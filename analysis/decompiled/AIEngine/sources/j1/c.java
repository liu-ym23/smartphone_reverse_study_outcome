package j1;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public int f9652a;

    /* renamed from: b, reason: collision with root package name */
    public ByteBuffer f9653b;

    /* renamed from: c, reason: collision with root package name */
    public int f9654c;

    /* renamed from: d, reason: collision with root package name */
    public int f9655d;

    public c() {
        if (a4.a.f40l == null) {
            a4.a.f40l = new a4.a(28);
        }
    }

    public final int a(int i10) {
        if (i10 < this.f9655d) {
            return this.f9653b.getShort(this.f9654c + i10);
        }
        return 0;
    }
}
