package com.bytedance.ai.bridge.media.image;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeDefaultValue;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.annotation.DefaultType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\f\r\u000eB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/bridge/media/image/AbsChooseImageMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/media/image/AbsChooseImageMethodIDL$ChooseImageParamModel;", "Lcom/bytedance/ai/bridge/media/image/AbsChooseImageMethodIDL$ChooseImageResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mustRunInMain", "", "ChooseImageParamModel", "ChooseImageResultModel", "ChooseImageFileInfo", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsChooseImageMethodIDL extends CoreAIBridgeMethod<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f35341a;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ai/bridge/media/image/AbsChooseImageMethodIDL$ChooseImageFileInfo;", "", "path", "", "size", "", "type", "<init>", "(Ljava/lang/String;JLjava/lang/String;)V", "getPath", "()Ljava/lang/String;", "getSize", "()J", "getType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ChooseImageFileInfo {

        @SerializedName("path")
        private final String path;

        @SerializedName("size")
        private final long size;

        @SerializedName("type")
        private final String type;

        public static /* synthetic */ ChooseImageFileInfo copy$default(ChooseImageFileInfo r100, String r101, long r102, String r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.path;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.size;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.type;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final String component1() {
            return this.path;
        }

        public final long component2() {
            return this.size;
        }

        public final String component3() {
            return this.type;
        }

        public final ChooseImageFileInfo copy(String r100, long r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "path");
            return new ChooseImageFileInfo(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ChooseImageFileInfo) == true) goto L8;
            return false;
        L8:
            ChooseImageFileInfo r101 = (ChooseImageFileInfo) r100;
            if (Intrinsics.areEqual(this.path, r101.path) == true) goto L12;
            return false;
        L12:
            if (this.size == r101.size) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.type, r101.type) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r100 = this.path.hashCode() * 31;
            long r101 = this.size;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            String r103 = this.type;
            if (r103 != null) goto L5;
            int r104 = 0;
        L7:
            return r102 + r104;
        L5:
            r104 = r103.hashCode();
            goto L7
        }

        public String toString() {
            return "ChooseImageFileInfo(path=" + this.path + ", size=" + this.size + ", type=" + this.type + ')';
        }

        public final String getPath() {
            return this.path;
        }

        public final long getSize() {
            return this.size;
        }

        public final String getType() {
            return this.type;
        }

        public ChooseImageFileInfo(String r100, long r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "path");
            this.path = r100;
            this.size = r101;
            this.type = r102;
        }

        public /* synthetic */ ChooseImageFileInfo(String r100, long r101, String r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 4) == 0) goto L5;
            r102 = null;
        L5:
            this(r100, r101, r102);
        }
    }

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(intValue = 9, type = DefaultType.INT), keyPath = "count", required = false)
        int getCount();

        @AIBridgeParamField(keyPath = "sizeType", required = false)
        List<String> getSizeType();

        @AIBridgeParamField(keyPath = "sourceType", required = false)
        List<String> getSourceType();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "tempFilePaths", required = true)
        void setTempFilePaths(List<String> r100);

        @AIBridgeParamField(keyPath = "tempFiles", required = true)
        void setTempFiles(List<ChooseImageFileInfo> r100);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        return true;
    }

    public AbsChooseImageMethodIDL() {
        this.f35341a = "doubao.chooseImage";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.f35341a;
    }
}
