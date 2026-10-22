package com.stepos.ailauncher.foundation.appui.card.provider.travel;

import N5.CardAction;
import Z8.C1173v;
import Z8.F;
import android.content.Context;
import android.graphics.Outline;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.ailauncher.common.imageloader.ImageDataSource;
import com.stepos.ailauncher.foundation.R$drawable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u0000 \"2\u00020\u0001:\u0001#B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001a\u0010\u000eJ\u001f\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u001b\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/f;", "LN5/d;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/widget/FrameLayout;", "container", "LY8/t;", ExifInterface.LONGITUDE_EAST, "(Landroid/widget/FrameLayout;)V", "LN5/n;", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "C", "(LN5/n;)V", "LT5/p;", "row", "Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/g;", "item", "Y", "(LT5/p;Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/g;)V", "coverHost", "X", "c0", "Landroid/widget/LinearLayout;", "itemContainer", "Landroid/widget/LinearLayout;", "", "coverRadiusPx", "F", "Companion", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class f extends N5.d {
    private static final float COVER_RADIUS_DP = 12.0f;
    private final float coverRadiusPx;
    private LinearLayout itemContainer;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/foundation/appui/card/provider/travel/f$b", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "LY8/t;", "getOutline", "(Landroid/view/View;Landroid/graphics/Outline;)V", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends ViewOutlineProvider {
        public b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            kotlin.jvm.internal.p.i(view, "view");
            kotlin.jvm.internal.p.i(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), f.this.coverRadiusPx);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.coverRadiusPx = getResources().getDisplayMetrics().density * 12.0f;
    }

    public static final void Z(String str, boolean z10, ImageDataSource source) {
        kotlin.jvm.internal.p.i(source, "source");
        if (z10) {
            R5.b.INSTANCE.c("hotel.cover.ok", Y8.j.a("url", str), Y8.j.a("source", source.name()));
        } else {
            R5.b.INSTANCE.h("hotel.cover.fail", Y8.j.a("url", str));
        }
    }

    public static final void a0(f fVar, CardAction cardAction, View view) {
        fVar.R(M5.e.ACTION_VIEW_DETAIL);
        N5.d.G(fVar, cardAction != null ? cardAction.getAppLink() : null, cardAction != null ? cardAction.getWebLink() : null, null, false, true, false, 44, null);
    }

    public static final void b0(f fVar, CardAction cardAction, View view) {
        fVar.R(M5.e.ACTION_VIEW_DETAIL);
        N5.d.G(fVar, cardAction != null ? cardAction.getAppLink() : null, cardAction != null ? cardAction.getWebLink() : null, null, false, true, false, 44, null);
    }

    @Override // N5.d
    public void C(N5.n model) {
        kotlin.jvm.internal.p.i(model, "model");
        if (model instanceof C3330b) {
            LinearLayout linearLayout = this.itemContainer;
            if (linearLayout == null) {
                kotlin.jvm.internal.p.A("itemContainer");
                linearLayout = null;
            }
            linearLayout.removeAllViews();
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
            int i10 = 0;
            for (Object obj : ((C3330b) model).b()) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    C1173v.w();
                }
                HotelItem hotelItem = (HotelItem) obj;
                LinearLayout linearLayout2 = this.itemContainer;
                if (linearLayout2 == null) {
                    kotlin.jvm.internal.p.A("itemContainer");
                    linearLayout2 = null;
                }
                T5.p pVarC = T5.p.c(layoutInflaterFrom, linearLayout2, false);
                kotlin.jvm.internal.p.h(pVarC, "inflate(...)");
                if (i10 == 0) {
                    ViewGroup.LayoutParams layoutParams = pVarC.b().getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
                    if (marginLayoutParams != null) {
                        marginLayoutParams.topMargin = 0;
                        pVarC.b().setLayoutParams(marginLayoutParams);
                    }
                }
                Y(pVarC, hotelItem);
                LinearLayout linearLayout3 = this.itemContainer;
                if (linearLayout3 == null) {
                    kotlin.jvm.internal.p.A("itemContainer");
                    linearLayout3 = null;
                }
                linearLayout3.addView(pVarC.b());
                i10 = i11;
            }
        }
    }

    @Override // N5.d
    public void E(FrameLayout container) {
        kotlin.jvm.internal.p.i(container, "container");
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        this.itemContainer = linearLayout;
        container.addView(linearLayout);
    }

    public final void X(FrameLayout coverHost) {
        coverHost.setOutlineProvider(new b());
        coverHost.setClipToOutline(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x012e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Y(T5.p r27, com.stepos.ailauncher.foundation.appui.card.provider.travel.HotelItem r28) {
        /*
            Method dump skipped, instructions count: 366
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.travel.f.Y(T5.p, com.stepos.ailauncher.foundation.appui.card.provider.travel.g):void");
    }

    public final void c0(T5.p row, HotelItem item) {
        N5.j jVar = N5.j.INSTANCE;
        HotelSecondaryInfo secondaryInfo = item.getSecondaryInfo();
        String strD = jVar.d(secondaryInfo != null ? secondaryInfo.getRating() : null);
        HotelSecondaryInfo secondaryInfo2 = item.getSecondaryInfo();
        String strD2 = jVar.d(secondaryInfo2 != null ? secondaryInfo2.getDistanceText() : null);
        HotelSecondaryInfo secondaryInfo3 = item.getSecondaryInfo();
        String strA0 = F.A0(C1173v.r(strD, strD2, jVar.d(secondaryInfo3 != null ? secondaryInfo3.getAddress() : null)), "  ", null, null, 0, null, null, 62, null);
        if (strA0.length() == 0) {
            row.tvHotelRating.setVisibility(8);
            row.tvHotelRating.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
        } else {
            row.tvHotelRating.setVisibility(0);
            row.tvHotelRating.setText(strA0);
            row.tvHotelRating.setCompoundDrawablesRelativeWithIntrinsicBounds(strD != null ? R$drawable.ic_card_hotel_rating : 0, 0, 0, 0);
        }
    }

    public /* synthetic */ f(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
