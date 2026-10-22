package com.bytedance.android.live.core.tetris.widgets;

import android.animation.Animator;
import android.content.Context;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.CommonLifecycleTransformer;
import com.bytedance.android.live.core.utils.rxutils.IoToUiTransformer;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AndroidLifecycleScopeProvider;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDisposeConverter;
import com.bytedance.android.livesdk.config.aw;
import com.bytedance.android.livesdk.config.i91;
import com.bytedance.android.livesdk.j1;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.livesdk.preview.merge.AbsMergeWidget;
import com.bytedance.livesdk.preview.merge.PreviewViewHolderStatus;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@LiveWidgetRecord
public abstract class LiveWidget extends AbsMergeWidget implements tw2.b, z70.a {
    private static final String TAG = "LiveWidget";
    private CompositeDisposable compositeDisposable;
    private Map<String, String> extraInfo;
    protected boolean isAppBackground;
    private CommonLifecycleTransformer lifecycleTransformer;
    private PreviewState previewStatus;
    private Animator showAnimator;
    private IoToUiTransformer transformer;
    protected f widgetLifeCycleObserver;

    public static final enum PreviewState extends Enum<PreviewState> {
        public static final PreviewState CREATED = null;
        public static final PreviewState DESTORYED = null;
        public static final PreviewState LOADED = null;
        public static final PreviewState PAUSEED = null;
        public static final PreviewState RESUMED = null;
        public static final PreviewState STARTED = null;
        public static final PreviewState STOPED = null;
        public static final PreviewState UNLOAD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PreviewState[] f65943a = null;

        static {
            PreviewState r100 = new PreviewState("LOADED", 0);
            LOADED = r100;
            PreviewState r101 = new PreviewState("CREATED", 1);
            CREATED = r101;
            PreviewState r102 = new PreviewState("STARTED", 2);
            STARTED = r102;
            PreviewState r103 = new PreviewState("RESUMED", 3);
            RESUMED = r103;
            PreviewState r104 = new PreviewState("PAUSEED", 4);
            PAUSEED = r104;
            PreviewState r105 = new PreviewState("STOPED", 5);
            STOPED = r105;
            PreviewState r110 = new PreviewState("DESTORYED", 6);
            DESTORYED = r110;
            PreviewState r111 = new PreviewState("UNLOAD", 7);
            UNLOAD = r111;
            f65943a = new PreviewState[]{r100, r101, r102, r103, r104, r105, r110, r111};
        }

        public static PreviewState[] values() {
            return (PreviewState[]) f65943a.clone();
        }

        public static PreviewState valueOf(String r100) {
            return (PreviewState) r27.a.a(PreviewState.class, r100);
        }

        public PreviewState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public class a implements Consumer<y> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveWidget f65944a;

        public a(LiveWidget r100) {
            this.f65944a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(y r100) throws Exception {
            y r101 = r100;
            int r102 = r101.f66043b;     // Catch: Exception -> L11
            if (r102 != 16) goto L7;
            LiveWidget r103 = this.f65944a;     // Catch: Exception -> L11
            r103.isAppBackground = r101.f66042a;     // Catch: Exception -> L11
        L7:
            if (r101.f66042a == false) goto L9;
            this.f65944a.onEnterClear(r102);     // Catch: Exception -> L11
            return;
        L9:
            this.f65944a.onExitClear(r102);     // Catch: Exception -> L11
            return;
        L11:
            e = move-exception;
            e.printStackTrace();
        }
    }

    public class b implements Predicate<y> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveWidget f65945a;

        public b(LiveWidget r100) {
            this.f65945a = r100;
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(y r100) throws Exception {
            y r101 = r100;
            if ((r101.f66043b & this.f65945a.supportClearScene()) != r101.f66043b) goto L5;
            return true;
        L5:
            return false;
        }
    }

    @Override // tw2.a
    public Map<String, Object> getEnvData() {
        return null;
    }

    public String getSpm() {
        return "";
    }

    @Override // tw2.b
    public boolean isIgnored() {
        return false;
    }

    @Override // com.bytedance.livesdk.preview.merge.AbsMergeWidget
    public boolean isInnerPreviewNeedUnbind() {
        return false;
    }

    @Override // com.bytedance.livesdk.preview.merge.AbsMergeWidget
    public boolean isPreviewWidget() {
        return false;
    }

    public void onMergeHolderSelect() {
    }

    public void onMergeHolderUnSelect() {
    }

    public Animator startShowAnimation() {
        return null;
    }

    public int supportClearScene() {
        return 0;
    }

