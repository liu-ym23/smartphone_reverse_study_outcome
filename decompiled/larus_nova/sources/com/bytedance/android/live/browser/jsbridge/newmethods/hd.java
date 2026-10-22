package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.android.live.browser.BrowserServiceImpl;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "commercialComponentOperation")
public final class hd extends com.bytedance.ies.web.jsbridge2.f<a, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Inject
    public com.bytedance.android.live.browser.v f63431a;

    public static final class a {

        @SerializedName("card_id")
        String cardId;

        @SerializedName("room_id")
        String roomId;

        @SerializedName("type")
        int type;

        public a() {
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public hd() {
        BrowserServiceImpl.Companion.getClass();
        this.f63431a = ((s20.b) BrowserServiceImpl.access$getDiComponent$cp()).a().f540207a.f540212e.get();
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(a r100, CallContext r101) throws Exception {
        a r102 = r100;
        xs2.b.a().post(new com.bytedance.android.livesdk.event.h0(r102.type));
        if (r102.type != 4) goto L19;
        Context r103 = r101.getContext();
        com.bytedance.android.livesdk.widget.x0.d r104 = new com.bytedance.android.livesdk.widget.x0.d();
        r104.f162243b = r103;
        r104.f162242a = 4;
        r104.f162244c = r104.f162243b.getText(R.string.ttlive_sure_to_remove);
        r104.f162245d = r104.f162243b.getText(R.string.ttlive_not_show_after_remove);
        String r105 = com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_remove);
        DialogInterface.OnClickListener r106 = new fd(this);
        com.bytedance.android.livesdk.widget.x0.c[] r107 = r104.f162248g;
        com.bytedance.android.livesdk.widget.x0.c r108 = r107[0];
        if (r108 != null) goto L7;
        r108 = new com.bytedance.android.livesdk.widget.x0.c();
        r107[0] = r108;
    L7:
        r108.f162239a = r105;
        r108.f162240b = r106;
        String r109 = com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_text_cancel);
        DialogInterface.OnClickListener r110 = new gd(this);
        com.bytedance.android.livesdk.widget.x0.c[] r111 = r104.f162248g;
        com.bytedance.android.livesdk.widget.x0.c r112 = r111[1];
        if (r112 != null) goto L10;
        r112 = new com.bytedance.android.livesdk.widget.x0.c();
        r111[1] = r112;
    L10:
        r112.f162239a = r109;
        r112.f162240b = r110;
        com.bytedance.android.livesdk.widget.x0 r113 = new com.bytedance.android.livesdk.widget.x0(r104.f162243b, r104);
        if (DialogLancet.shouldBlockDialogShow(r113) == false) goto L17;
        DialogLancet.handleBlockedDialogShow(r113);
        return;
    L17:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L14:
        DialogLancet.beforeDialogShow(r113);
        r113.show();
        DialogLancet.afterDialogShow(r113);
        return;
    }
}
