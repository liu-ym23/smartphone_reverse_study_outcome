package com.obric.autoaction.vdplayer.legacy.d;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VDPlayerUIState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final d.f f25967a = null;

    public static final /* synthetic */ h a() {
        return b();
    }

    public static /* synthetic */ h lambda$ahbYl__uS3LE28qOKvLped1uieU() {
        return d();
    }

    static {
        f25967a = d.g.a($$Lambda$t$ahbYl__uS3LE28qOKvLped1uieU.INSTANCE);
    }

    private static final h b() {
        return (h) ZeusTransformUtils.preCheckCast(f25967a.b(), h.class, "com.obric.aiagent.plugin");
    }

    private static final h d() {
        return new h(true, c(), null);
    }

    private static final String c() {
        Object r1 = null;
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L9
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        if (r3 == null) goto L6;
        String r4 = r3.getString(ZeusTransformUtils.mapRes(R.string.obric_vd_status_preparing, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_vd_status_preparing"));     // Catch: Throwable -> L9
    L7:
        Object r5 = d.n.f(r4);     // Catch: Throwable -> L9
    L12:
        if (d.n.b(r5) == true) goto L15;
        r1 = r5;
    L15:
        String r0 = (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L21;
        return "";
    L21:
        return r0;
    L6:
        r4 = null;
    L9:
        th = move-exception;
        d.n.a r6 = d.n.f38560a;
        r5 = d.n.f(d.o.a(th));
        goto L12
    }
}
