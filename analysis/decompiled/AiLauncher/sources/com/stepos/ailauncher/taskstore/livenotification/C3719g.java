package com.stepos.ailauncher.taskstore.livenotification;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Locale;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\fJ9\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0016JQ\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010\"\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006¢\u0006\u0004\b\"\u0010\fJ\u001f\u0010&\u001a\u00020%2\u0006\u0010#\u001a\u00020\u00062\b\b\u0002\u0010$\u001a\u00020\u0006¢\u0006\u0004\b&\u0010'J\u001f\u0010)\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\b\b\u0002\u0010(\u001a\u00020\u0006¢\u0006\u0004\b)\u0010\f¨\u0006*"}, d2 = {"Lcom/stepos/ailauncher/taskstore/livenotification/g;", "", "<init>", "()V", "", "type", "", "contentOnly", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Z)Z", "floatOverlay", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(ZZ)Z", "e", "remind", "isExecuting", Const.INTENT_KEY_UMID, "(ZZZZLjava/lang/String;)Z", "status", "c", "(Ljava/lang/String;)Z", Const.INTENT_KEY_APIKEY, "(ZZ)Ljava/lang/Boolean;", "hasPendingRisk", "riskAlreadySeen", "isTakeover", "isAlertingStatus", "goingOnIsland", "statusChanged", "takeoverAlreadySeen", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(ZZZZZZZZ)Z", "shouldRemind", "keepIslandPin", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "alreadySeen", "hasExistingLiveWindow", "", "f", "(ZZ)I", "sessionCenterForeground", Const.INTENT_KEY_BACKGROUND_COMMAND, "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.taskstore.livenotification.g, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3719g {
    public static final C3719g INSTANCE = new C3719g();

    public final Boolean a(boolean contentOnly, boolean floatOverlay) {
        if (contentOnly && !floatOverlay) {
            return Boolean.FALSE;
        }
        return null;
    }

    public final boolean b(String type, boolean contentOnly) {
        kotlin.jvm.internal.p.i(type, "type");
        return contentOnly || La.D.L(type, O5.c.ALIPAY_XUI, true);
    }

    public final boolean c(String status) {
        kotlin.jvm.internal.p.i(status, "status");
        String upperCase = status.toUpperCase(Locale.ROOT);
        kotlin.jvm.internal.p.h(upperCase, "toUpperCase(...)");
        switch (upperCase.hashCode()) {
            case -2026200673:
                return upperCase.equals("RUNNING");
            case -1941992146:
                return upperCase.equals("PAUSED");
            case -1642965155:
                return upperCase.equals("PLANNING");
            case -604548089:
                return upperCase.equals("IN_PROGRESS");
            case 1746537160:
                return upperCase.equals("CREATED");
            default:
                return false;
        }
    }

    public final boolean d(boolean remind, boolean contentOnly, boolean floatOverlay, boolean isExecuting, String type) {
        kotlin.jvm.internal.p.i(type, "type");
        return b(type, contentOnly) ? floatOverlay : !isExecuting && remind && e(contentOnly, floatOverlay);
    }

    public final boolean e(boolean contentOnly, boolean floatOverlay) {
        if (contentOnly) {
            return floatOverlay;
        }
        return true;
    }

    public final int f(boolean alreadySeen, boolean hasExistingLiveWindow) {
        return (alreadySeen && hasExistingLiveWindow) ? 1 : 0;
    }

    public final boolean g(boolean alreadySeen, boolean sessionCenterForeground) {
        return (alreadySeen || sessionCenterForeground) ? false : true;
    }

    public final boolean h(boolean hasPendingRisk, boolean riskAlreadySeen, boolean isTakeover, boolean isAlertingStatus, boolean goingOnIsland, boolean statusChanged, boolean isExecuting, boolean takeoverAlreadySeen) {
        if (hasPendingRisk) {
            return !riskAlreadySeen;
        }
        if (isExecuting) {
            return false;
        }
        return isTakeover ? !takeoverAlreadySeen && (goingOnIsland || statusChanged) : isAlertingStatus && !goingOnIsland && statusChanged;
    }

    public final boolean i(boolean shouldRemind, boolean keepIslandPin) {
        return shouldRemind || keepIslandPin;
    }

    public final boolean j(boolean contentOnly, boolean floatOverlay) {
        if (contentOnly) {
            return !floatOverlay;
        }
        return false;
    }
}
