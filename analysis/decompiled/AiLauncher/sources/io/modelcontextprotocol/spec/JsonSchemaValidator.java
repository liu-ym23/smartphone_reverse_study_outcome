package io.modelcontextprotocol.spec;

import io.modelcontextprotocol.client.b1;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes4.dex */
public interface JsonSchemaValidator {

    public static final class ValidationResponse extends W8.a {
        private final String errorMessage;
        private final String jsonStructuredOutput;
        private final boolean valid;

        public ValidationResponse(boolean z10, String str, String str2) {
            this.valid = z10;
            this.errorMessage = str;
            this.jsonStructuredOutput = str2;
        }

        private /* synthetic */ boolean a(Object obj) {
            if (!(obj instanceof ValidationResponse)) {
                return false;
            }
            ValidationResponse validationResponse = (ValidationResponse) obj;
            return this.valid == validationResponse.valid && Objects.equals(this.errorMessage, validationResponse.errorMessage) && Objects.equals(this.jsonStructuredOutput, validationResponse.jsonStructuredOutput);
        }

        public static ValidationResponse asInvalid(String str) {
            return new ValidationResponse(false, str, null);
        }

        public static ValidationResponse asValid(String str) {
            return new ValidationResponse(true, null, str);
        }

        private /* synthetic */ Object[] b() {
            return new Object[]{Boolean.valueOf(this.valid), this.errorMessage, this.jsonStructuredOutput};
        }

        public final boolean equals(Object obj) {
            return a(obj);
        }

        public String errorMessage() {
            return this.errorMessage;
        }

        public final int hashCode() {
            return io.modelcontextprotocol.json.schema.e.a(this.valid, this.errorMessage, this.jsonStructuredOutput);
        }

        public String jsonStructuredOutput() {
            return this.jsonStructuredOutput;
        }

        public final String toString() {
            return b1.a(b(), ValidationResponse.class, "valid;errorMessage;jsonStructuredOutput");
        }

        public boolean valid() {
            return this.valid;
        }
    }

    ValidationResponse validate(Map<String, Object> map, Object obj);
}
