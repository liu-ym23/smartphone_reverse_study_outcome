package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "getDynamicSettings")
public final class o4 extends f<p4, JsonObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f63586a;

    public o4() {
        this.f63586a = "data.";
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        p4 r102 = (p4) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        List<String> r103 = r102.a();     // Catch: Exception -> L32
        if (r103 != null) goto L6;
    L9:
        boolean r104 = true;
    L10:
        if (r104 == false) goto L12;
        finishWithFailure(new Throwable("keys is null"));     // Catch: Exception -> L32
        return;
    L12:
        List<String> r105 = r102.a();     // Catch: Exception -> L32
        if (r105 == null) goto L27;
        ArrayList r106 = new ArrayList();     // Catch: Exception -> L32
        Iterator<T> r107 = r105.iterator();     // Catch: Exception -> L32
    L16:
        if (r107.hasNext() == false) goto L23;
        Object r108 = r107.next();     // Catch: Exception -> L32
        if (((String) r108).length() <= 0) goto L20;
        boolean r109 = true;
    L21:
        if (r109 == false) goto L16;
        r106.add(r108);     // Catch: Exception -> L32
        goto L16
    L20:
        r109 = false;
        goto L21
    L23:
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));     // Catch: Exception -> L32
        Iterator r111 = r106.iterator();     // Catch: Exception -> L32
    L25:
        if (r111.hasNext() == false) goto L28;
        r110.add(this.f63586a + ((String) r111.next()));     // Catch: Exception -> L32
    L28:
        if (r110 != null) goto L30;
        finishWithFailure(new Throwable("suffixList is null"));     // Catch: Exception -> L32
        return;
    L30:
        ((IHostContext) jc1.k.n(IHostContext.class)).getUgSettingsByKey(1, r110, new n4(this));     // Catch: Exception -> L32
        return;
    L27:
        r110 = null;
        goto L28
    L6:
        if (r103.isEmpty() == true) goto L9;
        r104 = false;
    L32:
        e = move-exception;
        finishWithFailure(e);
    }
}
