package com.stepos.ailauncher.task.detail.chip;

import Y8.j;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u0003J\u001d\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/task/detail/chip/a;", "", "<init>", "()V", "", "sessionId", "productKey", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_APIKEY, "", "c", "(Ljava/lang/String;Ljava/lang/String;)Z", "Lkotlin/Pair;", "live", "Lkotlin/Pair;", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    public static final a INSTANCE = new a();
    private static volatile Pair<String, String> live;

    public final void a() {
        live = null;
    }

    public final void b(String sessionId, String productKey) {
        p.i(sessionId, "sessionId");
        p.i(productKey, "productKey");
        if (sessionId.length() == 0 || productKey.length() == 0) {
            return;
        }
        live = j.a(sessionId, productKey);
    }

    public final boolean c(String sessionId, String productKey) {
        p.i(sessionId, "sessionId");
        p.i(productKey, "productKey");
        return p.d(live, j.a(sessionId, productKey));
    }
}
