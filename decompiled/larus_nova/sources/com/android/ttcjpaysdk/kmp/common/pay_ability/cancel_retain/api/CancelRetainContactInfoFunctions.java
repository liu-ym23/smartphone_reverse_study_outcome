package com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006X\u0086T¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006X\u0086T¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00060\u0005j\u0002`\u0006X\u0086T¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00060\u0005j\u0002`\u0006X\u0086T¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00060\u0005j\u0002`\u0006X\u0086T¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00060\u0005j\u0002`\u0006X\u0086T¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00060\u0005j\u0002`\u0006X\u0086T¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00060\u0005j\u0002`\u0006X\u0086T¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00060\u0005j\u0002`\u0006X\u0086T¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00060\u0005j\u0002`\u0006X\u0086T¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00060\u0005j\u0002`\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CancelRetainContactInfoFunctions;", "", "<init>", "()V", "Default", "", "Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayRetainContactInfoFunc;", CancelRetainContactInfoFunctions.All, CancelRetainContactInfoFunctions.Token, CancelRetainContactInfoFunctions.SkipVerify, CancelRetainContactInfoFunctions.Password, CancelRetainContactInfoFunctions.SMS, "FaceId", CancelRetainContactInfoFunctions.Finger, CancelRetainContactInfoFunctions.NoPassword, CancelRetainContactInfoFunctions.SetPassword, CancelRetainContactInfoFunctions.CVV, "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CancelRetainContactInfoFunctions {
    public static final int $stable = 0;
    public static final String All = "All";
    public static final String CVV = "CVV";
    public static final String Default = "Default";
    public static final String FaceId = "FaceID";
    public static final String Finger = "Finger";
    public static final CancelRetainContactInfoFunctions INSTANCE = null;
    public static final String NoPassword = "NoPassword";
    public static final String Password = "Password";
    public static final String SMS = "SMS";
    public static final String SetPassword = "SetPassword";
    public static final String SkipVerify = "SkipVerify";
    public static final String Token = "Token";

    static {
        INSTANCE = new CancelRetainContactInfoFunctions();
    }

    private CancelRetainContactInfoFunctions() {
    }
}
