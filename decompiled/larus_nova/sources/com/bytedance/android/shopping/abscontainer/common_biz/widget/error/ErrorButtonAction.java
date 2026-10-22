package com.bytedance.android.shopping.abscontainer.common_biz.widget.error;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/abscontainer/common_biz/widget/error/ErrorButtonAction;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "REFRESH", "RETURN", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ErrorButtonAction extends Enum<ErrorButtonAction> {
    public static final ErrorButtonAction REFRESH = null;
    public static final ErrorButtonAction RETURN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ErrorButtonAction[] f164355a = null;
    private final String value;

    static {
        ErrorButtonAction r100 = new ErrorButtonAction("REFRESH", 0, "refresh");
        REFRESH = r100;
        ErrorButtonAction r101 = new ErrorButtonAction("RETURN", 1, "return");
        RETURN = r101;
        f164355a = new ErrorButtonAction[]{r100, r101};
    }

    public static ErrorButtonAction valueOf(String r100) {
        return (ErrorButtonAction) a.a(ErrorButtonAction.class, r100);
    }

    public static ErrorButtonAction[] values() {
        return (ErrorButtonAction[]) f164355a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public ErrorButtonAction(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
