package kotlin.random;

import com.autonavi.aps.amapapi.config.Const;
import java.io.InvalidObjectException;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import t9.C5526c;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 !2\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001\"B9\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fB\u0019\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0016\u0010\b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u001cR\u0016\u0010\t\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001cR\u0016\u0010\n\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001c¨\u0006#"}, d2 = {"Lkotlin/random/XorWowRandom;", "Lkotlin/random/Random;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "x", "y", "z", "w", "v", "addend", "<init>", "(IIIIII)V", "seed1", "seed2", "(II)V", "", "readResolve", "()Ljava/lang/Object;", "f", "()I", "bitCount", Const.INTENT_KEY_PKGNAME, "(I)I", "LY8/t;", "l", "()V", "c", "I", Const.INTENT_KEY_UMID, "e", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_APIKEY, "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class XorWowRandom extends Random implements Serializable {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public int x;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public int y;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public int z;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public int w;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public int v;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public int addend;

    public XorWowRandom(int i10, int i11, int i12, int i13, int i14, int i15) {
        this.x = i10;
        this.y = i11;
        this.z = i12;
        this.w = i13;
        this.v = i14;
        this.addend = i15;
        l();
        for (int i16 = 0; i16 < 64; i16++) {
            f();
        }
    }

    private final Object readResolve() throws Throwable {
        try {
            l();
            return this;
        } catch (Throwable th) {
            Throwable thInitCause = new InvalidObjectException(th.getMessage()).initCause(th);
            p.h(thInitCause, "initCause(...)");
            throw thInitCause;
        }
    }

    @Override // kotlin.random.Random
    public int b(int bitCount) {
        return C5526c.g(f(), bitCount);
    }

    @Override // kotlin.random.Random
    public int f() {
        int i10 = this.x;
        int i11 = i10 ^ (i10 >>> 2);
        this.x = this.y;
        this.y = this.z;
        this.z = this.w;
        int i12 = this.v;
        this.w = i12;
        int i13 = ((i11 ^ (i11 << 1)) ^ i12) ^ (i12 << 4);
        this.v = i13;
        int i14 = this.addend + 362437;
        this.addend = i14;
        return i13 + i14;
    }

    public final void l() {
        if ((this.v | this.x | this.y | this.z | this.w) == 0) {
            throw new IllegalArgumentException("Initial state must have at least one non-zero element.");
        }
    }

    public XorWowRandom(int i10, int i11) {
        this(i10, i11, 0, 0, ~i10, (i10 << 10) ^ (i11 >>> 4));
    }
}
