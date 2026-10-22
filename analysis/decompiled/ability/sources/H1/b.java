package H1;

import H.h;
import Z6.k;
import android.os.Process;
import android.text.TextUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes2.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f728a;
    public final /* synthetic */ c b;

    public /* synthetic */ b(c cVar, int i) {
        this.f728a = i;
        this.b = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        switch (this.f728a) {
            case 0:
                if (F1.b.b().d()) {
                    String string = c.d().e().getString("updateVersionCode", "");
                    if (((File) F1.b.b().b).length() > 31457280 && !TextUtils.isEmpty(string)) {
                        this.b.b = true;
                        Process.setThreadPriority(10);
                        String strOptString = h.d().optString("device_id");
                        long jCurrentTimeMillis = c.d().c != null ? c.d().c.c : System.currentTimeMillis();
                        File file = (File) F1.b.b().b;
                        String strSubstring = file.getName().substring(0, file.getName().lastIndexOf("."));
                        if (S0.b.Y("memory_upload_origin")) {
                            File file2 = new File((File) F1.b.b().f, "dump.hprof");
                            if (file.getPath().contains("jpg")) {
                                file.renameTo(file2);
                            }
                            File file3 = (File) F1.b.b().d;
                            StringBuilder sb = new StringBuilder();
                            androidx.constraintlayout.core.dsl.a.A(sb, strSubstring.replace("dump", new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date(jCurrentTimeMillis))), "_", strOptString, "_");
                            File file4 = new File(file3, B7.a.q(sb, string, "_origin.zip"));
                            S0.b.C0("origin_compress_begin");
                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                            S0.b.H(file2, file4);
                            U7.a.j("compress origin file succeed", new Object[0]);
                            S0.b.y(System.currentTimeMillis() - jCurrentTimeMillis2, "origin_compress_time");
                            S0.b.C0("origin_compress_end");
                            S0.b.y(file4.length() / 1024, "origin_compress_size");
                            if (file2.exists()) {
                                file2.delete();
                            }
                            c.d().e().edit().putInt("hprof_type", 1).commit();
                            c.d().e().edit().putBoolean("hasShrink", true).commit();
                            c.d().e().edit().putString("latestFilePath", file4.getAbsolutePath()).commit();
                        } else {
                            U7.a.j("shrink begin with path %s, length %s ", file.getPath(), Long.valueOf(file.length()));
                            try {
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                            File fileJ0 = file.exists() ? S0.b.j0(file, new File((File) F1.b.b().e, "dump.hprof")) : null;
                            if (fileJ0 == null || (fileJ0.length() < 31457280 && c.d().e().getInt("hprof_type", 1) == 2)) {
                                U7.a.j("shrink failed deleteCache", new Object[0]);
                                c.d().b();
                            } else {
                                U7.a.j("shrink succeed", new Object[0]);
                                S0.b.C0("shrink_compress_begin");
                                long jCurrentTimeMillis3 = System.currentTimeMillis();
                                File file5 = new File(fileJ0.getParentFile(), fileJ0.getName().substring(0, fileJ0.getName().lastIndexOf(".")) + ".zip");
                                S0.b.H(fileJ0, file5);
                                if (file5.exists()) {
                                    fileJ0.delete();
                                }
                                S0.b.y(System.currentTimeMillis() - jCurrentTimeMillis3, "shrink_compress_time");
                                S0.b.C0("shrink_compress_end");
                                S0.b.y(file5.length() / 1024, "shrink_compress_size");
                                String parent = file5.getParent();
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date(jCurrentTimeMillis)));
                                sb2.append("_");
                                File file6 = new File(parent, androidx.appfunctions.metadata.a.p(sb2, strOptString, "_", string, "_shrink.zip"));
                                if (file5.exists()) {
                                    file5.renameTo(file6);
                                }
                                c.d().e().edit().putBoolean("hasShrink", true).commit();
                                c.d().e().edit().putString("latestFilePath", file6.getAbsolutePath()).commit();
                            }
                        }
                        F1.b bVarB = F1.b.b();
                        if (((File) bVarB.b).exists()) {
                            ((File) bVarB.b).delete();
                        }
                        this.b.b = false;
                        Process.setThreadPriority(0);
                        C1.a.a();
                        break;
                    } else {
                        U7.a.j(B7.a.k("HeapSaver shrink return deleteCache. updateVersionCode:", string), new Object[0]);
                        c.d().b();
                        break;
                    }
                }
                break;
            default:
                this.b.c = null;
                k.f((File) F1.b.b().f);
                this.b.e().edit().putString("filePath", "").commit();
                c.d().e().edit().putString("latestFilePath", "").commit();
                c.d().e().edit().putString("updateVersionCode", "").commit();
                c.d().e().edit().putInt("hprof_type", 0).commit();
                break;
        }
    }
}
