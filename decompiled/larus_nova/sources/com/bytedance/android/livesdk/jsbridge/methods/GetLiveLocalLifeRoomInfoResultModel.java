package com.bytedance.android.livesdk.jsbridge.methods;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import w20.aa;
import w20.z9;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0002\u0012\u0007B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/jsbridge/methods/GetLiveLocalLifeRoomInfoResultModel;", "Lw20/aa;", "Lcom/bytedance/android/livesdk/jsbridge/methods/GetLiveLocalLifeRoomInfoResultModel$Code;", "code", "Lcom/bytedance/android/livesdk/jsbridge/methods/GetLiveLocalLifeRoomInfoResultModel$Code;", "getCode", "()Lcom/bytedance/android/livesdk/jsbridge/methods/GetLiveLocalLifeRoomInfoResultModel$Code;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Lcom/bytedance/android/livesdk/jsbridge/methods/GetLiveLocalLifeRoomInfoResultModel$Code;)V", "Lcom/bytedance/android/livesdk/jsbridge/methods/GetLiveLocalLifeRoomInfoResultModel$a;", "data", "Lcom/bytedance/android/livesdk/jsbridge/methods/GetLiveLocalLifeRoomInfoResultModel$a;", "getData", "()Lcom/bytedance/android/livesdk/jsbridge/methods/GetLiveLocalLifeRoomInfoResultModel$a;", "b", "(Lcom/bytedance/android/livesdk/jsbridge/methods/GetLiveLocalLifeRoomInfoResultModel$a;)V", "<init>", "()V", "Code", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GetLiveLocalLifeRoomInfoResultModel implements aa {

    @SerializedName("code")
    private Code code;

    @SerializedName("data")
    private a data;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/jsbridge/methods/GetLiveLocalLifeRoomInfoResultModel$Code;", "", "Lw20/z9;", "", "getCode", "value", "I", "getValue", "()I", "Success", "Failed", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Code extends Enum<Code> implements z9 {
        public static final Code Failed = null;
        public static final Code Success = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Code[] f142026a = null;
        private final int value;

        static {
            Code r100 = new Code("Success", 0, 1);
            Success = r100;
            Code r101 = new Code("Failed", 1, 0);
            Failed = r101;
            f142026a = new Code[]{r100, r101};
        }

        public static Code valueOf(String r100) {
            return (Code) r27.a.a(Code.class, r100);
        }

        public static Code[] values() {
            return (Code[]) f142026a.clone();
        }

        @Override // w20.z9
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

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0004\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/jsbridge/methods/GetLiveLocalLifeRoomInfoResultModel$a;", "", "", "code", "Ljava/lang/Number;", "getCode", "()Ljava/lang/Number;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Ljava/lang/Number;)V", "", "live_room_info", "Ljava/lang/String;", "getLive_room_info", "()Ljava/lang/String;", "b", "(Ljava/lang/String;)V", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("code")
        private Number code;

        @SerializedName("live_room_info")
        private String live_room_info;

        public a() {
        }

        public final void a(Number r100) {
            this.code = r100;
        }

        public final void b(String r100) {
            this.live_room_info = r100;
        }
    }

    public GetLiveLocalLifeRoomInfoResultModel() {
    }

    public final void a(Code r100) {
        this.code = r100;
    }

    public final void b(a r100) {
        this.data = r100;
    }
}
