package baseverify;

import com.alibaba.fastjson.JSON;
import com.alipay.zoloz.toyger.SgomInfoManager;
import com.alipay.zoloz.toyger.blob.FaceDataFrameInfo;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.dtf.face.api.IDTResponseCode;
import com.dtf.face.log.RecordConst;
import com.dtf.face.log.RecordService;
import com.dtf.face.network.APICallback;
import com.dtf.face.network.model.ZimInitResponse;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public final class h implements APICallback<Map<String, Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f18507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f18508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map f18509c;

    public void a(Map<String, Object> r100) {
        if (hs7.a.h().b(this.f18507a, "zimInit", System.currentTimeMillis() - this.f18508b) == false) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.size() == 0) goto L34;
        String r101 = (String) r100.get("data");
        ZimInitResponse r102 = new ZimInitResponse();
        ZimInitResponse r103 = (ZimInitResponse) JSON.parseObject(r101, ZimInitResponse.class);     // Catch: Throwable -> L28
        r103.fixParams();     // Catch: Throwable -> L13
    L15:
        j r104 = (j) this.f18509c.get("zimInitCallback");
        if (IDTResponseCode.ZIM_NET_INIT_SUCCESS.equals(r103.retCodeSub) == false) goto L20;
        if (r104 == null) goto L19;
        r104.onSuccess(r103.protocol, r103.extParams, r103.wishControlBiz);
    L22:
        StringBuilder r105 = new StringBuilder("");
        r105.append(this.f18507a);
        r105.append(".");
        if (r101 == null) goto L25;
        String r106 = r103.retCode;
    L26:
        r105.append(r106);
        FaceDataFrameInfo.info_cache = r105.toString();
        SgomInfoManager.updateSgomInfo(-779092065, null);
        return;
    L25:
        r106 = null;
        goto L26
    L19:
        RecordService.getInstance().recordEvent(2, "faceVerifyInit", new String[]{"status", "success", "content", JSON.toJSONString(r101)});
        goto L22
    L20:
        if (r104 == null) goto L22;
        r104.onServerError(r103.retCodeSub, r103.retMessageSub);
    L13:
        r102 = r103;
    L14:
        r102.retCode = null;
        r103 = r102;
        goto L15
    }

    @Override // com.dtf.face.network.APICallback
    public /* bridge */ /* synthetic */ void onSuccess(Map<String, Object> r100) {
        a(r100);
    }

    public h(String r100, long r101, Map r102) {
        this.f18507a = r100;
        this.f18508b = r101;
        this.f18509c = r102;
    }

    @Override // com.dtf.face.network.APICallback
    public void onError(String r100, String r101, String r102) {
        RecordService.getInstance().recordEvent(4, "faceVerifyInit", new String[]{"status", "error", "errCode", r100, "errMsg", r101, RecordConst.LOG_ERR_TYPE, r102});
        if (hs7.a.h().b(this.f18507a, "zimInit", System.currentTimeMillis() - this.f18508b) == false) goto L5;
        return;
    L5:
        j r103 = (j) this.f18509c.get("zimInitCallback");
        if (r103 != null) goto L8;
    L11:
        FaceDataFrameInfo.info_cache = "" + this.f18507a + "." + r100;
        SgomInfoManager.updateSgomInfo(-779092065, null);
        return;
    L8:
        if (HTTP.SERVER.equals(r100) == false) goto L10;
        r103.onServerError(IDTResponseCode.ZIM_RESPONSE_CLIENT_TIME_INVALID, r101);
        goto L11
    L10:
        r103.onError(r100, r101);
        goto L11
    }
}
