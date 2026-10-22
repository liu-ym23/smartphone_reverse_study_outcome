package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarAuditStatus;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VideoShowMode[] f80232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public VideoShowMode f80233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DigitAvatarAuditStatus f80234c;

    public m(VideoShowMode[] r100, VideoShowMode r101, DigitAvatarAuditStatus r102) {
        Intrinsics.checkNotNullParameter(r100, "supportModes");
        Intrinsics.checkNotNullParameter(r101, "selectMode");
        Intrinsics.checkNotNullParameter(r102, "auditStatus");
        this.f80232a = r100;
        this.f80233b = r101;
        this.f80234c = r102;
    }
}
