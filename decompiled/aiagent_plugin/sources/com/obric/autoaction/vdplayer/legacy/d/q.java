package com.obric.autoaction.vdplayer.legacy.d;

import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.vdplayer.api.feedback.IFeedbackApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VDPlayerEffect.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class q implements com.obric.autoaction.vdplayer.legacy.b.a {

    /* JADX INFO: compiled from: VDPlayerEffect.kt */
    public static final class a extends q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f25933a = null;

        static {
            f25933a = new a();
        }

        private a() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: VDPlayerEffect.kt */
    public static final class b extends q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IAutoActionAgentEventListener.OperatingAppInfo f25934a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f25934a, r6.f25934a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            IAutoActionAgentEventListener.OperatingAppInfo r0 = this.f25934a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public String toString() {
            return "FinishAndOpenApp(operatingAppInfo=" + this.f25934a + ')';
        }

        public b(IAutoActionAgentEventListener.OperatingAppInfo r2) {
            super(null);
            this.f25934a = r2;
        }

        public final IAutoActionAgentEventListener.OperatingAppInfo a() {
            return this.f25934a;
        }
    }

    /* JADX INFO: compiled from: VDPlayerEffect.kt */
    public static final class c extends q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f25935a = null;

        static {
            f25935a = new c();
        }

        private c() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: VDPlayerEffect.kt */
    public static final class d extends q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IFeedbackApi.a f25936a;

        public d(IFeedbackApi.a r2) {
            d.h.b.o.e(r2, "feedbackInfo");
            super(null);
            this.f25936a = r2;
        }

        public final IFeedbackApi.a a() {
            return this.f25936a;
        }
    }

    /* JADX INFO: compiled from: VDPlayerEffect.kt */
    public static final class e extends q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f25937a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f25937a, r6.f25937a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f25937a.hashCode();
        }

        public String toString() {
            return "OpenShare(url=" + this.f25937a + ')';
        }
    }

    /* JADX INFO: compiled from: VDPlayerEffect.kt */
    public static final class f extends q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f25938a = null;

        static {
            f25938a = new f();
        }

        private f() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: VDPlayerEffect.kt */
    public static final class g extends q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f25939a = null;

        static {
            f25939a = new g();
        }

        private g() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: VDPlayerEffect.kt */
    public static final class h extends q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f25940a = null;

        static {
            f25940a = new h();
        }

        private h() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: VDPlayerEffect.kt */
    public static final class i extends q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f25941a = null;

        static {
            f25941a = new i();
        }

        private i() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: VDPlayerEffect.kt */
    public static final class j extends q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Integer f25942a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f25943b;

        /* JADX WARN: Multi-variable type inference failed */
        public j() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3, 0 == true ? 1 : 0);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, j.class) == true) goto L8;
            return false;
        L8:
            j r6 = (j) ZeusTransformUtils.preCheckCast(r5, j.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f25942a, r6.f25942a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f25943b, r6.f25943b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            Integer r0 = this.f25942a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.f25943b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "ShowToast(messageResId=" + this.f25942a + ", message=" + this.f25943b + ')';
        }

        public /* synthetic */ j(Integer r2, String r3, int r4, d.h.b.h r5) {
            if ((r4 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = null;
        L8:
            this(r2, r3);
        }

        public final Integer a() {
            return this.f25942a;
        }

        public final String b() {
            return this.f25943b;
        }

        public j(Integer r2, String r3) {
            super(null);
            this.f25942a = r2;
            this.f25943b = r3;
        }
    }

    public /* synthetic */ q(d.h.b.h r1) {
        this();
    }

    private q() {
    }
}
