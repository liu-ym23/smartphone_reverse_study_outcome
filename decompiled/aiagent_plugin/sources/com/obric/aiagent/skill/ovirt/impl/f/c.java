package com.obric.aiagent.skill.ovirt.impl.f;

import android.util.EventsUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.skill.virt.api.IVirtService;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.bduploader.BDVideoUploaderBase;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.am;
import kotlinx.coroutines.co;

/* JADX INFO: compiled from: SkillProjector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f21242a = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final d.o.k f21243e = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final IVirtService f21244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.aiagent.skill.virt.api.y f21245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.h.a.s<com.obric.aiagent.skill.virt.api.x, String, Long, String, d.c.d<? super com.obric.aiagent.skill.virt.api.z>, Object> f21246d;

    /* JADX INFO: compiled from: SkillProjector.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: SkillProjector.kt */
    @d.c.b.a.f(b = "SkillProjector.kt", c = {711}, d = "runShellPrimitive", e = "com.obric.aiagent.skill.ovirt.impl.projection.SkillProjector")
    static final class aa extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f21247a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f21248b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f21249c;

        aa(c r3, d.c.d<? super aa> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21248b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21247a = r3;
            this.f21249c |= Integer.MIN_VALUE;
            return c.e(this.f21248b, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillProjector.kt */
    @d.c.b.a.f(b = "SkillProjector.kt", c = {518, 527, 544, 544}, d = "snapshotDirectory", e = "com.obric.aiagent.skill.ovirt.impl.projection.SkillProjector")
    static final class ab extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21251b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21252c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f21253d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f21254e;
        /* synthetic */ Object f;
        final /* synthetic */ c g;
        int h;

        ab(c r3, d.c.d<? super ab> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f = r3;
            this.h |= Integer.MIN_VALUE;
            return c.b(this.g, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillProjector.kt */
    @d.c.b.a.f(b = "SkillProjector.kt", c = {545}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.projection.SkillProjector$snapshotDirectory$2")
    static final class ac extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21255a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f21256b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f21257c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f21258d;

        ac(c r3, String r4, String r5, d.c.d<? super ac> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21256b = r3;
            this.f21257c = r4;
            this.f21258d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super Boolean> r4) {
            return ((ac) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ac.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ac(this.f21256b, this.f21257c, this.f21258d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Boolean> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21255a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L11:
            return r7;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            c r8 = this.f21256b;
            String r2 = this.f21257c;
            String r3 = this.f21258d;
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21255a = 1;
            r7 = c.a(r8, r2, r3, r4);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: SkillProjector.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.aiagent.skill.ovirt.impl.f.a f21259a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f21260b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f21259a, r6.f21259a) == true) goto L12;
            return false;
        L12:
            if (this.f21260b == r6.f21260b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f21259a.hashCode() * 31) + Boolean.hashCode(this.f21260b);
        }

        public String toString() {
            return "ItemProjectionOutcome(result=" + this.f21259a + ", rootSafe=" + this.f21260b + ')';
        }

        public b(com.obric.aiagent.skill.ovirt.impl.f.a r2, boolean r3) {
            d.h.b.o.e(r2, "result");
            this.f21259a = r2;
            this.f21260b = r3;
        }

        public final com.obric.aiagent.skill.ovirt.impl.f.a a() {
            return this.f21259a;
        }

        public final boolean b() {
            return this.f21260b;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.skill.ovirt.impl.f.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SkillProjector.kt */
    private static final class C0447c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f21261a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final File f21262b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0447c.class) == true) goto L8;
            return false;
        L8:
            C0447c r6 = (C0447c) ZeusTransformUtils.preCheckCast(r5, C0447c.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f21261a, r6.f21261a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f21262b, r6.f21262b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f21261a.hashCode() * 31) + this.f21262b.hashCode();
        }

        public String toString() {
            return "ObricAttachment(relativePath=" + this.f21261a + ", file=" + this.f21262b + ')';
        }

        public C0447c(String r2, File r3) {
            d.h.b.o.e(r2, "relativePath");
            d.h.b.o.e(r3, "file");
            this.f21261a = r2;
            this.f21262b = r3;
        }

        public final String a() {
            return this.f21261a;
        }

        public final File b() {
            return this.f21262b;
        }
    }

    /* JADX INFO: compiled from: SkillProjector.kt */
    private static final class d extends Exception {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f21263a;

        public d(String r2) {
            d.h.b.o.e(r2, "reason");
            super(r2);
            this.f21263a = r2;
        }

        public final String a() {
            return this.f21263a;
        }
    }

    /* JADX INFO: compiled from: SkillProjector.kt */
    private static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f21264a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<String> f21265b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
            if (this.f21264a == r6.f21264a) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f21265b, r6.f21265b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.f21264a) * 31) + this.f21265b.hashCode();
        }

        public String toString() {
            return "ObricSkillManifest(isSecret=" + this.f21264a + ", attachments=" + this.f21265b + ')';
        }

        public e(boolean r3, List<String> r4) {
            List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r5, "attachments");
            this.f21264a = r3;
            this.f21265b = r5;
        }

        public final boolean a() {
            return this.f21264a;
        }

        public final List<String> b() {
            return this.f21265b;
        }
    }

    /* JADX INFO: compiled from: SkillProjector.kt */
    private static final class f extends Exception {
        public /* synthetic */ f(String r1, Throwable r2, int r3, d.h.b.h r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = null;
        L5:
            this(r1, r2);
        }

        public f(String r2, Throwable r3) {
            d.h.b.o.e(r2, "message");
            super(r2, r3);
        }
    }

    /* JADX INFO: compiled from: SkillProjector.kt */
    private interface g<T> {

        /* JADX INFO: compiled from: SkillProjector.kt */
        public static final class a implements g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f21266a;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
                return false;
            L8:
                a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
                if (d.h.b.o.a(this.f21266a, r6.f21266a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f21266a.hashCode();
            }

            public String toString() {
                return "Invalid(reason=" + this.f21266a + ')';
            }

            public a(String r2) {
                d.h.b.o.e(r2, "reason");
                this.f21266a = r2;
            }

            public final String a() {
                return this.f21266a;
            }
        }

        /* JADX INFO: compiled from: SkillProjector.kt */
        public static final class b<T> implements g<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final T f21267a;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
                return false;
            L8:
                b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
                if (d.h.b.o.a(this.f21267a, r6.f21267a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                T r0 = this.f21267a;
                if (r0 != null) goto L6;
                return 0;
            L6:
                return r0.hashCode();
            }

            public String toString() {
                return "Valid(value=" + this.f21267a + ')';
            }

            public b(T r1) {
                this.f21267a = r1;
            }

            public final T a() {
                return this.f21267a;
            }
        }
    }

    /* JADX INFO: compiled from: SkillProjector.kt */
    @d.c.b.a.f(b = "SkillProjector.kt", c = {446}, d = "cleanupShareAttachment", e = "com.obric.aiagent.skill.ovirt.impl.projection.SkillProjector")
    static final class h extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f21268a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f21269b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f21270c;

        h(c r3, d.c.d<? super h> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21269b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21268a = r3;
            this.f21270c |= Integer.MIN_VALUE;
            return c.a(this.f21269b, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillProjector.kt */
    @d.c.b.a.f(b = "SkillProjector.kt", c = {465}, d = "cleanupStagingSkill", e = "com.obric.aiagent.skill.ovirt.impl.projection.SkillProjector")
    static final class i extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f21271a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f21272b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f21273c;

        i(c r3, d.c.d<? super i> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21272b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21271a = r3;
            this.f21273c |= Integer.MIN_VALUE;
            return c.b(this.f21272b, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillProjector.kt */
    @d.c.b.a.f(b = "SkillProjector.kt", c = {648}, d = "clearProjectionRootBestEffort", e = "com.obric.aiagent.skill.ovirt.impl.projection.SkillProjector")
    static final class j extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21274a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f21275b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f21276c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f21277d;

        j(c r3, d.c.d<? super j> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21276c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21275b = r3;
            this.f21277d |= Integer.MIN_VALUE;
            return c.d(this.f21276c, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillProjector.kt */
    @d.c.b.a.f(b = "SkillProjector.kt", c = {366}, d = "ensureEmptyObricSkillDir", e = "com.obric.aiagent.skill.ovirt.impl.projection.SkillProjector")
    static final class k extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f21278a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f21279b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f21280c;

        k(c r3, d.c.d<? super k> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21279b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21278a = r3;
            this.f21280c |= Integer.MIN_VALUE;
            return c.c(this.f21279b, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillProjector.kt */
    @d.c.b.a.f(b = "SkillProjector.kt", c = {387, 398, BDVideoUploaderBase.KeyIsMaxUploadSpeedThresh, BDVideoUploaderBase.KeyIsMaxUploadSpeedThresh}, d = "importAndExtractAttachment", e = "com.obric.aiagent.skill.ovirt.impl.projection.SkillProjector")
    static final class l extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21281a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21282b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21283c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f21284d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f21285e;
        /* synthetic */ Object f;
        final /* synthetic */ c g;
        int h;

        l(c r3, d.c.d<? super l> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.f = r7;
            this.h |= Integer.MIN_VALUE;
            return c.a(this.g, null, null, null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillProjector.kt */
    @d.c.b.a.f(b = "SkillProjector.kt", c = {BDVideoUploaderBase.KeyIsPrivateVideo}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.projection.SkillProjector$importAndExtractAttachment$2")
    static final class m extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21286a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f21287b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.skill.virt.api.j f21288c;

        m(c r3, com.obric.aiagent.skill.virt.api.j r4, d.c.d<? super m> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21287b = r3;
            this.f21288c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((m) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), m.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new m(this.f21287b, this.f21288c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21286a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            c r7 = this.f21287b;
            String r2 = this.f21288c.a();
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21286a = 1;
            if (c.a(r7, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: SkillProjector.kt */
    @d.c.b.a.f(b = "SkillProjector.kt", c = {661}, d = "installCliTool", e = "com.obric.aiagent.skill.ovirt.impl.projection.SkillProjector")
    static final class n extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21289a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f21290b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f21291c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f21292d;

        n(c r3, d.c.d<? super n> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21291c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21290b = r3;
            this.f21292d |= Integer.MIN_VALUE;
            return c.a(this.f21291c, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillProjector.kt */
    @d.c.b.a.f(b = "SkillProjector.kt", c = {620}, d = "linkProjectionRoot", e = "com.obric.aiagent.skill.ovirt.impl.projection.SkillProjector")
    static final class o extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21293a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f21294b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f21295c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f21296d;

        o(c r3, d.c.d<? super o> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21295c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21294b = r3;
            this.f21296d |= Integer.MIN_VALUE;
            return c.c(this.f21295c, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillProjector.kt */
    @d.c.b.a.f(b = "SkillProjector.kt", c = {604}, d = "prepareProjectionRoot", e = "com.obric.aiagent.skill.ovirt.impl.projection.SkillProjector")
    static final class p extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21297a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f21298b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f21299c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f21300d;

        p(c r3, d.c.d<? super p> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21299c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21298b = r3;
            this.f21300d |= Integer.MIN_VALUE;
            return c.b(this.f21299c, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillProjector.kt */
    @d.c.b.a.f(b = "SkillProjector.kt", c = {41}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.projection.SkillProjector$projectInstalled$3")
    static final class r extends d.c.b.a.l implements d.h.a.q<com.obric.aiagent.skill.manager.api.ac, String, d.c.d<? super b>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21302a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f21303b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f21304c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f21305d;

        /* JADX INFO: renamed from: com.obric.aiagent.skill.ovirt.impl.f.c$r$1, reason: invalid class name */
        /* JADX INFO: compiled from: SkillProjector.kt */
        @d.c.b.a.f(b = "SkillProjector.kt", c = {47}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.projection.SkillProjector$projectInstalled$3$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.b<d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f21306a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f21307b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int f21308c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.obric.aiagent.skill.manager.api.ac f21309d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ c f21310e;

            AnonymousClass1(com.obric.aiagent.skill.manager.api.ac r3, c r4, d.c.d<? super AnonymousClass1> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21309d = r3;
                this.f21310e = r4;
                super(1, r6);
            }

            public final Object a(d.c.d<? super d.x> r3) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f21309d, this.f21310e, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.b
            public /* synthetic */ Object invoke(d.c.d<? super d.x> r3) {
                return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r7) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f21308c;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                Iterator r2 = (Iterator) ZeusTransformUtils.preCheckCast(this.f21307b, Iterator.class, "com.obric.aiagent.plugin");
                c r4 = (c) ZeusTransformUtils.preCheckCast(this.f21306a, c.class, "com.obric.aiagent.plugin");
                d.o.a(r7);
            L10:
                if (r2.hasNext() == false) goto L15;
                com.obric.aiagent.skill.manager.api.ab r8 = (com.obric.aiagent.skill.manager.api.ab) ZeusTransformUtils.preCheckCast(r2.next(), com.obric.aiagent.skill.manager.api.ab.class, "com.obric.aiagent.plugin");
                String r5 = r8.a();
                File r9 = r8.b();
                this.f21306a = r4;
                this.f21307b = r2;
                this.f21308c = 1;
                if (c.a(r4, r5, r9, this) != r0) goto L10;
                return r0;
            L15:
                return d.x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r7);
                Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(this.f21309d.c(), Iterable.class, "com.obric.aiagent.plugin");
                c r3 = this.f21310e;
                r4 = r3;
                r2 = r10.iterator();
                goto L10
            }
        }

        r(c r3, d.c.d<? super r> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21305d = r3;
            super(3, r5);
        }

        public final Object a(com.obric.aiagent.skill.manager.api.ac r3, String r4, d.c.d<? super b> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            r r0 = new r(this.f21305d, r6);
            r0.f21303b = r3;
            r0.f21304c = r4;
            return r0.invokeSuspend(d.x.f38692a);
        }

        @Override // d.h.a.q
        public /* synthetic */ Object invoke(com.obric.aiagent.skill.manager.api.ac r3, String r4, d.c.d<? super b> r5) {
            return a((com.obric.aiagent.skill.manager.api.ac) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.manager.api.ac.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r5, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21302a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r11);
        L11:
            return r11;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r11);
            com.obric.aiagent.skill.manager.api.ac r12 = (com.obric.aiagent.skill.manager.api.ac) ZeusTransformUtils.preCheckCast(this.f21303b, com.obric.aiagent.skill.manager.api.ac.class, "com.obric.aiagent.plugin");
            String r7 = (String) ZeusTransformUtils.preCheckCast(this.f21304c, String.class, "com.obric.aiagent.plugin");
            c r4 = this.f21305d;
            String r5 = r12.a();
            File r6 = r12.b();
            d.h.a.b r8 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r12, this.f21305d, null), d.h.a.b.class, "com.obric.aiagent.plugin");
            d.c.d r13 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21303b = null;
            this.f21302a = 1;
            r11 = c.a(r4, r5, r6, r7, r8, r13);
            if (r11 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: SkillProjector.kt */
    @d.c.b.a.f(b = "SkillProjector.kt", c = {70, 79, 82, EventsUtils.FEAT_TYPE_NFC_EVENT}, d = "projectItems", e = "com.obric.aiagent.skill.ovirt.impl.projection.SkillProjector")
    static final class s<T> extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21311a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21312b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21313c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f21314d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f21315e;
        Object f;
        /* synthetic */ Object g;
        final /* synthetic */ c h;
        int i;

        s(c r3, d.c.d<? super s> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.h = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.g = r3;
            this.i |= Integer.MIN_VALUE;
            return c.a(this.h, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillProjector.kt */
    @d.c.b.a.f(b = "SkillProjector.kt", c = {182, 195, 205, 212, 243, 243}, d = "projectObricSkill", e = "com.obric.aiagent.skill.ovirt.impl.projection.SkillProjector")
    static final class t extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21316a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21317b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21318c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f21319d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f21320e;
        Object f;
        Object g;
        int h;
        int i;
        /* synthetic */ Object j;
        final /* synthetic */ c k;
        int l;

        t(c r3, d.c.d<? super t> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.k = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.j = r3;
            this.l |= Integer.MIN_VALUE;
            return c.a(this.k, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillProjector.kt */
    @d.c.b.a.f(b = "SkillProjector.kt", c = {244}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.projection.SkillProjector$projectObricSkill$3")
    static final class u extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21321a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f21322b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f21323c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f21324d;

        u(c r3, String r4, String r5, d.c.d<? super u> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21322b = r3;
            this.f21323c = r4;
            this.f21324d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((u) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), u.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new u(this.f21322b, this.f21323c, this.f21324d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21321a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            c r8 = this.f21322b;
            String r2 = this.f21323c;
            String r3 = this.f21324d;
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21321a = 1;
            if (c.b(r8, r2, r3, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: SkillProjector.kt */
    @d.c.b.a.f(b = "SkillProjector.kt", c = {109, 111, 117, 133}, d = "projectOne", e = "com.obric.aiagent.skill.ovirt.impl.projection.SkillProjector")
    static final class v extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21325a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21326b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21327c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f21328d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f21329e;
        final /* synthetic */ c f;
        int g;

        v(c r3, d.c.d<? super v> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.f21329e = r7;
            this.g |= Integer.MIN_VALUE;
            return c.a(this.f, null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillProjector.kt */
    @d.c.b.a.f(b = "SkillProjector.kt", c = {134}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.projection.SkillProjector$projectOne$cleaned$1")
    static final class w extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21330a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f21331b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f21332c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f21333d;

        w(c r3, String r4, String r5, d.c.d<? super w> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21331b = r3;
            this.f21332c = r4;
            this.f21333d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super Boolean> r4) {
            return ((w) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), w.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new w(this.f21331b, this.f21332c, this.f21333d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Boolean> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21330a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L11:
            return r7;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            c r8 = this.f21331b;
            String r2 = this.f21332c;
            String r3 = this.f21333d;
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21330a = 1;
            r7 = c.a(r8, r2, r3, r4);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: SkillProjector.kt */
    @d.c.b.a.f(b = "SkillProjector.kt", c = {591}, d = "removeProjectedSkill", e = "com.obric.aiagent.skill.ovirt.impl.projection.SkillProjector")
    static final class x extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f21334a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f21335b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f21336c;

        x(c r3, d.c.d<? super x> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21335b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21334a = r3;
            this.f21336c |= Integer.MIN_VALUE;
            return c.d(this.f21335b, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillProjector.kt */
    @d.c.b.a.f(b = "SkillProjector.kt", c = {637}, d = "removeProjectedSkillBestEffort", e = "com.obric.aiagent.skill.ovirt.impl.projection.SkillProjector")
    static final class y extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21337a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f21338b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f21339c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f21340d;

        y(c r3, d.c.d<? super y> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21339c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21338b = r3;
            this.f21340d |= Integer.MIN_VALUE;
            return c.a(this.f21339c, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillProjector.kt */
    @d.c.b.a.f(b = "SkillProjector.kt", c = {576}, d = "replaceProjectedDirectory", e = "com.obric.aiagent.skill.ovirt.impl.projection.SkillProjector")
    static final class z extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f21341a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f21342b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f21343c;

        z(c r3, d.c.d<? super z> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21342b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21341a = r3;
            this.f21343c |= Integer.MIN_VALUE;
            return c.a(this.f21342b, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public c(IVirtService r3, com.obric.aiagent.skill.virt.api.y r4, d.h.a.s<? super com.obric.aiagent.skill.virt.api.x, ? super String, ? super Long, ? super String, ? super d.c.d<? super com.obric.aiagent.skill.virt.api.z>, ? extends Object> r5) {
        IVirtService r6 = (IVirtService) ZeusTransformUtils.wrapperContextForParams(r3, IVirtService.class, "com.obric.aiagent.plugin");
        d.h.a.s<com.obric.aiagent.skill.virt.api.x, String, Long, String, d.c.d<? super com.obric.aiagent.skill.virt.api.z>, Object> r7 = (d.h.a.s) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.s.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "virt");
        d.h.b.o.e(r4, "paths");
        d.h.b.o.e(r7, "executeSyncShell");
        this.f21244b = r6;
        this.f21245c = r4;
        this.f21246d = r7;
    }

    public static final /* synthetic */ Object a(c r2, String r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(c r2, String r3, File r4, d.c.d r5) {
        return r2.a(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(c r2, String r3, File r4, String r5, d.c.d r6) {
        return r2.a(r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(c r8, String r9, File r10, String r11, d.h.a.b r12, d.c.d r13) {
        return r8.a(r9, r10, r11, (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.b.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(c r6, String r7, String r8, C0447c r9, int r10, d.c.d r11) {
        return r6.a(r7, r8, r9, r10, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(c r2, String r3, String r4, d.c.d r5) {
        return r2.d(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(c r2, String r3, String r4, String r5, d.c.d r6) {
        return r2.a(r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(c r2, List r3, d.h.a.b r4, d.h.a.q r5, d.c.d r6) {
        return r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"), (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin"), (d.h.a.q) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.q.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object b(c r2, String r3, d.c.d r4) {
        return r2.b(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object b(c r2, String r3, File r4, String r5, d.c.d r6) {
        return r2.b(r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object b(c r2, String r3, String r4, d.c.d r5) {
        return r2.b(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object c(c r2, String r3, d.c.d r4) {
        return r2.c(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object c(c r2, String r3, String r4, d.c.d r5) {
        return r2.a(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object d(c r2, String r3, d.c.d r4) {
        return r2.d(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object d(c r2, String r3, String r4, d.c.d r5) {
        return r2.c(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object e(c r2, String r3, String r4, d.c.d r5) {
        return r2.e(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public final Object a(List<com.obric.aiagent.skill.manager.api.ac> r5, d.c.d<? super com.obric.aiagent.skill.ovirt.impl.f.b> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        d.c.d<? super com.obric.aiagent.skill.ovirt.impl.f.b> r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return a(r7, (d.h.a.b) ZeusTransformUtils.preCheckCast(q.f21301a, d.h.a.b.class, "com.obric.aiagent.plugin"), (d.h.a.q) ZeusTransformUtils.preCheckCast(new r(this, null), d.h.a.q.class, "com.obric.aiagent.plugin"), r8);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x01cd -> B:41:0x01ce). Please report as a decompilation issue!!! */
    private final <T> Object a(List<? extends T> r18, d.h.a.b<? super T, String> r19, d.h.a.q<? super T, ? super String, ? super d.c.d<? super b>, ? extends Object> r20, d.c.d<? super com.obric.aiagent.skill.ovirt.impl.f.b> r21) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.aiagent.plugin");
        d.h.a.b r10 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r19, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.q r1 = (d.h.a.q) ZeusTransformUtils.wrapperContextForParams(r20, d.h.a.q.class, "com.obric.aiagent.plugin");
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r21, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, s.class) == false) goto L7;
        s r3 = (s) ZeusTransformUtils.preCheckCast(r2, s.class, "com.obric.aiagent.plugin");
        if ((r3.i & Integer.MIN_VALUE) == 0) goto L7;
        r3.i -= Integer.MIN_VALUE;
    L8:
        Object r4 = r3.g;
        Object r5 = d.c.a.b.a();
        int r6 = r3.i;
        String r15 = null;
        if (r6 == 0) goto L20;
        if (r6 == 1) goto L19;
        if (r6 == 2) goto L18;
        if (r6 == 3) goto L17;
        if (r6 != 4) goto L16;
        List r0 = (List) ZeusTransformUtils.preCheckCast(r3.f21311a, List.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
    L68:
        boolean r7 = ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        if (r7 == true) goto L73;
        r15 = "root_link_failed";
    L73:
        return new com.obric.aiagent.skill.ovirt.impl.f.b(r0, true, r7, r15);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        List r8 = (List) ZeusTransformUtils.preCheckCast(r3.f21311a, List.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
    L63:
        return new com.obric.aiagent.skill.ovirt.impl.f.b(r8, true, false, "item_cleanup_failed");
    L18:
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(r3.f, Collection.class, "com.obric.aiagent.plugin");
        Iterator<T> r12 = (Iterator) ZeusTransformUtils.preCheckCast(r3.f21315e, Iterator.class, "com.obric.aiagent.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(r3.f21314d, Collection.class, "com.obric.aiagent.plugin");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r3.f21313c, String.class, "com.obric.aiagent.plugin");
        d.h.a.q r16 = (d.h.a.q) ZeusTransformUtils.preCheckCast(r3.f21312b, d.h.a.q.class, "com.obric.aiagent.plugin");
        c r17 = (c) ZeusTransformUtils.preCheckCast(r3.f21311a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
    L41:
        r11.add((b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.aiagent.plugin"));
        r11 = r13;
    L36:
        if (r12.hasNext() == false) goto L42;
        T r22 = r12.next();
        r3.f21311a = r17;
        r3.f21312b = r16;
        r3.f21313c = r14;
        r3.f21314d = r11;
        r3.f21315e = r12;
        r3.f = r11;
        r3.i = 2;
        r4 = r16.invoke(r22, r14, r3);
        if (r4 != r5) goto L40;
        return r5;
    L40:
        r13 = r11;
        goto L41
    L42:
        List r23 = (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.aiagent.plugin");
        Iterable r24 = (Iterable) ZeusTransformUtils.preCheckCast(r23, Iterable.class, "com.obric.aiagent.plugin");
        Collection r25 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r24, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator<T> r26 = r24.iterator();
    L44:
        if (r26.hasNext() == false) goto L46;
        r25.add(((b) ZeusTransformUtils.preCheckCast(r26.next(), b.class, "com.obric.aiagent.plugin")).a());
        goto L44
    L46:
        List r27 = (List) ZeusTransformUtils.preCheckCast(r25, List.class, "com.obric.aiagent.plugin");
        Iterable r28 = (Iterable) ZeusTransformUtils.preCheckCast(r23, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r28, Collection.class) == true) goto L49;
    L51:
        Iterator<T> r29 = r28.iterator();
    L53:
        if (r29.hasNext() == false) goto L50;
        if ((!((b) ZeusTransformUtils.preCheckCast(r29.next(), b.class, "com.obric.aiagent.plugin")).b()) == false) goto L53;
        boolean r30 = true;
    L57:
        if (r30 == false) goto L64;
        r3.f21311a = r27;
        r3.f21312b = null;
        r3.f21313c = null;
        r3.f21314d = null;
        r3.f21315e = null;
        r3.f = null;
        r3.i = 3;
        if (r17.d(r14, r3) != r5) goto L61;
        return r5;
    L61:
        r8 = r27;
        goto L63
    L64:
        r3.f21311a = r27;
        r3.f21312b = null;
        r3.f21313c = null;
        r3.f21314d = null;
        r3.f21315e = null;
        r3.f = null;
        r3.i = 4;
        Object r31 = r17.c(r14, r3);
        if (r31 != r5) goto L67;
        return r5;
    L67:
        r4 = r31;
        r0 = r27;
    L50:
        r30 = false;
        goto L57
    L49:
        if (((Collection) ZeusTransformUtils.preCheckCast(r28, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L51;
    L19:
        String r32 = (String) ZeusTransformUtils.preCheckCast(r3.f21315e, String.class, "com.obric.aiagent.plugin");
        d.h.a.q r33 = (d.h.a.q) ZeusTransformUtils.preCheckCast(r3.f21314d, d.h.a.q.class, "com.obric.aiagent.plugin");
        r10 = (d.h.a.b) ZeusTransformUtils.preCheckCast(r3.f21313c, d.h.a.b.class, "com.obric.aiagent.plugin");
        r9 = (List) ZeusTransformUtils.preCheckCast(r3.f21312b, List.class, "com.obric.aiagent.plugin");
        r17 = (c) ZeusTransformUtils.preCheckCast(r3.f21311a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        String r34 = r32;
        r1 = r33;
        Object r35 = r4;
    L27:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r35, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L34;
        Iterable r36 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin");
        Collection r37 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r36, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator<T> r38 = r36.iterator();
    L30:
        if (r38.hasNext() == false) goto L33;
        r37.add(r17.c((String) ZeusTransformUtils.preCheckCast(r10.invoke(r38.next()), String.class, "com.obric.aiagent.plugin"), "root_prepare_failed"));
        goto L30
    L33:
        return new com.obric.aiagent.skill.ovirt.impl.f.b((List) ZeusTransformUtils.preCheckCast(r37, List.class, "com.obric.aiagent.plugin"), false, false, "root_prepare_failed");
    L34:
        Iterable r39 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin");
        Collection r40 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r39, 10)), Collection.class, "com.obric.aiagent.plugin");
        r12 = r39.iterator();
        r14 = r34;
        r16 = r1;
        r11 = r40;
        goto L36
    L20:
        d.o.a(r4);
        String r41 = this.f21245c.b("skills").a();     // Catch: Exception -> L74
        r3.f21311a = this;
        r3.f21312b = r9;
        r3.f21313c = r10;
        r3.f21314d = r1;
        r3.f21315e = r41;
        r3.i = 1;
        Object r42 = b(r41, r3);
        if (r42 != r5) goto L25;
        return r5;
    L25:
        r35 = r42;
        r34 = r41;
        r17 = this;
    L74:
        e = move-exception;
        a(this, "projectSkills: SHARE root unavailable", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), null, 4, null);
        Iterable r43 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin");
        Collection r44 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r43, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator<T> r45 = r43.iterator();
    L77:
        if (r45.hasNext() == false) goto L80;
        r44.add(c((String) ZeusTransformUtils.preCheckCast(r10.invoke(r45.next()), String.class, "com.obric.aiagent.plugin"), "share_root_unavailable"));
        goto L77
    L80:
        return new com.obric.aiagent.skill.ovirt.impl.f.b((List) ZeusTransformUtils.preCheckCast(r44, List.class, "com.obric.aiagent.plugin"), false, false, "share_root_unavailable");
    L7:
        r3 = new s(this, r2);
        goto L8
    }

    private final Object a(String r17, File r18, String r19, d.h.a.b<? super d.c.d<? super d.x>, ? extends Object> r20, d.c.d<? super b> r21) {
        c r1 = this;
        String r2 = r17;
        String r3 = r19;
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r20, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r21, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, v.class) == false) goto L7;
        v r8 = (v) ZeusTransformUtils.preCheckCast(r7, v.class, "com.obric.aiagent.plugin");
        if ((r8.g & Integer.MIN_VALUE) == 0) goto L7;
        r8.g -= Integer.MIN_VALUE;
    L8:
        Object r9 = r8.f21329e;
        Object r10 = d.c.a.b.a();
        int r11 = r8.g;
        if (r11 != 0) goto L60;
        d.o.a(r9);
        c(r17);     // Catch: Exception -> L44 CancellationException -> L55
        r1.d(r18);     // Catch: Exception -> L44 CancellationException -> L55
        if (r1.b(r18) == false) goto L35;
        r8.f21325a = r1;     // Catch: Exception -> L44 CancellationException -> L55
        r8.f21326b = r2;     // Catch: Exception -> L44 CancellationException -> L55
        r8.f21327c = r3;     // Catch: Exception -> L44 CancellationException -> L55
        r8.f21328d = r5;     // Catch: Exception -> L44 CancellationException -> L55
        r8.g = 1;     // Catch: Exception -> L44 CancellationException -> L55
        r9 = r1.a(r2, r18, r3, r8);     // Catch: Exception -> L44 CancellationException -> L55
        if (r9 != r10) goto L34;
        return r10;
    L34:
        com.obric.aiagent.skill.ovirt.impl.f.e r0 = (com.obric.aiagent.skill.ovirt.impl.f.e) ZeusTransformUtils.preCheckCast(r9, com.obric.aiagent.skill.ovirt.impl.f.e.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L44 CancellationException -> L55
    L39:
        r8.f21325a = r1;     // Catch: Exception -> L44 CancellationException -> L55
        r8.f21326b = r2;     // Catch: Exception -> L44 CancellationException -> L55
        r8.f21327c = r3;     // Catch: Exception -> L44 CancellationException -> L55
        r8.f21328d = r0;     // Catch: Exception -> L44 CancellationException -> L55
        r8.g = 3;     // Catch: Exception -> L44 CancellationException -> L55
        if (r5.invoke(r8) != r10) goto L42;
        return r10;
    L42:
    L61:
        return new b(new com.obric.aiagent.skill.ovirt.impl.f.a(r2, r0, null, 4, null), true);
    L35:
        r8.f21325a = r1;     // Catch: Exception -> L44 CancellationException -> L55
        r8.f21326b = r2;     // Catch: Exception -> L44 CancellationException -> L55
        r8.f21327c = r3;     // Catch: Exception -> L44 CancellationException -> L55
        r8.f21328d = r5;     // Catch: Exception -> L44 CancellationException -> L55
        r8.g = 2;     // Catch: Exception -> L44 CancellationException -> L55
        r9 = r1.b(r2, r18, r3, r8);     // Catch: Exception -> L44 CancellationException -> L55
        if (r9 != r10) goto L38;
        return r10;
    L38:
        r0 = (com.obric.aiagent.skill.ovirt.impl.f.e) ZeusTransformUtils.preCheckCast(r9, com.obric.aiagent.skill.ovirt.impl.f.e.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L44 CancellationException -> L55
    L44:
        e = e;
    L45:
        r1.a("projectSkills: item projection failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), "projectSkills: item projection failed slug=" + r2);
        d.c.g r4 = (d.c.g) ZeusTransformUtils.preCheckCast(co.f39209b, d.c.g.class, "com.obric.aiagent.plugin");
        d.h.a.m r6 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new w(r1, r3, r2, null), d.h.a.m.class, "com.obric.aiagent.plugin");
        r8.f21325a = r1;
        r8.f21326b = r2;
        r8.f21327c = null;
        r8.f21328d = null;
        r8.g = 4;
        r9 = kotlinx.coroutines.i.a(r4, r6, r8);
        if (r9 != r10) goto L48;
        return r10;
    L48:
        String r12 = r2;
    L49:
        boolean r13 = ((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        if (r13 == false) goto L52;
        String r14 = "item_projection_failed";
    L54:
        return new b(r1.c(r12, r14), r13);
    L52:
        r14 = "item_cleanup_failed";
        goto L54
    L60:
        if (r11 == 1) goto L23;
        if (r11 == 2) goto L20;
        if (r11 == 3) goto L17;
        if (r11 != 4) goto L16;
        r12 = (String) ZeusTransformUtils.preCheckCast(r8.f21326b, String.class, "com.obric.aiagent.plugin");
        r1 = (c) ZeusTransformUtils.preCheckCast(r8.f21325a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r9);
        goto L49
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r0 = (com.obric.aiagent.skill.ovirt.impl.f.e) ZeusTransformUtils.preCheckCast(r8.f21328d, com.obric.aiagent.skill.ovirt.impl.f.e.class, "com.obric.aiagent.plugin");
        String r15 = (String) ZeusTransformUtils.preCheckCast(r8.f21327c, String.class, "com.obric.aiagent.plugin");
        r2 = (String) ZeusTransformUtils.preCheckCast(r8.f21326b, String.class, "com.obric.aiagent.plugin");
        c r16 = (c) ZeusTransformUtils.preCheckCast(r8.f21325a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r9);     // Catch: Exception -> L26 CancellationException -> L55
        r3 = r15;
        r1 = r16;
        goto L42
    L20:
        r5 = (d.h.a.b) ZeusTransformUtils.preCheckCast(r8.f21328d, d.h.a.b.class, "com.obric.aiagent.plugin");
        String r22 = (String) ZeusTransformUtils.preCheckCast(r8.f21327c, String.class, "com.obric.aiagent.plugin");
        r2 = (String) ZeusTransformUtils.preCheckCast(r8.f21326b, String.class, "com.obric.aiagent.plugin");
        c r23 = (c) ZeusTransformUtils.preCheckCast(r8.f21325a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r9);     // Catch: Exception -> L26 CancellationException -> L55
        r3 = r22;
        r1 = r23;
        goto L38
    L23:
        r5 = (d.h.a.b) ZeusTransformUtils.preCheckCast(r8.f21328d, d.h.a.b.class, "com.obric.aiagent.plugin");
        String r24 = (String) ZeusTransformUtils.preCheckCast(r8.f21327c, String.class, "com.obric.aiagent.plugin");
        r2 = (String) ZeusTransformUtils.preCheckCast(r8.f21326b, String.class, "com.obric.aiagent.plugin");
        c r25 = (c) ZeusTransformUtils.preCheckCast(r8.f21325a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r9);     // Catch: Exception -> L26 CancellationException -> L55
        r3 = r24;
        r1 = r25;
    L26:
        e = e;
        r3 = r1;
        r1 = r3;
    L55:
        e = move-exception;
        throw e;
    L7:
        r8 = new v(r1, r7);
        goto L8
    }

    private final File a(File r3) {
        return new File(new File(r3, ".obric"), "manifest.json");
    }

    private final boolean b(File r1) {
        return a(r1).isFile();
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 15001. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    private final java.lang.Object a(java.lang.String r27, java.io.File r28, java.lang.String r29, d.c.d<? super com.obric.aiagent.skill.ovirt.impl.f.e> r30) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0000: MOVE (r1v0 ?? I:??[OBJECT, ARRAY]) = (r26v0 'this' ?? I:??[OBJECT, ARRAY] A[IMMUTABLE_TYPE, THIS]) A[DECLARE_VAR] in method: com.obric.aiagent.skill.ovirt.impl.f.c.a(java.lang.String, java.io.File, java.lang.String, d.c.d<? super com.obric.aiagent.skill.ovirt.impl.f.e>):java.lang.Object, file: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 1500
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.obric.aiagent.skill.ovirt.impl.f.c.a(java.lang.String, java.io.File, java.lang.String, d.c.d):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Void a(String r3, String r4) {
        com.obric.aiagent.skill.ovirt.impl.b.f21110a.b("SkRt/ObricProjector", "projection rejected", "projection rejected slug=" + r3 + " reason=" + r4);
        throw new f("Skill projection rejected", null, 2, 0 == true ? 1 : 0);
    }

    private final g<e> c(File r5) {
        if (r5.isFile() == false) goto L43;
        if (r5.canRead() == false) goto L43;
        JsonElement r6 = JsonParser.parseString(d.f.k.a(r5, null, 1, null));     // Catch: Exception -> L40
        if (r6.isJsonObject() == false) goto L11;
        JsonObject r7 = r6.getAsJsonObject();     // Catch: Exception -> L40
        d.h.b.o.a(r7);
        g r2 = a(r7);
        if (ZeusTransformUtils.instanceOf(r2, g.b.class) == false) goto L36;
        if (((Number) ZeusTransformUtils.preCheckCast(((g.b) ZeusTransformUtils.preCheckCast(r2, g.b.class, "com.obric.aiagent.plugin")).a(), Number.class, "com.obric.aiagent.plugin")).intValue() != 1) goto L18;
        g r0 = a(r7, "is_secret");
        if (ZeusTransformUtils.instanceOf(r0, g.b.class) == false) goto L31;
        boolean r1 = ((Boolean) ZeusTransformUtils.preCheckCast(((g.b) ZeusTransformUtils.preCheckCast(r0, g.b.class, "com.obric.aiagent.plugin")).a(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        g r4 = b(r7);
        if (ZeusTransformUtils.instanceOf(r4, g.b.class) == false) goto L26;
        return (g) ZeusTransformUtils.preCheckCast(new g.b(new e(r1, (List) ZeusTransformUtils.preCheckCast(((g.b) ZeusTransformUtils.preCheckCast(r4, g.b.class, "com.obric.aiagent.plugin")).a(), List.class, "com.obric.aiagent.plugin"))), g.class, "com.obric.aiagent.plugin");
    L26:
        if (ZeusTransformUtils.instanceOf(r4, g.a.class) == false) goto L29;
        return r4;
    L29:
        throw new d.k();
    L31:
        if (ZeusTransformUtils.instanceOf(r0, g.a.class) == false) goto L34;
        return r0;
    L34:
        throw new d.k();
    L18:
        return (g) ZeusTransformUtils.preCheckCast(new g.a("unsupported_version"), g.class, "com.obric.aiagent.plugin");
    L36:
        if (ZeusTransformUtils.instanceOf(r2, g.a.class) == false) goto L39;
        return r2;
    L39:
        throw new d.k();
    L11:
        return (g) ZeusTransformUtils.preCheckCast(new g.a("manifest_not_object"), g.class, "com.obric.aiagent.plugin");
    L41:
        return (g) ZeusTransformUtils.preCheckCast(new g.a("manifest_invalid_json"), g.class, "com.obric.aiagent.plugin");
    L43:
        return (g) ZeusTransformUtils.preCheckCast(new g.a("manifest_unavailable"), g.class, "com.obric.aiagent.plugin");
    }

    private final g<Integer> a(JsonObject r2) {
        JsonElement r1 = r2.get("obric_skill_version");
        if (r1 != null) goto L7;
        return (g) ZeusTransformUtils.preCheckCast(new g.b(1), g.class, "com.obric.aiagent.plugin");
    L7:
        if (r1.isJsonPrimitive() == false) goto L18;
        if (r1.getAsJsonPrimitive().isNumber() == false) goto L18;
        String r3 = r1.getAsJsonPrimitive().getAsString();
        d.h.b.o.c(r3, "getAsString(...)");
        Integer r4 = d.o.o.d(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).toString());
        if (r4 == null) goto L16;
        return (g) ZeusTransformUtils.preCheckCast(new g.b(Integer.valueOf(r4.intValue())), g.class, "com.obric.aiagent.plugin");
    L16:
        return (g) ZeusTransformUtils.preCheckCast(new g.a("version_invalid"), g.class, "com.obric.aiagent.plugin");
    L18:
        return (g) ZeusTransformUtils.preCheckCast(new g.a("version_wrong_type"), g.class, "com.obric.aiagent.plugin");
    }

    private final g<Boolean> a(JsonObject r2, String r3) {
        JsonElement r1 = r2.get(r3);
        if (r1 != null) goto L7;
        return (g) ZeusTransformUtils.preCheckCast(new g.a(r3 + "_missing"), g.class, "com.obric.aiagent.plugin");
    L7:
        if (r1.isJsonPrimitive() == false) goto L14;
        if (r1.getAsJsonPrimitive().isBoolean() == false) goto L14;
        return (g) ZeusTransformUtils.preCheckCast(new g.b(Boolean.valueOf(r1.getAsBoolean())), g.class, "com.obric.aiagent.plugin");
    L14:
        return (g) ZeusTransformUtils.preCheckCast(new g.a(r3 + "_wrong_type"), g.class, "com.obric.aiagent.plugin");
    }

    private final g<List<String>> b(JsonObject r4) {
        JsonElement r3 = r4.get("attachments");
        if (r3 != null) goto L7;
        return (g) ZeusTransformUtils.preCheckCast(new g.b(d.a.p.b()), g.class, "com.obric.aiagent.plugin");
    L7:
        if (r3.isJsonArray() == false) goto L9;
        ArrayList r0 = new ArrayList(r3.getAsJsonArray().size());
        JsonArray r5 = r3.getAsJsonArray();
        d.h.b.o.c(r5, "getAsJsonArray(...)");
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L12:
        if (r6.hasNext() == false) goto L22;
        JsonElement r1 = (JsonElement) ZeusTransformUtils.preCheckCast(r6.next(), JsonElement.class, "com.obric.aiagent.plugin");
        if (r1.isJsonPrimitive() == false) goto L20;
        if (r1.getAsJsonPrimitive().isString() == false) goto L20;
        ((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).add(r1.getAsString());
    L20:
        return (g) ZeusTransformUtils.preCheckCast(new g.a("attachment_wrong_type"), g.class, "com.obric.aiagent.plugin");
    L22:
        return (g) ZeusTransformUtils.preCheckCast(new g.b(r0), g.class, "com.obric.aiagent.plugin");
    L9:
        return (g) ZeusTransformUtils.preCheckCast(new g.a("attachments_wrong_type"), g.class, "com.obric.aiagent.plugin");
    }

    private final g<List<C0447c>> a(File r11, e r12) {
        File r1 = new File(r11, ".obric");
        File r13 = r1.getCanonicalFile();     // Catch: Exception -> L32
        ArrayList r2 = new ArrayList(r12.b().size());
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r12.b(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r14.hasNext() == false) goto L31;
        String r3 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (b(r3) == false) goto L10;
        File r4 = new File(r1, r3).getCanonicalFile();     // Catch: Exception -> L28
        d.h.b.o.a(r4);
        d.h.b.o.a(r13);
        if (b(r4, r13) == false) goto L15;
        if (r4.isFile() == false) goto L27;
        if (r4.canRead() == false) goto L27;
        String r5 = r4.getName();
        d.h.b.o.c(r5, "getName(...)");
        if (d.o.o.c(r5, ".tar", false, 2, null) == false) goto L24;
        ((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin")).add(new C0447c(r3, r4));
        goto L6
    L24:
        return (g) ZeusTransformUtils.preCheckCast(new g.a("attachment_unsupported_type"), g.class, "com.obric.aiagent.plugin");
    L27:
        return (g) ZeusTransformUtils.preCheckCast(new g.a("attachment_missing"), g.class, "com.obric.aiagent.plugin");
    L15:
        return (g) ZeusTransformUtils.preCheckCast(new g.a("attachment_path_escape"), g.class, "com.obric.aiagent.plugin");
    L29:
        return (g) ZeusTransformUtils.preCheckCast(new g.a("attachment_unavailable"), g.class, "com.obric.aiagent.plugin");
    L10:
        return (g) ZeusTransformUtils.preCheckCast(new g.a("attachment_invalid_path"), g.class, "com.obric.aiagent.plugin");
    L31:
        return (g) ZeusTransformUtils.preCheckCast(new g.b(r2), g.class, "com.obric.aiagent.plugin");
    L33:
        return (g) ZeusTransformUtils.preCheckCast(new g.a("attachment_root_unavailable"), g.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object a(String r6, String r7, d.c.d<? super d.x> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, k.class) == false) goto L7;
        k r0 = (k) ZeusTransformUtils.preCheckCast(r9, k.class, "com.obric.aiagent.plugin");
        if ((r0.f21280c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f21280c -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f21278a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f21280c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        d.o.a(r10);
    L17:
        com.obric.aiagent.skill.virt.api.z r5 = (com.obric.aiagent.skill.virt.api.z) ZeusTransformUtils.preCheckCast(r10, com.obric.aiagent.skill.virt.api.z.class, "com.obric.aiagent.plugin");
        if (com.obric.aiagent.skill.ovirt.impl.f.d.a(r5) == false) goto L22;
        return d.x.f38692a;
    L22:
        throw new f("Obric staging directory prepare failed: exit=" + com.obric.aiagent.skill.ovirt.impl.f.d.b(r5), null, 2, 0 == true ? 1 : 0);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r10);
        String r11 = com.obric.aiagent.skill.ovirt.impl.a.a(b(r6, r7));
        r0.f21280c = 1;
        r10 = e("set -e; rm -rf -- " + r11 + "; mkdir -p -- " + r11, "obric_prepare_staging", r0);
        if (r10 != r2) goto L17;
        return r2;
    L7:
        r0 = new k(this, r9);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object a(String r24, String r25, C0447c r26, int r27, d.c.d<? super d.x> r28) {
        c r1 = this;
        String r0 = r25;
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r28, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, l.class) == false) goto L7;
        l r5 = (l) ZeusTransformUtils.preCheckCast(r3, l.class, "com.obric.aiagent.plugin");
        if ((r5.h & Integer.MIN_VALUE) == 0) goto L7;
        r5.h -= Integer.MIN_VALUE;
    L8:
        Object r4 = r5.f;
        Object r6 = d.c.a.b.a();
        int r7 = r5.h;
        int r11 = 2;
        Throwable r12 = null;
        boolean r13 = false;
        if (r7 != 0) goto L51;
        d.o.a(r4);
        com.obric.aiagent.skill.virt.api.j r2 = r1.f21245c.b("obric_skill_attachments/" + r0 + '/' + System.nanoTime() + '_' + r27 + '/' + r26.b().getName());
        IVirtService.b r8 = r1.f21244b.getFiles();     // Catch: Throwable -> L44
        com.obric.aiagent.skill.virt.api.g r9 = (com.obric.aiagent.skill.virt.api.g) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.virt.api.g.b(r26.b()), com.obric.aiagent.skill.virt.api.g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L44
        com.obric.aiagent.skill.virt.api.x r14 = (com.obric.aiagent.skill.virt.api.x) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.virt.api.x.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L44
        com.obric.aiagent.skill.virt.api.f r15 = new com.obric.aiagent.skill.virt.api.f(true, true, false, false, 8, null);     // Catch: Throwable -> L44
        r5.f21281a = r1;     // Catch: Throwable -> L44
        r5.f21282b = r24;     // Catch: Throwable -> L44
        r5.f21283c = r0;     // Catch: Throwable -> L44
        C0447c r16 = r26;
        r5.f21284d = r16;     // Catch: Throwable -> L44
        r5.f21285e = r2;     // Catch: Throwable -> L44
        r5.h = 1;     // Catch: Throwable -> L44
        if (r8.a(r9, r14, r15, r5) != r6) goto L30;
        return r6;
    L30:
        String r10 = r24;
        c r17 = r1;
        com.obric.aiagent.skill.virt.api.j r18 = r2;
    L31:
        String r19 = r17.b(r10, r0);     // Catch: Throwable -> L44
        String r20 = r17.a(r18.a(), r18.a() + "_extract", r19);     // Catch: Throwable -> L44
        r5.f21281a = r17;     // Catch: Throwable -> L44
        r5.f21282b = r16;     // Catch: Throwable -> L44
        r5.f21283c = r18;     // Catch: Throwable -> L44
        r5.f21284d = null;     // Catch: Throwable -> L44
        r5.f21285e = null;     // Catch: Throwable -> L44
        r5.h = 2;     // Catch: Throwable -> L44
        r4 = r17.e(r20, "obric_extract_attachment", r5);     // Catch: Throwable -> L44
        if (r4 != r6) goto L34;
        return r6;
    L34:
        C0447c r21 = r16;
        r1 = r17;
        r2 = r18;
    L35:
        com.obric.aiagent.skill.virt.api.z r22 = (com.obric.aiagent.skill.virt.api.z) ZeusTransformUtils.preCheckCast(r4, com.obric.aiagent.skill.virt.api.z.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L44
        if (com.obric.aiagent.skill.ovirt.impl.f.d.a(r22) == false) goto L43;
        d.c.g r23 = (d.c.g) ZeusTransformUtils.preCheckCast(co.f39209b, d.c.g.class, "com.obric.aiagent.plugin");
        d.h.a.m r29 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new m(r1, r2, null), d.h.a.m.class, "com.obric.aiagent.plugin");
        r5.f21281a = null;
        r5.f21282b = null;
        r5.f21283c = null;
        r5.h = 3;
        if (kotlinx.coroutines.i.a(r23, r29, r5) != r6) goto L41;
        return r6;
    L41:
        return d.x.f38692a;
    L43:
        throw new f("Obric attachment extract failed: path=" + r21.a() + " exit=" + com.obric.aiagent.skill.ovirt.impl.f.d.b(r22), r12, r11, r13 ? 1 : 0);     // Catch: Throwable -> L44
    L44:
        th = th;
    L45:
        d.c.g r30 = (d.c.g) ZeusTransformUtils.preCheckCast(co.f39209b, d.c.g.class, "com.obric.aiagent.plugin");
        d.h.a.m r31 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new m(r1, r2, null), d.h.a.m.class, "com.obric.aiagent.plugin");
        r5.f21281a = th;
        r5.f21282b = null;
        r5.f21283c = null;
        r5.f21284d = null;
        r5.f21285e = null;
        r5.h = 4;
        if (kotlinx.coroutines.i.a(r30, r31, r5) != r6) goto L52;
        return r6;
    L52:
        throw th;
    L51:
        if (r7 == 1) goto L21;
        if (r7 == 2) goto L18;
        if (r7 == 3) goto L17;
        if (r7 != 4) goto L15;
        Throwable r32 = (Throwable) ZeusTransformUtils.preCheckCast(r5.f21281a, Throwable.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        throw r32;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        d.o.a(r4);
        goto L41
    L18:
        com.obric.aiagent.skill.virt.api.j r33 = (com.obric.aiagent.skill.virt.api.j) ZeusTransformUtils.preCheckCast(r5.f21283c, com.obric.aiagent.skill.virt.api.j.class, "com.obric.aiagent.plugin");
        r21 = (C0447c) ZeusTransformUtils.preCheckCast(r5.f21282b, C0447c.class, "com.obric.aiagent.plugin");
        c r34 = (c) ZeusTransformUtils.preCheckCast(r5.f21281a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r4);     // Catch: Throwable -> L24
        r2 = r33;
        r1 = r34;
        goto L35
    L21:
        com.obric.aiagent.skill.virt.api.j r35 = (com.obric.aiagent.skill.virt.api.j) ZeusTransformUtils.preCheckCast(r5.f21285e, com.obric.aiagent.skill.virt.api.j.class, "com.obric.aiagent.plugin");
        C0447c r36 = (C0447c) ZeusTransformUtils.preCheckCast(r5.f21284d, C0447c.class, "com.obric.aiagent.plugin");
        String r37 = (String) ZeusTransformUtils.preCheckCast(r5.f21283c, String.class, "com.obric.aiagent.plugin");
        r10 = (String) ZeusTransformUtils.preCheckCast(r5.f21282b, String.class, "com.obric.aiagent.plugin");
        c r38 = (c) ZeusTransformUtils.preCheckCast(r5.f21281a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r4);     // Catch: Throwable -> L24
        r16 = r36;
        r0 = r37;
        r18 = r35;
        r17 = r38;
    L24:
        th = th;
        r2 = r1;
        r1 = c.class;
    L7:
        r5 = new l(r1, r3);
        goto L8
    }

    private final String a(String r4, String r5, String r6) {
        String r3 = com.obric.aiagent.skill.ovirt.impl.a.a(r4);
        String r7 = com.obric.aiagent.skill.ovirt.impl.a.a(r5);
        String r8 = com.obric.aiagent.skill.ovirt.impl.a.a(r6);
        StringBuilder r9 = new StringBuilder();
        r9.append("set -e; ");
        r9.append("rm -rf -- ").append(r7).append("; ");
        r9.append("mkdir -p -- ").append(r7).append(' ').append(r8).append("; ");
        r9.append("if tar -tf ").append(r3).append(" | grep -Eq '(^/|(^|/)\\.\\.(/|$))'; then exit 41; fi; ");
        r9.append("if tar -tvf ").append(r3).append(" | awk 'substr($1,1,1)!=\"-\" && substr($1,1,1)!=\"d\"").append(" { bad=1 } END { exit bad ? 0 : 1 }'; then exit 42; fi; ");
        r9.append("tar -xf ").append(r3).append(" -C ").append(r7).append("; ");
        r9.append("(cd ").append(r7).append(" && tar -cf - .) | ");
        r9.append("(cd ").append(r8).append(" && tar -xf -)");
        String r10 = r9.toString();
        d.h.b.o.c(r10, "toString(...)");
        return r10;
    }

    private final Object a(String r7, d.c.d<? super d.x> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, h.class) == false) goto L7;
        h r0 = (h) ZeusTransformUtils.preCheckCast(r9, h.class, "com.obric.aiagent.plugin");
        if ((r0.f21270c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f21270c -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f21268a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f21270c;
        if (r3 == 0) goto L17;
        if (r3 != 1) goto L16;
        d.o.a(r10);     // Catch: Exception -> L13
    L24:
    L23:
        return d.x.f38692a;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        d.o.a(r10);
        String r11 = "rm -rf -- " + com.obric.aiagent.skill.ovirt.impl.a.a(r7) + ' ' + com.obric.aiagent.skill.ovirt.impl.a.a(r7 + "_extract");     // Catch: Exception -> L13
        r0.f21270c = 1;     // Catch: Exception -> L13
        if (e(r11, "obric_cleanup_attachment", r0) != r2) goto L24;
        return r2;
    L13:
        e = move-exception;
        com.obric.aiagent.skill.ovirt.impl.b.f21110a.a("SkRt/ObricProjector", "attachment cleanup failed", "attachment cleanup failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L7:
        r0 = new h(this, r9);
        goto L8
    }

    private final Object b(String r6, String r7, d.c.d<? super d.x> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, i.class) == false) goto L7;
        i r0 = (i) ZeusTransformUtils.preCheckCast(r9, i.class, "com.obric.aiagent.plugin");
        if ((r0.f21273c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f21273c -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f21271a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f21273c;
        if (r3 == 0) goto L17;
        if (r3 != 1) goto L16;
        d.o.a(r10);     // Catch: Exception -> L13
    L24:
    L23:
        return d.x.f38692a;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        d.o.a(r10);
        r0.f21273c = 1;     // Catch: Exception -> L13
        if (c(r6, r7, r0) != r2) goto L24;
        return r2;
    L13:
        e = move-exception;
        com.obric.aiagent.skill.ovirt.impl.b.f21110a.a("SkRt/ObricProjector", "staging cleanup failed", "staging cleanup failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L7:
        r0 = new i(this, r9);
        goto L8
    }

    private final boolean a(File r12, File r13) {
        File[] r11 = r12.listFiles();
        if (r11 != null) goto L5;
        r11 = new File[0];
    L5:
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r1 = r11.length;
        int r3 = 0;
    L6:
        boolean r4 = true;
        if (r3 >= r1) goto L17;
        File r5 = r11[r3];
        if (d.h.b.o.a(r5.getName(), ".versions") == false) goto L11;
    L13:
        r4 = false;
    L14:
        if (r4 == false) goto L16;
        r0.add(r5);
    L16:
        r3 = r3 + 1;
        goto L6
    L11:
        if (d.h.b.o.a(r5.getName(), ".obric") == true) goto L13;
    L17:
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, Collection.class) == true) goto L20;
    L22:
        Iterator r15 = r14.iterator();
    L24:
        if (r15.hasNext() == false) goto L27;
        File r6 = (File) ZeusTransformUtils.preCheckCast(r15.next(), File.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r6);
        if (d.f.k.a(r6, new File(r13, r6.getName()), true, null, 4, null) == true) goto L24;
        return false;
    L27:
        return true;
    L20:
        if (((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L22;
        goto L22
    }

    private final boolean a(String r7) {
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L23;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), '/', false, 2, null) == true) goto L23;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), 0, false, 2, null) == true) goto L23;
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin");
        int r0 = 0;
    L10:
        if (r0 >= r6.length()) goto L15;
        if (d.o.a.a(r6.charAt(r0)) == true) goto L13;
        r0 = r0 + 1;
        goto L10
    L13:
        boolean r8 = false;
    L16:
        if (r8 == false) goto L23;
        if (d.h.b.o.a(r7, ".") == true) goto L23;
        if (d.h.b.o.a(r7, DownloadConstants.VULNERABILITY_PATH) == true) goto L23;
        return true;
    L15:
        r8 = true;
    L23:
        return false;
    }

    private final boolean b(String r9) {
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L5;
        return false;
    L5:
        if (d.o.o.b(r9, "/", false, 2, null) == false) goto L7;
        return false;
    L7:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"), 0, false, 2, null) == true) goto L35;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"), new String[]{"/"}, false, 0, 6, null), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, Collection.class) == true) goto L12;
    L14:
        Iterator r10 = r8.iterator();
    L16:
        if (r10.hasNext() == false) goto L34;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.aiagent.plugin");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L20;
    L25:
        boolean r12 = true;
    L26:
        if (r12 == false) goto L16;
        return false;
    L20:
        if (d.h.b.o.a(r11, ".") == true) goto L25;
        if (d.h.b.o.a(r11, DownloadConstants.VULNERABILITY_PATH) == true) goto L25;
        r12 = false;
    L34:
        return true;
    L12:
        if (((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L14;
    L35:
        return false;
    }

    private final boolean b(File r4, File r5) {
        String r3 = r4.getAbsolutePath();
        String r6 = r5.getAbsolutePath();
        d.h.b.o.c(r6, "getAbsolutePath(...)");
        String r7 = d.o.o.c(r6, new char[]{File.separatorChar});
        if (d.h.b.o.a(r3, r7) == true) goto L9;
        d.h.b.o.a(r3);
        if (d.o.o.b(r3, r7 + File.separator, false, 2, null) == false) goto L8;
        return true;
    L8:
        return false;
    L9:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Class, java.lang.Class<com.obric.aiagent.skill.ovirt.impl.f.c>] */
    /* JADX WARN: Type inference failed for: r4v2 */
    private final Object b(String r24, File r25, String r26, d.c.d<? super com.obric.aiagent.skill.ovirt.impl.f.e> r27) {
        c r1 = this;
        String r2 = r24;
        String r3 = r26;
        String r4 = c.class;
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r27, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ab.class) == false) goto L7;
        ab r7 = (ab) ZeusTransformUtils.preCheckCast(r5, ab.class, "com.obric.aiagent.plugin");
        if ((r7.h & Integer.MIN_VALUE) == 0) goto L7;
        r7.h -= Integer.MIN_VALUE;
    L8:
        Object r6 = r7.f;
        Object r8 = d.c.a.b.a();
        int r9 = r7.h;
        int r12 = 1;
        if (r9 != 0) goto L56;
        d.o.a(r6);
        c(r24);
        r1.d(r25);
        StringBuilder r10 = new StringBuilder().append(".projection-").append(r2).append('-');
        String r11 = Long.toString(System.nanoTime(), d.o.a.a(36));
        d.h.b.o.c(r11, "toString(...)");
        String r13 = r10.append(r11).toString();
        String r14 = r1.b(r3, r13);
        IVirtService.b r15 = r1.f21244b.getFiles();     // Catch: Throwable -> L41 Exception -> L43 CancellationException -> L46
        com.obric.aiagent.skill.virt.api.g r0 = (com.obric.aiagent.skill.virt.api.g) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.virt.api.g.a(r25), com.obric.aiagent.skill.virt.api.g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L41 Exception -> L43 CancellationException -> L46
        com.obric.aiagent.skill.virt.api.x r16 = (com.obric.aiagent.skill.virt.api.x) ZeusTransformUtils.preCheckCast(r1.f21245c.c(r14), com.obric.aiagent.skill.virt.api.x.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L41 Exception -> L43 CancellationException -> L46
        com.obric.aiagent.skill.virt.api.f r17 = new com.obric.aiagent.skill.virt.api.f(true, true, false, false, 8, null);     // Catch: Throwable -> L41 Exception -> L43 CancellationException -> L46
        r7.f21250a = r1;     // Catch: Throwable -> L41 Exception -> L43 CancellationException -> L46
        r7.f21251b = r2;     // Catch: Throwable -> L41 Exception -> L43 CancellationException -> L46
        r7.f21252c = r3;     // Catch: Throwable -> L41 Exception -> L43 CancellationException -> L46
        r7.f21253d = r13;     // Catch: Throwable -> L41 Exception -> L43 CancellationException -> L46
        r7.f21254e = 1;     // Catch: Throwable -> L41 Exception -> L43 CancellationException -> L46
        r7.h = 1;     // Catch: Throwable -> L41 Exception -> L43 CancellationException -> L46
        r1 = r1;
        if (r15.a(r0, r16, r17, r7) != r8) goto L35;
        return r8;
    L35:
        r7.f21250a = r1;     // Catch: Throwable -> L41 Exception -> L43 CancellationException -> L46
        r7.f21251b = r2;     // Catch: Throwable -> L41 Exception -> L43 CancellationException -> L46
        r7.f21252c = r3;     // Catch: Throwable -> L41 Exception -> L43 CancellationException -> L46
        r7.f21253d = r13;     // Catch: Throwable -> L41 Exception -> L43 CancellationException -> L46
        r7.f21254e = r12;     // Catch: Throwable -> L41 Exception -> L43 CancellationException -> L46
        r7.h = 2;     // Catch: Throwable -> L41 Exception -> L43 CancellationException -> L46
        if (r1.a(r3, r13, r2, r7) != r8) goto L38;
        return r8;
    L38:
        String r18 = r2;
        c r19 = r1;
    L40:
        return new com.obric.aiagent.skill.ovirt.impl.f.e(r18, r19.f21245c.a(".agents/skills/" + r18));
    L46:
        e = move-exception;
        throw e;     // Catch: Throwable -> L41
    L43:
        e = e;
    L44:
        r1.a("snapshotDirectory: import failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), "snapshotDirectory: import failed slug=" + r2);     // Catch: Throwable -> L41
        throw new f("Skill snapshot failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L41
    L56:
        if (r9 == 1) goto L22;
        if (r9 != 2) goto L13;
        int r110 = r7.f21254e;
        String r20 = (String) ZeusTransformUtils.preCheckCast(r7.f21253d, String.class, "com.obric.aiagent.plugin");
        String r21 = (String) ZeusTransformUtils.preCheckCast(r7.f21252c, String.class, "com.obric.aiagent.plugin");
        String r22 = (String) ZeusTransformUtils.preCheckCast(r7.f21251b, String.class, "com.obric.aiagent.plugin");
        c r23 = (c) ZeusTransformUtils.preCheckCast(r7.f21250a, r4, "com.obric.aiagent.plugin");
        d.o.a(r6);     // Catch: Throwable -> L25 Exception -> L27 CancellationException -> L29
        r18 = r22;
        r19 = r23;
        goto L40
    L13:
        if (r9 == 3) goto L18;
        if (r9 != 4) goto L16;
        Throwable r28 = (Throwable) ZeusTransformUtils.preCheckCast(r7.f21250a, Throwable.class, "com.obric.aiagent.plugin");
        d.o.a(r6);
        throw r28;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r18 = (String) ZeusTransformUtils.preCheckCast(r7.f21251b, String.class, "com.obric.aiagent.plugin");
        c r29 = (c) ZeusTransformUtils.preCheckCast(r7.f21250a, r4, "com.obric.aiagent.plugin");
        d.o.a(r6);
        r19 = r29;
        goto L40
    L22:
        r12 = r7.f21254e;
        String r30 = (String) ZeusTransformUtils.preCheckCast(r7.f21253d, String.class, "com.obric.aiagent.plugin");
        String r31 = (String) ZeusTransformUtils.preCheckCast(r7.f21252c, String.class, "com.obric.aiagent.plugin");
        String r32 = (String) ZeusTransformUtils.preCheckCast(r7.f21251b, String.class, "com.obric.aiagent.plugin");
        c r33 = (c) ZeusTransformUtils.preCheckCast(r7.f21250a, r4, "com.obric.aiagent.plugin");
        d.o.a(r6);     // Catch: Throwable -> L25 Exception -> L27 CancellationException -> L29
        r13 = r30;
        r1 = r33;
        r3 = r31;
        r2 = r32;
    L29:
        e = move-exception;
        throw e;     // Catch: Throwable -> L41
    L27:
        e = e;
        r1 = r4;
        r2 = r3;
    L25:
        th = th;
        r3 = r2;
        r4 = r1;
        r1 = r4;
    L48:
        if (1 == 0) goto L58;
        d.c.g r34 = (d.c.g) ZeusTransformUtils.preCheckCast(co.f39209b, d.c.g.class, "com.obric.aiagent.plugin");
        d.h.a.m r35 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new ac(r1, r3, r4, null), d.h.a.m.class, "com.obric.aiagent.plugin");
        r7.f21250a = th;
        r7.f21251b = null;
        r7.f21252c = null;
        r7.f21253d = null;
        r7.h = 4;
        if (kotlinx.coroutines.i.a(r34, r35, r7) != r8) goto L59;
        return r8;
    L59:
        throw th;
    L58:
        throw th;
    L41:
        th = th;
    L7:
        r7 = new ab(r1, r5);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object a(String r12, String r13, String r14, d.c.d<? super d.x> r15) {
        d.c.d r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r16, z.class) == false) goto L7;
        z r0 = (z) ZeusTransformUtils.preCheckCast(r16, z.class, "com.obric.aiagent.plugin");
        if ((r0.f21343c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f21343c -= Integer.MIN_VALUE;
    L8:
        Object r17 = r0.f21341a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f21343c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        d.o.a(r17);
    L18:
        if (com.obric.aiagent.skill.ovirt.impl.f.d.a((com.obric.aiagent.skill.virt.api.z) ZeusTransformUtils.preCheckCast(r17, com.obric.aiagent.skill.virt.api.z.class, "com.obric.aiagent.plugin")) == false) goto L22;
        return d.x.f38692a;
    L22:
        throw new f("Skill directory replace failed", null, 2, 0 == true ? 1 : 0);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r17);
        c(r13);
        c(r14);
        String r18 = com.obric.aiagent.skill.ovirt.impl.a.a(b(r12, r13));
        String r19 = com.obric.aiagent.skill.ovirt.impl.a.a(b(r12, r14));
        StringBuilder r110 = new StringBuilder().append(".projection-").append(r14).append("-backup-");
        String r4 = Long.toString(System.nanoTime(), d.o.a.a(36));
        d.h.b.o.c(r4, "toString(...)");
        String r111 = com.obric.aiagent.skill.ovirt.impl.a.a(b(r12, r110.append(r4).toString()));
        StringBuilder r112 = new StringBuilder();
        r112.append("set -e; rm -rf -- ").append(r111).append("; ");
        r112.append("if [ -e ").append(r19).append(" ]; then mv -- ").append(r19).append(' ').append(r111).append("; fi; ");
        r112.append("if mv -- ").append(r18).append(' ').append(r19).append("; then ");
        r112.append("rm -rf -- ").append(r111).append("; ");
        r112.append("else rm -rf -- ").append(r19).append("; ");
        r112.append("if [ -e ").append(r111).append(" ]; then mv -- ").append(r111).append(' ').append(r19).append("; fi; exit 1; fi");
        String r113 = r112.toString();
        d.h.b.o.c(r113, "toString(...)");
        r0.f21343c = 1;
        r17 = e(r113, "snapshot_replace_skill", r0);
        if (r17 != r2) goto L18;
        return r2;
    L7:
        r0 = new z(this, r16);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object c(String r6, String r7, d.c.d<? super d.x> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, x.class) == false) goto L7;
        x r0 = (x) ZeusTransformUtils.preCheckCast(r9, x.class, "com.obric.aiagent.plugin");
        if ((r0.f21336c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f21336c -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f21334a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f21336c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        d.o.a(r10);
    L18:
        if (com.obric.aiagent.skill.ovirt.impl.f.d.a((com.obric.aiagent.skill.virt.api.z) ZeusTransformUtils.preCheckCast(r10, com.obric.aiagent.skill.virt.api.z.class, "com.obric.aiagent.plugin")) == false) goto L22;
        return d.x.f38692a;
    L22:
        throw new f("Skill removal failed", null, 2, 0 == true ? 1 : 0);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r10);
        c(r7);
        String r11 = "rm -rf -- " + com.obric.aiagent.skill.ovirt.impl.a.a(b(r6, r7));
        r0.f21336c = 1;
        r10 = e(r11, "snapshot_remove_skill", r0);
        if (r10 != r2) goto L18;
        return r2;
    L7:
        r0 = new x(this, r9);
        goto L8
    }

    private final Object b(String r9, d.c.d<? super Boolean> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, p.class) == false) goto L7;
        p r0 = (p) ZeusTransformUtils.preCheckCast(r11, p.class, "com.obric.aiagent.plugin");
        if ((r0.f21300d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f21300d -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.f21298b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f21300d;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        c r8 = (c) ZeusTransformUtils.preCheckCast(r0.f21297a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r12);     // Catch: Exception -> L22
    L20:
        boolean r13 = com.obric.aiagent.skill.ovirt.impl.f.d.a((com.obric.aiagent.skill.virt.api.z) ZeusTransformUtils.preCheckCast(r12, com.obric.aiagent.skill.virt.api.z.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L22
    L25:
        return d.c.b.a.b.a(r13);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        d.o.a(r12);
        String r14 = com.obric.aiagent.skill.ovirt.impl.a.a(this.f21245c.a(".agents/skills").a());
        String r15 = com.obric.aiagent.skill.ovirt.impl.a.a(r9);
        r0.f21297a = this;     // Catch: Exception -> L22
        r0.f21300d = 1;     // Catch: Exception -> L22
        r12 = e("set -e; rm -rf -- " + r14 + ' ' + r15 + "; mkdir -p -- " + r15, "snapshot_prepare_root", r0);     // Catch: Exception -> L22
        if (r12 != r2) goto L20;
        return r2;
    L22:
        e = move-exception;
        a(this, "projectSkills: root prepare failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), null, 4, null);
        r13 = false;
    L7:
        r0 = new p(this, r11);
        goto L8
    }

    private final Object c(String r9, d.c.d<? super Boolean> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, o.class) == false) goto L7;
        o r0 = (o) ZeusTransformUtils.preCheckCast(r11, o.class, "com.obric.aiagent.plugin");
        if ((r0.f21296d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f21296d -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.f21294b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f21296d;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        c r8 = (c) ZeusTransformUtils.preCheckCast(r0.f21293a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r12);     // Catch: Exception -> L22
    L20:
        boolean r13 = com.obric.aiagent.skill.ovirt.impl.f.d.a((com.obric.aiagent.skill.virt.api.z) ZeusTransformUtils.preCheckCast(r12, com.obric.aiagent.skill.virt.api.z.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L22
    L25:
        return d.c.b.a.b.a(r13);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        d.o.a(r12);
        String r14 = com.obric.aiagent.skill.ovirt.impl.a.a(this.f21245c.a(".agents").a());
        String r4 = com.obric.aiagent.skill.ovirt.impl.a.a(this.f21245c.a(".agents/skills").a());
        String r15 = "set -e; mkdir -p -- " + r14 + "; rm -rf -- " + r4 + "; ln -s -- " + com.obric.aiagent.skill.ovirt.impl.a.a(r9) + ' ' + r4;     // Catch: Exception -> L22
        r0.f21293a = this;     // Catch: Exception -> L22
        r0.f21296d = 1;     // Catch: Exception -> L22
        r12 = e(r15, "snapshot_link_root", r0);     // Catch: Exception -> L22
        if (r12 != r2) goto L20;
        return r2;
    L22:
        e = move-exception;
        a(this, "projectSkills: root link failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), null, 4, null);
        r13 = false;
    L7:
        r0 = new o(this, r11);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.obric.aiagent.skill.ovirt.impl.f.c] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.obric.aiagent.skill.ovirt.impl.f.c, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v6 */
    private final Object d(String r9, String r10, d.c.d<? super Boolean> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, y.class) == false) goto L7;
        y r0 = (y) ZeusTransformUtils.preCheckCast(r12, y.class, "com.obric.aiagent.plugin");
        if ((r0.f21340d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f21340d -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.f21338b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f21340d;
        boolean r4 = true;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        c r8 = (c) ZeusTransformUtils.preCheckCast(r0.f21337a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r13);     // Catch: Exception -> L20
        ?? this = r8;
    L24:
    L23:
        return d.c.b.a.b.a(r4);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        d.o.a(r13);
        r0.f21337a = this;     // Catch: Exception -> L20
        r0.f21340d = 1;     // Catch: Exception -> L20
        Object r14 = c(r9, r10, r0);     // Catch: Exception -> L20
        this = r14;
        if (r14 != r2) goto L24;
        return r2;
    L20:
        e = move-exception;
        a(this, "projectSkills: item cleanup failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), null, 4, null);
        r4 = false;
    L7:
        r0 = new y(this, r12);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.obric.aiagent.skill.ovirt.impl.f.c] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.obric.aiagent.skill.ovirt.impl.f.c, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v6 */
    private final Object d(String r9, d.c.d<? super d.x> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, j.class) == false) goto L7;
        j r0 = (j) ZeusTransformUtils.preCheckCast(r11, j.class, "com.obric.aiagent.plugin");
        if ((r0.f21277d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f21277d -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.f21275b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f21277d;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        c r8 = (c) ZeusTransformUtils.preCheckCast(r0.f21274a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r12);     // Catch: Exception -> L20
        ?? this = r8;
    L24:
    L23:
        return d.x.f38692a;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        d.o.a(r12);
        String r13 = "rm -rf -- " + com.obric.aiagent.skill.ovirt.impl.a.a(r9);     // Catch: Exception -> L20
        r0.f21274a = this;     // Catch: Exception -> L20
        r0.f21277d = 1;     // Catch: Exception -> L20
        Object r14 = e(r13, "snapshot_remove_skill", r0);     // Catch: Exception -> L20
        this = r14;
        if (r14 != r2) goto L24;
        return r2;
    L20:
        e = move-exception;
        a(this, "projectSkills: contaminated root cleanup failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), null, 4, null);
    L7:
        r0 = new j(this, r11);
        goto L8
    }

    private final Object a(String r9, File r10, d.c.d<? super d.x> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, n.class) == false) goto L7;
        n r0 = (n) ZeusTransformUtils.preCheckCast(r12, n.class, "com.obric.aiagent.plugin");
        if ((r0.f21292d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f21292d -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.f21290b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f21292d;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        c this = (c) ZeusTransformUtils.preCheckCast(r0.f21289a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r13);     // Catch: Exception -> L23 CancellationException -> L26
    L20:
        com.obric.aiagent.skill.virt.api.h r14 = (com.obric.aiagent.skill.virt.api.h) ZeusTransformUtils.preCheckCast(r13, com.obric.aiagent.skill.virt.api.h.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L23 CancellationException -> L26
    L22:
        return d.x.f38692a;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        d.o.a(r13);
        a(r9, r10);
        com.obric.aiagent.skill.virt.api.e r15 = this.f21245c.a(".obric/bin/" + r9);
        IVirtService.b r16 = this.f21244b.getFiles();     // Catch: Exception -> L23 CancellationException -> L26
        com.obric.aiagent.skill.virt.api.g r17 = (com.obric.aiagent.skill.virt.api.g) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.virt.api.g.b(r10), com.obric.aiagent.skill.virt.api.g.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L23 CancellationException -> L26
        com.obric.aiagent.skill.virt.api.x r18 = (com.obric.aiagent.skill.virt.api.x) ZeusTransformUtils.preCheckCast(r15, com.obric.aiagent.skill.virt.api.x.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L23 CancellationException -> L26
        com.obric.aiagent.skill.virt.api.f r4 = new com.obric.aiagent.skill.virt.api.f(true, true, false, true);     // Catch: Exception -> L23 CancellationException -> L26
        r0.f21289a = this;     // Catch: Exception -> L23 CancellationException -> L26
        r0.f21292d = 1;     // Catch: Exception -> L23 CancellationException -> L26
        r13 = r16.a(r17, r18, r4, r0);     // Catch: Exception -> L23 CancellationException -> L26
        if (r13 != r2) goto L20;
        return r2;
    L26:
        e = move-exception;
        throw e;
    L23:
        e = move-exception;
        a(this, "installCliTool: import failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), null, 4, null);
        throw new f("CLI tool import failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L7:
        r0 = new n(this, r12);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void c(String r6) {
        int r1 = 2;
        Throwable r2 = null;
        Object[] r3 = 0;
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L22;
        boolean r4 = false;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"), '/', false, 2, null) == true) goto L22;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"), 0, false, 2, null) == true) goto L22;
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        int r0 = 0;
    L10:
        if (r0 >= r5.length()) goto L15;
        if (d.o.a.a(r5.charAt(r0)) == true) goto L13;
        r0 = r0 + 1;
        goto L10
    L13:
        r4 = true;
    L15:
        if (r4 == true) goto L22;
        if (d.h.b.o.a(r6, ".") == true) goto L22;
        if (d.h.b.o.a(r6, DownloadConstants.VULNERABILITY_PATH) == true) goto L22;
        return;
    L22:
        throw new f("Invalid skill identifier", r2, r1, r3 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void d(File r3) {
        if (r3.isDirectory() == false) goto L17;
        if (r3.canRead() == false) goto L17;
        File[] r2 = r3.listFiles();
        boolean r4 = false;
        if (r2 != null) goto L9;
    L13:
        r4 = true;
    L14:
        if (r4 == true) goto L17;
        return;
    L9:
        if (r2.length != 0) goto L11;
        Object[] r5 = true;
    L12:
        if (r5 == false) goto L14;
    L11:
        r5 = false;
    L17:
        throw new f("Skill source is unavailable", null, 2, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void a(String r3, File r4) {
        int r0 = 2;
        Throwable r1 = null;
        Object[] r2 = 0;
        Object[] r5 = 0;
        Object[] r6 = 0;
        if (f21243e.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L16;
        if (d.h.b.o.a(r3, ".") == true) goto L16;
        if (d.h.b.o.a(r3, DownloadConstants.VULNERABILITY_PATH) == true) goto L16;
        if (r4.isFile() == false) goto L14;
        if (r4.canRead() == false) goto L14;
        return;
    L14:
        throw new f("CLI tool source is unavailable", r1, r0, r6 == true ? 1 : 0);
    L16:
        throw new f("Invalid CLI tool name", r5 == true ? 1 : 0, r0, r2 == true ? 1 : 0);
    }

    private final String b(String r4, String r5) {
        return d.o.o.c(r4, new char[]{'/'}) + '/' + r5;
    }

    private final Object e(String r9, String r10, d.c.d<? super com.obric.aiagent.skill.virt.api.z> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, aa.class) == false) goto L7;
        aa r0 = (aa) ZeusTransformUtils.preCheckCast(r12, aa.class, "com.obric.aiagent.plugin");
        if ((r0.f21249c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f21249c -= Integer.MIN_VALUE;
    L8:
        aa r7 = r0;
        Object r13 = r7.f21247a;
        Object r1 = d.c.a.b.a();
        int r2 = r7.f21249c;
        if (r2 == 0) goto L19;
        if (r2 != 1) goto L18;
        d.o.a(r13);     // Catch: Exception -> L13 CancellationException -> L15
    L23:
        return (com.obric.aiagent.skill.virt.api.z) ZeusTransformUtils.preCheckCast(r13, com.obric.aiagent.skill.virt.api.z.class, "com.obric.aiagent.plugin");
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        d.o.a(r13);
        d.h.a.s<com.obric.aiagent.skill.virt.api.x, String, Long, String, d.c.d<? super com.obric.aiagent.skill.virt.api.z>, Object> r3 = this.f21246d;     // Catch: Exception -> L13 CancellationException -> L15
        com.obric.aiagent.skill.virt.api.e r8 = this.f21245c.a();     // Catch: Exception -> L13 CancellationException -> L15
        Long r5 = d.c.b.a.b.a(60000);     // Catch: Exception -> L13 CancellationException -> L15
        r7.f21249c = 1;     // Catch: Exception -> L13 CancellationException -> L15
        r13 = r3.a(r8, r9, r5, r10, r7);     // Catch: Exception -> L13 CancellationException -> L15
        if (r13 != r1) goto L23;
        return r1;
    L15:
        e = move-exception;
        throw e;
    L13:
        e = move-exception;
        throw new f("Skill operation failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L7:
        r0 = new aa(this, r12);
        goto L8
    }

    private final com.obric.aiagent.skill.ovirt.impl.f.a c(String r7, String r8) {
        return new com.obric.aiagent.skill.ovirt.impl.f.a(r7, null, r8, 2, null);
    }

    static /* synthetic */ void a(c r0, String r1, Throwable r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = r1;
    L5:
        r0.a(r1, r2, r3);
    }

    private final void a(String r2, Throwable r3, String r4) {
        if (IAppContext.Companion.isDebug() == false) goto L5;
        ILogDepend.Companion.e("SkRt/Snapshot", r4, r3);
        return;
    L5:
        ILogDepend.Companion.e("SkRt/Snapshot", r2);
    }

    static {
        f21242a = new a(null);
        f21243e = new d.o.k("[A-Za-z0-9][A-Za-z0-9._-]{0,63}");
    }
}
