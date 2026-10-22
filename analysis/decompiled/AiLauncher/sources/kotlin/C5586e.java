package kotlin;

import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.motionkit.EasingType;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import s7.TrackDefinition;
import s7.v;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\n\u001a\u00020\u0000*\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0086\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u000e\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\r\u001a\u00020\fH\u0086\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\u0010\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\r\u001a\u00020\fH\u0086\u0004¢\u0006\u0004\b\u0010\u0010\u000fJ%\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\b¢\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b\u001b\u0010\u0015J%\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b\u001c\u0010\u0015J!\u0010!\u001a\u00020\u00002\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001d¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0000¢\u0006\u0004\b$\u0010%R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010&R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010'R\u0016\u0010\u0019\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010(R\u0016\u0010\u001a\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010(R\u0016\u0010*\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010)R\u0016\u0010+\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010)R\u0016\u0010.\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u00100¨\u00062"}, d2 = {"Lu7/e;", "", "", "name", "", "component", "<init>", "(Ljava/lang/String;I)V", "", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(FF)Lu7/e;", "", Const.SP_KEY_GSM_UPLOAD_MXSIZE, "c", "(Lu7/e;J)Lu7/e;", Const.INTENT_KEY_PKGNAME, "min", "max", "period", "e", "(FFJ)Lu7/e;", Const.JSON_KEY_SPEED, Const.INTENT_KEY_UMID, "(F)Lu7/e;", "from", "to", "f", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Lkotlin/Function1;", "Lu7/d;", "LY8/t;", "block", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lp9/l;)Lu7/e;", "Ls7/u;", Const.INTENT_KEY_APIKEY, "()Ls7/u;", "Ljava/lang/String;", "I", "F", "J", "durationMs", "delayMs", "Lcom/stepos/motionkit/EasingType;", "Lcom/stepos/motionkit/EasingType;", "easing", "Ls7/v;", "Ls7/v;", "trackType", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: u7.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5586e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String name;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final int component;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public float from;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public float to;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public long durationMs;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public long delayMs;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public EasingType easing;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public v trackType;

    public C5586e(String name, int i10) {
        p.i(name, "name");
        this.name = name;
        this.component = i10;
        this.to = 1.0f;
        this.durationMs = 1000L;
        this.easing = EasingType.LINEAR;
    }

    public final TrackDefinition a() {
        v oneShot = this.trackType;
        if (oneShot == null) {
            oneShot = new v.OneShot(this.from, this.to, this.durationMs, this.delayMs, this.easing);
        }
        return new TrackDefinition(this.name, oneShot, this.component);
    }

    public final C5586e b(C5586e c5586e, long j10) {
        p.i(c5586e, "<this>");
        c5586e.delayMs = j10;
        return c5586e;
    }

    public final C5586e c(C5586e c5586e, long j10) {
        p.i(c5586e, "<this>");
        c5586e.durationMs = j10;
        return c5586e;
    }

    public final C5586e d(float speed) {
        this.trackType = new v.Linear(speed);
        return this;
    }

    public final C5586e e(float min, float max, long period) {
        this.trackType = new v.Oscillate(min, max, period);
        return this;
    }

    public final C5586e f(float from, float to, long period) {
        this.trackType = new v.Sawtooth(from, to, period);
        return this;
    }

    public final C5586e g(InterfaceC5074l<? super C5585d, t> block) {
        p.i(block, "block");
        C5585d c5585d = new C5585d();
        block.invoke(c5585d);
        this.trackType = c5585d.a();
        return this;
    }

    public final C5586e h(float f10, float f11) {
        this.from = f10;
        this.to = f11;
        return this;
    }

    public final C5586e i(float min, float max, long period) {
        this.trackType = new v.TriangleWave(min, max, period);
        return this;
    }
}
