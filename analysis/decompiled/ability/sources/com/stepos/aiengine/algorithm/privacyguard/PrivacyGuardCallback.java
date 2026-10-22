package com.stepos.aiengine.algorithm.privacyguard;

import C7.c;
import android.os.Bundle;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.api.task.IBundleCallback;
import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\bJ\u001f\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/stepos/aiengine/algorithm/privacyguard/PrivacyGuardCallback;", "Lcom/stepos/aiengine/api/task/IBundleCallback;", AppAgent.CONSTRUCT, "()V", "", "token", "LC7/r;", "onFirst", "(Ljava/lang/String;)V", "onNext", "fullText", "onDone", "", "code", "message", "onError", "(ILjava/lang/String;)V", "Ljava/util/concurrent/CompletableFuture;", "outputFuture", "()Ljava/util/concurrent/CompletableFuture;", "Landroid/os/Bundle;", "bundle", "onCall", "(Landroid/os/Bundle;)V", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class PrivacyGuardCallback implements IBundleCallback {
    public static final String KEY_DONE = "pg_done";
    public static final String KEY_ERROR_CODE = "pg_error_code";
    public static final String KEY_EXCEPTION = "pg_exception";
    public static final String KEY_OUTPUT = "pg_output";
    public static final String KEY_TOKEN_NEXT = "pg_token_next";

    /* renamed from: a, reason: collision with root package name */
    public final StringBuilder f3484a = new StringBuilder();
    public boolean b = true;
    public final CompletableFuture c = new CompletableFuture();

    @Override // com.stepos.aiengine.api.task.IBundleCallback
    public void onCall(Bundle bundle) {
        k.f(bundle, "bundle");
        boolean z10 = bundle.getBoolean(KEY_DONE, false);
        String string = bundle.getString(KEY_EXCEPTION);
        CompletableFuture completableFuture = this.c;
        if (string != null) {
            int i = bundle.getInt(KEY_ERROR_CODE, AndroidComposeViewAccessibilityDelegateCompat.ParcelSafeTextLength);
            onError(i, string);
            completableFuture.completeExceptionally(new RuntimeException(a.c(i, "[", "] ", string)));
            return;
        }
        StringBuilder sb = this.f3484a;
        if (z10) {
            String string2 = sb.toString();
            k.e(string2, "toString(...)");
            onDone(string2);
            completableFuture.complete(string2);
            return;
        }
        String string3 = bundle.getString(KEY_TOKEN_NEXT);
        if (string3 == null) {
            return;
        }
        sb.append(string3);
        if (this.b) {
            this.b = false;
            onFirst(string3);
        }
        onNext(string3);
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
        return this.c;
    }
}
