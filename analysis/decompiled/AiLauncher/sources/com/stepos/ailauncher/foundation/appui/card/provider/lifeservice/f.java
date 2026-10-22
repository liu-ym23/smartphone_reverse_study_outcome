package com.stepos.ailauncher.foundation.appui.card.provider.lifeservice;

import N5.n;
import T5.q;
import Y8.j;
import Z8.F;
import android.content.Context;
import android.graphics.Outline;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.ailauncher.common.imageloader.ImageRequest;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiLiveClickReceiver;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000  2\u00020\u0001:\u0001!B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/lifeservice/f;", "LN5/d;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/widget/FrameLayout;", "container", "LY8/t;", ExifInterface.LONGITUDE_EAST, "(Landroid/widget/FrameLayout;)V", "LN5/n;", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "C", "(LN5/n;)V", "Landroid/view/View;", "view", "", "radiusDp", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Landroid/view/View;F)V", "Lcom/stepos/ailauncher/foundation/appui/card/provider/lifeservice/c;", ExifInterface.LONGITUDE_WEST, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/lifeservice/c;)V", "Y", "LT5/q;", "itemBinding", "LT5/q;", "Companion", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class f extends N5.d {
    private static final float BRAND_ICON_CORNER_DP = 4.0f;
    private static final float SERVICE_ICON_CORNER_DP = 8.0f;
    private static final String SERVICE_TITLE_FALLBACK = "点击查看详情";
    private q itemBinding;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/foundation/appui/card/provider/lifeservice/f$b", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "v", "Landroid/graphics/Outline;", "outline", "LY8/t;", "getOutline", "(Landroid/view/View;Landroid/graphics/Outline;)V", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends ViewOutlineProvider {
        final /* synthetic */ float $radiusPx;

        public b(float f10) {
            this.$radiusPx = f10;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View v10, Outline outline) {
            p.i(v10, "v");
            p.i(outline, "outline");
            outline.setRoundRect(0, 0, v10.getWidth(), v10.getHeight(), this.$radiusPx);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        p.i(context, "context");
    }

    public static final void X(String str, boolean z10) {
        if (z10) {
            return;
        }
        R5.b.INSTANCE.h("view.lifeService.serviceIcon.fail", j.a("url", str));
    }

    public static final void Z(f fVar, c cVar, String str, String str2, View view) {
        fVar.R(M5.e.ACTION_VIEW_DETAIL);
        R5.b.INSTANCE.c("view.lifeService.click", j.a("taskId", cVar.getCardId()), j.a(AlipayXuiLiveClickReceiver.EXTRA_APP_LINK, str == null ? "null" : str), j.a("webLink", str2 != null ? str2 : "null"));
        N5.d.G(fVar, str, str2, null, false, false, false, 60, null);
    }

    @Override // N5.d
    public void C(n model) {
        p.i(model, "model");
        if (model instanceof c) {
            c cVar = (c) model;
            W(cVar);
            Y(cVar);
        }
    }

    @Override // N5.d
    public void E(FrameLayout container) {
        p.i(container, "container");
        q qVarC = q.c(LayoutInflater.from(getContext()), container, true);
        p.h(qVarC, "inflate(...)");
        this.itemBinding = qVarC;
        getBinding().tvCardTitle.setVisibility(8);
        getBinding().tvCardStatus.setVisibility(8);
        q qVar = this.itemBinding;
        q qVar2 = null;
        if (qVar == null) {
            p.A("itemBinding");
            qVar = null;
        }
        ImageView ivBrandIcon = qVar.ivBrandIcon;
        p.h(ivBrandIcon, "ivBrandIcon");
        V(ivBrandIcon, 4.0f);
        q qVar3 = this.itemBinding;
        if (qVar3 == null) {
            p.A("itemBinding");
        } else {
            qVar2 = qVar3;
        }
        ImageView ivServiceIcon = qVar2.ivServiceIcon;
        p.h(ivServiceIcon, "ivServiceIcon");
        V(ivServiceIcon, 8.0f);
    }

    public final void V(View view, float radiusDp) {
        view.setOutlineProvider(new b(radiusDp * getResources().getDisplayMetrics().density));
        view.setClipToOutline(true);
    }

    public final void W(c model) {
        LifeServiceMedia media;
        q qVar = this.itemBinding;
        String icon = null;
        if (qVar == null) {
            p.A("itemBinding");
            qVar = null;
        }
        ImageView ivServiceIcon = qVar.ivServiceIcon;
        p.h(ivServiceIcon, "ivServiceIcon");
        N5.j jVar = N5.j.INSTANCE;
        LifeServiceItem lifeServiceItem = (LifeServiceItem) F.s0(model.b());
        if (lifeServiceItem != null && (media = lifeServiceItem.getMedia()) != null) {
            icon = media.getIcon();
        }
        final String strD = jVar.d(icon);
        R5.b.INSTANCE.e("view.lifeService.serviceIcon:" + model.getCardId(), "view.lifeService.serviceIcon", j.a("taskId", model.getCardId()), j.a("mediaIcon", strD == null ? "null" : strD));
        if (strD == null) {
            ivServiceIcon.setVisibility(8);
        } else {
            ivServiceIcon.setVisibility(0);
            com.stepos.ailauncher.common.imageloader.g.s(com.stepos.ailauncher.common.imageloader.g.INSTANCE, ivServiceIcon, new ImageRequest(strD, 0, 0, null, null, 0, 0, 0, 0, false, null, false, false, false, false, null, 0.0f, false, 262142, null), new com.stepos.ailauncher.common.imageloader.a() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.lifeservice.e
                @Override // com.stepos.ailauncher.common.imageloader.a
                public final void a(boolean z10) {
                    f.X(strD, z10);
                }
            }, null, getContext().getApplicationContext(), 8, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Y(final com.stepos.ailauncher.foundation.appui.card.provider.lifeservice.c r14) {
        /*
            Method dump skipped, instructions count: 338
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.lifeservice.f.Y(com.stepos.ailauncher.foundation.appui.card.provider.lifeservice.c):void");
    }

    public /* synthetic */ f(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
