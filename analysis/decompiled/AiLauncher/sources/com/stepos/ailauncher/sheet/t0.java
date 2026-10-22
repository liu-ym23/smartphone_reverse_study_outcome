package com.stepos.ailauncher.sheet;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u0003R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/sheet/t0;", "", "<init>", "()V", "", "sameStack", "", "nowMs", "LY8/t;", "c", "(ZJ)V", Const.INTENT_KEY_PKGNAME, "(J)Z", Const.INTENT_KEY_APIKEY, "launchTimeMs", "Ljava/lang/Long;", "Companion", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class t0 {
    private static final a Companion = new a(null);

    @Deprecated
    public static final long TIMEOUT_MS = 2000;
    private Long launchTimeMs;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/sheet/t0$a;", "", "<init>", "()V", "", "TIMEOUT_MS", "J", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    public final void a() {
        this.launchTimeMs = null;
    }

    public final boolean b(long nowMs) {
        Long l10 = this.launchTimeMs;
        a();
        if (l10 == null) {
            return false;
        }
        long jLongValue = nowMs - l10.longValue();
        return 0 <= jLongValue && jLongValue < 2000;
    }

    public final void c(boolean sameStack, long nowMs) {
        Long lValueOf = Long.valueOf(nowMs);
        if (!sameStack) {
            lValueOf = null;
        }
        this.launchTimeMs = lValueOf;
    }
}
