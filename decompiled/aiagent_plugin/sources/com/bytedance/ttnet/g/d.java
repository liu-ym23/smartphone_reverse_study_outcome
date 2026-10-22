package com.bytedance.ttnet.g;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.setting.DownloadSettingValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: ModeRuntimeDelay.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends i.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f11451c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set<String> f11452d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set<String> f11453e;
    private final Set<String> f;
    private int g;
    private int h;
    private final AtomicLong i;
    private final Set<com.bytedance.retrofit2.b.c> j;

    public d() {
        this.f11451c = new f();
        this.f11452d = new CopyOnWriteArraySet();
        this.f11453e = new CopyOnWriteArraySet();
        this.f = new CopyOnWriteArraySet();
        this.g = DownloadSettingValues.SYNC_INTERVAL_MS_FG;
        this.h = DownloadSettingValues.SYNC_INTERVAL_MS_FG;
        this.i = new AtomicLong(0);
        this.j = new CopyOnWriteArraySet();
    }

    static /* synthetic */ Set a(d r0) {
        return r0.j;
    }

    private boolean d(com.bytedance.retrofit2.b.c r7) {
        this.f11451c.a(r7);
        boolean r1 = false;
        if (i.a(this.f11452d, r7.o()) == false) goto L7;
        this.i.set(System.currentTimeMillis());
        this.j.add(r7);
        return false;
    L7:
        if ((System.currentTimeMillis() - this.i.get()) <= this.g) goto L9;
    L19:
        return r1;
    L9:
        if (this.j.isEmpty() == true) goto L19;
        if (this.f11453e.isEmpty() == false) goto L14;
        r1 = true;
        if (this.f.isEmpty() == true) goto L19;
        return !i.a(this.f, r7.o());
    L14:
        return i.a(this.f11453e, r7.o());
    }

    @Override // com.bytedance.retrofit2.f.a
    public void a(com.bytedance.retrofit2.b.c r8) {
        if (d(r8) == false) goto L6;
        this.f11483a.a(r8, false, true, this.h);
        return;
    }

    @Override // com.bytedance.retrofit2.f.a
    public boolean a(com.bytedance.retrofit2.b.c r10, Executor r11, Runnable r12) {
        Executor r8 = (Executor) ZeusTransformUtils.wrapperContextForParams(r11, Executor.class, "com.obric.aiagent.plugin");
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r12, Runnable.class, "com.obric.aiagent.plugin");
        if (d(r10) == true) goto L5;
        return false;
    L5:
        return this.f11483a.a(r10, false, this.h, r7, r8);
    }

    @Override // com.bytedance.ttnet.g.i.a, com.bytedance.retrofit2.f.a
    public void b(final com.bytedance.retrofit2.b.c r3) {
        com.bytedance.frameworks.baselib.network.a.b.a(com.bytedance.frameworks.baselib.network.a.c.f7963a).a(new AnonymousClass1(this, r3));
    }

    @Override // com.bytedance.ttnet.g.i.a
    public boolean a(JSONObject r6) {
        super.a(r6);
        this.f11451c.a(r6);
        this.f11483a.a(r6, this.f11484b);
        JSONArray r0 = r6.optJSONArray("p0");
        int r1 = 0;
        if (r0 == null) goto L12;
        int r2 = 0;
    L6:
        if (r2 >= r0.length()) goto L12;
        String r3 = r0.optString(r2);
        if (TextUtils.isEmpty(r3) == true) goto L10;
        this.f11452d.add(r3);
    L10:
        r2 = r2 + 1;
    L12:
        if (this.f11451c.a() == false) goto L14;
    L16:
        JSONArray r4 = r6.optJSONArray("bl_for_runtime");
        if (r4 == null) goto L25;
        int r5 = 0;
    L20:
        if (r5 >= r4.length()) goto L25;
        String r7 = r4.optString(r5);
        if (TextUtils.isEmpty(r7) == true) goto L24;
        this.f11453e.add(r7);
    L24:
        r5 = r5 + 1;
    L25:
        JSONArray r8 = r6.optJSONArray("wl_for_runtime");
        if (r8 != null) goto L28;
    L33:
        this.g = r6.optInt("p0_check_max_ms", DownloadSettingValues.SYNC_INTERVAL_MS_FG);
        this.h = r6.optInt("p1_wait_max_ms", DownloadSettingValues.SYNC_INTERVAL_MS_FG);
        return true;
    L28:
        if (r1 >= r8.length()) goto L33;
        String r9 = r8.optString(r1);
        if (TextUtils.isEmpty(r9) == true) goto L32;
        this.f.add(r9);
    L32:
        r1 = r1 + 1;
        goto L28
    L14:
        if (this.f11452d.isEmpty() == false) goto L16;
        return false;
    }

    @Override // com.bytedance.ttnet.g.i.a
    public void b() {
        super.b();
        this.f11483a.a();
    }

    @Override // com.bytedance.ttnet.g.i.a
    i.b c() {
        return i.b.f11491c;
    }
}
