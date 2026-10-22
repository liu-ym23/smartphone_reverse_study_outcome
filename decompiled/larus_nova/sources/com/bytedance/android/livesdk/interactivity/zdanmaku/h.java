package com.bytedance.android.livesdk.interactivity.zdanmaku;

import com.bytedance.android.livesdk.interactivity.zdanmaku.attributes.DanmakuType;
import com.bytedance.live.zdanmaku.data.Danmaku;

/* JADX INFO: loaded from: classes9.dex */
public class h extends Danmaku {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f141634d;

    public final tc2.e g() {
        nf6.a r100 = new tc2.e(0, 0, 0, 7);
        nf6.a r101 = b().e(tc2.e.class);
        if (r101 == null) goto L7;
        r100 = r101;
    L7:
        return (tc2.e) r100;
    }

    public final DanmakuType getType() {
        nf6.a r100 = DanmakuType.UnDefined;
        nf6.a r101 = b().e(DanmakuType.class);
        if (r101 == null) goto L7;
        r100 = r101;
    L7:
        return (DanmakuType) r100;
    }

    public final tc2.h h() {
        nf6.a r100 = new tc2.h(0);
        nf6.a r101 = b().e(tc2.h.class);
        if (r101 == null) goto L7;
        r100 = r101;
    L7:
        return (tc2.h) r100;
    }

    public h() {
        this.f141634d = 1.0f;
    }
}
