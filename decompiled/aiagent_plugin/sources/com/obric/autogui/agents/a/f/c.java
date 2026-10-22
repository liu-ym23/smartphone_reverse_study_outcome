package com.obric.autogui.agents.a.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActionEffectDetectionModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum c extends Enum<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f26402a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f26403b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f26404c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f26405d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f26406e = null;
    public static final c f = null;
    public static final c g = null;
    private static final /* synthetic */ c[] i = null;
    private static final /* synthetic */ d.d.a j = null;
    private final String h;

    private static final /* synthetic */ c[] b() {
        return new c[]{f26402a, f26403b, f26404c, f26405d, f26406e, f, g};
    }

    private c(String r1, int r2, String r3) {
        super(r1, r2);
        this.h = r3;
    }

    public final String a() {
        return this.h;
    }

    static {
        f26402a = new c("PAGE_COMPONENT", 0, "page_component");
        f26403b = new c("VIEW_TREE", 1, "view_tree");
        f26404c = new c("TYPE_VIEW_TREE_TEXT", 2, "type_view_tree_text");
        f26405d = new c("IMAGE", 3, "image");
        f26406e = new c("INPUT_TEXT", 4, "input_text");
        f = new c("SCROLL", 5, "scroll");
        g = new c("OPEN_APP_FOREGROUND", 6, "open_app_foreground");
        c[] r0 = b();
        i = r0;
        j = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static c valueOf(String r2) {
        return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
    }

    public static c[] values() {
        return (c[]) ZeusTransformUtils.preCheckCast(i.clone(), c[].class, "com.obric.aiagent.plugin");
    }
}
