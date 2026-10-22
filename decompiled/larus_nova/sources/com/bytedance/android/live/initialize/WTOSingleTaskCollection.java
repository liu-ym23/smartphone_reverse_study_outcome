package com.bytedance.android.live.initialize;

import com.bytedance.android.live.initialize.model.WTOTaskProxy;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import jc1.e;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/initialize/WTOSingleTaskCollection;", "", "()V", "TASK_COLLECTION_NAME", "", "singleTask2Proxy", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/android/live/initialize/IWTOTask;", "Lcom/bytedance/android/live/initialize/model/WTOTaskProxy;", "getSingleTask2Proxy$live_initialize_scheduler_saasRelease", "()Ljava/util/concurrent/ConcurrentHashMap;", "singleTasks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "collectAutoRegisterTask", "", "getSingleTasks", "", "live-initialize-scheduler_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WTOSingleTaskCollection {
    public static final WTOSingleTaskCollection INSTANCE = null;
    private static final String TASK_COLLECTION_NAME = "com.bytedance.android.livesdk.InitializeTaskCollection";
    private static final ConcurrentHashMap<IWTOTask, WTOTaskProxy> singleTask2Proxy = null;
    private static final CopyOnWriteArrayList<IWTOTask> singleTasks = null;

    private WTOSingleTaskCollection() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        WTOSingleTaskCollection r100 = new WTOSingleTaskCollection();
        INSTANCE = r100;
        CopyOnWriteArrayList<IWTOTask> r101 = new CopyOnWriteArrayList();
        singleTasks = r101;
        singleTask2Proxy = new ConcurrentHashMap();
        r100.collectAutoRegisterTask();
        CollectionsKt.removeAll(r101, AnonymousClass1.INSTANCE);
        Iterator<T> r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        IWTOTask r103 = (IWTOTask) r102.next();
        singleTask2Proxy.put(r103, new WTOTaskProxy(r103));
        goto L4
    }

    private final void collectAutoRegisterTask() {
        int r100 = e.f498076a;     // Catch: Throwable -> L4
        Class r101 = INVOKESTATIC_com_bytedance_android_live_initialize_WTOSingleTaskCollection_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(TASK_COLLECTION_NAME);     // Catch: Throwable -> L4
        Object r102 = r101.getField("INSTANCE").get(null);     // Catch: Throwable -> L4
        r101.getDeclaredMethod("collectionTasks", new Class[]{CopyOnWriteArrayList.class}).invoke(r102, new Object[]{singleTasks});     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        ya0.a.b("collection task error", th);
        throw th;
    }

    public final ConcurrentHashMap<IWTOTask, WTOTaskProxy> getSingleTask2Proxy$live_initialize_scheduler_saasRelease() {
        return singleTask2Proxy;
    }

    public final List<IWTOTask> getSingleTasks() {
        return singleTasks;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_android_live_initialize_WTOSingleTaskCollection_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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
}
