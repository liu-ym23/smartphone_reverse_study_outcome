package com.bytedance.android.livesdkapi.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0007\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\b\u001a\u00020\u0004*\u00020\u0002¨\u0006\t"}, d2 = {"getSafeMaxDiffCount", "", "Lcom/bytedance/android/livesdkapi/model/ILiveLinkCameraBackUpConfig;", "supportAudienceCheckLinker", "", "supportMixStreamOpt", "supportMsgUpdateForAnchor", "supportMsgUpdateForAudience", "supportReportAckMessage", "live-model-api_saasRelease"}, k = 2, mv = {1, 5, 1})
public final class ILiveLinkCameraBackUpConfigKt {
    public static final int getSafeMaxDiffCount(ILiveLinkCameraBackUpConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getSafeMaxDiffCount");
        return Math.max(r100.getMaxDiffCount(), 0);
    }

    public static final boolean supportAudienceCheckLinker(ILiveLinkCameraBackUpConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$supportAudienceCheckLinker");
        if (r100.getTotalSwitch() == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.getAudienceCheckLinkerSwitch() == false) goto L7;
        return true;
    }

    public static final boolean supportMixStreamOpt(ILiveLinkCameraBackUpConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$supportMixStreamOpt");
        if (r100.getTotalSwitch() == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.getMixStreamSwitch() == false) goto L7;
        return true;
    }

    public static final boolean supportMsgUpdateForAnchor(ILiveLinkCameraBackUpConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$supportMsgUpdateForAnchor");
        if (r100.getTotalSwitch() == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.getMsgUpdateSwitchForAnchor() == false) goto L7;
        return true;
    }

    public static final boolean supportMsgUpdateForAudience(ILiveLinkCameraBackUpConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$supportMsgUpdateForAudience");
        if (r100.getTotalSwitch() == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.getMsgUpdateSwitch() == false) goto L7;
        return true;
    }

    public static final boolean supportReportAckMessage(ILiveLinkCameraBackUpConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$supportReportAckMessage");
        if (r100.getTotalSwitch() == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.getReportAckMsgSwitch() == false) goto L7;
        return true;
    }
}
