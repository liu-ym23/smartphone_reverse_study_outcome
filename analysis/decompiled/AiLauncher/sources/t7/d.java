package t7;

import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.motionkit.EndBehavior;
import com.stepos.motionkit.PlayMode;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import p9.InterfaceC5063a;
import p9.p;
import s7.k;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b(\b\u0000\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ5\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\"\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\"\u0010#J'\u0010&\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0005H\u0016¢\u0006\u0004\b&\u0010'J/\u0010)\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u0005H\u0016¢\u0006\u0004\b)\u0010*J7\u0010,\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u0005H\u0016¢\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u0005H\u0016¢\u0006\u0004\b/\u00100J\u0017\u00103\u001a\u00020\u00062\u0006\u00102\u001a\u000201H\u0016¢\u0006\u0004\b3\u00104J\u001f\u00106\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u00105\u001a\u000201¢\u0006\u0004\b6\u00107R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b3\u00108\u001a\u0004\b9\u0010:R&\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010=R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010>R\"\u0010D\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u0010H\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u00108\u001a\u0004\bE\u0010:\"\u0004\bF\u0010GR$\u0010.\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00058\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\"\u0010I\u001a\u0004\bJ\u0010KR\u0016\u0010M\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010LR\u0016\u0010N\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010IR$\u0010Q\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00178\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b\u0014\u0010O\u001a\u0004\b;\u0010PR\u0016\u0010S\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010RR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u00108R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010TR\u001e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010=R\u0016\u0010W\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010OR\u0014\u0010 \u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bX\u0010A¨\u0006Y"}, d2 = {"Lt7/d;", "", "", "id", "Lkotlin/Function2;", "", "LY8/t;", "onFrameCallback", "Lkotlin/Function0;", "onRelease", "LB7/a;", "binder", "<init>", "(JLp9/p;Lp9/a;LB7/a;)V", "Lcom/stepos/motionkit/PlayMode;", "mode", "durationMs", "Lcom/stepos/motionkit/EndBehavior;", "endBehavior", "onComplete", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/motionkit/PlayMode;JLcom/stepos/motionkit/EndBehavior;Lp9/a;)V", "dt", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(F)Z", "elapsedMs", "l", "(JF)V", "release", "()V", "", "name", UxipConstants.f30680s, Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;F)V", "x", "y", "c", "(Ljava/lang/String;FF)V", "z", "e", "(Ljava/lang/String;FFF)V", "w", "f", "(Ljava/lang/String;FFFF)V", Const.JSON_KEY_SPEED, Const.INTENT_KEY_UMID, "(F)V", "", "fps", Const.INTENT_KEY_APIKEY, "(I)V", "moduleDefaultFps", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(FI)Ljava/lang/Float;", "J", "getId", "()J", Const.INTENT_KEY_PKGNAME, "Lp9/p;", "Lp9/a;", "LB7/a;", "Ljava/lang/String;", "getEffectName", "()Ljava/lang/String;", "m", "(Ljava/lang/String;)V", "effectName", "k", "setLocalElapsedMs", "(J)V", "localElapsedMs", "F", "getSpeed", "()F", "I", "frameRateOverride", "frameAccumSec", "Z", "()Z", "isActive", "Lcom/stepos/motionkit/PlayMode;", "playMode", "Lcom/stepos/motionkit/EndBehavior;", "n", "o", "completed", "getName", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class d implements k {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final long id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final p<Long, Float, t> onFrameCallback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5063a<t> onRelease;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final B7.a binder;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public String effectName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public long localElapsedMs;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public volatile float speed;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public volatile int frameRateOverride;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public float frameAccumSec;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public boolean isActive;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public PlayMode playMode;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public long durationMs;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public EndBehavior endBehavior;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public InterfaceC5063a<t> onComplete;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public boolean completed;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f42032a;

        static {
            int[] iArr = new int[PlayMode.values().length];
            try {
                iArr[PlayMode.ONCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PlayMode.LOOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f42032a = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(long j10, p<? super Long, ? super Float, t> onFrameCallback, InterfaceC5063a<t> onRelease, B7.a aVar) {
        kotlin.jvm.internal.p.i(onFrameCallback, "onFrameCallback");
        kotlin.jvm.internal.p.i(onRelease, "onRelease");
        this.id = j10;
        this.onFrameCallback = onFrameCallback;
        this.onRelease = onRelease;
        this.binder = aVar;
        this.effectName = "";
        this.speed = 1.0f;
        this.frameRateOverride = -1;
        this.isActive = true;
        this.playMode = PlayMode.LOOP;
        this.endBehavior = EndBehavior.FREEZE;
    }

    @Override // s7.k
    public void a(int fps) {
        this.frameRateOverride = fps;
        this.frameAccumSec = 0.0f;
    }

    @Override // s7.k
    /* renamed from: b, reason: from getter */
    public boolean getIsActive() {
        return this.isActive;
    }

    @Override // s7.k
    public void c(String name, float x10, float y10) {
        kotlin.jvm.internal.p.i(name, "name");
        B7.a aVar = this.binder;
        if (aVar != null) {
            aVar.g(name, x10, y10);
        }
    }

    @Override // s7.k
    public void d(float speed) {
        this.speed = speed;
    }

    @Override // s7.k
    public void e(String name, float x10, float y10, float z10) {
        kotlin.jvm.internal.p.i(name, "name");
        B7.a aVar = this.binder;
        if (aVar != null) {
            aVar.h(name, x10, y10, z10);
        }
    }

    @Override // s7.k
    public void f(String name, float x10, float y10, float z10, float w10) {
        kotlin.jvm.internal.p.i(name, "name");
        B7.a aVar = this.binder;
        if (aVar != null) {
            aVar.i(name, x10, y10, z10, w10);
        }
    }

    @Override // s7.k
    public void g(String name, float value) {
        kotlin.jvm.internal.p.i(name, "name");
        B7.a aVar = this.binder;
        if (aVar != null) {
            aVar.f(name, value);
        }
    }

    @Override // s7.k
    public long getId() {
        return this.id;
    }

    @Override // s7.k
    /* renamed from: getName, reason: from getter */
    public String getEffectName() {
        return this.effectName;
    }

    public final Float h(float dt, int moduleDefaultFps) {
        if (this.frameRateOverride >= 0) {
            moduleDefaultFps = this.frameRateOverride;
        }
        if (moduleDefaultFps <= 0) {
            return Float.valueOf(dt);
        }
        float f10 = 1.0f / moduleDefaultFps;
        float f11 = this.frameAccumSec + dt;
        this.frameAccumSec = f11;
        if (f11 < f10) {
            return null;
        }
        this.frameAccumSec = 0.0f;
        return Float.valueOf(f11);
    }

    public final boolean i(float dt) {
        if (!getIsActive()) {
            return false;
        }
        this.localElapsedMs += (long) (dt * 1000 * this.speed);
        int i10 = a.f42032a[this.playMode.ordinal()];
        if (i10 == 1) {
            long j10 = this.durationMs;
            if (j10 > 0 && this.localElapsedMs >= j10) {
                this.localElapsedMs = j10;
                if (!this.completed) {
                    this.completed = true;
                    InterfaceC5063a<t> interfaceC5063a = this.onComplete;
                    if (interfaceC5063a != null) {
                        interfaceC5063a.invoke();
                    }
                }
                if (this.endBehavior == EndBehavior.RELEASE) {
                    release();
                    return false;
                }
            }
        } else {
            if (i10 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            long j11 = this.durationMs;
            if (j11 > 0) {
                this.localElapsedMs = ((this.localElapsedMs % j11) + j11) % j11;
            }
        }
        return true;
    }

    public final void j(PlayMode mode, long durationMs, EndBehavior endBehavior, InterfaceC5063a<t> onComplete) {
        kotlin.jvm.internal.p.i(mode, "mode");
        kotlin.jvm.internal.p.i(endBehavior, "endBehavior");
        this.playMode = mode;
        this.durationMs = durationMs;
        this.endBehavior = endBehavior;
        this.onComplete = onComplete;
    }

    /* renamed from: k, reason: from getter */
    public final long getLocalElapsedMs() {
        return this.localElapsedMs;
    }

    public void l(long elapsedMs, float dt) {
        if (getIsActive()) {
            this.onFrameCallback.invoke(Long.valueOf(elapsedMs), Float.valueOf(dt));
        }
    }

    public final void m(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.effectName = str;
    }

    @Override // s7.k
    public void release() {
        if (getIsActive()) {
            this.isActive = false;
            this.onRelease.invoke();
        }
    }
}
