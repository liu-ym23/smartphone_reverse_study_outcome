package com.baidu.b.e;

import android.content.Context;
import com.baidu.b.c.b.c;
import com.stepos.activeview.utils.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f4871a;

    /* renamed from: b, reason: collision with root package name */
    private C0007a f4872b;

    /* renamed from: com.baidu.b.e.a$a, reason: collision with other inner class name */
    public final class C0007a {

        /* renamed from: b, reason: collision with root package name */
        private File f4874b;

        /* renamed from: c, reason: collision with root package name */
        private String f4875c;

        /* renamed from: d, reason: collision with root package name */
        private C0007a f4876d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f4877e = true;

        public C0007a(File file) {
            this.f4874b = file;
            this.f4875c = file.getName();
        }

        public C0007a a(File file) {
            if (this.f4877e) {
                throw new IllegalStateException("isolate session is not support");
            }
            ArrayList arrayList = new ArrayList();
            C0007a c0007aD = this;
            do {
                arrayList.add(c0007aD.c());
                c0007aD = c0007aD.d();
            } while (c0007aD != null);
            int size = arrayList.size() - 1;
            while (size >= 0) {
                File file2 = new File(file, (String) arrayList.get(size));
                size--;
                file = file2;
            }
            return a.this.new C0007a(file);
        }

        public File b() {
            File file = this.f4874b;
            if (file != null) {
                return file;
            }
            File file2 = this.f4876d == null ? new File(a.this.a(), this.f4875c) : new File(this.f4876d.b(), this.f4875c);
            this.f4874b = file2;
            return file2;
        }

        public String c() {
            return this.f4875c;
        }

        public C0007a d() {
            return this.f4876d;
        }

        public C0007a(String str, C0007a c0007a) {
            this.f4875c = str;
            this.f4876d = c0007a;
        }

        public C0007a a(String str) {
            return a.this.new C0007a(str, this);
        }

        public String a(String str, boolean z4) {
            return a.a(b(), str, Constants.UTF_8_CODE, z4);
        }

        public void a() {
            b().mkdirs();
        }

        public boolean a(String str, String str2, boolean z4) {
            return a.a(b(), str, str2, Constants.UTF_8_CODE, z4);
        }
    }

    public a(Context context) {
        this.f4871a = context;
        c().mkdirs();
    }

    private File c() {
        return new File(a(), ".cesium");
    }

    public File a() {
        return new File(this.f4871a.getApplicationInfo().dataDir);
    }

    public synchronized C0007a b() {
        try {
            if (this.f4872b == null) {
                this.f4872b = new C0007a(".cesium", null);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f4872b;
    }

    public static String a(File file, String str, String str2, boolean z4) throws Throwable {
        FileInputStream fileInputStream;
        a(file);
        File file2 = new File(file, str);
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                fileInputStream = new FileInputStream(file2);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i4 = fileInputStream.read(bArr);
                        if (i4 <= 0) {
                            break;
                        }
                        byteArrayOutputStream2.write(bArr, 0, i4);
                    }
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    if (z4) {
                        byteArray = new c().b(byteArray);
                    }
                    String str3 = new String(byteArray, str2);
                    com.baidu.b.f.c.a(fileInputStream);
                    com.baidu.b.f.c.a(byteArrayOutputStream2);
                    return str3;
                } catch (Exception unused) {
                    byteArrayOutputStream = byteArrayOutputStream2;
                    com.baidu.b.f.c.a(fileInputStream);
                    com.baidu.b.f.c.a(byteArrayOutputStream);
                    return "";
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    com.baidu.b.f.c.a(fileInputStream);
                    com.baidu.b.f.c.a(byteArrayOutputStream);
                    throw th;
                }
            } catch (Exception unused2) {
                fileInputStream = null;
            } catch (Throwable th2) {
                fileInputStream = null;
                byteArrayOutputStream = byteArrayOutputStream2;
                th = th2;
            }
        } catch (Exception unused3) {
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public static void a(File file) {
        file.mkdirs();
    }

    public static boolean a(File file, String str, String str2, String str3, boolean z4) throws Throwable {
        a(file);
        File file2 = new File(file, str);
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
            try {
                if (z4) {
                    fileOutputStream2.write(new c().a(str2.getBytes()));
                } else {
                    fileOutputStream2.write(str2.getBytes(str3));
                }
                com.baidu.b.f.c.a(fileOutputStream2);
                return true;
            } catch (Exception unused) {
                fileOutputStream = fileOutputStream2;
                com.baidu.b.f.c.a(fileOutputStream);
                return false;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                com.baidu.b.f.c.a(fileOutputStream);
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
