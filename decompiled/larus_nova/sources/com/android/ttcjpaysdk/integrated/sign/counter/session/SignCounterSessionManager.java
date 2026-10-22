package com.android.ttcjpaysdk.integrated.sign.counter.session;

import com.alipay.sdk.m.x.d;
import com.android.ttcjpaysdk.base.service.ICJPayIntegratedSignCallback;
import com.bytedance.caijing.sdk.infra.base.core.CJContext;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JD\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/sign/counter/session/SignCounterSessionManager;", "", "()V", "preSignSessions", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/android/ttcjpaysdk/integrated/sign/counter/session/SignPreRouteSession;", "createPreSignSession", "cjContext", "Lcom/bytedance/caijing/sdk/infra/base/core/CJContext;", d.D, "", "extraInfo", "callback", "Lcom/android/ttcjpaysdk/base/service/ICJPayIntegratedSignCallback;", "getPreSignSession", "sessionId", "removePreSignSession", "", "integrated-sign-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SignCounterSessionManager {
    public static final SignCounterSessionManager INSTANCE = null;
    private static final ConcurrentHashMap<String, SignPreRouteSession> preSignSessions = null;

    private SignCounterSessionManager() {
    }

    static {
        INSTANCE = new SignCounterSessionManager();
        preSignSessions = new ConcurrentHashMap();
    }

    public final SignPreRouteSession getPreSignSession(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L12;
        return null;
    L12:
        return preSignSessions.get(r100);
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    public final void removePreSignSession(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L10;
        return;
    L10:
        preSignSessions.remove(r100);
        return;
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    public final String createPreSignSession(CJContext r110, Map<String, String> r111, Map<String, ? extends Object> r112, ICJPayIntegratedSignCallback r113) {
        Intrinsics.checkNotNullParameter(r110, "cjContext");
        Intrinsics.checkNotNullParameter(r111, d.D);
        String r100 = UUID.randomUUID().toString();
        preSignSessions.put(r100, new SignPreRouteSession(r110, r111, r112, r113, null, 16, null));
        return r100;
    }
}
