package com.stepos.ailauncher.container;

import android.os.SystemClock;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003R$\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/ailauncher/container/c0;", "", "<init>", "()V", "LY8/t;", Const.INTENT_KEY_PKGNAME, "", UxipConstants.f30680s, "lastInputUptimeMs", "J", Const.INTENT_KEY_APIKEY, "()J", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class c0 {
    public static final c0 INSTANCE = new c0();
    private static volatile long lastInputUptimeMs;

    public final long a() {
        return lastInputUptimeMs;
    }

    public final void b() {
        lastInputUptimeMs = SystemClock.uptimeMillis();
    }
}
