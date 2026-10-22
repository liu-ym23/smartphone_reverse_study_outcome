package com.baidu.mapauto.auth.base;

import android.text.TextUtils;
import com.baidu.mapauto.auth.AuthCore;
import com.baidu.mapauto.auth.base.b;
import com.baidu.mapauto.auth.constant.ErrorCode;
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
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class BaseLicenseAuthDataStandardProcess<T extends b, Z> {

    /* renamed from: a, reason: collision with root package name */
    public final int f7662a;

    public static class ProcessException extends Exception {
        private final int mCode;

        public ProcessException(int i4, String str) {
            super(str);
            this.mCode = i4;
        }

        public int getCode() {
            return this.mCode;
        }
    }

    public BaseLicenseAuthDataStandardProcess(int i4) {
        this.f7662a = i4;
    }

    public abstract T a(String str);

    public abstract ArrayList a(int i4, AuthCore.AuthParam authParam, b bVar);

    public void a(b bVar) throws ProcessException {
    }

    public abstract boolean a(AuthCore.AuthParam authParam, T t4);

    public abstract String b(AuthCore.AuthParam authParam);

    public abstract HashMap b(b bVar);

    public abstract com.baidu.mapauto.auth.net.b c(AuthCore.AuthParam authParam) throws Exception;

    public final Map<String, Integer> a(AuthCore.AuthParam authParam) throws ProcessException, InterruptedException {
        com.baidu.mapauto.auth.net.b bVarC;
        int i4;
        Integer num;
        LogUtil logUtil;
        String str;
        if ((this.f7662a & 1) == 1) {
            LogUtil.getInstance().i("BaseLicenseAuthDataStandardProcess", "开始请求 license  服务 ==>");
            KeyPair keyPairGenerateKeyPair = RSAUtil.generateKeyPair();
            if (keyPairGenerateKeyPair == null) {
                logUtil = LogUtil.getInstance();
                str = "生成公私钥错误";
            } else {
                String publicKeyCS1Pem = RSAUtil.getPublicKeyCS1Pem(keyPairGenerateKeyPair.getPublic());
                if (publicKeyCS1Pem == null) {
                    logUtil = LogUtil.getInstance();
                    str = "生成公钥为空";
                } else {
                    authParam.put("public_key", publicKeyCS1Pem);
                    try {
                        authParam.put("private_key", RSAUtil.getPrivateKeyStr(keyPairGenerateKeyPair.getPrivate()));
                        int i5 = 1;
                        while (true) {
                            try {
                                bVarC = c(authParam);
                            } catch (Exception e4) {
                                LogUtil.getInstance().e("BaseLicenseAuthDataStandardProcess", e4.toString());
                                com.baidu.mapauto.auth.net.b bVar = new com.baidu.mapauto.auth.net.b();
                                bVar.f7677d = e4;
                                bVarC = bVar;
                            }
                            if (i5 >= 3 || (bVarC != null && bVarC.f7677d == null && (num = bVarC.f7674a) != null && num.intValue() == 200 && !TextUtils.isEmpty(bVarC.f7676c))) {
                                break;
                            }
                            try {
                                Thread.sleep(500L);
                            } catch (InterruptedException e5) {
                                LogUtil.getInstance().e("BaseLicenseAuthDataStandardProcess", e5.toString());
                            }
                            i5++;
                        }
                    } catch (Exception e6) {
                        LogUtil.getInstance().e("BaseLicenseAuthDataStandardProcess", e6.toString());
                    }
                    LogUtil.getInstance().i("BaseLicenseAuthDataStandardProcess", "<== license 服务返回结果:" + bVarC);
                    i4 = 0;
                }
            }
            logUtil.i("BaseLicenseAuthDataStandardProcess", str);
            bVarC = null;
            LogUtil.getInstance().i("BaseLicenseAuthDataStandardProcess", "<== license 服务返回结果:" + bVarC);
            i4 = 0;
        } else {
            bVarC = null;
            i4 = -1;
        }
        String strB = bVarC == null ? "" : bVarC.f7676c;
        if (TextUtils.isEmpty(strB) && (this.f7662a & 2) == 2) {
            LogUtil.getInstance().i("BaseLicenseAuthDataStandardProcess", "尝试从本地缓存获取 ==>");
            strB = b(authParam);
            LogUtil.getInstance().i("BaseLicenseAuthDataStandardProcess", "<== 本地缓存服务返回结果:" + strB);
            i4 = 1;
        }
        if (i4 == -1) {
            return new HashMap(0);
        }
        if (TextUtils.isEmpty(strB)) {
            if (bVarC == null) {
                throw new ProcessException(ErrorCode.CODE_INNER_ERROR, "获取数据异常");
            }
            Exception exc = bVarC.f7677d;
            if (exc instanceof SocketTimeoutException) {
                throw new ProcessException(ErrorCode.CODE_NET_WORK_TIMEOUT, "网络超时");
            }
            if ((exc instanceof HttpRetryException) || (exc instanceof MalformedURLException) || (exc instanceof ProtocolException) || (exc instanceof URISyntaxException) || (exc instanceof SocketException)) {
                throw new ProcessException(ErrorCode.CODE_NET_WORK_ERROR, "网络链接异常");
            }
            if ((exc instanceof UnknownHostException) || (exc instanceof UnknownServiceException)) {
                throw new ProcessException(ErrorCode.CODE_SERVER_ERROR, "服务异常");
            }
            throw new ProcessException(ErrorCode.CODE_UNKNOWN_ERROR, "网络未知异常");
        }
        b bVarA = a(strB);
        JSONObject jSONObject = bVarA.f7667b;
        if (jSONObject == null) {
            throw new ProcessException(ErrorCode.CODE_INNER_ERROR, a(bVarC, "license 数据解析错误"));
        }
        if (jSONObject == null || jSONObject.optInt("status", -1) != 0) {
            JSONObject jSONObject2 = bVarA.f7667b;
            int iOptInt = jSONObject2 != null ? jSONObject2.optInt("status", -1) : -1;
            JSONObject jSONObject3 = bVarA.f7667b;
            String strOptString = jSONObject3 != null ? jSONObject3.optString("message") : null;
            if (TextUtils.isEmpty(strOptString)) {
                strOptString = "license 数据服务错误";
            }
            throw new ProcessException(iOptInt, a(bVarC, strOptString));
        }
        LogUtil.getInstance().i("BaseLicenseAuthDataStandardProcess", "开始校验 license 数据");
        ArrayList<a> arrayListA = a(i4, authParam, bVarA);
        if (arrayListA != null && !arrayListA.isEmpty()) {
            for (a aVar : arrayListA) {
                int i6 = aVar.f7663a;
                AuthCore.AuthParam authParam2 = aVar.f7664b;
                T t4 = aVar.f7665c;
                if ((i6 != 0 && i6 != 1) || authParam2 == null || t4 == 0 || !aVar.a(i6, authParam2, t4)) {
                    throw new ProcessException(ErrorCode.CODE_CHECK_SIGN_ERROR, a(bVarC, "license 校验失败"));
                }
            }
        }
        LogUtil.getInstance().i("BaseLicenseAuthDataStandardProcess", "校验 license 数据完成");
        if (i4 == 0) {
            LogUtil.getInstance().i("BaseLicenseAuthDataStandardProcess", "更新本地 license 缓存");
            a(authParam, (AuthCore.AuthParam) bVarA);
        }
        LogUtil.getInstance().i("BaseLicenseAuthDataStandardProcess", "数据通过接入点开始");
        a(bVarA);
        LogUtil.getInstance().i("BaseLicenseAuthDataStandardProcess", "数据通过接入点结束");
        return b(bVarA);
    }

    public static String a(com.baidu.mapauto.auth.net.b bVar, String str) {
        Integer num;
        if (bVar == null || (num = bVar.f7674a) == null || num.intValue() == 200) {
            return str;
        }
        return "(" + num + ")" + str;
    }
}
