package com.baidu.location.b;

import android.util.Base64;
import com.baidu.location.Jni;
import com.stepos.activeview.utils.Constants;
import com.stepos.alphame.utils.Consts;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private boolean f5369a;

    /* renamed from: b, reason: collision with root package name */
    private String[] f5370b;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static n f5371a = new n();
    }

    private n() {
        this.f5369a = false;
        this.f5370b = null;
        try {
            String str = Jni.getldkaiv();
            if (str == null || !str.contains(Consts.SPLITTER_DETAIL)) {
                return;
            }
            String[] strArrSplit = str.split("\\|");
            this.f5370b = strArrSplit;
            if (strArrSplit == null || strArrSplit.length != 2) {
                return;
            }
            this.f5369a = true;
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static n a() {
        return a.f5371a;
    }

    public synchronized String b(String str) {
        if (!this.f5369a) {
            return null;
        }
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(this.f5370b[1].getBytes(Constants.UTF_8_CODE));
            SecretKeySpec secretKeySpec = new SecretKeySpec(this.f5370b[0].getBytes(Constants.UTF_8_CODE), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return new String(cipher.doFinal(Base64.decode(str, 0)), Constants.UTF_8_CODE);
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public synchronized String a(String str) {
        if (this.f5369a) {
            try {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(this.f5370b[1].getBytes(Constants.UTF_8_CODE));
                SecretKeySpec secretKeySpec = new SecretKeySpec(this.f5370b[0].getBytes(Constants.UTF_8_CODE), "AES");
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
                cipher.init(1, secretKeySpec, ivParameterSpec);
                return Base64.encodeToString(cipher.doFinal(str.getBytes()), 0);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return null;
    }

    public boolean b() {
        return this.f5369a;
    }
}
