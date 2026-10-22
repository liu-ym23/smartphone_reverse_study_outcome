package com.stepos.ailauncher.chat.lockscreen;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/chat/lockscreen/l;", "", "<init>", "()V", "", "nowMs", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(J)V", "c", "", Const.INTENT_KEY_UMID, "(J)Z", UxipConstants.f30680s, HomeGestureEligibilityContract.EXTRA_GENERATION, "J", Const.INTENT_KEY_APIKEY, "()J", "pendingUntilMs", "Ljava/lang/Long;", "suppressCurrentSession", "Z", "Companion", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.lockscreen.l, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2679l {
    private static final a Companion = new a(null);

    @Deprecated
    public static final long PENDING_TIMEOUT_MS = 60000;
    private long generation;
    private Long pendingUntilMs;
    private boolean suppressCurrentSession;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/chat/lockscreen/l$a;", "", "<init>", "()V", "", "PENDING_TIMEOUT_MS", "J", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.lockscreen.l$a */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    /* renamed from: a, reason: from getter */
    public final long getGeneration() {
        return this.generation;
    }

    public final void b(long nowMs) {
        this.generation++;
        if (this.suppressCurrentSession) {
            return;
        }
        this.pendingUntilMs = Long.valueOf(nowMs + 60000);
    }

    public final void c() {
        this.generation++;
        this.suppressCurrentSession = false;
    }

    public final boolean d(long nowMs) {
        if (this.suppressCurrentSession) {
            return true;
        }
        Long l10 = this.pendingUntilMs;
        if (l10 == null) {
            return false;
        }
        long jLongValue = l10.longValue();
        this.pendingUntilMs = null;
        if (nowMs >= jLongValue) {
            return false;
        }
        this.suppressCurrentSession = true;
        return true;
    }
}
