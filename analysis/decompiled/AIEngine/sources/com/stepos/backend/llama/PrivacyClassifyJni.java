package com.stepos.backend.llama;

import h0.e;
import java.util.Arrays;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PrivacyClassifyJni {
    public static final PrivacyClassifyJni INSTANCE = new PrivacyClassifyJni();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Result {
        private final float[] logits;
        private final int nClasses;
        private final int predictedClass;
        private final float[] probs;

        public Result(int i10, float[] logits, float[] probs, int i11) {
            g.f(logits, "logits");
            g.f(probs, "probs");
            this.nClasses = i10;
            this.logits = logits;
            this.probs = probs;
            this.predictedClass = i11;
        }

        public static /* synthetic */ Result copy$default(Result result, int i10, float[] fArr, float[] fArr2, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i10 = result.nClasses;
            }
            if ((i12 & 2) != 0) {
                fArr = result.logits;
            }
            if ((i12 & 4) != 0) {
                fArr2 = result.probs;
            }
            if ((i12 & 8) != 0) {
                i11 = result.predictedClass;
            }
            return result.copy(i10, fArr, fArr2, i11);
        }

        public final int component1() {
            return this.nClasses;
        }

        public final float[] component2() {
            return this.logits;
        }

        public final float[] component3() {
            return this.probs;
        }

        public final int component4() {
            return this.predictedClass;
        }

        public final Result copy(int i10, float[] logits, float[] probs, int i11) {
            g.f(logits, "logits");
            g.f(probs, "probs");
            return new Result(i10, logits, probs, i11);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!Result.class.equals(obj != null ? obj.getClass() : null)) {
                return false;
            }
            g.d(obj, "null cannot be cast to non-null type com.stepos.backend.llama.PrivacyClassifyJni.Result");
            Result result = (Result) obj;
            return this.nClasses == result.nClasses && Arrays.equals(this.logits, result.logits) && Arrays.equals(this.probs, result.probs) && this.predictedClass == result.predictedClass;
        }

        public final float[] getLogits() {
            return this.logits;
        }

        public final int getNClasses() {
            return this.nClasses;
        }

        public final int getPredictedClass() {
            return this.predictedClass;
        }

        public final float[] getProbs() {
            return this.probs;
        }

        public int hashCode() {
            return ((Arrays.hashCode(this.probs) + ((Arrays.hashCode(this.logits) + (this.nClasses * 31)) * 31)) * 31) + this.predictedClass;
        }

        public String toString() {
            int i10 = this.nClasses;
            String string = Arrays.toString(this.logits);
            String string2 = Arrays.toString(this.probs);
            int i11 = this.predictedClass;
            StringBuilder sbE = e.e("Result(nClasses=", i10, ", logits=", string, ", probs=");
            sbE.append(string2);
            sbE.append(", predictedClass=");
            sbE.append(i11);
            sbE.append(")");
            return sbE.toString();
        }
    }

    static {
        System.loadLibrary("llamacpp_privacy_classify");
        System.loadLibrary("privacy_classify_jni");
    }

    private PrivacyClassifyJni() {
    }

    public static final native String nativeClassLabel(long j10, int i10);

    public static final native Result nativeClassify(long j10, String str);

    public static final native long nativeInit(String str, int i10, int i11, int i12, int i13);

    public static final native int nativeNClasses(long j10);

    public static final native void nativeRelease(long j10);
}
