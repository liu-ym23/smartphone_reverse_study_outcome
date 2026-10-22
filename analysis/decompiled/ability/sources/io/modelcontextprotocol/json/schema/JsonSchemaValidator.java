package io.modelcontextprotocol.json.schema;

import java.util.Map;
import java.util.Objects;

/* loaded from: classes2.dex */
public interface JsonSchemaValidator {

    public static final class ValidationResponse extends B7.a {
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
            return Objects.hashCode(str2) + com.stepos.statsrpk.service.c.a(Boolean.hashCode(z10) * 31, 31, str);
        }

        public String jsonStructuredOutput() {
            return this.jsonStructuredOutput;
        }

        public final String toString() {
            Object[] objArr = {Boolean.valueOf(this.valid), this.errorMessage, this.jsonStructuredOutput};
            String[] strArrSplit = "valid;errorMessage;jsonStructuredOutput".length() == 0 ? new String[0] : "valid;errorMessage;jsonStructuredOutput".split(";");
            StringBuilder sb = new StringBuilder();
            com.stepos.statsrpk.service.c.q(sb, ValidationResponse.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb.append(strArrSplit[i]);
                sb.append("=");
                sb.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
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
