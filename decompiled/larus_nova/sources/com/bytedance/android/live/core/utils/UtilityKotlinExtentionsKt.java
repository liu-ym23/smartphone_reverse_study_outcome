package com.bytedance.android.live.core.utils;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class UtilityKotlinExtentionsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f66103a = null;

    public static final class a<T> implements ObservableOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f66104a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ r f66105b;

        public a(Function1 r100, r r101) {
            this.f66104a = r100;
            this.f66105b = r101;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            this.f66104a.invoke(this.f66105b);
        }
    }

    public final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f66106a;

        public b(Function0 r100) {
            this.f66106a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f66106a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        f66103a = new Handler(Looper.getMainLooper());
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.app.ActivityThread");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.app.ActivityThread");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.app.ActivityThread");
    }

    private static final Context getContext() {
        Context r100 = TTMiddlewareLiveSDK.getContext();
        if (r100 != null) goto L12;
        r100 = null;
        Object r101 = a().getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L13
        if ((r101 instanceof Application) == true) goto L8;
        r101 = null;
    L8:
        r100 = (Application) r101;     // Catch: Throwable -> L13
    L10:
        Intrinsics.checkNotNull(r100);
    L12:
        return r100.getApplicationContext();
    }

    public static void f(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$fadeWhenTouch");
        r100.setOnTouchListener(new l2(r100, 0.5f, 200));
    }

    public static final Sequence<View> g(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$children");
        return SequencesKt.sequence(new UtilityKotlinExtentionsKt$children$1(r100, null));
    }

    public static final float h(float r100) {
        Resources r101 = getContext().getResources();
        return (WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density * r100) + 0.5f;
    }

    public static final int i(int r100) {
        return (int) h(r100);
    }

    public static final float j(float r100) {
        Resources r101 = getContext().getResources();
        return (r100 / WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f;
    }

    public static final int k(int r100) {
        return (int) j(r100);
    }

    public static final List<Pair<String, String>> l(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getQueriesList");
        Set<String> r101 = UriProtector.getQueryParameterNames(r100);
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        String r104 = (String) r103.next();
        String r105 = UriProtector.getQueryParameter(r100, r104);
        if (r105 != null) goto L8;
        r105 = "";
    L8:
        r102.add(TuplesKt.to(r104, r105));
        goto L4
    L9:
        return r102;
    }

    public static final float m(float r100) {
        Resources r101 = getContext().getResources();
        return TypedValue.applyDimension(2, r100, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()));
    }

    public static final boolean n(py.k r100) {
        if (r100 == null) goto L14;
        List<String> r101 = r100.getUrls();
        if (r101 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == true) goto L14;
        return false;
    L7:
        if (r101.isEmpty() == true) goto L10;
        r102 = false;
    L14:
        return true;
    }

    public static final <V> JSONObject o(Pair<String, ? extends V>... r100) {
        Intrinsics.checkNotNullParameter(r100, "pairs");
        JSONObject r101 = new JSONObject();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        Pair<String, ? extends V> r104 = r100[r103];
        r101.put(r104.getFirst(), r104.getSecond());
        r103 = r103 + 1;
        goto L3
    L5:
        return r101;
    }

    public static final ViewGroup p(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$parentView");
        ViewParent r101 = r100.getParent();
        if ((r101 instanceof ViewGroup) == true) goto L6;
        r101 = null;
    L6:
        return (ViewGroup) r101;
    }

    public static final void q(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$removeFromParent");
        ViewGroup r101 = p(r100);
        if (r101 == null) goto L6;
        r101.removeView(r100);
        Unit r102 = Unit.INSTANCE;
        return;
    }

    public static final void t(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$setVisibilityGone");
        UIUtils.setViewVisibility(r100, 8);
    }

    public static final void u(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$setVisibilityInVisible");
        UIUtils.setViewVisibility(r100, 4);
    }

    public static final void w(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$setVisibilityVisible");
        UIUtils.setViewVisibility(r100, 0);
    }

    public static final void x(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$setVisibilityVisibleAlpha");
        r100.setAlpha(1.0f);
    }

    public static Function0 y(final Function0 r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        final Ref.LongRef r101 = new Ref.LongRef();
        r101.element = 0;
        final long r102 = 500;
        return new UtilityKotlinExtentionsKt$throttle$1(r102, r101, r100);
    }

    public static final void A(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$visibleOrInvisible");
        if (r101 == false) goto L5;
        int r102 = 0;
    L6:
        r100.setVisibility(r102);
        return;
    L5:
        r102 = 4;
        goto L6
    }

    public static final <T> void b(T r100, Function1<? super r<T>, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "task");
        Observable.create(new a(r101, new r(new WeakReference(r100)))).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe();
    }

    public static final void d(View r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$fadeIn");
        w(r100);
        r100.animate().alpha(1.0f).setDuration(r101).start();
    }

    public static final void e(View r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$fadeOut");
        r100.animate().alpha(0.0f).setDuration(r101).withEndAction(new k2(r100)).start();
    }

    public static final void v(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setVisibilitySimple");
        if (r101 == false) goto L5;
        UIUtils.setViewVisibility(r100, 0);
        return;
    L5:
        UIUtils.setViewVisibility(r100, 8);
    }

    public static final void z(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$visibleOrGone");
        if (r101 == false) goto L5;
        int r102 = 0;
    L6:
        r100.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public static final void c(Collection r100, ToolbarButton r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$ensureItemExistence");
        if (r100.contains(r101) == true) goto L6;
        if (r102 == false) goto L6;
        r100.add(r101);
        return;
    L6:
        if (r102 == true) goto L10;
        r100.remove(r101);
        return;
    }

    public static final void r(long r100, boolean r101, boolean r102, Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r103, "action");
        if (r100 <= 0) goto L5;
        f66103a.postDelayed(new b(r103), r100);
        return;
    L5:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L8;
        if (r102 == true) goto L8;
        r103.invoke();
        return;
    L8:
        if (r101 == false) goto L10;
        f66103a.postAtTime(new b(r103), 2);
        return;
    L10:
        f66103a.post(new b(r103));
    }

    public static /* synthetic */ void s(long r100, boolean r101, boolean r102, Function0 r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r104 & 4) == 0) goto L11;
        r102 = false;
    L11:
        r(r100, r101, r102, r103);
    }
}
