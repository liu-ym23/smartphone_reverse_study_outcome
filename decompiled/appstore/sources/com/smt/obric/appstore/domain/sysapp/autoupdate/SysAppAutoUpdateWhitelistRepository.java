package com.smt.obric.appstore.domain.sysapp.autoupdate;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.b;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes4.dex */
public final class SysAppAutoUpdateWhitelistRepository {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f18114c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile SysAppAutoUpdateWhitelistRepository f18115d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f18116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f18117b;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final SysAppAutoUpdateWhitelistRepository a(Context r10) {
            q.g(r10, "context");
            SysAppAutoUpdateWhitelistRepository r11 = SysAppAutoUpdateWhitelistRepository.b();
            if (r11 != null) goto L15;
            monitor-enter(this);
            r11 = SysAppAutoUpdateWhitelistRepository.b();     // Catch: Throwable -> L9
            if (r11 != null) goto L11;
            Context r12 = r10.getApplicationContext();     // Catch: Throwable -> L9
            q.f(r12, "getApplicationContext(...)");     // Catch: Throwable -> L9
            r11 = new SysAppAutoUpdateWhitelistRepository(r12, null);     // Catch: Throwable -> L9
            SysAppAutoUpdateWhitelistRepository.d(r11);     // Catch: Throwable -> L9
        L11:
            monitor-exit(this);
        L9:
            th = move-exception;
            throw th;
        L15:
            return r11;
        }

        public a() {
        }
    }

    static {
        f18114c = new a(null);
    }

    public /* synthetic */ SysAppAutoUpdateWhitelistRepository(Context r10, DefaultConstructorMarker r11) {
        this(r10);
    }

    public static final /* synthetic */ Context a(SysAppAutoUpdateWhitelistRepository r10) {
        return r10.f18116a;
    }

    public static final /* synthetic */ SysAppAutoUpdateWhitelistRepository b() {
        return f18115d;
    }

    public static final /* synthetic */ SharedPreferences c(SysAppAutoUpdateWhitelistRepository r10) {
        return r10.e();
    }

    public static final /* synthetic */ void d(SysAppAutoUpdateWhitelistRepository r10) {
        f18115d = r10;
    }

    public final SharedPreferences e() {
        Object r10 = this.f18117b.getValue();
        q.f(r10, "getValue(...)");
        return (SharedPreferences) r10;
    }

    public final Object f(Continuation r10) {
        return h.g(l0.b(), new SysAppAutoUpdateWhitelistRepository$getWhitelist$2(this, null), r10);
    }

    public final Object g(Set r10, Continuation r11) {
        Object r12 = h.g(l0.b(), new SysAppAutoUpdateWhitelistRepository$saveWhitelist$2(this, r10, null), r11);
        if (r12 != kotlin.coroutines.intrinsics.a.d()) goto L6;
        return r12;
    L6:
        return Unit.f21064a;
    }

    public SysAppAutoUpdateWhitelistRepository(Context r10) {
        this.f18116a = r10;
        this.f18117b = b.b(new SysAppAutoUpdateWhitelistRepository$sharedPreferences$2(this));
    }
}
