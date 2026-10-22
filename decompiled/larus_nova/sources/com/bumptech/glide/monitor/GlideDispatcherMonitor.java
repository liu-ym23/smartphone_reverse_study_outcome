package com.bumptech.glide.monitor;

import com.bumptech.glide.IGlideDependency;
import com.bumptech.glide.util.GlideCommonUtils;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.ss.android.lark.inv.export.router.InvRouter;
import com.ss.android.lark.log.Log;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Metadata;
import kotlin.collections.GroupingKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000bH\u0007J\u001a\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0007J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000bH\u0007J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bumptech/glide/monitor/GlideDispatcherMonitor;", "", "<init>", "()V", "TAG", "", "EVENT_KEY_DISPATCHER_DEV", "dependency", "Lcom/bumptech/glide/IGlideDependency;", "dispatcherInfo", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ThreadPoolExecutor;", "Lcom/bumptech/glide/monitor/GlideDispatcherMonitor$DispatcherInfo;", MiPushClient.COMMAND_REGISTER, "", "name", "executor", "onEnqueue", "loadModel", "onDequeue", "refreshDispatcherInfo", "waitSize", "", "info", "DispatcherInfo", "lark-glide_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GlideDispatcherMonitor {
    private static final String EVENT_KEY_DISPATCHER_DEV = "image_load_sdk_dispatcher_dev";
    public static final GlideDispatcherMonitor INSTANCE = null;
    private static final String TAG = "GlideDispatcherMonitor";
    private static final IGlideDependency dependency = null;
    private static final ConcurrentHashMap<ThreadPoolExecutor, DispatcherInfo> dispatcherInfo = null;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001Bm\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\r¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010*\u001a\u00020\u0005H\u0002J\b\u0010+\u001a\u00020\u0003H\u0002J\b\u0010,\u001a\u00020\u0003H\u0002J\b\u0010-\u001a\u00020.H\u0002J\u0006\u0010/\u001a\u000200J\u0006\u00101\u001a\u000200R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\n\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0016\"\u0004\b#\u0010\u0018R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010%\"\u0004\b)\u0010'¨\u00062"}, d2 = {"Lcom/bumptech/glide/monitor/GlideDispatcherMonitor$DispatcherInfo;", "", "name", "", "corePoolSize", "", "maximumPoolSize", "maxWaitSize", "waitStart", "", "waitEnd", "isWeakNet", InvRouter.SCENES, "Ljava/util/concurrent/CopyOnWriteArrayList;", "modelTypes", "<init>", "(Ljava/lang/String;IIIJJILjava/util/concurrent/CopyOnWriteArrayList;Ljava/util/concurrent/CopyOnWriteArrayList;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getCorePoolSize", "()I", "setCorePoolSize", "(I)V", "getMaximumPoolSize", "setMaximumPoolSize", "getMaxWaitSize", "setMaxWaitSize", "getWaitStart", "()J", "setWaitStart", "(J)V", "getWaitEnd", "setWaitEnd", "setWeakNet", "getScenes", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "setScenes", "(Ljava/util/concurrent/CopyOnWriteArrayList;)V", "getModelTypes", "setModelTypes", "getWaitDuration", "getMajorScene", "getMajorModelType", "toJson", "Lorg/json/JSONObject;", "report", "", BasicTestActionHandler.TEST_ACTION_RESET, "lark-glide_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DispatcherInfo {
        private int corePoolSize;
        private int isWeakNet;
        private int maxWaitSize;
        private int maximumPoolSize;
        private CopyOnWriteArrayList<String> modelTypes;
        private String name;
        private CopyOnWriteArrayList<String> scenes;
        private long waitEnd;
        private long waitStart;

        public DispatcherInfo() {
            this(null, 0, 0, 0, 0, 0, 0, null, null, 511, null);
        }

        public final void reset() {
            this.maxWaitSize = 0;
            this.waitStart = 0;
            this.waitEnd = 0;
            this.isWeakNet = 0;
            this.scenes.clear();
            this.modelTypes.clear();
        }

        private final String getMajorModelType() {
            final CopyOnWriteArrayList<String> r100 = this.modelTypes;
            Iterator r101 = GroupingKt.eachCount(new GlideDispatcherMonitor$DispatcherInfo$getMajorModelType$$inlined$groupingBy$1(r100)).entrySet().iterator();
            if (r101.hasNext() == true) goto L5;
            Object r102 = null;
        L15:
            Map.Entry r103 = (Map.Entry) r102;
            if (r103 == null) goto L19;
            String r104 = (String) r103.getKey();
            if (r104 == null) goto L19;
            return r104;
        L19:
            return "";
        L5:
            Object r105 = r101.next();
            if (r101.hasNext() == true) goto L8;
        L7:
            r102 = r105;
            goto L15
        L8:
            int r106 = ((Number) ((Map.Entry) r105).getValue()).intValue();
        L9:
            Object r107 = r101.next();
            int r108 = ((Number) ((Map.Entry) r107).getValue()).intValue();
            if (r106 >= r108) goto L13;
            r105 = r107;
            r106 = r108;
        L13:
            if (r101.hasNext() == true) goto L9;
            goto L7
        }

        private final String getMajorScene() {
            final CopyOnWriteArrayList<String> r100 = this.scenes;
            Iterator r101 = GroupingKt.eachCount(new GlideDispatcherMonitor$DispatcherInfo$getMajorScene$$inlined$groupingBy$1(r100)).entrySet().iterator();
            if (r101.hasNext() == true) goto L5;
            Object r102 = null;
        L15:
            Map.Entry r103 = (Map.Entry) r102;
            if (r103 == null) goto L19;
            String r104 = (String) r103.getKey();
            if (r104 == null) goto L19;
            return r104;
        L19:
            return "";
        L5:
            Object r105 = r101.next();
            if (r101.hasNext() == true) goto L8;
        L7:
            r102 = r105;
            goto L15
        L8:
            int r106 = ((Number) ((Map.Entry) r105).getValue()).intValue();
        L9:
            Object r107 = r101.next();
            int r108 = ((Number) ((Map.Entry) r107).getValue()).intValue();
            if (r106 >= r108) goto L13;
            r105 = r107;
            r106 = r108;
        L13:
            if (r101.hasNext() == true) goto L9;
            goto L7
        }

        private final int getWaitDuration() {
            return (int) (this.waitEnd - this.waitStart);
        }

        private final JSONObject toJson() {
            JSONObject r100 = new JSONObject();
            r100.put("name", this.name).put("core_size", this.corePoolSize).put("max_pool_size", this.maximumPoolSize).put("max_wait_size", this.maxWaitSize).put("wait_duration", getWaitDuration()).put("is_weak_net", this.isWeakNet).put("major_scene", getMajorScene()).put("major_model_type", getMajorModelType());     // Catch: Exception -> L5
        L6:
            return r100;
        L5:
            Log.e(GlideDispatcherMonitor.TAG, "to json failed");
            goto L6
        }

        public final void report() {
            if (getWaitDuration() <= GlideMonitorSettings.getMonitor().getDispatcherTimeOut()) goto L8;
            IGlideDependency r100 = GlideDispatcherMonitor.access$getDependency$p();
            if (r100 == null) goto L9;
            r100.report(GlideDispatcherMonitor.EVENT_KEY_DISPATCHER_DEV, toJson());
            return;
        L9:
            return;
        }

        public final int getCorePoolSize() {
            return this.corePoolSize;
        }

        public final int getMaxWaitSize() {
            return this.maxWaitSize;
        }

        public final int getMaximumPoolSize() {
            return this.maximumPoolSize;
        }

        public final CopyOnWriteArrayList<String> getModelTypes() {
            return this.modelTypes;
        }

        public final String getName() {
            return this.name;
        }

        public final CopyOnWriteArrayList<String> getScenes() {
            return this.scenes;
        }

        public final long getWaitEnd() {
            return this.waitEnd;
        }

        public final long getWaitStart() {
            return this.waitStart;
        }

        public final int isWeakNet() {
            return this.isWeakNet;
        }

        public final void setCorePoolSize(int r100) {
            this.corePoolSize = r100;
        }

        public final void setMaxWaitSize(int r100) {
            this.maxWaitSize = r100;
        }

        public final void setMaximumPoolSize(int r100) {
            this.maximumPoolSize = r100;
        }

        public final void setModelTypes(CopyOnWriteArrayList<String> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.modelTypes = r100;
        }

        public final void setName(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.name = r100;
        }

        public final void setScenes(CopyOnWriteArrayList<String> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.scenes = r100;
        }

        public final void setWaitEnd(long r100) {
            this.waitEnd = r100;
        }

        public final void setWaitStart(long r100) {
            this.waitStart = r100;
        }

        public final void setWeakNet(int r100) {
            this.isWeakNet = r100;
        }

        public DispatcherInfo(String r100, int r101, int r102, int r103, long r104, long r105, int r110, CopyOnWriteArrayList<String> r111, CopyOnWriteArrayList<String> r112) {
            Intrinsics.checkNotNullParameter(r100, "name");
            Intrinsics.checkNotNullParameter(r111, InvRouter.SCENES);
            Intrinsics.checkNotNullParameter(r112, "modelTypes");
            this.name = r100;
            this.corePoolSize = r101;
            this.maximumPoolSize = r102;
            this.maxWaitSize = r103;
            this.waitStart = r104;
            this.waitEnd = r105;
            this.isWeakNet = r110;
            this.scenes = r111;
            this.modelTypes = r112;
        }

        public /* synthetic */ DispatcherInfo(String r110, int r111, int r112, int r113, long r114, long r115, int r210, CopyOnWriteArrayList r211, CopyOnWriteArrayList r212, int r213, DefaultConstructorMarker r214) {
            if ((r213 & 1) == 0) goto L5;
            String r100 = "";
        L6:
            int r101 = 0;
            if ((r213 & 2) == 0) goto L9;
            int r102 = 0;
        L11:
            if ((r213 & 4) == 0) goto L13;
            int r103 = 0;
        L15:
            if ((r213 & 8) == 0) goto L17;
            int r104 = 0;
        L18:
            long r105 = 0;
            if ((r213 & 16) == 0) goto L21;
            long r106 = 0;
        L23:
            if ((r213 & 32) != 0) goto L27;
            r105 = r115;
        L27:
            if ((r213 & 64) != 0) goto L31;
            r101 = r210;
        L31:
            if ((r213 & 128) == 0) goto L33;
            CopyOnWriteArrayList r107 = new CopyOnWriteArrayList();
        L35:
            if ((r213 & 256) == 0) goto L37;
            CopyOnWriteArrayList r108 = new CopyOnWriteArrayList();
        L38:
            this(r100, r102, r103, r104, r106, r105, r101, r107, r108);
            return;
        L37:
            r108 = r212;
            goto L38
        L33:
            r107 = r211;
            goto L35
        L21:
            r106 = r114;
            goto L23
        L17:
            r104 = r113;
            goto L18
        L13:
            r103 = r112;
            goto L15
        L9:
            r102 = r111;
            goto L11
        L5:
            r100 = r110;
            goto L6
        }
    }

    private GlideDispatcherMonitor() {
    }

    static {
        INSTANCE = new GlideDispatcherMonitor();
        dependency = GlideCommonUtils.getDependency();
        dispatcherInfo = new ConcurrentHashMap();
    }

    public static final /* synthetic */ IGlideDependency access$getDependency$p() {
        return dependency;
    }

    @JvmStatic
    public static final void onDequeue(ThreadPoolExecutor r100) {
        Intrinsics.checkNotNullParameter(r100, "executor");
        DispatcherInfo r101 = dispatcherInfo.get(r100);
        if (r101 == null) goto L6;
        INSTANCE.refreshDispatcherInfo(r100.getQueue().size(), r101);
        return;
    }

    @JvmStatic
    public static final void onEnqueue(ThreadPoolExecutor r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "executor");
        DispatcherInfo r102 = dispatcherInfo.get(r100);
        if (r102 == null) goto L14;
        CopyOnWriteArrayList<String> r103 = r102.getScenes();
        IGlideDependency r104 = dependency;
        String r105 = "";
        if (r104 == null) goto L8;
        String r106 = r104.getCurrentScene();
        if (r106 == null) goto L8;
    L9:
        r103.add(r106);
        CopyOnWriteArrayList<String> r107 = r102.getModelTypes();
        if (r101 == null) goto L12;
        r105 = r101.getClass().getSimpleName();
    L12:
        r107.add(r105);
        return;
    L8:
        r106 = "";
        goto L9
    }

    private final void refreshDispatcherInfo(int r100, DispatcherInfo r101) {
        if (r101.getMaxWaitSize() != 0) goto L6;
        if (r100 != 0) goto L6;
        return;
    L6:
        int r102 = 1;
        if (r101.getMaxWaitSize() != 0) goto L10;
        if (r100 <= 0) goto L10;
        boolean r103 = true;
    L12:
        if (r101.getMaxWaitSize() <= 0) goto L15;
        if (r100 != 0) goto L15;
        boolean r104 = true;
    L16:
        r101.setMaxWaitSize(RangesKt.coerceAtLeast(r101.getMaxWaitSize(), r100));
        if (r103 == false) goto L25;
        r101.setWaitStart(System.currentTimeMillis());
        IGlideDependency r105 = dependency;
        if (r105 != null) goto L21;
    L23:
        r102 = 0;
    L24:
        r101.setWeakNet(r102);
        goto L25
    L21:
        if (r105.isWeakNet() != true) goto L23;
    L25:
        if (r104 == false) goto L28;
        r101.setWaitEnd(System.currentTimeMillis());
        r101.report();
        r101.reset();
        return;
    L28:
        return;
    L15:
        r104 = false;
    L10:
        r103 = false;
        goto L12
    }

    @JvmStatic
    public static final void register(String r110, ThreadPoolExecutor r111) {
        Intrinsics.checkNotNullParameter(r110, "name");
        Intrinsics.checkNotNullParameter(r111, "executor");
        dispatcherInfo.put(r111, new DispatcherInfo(r110, r111.getCorePoolSize(), r111.getMaximumPoolSize(), 0, 0, 0, 0, null, null, 504, null));
    }
}
