package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.android.livesdk.widget.rangeseekbar.RangeSeekBar;
import com.bytedance.android.livesdkapi.barrage.ChangeSettingSource;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.larus.nova.R;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import p22.o;

/* JADX INFO: loaded from: classes9.dex */
public final class d extends com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f141768f;

    public static final class a implements ov2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f141769a;

        @Override // ov2.a
        public final void a() {
        }

        @Override // ov2.a
        public final void d(RangeSeekBar r100, float r101) {
        }

        @Override // ov2.a
        public final void b() {
            d r100 = this.f141769a;
            ChangeSettingSource r101 = ChangeSettingSource.SETTING_PANEL_LINE;
            r100.getClass();
            Intrinsics.checkNotNullParameter(r101, "source");
            r100.f141765b.yR(r101);
            this.f141769a.f141765b.dR();
            this.f141769a.f(MapsKt.mapOf(new Pair[]{TuplesKt.to("change_type", "slide"), TuplesKt.to(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE, "show_area"), TuplesKt.to("old_show_area_level", String.valueOf(this.f141769a.f141768f)), TuplesKt.to("new_show_area_level", String.valueOf(this.f141769a.f141764a.d()))}));
            d r102 = this.f141769a;
            r102.f141768f = Integer.valueOf(r102.f141764a.d());
        }

        public a(d r100) {
            this.f141769a = r100;
        }

        @Override // ov2.a
        public final void c(RangeSeekBar r100, int r101, boolean r102) {
            if (r102 == false) goto L4;
            return;
        L4:
            if (r100 == null) goto L6;
            int r103 = r100.getStepCount();
        L7:
            if (r103 <= 0) goto L20;
            this.f141769a.getClass();
            int r104 = 1;
            if (r101 != 0) goto L11;
        L18:
            d r105 = this.f141769a;
            r105.getClass();
            StringBuilder r106 = new StringBuilder();
            r106.append(r104);
            r106.append(34892);
            r105.k(r106.toString());
            this.f141769a.f141764a.j(r104);
            return;
        L11:
            if (r101 == 1) goto L17;
            r104 = 3;
            if (r101 == 2) goto L18;
            if (r101 != 3) goto L18;
            r104 = 4;
            goto L18
        L17:
            r104 = 2;
            goto L18
        L20:
            return;
        L6:
            r103 = 0;
            goto L7
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.b
    public final int a() {
        return R.id.area_container;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.b
    public final void b() {
        f(MapsKt.mapOf(new Pair[]{TuplesKt.to("change_type", BasicTestActionHandler.TEST_ACTION_RESET), TuplesKt.to(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE, "show_area"), TuplesKt.to("old_show_area_level", String.valueOf(this.f141768f)), TuplesKt.to("new_show_area_level", String.valueOf(this.f141764a.d()))}));
        j();
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.a
    public final ov2.a g() {
        return new a(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.a
    public final f h() {
        return new f(3, 262143);
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.a
    public final void j() {
        int r100 = this.f141764a.d();
        StringBuilder r101 = new StringBuilder();
        r101.append(r100);
        r101.append(34892);
        k(r101.toString());
        int r102 = 1;
        if (r100 != 1) goto L5;
        r102 = 0;
    L14:
        RangeSeekBar r103 = this.f141762d;
        if (r103 == null) goto L17;
        r103.setStep(r102);
    L17:
        this.f141768f = Integer.valueOf(r100);
        return;
    L5:
        if (r100 == 2) goto L14;
        if (r100 != 3) goto L9;
        r102 = 2;
        goto L14
    L9:
        if (r100 != 4) goto L14;
        r102 = 3;
        goto L14
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.a
    public final String i() {
        return s1.B(R.string.ttlive_barrage_simple_setting_area_title);
    }

    public d(o r100, SimpleZDanmakuSettingDialogFragment r101) {
        Intrinsics.checkNotNullParameter(r100, "danmakuSetting");
        Intrinsics.checkNotNullParameter(r101, "panelCallback");
        super(r100, r101);
    }
}
