package com.android.ttcjpaysdk.integrated.counter.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
public class UserInfo implements Serializable, CJPayObject {
    public static final String CVV_CHECK = "7";
    public static final String MEMBER_CHECK = "8";
    public static final String PWD_CHECK_CARRIER = "13";
    public static final String PWD_CHECK_FACE = "11";
    public static final String PWD_CHECK_FINGERPRINT = "1";
    public static final String PWD_CHECK_NOTHING = "5";
    public static final String PWD_CHECK_PWD = "0";
    public static final String PWD_CHECK_TOKEN = "6";
    public static final String PWD_NOT_CHECK_PWD = "3";
    public String add_pwd_url;
    public String auth_status;
    public String auth_url;
    public long balance_amount;
    public String bind_url;
    public String certificate_num;
    public String certificate_type;
    public String declive_url;
    public String find_pwd_url;
    public boolean is_new_user;
    public String jruid;
    public String m_name;
    public String mid;
    public String mobile;
    public int pay_id_state;
    public String pay_uid;
    public String pwd_check_way;
    public String pwd_status;
    public String real_check_type;
    public String real_check_type_supplementary;
    public String uid;
    public int uid_type;

    public static final enum PayIdState extends Enum<PayIdState> {
        private static final /* synthetic */ PayIdState[] $VALUES = null;
        public static final PayIdState PAY_ID_STATE_FOUR = null;
        public static final PayIdState PAY_ID_STATE_ONE = null;
        public static final PayIdState PAY_ID_STATE_THREE = null;
        public static final PayIdState PAY_ID_STATE_TWO = null;
        public static final PayIdState PAY_ID_STATE_UNKNOWN = null;

        private static /* synthetic */ PayIdState[] $values() {
            return new PayIdState[]{PAY_ID_STATE_UNKNOWN, PAY_ID_STATE_ONE, PAY_ID_STATE_TWO, PAY_ID_STATE_THREE, PAY_ID_STATE_FOUR};
        }

        static {
            PAY_ID_STATE_UNKNOWN = new PayIdState("PAY_ID_STATE_UNKNOWN", 0);
            PAY_ID_STATE_ONE = new PayIdState("PAY_ID_STATE_ONE", 1);
            PAY_ID_STATE_TWO = new PayIdState("PAY_ID_STATE_TWO", 2);
            PAY_ID_STATE_THREE = new PayIdState("PAY_ID_STATE_THREE", 3);
            PAY_ID_STATE_FOUR = new PayIdState("PAY_ID_STATE_FOUR", 4);
            $VALUES = $values();
        }

        public static PayIdState[] values() {
            return (PayIdState[]) $VALUES.clone();
        }

        public static PayIdState valueOf(String r100) {
            return (PayIdState) a.a(PayIdState.class, r100);
        }

