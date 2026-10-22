package com.android.ttcjpaysdk.base.ui.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.thirdparty.data.unifypay.UnifyCashierRenderInfo;
import com.bytedance.android.ec.core.event.a;
import com.tencent.open.SocialConstants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u000f\u0010B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u0005R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/CJPayTopRightBtnInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "action", "", a.KEY_BIO_TYPE, SocialConstants.PARAM_APP_DESC, "downgrade_reason", "jump_url", "getActionType", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayTopRightBtnInfo$ActionType;", "getBioType", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayTopRightBtnInfo$BioType;", "getCheckTypeName", "ActionType", "BioType", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayTopRightBtnInfo implements CJPayObject, Serializable {
    public String action;
    public String bio_type;
    public String desc;
    public String downgrade_reason;
    public String jump_url;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/CJPayTopRightBtnInfo$ActionType;", "", "(Ljava/lang/String;I)V", "BIO_VERIFY", "FACE_VERIFY", "PRE_BIO_GUIDE", "FORGET_PWD_SMS_VERIFY", "PASSWORD_VERIFY", "ON_SET_PWD", "ON_MODIFY_PWD", "SMS_VERIFY", "ON_NO_PWD", "ON_NORMAL_MODE", "NOT_CHECK", "CARRIER_VERIFY", "DEFAULT", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum ActionType extends Enum<ActionType> {
        private static final /* synthetic */ ActionType[] $VALUES = null;
        public static final ActionType BIO_VERIFY = null;
        public static final ActionType CARRIER_VERIFY = null;
        public static final ActionType DEFAULT = null;
        public static final ActionType FACE_VERIFY = null;
        public static final ActionType FORGET_PWD_SMS_VERIFY = null;
        public static final ActionType NOT_CHECK = null;
        public static final ActionType ON_MODIFY_PWD = null;
        public static final ActionType ON_NORMAL_MODE = null;
        public static final ActionType ON_NO_PWD = null;
        public static final ActionType ON_SET_PWD = null;
        public static final ActionType PASSWORD_VERIFY = null;
        public static final ActionType PRE_BIO_GUIDE = null;
        public static final ActionType SMS_VERIFY = null;

        private static final /* synthetic */ ActionType[] $values() {
            return new ActionType[]{BIO_VERIFY, FACE_VERIFY, PRE_BIO_GUIDE, FORGET_PWD_SMS_VERIFY, PASSWORD_VERIFY, ON_SET_PWD, ON_MODIFY_PWD, SMS_VERIFY, ON_NO_PWD, ON_NORMAL_MODE, NOT_CHECK, CARRIER_VERIFY, DEFAULT};
        }

        public static ActionType valueOf(String r100) {
            return (ActionType) r27.a.a(ActionType.class, r100);
        }

        public static ActionType[] values() {
            return (ActionType[]) $VALUES.clone();
        }

        static {
            BIO_VERIFY = new ActionType("BIO_VERIFY", 0);
            FACE_VERIFY = new ActionType("FACE_VERIFY", 1);
            PRE_BIO_GUIDE = new ActionType("PRE_BIO_GUIDE", 2);
            FORGET_PWD_SMS_VERIFY = new ActionType("FORGET_PWD_SMS_VERIFY", 3);
            PASSWORD_VERIFY = new ActionType("PASSWORD_VERIFY", 4);
            ON_SET_PWD = new ActionType("ON_SET_PWD", 5);
            ON_MODIFY_PWD = new ActionType("ON_MODIFY_PWD", 6);
            SMS_VERIFY = new ActionType("SMS_VERIFY", 7);
            ON_NO_PWD = new ActionType("ON_NO_PWD", 8);
            ON_NORMAL_MODE = new ActionType("ON_NORMAL_MODE", 9);
            NOT_CHECK = new ActionType("NOT_CHECK", 10);
            CARRIER_VERIFY = new ActionType("CARRIER_VERIFY", 11);
            DEFAULT = new ActionType("DEFAULT", 12);
            $VALUES = $values();
        }

        private ActionType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/CJPayTopRightBtnInfo$BioType;", "", "(Ljava/lang/String;I)V", "FINGER", "DEFAULT", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum BioType extends Enum<BioType> {
        private static final /* synthetic */ BioType[] $VALUES = null;
        public static final BioType DEFAULT = null;
        public static final BioType FINGER = null;

        private static final /* synthetic */ BioType[] $values() {
            return new BioType[]{FINGER, DEFAULT};
        }

        public static BioType valueOf(String r100) {
            return (BioType) r27.a.a(BioType.class, r100);
        }

        public static BioType[] values() {
            return (BioType[]) $VALUES.clone();
        }

        static {
            FINGER = new BioType("FINGER", 0);
            DEFAULT = new BioType("DEFAULT", 1);
            $VALUES = $values();
        }

        private BioType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[ActionType.values().length];
            r100[ActionType.BIO_VERIFY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L37:
            r100[ActionType.FACE_VERIFY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L55:
            r100[ActionType.PRE_BIO_GUIDE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L41:
            r100[ActionType.FORGET_PWD_SMS_VERIFY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L45:
            r100[ActionType.PASSWORD_VERIFY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L22
        L31:
            r100[ActionType.ON_SET_PWD.ordinal()] = 6;     // Catch: NoSuchFieldError -> L23
        L47:
            r100[ActionType.ON_MODIFY_PWD.ordinal()] = 7;     // Catch: NoSuchFieldError -> L24
        L49:
            r100[ActionType.SMS_VERIFY.ordinal()] = 8;     // Catch: NoSuchFieldError -> L25
        L39:
            r100[ActionType.ON_NO_PWD.ordinal()] = 9;     // Catch: NoSuchFieldError -> L26
        L43:
            r100[ActionType.NOT_CHECK.ordinal()] = 10;     // Catch: NoSuchFieldError -> L27
        L33:
            r100[ActionType.ON_NORMAL_MODE.ordinal()] = 11;     // Catch: NoSuchFieldError -> L28
        L35:
            r100[ActionType.CARRIER_VERIFY.ordinal()] = 12;     // Catch: NoSuchFieldError -> L29
        L53:
            r100[ActionType.DEFAULT.ordinal()] = 13;     // Catch: NoSuchFieldError -> L30
        L16:
            $EnumSwitchMapping$0 = r100;
        }
    }

    public final ActionType getActionType() {
        String r100 = this.action;
        switch(r100.hashCode()) {
            case -1541143826: goto L50;
            case -1541078144: goto L46;
            case -897951205: goto L42;
            case -815673456: goto L38;
            case -475465479: goto L34;
            case -220465025: goto L30;
            case 668861636: goto L26;
            case 919585691: goto L22;
            case 1111270552: goto L18;
            case 1612531868: goto L14;
            case 1833222387: goto L10;
            case 2103775565: goto L6;
            default: goto L54;
        };
    L6:
        if (r100.equals("forget_pwd_verify") == false) goto L54;
        return ActionType.FACE_VERIFY;
    L10:
        if (r100.equals("forget_pwd_sms_verify") == false) goto L54;
        return ActionType.FORGET_PWD_SMS_VERIFY;
    L14:
        if (r100.equals("not_check") == false) goto L54;
        return ActionType.NOT_CHECK;
    L18:
        if (r100.equals("on_modify_pwd") == false) goto L54;
        return ActionType.ON_MODIFY_PWD;
    L22:
        if (r100.equals("on_normal_mode") == false) goto L54;
        return ActionType.ON_NORMAL_MODE;
    L26:
        if (r100.equals("pre_bio_guide_info") == false) goto L54;
        return ActionType.PRE_BIO_GUIDE;
    L30:
        if (r100.equals("on_sms_verify") == false) goto L54;
        return ActionType.SMS_VERIFY;
    L34:
        if (r100.equals("no_pwd_verify") == false) goto L54;
        return ActionType.ON_NO_PWD;
    L38:
        if (r100.equals("bio_verify") == false) goto L54;
        return ActionType.BIO_VERIFY;
    L42:
        if (r100.equals("on_pwd_verify") == false) goto L54;
        return ActionType.PASSWORD_VERIFY;
    L46:
        if (r100.equals("on_set_pwd") == false) goto L54;
        return ActionType.ON_SET_PWD;
    L50:
        if (r100.equals(UnifyCashierRenderInfo.StandardVerifyInfo.ACTION_CARRIER) == false) goto L54;
        return ActionType.CARRIER_VERIFY;
    L54:
        return ActionType.DEFAULT;
    }

    public final BioType getBioType() {
        if (Intrinsics.areEqual(this.bio_type, "FINGER") == false) goto L6;
        return BioType.FINGER;
    L6:
        return BioType.DEFAULT;
    }

    public CJPayTopRightBtnInfo() {
        this.desc = "";
        this.action = "";
        this.bio_type = "";
        this.downgrade_reason = "";
        this.jump_url = "";
    }

    public final String getCheckTypeName() {
        ActionType r100 = getActionType();
        switch(WhenMappings.$EnumSwitchMapping$0[r100.ordinal()]) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L23;
            case 4: goto L16;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L23;
            case 8: goto L16;
            case 9: goto L9;
            case 10: goto L8;
            case 11: goto L7;
            case 12: goto L6;
            case 13: goto L23;
            default: goto L5;
        };
    L6:
        return "运营商";
    L7:
        return "普通模式";
    L8:
        return "免验证";
    L9:
        return "免密";
    L10:
        return "设密";
    L11:
        return "密码";
    L13:
        return "人脸";
    L14:
        return "指纹";
    L16:
        return "短信";
    L5:
        throw new NoWhenBranchMatchedException();
    L23:
        return "";
    }
}
