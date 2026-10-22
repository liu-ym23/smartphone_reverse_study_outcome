package com.bytedance.android.live.liveinteract.digitavatar.videoavatar;

import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VideoShowMode f72711a;

    public c() {
        this(VideoShowMode.AUDIO, null);
    }

    public c(VideoShowMode r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "showMode");
        this.f72711a = r100;
    }
}
