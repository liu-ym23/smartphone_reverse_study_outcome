package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.amap.api.col.s.ce;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0003\u0019\u0007\u000eB\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/gamecp/hybrid_impl/jsb/GameGetExplainCardEnterRoomDataResultModel;", "Le7/k0;", "Lcom/bytedance/android/gamecp/hybrid_impl/jsb/GameGetExplainCardEnterRoomDataResultModel$Code;", "code", "Lcom/bytedance/android/gamecp/hybrid_impl/jsb/GameGetExplainCardEnterRoomDataResultModel$Code;", "getCode", "()Lcom/bytedance/android/gamecp/hybrid_impl/jsb/GameGetExplainCardEnterRoomDataResultModel$Code;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Lcom/bytedance/android/gamecp/hybrid_impl/jsb/GameGetExplainCardEnterRoomDataResultModel$Code;)V", "Lcom/bytedance/android/gamecp/hybrid_impl/jsb/GameGetExplainCardEnterRoomDataResultModel$a;", "data", "Lcom/bytedance/android/gamecp/hybrid_impl/jsb/GameGetExplainCardEnterRoomDataResultModel$a;", "getData", "()Lcom/bytedance/android/gamecp/hybrid_impl/jsb/GameGetExplainCardEnterRoomDataResultModel$a;", "b", "(Lcom/bytedance/android/gamecp/hybrid_impl/jsb/GameGetExplainCardEnterRoomDataResultModel$a;)V", "", "msg", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "<init>", "()V", "Code", "gamecp-hybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameGetExplainCardEnterRoomDataResultModel implements e7.k0 {

    @SerializedName("code")
    private Code code;

    @SerializedName("data")
    private a data;

    @SerializedName("msg")
    private String msg;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/gamecp/hybrid_impl/jsb/GameGetExplainCardEnterRoomDataResultModel$Code;", "", "Le7/j0;", "", "getCode", "value", "I", "getValue", "()I", "Success", "Failed", "NO_PERMISSION", "NOT_REGISTER", "gamecp-hybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Code extends Enum<Code> implements e7.j0 {
        public static final Code Failed = null;
        public static final Code NOT_REGISTER = null;
        public static final Code NO_PERMISSION = null;
        public static final Code Success = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Code[] f57451a = null;
        private final int value;

        static {
            Code r100 = new Code("Success", 0, 1);
            Success = r100;
            Code r101 = new Code("Failed", 1, 0);
            Failed = r101;
            Code r102 = new Code("NO_PERMISSION", 2, -1);
            NO_PERMISSION = r102;
            Code r103 = new Code("NOT_REGISTER", 3, -2);
            NOT_REGISTER = r103;
            f57451a = new Code[]{r100, r101, r102, r103};
        }

        public static Code valueOf(String r100) {
            return (Code) r27.a.a(Code.class, r100);
        }

        public static Code[] values() {
            return (Code[]) f57451a.clone();
        }

        @Override // e7.j0
        public int getCode() {
            return this.value;
        }

        public final int getValue() {
            return this.value;
        }

        public Code(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010(R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR$\u0010\"\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u000b\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR$\u0010%\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0004\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\b¨\u0006)"}, d2 = {"Lcom/bytedance/android/gamecp/hybrid_impl/jsb/GameGetExplainCardEnterRoomDataResultModel$a;", "", "", "preRequestSuccess", "Ljava/lang/Boolean;", "getPreRequestSuccess", "()Ljava/lang/Boolean;", "c", "(Ljava/lang/Boolean;)V", "Lcom/google/gson/JsonObject;", OnekeyLoginConstants.CT_KEY_RSP_DATA, "Lcom/google/gson/JsonObject;", "getResponseData", "()Lcom/google/gson/JsonObject;", "d", "(Lcom/google/gson/JsonObject;)V", "", "", "pendingIMArray", "Ljava/util/List;", "getPendingIMArray", "()Ljava/util/List;", "b", "(Ljava/util/List;)V", "Lcom/bytedance/android/gamecp/hybrid_impl/jsb/GameGetExplainCardEnterRoomDataResultModel$b;", "roomContext", "Lcom/bytedance/android/gamecp/hybrid_impl/jsb/GameGetExplainCardEnterRoomDataResultModel$b;", "getRoomContext", "()Lcom/bytedance/android/gamecp/hybrid_impl/jsb/GameGetExplainCardEnterRoomDataResultModel$b;", "e", "(Lcom/bytedance/android/gamecp/hybrid_impl/jsb/GameGetExplainCardEnterRoomDataResultModel$b;)V", "toolbarData", "getToolbarData", ce.f26391f, "settings", "getSettings", "f", "isAudienceEntranceShow", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "<init>", "()V", "gamecp-hybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("isAudienceEntranceShow")
        private Boolean isAudienceEntranceShow;

        @SerializedName("pendingIMArray")
        private List<String> pendingIMArray;

        @SerializedName("preRequestSuccess")
        private Boolean preRequestSuccess;

        @SerializedName(OnekeyLoginConstants.CT_KEY_RSP_DATA)
        private JsonObject responseData;

        @SerializedName("roomContext")
        private b roomContext;

        @SerializedName("settings")
        private JsonObject settings;

        @SerializedName("toolbarData")
        private JsonObject toolbarData;

        public a() {
        }

        public final void a(Boolean r100) {
            this.isAudienceEntranceShow = r100;
        }

        public final void b(List<String> r100) {
            this.pendingIMArray = r100;
        }

        public final void c(Boolean r100) {
            this.preRequestSuccess = r100;
        }

        public final void d(JsonObject r100) {
            this.responseData = r100;
        }

        public final void e(b r100) {
            this.roomContext = r100;
        }

        public final void f(JsonObject r100) {
            this.settings = r100;
        }

        public final void g(JsonObject r100) {
            this.toolbarData = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/gamecp/hybrid_impl/jsb/GameGetExplainCardEnterRoomDataResultModel$b;", "", "", "uniqueKey", "Ljava/lang/String;", "getUniqueKey", "()Ljava/lang/String;", "b", "(Ljava/lang/String;)V", "enterRoomTimestamp", "getEnterRoomTimestamp", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "<init>", "()V", "gamecp-hybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("enterRoomTimestamp")
        private String enterRoomTimestamp;

        @SerializedName("uniqueKey")
        private String uniqueKey;

        public b() {
        }

        public final void a(String r100) {
            this.enterRoomTimestamp = r100;
        }

        public final void b(String r100) {
            this.uniqueKey = r100;
        }
    }

    public GameGetExplainCardEnterRoomDataResultModel() {
    }

    public final void a(Code r100) {
        this.code = r100;
    }

    public final void b(a r100) {
        this.data = r100;
    }

    public final void c(String r100) {
        this.msg = r100;
    }
}
