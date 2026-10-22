package kotlin.random;

import com.tmall.wireless.tangram.structure.card.FixCard;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0014\b\u0000\u0018\u0000 \u00162\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001\u0017B9\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fB\u0019\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0015R\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0015R\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0015R\u0016\u0010\b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0015R\u0016\u0010\t\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0015R\u0016\u0010\n\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0015¨\u0006\u0018"}, d2 = {"Lkotlin/random/XorWowRandom;", "Lkotlin/random/Random;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", FixCard.FixStyle.KEY_X, FixCard.FixStyle.KEY_Y, "z", "w", "v", "addend", "<init>", "(IIIIII)V", "seed1", "seed2", "(II)V", "nextInt", "()I", "bitCount", "nextBits", "(I)I", "I", "Companion", "a", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nXorWowRandom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 XorWowRandom.kt\nkotlin/random/XorWowRandom\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,60:1\n1#2:61\n*E\n"})
public final class XorWowRandom extends Random implements Serializable {

    @NotNull
    private static final a Companion = null;
    private static final long serialVersionUID = 0;
    private int addend;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f21199v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f21200w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f21201x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f21202y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f21203z;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public XorWowRandom(int r10, int r11, int r12, int r13, int r14, int r15) {
        this.f21201x = r10;
        this.f21202y = r11;
        this.f21203z = r12;
        this.f21200w = r13;
        this.f21199v = r14;
        this.addend = r15;
        if (((((r10 | r11) | r12) | r13) | r14) == 0) goto L10;
        int r16 = 0;
    L6:
        if (r16 >= 64) goto L8;
        nextInt();
        r16 = r16 + 1;
        goto L6
    L8:
        return;
    L10:
        throw new IllegalArgumentException("Initial state must have at least one non-zero element.");
    }

    @Override // kotlin.random.Random
    public int nextBits(int r10) {
        return d.g(nextInt(), r10);
    }

    @Override // kotlin.random.Random
    public int nextInt() {
        int r10 = this.f21201x;
        int r11 = r10 ^ (r10 >>> 2);
        this.f21201x = this.f21202y;
        this.f21202y = this.f21203z;
        this.f21203z = this.f21200w;
        int r12 = this.f21199v;
        this.f21200w = r12;
        int r13 = ((r11 ^ (r11 << 1)) ^ r12) ^ (r12 << 4);
        this.f21199v = r13;
        int r14 = this.addend + 362437;
        this.addend = r14;
        return r13 + r14;
    }

    public XorWowRandom(int r10, int r11) {
        this(r10, r11, 0, 0, ~r10, (r10 << 10) ^ (r11 >>> 4));
    }
}
