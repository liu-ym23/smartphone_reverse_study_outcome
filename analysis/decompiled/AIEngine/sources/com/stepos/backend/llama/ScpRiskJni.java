package com.stepos.backend.llama;

import java.util.Arrays;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ScpRiskJni {
    public static final ScpRiskJni INSTANCE = new ScpRiskJni();
    private static final UnsatisfiedLinkError loadFailure;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Result {
        private final float[] blockProbabilities;
        private final String[] categories;
        private final float[] passProbabilities;

        public Result(String[] categories, float[] passProbabilities, float[] blockProbabilities) {
            g.f(categories, "categories");
            g.f(passProbabilities, "passProbabilities");
            g.f(blockProbabilities, "blockProbabilities");
            this.categories = categories;
            this.passProbabilities = passProbabilities;
            this.blockProbabilities = blockProbabilities;
        }

        public static /* synthetic */ Result copy$default(Result result, String[] strArr, float[] fArr, float[] fArr2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                strArr = result.categories;
            }
            if ((i10 & 2) != 0) {
                fArr = result.passProbabilities;
            }
            if ((i10 & 4) != 0) {
                fArr2 = result.blockProbabilities;
            }
            return result.copy(strArr, fArr, fArr2);
        }

        public final String[] component1() {
            return this.categories;
        }

        public final float[] component2() {
            return this.passProbabilities;
        }

        public final float[] component3() {
            return this.blockProbabilities;
        }

        public final Result copy(String[] categories, float[] passProbabilities, float[] blockProbabilities) {
            g.f(categories, "categories");
            g.f(passProbabilities, "passProbabilities");
            g.f(blockProbabilities, "blockProbabilities");
            return new Result(categories, passProbabilities, blockProbabilities);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Result)) {
                return false;
            }
            Result result = (Result) obj;
            return g.b(this.categories, result.categories) && g.b(this.passProbabilities, result.passProbabilities) && g.b(this.blockProbabilities, result.blockProbabilities);
        }

        public final float[] getBlockProbabilities() {
            return this.blockProbabilities;
        }

        public final String[] getCategories() {
            return this.categories;
        }

        public final float[] getPassProbabilities() {
            return this.passProbabilities;
        }

        public int hashCode() {
            return Arrays.hashCode(this.blockProbabilities) + ((Arrays.hashCode(this.passProbabilities) + (Arrays.hashCode(this.categories) * 31)) * 31);
        }

        public String toString() {
            String string = Arrays.toString(this.categories);
            String string2 = Arrays.toString(this.passProbabilities);
            return ai.onnxruntime.a.o(ai.onnxruntime.a.s("Result(categories=", string, ", passProbabilities=", string2, ", blockProbabilities="), Arrays.toString(this.blockProbabilities), ")");
        }
    }

    static {
        try {
            System.loadLibrary("scp_risk");
            System.loadLibrary("scp_risk_jni");
            e = null;
        } catch (UnsatisfiedLinkError e10) {
            e = e10;
        }
        loadFailure = e;
    }

    private ScpRiskJni() {
    }

    public static final native Result nativeClassify(long j10, String str);

    public static final native String nativeGetVersion();

    public static final native long nativeInit(String str, int i10);

    public static final native int nativeNumCategories(long j10);

    public static final native void nativeRelease(long j10);

    public final String getUnavailableReason() {
        UnsatisfiedLinkError unsatisfiedLinkError = loadFailure;
        if (unsatisfiedLinkError != null) {
            return unsatisfiedLinkError.getMessage();
        }
        return null;
    }

    public final boolean isAvailable() {
        return loadFailure == null;
    }

    public final void requireAvailable() {
        UnsatisfiedLinkError unsatisfiedLinkError = loadFailure;
        if (unsatisfiedLinkError != null) {
            throw new IllegalStateException(ai.onnxruntime.a.k("SCP risk native backend unavailable: ", unsatisfiedLinkError.getMessage()), unsatisfiedLinkError);
        }
    }
}
