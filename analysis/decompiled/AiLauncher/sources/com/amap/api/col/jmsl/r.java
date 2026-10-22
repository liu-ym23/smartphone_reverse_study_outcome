package com.amap.api.col.jmsl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.caverock.androidsvg.BuildConfig;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class r {
    public static File a(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            cacheDir = context.getDir("cache", 0);
        }
        if (cacheDir == null) {
            cacheDir = new File("/data/data/" + context.getPackageName() + "/app_cache");
        }
        if (!cacheDir.exists()) {
            cacheDir.mkdirs();
        }
        return cacheDir;
    }

    public static Object b(Context context, String str, String str2, Object obj) {
        String simpleName = obj.getClass().getSimpleName();
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        if ("String".equals(simpleName)) {
            return sharedPreferences.getString(str2, (String) obj);
        }
        if ("Integer".equals(simpleName)) {
            return Integer.valueOf(sharedPreferences.getInt(str2, ((Integer) obj).intValue()));
        }
        if ("Boolean".equals(simpleName)) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str2, ((Boolean) obj).booleanValue()));
        }
        if ("Float".equals(simpleName)) {
            return Float.valueOf(sharedPreferences.getFloat(str2, ((Float) obj).floatValue()));
        }
        if ("Long".equals(simpleName)) {
            return Long.valueOf(sharedPreferences.getLong(str2, ((Long) obj).longValue()));
        }
        return null;
    }

    public static String c(String str, String str2, String str3) throws Exception {
        byte[] bArrDoFinal;
        String str4 = str.toUpperCase() + "&%2F&" + l(str2);
        String str5 = str3 + Const.STR_MART_ADD;
        String strEncodeToString = null;
        if (TextUtils.isEmpty(str5) || TextUtils.isEmpty(str4)) {
            bArrDoFinal = null;
        } else {
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(new SecretKeySpec(str5.getBytes("UTF-8"), "UTF-8"));
            bArrDoFinal = mac.doFinal(str4.getBytes("UTF-8"));
        }
        if (bArrDoFinal != null && bArrDoFinal.length != 0) {
            strEncodeToString = Base64.encodeToString(bArrDoFinal, 0);
        }
        return strEncodeToString.replace("=", "%3D");
    }

    public static String d(Map<String, String> map, String str) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("AccessKeyId", str);
        treeMap.put("SignatureMethod", "HMAC-SHA1");
        treeMap.put("SignatureVersion", BuildConfig.VERSION_NAME);
        treeMap.put("SignatureNonce", UUID.randomUUID().toString());
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        treeMap.put("Timestamp", simpleDateFormat.format(date));
        treeMap.putAll(map);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : treeMap.entrySet()) {
            arrayList.add(((String) entry.getKey()) + "=" + l((String) entry.getValue()));
        }
        StringBuilder sb2 = new StringBuilder("");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb2.append((String) it.next());
            sb2.append(Const.STR_MART_ADD);
        }
        return sb2.toString().substring(0, r3.length() - 1);
    }

    public static PublicKey e(String str) throws Exception {
        try {
            return KeyFactory.getInstance(C1604s2.m("EUlNB")).generatePublic(new X509EncodedKeySpec(V.c(str)));
        } catch (NullPointerException unused) {
            throw new Exception("公钥数据为空");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException unused3) {
            throw new Exception("公钥非法");
        }
    }

    public static void f(int i10, Object... objArr) {
        StringBuilder sb2 = new StringBuilder();
        for (Object obj : objArr) {
            sb2.append(" ");
            sb2.append(obj.toString());
        }
        h("3dmap-lite1.2.0", sb2.toString(), i10);
    }

    public static void g(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void h(String str, String str2, int i10) {
        switch (i10) {
            case 111:
                Log.d(str, str2);
                break;
            case 112:
                Log.e(str, str2);
                break;
            case 113:
                Log.i(str, str2);
                break;
            case 114:
                Log.v(str, str2);
                break;
            case 115:
                Log.w(str, str2);
                break;
        }
    }

    public static void i(String str, String str2, boolean z10) {
        if (str2 != null && z10) {
            try {
                Log.d(str, str2);
            } catch (Throwable th) {
                C1611u1.b(th, "Log", "logD");
            }
        }
    }

    public static void j(String str, byte[] bArr) throws Throwable {
        Throwable th;
        ReentrantReadWriteLock.WriteLock writeLock = new ReentrantReadWriteLock().writeLock();
        writeLock.lock();
        FileOutputStream fileOutputStream = null;
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    File file = new File(str);
                    File parentFile = file.getParentFile();
                    if (!parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    if (file.exists()) {
                        file.delete();
                    }
                    file.createNewFile();
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(bArr);
                        fileOutputStream2.flush();
                        writeLock.unlock();
                        g(fileOutputStream2);
                        return;
                    } catch (Exception unused) {
                        fileOutputStream = fileOutputStream2;
                        writeLock.unlock();
                        g(fileOutputStream);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = fileOutputStream2;
                        writeLock.unlock();
                        g(fileOutputStream);
                        throw th;
                    }
                }
            } catch (Exception unused2) {
            } catch (Throwable th3) {
                th = th3;
            }
        }
        writeLock.unlock();
        g(null);
    }

    public static Object k(Context context, String str, String str2, Object obj) {
        String simpleName = obj.getClass().getSimpleName();
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        if ("String".equals(simpleName)) {
            return sharedPreferences.getString(str2, (String) obj);
        }
        if ("Integer".equals(simpleName)) {
            return Integer.valueOf(sharedPreferences.getInt(str2, ((Integer) obj).intValue()));
        }
        if ("Boolean".equals(simpleName)) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str2, ((Boolean) obj).booleanValue()));
        }
        if ("Float".equals(simpleName)) {
            return Float.valueOf(sharedPreferences.getFloat(str2, ((Float) obj).floatValue()));
        }
        if ("Long".equals(simpleName)) {
            return Long.valueOf(sharedPreferences.getLong(str2, ((Long) obj).longValue()));
        }
        return null;
    }

    public static String l(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLEncoder.encode(str, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static void m(String str, String str2, boolean z10) {
        if (str2 != null && z10) {
            try {
                Log.e(str, str2);
            } catch (Throwable th) {
                C1611u1.b(th, "Log", "logE");
            }
        }
    }

    public static void n(Context context, String str, String str2, Object obj) {
        String simpleName = obj.getClass().getSimpleName();
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
        if ("String".equals(simpleName)) {
            editorEdit.putString(str2, (String) obj);
        } else if ("Integer".equals(simpleName)) {
            editorEdit.putInt(str2, ((Integer) obj).intValue());
        } else if ("Boolean".equals(simpleName)) {
            editorEdit.putBoolean(str2, ((Boolean) obj).booleanValue());
        } else if ("Float".equals(simpleName)) {
            editorEdit.putFloat(str2, ((Float) obj).floatValue());
        } else if ("Long".equals(simpleName)) {
            editorEdit.putLong(str2, ((Long) obj).longValue());
        }
        editorEdit.commit();
    }

    public static byte[] o(String str) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            File file = new File(str);
            if (!file.exists()) {
                g(null);
                return null;
            }
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int i10 = fileInputStream.read(bArr);
                    if (i10 == -1) {
                        byteArrayOutputStream.close();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        g(fileInputStream);
                        return byteArray;
                    }
                    byteArrayOutputStream.write(bArr, 0, i10);
                }
            } catch (Exception unused) {
                g(fileInputStream);
                return null;
            } catch (Throwable th) {
                fileInputStream2 = fileInputStream;
                th = th;
                g(fileInputStream2);
                throw th;
            }
        } catch (Exception unused2) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void p(Context context, String str, String str2, Object obj) {
        String simpleName = obj.getClass().getSimpleName();
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
        if ("String".equals(simpleName)) {
            editorEdit.putString(str2, (String) obj);
        } else if ("Integer".equals(simpleName)) {
            editorEdit.putInt(str2, ((Integer) obj).intValue());
        } else if ("Boolean".equals(simpleName)) {
            editorEdit.putBoolean(str2, ((Boolean) obj).booleanValue());
        } else if ("Float".equals(simpleName)) {
            editorEdit.putFloat(str2, ((Float) obj).floatValue());
        } else if ("Long".equals(simpleName)) {
            editorEdit.putLong(str2, ((Long) obj).longValue());
        }
        editorEdit.commit();
    }
}
