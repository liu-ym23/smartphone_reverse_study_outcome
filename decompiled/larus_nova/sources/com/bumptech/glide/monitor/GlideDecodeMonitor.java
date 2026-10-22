package com.bumptech.glide.monitor;

import com.bumptech.glide.IGlideDependency;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.GlideCommonUtils;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.lark.log.Log;
import java.nio.ByteBuffer;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JB\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0012H\u0007J\u0017\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bumptech/glide/monitor/GlideDecodeMonitor;", "", "<init>", "()V", "TAG", "", "EVENT_KEY_DECODE_DEV", "FILE_SIZE_UNITY", "", "dependency", "Lcom/bumptech/glide/IGlideDependency;", "onDecodeFinish", "", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "data", "Ljava/nio/ByteBuffer;", "requestedResolution", "Lkotlin/Pair;", "", "resource", "Lcom/bumptech/glide/load/engine/Resource;", WiseOpenHianalyticsData.UNION_COSTTIME, "formatSize", "input", "(Ljava/lang/Integer;)F", "DecodeInfo", "lark-glide_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GlideDecodeMonitor {
    private static final String EVENT_KEY_DECODE_DEV = "image_load_sdk_decode_dev";
    private static final float FILE_SIZE_UNITY = 1024.0f;
    public static final GlideDecodeMonitor INSTANCE = null;
    private static final String TAG = "GlideDecodeMonitor";
    private static final IGlideDependency dependency = null;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010,\u001a\u00020-H\u0002J\u0006\u0010.\u001a\u00020/R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0015R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u001e\"\u0004\b)\u0010 R\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001b\"\u0004\b+\u0010\u001d¨\u00060"}, d2 = {"Lcom/bumptech/glide/monitor/GlideDecodeMonitor$DecodeInfo;", "", "key", "", "scene", "modelType", "fileSize", "", "isOpenEncrypt", "", "fileHeader", "requestedResolution", WiseOpenHianalyticsData.UNION_COSTTIME, "", "isSuccess", "memorySize", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FZLjava/lang/String;Ljava/lang/String;IZF)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "getScene", "setScene", "getModelType", "setModelType", "getFileSize", "()F", "setFileSize", "(F)V", "()Z", "setOpenEncrypt", "(Z)V", "getFileHeader", "setFileHeader", "getRequestedResolution", "setRequestedResolution", "getCostTime", "()I", "setCostTime", "(I)V", "setSuccess", "getMemorySize", "setMemorySize", "toJson", "Lorg/json/JSONObject;", "report", "", "lark-glide_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DecodeInfo {
        private int costTime;
        private String fileHeader;
        private float fileSize;
        private boolean isOpenEncrypt;
        private boolean isSuccess;
        private String key;
        private float memorySize;
        private String modelType;
        private String requestedResolution;
        private String scene;

        public DecodeInfo() {
            this(null, null, null, 0.0f, false, null, null, 0, false, 0.0f, 1023, null);
        }

        private final JSONObject toJson() {
            JSONObject r100 = new JSONObject();
            JSONObject r101 = r100.put("key", this.key).put("scene", this.scene).put(AdDownloadModel.JsonKey.MODEL_TYPE, this.modelType).put("size", Float.valueOf(this.fileSize));     // Catch: Exception -> L13
            int r102 = 1;
            if (this.isOpenEncrypt == false) goto L6;
            int r103 = 1;
        L7:
            JSONObject r104 = r101.put("is_open_encrypt", r103).put("file_header", this.fileHeader).put("requested_resolution", this.requestedResolution).put(HiAnalyticsConstant.BI_KEY_COST_TIME, this.costTime);     // Catch: Exception -> L13
            if (this.isSuccess == true) goto L11;
            r102 = 0;
        L11:
            r104.put("is_success", r102).put("memory_size", Float.valueOf(this.memorySize));     // Catch: Exception -> L13
        L14:
            return r100;
        L6:
            r103 = 0;
        L13:
            Log.e(GlideDecodeMonitor.TAG, "to json failed");
            goto L14
        }

        public final void report() {
            IGlideDependency r100 = GlideDecodeMonitor.access$getDependency$p();
            if (r100 == null) goto L6;
            r100.report(GlideDecodeMonitor.EVENT_KEY_DECODE_DEV, toJson());
            return;
        }

        public final int getCostTime() {
            return this.costTime;
        }

        public final String getFileHeader() {
            return this.fileHeader;
        }

        public final float getFileSize() {
            return this.fileSize;
        }

        public final String getKey() {
            return this.key;
        }

        public final float getMemorySize() {
            return this.memorySize;
        }

        public final String getModelType() {
            return this.modelType;
        }

        public final String getRequestedResolution() {
            return this.requestedResolution;
        }

        public final String getScene() {
            return this.scene;
        }

        public final boolean isOpenEncrypt() {
            return this.isOpenEncrypt;
        }

        public final boolean isSuccess() {
            return this.isSuccess;
        }

        public final void setCostTime(int r100) {
            this.costTime = r100;
        }

        public final void setFileHeader(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.fileHeader = r100;
        }

        public final void setFileSize(float r100) {
            this.fileSize = r100;
        }

        public final void setKey(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.key = r100;
        }

        public final void setMemorySize(float r100) {
            this.memorySize = r100;
        }

        public final void setModelType(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.modelType = r100;
        }

        public final void setOpenEncrypt(boolean r100) {
            this.isOpenEncrypt = r100;
        }

        public final void setRequestedResolution(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.requestedResolution = r100;
        }

        public final void setScene(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.scene = r100;
        }

        public final void setSuccess(boolean r100) {
            this.isSuccess = r100;
        }

        public DecodeInfo(String r100, String r101, String r102, float r103, boolean r104, String r105, String r106, int r107, boolean r110, float r111) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "scene");
            Intrinsics.checkNotNullParameter(r102, "modelType");
            Intrinsics.checkNotNullParameter(r105, "fileHeader");
            Intrinsics.checkNotNullParameter(r106, "requestedResolution");
            this.key = r100;
            this.scene = r101;
            this.modelType = r102;
            this.fileSize = r103;
            this.isOpenEncrypt = r104;
            this.fileHeader = r105;
            this.requestedResolution = r106;
            this.costTime = r107;
            this.isSuccess = r110;
            this.memorySize = r111;
        }

        public /* synthetic */ DecodeInfo(String r110, String r111, String r112, float r113, boolean r114, String r115, String r116, int r117, boolean r210, float r211, int r212, DefaultConstructorMarker r213) {
            String r100 = "";
            if ((r212 & 1) == 0) goto L5;
            String r101 = "";
        L7:
            if ((r212 & 2) == 0) goto L9;
            String r102 = "";
        L11:
            if ((r212 & 4) == 0) goto L13;
            String r103 = "";
        L14:
            float r104 = 0.0f;
            if ((r212 & 8) == 0) goto L17;
            float r105 = 0.0f;
        L18:
            int r106 = 0;
            if ((r212 & 16) == 0) goto L21;
            boolean r107 = false;
        L23:
            if ((r212 & 32) == 0) goto L25;
            String r108 = "";
        L27:
            if ((r212 & 64) != 0) goto L31;
            r100 = r116;
        L31:
            if ((r212 & 128) != 0) goto L35;
            r106 = r117;
        L35:
            if ((r212 & 256) == 0) goto L37;
            boolean r118 = true;
        L39:
            if ((r212 & 512) != 0) goto L42;
            r104 = r211;
        L42:
            this(r101, r102, r103, r105, r107, r108, r100, r106, r118, r104);
            return;
        L37:
            r118 = r210;
            goto L39
        L25:
            r108 = r115;
            goto L27
        L21:
            r107 = r114;
            goto L23
        L17:
            r105 = r113;
            goto L18
        L13:
            r103 = r112;
            goto L14
        L9:
            r102 = r111;
            goto L11
        L5:
            r101 = r110;
            goto L7
        }
    }

    private GlideDecodeMonitor() {
    }

    static {
        INSTANCE = new GlideDecodeMonitor();
        dependency = GlideCommonUtils.getDependency();
    }

    public static final /* synthetic */ IGlideDependency access$getDependency$p() {
        return dependency;
    }

    private final float formatSize(Integer r100) {
        if (r100 != null) goto L10;
        int r101 = 0;
    L6:
        float r102 = r101 / FILE_SIZE_UNITY;     // Catch: Exception -> L8
        StringCompanionObject r103 = StringCompanionObject.INSTANCE;     // Catch: Exception -> L8
        return CastFloatProtector.parseFloat(String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(r102)}, 1)));
    L8:
        Log.e(TAG, "formatSize failed");
        return 0.0f;
    L10:
        r101 = r100.intValue();     // Catch: Exception -> L8
        goto L6
    }

    @JvmStatic
    public static final void onDecodeFinish(Object r210, ByteBuffer r211, Pair<Integer, Integer> r212, Resource<?> r213, int r214) {
        Intrinsics.checkNotNullParameter(r210, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r211, "data");
        Intrinsics.checkNotNullParameter(r212, "requestedResolution");
        GlideDecodeMonitor r100 = INSTANCE;
        float r101 = r100.formatSize(Integer.valueOf(r211.limit()));
        GlideLoadCostMonitor.onGetData(r210, r101);
        if (r213 == null) goto L5;
        Integer r102 = Integer.valueOf(r213.getSize());
    L6:
        float r103 = r100.formatSize(r102);
        boolean r104 = false;
        if (r213 == null) goto L9;
        boolean r105 = true;
    L11:
        if (r101 <= GlideMonitorSettings.getMonitor().getBigImageSize()) goto L13;
    L18:
        DecodeInfo r106 = new DecodeInfo(null, null, null, 0.0f, false, null, null, 0, false, 0.0f, 1023, null);
        r106.setKey(r210.toString());
        IGlideDependency r107 = dependency;
        String r110 = "";
        if (r107 == null) goto L22;
        String r111 = r107.getCurrentScene();
        if (r111 == null) goto L22;
    L23:
        r106.setScene(r111);
        r106.setModelType(r210.getClass().getSimpleName());
        r106.setFileSize(r101);
        if (r107 == null) goto L26;
        r104 = r107.isOpenEncrypt();
    L26:
        r106.setOpenEncrypt(r104);
        if (r107 == null) goto L32;
        String r108 = r107.getFileHeader(r211);
        if (r108 == null) goto L32;
        r110 = r108;
    L32:
        r106.setFileHeader(r110);
        StringBuilder r109 = new StringBuilder();
        r109.append(r212.getFirst().intValue());
        r109.append('*');
        r109.append(r212.getSecond().intValue());
        r106.setRequestedResolution(r109.toString());
        r106.setCostTime(r214);
        r106.setSuccess(r105);
        r106.setMemorySize(r103);
        r106.report();
        return;
    L22:
        r111 = "";
        goto L23
    L13:
        if (r103 > GlideMonitorSettings.getMonitor().getBigImageSize()) goto L18;
        if (r214 > GlideMonitorSettings.getMonitor().getDecodeTimeOut()) goto L18;
        if (r105 == false) goto L18;
        return;
    L9:
        r105 = false;
        goto L11
    L5:
        r102 = null;
        goto L6
    }
}
