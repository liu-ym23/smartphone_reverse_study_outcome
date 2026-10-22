package d3;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.fragment.app.j;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i implements Iterable {

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f3187c;

    /* renamed from: f, reason: collision with root package name */
    public j f3188f;

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(j jVar) {
        ArrayList arrayList = this.f3187c;
        j jVar2 = this.f3188f;
        Intent supportParentActivityIntent = ((h) jVar).getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = a.b(jVar);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(jVar2.getPackageManager());
            }
            int size = arrayList.size();
            try {
                for (Intent intentC = a.c(jVar2, component); intentC != null; intentC = a.c(jVar2, intentC.getComponent())) {
                    arrayList.add(size, intentC);
                }
                arrayList.add(supportParentActivityIntent);
            } catch (PackageManager.NameNotFoundException e10) {
                Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
                throw new IllegalArgumentException(e10);
            }
        }
    }

    public final void b() {
        ArrayList arrayList = this.f3187c;
        if (arrayList.isEmpty()) {
            od.f.e("No intents added to TaskStackBuilder; cannot startActivities");
            return;
        }
        Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[0]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        this.f3188f.startActivities(intentArr, null);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.f3187c.iterator();
    }
}
