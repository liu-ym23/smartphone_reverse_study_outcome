package com.baidu.xclient.gdid.jni;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.xclient.gdid.j.d;
import com.stepos.alphame.utils.Consts;
import java.security.SecureRandom;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static volatile c f9557a;

    /* renamed from: b, reason: collision with root package name */
    public Native f9558b = new Native();

    /* renamed from: c, reason: collision with root package name */
    public Context f9559c;

    /* renamed from: d, reason: collision with root package name */
    public String f9560d;

    /* renamed from: e, reason: collision with root package name */
    public String f9561e;

    /* renamed from: f, reason: collision with root package name */
    public String f9562f;

    /* renamed from: g, reason: collision with root package name */
    public String f9563g;

    /* renamed from: h, reason: collision with root package name */
    public String f9564h;

    /* renamed from: i, reason: collision with root package name */
    public String f9565i;

    public c(Context context) {
        this.f9559c = context;
    }

    public static c a(Context context) {
        if (f9557a == null) {
            synchronized (c.class) {
                try {
                    if (f9557a == null) {
                        f9557a = new c(context);
                    }
                } finally {
                }
            }
        }
        return f9557a;
    }

    public String b() {
        String str = null;
        try {
            str = (String) this.f9558b.jnictl(6, null, null, null);
        } catch (Throwable th) {
            d.a(th);
        }
        return str == null ? "" : str;
    }

    public int c() {
        String str = null;
        try {
            str = (String) this.f9558b.jnictl(7, null, null, null);
        } catch (Throwable th) {
            d.a(th);
        }
        if (str == null) {
            return 0;
        }
        return Integer.parseInt(str);
    }

    public String d() {
        String str = null;
        try {
            str = (String) this.f9558b.jnictl(14, null, null, null);
        } catch (Throwable th) {
            d.a(th);
        }
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public String e() {
        try {
            return (String) this.f9558b.jnictl(17, null, null, null);
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }

    public String f() {
        if (!com.baidu.sec.privacy.e.a.a(this.f9559c).a()) {
            return "";
        }
        if (TextUtils.isEmpty(this.f9560d)) {
            this.f9560d = c("ro.product.manufacturer");
        }
        if (TextUtils.isEmpty(this.f9560d)) {
            this.f9560d = Build.MANUFACTURER;
        }
        return this.f9560d;
    }

    public String g() {
        if (!com.baidu.sec.privacy.e.a.a(this.f9559c).a()) {
            return "";
        }
        if (TextUtils.isEmpty(this.f9561e)) {
            this.f9561e = c("ro.product.name");
        }
        if (TextUtils.isEmpty(this.f9561e)) {
            this.f9561e = Build.PRODUCT;
        }
        return this.f9561e;
    }

    public String h() {
        if (!com.baidu.sec.privacy.e.a.a(this.f9559c).a()) {
            return "";
        }
        if (TextUtils.isEmpty(this.f9562f)) {
            this.f9562f = c("ro.hardware");
        }
        if (TextUtils.isEmpty(this.f9562f)) {
            this.f9562f = Build.HARDWARE;
        }
        return this.f9562f;
    }

    public String i() {
        if (!com.baidu.sec.privacy.e.a.a(this.f9559c).a()) {
            return "";
        }
        if (TextUtils.isEmpty(this.f9563g)) {
            this.f9563g = c("ro.product.device");
        }
        if (TextUtils.isEmpty(this.f9563g)) {
            this.f9563g = Build.DEVICE;
        }
        return this.f9563g;
    }

    public String j() {
        if (!com.baidu.sec.privacy.e.a.a(this.f9559c).a()) {
            return "";
        }
        if (TextUtils.isEmpty(this.f9564h)) {
            this.f9564h = c("ro.product.board");
        }
        if (TextUtils.isEmpty(this.f9564h)) {
            this.f9564h = Build.BOARD;
        }
        return this.f9564h;
    }

    public String k() {
        if (!com.baidu.sec.privacy.e.a.a(this.f9559c).a()) {
            return "";
        }
        if (TextUtils.isEmpty(this.f9565i)) {
            this.f9565i = c("ro.product.brand");
        }
        if (TextUtils.isEmpty(this.f9565i)) {
            this.f9565i = Build.BRAND;
        }
        return this.f9565i;
    }

    public Object a(int i4, Object obj, Object obj2, Object obj3) {
        try {
            return this.f9558b.jnictl(i4, obj, obj2, obj3);
        } catch (Throwable th) {
            d.a(th);
            return null;
        }
    }

    public String b(String str) {
        String str2 = null;
        try {
            byte[] bArr = (byte[]) this.f9558b.jnictl(9, str, null, null);
            if (bArr != null) {
                str2 = new String(bArr);
            }
        } catch (Throwable th) {
            d.a(th);
        }
        return str2 == null ? "" : str2;
    }

    public String c(String str) {
        String str2 = null;
        try {
            str2 = (String) this.f9558b.jnictl(10, str, null, null);
        } catch (Throwable th) {
            d.a(th);
        }
        return str2 == null ? "" : str2;
    }

    public String d(String str) {
        String str2 = null;
        try {
            str2 = (String) this.f9558b.jnictl(11, str, null, null);
        } catch (Throwable th) {
            d.a(th);
        }
        return str2 == null ? "" : str2;
    }

    public String e(String str) {
        String str2;
        try {
            str2 = (String) this.f9558b.jnictl(13, str, null, null);
        } catch (Throwable th) {
            d.a(th);
            str2 = "";
        }
        return TextUtils.isEmpty(str2) ? Consts.SPLITTER_DETAIL : str2;
    }

    public String a() {
        return this.f9558b.a();
    }

    public String a(String str) {
        String str2 = null;
        try {
            str2 = (String) this.f9558b.jnictl(8, str, null, null);
        } catch (Throwable th) {
            d.a(th);
        }
        return str2 == null ? "" : str2;
    }

    public byte[] a(byte[] bArr) {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    byte[] bArr2 = new byte[8];
                    new SecureRandom().nextBytes(bArr2);
                    byte[] bArr3 = new byte[bArr.length + 8];
                    System.arraycopy(bArr2, 0, bArr3, 0, 8);
                    System.arraycopy(bArr, 0, bArr3, 8, bArr.length);
                    return (byte[]) this.f9558b.jnictl(12, bArr3, null, null);
                }
            } catch (Throwable th) {
                d.a(th);
            }
        }
        return null;
    }
}
