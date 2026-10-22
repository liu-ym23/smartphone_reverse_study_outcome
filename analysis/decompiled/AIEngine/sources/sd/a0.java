package sd;

import androidx.datastore.preferences.protobuf.b1;
import com.stepos.core.ability.speech.PcmDumpBudget;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f11901a;

    /* renamed from: b, reason: collision with root package name */
    public int f11902b;

    /* renamed from: c, reason: collision with root package name */
    public int f11903c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f11904d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f11905e;

    /* renamed from: f, reason: collision with root package name */
    public a0 f11906f;

    /* renamed from: g, reason: collision with root package name */
    public a0 f11907g;

    public a0() {
        this.f11901a = new byte[PcmDumpBudget.HARD_MAX_DIR_MB];
        this.f11905e = true;
        this.f11904d = false;
    }

    public final a0 a() {
        a0 a0Var = this.f11906f;
        if (a0Var == this) {
            a0Var = null;
        }
        a0 a0Var2 = this.f11907g;
        kotlin.jvm.internal.g.c(a0Var2);
        a0Var2.f11906f = this.f11906f;
        a0 a0Var3 = this.f11906f;
        kotlin.jvm.internal.g.c(a0Var3);
        a0Var3.f11907g = this.f11907g;
        this.f11906f = null;
        this.f11907g = null;
        return a0Var;
    }

    public final void b(a0 segment) {
        kotlin.jvm.internal.g.f(segment, "segment");
        segment.f11907g = this;
        segment.f11906f = this.f11906f;
        a0 a0Var = this.f11906f;
        kotlin.jvm.internal.g.c(a0Var);
        a0Var.f11907g = segment;
        this.f11906f = segment;
    }

    public final a0 c() {
        this.f11904d = true;
        return new a0(this.f11901a, this.f11902b, this.f11903c, true, false);
    }

    public final void d(a0 sink, int i10) {
        kotlin.jvm.internal.g.f(sink, "sink");
        if (!sink.f11905e) {
            throw new IllegalStateException("only owner can write");
        }
        int i11 = sink.f11903c;
        int i12 = i11 + i10;
        if (i12 > 8192) {
            if (sink.f11904d) {
                throw new IllegalArgumentException();
            }
            int i13 = sink.f11902b;
            if (i12 - i13 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = sink.f11901a;
            b1.s(bArr, bArr, 0, i13, i11, 2);
            sink.f11903c -= sink.f11902b;
            sink.f11902b = 0;
        }
        byte[] bArr2 = sink.f11901a;
        int i14 = sink.f11903c;
        int i15 = this.f11902b;
        b1.n(i14, i15, i15 + i10, this.f11901a, bArr2);
        sink.f11903c += i10;
        this.f11902b += i10;
    }

    public a0(byte[] data, int i10, int i11, boolean z, boolean z3) {
        kotlin.jvm.internal.g.f(data, "data");
        this.f11901a = data;
        this.f11902b = i10;
        this.f11903c = i11;
        this.f11904d = z;
        this.f11905e = z3;
    }
}
