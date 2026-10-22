package com.obric.autogui.agents.vlm.models.a;

import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: IStepSpecsProviders.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface d {

    /* JADX INFO: compiled from: IStepSpecsProviders.kt */
    public static final class a {
        public static boolean b(d r2) {
            d r3 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin");
            return false;
        }

        public static boolean c(d r2) {
            d r3 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin");
            return false;
        }

        public static boolean e(d r2) {
            d r3 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin");
            return false;
        }

        public static Bundle f(d r2) {
            d r3 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin");
            return null;
        }

        public static String a(d r2) {
            return ((d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin")).w();
        }

        public static b d(d r2) {
            d r3 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin");
            return b.f27243b;
        }
    }

    /* JADX INFO: compiled from: IStepSpecsProviders.kt */
    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f27242a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f27243b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f27244c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f27245d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f27246e = null;
        public static final b f = null;
        private static final /* synthetic */ b[] h = null;
        private static final /* synthetic */ d.d.a i = null;
        private final int g;

        private static final /* synthetic */ b[] a() {
            return new b[]{f27242a, f27243b, f27244c, f27245d, f27246e, f};
        }

        private b(String r1, int r2, int r3) {
            super(r1, r2);
            this.g = r3;
        }

        public final int getIdentifier() {
            return this.g;
        }

        static {
            f27242a = new b("UNSOLICITED", 0, 0);
            f27243b = new b("NORMAL", 1, 1);
            f27244c = new b("CALL_USER", 2, 2);
            f27245d = new b("CLARIFY", 3, 3);
            f27246e = new b("SET_TIMER_TASK", 4, 4);
            f = new b("ACCESS_CLIPBOARD", 5, 5);
            b[] r0 = a();
            h = r0;
            i = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(h.clone(), b[].class, "com.obric.aiagent.plugin");
        }
    }

    boolean A();

    boolean B();

    b C();

    Bundle g();

    boolean h();

    String w();

    String z();
}
