package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.ui.TicketPriceInputDialogFragment;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openTicketPriceInputPanel")
public final class i9 extends w20.u4<w20.tc, w20.uc> implements TicketPriceInputDialogFragment.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f63452a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.TicketPriceInputDialogFragment.b
    public final void a() {
        f63452a = false;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public i9() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.TicketPriceInputDialogFragment.b
    public final void f(String r100, boolean r101) {
        ALogger.i("OpenTicketPriceInputPanelMethod", "on input finish: input " + r100 + ", is recommend price " + r101);
        w20.uc r102 = new w20.uc();
        r102.a(1);
        w20.uc.a r103 = new w20.uc.a();
        r103.a(r100);
        r103.b(Boolean.valueOf(r101));
        Unit r104 = Unit.INSTANCE;
        r102.b(r103);
        finishWithResult(r102);
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.tc r102 = (w20.tc) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        ALogger.i("OpenTicketPriceInputPanelMethod", "invoke: is input panel already open " + f63452a);
        if (f63452a == true) goto L42;
        TicketPriceInputDialogFragment r103 = new TicketPriceInputDialogFragment();
        String r104 = GsonProtectorUtils.toJson(GsonHelper.get(), r102);
        r103.f112559j = this;
        Gson r105 = GsonHelper.get();
        if (r104 != null) goto L7;
        r104 = "";
    L7:
        TicketPriceInputDialogFragment.c r106 = (TicketPriceInputDialogFragment.c) GsonProtectorUtils.fromJson(r105, r104, TicketPriceInputDialogFragment.c.class);
        Context r107 = null;
        if (r106 == null) goto L10;
        String r108 = r106.b();
    L12:
        if (TextUtils.isEmpty(r108) == true) goto L17;
        if (r106 == null) goto L15;
        String r109 = r106.b();
    L16:
        r103.f112557h = r109;
        goto L17
    L15:
        r109 = null;
    L17:
        List<String> r110 = CollectionsKt.mutableListOf(new String[]{"recommend_price_tag"});
        r103.f112558i = r110;
        if (r110 == null) goto L25;
        if (r106 == null) goto L23;
        List<String> r111 = r106.a();
        if (r111 == null) goto L23;
    L24:
        r110.addAll(r111);
    L23:
        r111 = CollectionsKt.emptyList();
    L25:
        Context r112 = r101.getContext();
        ALogger.i("TicketPriceInputDialogFragment", "show dialog " + r103.hashCode() + ", context " + r112);
        if ((r112 instanceof FragmentActivity) == false) goto L29;
        r107 = r112;
    L29:
        FragmentActivity r113 = (FragmentActivity) r107;
        if (r113 == null) goto L37;
        FragmentManager r114 = r113.getSupportFragmentManager();
        String r115 = r103.getTag();
        LandscapeRestrictionOperation r116 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r103, r115, r116);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r114, r103, r116) == false) goto L40;
    L36:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_paidlive_activity_price_filling_shortcut_panel_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("enter_from_merge", "direct_shoot"), TuplesKt.to("live_type", "video_live")}), new Object[]{Room.class});
        goto L37
    L40:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L39
    L35:
        r103.show(r114, r115);
    L37:
        ALogger.i("OpenTicketPriceInputPanelMethod", "invoke: show input price dialog fragment " + r103.hashCode());
        f63452a = true;
        return;
    L10:
        r108 = null;
        goto L12
    }
}
