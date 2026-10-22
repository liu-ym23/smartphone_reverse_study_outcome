package com.bytedance.android.livesdk.interactivity.api.monitorV2.business;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/monitorV2/business/PanelPopupFailed;", "", "", "reason", "Ljava/lang/String;", "getReason", "()Ljava/lang/String;", "UserBan", "CommentClose", "NotLogin", "SpecialStyle", "LandscapeBlock", "NotPaid", "UserCenterIntercept", "VS", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PanelPopupFailed extends Enum<PanelPopupFailed> {
    public static final PanelPopupFailed CommentClose = null;
    public static final PanelPopupFailed LandscapeBlock = null;
    public static final PanelPopupFailed NotLogin = null;
    public static final PanelPopupFailed NotPaid = null;
    public static final PanelPopupFailed SpecialStyle = null;
    public static final PanelPopupFailed UserBan = null;
    public static final PanelPopupFailed UserCenterIntercept = null;
    public static final PanelPopupFailed VS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PanelPopupFailed[] f133353a = null;
    private final String reason;

    public static PanelPopupFailed valueOf(String r100) {
        return (PanelPopupFailed) a.a(PanelPopupFailed.class, r100);
    }

    public static PanelPopupFailed[] values() {
        return (PanelPopupFailed[]) f133353a.clone();
    }

    static {
        PanelPopupFailed r100 = new PanelPopupFailed("UserBan", 0, "user_ban");
        UserBan = r100;
        PanelPopupFailed r101 = new PanelPopupFailed("CommentClose", 1, "comment_close");
        CommentClose = r101;
        PanelPopupFailed r102 = new PanelPopupFailed("NotLogin", 2, "not_login");
        NotLogin = r102;
        PanelPopupFailed r103 = new PanelPopupFailed("SpecialStyle", 3, "special_style");
        SpecialStyle = r103;
        PanelPopupFailed r104 = new PanelPopupFailed("LandscapeBlock", 4, "landscape_block");
        LandscapeBlock = r104;
        PanelPopupFailed r105 = new PanelPopupFailed("NotPaid", 5, "not_paid");
        NotPaid = r105;
        PanelPopupFailed r106 = new PanelPopupFailed("UserCenterIntercept", 6, "user_center_intercept");
        UserCenterIntercept = r106;
        PanelPopupFailed r107 = new PanelPopupFailed("VS", 7, "vs");
        VS = r107;
        f133353a = new PanelPopupFailed[]{r100, r101, r102, r103, r104, r105, r106, r107};
    }

    public final String getReason() {
        return this.reason;
    }

    public PanelPopupFailed(String r100, int r101, String r102) {
        super(r100, r101);
        this.reason = r102;
    }
}
