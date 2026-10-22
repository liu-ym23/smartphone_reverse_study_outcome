package com.networknt.schema;

import com.networknt.schema.dialect.DialectId;
import java.util.Optional;

/* loaded from: classes2.dex */
public enum SpecificationVersion {
    DRAFT_4(4, DialectId.DRAFT_4),
    DRAFT_6(6, DialectId.DRAFT_6),
    DRAFT_7(7, DialectId.DRAFT_7),
    DRAFT_2019_09(8, DialectId.DRAFT_2019_09),
    DRAFT_2020_12(9, DialectId.DRAFT_2020_12);

    private final String dialectId;
    private final int order;

    SpecificationVersion(int i10, String str) {
        this.order = i10;
        this.dialectId = str;
    }

    public static Optional<SpecificationVersion> fromDialectId(String str) {
        for (SpecificationVersion specificationVersion : values()) {
            if (specificationVersion.dialectId.equals(str)) {
                return Optional.of(specificationVersion);
            }
        }
        return Optional.empty();
    }

    public String getDialectId() {
        return this.dialectId;
    }

    public int getOrder() {
        return this.order;
    }
}
