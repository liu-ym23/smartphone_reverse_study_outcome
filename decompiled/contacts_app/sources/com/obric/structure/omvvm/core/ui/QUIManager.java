package com.obric.structure.omvvm.core.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Trace;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.obric.contactsdk.loader.CallFeatureEntityUtilKt;
import com.obric.structure.omvvm.core.Q;
import com.obric.structure.omvvm.core.extension.IQIManagerPrefMonitor;
import com.obric.structure.omvvm.core.extension.QIManagerBindListener;
import com.obric.structure.omvvm.core.insight.QInsight;
import com.obric.structure.omvvm.core.model.QModel;
import com.obric.structure.omvvm.core.performance.QVsyncFrameCaller;
import com.obric.structure.omvvm.core.presenter.QGroupPresenter;
import com.obric.structure.omvvm.core.presenter.QIMust;
import com.obric.structure.omvvm.core.presenter.QIPresenter;
import com.obric.structure.omvvm.core.util.QExecutor;
import com.obric.structure.omvvm.core.util.QHandler;
import com.obric.structure.omvvm.core.util.QUtils;
import com.obric.structure.omvvm.core.util.ViewModelStoreOwnerDelegate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: QUIManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 \u009a\u00012\u00020\u0001:\u0002\u009a\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020)H\u0002J\u000e\u0010j\u001a\u00020Z2\u0006\u0010k\u001a\u00020\tJ,\u0010l\u001a\u00020Z2\u0006\u0010i\u001a\u00020)2\n\u0010m\u001a\u0006\u0012\u0002\b\u00030A2\u000e\u0010n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010oH\u0007J\u0010\u0010p\u001a\u00020Z2\u0006\u0010i\u001a\u00020)H\u0004J*\u0010q\u001a\u00020Z\"\b\b\u0000\u0010r*\u00020)2\f\u0010s\u001a\b\u0012\u0004\u0012\u0002Hr0A2\b\u0010t\u001a\u0004\u0018\u00010uH\u0007J\u001a\u0010v\u001a\u00020Z2\u0006\u0010i\u001a\u00020)2\b\u0010t\u001a\u0004\u0018\u00010uH\u0014J\u001a\u0010w\u001a\u00020Z2\u0006\u0010i\u001a\u00020)2\b\u0010t\u001a\u0004\u0018\u00010uH\u0002J\u0018\u0010x\u001a\u00020Z2\u0006\u0010i\u001a\u00020)2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010y\u001a\u00020Z2\u0006\u0010i\u001a\u00020)2\u0006\u0010z\u001a\u00020\u0004H\u0002J\u000e\u0010{\u001a\u00020\u00042\u0006\u0010k\u001a\u00020\tJ\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010|\u001a\u00020Q2\u0006\u0010i\u001a\u00020)H\u0004J\u0006\u0010}\u001a\u00020)J \u0010~\u001a\u0004\u0018\u00010Q\"\b\b\u0000\u0010r*\u00020)2\f\u0010s\u001a\b\u0012\u0004\u0012\u0002Hr0AJ \u0010\u007f\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*2\u0006\u0010i\u001a\u00020)H\u0002J\u0018\u0010/\u001a\u00020Z2\u0006\u0010z\u001a\u00020)2\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J \u0010/\u001a\u00020Z2\u0006\u0010z\u001a\u00020)2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 H\u0007J+\u0010/\u001a\u00020Z2\u0006\u0010z\u001a\u00020)2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0007\u0010\u0080\u0001\u001a\u00020\u0004H\u0007J!\u0010/\u001a\u00020Z2\u0006\u0010z\u001a\u00020)2\u0006\u0010\u0019\u001a\u00020\u001a2\u0007\u0010\u0080\u0001\u001a\u00020\u0004H\u0007J\"\u0010\u0081\u0001\u001a\u00020Z2\u0006\u0010i\u001a\u00020)2\u0006\u0010\u0019\u001a\u00020\u001a2\u0007\u0010\u0082\u0001\u001a\u00020)H\u0002J\u001a\u0010\u0083\u0001\u001a\u00020Z2\u0006\u0010i\u001a\u00020)2\u0007\u0010\u0084\u0001\u001a\u00020_H\u0002J\u001a\u0010\u0085\u0001\u001a\u00020Z2\u0006\u0010i\u001a\u00020)2\u0007\u0010\u0084\u0001\u001a\u00020_H\u0002J\t\u0010\u0086\u0001\u001a\u00020ZH\u0003J\u0017\u0010\u0087\u0001\u001a\u00020Z2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010P\u001a\u00020QJ\u001b\u0010\u0088\u0001\u001a\u00020Z2\u0006\u0010i\u001a\u00020)2\b\u0010t\u001a\u0004\u0018\u00010uH\u0004J\u0016\u0010\u0089\u0001\u001a\u00020Z2\r\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020Z0oJ\u0011\u0010\u008b\u0001\u001a\u00020\u00042\u0006\u0010i\u001a\u00020)H\u0002J-\u0010\u008c\u0001\u001a\u0011\u0012\u0004\u0012\u0002Hr\u0012\u0006\u0012\u0004\u0018\u00010D0\u008d\u0001\"\u0004\b\u0000\u0010r2\r\u0010\u008e\u0001\u001a\b\u0012\u0004\u0012\u0002Hr0oH\u0002J\u000f\u0010\u008f\u0001\u001a\u00020Z2\u0006\u0010k\u001a\u00020\tJ\u0006\u0010P\u001a\u00020QJ'\u0010\u0090\u0001\u001a\u00020Z2\u0006\u0010i\u001a\u00020)2\b\u0010t\u001a\u0004\u0018\u00010u2\n\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u0001H\u0004J\u001a\u0010\u0093\u0001\u001a\u00020Z2\b\u0010i\u001a\u0004\u0018\u00010)2\u0007\u0010\u0084\u0001\u001a\u00020_J(\u0010\u0093\u0001\u001a\u00020Z\"\b\b\u0000\u0010r*\u00020)2\f\u0010s\u001a\b\u0012\u0004\u0012\u0002Hr0A2\u0007\u0010\u0084\u0001\u001a\u00020_J\u0011\u0010\u0094\u0001\u001a\u00020Z2\u0006\u0010i\u001a\u00020)H\u0002J!\u0010\u0095\u0001\u001a\u00020Z\"\b\b\u0000\u0010r*\u00020)2\f\u0010s\u001a\b\u0012\u0004\u0012\u0002Hr0AH\u0007J\u0011\u0010\u0096\u0001\u001a\u00020Z2\u0006\u0010i\u001a\u00020)H\u0002J1\u0010\u0097\u0001\u001a\u00020Z2\u0006\u0010i\u001a\u00020)2\b\u0010t\u001a\u0004\u0018\u00010u2\t\b\u0002\u0010\u0098\u0001\u001a\u00020\u00042\t\b\u0002\u0010\u0099\u0001\u001a\u00020\u0004H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u00020\u00048FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\rR\u001a\u0010\u0019\u001a\u00020\u001aX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$RJ\u0010%\u001a>\u0012\u0004\u0012\u00020'\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*0&j\u001e\u0012\u0004\u0012\u00020'\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*`+X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0006R\u000e\u0010/\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\rR\u001a\u00103\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\rR\u001a\u00106\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0006\"\u0004\b7\u0010\rR\u001a\u00108\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0006\"\u0004\b9\u0010\rR\u001a\u0010:\u001a\u00020;X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R2\u0010@\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030A\u0012\u0004\u0012\u00020)0&j\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030A\u0012\u0004\u0012\u00020)`+X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010B\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020D0CX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010E\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020D0CX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010F\u001a\u0004\u0018\u00010GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001a\u0010L\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0006\"\u0004\bN\u0010\rR\u000e\u0010O\u001a\u00020)X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020QX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010R\u001a\u00020'8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bS\u0010TR#\u0010W\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020Z0Y0X¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\\R\u001a\u0010]\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020_0^X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010`\u001a\u00020aX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010cR\u001a\u0010d\u001a\u00020;X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010=\"\u0004\bf\u0010?¨\u0006\u009b\u0001"}, d2 = {"Lcom/obric/structure/omvvm/core/ui/QUIManager;", "", "()V", "DEBUG_TRACE", "", "getDEBUG_TRACE", "()Z", "bindFinishListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/structure/omvvm/core/extension/QIManagerBindListener;", "bindInnerOpt", "getBindInnerOpt", "setBindInnerOpt", "(Z)V", "bindListener", "getBindListener", "()Lcom/obric/structure/omvvm/core/extension/QIManagerBindListener;", "setBindListener", "(Lcom/obric/structure/omvvm/core/extension/QIManagerBindListener;)V", "bindListener2", "getBindListener2", "setBindListener2", "bindScatterOpt", "getBindScatterOpt", "setBindScatterOpt", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "fragment", "Landroidx/fragment/app/Fragment;", "getFragment", "()Landroidx/fragment/app/Fragment;", "setFragment", "(Landroidx/fragment/app/Fragment;)V", "groupModule", "Ljava/util/HashMap;", "", "Ljava/util/ArrayList;", "Lcom/obric/structure/omvvm/core/ui/QUIModule;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "<set-?>", "hasSyncBind", "getHasSyncBind", "init", "innerCheckBindState", "getInnerCheckBindState", "setInnerCheckBindState", "insight", "getInsight", "setInsight", "isPostScatter", "setPostScatter", "isScatterUnbind", "setScatterUnbind", "main", "Lcom/obric/structure/omvvm/core/util/QHandler;", "getMain", "()Lcom/obric/structure/omvvm/core/util/QHandler;", "setMain", "(Lcom/obric/structure/omvvm/core/util/QHandler;)V", "moduleCache", "Ljava/lang/Class;", "moduleCreatedTimeRecord", "Ljava/util/concurrent/ConcurrentHashMap;", "", "moduleVisibilityTimeRecord", "prefMonitor", "Lcom/obric/structure/omvvm/core/extension/IQIManagerPrefMonitor;", "getPrefMonitor", "()Lcom/obric/structure/omvvm/core/extension/IQIManagerPrefMonitor;", "setPrefMonitor", "(Lcom/obric/structure/omvvm/core/extension/IQIManagerPrefMonitor;)V", "qContextLifecycleLeakFix", "getQContextLifecycleLeakFix", "setQContextLifecycleLeakFix", "rootUIModule", "rootView", "Landroid/view/View;", "uiManagerKey", "getUiManagerKey", "()Ljava/lang/String;", "uiManagerKey$delegate", "Lkotlin/Lazy;", "unBindFinishListeners", "", "Lkotlin/Function1;", "", "getUnBindFinishListeners", "()Ljava/util/List;", "visibilityTracker", "", "", "vmStoreOwner", "Lcom/obric/structure/omvvm/core/util/ViewModelStoreOwnerDelegate;", "getVmStoreOwner$omvvm_core_release", "()Lcom/obric/structure/omvvm/core/util/ViewModelStoreOwnerDelegate;", "work", "getWork", "setWork", CallFeatureEntityUtilKt.PARAM_KEY_ACTION, "Lcom/obric/structure/omvvm/core/ui/QUIAction;", "uiModule", "addBindFinishListener", "listener", "addModuleAfterInit", "parentModuleCls", "contextCheck", "Lkotlin/Function0;", "addModuleView", "bind", ExifInterface.GPS_DIRECTION_TRUE, "moduleClass", "model", "Lcom/obric/structure/omvvm/core/model/QModel;", "bindInner", "bindMust", "buildModule", "buildSub", "root", "containsBindFinishListener", "createView", "getRootModule", "getRootView", "group", "sync", "initModule", "parentModule", "moduleCreated", "visibility", "moduleVisibility", "notifyAllModuleVisibilityChanged", "onlyInitField", "pendingBind", "postBind", "runnable", "preloadModuleView", "recordTime", "Lkotlin/Pair;", "block", "removeBindFinishListener", "scatterBind", "presenter", "Lcom/obric/structure/omvvm/core/presenter/QIPresenter;", "setVisibility", "subVisible", "unbind", "unbindInner", "updateVisibility", "isChildOnly", "preload", "Companion", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class QUIManager {
    public static final Companion Companion = null;
    private static boolean bindInnerGlobalOpt;
    private final boolean DEBUG_TRACE;
    private final CopyOnWriteArrayList<QIManagerBindListener> bindFinishListeners;
    private boolean bindInnerOpt;
    private QIManagerBindListener bindListener;
    private QIManagerBindListener bindListener2;
    private boolean bindScatterOpt;
    public Context context;
    private Fragment fragment;
    private final HashMap<String, ArrayList<QUIModule>> groupModule;
    private volatile boolean hasSyncBind;
    private boolean init;
    private boolean innerCheckBindState;
    private boolean insight;
    private boolean isPostScatter;
    private boolean isScatterUnbind;
    protected QHandler main;
    private final HashMap<Class<?>, QUIModule> moduleCache;
    private final ConcurrentHashMap<String, Long> moduleCreatedTimeRecord;
    private final ConcurrentHashMap<String, Long> moduleVisibilityTimeRecord;
    private IQIManagerPrefMonitor prefMonitor;
    private boolean qContextLifecycleLeakFix;
    private QUIModule rootUIModule;
    private View rootView;
    private final Lazy uiManagerKey$delegate;
    private final List<Function1<QUIModule, Unit>> unBindFinishListeners;
    private final Map<String, Integer> visibilityTracker;
    private final ViewModelStoreOwnerDelegate vmStoreOwner;
    protected QHandler work;

    /* JADX INFO: compiled from: QUIManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/structure/omvvm/core/ui/QUIManager$Companion;", "", "()V", "bindInnerGlobalOpt", "", "getBindInnerGlobalOpt$annotations", "getBindInnerGlobalOpt", "()Z", "setBindInnerGlobalOpt", "(Z)V", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getBindInnerGlobalOpt$annotations() {
        }

        private Companion() {
        }

        public final boolean getBindInnerGlobalOpt() {
            return QUIManager.access$getBindInnerGlobalOpt$cp();
        }

        public final void setBindInnerGlobalOpt(boolean r1) {
            QUIManager.access$setBindInnerGlobalOpt$cp(r1);
        }
    }

    /* JADX INFO: compiled from: QUIManager.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[QUIAction.values().length];
            r0[QUIAction.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[QUIAction.SHOW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[QUIAction.REPLACE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[QUIAction.HIDE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static final boolean getBindInnerGlobalOpt() {
        return Companion.getBindInnerGlobalOpt();
    }

    public static final void setBindInnerGlobalOpt(boolean r1) {
        Companion.setBindInnerGlobalOpt(r1);
    }

    public QUIManager() {
        this.qContextLifecycleLeakFix = Q.INSTANCE.getCig().fixQContextLifecycleLeak();
        this.bindFinishListeners = new CopyOnWriteArrayList();
        this.unBindFinishListeners = new ArrayList();
        this.vmStoreOwner = new ViewModelStoreOwnerDelegate();
        this.groupModule = new HashMap();
        this.moduleCache = new HashMap();
        this.moduleVisibilityTimeRecord = new ConcurrentHashMap();
        this.moduleCreatedTimeRecord = new ConcurrentHashMap();
        this.visibilityTracker = new LinkedHashMap();
        this.uiManagerKey$delegate = LazyKt.lazy(new QUIManager$uiManagerKey$2(this));
        this.isPostScatter = true;
    }

    public static final /* synthetic */ QUIAction access$action(QUIManager r0, QUIModule r1) {
        return r0.action(r1);
    }

    public static final /* synthetic */ void access$buildModule(QUIManager r0, QUIModule r1, Context r2) {
        r0.buildModule(r1, r2);
    }

    public static final /* synthetic */ CopyOnWriteArrayList access$getBindFinishListeners$p(QUIManager r0) {
        return r0.bindFinishListeners;
    }

    public static final /* synthetic */ boolean access$getBindInnerGlobalOpt$cp() {
        return bindInnerGlobalOpt;
    }

    public static final /* synthetic */ HashMap access$getModuleCache$p(QUIManager r0) {
        return r0.moduleCache;
    }

    public static final /* synthetic */ QUIModule access$getRootUIModule$p(QUIManager r0) {
        return r0.rootUIModule;
    }

    public static final /* synthetic */ View access$getRootView$p(QUIManager r0) {
        return r0.rootView;
    }

    public static final /* synthetic */ Map access$getVisibilityTracker$p(QUIManager r0) {
        return r0.visibilityTracker;
    }

    public static final /* synthetic */ ArrayList access$group(QUIManager r0, QUIModule r1) {
        return r0.group(r1);
    }

    public static final /* synthetic */ void access$moduleVisibility(QUIManager r0, QUIModule r1, int r2) {
        r0.moduleVisibility(r1, r2);
    }

    public static final /* synthetic */ void access$notifyAllModuleVisibilityChanged(QUIManager r0) {
        r0.notifyAllModuleVisibilityChanged();
    }

    public static final /* synthetic */ Pair access$recordTime(QUIManager r0, Function0 r1) {
        return r0.recordTime(r1);
    }

    public static final /* synthetic */ void access$setBindInnerGlobalOpt$cp(boolean r0) {
        bindInnerGlobalOpt = r0;
    }

    public static final /* synthetic */ void access$subVisible(QUIManager r0, QUIModule r1) {
        r0.subVisible(r1);
    }

    public static final /* synthetic */ void access$unbind$unbindBlock(QUIManager r0, QUIModule r1) {
        unbind$unbindBlock(r0, r1);
    }

    public final Context getContext() {
        Context r0 = this.context;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("context");
        return null;
    }

    public final void setContext(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.context = r2;
    }

    public final boolean getQContextLifecycleLeakFix() {
        return this.qContextLifecycleLeakFix;
    }

    public final void setQContextLifecycleLeakFix(boolean r1) {
        this.qContextLifecycleLeakFix = r1;
    }

    public final Fragment getFragment() {
        return this.fragment;
    }

    public final void setFragment(Fragment r1) {
        this.fragment = r1;
    }

    public final QIManagerBindListener getBindListener() {
        return this.bindListener;
    }

    public final void setBindListener(QIManagerBindListener r1) {
        this.bindListener = r1;
    }

    public final QIManagerBindListener getBindListener2() {
        return this.bindListener2;
    }

    public final void setBindListener2(QIManagerBindListener r1) {
        this.bindListener2 = r1;
    }

    public final IQIManagerPrefMonitor getPrefMonitor() {
        return this.prefMonitor;
    }

    public final void setPrefMonitor(IQIManagerPrefMonitor r1) {
        this.prefMonitor = r1;
    }

    public final List<Function1<QUIModule, Unit>> getUnBindFinishListeners() {
        return this.unBindFinishListeners;
    }

    public final ViewModelStoreOwnerDelegate getVmStoreOwner$omvvm_core_release() {
        return this.vmStoreOwner;
    }

    protected final QHandler getMain() {
        QHandler r0 = this.main;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("main");
        return null;
    }

    protected final void setMain(QHandler r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.main = r2;
    }

    protected final QHandler getWork() {
        QHandler r0 = this.work;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("work");
        return null;
    }

    protected final void setWork(QHandler r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.work = r2;
    }

    public final String getUiManagerKey() {
        return (String) this.uiManagerKey$delegate.getValue();
    }

    public final boolean getInsight() {
        return this.insight;
    }

    public final void setInsight(boolean r1) {
        this.insight = r1;
    }

    public final void setBindInnerOpt(boolean r1) {
        this.bindInnerOpt = r1;
    }

    public final boolean getBindInnerOpt() {
        if (this.bindInnerOpt == false) goto L5;
    L8:
        return true;
    L5:
        if (bindInnerGlobalOpt == true) goto L8;
        return false;
    }

    public final boolean getDEBUG_TRACE() {
        return this.DEBUG_TRACE;
    }

    public final boolean getBindScatterOpt() {
        return this.bindScatterOpt;
    }

    public final void setBindScatterOpt(boolean r1) {
        this.bindScatterOpt = r1;
    }

    public final boolean isPostScatter() {
        return this.isPostScatter;
    }

    public final void setPostScatter(boolean r1) {
        this.isPostScatter = r1;
    }

    public final boolean isScatterUnbind() {
        return this.isScatterUnbind;
    }

    public final void setScatterUnbind(boolean r1) {
        this.isScatterUnbind = r1;
    }

    public final void onlyInitField(Context r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "rootView");
        setContext(r2);
        this.rootView = r3;
    }

    public final void init(QUIModule r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "root");
        Intrinsics.checkNotNullParameter(r3, "context");
        init(r2, r3, false);
    }

    public final void init(QUIModule r2, Context r3, Fragment r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "root");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.fragment = r4;
        init(r2, r3, r5);
    }

    public final void init(QUIModule r9, final Context r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r9, "root");
        Intrinsics.checkNotNullParameter(r10, "context");
        setContext(r10);
        if (r11 == false) goto L5;
        setMain(new QHandler(new Handler(), true));
        setWork(new QHandler(new Handler(), true));
    L6:
        this.rootUIModule = r9;
        QInsight.INSTANCE.runIfEnabled(new C03981(this));
        if (this.prefMonitor == null) goto L9;
        Long r12 = Long.valueOf(-System.nanoTime());
    L10:
        QUIModule r1 = this.rootUIModule;
        if (r1 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("rootUIModule");
        r1 = null;
    L13:
        r1.init(r10, this, null);
        if (r12 == null) goto L16;
        Long r13 = Long.valueOf(r12.longValue() + System.nanoTime());
    L18:
        if (this.DEBUG_TRACE == false) goto L23;
        StringBuilder r2 = new StringBuilder("onCreateView:");
        QUIModule r3 = this.rootUIModule;
        if (r3 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("rootUIModule");
        r3 = null;
    L22:
        Trace.beginSection(r2.append(r3.getClass().getSimpleName()).toString());
    L23:
        QUIModule r4 = this.rootUIModule;
        if (r4 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("rootUIModule");
        r4 = null;
    L26:
        QUIModule r5 = this.rootUIModule;
        if (r5 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("rootUIModule");
        r5 = null;
    L29:
        r4.setView(r5.onCreateView(r10, null));
        if (this.DEBUG_TRACE == false) goto L32;
        Trace.endSection();
    L32:
        QInsight.INSTANCE.runIfEnabled(new C03992(this));
        QUIModule r6 = this.rootUIModule;
        if (r6 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("rootUIModule");
        r6 = null;
    L35:
        View r7 = r6.getView();
        Intrinsics.checkNotNull(r7);
        this.rootView = r7;
        QUIModule r8 = this.rootUIModule;
        if (r8 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("rootUIModule");
        r8 = null;
    L38:
        View r14 = r8.getView();
        Intrinsics.checkNotNull(r14);
        QUIModule r15 = this.rootUIModule;
        if (r15 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("rootUIModule");
        r15 = null;
    L41:
        r14.setVisibility(QUIModule.visibility$default(r15, null, 1, null));
        QUIModule r16 = this.rootUIModule;
        if (r16 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("rootUIModule");
        r16 = null;
    L44:
        r16.setViewCreated$omvvm_core_release(true);
        QUIModule r17 = this.rootUIModule;
        if (r17 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("rootUIModule");
        r17 = null;
    L47:
        View r18 = this.rootView;
        if (r18 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        r18 = null;
    L50:
        r17.onViewCreated(r18);
        QInsight.INSTANCE.runIfEnabled(new AnonymousClass3(this));
        HashMap<Class<?>, QUIModule> r19 = this.moduleCache;
        QUIModule r20 = this.rootUIModule;
        if (r20 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("rootUIModule");
        r20 = null;
    L53:
        Class<?> r21 = r20.getClass();
        QUIModule r22 = this.rootUIModule;
        if (r22 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("rootUIModule");
        r22 = null;
    L56:
        r19.put(r21, r22);
        QUIModule r23 = this.rootUIModule;
        if (r23 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("rootUIModule");
        r23 = null;
    L60:
        if (r23.getSubModules() == null) goto L84;
        QUIModule r24 = this.rootUIModule;
        if (r24 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("rootUIModule");
        r24 = null;
    L64:
        List<QUIModule> r25 = r24.getSubModules();
        Intrinsics.checkNotNull(r25);
        Iterator<QUIModule> r26 = r25.iterator();
    L66:
        if (r26.hasNext() == false) goto L84;
        final QUIModule r27 = r26.next();
        if (this.DEBUG_TRACE == false) goto L70;
        Trace.beginSection("initModule:" + r27.getClass().getSimpleName());
    L70:
        if (r13 == null) goto L72;
        Long r28 = Long.valueOf(r13.longValue() - System.nanoTime());
    L73:
        QUIModule r29 = this.rootUIModule;
        if (r29 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("rootUIModule");
        r29 = null;
    L76:
        initModule(r27, r10, r29);
        if (r28 == null) goto L79;
        r13 = Long.valueOf(r28.longValue() + System.nanoTime());
    L81:
        if (this.DEBUG_TRACE == false) goto L83;
        Trace.endSection();
    L83:
        getWork().post(new C04004(this, r27, r10));
        goto L66
    L79:
        r13 = null;
        goto L81
    L72:
        r28 = null;
    L84:
        IQIManagerPrefMonitor r110 = this.prefMonitor;
        if (r110 == null) goto L87;
        r110.onModuleInitialized(r13);
    L87:
        this.init = true;
        return;
    L16:
        r13 = null;
        goto L18
    L9:
        r12 = null;
        goto L10
    L5:
        setMain(new QHandler(QExecutor.INSTANCE.main(), false));
        setWork(new QHandler(QExecutor.INSTANCE.work(), false));
        goto L6
    }

    public final void init(QUIModule r2, Context r3, Fragment r4) {
        Intrinsics.checkNotNullParameter(r2, "root");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "fragment");
        this.fragment = r4;
        init(r2, r3);
    }

    public final View rootView() {
        View r0 = this.rootView;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        return null;
    L6:
        return r0;
    }

    public final Context context() {
        return getContext();
    }

    public final boolean getInnerCheckBindState() {
        return this.innerCheckBindState;
    }

    public final void setInnerCheckBindState(boolean r1) {
        this.innerCheckBindState = r1;
    }

    public final boolean getHasSyncBind() {
        return this.hasSyncBind;
    }

    public final <T extends QUIModule> void bind(final Class<T> r4, final QModel r5) {
        Intrinsics.checkNotNullParameter(r4, "moduleClass");
        if (this.init == false) goto L15;
        this.hasSyncBind = true;
        QInsight.INSTANCE.bind(this);
        final QUIModule r0 = this.moduleCache.get(r4);
        if (r0 != null) goto L7;
        return;
    L7:
        IQIManagerPrefMonitor r1 = this.prefMonitor;
        if (r1 == null) goto L10;
        r1.onMustBindStart(this.moduleCache.size());
    L10:
        bindMust(r0, r5);
        IQIManagerPrefMonitor r2 = this.prefMonitor;
        if (r2 == null) goto L13;
        r2.onMustBindEnd();
    L13:
        getWork().post(new AnonymousClass1(this, r0, r5, r4));
        return;
    }

    static /* synthetic */ void updateVisibility$default(QUIManager r1, QUIModule r2, QModel r3, boolean r4, boolean r5, int r6, Object r7) {
        if (r7 != null) goto L12;
        if ((r6 & 4) == 0) goto L7;
        r4 = false;
    L7:
        if ((r6 & 8) == 0) goto L9;
        r5 = false;
    L9:
        r1.updateVisibility(r2, r3, r4, r5);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateVisibility");
    }

    private final void updateVisibility(final QUIModule r3, final QModel r4, boolean r5, boolean r6) {
        if (r5 == true) goto L4;
    L6:
        Long r7 = (Long) recordTime(new C04101(r3, r4)).getSecond();
        if (r7 == null) goto L10;
        this.moduleVisibilityTimeRecord.put(r3.moduleName(), Long.valueOf(r7.longValue()));
    L10:
        if (r6 == true) goto L12;
    L16:
        boolean r8 = false;
    L18:
        if (r3.getSubModules() == null) goto L29;
        r3.setChildOnly$omvvm_core_release(false);
        List<QUIModule> r0 = r3.getSubModules();
        Intrinsics.checkNotNull(r0);
        Iterator<QUIModule> r1 = r0.iterator();
    L21:
        if (r1.hasNext() == false) goto L25;
        if (r1.next().isOnly(r4) == false) goto L21;
        r3.setChildOnly$omvvm_core_release(true);
    L25:
        List<QUIModule> r9 = r3.getSubModules();
        Intrinsics.checkNotNull(r9);
        Iterator<QUIModule> r10 = r9.iterator();
    L27:
        if (r10.hasNext() == false) goto L34;
        updateVisibility(r10.next(), r4, r3.isChildOnly$omvvm_core_release(), r8);
        goto L27
    L34:
        return;
    L29:
        return;
    L12:
        if (r3.asyncUIOperated() == true) goto L16;
        if (preloadModuleView(r3) == false) goto L16;
        r8 = true;
        goto L18
    L4:
        if (r3.isOnly(r4) == true) goto L6;
        r3.setVisibility$omvvm_core_release(8);
        goto L10
    }

    private final boolean preloadModuleView(QUIModule r2) {
        if (r2.getView() != null) goto L8;
        if (r2.getVisibility$omvvm_core_release() != 0) goto L8;
        r2.setView(createView(r2));
    L8:
        if (r2.getVisibility$omvvm_core_release() == 0) goto L10;
    L12:
        return false;
    L10:
        if ((r2.getView() instanceof ViewGroup) == false) goto L12;
        return true;
    }

    private final void bindMust(QUIModule r3, QModel r4) {
        if ((r3.getPresenter$omvvm_core_release() instanceof QIMust) == false) goto L6;
        QIPresenter r0 = r3.getPresenter$omvvm_core_release();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.obric.structure.omvvm.core.presenter.QIMust");
        ((QIMust) r0).mustBind(r4, this);
    L6:
        if (r3.getSubModules() == null) goto L11;
        List<QUIModule> r5 = r3.getSubModules();
        Intrinsics.checkNotNull(r5);
        Iterator<QUIModule> r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L13;
        bindMust(r6.next(), r4);
        goto L9
    L13:
        return;
    }

    protected void bindInner(final QUIModule r5, final QModel r6) {
        Intrinsics.checkNotNullParameter(r5, "uiModule");
        Fragment r0 = this.fragment;
        if (r0 == null) goto L7;
        Intrinsics.checkNotNull(r0);
        if (r0.getActivity() == null) goto L7;
    L8:
        r5.setModel$omvvm_core_release(r6);
        if (r5.getVisibility$omvvm_core_release() != 8) goto L11;
        pendingBind(r5, r6);
    L32:
        if (r5.getViewCreated$omvvm_core_release() == false) goto L38;
        if (this.bindScatterOpt == false) goto L36;
        postBind(new C03921(this, r5));
        goto L38
    L36:
        setVisibility(r5, r5.getVisibility$omvvm_core_release());
    L38:
        if (r5.getVisibility$omvvm_core_release() != 8) goto L40;
        return;
    L40:
        if (r5.getSubModules() != null) goto L42;
        return;
    L42:
        if (GraduallyRenderUIModuleKt.isGraduallyRenderUIModule(r5) == true) goto L61;
        List<QUIModule> r7 = r5.getSubModules();
        Intrinsics.checkNotNull(r7);
        Iterator<QUIModule> r8 = r7.iterator();
    L45:
        if (r8.hasNext() == false) goto L62;
        final QUIModule r1 = r8.next();
        Long r2 = (Long) recordTime(new C03932(this, r1, r6)).getSecond();
        if (r2 == null) goto L45;
        long r3 = r2.longValue();
        IQIManagerPrefMonitor r4 = this.prefMonitor;
        if (r4 == null) goto L45;
        r4.onSubModuleBindFinish(r1.moduleName(), r3);
        goto L45
    L62:
        return;
    L61:
        return;
    L11:
        if (r5.getViewCreated$omvvm_core_release() == false) goto L19;
        if (this.bindScatterOpt == false) goto L15;
        scatterBind(r5, r6, r5.getPresenter$omvvm_core_release());
        goto L32
    L15:
        QIPresenter r9 = r5.getPresenter$omvvm_core_release();
        if (r9 == null) goto L32;
        View r10 = r5.getView();
        Intrinsics.checkNotNull(r10);
        r9.bind(r6, r10, this);
        goto L32
    L19:
        if (getBindInnerOpt() == true) goto L21;
        r5.setView(createView(r5));
    L24:
        addModuleView(r5);
        r5.setViewCreated$omvvm_core_release(true);
        View r11 = r5.getView();
        Intrinsics.checkNotNull(r11);
        r5.onViewCreated(r11);
        if (this.bindScatterOpt == false) goto L27;
        scatterBind(r5, r6, r5.getPresenter$omvvm_core_release());
        goto L32
    L27:
        QIPresenter r12 = r5.getPresenter$omvvm_core_release();
        if (r12 == null) goto L32;
        View r13 = r5.getView();
        Intrinsics.checkNotNull(r13);
        r12.bind(r6, r13, this);
        goto L32
    L21:
        if (r5.getView() != null) goto L24;
        r5.setView(createView(r5));
    L7:
        if (this.fragment == null) goto L8;
    }

    protected final void scatterBind(final QUIModule r2, final QModel r3, final QIPresenter r4) {
        Intrinsics.checkNotNullParameter(r2, "uiModule");
        if ((r4 instanceof QGroupPresenter) == false) goto L5;
        View r5 = r2.getView();
        Intrinsics.checkNotNull(r5);
        ((QGroupPresenter) r4).scatterBind(r3, r5, this, this.isPostScatter);
        return;
    L5:
        postBind(new C04061(r4, r3, r2, this));
    }

    public final void postBind(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "runnable");
        QVsyncFrameCaller.INSTANCE.postBind(r2, this.isPostScatter);
    }

    protected final void pendingBind(QUIModule r2, QModel r3) {
        Intrinsics.checkNotNullParameter(r2, "uiModule");
        r2.setPendingBind$omvvm_core_release(true);
        r2.setModel$omvvm_core_release(r3);
        if (r2.getSubModules() == null) goto L8;
        List<QUIModule> r4 = r2.getSubModules();
        Intrinsics.checkNotNull(r4);
        Iterator<QUIModule> r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        pendingBind(r5.next(), r3);
        goto L6
    L10:
        return;
    }

    public final <T extends QUIModule> void unbind(Class<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "moduleClass");
        if (this.init == false) goto L12;
        this.hasSyncBind = false;
        final QUIModule r4 = this.moduleCache.get(r3);
        if (r4 != null) goto L7;
        return;
    L7:
        QInsight.INSTANCE.runIfEnabled(new C04081(this));
        if (this.isScatterUnbind == false) goto L10;
        postBind(new C04092(this, r4));
        return;
    L10:
        unbind$unbindBlock(this, r4);
        return;
    }

    private static final void unbind$unbindBlock(QUIManager r2, QUIModule r3) {
        IQIManagerPrefMonitor r0 = r2.prefMonitor;
        if (r0 == null) goto L5;
        r0.onUnbind();
    L5:
        r2.unbindInner(r3);
        Iterator<T> r1 = r2.unBindFinishListeners.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((Function1) r1.next()).invoke(r3);
        goto L7
    L9:
        IQIManagerPrefMonitor r4 = r2.prefMonitor;
        if (r4 == null) goto L14;
        r4.onUnbindFinish(r2.moduleCreatedTimeRecord, r2.moduleVisibilityTimeRecord);
        return;
    }

    private final void unbindInner(QUIModule r3) {
        if ((r3.getPresenter$omvvm_core_release() instanceof QIMust) == false) goto L6;
        QIPresenter r0 = r3.getPresenter$omvvm_core_release();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.obric.structure.omvvm.core.presenter.QIMust");
        ((QIMust) r0).mustUnbind();
    L6:
        if (r3.getViewCreated$omvvm_core_release() == false) goto L11;
        QIPresenter r1 = r3.getPresenter$omvvm_core_release();
        if (r1 == null) goto L11;
        r1.unbind();
    L11:
        if (r3.getSubModules() == null) goto L16;
        List<QUIModule> r4 = r3.getSubModules();
        Intrinsics.checkNotNull(r4);
        Iterator<QUIModule> r5 = r4.iterator();
    L14:
        if (r5.hasNext() == false) goto L18;
        unbindInner(r5.next());
        goto L14
    L18:
        return;
    }

    public final void setVisibility(final QUIModule r3, final int r4) {
        if (this.init == true) goto L5;
        return;
    L5:
        if (r3 == null) goto L8;
        getWork().post(new C04071(r4, this, r3));
        return;
    }

    public final <T extends QUIModule> void setVisibility(Class<T> r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "moduleClass");
        setVisibility(this.moduleCache.get(r2), r3);
    }

    public final <T extends QUIModule> View getRootView(Class<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "moduleClass");
        if (this.init == true) goto L5;
        return null;
    L5:
        QUIModule r2 = this.moduleCache.get(r3);
        if (r2 == null) goto L11;
        QUIModule r4 = r2.getParent();
        if (r4 != null) goto L10;
        return null;
    L10:
        return r4.getView();
    L11:
        return null;
    }

    public final QUIModule getRootModule() {
        QUIModule r0 = this.rootUIModule;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("rootUIModule");
        return null;
    L6:
        return r0;
    }

    public final void addModuleAfterInit(final QUIModule r2, Class<?> r3, final Function0<Boolean> r4) {
        Intrinsics.checkNotNullParameter(r2, "uiModule");
        Intrinsics.checkNotNullParameter(r3, "parentModuleCls");
        QUIModule r5 = this.moduleCache.get(r3);
        if (r5 != null) goto L5;
        return;
    L5:
        List<QUIModule> r0 = r5.getSubModules();
        if (r0 == null) goto L10;
        List<? extends QUIModule> r1 = CollectionsKt.toMutableList(r0);
        if (r1 == null) goto L10;
        r1.add(r2);
    L11:
        r5.setSubModules(r1);
        initModule(r2, getContext(), r5);
        getWork().post(new AnonymousClass2(r4, this, r2));
        return;
    L10:
        r1 = null;
        goto L11
    }

    private final void initModule(final QUIModule r5, Context r6, QUIModule r7) {
        final long r0 = System.currentTimeMillis();
        QInsight.INSTANCE.runIfEnabled(new C04011(this, r5));
        this.moduleCache.put(r5.getClass(), r5);
        r5.init(r6, this, r7);
        if (r5.getSubModules() == null) goto L8;
        List<QUIModule> r8 = r5.getSubModules();
        Intrinsics.checkNotNull(r8);
        Iterator<QUIModule> r9 = r8.iterator();
    L6:
        if (r9.hasNext() == false) goto L8;
        initModule(r9.next(), r6, r5);
    L8:
        QInsight.INSTANCE.runIfEnabled(new C04022(this, r5, r0));
    }

    private final void buildModule(final QUIModule r9, Context r10) {
        if (QUIModule.visibility$default(r9, null, 1, null) != 8) goto L5;
        return;
    L5:
        final long r4 = System.currentTimeMillis();
        QInsight.INSTANCE.runIfEnabled(new C03941(this, r9));
        int r2 = WhenMappings.$EnumSwitchMapping$0[action(r9).ordinal()];
        if (r2 != 1) goto L8;
        r9.setView(createView(r9));
    L23:
        if (r9.groupId().length() <= 0) goto L25;
        boolean r3 = true;
    L26:
        if (r3 == false) goto L29;
        group(r9).add(r9);
    L29:
        if (r9.getSubModules() == null) goto L34;
        List<QUIModule> r5 = r9.getSubModules();
        Intrinsics.checkNotNull(r5);
        Iterator<QUIModule> r6 = r5.iterator();
    L32:
        if (r6.hasNext() == false) goto L34;
        buildModule(r6.next(), r10);
    L34:
        moduleCreated(r9, QUIModule.visibility$default(r9, null, 1, null));
        QInsight.INSTANCE.runIfEnabled(new C03952(this, r9, r4));
        return;
    L25:
        r3 = false;
        goto L26
    L8:
        if (r2 != 2) goto L10;
        r9.setView(createView(r9));
        goto L23
    L10:
        if (r2 != 3) goto L12;
        r9.setView(createView(r9));
        Iterator<QUIModule> r7 = group(r9).iterator();
    L17:
        if (r7.hasNext() == false) goto L19;
        QUIModule r8 = r7.next();
        Intrinsics.checkNotNullExpressionValue(r8, "otherModule");
        moduleVisibility(r8, 8);
        goto L17
    L19:
        group(r9).clear();
        goto L23
    L12:
        if (r2 != 4) goto L23;
    }

    private final QUIAction action(QUIModule r2) {
        ArrayList<QUIModule> r1 = group(r2);
        r1.remove(r2);
        if ((!r1.isEmpty()) == false) goto L6;
        return r2.handleConflict(r1, r2.getModel$omvvm_core_release());
    L6:
        return QUIAction.NONE;
    }

    private final ArrayList<QUIModule> group(QUIModule r4) {
        if (this.groupModule.get(r4.groupId()) != null) goto L5;
        this.groupModule.put(r4.groupId(), new ArrayList());
    L5:
        ArrayList<QUIModule> r3 = this.groupModule.get(r4.groupId());
        Intrinsics.checkNotNull(r3);
        return r3;
    }

    private final void moduleVisibility(final QUIModule r3, final int r4) {
        getMain().post(new C04041(this, r3, r4));
    }

    private final void moduleCreated(final QUIModule r3, final int r4) {
        getMain().post(new C04031(r3, this, r4));
    }

    protected final void addModuleView(QUIModule r5) {
        Intrinsics.checkNotNullParameter(r5, "uiModule");
        if ((r5.getView() instanceof ViewStub) == false) goto L6;
        QUtils.INSTANCE.replaceSelfWithView(r5);
        return;
    L6:
        View r4 = r5.getView();
        Intrinsics.checkNotNull(r4);
        if (r4.getParent() == null) goto L10;
        return;
    L10:
        if (r5.getParent() != null) goto L12;
        Q.INSTANCE.uploadLog("uiModule.parent is null " + Reflection.getOrCreateKotlinClass(r5.getClass()).getSimpleName());
    L12:
        QUIModule r1 = null;
        if (r5.getParentId$omvvm_core_release() == (-1)) goto L21;
        QUIModule r6 = r5.getParent();
        if (r6 == null) goto L17;
        View r7 = r6.getView();
    L18:
        if (r7 != null) goto L20;
        Q.INSTANCE.uploadLog("uiModule.parent.view is null " + Reflection.getOrCreateKotlinClass(r5.getClass()).getSimpleName());
    L20:
        QUIModule r8 = r5.getParent();
        Intrinsics.checkNotNull(r8);
        View r9 = r8.getView();
        Intrinsics.checkNotNull(r9);
        ViewGroup r10 = (ViewGroup) r9.findViewById(r5.getParentId$omvvm_core_release());
    L25:
        if (r10 != null) goto L29;
        Q.INSTANCE.uploadLog("uiModule.view.parent is null " + Reflection.getOrCreateKotlinClass(r5.getClass()).getSimpleName());
        return;
    L29:
        if (r5.getParams$omvvm_core_release() == null) goto L42;
        r10.addView(r5.getView(), r5.getParams$omvvm_core_release());
        return;
    L42:
        r10.addView(r5.getView());     // Catch: StackOverflowError -> L33
        return;
    L33:
        e = move-exception;
        Q r0 = Q.INSTANCE;
        StringBuilder r2 = new StringBuilder("add view error: uiModule[").append(r5.getModuleKey()).append('@');
        QUIModule r3 = r5.getUiManager().rootUIModule;
        if (r3 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("rootUIModule");
    L38:
        r0.uploadLog(r2.append(r1.getModuleKey()).append("]/ ").append(r5.getView()).append(", error: ").append(e.getMessage()).toString());
        if (Q.INSTANCE.fixModuleViewAddError() == true) goto L44;
        throw e;
    L44:
        return;
    L37:
        r1 = r3;
        goto L38
    L17:
        r7 = null;
        goto L18
    L21:
        QUIModule r11 = r5.getParent();
        Intrinsics.checkNotNull(r11);
        View r12 = r11.getView();
        if ((r12 instanceof ViewGroup) == false) goto L24;
        r10 = (ViewGroup) r12;
        goto L25
    L24:
        r10 = null;
        goto L25
    }

    private final void subVisible(QUIModule r4) {
        boolean r1 = true;
        if (r4.getView() != null) goto L5;
        buildSub(r4, true);
    L7:
        if (r4.groupId().length() > 0) goto L10;
        r1 = false;
    L10:
        if (r1 == false) goto L13;
        group(r4).add(r4);
        return;
    L13:
        return;
    L5:
        moduleVisibility(r4, 0);
        goto L7
    }

    private final void buildSub(QUIModule r3, boolean r4) {
        if (r3.visibility(r3.getModel$omvvm_core_release()) != 8) goto L5;
        if (r4 == true) goto L5;
        return;
    L5:
        r3.setView(createView(r3));
        if (r3.getSubModules() == null) goto L11;
        List<QUIModule> r5 = r3.getSubModules();
        Intrinsics.checkNotNull(r5);
        Iterator<QUIModule> r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L11;
        buildSub(r6.next(), false);
    L11:
        moduleCreated(r3, 0);
    }

    protected final View createView(final QUIModule r9) {
        Intrinsics.checkNotNullParameter(r9, "uiModule");
        final long r0 = System.currentTimeMillis();
        QInsight.INSTANCE.runIfEnabled(new C03961(this, r9));
        if (this.DEBUG_TRACE == false) goto L5;
        Trace.beginSection("onCreateView:" + r9.getClass().getSimpleName());
    L5:
        Pair r2 = recordTime(new C03972(r9, this));
        View r3 = (View) r2.component1();
        Long r4 = (Long) r2.component2();
        if (r4 == null) goto L9;
        this.moduleCreatedTimeRecord.put(r9.moduleName(), Long.valueOf(r4.longValue()));
    L9:
        if (this.DEBUG_TRACE == false) goto L12;
        Trace.endSection();
    L12:
        if ((r3 instanceof ViewStub) == false) goto L17;
        QUtils r5 = QUtils.INSTANCE;
        ViewStub r6 = (ViewStub) r3;
        QUIModule r7 = r9.getParent();
        Intrinsics.checkNotNull(r7);
        ViewGroup r8 = (ViewGroup) r7.getView();
        View r10 = this.rootView;
        if (r10 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        r10 = null;
    L16:
        Context r11 = r10.getContext();
        Intrinsics.checkNotNullExpressionValue(r11, "rootView.context");
        r5.inflateViewStub(r6, r8, r11);
    L17:
        QInsight.INSTANCE.runIfEnabled(new AnonymousClass4(this, r9, r0));
        return r3;
    }

    public final void addBindFinishListener(QIManagerBindListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        CopyOnWriteArrayList<QIManagerBindListener> r1 = this.bindFinishListeners;
        if (r1 == null) goto L6;
        r1.add(r2);
        return;
    }

    public final boolean containsBindFinishListener(QIManagerBindListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        return this.bindFinishListeners.contains(r2);
    }

    public final void removeBindFinishListener(QIManagerBindListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        CopyOnWriteArrayList<QIManagerBindListener> r1 = this.bindFinishListeners;
        if (r1 == null) goto L6;
        r1.remove(r2);
        return;
    }

    private final void notifyAllModuleVisibilityChanged() {
        getWork().post(new C04051(this));
    }

    private final <T> Pair<T, Long> recordTime(Function0<? extends T> r5) {
        IQIManagerPrefMonitor r4 = this.prefMonitor;
        Long r0 = null;
        if (r4 != null) goto L5;
    L10:
        Long r6 = null;
    L11:
        T r7 = r5.invoke();
        if (r6 == null) goto L15;
        r0 = Long.valueOf(System.nanoTime() - r6.longValue());
    L15:
        return TuplesKt.to(r7, r0);
    L5:
        if (r4.shouldSample() == true) goto L8;
        r4 = null;
    L8:
        if (r4 == null) goto L10;
        r6 = Long.valueOf(System.nanoTime());
        goto L11
    }
}
