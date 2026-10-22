package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.P;
import androidx.lifecycle.AbstractC0328z;
import androidx.lifecycle.E;
import androidx.lifecycle.EnumC0327y;
import androidx.lifecycle.G;
import androidx.lifecycle.I;
import com.alibaba.fastjson.util.UTF8Decoder;
import d.AbstractC0528b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.random.Random;

/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f2428a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f2429b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f2430c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f2431d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final transient HashMap f2432e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f2433f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public final Bundle f2434g = new Bundle();

    public final boolean a(int i4, int i5, Intent intent) {
        a aVar;
        String str = (String) this.f2428a.get(Integer.valueOf(i4));
        if (str == null) {
            return false;
        }
        e eVar = (e) this.f2432e.get(str);
        if (eVar == null || (aVar = eVar.f2424a) == null || !this.f2431d.contains(str)) {
            this.f2433f.remove(str);
            this.f2434g.putParcelable(str, new ActivityResult(i5, intent));
            return true;
        }
        ((P) aVar).b(eVar.f2425b.c(i5, intent));
        this.f2431d.remove(str);
        return true;
    }

    public abstract void b(int i4, AbstractC0528b abstractC0528b, Object obj);

    public final d c(String str, G g4, AbstractC0528b abstractC0528b, a aVar) {
        AbstractC0328z lifecycle = g4.getLifecycle();
        I i4 = (I) lifecycle;
        if (i4.f3871d.a(EnumC0327y.f3986d)) {
            throw new IllegalStateException("LifecycleOwner " + g4 + " is attempting to register while current state is " + i4.f3871d + ". LifecycleOwners must call register before they are STARTED.");
        }
        e(str);
        HashMap map = this.f2430c;
        f fVar = (f) map.get(str);
        if (fVar == null) {
            fVar = new f(lifecycle);
        }
        c cVar = new c(this, str, aVar, abstractC0528b);
        fVar.f2426a.a(cVar);
        fVar.f2427b.add(cVar);
        map.put(str, fVar);
        return new d(this, str, abstractC0528b, 0);
    }

    public final d d(String str, AbstractC0528b abstractC0528b, P p4) {
        e(str);
        this.f2432e.put(str, new e(abstractC0528b, p4));
        HashMap map = this.f2433f;
        if (map.containsKey(str)) {
            Object obj = map.get(str);
            map.remove(str);
            p4.b(obj);
        }
        Bundle bundle = this.f2434g;
        ActivityResult activityResult = (ActivityResult) bundle.getParcelable(str);
        if (activityResult != null) {
            bundle.remove(str);
            p4.b(abstractC0528b.c(activityResult.f2410a, activityResult.f2411b));
        }
        return new d(this, str, abstractC0528b, 1);
    }

    public final void e(String str) {
        HashMap map = this.f2429b;
        if (((Integer) map.get(str)) != null) {
            return;
        }
        int iNextInt = Random.INSTANCE.nextInt(2147418112);
        while (true) {
            int i4 = iNextInt + UTF8Decoder.Surrogate.UCS4_MIN;
            HashMap map2 = this.f2428a;
            if (!map2.containsKey(Integer.valueOf(i4))) {
                map2.put(Integer.valueOf(i4), str);
                map.put(str, Integer.valueOf(i4));
                return;
            }
            iNextInt = Random.INSTANCE.nextInt(2147418112);
        }
    }

    public final void f(String str) {
        Integer num;
        if (!this.f2431d.contains(str) && (num = (Integer) this.f2429b.remove(str)) != null) {
            this.f2428a.remove(num);
        }
        this.f2432e.remove(str);
        HashMap map = this.f2433f;
        if (map.containsKey(str)) {
            StringBuilder sbW = B0.g.w("Dropping pending result for request ", str, ": ");
            sbW.append(map.get(str));
            Log.w("ActivityResultRegistry", sbW.toString());
            map.remove(str);
        }
        Bundle bundle = this.f2434g;
        if (bundle.containsKey(str)) {
            StringBuilder sbW2 = B0.g.w("Dropping pending result for request ", str, ": ");
            sbW2.append(bundle.getParcelable(str));
            Log.w("ActivityResultRegistry", sbW2.toString());
            bundle.remove(str);
        }
        HashMap map2 = this.f2430c;
        f fVar = (f) map2.get(str);
        if (fVar != null) {
            ArrayList arrayList = fVar.f2427b;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                fVar.f2426a.b((E) it.next());
            }
            arrayList.clear();
            map2.remove(str);
        }
    }
}
