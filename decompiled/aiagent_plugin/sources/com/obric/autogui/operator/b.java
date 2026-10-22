package com.obric.autogui.operator;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AOOperation.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.autogui.operator.a.c.b f29868a;

    /* JADX INFO: compiled from: AOOperation.kt */
    public interface a {
    }

    /* JADX INFO: renamed from: com.obric.autogui.operator.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AOOperation.kt */
    public static final enum EnumC0777b extends Enum<EnumC0777b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC0777b f29869a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0777b f29870b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final EnumC0777b f29871c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final EnumC0777b f29872d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final EnumC0777b f29873e = null;
        public static final EnumC0777b f = null;
        public static final EnumC0777b g = null;
        public static final EnumC0777b h = null;
        public static final EnumC0777b i = null;
        public static final EnumC0777b j = null;
        private static final /* synthetic */ EnumC0777b[] l = null;
        private static final /* synthetic */ d.d.a m = null;
        private final b k;

        private static final /* synthetic */ EnumC0777b[] b() {
            return new EnumC0777b[]{f29869a, f29870b, f29871c, f29872d, f29873e, f, g, h, i, j};
        }

        private EnumC0777b(String r1, int r2, b r3) {
            super(r1, r2);
            this.k = r3;
        }

        public final b a() {
            return this.k;
        }

        static {
            f29869a = new EnumC0777b("OpenApp", 0, (b) ZeusTransformUtils.preCheckCast(new com.obric.autogui.operator.a.b.a.a(), b.class, "com.obric.aiagent.plugin"));
            f29870b = new EnumC0777b("ClickUI", 1, (b) ZeusTransformUtils.preCheckCast(new com.obric.autogui.operator.a.b.b(), b.class, "com.obric.aiagent.plugin"));
            f29871c = new EnumC0777b("ScrollWheel", 2, (b) ZeusTransformUtils.preCheckCast(new com.obric.autogui.operator.a.b.b.d(), b.class, "com.obric.aiagent.plugin"));
            f29872d = new EnumC0777b("Wait", 3, (b) ZeusTransformUtils.preCheckCast(new com.obric.autogui.operator.a.b.g(), b.class, "com.obric.aiagent.plugin"));
            f29873e = new EnumC0777b("WaitImeReady", 4, (b) ZeusTransformUtils.preCheckCast(new com.obric.autogui.operator.a.b.h(), b.class, "com.obric.aiagent.plugin"));
            f = new EnumC0777b("TypeText", 5, (b) ZeusTransformUtils.preCheckCast(new com.obric.autogui.operator.a.b.f(), b.class, "com.obric.aiagent.plugin"));
            g = new EnumC0777b("DeviceAction", 6, (b) ZeusTransformUtils.preCheckCast(new com.obric.autogui.operator.a.b.c(), b.class, "com.obric.aiagent.plugin"));
            h = new EnumC0777b("GetMemoryAction", 7, (b) ZeusTransformUtils.preCheckCast(new com.obric.autogui.operator.a.b.d(), b.class, "com.obric.aiagent.plugin"));
            i = new EnumC0777b("BrowserUse", 8, (b) ZeusTransformUtils.preCheckCast(new com.obric.autogui.operator.a.b.a(), b.class, "com.obric.aiagent.plugin"));
            j = new EnumC0777b("SwipeUI", 9, (b) ZeusTransformUtils.preCheckCast(new com.obric.autogui.operator.a.b.e(), b.class, "com.obric.aiagent.plugin"));
            EnumC0777b[] r0 = b();
            l = r0;
            m = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static EnumC0777b valueOf(String r2) {
            return (EnumC0777b) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnumC0777b.class, r2), EnumC0777b.class, "com.obric.aiagent.plugin");
        }

        public static EnumC0777b[] values() {
            return (EnumC0777b[]) ZeusTransformUtils.preCheckCast(l.clone(), EnumC0777b[].class, "com.obric.aiagent.plugin");
        }
    }

    public abstract b a(a r1);

    public abstract Object a(Context r1, d.c.d<? super c> r2);

    public void a(e r1) {
        d.h.b.o.e(r1, "step");
    }

    public void b(e r1) {
        d.h.b.o.e(r1, "step");
    }

    public b() {
    }

    public com.obric.autogui.operator.a.c.b a() {
        return this.f29868a;
    }
}
