package stepai.android.mindx.client;

import H7.c;
import Ma.a;
import S7.n;
import android.content.Context;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import stepai.android.llm.base.LLMRequest;
import stepai.android.mindx.base.d;
import stepai.android.mindx.client.config.ClientConfig;
import stepai.android.mindx.client.config.StepChatResult;
import stepai.android.mindx.client.inner.e;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\u0003J \u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0096@¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u00142\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ)\u0010\u001f\u001a\u00020\u000b2\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u000b0\u001bH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010\"\u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0006H\u0016¢\u0006\u0004\b$\u0010\nJ\u0019\u0010&\u001a\u0004\u0018\u00010\u001d2\u0006\u0010%\u001a\u00020\u001dH\u0016¢\u0006\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u00018\u0000X\u0080\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lstepai/android/mindx/client/StepLLMClient;", "LMa/a;", AppAgent.CONSTRUCT, "()V", "Landroid/content/Context;", "context", "", "bindService", "(Landroid/content/Context;)Z", "isServiceConnected", "()Z", "LC7/r;", "unbindService", "Lstepai/android/llm/base/LLMRequest;", "param", "Lstepai/android/mindx/base/d;", "resourceType", "Lstepai/android/mindx/client/config/StepChatResult;", "chat", "(Lstepai/android/llm/base/LLMRequest;Lstepai/android/mindx/base/d;LH7/c;)Ljava/lang/Object;", "Lp9/c;", "stream", "(Lstepai/android/llm/base/LLMRequest;Lstepai/android/mindx/base/d;)Lp9/c;", "Lstepai/android/mindx/client/config/ClientConfig;", "config", "updateSetting", "(Lstepai/android/mindx/client/config/ClientConfig;)V", "Lkotlin/Function2;", "", "", "listener", "registerErrorListener", "(LS7/n;)V", "pathArray", "recordPathList", "(Ljava/lang/String;)V", "syncTraceBuffer", "id", "getTraceById", "(Ljava/lang/String;)Ljava/lang/String;", "client", "LMa/a;", "getClient$mindXClient_release", "()LMa/a;", "mindXClient_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepLLMClient implements a {
    public static final StepLLMClient INSTANCE = new StepLLMClient();
    private static final a client = new e();

    private StepLLMClient() {
    }

    @Override // Ma.a
    public boolean bindService(Context context) {
        k.f(context, "context");
        return client.bindService(context);
    }

    @Override // Ma.a
    public Object chat(LLMRequest lLMRequest, d dVar, c<? super StepChatResult> cVar) {
        return client.chat(lLMRequest, dVar, cVar);
    }

    public final a getClient$mindXClient_release() {
        return client;
    }

    @Override // Ma.a
    public String getTraceById(String id) {
        k.f(id, "id");
        return client.getTraceById(id);
    }

    @Override // Ma.a
    public boolean isServiceConnected() {
        return client.isServiceConnected();
    }

    @Override // Ma.a
    public void recordPathList(String pathArray) {
        client.recordPathList(pathArray);
    }

    @Override // Ma.a
    public void registerErrorListener(n listener) {
        k.f(listener, "listener");
        client.registerErrorListener(listener);
    }

    @Override // Ma.a
    public p9.c stream(LLMRequest param, d resourceType) {
        k.f(param, "param");
        k.f(resourceType, "resourceType");
        return client.stream(param, resourceType);
    }

    @Override // Ma.a
    public boolean syncTraceBuffer() {
        return client.syncTraceBuffer();
    }

    @Override // Ma.a
    public void unbindService() {
        client.unbindService();
    }

    @Override // Ma.a
    public void updateSetting(ClientConfig config) {
        k.f(config, "config");
        client.updateSetting(config);
    }
}
