package com.bumptech.glide.monitor;

import com.bumptech.glide.IGlideDependency;
import com.bumptech.glide.util.GlideCommonUtils;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.lark.log.Log;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0007J\u001a\u0010\u000f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\"\u0010\u0012\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bumptech/glide/monitor/GlideLoadCostMonitor;", "", "<init>", "()V", "TAG", "", "EVENT_KEY_LOAD_COST_DEV", "dependency", "Lcom/bumptech/glide/IGlideDependency;", "costInfo", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bumptech/glide/monitor/GlideLoadCostMonitor$CostInfo;", WidgetCostModule.TYPE_ON_START, "", "loadModel", "onGetData", "size", "", "onEnd", "waitCost", "", "runCost", "CostInfo", "lark-glide_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GlideLoadCostMonitor {
    private static final String EVENT_KEY_LOAD_COST_DEV = "image_load_sdk_load_cost_dev";
    public static final GlideLoadCostMonitor INSTANCE = null;
    private static final String TAG = "GlideLoadCostMonitor";
    private static final ConcurrentHashMap<Object, CostInfo> costInfo = null;
    private static final IGlideDependency dependency = null;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010$\u001a\u00020%H\u0002J\u0006\u0010&\u001a\u00020'R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010!¨\u0006("}, d2 = {"Lcom/bumptech/glide/monitor/GlideLoadCostMonitor$CostInfo;", "", "key", "", "scene", "modelType", "size", "", "isWeakNet", "", "waitCost", "", "runCost", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FZII)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "getScene", "setScene", "getModelType", "setModelType", "getSize", "()F", "setSize", "(F)V", "()Z", "setWeakNet", "(Z)V", "getWaitCost", "()I", "setWaitCost", "(I)V", "getRunCost", "setRunCost", "toJson", "Lorg/json/JSONObject;", "report", "", "lark-glide_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CostInfo {
        private boolean isWeakNet;
        private String key;
        private String modelType;
        private int runCost;
        private String scene;
        private float size;
        private int waitCost;

        public CostInfo() {
            this(null, null, null, 0.0f, false, 0, 0, 127, null);
        }

        private final JSONObject toJson() {
            JSONObject r100 = new JSONObject();
            JSONObject r101 = r100.put("key", this.key).put("scene", this.scene).put(AdDownloadModel.JsonKey.MODEL_TYPE, this.modelType).put("size", Float.valueOf(this.size));     // Catch: Exception -> L9
            if (this.isWeakNet == false) goto L6;
            int r102 = 1;
        L7:
            r101.put("is_weak_net", r102).put("wait_cost", this.waitCost).put("run_cost", this.runCost);     // Catch: Exception -> L9
        L10:
            return r100;
        L6:
            r102 = 0;
        L9:
            Log.e(GlideLoadCostMonitor.TAG, "to json failed");
            goto L10
        }

        public final void report() {
            if ((this.waitCost + this.runCost) <= GlideMonitorSettings.getMonitor().getLoadTimeOut()) goto L8;
            IGlideDependency r100 = GlideLoadCostMonitor.access$getDependency$p();
            if (r100 == null) goto L9;
            r100.report(GlideLoadCostMonitor.EVENT_KEY_LOAD_COST_DEV, toJson());
            return;
        L9:
            return;
        }

        public final String getKey() {
            return this.key;
        }

        public final String getModelType() {
            return this.modelType;
        }

        public final int getRunCost() {
            return this.runCost;
        }

        public final String getScene() {
            return this.scene;
        }

        public final float getSize() {
            return this.size;
        }

        public final int getWaitCost() {
            return this.waitCost;
        }

        public final boolean isWeakNet() {
            return this.isWeakNet;
        }

        public final void setKey(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.key = r100;
        }

        public final void setModelType(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.modelType = r100;
        }

        public final void setRunCost(int r100) {
            this.runCost = r100;
        }

        public final void setScene(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.scene = r100;
        }

        public final void setSize(float r100) {
            this.size = r100;
        }

        public final void setWaitCost(int r100) {
            this.waitCost = r100;
        }

        public final void setWeakNet(boolean r100) {
            this.isWeakNet = r100;
        }

        public CostInfo(String r100, String r101, String r102, float r103, boolean r104, int r105, int r106) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "scene");
            Intrinsics.checkNotNullParameter(r102, "modelType");
            this.key = r100;
            this.scene = r101;
            this.modelType = r102;
            this.size = r103;
            this.isWeakNet = r104;
            this.waitCost = r105;
            this.runCost = r106;
        }

        public /* synthetic */ CostInfo(String r100, String r101, String r102, float r103, boolean r110, int r111, int r112, int r113, DefaultConstructorMarker r114) {
            String r104 = "";
            if ((r113 & 1) == 0) goto L5;
            String r115 = "";
        L7:
            if ((r113 & 2) == 0) goto L9;
            String r105 = "";
        L11:
            if ((r113 & 4) != 0) goto L15;
            r104 = r102;
        L15:
            if ((r113 & 8) == 0) goto L17;
            float r106 = 0.0f;
        L19:
            if ((r113 & 16) == 0) goto L21;
            boolean r107 = false;
        L23:
            if ((r113 & 32) == 0) goto L25;
            int r108 = 0;
        L27:
            if ((r113 & 64) == 0) goto L29;
            int r116 = 0;
        L30:
            this(r115, r105, r104, r106, r107, r108, r116);
            return;
        L29:
            r116 = r112;
            goto L30
        L25:
            r108 = r111;
            goto L27
        L21:
            r107 = r110;
            goto L23
        L17:
            r106 = r103;
            goto L19
        L9:
            r105 = r101;
            goto L11
        L5:
            r115 = r100;
            goto L7
        }
    }

    private GlideLoadCostMonitor() {
    }

    static {
        INSTANCE = new GlideLoadCostMonitor();
        dependency = GlideCommonUtils.getDependency();
        costInfo = new ConcurrentHashMap();
    }

    public static final /* synthetic */ IGlideDependency access$getDependency$p() {
        return dependency;
    }

    @JvmStatic
    public static final void onStart(Object r110) {
        if (r110 == null) goto L14;
        ConcurrentHashMap<Object, CostInfo> r100 = costInfo;
        CostInfo r111 = new CostInfo(null, null, null, 0.0f, false, 0, 0, 127, null);
        r111.setKey(r110.toString());
        IGlideDependency r101 = dependency;
        if (r101 == null) goto L7;
        String r102 = r101.getCurrentScene();
        if (r102 == null) goto L7;
    L8:
        r111.setScene(r102);
        r111.setModelType(r110.getClass().getSimpleName());
        if (r101 == null) goto L11;
        boolean r103 = r101.isWeakNet();
    L12:
        r111.setWeakNet(r103);
        r100.put(r110, r111);
        return;
    L11:
        r103 = false;
    L7:
        r102 = "";
        goto L8
    }

    @JvmStatic
    public static final void onGetData(Object r100, float r101) {
        if (r100 == null) goto L7;
        CostInfo r102 = costInfo.get(r100);
        if (r102 == null) goto L8;
        r102.setSize(r101);
        return;
    L8:
        return;
    }

    @JvmStatic
    public static final void onEnd(Object r100, int r101, int r102) {
        if (r100 == null) goto L7;
        CostInfo r103 = costInfo.remove(r100);
        if (r103 == null) goto L8;
        r103.setWaitCost(r101);
        r103.setRunCost(r102);
        r103.report();
        return;
    L8:
        return;
    }
}
