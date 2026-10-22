package com.stepos.core.ota.install;

import ai.onnxruntime.a;
import android.content.Context;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import h0.e;
import java.util.List;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelWarmupValidator {
    public static final ModelWarmupValidator INSTANCE = new ModelWarmupValidator();
    private static final String TAG = "ModelWarmupValidator";

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class TestCase {
        private final String expectedKeyword;
        private final String input;

        public TestCase(String input, String expectedKeyword) {
            g.f(input, "input");
            g.f(expectedKeyword, "expectedKeyword");
            this.input = input;
            this.expectedKeyword = expectedKeyword;
        }

        public static /* synthetic */ TestCase copy$default(TestCase testCase, String str, String str2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = testCase.input;
            }
            if ((i10 & 2) != 0) {
                str2 = testCase.expectedKeyword;
            }
            return testCase.copy(str, str2);
        }

        public final String component1() {
            return this.input;
        }

        public final String component2() {
            return this.expectedKeyword;
        }

        public final TestCase copy(String input, String expectedKeyword) {
            g.f(input, "input");
            g.f(expectedKeyword, "expectedKeyword");
            return new TestCase(input, expectedKeyword);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TestCase)) {
                return false;
            }
            TestCase testCase = (TestCase) obj;
            return g.b(this.input, testCase.input) && g.b(this.expectedKeyword, testCase.expectedKeyword);
        }

        public final String getExpectedKeyword() {
            return this.expectedKeyword;
        }

        public final String getInput() {
            return this.input;
        }

        public int hashCode() {
            return this.expectedKeyword.hashCode() + (this.input.hashCode() * 31);
        }

        public String toString() {
            return e.c("TestCase(input=", this.input, ", expectedKeyword=", this.expectedKeyword, ")");
        }
    }

    private ModelWarmupValidator() {
    }

    public final boolean validate(Context context, String algorithmId, List<TestCase> testCases) {
        g.f(context, "context");
        g.f(algorithmId, "algorithmId");
        g.f(testCases, "testCases");
        if (testCases.isEmpty()) {
            return true;
        }
        AIEngineLogger.d(LogModule.OTA, TAG, a.i("validate: algorithmId=", testCases.size(), algorithmId, " cases=", " (TODO)"));
        return true;
    }
}
