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
@XBridgeMethod(biz = "webcast", name = "getActivitySettings")
public final class s3 extends w20.b1<w20.h9, JsonObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f63643a;

    public s3() {
        this.f63643a = "data.common_info.extra.";
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.h9 r102 = (w20.h9) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        List<String> r103 = r102.a();     // Catch: Exception -> L37
        if (r103 != null) goto L6;
    L9:
        boolean r104 = true;
    L10:
        if (r104 == false) goto L12;
        finishWithFailure(new Throwable("keys is null"));     // Catch: Exception -> L37
        return;
    L12:
        List<String> r105 = r102.a();     // Catch: Exception -> L37
        if (r105 == null) goto L32;
        ArrayList r106 = new ArrayList();     // Catch: Exception -> L37
        Iterator<T> r107 = r105.iterator();     // Catch: Exception -> L37
    L16:
        if (r107.hasNext() == false) goto L28;
        Object r108 = r107.next();     // Catch: Exception -> L37
        String r109 = (String) r108;     // Catch: Exception -> L37
        if (r109 != null) goto L20;
    L25:
        boolean r110 = false;
    L26:
        if (r110 == false) goto L16;
        r106.add(r108);     // Catch: Exception -> L37
        goto L16
    L20:
        if (r109.length() <= 0) goto L22;
        boolean r111 = true;
    L23:
        if (r111 == false) goto L25;
        r110 = true;
        goto L26
    L22:
        r111 = false;
        goto L23
    L28:
        ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));     // Catch: Exception -> L37
        Iterator r113 = r106.iterator();     // Catch: Exception -> L37
    L30:
        if (r113.hasNext() == false) goto L33;
        r112.add(this.f63643a + ((String) r113.next()));     // Catch: Exception -> L37
    L33:
        if (r112 != null) goto L35;
        finishWithFailure(new Throwable("suffixList is null"));     // Catch: Exception -> L37
        return;
    L35:
        ((IHostContext) jc1.k.n(IHostContext.class)).getUgSettingsByKey(0, r112, new r3(this));     // Catch: Exception -> L37
        return;
    L32:
        r112 = null;
        goto L33
    L6:
        if (r103.isEmpty() == true) goto L9;
        r104 = false;
    L37:
        e = move-exception;
        finishWithFailure(e);
    }
}
