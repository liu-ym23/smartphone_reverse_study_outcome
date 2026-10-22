package com.bytedance.android.monitorV2.hybridSetting;

import com.bytedance.android.monitorV2.DataReporter;
import com.bytedance.android.monitorV2.listener.EventWatchTools;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes12.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f163106a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static com.bytedance.android.monitorV2.settings.g f163107b;

    public static final class a {
        public a() {
        }

        public static void a() {
            if (EventWatchTools.f163109k == true) goto L16;
            if (Switches.checkSelf.isEnabled() == false) goto L16;
            com.bytedance.android.monitorV2.g r100 = com.bytedance.android.monitorV2.g.e();
            EventWatchTools r101 = new EventWatchTools();
            r100.getClass();
            monitor-enter(r101);
            ((CopyOnWriteArrayList) r100.f163048i).add(r101);     // Catch: Throwable -> L12
            monitor-exit(r101);     // Catch: Throwable -> L12
            EventWatchTools.f163109k = true;
        L12:
            th = move-exception;
            throw th;
        L16:
            if (com.bytedance.android.monitorV2.listener.b.f163121b == false) goto L19;
        L21:
            nz2.b.a("SettingsParseManager", "highPriorityTaskDone");
            return;
        L19:
            if (Switches.teaReport.isEnabled() == false) goto L21;
            com.bytedance.android.monitorV2.g.e().g(new com.bytedance.android.monitorV2.listener.b());
            com.bytedance.android.monitorV2.listener.b.f163121b = true;
            goto L21
        }

        public static void b() {
            DataReporter.f162979a.d();
            if (Switches.appSettings.isEnabled() == true) goto L5;
        L8:
            nz2.b.a("SettingsParseManager", "lowPriorityTaskDone");
            return;
        L5:
            if (k.f163107b == null) goto L7;
            g37.a.c("hybrid_monitor").e(true);
            nz2.b.f("SettingsParseManager", "update app settings...");
            goto L8
        L7:
            k.f163107b = new com.bytedance.android.monitorV2.settings.g();
            goto L8
        }
    }

    static {
        f163106a = new a();
    }
}
