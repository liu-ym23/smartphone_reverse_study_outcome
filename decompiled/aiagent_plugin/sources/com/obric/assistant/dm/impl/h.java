package com.obric.assistant.dm.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActionName.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum h extends Enum<h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f22492a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f22493b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f22494c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h f22495d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final h f22496e = null;
    public static final h f = null;
    public static final h g = null;
    private static final /* synthetic */ h[] i = null;
    private static final /* synthetic */ d.d.a j = null;
    private final String h;

    private static final /* synthetic */ h[] b() {
        return new h[]{f22492a, f22493b, f22494c, f22495d, f22496e, f, g};
    }

    private h(String r1, int r2, String r3) {
        super(r1, r2);
        this.h = r3;
    }

    public final String a() {
        return this.h;
    }

    static {
        f22492a = new h("SEARCH_SMS", 0, "SearchSms");
        f22493b = new h("SEARCH_CONTACT", 1, "SearchContact");
        f22494c = new h("SEARCH_CALL_HISTORY", 2, "SearchCallHistory");
        f22495d = new h("SEARCH_PHOTO", 3, "SearchPhoto");
        f22496e = new h("SEARCH_ALBUM", 4, "SearchAlbum");
        f = new h("SEARCH_NOTE", 5, "SearchNote");
        g = new h("SEARCH_ALARM", 6, "SearchAlarm");
        h[] r0 = b();
        i = r0;
        j = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static h valueOf(String r2) {
        return (h) ZeusTransformUtils.preCheckCast(Enum.valueOf(h.class, r2), h.class, "com.obric.aiagent.plugin");
    }

    public static h[] values() {
        return (h[]) ZeusTransformUtils.preCheckCast(i.clone(), h[].class, "com.obric.aiagent.plugin");
    }
}
