package androidx.lifecycle;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bBO\b\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00120\b\u0002\u0010\u0004\u001a*\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005j\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007`\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rB\u0013\b\u0016\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\u000eJ&\u0010\u000f\u001a\u0002H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0013H\u0097\u0002¢\u0006\u0002\u0010\u0014J.\u0010\u000f\u001a\u0002H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0013H\u0096\u0002¢\u0006\u0002\u0010\u0016J-\u0010\u000f\u001a\u0002H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u00112\u0006\u0010\u0017\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0013H\u0007¢\u0006\u0002\u0010\u0018J5\u0010\u000f\u001a\u0002H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u00112\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0013H\u0007¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R6\u0010\u0004\u001a*\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005j\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007`\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/lifecycle/SharedViewModelProviderCp;", "Landroidx/lifecycle/ViewModelProvider;", ComplianceConstants.ComplianceRequest.MARKET_STORE, "Landroidx/lifecycle/ViewModelStore;", "map", "Ljava/util/HashMap;", "", "", "Landroidx/lifecycle/Lifecycle;", "Lkotlin/collections/HashMap;", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "<init>", "(Landroidx/lifecycle/ViewModelStore;Ljava/util/HashMap;Landroidx/lifecycle/ViewModelProvider$Factory;)V", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", MonitorConstants.CONNECT_TYPE_GET, ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "key", "(Ljava/lang/String;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", NewBroadcastMonitor.STAGE.LIFECYCLE, "(Landroidx/lifecycle/Lifecycle;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "(Landroidx/lifecycle/Lifecycle;Ljava/lang/String;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Companion", "ClearUselessViewModelObserver", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SharedViewModelProviderCp extends ViewModelProvider {
    public static final Companion Companion = null;
    private static final String DEFAULT_KEY = "androidx.lifecycle.ViewModelProvider.DefaultKey";
    private static final String UNSUPPORT_MESSAGE = "Unsupport get viewmodel without lifecycle, please use method get(Lifecycle,Class) or get(Lifecycle,String,Class) instead";
    private static final HashMap<String, Set<Lifecycle>> globalMap = null;
    private static final ViewModelStore globalStore = null;
    private static boolean optimiseLifecycle;
    private HashMap<String, Set<Lifecycle>> map;
    private ViewModelStore store;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012.\u0010\b\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\n0\tj\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\n`\u000b¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\b\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\n0\tj\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/lifecycle/SharedViewModelProviderCp$ClearUselessViewModelObserver;", "Landroidx/lifecycle/LifecycleEventObserver;", NewBroadcastMonitor.STAGE.LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "key", "", ComplianceConstants.ComplianceRequest.MARKET_STORE, "Landroidx/lifecycle/ViewModelStore;", "map", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "<init>", "(Landroidx/lifecycle/Lifecycle;Ljava/lang/String;Landroidx/lifecycle/ViewModelStore;Ljava/util/HashMap;)V", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ClearUselessViewModelObserver implements LifecycleEventObserver {
        private final String key;
        private final Lifecycle lifecycle;
        private final HashMap<String, Set<Lifecycle>> map;
        private final ViewModelStore store;

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
            Intrinsics.checkNotNullParameter(r100, "source");
            Intrinsics.checkNotNullParameter(r101, "event");
            if (r101 != Lifecycle.Event.ON_DESTROY) goto L11;
            Set<Lifecycle> r102 = this.map.get(this.key);
            if (r102 != null) goto L7;
            r102 = new LinkedHashSet();
        L7:
            Set<Lifecycle> r103 = r102;
            r103.remove(this.lifecycle);
            if (r103.isEmpty() == false) goto L12;
            this.store.put(this.key, FakeViewModelCp.INSTANCE);
            this.map.remove(this.key);
            return;
        L12:
            return;
        }

        public ClearUselessViewModelObserver(Lifecycle r100, String r101, ViewModelStore r102, HashMap<String, Set<Lifecycle>> r103) {
            Intrinsics.checkNotNullParameter(r100, NewBroadcastMonitor.STAGE.LIFECYCLE);
            Intrinsics.checkNotNullParameter(r101, "key");
            Intrinsics.checkNotNullParameter(r102, ComplianceConstants.ComplianceRequest.MARKET_STORE);
            Intrinsics.checkNotNullParameter(r103, "map");
            this.lifecycle = r100;
            this.key = r101;
            this.store = r102;
            this.map = r103;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\u0006\u001a*\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0007j\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/lifecycle/SharedViewModelProviderCp$Companion;", "", "<init>", "()V", "globalStore", "Landroidx/lifecycle/ViewModelStore;", "globalMap", "Ljava/util/HashMap;", "", "", "Landroidx/lifecycle/Lifecycle;", "Lkotlin/collections/HashMap;", "DEFAULT_KEY", "UNSUPPORT_MESSAGE", "optimiseLifecycle", "", "getOptimiseLifecycle", "()Z", "setOptimiseLifecycle", "(Z)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final boolean getOptimiseLifecycle() {
            return SharedViewModelProviderCp.access$getOptimiseLifecycle$cp();
        }

        public final void setOptimiseLifecycle(boolean r100) {
            SharedViewModelProviderCp.access$setOptimiseLifecycle$cp(r100);
        }
    }

    static {
        Companion = new Companion(null);
        globalStore = new ViewModelStore();
        globalMap = new HashMap();
    }

    public static final /* synthetic */ boolean access$getOptimiseLifecycle$cp() {
        return optimiseLifecycle;
    }

    public SharedViewModelProviderCp(ViewModelProvider.Factory r100) {
        Intrinsics.checkNotNullParameter(r100, "factory");
        ViewModelStore r101 = globalStore;
        super(r101, r100, null, 4, null);
        this.store = r101;
        this.map = globalMap;
    }

    public static final /* synthetic */ void access$setOptimiseLifecycle$cp(boolean r100) {
        optimiseLifecycle = r100;
    }

    @Override // androidx.lifecycle.ViewModelProvider
    @Deprecated(message = UNSUPPORT_MESSAGE)
    public <T extends ViewModel> T get(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "modelClass");
        throw new IllegalAccessException(UNSUPPORT_MESSAGE);
    }

    public final <T extends ViewModel> T get(Lifecycle r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, NewBroadcastMonitor.STAGE.LIFECYCLE);
        Intrinsics.checkNotNullParameter(r101, "modelClass");
        String r102 = r101.getCanonicalName();
        if (r102 == null) goto L7;
        return (T) get(r100, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(r102), r101);
    L7:
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.ViewModelProvider
    public <T extends ViewModel> T get(String r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "modelClass");
        throw new IllegalAccessException(UNSUPPORT_MESSAGE);
    }

    public SharedViewModelProviderCp(ViewModelStore r100, HashMap<String, Set<Lifecycle>> r101, ViewModelProvider.Factory r110) {
        Intrinsics.checkNotNullParameter(r100, ComplianceConstants.ComplianceRequest.MARKET_STORE);
        Intrinsics.checkNotNullParameter(r101, "map");
        Intrinsics.checkNotNullParameter(r110, "factory");
        super(r100, r110, null, 4, null);
        this.store = r100;
        this.map = r101;
    }

    public final <T extends ViewModel> T get(Lifecycle r100, String r101, Class<T> r102) {
        Intrinsics.checkNotNullParameter(r100, NewBroadcastMonitor.STAGE.LIFECYCLE);
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "modelClass");
        if (r100.getCurrentState() == Lifecycle.State.DESTROYED) goto L5;
    L11:
        T r103 = (T) super.get(r101, r102);
        Set<Lifecycle> r104 = this.map.get(r101);
        if (r104 != null) goto L14;
        r104 = new LinkedHashSet();
    L14:
        Set<Lifecycle> r105 = r104;
        this.map.put(r101, r105);
        if (r105.contains(r100) == true) goto L17;
        r105.add(r100);
        r100.addObserver(new ClearUselessViewModelObserver(r100, r101, this.store, this.map));
    L17:
        return r103;
    L5:
        if (optimiseLifecycle == false) goto L11;
        T r106 = r102.newInstance();     // Catch: IllegalAccessException -> L8 InstantiationException -> L9
        Intrinsics.checkNotNull(r106);     // Catch: IllegalAccessException -> L8 InstantiationException -> L9
    L21:
        return r106;
    L20:
        return (T) super.get(r101, r102);
    L10:
        return (T) super.get(r101, r102);
    }

    public /* synthetic */ SharedViewModelProviderCp(ViewModelProvider.Factory r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = new ViewModelProvider.NewInstanceFactory();
    L5:
        this(r100);
    }

    public /* synthetic */ SharedViewModelProviderCp(ViewModelStore r100, HashMap r101, ViewModelProvider.Factory r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = globalStore;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = globalMap;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = new ViewModelProvider.NewInstanceFactory();
    L11:
        this(r100, r101, r102);
    }
}
