package w3;

import com.google.android.gms.common.Feature;
import com.google.android.gms.internal.mlkit_vision_barcode.zzra;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrc;
import java.util.List;
import java.util.concurrent.Executor;
import r3.C5214h;
import r3.C5217k;
import t3.C5506b;
import t3.InterfaceC5505a;
import u3.C5573a;
import x3.C5846a;
import z2.B8;
import z2.C6122e6;
import z2.C6142g6;
import z2.E8;
import z2.Q8;
import z2.U5;

/* renamed from: w3.g, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5730g extends y3.e implements InterfaceC5505a {

    /* renamed from: l, reason: collision with root package name */
    public static final C5506b f43066l = new C5506b.a().a();

    /* renamed from: g, reason: collision with root package name */
    public final boolean f43067g;

    /* renamed from: h, reason: collision with root package name */
    public final C5506b f43068h;

    /* renamed from: i, reason: collision with root package name */
    public final Q8 f43069i;

    /* renamed from: j, reason: collision with root package name */
    public int f43070j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f43071k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5730g(C5506b c5506b, k kVar, Executor executor, B8 b82, C5214h c5214h) {
        super(kVar, executor);
        c5506b.b();
        this.f43068h = c5506b;
        boolean zF = C5725b.f();
        this.f43067g = zF;
        C6122e6 c6122e6 = new C6122e6();
        c6122e6.i(C5725b.c(c5506b));
        C6142g6 c6142g6J = c6122e6.j();
        U5 u52 = new U5();
        u52.e(zF ? zzra.TYPE_THICK : zzra.TYPE_THIN);
        u52.g(c6142g6J);
        b82.d(E8.e(u52, 1), zzrc.ON_DEVICE_BARCODE_CREATE);
        this.f43069i = null;
    }

    public final D2.i A(D2.i iVar, final int i10, final int i11) {
        return iVar.m(new D2.h() { // from class: w3.e
            @Override // D2.h
            public final D2.i a(Object obj) {
                return this.f43060a.n(i10, i11, (List) obj);
            }
        });
    }

    @Override // y3.e, java.io.Closeable, java.lang.AutoCloseable, t3.InterfaceC5505a
    public final synchronized void close() {
        super.close();
    }

    @Override // com.google.android.gms.common.api.e
    public final Feature[] e() {
        return this.f43067g ? C5217k.f38774a : new Feature[]{C5217k.f38775b};
    }

    public final /* synthetic */ D2.i n(int i10, int i11, List list) throws Exception {
        return D2.l.d(list);
    }

    @Override // t3.InterfaceC5505a
    public final D2.i<List<C5573a>> n0(C5846a c5846a) {
        return A(super.g(c5846a), c5846a.j(), c5846a.f());
    }
}
