package com.miui.guardprovider.sdk;

import android.os.Bundle;
import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;

/* JADX INFO: compiled from: ScanRequestArgs.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f13918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f13919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f13920c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f13921d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f13922e;
    private final int f;
    private final int g;
    private final int h;
    private final Set<String> i;

    /* JADX INFO: compiled from: ScanRequestArgs.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f13923a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f13924b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f13925c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f13926d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f13927e;
        private int f;
        private final int g;
        private int h;
        private Set<String> i;

        public a(int r2) {
            this.f13923a = true;
            this.f13924b = true;
            this.f13925c = false;
            this.f13926d = false;
            this.f13927e = false;
            this.f = 0;
            this.h = 0;
            this.i = Set.of();
            this.g = r2;
        }

        public a a(boolean r1) {
            this.f13925c = r1;
            return this;
        }

        public a a(int r1) {
            this.f = r1;
            return this;
        }

        public b a() {
            if (this.h != 2) goto L10;
            if (this.i.isEmpty() == false) goto L10;
            throw new IllegalArgumentException("setEngineNames should be called when mode is specified.");
        L10:
            return new b(this.f13923a, this.f13924b, this.f13925c, this.f13926d, this.f13927e, this.g, this.f, this.h, this.i, null);
        }
    }

    /* synthetic */ b(boolean r12, boolean r13, boolean r14, boolean r15, boolean r16, int r17, int r18, int r19, Set r20, c r21) {
        this(r12, r13, r14, r15, r16, r17, r18, r19, (Set) ZeusTransformUtils.wrapperContextForParams(r20, Set.class, "com.obric.aiagent.plugin"));
    }

    private b(boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, int r8, int r9, int r10, Set<String> r11) {
        Set<String> r12 = (Set) ZeusTransformUtils.wrapperContextForParams(r11, Set.class, "com.obric.aiagent.plugin");
        this.f13918a = r3;
        this.f13919b = r4;
        this.f13920c = r5;
        this.f13921d = r6;
        this.f13922e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r12;
    }

    static Bundle a() {
        return new a(0).a().b();
    }

    Bundle b() {
        Bundle r0 = new Bundle();
        r0.putBoolean("use_cloud_scan", this.f13918a);
        r0.putBoolean("use_cache", this.f13919b);
        r0.putBoolean("reject_when_busy", this.f13920c);
        r0.putBoolean("skip_whitelist", this.f13921d);
        r0.putBoolean("wait_all_engines", this.f13922e);
        r0.putInt(DBHelper.BATTERY_COL_SCENE, this.f);
        int r1 = this.g;
        if (r1 <= 0) goto L5;
        r0.putInt("request_timeout", r1);
    L5:
        r0.putInt("engine_mode", this.h);
        if (this.i.isEmpty() == true) goto L8;
        r0.putStringArray("engine_names", (String[]) ZeusTransformUtils.preCheckCast(this.i.toArray(new String[0]), String[].class, "com.obric.aiagent.plugin"));
    L8:
        return r0;
    }
}
