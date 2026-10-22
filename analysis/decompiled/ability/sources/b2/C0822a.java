package b2;

import D8.j;
import J9.k;
import a.AbstractC0291a;
import a2.AbstractC0299a;
import android.content.Context;
import ca.AbstractC0897f;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;
import u1.d;

/* renamed from: b2.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0822a extends AbstractC0299a {
    public j c;
    public final ArrayList d = new ArrayList();
    public volatile long e = 0;
    public final /* synthetic */ int f;

    public C0822a(int i) {
        this.f = i;
    }

    @Override // a2.AbstractC0299a
    public final String a() {
        switch (this.f) {
            case 0:
                return "alog_apmplus";
            case 1:
                return "apmplus";
            default:
                return "alog";
        }
    }

    @Override // a2.AbstractC0299a
    public final synchronized boolean d(d dVar) {
        boolean z10;
        JSONObject jSONObject = new JSONObject((String) dVar.b);
        if (this.c == null) {
            S0.b.v(0, this.f1636a, (String) dVar.d, "未设置Log回捞处理组件");
            return false;
        }
        if (System.currentTimeMillis() - this.e < 180000) {
            k kVar = new k(this.f1636a, (String) dVar.d, null);
            kVar.b = 0;
            kVar.e = "3分钟内不重复执行log回捞";
            S1.a.a(kVar);
            return false;
        }
        this.e = System.currentTimeMillis();
        List listA = this.c.a(jSONObject.optLong("fetch_start_time", (System.currentTimeMillis() / 1000) - 18000), jSONObject.optLong("fetch_end_time", System.currentTimeMillis() / 1000), a());
        List list = this.c.f433a;
        boolean z11 = list != null && list.size() > 0;
        String str = z11 ? "log file get" : "log file not get";
        if (listA != null) {
            listA.size();
        }
        if (listA == null || listA.size() == 0 || !z11) {
            z10 = true;
            if (!z11) {
                k kVar2 = new k(this.f1636a, (String) dVar.d, null);
                kVar2.b = 3;
                kVar2.e = str;
                S1.a.a(kVar2);
            }
        } else {
            this.d.clear();
            this.d.addAll(listA);
            R1.b bVarB = R1.b.b(this.f1636a);
            if (!bVarB.b.exists()) {
                bVarB.b.mkdirs();
            }
            File file = new File(bVarB.b, ((String) dVar.d) + "temp");
            if (file.exists()) {
                file.delete();
            }
            file.mkdirs();
            File file2 = new File(file, ((String) dVar.d) + "-cloudMsg.zip");
            if (file2.exists()) {
                file2.delete();
            }
            String[] strArr = (String[]) listA.toArray(new String[listA.size()]);
            Z6.k.h(file2.getAbsolutePath(), strArr);
            S0.b.v(0, this.f1636a, (String) dVar.d, "Alog回捞:" + Arrays.toString(strArr) + " ErrMsg=" + str);
            R1.b bVarB2 = R1.b.b(this.f1636a);
            synchronized (bVarB2) {
                try {
                    S0.b.v(0, (String) bVarB2.c.f177a, (String) dVar.d, "命令产物已生成，等待上传");
                    if (!bVarB2.b.exists()) {
                        bVarB2.b.mkdirs();
                    }
                    String str2 = (String) dVar.d;
                    File file3 = new File(bVarB2.b, str2);
                    if (file3.exists()) {
                        file3.delete();
                    }
                    file.renameTo(file3);
                    long jA = R1.b.a(file3);
                    boolean z12 = ((JSONObject) dVar.e).optBoolean("wifiOnly") && jA > 2097152;
                    bVarB2.f1141a.put(str2, Boolean.valueOf(z12));
                    if (!z12 || AbstractC0897f.j((Context) bVarB2.c.c)) {
                        boolean z13 = true;
                        for (File file4 : file3.listFiles(new R1.a(0))) {
                            Object obj = bVarB2.c.f177a;
                            String str3 = "正在上传:" + file4.getName();
                            if (AbstractC0291a.c) {
                                AbstractC0291a.m("postFile: commandId=" + str2, "postFile=" + file4.getAbsolutePath(), ", uploadMessage=" + str3, ", fileType=log_agile");
                            }
                            boolean zA = U1.a.a(U1.a.f1265a, file4, 1, "log_agile", str2, str3, System.currentTimeMillis(), null);
                            StringBuilder sb = new StringBuilder();
                            sb.append("文件上传");
                            sb.append(zA ? "成功" : "失败");
                            sb.append(":");
                            sb.append(file4.getName());
                            S0.b.v(0, (String) bVarB2.c.f177a, (String) dVar.d, sb.toString());
                            if (!zA) {
                                z13 = false;
                            }
                        }
                        z10 = true;
                        if (z13) {
                            S0.b.v(2, (String) bVarB2.c.f177a, str2, "上传成功");
                        }
                    } else {
                        S0.b.v(0, (String) bVarB2.c.f177a, (String) dVar.d, "产物超过阈值，等待WiFi环境执行. fileTotalSize=" + jA);
                        z10 = true;
                    }
                } finally {
                }
            }
        }
        return z10;
    }
}
