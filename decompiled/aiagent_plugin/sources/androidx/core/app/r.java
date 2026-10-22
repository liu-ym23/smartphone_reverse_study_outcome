package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: TaskStackBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public final class r implements Iterable<Intent> {
    private static final String TAG = "TaskStackBuilder";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<Intent> f1141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f1142b;

    /* JADX INFO: compiled from: TaskStackBuilder.java */
    public interface a {
        Intent getSupportParentActivityIntent();
    }

    private r(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.f1141a = new ArrayList();
        this.f1142b = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
    }

    public static r a(Context r2) {
        return new r((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"));
    }

    public r a(Intent r2) {
        this.f1141a.add(r2);
        return this;
    }

    public r a(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, a.class) == false) goto L5;
        Intent r0 = ((a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.aiagent.plugin")).getSupportParentActivityIntent();
    L6:
        if (r0 != null) goto L8;
        r0 = h.a(r4);
    L8:
        if (r0 == null) goto L13;
        ComponentName r5 = r0.getComponent();
        if (r5 != null) goto L12;
        r5 = r0.resolveActivity(this.f1142b.getPackageManager());
    L12:
        a(r5);
        a(r0);
    L13:
        return this;
    L5:
        r0 = null;
        goto L6
    }

    public r a(ComponentName r3) {
        int r0 = this.f1141a.size();
        Intent r4 = h.a(this.f1142b, r3);     // Catch: PackageManager.NameNotFoundException -> L8
    L4:
        if (r4 == null) goto L7;
        this.f1141a.add(r0, r4);     // Catch: PackageManager.NameNotFoundException -> L8
        r4 = h.a(this.f1142b, r4.getComponent());     // Catch: PackageManager.NameNotFoundException -> L8
        goto L4
    L7:
        return this;
    L8:
        e = move-exception;
        a(TAG, "Bad ComponentName while traversing activity parent metadata");
        throw new IllegalArgumentException(e);
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f1141a.iterator();
    }

    public void a() {
        a(null);
    }

    public void a(Bundle r6) {
        if (this.f1141a.isEmpty() == true) goto L9;
        Intent[] r0 = (Intent[]) ZeusTransformUtils.preCheckCast(this.f1141a.toArray(new Intent[0]), Intent[].class, "com.obric.aiagent.plugin");
        r0[0] = new Intent(r0[0]).addFlags(268484608);
        if (androidx.core.content.a.a(this.f1142b, r0, r6) == true) goto L10;
        Intent r7 = new Intent(r0[r0.length - 1]);
        r7.addFlags(268435456);
        ZeusTransformUtils.startActivity(this.f1142b, r7, "com.obric.aiagent.plugin");
        return;
    L10:
        return;
    L9:
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
