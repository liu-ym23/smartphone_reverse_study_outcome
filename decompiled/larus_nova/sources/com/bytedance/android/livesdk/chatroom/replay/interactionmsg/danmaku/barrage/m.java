package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.barrage;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.utils.ReplayDanmakuUtilsKt;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f109019d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f109020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f109021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f109022c;

    public static final class a {
        public static m a(jq1.b r100, d r101) {
            Intrinsics.checkNotNullParameter(r100, "message");
            Intrinsics.checkNotNullParameter(r101, "danmakuSettingConfig");
            if (ReplayDanmakuUtilsKt.d(r100) == true) goto L9;
            if (ReplayDanmakuUtilsKt.a(r100, r101) != (-1)) goto L9;
            return new m(s1.e(0.5f), ColorProtector.parseColor("#BF000000"));
        L9:
            return new m(s1.e(0.5f), ColorProtector.parseColor("#BF000000"));
        }
    }

    static {
    }

    public m(float r100, int r101) {
        this.f109020a = r100;
        this.f109021b = r101;
        this.f109022c = 0;
    }
}
