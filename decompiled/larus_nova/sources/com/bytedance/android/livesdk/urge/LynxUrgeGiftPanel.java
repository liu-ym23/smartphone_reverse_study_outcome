package com.bytedance.android.livesdk.urge;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.y0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.urge.IUrgeGiftPanel;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import io.reactivex.functions.Consumer;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tt2.c;
import tt2.d;
import xs2.b;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/urge/LynxUrgeGiftPanel;", "Lcom/bytedance/android/livesdk/urge/UrgeGiftPanel;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LynxUrgeGiftPanel extends UrgeGiftPanel {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f158618l;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LynxUrgeGiftPanel f158619a;

        public a(LynxUrgeGiftPanel r100) {
            this.f158619a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            UrgeSendGiftEventCode r101 = ((d) r100).f547541a;
            int r102 = tt2.a.f547539a[r101.ordinal()];
            if (r102 != 1) goto L5;
            IUrgeGiftPanel.ICallback r103 = this.f158619a.f158629k;
            if (r103 == null) goto L23;
            r103.onSuccess();
            return;
        L23:
            return;
        L5:
            if (r102 != 2) goto L7;
            IUrgeGiftPanel.ICallback r104 = this.f158619a.f158629k;
            if (r104 == null) goto L21;
            r104.onInsufficientFund();
            return;
        L21:
            return;
        L7:
            if (r102 != 3) goto L24;
            IUrgeGiftPanel.ICallback r105 = this.f158619a.f158629k;
            if (r105 == null) goto L19;
            r105.onCancel();
            return;
        L19:
            return;
        }
    }

    public LynxUrgeGiftPanel() {
        this.f158618l = "";
    }

    @Override // com.bytedance.android.livesdk.urge.UrgeGiftPanel, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        RxUtilKt.c(b.a().b(d.class).subscribe(new a(this)), this.f158622d);
    }

    public static final /* synthetic */ Dialog S90(LynxUrgeGiftPanel r100) {
        return super.getDialog();
    }

    @Override // com.bytedance.android.livesdk.urge.UrgeGiftPanel, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        if (r100 == null) goto L8;
        String r101 = r100.getString("scheme");
        if (r101 == null) goto L9;
        this.f158618l = r101;
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.urge.UrgeGiftPanel, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "outState");
        super.onSaveInstanceState(r100);
        r100.putString("scheme", this.f158618l);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        Context r113 = getContext();
        if (r113 != null) goto L5;
        return null;
    L5:
        String r114 = this.f158618l;
        if (TextUtils.isEmpty(r114) == false) goto L9;
    L19:
        return null;
    L9:
        if (this.f158623e == true) goto L20;
        this.f158623e = true;
        String r100 = this.f158625g;
        String r101 = this.f158626h;
        boolean r102 = this.f158628j;
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "toUserId");
        Pair[] r115 = new Pair[4];
        r115[0] = TuplesKt.to("user_id", r100.toString());
        r115[1] = TuplesKt.to("anchor_id", r101.toString());
        r115[2] = TuplesKt.to("author_id", r101);
        if (r102 == false) goto L13;
        String r103 = "rewarded";
    L14:
        r115[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BUTTON_STATUS, r103);
        u.l().sendLog("livesdk_update_reward_panel_show", MapsKt.mapOf(r115), new Object[0]);
        goto L20
    L13:
        r103 = "unrewarded";
    L20:
        ((IBrowserService) k.n(IBrowserService.class)).showHybridDialogWithListener(r113, UriProtector.parse(y0.b(r114, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("title", this.f158624f), TuplesKt.to("sec_anchor_id", this.f158627i), TuplesKt.to("anchor_id", this.f158626h.toString()), TuplesKt.to("user_id", this.f158625g.toString())}))).buildUpon().build(), new c(), new tt2.b(this));     // Catch: Exception -> L17
    L17:
        e = move-exception;
        ALogger.e("LynxUrgeGiftPanel", "showLynxUrgeGiftPanel error" + e.getMessage());
        goto L19
    }
}
