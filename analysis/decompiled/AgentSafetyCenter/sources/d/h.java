package d;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.v;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public HashMap f2935a;

    /* renamed from: b, reason: collision with root package name */
    public HashMap f2936b;

    /* renamed from: c, reason: collision with root package name */
    public HashMap f2937c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f2938d;

    /* renamed from: e, reason: collision with root package name */
    public transient HashMap f2939e;

    /* renamed from: f, reason: collision with root package name */
    public HashMap f2940f;

    /* renamed from: g, reason: collision with root package name */
    public Bundle f2941g;

    public final boolean a(int i, int i3, Intent intent) {
        b bVar;
        String str = (String) this.f2935a.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        f fVar = (f) this.f2939e.get(str);
        if (fVar == null || (bVar = fVar.f2931a) == null || !this.f2938d.contains(str)) {
            this.f2940f.remove(str);
            this.f2941g.putParcelable(str, new a(intent, i3));
            return true;
        }
        bVar.a(fVar.f2932b.c(intent, i3));
        this.f2938d.remove(str);
        return true;
    }

    public abstract void b(int i, e.b bVar, Cloneable cloneable);

    public final e c(String str, e.b bVar, b bVar2) {
        Bundle bundle = this.f2941g;
        d(str);
        this.f2939e.put(str, new f(bVar, bVar2));
        HashMap map = this.f2940f;
        if (map.containsKey(str)) {
            Object obj = map.get(str);
            map.remove(str);
            bVar2.a(obj);
        }
        a aVar = (a) bundle.getParcelable(str);
        if (aVar != null) {
            bundle.remove(str);
            bVar2.a(bVar.c(aVar.f2922f, aVar.f2921c));
        }
        e eVar = new e(1);
        eVar.f2930d = this;
        eVar.f2928b = str;
        eVar.f2929c = bVar;
        VarHandle.storeStoreFence();
        return eVar;
    }

    public final void d(String str) {
        HashMap map = this.f2935a;
        HashMap map2 = this.f2936b;
        if (((Integer) map2.get(str)) != null) {
            return;
        }
        cc.a aVar = cc.d.f2262c;
        int iNextInt = cc.d.f2262c.c().nextInt(2147418112);
        while (true) {
            int i = iNextInt + 65536;
            if (!map.containsKey(Integer.valueOf(i))) {
                map.put(Integer.valueOf(i), str);
                map2.put(str, Integer.valueOf(i));
                return;
            } else {
                cc.a aVar2 = cc.d.f2262c;
                iNextInt = cc.d.f2262c.c().nextInt(2147418112);
            }
        }
    }

    public final void e(String str) {
        Integer num;
        HashMap map = this.f2937c;
        Bundle bundle = this.f2941g;
        HashMap map2 = this.f2940f;
        if (!this.f2938d.contains(str) && (num = (Integer) this.f2936b.remove(str)) != null) {
            this.f2935a.remove(num);
        }
        this.f2939e.remove(str);
        if (map2.containsKey(str)) {
            StringBuilder sbO = androidx.activity.b.o("Dropping pending result for request ", str, ": ");
            sbO.append(map2.get(str));
            Log.w("ActivityResultRegistry", sbO.toString());
            map2.remove(str);
        }
        if (bundle.containsKey(str)) {
            StringBuilder sbO2 = androidx.activity.b.o("Dropping pending result for request ", str, ": ");
            sbO2.append(bundle.getParcelable(str));
            Log.w("ActivityResultRegistry", sbO2.toString());
            bundle.remove(str);
        }
        g gVar = (g) map.get(str);
        if (gVar != null) {
            ArrayList arrayList = gVar.f2934b;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                gVar.f2933a.c((v) obj);
            }
            arrayList.clear();
            map.remove(str);
        }
    }
}
