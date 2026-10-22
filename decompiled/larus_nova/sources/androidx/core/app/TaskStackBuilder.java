package androidx.core.app;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes17.dex */
public final class TaskStackBuilder implements Iterable<Intent> {
    private static final String TAG = "TaskStackBuilder";
    private final ArrayList<Intent> mIntents;
    private final Context mSourceContext;

    /* JADX INFO: loaded from: classes.dex */
    public interface SupportParentable {
        Intent getSupportParentActivityIntent();
    }

    public void startActivities() {
        startActivities(null);
    }

    public int getIntentCount() {
        return this.mIntents.size();
    }

    public Intent[] getIntents() {
        int r100 = this.mIntents.size();
        Intent[] r101 = new Intent[r100];
        if (r100 != 0) goto L5;
        return r101;
    L5:
        r101[0] = new Intent((Intent) ListProtector.get(this.mIntents, 0)).addFlags(268484608);
        int r102 = 1;
    L6:
        if (r102 >= r100) goto L8;
        r101[r102] = new Intent((Intent) ListProtector.get(this.mIntents, r102));
        r102 = r102 + 1;
        goto L6
    L8:
        return r101;
    }

    @Override // java.lang.Iterable
    public Iterator<Intent> iterator() {
        return this.mIntents.iterator();
    }

    private TaskStackBuilder(Context r100) {
        this.mIntents = new ArrayList();
        this.mSourceContext = r100;
    }

    public static TaskStackBuilder create(Context r100) {
        return new TaskStackBuilder(r100);
    }

    public static TaskStackBuilder from(Context r100) {
        return create(r100);
    }

    public TaskStackBuilder addNextIntent(Intent r100) {
        this.mIntents.add(r100);
        return this;
    }

    public TaskStackBuilder addNextIntentWithParentStack(Intent r100) {
        ComponentName r101 = r100.getComponent();
        if (r101 != null) goto L5;
        r101 = r100.resolveActivity(this.mSourceContext.getPackageManager());
    L5:
        if (r101 == null) goto L7;
        addParentStack(r101);
    L7:
        addNextIntent(r100);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TaskStackBuilder addParentStack(Activity r100) {
        if ((r100 instanceof SupportParentable) == false) goto L5;
        Intent r101 = ((SupportParentable) r100).getSupportParentActivityIntent();
    L6:
        if (r101 != null) goto L8;
        r101 = NavUtils.getParentActivityIntent(r100);
    L8:
        if (r101 == null) goto L13;
        ComponentName r102 = r101.getComponent();
        if (r102 != null) goto L12;
        r102 = r101.resolveActivity(this.mSourceContext.getPackageManager());
    L12:
        addParentStack(r102);
        addNextIntent(r101);
    L13:
        return this;
    L5:
        r101 = null;
        goto L6
    }

    public Intent editIntentAt(int r100) {
        return (Intent) ListProtector.get(this.mIntents, r100);
    }

    public Intent getIntent(int r100) {
        return editIntentAt(r100);
    }

    public void startActivities(Bundle r100) {
        if (this.mIntents.isEmpty() == true) goto L9;
        Intent[] r101 = (Intent[]) this.mIntents.toArray(new Intent[0]);
        r101[0] = new Intent(r101[0]).addFlags(268484608);
        if (ContextCompat.startActivities(this.mSourceContext, r101, r100) == true) goto L10;
        Intent r102 = new Intent(r101[r101.length - 1]);
        r102.addFlags(268435456);
        this.mSourceContext.startActivity(r102);
        return;
    L10:
        return;
    L9:
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }

    public TaskStackBuilder addParentStack(ComponentName r100) {
        int r101 = this.mIntents.size();
        Intent r102 = NavUtils.getParentActivityIntent(this.mSourceContext, r100);     // Catch: PackageManager.NameNotFoundException -> L8
    L4:
        if (r102 == null) goto L7;
        ListProtector.add(this.mIntents, r101, r102);     // Catch: PackageManager.NameNotFoundException -> L8
        r102 = NavUtils.getParentActivityIntent(this.mSourceContext, r102.getComponent());     // Catch: PackageManager.NameNotFoundException -> L8
        goto L4
    L7:
        return this;
    L8:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public TaskStackBuilder addParentStack(Class<?> r100) {
        return addParentStack(new ComponentName(this.mSourceContext, r100));
    }

    public PendingIntent getPendingIntent(int r100, int r101) {
        return getPendingIntent(r100, r101, null);
    }

    public PendingIntent getPendingIntent(int r100, int r101, Bundle r102) {
        if (this.mIntents.isEmpty() == true) goto L7;
        Intent[] r103 = (Intent[]) this.mIntents.toArray(new Intent[0]);
        r103[0] = new Intent(r103[0]).addFlags(268484608);
        return PendingIntent.getActivities(this.mSourceContext, r100, r103, r101, r102);
    L7:
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
    }
}
