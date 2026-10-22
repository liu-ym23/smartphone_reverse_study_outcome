package com.bytedance.android.livesdk.behavior;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.service.LevelAbility;
import com.facebook.keyframes.model.KFAnimation;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class c implements LevelAbility {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f104289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f104290b = null;

    public c() {
    }

    static {
        f104290b = new c();
        f104289a = true;
    }

    @Override // com.bytedance.android.livesdkapi.service.LevelAbility
    public final boolean onLevelChange(int r100) {
        if (r100 >= 0) goto L5;
        int r101 = b.f104288a;
        return true;
    L5:
        if (f104289a == false) goto L10;
        int r102 = b.f104288a;
        return true;
    L10:
        return true;
    }

    @Override // com.bytedance.android.livesdkapi.service.AtomicAbility
    public final void onPropertyChange(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L16
        Object r102 = r100.get("support_auto_recover");     // Catch: Throwable -> L16
        Object r103 = null;
        if ((r102 instanceof String) == true) goto L8;
        r102 = null;
    L8:
        if ((r102 instanceof String) == false) goto L11;
        r103 = r102;
    L11:
        String r104 = (String) r103;     // Catch: Throwable -> L16
        if (r104 == null) goto L14;
        f104289a = Intrinsics.areEqual(r104, "1");     // Catch: Throwable -> L16
    L14:
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L24;
        ALogger.e("LiveUserBehaviorScheduleAtomicAbility", "setProperty error " + r106.getMessage());
        return;
    L24:
        return;
    L16:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    }
}
