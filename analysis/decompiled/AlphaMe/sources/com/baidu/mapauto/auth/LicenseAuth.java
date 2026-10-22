package com.baidu.mapauto.auth;

import android.content.Context;
import com.baidu.mapauto.auth.AuthCore;
import com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess;
import com.baidu.mapauto.auth.constant.ErrorCode;
import com.baidu.mapauto.auth.util.LogUtil;
import java.util.Map;

/* loaded from: classes.dex */
public final class LicenseAuth {

    /* renamed from: b, reason: collision with root package name */
    public static volatile LicenseAuth f7651b;

    /* renamed from: a, reason: collision with root package name */
    public final AuthCore f7652a = new AuthCore();

    public static LicenseAuth getInstance() {
        if (f7651b == null) {
            synchronized (LicenseAuth.class) {
                try {
                    if (f7651b == null) {
                        f7651b = new LicenseAuth();
                    }
                } finally {
                }
            }
        }
        return f7651b;
    }

    public void loadAuth(Context context, String str, String str2, String str3, String str4, int i4, ILicenseAuthListener iLicenseAuthListener) {
        loadAuth(context, str, str2, str3, str4, null, i4, null, iLicenseAuthListener);
    }

    public Map<String, Integer> loadLocalAuth(Context context, String str, String str2, int i4) throws BaseLicenseAuthDataStandardProcess.ProcessException {
        return this.f7652a.a(context, null, null, null, str, str2, i4);
    }

    public void setDebug(Boolean bool) {
        LogUtil.getInstance().openLog(bool);
    }

    public void loadAuth(Context context, String str, String str2, String str3, String str4, int i4, Map<String, Object> map, ILicenseAuthListener iLicenseAuthListener) {
        loadAuth(context, str, str2, str3, str4, null, i4, map, iLicenseAuthListener);
    }

    public Map<String, Integer> loadLocalAuth(Context context, String str, String str2, String str3, int i4) throws BaseLicenseAuthDataStandardProcess.ProcessException {
        return this.f7652a.a(context, null, null, str, str2, str3, i4);
    }

    public void loadAuth(Context context, String str, String str2, String str3, String str4, String str5, int i4, Map<String, Object> map, ILicenseAuthListener iLicenseAuthListener) {
        String str6;
        AuthCore authCore = this.f7652a;
        Context applicationContext = context.getApplicationContext();
        AuthCore.AuthParam authParam = new AuthCore.AuthParam(str, str2, str3, str4, str5, map);
        authCore.getClass();
        LogUtil.getInstance().i(AuthCore.TAG, "开始授权");
        AuthCore.b bVar = new AuthCore.b(iLicenseAuthListener);
        if (applicationContext == null) {
            str6 = "context 不可以为空";
        } else {
            if (authParam.a(i4)) {
                authCore.f7641g = authParam.b();
                authCore.f7642h = authParam.d();
                authCore.f7643i = authParam.c();
                if (authCore.f7636b == null) {
                    synchronized (AuthCore.class) {
                        try {
                            if (authCore.f7636b == null) {
                                authCore.f7636b = new com.baidu.mapauto.auth.data.license.impl.b(new com.baidu.mapauto.auth.store.a(applicationContext));
                            }
                        } finally {
                        }
                    }
                }
                if (authCore.f7639e == null) {
                    synchronized (AuthCore.class) {
                        try {
                            if (authCore.f7639e == null) {
                                authCore.f7639e = new com.baidu.mapauto.auth.process.a(3, authCore.f7635a, authCore.f7636b);
                            }
                        } finally {
                        }
                    }
                }
                if (authCore.f7640f == null) {
                    synchronized (AuthCore.class) {
                        try {
                            if (authCore.f7640f == null) {
                                authCore.f7640f = new com.baidu.mapauto.auth.process.b(3, authCore.f7635a, authCore.f7636b);
                            }
                        } finally {
                        }
                    }
                }
                if (authCore.f7636b instanceof com.baidu.mapauto.auth.data.license.impl.b) {
                    com.baidu.mapauto.auth.data.license.impl.b bVar2 = authCore.f7636b;
                    String strB = authParam.b();
                    authParam.c();
                    authParam.e();
                    Object obj = authParam.get("function_name");
                    if (obj instanceof String) {
                    }
                    String strD = authParam.d();
                    bVar2.getClass();
                    bVar2.f7670b = strB + strD;
                }
                authCore.f7637c.submit(new b(authCore, i4, bVar, authParam));
                return;
            }
            str6 = "参数错误, 请确保 ak, channel, serviceName 、 file 类型下时的 deviceId 不为空";
        }
        bVar.onError(ErrorCode.CODE_PARAMETER_ERROR, str6);
    }

    public Map<String, Integer> loadLocalAuth(Context context, String str, String str2, String str3, String str4, String str5, int i4) throws BaseLicenseAuthDataStandardProcess.ProcessException {
        return this.f7652a.a(context, str, str3, str2, str4, str5, i4);
    }
}
