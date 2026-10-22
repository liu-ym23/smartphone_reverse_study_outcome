package com.stepos.ailauncher.common.utils;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.credential.api.AuthSessionDto;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b \b\u0000\u0018\u0000 12\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\rJ?\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00112\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011¢\u0006\u0004\b\u0015\u0010\u0016J+\u0010\u0019\u001a\u0004\u0018\u00010\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0004¢\u0006\u0004\b\u001b\u0010\u0003J\u000f\u0010\u001c\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u0003R$\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\bR$\u0010!\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b!\u0010\u001f\u001a\u0004\b\"\u0010\bR$\u0010#\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b#\u0010\u001f\u001a\u0004\b$\u0010\bR\u0016\u0010%\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010\u001fR\u0016\u0010&\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010\u001fR\u0018\u0010'\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010+\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010*R\u0016\u0010.\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010*R\u0016\u0010/\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010\u001fR\u0018\u00100\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010(¨\u00062"}, d2 = {"Lcom/stepos/ailauncher/common/utils/u;", "", "<init>", "()V", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "", "f", "()Z", com.stepos.ailauncher.chat.trace.h.APP_FOREGROUND, "", "now", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(ZJ)V", "visible", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "privacyGranted", "Lkotlin/Function0;", "", "topPackage", "homePackage", "k", "(ZJLp9/a;Lp9/a;)Ljava/lang/String;", "top", "home", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;Ljava/lang/String;J)Ljava/lang/String;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, UxipConstants.f30680s, "detecting", "Z", "c", "inRecents", "e", "hasEnteredHome", Const.INTENT_KEY_UMID, "armed", "hostForeground", "foregroundSince", "Ljava/lang/Long;", "deadline", "J", AuthSessionDto.STATUS_PENDING, "Ljava/lang/String;", "pendingSince", "lastSampleAt", "desktopReturn", "anonymousSince", "Companion", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class u {
    public static final long FOREGROUND_SETTLE_MS = 400;
    public static final long MAX_SAMPLE_GAP_MS = 500;
    public static final long TIMEOUT_MS = 6000;
    private Long anonymousSince;
    private boolean armed;
    private long deadline;
    private boolean desktopReturn;
    private boolean detecting;
    private Long foregroundSince;
    private boolean hasEnteredHome;
    private boolean hostForeground;
    private boolean inRecents;
    private long lastSampleAt;
    private String pending;
    private long pendingSince;

    public final void a() {
        this.detecting = false;
        this.armed = false;
        this.desktopReturn = false;
        b();
    }

    public final void b() {
        this.anonymousSince = null;
        this.pending = null;
        this.pendingSince = 0L;
        this.lastSampleAt = 0L;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getDetecting() {
        return this.detecting;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getHasEnteredHome() {
        return this.hasEnteredHome;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getInRecents() {
        return this.inRecents;
    }

    public final boolean f() {
        if (!this.detecting || this.hostForeground || this.inRecents) {
            return false;
        }
        this.desktopReturn = true;
        b();
        return true;
    }

    public final void g() {
        this.hasEnteredHome = true;
    }

    public final void h(boolean foreground, long now) {
        if (this.hasEnteredHome) {
            this.hostForeground = foreground;
            if (!foreground) {
                this.foregroundSince = null;
                if (!this.armed || this.detecting) {
                    return;
                }
                this.armed = false;
                this.detecting = true;
                this.deadline = now + 6000;
                b();
                return;
            }
            this.desktopReturn = false;
            b();
            if (this.foregroundSince == null) {
                this.foregroundSince = Long.valueOf(now);
            }
            if (this.detecting) {
                Long l10 = this.foregroundSince;
                kotlin.jvm.internal.p.f(l10);
                if (now - l10.longValue() < 400) {
                    return;
                }
            }
            a();
            this.armed = true;
        }
    }

    public final void i(boolean visible, long now) {
        if (this.inRecents == visible) {
            return;
        }
        this.inRecents = visible;
        this.desktopReturn = false;
        b();
        if (visible || !this.detecting) {
            return;
        }
        this.deadline = now + 6000;
    }

    public final String j(String top, String home, long now) {
        String str;
        if (!this.detecting) {
            return null;
        }
        if (this.inRecents) {
            b();
            return null;
        }
        if (now >= this.deadline) {
            a();
            return null;
        }
        if (!this.hostForeground && top != null && !La.H.x0(top)) {
            t tVar = t.INSTANCE;
            if (!tVar.b(top)) {
                if (!kotlin.jvm.internal.p.d(top, home)) {
                    this.desktopReturn = false;
                }
                if (kotlin.jvm.internal.p.d(this.pending, top)) {
                    long j10 = this.lastSampleAt;
                    if (now - j10 <= 500) {
                        if (now <= j10) {
                            return null;
                        }
                        this.lastSampleAt = now;
                        if (this.desktopReturn && kotlin.jvm.internal.p.d(top, home)) {
                            str = top;
                        } else {
                            str = top;
                            if (!tVar.e(str, this.pending, this.pendingSince, now, home)) {
                                return null;
                            }
                        }
                        a();
                        return str;
                    }
                }
                this.pending = top;
                this.pendingSince = now;
                this.lastSampleAt = now;
                return null;
            }
        }
        this.desktopReturn = false;
        b();
        return null;
    }

    public final String k(boolean privacyGranted, long now, InterfaceC5063a<String> topPackage, InterfaceC5063a<String> homePackage) {
        kotlin.jvm.internal.p.i(topPackage, "topPackage");
        kotlin.jvm.internal.p.i(homePackage, "homePackage");
        if (this.hasEnteredHome && this.detecting) {
            if (privacyGranted) {
                this.anonymousSince = null;
                return j(topPackage.invoke(), homePackage.invoke(), now);
            }
            this.pending = null;
            if (!this.inRecents && !this.hostForeground) {
                if (now >= this.deadline) {
                    a();
                    return null;
                }
                Long l10 = this.anonymousSince;
                if (l10 != null) {
                    long j10 = this.lastSampleAt;
                    if (now - j10 <= 500) {
                        if (now <= j10) {
                            return null;
                        }
                        this.lastSampleAt = now;
                        kotlin.jvm.internal.p.f(l10);
                        if (now - l10.longValue() < 1200) {
                            return null;
                        }
                        a();
                        return "";
                    }
                }
                this.anonymousSince = Long.valueOf(now);
                this.lastSampleAt = now;
                return null;
            }
            b();
        }
        return null;
    }
}
