package w0;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.services.apm.api.IZstdDict;
import com.bytedanceos.common.toolbox.ServerElements;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class j implements IZstdDict {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f25289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f25290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f25291c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f25292d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f25293e;

    public j() {
    }

    public static void c(File r10, byte[] r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r11 != null) goto L6;
        return;
    L6:
        if (r11.length == 0) goto L31;
        r10.getParentFile().mkdirs();
        FileOutputStream r12 = null;
    L12:
        th = th;
    L20:
        r3.d.b(r12);
        throw th;
    L10:
        if (r10.exists() == false) goto L14;
        r10.delete();     // Catch: Throwable -> L12 Exception -> L24
    L14:
        r10.exists();     // Catch: Throwable -> L12 Exception -> L24
        FileOutputStream r13 = new FileOutputStream(r10);     // Catch: Throwable -> L12 Exception -> L24
        goto L22
    L27:
        r13.write(r11);     // Catch: Throwable -> L17 Exception -> L19
        r13.flush();     // Catch: Throwable -> L17 Exception -> L19
        r3.d.b(r13);
        return;
    L19:
        r12 = r13;
    L17:
        th = th;
        r12 = r13;
    L22:
        r3.d.b(r12);
        return;
    }

    public final void a() {
        HashMap r10 = new HashMap(d3.a.w());
        r10.put("slardar_zstd_dict_type", "monitor");
        r10.put("zstd_client_code_version", "dynamic");
        r10.put("Content-Type", "application/json; charset=utf-8");
        byte[] r11 = new JSONObject(r10).toString().getBytes();     // Catch: Exception -> L13
        i6.c r12 = d3.a.g(r3.j.a(this.f25289a, r10), r10, r11);     // Catch: Exception -> L13
        if (r12 != null) goto L6;
        return;
    L6:
        if (r12.b() == null) goto L20;
        JSONObject r13 = new JSONObject(new String(r12.b()));     // Catch: Exception -> L13
        String r14 = r13.getString("dict_version");     // Catch: Exception -> L13
        String r15 = r13.getString("dict");     // Catch: Exception -> L13
        if (r13.getInt(ServerElements.CODE) == 200) goto L10;
        return;
    L10:
        byte[] r16 = Base64.decode(r15, 0);     // Catch: Exception -> L13
        c(new File(r3.a.b().getFilesDir(), "monitor_dict"), r16);     // Catch: Exception -> L13
        this.f25293e = r14;     // Catch: Exception -> L13
        this.f25291c = r16;     // Catch: Exception -> L13
        this.f25292d = System.currentTimeMillis();
        r3.a.b().getSharedPreferences("dict_interval", 0).edit().putLong("dict_interval", this.f25292d).putString("dict_version", r14).commit();
        return;
    L20:
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
    }

    public final void b() {
        if (this.f25290b == false) goto L5;
        return;
    L5:
        this.f25291c = r3.c.e(new File(r3.a.b().getFilesDir(), "monitor_dict"));
        SharedPreferences r10 = r3.a.b().getSharedPreferences("dict_interval", 0);
        this.f25292d = r10.getLong("dict_interval", 0);
        this.f25293e = r10.getString("dict_version", null);
        this.f25290b = true;
    }

    @Override // com.bytedance.services.apm.api.IZstdDict
    public Pair getDictAndDictVersion() {
        b();
        byte[] r10 = this.f25291c;
        if (r10 != null) goto L5;
    L6:
        a();
        r10 = this.f25291c;
    L8:
        return new Pair(r10, this.f25293e);
    L5:
        if ((System.currentTimeMillis() - this.f25292d) <= 604800000) goto L8;
        goto L6
    }

    @Override // com.bytedance.services.apm.api.IZstdDict
    public void setDomain(String r10) {
        this.f25289a = "https://" + r10 + "/monitor/collect/zstd_dict/";
    }
}
