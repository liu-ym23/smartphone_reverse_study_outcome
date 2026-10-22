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

/* JADX INFO: loaded from: classes17.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0002\u0019\u001aBM\b\u0010\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00120\b\u0002\u0010\u0004\u001a*\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005j\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007`\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fB\u0011\b\u0016\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\rJ/\u0010\u000e\u001a\u0002H\u000f\"\n\b\u0000\u0010\u000f*\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0013H\u0007¢\u0006\u0002\u0010\u0014J7\u0010\u000e\u001a\u0002H\u000f\"\n\b\u0000\u0010\u000f*\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0013H\u0007¢\u0006\u0002\u0010\u0016J(\u0010\u000e\u001a\u0002H\u000f\"\n\b\u0000\u0010\u000f*\u0004\u0018\u00010\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0013H\u0097\u0002¢\u0006\u0002\u0010\u0017J0\u0010\u000e\u001a\u0002H\u000f\"\n\b\u0000\u0010\u000f*\u0004\u0018\u00010\u00102\u0006\u0010\u0015\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0013H\u0096\u0002¢\u0006\u0002\u0010\u0018R6\u0010\u0004\u001a*\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005j\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007`\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/lifecycle/SharedViewModelProvider;", "Landroidx/lifecycle/ViewModelProvider;", ComplianceConstants.ComplianceRequest.MARKET_STORE, "Landroidx/lifecycle/ViewModelStore;", "map", "Ljava/util/HashMap;", "", "", "Landroidx/lifecycle/Lifecycle;", "Lkotlin/collections/HashMap;", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "(Landroidx/lifecycle/ViewModelStore;Ljava/util/HashMap;Landroidx/lifecycle/ViewModelProvider$Factory;)V", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", MonitorConstants.CONNECT_TYPE_GET, ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", NewBroadcastMonitor.STAGE.LIFECYCLE, "modelClass", "Ljava/lang/Class;", "(Landroidx/lifecycle/Lifecycle;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "key", "(Landroidx/lifecycle/Lifecycle;Ljava/lang/String;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "(Ljava/lang/String;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "ClearUselessViewModelObserver", "Companion", "SharedViewModel_release"}, k = 1, mv = {1, 1, 16})
public final class SharedViewModelProvider extends ViewModelProvider {
    public static final Companion Companion = null;
    private static final String DEFAULT_KEY = "androidx.lifecycle.ViewModelProvider.DefaultKey";
    private static final String UNSUPPORT_MESSAGE = "Unsupport get viewmodel without lifecycle, please use method get(Lifecycle,Class) or get(Lifecycle,String,Class) instead";
    private static final HashMap<String, Set<Lifecycle>> globalMap = null;
    private static final ViewModelStore globalStore = null;
    private HashMap<String, Set<Lifecycle>> map;
    private ViewModelStore store;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012.\u0010\b\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\n0\tj\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\n`\u000b¢\u0006\u0002\u0010\fJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\b\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\n0\tj\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/lifecycle/SharedViewModelProvider$ClearUselessViewModelObserver;", "Landroidx/lifecycle/LifecycleEventObserver;", NewBroadcastMonitor.STAGE.LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "key", "", ComplianceConstants.ComplianceRequest.MARKET_STORE, "Landroidx/lifecycle/ViewModelStore;", "map", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "(Landroidx/lifecycle/Lifecycle;Ljava/lang/String;Landroidx/lifecycle/ViewModelStore;Ljava/util/HashMap;)V", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "SharedViewModel_release"}, k = 1, mv = {1, 1, 16})
    public static final class ClearUselessViewModelObserver implements LifecycleEventObserver {
        private final String key;
        private final Lifecycle lifecycle;
        private final HashMap<String, Set<Lifecycle>> map;
        private final ViewModelStore store;

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
            if (r101 != Lifecycle.Event.ON_DESTROY) goto L12;
            Set<Lifecycle> r102 = this.map.get(this.key);
            if (r102 != null) goto L8;
            r102 = new LinkedHashSet();
        L8:
            Set<Lifecycle> r103 = r102;
            r103.remove(this.lifecycle);
            if (r103.isEmpty() == false) goto L13;
            this.store.put(this.key, FakeViewModel.INSTANCE);
            this.map.remove(this.key);
            return;
        L13:
            return;
        }

        public ClearUselessViewModelObserver(Lifecycle r100, String r101, ViewModelStore r102, HashMap<String, Set<Lifecycle>> r103) {
            this.lifecycle = r100;
            this.key = r101;
            this.store = r102;
            this.map = r103;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R6\u0010\u0006\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/lifecycle/SharedViewModelProvider$Companion;", "", "()V", "DEFAULT_KEY", "", "UNSUPPORT_MESSAGE", "globalMap", "Ljava/util/HashMap;", "", "Landroidx/lifecycle/Lifecycle;", "Lkotlin/collections/HashMap;", "globalStore", "Landroidx/lifecycle/ViewModelStore;", "SharedViewModel_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        globalStore = new ViewModelStore();
        globalMap = new HashMap();
    }

    public SharedViewModelProvider(ViewModelProvider.Factory r100) {
        ViewModelStore r101 = globalStore;
        super(r101, r100);
        this.store = r101;
        this.map = globalMap;
    }

    @Override // androidx.lifecycle.ViewModelProvider
    @Deprecated(message = UNSUPPORT_MESSAGE)
    public <T extends ViewModel> T get(Class<T> r100) {
        throw new IllegalAccessException(UNSUPPORT_MESSAGE);
    }

    public final <T extends ViewModel> T get(Lifecycle r100, Class<T> r101) {
        String r102 = r101.getCanonicalName();
        if (r102 == null) goto L7;
        return (T) get(r100, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(r102), r101);
    L7:
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.ViewModelProvider
    public <T extends ViewModel> T get(String r100, Class<T> r101) {
        throw new IllegalAccessException(UNSUPPORT_MESSAGE);
    }

    public /* synthetic */ SharedViewModelProvider(ViewModelProvider.Factory r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = new ViewModelProvider.NewInstanceFactory();
    L5:
        this(r100);
    }

    public final <T extends ViewModel> T get(Lifecycle r100, String r101, Class<T> r102) {
        if (r100.getCurrentState() == Lifecycle.State.DESTROYED) goto L5;
        T r103 = (T) super.get(r101, r102);
        Set<Lifecycle> r104 = this.map.get(r101);
        if (r104 != null) goto L16;
        r104 = new LinkedHashSet();
    L16:
        Set<Lifecycle> r105 = r104;
        this.map.put(r101, r105);
        if (r105.contains(r100) == true) goto L19;
        r105.add(r100);
        r100.addObserver(new ClearUselessViewModelObserver(r100, r101, this.store, this.map));
    L19:
        return r103;
    L5:
        if (SharedViewModelHostInjector.INSTANCE.getOptimiseLifecycle() == false) goto L11;
        return r102.newInstance();
    L9:
        return (T) super.get(r101, r102);
    L11:
        throw new IllegalStateException("Could not get viewmodel when lifecycle was destroyed");
    }

    public SharedViewModelProvider(ViewModelStore r100, HashMap<String, Set<Lifecycle>> r101, ViewModelProvider.Factory r102) {
        super(r100, r102);
        this.store = r100;
        this.map = r101;
    }

    public /* synthetic */ SharedViewModelProvider(ViewModelStore r100, HashMap r101, ViewModelProvider.Factory r102, int r103, DefaultConstructorMarker r104) {
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
