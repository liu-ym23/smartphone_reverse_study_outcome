package com.stepos.motionkit.fx.shader;

import D7.v;
import android.graphics.RuntimeShader;
import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import com.stepos.motionkit.ErrorLevel;
import com.stepos.motionkit.MotionKit;
import com.stepos.motionkit.MotionKitError;
import j9.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\n"}, d2 = {"Lcom/stepos/motionkit/fx/shader/ShaderValidator;", "", AppAgent.CONSTRUCT, "()V", "validate", "Lcom/stepos/motionkit/fx/shader/ShaderValidator$ValidationResult;", AgentBusWakeContract.EXTRA_SOURCE, "", "validateGlsl", "ValidationResult", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ShaderValidator {
    public final ValidationResult validate(String source) {
        k.f(source, "source");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (m.s0(source)) {
            arrayList.add("Shader source is empty");
            return new ValidationResult(false, arrayList, null, 4, null);
        }
        if (!m.h0(source, "main(", false)) {
            arrayList.add("Missing main() function");
        }
        if (!m.h0(source, "half4", false) && !m.h0(source, "vec4", false)) {
            arrayList2.add("No half4/vec4 return type found — may not produce visible output");
        }
        if (!m.h0(source, "uniform float2 iResolution", false) && !m.h0(source, "uniform vec2 iResolution", false)) {
            arrayList2.add("No iResolution uniform — shader won't know viewport size");
        }
        if (arrayList.isEmpty()) {
            try {
                new RuntimeShader(source);
            } catch (Exception e) {
                arrayList.add("Compilation failed: " + e.getMessage());
            }
        }
        ValidationResult validationResult = new ValidationResult(arrayList.isEmpty(), arrayList, arrayList2);
        if (!validationResult.isValid()) {
            MotionKit.INSTANCE.handleError(new MotionKitError(ErrorLevel.WARNING, a.j(v.A0(arrayList), "Shader validation failed: "), null, 4, null));
        }
        return validationResult;
    }

    public final ValidationResult validateGlsl(String source) {
        k.f(source, "source");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (m.s0(source)) {
            arrayList.add("GLSL source is empty");
            return new ValidationResult(false, arrayList, null, 4, null);
        }
        if (!m.h0(source, "#version", false)) {
            arrayList2.add("Missing #version directive — defaulting to ES 3.0");
        }
        if (!m.h0(source, "void main()", false) && !m.h0(source, "void main(void)", false)) {
            arrayList.add("Missing main() function");
        }
        if (!m.h0(source, "out ", false) && !m.h0(source, "gl_FragColor", false)) {
            arrayList2.add("No output variable declared");
        }
        return new ValidationResult(arrayList.isEmpty(), arrayList, arrayList2);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/stepos/motionkit/fx/shader/ShaderValidator$ValidationResult;", "", "isValid", "", "errors", "", "", "warnings", AppAgent.CONSTRUCT, "(ZLjava/util/List;Ljava/util/List;)V", "()Z", "getErrors", "()Ljava/util/List;", "getWarnings", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class ValidationResult {
        private final List<String> errors;
        private final boolean isValid;
        private final List<String> warnings;

        public ValidationResult(boolean z10, List<String> errors, List<String> warnings) {
            k.f(errors, "errors");
            k.f(warnings, "warnings");
            this.isValid = z10;
            this.errors = errors;
            this.warnings = warnings;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ValidationResult copy$default(ValidationResult validationResult, boolean z10, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                z10 = validationResult.isValid;
            }
            if ((i & 2) != 0) {
                list = validationResult.errors;
            }
            if ((i & 4) != 0) {
                list2 = validationResult.warnings;
            }
            return validationResult.copy(z10, list, list2);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsValid() {
            return this.isValid;
        }

        public final List<String> component2() {
            return this.errors;
        }

        public final List<String> component3() {
            return this.warnings;
        }

        public final ValidationResult copy(boolean isValid, List<String> errors, List<String> warnings) {
            k.f(errors, "errors");
            k.f(warnings, "warnings");
            return new ValidationResult(isValid, errors, warnings);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ValidationResult)) {
                return false;
            }
            ValidationResult validationResult = (ValidationResult) other;
            return this.isValid == validationResult.isValid && k.b(this.errors, validationResult.errors) && k.b(this.warnings, validationResult.warnings);
        }

        public final List<String> getErrors() {
            return this.errors;
        }

        public final List<String> getWarnings() {
            return this.warnings;
        }

        public int hashCode() {
            return this.warnings.hashCode() + a.e(this.errors, Boolean.hashCode(this.isValid) * 31, 31);
        }

        public final boolean isValid() {
            return this.isValid;
        }

        public String toString() {
            boolean z10 = this.isValid;
            List<String> list = this.errors;
            List<String> list2 = this.warnings;
            StringBuilder sb = new StringBuilder("ValidationResult(isValid=");
            sb.append(z10);
            sb.append(", errors=");
            sb.append(list);
            sb.append(", warnings=");
            return a.q(sb, list2, ")");
        }

        public ValidationResult(boolean z10, List list, List list2, int i, e eVar) {
            this(z10, (i & 2) != 0 ? EmptyList.f4893a : list, (i & 4) != 0 ? EmptyList.f4893a : list2);
        }
    }
}
