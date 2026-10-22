package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.barrage;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.config.ReplayBarrageSettingFont;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.config.ReplayBarrageSettingSpeed;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f108996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f108997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ReplayBarrageSettingFont f108998c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f108999d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ReplayBarrageSettingSpeed f109000e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f109001f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f109002g;

    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f109003a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f109004b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f109005c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f109006d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f109007e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f109008f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f109009g;

        public a(int r100, int r101, int r102, int r103, int r104, int r105, int r106) {
            this.f109003a = r100;
            this.f109004b = r101;
            this.f109005c = r102;
            this.f109006d = r103;
            this.f109007e = r104;
            this.f109008f = r105;
            this.f109009g = r106;
        }
    }

    public static int a(float r100) {
        return (int) ((r100 * s1.u()) - 0.5f);
    }

    public final void b(int r100, boolean r101, boolean r102) {
        if (r102 == false) goto L5;
        this.f109001f = new int[]{1, 3};
        return;
    L5:
        if (r101 == false) goto L8;
        this.f109001f = new int[]{0, 2};
        return;
    L8:
        if (((r100 + 0) / (this.f108996a.f109003a + 0)) >= 4) goto L10;
        int[] r103 = {0, 2};
    L11:
        this.f109001f = r103;
        return;
    L10:
        r103 = new int[]{1, 3};
        goto L11
    }

    public d(float r310, ReplayBarrageSettingFont r311, float r312, ReplayBarrageSettingSpeed r313) {
        Intrinsics.checkNotNullParameter(r311, "barrageFont");
        Intrinsics.checkNotNullParameter(r313, "barrageSpeed");
        this.f109001f = new int[0];
        switch(e.f109010a[r311.ordinal()]) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L5;
            default: goto L4;
        };
    L4:
        int r110 = a(32.0f);
        a(28.0f);
        a(24.0f);
        a(18.0f);
        a(16.0f);
        a(18.0f);
        a(12.0f);
        a(10.0f);
        int r111 = a(18.0f);
        int r100 = a(18.0f);
        int r112 = a(24.0f);
        int r210 = a(20.0f);
        a(10.0f);
        int r211 = a(18.0f);
        int r212 = a(24.0f);
        a(44.0f);
        a(18.0f);
        a r101 = new a(r110, r111, r100, r112, r210, r211, r212);
    L14:
        this.f108996a = r101;
        this.f108997b = r310;
        this.f108998c = r311;
        this.f108999d = r312;
        this.f109000e = r313;
        return;
    L5:
        int r213 = a(42.0f);
        a(34.0f);
        a(34.0f);
        a(28.0f);
        a(20.0f);
        a(24.0f);
        a(16.0f);
        a(14.0f);
        int r214 = a(28.0f);
        int r215 = a(28.0f);
        int r216 = a(34.0f);
        int r314 = a(28.0f);
        a(12.0f);
        int r315 = a(28.0f);
        int r316 = a(34.0f);
        a(60.0f);
        a(24.0f);
        r101 = new a(r213, r214, r215, r216, r314, r315, r316);
        goto L14
    L6:
        int r102 = a(36.0f);
        a(30.0f);
        a(28.0f);
        a(18.0f);
        a(16.0f);
        a(22.0f);
        a(14.0f);
        a(12.0f);
        int r113 = a(20.0f);
        int r114 = a(20.0f);
        int r115 = a(28.0f);
        a(10.0f);
        int r116 = a(28.0f);
        int r117 = a(24.0f);
        int r118 = a(32.0f);
        a(50.0f);
        a(20.0f);
        r101 = new a(r102, r113, r114, r115, r116, r117, r118);
        goto L14
    L7:
        int r103 = a(32.0f);
        a(26.0f);
        a(21.0f);
        a(15.0f);
        a(12.0f);
        a(18.0f);
        a(12.0f);
        a(10.0f);
        int r104 = a(15.0f);
        int r105 = a(15.0f);
        int r217 = a(21.0f);
        a(10.0f);
        int r218 = a(18.0f);
        int r219 = a(18.0f);
        int r220 = a(24.0f);
        a(44.0f);
        a(18.0f);
        r101 = new a(r103, r104, r105, r217, r218, r219, r220);
        goto L14
    L8:
        int r119 = a(24.0f);
        a(24.0f);
        a(15.0f);
        a(12.0f);
        a(12.0f);
        a(18.0f);
        a(10.0f);
        a(8.0f);
        int r120 = a(11.0f);
        int r121 = a(11.0f);
        int r106 = a(15.0f);
        int r221 = a(17.0f);
        a(8.0f);
        int r222 = a(15.0f);
        int r223 = a(21.0f);
        a(39.0f);
        a(16.0f);
        r101 = new a(r119, r120, r121, r106, r221, r222, r223);
        goto L14
    L9:
        int r107 = a(22.0f);
        a(22.0f);
        a(20.0f);
        a(16.0f);
        a(12.0f);
        a(16.0f);
        a(12.0f);
        a(10.0f);
        int r108 = a(16.0f);
        int r122 = a(16.0f);
        int r123 = a(20.0f);
        int r124 = a(20.0f);
        a(10.0f);
        int r125 = a(16.0f);
        int r109 = a(22.0f);
        a(44.0f);
        a(18.0f);
        r101 = new a(r107, r108, r122, r123, r124, r125, r109);
        goto L14
    L10:
        int r126 = a(24.0f);
        a(24.0f);
        a(18.0f);
        a(15.0f);
        a(12.0f);
        a(14.0f);
        a(10.0f);
        a(8.0f);
        int r127 = a(15.0f);
        int r128 = a(15.0f);
        int r129 = a(18.0f);
        int r224 = a(17.0f);
        a(8.0f);
        int r225 = a(15.0f);
        int r226 = a(21.0f);
        a(39.0f);
        a(16.0f);
        r101 = new a(r126, r127, r128, r129, r224, r225, r226);
        goto L14
    L11:
        int r130 = a(32.0f);
        a(28.0f);
        a(24.0f);
        a(18.0f);
        a(16.0f);
        a(18.0f);
        a(12.0f);
        a(10.0f);
        int r131 = a(18.0f);
        int r132 = a(18.0f);
        int r133 = a(24.0f);
        int r134 = a(20.0f);
        a(10.0f);
        int r135 = a(18.0f);
        int r136 = a(24.0f);
        a(44.0f);
        a(18.0f);
        r101 = new a(r130, r131, r132, r133, r134, r135, r136);
        goto L14
    L12:
        int r227 = a(38.0f);
        a(32.0f);
        a(30.0f);
        a(24.0f);
        a(20.0f);
        a(24.0f);
        a(14.0f);
        a(12.0f);
        int r228 = a(24.0f);
        int r229 = a(24.0f);
        a(10.0f);
        int r230 = a(30.0f);
        int r231 = a(24.0f);
        int r317 = a(24.0f);
        int r318 = a(32.0f);
        a(50.0f);
        a(20.0f);
        r101 = new a(r227, r228, r229, r230, r231, r317, r318);
        goto L14
    L13:
        int r137 = a(42.0f);
        a(34.0f);
        a(34.0f);
        a(28.0f);
        a(20.0f);
        a(24.0f);
        a(16.0f);
        a(14.0f);
        int r138 = a(28.0f);
        int r139 = a(28.0f);
        int r140 = a(34.0f);
        int r141 = a(28.0f);
        a(12.0f);
        int r142 = a(28.0f);
        int r143 = a(34.0f);
        a(60.0f);
        a(24.0f);
        r101 = new a(r137, r138, r139, r140, r141, r142, r143);
        goto L14
    }
}
