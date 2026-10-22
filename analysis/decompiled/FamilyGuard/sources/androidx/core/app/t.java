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

/* loaded from: classes.dex */
public final class t implements Iterable<Intent> {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<Intent> f9581a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private final Context f9582b;

    public interface a {
        Intent getSupportParentActivityIntent();
    }

    private t(Context context) {
        this.f9582b = context;
    }

    public static t h(Context context) {
        return new t(context);
    }

    public t a(Intent intent) {
        this.f9581a.add(intent);
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
                component = supportParentActivityIntent.resolveActivity(this.f9582b.getPackageManager());
            }
            f(component);
            a(supportParentActivityIntent);
        }
        return this;
    }

    public t f(ComponentName componentName) {
        int size = this.f9581a.size();
        try {
            Intent intentB = h.b(this.f9582b, componentName);
            while (intentB != null) {
                this.f9581a.add(size, intentB);
                intentB = h.b(this.f9582b, intentB.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e6) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e6);
        }
    }

    public void i() {
        m(null);
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f9581a.iterator();
    }

    public void m(Bundle bundle) {
        if (this.f9581a.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.f9581a.toArray(new Intent[0]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (androidx.core.content.a.k(this.f9582b, intentArr, bundle)) {
            return;
        }
        Intent intent = new Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(268435456);
        this.f9582b.startActivity(intent);
    }
}
