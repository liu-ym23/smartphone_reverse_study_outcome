package com.bytedance.android.live.liveinteract.plantform.performance;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.service.LevelAbility;
import com.facebook.keyframes.model.KFAnimation;
import io.reactivex.subjects.BehaviorSubject;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class k implements LevelAbility {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Object> f77327a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k f77328b = null;

    public k() {
    }

    static {
        f77328b = new k();
        f77327a = new LinkedHashMap();
    }

    @Override // com.bytedance.android.livesdkapi.service.LevelAbility
    public final boolean onLevelChange(int r100) {
        if (r100 >= 0) goto L5;
        BehaviorSubject<d0> r101 = l.f77329a;
        Map<String, Object> r102 = f77327a;
        Intrinsics.checkNotNullParameter(r102, "propertyMap");
        l.f77329a.onNext(new d0(false, r102));
    L6:
        return true;
    L5:
        BehaviorSubject<d0> r103 = l.f77329a;
        Map<String, Object> r104 = f77327a;
        Intrinsics.checkNotNullParameter(r104, "propertyMap");
        l.f77329a.onNext(new d0(true, r104));
        goto L6
    }

    @Override // com.bytedance.android.livesdkapi.service.AtomicAbility
    public final void onPropertyChange(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Map<String, Object> r102 = f77327a;     // Catch: Throwable -> L5
        ((LinkedHashMap) r102).clear();     // Catch: Throwable -> L5
        r102.putAll(r100);     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L13;
        ALogger.e("MultiLinkAtomicAbility-Extreme", "setProperty error " + r104.getMessage());
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
