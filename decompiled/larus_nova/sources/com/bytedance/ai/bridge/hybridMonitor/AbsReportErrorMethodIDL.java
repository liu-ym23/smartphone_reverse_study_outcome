package com.bytedance.ai.bridge.hybridMonitor;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\n\u000b\fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/hybridMonitor/AbsReportErrorMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/hybridMonitor/AbsReportErrorMethodIDL$ErrorInfoModel;", "Lcom/bytedance/ai/bridge/hybridMonitor/AbsReportErrorMethodIDL$EmptyMessageModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "ErrorInfoModel", "EmptyMessageModel", "ErrorData", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsReportErrorMethodIDL extends CoreAIBridgeMethod<b, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f35336a;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003JV\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\""}, d2 = {"Lcom/bytedance/ai/bridge/hybridMonitor/AbsReportErrorMethodIDL$ErrorData;", "", "error_message", "", "fileName", "lineNumber", "", "columnNumber", "stack", "sourcemap_release", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getError_message", "()Ljava/lang/String;", "getFileName", "getLineNumber", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getColumnNumber", "getStack", "getSourcemap_release", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/ai/bridge/hybridMonitor/AbsReportErrorMethodIDL$ErrorData;", "equals", "", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ErrorData {

        @SerializedName("columnNumber")
        private final Integer columnNumber;

        @SerializedName("error_message")
        private final String error_message;

        @SerializedName("fileName")
        private final String fileName;

        @SerializedName("lineNumber")
        private final Integer lineNumber;

        @SerializedName("sourcemap_release")
        private final String sourcemap_release;

        @SerializedName("stack")
        private final String stack;

        public ErrorData() {
            this(null, null, null, null, null, null, 63, null);
        }

        public static /* synthetic */ ErrorData copy$default(ErrorData r100, String r101, String r102, Integer r103, Integer r104, String r105, String r110, int r111, Object r112) {
            if ((r111 & 1) == 0) goto L6;
            r101 = r100.error_message;
        L6:
            if ((r111 & 2) == 0) goto L8;
            r102 = r100.fileName;
        L8:
            String r113 = r102;
            if ((r111 & 4) == 0) goto L11;
            r103 = r100.lineNumber;
        L11:
            Integer r106 = r103;
            if ((r111 & 8) == 0) goto L14;
            r104 = r100.columnNumber;
        L14:
            Integer r107 = r104;
            if ((r111 & 16) == 0) goto L17;
            r105 = r100.stack;
        L17:
            String r108 = r105;
            if ((r111 & 32) == 0) goto L20;
            r110 = r100.sourcemap_release;
        L20:
            String r109 = r101;
            return r100.copy(r109, r113, r106, r107, r108, r110);
        }

        public final String component1() {
            return this.error_message;
        }

        public final String component2() {
            return this.fileName;
        }

        public final Integer component3() {
            return this.lineNumber;
        }

        public final Integer component4() {
            return this.columnNumber;
        }

        public final String component5() {
            return this.stack;
        }

        public final String component6() {
            return this.sourcemap_release;
        }

        public final ErrorData copy(String r100, String r110, Integer r111, Integer r112, String r113, String r114) {
            return new ErrorData(r100, r110, r111, r112, r113, r114);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ErrorData) == true) goto L8;
            return false;
        L8:
            ErrorData r101 = (ErrorData) r100;
            if (Intrinsics.areEqual(this.error_message, r101.error_message) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.fileName, r101.fileName) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.lineNumber, r101.lineNumber) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.columnNumber, r101.columnNumber) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.stack, r101.stack) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.sourcemap_release, r101.sourcemap_release) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            String r100 = this.error_message;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.fileName;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            Integer r107 = this.lineNumber;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            Integer r110 = this.columnNumber;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.stack;
            if (r113 != null) goto L21;
            int r114 = 0;
        L22:
            int r115 = (r112 + r114) * 31;
            String r116 = this.sourcemap_release;
            if (r116 == null) goto L27;
            r101 = r116.hashCode();
        L27:
            return r115 + r101;
        L21:
            r114 = r113.hashCode();
            goto L22
        L17:
            r111 = r110.hashCode();
            goto L18
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public String toString() {
            return "ErrorData(error_message=" + this.error_message + ", fileName=" + this.fileName + ", lineNumber=" + this.lineNumber + ", columnNumber=" + this.columnNumber + ", stack=" + this.stack + ", sourcemap_release=" + this.sourcemap_release + ')';
        }

        public final Integer getColumnNumber() {
            return this.columnNumber;
        }

        public final String getError_message() {
            return this.error_message;
        }

        public final String getFileName() {
            return this.fileName;
        }

        public final Integer getLineNumber() {
            return this.lineNumber;
        }

        public final String getSourcemap_release() {
            return this.sourcemap_release;
        }

        public final String getStack() {
            return this.stack;
        }

        public ErrorData(String r100, String r101, Integer r102, Integer r103, String r104, String r105) {
            this.error_message = r100;
            this.fileName = r101;
            this.lineNumber = r102;
            this.columnNumber = r103;
            this.stack = r104;
            this.sourcemap_release = r105;
        }

        public /* synthetic */ ErrorData(String r100, String r101, Integer r102, Integer r103, String r110, String r111, int r112, DefaultConstructorMarker r113) {
            if ((r112 & 1) == 0) goto L5;
            String r114 = null;
        L7:
            if ((r112 & 2) == 0) goto L9;
            String r104 = null;
        L11:
            if ((r112 & 4) == 0) goto L13;
            Integer r105 = null;
        L15:
            if ((r112 & 8) == 0) goto L17;
            Integer r106 = null;
        L19:
            if ((r112 & 16) == 0) goto L21;
            String r107 = null;
        L23:
            if ((r112 & 32) == 0) goto L25;
            String r115 = null;
        L26:
            this(r114, r104, r105, r106, r107, r115);
            return;
        L25:
            r115 = r111;
            goto L26
        L21:
            r107 = r110;
            goto L23
        L17:
            r106 = r103;
            goto L19
        L13:
            r105 = r102;
            goto L15
        L9:
            r104 = r101;
            goto L11
        L5:
            r114 = r100;
            goto L7
        }
    }

    @AIBridgeResultModel
    public interface a extends ResultModel {
    }

    @AIBridgeParamModel
    public interface b extends ParamModel {
        @AIBridgeParamField(keyPath = PerfLog.PARAM_KEY_CONTEXT_ID, required = false)
        Map<String, Object> getContext();

        @AIBridgeParamField(keyPath = "data", required = false)
        ErrorData getData();
    }

    public AbsReportErrorMethodIDL() {
        this.f35336a = "hybridMonitor.reportError";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.f35336a;
    }
}
