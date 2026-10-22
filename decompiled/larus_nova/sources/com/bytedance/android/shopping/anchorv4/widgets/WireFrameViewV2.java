package com.bytedance.android.shopping.anchorv4.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/widgets/WireFrameViewV2;", "Landroid/view/View;", "Landroid/graphics/Paint;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getPaint", "()Landroid/graphics/Paint;", "paint", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WireFrameViewV2 extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f170174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f170175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f170176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LinearGradient f170177d;

    private final Paint getPaint() {
        return (Paint) this.f170174a.getValue();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r310) {
        Intrinsics.checkNotNullParameter(r310, "canvas");
        float r110 = com.bytedance.android.shopping.extensions.b.a(Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_FIRST_PACKET_TIME));
        Paint r100 = getPaint();
        LinearGradient r101 = this.f170177d;
        if (r101 != null) goto L6;
        r101 = new LinearGradient(0.0f, 0.0f, 0.0f, r110, -1, (int) 4294309625L, Shader.TileMode.CLAMP);
        this.f170177d = r101;
        Unit r102 = Unit.INSTANCE;
    L6:
        r100.setShader(r101);
        r310.drawRect(0.0f, 0.0f, getWidth(), getHeight(), getPaint());
        getPaint().setShader(null);
        int r103 = (int) 4294375419L;
        getPaint().setColor(r103);
        float r111 = 2;
        float r104 = com.bytedance.android.shopping.extensions.b.a(1) / r111;
        r310.drawLine(0.0f, r104, getWidth(), r104, getPaint());
        float r105 = com.bytedance.android.shopping.extensions.b.a(16);
        float r106 = getWidth() - (r105 * r111);
        getPaint().setColor((int) 4294178039L);
        float r107 = com.bytedance.android.shopping.extensions.b.a(12);
        int r112 = 3;
        List r108 = CollectionsKt.listOf(new Float[]{Float.valueOf(com.bytedance.android.shopping.extensions.b.a(24)), Float.valueOf(com.bytedance.android.shopping.extensions.b.a(16)), Float.valueOf(com.bytedance.android.shopping.extensions.b.a(16))});
        Float[] r109 = {Float.valueOf(0.54f), Float.valueOf(1.0f), Float.valueOf(0.45f)};
        float r113 = r105;
        int r114 = 0;
        int r115 = 0;
    L7:
        if (r114 >= r112) goto L9;
        this.f170175b.set(r105, r113, (r109[r114].floatValue() * r106) + r105, ((Number) ListProtector.get(r108, r115)).floatValue() + r113);
        RectF r116 = this.f170175b;
        float r117 = this.f170176c;
        r310.drawRoundRect(r116, r117, r117, getPaint());
        r113 = this.f170175b.bottom + r107;
        r114 = r114 + 1;
        r115 = r115 + 1;
        r112 = 3;
        goto L7
    L9:
        float r118 = this.f170175b.bottom + r105;
        float r119 = com.bytedance.android.shopping.extensions.b.a(8);
        float r120 = r119 * r111;
        float r121 = getWidth() - r120;
        getPaint().setColor(-1);
        float r122 = com.bytedance.android.shopping.extensions.b.a(12);
        float r123 = com.bytedance.android.shopping.extensions.b.a(156) + r118;
        this.f170175b.set(r119, r118, r119 + r121, r123);
        r310.drawRoundRect(this.f170175b, r122, r122, getPaint());
        float r124 = com.bytedance.android.shopping.extensions.b.a(20);
        float r125 = com.bytedance.android.shopping.extensions.b.a(32);
        float r126 = com.bytedance.android.shopping.extensions.b.a(8);
        float r127 = com.bytedance.android.shopping.extensions.b.a(12);
        float r128 = (r121 - (r111 * r127)) - r126;
        float r129 = r118 + com.bytedance.android.shopping.extensions.b.a(16);
        Float[] r130 = {Float.valueOf(0.72f), Float.valueOf(0.6f), Float.valueOf(1.0f)};
        int r131 = 0;
        int r132 = 0;
    L10:
        int r210 = r103;
        if (r132 >= 3) goto L24;
        int r311 = r131 + 1;
        float r133 = r130[r132].floatValue();
        Float[] r312 = r130;
        Paint r134 = getPaint();
        float r313 = r111;
        if (r131 != 0) goto L15;
        int r314 = r132;
        long r135 = 4294309625L;
    L19:
        r134.setColor((int) r135);
        float r136 = r119 + r127;
        float r315 = r127;
        this.f170175b.set(r136, r129, r136 + r124, r129 + r124);
        RectF r137 = this.f170175b;
        float r138 = this.f170176c;
        r310.drawRoundRect(r137, r138, r138, getPaint());
        RectF r139 = this.f170175b;
        float r140 = r139.right;
        float r141 = r140 - r139.left;
        float r142 = r140 + r126;
        r139.left = r142;
        if (r131 != 2) goto L22;
        float r143 = r133 * ((r128 - r141) - r126);
    L23:
        r139.right = r142 + r143;
        float r144 = this.f170176c;
        r310.drawRoundRect(r139, r144, r144, getPaint());
        r129 = this.f170175b.bottom + r125;
        r132 = r314 + 1;
        r103 = r210;
        r131 = r311;
        r130 = r312;
        r111 = r313;
        r127 = r315;
        goto L10
    L22:
        r143 = r133 * r128;
        goto L23
    L15:
        r314 = r132;
        if (r131 != 1) goto L18;
        r135 = 3438671609L;
        goto L19
    L18:
        r135 = 2599810809L;
        goto L19
    L24:
        float r316 = r111;
        float r145 = r123 + com.bytedance.android.shopping.extensions.b.a(12);
        int r146 = 1;
    L26:
        if (r145 >= getHeight()) goto L40;
        float r147 = getWidth() - r120;
        int r148 = r146 + 1;
        getPaint().setColor(-1);
        float r149 = com.bytedance.android.shopping.extensions.b.a(12);
        float r150 = com.bytedance.android.shopping.extensions.b.a(156) + r145;
        this.f170175b.set(r119, r145, r119 + r147, r150);
        r310.drawRoundRect(this.f170175b, r149, r149, getPaint());
        List r151 = CollectionsKt.listOf(new Float[]{Float.valueOf(com.bytedance.android.shopping.extensions.b.a(20)), Float.valueOf(com.bytedance.android.shopping.extensions.b.a(204))});
        float r152 = com.bytedance.android.shopping.extensions.b.a(16);
        com.bytedance.android.shopping.extensions.b.a(8);
        float r153 = com.bytedance.android.shopping.extensions.b.a(12);
        float r154 = r147 - (r316 * r153);
        float r155 = r145 + com.bytedance.android.shopping.extensions.b.a(16);
        int r156 = 2;
        Float[] r157 = {Float.valueOf(0.54f), Float.valueOf(1.0f)};
        int r158 = 0;
        int r159 = 0;
    L28:
        if (r158 >= r156) goto L39;
        int r317 = r159 + 1;
        float r160 = r157[r158].floatValue();
        int r318 = r148;
        Paint r161 = getPaint();
        if (r159 != 0) goto L33;
        if (r146 != 0) goto L33;
        Float[] r319 = r157;
        long r162 = 4294309625L;
    L38:
        r161.setColor((int) r162);
        float r163 = r119 + r153;
        this.f170175b.set(r163, r155, (r160 * r154) + r163, ((Number) ListProtector.get(r151, r159)).floatValue() + r155);
        RectF r164 = this.f170175b;
        float r165 = this.f170176c;
        r310.drawRoundRect(r164, r165, r165, getPaint());
        r155 = this.f170175b.bottom + r152;
        r158 = r158 + 1;
        r120 = r120;
        r159 = r317;
        r148 = r318;
        r157 = r319;
        r156 = 2;
    L33:
        r319 = r157;
        if (r159 != 1) goto L37;
        if (r146 != 0) goto L37;
        r162 = 3438671609L;
    L37:
        r162 = 2599810809L;
        goto L38
    L39:
        r145 = r150 + com.bytedance.android.shopping.extensions.b.a(12);
        r120 = r120;
        r146 = r148;
        goto L26
    L40:
        float r166 = com.bytedance.android.shopping.extensions.b.a(60);
        float r167 = getWidth();
        float r168 = getHeight() - r166;
        getPaint().setColor(-1);
        float r169 = 0.0f + r167;
        this.f170175b.set(0.0f, r168, r169, r168 + r166);
        r310.drawRect(this.f170175b, getPaint());
        getPaint().setColor(r210);
        r310.drawLine(0.0f, r168, r169, r168, getPaint());
        getPaint().setColor((int) 4294309625L);
        float r170 = com.bytedance.android.shopping.extensions.b.a(16);
        float r171 = com.bytedance.android.shopping.extensions.b.a(36);
        float r172 = (r167 - (r170 * r316)) - (3 * r171);
        float r173 = r168 + (r166 / r316);
        float r174 = r171 / r316;
        float r175 = (0.0f + r170) + r174;
        int r176 = 0;
    L41:
        if (r176 >= 3) goto L46;
        r310.drawCircle(r175, r173, r174, getPaint());
        if (r176 >= 2) goto L45;
        r175 = r175 + ((0.06f * r172) + r171);
    L45:
        r176 = r176 + 1;
        goto L41
    L46:
        this.f170175b.set((r175 + r174) + (r172 * 0.09f), r173 - com.bytedance.android.shopping.extensions.b.a(22), r169 - r170, r173 + com.bytedance.android.shopping.extensions.b.a(22));
        float r177 = com.bytedance.android.shopping.extensions.b.a(22);
        r310.drawRoundRect(this.f170175b, r177, r177, getPaint());
    }

    public WireFrameViewV2(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f170174a = LazyKt.lazy(WireFrameViewV2$paint$2.INSTANCE);
        this.f170175b = new RectF();
        this.f170176c = com.bytedance.android.shopping.extensions.b.a(6);
    }
}
