package com.baidu.platform.comapi.resource;

import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.platform.comapi.JNIInitializer;
import com.baidu.platform.comapi.util.MD5;
import com.baidu.platform.comapi.util.SysOSUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f9262a = new b();

    /* renamed from: b, reason: collision with root package name */
    private final SharedPreferences f9263b = JNIInitializer.getCachedContext().getSharedPreferences("engine_resource_sp", 0);

    private b() {
    }

    private boolean b(File file, byte[] bArr) throws Throwable {
        if (file != null && file.exists() && bArr != null) {
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    byte[] bArr2 = new byte[fileInputStream2.available()];
                    fileInputStream2.read(bArr2);
                    if (Arrays.equals(bArr2, bArr)) {
                        a.a(fileInputStream2);
                        return false;
                    }
                } catch (IOException unused) {
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    a.a(fileInputStream);
                    throw th;
                }
                fileInputStream = fileInputStream2;
            } catch (IOException unused2) {
            } catch (Throwable th2) {
                th = th2;
            }
            a.a(fileInputStream);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0063 A[Catch: all -> 0x004a, TRY_LEAVE, TryCatch #0 {all -> 0x004a, blocks: (B:3:0x0001, B:5:0x0008, B:6:0x0013, B:8:0x001d, B:10:0x002d, B:13:0x004c, B:20:0x0059, B:21:0x005d, B:23:0x0063), top: B:29:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void a(com.baidu.platform.comapi.resource.ResourceList r13) {
        /*
            r12 = this;
            monitor-enter(r12)
            android.content.Context r0 = com.baidu.platform.comapi.JNIInitializer.getCachedContext()     // Catch: java.lang.Throwable -> L4a
            r1 = 0
            r2 = 0
            r3 = 1
            java.lang.String r4 = r12.a()     // Catch: java.lang.Throwable -> L4a java.lang.Throwable -> L53
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L4a java.lang.Throwable -> L53
            java.lang.String r6 = "/ver.dat"
            r5.<init>(r4, r6)     // Catch: java.lang.Throwable -> L4a java.lang.Throwable -> L53
            byte[] r2 = r13.resVer()     // Catch: java.lang.Throwable -> L4a java.lang.Throwable -> L54
            boolean r6 = r12.b(r5, r2)     // Catch: java.lang.Throwable -> L4a java.lang.Throwable -> L54
            if (r6 == 0) goto L4c
            android.content.res.AssetManager r0 = r0.getAssets()     // Catch: java.lang.Throwable -> L4a java.lang.Throwable -> L51
            java.lang.String[] r13 = r13.resList()     // Catch: java.lang.Throwable -> L4a java.lang.Throwable -> L51
            r7 = 65536(0x10000, float:9.1835E-41)
            byte[] r7 = new byte[r7]     // Catch: java.lang.Throwable -> L4a java.lang.Throwable -> L51
            int r8 = r13.length     // Catch: java.lang.Throwable -> L4a java.lang.Throwable -> L51
            r9 = r1
        L2b:
            if (r9 >= r8) goto L4c
            r3 = r13[r9]     // Catch: java.lang.Throwable -> L4a java.lang.Throwable -> L51
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4a java.lang.Throwable -> L51
            r10.<init>()     // Catch: java.lang.Throwable -> L4a java.lang.Throwable -> L51
            r10.append(r4)     // Catch: java.lang.Throwable -> L4a java.lang.Throwable -> L51
            java.lang.String r11 = "/"
            r10.append(r11)     // Catch: java.lang.Throwable -> L4a java.lang.Throwable -> L51
            r10.append(r3)     // Catch: java.lang.Throwable -> L4a java.lang.Throwable -> L51
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> L4a java.lang.Throwable -> L51
            boolean r3 = r12.a(r0, r7, r3, r10)     // Catch: java.lang.Throwable -> L4a java.lang.Throwable -> L51
            int r9 = r9 + 1
            goto L2b
        L4a:
            r13 = move-exception
            goto L85
        L4c:
            r12.a(r4)     // Catch: java.lang.Throwable -> L4a java.lang.Throwable -> L51
            r1 = r3
            goto L55
        L51:
            r3 = r6
            goto L54
        L53:
            r5 = r2
        L54:
            r6 = r3
        L55:
            if (r6 == 0) goto L5d
            if (r1 == 0) goto L5d
            boolean r1 = r12.a(r5, r2)     // Catch: java.lang.Throwable -> L4a
        L5d:
            boolean r13 = com.baidu.mapapi.OpenLogUtil.isMapLogEnable()     // Catch: java.lang.Throwable -> L4a
            if (r13 == 0) goto L83
            com.baidu.mapsdkplatform.comapi.commonutils.a r13 = com.baidu.mapsdkplatform.comapi.commonutils.a.a()     // Catch: java.lang.Throwable -> L4a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4a
            r0.<init>()     // Catch: java.lang.Throwable -> L4a
            java.lang.String r2 = "initEngineRes firstInit = "
            r0.append(r2)     // Catch: java.lang.Throwable -> L4a
            r0.append(r6)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r2 = "; isInitSucceed = "
            r0.append(r2)     // Catch: java.lang.Throwable -> L4a
            r0.append(r1)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L4a
            r13.a(r0)     // Catch: java.lang.Throwable -> L4a
        L83:
            monitor-exit(r12)
            return
        L85:
            monitor-exit(r12)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.resource.b.a(com.baidu.platform.comapi.resource.ResourceList):void");
    }

    private String a() {
        String outputDirPath = SysOSUtil.getInstance().getOutputDirPath();
        File file = new File(outputDirPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        return outputDirPath;
    }

    private boolean a(AssetManager assetManager, byte[] bArr, String str, String str2) throws IOException {
        InputStream inputStreamOpen = null;
        try {
            if (!TextUtils.isEmpty(str) && str.endsWith(".dir")) {
                String strSubstring = str.substring(0, str.indexOf(".dir"));
                String strSubstring2 = str2.substring(0, str2.indexOf(".dir"));
                String[] list = assetManager.list(strSubstring);
                if (list != null && list.length > 0) {
                    File file = new File(strSubstring2);
                    if (file.exists()) {
                        file.delete();
                    }
                    file.mkdirs();
                    for (String str3 : list) {
                        if (!TextUtils.isEmpty(str3)) {
                            a(assetManager, bArr, strSubstring + "/" + str3, strSubstring2 + "/" + str3);
                        }
                    }
                }
            } else {
                inputStreamOpen = assetManager.open(str);
                File file2 = new File(str2);
                File parentFile = file2.getParentFile();
                if (parentFile != null && !parentFile.isDirectory()) {
                    parentFile.mkdirs();
                }
                if (file2.exists()) {
                    file2.delete();
                }
                file2.createNewFile();
                a.a(inputStreamOpen, new FileOutputStream(file2), bArr);
            }
            a.a(inputStreamOpen);
            return true;
        } catch (Exception unused) {
            a.a(null);
            return false;
        } catch (Throwable th) {
            a.a(null);
            throw th;
        }
    }

    private boolean a(File file, byte[] bArr) throws Throwable {
        FileOutputStream fileOutputStream;
        if (file != null && bArr != null) {
            FileOutputStream fileOutputStream2 = null;
            try {
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                fileOutputStream = new FileOutputStream(file);
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(bArr);
                a.a(fileOutputStream);
                return true;
            } catch (Exception unused2) {
                fileOutputStream2 = fileOutputStream;
                a.a(fileOutputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                a.a(fileOutputStream2);
                throw th;
            }
        }
        return false;
    }

    private void a(String str) {
        if (this.f9263b == null) {
            return;
        }
        File file = new File(str, "shader/");
        String mD5String = MD5.getMD5String(Build.FINGERPRINT);
        if (!file.exists()) {
            this.f9263b.edit().putString("fingerprint", mD5String).commit();
            return;
        }
        String string = this.f9263b.getString("fingerprint", "");
        if (TextUtils.isEmpty(string) || !(string.equals(mD5String) || MD5.getMD5String(string).equals(mD5String))) {
            a(file);
            if (file.exists()) {
                return;
            }
            this.f9263b.edit().putString("fingerprint", mD5String).commit();
        }
    }

    private static void a(File file) {
        if (file == null) {
            return;
        }
        if (!file.isFile() && (!file.exists() || file.list() == null || file.list().length != 0)) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (int i4 = 0; i4 < fileArrListFiles.length; i4++) {
                    a(fileArrListFiles[i4]);
                    fileArrListFiles[i4].delete();
                }
            }
            if (file.exists()) {
                file.delete();
                return;
            }
            return;
        }
        file.delete();
    }
}
