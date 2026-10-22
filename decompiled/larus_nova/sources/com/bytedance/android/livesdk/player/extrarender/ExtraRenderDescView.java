package com.bytedance.android.livesdk.player.extrarender;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.livesdkapi.model.RenderDescInfo;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class ExtraRenderDescView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f155194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f155195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f155196c;

    private final SimpleDraweeView getIvAvatar() {
        return (SimpleDraweeView) this.f155194a.getValue();
    }

    private final TextView getTvDesc() {
        return (TextView) this.f155195b.getValue();
    }

    private final LinearLayout getWrapperView() {
        return (LinearLayout) this.f155196c.getValue();
    }

    public final void c() {
        getTvDesc().setText("");
        getIvAvatar().setActualImageResource(R.drawable.ttlive_player_icon_transpant);
    }

    public ExtraRenderDescView(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f155194a = LazyKt.lazy(new ExtraRenderDescView$ivAvatar$2(r100));
        this.f155195b = LazyKt.lazy(new ExtraRenderDescView$tvDesc$2(r100));
        this.f155196c = LazyKt.lazy(new ExtraRenderDescView$wrapperView$2(r100));
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        getWrapperView().addView(getIvAvatar());
        getWrapperView().addView(getTvDesc());
        addView(getWrapperView());
    }

    public final void a(boolean r100) {
        ViewGroup.LayoutParams r101 = null;
        if (r100 == false) goto L18;
        ViewGroup.LayoutParams r102 = getIvAvatar().getLayoutParams();
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == true) goto L7;
        r102 = null;
    L7:
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
        if (r103 == null) goto L10;
        r103.leftMargin = com.bytedance.android.livesdk.player.utils.h.b(10.0f);
    L10:
        ViewGroup.LayoutParams r104 = getWrapperView().getLayoutParams();
        if ((r104 instanceof ViewGroup.MarginLayoutParams) == false) goto L14;
        r101 = r104;
    L14:
        ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r101;
        if (r105 == null) goto L17;
        r105.bottomMargin = com.bytedance.android.livesdk.player.utils.h.b(4.0f);
        r105.topMargin = 0;
    L17:
        setBackground(com.bytedance.android.livesdk.player.utils.h.c(R.drawable.ttlive_player_bg_extra_render_desc_small));
        return;
    L18:
        ViewGroup.LayoutParams r106 = getIvAvatar().getLayoutParams();
        if ((r106 instanceof ViewGroup.MarginLayoutParams) == true) goto L21;
        r106 = null;
    L21:
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r106;
        if (r107 == null) goto L24;
        r107.leftMargin = com.bytedance.android.livesdk.player.utils.h.b(16.0f);
    L24:
        ViewGroup.LayoutParams r108 = getWrapperView().getLayoutParams();
        if ((r108 instanceof ViewGroup.MarginLayoutParams) == false) goto L28;
        r101 = r108;
    L28:
        ViewGroup.MarginLayoutParams r109 = (ViewGroup.MarginLayoutParams) r101;
        if (r109 == null) goto L31;
        r109.topMargin = com.bytedance.android.livesdk.player.utils.h.b(8.0f);
    L31:
        setBackground(com.bytedance.android.livesdk.player.utils.h.c(R.drawable.ttlive_player_bg_extra_render_desc));
    }

    public final boolean b(RenderDescInfo r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        getTvDesc().setText(r100.getNickName());
        int r101 = com.bytedance.android.livesdk.player.utils.d.f156214a;
        SimpleDraweeView r102 = getIvAvatar();
        String r103 = r100.getAvatar();
        if (r102 != null) goto L8;
    L11:
        return true;
    L8:
        if (TextUtils.isEmpty(r103) == true) goto L11;
        RoundingParams r104 = RoundingParams.fromCornersRadius(5.0f);
        r104.setRoundAsCircle(true);
        r102.getHierarchy().setRoundingParams(r104);
        r102.setImageURI(ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r103)).build().getSourceUri());
        goto L11
    }
}
