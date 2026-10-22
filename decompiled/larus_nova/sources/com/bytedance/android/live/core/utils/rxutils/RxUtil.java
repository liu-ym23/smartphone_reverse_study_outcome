package com.bytedance.android.live.core.utils.rxutils;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.core.utils.rxutils.rxlifecycle.LifecycleEvent;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Function4;
import io.reactivex.internal.util.ExceptionHelper;

/* JADX INFO: loaded from: classes45.dex */
public class RxUtil {
    static final Scheduler LIVE_MAIN_THREAD_P5_SCHEDULER = null;
    public static final Object __ = null;
    private static Consumer<Object> noOp;
    private static Consumer<Throwable> noOpThrowable;

    public static /* synthetic */ ObservableSource a(Observable r100) {
        return lambda$bindUntilEvent$2(r100);
    }

    public static /* synthetic */ void b(Throwable r100) {
        lambda$static$0(r100);
    }

    public static /* synthetic */ void c(Object r100) {
        lambda$static$1(r100);
    }

    private static /* synthetic */ ObservableSource lambda$bindUntilEvent$2(Observable r100) {
        return r100;
    }

    private static /* synthetic */ void lambda$static$1(Object r100) throws Exception {
    }

    static {
        LIVE_MAIN_THREAD_P5_SCHEDULER = new q80.b(new Handler(Looper.getMainLooper()));
        noOpThrowable = new p();
        noOp = new q();
        __ = new Object();
    }

    public static <T> IoToUiTransformer<T> rxSchedulerHelper() {
        return new IoToUiTransformer();
    }

    private RxUtil() {
    }

    public static Scheduler getLiveMainThreadP4Scheduler() {
        return i.f66355a;
    }

    public static Scheduler getLiveMainThreadP5Scheduler() {
        return LIVE_MAIN_THREAD_P5_SCHEDULER;
    }

    public static Consumer<Object> getNoOp() {
        return noOp;
    }

    public static Consumer<Throwable> getNoOpThrowable() {
        return noOpThrowable;
    }

    public static <T> ObservableTransformer<T, T> bindUntilDestroy(Activity r100) {
        return bindUntilEvent(r100, LifecycleEvent.DESTROY);
    }

    private static /* synthetic */ void lambda$static$0(Throwable r100) throws Exception {
        LocalTestManager.a(new Class[]{wy.a.class});
    }

    public static void run(Action r100) {
        r100.run();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        throw ExceptionHelper.d(th);
    }

    public static l rxRetryHelper(int r100) {
        return rxRetryHelper(r100, 500);
    }

    public static <T> ObservableTransformer<T, T> bindUntilDestroy(Fragment r100) {
        return bindUntilEvent(r100, LifecycleEvent.DESTROY);
    }

    public static <T> void accept(Consumer<T> r100, T r101) {
        r100.accept(r101);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        throw ExceptionHelper.d(th);
    }

    public static <T, R> R apply(Function<T, R> r100, T r101) {
        return r100.apply(r101);
    L4:
        th = move-exception;
        throw ExceptionHelper.d(th);
    }

    public static <T> ObservableTransformer<T, T> bindUntilEvent(Activity r100, LifecycleEvent r101) {
        if ((r100 instanceof AppCompatActivity) == false) goto L11;
        o80.a<LifecycleEvent> r102 = o80.a.a(((AppCompatActivity) r100).getSupportFragmentManager());
        if (r101 == null) goto L9;
        return new p80.b(r102.f522338a, r101);
    L9:
        throw new NullPointerException("event == null");
    L11:
        return new o();
    }

    public static l rxRetryHelper(int r100, long r101) {
        return new l(r100, r101);
    }

    public static <T> ObservableTransformer<T, T> bindUntilEvent(Fragment r100, LifecycleEvent r101) {
        o80.a<LifecycleEvent> r102 = o80.a.a(r100.getChildFragmentManager());
        if (r101 == null) goto L7;
        return new p80.b(r102.f522338a, r101);
    L7:
        throw new NullPointerException("event == null");
    }

    public static <T, U, R> R apply(BiFunction<T, U, R> r100, T r101, U r102) {
        return r100.apply(r101, r102);
    L4:
        th = move-exception;
        throw ExceptionHelper.d(th);
    }

    public static <T1, T2, T3, R> R apply(Function3<T1, T2, T3, R> r100, T1 r101, T2 r102, T3 r103) {
        return r100.apply(r101, r102, r103);
    L4:
        th = move-exception;
        throw ExceptionHelper.d(th);
    }

    public static <T1, T2, T3, T4, R> R apply(Function4<T1, T2, T3, T4, R> r100, T1 r101, T2 r102, T3 r103, T4 r104) {
        return r100.apply(r101, r102, r103, r104);
    L4:
        th = move-exception;
        throw ExceptionHelper.d(th);
    }
}
