package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import w20.aa;
import w20.z9;

/* JADX INFO: loaded from: classes46.dex */
public final class DynamicRegisterMessageMethod extends com.bytedance.ies.web.jsbridge2.f<b, RegisterMessageResultModel> implements com.bytedance.android.live.browser.jsbridge.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f74185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f74186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DataCenter f74187c;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/liveinteract/jsbridge/method/DynamicRegisterMessageMethod$RegisterMessageResultModel;", "Lw20/aa;", "Lcom/bytedance/android/live/liveinteract/jsbridge/method/DynamicRegisterMessageMethod$RegisterMessageResultModel$Code;", "code", "Lcom/bytedance/android/live/liveinteract/jsbridge/method/DynamicRegisterMessageMethod$RegisterMessageResultModel$Code;", "getCode", "()Lcom/bytedance/android/live/liveinteract/jsbridge/method/DynamicRegisterMessageMethod$RegisterMessageResultModel$Code;", "setCode", "(Lcom/bytedance/android/live/liveinteract/jsbridge/method/DynamicRegisterMessageMethod$RegisterMessageResultModel$Code;)V", "Lcom/google/gson/JsonObject;", "data", "Lcom/google/gson/JsonObject;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/google/gson/JsonObject;", "b", "(Lcom/google/gson/JsonObject;)V", "", "msg", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "<init>", "()V", "Code", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class RegisterMessageResultModel implements aa {

        @SerializedName("code")
        private Code code;

        @SerializedName("data")
        private JsonObject data;

        @SerializedName("msg")
        private String msg;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/liveinteract/jsbridge/method/DynamicRegisterMessageMethod$RegisterMessageResultModel$Code;", "", "Lw20/z9;", "", "getCode", "value", "I", "getValue", "()I", "Success", "Failed", "NO_PERMISSION", "NOT_REGISTER", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
        public static final enum Code extends Enum<Code> implements z9 {
            public static final Code Failed = null;
            public static final Code NOT_REGISTER = null;
            public static final Code NO_PERMISSION = null;
            public static final Code Success = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Code[] f74188a = null;
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
                f74188a = new Code[]{r100, r101, r102, r103};
            }

            public static Code valueOf(String r100) {
                return (Code) r27.a.a(Code.class, r100);
            }

            public static Code[] values() {
                return (Code[]) f74188a.clone();
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

        public RegisterMessageResultModel() {
        }

        public final JsonObject a() {
            return this.data;
        }

        public final void b(JsonObject r100) {
            this.data = r100;
        }
    }

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/liveinteract/jsbridge/method/DynamicRegisterMessageMethod$b;", "", "", "", "typeList", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setTypeList", "(Ljava/util/List;)V", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class b {

        @SerializedName("type_list")
        private List<String> typeList;

        public b() {
        }

        public final List<String> a() {
            return this.typeList;
        }
    }

    static {
        new HashMap();
    }

    @Override // com.bytedance.android.live.browser.jsbridge.e
    public final void onClean() {
        DataCenter r100 = this.f74187c;
        if (r100 == null) goto L5;
        vlc.d r101 = (vlc.d) r100.get("data_message_manager", null);
    L6:
        if (r101 == null) goto L8;
        r101.removeMessageListener(this.f74185a);
    L8:
        DataCenter r102 = this.f74187c;
        if (r102 == null) goto L13;
        HashMap r103 = (HashMap) r102.get("multilink_jsb_message_filter", null);
        if (r103 == null) goto L13;
        r103.clear();
    L13:
        int r104 = com.bytedance.android.live.browser.utils.j.f64310a;
        com.bytedance.android.live.browser.utils.j.a(getCallContext());
        int r105 = com.bytedance.android.live.browser.utils.n.f64317a;
        com.bytedance.android.live.browser.utils.n.b(getCallContext());
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        ALogger.i("DynamicRegisterMessageMethod", "onTerminate");
        onClean();
    }

    public DynamicRegisterMessageMethod(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "mDataCenter");
        this.f74187c = r100;
        this.f74186b = String.valueOf(System.currentTimeMillis());
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(b r100, CallContext r110) {
        b r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        DataCenter r102 = this.f74187c;
        HashMap r103 = null;
        if (r102 == null) goto L5;
        vlc.d r104 = (vlc.d) r102.get("data_message_manager", null);
    L6:
        DataCenter r105 = this.f74187c;
        if (r105 == null) goto L9;
        r103 = (HashMap) r105.get("multilink_jsb_message_filter", null);
    L9:
        if (r103 != null) goto L11;
        r103 = new HashMap();
        this.f74187c.put("multilink_jsb_message_filter", r103);
    L11:
        List<String> r106 = r101.a();
        if (r106 == null) goto L29;
        Iterator<T> r107 = r106.iterator();
    L15:
        if (r107.hasNext() == false) goto L29;
        String r108 = (String) r107.next();
        if (r103.containsKey(r108) == true) goto L15;
        r103.put(r108, 1);
        MessageType[] r109 = MessageType.values();
        int r111 = r109.length;
        int r112 = 0;
    L19:
        if (r112 >= r111) goto L15;
        MessageType r113 = r109[r112];
        if (com.bytedance.android.livesdk.message.linker.m.a(r113, r108) == true) goto L22;
        r112 = r112 + 1;
        goto L19
    L22:
        ALogger.i("DynamicRegisterMessageMethod", "registerMessage, messageType: " + r113.getKey());
        if (this.f74185a != null) goto L25;
        this.f74185a = new d(r110);
    L25:
        if (r104 == null) goto L27;
        r104.addMessageListener(r113.getIntType(), this.f74185a);
    L27:
        int r114 = com.bytedance.android.live.browser.utils.n.f64317a;
        com.bytedance.android.live.browser.utils.n.c(r110, Integer.valueOf(r113.getIntType()), this.f74185a);
    L29:
        com.bytedance.android.live.browser.utils.j.b(r110, this);
        RegisterMessageResultModel r115 = new RegisterMessageResultModel();
        r115.b(new JsonObject());
        JsonObject r116 = r115.a();
        if (r116 == null) goto L32;
        r116.addProperty("listener_id", this.f74186b);
    L32:
        IInteractService r117 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r117 == null) goto L37;
        ih0.b r118 = r117.dynamicService(this.f74187c);
        if (r118 == null) goto L37;
        r118.oe(this.f74186b, this.f74185a);
    L37:
        finishWithResult(r115);
        return;
    L5:
        r104 = null;
        goto L6
    }
}
