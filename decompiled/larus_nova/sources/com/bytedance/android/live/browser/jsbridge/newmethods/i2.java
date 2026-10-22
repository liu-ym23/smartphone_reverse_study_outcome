package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.livehostapi.business.depend.livead.ICommerceMessage;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class i2 implements com.bytedance.android.annie.bridge.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IHybridComponent f63434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f63435b;

    public static final class a implements vlc.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i2 f63436a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ies.web.jsbridge2.d0 f63437b;

        public a(i2 r100, com.bytedance.ies.web.jsbridge2.d0 r101) {
            this.f63436a = r100;
            this.f63437b = r101;
        }

        @Override // vlc.l
        public final void onMessage(tlc.d r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            if (r100.getIntType() == 2001) goto L6;
        L8:
            boolean r101 = false;
        L9:
            if (r101 == true) goto L12;
            r100 = null;
        L12:
            if (r100 == null) goto L26;
            ICommerceMessage r102 = (ICommerceMessage) r100;
            if (r102.getMessageType() != 7) goto L27;
            String r103 = r102.getMessageContent();
            if (r103 == null) goto L28;
            IHybridComponent r104 = this.f63436a.f63434a;
            if (r104 == null) goto L21;
            if (r104 == null) goto L29;
            r104.sendJsEvent("updateRealTimeNum", r103);
            return;
        L29:
            return;
        L21:
            com.bytedance.ies.web.jsbridge2.d0 r105 = this.f63437b;
            if (r105 == null) goto L31;
            r105.f("updateRealTimeNum", r103);
            return;
        L31:
            return;
        L28:
            return;
        L27:
            return;
        L26:
            return;
        L6:
            if ((r100 instanceof ICommerceMessage) == false) goto L8;
            r101 = true;
            goto L9
        }
    }

    public static final class b extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i2 f63438a;

        @Override // com.bytedance.ies.web.jsbridge2.f
        public final void onTerminate() {
        }

        public b(i2 r100) {
            this.f63438a = r100;
        }

        @Override // com.bytedance.ies.web.jsbridge2.f
        public final void invoke(JSONObject r100, CallContext r101) {
            JSONObject r102 = r100;
            Intrinsics.checkNotNullParameter(r102, "params");
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            if (Intrinsics.areEqual(r102.optString("enableMsgMonitor", "0"), "1") == false) goto L8;
            vlc.d r103 = com.bytedance.android.livesdk.chatroom.utils.n3.b();
            if (r103 == null) goto L9;
            r103.addMessageListener(2001, this.f63438a.f63435b);
            return;
        L9:
            return;
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.f.b
    public final com.bytedance.ies.web.jsbridge2.f<?, ?> a() {
        return new b(this);
    }

    @Override // com.bytedance.android.annie.bridge.q
    public final void release() {
        vlc.d r100 = com.bytedance.android.livesdk.chatroom.utils.n3.b();
        if (r100 == null) goto L6;
        r100.removeMessageListener(2001, this.f63435b);
        return;
    }

    public i2(IHybridComponent r100) {
        Intrinsics.checkNotNullParameter(r100, "hybridComponent");
        this(null);
        this.f63434a = r100;
    }

    public i2(com.bytedance.ies.web.jsbridge2.d0 r100) {
        this.f63435b = new a(this, r100);
    }
}
