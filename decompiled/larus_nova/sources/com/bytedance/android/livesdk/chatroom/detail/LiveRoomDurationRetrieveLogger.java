package com.bytedance.android.livesdk.chatroom.detail;

import android.os.SystemClock;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.r71;
import com.bytedance.keva.Keva;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.ReplaySubject;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class LiveRoomDurationRetrieveLogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f105611a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f105612b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f105613c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f105614d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f105615e;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f105616a = null;

        static {
            f105616a = new a();
        }

        public a() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Boolean r101 = (Boolean) r100;
            long r102 = SystemClock.elapsedRealtime();
            Keva r103 = LiveRoomDurationRetrieveLogger.c();
            List r104 = CollectionsKt.toMutableList(LiveRoomDurationRetrieveLogger.d().values());
            LiveRoomDurationRetrieveLogger.h("storeJsonObject ".concat(String.valueOf(r104)));
        L12:
            e = move-exception;
            LiveRoomDurationRetrieveLogger.g("cannot storeGsonObject " + List.class.getSimpleName() + ", key=live_room_duration_retrieve_logger_key", e);
        L14:
            LiveRoomDurationRetrieveLogger.h("storeRetrieveLogger onNext cost " + (SystemClock.elapsedRealtime() - r102));
            return;
        L4:
            if (LiveRoomDurationRetrieveLogger.a().e() == false) goto L8;
            Observable.fromCallable(new y(r103, r104)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(z.f105738a, a0.f105619a);     // Catch: Exception -> L12
        L16:
            goto L14
        L8:
            if (r104 != null) goto L10;
            r103.erase("live_room_duration_retrieve_logger_key");     // Catch: Exception -> L12
            goto L16
        L10:
            r103.storeString("live_room_duration_retrieve_logger_key", GsonHelper.get().toJson(r104));     // Catch: Exception -> L12
            goto L16
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f105617a = null;

        static {
            f105617a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            long r102 = SystemClock.elapsedRealtime();
            Keva r103 = LiveRoomDurationRetrieveLogger.c();
            List r104 = CollectionsKt.toMutableList(LiveRoomDurationRetrieveLogger.d().values());
            LiveRoomDurationRetrieveLogger.h("storeJsonObject ".concat(String.valueOf(r104)));
        L12:
            e = move-exception;
            LiveRoomDurationRetrieveLogger.g("cannot storeGsonObject " + List.class.getSimpleName() + ", key=live_room_duration_retrieve_logger_key", e);
        L14:
            LiveRoomDurationRetrieveLogger.g("storeRetrieveLogger onError cost " + (SystemClock.elapsedRealtime() - r102), r101);
            return;
        L4:
            if (LiveRoomDurationRetrieveLogger.a().e() == false) goto L8;
            Observable.fromCallable(new y(r103, r104)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(z.f105738a, a0.f105619a);     // Catch: Exception -> L12
        L16:
            goto L14
        L8:
            if (r104 != null) goto L10;
            r103.erase("live_room_duration_retrieve_logger_key");     // Catch: Exception -> L12
            goto L16
        L10:
            r103.storeString("live_room_duration_retrieve_logger_key", GsonHelper.get().toJson(r104));     // Catch: Exception -> L12
            goto L16
        }
    }

    public static r71 a() {
        return (r71) f105611a.getValue();
    }

    public static ReplaySubject b() {
        return (ReplaySubject) f105614d.getValue();
    }

    public static Keva c() {
        return (Keva) f105612b.getValue();
    }

    public static ConcurrentHashMap d() {
        return (ConcurrentHashMap) f105613c.getValue();
    }

    static {
        f105611a = LazyKt.lazy(LiveRoomDurationRetrieveLogger$config$2.INSTANCE);
        f105612b = LazyKt.lazy(LiveRoomDurationRetrieveLogger$roomRetrieveKeva$2.INSTANCE);
        f105613c = LazyKt.lazy(LiveRoomDurationRetrieveLogger$roomRetrieveMap$2.INSTANCE);
        f105614d = LazyKt.lazy(LiveRoomDurationRetrieveLogger$mCurrentStatus$2.INSTANCE);
    }

    @JvmStatic
    public static final boolean e() {
        return a().b();
    }

    @JvmStatic
    public static final void f() {
        if (e() == false) goto L8;
        h("logRetrieveLogger  isLoaded: " + f105615e);
        if (f105615e == true) goto L9;
        Observable.fromCallable(v.f105732a).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(w.f105733a, x.f105734a);
        return;
    L9:
        return;
    }

    @JvmStatic
    public static final void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        ALogger.i("LiveRoomDurationRetrieveLogger", r100);
    }

    public static void i(boolean r100) {
        if (f105615e == true) goto L6;
        if (r100 == true) goto L6;
        b().subscribe(a.f105616a, b.f105617a);
        return;
    L6:
        long r101 = SystemClock.elapsedRealtime();
        Keva r102 = c();
        List r103 = CollectionsKt.toMutableList(d().values());
        h("storeJsonObject ".concat(String.valueOf(r103)));
    L16:
        e = move-exception;
        g("cannot storeGsonObject " + List.class.getSimpleName() + ", key=live_room_duration_retrieve_logger_key", e);
    L18:
        h("storeRetrieveLogger cost " + (SystemClock.elapsedRealtime() - r101));
        return;
    L8:
        if (a().e() == false) goto L12;
        Observable.fromCallable(new y(r102, r103)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(z.f105738a, a0.f105619a);     // Catch: Exception -> L16
    L20:
        goto L18
    L12:
        if (r103 != null) goto L14;
        r102.erase("live_room_duration_retrieve_logger_key");     // Catch: Exception -> L16
        goto L20
    L14:
        r102.storeString("live_room_duration_retrieve_logger_key", GsonHelper.get().toJson(r103));     // Catch: Exception -> L16
        goto L20
    }

    @JvmStatic
    public static final void g(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        Intrinsics.checkNotNullParameter(r101, "e");
        ALogger.e("LiveRoomDurationRetrieveLogger", r100, r101);
    }
}
