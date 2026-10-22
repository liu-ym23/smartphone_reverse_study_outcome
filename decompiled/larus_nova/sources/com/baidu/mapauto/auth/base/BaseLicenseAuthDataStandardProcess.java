package com.baidu.mapauto.auth.base;

import android.text.TextUtils;
import com.baidu.mapauto.auth.AuthCore;
import com.baidu.mapauto.auth.base.b;
import com.baidu.mapauto.auth.util.LogUtil;
import com.baidu.mapauto.auth.util.RSAUtil;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.security.KeyPair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public abstract class BaseLicenseAuthDataStandardProcess<T extends b, Z> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f31782a;

    public static class ProcessException extends Exception {
        private Map<String, Integer> errors;
        private final int mCode;

        public ProcessException(int r100, String r101) {
            super(r101);
            this.mCode = r100;
        }

        public int getCode() {
            return this.mCode;
        }

        public Map<String, Integer> getErrors() {
            return this.errors;
        }

        public void setErrors(Map<String, Integer> r100) {
            this.errors = r100;
        }
    }

    public BaseLicenseAuthDataStandardProcess(int r100) {
        this.f31782a = r100;
    }

    public abstract T a(String r100);

    public abstract ArrayList a(int r100, AuthCore.AuthParam r101, b r102);

    public abstract HashMap a(b r100);

    public void a(AuthCore.AuthParam r100, b r101) throws ProcessException {
    }

    public abstract String b(AuthCore.AuthParam r100);

    public abstract boolean b(AuthCore.AuthParam r100, T r101);

    public abstract com.baidu.mapauto.auth.net.b c(AuthCore.AuthParam r100) throws Exception;

    public final Map<String, Integer> a(AuthCore.AuthParam r110) throws ProcessException {
        boolean r100 = true;
        String r101 = null;
        int r102 = -1;
        if ((this.f31782a & 1) != 1) goto L44;
        LogUtil.getInstance().i("BaseLicenseAuthDataStandardProcess", "开始请求 license  服务 ==>");
        KeyPair r103 = RSAUtil.generateKeyPair();
        if (r103 != null) goto L9;
        LogUtil r104 = LogUtil.getInstance();
        String r105 = "生成公私钥错误";
    L7:
        r104.i("BaseLicenseAuthDataStandardProcess", r105);
    L8:
        com.baidu.mapauto.auth.net.b r106 = null;
    L43:
        LogUtil.getInstance().i("BaseLicenseAuthDataStandardProcess", "<== license 服务返回结果:" + r106);
        int r107 = 0;
    L45:
        if (r106 != null) goto L47;
        String r108 = "";
    L49:
        if (TextUtils.isEmpty(r108) == true) goto L51;
    L53:
        if (r107 != (-1)) goto L57;
        return new HashMap(0);
    L57:
        if (TextUtils.isEmpty(r108) == true) goto L59;
        b r109 = a(r108);
        JSONObject r111 = r109.f31787b;
        if (r111 != null) goto L93;
        boolean r112 = true;
    L94:
        if (r112 == true) goto L144;
        if (r111 != null) goto L99;
    L101:
        boolean r113 = false;
    L102:
        if (r113 == true) goto L116;
        JSONObject r114 = r109.f31787b;
        if (r114 == null) goto L107;
        r102 = r114.optInt("status", -1);
    L107:
        JSONObject r115 = r109.f31787b;
        if (r115 == null) goto L112;
        r101 = r115.optString("message");
    L112:
        if (TextUtils.isEmpty(r101) == false) goto L115;
        r101 = "license 数据服务错误";
    L115:
        throw new ProcessException(r102, a(r106, r101));
    L116:
        LogUtil.getInstance().i("BaseLicenseAuthDataStandardProcess", "开始校验 license 数据");
        ArrayList r116 = a(r107, r110, r109);
        if (r116 != null) goto L119;
    L135:
        if (r100 == false) goto L142;
        LogUtil.getInstance().i("BaseLicenseAuthDataStandardProcess", "校验 license 数据完成");
        if (r107 != 0) goto L139;
        LogUtil.getInstance().i("BaseLicenseAuthDataStandardProcess", "更新本地 license 缓存");
        b(r110, r109);
    L139:
        LogUtil.getInstance().i("BaseLicenseAuthDataStandardProcess", "数据通过接入点开始");
        a(r110, r109);
        LogUtil.getInstance().i("BaseLicenseAuthDataStandardProcess", "数据通过接入点结束");
        return a(r109);
    L142:
        throw new ProcessException(-1006, a(r106, "license 校验失败"));
    L119:
        if (r116.isEmpty() == true) goto L135;
        Iterator r117 = r116.iterator();
    L123:
        if (r117.hasNext() == false) goto L135;
        a r118 = (a) r117.next();
        int r119 = r118.f31783a;
        AuthCore.AuthParam r120 = r118.f31784b;
        T r121 = r118.f31785c;
        if (r119 == 0) goto L128;
        if (r119 == 1) goto L128;
    L131:
        boolean r122 = false;
    L133:
        if (r122 == true) goto L123;
        r100 = false;
    L128:
        if (r120 == null) goto L131;
        if (r121 == 0) goto L131;
        r122 = r118.a(r119, r120, r121);
        goto L133
    L99:
        if (r111.optInt("status", -1) != 0) goto L101;
        r113 = true;
        goto L102
    L144:
        throw new ProcessException(-1001, a(r106, "license 数据解析错误"));
    L93:
        r112 = false;
        goto L94
    L59:
        if ((this.f31782a & 1) != 1) goto L89;
        if (r106 == null) goto L87;
        Exception r123 = r106.f31797d;
        if ((r123 instanceof SocketTimeoutException) == true) goto L85;
        if ((r123 instanceof HttpRetryException) == true) goto L83;
        if ((r123 instanceof MalformedURLException) == true) goto L83;
        if ((r123 instanceof ProtocolException) == true) goto L83;
        if ((r123 instanceof URISyntaxException) == true) goto L83;
        if ((r123 instanceof SocketException) == true) goto L83;
        if ((r123 instanceof UnknownHostException) == true) goto L81;
        if ((r123 instanceof UnknownServiceException) == true) goto L81;
        throw new ProcessException(-1000, "网络未知异常");
    L81:
        throw new ProcessException(-1005, "服务异常");
    L83:
        throw new ProcessException(-1003, "网络链接异常");
    L85:
        throw new ProcessException(-1004, "网络超时");
    L87:
        throw new ProcessException(-1001, "获取数据异常");
    L89:
        throw new ProcessException(-1007, "获取本地数据异常，本地无License文件");
    L51:
        if ((this.f31782a & 2) != 2) goto L53;
        LogUtil.getInstance().i("BaseLicenseAuthDataStandardProcess", "尝试从本地缓存获取 ==>");
        r108 = b(r110);
        LogUtil.getInstance().i("BaseLicenseAuthDataStandardProcess", "<== 本地缓存服务返回结果:" + r108);
        r107 = 1;
        goto L53
    L47:
        r108 = r106.f31796c;
        goto L49
    L9:
        String r124 = RSAUtil.getPublicKeyCS1Pem(r103.getPublic());
        if (r124 != null) goto L12;
        r104 = LogUtil.getInstance();
        r105 = "生成公钥为空";
        goto L7
    L12:
        r110.put("public_key", r124);
        r110.put("private_key", RSAUtil.getPrivateKeyStr(r103.getPrivate()));     // Catch: Exception -> L41
        int r125 = 1;
    L149:
        r106 = c(r110);     // Catch: Exception -> L17
    L20:
        if (r125 >= 3) goto L43;
        if (r106 != null) goto L25;
    L32:
        boolean r126 = true;
    L34:
        if (r126 == false) goto L43;
        Thread.sleep(500);     // Catch: InterruptedException -> L38
    L40:
        r125 = r125 + 1;
    L38:
        e = move-exception;
        LogUtil.getInstance().e("BaseLicenseAuthDataStandardProcess", e.toString());
        goto L40
    L25:
        if (r106.f31797d != null) goto L32;
        Integer r127 = r106.f31794a;
        if (r127 == null) goto L32;
        if (r127.intValue() != 200) goto L32;
        r126 = TextUtils.isEmpty(r106.f31796c);
    L17:
        e = move-exception;
        LogUtil.getInstance().e("BaseLicenseAuthDataStandardProcess", e.toString());
        com.baidu.mapauto.auth.net.b r128 = new com.baidu.mapauto.auth.net.b();
        r128.f31797d = e;
        r106 = r128;
    L41:
        e = move-exception;
        LogUtil.getInstance().e("BaseLicenseAuthDataStandardProcess", e.toString());
        goto L8
    L44:
        r106 = null;
        r107 = -1;
        goto L45
    }

    public static String a(com.baidu.mapauto.auth.net.b r100, String r101) {
        if (r100 != null) goto L4;
        return r101;
    L4:
        Integer r102 = r100.f31794a;
        if (r102 != null) goto L8;
        return r101;
    L8:
        if (r102.intValue() != 200) goto L11;
        return r101;
    L11:
        return "(" + r102 + ")" + r101;
    }
}
