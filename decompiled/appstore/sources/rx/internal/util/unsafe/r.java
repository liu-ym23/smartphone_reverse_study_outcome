package rx.internal.util.unsafe;

/* JADX INFO: loaded from: classes4.dex */
public abstract class r extends f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Integer f24444g = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f24445f;

    static {
        f24444g = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    }

    public r(int r10) {
        super(r10);
        this.f24445f = Math.min(r10 / 4, f24444g.intValue());
    }
}
