package com.bytedance.android.shopping.prepurchase.arch.atom_event;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.ec.core.utils.LoginUtil;
import com.bytedance.android.shopping.slice.action.entity.CheckLoginParam;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class ECCheckLoginActionAtomEvent extends t96.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f180673c;

    public ECCheckLoginActionAtomEvent(Context r100) {
        Intrinsics.checkNotNullParameter("loginVerification", "name");
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super("loginVerification");
        this.f180673c = r100;
    }

    @Override // t96.a
    public final void b(EventContext r110, final Function1<? super com.bytedance.kmp.ec.yata.chain.event.b, Unit> r111) {
        Intrinsics.checkNotNullParameter(r110, "eventContext");
        Intrinsics.checkNotNullParameter(r111, "completion");
        CheckLoginParam.a r100 = CheckLoginParam.Companion;
        Map<String, ? extends Object> r112 = r110.f251278k;
        r100.getClass();
        final CheckLoginParam r113 = CheckLoginParam.a.a(r112);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L32
        Context r102 = this.f180673c;     // Catch: Throwable -> L32
        String r103 = null;
        if ((r102 instanceof Activity) == true) goto L6;
        r102 = null;
    L6:
        Activity r104 = (Activity) r102;     // Catch: Throwable -> L32
        final long r105 = System.currentTimeMillis();     // Catch: Throwable -> L32
        if (r104 != null) goto L10;
        int r114 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;     // Catch: Throwable -> L32
        r111.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "activity is null", null, null, 57));     // Catch: Throwable -> L32
        return;
    L10:
        Map<String, String> r106 = LoginUtil.f45533a;     // Catch: Throwable -> L32
        if (r113 == null) goto L14;
        String r107 = r113.getEnterFrom();     // Catch: Throwable -> L32
    L16:
        if (r107 != null) goto L18;
        String r108 = "";
    L19:
        if (r113 == null) goto L21;
        String r109 = r113.getEnterMethod();     // Catch: Throwable -> L32
    L22:
        if (r109 != null) goto L24;
        String r115 = "";
    L25:
        if (r113 == null) goto L27;
        r103 = r113.getSource();     // Catch: Throwable -> L32
    L27:
        if (r103 != null) goto L29;
        String r116 = "";
    L30:
        LoginUtil.b(r104, r108, r115, r116, new ECCheckLoginActionAtomEvent$handle$$inlined$runCatching$lambda$1(r105, this, r111, r113), new ECCheckLoginActionAtomEvent$handle$$inlined$runCatching$lambda$2(this, r111, r113));     // Catch: Throwable -> L32
        Object r117 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L32
    L34:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);
        if (r118 == null) goto L39;
        int r119 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r111.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "check login exception: " + r118.getMessage(), null, null, 57));
        return;
    L39:
        return;
    L29:
        r116 = r103;
        goto L30
    L24:
        r115 = r109;
        goto L25
    L21:
        r109 = null;
        goto L22
    L18:
        r108 = r107;
        goto L19
    L14:
        r107 = null;
    L32:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L34
    }
}
