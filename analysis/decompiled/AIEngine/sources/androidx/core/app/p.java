package androidx.core.app;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class p implements Iterable<Intent> {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<Intent> f1515a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    public final androidx.fragment.app.o f1516b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface a {
        Intent getSupportParentActivityIntent();
    }

    public p(androidx.fragment.app.o oVar) {
        this.f1516b = oVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(androidx.fragment.app.o oVar) {
        Intent supportParentActivityIntent = ((a) oVar).getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = e.a(oVar);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            androidx.fragment.app.o oVar2 = this.f1516b;
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(oVar2.getPackageManager());
            }
            ArrayList<Intent> arrayList = this.f1515a;
            int size = arrayList.size();
            try {
                for (Intent intentB = e.b(oVar2, component); intentB != null; intentB = e.b(oVar2, intentB.getComponent())) {
                    arrayList.add(size, intentB);
                }
                arrayList.add(supportParentActivityIntent);
            } catch (PackageManager.NameNotFoundException e10) {
                Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
                throw new IllegalArgumentException(e10);
            }
        }
    }

    public final void b() {
        ArrayList<Intent> arrayList = this.f1515a;
        if (arrayList.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[0]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        this.f1516b.startActivities(intentArr, null);
    }

    @Override // java.lang.Iterable
    @Deprecated
    public final Iterator<Intent> iterator() {
        return this.f1515a.iterator();
    }
}
