package t7;

import La.C0953c;
import La.D;
import Y8.t;
import Z8.A;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.motionkit.BackendHint;
import com.stepos.motionkit.ErrorLevel;
import com.stepos.motionkit.SurfaceRendererType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import s7.EffectDefinition;
import s7.MotionKitError;
import s7.k;
import s7.l;
import s7.o;
import s7.r;
import v7.m;
import v7.z;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ3\u0010\u0013\u001a\u0004\u0018\u00010\u00122\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t0\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ-\u0010\u001f\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001e\u001a\u00020\r2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t0\u000fH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020#H\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020#H\u0002¢\u0006\u0004\b(\u0010'J\u001f\u0010*\u001a\u00020)2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b*\u0010+R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010,R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020.0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010/R\u0018\u00102\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u00101R\u0018\u00103\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u00101R\u0018\u00105\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00101R\u0016\u00108\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107¨\u00069"}, d2 = {"Lt7/g;", "Ls7/l;", "Ls7/r;", "Ls7/o;", "host", "<init>", "(Ls7/o;)V", "", "fps", "LY8/t;", Const.INTENT_KEY_APIKEY, "(I)V", "", "Ls7/e;", "effects", "Lkotlin/Function1;", "Ls7/j;", "config", "Ls7/k;", Const.INTENT_KEY_PKGNAME, "(Ljava/util/List;Lp9/l;)Ls7/k;", "instance", Const.INTENT_KEY_UMID, "(Ls7/k;)V", "", "dt", "c", "(F)V", "release", "()V", "effect", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ls7/e;Lp9/l;)Ls7/k;", "Lcom/stepos/motionkit/BackendHint;", "hint", "Ls7/i;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/motionkit/BackendHint;)Ls7/i;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ls7/i;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "", "k", "(Ls7/e;Ls7/j;)Ljava/lang/String;", "Ls7/o;", "", "Lt7/d;", "Ljava/util/List;", "instances", "Ls7/i;", "runtimeShaderBackend", "surfaceBackend", "e", "sfBackend", "f", "I", "defaultFrameRate", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class g implements l, r {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final o host;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final List<d> instances;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public s7.i runtimeShaderBackend;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public s7.i surfaceBackend;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public s7.i sfBackend;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public int defaultFrameRate;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f42040a;

        static {
            int[] iArr = new int[BackendHint.values().length];
            try {
                iArr[BackendHint.RUNTIME_SHADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BackendHint.AUTO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BackendHint.SURFACE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BackendHint.SF.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f42040a = iArr;
        }
    }

    public g(o host) {
        p.i(host, "host");
        this.host = host;
        this.instances = new ArrayList();
    }

    public static final boolean l(d it) {
        p.i(it, "it");
        return !it.getIsActive();
    }

    public static final boolean m(k kVar, d it) {
        p.i(it, "it");
        return it.getId() == kVar.getId();
    }

    @Override // s7.l
    public void a(int fps) {
        this.defaultFrameRate = fps;
        this.host.getFrameLoop().j(fps);
    }

    @Override // s7.l
    public k b(List<EffectDefinition> effects, InterfaceC5074l<? super s7.j, t> config) {
        p.i(effects, "effects");
        p.i(config, "config");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = effects.iterator();
        while (it.hasNext()) {
            k kVarJ = j((EffectDefinition) it.next(), config);
            if (kVarJ != null) {
                arrayList.add(kVarJ);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList.size() == 1 ? (k) arrayList.get(0) : new C5519b(arrayList);
    }

    @Override // s7.r
    public void c(float dt) {
        Iterator<d> it = this.instances.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.getIsActive()) {
                Float fH = next.h(dt, this.defaultFrameRate);
                if (fH != null) {
                    float fFloatValue = fH.floatValue();
                    next.l(next.getLocalElapsedMs(), fFloatValue);
                    if (!next.i(fFloatValue)) {
                        it.remove();
                    }
                }
            } else {
                it.remove();
            }
        }
    }

    @Override // s7.l
    public void d(final k instance) {
        p.i(instance, "instance");
        instance.release();
        if (instance instanceof C5519b) {
            A.L(this.instances, new InterfaceC5074l() { // from class: t7.e
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(g.l((d) obj));
                }
            });
        } else {
            A.L(this.instances, new InterfaceC5074l() { // from class: t7.f
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(g.m(instance, (d) obj));
                }
            });
        }
    }

    public final s7.i g() {
        return new m();
    }

    public final s7.i h() {
        return new z();
    }

    public final s7.i i(BackendHint hint) {
        int i10 = a.f42040a[hint.ordinal()];
        if (i10 == 1 || i10 == 2) {
            s7.i iVar = this.runtimeShaderBackend;
            if (iVar != null) {
                return iVar;
            }
            s7.i iVarG = g();
            this.runtimeShaderBackend = iVarG;
            return iVarG;
        }
        if (i10 == 3) {
            s7.i iVar2 = this.surfaceBackend;
            if (iVar2 != null) {
                return iVar2;
            }
            s7.i iVarH = h();
            this.surfaceBackend = iVarH;
            return iVarH;
        }
        if (i10 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        s7.i iVar3 = this.sfBackend;
        if (iVar3 != null) {
            return iVar3;
        }
        v7.r rVar = new v7.r();
        this.sfBackend = rVar;
        return rVar;
    }

    public final k j(EffectDefinition effect, InterfaceC5074l<? super s7.j, t> config) {
        s7.p pVar = s7.p.f40121a;
        try {
            s7.j jVar = new s7.j();
            config.invoke(jVar);
            s7.b bVar = s7.b.f40073a;
            Context context = this.host.getView().getContext();
            p.h(context, "getContext(...)");
            BackendHint backendHintA = bVar.a(effect, jVar, context);
            s7.i iVarI = i(backendHintA);
            s7.c cVar = new s7.c(k(effect, jVar), backendHintA, null, 4, null);
            o oVar = this.host;
            k kVarA = iVarI.a(oVar, oVar.getView(), cVar, jVar, effect);
            p.g(kVarA, "null cannot be cast to non-null type com.stepos.motionkit.fx.FxInstanceImpl");
            d dVar = (d) kVarA;
            dVar.m(effect.getName());
            dVar.j(jVar.getPlayMode(), jVar.getDurationMs(), jVar.getEndBehavior(), jVar.d());
            this.instances.add(dVar);
            return dVar;
        } catch (Exception e10) {
            pVar.a(new MotionKitError(ErrorLevel.DEGRADED, "FX operation failed", e10));
            return null;
        }
    }

    public final String k(EffectDefinition effect, s7.j config) throws IOException {
        String shaderSource = effect.getShaderSource();
        if (shaderSource != null) {
            return shaderSource;
        }
        String shaderAsset = effect.getShaderAsset();
        if (shaderAsset == null) {
            return "";
        }
        String strT = config.getSurfaceRenderer() == SurfaceRendererType.GLES ? D.T(shaderAsset, ".agsl", ".glsl", false, 4, null) : shaderAsset;
        try {
            InputStream inputStreamOpen = this.host.getView().getContext().getAssets().open("motionkit/shaders/" + strT);
            p.h(inputStreamOpen, "open(...)");
            return l9.m.e(new BufferedReader(new InputStreamReader(inputStreamOpen, C0953c.UTF_8), com.stepos.agentframework.chatui.longtext.b.THRESHOLD));
        } catch (Exception unused) {
            InputStream inputStreamOpen2 = this.host.getView().getContext().getAssets().open("motionkit/shaders/" + shaderAsset);
            p.h(inputStreamOpen2, "open(...)");
            return l9.m.e(new BufferedReader(new InputStreamReader(inputStreamOpen2, C0953c.UTF_8), com.stepos.agentframework.chatui.longtext.b.THRESHOLD));
        }
    }

    @Override // s7.r
    public void release() {
        Iterator<T> it = this.instances.iterator();
        while (it.hasNext()) {
            ((d) it.next()).release();
        }
        this.instances.clear();
        s7.i iVar = this.runtimeShaderBackend;
        if (iVar != null) {
            iVar.release();
        }
        s7.i iVar2 = this.surfaceBackend;
        if (iVar2 != null) {
            iVar2.release();
        }
        s7.i iVar3 = this.sfBackend;
        if (iVar3 != null) {
            iVar3.release();
        }
        this.runtimeShaderBackend = null;
        this.surfaceBackend = null;
        this.sfBackend = null;
    }
}
