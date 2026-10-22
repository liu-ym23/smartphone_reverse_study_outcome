package b9a;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.monitor.cloudmessage.entity.CloudMessageException;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class b extends a9a.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y8a.b f18349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f18350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile long f18351d;

    @Override // a9a.a
    public final String f() {
        return CloudControlInf.ALOG;
    }

    public b() {
        this.f18350c = new ArrayList();
        this.f18351d = 0;
    }

    @Override // a9a.a
    public final synchronized boolean g(z8a.a r110) throws Exception {
        monitor-enter(this);
        JSONObject r100 = new JSONObject(r110.f570965a);     // Catch: Throwable -> L52
        if (this.f18349b != null) goto L16;
        boolean r101 = com.bytedance.apm.d.k();     // Catch: Throwable -> L52
        String r102 = com.bytedance.apm.d.c();     // Catch: Throwable -> L52
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        if (r101 == false) goto L11;
        String r103 = "主进程收到命令，未设置ALog回捞组件。请宿主应用检查是否在合适时机设置ALog回捞组件。";
    L12:
        f9a.a.a(r110.f570967c, r103, 0, null);     // Catch: Throwable -> L52
        monitor-exit(this);
        return false;
    L11:
        r103 = "子进程\"$processName\"收到命令，等待主进程活跃后上报。".replace("$processName", r102);     // Catch: Throwable -> L52
        goto L12
    L16:
        if ((System.currentTimeMillis() - this.f18351d) >= 180000) goto L20;
        i9a.b r104 = new i9a.b(r110.f570967c, null);     // Catch: Throwable -> L52
        r104.f488823d = 0;     // Catch: Throwable -> L52
        r104.f488824e = "3分钟内不重复执行alog回捞";     // Catch: Throwable -> L52
        g9a.a.c(r104);     // Catch: Throwable -> L52
        monitor-exit(this);
        return false;
    L20:
        this.f18351d = System.currentTimeMillis();     // Catch: Throwable -> L52
        List<String> r105 = this.f18349b.handleAlogData(r100.optLong("fetch_start_time", (System.currentTimeMillis() / 1000) - 18000), r100.optLong("fetch_end_time", System.currentTimeMillis() / 1000), r100);     // Catch: Throwable -> L52
        z8a.b r106 = this.f18349b.getConsumerResult();     // Catch: Throwable -> L52
        if (r105 != null) goto L23;
    L24:
        y8a.b r107 = this.f18349b;     // Catch: Throwable -> L52
        if ((r107 instanceof y8a.a) == false) goto L31;
        r105 = ((y8a.a) r107).b();     // Catch: Throwable -> L52
        if (r105 == null) goto L31;
        if (r105.size() == 0) goto L31;
        r106 = new z8a.b(true, "兜底策略数据", r106.f570971c);     // Catch: Throwable -> L52
    L31:
        if (r105 == null) goto L48;
        if (r105.size() == 0) goto L48;
        if (r106.f570969a == false) goto L48;
        ((ArrayList) this.f18350c).clear();     // Catch: Throwable -> L52
        ((ArrayList) this.f18350c).addAll(r105);     // Catch: Throwable -> L52
        f9a.b r108 = f9a.b.C5874b.f475989a;     // Catch: Throwable -> L52
        File r109 = r108.a();     // Catch: Throwable -> L52
        if (r109 == null) goto L46;
        PolarisFileWrapper r111 = new PolarisFileWrapper(r109, r110.f570967c + "temp");     // Catch: Throwable -> L52
        if (r111.exists() == false) goto L41;
        com.monitor.cloudmessage.utils.a.d(r111);     // Catch: Throwable -> L52
    L41:
        r111.mkdirs();     // Catch: Throwable -> L52
        PolarisFileWrapper r112 = new PolarisFileWrapper(r111, r110.f570967c + "-cloudMsg.zip");     // Catch: Throwable -> L52
        if (r112.exists() == false) goto L44;
        r112.delete();     // Catch: Throwable -> L52
    L44:
        String[] r113 = (String[]) r105.toArray(new String[r105.size()]);     // Catch: Throwable -> L52
        com.monitor.cloudmessage.utils.a.b(r112.getAbsolutePath(), r113);     // Catch: Throwable -> L52
        f9a.a.a(r110.f570967c, "Alog回捞:" + Arrays.toString(r113) + " ErrMsg=" + r106.f570970b, 0, r106.f570971c);     // Catch: Throwable -> L52
        r108.b(r110, r111, "log_agile");     // Catch: Throwable -> L52
    L50:
        monitor-exit(this);
        return true;
    L46:
        throw new CloudMessageException("pending目录因拿不到context而未设置");     // Catch: Throwable -> L52
    L48:
        if (r106.f570969a == true) goto L50;
        String r114 = r106.f570970b;     // Catch: Throwable -> L52
        i9a.b r115 = new i9a.b(r110.f570967c, r106.f570971c);     // Catch: Throwable -> L52
        r115.f488823d = 3;     // Catch: Throwable -> L52
        r115.f488824e = r114;     // Catch: Throwable -> L52
        g9a.a.c(r115);     // Catch: Throwable -> L52
        goto L50
    L23:
        if (r105.size() != 0) goto L31;
    L52:
        th = move-exception;
        throw th;
    }
}
