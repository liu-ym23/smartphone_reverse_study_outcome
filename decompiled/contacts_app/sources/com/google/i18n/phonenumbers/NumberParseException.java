package com.google.i18n.phonenumbers;

/* JADX INFO: loaded from: classes2.dex */
public class NumberParseException extends Exception {
    private ErrorType errorType;
    private String message;

    public static final enum ErrorType extends Enum<ErrorType> {
        private static final /* synthetic */ ErrorType[] $VALUES = null;
        public static final ErrorType INVALID_COUNTRY_CODE = null;
        public static final ErrorType NOT_A_NUMBER = null;
        public static final ErrorType TOO_LONG = null;
        public static final ErrorType TOO_SHORT_AFTER_IDD = null;
        public static final ErrorType TOO_SHORT_NSN = null;

        private ErrorType(String r1, int r2) {
            super(r1, r2);
        }

        public static ErrorType valueOf(String r1) {
            return (ErrorType) Enum.valueOf(ErrorType.class, r1);
        }

        public static ErrorType[] values() {
            return (ErrorType[]) $VALUES.clone();
        }

        static {
            ErrorType r0 = new ErrorType("INVALID_COUNTRY_CODE", 0);
            INVALID_COUNTRY_CODE = r0;
            ErrorType r1 = new ErrorType("NOT_A_NUMBER", 1);
            NOT_A_NUMBER = r1;
            ErrorType r3 = new ErrorType("TOO_SHORT_AFTER_IDD", 2);
            TOO_SHORT_AFTER_IDD = r3;
            ErrorType r5 = new ErrorType("TOO_SHORT_NSN", 3);
            TOO_SHORT_NSN = r5;
            ErrorType r7 = new ErrorType("TOO_LONG", 4);
            TOO_LONG = r7;
            $VALUES = new ErrorType[]{r0, r1, r3, r5, r7};
        }
    }

    public NumberParseException(ErrorType r1, String r2) {
        super(r2);
        this.message = r2;
        this.errorType = r1;
    }

    public ErrorType getErrorType() {
        return this.errorType;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "Error type: " + this.errorType + ". " + this.message;
    }
}
