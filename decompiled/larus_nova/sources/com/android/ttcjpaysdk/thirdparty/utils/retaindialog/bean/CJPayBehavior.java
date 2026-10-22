package com.android.ttcjpaysdk.thirdparty.utils.retaindialog.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoBehaviors;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayBehavior;", "", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", CancelRetainContactInfoBehaviors.ClosePage, CancelRetainContactInfoBehaviors.BackPage, "UNKNOWN", "Companion", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum CJPayBehavior extends Enum<CJPayBehavior> implements CJPayObject {
    private static final /* synthetic */ CJPayBehavior[] $VALUES = null;
    public static final CJPayBehavior BackPage = null;
    public static final CJPayBehavior ClosePage = null;
    public static final Companion Companion = null;
    public static final CJPayBehavior UNKNOWN = null;
    private final String value;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayBehavior$Companion;", "", "()V", "fromString", "Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayBehavior;", "value", "", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final CJPayBehavior fromString(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            CJPayBehavior[] r101 = CJPayBehavior.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            CJPayBehavior r104 = r101[r103];
            if (Intrinsics.areEqual(r104.getValue(), r100) == true) goto L9;
            r103 = r103 + 1;
        L9:
            if (r104 == null) goto L11;
            return r104;
        L11:
            return CJPayBehavior.UNKNOWN;
        L8:
            r104 = null;
            goto L9
        }
    }

    private static final /* synthetic */ CJPayBehavior[] $values() {
        return new CJPayBehavior[]{ClosePage, BackPage, UNKNOWN};
    }

    public static CJPayBehavior valueOf(String r100) {
        return (CJPayBehavior) a.a(CJPayBehavior.class, r100);
    }

    public static CJPayBehavior[] values() {
        return (CJPayBehavior[]) $VALUES.clone();
    }

    static {
        ClosePage = new CJPayBehavior(CancelRetainContactInfoBehaviors.ClosePage, 0, CancelRetainContactInfoBehaviors.ClosePage);
        BackPage = new CJPayBehavior(CancelRetainContactInfoBehaviors.BackPage, 1, CancelRetainContactInfoBehaviors.BackPage);
        UNKNOWN = new CJPayBehavior("UNKNOWN", 2, "UNKNOWN");
        $VALUES = $values();
        Companion = new Companion(null);
    }

    public final String getValue() {
        return this.value;
    }

    private CJPayBehavior(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
