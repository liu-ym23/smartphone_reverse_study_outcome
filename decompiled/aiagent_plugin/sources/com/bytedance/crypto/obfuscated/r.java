package com.bytedance.crypto.obfuscated;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Log;
import com.bytedance.crypto.utils.CryptoConst;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public abstract class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SecretKeySpec f7876a;

    public static SecretKey a() {
        KeyStore r1 = KeyStore.getInstance("AndroidKeyStore");
        r1.load(null);
        if (r1.containsAlias("secret_master_key") == true) goto L7;
        KeyGenerator r0 = KeyGenerator.getInstance(CryptoConst.ALGORITHM_AES, "AndroidKeyStore");
        r0.init(new KeyGenParameterSpec.Builder("secret_master_key", 3).setBlockModes(new String[]{"GCM"}).setEncryptionPaddings(new String[]{"NoPadding"}).setRandomizedEncryptionRequired(false).setKeySize(256).build());
        return r0.generateKey();
    L7:
        return (SecretKey) ZeusTransformUtils.preCheckCast(r1.getKey("secret_master_key", null), SecretKey.class, "com.obric.aiagent.plugin");
    }

    public static SecretKeySpec a(Context r17, String r18) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r17, Context.class, "com.obric.aiagent.plugin");
        m r0 = m.a(r2);
        r0.getClass();
        a("a", "queryKey, alias: ".concat(r18));
        Cursor r1 = r0.getReadableDatabase().query("key_item", null, "alias =? ", new String[]{r18}, null, null, null);
        if (r1 != null) goto L7;
        b("a", "queryKey cursor is null");
    L5:
        p r10 = null;
    L13:
        String r3 = r2.getPackageName() + r18;
        if (r10 != null) goto L42;
        a("d", "Generate new key");
        byte[] r11 = new byte[32];
        new SecureRandom().nextBytes(r11);
        byte[] r13 = new byte[12];
        new SecureRandom().nextBytes(r13);
        byte[] r4 = r3.getBytes(StandardCharsets.UTF_8);
        GCMParameterSpec r5 = new GCMParameterSpec(128, r13);     // Catch: Exception -> L27
        Cipher r12 = Cipher.getInstance("AES/GCM/NoPadding");     // Catch: Exception -> L27
        SecretKey r14 = a();     // Catch: Exception -> L27
        String r16 = CryptoConst.ALGORITHM_AES;
        r12.init(1, r14, r5);     // Catch: Exception -> L25
        if (r4 != null) goto L21;
    L23:
        byte[] r6 = r12.doFinal(r11);     // Catch: Exception -> L25
    L30:
        if (r6 != null) goto L32;
    L40:
        b("d", "Encrypt data key failed!!");
        return null;
    L32:
        if (r6.length == 0) goto L40;
        String r7 = q.a(r13);
        String r8 = q.a(r6);
        m r9 = m.a(r2);
        r9.getClass();
        a("a", "insertKey, alias: ".concat(r18));
        SQLiteDatabase r15 = r9.getWritableDatabase();
        ContentValues r19 = new ContentValues();
        r19.put("alias", r18);
        r19.put("version", 1);
        r19.put("cipher", r8);
        r19.put("iv", r7);
        r19.put("extra", "");
        if (r15.insert("key_item", null, r19) != (-1)) goto L39;
        b("d", "Insert key to db failed!!");
        return null;
    L39:
        return new SecretKeySpec(r11, r16);
    L21:
        if (r4.length <= 0) goto L23;
        r12.updateAAD(r4);     // Catch: Exception -> L25
    L25:
        e = e;
    L29:
        b("d", "xcryptByKeyStore failed, error:" + e.getMessage());
        e.printStackTrace();
        r6 = new byte[0];
    L27:
        e = e;
        r16 = CryptoConst.ALGORITHM_AES;
        goto L29
    L42:
        a("d", "Get key from db");
        byte[] r20 = q.a(r10.f7875b);
        byte[] r21 = q.a(r10.f7874a);
        byte[] r22 = r3.getBytes(StandardCharsets.UTF_8);
        GCMParameterSpec r23 = new GCMParameterSpec(128, r20);     // Catch: Exception -> L50
        Cipher r24 = Cipher.getInstance("AES/GCM/NoPadding");     // Catch: Exception -> L50
        r24.init(2, a(), r23);     // Catch: Exception -> L50
        if (r22 != null) goto L46;
    L48:
        byte[] r25 = r24.doFinal(r21);     // Catch: Exception -> L50
    L52:
        if (r25 != null) goto L54;
    L58:
        b("d", "Decrypt data key failed!!");
        return null;
    L54:
        if (r25.length == 0) goto L58;
        return new SecretKeySpec(r25, CryptoConst.ALGORITHM_AES);
    L46:
        if (r22.length <= 0) goto L48;
        r24.updateAAD(r22);     // Catch: Exception -> L50
    L50:
        e = move-exception;
        b("d", "xcryptByKeyStore failed, error:" + e.getMessage());
        e.printStackTrace();
        r25 = new byte[0];
        goto L52
    L7:
        if (r1.getCount() != 0) goto L9;
        b("a", "queryKey cursor count is 0");
        r1.close();
        goto L5
    L9:
        r10 = new p();
        if (r1.moveToFirst() == false) goto L12;
        r1.getInt(r1.getColumnIndex("version"));
        r10.f7875b = r1.getString(r1.getColumnIndex("iv"));
        r10.f7874a = r1.getString(r1.getColumnIndex("cipher"));
        r1.getString(r1.getColumnIndex("extra"));
    L12:
        r1.close();
        goto L13
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
