package com.networknt.schema;

import com.networknt.schema.dialect.Dialect;
import com.networknt.schema.dialect.Dialects;

/* loaded from: classes2.dex */
public class Specification {

    /* renamed from: com.networknt.schema.Specification$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$networknt$schema$SpecificationVersion;

        static {
            int[] iArr = new int[SpecificationVersion.values().length];
            $SwitchMap$com$networknt$schema$SpecificationVersion = iArr;
            try {
                iArr[SpecificationVersion.DRAFT_2020_12.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$networknt$schema$SpecificationVersion[SpecificationVersion.DRAFT_2019_09.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$networknt$schema$SpecificationVersion[SpecificationVersion.DRAFT_7.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$networknt$schema$SpecificationVersion[SpecificationVersion.DRAFT_6.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$networknt$schema$SpecificationVersion[SpecificationVersion.DRAFT_4.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static Dialect getDialect(SpecificationVersion specificationVersion) {
        if (specificationVersion == null) {
            return null;
        }
        int i10 = AnonymousClass1.$SwitchMap$com$networknt$schema$SpecificationVersion[specificationVersion.ordinal()];
        if (i10 == 1) {
            return Dialects.getDraft202012();
        }
        if (i10 == 2) {
            return Dialects.getDraft201909();
        }
        if (i10 == 3) {
            return Dialects.getDraft7();
        }
        if (i10 == 4) {
            return Dialects.getDraft6();
        }
        if (i10 != 5) {
            return null;
        }
        return Dialects.getDraft4();
    }

    public static Dialect getDialect(String str) {
        if (str == null) {
            return null;
        }
        str.getClass();
        switch (str) {
        }
        return null;
    }
}
