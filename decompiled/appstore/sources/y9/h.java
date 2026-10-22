package y9;

import android.text.TextUtils;
import com.bytedance.services.apm.api.IMonitorLogQueryCallback;
import com.monitor.cloudmessage.callback.IMonitorLogConsumer;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.monitor.cloudmessage.upload.callback.IFileUploadCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class h extends x9.a implements IFileUploadCallback {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IMonitorLogConsumer f26173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public File f26174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ConcurrentLinkedQueue f26175d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f26176e;

    public class a implements IMonitorLogQueryCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f26177a;

        public a(h r10) {
            this.f26177a = r10;
        }

        @Override // com.bytedance.services.apm.api.IMonitorLogQueryCallback
        public void onResult(String r10, String r11) {
            if (TextUtils.isEmpty(r10) == false) goto L5;
        L8:
            h.l(this.f26177a).offer(h.k(this.f26177a));
            return;
        L5:
            if (TextUtils.isEmpty(r11) == true) goto L8;
            h.l(this.f26177a).offer(new b(this.f26177a, r10, r11));
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f26178a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f26179b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ h f26180c;

        public b(h r10, String r11, String r12) {
            this.f26180c = r10;
            this.f26178a = r11;
            this.f26179b = r12;
        }
    }

    public h() {
        this.f26174c = null;
        this.f26175d = new ConcurrentLinkedQueue();
        this.f26176e = new b(this, "error_data", "error_ids");
    }

    public static /* synthetic */ b k(h r10) {
        return r10.f26176e;
    }

    public static /* synthetic */ ConcurrentLinkedQueue l(h r10) {
        return r10.f26175d;
    }

    @Override // x9.a
    public String d() {
        return CloudControlInf.MONITOR_LOG;
    }

    @Override // x9.a
    public boolean e(w9.a r25) {
        JSONObject r10 = new JSONObject(r25.c());
        int r11 = 0;
        if (this.f26173b != null) goto L6;
        return false;
    L6:
        if (c(r10, r25) == false) goto L8;
        return true;
    L8:
        long r19 = r10.optLong("fetch_start_time", (System.currentTimeMillis() / 1000) - 18000);
        long r21 = r10.optLong("fetch_end_time", System.currentTimeMillis() / 1000);
        String[] r12 = this.f26173b.parseLogType(r10);
        if (r12 != null) goto L11;
    L33:
        return true;
    L11:
        if (r12.length <= 0) goto L33;
        int r13 = r12.length;
        boolean r14 = false;
        int r15 = 0;
        int r16 = 0;
    L13:
        if (r16 >= r13) goto L30;
        String r17 = r12[r16];
        int r18 = r11;
    L15:
        r18 = r18 + 1;
        if (r18 > 100) goto L29;
        if (this.f26175d.isEmpty() == true) goto L20;
        b r110 = (b) this.f26175d.poll();
        if (r110 == this.f26176e) goto L24;
        File r20 = aa.c.a(v9.a.k().i(), r110.f26178a, m(r17));
        this.f26174c = r20;
        if (r20 == null) goto L28;
        String r111 = r17;
        da.a r112 = new da.a(n(r17), 0, false, r25.b(), this, null);
        r112.h(1);
        r112.t(true);
        ca.a.c(r112);
        this.f26173b.notifyLogDataConsumed(r111, r110.f26179b);
        Thread.sleep(100);
        r17 = r111;
        r14 = true;
        r13 = r13;
        r16 = r16;
        r12 = r12;
        r18 = r18;
        r15 = 0;
        r11 = 0;
        goto L15
    L28:
        this.f26175d.clear();
        r14 = false;
        r15 = 0;
        goto L29
    L24:
        this.f26175d.clear();
        r15 = r11;
        goto L29
    L20:
        if (r15 != 0) goto L15;
        this.f26173b.handleLogData(r19, r21, r17, new a(this));
        r15 = 1;
    L29:
        r16 = r16 + 1;
        r13 = r13;
        r12 = r12;
        r11 = 0;
        goto L13
    L30:
        if (r14 == false) goto L32;
        j(r25);
        goto L33
    L32:
        i("Monitor日志查询为空", r25);
        goto L33
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public List getUploadFileList() {
        ArrayList r10 = new ArrayList();
        File r11 = this.f26174c;
        if (r11 == null) goto L5;
        r10.add(r11.getAbsolutePath());
    L5:
        return r10;
    }

    public String m(String r10) {
        return "cloudMessage_" + r10;
    }

    public String n(String r10) {
        if ("block_monitor".equals(r10) == false) goto L5;
        return "log_exception";
    L5:
        return "log_performance";
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public void notifyUploadBegin(String r10) {
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public void notifyUploadEnd(String r10, boolean r11) {
    }

    public void o(IMonitorLogConsumer r10) {
        this.f26173b = r10;
    }
}
