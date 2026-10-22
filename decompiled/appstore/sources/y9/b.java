package y9;

import com.monitor.cloudmessage.callback.IAdvanceAlogConsumer;
import com.monitor.cloudmessage.callback.IAlogConsumer;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.monitor.cloudmessage.entity.CloudMessageException;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class b extends x9.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IAlogConsumer f26163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f26164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile long f26165d;

    public b() {
        this.f26164c = new ArrayList();
        this.f26165d = 0;
    }

    @Override // x9.a
    public String d() {
        return CloudControlInf.ALOG;
    }

    @Override // x9.a
    public synchronized boolean e(w9.a r13) {
        monitor-enter(this);
        JSONObject r10 = new JSONObject(r13.c());     // Catch: Throwable -> L8
        if (this.f26163b != null) goto L17;
        boolean r11 = w0.c.F();     // Catch: Throwable -> L8
        String r12 = w0.c.h();     // Catch: Throwable -> L8
        if (r12 != null) goto L10;
        r12 = "";
    L10:
        if (r11 == false) goto L12;
        String r14 = "主进程收到命令，未设置ALog回捞组件。请宿主应用检查是否在合适时机设置ALog回捞组件。";
    L13:
        ba.a.c(r14, r13);     // Catch: Throwable -> L8
        monitor-exit(this);
        return false;
    L12:
        r14 = "子进程\"$processName\"收到命令，等待主进程活跃后上报。".replace("$processName", r12);     // Catch: Throwable -> L8
        goto L13
    L17:
        if ((System.currentTimeMillis() - this.f26165d) >= 180000) goto L21;
        da.b r15 = new da.b(0, false, r13.b(), null);     // Catch: Throwable -> L8
        r15.h(0);     // Catch: Throwable -> L8
        r15.i("3分钟内不重复执行alog回捞");     // Catch: Throwable -> L8
        ca.a.d(r15);     // Catch: Throwable -> L8
        monitor-exit(this);
        return false;
    L21:
        this.f26165d = System.currentTimeMillis();     // Catch: Throwable -> L8
        List<String> r16 = this.f26163b.handleAlogData(r10.optLong("fetch_start_time", (System.currentTimeMillis() / 1000) - 18000), r10.optLong("fetch_end_time", System.currentTimeMillis() / 1000), r10);     // Catch: Throwable -> L8
        w9.b r17 = this.f26163b.getConsumerResult();     // Catch: Throwable -> L8
        if (r16 != null) goto L24;
    L25:
        IAlogConsumer r18 = this.f26163b;     // Catch: Throwable -> L8
        if ((r18 instanceof IAdvanceAlogConsumer) == false) goto L32;
        r16 = ((IAdvanceAlogConsumer) r18).getBackupAlogData();     // Catch: Throwable -> L8
        if (r16 == null) goto L32;
        if (r16.size() == 0) goto L32;
        r17 = w9.b.a(true, "兜底策略数据", r17.c());     // Catch: Throwable -> L8
    L32:
        if (r16 == null) goto L49;
        if (r16.size() == 0) goto L49;
        if (r17.d() == false) goto L49;
        this.f26164c.clear();     // Catch: Throwable -> L8
        this.f26164c.addAll(r16);     // Catch: Throwable -> L8
        File r19 = ba.b.b().c();     // Catch: Throwable -> L8
        if (r19 == null) goto L47;
        File r20 = new File(r19, r13.b() + "temp");     // Catch: Throwable -> L8
        if (r20.exists() == false) goto L42;
        com.monitor.cloudmessage.utils.b.f(r20);     // Catch: Throwable -> L8
    L42:
        r20.mkdirs();     // Catch: Throwable -> L8
        File r21 = new File(r20, r13.b() + "-cloudMsg.zip");     // Catch: Throwable -> L8
        if (r21.exists() == false) goto L45;
        r21.delete();     // Catch: Throwable -> L8
    L45:
        String[] r22 = (String[]) r16.toArray(new String[r16.size()]);     // Catch: Throwable -> L8
        com.monitor.cloudmessage.utils.b.b(r21.getAbsolutePath(), r22);     // Catch: Throwable -> L8
        ba.a.d("Alog回捞:" + Arrays.toString(r22) + " ErrMsg=" + r17.b(), r13, r17.c());     // Catch: Throwable -> L8
        ba.b.b().e(r13, r20, "log_agile");     // Catch: Throwable -> L8
    L51:
        monitor-exit(this);
        return true;
    L47:
        throw new CloudMessageException("pending目录因拿不到context而未设置");     // Catch: Throwable -> L8
    L49:
        if (r17.d() == true) goto L51;
        h(r17.b(), r17.c(), r13);     // Catch: Throwable -> L8
        goto L51
    L24:
        if (r16.size() != 0) goto L32;
    L8:
        th = move-exception;
        throw th;
    }

    public void k(IAlogConsumer r10) {
        this.f26163b = r10;
    }
}
