package com.networknt.schema;

/* loaded from: classes3.dex */
public enum SpecificationVersion {
    DRAFT_4(4, "http://json-schema.org/draft-04/schema#"),
    DRAFT_6(6, "http://json-schema.org/draft-06/schema#"),
    DRAFT_7(7, "http://json-schema.org/draft-07/schema#"),
    DRAFT_2019_09(8, "https://json-schema.org/draft/2019-09/schema"),
    DRAFT_2020_12(9, "https://json-schema.org/draft/2020-12/schema");


    /* renamed from: a, reason: collision with root package name */
    public final int f3013a;
    public final String b;

    SpecificationVersion(int i, String str) {
        this.f3013a = i;
        this.b = str;
    }
}
