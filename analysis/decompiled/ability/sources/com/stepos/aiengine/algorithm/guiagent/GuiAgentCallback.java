package com.stepos.aiengine.algorithm.guiagent;

import C7.c;
import android.os.Bundle;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.api.task.IBundleCallback;
import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b&\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\bJ\u001f\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u00060\u0018j\u0002`\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/stepos/aiengine/algorithm/guiagent/GuiAgentCallback;", "Lcom/stepos/aiengine/api/task/IBundleCallback;", AppAgent.CONSTRUCT, "()V", "", "token", "LC7/r;", "onFirst", "(Ljava/lang/String;)V", "onNext", "fullText", "onDone", "", "code", "message", "onError", "(ILjava/lang/String;)V", "Ljava/util/concurrent/CompletableFuture;", "outputFuture", "()Ljava/util/concurrent/CompletableFuture;", "Landroid/os/Bundle;", "bundle", "onCall", "(Landroid/os/Bundle;)V", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "buffer", "Ljava/lang/StringBuilder;", "", "isFirst", "Z", "future", "Ljava/util/concurrent/CompletableFuture;", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class GuiAgentCallback implements IBundleCallback {
    public static final String KEY_DONE = "ga_done";
    public static final String KEY_ERROR_CODE = "ga_error_code";
    public static final String KEY_EXCEPTION = "ga_exception";
    public static final String KEY_OUTPUT = "ga_output";
    public static final String KEY_TOKEN_NEXT = "ga_token_next";
    private final StringBuilder buffer = new StringBuilder();
    private boolean isFirst = true;
    private final CompletableFuture<String> future = new CompletableFuture<>();

    @Override // com.stepos.aiengine.api.task.IBundleCallback
    public void onCall(Bundle bundle) {
        k.f(bundle, "bundle");
        boolean z10 = bundle.getBoolean(KEY_DONE, false);
        String string = bundle.getString(KEY_EXCEPTION);
        if (string != null) {
            int i = bundle.getInt(KEY_ERROR_CODE, AndroidComposeViewAccessibilityDelegateCompat.ParcelSafeTextLength);
            onError(i, string);
            this.future.completeExceptionally(new RuntimeException(a.c(i, "[", "] ", string)));
        } else {
            if (z10) {
                String string2 = this.buffer.toString();
                k.e(string2, "toString(...)");
                onDone(string2);
                this.future.complete(string2);
                return;
            }
            String string3 = bundle.getString(KEY_TOKEN_NEXT);
            if (string3 == null) {
                return;
            }
            this.buffer.append(string3);
            if (this.isFirst) {
                this.isFirst = false;
                onFirst(string3);
            }
            onNext(string3);
        }
    }

    public void onDone(String fullText) {
        k.f(fullText, "fullText");
    }

    public void onError(int code, String message) {
        k.f(message, "message");
    }

    public void onFirst(String token) {
        k.f(token, "token");
    }

    public abstract void onNext(String token);

    @Override // com.stepos.aiengine.api.task.IBundleCallback
    @c
    public void onResult(Bundle bundle) {
        IBundleCallback.DefaultImpls.onResult(this, bundle);
    }

    public final CompletableFuture<String> outputFuture() {
        return this.future;
    }
}
