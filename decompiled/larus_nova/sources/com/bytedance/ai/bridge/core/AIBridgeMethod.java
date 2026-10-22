package com.bytedance.ai.bridge.core;

import androidx.core.util.Consumer;
import com.google.gson.JsonObject;
import e3.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes43.dex */
public interface AIBridgeMethod {

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B5\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fB!\b\u0017\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\rB\u0015\b\u0016\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\u000eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ai/bridge/core/AIBridgeMethod$Error;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "code", "", "msg", "", "data", "Lcom/google/gson/JsonObject;", "errNo", "Lcom/bytedance/ai/bridge/core/AIBridgeApiErr;", "<init>", "(ILjava/lang/String;Lcom/google/gson/JsonObject;Lcom/bytedance/ai/bridge/core/AIBridgeApiErr;)V", "(Ljava/lang/String;Lcom/google/gson/JsonObject;)V", "(Lcom/google/gson/JsonObject;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "getData", "()Lcom/google/gson/JsonObject;", "getErrNo", "()Lcom/bytedance/ai/bridge/core/AIBridgeApiErr;", "extras", "getExtras", "setExtras", "applet-bridge_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class Error extends RuntimeException {
        private final int code;
        private final JsonObject data;
        private final f3.a errNo;
        private JsonObject extras;
        private final String msg;

        /* JADX WARN: Multi-variable type inference failed */
        public Error() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        public Error(int r100) {
            this(r100, null, null, null, 14, null);
        }

        public Error(int r100, String r101) {
            this(r100, r101, null, null, 12, null);
        }

        public Error(int r100, String r101, JsonObject r110) {
            this(r100, r101, r110, null, 8, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Error(String r100) {
            this(r100, null, 2, 0 == true ? 1 : 0);
        }

        public final int getCode() {
            return this.code;
        }

        public final JsonObject getData() {
            return this.data;
        }

        public final f3.a getErrNo() {
            return this.errNo;
        }

        public final JsonObject getExtras() {
            return this.extras;
        }

        public final String getMsg() {
            return this.msg;
        }

        public Error(JsonObject r100) {
            this(0, "", r100, null, 8, null);
        }

        public final void setExtras(JsonObject r100) {
            this.extras = r100;
        }

        public Error(String r100, JsonObject r101) {
            this(0, r100, r101, null, 8, null);
        }

        public /* synthetic */ Error(JsonObject r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100);
        }

        public /* synthetic */ Error(String r100, JsonObject r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = "";
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            this(r100, r101);
        }

        public Error(int r100, String r101, JsonObject r102, f3.a r103) {
            super(r101);
            this.code = r100;
            this.msg = r101;
            this.data = r102;
            this.errNo = r103;
        }

        public /* synthetic */ Error(int r100, String r101, JsonObject r102, f3.a r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 2) == 0) goto L6;
            r101 = "";
        L6:
            if ((r104 & 4) == 0) goto L9;
            r102 = null;
        L9:
            if ((r104 & 8) == 0) goto L11;
            r103 = null;
        L11:
            this(r100, r101, r102, r103);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/bridge/core/AIBridgeMethod$InvalidParamsError;", "Lcom/bytedance/ai/bridge/core/AIBridgeMethod$Error;", "msg", "", "<init>", "(Ljava/lang/String;)V", "applet-bridge_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class InvalidParamsError extends Error {
        /* JADX WARN: Multi-variable type inference failed */
        public InvalidParamsError() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public InvalidParamsError(String r100) {
            super(-3, r100, null, null, 8, null);
        }

        public /* synthetic */ InvalidParamsError(String r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = "the result passed by the method implementor is invalid";
        L5:
            this(r100);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/bridge/core/AIBridgeMethod$InvalidResultError;", "Lcom/bytedance/ai/bridge/core/AIBridgeMethod$Error;", "msg", "", "<init>", "(Ljava/lang/String;)V", "applet-bridge_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class InvalidResultError extends Error {
        /* JADX WARN: Multi-variable type inference failed */
        public InvalidResultError() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public InvalidResultError(String r100) {
            super(-5, r100, null, null, 8, null);
        }

        public /* synthetic */ InvalidResultError(String r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = "the parameter passed by FE is invalid";
        L5:
            this(r100);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/bridge/core/AIBridgeMethod$UnregisteredError;", "Lcom/bytedance/ai/bridge/core/AIBridgeMethod$Error;", "msg", "", "<init>", "(Ljava/lang/String;)V", "applet-bridge_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class UnregisteredError extends Error {
        /* JADX WARN: Multi-variable type inference failed */
        public UnregisteredError() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public UnregisteredError(String r100) {
            super(-2, r100, null, null, 8, null);
        }

        public /* synthetic */ UnregisteredError(String r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = "the called method isn't registered";
        L5:
            this(r100);
        }
    }

    List<String> getAltNames();

    String getName();

    boolean getSupportSyncCall();

    boolean mustRunInMain();

    void realHandle(d r100, JsonObject r101, Consumer<JsonObject> r102, Consumer<Error> r103);
}