    private void doMergePause() {
        PreviewState r100 = this.previewStatus;
        if (r100 != PreviewState.RESUMED) goto L6;
        onPause();
        onStop();
        return;
    L6:
        if (r100 != PreviewState.STARTED) goto L8;
    L9:
        onStop();
        return;
    L8:
        if (r100 == PreviewState.PAUSEED) goto L9;
    }

    private void doMergeResume() {
        PreviewState r100 = this.previewStatus;
        if (r100 != PreviewState.CREATED) goto L5;
    L12:
        onStart();
        onResume();
        return;
    L5:
        if (r100 == PreviewState.STOPED) goto L12;
        if (r100 != PreviewState.STARTED) goto L10;
    L11:
        onResume();
        return;
    L10:
        if (r100 == PreviewState.PAUSEED) goto L11;
    }

    public final <T> AutoDisposeConverter<T> activityAutoDispose() {
        return AutoDispose.bind((LifecycleOwner) this.context);
    }

    public final <T> AutoDisposeConverter<T> activityAutoDisposeWithTransformer() {
        if (this.transformer != null) goto L6;
        this.transformer = new IoToUiTransformer();
    L6:
        return AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from((LifecycleOwner) this.context, Lifecycle.Event.ON_DESTROY), this.transformer);
    }

