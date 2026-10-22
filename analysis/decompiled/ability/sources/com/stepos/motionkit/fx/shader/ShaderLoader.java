package com.stepos.motionkit.fx.shader;

import B9.Q;
import C7.r;
import D7.K;
import D7.v;
import H4.o;
import J7.c;
import S7.n;
import android.content.res.AssetManager;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import j9.AbstractC1607a;
import j9.InterfaceC1616j;
import j9.l;
import j9.m;
import j9.t;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.b;
import kotlin.collections.a;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import kotlin.text.Regex;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;
import u9.d;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ+\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\nH\u0002¢\u0006\u0004\b\f\u0010\rJ.\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\nH\u0086@¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0004\b\u0011\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/motionkit/fx/shader/ShaderLoader;", "", "Landroid/content/res/AssetManager;", "assets", AppAgent.CONSTRUCT, "(Landroid/content/res/AssetManager;)V", "", AgentBusWakeContract.EXTRA_SOURCE, "resolveIncludes", "(Ljava/lang/String;)Ljava/lang/String;", "", "defines", "preprocess", "(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;", "assetPath", "load", "(Ljava/lang/String;Ljava/util/Map;LH7/c;)Ljava/lang/Object;", "loadSync", "Landroid/content/res/AssetManager;", "", "includeCache", "Ljava/util/Map;", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ShaderLoader {
    private final AssetManager assets;
    private final Map<String, String> includeCache;

    @c(c = "com.stepos.motionkit.fx.shader.ShaderLoader$load$2", f = "ShaderLoader.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "", "<anonymous>", "(Lm9/z;)Ljava/lang/String;"}, k = 3, mv = {2, 0, 0})
    /* renamed from: com.stepos.motionkit.fx.shader.ShaderLoader$load$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ String $assetPath;
        final /* synthetic */ Map<String, String> $defines;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, Map<String, String> map, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$assetPath = str;
            this.$defines = map;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return ShaderLoader.this.new AnonymousClass2(this.$assetPath, this.$defines, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            InputStream inputStreamOpen = ShaderLoader.this.assets.open(this.$assetPath);
            k.e(inputStreamOpen, "open(...)");
            return ShaderLoader.this.preprocess(ShaderLoader.this.resolveIncludes(S0.b.o1(new BufferedReader(new InputStreamReader(inputStreamOpen, AbstractC1607a.f4778a), 8192))), this.$defines);
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super String> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public ShaderLoader(AssetManager assets) {
        k.f(assets, "assets");
        this.assets = assets;
        this.includeCache = new LinkedHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object load$default(ShaderLoader shaderLoader, String str, Map map, H7.c cVar, int i, Object obj) {
        if ((i & 2) != 0) {
            map = a.M();
        }
        return shaderLoader.load(str, map, cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String loadSync$default(ShaderLoader shaderLoader, String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = a.M();
        }
        return shaderLoader.loadSync(str, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String preprocess(String source, Map<String, String> defines) {
        if (defines.isEmpty()) {
            return source;
        }
        List<String> listW0 = m.w0(source);
        StringBuilder sb = new StringBuilder();
        ArrayList arrayListQ = o.Q(Boolean.TRUE);
        for (String str : listW0) {
            String string = m.R0(str).toString();
            boolean z10 = false;
            if (t.e0(string, "#ifdef ", false)) {
                String string2 = m.R0(m.y0("#ifdef ", string)).toString();
                if (((Boolean) v.K0(arrayListQ)).booleanValue() && defines.containsKey(string2)) {
                    z10 = true;
                }
                arrayListQ.add(Boolean.valueOf(z10));
            } else if (t.e0(string, "#ifndef ", false)) {
                String string3 = m.R0(m.y0("#ifndef ", string)).toString();
                if (((Boolean) v.K0(arrayListQ)).booleanValue() && !defines.containsKey(string3)) {
                    z10 = true;
                }
                arrayListQ.add(Boolean.valueOf(z10));
            } else if (string.equals("#else")) {
                if (arrayListQ.size() > 1) {
                    boolean zBooleanValue = ((Boolean) arrayListQ.get(arrayListQ.size() - 2)).booleanValue();
                    int iH = o.H(arrayListQ);
                    if (zBooleanValue && !((Boolean) v.K0(arrayListQ)).booleanValue()) {
                        z10 = true;
                    }
                    arrayListQ.set(iH, Boolean.valueOf(z10));
                }
            } else if (string.equals("#endif")) {
                if (arrayListQ.size() > 1) {
                    arrayListQ.remove(o.H(arrayListQ));
                }
            } else if (((Boolean) v.K0(arrayListQ)).booleanValue()) {
                sb.append(str);
                sb.append('\n');
            }
        }
        String string4 = sb.toString();
        k.e(string4, "toString(...)");
        return string4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String resolveIncludes(String source) {
        return new Regex("#include\\s+\"([^\"]+)\"").e(new Q(this, 29), source);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence resolveIncludes$lambda$1(ShaderLoader shaderLoader, InterfaceC1616j match) throws IOException {
        String strM;
        k.f(match, "match");
        String str = (String) ((K) ((l) match).a()).get(1);
        Map<String, String> map = shaderLoader.includeCache;
        String str2 = map.get(str);
        if (str2 == null) {
            try {
                InputStream inputStreamOpen = shaderLoader.assets.open("motionkit/shaders/include/" + str);
                k.e(inputStreamOpen, "open(...)");
                strM = S0.b.o1(new BufferedReader(new InputStreamReader(inputStreamOpen, AbstractC1607a.f4778a), 8192));
            } catch (Exception unused) {
                strM = B7.a.m("// include '", str, "' not found");
            }
            str2 = strM;
            map.put(str, str2);
        }
        return str2;
    }

    public final Object load(String str, Map<String, String> map, H7.c<? super String> cVar) {
        d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new AnonymousClass2(str, map, null), cVar);
    }

    public final String loadSync(String source, Map<String, String> defines) {
        k.f(source, "source");
        k.f(defines, "defines");
        return preprocess(resolveIncludes(source), defines);
    }
}
