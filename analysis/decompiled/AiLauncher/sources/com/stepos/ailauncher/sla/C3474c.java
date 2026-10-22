package com.stepos.ailauncher.sla;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\"\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/sla/c;", "", "<init>", "()V", "", x5.d.EXTRA_ENABLED, "Z", Const.INTENT_KEY_PKGNAME, "()Z", "setEnabled", "(Z)V", "localDispatch", "c", "setLocalDispatch", "cloudFirstWhenOnline", Const.INTENT_KEY_APIKEY, "setCloudFirstWhenOnline", "offlineLedgerBypass", Const.INTENT_KEY_UMID, "setOfflineLedgerBypass", "sla_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.sla.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3474c {
    private static volatile boolean cloudFirstWhenOnline;
    public static final C3474c INSTANCE = new C3474c();
    private static volatile boolean enabled = true;
    private static volatile boolean localDispatch = true;
    private static volatile boolean offlineLedgerBypass = true;

    public final boolean a() {
        return cloudFirstWhenOnline;
    }

    public final boolean b() {
        return enabled;
    }

    public final boolean c() {
        return localDispatch;
    }

    public final boolean d() {
        return offlineLedgerBypass;
    }
}
