package stepos.com.android.os;

import com.google.protobuf.Internal;

/* loaded from: classes.dex */
public enum RestrictionCategory implements Internal.EnumLite {
    RESTRICTION_UNSET(0),
    RESTRICTION_DIAGNOSTIC(1),
    RESTRICTION_SYSTEM_INTELLIGENCE(2),
    RESTRICTION_AUTHENTICATION(3),
    RESTRICTION_FRAUD_AND_ABUSE(4);

    public static final int RESTRICTION_AUTHENTICATION_VALUE = 3;
    public static final int RESTRICTION_DIAGNOSTIC_VALUE = 1;
    public static final int RESTRICTION_FRAUD_AND_ABUSE_VALUE = 4;
    public static final int RESTRICTION_SYSTEM_INTELLIGENCE_VALUE = 2;
    public static final int RESTRICTION_UNSET_VALUE = 0;
    private static final Internal.EnumLiteMap<RestrictionCategory> internalValueMap = new Internal.EnumLiteMap<RestrictionCategory>() { // from class: stepos.com.android.os.RestrictionCategory.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public RestrictionCategory findValueByNumber(int i) {
            return RestrictionCategory.forNumber(i);
        }
    };
    private final int value;

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static RestrictionCategory valueOf(int i) {
        return forNumber(i);
    }

    public static RestrictionCategory forNumber(int i) {
        if (i == 0) {
            return RESTRICTION_UNSET;
        }
        if (i == 1) {
            return RESTRICTION_DIAGNOSTIC;
        }
        if (i == 2) {
            return RESTRICTION_SYSTEM_INTELLIGENCE;
        }
        if (i == 3) {
            return RESTRICTION_AUTHENTICATION;
        }
        if (i != 4) {
            return null;
        }
        return RESTRICTION_FRAUD_AND_ABUSE;
    }

    public static Internal.EnumLiteMap<RestrictionCategory> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return RestrictionCategoryVerifier.INSTANCE;
    }

    private static final class RestrictionCategoryVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new RestrictionCategoryVerifier();

        private RestrictionCategoryVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return RestrictionCategory.forNumber(i) != null;
        }
    }

    RestrictionCategory(int i) {
        this.value = i;
    }
}
