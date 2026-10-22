package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes.dex */
public final class t implements Iterable<Intent> {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<Intent> f13079a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    public final Context f13080b;

    public interface a {
        Intent getSupportParentActivityIntent();
    }

    public t(Context context) {
        this.f13080b = context;
    }

    public static t f(Context context) {
        return new t(context);
    }

    public t b(Intent intent) {
        this.f13079a.add(intent);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public t c(Activity activity) {
        Intent supportParentActivityIntent = activity instanceof a ? ((a) activity).getSupportParentActivityIntent() : null;
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = h.a(activity);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(this.f13080b.getPackageManager());
            }
            e(component);
            b(supportParentActivityIntent);
        }
        return this;
    }

    public t e(ComponentName componentName) {
        int size = this.f13079a.size();
        try {
            Intent intentB = h.b(this.f13080b, componentName);
            while (intentB != null) {
                this.f13079a.add(size, intentB);
                intentB = h.b(this.f13080b, intentB.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e10) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e10);
        }
    }

    public void i() {
        j(null);
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f13079a.iterator();
    }

    public void j(Bundle bundle) {
        if (this.f13079a.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.f13079a.toArray(new Intent[0]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (androidx.core.content.a.l(this.f13080b, intentArr, bundle)) {
            return;
        }
        Intent intent = new Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        this.f13080b.startActivity(intent);
    }
}
