package com.stepos.ailauncher.foundation.appui.card.provider.amap;

import N5.CardAction;
import N5.CardEnvelope;
import Z8.C1173v;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
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
import com.stepos.agentframework.uikit.IndeterminateSpinnerView;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.ailauncher.foundation.R$color;
import com.stepos.ailauncher.foundation.R$drawable;
import com.stepos.ailauncher.taskstore.provider.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 E2\u00020\u0001:\u0001FB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001a\u0010\u0010J\u000f\u0010\u001b\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001b\u0010\u0010J\u0017\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010\"\u001a\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010 H\u0002¢\u0006\u0004\b\"\u0010#J\u001b\u0010&\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010$H\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b(\u0010\u001fJ\u001d\u0010,\u001a\u00020\f2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020*0)H\u0002¢\u0006\u0004\b,\u0010-J\u001d\u00100\u001a\u00020\f2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020.0)H\u0002¢\u0006\u0004\b0\u0010-J'\u00106\u001a\u00020\f2\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u00020.2\u0006\u00105\u001a\u000204H\u0002¢\u0006\u0004\b6\u00107R\u0016\u00109\u001a\u0002088\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b9\u0010:R\u001c\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001c0)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010=\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u001c\u0010?\u001a\b\u0012\u0004\u0012\u00020.0)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010<R\u0016\u0010@\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010C\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010D¨\u0006G"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/r0;", "LN5/d;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/widget/FrameLayout;", "container", "LY8/t;", ExifInterface.LONGITUDE_EAST, "(Landroid/widget/FrameLayout;)V", "onAttachedToWindow", "()V", "onDetachedFromWindow", "LN5/n;", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "C", "(LN5/n;)V", "LN5/i;", "envelope", "D", "(LN5/i;LN5/n;)V", "h0", "j0", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/H0;", "mode", "b0", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/H0;)V", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/I0;", c.a.COL_SUMMARY, "c0", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/I0;)V", "", "raw", "k0", "(Ljava/lang/String;)Ljava/lang/String;", "Z", "", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/b;", "tags", "d0", "(Ljava/util/List;)V", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/J0;", "waypoints", "g0", "LT5/v;", "row", "wp", "", "isLast", "e0", "(LT5/v;Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/J0;Z)V", "LT5/u;", "routeBinding", "LT5/u;", "modes", "Ljava/util/List;", "selectedMode", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/H0;", "sharedEndpoints", "cardId", "Ljava/lang/String;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/G0;", "mapBinder", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/G0;", "Companion", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class r0 extends N5.d {
    private static final float TAB_TEXT_SIZE_SP = 13.0f;
    private static final int TAB_WEIGHT = 420;
    private String cardId;
    private G0 mapBinder;
    private List<RouteMode> modes;
    private T5.u routeBinding;
    private RouteMode selectedMode;
    private List<RouteWaypoint> sharedEndpoints;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<String> ORIGIN_TYPES = Z8.Y.j("origin", "start", "from", "起点");
    private static final Set<String> DEST_TYPES = Z8.Y.j("destination", "dest", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "to", "终点");
    private static final Set<String> WALK_OR_RIDE_KEYS = Z8.Y.j("walk", "walking", "foot", "步行", "ride", "riding", "bike", "bicycle", "cycling", "骑行");

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\n\u001a\u00020\t*\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\f\u001a\u00020\u0005*\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u0005*\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/r0$a;", "", "<init>", "()V", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/H0;", "", "f", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/H0;)Z", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/J0;", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/J0;)Ljava/lang/String;", "e", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/J0;)Z", Const.INTENT_KEY_UMID, "", "TAB_TEXT_SIZE_SP", "F", "", "TAB_WEIGHT", "I", "", "ORIGIN_TYPES", "Ljava/util/Set;", "DEST_TYPES", "WALK_OR_RIDE_KEYS", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.amap.r0$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final boolean d(RouteWaypoint routeWaypoint) {
            return r0.DEST_TYPES.contains(g(routeWaypoint));
        }

        public final boolean e(RouteWaypoint routeWaypoint) {
            return r0.ORIGIN_TYPES.contains(g(routeWaypoint));
        }

        public final boolean f(RouteMode routeMode) {
            String lowerCase;
            String string;
            String key = routeMode.getKey();
            if (key == null || (string = La.H.D1(key).toString()) == null) {
                lowerCase = null;
            } else {
                lowerCase = string.toLowerCase(Locale.ROOT);
                kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
            }
            if (lowerCase == null) {
                lowerCase = "";
            }
            if (r0.WALK_OR_RIDE_KEYS.contains(lowerCase)) {
                return true;
            }
            String label = routeMode.getLabel();
            String string2 = label != null ? La.H.D1(label).toString() : null;
            String str = string2 != null ? string2 : "";
            return kotlin.jvm.internal.p.d(str, "步行") || kotlin.jvm.internal.p.d(str, "骑行");
        }

        public final String g(RouteWaypoint routeWaypoint) {
            String string;
            String type = routeWaypoint.getType();
            if (type == null || (string = La.H.D1(type).toString()) == null) {
                return "";
            }
            String lowerCase = string.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
            return lowerCase == null ? "" : lowerCase;
        }

        public Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.modes = C1173v.m();
        this.sharedEndpoints = C1173v.m();
        this.cardId = "";
    }

    public static final void a0(String str, r0 r0Var, CardAction cardAction, View view) {
        M5.a aVar = M5.a.INSTANCE;
        if (aVar.d(str)) {
            M5.a.b(aVar, r0Var.cardId, M5.a.CARD_TYPE_ROUTE, M5.a.ACTION_START_NAV, null, 8, null);
        }
        N5.d.G(r0Var, cardAction != null ? cardAction.getAppLink() : null, cardAction != null ? cardAction.getWebLink() : null, null, false, false, false, 60, null);
    }

    public static final void f0(r0 r0Var, CardAction cardAction, View view) {
        N5.d.G(r0Var, cardAction != null ? cardAction.getAppLink() : null, cardAction != null ? cardAction.getWebLink() : null, null, false, false, false, 60, null);
    }

    public static final void i0(boolean z10, r0 r0Var, RouteMode routeMode, View view) {
        RouteMode routeMode2;
        if (!z10 || (routeMode2 = r0Var.selectedMode) == routeMode) {
            return;
        }
        r0Var.selectedMode = routeMode;
        r0Var.j0();
        r0Var.b0(routeMode);
        M5.a.INSTANCE.g(r0Var.cardId, routeMode2 != null ? routeMode2.getKey() : null, routeMode.getKey());
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x002d, code lost:
    
        continue;
     */
    @Override // N5.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void C(N5.n r8) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.amap.r0.C(N5.n):void");
    }

    @Override // N5.d
    public void D(CardEnvelope envelope, N5.n model) {
        String taskId;
        kotlin.jvm.internal.p.i(envelope, "envelope");
        M5.a aVar = M5.a.INSTANCE;
        if (model == null || (taskId = model.getCardId()) == null) {
            taskId = envelope.getTaskId();
        }
        aVar.c(taskId, M5.a.CARD_TYPE_ROUTE);
    }

    @Override // N5.d
    public void E(FrameLayout container) {
        kotlin.jvm.internal.p.i(container, "container");
        T5.u uVarC = T5.u.c(LayoutInflater.from(getContext()), container, true);
        kotlin.jvm.internal.p.h(uVarC, "inflate(...)");
        this.routeBinding = uVarC;
        T5.u uVar = this.routeBinding;
        T5.u uVar2 = null;
        if (uVar == null) {
            kotlin.jvm.internal.p.A("routeBinding");
            uVar = null;
        }
        FrameLayout flMapSlot = uVar.flMapSlot;
        kotlin.jvm.internal.p.h(flMapSlot, "flMapSlot");
        T5.u uVar3 = this.routeBinding;
        if (uVar3 == null) {
            kotlin.jvm.internal.p.A("routeBinding");
            uVar3 = null;
        }
        ImageView ivRouteMap = uVar3.ivRouteMap;
        kotlin.jvm.internal.p.h(ivRouteMap, "ivRouteMap");
        T5.u uVar4 = this.routeBinding;
        if (uVar4 == null) {
            kotlin.jvm.internal.p.A("routeBinding");
            uVar4 = null;
        }
        IndeterminateSpinnerView vRouteMapLoading = uVar4.vRouteMapLoading;
        kotlin.jvm.internal.p.h(vRouteMapLoading, "vRouteMapLoading");
        this.mapBinder = new G0(flMapSlot, ivRouteMap, vRouteMapLoading);
        C3251a c3251a = C3251a.INSTANCE;
        T5.u uVar5 = this.routeBinding;
        if (uVar5 == null) {
            kotlin.jvm.internal.p.A("routeBinding");
        } else {
            uVar2 = uVar5;
        }
        LinearLayout linearLayoutB = uVar2.b();
        kotlin.jvm.internal.p.h(linearLayoutB, "getRoot(...)");
        c3251a.b(linearLayoutB);
    }

    public final void Z(RouteMode mode) {
        final CardAction action = mode.getAction();
        T5.u uVar = this.routeBinding;
        if (uVar == null) {
            kotlin.jvm.internal.p.A("routeBinding");
            uVar = null;
        }
        TextView btnRouteAction = uVar.btnRouteAction;
        kotlin.jvm.internal.p.h(btnRouteAction, "btnRouteAction");
        String appLink = action != null ? action.getAppLink() : null;
        if (appLink == null || La.H.x0(appLink)) {
            String webLink = action != null ? action.getWebLink() : null;
            if (webLink == null || La.H.x0(webLink)) {
                btnRouteAction.setVisibility(8);
                return;
            }
        }
        btnRouteAction.setVisibility(0);
        final String strD = N5.j.INSTANCE.d(action != null ? action.getLabel() : null);
        if (strD == null) {
            strD = "开始导航";
        }
        btnRouteAction.setText(strD);
        btnRouteAction.setCompoundDrawablesRelativeWithIntrinsicBounds(La.H.g0(strD, "行程", false, 2, null) ? R$drawable.ic_card_map_arrow_left : 0, 0, 0, 0);
        btnRouteAction.setCompoundDrawablePadding((int) (4 * btnRouteAction.getResources().getDisplayMetrics().density));
        btnRouteAction.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r0.a0(strD, this, action, view);
            }
        });
    }

    public final void b0(RouteMode mode) {
        boolean zF = INSTANCE.f(mode);
        List<RouteWaypoint> listG = !mode.g().isEmpty() ? mode.g() : this.sharedEndpoints;
        if (zF) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : listG) {
                RouteWaypoint routeWaypoint = (RouteWaypoint) obj;
                Companion companion = INSTANCE;
                if (companion.e(routeWaypoint) || companion.d(routeWaypoint)) {
                    arrayList.add(obj);
                }
            }
            listG = arrayList;
        }
        G0 g02 = this.mapBinder;
        if (g02 != null) {
            g02.o(this.cardId, mode.getKey(), listG);
        }
        RouteSummary summary = mode.getSummary();
        C3251a c3251a = C3251a.INSTANCE;
        T5.u uVar = this.routeBinding;
        if (uVar == null) {
            kotlin.jvm.internal.p.A("routeBinding");
            uVar = null;
        }
        TextView tvRouteOrigin = uVar.tvRouteOrigin;
        kotlin.jvm.internal.p.h(tvRouteOrigin, "tvRouteOrigin");
        c3251a.e(tvRouteOrigin, mode.getOriginText());
        c0(summary);
        List<CardTag> listC = summary != null ? summary.c() : null;
        if (listC == null) {
            listC = C1173v.m();
        }
        d0(listC);
        g0(zF ? C1173v.m() : mode.g());
        Z(mode);
    }

    public final void c0(RouteSummary summary) {
        N5.j jVar = N5.j.INSTANCE;
        T5.u uVar = null;
        String strD = jVar.d(summary != null ? summary.getDurationText() : null);
        String strK0 = k0(jVar.d(summary != null ? summary.getDistanceText() : null));
        C3251a c3251a = C3251a.INSTANCE;
        T5.u uVar2 = this.routeBinding;
        if (uVar2 == null) {
            kotlin.jvm.internal.p.A("routeBinding");
            uVar2 = null;
        }
        TextView tvRouteDuration = uVar2.tvRouteDuration;
        kotlin.jvm.internal.p.h(tvRouteDuration, "tvRouteDuration");
        c3251a.e(tvRouteDuration, strD);
        T5.u uVar3 = this.routeBinding;
        if (uVar3 == null) {
            kotlin.jvm.internal.p.A("routeBinding");
            uVar3 = null;
        }
        TextView tvRouteDistance = uVar3.tvRouteDistance;
        kotlin.jvm.internal.p.h(tvRouteDistance, "tvRouteDistance");
        c3251a.e(tvRouteDistance, strK0);
        boolean z10 = (strD == null || strK0 == null) ? false : true;
        T5.u uVar4 = this.routeBinding;
        if (uVar4 == null) {
            kotlin.jvm.internal.p.A("routeBinding");
        } else {
            uVar = uVar4;
        }
        uVar.tvRouteSummaryDot.setVisibility(z10 ? 0 : 8);
    }

    public final void d0(List<CardTag> tags) {
        T5.u uVar = this.routeBinding;
        T5.u uVar2 = null;
        if (uVar == null) {
            kotlin.jvm.internal.p.A("routeBinding");
            uVar = null;
        }
        uVar.llRouteTags.removeAllViews();
        ArrayList<CardTag> arrayList = new ArrayList();
        for (Object obj : tags) {
            if (N5.j.INSTANCE.d(((CardTag) obj).getText()) != null) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            T5.u uVar3 = this.routeBinding;
            if (uVar3 == null) {
                kotlin.jvm.internal.p.A("routeBinding");
            } else {
                uVar2 = uVar3;
            }
            uVar2.scrollRouteTags.setVisibility(8);
            return;
        }
        T5.u uVar4 = this.routeBinding;
        if (uVar4 == null) {
            kotlin.jvm.internal.p.A("routeBinding");
            uVar4 = null;
        }
        uVar4.scrollRouteTags.setVisibility(0);
        T5.u uVar5 = this.routeBinding;
        if (uVar5 == null) {
            kotlin.jvm.internal.p.A("routeBinding");
            uVar5 = null;
        }
        Context context = uVar5.llRouteTags.getContext();
        float f10 = context.getResources().getDisplayMetrics().density;
        int i10 = (int) (8 * f10);
        int i11 = (int) (4 * f10);
        int i12 = (int) (6 * f10);
        for (CardTag cardTag : arrayList) {
            TextView textView = new TextView(context);
            textView.setTextSize(10.0f);
            textView.setPadding(i10, i11, i10, i11);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
            marginLayoutParams.setMarginEnd(i12);
            textView.setLayoutParams(marginLayoutParams);
            C3251a.INSTANCE.d(textView, cardTag);
            T5.u uVar6 = this.routeBinding;
            if (uVar6 == null) {
                kotlin.jvm.internal.p.A("routeBinding");
                uVar6 = null;
            }
            uVar6.llRouteTags.addView(textView);
        }
    }

    public final void e0(T5.v row, RouteWaypoint wp, boolean isLast) {
        Companion companion = INSTANCE;
        if (companion.e(wp)) {
            row.vWaypointDot.setBackgroundResource(R$drawable.bg_card_map_dot_origin);
        } else if (companion.d(wp)) {
            row.vWaypointDot.setBackgroundResource(R$drawable.bg_card_map_dot_dest);
        } else {
            row.vWaypointDot.setBackgroundResource(R$drawable.bg_card_map_dot_waypoint);
        }
        row.vWaypointLine.setVisibility(isLast ? 4 : 0);
        if (isLast) {
            LinearLayout linearLayoutB = row.b();
            kotlin.jvm.internal.p.h(linearLayoutB, "getRoot(...)");
            linearLayoutB.setPadding(linearLayoutB.getPaddingLeft(), linearLayoutB.getPaddingTop(), linearLayoutB.getPaddingRight(), 0);
        }
        C3251a c3251a = C3251a.INSTANCE;
        TextView tvWaypointName = row.tvWaypointName;
        kotlin.jvm.internal.p.h(tvWaypointName, "tvWaypointName");
        c3251a.e(tvWaypointName, wp.getName());
        N5.j jVar = N5.j.INSTANCE;
        String strD = jVar.d(wp.getTimeText());
        if (strD == null) {
            strD = jVar.d(wp.getSegmentText());
        }
        TextView tvWaypointMeta = row.tvWaypointMeta;
        kotlin.jvm.internal.p.h(tvWaypointMeta, "tvWaypointMeta");
        c3251a.e(tvWaypointMeta, strD);
        TextView tvWaypointBadge = row.tvWaypointBadge;
        kotlin.jvm.internal.p.h(tvWaypointBadge, "tvWaypointBadge");
        c3251a.c(tvWaypointBadge, wp.getBadge());
        final CardAction action = wp.getAction();
        String appLink = action != null ? action.getAppLink() : null;
        if (appLink == null || La.H.x0(appLink)) {
            String webLink = action != null ? action.getWebLink() : null;
            if (webLink == null || La.H.x0(webLink)) {
                row.b().setOnClickListener(null);
                row.b().setClickable(false);
                return;
            }
        }
        row.b().setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.o0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r0.f0(this.f27271a, action, view);
            }
        });
    }

    public final void g0(List<RouteWaypoint> waypoints) {
        T5.u uVar = this.routeBinding;
        T5.u uVar2 = null;
        if (uVar == null) {
            kotlin.jvm.internal.p.A("routeBinding");
            uVar = null;
        }
        uVar.llWaypoints.removeAllViews();
        if (waypoints.isEmpty()) {
            T5.u uVar3 = this.routeBinding;
            if (uVar3 == null) {
                kotlin.jvm.internal.p.A("routeBinding");
            } else {
                uVar2 = uVar3;
            }
            uVar2.llWaypoints.setVisibility(8);
            return;
        }
        T5.u uVar4 = this.routeBinding;
        if (uVar4 == null) {
            kotlin.jvm.internal.p.A("routeBinding");
            uVar4 = null;
        }
        uVar4.llWaypoints.setVisibility(0);
        T5.u uVar5 = this.routeBinding;
        if (uVar5 == null) {
            kotlin.jvm.internal.p.A("routeBinding");
            uVar5 = null;
        }
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(uVar5.llWaypoints.getContext());
        int i10 = 0;
        for (Object obj : waypoints) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            RouteWaypoint routeWaypoint = (RouteWaypoint) obj;
            T5.u uVar6 = this.routeBinding;
            if (uVar6 == null) {
                kotlin.jvm.internal.p.A("routeBinding");
                uVar6 = null;
            }
            T5.v vVarC = T5.v.c(layoutInflaterFrom, uVar6.llWaypoints, false);
            kotlin.jvm.internal.p.h(vVarC, "inflate(...)");
            e0(vVarC, routeWaypoint, i10 == C1173v.o(waypoints));
            T5.u uVar7 = this.routeBinding;
            if (uVar7 == null) {
                kotlin.jvm.internal.p.A("routeBinding");
                uVar7 = null;
            }
            uVar7.llWaypoints.addView(vVarC.b());
            i10 = i11;
        }
    }

    public final void h0() {
        T5.u uVar = this.routeBinding;
        T5.u uVar2 = null;
        if (uVar == null) {
            kotlin.jvm.internal.p.A("routeBinding");
            uVar = null;
        }
        uVar.llModeTabs.removeAllViews();
        if (this.modes.isEmpty()) {
            T5.u uVar3 = this.routeBinding;
            if (uVar3 == null) {
                kotlin.jvm.internal.p.A("routeBinding");
            } else {
                uVar2 = uVar3;
            }
            uVar2.llModeTabs.setVisibility(8);
            return;
        }
        T5.u uVar4 = this.routeBinding;
        if (uVar4 == null) {
            kotlin.jvm.internal.p.A("routeBinding");
            uVar4 = null;
        }
        uVar4.llModeTabs.setVisibility(0);
        T5.u uVar5 = this.routeBinding;
        if (uVar5 == null) {
            kotlin.jvm.internal.p.A("routeBinding");
            uVar5 = null;
        }
        Context context = uVar5.llModeTabs.getContext();
        int i10 = (int) (6 * context.getResources().getDisplayMetrics().density);
        for (final RouteMode routeMode : this.modes) {
            final boolean z10 = !kotlin.jvm.internal.p.d(routeMode.getEnabled(), Boolean.FALSE);
            TextView textView = new TextView(context);
            N5.j jVar = N5.j.INSTANCE;
            String strD = jVar.d(routeMode.getLabel());
            if (strD == null && (strD = jVar.d(routeMode.getKey())) == null) {
                strD = "";
            }
            textView.setText(strD);
            textView.setTextSize(13.0f);
            textView.setTypeface(Typeface.create(Typeface.DEFAULT, TAB_WEIGHT, false), 0);
            textView.setGravity(17);
            textView.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            textView.setPadding(0, i10, 0, i10);
            textView.setEnabled(z10);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.q0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    r0.i0(z10, this, routeMode, view);
                }
            });
            T5.u uVar6 = this.routeBinding;
            if (uVar6 == null) {
                kotlin.jvm.internal.p.A("routeBinding");
                uVar6 = null;
            }
            uVar6.llModeTabs.addView(textView);
        }
        j0();
    }

    public final void j0() {
        RouteMode routeMode;
        T5.u uVar = this.routeBinding;
        if (uVar == null) {
            kotlin.jvm.internal.p.A("routeBinding");
            uVar = null;
        }
        Resources resources = uVar.llModeTabs.getResources();
        T5.u uVar2 = this.routeBinding;
        if (uVar2 == null) {
            kotlin.jvm.internal.p.A("routeBinding");
            uVar2 = null;
        }
        int childCount = uVar2.llModeTabs.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            T5.u uVar3 = this.routeBinding;
            if (uVar3 == null) {
                kotlin.jvm.internal.p.A("routeBinding");
                uVar3 = null;
            }
            View childAt = uVar3.llModeTabs.getChildAt(i10);
            TextView textView = childAt instanceof TextView ? (TextView) childAt : null;
            if (textView != null && (routeMode = (RouteMode) Z8.F.t0(this.modes, i10)) != null) {
                textView.setTextColor(resources.getColor(kotlin.jvm.internal.p.d(routeMode.getEnabled(), Boolean.FALSE) ? R$color.card_map_tab_text_disabled : routeMode == this.selectedMode ? R$color.card_map_tab_text_selected : R$color.card_map_tab_text_normal, null));
                textView.setBackground(routeMode == this.selectedMode ? resources.getDrawable(R$drawable.bg_card_map_tab_selected, null) : null);
            }
        }
    }

    public final String k0(String raw) {
        return (raw == null || La.H.x0(raw)) ? raw : La.D.T(La.D.T(raw, "米公里", "公里", false, 4, null), "米 公里", "公里", false, 4, null);
    }

    @Override // N5.d, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        G0 g02 = this.mapBinder;
        if (g02 != null) {
            g02.Q();
        }
    }

    @Override // N5.d, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        if (w()) {
            G0 g02 = this.mapBinder;
            if (g02 != null) {
                g02.x();
            }
        } else {
            G0 g03 = this.mapBinder;
            if (g03 != null) {
                g03.N();
            }
        }
        super.onDetachedFromWindow();
    }

    public /* synthetic */ r0(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
