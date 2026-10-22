package com.stepos.motionkit.fx.shader;

import android.content.Context;
import android.graphics.RuntimeShader;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import com.stepos.motionkit.BackendHint;
import com.stepos.motionkit.CompiledShader;
import j9.AbstractC1607a;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\fJ\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/motionkit/fx/shader/ShaderCompiler;", "", "Landroid/content/Context;", "context", AppAgent.CONSTRUCT, "(Landroid/content/Context;)V", "", AgentBusWakeContract.EXTRA_SOURCE, "Lcom/stepos/motionkit/BackendHint;", "backendHint", "Lcom/stepos/motionkit/CompiledShader;", "doCompile", "(Ljava/lang/String;Lcom/stepos/motionkit/BackendHint;)Lcom/stepos/motionkit/CompiledShader;", "backend", "computeKey", "(Ljava/lang/String;Lcom/stepos/motionkit/BackendHint;)Ljava/lang/String;", "compile", "LC7/r;", "evictAll", "()V", "Lcom/stepos/motionkit/fx/shader/ShaderCache;", "cache", "Lcom/stepos/motionkit/fx/shader/ShaderCache;", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ShaderCompiler {
    private final ShaderCache cache;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

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
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ShaderCompiler(Context context) {
        k.f(context, "context");
        this.cache = new ShaderCache(context);
    }

    private final String computeKey(String source, BackendHint backend) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        Charset charset = AbstractC1607a.f4778a;
        byte[] bytes = source.getBytes(charset);
        k.e(bytes, "getBytes(...)");
        messageDigest.update(bytes);
        byte[] bytes2 = backend.name().getBytes(charset);
        k.e(bytes2, "getBytes(...)");
        messageDigest.update(bytes2);
        byte[] bArrDigest = messageDigest.digest();
        k.e(bArrDigest, "digest(...)");
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        int i = 0;
        for (byte b : bArrDigest) {
            i++;
            if (i > 1) {
                sb.append((CharSequence) "");
            }
            sb.append(computeKey$lambda$2(b));
        }
        sb.append((CharSequence) "");
        return sb.toString();
    }

    private static final CharSequence computeKey$lambda$2(byte b) {
        return String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
    }

    private final CompiledShader doCompile(String source, BackendHint backendHint) {
        int i = WhenMappings.$EnumSwitchMapping$0[backendHint.ordinal()];
        if (i == 1 || i == 2) {
            return new CompiledShader(source, backendHint, new RuntimeShader(source));
        }
        if (i != 3 && i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return new CompiledShader(source, backendHint, null);
    }

    public final CompiledShader compile(String source, BackendHint backendHint) throws Throwable {
        k.f(source, "source");
        k.f(backendHint, "backendHint");
        String strComputeKey = computeKey(source, backendHint);
        CompiledShader l1 = this.cache.getL1(strComputeKey);
        if (l1 != null) {
            return l1;
        }
        String l22 = this.cache.getL2(strComputeKey);
        if (l22 != null) {
            CompiledShader compiledShaderDoCompile = doCompile(l22, backendHint);
            this.cache.putL1(strComputeKey, compiledShaderDoCompile);
            return compiledShaderDoCompile;
        }
        CompiledShader compiledShaderDoCompile2 = doCompile(source, backendHint);
        this.cache.putL1(strComputeKey, compiledShaderDoCompile2);
        this.cache.putL2(strComputeKey, source);
        return compiledShaderDoCompile2;
    }

    public final void evictAll() {
        this.cache.evictAll();
    }
}
