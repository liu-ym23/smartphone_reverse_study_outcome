package com.stepos.aiengine.adapter;

import android.os.Bundle;
import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.algorithm.tts.ITTS;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.api.task.IBundleCallback;
import com.stepos.core.c;
import com.stepos.core.callback.b;
import com.stepos.core.d;
import com.stepos.core.data.TextContent;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J/\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/aiengine/adapter/TTSAbilityAdapter;", "Lcom/stepos/aiengine/algorithm/tts/ITTS;", "Lcom/stepos/core/c;", "handle", AppAgent.CONSTRUCT, "(Lcom/stepos/core/c;)V", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", "token", "", "text", "Landroid/os/Bundle;", "args", "Lcom/stepos/aiengine/api/task/IBundleCallback;", "callback", "", "synthesize", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Ljava/lang/String;Landroid/os/Bundle;Lcom/stepos/aiengine/api/task/IBundleCallback;)I", "", "identity", "", "cancel", "(J)Z", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TTSAbilityAdapter implements ITTS {

    /* renamed from: a, reason: collision with root package name */
    public final c f3478a;

    public TTSAbilityAdapter(c handle) {
        k.f(handle, "handle");
        this.f3478a = handle;
    }

    @Override // com.stepos.aiengine.algorithm.tts.ITTS
    public boolean cancel(long identity) {
        return this.f3478a.a(String.valueOf(identity));
    }

    @Override // com.stepos.aiengine.algorithm.tts.ITTS
    public int synthesize(AlgorithmToken token, String text, Bundle args, final IBundleCallback callback) {
        k.f(token, "token");
        k.f(text, "text");
        k.f(args, "args");
        k.f(callback, "callback");
        this.f3478a.g(String.valueOf(token.getIdentity()), new TextContent(text), new d() { // from class: com.stepos.aiengine.adapter.TTSAbilityAdapter.synthesize.1
            @Override // com.stepos.core.d
            public void onNext(String inferId, com.stepos.core.callback.c result) {
                k.f(inferId, "inferId");
                k.f(result, "result");
                boolean z10 = result instanceof b;
                IBundleCallback iBundleCallback = callback;
                if (z10) {
                    Bundle bundle = new Bundle();
                    b bVar = (b) result;
                    bundle.putString("exception", a.c(bVar.f3827a, "[", "] ", bVar.b));
                    bundle.putBoolean("is_done", true);
                    iBundleCallback.onCall(bundle);
                    return;
                }
                if (!result.equals(com.stepos.core.callback.a.f3826a)) {
                    throw new NoWhenBranchMatchedException();
                }
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("is_done", true);
                iBundleCallback.onCall(bundle2);
            }
        });
        return 0;
    }
}
