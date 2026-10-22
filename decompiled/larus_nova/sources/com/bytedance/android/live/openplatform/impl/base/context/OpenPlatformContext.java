package com.bytedance.android.live.openplatform.impl.base.context;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.live.openplatform.impl.base.utils.a;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import ro0.b;
import vlc.d;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u00103\u001a\u000202\u0012\b\u00108\u001a\u0004\u0018\u000107¢\u0006\u0004\b@\u0010AJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0014J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\b\u0010\n\u001a\u00020\u0005H\u0014J\b\u0010\u000b\u001a\u00020\u0005H\u0014J%\u0010\u0010\u001a\u00028\u0000\"\b\b\u0000\u0010\r*\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\t\u0010\u0014\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0096\u0001J\r\u0010\u0018\u001a\u00020\u0005*\u00020\u0015H\u0096\u0001R$\u0010\u001a\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\f0\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001b\u0010!\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010#\u001a\u00020\"8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0019\u0010(\u001a\u0004\u0018\u00010'8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R$\u0010,\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0017\u00103\u001a\u0002028\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0019\u00108\u001a\u0004\u0018\u0001078\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0014\u0010=\u001a\u00020<8&X¦\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0014\u0010?\u001a\u00020<8&X¦\u0004¢\u0006\u0006\u001a\u0004\b?\u0010>¨\u0006B"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "", "Lro0/a;", "manager", "", "onMessageManagerInitialized", "Landroidx/lifecycle/Lifecycle$Event;", "event", "dispatchLifecycleEvent", WidgetCostModule.TYPE_ON_CREATE, LiveCommonConstants.REASON_ON_DEDTROY, "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "serviceClass", "getService", "(Ljava/lang/Class;)Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Landroidx/lifecycle/Lifecycle;", "getLifecycleCompat", "dispose", "Lio/reactivex/disposables/Disposable;", "d", "remove", "autoDispose", "", "serviceMap", "Ljava/util/Map;", "Landroidx/lifecycle/LifecycleRegistry;", "_lifecycle$delegate", "Lkotlin/Lazy;", "get_lifecycle", "()Landroidx/lifecycle/LifecycleRegistry;", "_lifecycle", "", "roomId", "J", "getRoomId", "()J", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "getRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "messageManager", "Lro0/a;", "getMessageManager", "()Lro0/a;", "setMessageManager", "(Lro0/a;)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "", "isAnchor", "()Z", "isInLive", "<init>", "(Landroid/content/Context;Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class OpenPlatformContext implements LifecycleOwnerCompat {
    private final /* synthetic */ a $$delegate_0;
    private final Lazy _lifecycle$delegate;
    private final Context context;
    private final DataCenter dataCenter;
    private ro0.a messageManager;
    private final Room room;
    private final long roomId;
    private final Map<Class<?>, OpenPlatformContextService> serviceMap;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private final LifecycleRegistry get_lifecycle() {
        return (LifecycleRegistry) this._lifecycle$delegate.getValue();
    }

    public void autoDispose(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$autoDispose");
        this.$$delegate_0.a(r100);
    }

    public void dispose() {
        this.$$delegate_0.b();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.CC.$default$getLifecycle(this);
    }

    public abstract boolean isAnchor();

    public abstract boolean isInLive();

    public void onCreate() {
    }

    public void onMessageManagerInitialized(ro0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
    }

    public void remove(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "d");
        this.$$delegate_0.c(r100);
    }

    @Override // com.bytedance.android.livesdk.utils.LifecycleOwnerCompat
    public Lifecycle getLifecycleCompat() {
        return get_lifecycle();
    }

    public void onDestroy() {
        dispose();
        this.serviceMap.clear();
        ro0.a r100 = this.messageManager;
        if (r100 == null) goto L17;
        Iterator<b<?>> r101 = r100.f538749a.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        b<?> r102 = r101.next();
        r102.f538753c.b();
        d r103 = r100.f538750b;
        if (r103 == null) goto L6;
        r103.removeMessageListener(r102.f538751a);
        goto L6
    L10:
        r100.f538749a.clear();
        return;
    }

    public final Context getContext() {
        return this.context;
    }

    public final DataCenter getDataCenter() {
        return this.dataCenter;
    }

    public final ro0.a getMessageManager() {
        return this.messageManager;
    }

    public final Room getRoom() {
        return this.room;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_android_live_openplatform_impl_base_context_OpenPlatformContext_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public final void dispatchLifecycleEvent(Lifecycle.Event r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        get_lifecycle().handleLifecycleEvent(r100);
        if (r100 != Lifecycle.Event.ON_CREATE) goto L6;
        onCreate();
    L6:
        if (r100 != Lifecycle.Event.ON_DESTROY) goto L9;
        onDestroy();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Class, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.Class] */
    public final <T extends OpenPlatformContextService> T getService(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "serviceClass");
        Map<Class<?>, OpenPlatformContextService> r101 = this.serviceMap;
        monitor-enter(r101);
        Annotation[] r102 = r100.getAnnotations();     // Catch: Throwable -> L32
        int r103 = r102.length;     // Catch: Throwable -> L32
    L5:
        r103 = r103 - 1;     // Catch: Throwable -> L32
        if (r103 < 0) goto L10;
        Annotation r104 = r102[r103];     // Catch: Throwable -> L32
        if ((r104 instanceof ContextServiceImpl) == false) goto L5;
    L11:
        if (r104 != null) goto L13;
    L22:
        T r105 = (T) this.serviceMap.get(r100);     // Catch: Throwable -> L32
        if (r105 != null) goto L28;
        Object r106 = r100.getConstructor(new Class[]{OpenPlatformContext.class}).newInstance(new Object[]{this});     // Catch: Throwable -> L32
        if (r106 == null) goto L31;
        r105 = (T) r106;     // Catch: Throwable -> L32
        this.serviceMap.put((Class<?>) r100, r105);     // Catch: Throwable -> L32
        r105.init$liveopenplatform_impl_saasRelease();     // Catch: Throwable -> L32
        goto L28
    L31:
        throw new NullPointerException("null cannot be cast to non-null type T");     // Catch: Throwable -> L32
    L28:
        monitor-exit(r101);
        return r105;
    L13:
        if ((r104 instanceof ContextServiceImpl) == false) goto L22;
        if (isAnchor() == true) goto L17;
        String r107 = ((ContextServiceImpl) r104).audienceService();     // Catch: Throwable -> L32
    L21:
        r100 = (Class<T>) INVOKESTATIC_com_bytedance_android_live_openplatform_impl_base_context_OpenPlatformContext_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r107);
        goto L22
    L17:
        if (isInLive() == false) goto L19;
        r107 = ((ContextServiceImpl) r104).liveAnchorService();     // Catch: Throwable -> L32
        goto L21
    L19:
        r107 = ((ContextServiceImpl) r104).previewAnchorService();     // Catch: Throwable -> L32
        goto L21
    L10:
        r104 = null;
    L32:
        th = move-exception;
        throw th;
    }

    public final void setMessageManager(ro0.a r100) {
        this.messageManager = r100;
    }

    public OpenPlatformContext(Context r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.$$delegate_0 = new a();
        this.context = r100;
        this.dataCenter = r101;
        this.serviceMap = new HashMap();
        this._lifecycle$delegate = LazyKt.lazy(new OpenPlatformContext$_lifecycle$2(this));
        RoomContext.a r102 = RoomContext.Companion;
        RoomContext r103 = RoomContext.a.c(r102, r101, 0, 2);
        if (r103 == null) goto L9;
        m<Room> r104 = r103.getRoom();
        if (r104 == null) goto L9;
        Room r105 = r104.getValue();
        if (r105 == null) goto L9;
        long r106 = r105.getRoomId();
    L10:
        this.roomId = r106;
        RoomContext r107 = RoomContext.a.c(r102, r101, 0, 2);
        if (r107 == null) goto L15;
        m<Room> r108 = r107.getRoom();
        if (r108 == null) goto L15;
        Room r109 = r108.getValue();
    L16:
        this.room = r109;
        RoomContext r110 = RoomContext.a.c(r102, r101, 0, 2);
        if (r110 == null) goto L22;
        j<d> r111 = r110.getMessageManager();
        if (r111 == null) goto L23;
        r111.c(new AnonymousClass1(this));
        return;
    L23:
        return;
    L22:
        return;
    L15:
        r109 = null;
    L9:
        r106 = 0;
        goto L10
    }
}
