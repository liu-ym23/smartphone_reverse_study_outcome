package bba;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.bytedance.keva.Keva;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f18558b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ContentResolver f18559a;

    public static final class a {
    }

    static {
    }

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f18559a = r100.getApplicationContext().getContentResolver();
    }

    public final bba.a a(Long r110) {
        boolean r100 = true;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(Keva.getRepo("obric_ai_key_gesture", 1));     // Catch: Throwable -> L5
    L7:
        Long r103 = null;
        if (Result.m9455isFailureimpl(r102) == false) goto L10;
        r102 = null;
    L10:
        Keva r104 = (Keva) r102;
        Object r105 = Result.m9449constructorimpl(Integer.valueOf(Settings.Global.getInt(this.f18559a, "ai_key_sensitivity", 0)));     // Catch: Throwable -> L13
    L16:
        if (Result.m9455isFailureimpl(r105) == false) goto L18;
        r105 = 0;
    L18:
        int r106 = ((Number) r105).intValue();
        long r107 = 180000;
        if (r104 != null) goto L78;
        Long r108 = null;
    L24:
        Object r109 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L21
    L28:
        if (Result.m9455isFailureimpl(r109) == false) goto L30;
        r109 = null;
    L30:
        Long r111 = (Long) r109;
        if (r111 == null) goto L33;
        long r112 = r111.longValue();
    L35:
        if (r110 != null) goto L37;
    L45:
        long r113 = r112;
    L46:
        if (r110 != null) goto L48;
    L57:
        long[] r114 = bba.a.f18553e;
        if (r106 >= 0) goto L60;
    L62:
        boolean r115 = false;
    L63:
        if (r115 == false) goto L65;
        long r116 = r114[r106];
    L66:
        Long r117 = Long.valueOf(r113);
        if (r117.longValue() > 0) goto L70;
        r100 = false;
    L70:
        if (r100 == false) goto L72;
        r103 = r117;
    L72:
        if (r103 == null) goto L75;
        r107 = r103.longValue();
    L75:
        return new bba.a(r116, r107);
    L65:
        r116 = r114[0];
        goto L66
    L60:
        if (r106 >= 3) goto L62;
        r115 = true;
        goto L63
    L48:
        if (r113 == r112) goto L57;
        if (r104 != null) goto L76;
        Unit r118 = null;
    L54:
        Result.m9449constructorimpl(r118);     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L57
    L76:
        r104.storeLong("gesture_timeout_millis", r113);     // Catch: Throwable -> L51
        r118 = Unit.INSTANCE;     // Catch: Throwable -> L51
        goto L54
    L37:
        if (r110.longValue() <= 0) goto L39;
        boolean r120 = true;
    L40:
        if (r120 == false) goto L42;
        Long r121 = r110;
    L43:
        if (r121 == null) goto L45;
        r113 = r121.longValue();
        goto L46
    L42:
        r121 = null;
        goto L43
    L39:
        r120 = false;
        goto L40
    L33:
        r112 = 180000;
    L21:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L28
    L78:
        r108 = Long.valueOf(r104.getLong("gesture_timeout_millis", 180000));     // Catch: Throwable -> L21
    L13:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
