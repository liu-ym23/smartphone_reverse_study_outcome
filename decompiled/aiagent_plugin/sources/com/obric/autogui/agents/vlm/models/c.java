package com.obric.autogui.agents.vlm.models;

import com.obric.autogui.common.api.platform.display.capture.ScreenshotResult;
import com.obric.autogui.common.api.platform.system.viewhierarchy.ViewHierarchyDump;
import com.obric.autogui.operator.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.b.h;
import d.h.b.o;
import java.util.List;
import kotlinx.coroutines.au;

/* JADX INFO: compiled from: VlmStepMaker.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface c {

    /* JADX INFO: compiled from: VlmStepMaker.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f27282a = null;

        static {
            f27282a = new a();
        }

        private a() {
        }

        public final String a(String r2) {
            o.e(r2, "stepId");
            return "prep_" + r2;
        }

        public final String b(String r2) {
            o.e(r2, "sessionKey");
            return "term_" + r2;
        }
    }

    /* JADX INFO: compiled from: VlmStepMaker.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f27283a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f27284b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f27285c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f27286d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final com.obric.autogui.session.c.a f27287e;
        private int f;
        private Long g;
        private Boolean h;
        private ScreenshotResult i;
        private Long j;
        private byte[] k;
        private final boolean l;
        private au<? extends List<ViewHierarchyDump>> m;

        /* JADX INFO: compiled from: VlmStepMaker.kt */
        public static final class a {
            public /* synthetic */ a(h r1) {
                this();
            }

            private a() {
            }
        }

        static {
            f27283a = new a(null);
        }

        public b(String r3, int r4, boolean r5, com.obric.autogui.session.c.a r6, int r7, Long r8, Boolean r9, ScreenshotResult r10, Long r11, byte[] r12, boolean r13, au<? extends List<ViewHierarchyDump>> r14) {
            au<? extends List<ViewHierarchyDump>> r15 = (au) ZeusTransformUtils.wrapperContextForParams(r14, au.class, "com.obric.aiagent.plugin");
            o.e(r3, "stepId");
            o.e(r6, "metrics");
            this.f27284b = r3;
            this.f27285c = r4;
            this.f27286d = r5;
            this.f27287e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            this.j = r11;
            this.k = r12;
            this.l = r13;
            this.m = r15;
        }

        public /* synthetic */ b(String r18, int r19, boolean r20, com.obric.autogui.session.c.a r21, int r22, Long r23, Boolean r24, ScreenshotResult r25, Long r26, byte[] r27, boolean r28, au r29, int r30, h r31) {
            au r1 = (au) ZeusTransformUtils.wrapperContextForParams(r29, au.class, "com.obric.aiagent.plugin");
            if ((r30 & 16) == 0) goto L5;
            int r9 = 0;
        L7:
            if ((r30 & 32) == 0) goto L9;
            Long r10 = null;
        L11:
            if ((r30 & 64) == 0) goto L13;
            Boolean r11 = null;
        L15:
            if ((r30 & 256) == 0) goto L17;
            Long r13 = null;
        L19:
            if ((r30 & 512) == 0) goto L21;
            byte[] r14 = null;
        L23:
            if ((r30 & 1024) == 0) goto L25;
            boolean r15 = false;
        L27:
            if ((r30 & 2048) == 0) goto L29;
            au r16 = null;
        L30:
            this(r18, r19, r20, r21, r9, r10, r11, r25, r13, r14, r15, r16);
            return;
        L29:
            r16 = r1;
            goto L30
        L25:
            r15 = r28;
            goto L27
        L21:
            r14 = r27;
            goto L23
        L17:
            r13 = r26;
            goto L19
        L13:
            r11 = r24;
            goto L15
        L9:
            r10 = r23;
            goto L11
        L5:
            r9 = r22;
            goto L7
        }

        public final String a() {
            return this.f27284b;
        }

        public final int b() {
            return this.f27285c;
        }

        public final com.obric.autogui.session.c.a c() {
            return this.f27287e;
        }

        public final void a(int r1) {
            this.f = r1;
        }

        public final int d() {
            return this.f;
        }

        public final void a(Long r1) {
            this.g = r1;
        }

        public final Long e() {
            return this.g;
        }

        public final void a(Boolean r1) {
            this.h = r1;
        }

        public final Boolean f() {
            return this.h;
        }

        public final void a(ScreenshotResult r1) {
            this.i = r1;
        }

        public final ScreenshotResult g() {
            return this.i;
        }

        public final void b(Long r1) {
            this.j = r1;
        }

        public final Long h() {
            return this.j;
        }

        public final byte[] i() {
            return this.k;
        }

        public final boolean j() {
            return this.l;
        }

        public final void a(au<? extends List<ViewHierarchyDump>> r3) {
            this.m = (au) ZeusTransformUtils.wrapperContextForParams(r3, au.class, "com.obric.aiagent.plugin");
        }

        public final au<List<ViewHierarchyDump>> k() {
            return this.m;
        }
    }

    Object a(com.obric.autogui.agents.vlm.b.C0677b r1, com.obric.autogui.agents.a.d r2, d<? super com.obric.autogui.common.d<b>> r3);

    Object a(com.obric.autogui.agents.vlm.b.C0677b r1, b r2, d<? super com.obric.autogui.common.d<e>> r3);

    Object a(com.obric.autogui.agents.vlm.b.C0677b r1, d<? super com.obric.autogui.common.e> r2);

    void a();

    void a(com.obric.autogui.agents.vlm.b.C0677b r1);
}
