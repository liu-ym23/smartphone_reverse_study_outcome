package com.bytedance.android.accessibilityLib_Core.helper;

import android.app.Activity;
import android.content.Context;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes43.dex */
public final class AppWindows {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Class<?> f38255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f38256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<? extends Object> f38257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Integer, WeakReference<b>> f38258d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f38259e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CopyOnWriteArrayList<a> f38260f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f38261g;

    public interface a {
        void a();

        void b(Window r100, View r101, String r102);

        void c(View r100, String r101);
    }

    public final class b implements Window.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Window.Callback f38262a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f38263b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Window.Callback f38264c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Window f38265d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final View f38266e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ AppWindows f38267f;

        @Override // android.view.Window.Callback
        public final boolean dispatchGenericMotionEvent(MotionEvent r100) {
            return this.f38264c.dispatchGenericMotionEvent(r100);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchKeyShortcutEvent(KeyEvent r100) {
            return this.f38264c.dispatchKeyShortcutEvent(r100);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r100) {
            return this.f38264c.dispatchPopulateAccessibilityEvent(r100);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchTrackballEvent(MotionEvent r100) {
            return this.f38264c.dispatchTrackballEvent(r100);
        }

        @Override // android.view.Window.Callback
        public final void onActionModeFinished(ActionMode r100) {
            this.f38264c.onActionModeFinished(r100);
        }

        @Override // android.view.Window.Callback
        public final void onActionModeStarted(ActionMode r100) {
            this.f38264c.onActionModeStarted(r100);
        }

        @Override // android.view.Window.Callback
        public final void onAttachedToWindow() {
            this.f38264c.onAttachedToWindow();
        }

        @Override // android.view.Window.Callback
        public final void onContentChanged() {
            this.f38264c.onContentChanged();
        }

        @Override // android.view.Window.Callback
        public final boolean onCreatePanelMenu(int r100, Menu r101) {
            return this.f38264c.onCreatePanelMenu(r100, r101);
        }

        @Override // android.view.Window.Callback
        public final View onCreatePanelView(int r100) {
            return this.f38264c.onCreatePanelView(r100);
        }

        @Override // android.view.Window.Callback
        public final void onDetachedFromWindow() {
            this.f38264c.onDetachedFromWindow();
        }

        @Override // android.view.Window.Callback
        public final boolean onMenuItemSelected(int r100, MenuItem r101) {
            return this.f38264c.onMenuItemSelected(r100, r101);
        }

        @Override // android.view.Window.Callback
        public final boolean onMenuOpened(int r100, Menu r101) {
            return this.f38264c.onMenuOpened(r100, r101);
        }

        @Override // android.view.Window.Callback
        public final void onPanelClosed(int r100, Menu r101) {
            this.f38264c.onPanelClosed(r100, r101);
        }

        @Override // android.view.Window.Callback
        public final boolean onPreparePanel(int r100, View r101, Menu r102) {
            return this.f38264c.onPreparePanel(r100, r101, r102);
        }

        @Override // android.view.Window.Callback
        public final boolean onSearchRequested() {
            return this.f38264c.onSearchRequested();
        }

        @Override // android.view.Window.Callback
        public final boolean onSearchRequested(SearchEvent r100) {
            return this.f38264c.onSearchRequested(r100);
        }

        @Override // android.view.Window.Callback
        public final void onWindowAttributesChanged(WindowManager.LayoutParams r100) {
            this.f38264c.onWindowAttributesChanged(r100);
        }

        @Override // android.view.Window.Callback
        public final void onWindowFocusChanged(boolean r100) {
            this.f38264c.onWindowFocusChanged(r100);
        }

        @Override // android.view.Window.Callback
        public final ActionMode onWindowStartingActionMode(ActionMode.Callback r100) {
            return this.f38264c.onWindowStartingActionMode(r100);
        }

        @Override // android.view.Window.Callback
        public final ActionMode onWindowStartingActionMode(ActionMode.Callback r100, int r101) {
            return this.f38264c.onWindowStartingActionMode(r100, r101);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchKeyEvent(KeyEvent r100) {
            return this.f38264c.dispatchKeyEvent(r100);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchTouchEvent(MotionEvent r110) {
            if (this.f38267f.f38261g == false) goto L45;
            if (this.f38262a != null) goto L7;
        L40:
            Iterator<a> r100 = this.f38267f.f38260f.iterator();
        L42:
            if (r100.hasNext() == false) goto L45;
            r100.next().a();
            goto L42
        L7:
            if (r110.getAction() != 0) goto L29;
            View r101 = this.f38266e;
            if ((r101 instanceof ViewGroup) == true) goto L11;
            r101 = null;
        L11:
            ViewGroup r102 = (ViewGroup) r101;
            if (r102 == null) goto L29;
            int r103 = r102.getChildCount();
            int r104 = 0;
        L14:
            if (r104 >= r103) goto L29;
            View r105 = r102.getChildAt(r104);
            this.f38267f.getClass();
            int[] r106 = new int[2];
            r105.getLocationOnScreen(r106);
            int r107 = r106[0];
            int r108 = r106[1];
            if (r110.getX() >= r107) goto L18;
        L24:
            boolean r109 = false;
        L25:
            if (r109 == false) goto L27;
            this.f38263b = true;
        L27:
            r104 = r104 + 1;
            goto L14
        L18:
            if (r110.getX() > (r107 + r105.getWidth())) goto L24;
            if (r110.getY() < r108) goto L24;
            if (r110.getY() > (r108 + r105.getHeight())) goto L24;
            r109 = true;
        L29:
            if (this.f38263b == false) goto L36;
            Window.Callback r111 = this.f38262a;
            if (r111 != null) goto L34;
            Intrinsics.throwNpe();
        L34:
            return r111.dispatchTouchEvent(r110);
        L36:
            if (r110.getAction() != 1) goto L38;
        L39:
            this.f38263b = false;
            goto L40
        L38:
            if (r110.getAction() != 3) goto L40;
        L45:
            return this.f38264c.dispatchTouchEvent(r110);
        }

        public b(AppWindows r100, Window.Callback r101, Window r102, View r103) {
            this.f38267f = r100;
            this.f38264c = r101;
            this.f38265d = r102;
            this.f38266e = r103;
            if (((Class) r100.f38259e.getValue()) == null) goto L21;
            Class r104 = (Class) r100.f38259e.getValue();
            if (r104 != null) goto L8;
            Intrinsics.throwNpe();
        L8:
            if (r104.isAssignableFrom(r101.getClass()) == false) goto L22;
            Class r105 = (Class) r100.f38259e.getValue();     // Catch: Throwable -> L17
            if (r105 != null) goto L12;
            Intrinsics.throwNpe();     // Catch: Throwable -> L17
        L12:
            Field r106 = r105.getDeclaredField("mWrapped");     // Catch: Throwable -> L17
            r106.setAccessible(true);     // Catch: Throwable -> L17
            Object r107 = r106.get(r101);     // Catch: Throwable -> L17
            if (r107 == null) goto L16;
            this.f38262a = (Window.Callback) r107;     // Catch: Throwable -> L17
            return;
        L16:
            throw new TypeCastException("null cannot be cast to non-null type android.view.Window.Callback");     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            th.getMessage();
            return;
        L22:
            return;
        }
    }

    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppWindows f38268a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Window f38269b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f38270c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Object f38271d;

        public c(AppWindows r100, Window r101, View r102, Object r103) {
            this.f38268a = r100;
            this.f38269b = r101;
            this.f38270c = r102;
            this.f38271d = r103;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if ((this.f38269b.getCallback() instanceof b) == false) goto L5;
            return;
        L5:
            if (this.f38269b.getCallback() == null) goto L9;
            Window r100 = this.f38269b;
            b r101 = new b(this.f38268a, r100.getCallback(), this.f38269b, this.f38270c);
            this.f38268a.f38258d.put(Integer.valueOf(this.f38271d.hashCode()), new WeakReference(r101));
            Unit r102 = Unit.INSTANCE;
            r100.setCallback(r101);
            return;
        }
    }

    public static final class d implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppWindows f38272a;

        public d(AppWindows r100) {
            this.f38272a = r100;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object r100, Method r101, Object[] r102) {
            if (r102 != null) goto L8;
            Object r103 = this.f38272a.f38256b;
            if (r103 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("windowSession");
        L7:
            Object r104 = r101.invoke(r103, new Object[0]);
        L13:
            if (StringsKt.startsWith$default(r101.getName(), "addToDisplay", false, 2, null) == true) goto L20;
        L18:
            return r104;
        L20:
            AppWindows r105 = this.f38272a;     // Catch: Throwable -> L19
            List<? extends Object> r106 = r105.f38257c;     // Catch: Throwable -> L19
            if (r106 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("viewRoots");     // Catch: Throwable -> L19
        L17:
            r105.c(CollectionsKt.last(r106));     // Catch: Throwable -> L19
            goto L18
        L8:
            Object r107 = this.f38272a.f38256b;
            if (r107 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("windowSession");
        L11:
            r104 = r101.invoke(r107, Arrays.copyOf(r102, r102.length));
            goto L13
        }
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.view.WindowManagerGlobal");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.view.WindowManagerGlobal");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.view.WindowManagerGlobal");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.view.WindowManagerGlobal");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.view.WindowManagerGlobal");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.view.WindowManagerGlobal");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.view.WindowManagerGlobal");
    }

    public final void d() {
        Class<?> r100 = this.f38255a;     // Catch: Throwable -> L14
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("classWindowManagerGlobal");     // Catch: Throwable -> L14
    L6:
        Object r101 = r100.getDeclaredMethod("getWindowSession", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L14
        this.f38256b = r101;     // Catch: Throwable -> L14
        if (r101 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("windowSession");     // Catch: Throwable -> L14
    L9:
        Class<?> r102 = r101.getClass();     // Catch: Throwable -> L14
        Object r103 = Proxy.newProxyInstance(r102.getClassLoader(), r102.getInterfaces(), new d(this));     // Catch: Throwable -> L14
        Class<?> r104 = this.f38255a;     // Catch: Throwable -> L14
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("classWindowManagerGlobal");     // Catch: Throwable -> L14
    L12:
        Field r105 = r104.getDeclaredField("sWindowSession");     // Catch: Throwable -> L14
        r105.setAccessible(true);     // Catch: Throwable -> L14
        r105.set(null, r103);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        th.getMessage();
    }

    public final void e() {
        Class<?> r100 = this.f38255a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("classWindowManagerGlobal");
    L5:
        Method r101 = r100.getDeclaredMethod("getInstance", new Class[0]);
        r101.setAccessible(true);
        Object r102 = r101.invoke(null, new Object[0]);
        Class<?> r103 = this.f38255a;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("classWindowManagerGlobal");
    L8:
        Field r104 = r103.getDeclaredField("mRoots");
        r104.setAccessible(true);
        Object r105 = r104.get(r102);
        if (r105 == null) goto L17;
        List<? extends Object> r106 = (List) r105;
        ArrayList<Object> r107 = new AppWindows$hookViewRootsOfWMG$replacedViewRoots$1(this);     // Catch: Throwable -> L13
        r107.addAll(r106);     // Catch: Throwable -> L13
        r104.set(r102, r107);     // Catch: Throwable -> L13
        this.f38257c = r107;     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        this.f38257c = r106;
        th.getMessage();
        return;
    L17:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
    }

    public AppWindows() {
        this.f38258d = new LinkedHashMap();
        this.f38259e = LazyKt.lazy(AppWindows$xiguaWindowCallbackClazz$2.INSTANCE);
        this.f38260f = new CopyOnWriteArrayList();
    }

    public final void c(Object r100) {
        Field r101 = r100.getClass().getDeclaredField("mView");
        r101.setAccessible(true);
        Object r102 = r101.get(r100);
        Window r103 = null;
        if ((r102 instanceof View) == true) goto L5;
        r102 = null;
    L5:
        View r104 = (View) r102;
        if (r104 != null) goto L8;
        return;
    L8:
        if (StringsKt.contains$default(r104.getClass().getName(), "DecorView", false, 2, null) == true) goto L37;
        return;
    L37:
        Field r105 = r104.getClass().getDeclaredField("mWindow");     // Catch: NoSuchFieldException -> L16
        r105.setAccessible(true);     // Catch: NoSuchFieldException -> L16
        Object r106 = r105.get(r104);     // Catch: NoSuchFieldException -> L16
        if (r106 == null) goto L15;
        Window r107 = (Window) r106;     // Catch: NoSuchFieldException -> L16
    L13:
        r103 = r107;
    L21:
        if (r103 == null) goto L44;
        Window.Callback r108 = r103.getCallback();
        if (r108 == null) goto L26;
        b r109 = new b(this, r108, r103, r104);
        this.f38258d.put(Integer.valueOf(r100.hashCode()), new WeakReference(r109));
        Unit r110 = Unit.INSTANCE;
        r103.setCallback(r109);
    L26:
        if (this.f38261g == false) goto L35;
        Iterator<a> r111 = this.f38260f.iterator();
    L29:
        if (r111.hasNext() == false) goto L35;
        a r112 = r111.next();
        Context r113 = r103.getContext();
        if ((r113 instanceof Activity) == false) goto L33;
        String r114 = ((Activity) r113).getClass().getSimpleName();
    L34:
        r112.b(r103, r104, r114);
        goto L29
    L33:
        r114 = "";
    L35:
        r104.getViewTreeObserver().addOnGlobalLayoutListener(new c(this, r103, r104, r100));
        return;
    L44:
        return;
    L15:
        throw new TypeCastException("null cannot be cast to non-null type android.view.Window");     // Catch: NoSuchFieldException -> L16
    L17:
        if (StringsKt.contains$default(r104.getClass().getName(), "PopupDecorView", false, 2, null) == false) goto L21;
        r107 = new com.bytedance.android.accessibilityLib_Core.helper.d(com.bytedance.android.accessibilityLib_Core.helper.a.a(), (FrameLayout) r104);     // Catch: ClassCastException -> L20
        goto L13
    }

    public final void f(boolean r100) {
        this.f38261g = r100;
        if (r100 == true) goto L5;
        return;
    L5:
        if (this.f38256b != null) goto L28;
        this.f38255a = a();     // Catch: Throwable -> L16
        d();     // Catch: Throwable -> L16
        e();     // Catch: Throwable -> L16
        List<? extends Object> r101 = this.f38257c;     // Catch: Throwable -> L16
        if (r101 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewRoots");     // Catch: Throwable -> L16
    L10:
        Iterator<T> r102 = r101.iterator();     // Catch: Throwable -> L16
    L11:
        if (r102.hasNext() == false) goto L29;
        c(r102.next());     // Catch: Throwable -> L19
        goto L11
    L29:
        return;
    L16:
        th = move-exception;
        th.getMessage();
        return;
    }

    public static final void b(AppWindows r100, Object r101) {
        WeakReference<b> r102 = r100.f38258d.remove(Integer.valueOf(r101.hashCode()));
        if (r100.f38261g == false) goto L15;
        if (r102 == null) goto L19;
        b r103 = r102.get();
        if (r103 == null) goto L20;
        Window r104 = r103.f38265d;
        Iterator<a> r105 = r100.f38260f.iterator();
    L9:
        if (r105.hasNext() == false) goto L21;
        a r106 = r105.next();
        View r107 = r103.f38266e;
        Context r108 = r104.getContext();
        if ((r108 instanceof Activity) == false) goto L13;
        String r109 = ((Activity) r108).getClass().getSimpleName();
    L14:
        r106.c(r107, r109);
        goto L9
    L13:
        r109 = "";
        goto L14
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }
}
