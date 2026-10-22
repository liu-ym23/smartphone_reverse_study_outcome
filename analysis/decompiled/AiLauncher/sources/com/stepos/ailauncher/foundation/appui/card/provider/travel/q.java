package com.stepos.ailauncher.foundation.appui.card.provider.travel;

import La.H;
import N5.CardAction;
import Z8.C1173v;
import Z8.F;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.ailauncher.common.imageloader.ImageRequest;
import com.stepos.ailauncher.foundation.R$drawable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.text.Regex;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 52\u00020\u0001:\u00016B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001b\u0010!\u001a\u0004\u0018\u00010\u001b2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0004\b!\u0010\"J!\u0010#\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001bH\u0002¢\u0006\u0004\b&\u0010'J!\u0010)\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u001bH\u0002¢\u0006\u0004\b)\u0010*J'\u0010+\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b+\u0010\u001aJ\u0019\u0010,\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b,\u0010-J\u0017\u00100\u001a\u00020\f2\u0006\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b0\u00101R\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b3\u00104¨\u00067"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/q;", "LN5/d;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/widget/FrameLayout;", "container", "LY8/t;", ExifInterface.LONGITUDE_EAST, "(Landroid/widget/FrameLayout;)V", "LN5/n;", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "C", "(LN5/n;)V", "LT5/y;", "row", "Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/s;", "item", "Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/TransportType;", "transportType", "Y", "(LT5/y;Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/s;Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/TransportType;)V", "", "iconUrl", "b0", "(LT5/y;Ljava/lang/String;)V", "Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/r;", "endpoint", "g0", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/r;)Ljava/lang/String;", "j0", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/s;Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/TransportType;)Ljava/lang/String;", "title", "e0", "(Ljava/lang/String;)Ljava/lang/String;", "compactTitle", "h0", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/s;Ljava/lang/String;)Ljava/lang/String;", "d0", "i0", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/s;)Ljava/lang/String;", "Landroid/widget/TextView;", "textView", "X", "(Landroid/widget/TextView;)V", "Landroid/widget/LinearLayout;", "itemContainer", "Landroid/widget/LinearLayout;", "Companion", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class q extends N5.d {
    private static final int ILLUSTRATION_WIDTH_FLIGHT_DP = 95;
    private static final int ILLUSTRATION_WIDTH_TRAIN_DP = 97;
    private LinearLayout itemContainer;
    private static final Regex TRAIN_NUMBER_GAP_REGEX = new Regex("([A-Za-z]+)[\\s\\u00A0\\u3000]+(\\d+)");
    private static final List<String> TRAIN_TYPE_NAMES = C1173v.p("复兴号", "动感号", "和谐号", "CRH", "CR400");

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TransportType.values().length];
            try {
                iArr[TransportType.TRAIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TransportType.FLIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public static final void Z(q qVar, CardAction cardAction, View view) {
        qVar.R(M5.e.ACTION_VIEW_DETAIL);
        N5.d.G(qVar, cardAction != null ? cardAction.getAppLink() : null, cardAction != null ? cardAction.getWebLink() : null, null, false, true, false, 44, null);
    }

    public static final void a0(q qVar, CardAction cardAction, View view) {
        qVar.R(M5.e.ACTION_VIEW_DETAIL);
        N5.d.G(qVar, cardAction != null ? cardAction.getAppLink() : null, cardAction != null ? cardAction.getWebLink() : null, null, false, true, false, 44, null);
    }

    public static final void c0(ImageView imageView, String str, boolean z10) {
        if (z10) {
            return;
        }
        imageView.setVisibility(8);
        R5.b.INSTANCE.h("view.transport.leadingIcon.fail", Y8.j.a("url", str));
    }

    public static final CharSequence f0(La.m it) {
        kotlin.jvm.internal.p.i(it, "it");
        String str = it.c().get(1);
        String str2 = it.c().get(2);
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) str);
        sb2.append((Object) str2);
        return sb2.toString();
    }

    @Override // N5.d
    public void C(N5.n model) {
        kotlin.jvm.internal.p.i(model, "model");
        if (model instanceof l) {
            LinearLayout linearLayout = this.itemContainer;
            if (linearLayout == null) {
                kotlin.jvm.internal.p.A("itemContainer");
                linearLayout = null;
            }
            linearLayout.removeAllViews();
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
            l lVar = (l) model;
            int i10 = 0;
            for (Object obj : lVar.b()) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    C1173v.w();
                }
                TransportItem transportItem = (TransportItem) obj;
                LinearLayout linearLayout2 = this.itemContainer;
                if (linearLayout2 == null) {
                    kotlin.jvm.internal.p.A("itemContainer");
                    linearLayout2 = null;
                }
                T5.y yVarC = T5.y.c(layoutInflaterFrom, linearLayout2, false);
                kotlin.jvm.internal.p.h(yVarC, "inflate(...)");
                if (i10 == 0) {
                    ViewGroup.LayoutParams layoutParams = yVarC.b().getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
                    if (marginLayoutParams != null) {
                        marginLayoutParams.topMargin = 0;
                        yVarC.b().setLayoutParams(marginLayoutParams);
                    }
                }
                Y(yVarC, transportItem, lVar.getTransportType());
                LinearLayout linearLayout3 = this.itemContainer;
                if (linearLayout3 == null) {
                    kotlin.jvm.internal.p.A("itemContainer");
                    linearLayout3 = null;
                }
                linearLayout3.addView(yVarC.b());
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

    public final void X(TextView textView) {
        String string;
        CharSequence text = textView.getText();
        if (text == null || (string = text.toString()) == null || string.length() == 0) {
            return;
        }
        textView.getPaint().getTextBounds(string, 0, string.length(), new Rect());
        textView.setTranslationY(textView.getPaint().ascent() - r0.top);
    }

    public final void Y(T5.y row, TransportItem item, TransportType transportType) {
        Pair pairA;
        TransportEndpoint arrival;
        TransportEndpoint departure;
        CardPrimaryInfo primaryInfo = item.getPrimaryInfo();
        b0(row, primaryInfo != null ? primaryInfo.getIcon() : null);
        ImageView ivTransportIllustration = row.ivTransportIllustration;
        kotlin.jvm.internal.p.h(ivTransportIllustration, "ivTransportIllustration");
        int i10 = b.$EnumSwitchMapping$0[transportType.ordinal()];
        boolean z10 = true;
        if (i10 == 1) {
            pairA = Y8.j.a(Integer.valueOf(R$drawable.ic_card_transport_train), 97);
        } else {
            if (i10 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            pairA = Y8.j.a(Integer.valueOf(R$drawable.ic_card_transport_plane), 95);
        }
        int iIntValue = ((Number) pairA.a()).intValue();
        int iIntValue2 = ((Number) pairA.b()).intValue();
        ivTransportIllustration.setImageResource(iIntValue);
        ViewGroup.LayoutParams layoutParams = ivTransportIllustration.getLayoutParams();
        layoutParams.width = (int) (iIntValue2 * getResources().getDisplayMetrics().density);
        layoutParams.height = -2;
        ivTransportIllustration.setLayoutParams(layoutParams);
        TextView tvTransportTitle = row.tvTransportTitle;
        kotlin.jvm.internal.p.h(tvTransportTitle, "tvTransportTitle");
        n(tvTransportTitle, j0(item, transportType));
        d0(row, item, transportType);
        TransportSchedule schedule = item.getSchedule();
        TextView tvDepTime = row.tvDepTime;
        kotlin.jvm.internal.p.h(tvDepTime, "tvDepTime");
        n(tvDepTime, (schedule == null || (departure = schedule.getDeparture()) == null) ? null : departure.getTime());
        TextView tvDepPlace = row.tvDepPlace;
        kotlin.jvm.internal.p.h(tvDepPlace, "tvDepPlace");
        n(tvDepPlace, g0(schedule != null ? schedule.getDeparture() : null));
        TextView tvArrTime = row.tvArrTime;
        kotlin.jvm.internal.p.h(tvArrTime, "tvArrTime");
        n(tvArrTime, (schedule == null || (arrival = schedule.getArrival()) == null) ? null : arrival.getTime());
        TextView tvArrPlace = row.tvArrPlace;
        kotlin.jvm.internal.p.h(tvArrPlace, "tvArrPlace");
        n(tvArrPlace, g0(schedule != null ? schedule.getArrival() : null));
        TextView tvDuration = row.tvDuration;
        kotlin.jvm.internal.p.h(tvDuration, "tvDuration");
        n(tvDuration, schedule != null ? schedule.getDurationText() : null);
        if (transportType == TransportType.TRAIN) {
            TextView tvDepTime2 = row.tvDepTime;
            kotlin.jvm.internal.p.h(tvDepTime2, "tvDepTime");
            X(tvDepTime2);
            TextView tvArrTime2 = row.tvArrTime;
            kotlin.jvm.internal.p.h(tvArrTime2, "tvArrTime");
            X(tvArrTime2);
        }
        N5.j jVar = N5.j.INSTANCE;
        TransportPrice price = item.getPrice();
        String strA = jVar.a(price != null ? price.getAmount() : null);
        if (strA.length() == 0) {
            row.llTransportPriceGroup.setVisibility(8);
        } else {
            row.llTransportPriceGroup.setVisibility(0);
            row.tvTransportPrice.setText(strA);
        }
        final CardAction action = item.getAction();
        String appLink = action != null ? action.getAppLink() : null;
        if (appLink == null || H.x0(appLink)) {
            String webLink = action != null ? action.getWebLink() : null;
            if (webLink == null || H.x0(webLink)) {
                z10 = false;
            }
        }
        if (z10) {
            row.btnTransportAction.setVisibility(0);
            row.btnTransportAction.setText("预定");
            row.btnTransportAction.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.travel.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    q.Z(this.f27404a, action, view);
                }
            });
        } else {
            row.btnTransportAction.setVisibility(8);
        }
        if (z10) {
            row.b().setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.travel.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    q.a0(this.f27406a, action, view);
                }
            });
        } else {
            row.b().setOnClickListener(null);
            row.b().setClickable(false);
        }
    }

    public final void b0(T5.y row, String iconUrl) {
        final String strD = N5.j.INSTANCE.d(iconUrl);
        final ImageView ivTransportIcon = row.ivTransportIcon;
        kotlin.jvm.internal.p.h(ivTransportIcon, "ivTransportIcon");
        if (strD == null) {
            ivTransportIcon.setVisibility(8);
            ivTransportIcon.setImageDrawable(null);
            return;
        }
        ivTransportIcon.setVisibility(0);
        com.stepos.ailauncher.common.imageloader.g.s(com.stepos.ailauncher.common.imageloader.g.INSTANCE, ivTransportIcon, new ImageRequest(strD, 0, 0, null, null, 0, 0, 0, 0, false, null, false, false, true, false, null, 0.0f, false, 253950, null), new com.stepos.ailauncher.common.imageloader.a() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.travel.m
            @Override // com.stepos.ailauncher.common.imageloader.a
            public final void a(boolean z10) {
                q.c0(ivTransportIcon, strD, z10);
            }
        }, null, getContext().getApplicationContext(), 8, null);
    }

    public final void d0(T5.y row, TransportItem item, TransportType transportType) {
        N5.j jVar = N5.j.INSTANCE;
        CardPrimaryInfo primaryInfo = item.getPrimaryInfo();
        String strD = jVar.d(primaryInfo != null ? primaryInfo.getSubtitle() : null);
        String strI0 = transportType != TransportType.TRAIN ? i0(item) : null;
        int i10 = 8;
        if (strD == null && strI0 == null) {
            row.llTransportSubtitle.setVisibility(8);
            return;
        }
        row.llTransportSubtitle.setVisibility(0);
        if (strD != null) {
            row.tvTransportCabin.setVisibility(0);
            row.tvTransportCabin.setText(strD);
        } else {
            row.tvTransportCabin.setVisibility(8);
        }
        if (strI0 != null) {
            row.tvTransportStop.setVisibility(0);
            row.tvTransportStop.setText(strI0);
        } else {
            row.tvTransportStop.setVisibility(8);
        }
        View view = row.vTransportSubtitleDivider;
        if (strD != null && strI0 != null) {
            i10 = 0;
        }
        view.setVisibility(i10);
    }

    public final String e0(String title) {
        return TRAIN_NUMBER_GAP_REGEX.m(H.D1(title).toString(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.travel.n
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return q.f0((La.m) obj);
            }
        });
    }

    public final String g0(TransportEndpoint endpoint) {
        if (endpoint == null) {
            return null;
        }
        N5.j jVar = N5.j.INSTANCE;
        String strA0 = F.A0(C1173v.r(jVar.d(endpoint.getCity()), jVar.d(endpoint.getPlace())), " ", null, null, 0, null, null, 62, null);
        if (strA0.length() > 0) {
            return strA0;
        }
        return null;
    }

    public final String h0(TransportItem item, String compactTitle) {
        Object next;
        N5.j jVar = N5.j.INSTANCE;
        TransportSecondaryInfo secondaryInfo = item.getSecondaryInfo();
        String strD = jVar.d(secondaryInfo != null ? secondaryInfo.getTrainType() : null);
        TransportSecondaryInfo secondaryInfo2 = item.getSecondaryInfo();
        List<String> listB = secondaryInfo2 != null ? secondaryInfo2.b() : null;
        if (listB == null) {
            listB = C1173v.m();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listB.iterator();
        while (it.hasNext()) {
            String strD2 = N5.j.INSTANCE.d((String) it.next());
            if (strD2 != null) {
                arrayList.add(strD2);
            }
        }
        Iterator it2 = arrayList.iterator();
        loop1: while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            String str = (String) next;
            List<String> list = TRAIN_TYPE_NAMES;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it3 = list.iterator();
                while (it3.hasNext()) {
                    if (H.g0(str, (String) it3.next(), false, 2, null)) {
                        break loop1;
                    }
                }
            }
        }
        String str2 = (String) next;
        if (strD == null) {
            if (str2 == null) {
                return null;
            }
            strD = str2;
        }
        if (H.g0(compactTitle, strD, false, 2, null)) {
            return null;
        }
        return strD;
    }

    public final String i0(TransportItem item) {
        Object next;
        N5.j jVar = N5.j.INSTANCE;
        TransportSecondaryInfo secondaryInfo = item.getSecondaryInfo();
        Object obj = null;
        String strD = jVar.d(secondaryInfo != null ? secondaryInfo.getStopType() : null);
        if (strD != null) {
            return strD;
        }
        TransportSecondaryInfo secondaryInfo2 = item.getSecondaryInfo();
        List<String> listB = secondaryInfo2 != null ? secondaryInfo2.b() : null;
        if (listB == null) {
            listB = C1173v.m();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listB.iterator();
        while (it.hasNext()) {
            String strD2 = N5.j.INSTANCE.d((String) it.next());
            if (strD2 != null) {
                arrayList.add(strD2);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            String str = (String) next;
            if (H.g0(str, "中转", false, 2, null) || H.g0(str, "转机", false, 2, null)) {
                break;
            }
        }
        String str2 = (String) next;
        if (str2 != null) {
            return str2;
        }
        for (Object obj2 : arrayList) {
            String str3 = (String) obj2;
            if (H.g0(str3, "直飞", false, 2, null) || H.g0(str3, "直达", false, 2, null)) {
                obj = obj2;
                break;
            }
        }
        return (String) obj;
    }

    public final String j0(TransportItem item, TransportType transportType) {
        N5.j jVar = N5.j.INSTANCE;
        CardPrimaryInfo primaryInfo = item.getPrimaryInfo();
        String strD = jVar.d(primaryInfo != null ? primaryInfo.getTitle() : null);
        if (strD == null) {
            return null;
        }
        if (transportType != TransportType.TRAIN) {
            return strD;
        }
        String strE0 = e0(strD);
        String strH0 = h0(item, strE0);
        if (strH0 == null) {
            return strE0;
        }
        return strH0 + " " + strE0;
    }

    public /* synthetic */ q(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
