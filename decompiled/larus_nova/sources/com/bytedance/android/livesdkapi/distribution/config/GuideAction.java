package com.bytedance.android.livesdkapi.distribution.config;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/distribution/config/GuideAction;", "", "()V", GuideAction.leaveRetainGuide, "", GuideAction.leftScrollGuide, GuideAction.longPressGuide, GuideAction.rightScrollGuide, GuideAction.upDownScrollGuide, GuideAction.zoomGuide, "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GuideAction {
    public static final GuideAction INSTANCE = null;
    public static final String leaveRetainGuide = "leaveRetainGuide";
    public static final String leftScrollGuide = "leftScrollGuide";
    public static final String longPressGuide = "longPressGuide";
    public static final String rightScrollGuide = "rightScrollGuide";
    public static final String upDownScrollGuide = "upDownScrollGuide";
    public static final String zoomGuide = "zoomGuide";

    private GuideAction() {
    }

    static {
        INSTANCE = new GuideAction();
    }
}
