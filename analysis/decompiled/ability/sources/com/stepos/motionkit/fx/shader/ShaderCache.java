package com.stepos.motionkit.fx.shader;

import R5.b;
import android.content.Context;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import com.stepos.motionkit.CompiledShader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import o3.C1761d;
import o3.e;
import o3.f;
import o3.i;

@Metadata(d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0016\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/stepos/motionkit/fx/shader/ShaderCache;", "", "Landroid/content/Context;", "context", AppAgent.CONSTRUCT, "(Landroid/content/Context;)V", "", "key", "Lcom/stepos/motionkit/CompiledShader;", "getL1", "(Ljava/lang/String;)Lcom/stepos/motionkit/CompiledShader;", "shader", "LC7/r;", "putL1", "(Ljava/lang/String;Lcom/stepos/motionkit/CompiledShader;)V", "getL2", "(Ljava/lang/String;)Ljava/lang/String;", AgentBusWakeContract.EXTRA_SOURCE, "putL2", "(Ljava/lang/String;Ljava/lang/String;)V", "evictAll", "()V", "com/stepos/motionkit/fx/shader/ShaderCache$l1$1", "l1", "Lcom/stepos/motionkit/fx/shader/ShaderCache$l1$1;", "Lo3/f;", "diskCache", "Lo3/f;", "Companion", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ShaderCache {
    private static final int MAX_L1_ENTRIES = 16;
    private static final long MAX_L2_SIZE = 8388608;
    private final f diskCache;
    private final ShaderCache$l1$1 l1;

    public ShaderCache(Context context) {
        f fVarK;
        k.f(context, "context");
        this.l1 = new ShaderCache$l1$1();
        try {
            fVarK = f.k(new File(context.getCacheDir(), "motionkit_shader_cache"));
        } catch (Exception unused) {
            fVarK = null;
        }
        this.diskCache = fVarK;
    }

    public final void evictAll() {
        synchronized (this.l1) {
            this.l1.clear();
        }
        try {
            f fVar = this.diskCache;
            if (fVar != null) {
                fVar.close();
                i.b(fVar.f5422a);
            }
        } catch (Exception unused) {
        }
    }

    public final CompiledShader getL1(String key) {
        CompiledShader compiledShader;
        k.f(key, "key");
        synchronized (this.l1) {
            compiledShader = (CompiledShader) this.l1.get((Object) key);
        }
        return compiledShader;
    }

    public final String getL2(String key) throws IOException {
        e eVarG;
        k.f(key, "key");
        try {
            f fVar = this.diskCache;
            if (fVar == null || (eVarG = fVar.g(key)) == null) {
                return null;
            }
            InputStreamReader inputStreamReader = new InputStreamReader(eVarG.f5421a[0], i.b);
            try {
                StringWriter stringWriter = new StringWriter();
                char[] cArr = new char[1024];
                while (true) {
                    int i = inputStreamReader.read(cArr);
                    if (i == -1) {
                        String string = stringWriter.toString();
                        inputStreamReader.close();
                        return string;
                    }
                    stringWriter.write(cArr, 0, i);
                }
            } catch (Throwable th) {
                inputStreamReader.close();
                throw th;
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public final void putL1(String key, CompiledShader shader) {
        k.f(key, "key");
        k.f(shader, "shader");
        synchronized (this.l1) {
            this.l1.put(key, shader);
        }
    }

    public final void putL2(String key, String source) throws Throwable {
        b bVarF;
        k.f(key, "key");
        k.f(source, "source");
        try {
            f fVar = this.diskCache;
            if (fVar == null || (bVarF = fVar.f(key)) == null) {
                return;
            }
            OutputStreamWriter outputStreamWriter = null;
            try {
                OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(bVarF.c(), i.b);
                try {
                    outputStreamWriter2.write(source);
                    i.a(outputStreamWriter2);
                    f fVar2 = (f) bVarF.d;
                    if (!bVarF.f1153a) {
                        f.b(fVar2, bVarF, true);
                    } else {
                        f.b(fVar2, bVarF, false);
                        fVar2.w(((C1761d) bVarF.b).f5420a);
                    }
                } catch (Throwable th) {
                    th = th;
                    outputStreamWriter = outputStreamWriter2;
                    i.a(outputStreamWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused) {
        }
    }
}
