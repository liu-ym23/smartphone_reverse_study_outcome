package com.byted.cast.common.pin;

import android.text.TextUtils;
import android.util.Base64;
import com.byted.cast.common.Logger;
import com.byted.cast.common.UrlUtils;
import com.byted.cast.common.api.IHttpNetWork;
import com.byted.cast.common.api.Response;
import com.byted.cast.common.bean.SinkInfoBean;
import com.byted.cast.common.config.Config;
import com.byted.cast.common.crypto.CryptoUtil;
import com.byted.cast.common.network.DefaultHttpNetWork;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.Gson;
import java.util.Collections;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class QRPinNetWork {
    public final String ACTION_DOWNLOAD_RESOURCE;
    public final String ACTION_UPLOAD_RESOURCE;
    private final String TAG;
    private String hostName;
    private final IHttpNetWork httpNetWork;
    private boolean isBoe;
    private final String mSplit;
    public String tokenAndTime;
    private String tokenHost;

    public QRPinNetWork() {
        this.TAG = "QRPinNetWork";
        this.ACTION_UPLOAD_RESOURCE = "UploadResource";
        this.ACTION_DOWNLOAD_RESOURCE = "DownloadResource";
        this.mSplit = "_0_";
        this.tokenAndTime = "_0_0";
        this.isBoe = false;
        this.hostName = UrlUtils.getQRDataDomain(false);
        this.tokenHost = UrlUtils.getQRTokenDomain(this.isBoe);
        DefaultHttpNetWork r100 = new DefaultHttpNetWork();
        this.httpNetWork = r100;
        if ((r100 instanceof DefaultHttpNetWork) == false) goto L6;
        r100.setTimeOut(5000);
        return;
    }

    public QRPinNetWork(IHttpNetWork r100) {
        this.TAG = "QRPinNetWork";
        this.ACTION_UPLOAD_RESOURCE = "UploadResource";
        this.ACTION_DOWNLOAD_RESOURCE = "DownloadResource";
        this.mSplit = "_0_";
        this.tokenAndTime = "_0_0";
        this.isBoe = false;
        this.hostName = UrlUtils.getQRDataDomain(false);
        this.tokenHost = UrlUtils.getQRTokenDomain(this.isBoe);
        if (r100 != null) goto L6;
        r100 = new DefaultHttpNetWork();
    L6:
        this.httpNetWork = r100;
        if ((r100 instanceof DefaultHttpNetWork) == false) goto L10;
        ((DefaultHttpNetWork) r100).setTimeOut(5000);
        return;
    }

    private String doRequestTokenAndHostName(String r110) {
        Logger.d("QRPinNetWork", "doRequestToken tokenHost:" + this.tokenHost + ", action:" + r110);
        String[] r100 = this.tokenAndTime.split("_0_");
        if (r100.length == 2) goto L5;
    L25:
        String r111 = CryptoUtil.base64Encode(new JSONObject().put("action", r110).toString());     // Catch: Throwable -> L21
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L21
        r101.put("content", r111);     // Catch: Throwable -> L21
        String r112 = r101.toString();     // Catch: Throwable -> L21
        HashMap r102 = new HashMap();     // Catch: Throwable -> L21
        r102.put("Content-Type", "application/json");     // Catch: Throwable -> L21
        Response r113 = this.httpNetWork.doPost(this.tokenHost, r112, r102);     // Catch: Throwable -> L21
        Logger.d("QRPinNetWork", "response : " + r113);     // Catch: Throwable -> L21
        if (r113 != null) goto L11;
        return "";
    L11:
        if (r113.code != 200) goto L28;
        JSONObject r103 = new JSONObject(r113.body);     // Catch: Throwable -> L21
        if (r103.optInt("status_code") != 0) goto L29;
        JSONObject r114 = r103.optJSONObject("data");     // Catch: Throwable -> L21
        if (r114 == null) goto L30;
        String r104 = r114.optString("token");     // Catch: Throwable -> L21
        String r115 = r114.optString("url");     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r115) == true) goto L19;
        this.hostName = r115;     // Catch: Throwable -> L21
    L19:
        this.tokenAndTime = r104 + "_0_" + System.currentTimeMillis();     // Catch: Throwable -> L21
        return r104;
    L30:
        return "";
    L29:
        return "";
    L28:
        return "";
    L21:
        th = move-exception;
        Logger.e("QRPinNetWork", th.toString());
        return "";
    L5:
        if ((System.currentTimeMillis() - CastLongProtector.parseLong(r100[1])) > 840000) goto L25;
        return r100[0];
    }

    public synchronized String uploadLinkInfo(SinkInfoBean r100) {
        monitor-enter(this);
        String r101 = Base64.encodeToString(GsonProtectorUtils.toJson(new Gson(), r100).getBytes(), 2);     // Catch: Throwable -> L29
        int r102 = 0;
        Response r103 = null;
    L5:
        r102 = r102 + 1;
        String r104 = doRequestTokenAndHostName("UploadResource");     // Catch: Exception -> L11 Throwable -> L29
        if (TextUtils.isEmpty(r104) == true) goto L13;
        String r105 = this.hostName + "?" + r104;     // Catch: Exception -> L11 Throwable -> L29
        Logger.i("QRPinNetWork", "uploadLinkInfo url : " + r105);     // Catch: Exception -> L11 Throwable -> L29
        r103 = this.httpNetWork.doPost(r105, "{ \"data\":\"" + r101 + "\"}", Collections.emptyMap());     // Catch: Exception -> L11 Throwable -> L29
    L13:
        if (r103 != null) goto L16;
        if (r102 <= 3) goto L5;
    L16:
        Logger.i("QRPinNetWork", "uploadLinkInfo response : " + r103);     // Catch: Exception -> L25 Throwable -> L29
        if (r103 != null) goto L19;
    L27:
        monitor-exit(this);
        return null;
    L19:
        if (r103.code != 200) goto L27;
        JSONObject r106 = new JSONObject(r103.body).optJSONObject("Result");     // Catch: Exception -> L25 Throwable -> L29
        if (r106 == null) goto L27;
        String r107 = r106.optString("Number");     // Catch: Exception -> L25 Throwable -> L29
        monitor-exit(this);
        return r107;
    L25:
        e = move-exception;
        Logger.e("QRPinNetWork", e.toString());     // Catch: Throwable -> L29
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L25 Throwable -> L29
    L29:
        th = move-exception;
        throw th;
    }

    public synchronized SinkInfoBean getLinkInfoByContent(String r100, Config r101) {
        monitor-enter(this);
        String r102 = doRequestTokenAndHostName("DownloadResource");     // Catch: Throwable -> L26
        String r103 = "";
        Logger.d("QRPinNetWork", "getLinkInfoByContent, config = " + r101);     // Catch: Throwable -> L26
        if (r101 == null) goto L9;
        String r104 = r101.getProjectId();     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r104) == true) goto L9;
        r103 = "&ProjectID=" + r104;     // Catch: Throwable -> L26
    L9:
        String r105 = this.hostName + "?" + r102 + "&Number=" + r100 + r103;     // Catch: Throwable -> L26
        Logger.i("QRPinNetWork", "getLinkInfoByContent url : " + r105);     // Catch: Throwable -> L26
        int r106 = 0;
    L29:
        Response r107 = this.httpNetWork.doPost(r105, "", Collections.emptyMap());     // Catch: Exception -> L21 Throwable -> L26
        Logger.i("QRPinNetWork", "getLinkInfoByContent response : " + r107);     // Catch: Exception -> L21 Throwable -> L26
        r106 = r106 + 1;     // Catch: Exception -> L21 Throwable -> L26
        int r108 = r107.code;     // Catch: Exception -> L21 Throwable -> L26
        if (r108 == 200) goto L15;
        if (r106 <= 3) goto L29;
    L15:
        if (r108 != 200) goto L23;
        JSONObject r109 = new JSONObject(r107.body).optJSONObject("Result");     // Catch: Exception -> L21 Throwable -> L26
        if (r109 == null) goto L23;
        String r110 = new String(Base64.decode(r109.optString("Data"), 2));     // Catch: Exception -> L21 Throwable -> L26
        Logger.i("QRPinNetWork", "getLinkInfoByContent data : " + r110);     // Catch: Exception -> L21 Throwable -> L26
        SinkInfoBean r111 = (SinkInfoBean) new Gson().fromJson(r110, SinkInfoBean.class);     // Catch: Exception -> L21 Throwable -> L26
        monitor-exit(this);
        return r111;
    L23:
        monitor-exit(this);
        return null;
    L21:
        e = move-exception;
        Logger.e("QRPinNetWork", e.toString());     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }
}
