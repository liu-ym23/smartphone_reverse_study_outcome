package com.bytedance.android.livesdk.ability;

import com.bytedance.android.livesdk.utils.r2;
import com.facebook.keyframes.model.KFAnimation;
import java.util.HashSet;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014J\u001c\u0010\u0015\u001a\u00020\u00162\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018J \u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00040\bj\b\u0012\u0004\u0012\u00020\u0004`\t2\u0006\u0010\u001a\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R+\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00040\bj\b\u0012\u0004\u0012\u00020\u0004`\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/ability/LiveLoggerScheduleAtomicAbility;", "", "()V", "LIVE_FORBIDDEN_EVENTS", "", "LIVE_FORBIDDEN_EVENTS_ARRAY", "TAG", "forbiddenLogEvents", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getForbiddenLogEvents", "()Ljava/util/HashSet;", "forbiddenLogEvents$delegate", "Lkotlin/Lazy;", "forbiddenStrategy", "", "filterLiveLoggerSchedule", "eventName", "onLevelChange", "level", "", "onPropertyChange", "", KFAnimation.PROPERTY_TYPE_JSON_FIELD, "", "parseForbiddenLiveEvents", "forbiddenEvents", "livelogger-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveLoggerScheduleAtomicAbility {
    public static final LiveLoggerScheduleAtomicAbility INSTANCE = null;
    private static final String LIVE_FORBIDDEN_EVENTS = "live_forbidden_events";
    private static final String LIVE_FORBIDDEN_EVENTS_ARRAY = "live_forbidden_events_array";
    private static final String TAG = "LiveLoggerScheduleAtomicAbility";
    private static final Lazy forbiddenLogEvents$delegate = null;
    private static boolean forbiddenStrategy;

    private LiveLoggerScheduleAtomicAbility() {
    }

    private final HashSet<String> getForbiddenLogEvents() {
        return (HashSet) forbiddenLogEvents$delegate.getValue();
    }

    static {
        INSTANCE = new LiveLoggerScheduleAtomicAbility();
        forbiddenLogEvents$delegate = LazyKt.lazy(LiveLoggerScheduleAtomicAbility$forbiddenLogEvents$2.INSTANCE);
    }

    private final HashSet<String> parseForbiddenLiveEvents(String r100) {
        HashSet<String> r101 = new HashSet(10);
        r101.addAll(StringsKt.split$default(r100, new String[]{","}, false, 0, 6, null));
        return r101;
    }

    public final boolean filterLiveLoggerSchedule(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        if (forbiddenStrategy == true) goto L5;
    L7:
        return false;
    L5:
        if (getForbiddenLogEvents().contains(r100) == false) goto L7;
        return true;
    }

    public final boolean onLevelChange(int r100) {
        if (r100 >= 0) goto L5;
        forbiddenStrategy = true;
    L6:
        return true;
    L5:
        forbiddenStrategy = false;
        goto L6
    }

    public final void onPropertyChange(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L20
        LiveLoggerScheduleAtomicAbility r102 = INSTANCE;     // Catch: Throwable -> L20
        r102.getForbiddenLogEvents().clear();     // Catch: Throwable -> L20
        Object r103 = r100.get(LIVE_FORBIDDEN_EVENTS);     // Catch: Throwable -> L20
        Boolean r104 = null;
        if ((r103 instanceof String) == true) goto L8;
        r103 = null;
    L8:
        if ((r103 instanceof String) == true) goto L10;
        r103 = null;
    L10:
        String r105 = (String) r103;     // Catch: Throwable -> L20
        if (r105 != null) goto L13;
    L18:
        Result.m9449constructorimpl(r104);     // Catch: Throwable -> L20
        return;
    L13:
        if (r2.a(r105) == true) goto L16;
        r105 = null;
    L16:
        if (r105 == null) goto L18;
        r104 = Boolean.valueOf(r102.getForbiddenLogEvents().addAll(r102.parseForbiddenLiveEvents(r105)));     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
