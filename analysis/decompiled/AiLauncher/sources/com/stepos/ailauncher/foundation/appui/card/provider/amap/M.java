package com.stepos.ailauncher.foundation.appui.card.provider.amap;

import android.graphics.Outline;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.R$drawable;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/M;", "", "<init>", "()V", "Landroid/view/View;", "cardRoot", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;)V", "target", "", "radius", Const.INTENT_KEY_PKGNAME, "(Landroid/view/View;F)V", "CORNER_DP", "F", "BLUR_RADIUS", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class M {
    private static final float BLUR_RADIUS = 60.0f;
    private static final float CORNER_DP = 12.0f;
    public static final M INSTANCE = new M();

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/foundation/appui/card/provider/amap/M$a", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "LY8/t;", "getOutline", "(Landroid/view/View;Landroid/graphics/Outline;)V", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends ViewOutlineProvider {
        final /* synthetic */ float $radiusPx;

        public a(float f10) {
            this.$radiusPx = f10;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            kotlin.jvm.internal.p.i(view, "view");
            kotlin.jvm.internal.p.i(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.$radiusPx);
        }
    }

    public final void a(View cardRoot) {
        kotlin.jvm.internal.p.i(cardRoot, "cardRoot");
        cardRoot.setBackgroundResource(R$drawable.bg_poi_card);
        cardRoot.setOutlineProvider(new a(cardRoot.getResources().getDisplayMetrics().density * 12.0f));
        cardRoot.setClipToOutline(true);
        b(cardRoot, 60.0f);
    }

    public final void b(View target, float radius) {
        RenderEffect renderEffectCreateBlurEffect = RenderEffect.createBlurEffect(radius, radius, Shader.TileMode.CLAMP);
        kotlin.jvm.internal.p.h(renderEffectCreateBlurEffect, "createBlurEffect(...)");
        try {
            Result.Companion companion = Result.INSTANCE;
            Result.b(View.class.getMethod("setBackdropRenderEffect", RenderEffect.class).invoke(target, renderEffectCreateBlurEffect));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }
}
