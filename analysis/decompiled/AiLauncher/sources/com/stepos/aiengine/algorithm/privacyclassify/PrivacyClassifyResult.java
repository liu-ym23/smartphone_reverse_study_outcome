package com.stepos.aiengine.algorithm.privacyclassify;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b.\b\u0086\b\u0018\u0000 :2\u00020\u0001:\u0001:BK\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0015J\u0010\u0010\u001c\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0015J\u0012\u0010 \u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b \u0010!Jb\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b$\u0010!R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\u0019R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b+\u0010)\u001a\u0004\b,\u0010\u0019R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\u0015R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u0010\u001dR\u0017\u0010\u000b\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b3\u00101\u001a\u0004\b4\u0010\u001dR\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b5\u0010.\u001a\u0004\b6\u0010\u0015R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010!¨\u0006;"}, d2 = {"Lcom/stepos/aiengine/algorithm/privacyclassify/PrivacyClassifyResult;", "", "", "label", "", "score", "threshold", "", "predictedClass", "", "logits", "probs", "classCount", "", "errorMessage", "<init>", "(ZFFI[F[FILjava/lang/String;)V", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "component1", "()Z", "component2", "()F", "component3", "component4", "component5", "()[F", "component6", "component7", "component8", "()Ljava/lang/String;", ChatTracker.CLICK_COPY, "(ZFFI[F[FILjava/lang/String;)Lcom/stepos/aiengine/algorithm/privacyclassify/PrivacyClassifyResult;", "toString", Const.INTENT_KEY_APIKEY, "Z", "getLabel", Const.INTENT_KEY_PKGNAME, "F", "getScore", "c", "getThreshold", Const.INTENT_KEY_UMID, "I", "getPredictedClass", "e", "[F", "getLogits", "f", "getProbs", Const.INTENT_KEY_BACKGROUND_COMMAND, "getClassCount", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Ljava/lang/String;", "getErrorMessage", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class PrivacyClassifyResult {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean label;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final float score;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final float threshold;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final int predictedClass;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final float[] logits;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final float[] probs;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    public final int classCount;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    public final String errorMessage;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/stepos/aiengine/algorithm/privacyclassify/PrivacyClassifyResult$Companion;", "", "<init>", "()V", "error", "Lcom/stepos/aiengine/algorithm/privacyclassify/PrivacyClassifyResult;", "message", "", "threshold", "", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public static /* synthetic */ PrivacyClassifyResult error$default(Companion companion, String str, float f10, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                f10 = 0.8f;
            }
            return companion.error(str, f10);
        }

        public final PrivacyClassifyResult error(String message, float threshold) {
            p.i(message, "message");
            return new PrivacyClassifyResult(false, 0.0f, threshold, 0, new float[0], new float[0], 0, message);
        }

        public Companion() {
        }
    }

    public PrivacyClassifyResult(boolean z10, float f10, float f11, int i10, float[] logits, float[] probs, int i11, String str) {
        p.i(logits, "logits");
        p.i(probs, "probs");
        this.label = z10;
        this.score = f10;
        this.threshold = f11;
        this.predictedClass = i10;
        this.logits = logits;
        this.probs = probs;
        this.classCount = i11;
        this.errorMessage = str;
    }

    public static /* synthetic */ PrivacyClassifyResult copy$default(PrivacyClassifyResult privacyClassifyResult, boolean z10, float f10, float f11, int i10, float[] fArr, float[] fArr2, int i11, String str, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            z10 = privacyClassifyResult.label;
        }
        if ((i12 & 2) != 0) {
            f10 = privacyClassifyResult.score;
        }
        if ((i12 & 4) != 0) {
            f11 = privacyClassifyResult.threshold;
        }
        if ((i12 & 8) != 0) {
            i10 = privacyClassifyResult.predictedClass;
        }
        if ((i12 & 16) != 0) {
            fArr = privacyClassifyResult.logits;
        }
        if ((i12 & 32) != 0) {
            fArr2 = privacyClassifyResult.probs;
        }
        if ((i12 & 64) != 0) {
            i11 = privacyClassifyResult.classCount;
        }
        if ((i12 & 128) != 0) {
            str = privacyClassifyResult.errorMessage;
        }
        int i13 = i11;
        String str2 = str;
        float[] fArr3 = fArr;
        float[] fArr4 = fArr2;
        return privacyClassifyResult.copy(z10, f10, f11, i10, fArr3, fArr4, i13, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLabel() {
        return this.label;
    }

    /* renamed from: component2, reason: from getter */
    public final float getScore() {
        return this.score;
    }

    /* renamed from: component3, reason: from getter */
    public final float getThreshold() {
        return this.threshold;
    }

    /* renamed from: component4, reason: from getter */
    public final int getPredictedClass() {
        return this.predictedClass;
    }

    /* renamed from: component5, reason: from getter */
    public final float[] getLogits() {
        return this.logits;
    }

    /* renamed from: component6, reason: from getter */
    public final float[] getProbs() {
        return this.probs;
    }

    /* renamed from: component7, reason: from getter */
    public final int getClassCount() {
        return this.classCount;
    }

    /* renamed from: component8, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final PrivacyClassifyResult copy(boolean label, float score, float threshold, int predictedClass, float[] logits, float[] probs, int classCount, String errorMessage) {
        p.i(logits, "logits");
        p.i(probs, "probs");
        return new PrivacyClassifyResult(label, score, threshold, predictedClass, logits, probs, classCount, errorMessage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PrivacyClassifyResult)) {
            return false;
        }
        PrivacyClassifyResult privacyClassifyResult = (PrivacyClassifyResult) other;
        return this.label == privacyClassifyResult.label && this.score == privacyClassifyResult.score && this.threshold == privacyClassifyResult.threshold && this.predictedClass == privacyClassifyResult.predictedClass && this.classCount == privacyClassifyResult.classCount && Arrays.equals(this.logits, privacyClassifyResult.logits) && Arrays.equals(this.probs, privacyClassifyResult.probs) && p.d(this.errorMessage, privacyClassifyResult.errorMessage);
    }

    public final int getClassCount() {
        return this.classCount;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final boolean getLabel() {
        return this.label;
    }

    public final float[] getLogits() {
        return this.logits;
    }

    public final int getPredictedClass() {
        return this.predictedClass;
    }

    public final float[] getProbs() {
        return this.probs;
    }

    public final float getScore() {
        return this.score;
    }

    public final float getThreshold() {
        return this.threshold;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((Boolean.hashCode(this.label) * 31) + Float.hashCode(this.score)) * 31) + Float.hashCode(this.threshold)) * 31) + this.predictedClass) * 31) + this.classCount) * 31) + Arrays.hashCode(this.logits)) * 31) + Arrays.hashCode(this.probs)) * 31;
        String str = this.errorMessage;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "PrivacyClassifyResult(label=" + this.label + ", score=" + this.score + ", threshold=" + this.threshold + ", predictedClass=" + this.predictedClass + ", logits=" + Arrays.toString(this.logits) + ", probs=" + Arrays.toString(this.probs) + ", classCount=" + this.classCount + ", errorMessage=" + this.errorMessage + ")";
    }

    public /* synthetic */ PrivacyClassifyResult(boolean z10, float f10, float f11, int i10, float[] fArr, float[] fArr2, int i11, String str, int i12, i iVar) {
        this(z10, f10, f11, i10, fArr, fArr2, i11, (i12 & 128) != 0 ? null : str);
    }
}
