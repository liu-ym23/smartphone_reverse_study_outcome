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
public final class s implements LevelAbility {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Object> f77339a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final s f77340b = null;

    public s() {
    }

    static {
        f77340b = new s();
        f77339a = new LinkedHashMap();
    }

    @Override // com.bytedance.android.livesdkapi.service.LevelAbility
    public final boolean onLevelChange(int r100) {
        if (r100 >= 0) goto L5;
        BehaviorSubject<d0> r101 = t.f77341a;
        Map<String, Object> r102 = f77339a;
        Intrinsics.checkNotNullParameter(r102, "propertyMap");
        t.f77341a.onNext(new d0(false, r102));
    L6:
        return true;
    L5:
        BehaviorSubject<d0> r103 = t.f77341a;
        Map<String, Object> r104 = f77339a;
        Intrinsics.checkNotNullParameter(r104, "propertyMap");
        t.f77341a.onNext(new d0(true, r104));
        goto L6
    }

    @Override // com.bytedance.android.livesdkapi.service.AtomicAbility
    public final void onPropertyChange(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L18
        Map<String, Object> r102 = f77339a;     // Catch: Throwable -> L18
        ((LinkedHashMap) r102).clear();     // Catch: Throwable -> L18
        r102.putAll(r100);     // Catch: Throwable -> L18
        Object r103 = r100.get("extra");     // Catch: Throwable -> L18
        Unit r104 = null;
        if ((r103 instanceof Map) == true) goto L6;
        r103 = null;
    L6:
        Map r105 = (Map) r103;     // Catch: Throwable -> L18
        if (r105 == null) goto L9;
        Object r106 = r105.get("duration");     // Catch: Throwable -> L18
    L11:
        if ((r106 instanceof Integer) == true) goto L13;
        r106 = null;
    L13:
        Integer r107 = (Integer) r106;     // Catch: Throwable -> L18
        if (r107 == null) goto L16;
        r107.intValue();     // Catch: Throwable -> L18
        BehaviorSubject<d0> r108 = t.f77341a;     // Catch: Throwable -> L18
        r104 = Unit.INSTANCE;     // Catch: Throwable -> L18
    L16:
        Object r109 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L18
    L20:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 == null) goto L26;
        ALogger.e("MultiLinkAtomicAbility-SeiConsume", "setProperty error " + r110.getMessage());
        return;
    L26:
        return;
    L9:
        r106 = null;
    L18:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    }
}
