package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarAuditStatus;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f80211a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f80212b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f80213c = null;

    static {
        int[] r100 = new int[VideoShowMode.values().length];
        f80211a = r100;
        VideoShowMode r101 = VideoShowMode.AUDIO;
        r100[r101.ordinal()] = 1;
        VideoShowMode r102 = VideoShowMode.VIDEO;
        r100[r102.ordinal()] = 2;
        VideoShowMode r103 = VideoShowMode.DIGIT_AVATAR;
        r100[r103.ordinal()] = 3;
        int[] r104 = new int[VideoShowMode.values().length];
        f80212b = r104;
        r104[r101.ordinal()] = 1;
        r104[r102.ordinal()] = 2;
        r104[r103.ordinal()] = 3;
        int[] r105 = new int[DigitAvatarAuditStatus.values().length];
        f80213c = r105;
        r105[DigitAvatarAuditStatus.NOT_PASS.ordinal()] = 1;
        r105[DigitAvatarAuditStatus.PASS.ordinal()] = 2;
        r105[DigitAvatarAuditStatus.AUDITING.ordinal()] = 3;
    }
}
