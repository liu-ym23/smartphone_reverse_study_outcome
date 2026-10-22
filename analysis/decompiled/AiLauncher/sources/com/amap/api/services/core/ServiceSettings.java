package com.amap.api.services.core;

import M1.a;
import android.content.Context;
import com.amap.api.col.jmsl.A0;
import com.amap.api.col.jmsl.C1535b0;
import com.amap.api.col.jmsl.C1607t1;
import com.amap.api.col.jmsl.C1631z1;
import com.amap.api.col.jmsl.T2;
import com.amap.api.col.jmsl.r5;
import com.amap.api.col.jmsl.s7;
import com.autonavi.aps.amapapi.config.Const;

/* loaded from: classes.dex */
public class ServiceSettings {
    public static final String CHINESE = "zh-Hans";
    public static final String ENGLISH = "en";
    public static final int HTTP = 1;
    public static final int HTTPS = 2;

    /* renamed from: d, reason: collision with root package name */
    private static ServiceSettings f17389d;

    /* renamed from: a, reason: collision with root package name */
    private int f17390a = 1;

    /* renamed from: b, reason: collision with root package name */
    private int f17391b = 20000;

    /* renamed from: c, reason: collision with root package name */
    private int f17392c = 20000;

    static {
        a.d("ZH", 0);
    }

    private ServiceSettings() {
    }

    public static ServiceSettings getInstance() {
        if (f17389d == null) {
            f17389d = new ServiceSettings();
        }
        return f17389d;
    }

    public static synchronized void updatePrivacyAgree(Context context, boolean z10) {
        r5.g(context, z10, T2.a(false));
    }

    public static synchronized void updatePrivacyShow(Context context, boolean z10, boolean z11) {
        r5.h(context, z10, z11, T2.a(false));
    }

    public void destroyInnerAsynThreadPool() {
        try {
            C1535b0.a();
        } catch (Throwable th) {
            C1631z1.o(th, "ServiceSettings", "destroyInnerAsynThreadPool");
        }
    }

    public int getConnectionTimeOut() {
        return this.f17391b;
    }

    public String getLanguage() {
        switch (a.c()) {
            case 1:
                return "zh-Hant-HK";
            case 2:
                return "en";
            case 3:
                return "es";
            case 4:
                return "pt";
            case 5:
                return Const.SP_KEY_FIRSTLOC_RELOC;
            case 6:
                return "de";
            case 7:
                return "th";
            case 8:
                return "ja";
            case 9:
                return "ko";
            case 10:
                return "ar";
            case 11:
                return "tr";
            case 12:
                return "he";
            case 13:
                return "it";
            case 14:
                return "ru";
            case 15:
                return Const.SP_KEY_GSM_UPLOAD_MXSIZE;
            case 16:
                return "id";
            case 17:
                return "vi";
            case 18:
                return "pl";
            case 19:
                return "cs";
            case 20:
                return "uk";
            case 21:
                return "az";
            default:
                return CHINESE;
        }
    }

    public int getProtocol() {
        return this.f17390a;
    }

    public int getSoTimeOut() {
        return this.f17392c;
    }

    public void setApiKey(String str) {
        A0.b(str);
    }

    public void setConnectionTimeOut(int i10) {
        if (i10 < 5000) {
            this.f17391b = s7.DEFAULT_RETRY_TIMEOUT;
        } else if (i10 > 30000) {
            this.f17391b = Const.I_LOC_JUMP_DELAY;
        } else {
            this.f17391b = i10;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0011  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x011c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setLanguage(java.lang.String r3) {
        /*
            Method dump skipped, instructions count: 289
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.core.ServiceSettings.setLanguage(java.lang.String):void");
    }

    public void setProtocol(int i10) {
        this.f17390a = i10;
        C1607t1.a().e(this.f17390a == 2);
    }

    public void setSoTimeOut(int i10) {
        if (i10 < 5000) {
            this.f17392c = s7.DEFAULT_RETRY_TIMEOUT;
        } else if (i10 > 30000) {
            this.f17392c = Const.I_LOC_JUMP_DELAY;
        } else {
            this.f17392c = i10;
        }
    }
}
