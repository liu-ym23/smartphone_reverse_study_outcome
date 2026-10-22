package com.android.ttcjpaysdk.base.h5.cjjsb.abs;

import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import com.bytedance.android.ec.core.event.a;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbDeviceInfo;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbDeviceInfo$DeviceInfoInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbDeviceInfo$DeviceInfoOutput;", "()V", "name", "", "getName", "()Ljava/lang/String;", "DeviceInfoInput", "DeviceInfoOutput", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsJsbDeviceInfo extends AbsJSBMethod<DeviceInfoInput, DeviceInfoOutput> {
    private final String name;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbDeviceInfo$DeviceInfoInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "aid", "", a.KEY_DID, "", "type", "(ILjava/lang/String;I)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DeviceInfoInput implements IJSBParams {
        public int aid;
        public String did;
        public int type;

        public DeviceInfoInput() {
            this(0, null, 0, 7, null);
        }

        public DeviceInfoInput(int r100, String r101, int r102) {
            Intrinsics.checkNotNullParameter(r101, a.KEY_DID);
            this.aid = r100;
            this.did = r101;
            this.type = r102;
        }

        public /* synthetic */ DeviceInfoInput(int r100, String r101, int r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = 0;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = "";
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = 0;
        L11:
            this(r100, r101, r102);
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001Bá\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0018¢\u0006\u0002\u0010\u001bR\u0012\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbDeviceInfo$DeviceInfoOutput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/JSBBaseOutput;", "device_id", "", a.KEY_DID, "device_platform", "device_type", "os_api", "os_version", TTVideoEngineInterface.PLAY_API_KEY_AC, "brand", "resolution", "platform", "app_name", "aid", "version_name", "version_code", "sdk_version", "cj_plugin_sdk_version", "cj_sdk_version_code", "", "cj_plugin_host_version_code", "host", "dev_info", "Lorg/json/JSONObject;", "fin_info", DyVerifyReqConstants.Key.RISK_INFO, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DeviceInfoOutput extends JSBBaseOutput {

        /* JADX INFO: renamed from: ac, reason: collision with root package name */
        public String f29340ac;
        public String aid;
        public String app_name;
        public String brand;
        public long cj_plugin_host_version_code;
        public String cj_plugin_sdk_version;
        public long cj_sdk_version_code;
        public JSONObject dev_info;
        public String device_id;
        public String device_platform;
        public String device_type;
        public String did;
        public JSONObject fin_info;
        public String host;
        public String os_api;
        public String os_version;
        public String platform;
        public String resolution;
        public JSONObject risk_info;
        public String sdk_version;
        public String version_code;
        public String version_name;

        public DeviceInfoOutput() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, null, null, null, null, 4194303, null);
        }

        public DeviceInfoOutput(String r110, String r111, String r112, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, String r312, long r313, long r314, String r315, JSONObject r316, JSONObject r317, JSONObject r410) {
            Intrinsics.checkNotNullParameter(r110, "device_id");
            Intrinsics.checkNotNullParameter(r111, a.KEY_DID);
            Intrinsics.checkNotNullParameter(r112, "device_platform");
            Intrinsics.checkNotNullParameter(r210, "device_type");
            Intrinsics.checkNotNullParameter(r211, "os_api");
            Intrinsics.checkNotNullParameter(r212, "os_version");
            Intrinsics.checkNotNullParameter(r213, TTVideoEngineInterface.PLAY_API_KEY_AC);
            Intrinsics.checkNotNullParameter(r214, "brand");
            Intrinsics.checkNotNullParameter(r215, "resolution");
            Intrinsics.checkNotNullParameter(r216, "platform");
            Intrinsics.checkNotNullParameter(r217, "app_name");
            Intrinsics.checkNotNullParameter(r218, "aid");
            Intrinsics.checkNotNullParameter(r219, "version_name");
            Intrinsics.checkNotNullParameter(r310, "version_code");
            Intrinsics.checkNotNullParameter(r311, "sdk_version");
            Intrinsics.checkNotNullParameter(r312, "cj_plugin_sdk_version");
            Intrinsics.checkNotNullParameter(r315, "host");
            Intrinsics.checkNotNullParameter(r316, "dev_info");
            Intrinsics.checkNotNullParameter(r317, "fin_info");
            Intrinsics.checkNotNullParameter(r410, DyVerifyReqConstants.Key.RISK_INFO);
            this.device_id = r110;
            this.did = r111;
            this.device_platform = r112;
            this.device_type = r210;
            this.os_api = r211;
            this.os_version = r212;
            this.f29340ac = r213;
            this.brand = r214;
            this.resolution = r215;
            this.platform = r216;
            this.app_name = r217;
            this.aid = r218;
            this.version_name = r219;
            this.version_code = r310;
            this.sdk_version = r311;
            this.cj_plugin_sdk_version = r312;
            this.cj_sdk_version_code = r313;
            this.cj_plugin_host_version_code = r314;
            this.host = r315;
            this.dev_info = r316;
            this.fin_info = r317;
            this.risk_info = r410;
        }

        public /* synthetic */ DeviceInfoOutput(String r210, String r211, String r212, String r213, String r310, String r311, String r312, String r313, String r314, String r315, String r316, String r317, String r318, String r319, String r410, String r411, long r412, long r413, String r414, JSONObject r415, JSONObject r416, JSONObject r417, int r510, DefaultConstructorMarker r511) {
            if ((r510 & 1) == 0) goto L5;
            String r100 = "";
        L7:
            if ((r510 & 2) == 0) goto L9;
            String r101 = "";
        L11:
            if ((r510 & 4) == 0) goto L13;
            String r102 = "";
        L15:
            if ((r510 & 8) == 0) goto L17;
            String r103 = "";
        L19:
            if ((r510 & 16) == 0) goto L21;
            String r104 = "";
        L23:
            if ((r510 & 32) == 0) goto L25;
            String r105 = "";
        L27:
            if ((r510 & 64) == 0) goto L29;
            String r106 = "";
        L31:
            if ((r510 & 128) == 0) goto L33;
            String r107 = "";
        L35:
            if ((r510 & 256) == 0) goto L37;
            String r110 = "";
        L39:
            if ((r510 & 512) == 0) goto L41;
            String r111 = "";
        L43:
            if ((r510 & 1024) == 0) goto L45;
            String r112 = "";
        L47:
            if ((r510 & 2048) == 0) goto L49;
            String r113 = "";
        L51:
            if ((r510 & 4096) == 0) goto L53;
            String r114 = "";
        L55:
            if ((r510 & 8192) == 0) goto L57;
            String r115 = "";
        L59:
            if ((r510 & 16384) == 0) goto L61;
            String r108 = "";
        L63:
            if ((r510 & 32768) == 0) goto L65;
            String r116 = "";
        L66:
            long r117 = -1;
            if ((r510 & 65536) == 0) goto L69;
            long r214 = -1;
        L71:
            if ((r510 & 131072) != 0) goto L75;
            r117 = r413;
        L75:
            if ((r510 & 262144) == 0) goto L77;
            String r118 = "";
        L79:
            if ((r510 & 524288) == 0) goto L81;
            JSONObject r215 = new JSONObject();
        L83:
            if ((r510 & 1048576) == 0) goto L85;
            JSONObject r216 = new JSONObject();
        L87:
            if ((r510 & 2097152) == 0) goto L89;
            JSONObject r109 = new JSONObject();
        L90:
            this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r214, r117, r118, r215, r216, r109);
            return;
        L89:
            r109 = r417;
            goto L90
        L85:
            r216 = r416;
            goto L87
        L81:
            r215 = r415;
            goto L83
        L77:
            r118 = r414;
            goto L79
        L69:
            r214 = r412;
            goto L71
        L65:
            r116 = r411;
            goto L66
        L61:
            r108 = r410;
            goto L63
        L57:
            r115 = r319;
            goto L59
        L53:
            r114 = r318;
            goto L55
        L49:
            r113 = r317;
            goto L51
        L45:
            r112 = r316;
            goto L47
        L41:
            r111 = r315;
            goto L43
        L37:
            r110 = r314;
            goto L39
        L33:
            r107 = r313;
            goto L35
        L29:
            r106 = r312;
            goto L31
        L25:
            r105 = r311;
            goto L27
        L21:
            r104 = r310;
            goto L23
        L17:
            r103 = r213;
            goto L19
        L13:
            r102 = r212;
            goto L15
        L9:
            r101 = r211;
            goto L11
        L5:
            r100 = r210;
            goto L7
        }
    }

    public AbsJsbDeviceInfo() {
        this.name = "ttcjpay.deviceInfo";
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod, cd4.m
    public final String getName() {
        return this.name;
    }
}
