package com.stepos.ailauncher.foundation.appui.card.provider.travel;

import N5.CardAction;
import Z8.C1173v;
import Z8.F;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.ailauncher.foundation.R$drawable;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001d\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b\u001d\u0010\u001cJ\u0019\u0010\u001f\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/B;", "LN5/d;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", UxipConstants.f30680s, "X", "(I)I", "Landroid/widget/FrameLayout;", "container", "LY8/t;", ExifInterface.LONGITUDE_EAST, "(Landroid/widget/FrameLayout;)V", "LN5/n;", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "C", "(LN5/n;)V", ExifInterface.LONGITUDE_WEST, "()V", "Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/s;", "item", "", "d0", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/s;)Ljava/lang/String;", "c0", "Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/g;", "Y", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/g;)Ljava/lang/String;", "LT5/z;", "comboBinding", "LT5/z;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class B extends N5.d {
    private T5.z comboBinding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
    }

    private final int X(int value) {
        return (int) (value * getResources().getDisplayMetrics().density);
    }

    public static final void Z(TransportItem transportItem, B b10, View view) {
        CardAction action;
        CardAction action2;
        CardAction action3;
        CardAction action4;
        String webLink = null;
        String appLink = (transportItem == null || (action4 = transportItem.getAction()) == null) ? null : action4.getAppLink();
        if (appLink == null || appLink.length() == 0) {
            String webLink2 = (transportItem == null || (action = transportItem.getAction()) == null) ? null : action.getWebLink();
            if (webLink2 == null || webLink2.length() == 0) {
                return;
            }
        }
        b10.R(M5.e.ACTION_VIEW_DETAIL);
        String appLink2 = (transportItem == null || (action3 = transportItem.getAction()) == null) ? null : action3.getAppLink();
        if (transportItem != null && (action2 = transportItem.getAction()) != null) {
            webLink = action2.getWebLink();
        }
        N5.d.G(b10, appLink2, webLink, null, false, true, false, 44, null);
    }

    public static final void a0(HotelItem hotelItem, B b10, View view) {
        CardAction action;
        CardAction action2;
        CardAction action3;
        CardAction action4;
        String webLink = null;
        String appLink = (hotelItem == null || (action4 = hotelItem.getAction()) == null) ? null : action4.getAppLink();
        if (appLink == null || appLink.length() == 0) {
            String webLink2 = (hotelItem == null || (action = hotelItem.getAction()) == null) ? null : action.getWebLink();
            if (webLink2 == null || webLink2.length() == 0) {
                return;
            }
        }
        b10.R(M5.e.ACTION_VIEW_DETAIL);
        String appLink2 = (hotelItem == null || (action3 = hotelItem.getAction()) == null) ? null : action3.getAppLink();
        if (hotelItem != null && (action2 = hotelItem.getAction()) != null) {
            webLink = action2.getWebLink();
        }
        N5.d.G(b10, appLink2, webLink, null, false, true, false, 44, null);
    }

    public static final void b0(B b10, CardAction cardAction, View view) {
        b10.R(M5.e.ACTION_VIEW_DETAIL);
        N5.d.G(b10, cardAction != null ? cardAction.getAppLink() : null, cardAction != null ? cardAction.getWebLink() : null, null, false, true, false, 44, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x00fb  */
    @Override // N5.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void C(N5.n r7) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.travel.B.C(N5.n):void");
    }

    @Override // N5.d
    public void E(FrameLayout container) {
        kotlin.jvm.internal.p.i(container, "container");
        W();
        T5.z zVarB = T5.z.b(LayoutInflater.from(getContext()), container, true);
        kotlin.jvm.internal.p.h(zVarB, "inflate(...)");
        this.comboBinding = zVarB;
    }

    public final void W() {
        int iX = X(12);
        LinearLayout linearLayout = getBinding().llCardBody;
        linearLayout.setBackgroundResource(R$drawable.bg_card_shell);
        linearLayout.setPadding(iX, iX, iX, iX);
        FrameLayout frameLayout = getBinding().flCustomContent;
        ViewGroup.LayoutParams layoutParams = getBinding().flCustomContent.getLayoutParams();
        kotlin.jvm.internal.p.g(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.topMargin = 0;
        frameLayout.setLayoutParams(marginLayoutParams);
    }

    public final String Y(HotelItem item) {
        String str;
        Integer nights;
        if (item == null) {
            return "";
        }
        N5.j jVar = N5.j.INSTANCE;
        HotelSchedule schedule = item.getSchedule();
        String checkIn = schedule != null ? schedule.getCheckIn() : null;
        HotelSchedule schedule2 = item.getSchedule();
        String strE = jVar.e(checkIn, schedule2 != null ? schedule2.getCheckOut() : null);
        HotelSchedule schedule3 = item.getSchedule();
        if (schedule3 == null || (nights = schedule3.getNights()) == null) {
            str = null;
        } else {
            str = nights.intValue() + "晚";
        }
        return F.A0(C1173v.r(strE.length() > 0 ? strE : null, str), " | ", null, null, 0, null, null, 62, null);
    }

    public final String c0(TransportItem item) {
        TransportEndpoint arrival;
        TransportEndpoint departure;
        if (item == null) {
            return "";
        }
        N5.j jVar = N5.j.INSTANCE;
        TransportSchedule schedule = item.getSchedule();
        String strD = jVar.d((schedule == null || (departure = schedule.getDeparture()) == null) ? null : departure.getTime());
        TransportSchedule schedule2 = item.getSchedule();
        String strA0 = F.A0(C1173v.r(strD, jVar.d((schedule2 == null || (arrival = schedule2.getArrival()) == null) ? null : arrival.getTime())), O6.l.DATE_SEPARATOR, null, null, 0, null, null, 62, null);
        CardPrimaryInfo primaryInfo = item.getPrimaryInfo();
        return F.A0(C1173v.r(strA0.length() > 0 ? strA0 : null, jVar.d(primaryInfo != null ? primaryInfo.getTitle() : null)), " | ", null, null, 0, null, null, 62, null);
    }

    public final String d0(TransportItem item) {
        TransportEndpoint arrival;
        TransportEndpoint departure;
        if (item == null) {
            return "";
        }
        N5.j jVar = N5.j.INSTANCE;
        TransportSchedule schedule = item.getSchedule();
        String strD = jVar.d((schedule == null || (departure = schedule.getDeparture()) == null) ? null : departure.getCity());
        TransportSchedule schedule2 = item.getSchedule();
        String strD2 = jVar.d((schedule2 == null || (arrival = schedule2.getArrival()) == null) ? null : arrival.getCity());
        if (strD == null || strD2 == null) {
            CardPrimaryInfo primaryInfo = item.getPrimaryInfo();
            String strD3 = jVar.d(primaryInfo != null ? primaryInfo.getTitle() : null);
            return strD3 == null ? "" : strD3;
        }
        return strD + " - " + strD2;
    }

    public /* synthetic */ B(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
