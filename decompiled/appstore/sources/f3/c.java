package f3;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.apm.util.n;
import com.bytedance.apm6.disk.config.DiskConfigService;
import com.bytedance.apm6.hub.config.internal.IConfigChangeListener;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c implements DiskConfigService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z2.a f19450a;

    public class a implements IConfigChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f19451a;

        public a(c r10) {
            this.f19451a = r10;
        }

        @Override // com.bytedance.apm6.hub.config.internal.IConfigChangeListener
        public void onConfigChanged(JSONObject r10, boolean r11) {
            c.a(this.f19451a, r10, r11);
        }
    }

    public c() {
        g3.a.g().h();
        g3.a.g().k(new a(this));
    }

    public static /* synthetic */ void a(c r10, JSONObject r11, boolean r12) {
        r10.b(r11, r12);
    }

    public final void b(JSONObject r10, boolean r11) {
        JSONObject r12 = r10.optJSONObject("performance_modules");
        if (r12 != null) goto L5;
        return;
    L5:
        JSONObject r13 = r12.optJSONObject("disk");
        if (r13 != null) goto L9;
        return;
    L9:
        if (r3.a.c() == false) goto L11;
        s3.a.a("APM-Disk", "parseConfig:" + r13);
    L11:
        z2.a r14 = new z2.a();
        boolean r15 = false;
        if (r13.optInt("enable_upload", 0) != 1) goto L14;
        r15 = true;
    L14:
        r14.w(r15);
        if (r13.optInt("dump_threshold") <= 0) goto L18;
        r14.n(((long) r13.optInt("dump_threshold")) * PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
    L18:
        if (r13.optInt("abnormal_folder_size") <= 0) goto L20;
        r14.p(((long) r13.optInt("abnormal_folder_size")) * PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
    L20:
        r14.o(((long) r13.optInt(SlardarSettingsConstants.PERF_DISK_KEY_ABNORMAL_FILE_SIZE, 100)) * 1024);
        if (r13.optInt("dump_top_count") <= 0) goto L23;
        r14.t(r13.optInt("dump_top_count"));
    L23:
        r14.u(r13.optInt(SlardarSettingsConstants.PERF_DISK_KEY_DUMP_OUTDATED_COUNT, 50));
        r14.v(r13.optInt(SlardarSettingsConstants.PERF_DISK_KEY_DUMP_TOP_FILE_COUNT, 20));
        r14.s(r13.optInt(SlardarSettingsConstants.PERF_DISK_KEY_DUMP_TOP_EXCEPTION_DIR_COUNT, 50));
        if (r13.optInt("outdated_days") <= 0) goto L26;
        r14.r(((long) r13.optInt("outdated_days")) * 86400000);
    L26:
        r14.m(n.e(r13, "disk_customed_paths"));
        r14.q(n.d(r13, "ignored_relative_paths"));
        r14.l(n.d(r13, "compliance_relative_paths"));
        this.f19450a = r14;
        if (r3.a.c() == false) goto L29;
        s3.a.a("APM-Disk", "parseConfig:" + r13);
    L29:
        y2.a.d().g(getConfig());
    }

    @Override // com.bytedance.apm6.disk.config.DiskConfigService
    public z2.a getConfig() {
        return this.f19450a;
    }
}
