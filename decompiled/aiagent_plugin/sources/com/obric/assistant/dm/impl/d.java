package com.obric.assistant.dm.impl;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: EntityType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum d extends Enum<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f22483a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f22484b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f22485c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f22486d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f22487e = null;
    public static final d f = null;
    public static final d g = null;
    public static final d h = null;
    public static final d i = null;
    public static final d j = null;
    public static final d k = null;
    public static final d l = null;
    public static final d m = null;
    public static final d n = null;
    public static final d o = null;
    private static final /* synthetic */ d[] q = null;
    private static final /* synthetic */ d.d.a r = null;
    private final String p;

    private static final /* synthetic */ d[] b() {
        return new d[]{f22483a, f22484b, f22485c, f22486d, f22487e, f, g, h, i, j, k, l, m, n, o};
    }

    private d(String r1, int r2, String r3) {
        super(r1, r2);
        this.p = r3;
    }

    public final String a() {
        return this.p;
    }

    static {
        f22483a = new d("MESSAGE", 0, "message");
        f22484b = new d("CONTACT", 1, "contact");
        f22485c = new d("CALL_HISTORY", 2, "callhistory");
        f22486d = new d("PHOTO", 3, "photo");
        f22487e = new d("ALBUM", 4, "album");
        f = new d("SCHEDULE", 5, MonitorConstants.SCHEDULE);
        g = new d("RECORDER", 6, "recorder");
        h = new d("NOTE", 7, "note");
        i = new d("ALARM", 8, "alarm");
        j = new d("FILE", 9, "file");
        k = new d("WEBSITE", 10, "website");
        l = new d("TEXT", 11, "text");
        m = new d("TELEPHONE", 12, SensitiveType.TELEPHONE);
        n = new d("MEMORY", 13, "memory");
        o = new d("UNKNOWN", 14, SensitiveType.UNKNOWN);
        d[] r0 = b();
        q = r0;
        r = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static d valueOf(String r2) {
        return (d) ZeusTransformUtils.preCheckCast(Enum.valueOf(d.class, r2), d.class, "com.obric.aiagent.plugin");
    }

    public static d[] values() {
        return (d[]) ZeusTransformUtils.preCheckCast(q.clone(), d[].class, "com.obric.aiagent.plugin");
    }
}
