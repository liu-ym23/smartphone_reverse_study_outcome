package com.bytedance.ai.bridge.system.systemInfo;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.annotations.SerializedName;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.camera_export.CameraParam;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\f\r\u000eB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/bridge/system/systemInfo/AbsGetSystemInfoMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/system/systemInfo/AbsGetSystemInfoMethodIDL$EmptyMessageModel;", "Lcom/bytedance/ai/bridge/system/systemInfo/AbsGetSystemInfoMethodIDL$GetSystemInfoResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mustRunInMain", "", "EmptyMessageModel", "GetSystemInfoResultModel", "SystemInfoSafeArea", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsGetSystemInfoMethodIDL extends CoreAIBridgeMethod<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f36123a;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ai/bridge/system/systemInfo/AbsGetSystemInfoMethodIDL$SystemInfoSafeArea;", "", "left", "", "right", "top", "bottom", "width", "height", "<init>", "(IIIIII)V", "getLeft", "()I", "getRight", "getTop", "getBottom", "getWidth", "getHeight", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SystemInfoSafeArea {

        @SerializedName("bottom")
        private final int bottom;

        @SerializedName("height")
        private final int height;

        @SerializedName("left")
        private final int left;

        @SerializedName("right")
        private final int right;

        @SerializedName("top")
        private final int top;

        @SerializedName("width")
        private final int width;

        public static /* synthetic */ SystemInfoSafeArea copy$default(SystemInfoSafeArea r100, int r101, int r102, int r103, int r104, int r105, int r110, int r111, Object r112) {
            if ((r111 & 1) == 0) goto L6;
            r101 = r100.left;
        L6:
            if ((r111 & 2) == 0) goto L8;
            r102 = r100.right;
        L8:
            int r113 = r102;
            if ((r111 & 4) == 0) goto L11;
            r103 = r100.top;
        L11:
            int r106 = r103;
            if ((r111 & 8) == 0) goto L14;
            r104 = r100.bottom;
        L14:
            int r107 = r104;
            if ((r111 & 16) == 0) goto L17;
            r105 = r100.width;
        L17:
            int r108 = r105;
            if ((r111 & 32) == 0) goto L20;
            r110 = r100.height;
        L20:
            int r109 = r101;
            return r100.copy(r109, r113, r106, r107, r108, r110);
        }

        public final int component1() {
            return this.left;
        }

        public final int component2() {
            return this.right;
        }

        public final int component3() {
            return this.top;
        }

        public final int component4() {
            return this.bottom;
        }

        public final int component5() {
            return this.width;
        }

        public final int component6() {
            return this.height;
        }

        public final SystemInfoSafeArea copy(int r100, int r110, int r111, int r112, int r113, int r114) {
            return new SystemInfoSafeArea(r100, r110, r111, r112, r113, r114);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof SystemInfoSafeArea) == true) goto L8;
            return false;
        L8:
            SystemInfoSafeArea r101 = (SystemInfoSafeArea) r100;
            if (this.left == r101.left) goto L12;
            return false;
        L12:
            if (this.right == r101.right) goto L15;
            return false;
        L15:
            if (this.top == r101.top) goto L18;
            return false;
        L18:
            if (this.bottom == r101.bottom) goto L21;
            return false;
        L21:
            if (this.width == r101.width) goto L24;
            return false;
        L24:
            if (this.height == r101.height) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            return (((((((((this.left * 31) + this.right) * 31) + this.top) * 31) + this.bottom) * 31) + this.width) * 31) + this.height;
        }

        public String toString() {
            return "SystemInfoSafeArea(left=" + this.left + ", right=" + this.right + ", top=" + this.top + ", bottom=" + this.bottom + ", width=" + this.width + ", height=" + this.height + ')';
        }

        public final int getBottom() {
            return this.bottom;
        }

        public final int getHeight() {
            return this.height;
        }

        public final int getLeft() {
            return this.left;
        }

        public final int getRight() {
            return this.right;
        }

        public final int getTop() {
            return this.top;
        }

        public final int getWidth() {
            return this.width;
        }

        public SystemInfoSafeArea(int r100, int r101, int r102, int r103, int r104, int r105) {
            this.left = r100;
            this.right = r101;
            this.top = r102;
            this.bottom = r103;
            this.width = r104;
            this.height = r105;
        }
    }

    @AIBridgeParamModel
    public interface a extends ParamModel {
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "abi", required = false)
        void setAbi(String r100);

        @AIBridgeParamField(keyPath = "benchmarkLevel", required = false)
        void setBenchmarkLevel(Double r100);

        @AIBridgeParamField(keyPath = "brand", required = true)
        void setBrand(String r100);

        @AIBridgeParamField(keyPath = "deviceOrientation", required = false)
        void setDeviceOrientation(String r100);

        @AIBridgeParamField(keyPath = "enableDebug", required = false)
        void setEnableDebug(Boolean r100);

        @AIBridgeParamField(keyPath = "language", required = true)
        void setLanguage(String r100);

        @AIBridgeParamField(keyPath = DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, required = true)
        void setModel(String r100);

        @AIBridgeParamField(keyPath = "pixelRatio", required = true)
        void setPixelRatio(double r100);

        @AIBridgeParamField(keyPath = "platform", required = true)
        void setPlatform(String r100);

        @AIBridgeParamField(keyPath = "SDKVersion", required = false)
        void setSDKVersion(String r100);

        @AIBridgeParamField(keyPath = "safeArea", required = false)
        void setSafeArea(SystemInfoSafeArea r100);

        @AIBridgeParamField(keyPath = "screenHeight", required = true)
        void setScreenHeight(int r100);

        @AIBridgeParamField(keyPath = "screenWidth", required = true)
        void setScreenWidth(int r100);

        @AIBridgeParamField(keyPath = "statusBarHeight", required = true)
        void setStatusBarHeight(int r100);

        @AIBridgeParamField(keyPath = CameraParam.TYPE_SYSTEM_CAMERA, required = true)
        void setSystem(String r100);

        @AIBridgeParamField(keyPath = "theme", required = false)
        void setTheme(String r100);

        @AIBridgeParamField(keyPath = "version", required = false)
        void setVersion(String r100);

        @AIBridgeParamField(keyPath = "windowHeight", required = true)
        void setWindowHeight(int r100);

        @AIBridgeParamField(keyPath = "windowWidth", required = true)
        void setWindowWidth(int r100);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        return true;
    }

    public AbsGetSystemInfoMethodIDL() {
        this.f36123a = "doubao.getSystemInfo";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.f36123a;
    }
}
