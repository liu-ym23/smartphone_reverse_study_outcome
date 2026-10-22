package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.android.livesdk.widget.rangeseekbar.RangeSeekBar;
import com.bytedance.android.livesdkapi.barrage.ChangeSettingSource;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.larus.nova.R;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import p22.o;

/* JADX INFO: loaded from: classes9.dex */
public final class g extends com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f141791f;

    public static final class a implements ov2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f141792a;

        @Override // ov2.a
        public final void a() {
        }

        @Override // ov2.a
        public final void d(RangeSeekBar r100, float r101) {
        }

        @Override // ov2.a
        public final void b() {
            g r100 = this.f141792a;
            ChangeSettingSource r101 = ChangeSettingSource.SETTING_PANEL_SPEED;
            r100.getClass();
            Intrinsics.checkNotNullParameter(r101, "source");
            r100.f141765b.yR(r101);
            this.f141792a.f141765b.dR();
            g r102 = this.f141792a;
            g r103 = this.f141792a;
            String r104 = r103.l(r103.f141764a.e());
            this.f141792a.f141791f = r104;
            Unit r105 = Unit.INSTANCE;
            r102.f(MapsKt.mapOf(new Pair[]{TuplesKt.to("change_type", "slide"), TuplesKt.to(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE, "move_speed"), TuplesKt.to("old_move_speed_level", String.valueOf(this.f141792a.f141791f)), TuplesKt.to("new_move_speed_level", r104)}));
        }

        public a(g r100) {
            this.f141792a = r100;
        }

        @Override // ov2.a
        public final void c(RangeSeekBar r100, int r101, boolean r102) {
            if (r102 == false) goto L4;
            return;
        L4:
            if (r100 == null) goto L6;
            int r103 = r100.getStepCount();
        L7:
            if (r103 <= 0) goto L26;
            this.f141792a.getClass();
            if (r101 != 0) goto L11;
            float r104 = 0.6f;
        L24:
            g r105 = this.f141792a;
            r105.k(r105.l(r104));
            this.f141792a.f141764a.k(r104);
            return;
        L11:
            if (r101 != 1) goto L13;
            r104 = 0.8f;
            goto L24
        L13:
            if (r101 != 2) goto L15;
        L21:
            r104 = 1.0f;
            goto L24
        L15:
            if (r101 != 3) goto L17;
            r104 = 1.2f;
            goto L24
        L17:
            if (r101 != 4) goto L21;
            r104 = 1.4f;
            goto L24
        L26:
            return;
        L6:
            r103 = 0;
            goto L7
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.b
    public final int a() {
        return R.id.speed_container;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.b
    public final void b() {
        f(MapsKt.mapOf(new Pair[]{TuplesKt.to("change_type", BasicTestActionHandler.TEST_ACTION_RESET), TuplesKt.to(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE, "move_speed"), TuplesKt.to("old_move_speed_level", String.valueOf(this.f141791f)), TuplesKt.to("new_move_speed_level", l(this.f141764a.e()))}));
        j();
    }

    public final String l(float r100) {
        if (r100 != 0.6f) goto L6;
        return "慢";
    L6:
        if (r100 != 0.8f) goto L9;
        return "较慢";
    L9:
        if (r100 != 1.0f) goto L12;
    L20:
        return "适中";
    L12:
        if (r100 != 1.2f) goto L15;
        return "较快";
    L15:
        if (r100 != 1.4f) goto L20;
        return "快";
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.a
    public final ov2.a g() {
        return new a(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.a
    public final f h() {
        return new f(4, 262143);
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.a
    public final void j() {
        float r100 = this.f141764a.e();
        String r101 = l(r100);
        this.f141791f = r101;
        Unit r102 = Unit.INSTANCE;
        k(r101);
        if (r100 != 0.6f) goto L6;
        int r103 = 0;
    L18:
        RangeSeekBar r104 = this.f141762d;
        if (r104 == null) goto L22;
        r104.setStep(r103);
        return;
    L22:
        return;
    L6:
        if (r100 != 0.8f) goto L9;
        r103 = 1;
        goto L18
    L9:
        if (r100 != 1.0f) goto L12;
    L17:
        r103 = 2;
        goto L18
    L12:
        if (r100 != 1.2f) goto L15;
        r103 = 3;
        goto L18
    L15:
        if (r100 != 1.4f) goto L17;
        r103 = 4;
        goto L18
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.a
    public final String i() {
        return s1.B(R.string.ttlive_barrage_simple_setting_speed_title);
    }

    public g(o r100, SimpleZDanmakuSettingDialogFragment r101) {
        Intrinsics.checkNotNullParameter(r100, "danmakuSetting");
        Intrinsics.checkNotNullParameter(r101, "panelCallback");
        super(r100, r101);
    }
}
