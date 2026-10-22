package B7;

import La.m;
import Y8.t;
import Z8.C1168p;
import Z8.C1174w;
import Z8.Y;
import android.graphics.RuntimeShader;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.C5587f;
import kotlin.C5588g;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.p;
import kotlin.text.Regex;
import p9.InterfaceC5063a;
import p9.q;
import s7.AnimationDefinition;
import s7.EffectDefinition;
import s7.TrackDefinition;
import s7.w;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0006\u0018\u0000 &2\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J-\u0010\u001b\u001a\u00020\b2\u001e\u0010\u001a\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\b0\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001f\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J%\u0010#\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001d¢\u0006\u0004\b#\u0010$J-\u0010&\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001d¢\u0006\u0004\b&\u0010'J5\u0010)\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\u001d¢\u0006\u0004\b)\u0010*J\u0019\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00180+¢\u0006\u0004\b,\u0010-R\u0014\u00100\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010/R\u0016\u00103\u001a\u0004\u0018\u0001018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u00102R&\u00107\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d05048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u00106R&\u00109\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b080+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u00106R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020\u000b0:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010;R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000b0:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010;R\u0014\u0010?\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010>¨\u0006@"}, d2 = {"LB7/a;", "", "Ls7/e;", "definition", "<init>", "(Ls7/e;)V", "", "elapsedMs", "LY8/t;", "e", "(J)V", "", "source", "c", "(Ljava/lang/String;)V", "name", "", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)Z", "Landroid/graphics/RuntimeShader;", "shader", Const.INTENT_KEY_APIKEY, "(Landroid/graphics/RuntimeShader;)V", "Lkotlin/Function3;", "", "", "uniformSetter", Const.INTENT_KEY_PKGNAME, "(Lp9/q;)V", "", UxipConstants.f30680s, "f", "(Ljava/lang/String;F)V", "x", "y", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;FF)V", "z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;FFF)V", "w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;FFFF)V", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Ljava/util/Map;", "LB7/b;", "LB7/b;", "buffer", "Lu7/f;", "Lu7/f;", "evaluator", "", "LXa/b;", "Ljava/util/Map;", "flowBindings", "Lkotlin/Function0;", "completionActions", "", "Ljava/util/Set;", "invalidUniforms", "declaredFloatUniforms", "[F", "glesTemp", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class a {

    /* renamed from: i, reason: collision with root package name */
    public static final Regex f1443i = new Regex("uniform\\s+(\\w+)\\s+(\\w+)");

    /* renamed from: j, reason: collision with root package name */
    public static final Set<String> f1444j = Y.j("float", "vec2", "vec3", "vec4", "float2", "float3", "float4", ChatTracker.STAGE_HALF, "half2", "half3", "half4");

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final b buffer;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final C5587f evaluator;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Map<String, Xa.b<Float>> flowBindings;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Map<String, InterfaceC5063a<t>> completionActions;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Set<String> invalidUniforms;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final Set<String> declaredFloatUniforms;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final float[] glesTemp;

    public a(EffectDefinition definition) {
        p.i(definition, "definition");
        this.buffer = new b(0, 1, null);
        this.flowBindings = new LinkedHashMap();
        for (w wVar : definition.i()) {
            if (wVar instanceof w.b) {
                this.buffer.a(wVar.getName(), 1);
                this.buffer.f(wVar.getName(), ((w.b) wVar).getDefault());
            } else if (wVar instanceof w.c) {
                this.buffer.a(wVar.getName(), 2);
                b bVar = this.buffer;
                String name = wVar.getName();
                w.c cVar = (w.c) wVar;
                bVar.g(name, cVar.getDefaultX(), cVar.getDefaultY());
            } else if (wVar instanceof w.d) {
                this.buffer.a(wVar.getName(), 3);
                b bVar2 = this.buffer;
                String name2 = wVar.getName();
                w.d dVar = (w.d) wVar;
                bVar2.h(name2, dVar.getDefaultX(), dVar.getDefaultY(), dVar.getDefaultZ());
            } else if (wVar instanceof w.e) {
                this.buffer.a(wVar.getName(), 4);
                b bVar3 = this.buffer;
                String name3 = wVar.getName();
                w.e eVar = (w.e) wVar;
                bVar3.i(name3, eVar.getDefaultX(), eVar.getDefaultY(), eVar.getDefaultZ(), eVar.getDefaultW());
            } else {
                if (!(wVar instanceof w.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                this.buffer.a(wVar.getName(), 4);
                int defaultColor = ((w.a) wVar).getDefaultColor();
                this.buffer.i(wVar.getName(), ((defaultColor >> 16) & 255) / 255.0f, ((defaultColor >> 8) & 255) / 255.0f, (defaultColor & 255) / 255.0f, ((defaultColor >> 24) & 255) / 255.0f);
            }
        }
        AnimationDefinition animation = definition.getAnimation();
        if (animation != null) {
            List<TrackDefinition> listB = animation.b();
            ArrayList arrayList = new ArrayList(C1174w.x(listB, 10));
            for (TrackDefinition trackDefinition : listB) {
                arrayList.add(new C5588g(trackDefinition.getUniformName(), trackDefinition.getType(), trackDefinition.getComponent(), 0.0f, false, 24, null));
            }
            this.evaluator = new C5587f(arrayList);
            this.completionActions = animation.a();
        } else {
            this.evaluator = null;
            this.completionActions = kotlin.collections.a.i();
        }
        this.invalidUniforms = new LinkedHashSet();
        this.declaredFloatUniforms = new LinkedHashSet();
        this.glesTemp = new float[4];
    }

    public final void a(RuntimeShader shader) {
        p.i(shader, "shader");
        for (String str : this.buffer.c()) {
            if (!this.invalidUniforms.contains(str) && d(str)) {
                int iB = this.buffer.b(str);
                Integer numD = this.buffer.d(str);
                if (numD != null) {
                    int iIntValue = numD.intValue();
                    float[] data = this.buffer.getData();
                    if (iB == 1) {
                        shader.setFloatUniform(str, data[iIntValue]);
                    } else if (iB == 2) {
                        shader.setFloatUniform(str, data[iIntValue], data[iIntValue + 1]);
                    } else if (iB == 3) {
                        shader.setFloatUniform(str, data[iIntValue], data[iIntValue + 1], data[iIntValue + 2]);
                    } else if (iB == 4) {
                        try {
                            float f10 = data[iIntValue];
                            float f11 = data[iIntValue + 1];
                            float f12 = data[iIntValue + 2];
                            float f13 = data[iIntValue + 3];
                            RuntimeShader runtimeShader = shader;
                            try {
                                runtimeShader.setFloatUniform(str, f10, f11, f12, f13);
                                shader = runtimeShader;
                            } catch (IllegalArgumentException unused) {
                                shader = runtimeShader;
                                this.invalidUniforms.add(str);
                            }
                        } catch (IllegalArgumentException unused2) {
                        }
                    }
                    t tVar = t.f7040a;
                }
            }
        }
    }

    public final void b(q<? super String, ? super float[], ? super Integer, t> uniformSetter) {
        p.i(uniformSetter, "uniformSetter");
        for (String str : this.buffer.c()) {
            int iB = this.buffer.b(str);
            Integer numD = this.buffer.d(str);
            if (numD != null) {
                System.arraycopy(this.buffer.getData(), numD.intValue(), this.glesTemp, 0, iB);
                uniformSetter.invoke(str, this.glesTemp, Integer.valueOf(iB));
            }
        }
    }

    public final void c(String source) {
        p.i(source, "source");
        this.declaredFloatUniforms.clear();
        for (m mVar : Regex.f(f1443i, source, 0, 2, null)) {
            if (f1444j.contains(mVar.c().get(1))) {
                this.declaredFloatUniforms.add(mVar.c().get(2));
            }
        }
    }

    public final boolean d(String name) {
        p.i(name, "name");
        return this.declaredFloatUniforms.isEmpty() || this.declaredFloatUniforms.contains(name);
    }

    public final void e(long elapsedMs) {
        C5587f c5587f = this.evaluator;
        if (c5587f != null) {
            c5587f.a(elapsedMs);
            for (C5588g c5588g : c5587f.c()) {
                if (c5588g.getComponent() >= 0) {
                    this.buffer.j(c5588g.getName(), c5588g.getComponent(), c5588g.getValue());
                } else {
                    this.buffer.f(c5588g.getName(), c5588g.getValue());
                }
            }
            Iterator<String> it = c5587f.d(elapsedMs).iterator();
            while (it.hasNext()) {
                InterfaceC5063a<t> interfaceC5063a = this.completionActions.get(it.next());
                if (interfaceC5063a != null) {
                    interfaceC5063a.invoke();
                }
            }
        }
    }

    public final void f(String name, float value) {
        p.i(name, "name");
        this.buffer.f(name, value);
    }

    public final void g(String name, float x10, float y10) {
        p.i(name, "name");
        this.buffer.g(name, x10, y10);
    }

    public final void h(String name, float x10, float y10, float z10) {
        p.i(name, "name");
        this.buffer.h(name, x10, y10, z10);
    }

    public final void i(String name, float x10, float y10, float z10, float w10) {
        p.i(name, "name");
        this.buffer.i(name, x10, y10, z10, w10);
    }

    public final Map<String, float[]> j() {
        HashMap map = new HashMap();
        for (String str : this.buffer.c()) {
            int iB = this.buffer.b(str);
            Integer numD = this.buffer.d(str);
            if (numD != null) {
                int iIntValue = numD.intValue();
                map.put(str, C1168p.p(this.buffer.getData(), iIntValue, iB + iIntValue));
            }
        }
        return map;
    }
}
