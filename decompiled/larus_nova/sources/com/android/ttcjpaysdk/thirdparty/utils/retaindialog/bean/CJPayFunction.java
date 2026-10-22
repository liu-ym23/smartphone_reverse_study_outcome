package com.android.ttcjpaysdk.thirdparty.utils.retaindialog.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoFunctions;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0001\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0013B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0014"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayFunction;", "", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", CancelRetainContactInfoFunctions.Password, CancelRetainContactInfoFunctions.SetPassword, CancelRetainContactInfoFunctions.SMS, CancelRetainContactInfoFunctions.Finger, CancelRetainContactInfoFunctions.NoPassword, CancelRetainContactInfoFunctions.Token, CancelRetainContactInfoFunctions.SkipVerify, "Live", "OnCarrierVerify", "UNKNOWN", "Default", "Companion", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum CJPayFunction extends Enum<CJPayFunction> implements CJPayObject {
    private static final /* synthetic */ CJPayFunction[] $VALUES = null;
    public static final Companion Companion = null;
    public static final CJPayFunction Default = null;
    public static final CJPayFunction Finger = null;
    public static final CJPayFunction Live = null;
    public static final CJPayFunction NoPassword = null;
    public static final CJPayFunction OnCarrierVerify = null;
    public static final CJPayFunction Password = null;
    public static final CJPayFunction SMS = null;
    public static final CJPayFunction SetPassword = null;
    public static final CJPayFunction SkipVerify = null;
    public static final CJPayFunction Token = null;
    public static final CJPayFunction UNKNOWN = null;
    private final String value;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayFunction$Companion;", "", "()V", "fromString", "Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayFunction;", "value", "", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final CJPayFunction fromString(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            CJPayFunction[] r101 = CJPayFunction.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            CJPayFunction r104 = r101[r103];
            if (Intrinsics.areEqual(r104.getValue(), r100) == true) goto L9;
            r103 = r103 + 1;
        L9:
            if (r104 == null) goto L11;
            return r104;
        L11:
            return CJPayFunction.UNKNOWN;
        L8:
            r104 = null;
            goto L9
        }
    }

    private static final /* synthetic */ CJPayFunction[] $values() {
        return new CJPayFunction[]{Password, SetPassword, SMS, Finger, NoPassword, Token, SkipVerify, Live, OnCarrierVerify, UNKNOWN, Default};
    }

    public static CJPayFunction valueOf(String r100) {
        return (CJPayFunction) a.a(CJPayFunction.class, r100);
    }

    public static CJPayFunction[] values() {
        return (CJPayFunction[]) $VALUES.clone();
    }

    static {
        Password = new CJPayFunction(CancelRetainContactInfoFunctions.Password, 0, CancelRetainContactInfoFunctions.Password);
        SetPassword = new CJPayFunction(CancelRetainContactInfoFunctions.SetPassword, 1, CancelRetainContactInfoFunctions.SetPassword);
        SMS = new CJPayFunction(CancelRetainContactInfoFunctions.SMS, 2, CancelRetainContactInfoFunctions.SMS);
        Finger = new CJPayFunction(CancelRetainContactInfoFunctions.Finger, 3, CancelRetainContactInfoFunctions.Finger);
        NoPassword = new CJPayFunction(CancelRetainContactInfoFunctions.NoPassword, 4, CancelRetainContactInfoFunctions.NoPassword);
        Token = new CJPayFunction(CancelRetainContactInfoFunctions.Token, 5, CancelRetainContactInfoFunctions.Token);
        SkipVerify = new CJPayFunction(CancelRetainContactInfoFunctions.SkipVerify, 6, CancelRetainContactInfoFunctions.SkipVerify);
        Live = new CJPayFunction("Live", 7, "Live");
        OnCarrierVerify = new CJPayFunction("OnCarrierVerify", 8, "OnCarrierVerify");
        UNKNOWN = new CJPayFunction("UNKNOWN", 9, "UNKNOWN");
        Default = new CJPayFunction("Default", 10, "Default");
        $VALUES = $values();
        Companion = new Companion(null);
    }

    public final String getValue() {
        return this.value;
    }

    private CJPayFunction(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
