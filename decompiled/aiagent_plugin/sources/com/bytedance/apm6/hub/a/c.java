package com.bytedance.apm6.hub.a;

import com.bytedance.apm.util.p;
import org.json.JSONObject;

/* JADX INFO: compiled from: DiskConfigManager.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements com.bytedance.apm6.disk.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.apm6.disk.a.a f5401a;

    static /* synthetic */ void a(c r0, JSONObject r1, boolean r2) {
        r0.a(r1, r2);
    }

    public c() {
        com.bytedance.apm6.hub.a.a.a.a().b();
        com.bytedance.apm6.hub.a.a.a.a().a(new AnonymousClass1(this));
    }

    @Override // com.bytedance.apm6.disk.a.b
    public com.bytedance.apm6.disk.a.a a() {
        return this.f5401a;
    }

    private void a(JSONObject r7, boolean r8) {
        JSONObject r9 = r7.optJSONObject("performance_modules");
        if (r9 != null) goto L5;
        return;
    L5:
        JSONObject r10 = r9.optJSONObject("disk");
        if (r10 != null) goto L9;
        return;
    L9:
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L11;
        com.bytedance.apm6.util.c.b.a("APM-Disk", "parseConfig:" + r10);
    L11:
        com.bytedance.apm6.disk.a.a r11 = new com.bytedance.apm6.disk.a.a();
        boolean r3 = false;
        if (r10.optInt("enable_upload", 0) != 1) goto L14;
        r3 = true;
    L14:
        r11.a(r3);
        if (r10.optInt("dump_threshold") <= 0) goto L18;
        r11.a((((long) r10.optInt("dump_threshold")) * 1024) * 1024);
    L18:
        if (r10.optInt("abnormal_folder_size") <= 0) goto L20;
        r11.b((((long) r10.optInt("abnormal_folder_size")) * 1024) * 1024);
    L20:
        r11.c(((long) r10.optInt("abnormal_file_size", 100)) * 1024);
        if (r10.optInt("dump_top_count") <= 0) goto L23;
        r11.a(r10.optInt("dump_top_count"));
    L23:
        r11.b(r10.optInt("dump_outdated_count", 50));
        r11.c(r10.optInt("dump_top_file_count", 20));
        r11.d(r10.optInt("dump_exception_dir_count", 50));
        if (r10.optInt("outdated_days") <= 0) goto L26;
        r11.d(((long) r10.optInt("outdated_days")) * 86400000);
    L26:
        r11.a(p.c(r10, "disk_customed_paths"));
        r11.b(p.b(r10, "ignored_relative_paths"));
        r11.c(p.b(r10, "compliance_relative_paths"));
        this.f5401a = r11;
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L29;
        com.bytedance.apm6.util.c.b.a("APM-Disk", "parseConfig:" + r10);
    L29:
        com.bytedance.apm6.disk.a.a().a(a());
    }
}