        private PayIdState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum PwdCheckWay extends Enum<PwdCheckWay> {
        private static final /* synthetic */ PwdCheckWay[] $VALUES = null;
        public static final PwdCheckWay PWD_CHECK_FACE = null;
        public static final PwdCheckWay PWD_CHECK_FINGER = null;
        public static final PwdCheckWay PWD_CHECK_PWD = null;
        public static final PwdCheckWay PWD_NOT_CHECK_PWD = null;

        private static /* synthetic */ PwdCheckWay[] $values() {
            return new PwdCheckWay[]{PWD_CHECK_PWD, PWD_CHECK_FINGER, PWD_CHECK_FACE, PWD_NOT_CHECK_PWD};
        }

        static {
            PWD_CHECK_PWD = new PwdCheckWay("PWD_CHECK_PWD", 0);
            PWD_CHECK_FINGER = new PwdCheckWay("PWD_CHECK_FINGER", 1);
            PWD_CHECK_FACE = new PwdCheckWay("PWD_CHECK_FACE", 2);
            PWD_NOT_CHECK_PWD = new PwdCheckWay("PWD_NOT_CHECK_PWD", 3);
            $VALUES = $values();
        }

        public static PwdCheckWay[] values() {
            return (PwdCheckWay[]) $VALUES.clone();
        }

        public static PwdCheckWay valueOf(String r100) {
            return (PwdCheckWay) a.a(PwdCheckWay.class, r100);
        }

        private PwdCheckWay(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum PwdStatus extends Enum<PwdStatus> {
        private static final /* synthetic */ PwdStatus[] $VALUES = null;
        public static final PwdStatus PWD_STATUS_LOCKED = null;
        public static final PwdStatus PWD_STATUS_NEGATIVE = null;
        public static final PwdStatus PWD_STATUS_POSITIVE = null;
        public static final PwdStatus PWD_STATUS_UNKNOWN = null;

        private static /* synthetic */ PwdStatus[] $values() {
            return new PwdStatus[]{PWD_STATUS_UNKNOWN, PWD_STATUS_NEGATIVE, PWD_STATUS_POSITIVE, PWD_STATUS_LOCKED};
        }

        static {
            PWD_STATUS_UNKNOWN = new PwdStatus("PWD_STATUS_UNKNOWN", 0);
            PWD_STATUS_NEGATIVE = new PwdStatus("PWD_STATUS_NEGATIVE", 1);
            PWD_STATUS_POSITIVE = new PwdStatus("PWD_STATUS_POSITIVE", 2);
            PWD_STATUS_LOCKED = new PwdStatus("PWD_STATUS_LOCKED", 3);
            $VALUES = $values();
        }

        public static PwdStatus[] values() {
            return (PwdStatus[]) $VALUES.clone();
        }

        public static PwdStatus valueOf(String r100) {
            return (PwdStatus) a.a(PwdStatus.class, r100);
        }

        private PwdStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    public PayIdState getPayIdState() {
        int r100 = this.pay_id_state;
        if (r100 == 1) goto L19;
        if (r100 == 2) goto L17;
        if (r100 == 3) goto L15;
        if (r100 == 4) goto L13;
        return PayIdState.PAY_ID_STATE_UNKNOWN;
    L13:
        return PayIdState.PAY_ID_STATE_FOUR;
    L15:
        return PayIdState.PAY_ID_STATE_THREE;
    L17:
        return PayIdState.PAY_ID_STATE_TWO;
    L19:
        return PayIdState.PAY_ID_STATE_ONE;
    }

    public PwdCheckWay getPwdCheckWay() {
        String r100 = this.pwd_check_way;
        r100.getClass();
        byte r101 = -1;
        switch(r100.hashCode()) {
            case 49: goto L14;
            case 50: goto L10;
            case 51: goto L6;
            default: goto L17;
        };
    L17:
        switch(r101) {
            case 0: goto L25;
            case 1: goto L23;
            case 2: goto L21;
            default: goto L19;
        };
    L19:
        return PwdCheckWay.PWD_CHECK_PWD;
    L21:
        return PwdCheckWay.PWD_NOT_CHECK_PWD;
    L23:
        return PwdCheckWay.PWD_CHECK_FACE;
    L25:
        return PwdCheckWay.PWD_CHECK_FINGER;
    L6:
        if (r100.equals("3") == false) goto L17;
        r101 = 2;
        goto L17
    L10:
        if (r100.equals("2") == false) goto L17;
        r101 = 1;
        goto L17
    L14:
        if (r100.equals("1") == false) goto L17;
        r101 = 0;
        goto L17
    }

    public PwdStatus getPwdStatus() {
        String r100 = this.pwd_status;
        r100.getClass();
        byte r101 = -1;
        switch(r100.hashCode()) {
            case 48: goto L14;
            case 49: goto L10;
            case 50: goto L6;
            default: goto L17;
        };
    L17:
        switch(r101) {
            case 0: goto L25;
            case 1: goto L23;
            case 2: goto L21;
            default: goto L19;
        };
    L19:
        return PwdStatus.PWD_STATUS_UNKNOWN;
    L21:
        return PwdStatus.PWD_STATUS_LOCKED;
    L23:
        return PwdStatus.PWD_STATUS_POSITIVE;
    L25:
        return PwdStatus.PWD_STATUS_NEGATIVE;
    L6:
        if (r100.equals("2") == false) goto L17;
        r101 = 2;
        goto L17
    L10:
        if (r100.equals("1") == false) goto L17;
        r101 = 1;
        goto L17
    L14:
        if (r100.equals("0") == false) goto L17;
        r101 = 0;
        goto L17
    }

    public boolean isNeedAddPwd() {
        if (TextUtils.equals(this.auth_status, "1") == true) goto L5;
    L9:
        return false;
    L5:
        if (TextUtils.equals(this.pwd_status, "0") == false) goto L9;
        if (TextUtils.isEmpty(this.add_pwd_url) == true) goto L9;
        return true;
    }

    public UserInfo() {
        this.auth_status = "";
        this.auth_url = "";
        this.certificate_num = "";
        this.certificate_type = "";
        this.m_name = "";
        this.mobile = "";
        this.mid = "";
        this.uid = "";
        this.uid_type = 0;
        this.find_pwd_url = "";
        this.add_pwd_url = "";
        this.pwd_status = "";
        this.bind_url = "";
        this.declive_url = "";
        this.pay_id_state = 0;
        this.pwd_check_way = "";
        this.real_check_type = "";
        this.real_check_type_supplementary = "";
        this.is_new_user = false;
        this.pay_uid = "";
        this.jruid = "";
    }
}