    public final <T> AutoDisposeConverter<T> autoDisposeWithTransformer() {
        if (this.transformer != null) goto L6;
        this.transformer = new IoToUiTransformer();
    L6:
        return AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(this, Lifecycle.Event.ON_DESTROY), this.transformer);
    }

    @Override // tw2.b
    public Map<String, Object> getPropertyParams() {
        HashMap r100 = new HashMap();
        r100.put("uni_key", Integer.valueOf(hashCode()));
        return r100;
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public void onCreate() {
        CompositeDisposable r100 = this.compositeDisposable;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        CompositeDisposable r101 = new CompositeDisposable();
        this.compositeDisposable = r101;
        this.lifecycleTransformer = new CommonLifecycleTransformer(r101);
        super.onCreate();     // Catch: Exception -> L8
    L10:
        this.showAnimator = startShowAnimation();
        registerClearScreen();
        int r102 = f.f65983c;
        boolean r103 = false;
        if (g.a() == false) goto L18;
        i91 r104 = g.c();
        if (r104 == null) goto L15;
        boolean r105 = r104.f();
    L16:
        if (r105 == false) goto L18;
        r103 = true;
        goto L18
    L15:
        r105 = false;
    L18:
        List<? extends e80.a> r106 = null;
        if (r103 == false) goto L21;
        f r107 = new f(this);
    L22:
        this.widgetLifeCycleObserver = r107;
        if (r107 == null) goto L35;
        Widget r108 = r107.f65985b;
        if (r108 == null) goto L29;
        DataCenter r109 = r108.dataCenter;
        if (r109 == null) goto L29;
        r106 = (List) r109.get("data_live_widget_lifecycle_observers", null);
    L29:
        r107.f65984a = r106;
        if (r106 == null) goto L35;
        Iterator<T> r110 = r106.iterator();
    L33:
        if (r110.hasNext() == false) goto L35;
        ((e80.a) r110.next()).l(r107.f65985b);
    L35:
        this.previewStatus = PreviewState.CREATED;
        return;
    L21:
        r107 = null;
    L8:
        e = move-exception;
        ALogger.e(TAG, e);
        goto L10
    }

    public void releaseSubWidgetManager() {
        if (this.subWidgetManager == null) goto L11;
        Widget.WidgetCallback r100 = this.widgetCallback;
        if (r100 == null) goto L11;
        if (r100.getWidgetManager() == null) goto L11;
        if (this.widgetCallback.getWidgetManager().getHost() == null) goto L11;
        this.widgetCallback.getWidgetManager().getChildFragmentManager().beginTransaction().remove(this.subWidgetManager).commitNowAllowingStateLoss();
    L11:
        this.subWidgetManager = null;
    }

    public LiveWidget() {
        this.isAppBackground = false;
        this.previewStatus = PreviewState.UNLOAD;
        this.extraInfo = null;
    }

    private void registerClearScreen() {
        if (supportClearScene() == 0) goto L14;
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L7;
        boolean r101 = ((Boolean) r100.get("enable_rxjava_async", Boolean.FALSE)).booleanValue();
    L8:
        Observable r102 = xs2.b.a().b(y.class).filter(new b(this));
        if (r101 == false) goto L11;
        Scheduler r103 = Schedulers.io();
    L12:
        Disposable r104 = r102.subscribeOn(r103).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
        this.compositeDisposable.add(r104);
        return;
    L11:
        r103 = AndroidSchedulers.mainThread();
        goto L12
    L7:
        r101 = false;
        goto L8
    }

    public final <T> AutoDisposeConverter<T> autoDispose() {
        return AutoDispose.bind(this);
    }

    @Override // com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public void onDestroy() {
        super.onDestroy();     // Catch: Exception -> L4
    L6:
        CompositeDisposable r100 = this.compositeDisposable;
        if (r100 == null) goto L10;
        r100.dispose();
    L10:
        if (getLoadedEnvironment() == AbsMergeWidget.MergeWidgetEnvironment.PREVIEW) goto L12;
        this.subWidgetManager = null;
        this.extraInfo = null;
    L12:
        Animator r101 = this.showAnimator;
        if (r101 != null) goto L15;
    L18:
        f r102 = this.widgetLifeCycleObserver;
        if (r102 == null) goto L26;
        List<? extends e80.a> r103 = r102.f65984a;
        if (r103 == null) goto L26;
        Iterator<T> r104 = r103.iterator();
    L24:
        if (r104.hasNext() == false) goto L26;
        ((e80.a) r104.next()).onDestroy(r102.f65985b);
    L26:
        this.widgetLifeCycleObserver = null;
        this.previewStatus = PreviewState.DESTORYED;
        if (getLoadedEnvironment() != AbsMergeWidget.MergeWidgetEnvironment.PREVIEW) goto L29;
        return;
    L29:
        if (j1.f142014a.getValue().getFixWidgetCallback() == false) goto L36;
        setWidgetCallback(x.f66041a);
        return;
    L36:
        return;
    L15:
        if (r101.isRunning() == false) goto L17;
        this.showAnimator.cancel();
    L17:
        this.showAnimator.removeAllListeners();
        this.showAnimator = null;
    L4:
        e = move-exception;
        ALogger.e(TAG, e);
        goto L6
    }

    @Override // com.bytedance.livesdk.preview.merge.AbsMergeWidget
    public void onMergeLoad() {
        super.onMergeLoad();
        this.previewStatus = PreviewState.LOADED;
    }

    @Override // com.bytedance.livesdk.preview.merge.AbsMergeWidget
    public void onMergeUnLoad() {
        super.onMergeUnLoad();
        this.previewStatus = PreviewState.UNLOAD;
        if (getLoadedEnvironment() != AbsMergeWidget.MergeWidgetEnvironment.PREVIEW) goto L8;
        this.subWidgetManager = null;
        this.extraInfo = null;
        if (j1.f142014a.getValue().getFixWidgetCallback() == false) goto L9;
        setWidgetCallback(x.f66041a);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public void onPause() {
        super.onPause();     // Catch: Exception -> L4
    L6:
        f r100 = this.widgetLifeCycleObserver;
        if (r100 == null) goto L14;
        List<? extends e80.a> r101 = r100.f65984a;
        if (r101 == null) goto L14;
        Iterator<T> r102 = r101.iterator();
    L12:
        if (r102.hasNext() == false) goto L14;
        ((e80.a) r102.next()).i(r100.f65985b);
    L14:
        this.previewStatus = PreviewState.PAUSEED;
        return;
    L4:
        e = move-exception;
        ALogger.e(TAG, e);
        goto L6
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public void onResume() {
        super.onResume();     // Catch: Exception -> L4
    L6:
        super.onResume();
        f r100 = this.widgetLifeCycleObserver;
        if (r100 == null) goto L20;
        List<? extends e80.a> r101 = r100.f65984a;
        if (r101 == null) goto L14;
        Iterator<T> r102 = r101.iterator();
    L12:
        if (r102.hasNext() == false) goto L14;
        ((e80.a) r102.next()).b(r100.f65985b);
    L14:
        Widget r103 = r100.f65985b;
        if (r103 == null) goto L17;
        DataCenter r104 = r103.dataCenter;
    L18:
        if (r104 != null) goto L20;
        f.a("onResume");
        goto L20
    L17:
        r104 = null;
    L20:
        this.previewStatus = PreviewState.RESUMED;
        return;
    L4:
        e = move-exception;
        ALogger.e(TAG, e);
        goto L6
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public void onStart() {
        super.onStart();     // Catch: Exception -> L4
    L6:
        f r100 = this.widgetLifeCycleObserver;
        if (r100 == null) goto L14;
        List<? extends e80.a> r101 = r100.f65984a;
        if (r101 == null) goto L14;
        Iterator<T> r102 = r101.iterator();
    L12:
        if (r102.hasNext() == false) goto L14;
        ((e80.a) r102.next()).e(r100.f65985b);
    L14:
        this.previewStatus = PreviewState.STARTED;
        return;
    L4:
        e = move-exception;
        ALogger.e(TAG, e);
        goto L6
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public void onStop() {
        super.onStop();     // Catch: Exception -> L4
    L6:
        f r100 = this.widgetLifeCycleObserver;
        if (r100 == null) goto L14;
        List<? extends e80.a> r101 = r100.f65984a;
        if (r101 == null) goto L14;
        Iterator<T> r102 = r101.iterator();
    L12:
        if (r102.hasNext() == false) goto L14;
        ((e80.a) r102.next()).c(r100.f65985b);
    L14:
        this.previewStatus = PreviewState.STOPED;
        return;
    L4:
        e = move-exception;
        ALogger.e(TAG, e);
        goto L6
    }

    public final <T> CommonLifecycleTransformer<T> getAutoUnbindTransformer() {
        return this.lifecycleTransformer;
    }

    public Context getContext() {
        return this.context;
    }

    public DataCenter getDataCenter() {
        return this.dataCenter;
    }

    public Map<String, String> getExtraInfo() {
        return this.extraInfo;
    }

    public final <T extends View> T findViewById(int r100) {
        return (T) this.contentView.findViewById(r100);
    }

    @Override // com.bytedance.livesdk.preview.merge.AbsMergeWidget
    public void handleLifeEvent(com.bytedance.livesdk.preview.event.b r100) {
        ALogger.i(TAG, "event: " + r100 + " previewStatus = " + this.previewStatus.name());
        PreviewState r101 = this.previewStatus;
        if (r101 != PreviewState.UNLOAD) goto L6;
        return;
    L6:
        if ((r100 instanceof com.bytedance.livesdk.preview.event.b.g) == false) goto L11;
        if (r101 == PreviewState.LOADED) goto L11;
        onDestroy();
    L11:
        if (this.mergeContext.getViewHolderStatus() != PreviewViewHolderStatus.UN_BIND) goto L14;
        return;
    L14:
        if ((r100 instanceof com.bytedance.livesdk.preview.event.b.a) == false) goto L17;
        onCreate();
        return;
    L17:
        if ((r100 instanceof com.bytedance.livesdk.preview.event.b.f) == false) goto L20;
        onMergeHolderSelect();
        doMergeResume();
        return;
    L20:
        if ((r100 instanceof com.bytedance.livesdk.preview.event.b.e) == false) goto L23;
        doMergeResume();
        return;
    L23:
        if ((r100 instanceof com.bytedance.livesdk.preview.event.b.c) == false) goto L29;
        doMergePause();
        return;
    }

    public void onEnterClear(int r100) {
        f r101 = this.widgetLifeCycleObserver;
        if (r101 == null) goto L19;
        List<? extends e80.a> r102 = r101.f65984a;
        if (r102 == null) goto L17;
        Iterator<T> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L17;
        ((e80.a) r103.next()).k(r101.f65985b);
    L17:
    L14:
        e = move-exception;
        ALogger.e("IClearScreen", "onEnterClear:" + e);
        return;
    L11:
        if (this.widgetLifeCycleObserver.f65985b == null) goto L20;
        ALogger.i("IClearScreen", this.widgetLifeCycleObserver.f65985b.getWidgetTag() + "_onEnterClear_" + r100);     // Catch: NullPointerException -> L14
        return;
    L20:
        return;
    }

    public void onExitClear(int r100) {
        f r101 = this.widgetLifeCycleObserver;
        if (r101 == null) goto L19;
        List<? extends e80.a> r102 = r101.f65984a;
        if (r102 == null) goto L17;
        Iterator<T> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L17;
        ((e80.a) r103.next()).f(r101.f65985b);
    L17:
    L14:
        e = move-exception;
        ALogger.e("IClearScreen", "onExitClear:" + e);
        return;
    L11:
        if (this.widgetLifeCycleObserver.f65985b == null) goto L20;
        ALogger.i("IClearScreen", this.widgetLifeCycleObserver.f65985b.getWidgetTag() + "_onExitClear_" + r100);     // Catch: NullPointerException -> L14
        return;
    L20:
        return;
    }

    @Override // z70.a
    public void setExtraInfo(Map<String, String> r100) {
        Map<String, String> r101 = this.extraInfo;
        if (r101 != null) goto L5;
        this.extraInfo = r100;
    L6:
        HashMap<String, String> r102 = j70.p.f497562a;
        Map<String, String> r103 = this.extraInfo;
        Intrinsics.checkNotNullParameter(this, "widget");
        if (aw.f119823a.getValue().getRecord_widget() == false) goto L14;
        if (r103 == null) goto L10;
        String r104 = r103.get("widget_level");
    L11:
        if (r104 == null) goto L15;
        String r105 = getClass().getSimpleName();
        String r106 = j70.p.f497562a.put(r105, r104);
        return;
    L15:
        return;
    L10:
        r104 = null;
        goto L11
    L14:
        return;
    L5:
        r101.putAll(r100);
        goto L6
    }
}
