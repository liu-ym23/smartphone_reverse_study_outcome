package com.android.ttcjpaysdk.base.h5.cjjsb.abs;

import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.NothingOutput;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.heytap.mcssdk.constant.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbOcr;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbOcr$OcrInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/NothingOutput;", "()V", "name", "", "getName", "()Ljava/lang/String;", "OcrInput", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsJsbOcr extends AbsJSBMethod<OcrInput, NothingOutput> {
    private final String name;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B¹\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003¢\u0006\u0002\u0010\u0017R\u0012\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbOcr$OcrInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "type", "", "merchant_id", "app_id", a.KEY_DID, "aid", b.f276366p, "compress_size", "", "track_base_param", "ext_params", "Lorg/json/JSONObject;", "frontUploadInteface", "backUploadInteface", "publicKey", "is_caijing_saas", "riskInfoParams", "title", BdpAppEventConstant.PARAMS_SUB_TITLE, "cj_tips_icon_url", "cj_tips_content", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class OcrInput implements IJSBParams {
        public String aid;
        public String app_id;
        public String backUploadInteface;
        public String cj_tips_content;
        public String cj_tips_icon_url;
        public int compress_size;
        public String did;
        public JSONObject ext_params;
        public String frontUploadInteface;
        public String is_caijing_saas;
        public String merchant_id;
        public String publicKey;
        public JSONObject riskInfoParams;
        public String rule;
        public String sub_title;
        public String title;
        public String track_base_param;
        public String type;

        public OcrInput() {
            this(null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, 262143, null);
        }

        public OcrInput(String r110, String r111, String r112, String r210, String r211, String r212, int r213, String r214, JSONObject r215, String r216, String r217, String r218, String r219, JSONObject r310, String r311, String r312, String r313, String r314) {
            Intrinsics.checkNotNullParameter(r110, "type");
            Intrinsics.checkNotNullParameter(r111, "merchant_id");
            Intrinsics.checkNotNullParameter(r112, "app_id");
            Intrinsics.checkNotNullParameter(r210, a.KEY_DID);
            Intrinsics.checkNotNullParameter(r211, "aid");
            Intrinsics.checkNotNullParameter(r212, b.f276366p);
            Intrinsics.checkNotNullParameter(r214, "track_base_param");
            Intrinsics.checkNotNullParameter(r215, "ext_params");
            Intrinsics.checkNotNullParameter(r216, "frontUploadInteface");
            Intrinsics.checkNotNullParameter(r217, "backUploadInteface");
            Intrinsics.checkNotNullParameter(r218, "publicKey");
            Intrinsics.checkNotNullParameter(r219, "is_caijing_saas");
            Intrinsics.checkNotNullParameter(r310, "riskInfoParams");
            Intrinsics.checkNotNullParameter(r311, "title");
            Intrinsics.checkNotNullParameter(r312, BdpAppEventConstant.PARAMS_SUB_TITLE);
            Intrinsics.checkNotNullParameter(r313, "cj_tips_icon_url");
            Intrinsics.checkNotNullParameter(r314, "cj_tips_content");
            this.type = r110;
            this.merchant_id = r111;
            this.app_id = r112;
            this.did = r210;
            this.aid = r211;
            this.rule = r212;
            this.compress_size = r213;
            this.track_base_param = r214;
            this.ext_params = r215;
            this.frontUploadInteface = r216;
            this.backUploadInteface = r217;
            this.publicKey = r218;
            this.is_caijing_saas = r219;
            this.riskInfoParams = r310;
            this.title = r311;
            this.sub_title = r312;
            this.cj_tips_icon_url = r313;
            this.cj_tips_content = r314;
        }

        public /* synthetic */ OcrInput(String r210, String r211, String r212, String r213, String r214, String r215, int r216, String r217, JSONObject r218, String r219, String r310, String r311, String r312, JSONObject r313, String r314, String r315, String r316, String r317, int r318, DefaultConstructorMarker r319) {
            if ((r318 & 1) == 0) goto L5;
            String r100 = "";
        L7:
            if ((r318 & 2) == 0) goto L9;
            String r101 = "";
        L11:
            if ((r318 & 4) == 0) goto L13;
            String r102 = "";
        L15:
            if ((r318 & 8) == 0) goto L17;
            String r103 = "";
        L19:
            if ((r318 & 16) == 0) goto L21;
            String r104 = "";
        L23:
            if ((r318 & 32) == 0) goto L25;
            String r105 = "";
        L27:
            if ((r318 & 64) == 0) goto L29;
            int r106 = -1;
        L31:
            if ((r318 & 128) == 0) goto L33;
            String r107 = "";
        L35:
            if ((r318 & 256) == 0) goto L37;
            JSONObject r110 = new JSONObject();
        L39:
            if ((r318 & 512) == 0) goto L41;
            String r111 = "";
        L43:
            if ((r318 & 1024) == 0) goto L45;
            String r112 = "";
        L47:
            if ((r318 & 2048) == 0) goto L49;
            String r113 = "";
        L51:
            if ((r318 & 4096) == 0) goto L53;
            String r114 = "";
        L55:
            if ((r318 & 8192) == 0) goto L57;
            JSONObject r115 = new JSONObject();
        L59:
            if ((r318 & 16384) == 0) goto L61;
            String r108 = "";
        L63:
            if ((r318 & 32768) == 0) goto L65;
            String r116 = "";
        L67:
            if ((r318 & 65536) == 0) goto L69;
            String r117 = "";
        L71:
            if ((r318 & 131072) == 0) goto L73;
            String r109 = "";
        L74:
            this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r109);
            return;
        L73:
            r109 = r317;
            goto L74
        L69:
            r117 = r316;
            goto L71
        L65:
            r116 = r315;
            goto L67
        L61:
            r108 = r314;
            goto L63
        L57:
            r115 = r313;
            goto L59
        L53:
            r114 = r312;
            goto L55
        L49:
            r113 = r311;
            goto L51
        L45:
            r112 = r310;
            goto L47
        L41:
            r111 = r219;
            goto L43
        L37:
            r110 = r218;
            goto L39
        L33:
            r107 = r217;
            goto L35
        L29:
            r106 = r216;
            goto L31
        L25:
            r105 = r215;
            goto L27
        L21:
            r104 = r214;
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

    public AbsJsbOcr() {
        this.name = "ttcjpay.ocr";
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod, cd4.m
    public final String getName() {
        return this.name;
    }
}
