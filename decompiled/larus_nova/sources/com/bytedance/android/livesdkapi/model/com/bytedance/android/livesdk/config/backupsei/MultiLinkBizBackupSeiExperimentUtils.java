package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.backupsei;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\nJ\u001a\u0010\u0011\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\nH\u0002J\u0018\u0010\u0012\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\nJ\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0004J\u0018\u0010\u0015\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\nJ\u0018\u0010\u0016\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\nJ\u0018\u0010\u0017\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/backupsei/MultiLinkBizBackupSeiExperimentUtils;", "", "()V", "MULTI_LINK_KTV_ALL_IN_ENABLE", "", "MULTI_LINK_TOTAL_ENABLE", "MULTI_LINK_VIDEO_TALK_ROOM_ENABLE", "MULTI_LINK_VOICE_KTV_ENABLE", "MULTI_LINK_VOICE_TALK_ROOM_ENABLE", "containMode", "", "sourceMode", "targetMode", "getMultiLinkConfig", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "isAnchor", "isEnableLiveBackupSei", "isKtvAllInEnable", "isTotalEnable", "configMode", "isVideoTalkRoomEnable", "isVoiceKtvEnable", "isVoiceTalkRoomEnable", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiLinkBizBackupSeiExperimentUtils {
    public static final MultiLinkBizBackupSeiExperimentUtils INSTANCE = null;
    private static final int MULTI_LINK_KTV_ALL_IN_ENABLE = 32;
    private static final int MULTI_LINK_TOTAL_ENABLE = 2;
    private static final int MULTI_LINK_VIDEO_TALK_ROOM_ENABLE = 4;
    private static final int MULTI_LINK_VOICE_KTV_ENABLE = 16;
    private static final int MULTI_LINK_VOICE_TALK_ROOM_ENABLE = 8;

    private MultiLinkBizBackupSeiExperimentUtils() {
    }

    private final boolean containMode(int r100, int r101) {
        if ((r100 & r101) != r101) goto L5;
        return true;
    L5:
        return false;
    }

    static {
        INSTANCE = new MultiLinkBizBackupSeiExperimentUtils();
    }

    public final boolean isTotalEnable(int r100) {
        return containMode(r100, 2);
    }

    private final boolean isEnableLiveBackupSei(IRoom r100, boolean r101) {
        if (r100 != null) goto L4;
        return false;
    L4:
        return LiveBackupSeiExperimentUtils.INSTANCE.isEnableLiveBackupSei(r100, r101);
    }

    public final int getMultiLinkConfig(IRoom r100, boolean r101) {
        if (isEnableLiveBackupSei(r100, r101) == true) goto L5;
        return 0;
    L5:
        if (r100 == null) goto L7;
        String r102 = r100.getAnchorAbValue("multi_link_biz_access_backup_sei_config");
    L8:
        if (r102 == null) goto L13;
        Integer r103 = StringsKt.toIntOrNull(r102);
        if (r103 != null) goto L12;
        return 0;
    L12:
        return r103.intValue();
    L13:
        return 0;
    L7:
        r102 = null;
        goto L8
    }

    public final boolean isKtvAllInEnable(IRoom r100, boolean r101) {
        int r102 = getMultiLinkConfig(r100, r101);
        if (containMode(r102, 2) == true) goto L5;
    L7:
        return false;
    L5:
        if (containMode(r102, 32) == false) goto L7;
        return true;
    }

    public final boolean isVideoTalkRoomEnable(IRoom r100, boolean r101) {
        int r102 = getMultiLinkConfig(r100, r101);
        if (containMode(r102, 2) == true) goto L5;
    L7:
        return false;
    L5:
        if (containMode(r102, 4) == false) goto L7;
        return true;
    }

    public final boolean isVoiceKtvEnable(IRoom r100, boolean r101) {
        int r102 = getMultiLinkConfig(r100, r101);
        if (containMode(r102, 2) == true) goto L5;
    L7:
        return false;
    L5:
        if (containMode(r102, 16) == false) goto L7;
        return true;
    }

    public final boolean isVoiceTalkRoomEnable(IRoom r100, boolean r101) {
        int r102 = getMultiLinkConfig(r100, r101);
        if (containMode(r102, 2) == true) goto L5;
    L7:
        return false;
    L5:
        if (containMode(r102, 8) == false) goto L7;
        return true;
    }
}
