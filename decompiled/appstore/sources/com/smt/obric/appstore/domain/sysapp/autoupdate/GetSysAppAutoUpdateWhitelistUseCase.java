package com.smt.obric.appstore.domain.sysapp.autoupdate;

import android.content.Context;
import com.bytedanceos.common.toolbox.j;
import java.util.Set;
import kotlin.Lazy;
import kotlin.b;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes4.dex */
public final class GetSysAppAutoUpdateWhitelistUseCase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f18104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SysAppAutoUpdateWhitelistRepository f18105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f18106c;

    public GetSysAppAutoUpdateWhitelistUseCase(Context r10) {
        q.g(r10, "context");
        this.f18104a = r10;
        this.f18105b = SysAppAutoUpdateWhitelistRepository.f18114c.a(r10);
        this.f18106c = b.b(new GetSysAppAutoUpdateWhitelistUseCase$defaultWhitelist$2(this));
    }

    public static final /* synthetic */ Context a(GetSysAppAutoUpdateWhitelistUseCase r10) {
        return r10.f18104a;
    }

    public final Set b() {
        return (Set) this.f18106c.getValue();
    }

    public final Object c(Continuation r10) {
        if ((r10 instanceof GetSysAppAutoUpdateWhitelistUseCase$invoke$1) == false) goto L7;
        GetSysAppAutoUpdateWhitelistUseCase$invoke$1 r11 = (GetSysAppAutoUpdateWhitelistUseCase$invoke$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = kotlin.coroutines.intrinsics.a.d();
        int r15 = r11.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        GetSysAppAutoUpdateWhitelistUseCase this = (GetSysAppAutoUpdateWhitelistUseCase) r11.L$0;
        c.b(r13);
    L17:
        Set r16 = (Set) r13;
        Set r17 = r16;
        if (r17 != null) goto L20;
    L23:
        j.s("[GetSysAppAutoUpdateWhitelistUseCase] warning: db is empty, using default whitelist");
        return this.b();
    L20:
        if (r17.isEmpty() == true) goto L23;
        return r16;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        c.b(r13);
        SysAppAutoUpdateWhitelistRepository r18 = this.f18105b;
        r11.L$0 = this;
        r11.label = 1;
        r13 = r18.f(r11);
        if (r13 != r14) goto L17;
        return r14;
    L7:
        r11 = new GetSysAppAutoUpdateWhitelistUseCase$invoke$1(this, r10);
        goto L8
    }

    public final Set d() {
        return (Set) h.e(l0.b(), new GetSysAppAutoUpdateWhitelistUseCase$invokeSync$1(this, null));
    }
}
