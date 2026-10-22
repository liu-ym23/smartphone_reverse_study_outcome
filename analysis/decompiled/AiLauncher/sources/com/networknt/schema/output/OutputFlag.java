package com.networknt.schema.output;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.networknt.schema.serialization.JsonMapperFactory;
import java.util.Objects;

/* loaded from: classes2.dex */
public class OutputFlag {
    private final boolean valid;

    public OutputFlag(boolean z10) {
        this.valid = z10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.valid == ((OutputFlag) obj).valid;
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(this.valid));
    }

    public boolean isValid() {
        return this.valid;
    }

    public String toString() {
        try {
            return JsonMapperFactory.getInstance().writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (JsonProcessingException unused) {
            return "OutputFlag [valid=" + this.valid + "]";
        }
    }
}
