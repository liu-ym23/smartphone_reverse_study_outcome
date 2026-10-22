package com.bytedance.ai.bridge.filesystem.filemethods;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\n\u000b\fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/filesystem/filemethods/AbsGetSavedFileListMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/filesystem/filemethods/AbsGetSavedFileListMethodIDL$EmptyMessageModel;", "Lcom/bytedance/ai/bridge/filesystem/filemethods/AbsGetSavedFileListMethodIDL$GetSavedFileListResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "EmptyMessageModel", "GetSavedFileListResultModel", "FsSavedFileItem", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsGetSavedFileListMethodIDL extends CoreAIBridgeMethod<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f35318a;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ai/bridge/filesystem/filemethods/AbsGetSavedFileListMethodIDL$FsSavedFileItem;", "", "filePath", "", "size", "", "createTime", "<init>", "(Ljava/lang/String;JJ)V", "getFilePath", "()Ljava/lang/String;", "getSize", "()J", "getCreateTime", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FsSavedFileItem {

        @SerializedName("createTime")
        private final long createTime;

        @SerializedName("filePath")
        private final String filePath;

        @SerializedName("size")
        private final long size;

        public static /* synthetic */ FsSavedFileItem copy$default(FsSavedFileItem r100, String r101, long r102, long r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.filePath;
        L6:
            if ((r104 & 2) == 0) goto L8;
            r102 = r100.size;
        L8:
            long r106 = r102;
            if ((r104 & 4) == 0) goto L11;
            r103 = r100.createTime;
        L11:
            String r107 = r101;
            return r100.copy(r107, r106, r103);
        }

        public final String component1() {
            return this.filePath;
        }

        public final long component2() {
            return this.size;
        }

        public final long component3() {
            return this.createTime;
        }

        public final FsSavedFileItem copy(String r100, long r101, long r110) {
            Intrinsics.checkNotNullParameter(r100, "filePath");
            return new FsSavedFileItem(r100, r101, r110);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof FsSavedFileItem) == true) goto L8;
            return false;
        L8:
            FsSavedFileItem r101 = (FsSavedFileItem) r100;
            if (Intrinsics.areEqual(this.filePath, r101.filePath) == true) goto L12;
            return false;
        L12:
            if (this.size == r101.size) goto L15;
            return false;
        L15:
            if (this.createTime == r101.createTime) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r100 = this.filePath.hashCode() * 31;
            long r101 = this.size;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            long r103 = this.createTime;
            return r102 + ((int) (r103 ^ (r103 >>> 32)));
        }

        public String toString() {
            return "FsSavedFileItem(filePath=" + this.filePath + ", size=" + this.size + ", createTime=" + this.createTime + ')';
        }

        public final long getCreateTime() {
            return this.createTime;
        }

        public final String getFilePath() {
            return this.filePath;
        }

        public final long getSize() {
            return this.size;
        }

        public FsSavedFileItem(String r100, long r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, "filePath");
            this.filePath = r100;
            this.size = r101;
            this.createTime = r102;
        }
    }

    @AIBridgeParamModel
    public interface a extends ParamModel {
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "fileList", required = true)
        void setFileList(List<FsSavedFileItem> r100);
    }

    public AbsGetSavedFileListMethodIDL() {
        this.f35318a = "doubao.getSavedFileList";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.f35318a;
    }
}
