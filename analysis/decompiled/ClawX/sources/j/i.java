package j;

import android.view.View;
import androidx.emoji2.text.m;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.p;
import v0.q0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3298a;

    /* renamed from: b, reason: collision with root package name */
    public int f3299b;

    /* renamed from: c, reason: collision with root package name */
    public int f3300c;
    public int d;

    /* renamed from: e, reason: collision with root package name */
    public int f3301e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f3302f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f3303g;

    public i(int i8) {
        this.f3298a = 0;
        this.f3299b = i8;
        if (i8 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f3302f = new m(16);
        this.f3303g = new t1.f(18);
    }

    public void a() {
        View view = (View) ((ArrayList) this.f3302f).get(r0.size() - 1);
        q0 q0Var = (q0) view.getLayoutParams();
        this.f3300c = ((StaggeredGridLayoutManager) this.f3303g).f792m.d(view);
        q0Var.getClass();
    }

    public void b() {
        ((ArrayList) this.f3302f).clear();
        this.f3299b = Integer.MIN_VALUE;
        this.f3300c = Integer.MIN_VALUE;
        this.d = 0;
    }

    public Object c(Object key) {
        p.e(key, "key");
        synchronized (((t1.f) this.f3303g)) {
            m mVar = (m) this.f3302f;
            mVar.getClass();
            Object obj = ((LinkedHashMap) mVar.f621a).get(key);
            if (obj != null) {
                this.d++;
                return obj;
            }
            this.f3301e++;
            return null;
        }
    }

    public int d(int i8) {
        int i9 = this.f3300c;
        if (i9 != Integer.MIN_VALUE) {
            return i9;
        }
        if (((ArrayList) this.f3302f).size() == 0) {
            return i8;
        }
        a();
        return this.f3300c;
    }

    public int e(int i8) {
        ArrayList arrayList = (ArrayList) this.f3302f;
        int i9 = this.f3299b;
        if (i9 != Integer.MIN_VALUE) {
            return i9;
        }
        if (arrayList.size() == 0) {
            return i8;
        }
        View view = (View) arrayList.get(0);
        q0 q0Var = (q0) view.getLayoutParams();
        this.f3299b = ((StaggeredGridLayoutManager) this.f3303g).f792m.g(view);
        q0Var.getClass();
        return this.f3299b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c4, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00cc, code lost:
    
        throw new java.lang.IllegalStateException("LruCache.sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(java.lang.Object r6, java.lang.Object r7) {
        /*
            Method dump skipped, instructions count: 209
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j.i.f(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public String toString() {
        String str;
        switch (this.f3298a) {
            case 0:
                synchronized (((t1.f) this.f3303g)) {
                    try {
                        int i8 = this.d;
                        int i9 = this.f3301e + i8;
                        str = "LruCache[maxSize=" + this.f3299b + ",hits=" + this.d + ",misses=" + this.f3301e + ",hitRate=" + (i9 != 0 ? (i8 * 100) / i9 : 0) + "%]";
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str;
            default:
                return super.toString();
        }
    }

    public i(StaggeredGridLayoutManager staggeredGridLayoutManager, int i8) {
        this.f3298a = 1;
        this.f3303g = staggeredGridLayoutManager;
        this.f3302f = new ArrayList();
        this.f3299b = Integer.MIN_VALUE;
        this.f3300c = Integer.MIN_VALUE;
        this.d = 0;
        this.f3301e = i8;
    }
}
