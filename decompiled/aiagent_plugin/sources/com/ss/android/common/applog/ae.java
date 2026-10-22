package com.ss.android.common.applog;

/* JADX INFO: compiled from: UrlConfig.java */
/* JADX INFO: loaded from: classes4.dex */
public class ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ae f37150a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ae f37151b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final String[] f37152c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final String f37153d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final String[] f37154e;
    final String[] f;
    final String[] g;
    final String[] h;
    final String i;
    final String j;

    static {
        ae r9 = new ae(new String[]{"https://log.zijieapi.com/service/2/app_log/", "https://applog.zijieapi.com/service/2/app_log/"}, new String[]{"https://rtlog.zijieapi.com/service/2/app_log/"}, new String[]{"https://log.snssdk.com/service/2/device_register/", "https://log.snssdk.com/service/2/device_register/"}, new String[]{"https://ichannel.snssdk.com/service/2/app_alert_check/"}, "https://log.zijieapi.com/service/2/log_settings/", new String[]{"https://log.zijieapi.com/service/2/app_log/", "https://applog.zijieapi.com/service/2/app_log/"}, "https://log.zijieapi.com/service/2/log_settings/", "https://dpprofile.snssdk.com");
        f37150a = r9;
        f37151b = r9;
    }

    public ae(String[] r1, String[] r2, String[] r3, String[] r4, String r5, String[] r6, String r7, String r8) {
        this.f37152c = r1;
        this.f37153d = r5;
        this.f37154e = r2;
        this.f = r4;
        this.g = r3;
        this.h = r6;
        this.i = r7;
        this.j = r8;
    }

    public String toString() {
        return super.toString() + ":\nmApplogURL : " + this.f37152c + "\nmApplogTimelyUrl : " + this.f37154e + "\nmDeviceRegisterUrl : " + this.g + "\nmAppActiveUrl : " + this.f + "\nmApplogSettingsUrl : " + this.f37153d + "\n\nmApplogFallbackUrl : " + this.h + "\nmApplogSettingsFallbackUrl : " + this.i + "\nmUserProfileUrl : " + this.j + "\n\n\n\n";
    }
}
