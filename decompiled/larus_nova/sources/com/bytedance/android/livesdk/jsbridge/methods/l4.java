package com.bytedance.android.livesdk.jsbridge.methods;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import com.larus.nova.R;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "showToolTip")
public final class l4 extends com.bytedance.ies.web.jsbridge2.f<a, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public yo2.e f142153a;

    public static final class a {

        @SerializedName("text")
        String text;

        @SerializedName("type")
        String type;

        public a() {
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public l4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(a r110, CallContext r111) throws Exception {
        a r112 = r110;
        ls2.b r113 = ns2.a.a();
        if (r113 != null) goto L5;
    L7:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r114 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.l();
    L9:
        if ((r114 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3) == false) goto L29;
        Map<ExtendedToolbarButton, View> r115 = ((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3) r114).f116829c;
        if (r115 == null) goto L29;
        if (PbRequest.SwitchType.PK.equals(r112.type) == false) goto L15;
        ToolbarButton r100 = ToolbarButton.PK;
    L16:
        if (r100 == null) goto L29;
        if (PbRequest.SwitchType.PK.equals(r112.type) == false) goto L20;
        ToolbarButton r101 = ToolbarButton.PK;
    L21:
        View r102 = (View) ((HashMap) r115).get(ExtendedToolbarButton.e(r101));
        if (r102 == null) goto L29;
        String r116 = r112.text;
        yo2.e r117 = this.f142153a;
        if (r117 != null) goto L26;
    L28:
        View r118 = LayoutInflater.from(getCallContext().getContext()).inflate(R.layout.ttlive_chiji_guide_tips, null);
        ((TextView) r118.findViewById(R.id.tv_interact_tip)).setText(r116);
        yo2.e r103 = new yo2.e(getCallContext().getContext());
        r103.f568651m = 5;
        r103.f568642d = r118;
        r103.f568643e = 0;
        r103.f568652n = true;
        r103.f568650l = true;
        r103.a();
        this.f142153a = r103;
        r103.i(r102, 1, 0, com.bytedance.android.live.core.utils.s1.f(1.0f), com.bytedance.android.live.core.utils.s1.f(-4.0f));
        goto L29
    L26:
        if (r117.h() == false) goto L28;
        this.f142153a.d();
        goto L28
    L20:
        r101 = null;
        goto L21
    L15:
        r100 = null;
    L29:
        finishWithSuccess();
        return;
    L5:
        if (TextUtils.isEmpty(r113.f510511r) == false) goto L7;
        r114 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.n(r113.f510511r);
        goto L9
    }
}
