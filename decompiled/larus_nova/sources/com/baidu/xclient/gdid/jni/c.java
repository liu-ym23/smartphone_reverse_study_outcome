package com.baidu.xclient.gdid.jni;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.xclient.gdid.j.d;
import com.bytedance.crypto.platform.PlatformConst;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.obric.sva.sdk.data.SettingsDAO;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes39.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile c f33646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Native f33647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f33648c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f33649d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f33650e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f33651f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f33652g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f33653h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f33654i;

    public c(Context r100) {
        this.f33648c = r100;
        this.f33647b = new Native();
    }

    public static c a(Context r100) {
        if (f33646a != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f33646a != null) goto L9;
        f33646a = new c(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f33646a;
    }

    public Object a(int r100, Object r101, Object r102, Object r103) {
        return this.f33647b.jnictl(r100, r101, r102, r103);
    L4:
        th = move-exception;
        d.a(th);
        return null;
    }

    public String a() {
        return this.f33647b.a();
    }

    public String a(String r100) {
        String r101 = null;
        r101 = (String) this.f33647b.jnictl(8, r100, null, null);     // Catch: Throwable -> L5
    L7:
        if (r101 != null) goto L12;
        return "";
    L12:
        return r101;
    L5:
        th = move-exception;
        d.a(th);
        goto L7
    }

    public byte[] a(byte[] r100) {
        if (r100 != null) goto L12;
    L11:
        return null;
    L12:
    L9:
        th = move-exception;
        d.a(th);
        goto L11
    L5:
        if (r100.length == 0) goto L11;
        byte[] r101 = new byte[8];     // Catch: Throwable -> L9
        new SecureRandom().nextBytes(r101);     // Catch: Throwable -> L9
        byte[] r102 = new byte[r100.length + 8];     // Catch: Throwable -> L9
        System.arraycopy(r101, 0, r102, 0, 8);     // Catch: Throwable -> L9
        System.arraycopy(r100, 0, r102, 8, r100.length);     // Catch: Throwable -> L9
        return (byte[]) this.f33647b.jnictl(12, r102, null, null);
    }

    public String b() {
        String r100 = null;
        r100 = (String) this.f33647b.jnictl(6, null, null, null);     // Catch: Throwable -> L5
    L7:
        if (r100 != null) goto L12;
        return "";
    L12:
        return r100;
    L5:
        th = move-exception;
        d.a(th);
        goto L7
    }

    public String b(String r100) {
        String r101 = null;
        byte[] r102 = (byte[]) this.f33647b.jnictl(9, r100, null, null);     // Catch: Throwable -> L7
        if (r102 == null) goto L9;
        r101 = new String(r102);     // Catch: Throwable -> L7
    L9:
        if (r101 != null) goto L14;
        return "";
    L14:
        return r101;
    L7:
        th = move-exception;
        d.a(th);
        goto L9
    }

    public int c() {
        String r100 = null;
        r100 = (String) this.f33647b.jnictl(7, null, null, null);     // Catch: Throwable -> L5
    L7:
        if (r100 != null) goto L11;
        return 0;
    L11:
        return CastIntegerProtector.parseInt(r100);
    L5:
        th = move-exception;
        d.a(th);
        goto L7
    }

    public String c(String r100) {
        String r101 = null;
        r101 = (String) this.f33647b.jnictl(10, r100, null, null);     // Catch: Throwable -> L5
    L7:
        if (r101 != null) goto L12;
        return "";
    L12:
        return r101;
    L5:
        th = move-exception;
        d.a(th);
        goto L7
    }

    public String d() {
        String r100 = null;
        r100 = (String) this.f33647b.jnictl(14, null, null, null);     // Catch: Throwable -> L5
    L8:
        if (TextUtils.isEmpty(r100) == false) goto L13;
        return "";
    L13:
        return r100;
    L5:
        th = move-exception;
        d.a(th);
        goto L8
    }

    public String d(String r100) {
        String r101 = null;
        r101 = (String) this.f33647b.jnictl(11, r100, null, null);     // Catch: Throwable -> L5
    L7:
        if (r101 != null) goto L12;
        return "";
    L12:
        return r101;
    L5:
        th = move-exception;
        d.a(th);
        goto L7
    }

    public String e() {
        return (String) this.f33647b.jnictl(17, null, null, null);
    L4:
        th = move-exception;
        d.a(th);
        return "";
    }

    public String e(String r100) {
        String r101 = (String) this.f33647b.jnictl(13, r100, null, null);     // Catch: Throwable -> L4
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L12;
        return HiAnalyticsConstant.REPORT_VAL_SEPARATOR;
    L12:
        return r101;
    L4:
        th = move-exception;
        d.a(th);
        r101 = "";
        goto L7
    }

    public String f() {
        if (com.baidu.sec.privacy.e.a.a(this.f33648c).a() == true) goto L7;
        return "";
    L7:
        if (TextUtils.isEmpty(this.f33649d) == false) goto L10;
        this.f33649d = c(PlatformConst.PROP_MANUFACTURER);
    L10:
        if (TextUtils.isEmpty(this.f33649d) == false) goto L13;
        this.f33649d = Build.MANUFACTURER;
    L13:
        return this.f33649d;
    }

    public String g() {
        if (com.baidu.sec.privacy.e.a.a(this.f33648c).a() == true) goto L7;
        return "";
    L7:
        if (TextUtils.isEmpty(this.f33650e) == false) goto L10;
        this.f33650e = c("ro.product.name");
    L10:
        if (TextUtils.isEmpty(this.f33650e) == false) goto L13;
        this.f33650e = Build.PRODUCT;
    L13:
        return this.f33650e;
    }

    public String h() {
        if (com.baidu.sec.privacy.e.a.a(this.f33648c).a() == true) goto L7;
        return "";
    L7:
        if (TextUtils.isEmpty(this.f33651f) == false) goto L10;
        this.f33651f = c(SettingsDAO.HARDWARE);
    L10:
        if (TextUtils.isEmpty(this.f33651f) == false) goto L13;
        this.f33651f = Build.HARDWARE;
    L13:
        return this.f33651f;
    }

    public String i() {
        if (com.baidu.sec.privacy.e.a.a(this.f33648c).a() == true) goto L7;
        return "";
    L7:
        if (TextUtils.isEmpty(this.f33652g) == false) goto L10;
        this.f33652g = c("ro.product.device");
    L10:
        if (TextUtils.isEmpty(this.f33652g) == false) goto L13;
        this.f33652g = Build.DEVICE;
    L13:
        return this.f33652g;
    }

    public String j() {
        if (com.baidu.sec.privacy.e.a.a(this.f33648c).a() == true) goto L7;
        return "";
    L7:
        if (TextUtils.isEmpty(this.f33653h) == false) goto L10;
        this.f33653h = c("ro.product.board");
    L10:
        if (TextUtils.isEmpty(this.f33653h) == false) goto L13;
        this.f33653h = Build.BOARD;
    L13:
        return this.f33653h;
    }

    public String k() {
        if (com.baidu.sec.privacy.e.a.a(this.f33648c).a() == true) goto L7;
        return "";
    L7:
        if (TextUtils.isEmpty(this.f33654i) == false) goto L10;
        this.f33654i = c("ro.product.brand");
    L10:
        if (TextUtils.isEmpty(this.f33654i) == false) goto L13;
        this.f33654i = Build.BRAND;
    L13:
        return this.f33654i;
    }
}
