package y7;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.motionkit.fx.material.capability.BlurGradient;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0000\u0018\u0000 ,2\u00020\u0001:\u0001\u0015BG\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b!\u0010 R\u0017\u0010\t\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\"\u0010\u001e\u001a\u0004\b#\u0010 R\u0017\u0010\n\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b$\u0010\u001e\u001a\u0004\b%\u0010 R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010\r\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b*\u0010\u001a\u001a\u0004\b+\u0010\u001c¨\u0006-"}, d2 = {"Ly7/q;", "", "", "id", "Lcom/stepos/motionkit/fx/material/capability/BlurGradient;", "direction", "", "gradientScale", "startColor", "middleColor", "endColor", "", "colorMidpoint", "colorDirection", "<init>", "(Ljava/lang/String;Lcom/stepos/motionkit/fx/material/capability/BlurGradient;IIIIFLcom/stepos/motionkit/fx/material/capability/BlurGradient;)V", "LA7/B;", "params", "LY8/t;", Const.INTENT_KEY_UMID, "(LA7/B;)V", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "getId", "()Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "Lcom/stepos/motionkit/fx/material/capability/BlurGradient;", "getDirection", "()Lcom/stepos/motionkit/fx/material/capability/BlurGradient;", "c", "I", "getGradientScale", "()I", "getStartColor", "e", "getMiddleColor", "f", "getEndColor", Const.INTENT_KEY_BACKGROUND_COMMAND, "F", "getColorMidpoint", "()F", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "getColorDirection", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class q {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE;

    /* renamed from: j, reason: collision with root package name */
    public static final q f43920j;

    /* renamed from: k, reason: collision with root package name */
    public static final q f43921k;

    /* renamed from: l, reason: collision with root package name */
    public static final q f43922l;

    /* renamed from: m, reason: collision with root package name */
    public static final List<q> f43923m;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final BlurGradient direction;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final int gradientScale;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final int startColor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final int middleColor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final int endColor;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final float colorMidpoint;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final BlurGradient colorDirection;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0010\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r¨\u0006\u0012"}, d2 = {"Ly7/q$a;", "", "<init>", "()V", "", "mode", "Lcom/stepos/motionkit/fx/material/capability/BlurGradient;", "e", "(I)Lcom/stepos/motionkit/fx/material/capability/BlurGradient;", "Ly7/q;", "TOP_SHORT", "Ly7/q;", "c", "()Ly7/q;", "BOTTOM_SHORT", Const.INTENT_KEY_PKGNAME, "TOP_TALL", Const.INTENT_KEY_UMID, "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: y7.q$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final q b() {
            return q.f43921k;
        }

        public final q c() {
            return q.f43920j;
        }

        public final q d() {
            return q.f43922l;
        }

        public final BlurGradient e(int mode) {
            for (BlurGradient blurGradient : BlurGradient.values()) {
                if (blurGradient.getMode() == mode) {
                    return blurGradient;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }

        public Companion() {
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        q qVar = new q("top_short", companion.e(2), 0, r.b(1710618, 100), r.b(1710618, 60), r.b(1710618, 0), 0.5f, companion.e(1));
        f43920j = qVar;
        q qVar2 = new q("bottom_short", companion.e(1), 1, r.b(1710618, 0), r.b(1710618, 65), r.b(986895, 100), 0.43f, companion.e(1));
        f43921k = qVar2;
        q qVar3 = new q("top_tall", companion.e(2), 0, r.b(0, 80), r.b(0, 60), r.b(0, 0), 0.57f, companion.e(1));
        f43922l = qVar3;
        f43923m = C1173v.p(qVar, qVar2, qVar3);
    }

    public q(String id, BlurGradient direction, int i10, int i11, int i12, int i13, float f10, BlurGradient colorDirection) {
        kotlin.jvm.internal.p.i(id, "id");
        kotlin.jvm.internal.p.i(direction, "direction");
        kotlin.jvm.internal.p.i(colorDirection, "colorDirection");
        this.id = id;
        this.direction = direction;
        this.gradientScale = i10;
        this.startColor = i11;
        this.middleColor = i12;
        this.endColor = i13;
        this.colorMidpoint = f10;
        this.colorDirection = colorDirection;
    }

    public final void d(A7.B params) {
        kotlin.jvm.internal.p.i(params, "params");
        params.z(this.direction);
        params.B(this.gradientScale);
        params.D(this.startColor);
        params.C(this.middleColor);
        params.A(this.endColor);
        params.y(this.colorMidpoint);
        params.x(this.colorDirection);
    }
}
