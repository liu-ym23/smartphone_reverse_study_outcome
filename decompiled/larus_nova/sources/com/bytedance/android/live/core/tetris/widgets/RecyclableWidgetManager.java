package com.bytedance.android.live.core.tetris.widgets;

import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.componentx.utils.ObservableLifecycleDelegate;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.livesdk.config.i91;
import com.bytedance.android.livesdk.j1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.ComponentManagerABHelper;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.ies.sdk.widgets.perf.WidgetPerfManager;
import com.bytedance.ies.sdk.widgets.priority.GroupSchedule;
import com.bytedance.livesdk.preview.merge.AbsMergeWidget;
import com.larus.nova.R;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public class RecyclableWidgetManager extends WidgetManager implements com.bytedance.livesdk.preview.merge.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f65946j = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f65947d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e80.b f65948e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public x70.b f65949f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final z f65950g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f65951h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ObservableLifecycleDelegate f65952i;

    public class a implements c {
        public a() {
        }

        @Override // com.bytedance.android.live.core.tetris.widgets.c
        public final <T extends com.bytedance.android.live.core.tetris.widgets.a> T a(Class<T> r100) {
            return r100.newInstance();
        L7:
            e = move-exception;
            throw new RuntimeException(e);
        L4:
            e = move-exception;
            throw new RuntimeException(e);
        }
    }

    static {
        f65946j = new a();
    }

    public final void C60() {
        if ((this.f65947d instanceof h) == true) goto L5;
        return;
    L5:
        Iterator<Widget> r100 = this.widgets.iterator();
    L7:
        if (r100.hasNext() == false) goto L21;
        Widget r101 = r100.next();
        if ((r101 instanceof LiveRecyclableWidget) == false) goto L7;
        LiveRecyclableWidget r102 = (LiveRecyclableWidget) r101;
        if (r102.isRecyclableOnRotation() == true) goto L7;
        h r103 = (h) this.f65947d;
        Class<?> r104 = r102.getClass();
        if (r103.f65990c == false) goto L18;
        WeakReference<com.bytedance.android.live.core.tetris.widgets.a> r105 = r103.f65989b.remove(r104);
        if (r105 == null) goto L17;
        com.bytedance.android.live.core.tetris.widgets.a r106 = r105.get();
    L19:
        if (r106 == null) goto L7;
        r106.clearAfterDestroyed();
        goto L7
    L17:
        r106 = null;
        goto L19
    L18:
        r106 = r103.f65988a.remove(r104);
        goto L19
    }

    @Override // com.bytedance.ies.sdk.widgets.WidgetManager
    public final WidgetManager createSubWidgetManager() {
        RecyclableWidgetManager r100 = ga0(this, this.contentView);
        r100.setDataCenter(this.dataCenter);
        r100.setWidgetConfigHandler(this.widgetConfigHandler);
        r100.ia0(this.f65948e);
        r100.f65947d = h.c();
        r100.f65949f = this.f65949f;
        return r100;
    }

    @Override // androidx.fragment.app.Fragment, androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        if (ComponentManagerABHelper.INSTANCE.enableWidgetManagerLifecycleDelegate() == false) goto L10;
        if (this.f65952i != null) goto L8;
        this.f65952i = new ObservableLifecycleDelegate(super.getLifecycle());
    L8:
        return this.f65952i;
    L10:
        return super.getLifecycle();
    }

    @Override // com.bytedance.ies.sdk.widgets.WidgetManager, androidx.fragment.app.Fragment
    public final void onDestroy() {
        if (this.f65951h == false) goto L5;
    L6:
        Fragment r100 = this.parentFragment;
        if (r100 != null) goto L9;
    L11:
        super.onDestroy();
        return;
    L9:
        if (r100.getFragmentManager() == null) goto L11;
        this.parentFragment.getFragmentManager().unregisterFragmentLifecycleCallbacks(this.parentDestroyedCallback);
        goto L11
    L5:
        if (j1.f142014a.getValue().getOpenFixV1() == false) goto L11;
        goto L6
    }

    public RecyclableWidgetManager() {
        this.f65947d = f65946j;
        this.f65948e = null;
        this.f65949f = null;
        this.f65950g = new z();
        this.f65951h = false;
    }

    public static void V90(Widget r100) {
        if ((r100 instanceof AbsMergeWidget) == false) goto L6;
        ((AbsMergeWidget) r100).setLoadedEnvironment(AbsMergeWidget.MergeWidgetEnvironment.LIVE);
        return;
    }

    @Override // com.bytedance.livesdk.preview.merge.a
    public final void ME(AbsMergeWidget r100) {
        unload(r100);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final <T extends com.bytedance.android.live.core.tetris.widgets.a> T W90(Class<T> r100) {
        DataCenter r101 = this.dataCenter;
        if (r101 == null) goto L12;
        IRoom r102 = (IRoom) r101.get("data_room");
        if (MultiRoomConfig.INSTANCE.enableComponentCache(r102, this.dataCenter) == false) goto L12;
        String r103 = (String) this.dataCenter.get("data_room_unique_id", null);
        if (TextUtils.isEmpty(r103) == true) goto L10;
        com.bytedance.android.live.core.tetris.widgets.cache.c r104 = com.bytedance.android.live.core.tetris.widgets.cache.c.f65963g.a();
        Class<? extends U> r105 = r100.asSubclass(LiveRecyclableWidget.class);
        Intrinsics.checkNotNullParameter(r103, "uniqueID");
        Intrinsics.checkNotNullParameter(r105, "clazz");
        return (T) r104.f65968e.a(r104, r103, r105);
    L10:
        ALogger.i(WidgetManager.TAG, "enableComponentCache = true, uniqueID isEmpty");
    L12:
        return (T) this.f65947d.a(r100);
    }

    @Override // com.bytedance.ies.sdk.widgets.WidgetManager
    public final void continueLoad(Widget r100) {
        super.continueLoad(r100);
        e80.b r101 = this.f65948e;
        if (r101 == null) goto L6;
        r101.h(r100);
        return;
    }

    @Override // com.bytedance.livesdk.preview.merge.a
    public final <T extends com.bytedance.android.live.core.tetris.widgets.a> T eW(Class<T> r100) {
        if (LiveRecyclableWidget.class.isAssignableFrom(r100) == false) goto L7;
        LiveRecyclableWidget r101 = (LiveRecyclableWidget) this.f65947d.a(r100);
        r101.setMergeWidgetManager(this);
        return r101;
    L7:
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L11;
        return null;
    L11:
        throw new RuntimeException("loadMergeWidget  classType error in RecyclableWidgetManager");
    }

    @Override // com.bytedance.livesdk.preview.merge.a
    public final void fW(AbsMergeWidget r100) {
        if (r100 == null) goto L5;
        r100.setMergeWidgetManager(this);
        V90(r100);
        load(r100);
        return;
    }

    public final void ia0(e80.b r100) {
        if (r100 == null) goto L14;
        boolean r101 = false;
        if (g.a() == false) goto L11;
        i91 r102 = g.c();
        if (r102 == null) goto L8;
        boolean r103 = r102.g();
    L9:
        if (r103 == false) goto L11;
        r101 = true;
        goto L11
    L8:
        r103 = false;
    L11:
        if (r101 == false) goto L15;
        this.f65948e = r100;
        return;
    L15:
        return;
    }

    @Override // com.bytedance.ies.sdk.widgets.WidgetManager
    public final void mayInsertHandlerQueue(Runnable r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (k60.b.c() == false) goto L7;
        i0.d(r100);
        return;
    L7:
        i0.i(c50.b.b(this.dataCenter), r100);
    }

    @Override // com.bytedance.ies.sdk.widgets.WidgetManager
    public final void mayInsertHighPriorityHandlerQueue(Runnable r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (k60.b.c() == false) goto L7;
        i0.f(r100);
        return;
    L7:
        i0.i(c50.b.b(this.dataCenter), r100);
    }

    @Override // com.bytedance.ies.sdk.widgets.WidgetManager, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        C60();
    }

    @Override // com.bytedance.ies.sdk.widgets.WidgetManager
    public final void onLoadByAsync(Widget r100) {
        if ((r100 instanceof LiveRecyclableWidget) == false) goto L5;
        ((LiveRecyclableWidget) r100).setIsAsyncLoading(Boolean.TRUE);
    L5:
        z r101 = this.f65950g;
        if (r101.f66045b != null) goto L9;
        r101.f66044a.add(r100);
        return;
    }

    @Override // com.bytedance.ies.sdk.widgets.WidgetManager
    public final void onLoadSuccessByAsync(Widget r100) {
        if ((r100 instanceof LiveRecyclableWidget) == false) goto L5;
        ((LiveRecyclableWidget) r100).setIsAsyncLoading(Boolean.FALSE);
    L5:
        z r101 = this.f65950g;
        r101.f66044a.remove(r100);
        if (r101.f66044a.isEmpty() == false) goto L11;
        Runnable r102 = r101.f66045b;
        if (r102 == null) goto L12;
        r102.run();
        r101.f66045b = null;
        return;
    L12:
        return;
    }

    public static RecyclableWidgetManager ga0(Fragment r100, View r101) {
        RecyclableWidgetManager r102 = new RecyclableWidgetManager();
        r102.config(null, r100, r101, r100.getContext(), k60.b.e());
        return r102;
    }

    public static RecyclableWidgetManager ha0(FragmentActivity r100, View r101) {
        RecyclableWidgetManager r102 = new RecyclableWidgetManager();
        r102.config(r100, null, r101, r100, k60.b.e());
        return r102;
    }

    public final <T extends LiveRecyclableWidget> T X90(int r100, Class<T> r101) {
        return (T) Y90(r100, r101, true, null);
    }

    public final void ca0(int r100, Class r101) {
        Y90(r100, r101, false, null);
    }

    public final LiveRecyclableWidget aa0(Class r100, boolean r101, boolean r102) {
        ViewGroup r103 = (ViewGroup) this.contentView.findViewById(R.id.broadcast_pause_page_container);
        LiveRecyclableWidget r104 = (LiveRecyclableWidget) W90(r100);
        fa0(r103, r104, r101, null);
        return r104;
    }

    @Override // com.bytedance.ies.sdk.widgets.WidgetManager
    public void continueLoad(Widget r100, ViewGroup r101, View r102) {
        if (r100.containerView != null) goto L8;
        e80.b r103 = this.f65948e;
        if (r103 == null) goto L22;
        r103.h(r100);
        return;
    L22:
        return;
    L8:
        if (r102 == null) goto L20;
        UIUtils.detachFromParent(r102);
    L20:
        super.continueLoad(r100, r101, r102);     // Catch: IllegalStateException -> L14
        e80.b r104 = this.f65948e;     // Catch: IllegalStateException -> L14
        if (r104 == null) goto L23;
        r104.h(r100);     // Catch: IllegalStateException -> L14
        return;
    L23:
        return;
    L14:
        e = move-exception;
        StringBuilder r105 = new StringBuilder("contentView: ");
        r105.append(r102);
        r105.append('\n');
        if (r102 == null) goto L18;
        r105.append("real parent: ");
        r105.append(r102.getParent());
        r105.append('\n');
    L18:
        r105.append("target parent: ");
        r105.append(r101);
        r105.append("\nwidget: ");
        r105.append(r100.getClass().getName());
        throw new IllegalStateException(r105.toString(), e);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final <T extends LiveRecyclableWidget> T ea0(Class<T> r100, boolean r101, boolean r102) {
        T r103 = (T) W90(r100);
        ALogger.i("【widget】", "load widget:" + r103.getClass().getCanonicalName() + "@" + r103.hashCode() + ", async: " + r101);
        r103.setWidgetCallback(this.widgetCallback);
        r103.context = this.context;
        r103.dataCenter = this.dataCenter;
        r103.setStatusAsync(r101);
        r103.setStatusRecycle(true);
        r103.setStatusHasUI(false);
        WidgetPerfManager.getInstance().onPerfStart(r103, WidgetCostModule.TYPE_ON_LOAD);
        WidgetManager.IWidgetConfigHandler r104 = this.widgetConfigHandler;
        if (r104 == null) goto L5;
        r104.onLoad(r103);
    L5:
        GroupSchedule.getInstance().enqueueLoad(r103, new l(this, r103, r101, r102));
        return r103;
    }

    @Override // com.bytedance.ies.sdk.widgets.WidgetManager
    public final WidgetManager load(ViewGroup r100, Widget r101, boolean r102) {
        if ((r101 instanceof LiveRecyclableWidget) == false) goto L5;
        fa0(r100, (LiveRecyclableWidget) r101, r102, null);
    L9:
        return this;
    L5:
        e80.b r103 = this.f65948e;
        if (r103 == null) goto L8;
        r103.d(r101);
    L8:
        V90(r101);
        super.load(r100, r101, r102);
        goto L9
    }

    @Override // com.bytedance.ies.sdk.widgets.WidgetManager
    public final WidgetManager load(int r100, Widget r101, boolean r102) {
        return load((ViewGroup) this.contentView.findViewById(r100), r101, r102);
    }

    public static void U90(RecyclableWidgetManager r100, LiveRecyclableWidget r101, ViewGroup r102, View r103) {
        r100.getClass();
        WidgetPerfManager.getInstance().onPerfEnd(r101, WidgetCostModule.TYPE_INFLATE);
        r100.onLoadSuccessByAsync(r101);
        if (r100.isRemoving() == false) goto L5;
        return;
    L5:
        if (r100.isDetached() == false) goto L7;
        return;
    L7:
        if (r100.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L9;
        return;
    L9:
        if (r101.widgetCallback == r100.widgetCallback) goto L11;
        ALogger.i("RecyclableWidgetManager", "abort load, opt: true");
        return;
    L11:
        if (r100.isAdded() == false) goto L13;
        r100.continueLoad(r101, r102, r103);
        return;
    L13:
        ALogger.i("RecyclableWidgetManager", "fragment is not add, so intercept");
    }

    public final <T extends LiveRecyclableWidget> T Y90(int r100, Class<T> r101, boolean r102, Object[] r103) {
        return (T) Z90((ViewGroup) this.contentView.findViewById(r100), r101, r102, r103);
    }

    public final <T extends LiveRecyclableWidget> T Z90(ViewGroup r100, Class<T> r101, boolean r102, Object[] r103) {
        DataCenter r104 = this.dataCenter;
        if (r104 == null) goto L7;
        IRoom r105 = (IRoom) r104.get("data_room");
        if (MultiRoomConfig.INSTANCE.enableComponentCache(r105, this.dataCenter) == false) goto L7;
        T r106 = (T) W90(r101);
        fa0(r100, r106, r102, r103);
        return r106;
    L7:
        T r107 = (T) this.f65947d.a(r101);
        fa0(r100, r107, r102, r103);
        return r107;
    }

    public final void ba0(int r100, Widget r101, boolean r102, boolean r103) {
        da0((ViewGroup) this.contentView.findViewById(r100), r101, r102, r103);
    }

    public final void da0(ViewGroup r100, Widget r101, boolean r102, boolean r103) {
        if ((r101 instanceof LiveRecyclableWidget) == false) goto L5;
        fa0(r100, (LiveRecyclableWidget) r101, r102, null);
        return;
    L5:
        e80.b r104 = this.f65948e;
        if (r104 == null) goto L8;
        r104.d(r101);
    L8:
        V90(r101);
        super.load(r100, r101, r102);
    }

    public final void fa0(ViewGroup r100, LiveRecyclableWidget r101, boolean r102, Object[] r103) {
        System.nanoTime();
        r101.getClass();
        ALogger.i("【widget】", "load widget:" + r101.getClass().getCanonicalName() + "@" + r101.hashCode() + ", async: " + r102);
        r101.setArgs(r103);
        r101.setWidgetCallback(this.widgetCallback);
        r101.context = this.context;
        r101.dataCenter = this.dataCenter;
        r101.containerView = r100;
        boolean r104 = false;
        r101.setMergeMode(false);
        r101.setStatusAsync(r102);
        r101.setStatusRecycle(true);
        if (r101.getLayoutId() == 0) goto L5;
        r104 = true;
    L5:
        r101.setStatusHasUI(r104);
        V90(r101);
        WidgetPerfManager.getInstance().onPerfStart(r101, WidgetCostModule.TYPE_ON_LOAD);
        WidgetManager.IWidgetConfigHandler r105 = this.widgetConfigHandler;
        if (r105 == null) goto L8;
        r105.onLoad(r101);
    L8:
        this.widgetViewGroupHashMap.put(r101, r100);
        GroupSchedule.getInstance().enqueueLoad(r101, new p(this, r100, r101, r102));
    }

    @Override // com.bytedance.livesdk.preview.merge.a
    public final void li(ViewGroup r100, AbsMergeWidget r101, boolean r102, boolean r103) {
        if (r101 == null) goto L5;
        r101.setMergeWidgetManager(this);
    L5:
        if ((r101 instanceof LiveRecyclableWidget) == false) goto L7;
        fa0(r100, (LiveRecyclableWidget) r101, r102, null);
        return;
    L7:
        e80.b r104 = this.f65948e;
        if (r104 == null) goto L10;
        r104.d(r101);
    L10:
        V90(r101);
        super.load(r100, r101, r102);
    }

    @Override // com.bytedance.livesdk.preview.merge.a
    public final AbsMergeWidget Gq(ViewGroup r100, LiveRecyclableWidget r101, boolean r102, boolean r103, Object[] r104) {
        fa0(r100, r101, r102, r104);
        return r101;
    }
}
