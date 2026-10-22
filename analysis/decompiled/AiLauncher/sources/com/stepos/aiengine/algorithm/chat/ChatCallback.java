package com.stepos.aiengine.algorithm.chat;

import M5.b;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.api.task.IBundleCallback;
import com.stepos.core.error.AIEngineError;
import io.ktor.server.application.debug.DebugPhaseNamesKt;
import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b&\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\bJ\u001f\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u00060\u0018j\u0002`\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/stepos/aiengine/algorithm/chat/ChatCallback;", "Lcom/stepos/aiengine/api/task/IBundleCallback;", "<init>", "()V", "", b.CREDENTIAL_TOKEN, "LY8/t;", "onFirst", "(Ljava/lang/String;)V", "onNext", "fullText", "onDone", "", "code", "message", "onError", "(ILjava/lang/String;)V", "Ljava/util/concurrent/CompletableFuture;", "outputFuture", "()Ljava/util/concurrent/CompletableFuture;", "Landroid/os/Bundle;", "bundle", DebugPhaseNamesKt.PHASE_ON_CALL, "(Landroid/os/Bundle;)V", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", Const.INTENT_KEY_APIKEY, "Ljava/lang/StringBuilder;", "buffer", "", Const.INTENT_KEY_PKGNAME, "Z", "isFirst", "c", "Ljava/util/concurrent/CompletableFuture;", "future", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ChatCallback implements IBundleCallback {
    public static final String KEY_ERROR_CODE = "error_code";
    public static final String KEY_EXCEPTION = "exception";
    public static final String KEY_SESSION_DONE = "session_done";
    public static final String KEY_SESSION_OUTPUT = "session_output";
    public static final String KEY_TOKEN_GENERATE_LEN = "token_generate_len";
    public static final String KEY_TOKEN_NEXT = "token_next";
    public static final String KEY_TOKEN_PROMPT_LEN = "token_prompt_len";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final StringBuilder buffer = new StringBuilder();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public boolean isFirst = true;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final CompletableFuture<String> future = new CompletableFuture<>();

    @Override // com.stepos.aiengine.api.task.IBundleCallback
    public void onCall(Bundle bundle) {
        p.i(bundle, "bundle");
        boolean z10 = bundle.getBoolean(KEY_SESSION_DONE, false);
        String string = bundle.getString("exception");
        if (string != null) {
            int i10 = bundle.getInt("error_code", AIEngineError.UNKNOWN);
            onError(i10, string);
            this.future.completeExceptionally(new RuntimeException("[" + i10 + "] " + string));
            return;
        }
        if (z10) {
            String string2 = this.buffer.toString();
            p.h(string2, "toString(...)");
            onDone(string2);
            this.future.complete(string2);
            return;
        }
        String string3 = bundle.getString("token_next");
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

    public void onDone(String fullText) {
        p.i(fullText, "fullText");
    }

    public void onError(int code, String message) {
        p.i(message, "message");
    }

    public void onFirst(String token) {
        p.i(token, "token");
    }

    public abstract void onNext(String token);

    @Override // com.stepos.aiengine.api.task.IBundleCallback
    public void onResult(Bundle bundle) {
        IBundleCallback.DefaultImpls.onResult(this, bundle);
    }

    public final CompletableFuture<String> outputFuture() {
        return this.future;
    }
}
