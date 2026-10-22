package com.obric.autogui.agents.vlm.models;

import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;

/* JADX INFO: compiled from: VlmModelType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f27277a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f27278b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f27279c = null;
    private static final /* synthetic */ b[] f = null;
    private static final /* synthetic */ d.d.a g = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f27280d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f27281e;

    /* JADX INFO: compiled from: VlmModelType.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final b a(int r4) {
            b[] r0 = b.values();
            if (r4 < r0.length) goto L7;
            Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "unsupported model type int: " + r4 + "; falling back to UI-TARS.");
            return b.f27278b;
        L7:
            return r0[r4];
        }
    }

    private static final /* synthetic */ b[] b() {
        return new b[]{f27278b, f27279c};
    }

    private b(String r1, int r2, String r3, boolean r4) {
        super(r1, r2);
        this.f27280d = r3;
        this.f27281e = r4;
    }

    public final String a() {
        return this.f27280d;
    }

    static {
        f27278b = new b("UI_TARS", 0, "uitars", true);
        f27279c = new b("GUI_THINKER", 1, "gui_thinker", false);
        b[] r0 = b();
        f = r0;
        g = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        f27277a = new a(null);
    }

    public static b valueOf(String r2) {
        return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
    }

    public static b[] values() {
        return (b[]) ZeusTransformUtils.preCheckCast(f.clone(), b[].class, "com.obric.aiagent.plugin");
    }
}
