package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting;

import com.alibaba.gaiax.template.GXTemplateKey;
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
import kotlin.math.MathKt;
import p22.o;

/* JADX INFO: loaded from: classes9.dex */
public final class c extends com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f141766f;

    public static final class a {
    }

    public static final class b implements ov2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f141767a;

        @Override // ov2.a
        public final void a() {
        }

        @Override // ov2.a
        public final void c(RangeSeekBar r100, int r101, boolean r102) {
        }

        @Override // ov2.a
        public final void b() {
            c r100 = this.f141767a;
            ChangeSettingSource r101 = ChangeSettingSource.SETTING_PANEL_ALPHA;
            r100.getClass();
            Intrinsics.checkNotNullParameter(r101, "source");
            r100.f141765b.yR(r101);
            this.f141767a.f141765b.dR();
            this.f141767a.f(MapsKt.mapOf(new Pair[]{TuplesKt.to("change_type", "slide"), TuplesKt.to(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE, GXTemplateKey.STYLE_OPACITY), TuplesKt.to("old_opacity_level", String.valueOf(this.f141767a.f141766f)), TuplesKt.to("new_opacity_level", String.valueOf(MathKt.roundToInt(this.f141767a.f141764a.b())))}));
            c r102 = this.f141767a;
            r102.f141766f = Integer.valueOf(MathKt.roundToInt(r102.f141764a.b()));
        }

        public b(c r100) {
            this.f141767a = r100;
        }

        @Override // ov2.a
        public final void d(RangeSeekBar r100, float r101) {
            if (r100 == null) goto L4;
            int r102 = r100.getStepCount();
        L5:
            if (r102 > 0) goto L8;
            this.f141767a.getClass();
            int r103 = MathKt.roundToInt((((int) r101) * 0.8f) + 20.0f);
            c r104 = this.f141767a;
            r104.getClass();
            r104.k(String.valueOf(r103) + GXTemplateKey.GAIAX_PE);
            this.f141767a.f141764a.g((float) r103);
            return;
        L8:
            return;
        L4:
            r102 = 0;
            goto L5
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.b
    public final int a() {
        return R.id.alpha_container;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.b
    public final void b() {
        f(MapsKt.mapOf(new Pair[]{TuplesKt.to("change_type", BasicTestActionHandler.TEST_ACTION_RESET), TuplesKt.to(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE, GXTemplateKey.STYLE_OPACITY), TuplesKt.to("old_opacity_level", String.valueOf(this.f141766f)), TuplesKt.to("new_opacity_level", String.valueOf(MathKt.roundToInt(this.f141764a.b())))}));
        j();
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.a
    public final ov2.a g() {
        return new b(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.a
    public final f h() {
        return new f(0, 524287);
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.a
    public final void j() {
        float r100 = this.f141764a.b();
        int r101 = MathKt.roundToInt((r100 - 20.0f) / 0.8f);
        k(String.valueOf(MathKt.roundToInt(r100)) + GXTemplateKey.GAIAX_PE);
        float r102 = (float) r101;
        RangeSeekBar r103 = this.f141762d;
        if (r103 == null) goto L5;
        r103.setProgress(r102);
    L5:
        this.f141766f = Integer.valueOf(MathKt.roundToInt(r100));
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.a
    public final String i() {
        return s1.B(R.string.ttlive_barrage_simple_setting_alpha_title);
    }

    public c(o r100, SimpleZDanmakuSettingDialogFragment r101) {
        Intrinsics.checkNotNullParameter(r100, "danmakuSetting");
        Intrinsics.checkNotNullParameter(r101, "panelCallback");
        super(r100, r101);
    }
}
