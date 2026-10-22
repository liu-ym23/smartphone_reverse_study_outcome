package com.networknt.schema.keyword;

import java.util.Objects;

/* loaded from: classes2.dex */
public abstract class AbstractKeyword implements Keyword {
    private final String value;

    public AbstractKeyword(String str) {
        this.value = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return Objects.equals(this.value, ((AbstractKeyword) obj).value);
        }
        return false;
    }

    @Override // com.networknt.schema.keyword.Keyword
    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        return Objects.hash(this.value);
    }

    public String toString() {
        return getValue();
    }
}
