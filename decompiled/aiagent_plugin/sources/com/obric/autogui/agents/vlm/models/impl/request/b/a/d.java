package com.obric.autogui.agents.vlm.models.impl.request.b.a;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: StdModelServerRespondedError.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements com.obric.autogui.agents.vlm.models.impl.request.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f28045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f28046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f28047c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.obric.autogui.common.b.c f28048d;

    /* JADX INFO: compiled from: StdModelServerRespondedError.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f28049a = null;

        static {
            int[] r0 = new int[com.obric.autogui.common.b.c.values().length];
            r0[com.obric.autogui.common.b.c.q.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f28049a = r0;
        }
    }

    public d(int r5, String r6, String r7) {
        o.e(r6, "msg");
        o.e(r7, "logId");
        this.f28045a = r5;
        this.f28046b = r6;
        this.f28047c = r7;
        com.obric.autogui.common.b.c[] r8 = com.obric.autogui.common.b.c.values();
        int r9 = r8.length;
        int r0 = 0;
    L3:
        if (r0 >= r9) goto L11;
        com.obric.autogui.common.b.c r1 = r8[r0];
        if (r1.a() != this.f28045a) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L12;
        r0 = r0 + 1;
    L12:
        if (r1 != null) goto L14;
        r1 = com.obric.autogui.common.b.c.f29005b;
    L14:
        this.f28048d = r1;
        return;
    L7:
        r2 = false;
        goto L8
    L11:
        r1 = null;
        goto L12
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.request.b.a
    public com.obric.autogui.agents.vlm.models.impl.request.b.b a() {
        com.obric.autogui.common.b.c r1 = this.f28048d;
        if (a.f28049a[r1.ordinal()] != 1) goto L6;
        return com.obric.autogui.agents.vlm.models.impl.request.b.b.g;
    L6:
        return com.obric.autogui.agents.vlm.models.impl.request.b.b.h;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.request.b.a
    public String a(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        if (a.f28049a[this.f28048d.ordinal()] != 1) goto L5;
        String r4 = r6.getString(ZeusTransformUtils.mapRes(R.string.std_model_err_serv_session_invalid, WsChannelMultiProcessSharedProvider.STRING_TYPE, "std_model_err_serv_session_invalid"));
        o.a(r4);
        return r4;
    L5:
        String r7 = r6.getString(ZeusTransformUtils.mapRes(R.string.std_model_err_serv_unhandled_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "std_model_err_serv_unhandled_error"), new Object[]{String.valueOf(this.f28045a)});
        o.a(r7);
        return r7;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.request.b.a
    public com.obric.autogui.agents.vlm.models.impl.request.b.a.EnumC0705a b() {
        com.obric.autogui.common.b.c r1 = this.f28048d;
        if (a.f28049a[r1.ordinal()] != 1) goto L6;
        return com.obric.autogui.agents.vlm.models.impl.request.b.a.EnumC0705a.f28036b;
    L6:
        return com.obric.autogui.agents.vlm.models.impl.request.b.a.EnumC0705a.f28035a;
    }
}
