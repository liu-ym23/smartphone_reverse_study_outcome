package io.modelcontextprotocol.json.schema;

import java.util.Map;
import java.util.Objects;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface JsonSchemaValidator {

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class ValidationResponse extends androidx.activity.b {
        private final String errorMessage;
        private final String jsonStructuredOutput;
        private final boolean valid;

        public ValidationResponse(boolean z10, String str, String str2) {
            this.valid = z10;
            this.errorMessage = str;
            this.jsonStructuredOutput = str2;
        }

        public static ValidationResponse asInvalid(String str) {
            return new ValidationResponse(false, str, null);
        }

        public static ValidationResponse asValid(String str) {
            return new ValidationResponse(true, null, str);
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof ValidationResponse)) {
                return false;
            }
            ValidationResponse validationResponse = (ValidationResponse) obj;
            return this.valid == validationResponse.valid && Objects.equals(this.errorMessage, validationResponse.errorMessage) && Objects.equals(this.jsonStructuredOutput, validationResponse.jsonStructuredOutput);
        }

        public String errorMessage() {
            return this.errorMessage;
        }

        public final int hashCode() {
            boolean z10 = this.valid;
            String str = this.errorMessage;
            String str2 = this.jsonStructuredOutput;
            return Objects.hashCode(str2) + androidx.activity.b.w(Boolean.hashCode(z10) * 31, 31, str);
        }

        public String jsonStructuredOutput() {
            return this.jsonStructuredOutput;
        }

        public final String toString() {
            Object[] objArr = {Boolean.valueOf(this.valid), this.errorMessage, this.jsonStructuredOutput};
            String[] strArrSplit = "valid;errorMessage;jsonStructuredOutput".length() == 0 ? new String[0] : "valid;errorMessage;jsonStructuredOutput".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, ValidationResponse.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        public boolean valid() {
            return this.valid;
        }
    }

    static JsonSchemaValidator createDefault() {
        return JsonSchemaInternal.createDefaultValidator();
    }

    static JsonSchemaValidator getDefault() {
        return JsonSchemaInternal.getDefaultValidator();
    }

    ValidationResponse validate(Map<String, Object> map, Object obj);
}
