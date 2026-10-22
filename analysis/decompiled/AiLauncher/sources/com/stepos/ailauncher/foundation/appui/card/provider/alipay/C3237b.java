package com.stepos.ailauncher.foundation.appui.card.provider.alipay;

import android.os.SystemClock;
import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\fJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/b;", "", "<init>", "()V", "LY8/t;", Const.INTENT_KEY_APIKEY, "", "reason", "c", "(Ljava/lang/String;)V", "", Const.INTENT_KEY_UMID, "()Z", Const.INTENT_KEY_PKGNAME, "", "e", "()Ljava/lang/Long;", "TTL_MS", "J", "armedAt", "Ljava/lang/Long;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.alipay.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3237b {
    public static final C3237b INSTANCE = new C3237b();
    private static final long TTL_MS = TimeUnit.MINUTES.toMillis(10);
    private static volatile Long armedAt;

    public final synchronized void a() {
        armedAt = Long.valueOf(SystemClock.elapsedRealtime());
        R5.b.INSTANCE.c("alipay.authResume.arm", new Pair[0]);
    }

    public final synchronized boolean b() {
        if (e() == null) {
            return false;
        }
        armedAt = null;
        R5.b.INSTANCE.c("alipay.authResume.consume", new Pair[0]);
        return true;
    }

    public final synchronized void c(String reason) {
        kotlin.jvm.internal.p.i(reason, "reason");
        if (armedAt == null) {
            return;
        }
        armedAt = null;
        R5.b.INSTANCE.c("alipay.authResume.disarm", Y8.j.a("reason", reason));
    }

    public final synchronized boolean d() {
        return e() != null;
    }

    public final Long e() {
        Long l10 = armedAt;
        if (l10 == null) {
            return null;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - l10.longValue();
        if (jElapsedRealtime <= TTL_MS) {
            return l10;
        }
        armedAt = null;
        R5.b.INSTANCE.c("alipay.authResume.expired", Y8.j.a("ageMs", Long.valueOf(jElapsedRealtime)));
        return null;
    }
}
