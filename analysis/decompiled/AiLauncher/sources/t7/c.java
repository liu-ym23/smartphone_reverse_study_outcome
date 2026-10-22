package t7;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import s7.EffectDefinition;
import x7.m;
import x7.z;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u0005\u0010\bR\u0017\u0010\u000e\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\bR\u0017\u0010\u0011\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\bR\u0017\u0010\u0014\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0013\u0010\bR\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lt7/c;", "", "<init>", "()V", "Ls7/e;", Const.INTENT_KEY_PKGNAME, "Ls7/e;", "getEdgeGlow", "()Ls7/e;", "EdgeGlow", "c", "SpectrumBorder", Const.INTENT_KEY_UMID, Const.INTENT_KEY_APIKEY, "Mesh", "e", "getEdgeBlurDispersion", "EdgeBlurDispersion", "f", "getWaveGlow", "WaveGlow", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "Ljava/util/List;", "getAll", "()Ljava/util/List;", "all", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f42010a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final EffectDefinition EdgeGlow;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final EffectDefinition SpectrumBorder;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final EffectDefinition Mesh;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final EffectDefinition EdgeBlurDispersion;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final EffectDefinition WaveGlow;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final List<EffectDefinition> all;

    static {
        EffectDefinition effectDefinitionE = x7.i.e();
        EdgeGlow = effectDefinitionE;
        EffectDefinition effectDefinitionE2 = m.e();
        SpectrumBorder = effectDefinitionE2;
        EffectDefinition effectDefinitionA = x7.j.a();
        Mesh = effectDefinitionA;
        EffectDefinition effectDefinitionK = x7.f.k();
        EdgeBlurDispersion = effectDefinitionK;
        EffectDefinition effectDefinitionY = z.y();
        WaveGlow = effectDefinitionY;
        all = C1173v.p(effectDefinitionE, effectDefinitionE2, effectDefinitionA, effectDefinitionK, effectDefinitionY);
    }

    public final EffectDefinition a() {
        return Mesh;
    }

    public final EffectDefinition b() {
        return SpectrumBorder;
    }
}
