package m5;

import java.util.Collections;
import java.util.TreeMap;
import java.util.TreeSet;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f10493a;

    /* renamed from: b, reason: collision with root package name */
    public a f10494b;

    /* renamed from: c, reason: collision with root package name */
    public TreeSet f10495c;

    /* renamed from: d, reason: collision with root package name */
    public final TreeMap f10496d;

    /* renamed from: e, reason: collision with root package name */
    public int f10497e;

    public a() {
        this(0);
    }

    public final void a(int i10) {
        if (this.f10495c == null) {
            this.f10495c = new TreeSet(Collections.reverseOrder());
        }
        this.f10495c.add(Integer.valueOf(i10));
    }

    public final a b(Character ch, boolean z) {
        a aVar = (a) this.f10496d.get(ch);
        return (!z && aVar == null && this.f10493a == 0) ? this : aVar;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("State{depth=");
        sb2.append(this.f10493a);
        sb2.append(", ID=");
        sb2.append(this.f10497e);
        sb2.append(", emits=");
        sb2.append(this.f10495c);
        sb2.append(", success=");
        sb2.append(this.f10496d.keySet());
        sb2.append(", failureID=");
        a aVar = this.f10494b;
        sb2.append(aVar == null ? "-1" : Integer.valueOf(aVar.f10497e));
        sb2.append(", failure=");
        sb2.append(this.f10494b);
        sb2.append('}');
        return sb2.toString();
    }

    public a(int i10) {
        this.f10494b = null;
        this.f10495c = null;
        this.f10496d = new TreeMap();
        this.f10493a = i10;
    }
}
