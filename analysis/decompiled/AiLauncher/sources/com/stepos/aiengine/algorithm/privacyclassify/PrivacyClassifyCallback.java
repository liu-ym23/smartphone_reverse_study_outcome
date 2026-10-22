package com.stepos.aiengine.algorithm.privacyclassify;

import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.api.task.IBundleCallback;
import com.stepos.core.error.AIEngineError;
import io.ktor.server.application.debug.DebugPhaseNamesKt;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0003J\u0013\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/stepos/aiengine/algorithm/privacyclassify/PrivacyClassifyCallback;", "Lcom/stepos/aiengine/api/task/IBundleCallback;", "<init>", "()V", "Lcom/stepos/aiengine/algorithm/privacyclassify/PrivacyClassifyResult;", "result", "LY8/t;", "onResult", "(Lcom/stepos/aiengine/algorithm/privacyclassify/PrivacyClassifyResult;)V", "", "code", "", "message", "onError", "(ILjava/lang/String;)V", "onCancelled", "Ljava/util/concurrent/CompletableFuture;", "resultFuture", "()Ljava/util/concurrent/CompletableFuture;", "Landroid/os/Bundle;", "bundle", DebugPhaseNamesKt.PHASE_ON_CALL, "(Landroid/os/Bundle;)V", Const.INTENT_KEY_APIKEY, "Ljava/util/concurrent/CompletableFuture;", "future", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class PrivacyClassifyCallback implements IBundleCallback {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final float DEFAULT_THRESHOLD = 0.8f;
    public static final String KEY_CANCELLED = "pc_cancelled";
    public static final String KEY_CLASS_COUNT = "pc_class_count";
    public static final String KEY_ERROR_CODE = "pc_error_code";
    public static final String KEY_EXCEPTION = "pc_exception";
    public static final String KEY_LABEL = "pc_label";
    public static final String KEY_LOGITS = "pc_logits";
    public static final String KEY_PREDICTED_CLASS = "pc_predicted_class";
    public static final String KEY_PROBS = "pc_probs";
    public static final String KEY_SCORE = "pc_score";
    public static final String KEY_THRESHOLD = "pc_threshold";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final CompletableFuture<PrivacyClassifyResult> future = new CompletableFuture<>();

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/stepos/aiengine/algorithm/privacyclassify/PrivacyClassifyCallback$Companion;", "", "<init>", "()V", "DEFAULT_THRESHOLD", "", "KEY_LABEL", "", "KEY_SCORE", "KEY_THRESHOLD", "KEY_PREDICTED_CLASS", "KEY_LOGITS", "KEY_PROBS", "KEY_CLASS_COUNT", "KEY_CANCELLED", "KEY_EXCEPTION", "KEY_ERROR_CODE", "bundleOf", "Landroid/os/Bundle;", "result", "Lcom/stepos/aiengine/algorithm/privacyclassify/PrivacyClassifyResult;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final Bundle bundleOf(PrivacyClassifyResult result) {
            p.i(result, "result");
            Bundle bundle = new Bundle();
            bundle.putBoolean(PrivacyClassifyCallback.KEY_LABEL, result.getLabel());
            bundle.putFloat(PrivacyClassifyCallback.KEY_SCORE, result.getScore());
            bundle.putFloat(PrivacyClassifyCallback.KEY_THRESHOLD, result.getThreshold());
            bundle.putInt(PrivacyClassifyCallback.KEY_PREDICTED_CLASS, result.getPredictedClass());
            bundle.putFloatArray(PrivacyClassifyCallback.KEY_LOGITS, result.getLogits());
            bundle.putFloatArray(PrivacyClassifyCallback.KEY_PROBS, result.getProbs());
            bundle.putInt(PrivacyClassifyCallback.KEY_CLASS_COUNT, result.getClassCount());
            return bundle;
        }

        public Companion() {
        }
    }

    public static final Bundle bundleOf(PrivacyClassifyResult privacyClassifyResult) {
        return INSTANCE.bundleOf(privacyClassifyResult);
    }

    @Override // com.stepos.aiengine.api.task.IBundleCallback
    public void onCall(Bundle bundle) {
        p.i(bundle, "bundle");
        if (bundle.getBoolean(KEY_CANCELLED, false)) {
            onCancelled();
            this.future.completeExceptionally(new CancellationException("privacy classify cancelled"));
            return;
        }
        String string = bundle.getString("pc_exception");
        if (string != null) {
            int i10 = bundle.getInt("pc_error_code", AIEngineError.UNKNOWN);
            onError(i10, string);
            this.future.completeExceptionally(new PrivacyClassifyInvocationException(i10, string));
            return;
        }
        boolean z10 = bundle.getBoolean(KEY_LABEL, false);
        float f10 = bundle.getFloat(KEY_SCORE, 0.0f);
        float f11 = bundle.getFloat(KEY_THRESHOLD, 0.8f);
        int i11 = bundle.getInt(KEY_PREDICTED_CLASS, 0);
        float[] floatArray = bundle.getFloatArray(KEY_LOGITS);
        if (floatArray == null) {
            floatArray = new float[0];
        }
        float[] fArr = floatArray;
        float[] floatArray2 = bundle.getFloatArray(KEY_PROBS);
        if (floatArray2 == null) {
            floatArray2 = new float[0];
        }
        PrivacyClassifyResult privacyClassifyResult = new PrivacyClassifyResult(z10, f10, f11, i11, fArr, floatArray2, bundle.getInt(KEY_CLASS_COUNT, 0), null);
        onResult(privacyClassifyResult);
        this.future.complete(privacyClassifyResult);
    }

    public void onCancelled() {
    }

    public void onError(int code, String message) {
        p.i(message, "message");
    }

    @Override // com.stepos.aiengine.api.task.IBundleCallback
    public void onResult(Bundle bundle) {
        IBundleCallback.DefaultImpls.onResult(this, bundle);
    }

    public abstract void onResult(PrivacyClassifyResult result);

    public final CompletableFuture<PrivacyClassifyResult> resultFuture() {
        return this.future;
    }
}
