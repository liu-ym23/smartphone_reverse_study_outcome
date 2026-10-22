package I4;

import com.stepos.motionkit.BackendHint;
import com.stepos.motionkit.EffectDefinition;
import com.stepos.motionkit.UniformSpec;

/* loaded from: classes3.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final EffectDefinition f797a = new EffectDefinition("Glow", "key_glow_ripple.agsl", null, H4.o.N(new UniformSpec.Float1("uEnterDur", 0.36f, new Y7.a(0.05f, 2.0f), "Enter s"), new UniformSpec.Float1("uExitDur", 0.25f, new Y7.a(0.05f, 2.0f), "Exit s"), new UniformSpec.Float1("uEnterX", -20.67f, new Y7.a(-80.0f, 80.0f), "Enter X dp"), new UniformSpec.Float1("uEnterY", 0.0f, new Y7.a(-80.0f, 80.0f), "Enter Y dp"), new UniformSpec.Float1("uExitX", 20.67f, new Y7.a(0.0f, 80.0f), "Exit X dp"), new UniformSpec.Float1("uExitY", 0.0f, new Y7.a(-80.0f, 80.0f), "Exit Y dp"), new UniformSpec.Float1("uHoldMs", 0.0f, new Y7.a(0.0f, 4000.0f), "Hold ms"), new UniformSpec.Float1("uReleaseAt", -1.0f, new Y7.a(-1.0f, 8.0f), "Release at s"), new UniformSpec.Float1("uSide", 0.98f, new Y7.a(0.0f, 1.0f), "左右 0=左 1=右"), new UniformSpec.Float1("uCenterY", 0.5f, new Y7.a(0.05f, 0.95f), "垂直位置"), new UniformSpec.Float1("uHeight", 0.29f, new Y7.a(0.15f, 1.2f), "高度（屏高占比）"), new UniformSpec.Float1("uIntensity", 3.0f, new Y7.a(0.0f, 3.0f), "亮度")), BackendHint.RUNTIME_SHADER, false, null, 100, null);
}
