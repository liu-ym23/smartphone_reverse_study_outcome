package com.stepos.ailauncher.foundation.appui.card.provider.alipay;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ%\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\tJ\r\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\u0003¨\u0006\r"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/E;", "", "<init>", "()V", "", "liveId", "sessionId", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)V", "chatSessionId", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class E {
    public static final E INSTANCE = new E();

    public static /* synthetic */ void c(E e10, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        e10.b(str, str2);
    }

    public final void a(String liveId, String sessionId) {
        kotlin.jvm.internal.p.i(liveId, "liveId");
        AlipayXuiIslandVisibility.INSTANCE.h(liveId, sessionId);
    }

    public final void b(String chatSessionId, String liveId) {
        AlipayXuiIslandVisibility.s(AlipayXuiIslandVisibility.INSTANCE, liveId, chatSessionId, null, 4, null);
    }

    public final void d() {
        AlipayXuiIslandVisibility.O(AlipayXuiIslandVisibility.INSTANCE, null, 0L, 3, null);
    }
}
