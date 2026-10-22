package com.android.ttcjpaysdk.thirdparty.verify;

import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayVerifyConstant {
    public static final int SHOW_NO_PWD_HALF_SCREEN_PAGE = 2;
    public static final int SKIP_NO_PWD_DIALOG = 1;
    public static final int SKIP_NO_PWD_HALF_SCREEN_PAGE = 1;

    public static final enum OneStepPayMethods extends Enum<OneStepPayMethods> {
        private static final /* synthetic */ OneStepPayMethods[] $VALUES = null;
        public static final OneStepPayMethods BACK_TOP_RIGHT_BUTTON = null;
        public static final OneStepPayMethods DEFAULT = null;
        public static final OneStepPayMethods DIRECT_PAY = null;
        public static final OneStepPayMethods NEW_DIALOG = null;
        public static final OneStepPayMethods NEW_HALF_PAGE = null;
        public static final OneStepPayMethods OLD_DIALOG = null;
        public static final OneStepPayMethods OLD_HALF_PAGE = null;
        public static final OneStepPayMethods PAY_AGAIN_SKIP_CONFIRM = null;
        public int type;

        private static /* synthetic */ OneStepPayMethods[] $values() {
            return new OneStepPayMethods[]{DEFAULT, DIRECT_PAY, OLD_DIALOG, NEW_DIALOG, OLD_HALF_PAGE, NEW_HALF_PAGE, PAY_AGAIN_SKIP_CONFIRM, BACK_TOP_RIGHT_BUTTON};
        }

        static {
            DEFAULT = new OneStepPayMethods("DEFAULT", 0, 0);
            DIRECT_PAY = new OneStepPayMethods("DIRECT_PAY", 1, 0);
            OLD_DIALOG = new OneStepPayMethods("OLD_DIALOG", 2, 1);
            NEW_DIALOG = new OneStepPayMethods("NEW_DIALOG", 3, 2);
            OLD_HALF_PAGE = new OneStepPayMethods("OLD_HALF_PAGE", 4, 3);
            NEW_HALF_PAGE = new OneStepPayMethods("NEW_HALF_PAGE", 5, 4);
            PAY_AGAIN_SKIP_CONFIRM = new OneStepPayMethods("PAY_AGAIN_SKIP_CONFIRM", 6, 5);
            BACK_TOP_RIGHT_BUTTON = new OneStepPayMethods("BACK_TOP_RIGHT_BUTTON", 7, 6);
            $VALUES = $values();
        }

        public static OneStepPayMethods[] values() {
            return (OneStepPayMethods[]) $VALUES.clone();
        }

        public static OneStepPayMethods valueOf(String r100) {
            return (OneStepPayMethods) a.a(OneStepPayMethods.class, r100);
        }

        private OneStepPayMethods(String r100, int r101, int r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    public CJPayVerifyConstant() {
    }
}
