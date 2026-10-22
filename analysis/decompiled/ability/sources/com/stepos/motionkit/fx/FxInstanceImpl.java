package com.stepos.motionkit.fx;

import S7.a;
import S7.n;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.EndBehavior;
import com.stepos.motionkit.FxInstance;
import com.stepos.motionkit.InternalFxInstance;
import com.stepos.motionkit.PlayMode;
import com.stepos.motionkit.fx.uniform.UniformBinder;
import g1.AbstractC1451a;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import stepai.android.llm.base.twoway.FlowType;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b'\b\u0000\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ5\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\"\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\"\u0010#J'\u0010\"\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\"\u0010&J/\u0010\"\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\"\u0010(J7\u0010\"\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\"\u0010*J\u0017\u0010,\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0005H\u0016¢\u0006\u0004\b,\u0010-J\u0017\u00100\u001a\u00020\u00062\u0006\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b0\u00101J\u001f\u00103\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u00102\u001a\u00020.¢\u0006\u0004\b3\u00104J\u0017\u00106\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u0005H\u0016¢\u0006\u0004\b6\u0010-R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u00107\u001a\u0004\b8\u00109R&\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010:R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010;R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010<R\"\u0010=\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010C\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u00107\u001a\u0004\bD\u00109\"\u0004\bE\u0010FR$\u0010+\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00058\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b+\u0010G\u001a\u0004\bH\u0010IR\u0016\u0010J\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010L\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010GR$\u0010M\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00178\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bM\u0010OR\u0016\u0010P\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u00107R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010RR\u001e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010;R\u0016\u0010S\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010NR\u0014\u0010 \u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bT\u0010@¨\u0006U"}, d2 = {"Lcom/stepos/motionkit/fx/FxInstanceImpl;", "Lcom/stepos/motionkit/InternalFxInstance;", "", "id", "Lkotlin/Function2;", "", "LC7/r;", "onFrameCallback", "Lkotlin/Function0;", "onRelease", "Lcom/stepos/motionkit/fx/uniform/UniformBinder;", "binder", AppAgent.CONSTRUCT, "(JLS7/n;LS7/a;Lcom/stepos/motionkit/fx/uniform/UniformBinder;)V", "Lcom/stepos/motionkit/PlayMode;", "mode", "durationMs", "Lcom/stepos/motionkit/EndBehavior;", "endBehavior", "onComplete", "applyPlayback", "(Lcom/stepos/motionkit/PlayMode;JLcom/stepos/motionkit/EndBehavior;LS7/a;)V", "dt", "", "advance", "(F)Z", "elapsedMs", "onFrame", "(JF)V", "release", "()V", "", HintConstants.AUTOFILL_HINT_NAME, "value", "setUniform", "(Ljava/lang/String;F)V", "x", "y", "(Ljava/lang/String;FF)V", "z", "(Ljava/lang/String;FFF)V", "w", "(Ljava/lang/String;FFFF)V", "speed", "setSpeed", "(F)V", "", "fps", "setFrameRate", "(I)V", "moduleDefaultFps", "accumulateFrame", "(FI)Ljava/lang/Float;", "t", "setProgress", "J", "getId", "()J", "LS7/n;", "LS7/a;", "Lcom/stepos/motionkit/fx/uniform/UniformBinder;", "effectName", "Ljava/lang/String;", "getEffectName", "()Ljava/lang/String;", "setEffectName", "(Ljava/lang/String;)V", "localElapsedMs", "getLocalElapsedMs", "setLocalElapsedMs", "(J)V", "F", "getSpeed", "()F", "frameRateOverride", "I", "frameAccumSec", "isActive", "Z", "()Z", "playMode", "Lcom/stepos/motionkit/PlayMode;", "Lcom/stepos/motionkit/EndBehavior;", FlowType.COMPLETED, "getName", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FxInstanceImpl implements InternalFxInstance {
    private final UniformBinder binder;
    private boolean completed;
    private long durationMs;
    private String effectName;
    private EndBehavior endBehavior;
    private float frameAccumSec;
    private volatile int frameRateOverride;
    private final long id;
    private boolean isActive;
    private long localElapsedMs;
    private a onComplete;
    private final n onFrameCallback;
    private final a onRelease;
    private PlayMode playMode;
    private volatile float speed;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

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
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public FxInstanceImpl(long j5, n onFrameCallback, a onRelease, UniformBinder uniformBinder) {
        k.f(onFrameCallback, "onFrameCallback");
        k.f(onRelease, "onRelease");
        this.id = j5;
        this.onFrameCallback = onFrameCallback;
        this.onRelease = onRelease;
        this.binder = uniformBinder;
        this.effectName = "";
        this.speed = 1.0f;
        this.frameRateOverride = -1;
        this.isActive = true;
        this.playMode = PlayMode.LOOP;
        this.endBehavior = EndBehavior.FREEZE;
    }

    public final Float accumulateFrame(float dt, int moduleDefaultFps) {
        if (this.frameRateOverride >= 0) {
            moduleDefaultFps = this.frameRateOverride;
        }
        if (moduleDefaultFps <= 0) {
            return Float.valueOf(dt);
        }
        float f = 1.0f / moduleDefaultFps;
        float f7 = this.frameAccumSec + dt;
        this.frameAccumSec = f7;
        if (f7 < f) {
            return null;
        }
        this.frameAccumSec = 0.0f;
        return Float.valueOf(f7);
    }

    public final boolean advance(float dt) {
        if (!getIsActive()) {
            return false;
        }
        this.localElapsedMs += (long) (dt * 1000 * this.speed);
        int i = WhenMappings.$EnumSwitchMapping$0[this.playMode.ordinal()];
        if (i == 1) {
            long j5 = this.durationMs;
            if (j5 > 0 && this.localElapsedMs >= j5) {
                this.localElapsedMs = j5;
                if (!this.completed) {
                    this.completed = true;
                    a aVar = this.onComplete;
                    if (aVar != null) {
                        aVar.invoke();
                    }
                }
                if (this.endBehavior == EndBehavior.RELEASE) {
                    release();
                    return false;
                }
            }
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            long j6 = this.durationMs;
            if (j6 > 0) {
                this.localElapsedMs = ((this.localElapsedMs % j6) + j6) % j6;
            }
        }
        return true;
    }

    public final void applyPlayback(PlayMode mode, long durationMs, EndBehavior endBehavior, a onComplete) {
        k.f(mode, "mode");
        k.f(endBehavior, "endBehavior");
        this.playMode = mode;
        this.durationMs = durationMs;
        this.endBehavior = endBehavior;
        this.onComplete = onComplete;
    }

    public final String getEffectName() {
        return this.effectName;
    }

    @Override // com.stepos.motionkit.FxInstance
    public long getId() {
        return this.id;
    }

    public final long getLocalElapsedMs() {
        return this.localElapsedMs;
    }

    @Override // com.stepos.motionkit.FxInstance
    public String getName() {
        return this.effectName;
    }

    public final float getSpeed() {
        return this.speed;
    }

    @Override // com.stepos.motionkit.FxInstance
    public FxInstance instance(String str) {
        return InternalFxInstance.DefaultImpls.instance(this, str);
    }

    @Override // com.stepos.motionkit.FxInstance
    /* renamed from: isActive, reason: from getter */
    public boolean getIsActive() {
        return this.isActive;
    }

    @Override // com.stepos.motionkit.InternalFxInstance
    public void onFrame(long elapsedMs, float dt) {
        if (getIsActive()) {
            this.onFrameCallback.invoke(Long.valueOf(elapsedMs), Float.valueOf(dt));
        }
    }

    @Override // com.stepos.motionkit.FxInstance
    public void release() {
        if (getIsActive()) {
            this.isActive = false;
            this.onRelease.invoke();
        }
    }

    public final void setEffectName(String str) {
        k.f(str, "<set-?>");
        this.effectName = str;
    }

    @Override // com.stepos.motionkit.FxInstance
    public void setFrameRate(int fps) {
        this.frameRateOverride = fps;
        this.frameAccumSec = 0.0f;
    }

    public final void setLocalElapsedMs(long j5) {
        this.localElapsedMs = j5;
    }

    @Override // com.stepos.motionkit.FxInstance
    public void setProgress(float t9) {
        UniformBinder uniformBinder = this.binder;
        if (uniformBinder == null) {
            return;
        }
        long totalDurationMs = uniformBinder.getTotalDurationMs();
        if (totalDurationMs <= 0) {
            return;
        }
        long jT = (long) (AbstractC1451a.t(t9, 0.0f, 1.0f) * totalDurationMs);
        this.localElapsedMs = jT;
        uniformBinder.resolve(jT);
    }

    @Override // com.stepos.motionkit.FxInstance
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    @Override // com.stepos.motionkit.FxInstance
    public void setUniform(String name, float value) {
        k.f(name, "name");
        UniformBinder uniformBinder = this.binder;
        if (uniformBinder != null) {
            uniformBinder.set(name, value);
        }
    }

    @Override // com.stepos.motionkit.FxInstance
    public void setUniform(String name, float x10, float y) {
        k.f(name, "name");
        UniformBinder uniformBinder = this.binder;
        if (uniformBinder != null) {
            uniformBinder.set(name, x10, y);
        }
    }

    @Override // com.stepos.motionkit.FxInstance
    public void setUniform(String name, float x10, float y, float z10) {
        k.f(name, "name");
        UniformBinder uniformBinder = this.binder;
        if (uniformBinder != null) {
            uniformBinder.set(name, x10, y, z10);
        }
    }

    @Override // com.stepos.motionkit.FxInstance
    public void setUniform(String name, float x10, float y, float z10, float w8) {
        k.f(name, "name");
        UniformBinder uniformBinder = this.binder;
        if (uniformBinder != null) {
            uniformBinder.set(name, x10, y, z10, w8);
        }
    }

    public /* synthetic */ FxInstanceImpl(long j5, n nVar, a aVar, UniformBinder uniformBinder, int i, e eVar) {
        this(j5, nVar, aVar, (i & 8) != 0 ? null : uniformBinder);
    }
}
