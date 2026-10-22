package w5;

import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import od.z;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f15234a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f15235b = new long[2];

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f15236c = new ArrayList(2);

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f15237d = new ArrayList(2);

    /* renamed from: e, reason: collision with root package name */
    public boolean f15238e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f15239f;

    /* renamed from: g, reason: collision with root package name */
    public ab.c f15240g;

    /* renamed from: h, reason: collision with root package name */
    public int f15241h;
    public final /* synthetic */ e i;

    public b(e eVar, String str) {
        this.i = eVar;
        this.f15234a = str;
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append('.');
        int length = sb2.length();
        for (int i = 0; i < 2; i++) {
            sb2.append(i);
            this.f15236c.add(this.i.f15247c.d(sb2.toString()));
            sb2.append(".tmp");
            this.f15237d.add(this.i.f15247c.d(sb2.toString()));
            sb2.setLength(length);
        }
    }

    public final c a() {
        if (!this.f15238e || this.f15240g != null || this.f15239f) {
            return null;
        }
        ArrayList arrayList = this.f15236c;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            e eVar = this.i;
            if (i >= size) {
                this.f15241h++;
                c cVar = new c();
                cVar.f15244g = eVar;
                cVar.f15242c = this;
                VarHandle.storeStoreFence();
                return cVar;
            }
            if (!eVar.f15261t.f((z) arrayList.get(i))) {
                try {
                    eVar.F(this);
                } catch (IOException unused) {
                }
                return null;
            }
            i++;
        }
    }
}
