package com.obric.aiagent.skill.ovirt.impl.c;

import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.skill.manager.api.al;
import com.obric.aiagent.skill.ovirt.api.IOVirtService;
import com.obric.aiagent.skill.ovirt.impl.OVirt;
import com.obric.aiagent.skill.virt.api.IVirtService;
import com.obric.aiagent.skill.virt.api.y;
import com.obric.aiagent.skill.virt.api.z;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.bduploader.BDImageUploader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.a.m;
import d.h.b.l;
import d.n;
import d.o.o;
import d.x;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: FileCapability.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements IOVirtService.b {
    private static final String TAG = "SkRt/Res";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f21127a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SecureRandom f21128c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final OVirt f21129b;

    /* JADX INFO: compiled from: FileCapability.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.skill.ovirt.impl.c.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FileCapability.kt */
    @d.c.b.a.f(b = "FileCapability.kt", c = {BDImageUploader.KeyIsImageCountThreshold}, d = "assertReadable", e = "com.obric.aiagent.skill.ovirt.impl.file.FileCapability")
    static final class C0443b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21130a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21131b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f21132c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f21133d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f21134e;

        C0443b(b r3, d.c.d<? super C0443b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21133d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21132c = r3;
            this.f21134e |= Integer.MIN_VALUE;
            return b.a(this.f21133d, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: FileCapability.kt */
    @d.c.b.a.f(b = "FileCapability.kt", c = {346}, d = "cleanupArchiveFiles", e = "com.obric.aiagent.skill.ovirt.impl.file.FileCapability")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21135a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f21136b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f21137c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f21138d;

        c(b r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21137c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21136b = r3;
            this.f21138d |= Integer.MIN_VALUE;
            return b.a(this.f21137c, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: FileCapability.kt */
    /* synthetic */ class d extends l implements d.h.a.b<String, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f21139a = null;

        static {
            f21139a = new d();
        }

        d() {
            super(1, o.class, "trim", "trim(Ljava/lang/String;)Ljava/lang/String;", 1);
        }

        public final String a(String r2) {
            d.h.b.o.e(r2, "p0");
            return o.a((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        }

        @Override // d.h.a.b
        public /* synthetic */ String invoke(String r3) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: FileCapability.kt */
    @d.c.b.a.f(b = "FileCapability.kt", c = {60}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.file.FileCapability$export$2")
    static final class e extends d.c.b.a.l implements m<com.obric.aiagent.skill.ovirt.impl.h.a, d.c.d<? super com.obric.aiagent.skill.ovirt.api.a.e>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21140a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f21141b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f21142c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f21143d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.skill.ovirt.api.a.d f21144e;
        final /* synthetic */ com.obric.aiagent.skill.ovirt.api.a.c f;

        e(b r3, String r4, com.obric.aiagent.skill.ovirt.api.a.d r5, com.obric.aiagent.skill.ovirt.api.a.c r6, d.c.d<? super e> r7) {
            com.obric.aiagent.skill.ovirt.api.a.d r8 = (com.obric.aiagent.skill.ovirt.api.a.d) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.aiagent.skill.ovirt.api.a.d.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21142c = r3;
            this.f21143d = r4;
            this.f21144e = r8;
            this.f = r6;
            super(2, r9);
        }

        public final Object a(com.obric.aiagent.skill.ovirt.impl.h.a r3, d.c.d<? super com.obric.aiagent.skill.ovirt.api.a.e> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            e r11 = new e(this.f21142c, this.f21143d, this.f21144e, this.f, r7);
            r11.f21141b = r9;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r11, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(com.obric.aiagent.skill.ovirt.impl.h.a r3, d.c.d<? super com.obric.aiagent.skill.ovirt.api.a.e> r4) {
            return a((com.obric.aiagent.skill.ovirt.impl.h.a) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.ovirt.impl.h.a.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21140a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r11);
        L11:
            return r11;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r11);
            com.obric.aiagent.skill.ovirt.impl.h.a r12 = (com.obric.aiagent.skill.ovirt.impl.h.a) ZeusTransformUtils.preCheckCast(this.f21141b, com.obric.aiagent.skill.ovirt.impl.h.a.class, "com.obric.aiagent.plugin");
            b r4 = this.f21142c;
            y r5 = r12.d();
            String r6 = this.f21143d;
            com.obric.aiagent.skill.ovirt.api.a.d r7 = this.f21144e;
            com.obric.aiagent.skill.ovirt.api.a.c r8 = this.f;
            d.c.d r9 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21140a = 1;
            r11 = b.a(r4, r5, r6, r7, r8, r9);
            if (r11 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: FileCapability.kt */
    @d.c.b.a.f(b = "FileCapability.kt", c = {74}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.file.FileCapability$exportDirectoryArchive$2")
    static final class f extends d.c.b.a.l implements m<com.obric.aiagent.skill.ovirt.impl.h.a, d.c.d<? super com.obric.aiagent.skill.ovirt.api.a.e>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21145a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f21146b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f21147c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f21148d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.skill.ovirt.api.a.d f21149e;

        f(b r3, String r4, com.obric.aiagent.skill.ovirt.api.a.d r5, d.c.d<? super f> r6) {
            com.obric.aiagent.skill.ovirt.api.a.d r7 = (com.obric.aiagent.skill.ovirt.api.a.d) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.aiagent.skill.ovirt.api.a.d.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21147c = r3;
            this.f21148d = r4;
            this.f21149e = r7;
            super(2, r8);
        }

        public final Object a(com.obric.aiagent.skill.ovirt.impl.h.a r3, d.c.d<? super com.obric.aiagent.skill.ovirt.api.a.e> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r5, d.c.d<?> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            f r0 = new f(this.f21147c, this.f21148d, this.f21149e, r7);
            r0.f21146b = r5;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(com.obric.aiagent.skill.ovirt.impl.h.a r3, d.c.d<? super com.obric.aiagent.skill.ovirt.api.a.e> r4) {
            return a((com.obric.aiagent.skill.ovirt.impl.h.a) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.ovirt.impl.h.a.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21145a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r8);
        L11:
            return r8;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r8);
            com.obric.aiagent.skill.ovirt.impl.h.a r9 = (com.obric.aiagent.skill.ovirt.impl.h.a) ZeusTransformUtils.preCheckCast(this.f21146b, com.obric.aiagent.skill.ovirt.impl.h.a.class, "com.obric.aiagent.plugin");
            b r2 = this.f21147c;
            y r10 = r9.d();
            String r4 = this.f21148d;
            com.obric.aiagent.skill.ovirt.api.a.d r5 = this.f21149e;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21145a = 1;
            r8 = b.a(r2, r10, r4, r5, r3);
            if (r8 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: FileCapability.kt */
    @d.c.b.a.f(b = "FileCapability.kt", c = {203, 218, 220, 234, 246, 269, 269}, d = "exportDirectoryArchive", e = "com.obric.aiagent.skill.ovirt.impl.file.FileCapability")
    static final class g extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21150a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21151b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21152c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f21153d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f21154e;
        Object f;
        Object g;
        /* synthetic */ Object h;
        final /* synthetic */ b i;
        int j;

        g(b r3, d.c.d<? super g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.i = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.h = r3;
            this.j |= Integer.MIN_VALUE;
            return b.a(this.i, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: FileCapability.kt */
    @d.c.b.a.f(b = "FileCapability.kt", c = {149, 151}, d = "exportFile", e = "com.obric.aiagent.skill.ovirt.impl.file.FileCapability")
    static final class h extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21155a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21156b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21157c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f21158d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f21159e;
        final /* synthetic */ b f;
        int g;

        h(b r3, d.c.d<? super h> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.f21159e = r7;
            this.g |= Integer.MIN_VALUE;
            return b.a(this.f, null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: FileCapability.kt */
    @d.c.b.a.f(b = "FileCapability.kt", c = {45}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.file.FileCapability$importFile$2")
    static final class i extends d.c.b.a.l implements m<com.obric.aiagent.skill.ovirt.impl.h.a, d.c.d<? super com.obric.aiagent.skill.ovirt.api.a.f>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21160a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f21161b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f21162c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.skill.ovirt.api.a.g f21163d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f21164e;

        i(b r3, com.obric.aiagent.skill.ovirt.api.a.g r4, String r5, d.c.d<? super i> r6) {
            com.obric.aiagent.skill.ovirt.api.a.g r7 = (com.obric.aiagent.skill.ovirt.api.a.g) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.aiagent.skill.ovirt.api.a.g.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21162c = r3;
            this.f21163d = r7;
            this.f21164e = r5;
            super(2, r8);
        }

        public final Object a(com.obric.aiagent.skill.ovirt.impl.h.a r3, d.c.d<? super com.obric.aiagent.skill.ovirt.api.a.f> r4) {
            return ((i) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r5, d.c.d<?> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            i r0 = new i(this.f21162c, this.f21163d, this.f21164e, r7);
            r0.f21161b = r5;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(com.obric.aiagent.skill.ovirt.impl.h.a r3, d.c.d<? super com.obric.aiagent.skill.ovirt.api.a.f> r4) {
            return a((com.obric.aiagent.skill.ovirt.impl.h.a) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.ovirt.impl.h.a.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21160a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r8);
        L11:
            return r8;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r8);
            com.obric.aiagent.skill.ovirt.impl.h.a r9 = (com.obric.aiagent.skill.ovirt.impl.h.a) ZeusTransformUtils.preCheckCast(this.f21161b, com.obric.aiagent.skill.ovirt.impl.h.a.class, "com.obric.aiagent.plugin");
            b r2 = this.f21162c;
            y r10 = r9.d();
            com.obric.aiagent.skill.ovirt.api.a.g r4 = this.f21163d;
            String r5 = this.f21164e;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21160a = 1;
            r8 = b.a(r2, r10, r4, r5, r3);
            if (r8 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: FileCapability.kt */
    @d.c.b.a.f(b = "FileCapability.kt", c = {102}, d = "importFile", e = "com.obric.aiagent.skill.ovirt.impl.file.FileCapability")
    static final class j extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21165a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21166b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f21167c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f21168d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f21169e;

        j(b r3, d.c.d<? super j> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21168d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21167c = r3;
            this.f21169e |= Integer.MIN_VALUE;
            return b.a(this.f21168d, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: FileCapability.kt */
    @d.c.b.a.f(b = "FileCapability.kt", c = {312}, d = "importInternalText", e = "com.obric.aiagent.skill.ovirt.impl.file.FileCapability")
    static final class k extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21170a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21171b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f21172c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f21173d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f21174e;

        k(b r3, d.c.d<? super k> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21173d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21172c = r3;
            this.f21174e |= Integer.MIN_VALUE;
            return b.a(this.f21173d, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: lambda$7d7ZL4-Lk0oGvMWqRZvTstLU7rc, reason: not valid java name */
    public static /* synthetic */ CharSequence m360lambda$7d7ZL4Lk0oGvMWqRZvTstLU7rc(byte r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$qLBcxOJC-44HgTGgESHYCFj1DKs, reason: not valid java name */
    public static /* synthetic */ CharSequence m361lambda$qLBcxOJC44HgTGgESHYCFj1DKs(com.obric.aiagent.skill.virt.api.x r0) {
        return a(r0);
    }

    public b(OVirt r2) {
        d.h.b.o.e(r2, "owner");
        this.f21129b = r2;
    }

    public static final /* synthetic */ Object a(b r2, y r3, com.obric.aiagent.skill.ovirt.api.a.g r4, String r5, d.c.d r6) {
        return r2.a(r3, (com.obric.aiagent.skill.ovirt.api.a.g) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.aiagent.skill.ovirt.api.a.g.class, "com.obric.aiagent.plugin"), r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(b r2, y r3, com.obric.aiagent.skill.virt.api.x r4, d.c.d r5) {
        return r2.a(r3, (com.obric.aiagent.skill.virt.api.x) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.aiagent.skill.virt.api.x.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(b r8, y r9, String r10, com.obric.aiagent.skill.ovirt.api.a.d r11, com.obric.aiagent.skill.ovirt.api.a.c r12, d.c.d r13) {
        return r8.a(r9, r10, (com.obric.aiagent.skill.ovirt.api.a.d) ZeusTransformUtils.wrapperContextForParams(r11, com.obric.aiagent.skill.ovirt.api.a.d.class, "com.obric.aiagent.plugin"), r12, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(b r2, y r3, String r4, com.obric.aiagent.skill.ovirt.api.a.d r5, d.c.d r6) {
        return r2.a(r3, r4, (com.obric.aiagent.skill.ovirt.api.a.d) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.aiagent.skill.ovirt.api.a.d.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(b r2, y r3, String r4, String r5, d.c.d r6) {
        return r2.a(r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(b r2, y r3, List r4, d.c.d r5) {
        return r2.a(r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.skill.ovirt.api.IOVirtService.b
    public Object a(String r11, com.obric.aiagent.skill.ovirt.api.a.g r12, String r13, d.c.d<? super com.obric.aiagent.skill.ovirt.api.b<com.obric.aiagent.skill.ovirt.api.a.f>> r14) {
        com.obric.aiagent.skill.ovirt.api.a.g r15 = (com.obric.aiagent.skill.ovirt.api.a.g) ZeusTransformUtils.wrapperContextForParams(r12, com.obric.aiagent.skill.ovirt.api.a.g.class, "com.obric.aiagent.plugin");
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        return OVirt.access$impl_release$default(this.f21129b, r11, false, null, (m) ZeusTransformUtils.preCheckCast(new i(this, r15, r13, null), m.class, "com.obric.aiagent.plugin"), r7, 6, null);
    }

    @Override // com.obric.aiagent.skill.ovirt.api.IOVirtService.b
    public Object a(String r13, String r14, com.obric.aiagent.skill.ovirt.api.a.d r15, com.obric.aiagent.skill.ovirt.api.a.c r16, boolean r17, d.h.a.a<x> r18, d.c.d<? super com.obric.aiagent.skill.ovirt.api.b<com.obric.aiagent.skill.ovirt.api.a.e>> r19) {
        com.obric.aiagent.skill.ovirt.api.a.d r5 = (com.obric.aiagent.skill.ovirt.api.a.d) ZeusTransformUtils.wrapperContextForParams(r15, com.obric.aiagent.skill.ovirt.api.a.d.class, "com.obric.aiagent.plugin");
        d.h.a.a<x> r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r18, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
        return this.f21129b.access$impl_release(r13, r17, r9, (m) ZeusTransformUtils.preCheckCast(new e(this, r14, r5, r16, null), m.class, "com.obric.aiagent.plugin"), r11);
    }

    @Override // com.obric.aiagent.skill.ovirt.api.IOVirtService.b
    public Object a(String r9, String r10, com.obric.aiagent.skill.ovirt.api.a.d r11, boolean r12, d.h.a.a<x> r13, d.c.d<? super com.obric.aiagent.skill.ovirt.api.b<com.obric.aiagent.skill.ovirt.api.a.e>> r14) {
        com.obric.aiagent.skill.ovirt.api.a.d r15 = (com.obric.aiagent.skill.ovirt.api.a.d) ZeusTransformUtils.wrapperContextForParams(r11, com.obric.aiagent.skill.ovirt.api.a.d.class, "com.obric.aiagent.plugin");
        d.h.a.a<x> r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r13, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        return this.f21129b.access$impl_release(r9, r12, r5, (m) ZeusTransformUtils.preCheckCast(new f(this, r10, r15, null), m.class, "com.obric.aiagent.plugin"), r7);
    }

    private final Object a(y r11, com.obric.aiagent.skill.ovirt.api.a.g r12, String r13, d.c.d<? super com.obric.aiagent.skill.ovirt.api.a.f> r14) {
        com.obric.aiagent.skill.ovirt.api.a.g r15 = (com.obric.aiagent.skill.ovirt.api.a.g) ZeusTransformUtils.wrapperContextForParams(r12, com.obric.aiagent.skill.ovirt.api.a.g.class, "com.obric.aiagent.plugin");
        d.c.d r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r16, j.class) == false) goto L7;
        j r0 = (j) ZeusTransformUtils.preCheckCast(r16, j.class, "com.obric.aiagent.plugin");
        if ((r0.f21169e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f21169e -= Integer.MIN_VALUE;
    L8:
        j r6 = r0;
        Object r17 = r6.f21167c;
        Object r1 = d.c.a.b.a();
        int r2 = r6.f21169e;
        if (r2 == 0) goto L18;
        if (r2 != 1) goto L17;
        com.obric.aiagent.skill.virt.api.e r10 = (com.obric.aiagent.skill.virt.api.e) ZeusTransformUtils.preCheckCast(r6.f21166b, com.obric.aiagent.skill.virt.api.e.class, "com.obric.aiagent.plugin");
        b r18 = (b) ZeusTransformUtils.preCheckCast(r6.f21165a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r17);     // Catch: Throwable -> L14
    L30:
        com.obric.aiagent.skill.virt.api.h r19 = (com.obric.aiagent.skill.virt.api.h) ZeusTransformUtils.preCheckCast(r17, com.obric.aiagent.skill.virt.api.h.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (IAppContext.Companion.isDebug() == false) goto L34;
        ILogDepend.Companion.i(TAG, "importFile: fileName=" + r19.a() + " path=" + r10.a() + " bytes=" + r19.b());
    L36:
        return new com.obric.aiagent.skill.ovirt.api.a.f(r10, r19.a(), r19.b());
    L34:
        ILogDepend.Companion.i(TAG, "importFile: completed bytes=" + r19.b());
    L14:
        th = move-exception;
        Throwable r3 = th;
        b r9 = r18;
        com.obric.aiagent.skill.virt.api.e r110 = r10;
        b this = r9;
    L39:
        this.a("importFile: IVirtService primitive failed", "importFile: IVirtService primitive failed target=" + r110.a(), r3);
        throw new com.obric.aiagent.skill.ovirt.api.a.a("File import failed", r3, null, 4, null);
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r17);
        String r111 = a(r13);
        String r112 = ".cache/imports/" + r111;
        r110 = r11.a(r112);     // Catch: Throwable -> L43
        if (ZeusTransformUtils.instanceOf(r15, com.obric.aiagent.skill.ovirt.api.a.g.a.class) == false) goto L24;
        com.obric.aiagent.skill.virt.api.g r113 = (com.obric.aiagent.skill.virt.api.g) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.virt.api.g.b(((com.obric.aiagent.skill.ovirt.api.a.g.a) ZeusTransformUtils.preCheckCast(r15, com.obric.aiagent.skill.ovirt.api.a.g.a.class, "com.obric.aiagent.plugin")).a()), com.obric.aiagent.skill.virt.api.g.class, "com.obric.aiagent.plugin");
    L46:
        IVirtService.b r4 = this.f21129b.getVirt$impl_release().getFiles();     // Catch: Throwable -> L37
        com.obric.aiagent.skill.virt.api.x r5 = (com.obric.aiagent.skill.virt.api.x) ZeusTransformUtils.preCheckCast(r110, com.obric.aiagent.skill.virt.api.x.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
        r6.f21165a = this;     // Catch: Throwable -> L37
        r6.f21166b = r110;     // Catch: Throwable -> L37
        r6.f21169e = 1;     // Catch: Throwable -> L37
        r17 = IVirtService.b.a.a(r4, r113, r5, null, r6, 4, null);     // Catch: Throwable -> L37
        if (r17 != r1) goto L29;
        return r1;
    L29:
        r18 = this;
        r10 = r110;
    L37:
        th = move-exception;
        r3 = th;
        goto L39
    L24:
        if (ZeusTransformUtils.instanceOf(r15, com.obric.aiagent.skill.ovirt.api.a.g.b.class) == false) goto L42;
        r113 = (com.obric.aiagent.skill.virt.api.g) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.virt.api.g.c(((com.obric.aiagent.skill.ovirt.api.a.g.b) ZeusTransformUtils.preCheckCast(r15, com.obric.aiagent.skill.ovirt.api.a.g.b.class, "com.obric.aiagent.plugin")).a(), r111), com.obric.aiagent.skill.virt.api.g.class, "com.obric.aiagent.plugin");
        goto L46
    L42:
        throw new d.k();
    L43:
        th = move-exception;
        a("importFile: rejected target", "importFile: rejected target relative='" + r112 + '\'', th);
        throw new com.obric.aiagent.skill.ovirt.api.a.a("Import target rejected", th, null, 4, null);
    L7:
        r0 = new j(this, r16);
        goto L8
    }

    private final Object a(y r10, String r11, com.obric.aiagent.skill.ovirt.api.a.d r12, com.obric.aiagent.skill.ovirt.api.a.c r13, d.c.d<? super com.obric.aiagent.skill.ovirt.api.a.e> r14) {
        com.obric.aiagent.skill.ovirt.api.a.d r15 = (com.obric.aiagent.skill.ovirt.api.a.d) ZeusTransformUtils.wrapperContextForParams(r12, com.obric.aiagent.skill.ovirt.api.a.d.class, "com.obric.aiagent.plugin");
        d.c.d r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r16, h.class) == false) goto L7;
        h r1 = (h) ZeusTransformUtils.preCheckCast(r16, h.class, "com.obric.aiagent.plugin");
        if ((r1.g & Integer.MIN_VALUE) == 0) goto L7;
        r1.g -= Integer.MIN_VALUE;
    L8:
        Object r17 = r1.f21159e;
        Object r3 = d.c.a.b.a();
        int r4 = r1.g;
        if (r4 == 0) goto L20;
        if (r4 == 1) goto L19;
        if (r4 != 2) goto L18;
        com.obric.aiagent.skill.virt.api.a r9 = (com.obric.aiagent.skill.virt.api.a) ZeusTransformUtils.preCheckCast(r1.f21156b, com.obric.aiagent.skill.virt.api.a.class, "com.obric.aiagent.plugin");
        b r18 = (b) ZeusTransformUtils.preCheckCast(r1.f21155a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r17);     // Catch: Throwable -> L15
    L35:
        com.obric.aiagent.skill.virt.api.d r19 = (com.obric.aiagent.skill.virt.api.d) ZeusTransformUtils.preCheckCast(r17, com.obric.aiagent.skill.virt.api.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        if (IAppContext.Companion.isDebug() == false) goto L39;
        ILogDepend.Companion.i(TAG, "exportFile: virtPath=" + r9.a() + " hostPath=" + r19.a() + " bytes=" + r19.c());
    L41:
        return new com.obric.aiagent.skill.ovirt.api.a.e(r9.a(), new File(r19.a()), r19.b(), r19.c());
    L39:
        ILogDepend.Companion.i(TAG, "exportFile: completed bytes=" + r19.c());
    L15:
        Throwable th = th;
    L44:
        r18.a("exportFile: IVirtService primitive failed", "exportFile: IVirtService primitive failed path=" + r9.a(), th);
        throw new com.obric.aiagent.skill.ovirt.api.a.a("File export failed", th, com.obric.aiagent.skill.ovirt.api.a.b.f20949d);
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        com.obric.aiagent.skill.virt.api.a r20 = (com.obric.aiagent.skill.virt.api.a) ZeusTransformUtils.preCheckCast(r1.f21158d, com.obric.aiagent.skill.virt.api.a.class, "com.obric.aiagent.plugin");
        r13 = (com.obric.aiagent.skill.ovirt.api.a.c) ZeusTransformUtils.preCheckCast(r1.f21157c, com.obric.aiagent.skill.ovirt.api.a.c.class, "com.obric.aiagent.plugin");
        r15 = (com.obric.aiagent.skill.ovirt.api.a.d) ZeusTransformUtils.preCheckCast(r1.f21156b, com.obric.aiagent.skill.ovirt.api.a.d.class, "com.obric.aiagent.plugin");
        b r110 = (b) ZeusTransformUtils.preCheckCast(r1.f21155a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r17);
        com.obric.aiagent.skill.virt.api.a r111 = r20;
        b this = r110;
    L46:
        IVirtService.b r112 = this.f21129b.getVirt$impl_release().getFiles();     // Catch: Throwable -> L42
        com.obric.aiagent.skill.virt.api.x r113 = (com.obric.aiagent.skill.virt.api.x) ZeusTransformUtils.preCheckCast(r111, com.obric.aiagent.skill.virt.api.x.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L42
        com.obric.aiagent.skill.virt.api.c r114 = this.a(r15);     // Catch: Throwable -> L42
        com.obric.aiagent.skill.virt.api.b r115 = this.a(r13);     // Catch: Throwable -> L42
        r1.f21155a = this;     // Catch: Throwable -> L42
        r1.f21156b = r111;     // Catch: Throwable -> L42
        r1.f21157c = null;     // Catch: Throwable -> L42
        r1.f21158d = null;     // Catch: Throwable -> L42
        r1.g = 2;     // Catch: Throwable -> L42
        r17 = r112.a(r113, r114, r115, r1);     // Catch: Throwable -> L42
        if (r17 != r3) goto L34;
        return r3;
    L34:
        r18 = this;
        r9 = r111;
    L42:
        th = move-exception;
        r18 = this;
        r9 = r111;
        th = th;
        goto L44
    L20:
        d.o.a(r17);
        if (al.f19195a.a().F() == false) goto L23;
        r111 = a(r10, r11);
        com.obric.aiagent.skill.virt.api.x r116 = (com.obric.aiagent.skill.virt.api.x) ZeusTransformUtils.preCheckCast(r111, com.obric.aiagent.skill.virt.api.x.class, "com.obric.aiagent.plugin");
        r1.f21155a = this;
        r1.f21156b = r15;
        r1.f21157c = r13;
        r1.f21158d = r111;
        r1.g = 1;
        if (a(r10, r116, r1) != r3) goto L46;
        return r3;
    L23:
        if (IAppContext.Companion.isDebug() == false) goto L25;
        ILogDepend.Companion.w(TAG, "exportFile: disabled by settings path=" + r11);
    L27:
        throw new com.obric.aiagent.skill.ovirt.api.a.a("exportFile: shell is disabled by settings", null, com.obric.aiagent.skill.ovirt.api.a.b.f20949d, 2, null);
    L25:
        ILogDepend.Companion.w(TAG, "exportFile: disabled by settings");
    L7:
        r1 = new h(this, r16);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 16, insn: 0x03d4: MOVE (r2 I:??[OBJECT, ARRAY]) = (r16 I:??[OBJECT, ARRAY]), block:B:97:0x03d4 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3, types: [com.obric.aiagent.skill.ovirt.api.a.d] */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.obric.aiagent.skill.ovirt.api.a.d, com.obric.aiagent.skill.virt.api.y, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r8v35, types: [com.obric.aiagent.skill.ovirt.impl.c.b] */
    private final Object a(y r27, String r28, com.obric.aiagent.skill.ovirt.api.a.d r29, d.c.d<? super com.obric.aiagent.skill.ovirt.api.a.e> r30) {
        y r1 = r27;
        ?? r4 = (com.obric.aiagent.skill.ovirt.api.a.d) ZeusTransformUtils.wrapperContextForParams(r29, com.obric.aiagent.skill.ovirt.api.a.d.class, "com.obric.aiagent.plugin");
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r30, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, g.class) == false) goto L7;
        g r7 = (g) ZeusTransformUtils.preCheckCast(r6, g.class, "com.obric.aiagent.plugin");
        if ((r7.j & Integer.MIN_VALUE) == 0) goto L7;
        r7.j -= Integer.MIN_VALUE;
    L8:
        Object r8 = r7.h;
        Object r15 = d.c.a.b.a();
        switch(r7.j) {
            case 0: goto L37;
            case 1: goto L36;
            case 2: goto L31;
            case 3: goto L30;
            case 4: goto L21;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            default: goto L11;
        };
    L12:
        Throwable r0 = (Throwable) ZeusTransformUtils.preCheckCast(r7.f21150a, Throwable.class, "com.obric.aiagent.plugin");
        d.o.a(r8);
        throw r0;
    L13:
        Object r2 = r7.f21150a;
        d.o.a(r8);
        return r2;
    L14:
        List<? extends com.obric.aiagent.skill.virt.api.x> r3 = (List) ZeusTransformUtils.preCheckCast(r7.f21152c, List.class, "com.obric.aiagent.plugin");
        y r5 = (y) ZeusTransformUtils.preCheckCast(r7.f21151b, y.class, "com.obric.aiagent.plugin");
        b r9 = (b) ZeusTransformUtils.preCheckCast(r7.f21150a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r8);     // Catch: Throwable -> L17 com.obric.aiagent.skill.ovirt.api.a.a -> L19
        Object r10 = r8;
        y r11 = r5;
        b r12 = r9;
        List<? extends com.obric.aiagent.skill.virt.api.x> r13 = r3;
        Object r14 = null;
    L71:
        r7.f21150a = r10;
        r7.f21151b = r14;
        r7.f21152c = r14;
        r7.j = 6;
        if (r12.a(r11, r13, r7) != r15) goto L134;
        return r15;
    L134:
        return r10;
    L19:
        e = e;
    L135:
        throw e;     // Catch: Throwable -> L96
    L17:
        th = th;
    L91:
        r9.a("exportDirectoryArchive: failed", "exportDirectoryArchive: failed", th);     // Catch: Throwable -> L96
        throw new com.obric.aiagent.skill.ovirt.api.a.a("Directory archive failed", th, com.obric.aiagent.skill.ovirt.api.a.b.f20949d);     // Catch: Throwable -> L96
    L21:
        List<? extends com.obric.aiagent.skill.virt.api.x> r16 = (List) ZeusTransformUtils.preCheckCast(r7.f21154e, List.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.virt.api.e r17 = (com.obric.aiagent.skill.virt.api.e) ZeusTransformUtils.preCheckCast(r7.f21153d, com.obric.aiagent.skill.virt.api.e.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.ovirt.api.a.d r18 = (com.obric.aiagent.skill.ovirt.api.a.d) ZeusTransformUtils.preCheckCast(r7.f21152c, com.obric.aiagent.skill.ovirt.api.a.d.class, "com.obric.aiagent.plugin");
        y r19 = (y) ZeusTransformUtils.preCheckCast(r7.f21151b, y.class, "com.obric.aiagent.plugin");
        r9 = (b) ZeusTransformUtils.preCheckCast(r7.f21150a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r8);     // Catch: Throwable -> L24 com.obric.aiagent.skill.ovirt.api.a.a -> L27
        ?? r110 = r18;
        r12 = r9;
        r13 = r16;
        r14 = null;
        Object r20 = r8;
        r11 = r19;
    L125:
        z r21 = (z) ZeusTransformUtils.preCheckCast(r20, z.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L77 com.obric.aiagent.skill.ovirt.api.a.a -> L79
        if (com.obric.aiagent.skill.ovirt.impl.c.c.a(r21) == false) goto L76;
        String r111 = r17.a();     // Catch: Throwable -> L77 com.obric.aiagent.skill.ovirt.api.a.a -> L79
        com.obric.aiagent.skill.ovirt.api.a.c r112 = new com.obric.aiagent.skill.ovirt.api.a.c(false, true, true, 1, null);     // Catch: Throwable -> L77 com.obric.aiagent.skill.ovirt.api.a.a -> L79
        r7.f21150a = r12;     // Catch: Throwable -> L77 com.obric.aiagent.skill.ovirt.api.a.a -> L79
        r7.f21151b = r11;     // Catch: Throwable -> L77 com.obric.aiagent.skill.ovirt.api.a.a -> L79
        r7.f21152c = r13;     // Catch: Throwable -> L77 com.obric.aiagent.skill.ovirt.api.a.a -> L79
        r7.f21153d = r14;     // Catch: Throwable -> L77 com.obric.aiagent.skill.ovirt.api.a.a -> L79
        r7.f21154e = r14;     // Catch: Throwable -> L77 com.obric.aiagent.skill.ovirt.api.a.a -> L79
        r7.j = 5;     // Catch: Throwable -> L77 com.obric.aiagent.skill.ovirt.api.a.a -> L79
        r10 = r12.a(r11, r111, r110, r112, r7);     // Catch: Throwable -> L77 com.obric.aiagent.skill.ovirt.api.a.a -> L79
        if (r10 != r15) goto L71;
        return r15;
    L76:
        throw new com.obric.aiagent.skill.ovirt.api.a.a("Directory archive rejected", null, r12.c(r21.a()), 2, null);     // Catch: Throwable -> L77 com.obric.aiagent.skill.ovirt.api.a.a -> L79
    L79:
        e = move-exception;
        throw e;     // Catch: Throwable -> L96
    L77:
        th = th;
        r9 = r12;
        goto L91
    L27:
        e = e;
    L24:
        th = th;
        goto L91
    L30:
        Throwable r22 = (Throwable) ZeusTransformUtils.preCheckCast(r7.f21150a, Throwable.class, "com.obric.aiagent.plugin");
        d.o.a(r8);
        throw r22;
    L31:
        r17 = (com.obric.aiagent.skill.virt.api.e) ZeusTransformUtils.preCheckCast(r7.f21154e, com.obric.aiagent.skill.virt.api.e.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.virt.api.e r23 = (com.obric.aiagent.skill.virt.api.e) ZeusTransformUtils.preCheckCast(r7.f21153d, com.obric.aiagent.skill.virt.api.e.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.ovirt.api.a.d r24 = (com.obric.aiagent.skill.ovirt.api.a.d) ZeusTransformUtils.preCheckCast(r7.f21152c, com.obric.aiagent.skill.ovirt.api.a.d.class, "com.obric.aiagent.plugin");
        y r25 = (y) ZeusTransformUtils.preCheckCast(r7.f21151b, y.class, "com.obric.aiagent.plugin");
        r9 = (b) ZeusTransformUtils.preCheckCast(r7.f21150a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r8);     // Catch: Throwable -> L34
        Object r113 = null;
        ?? r26 = r24;
        y r31 = r25;
        Object r32 = r8;
    L114:
        com.obric.aiagent.skill.virt.api.e r33 = (com.obric.aiagent.skill.virt.api.e) ZeusTransformUtils.preCheckCast(r32, com.obric.aiagent.skill.virt.api.e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L101
        List<? extends com.obric.aiagent.skill.virt.api.x> r114 = p.b(new com.obric.aiagent.skill.virt.api.e[]{r23, r33, r17});
        String r115 = p.a((Iterable) ZeusTransformUtils.preCheckCast(p.b(new String[]{"python3", com.obric.aiagent.skill.ovirt.impl.a.a(r23.a()), com.obric.aiagent.skill.ovirt.impl.a.a(r33.a())}), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" ", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);     // Catch: Throwable -> L89 com.obric.aiagent.skill.ovirt.api.a.a -> L93
        com.obric.aiagent.skill.ovirt.impl.g.e r34 = r9.f21129b.getShellCapability$impl_release();     // Catch: Throwable -> L89 com.obric.aiagent.skill.ovirt.api.a.a -> L93
        com.obric.aiagent.skill.virt.api.x r35 = (com.obric.aiagent.skill.virt.api.x) ZeusTransformUtils.preCheckCast(r31.a(), com.obric.aiagent.skill.virt.api.x.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L89 com.obric.aiagent.skill.ovirt.api.a.a -> L93
        r7.f21150a = r9;     // Catch: Throwable -> L89 com.obric.aiagent.skill.ovirt.api.a.a -> L93
        r7.f21151b = r31;     // Catch: Throwable -> L89 com.obric.aiagent.skill.ovirt.api.a.a -> L93
        r7.f21152c = r26;     // Catch: Throwable -> L89 com.obric.aiagent.skill.ovirt.api.a.a -> L93
        r7.f21153d = r17;     // Catch: Throwable -> L89 com.obric.aiagent.skill.ovirt.api.a.a -> L93
        r7.f21154e = r114;     // Catch: Throwable -> L89 com.obric.aiagent.skill.ovirt.api.a.a -> L93
    L128:
        r7.j = 4;     // Catch: Throwable -> L85 com.obric.aiagent.skill.ovirt.api.a.a -> L87
        r14 = null;
        r20 = r34.a(r35, r115, 60000, "skill_archive", r7);     // Catch: Throwable -> L81 com.obric.aiagent.skill.ovirt.api.a.a -> L83
        if (r20 != r15) goto L65;
        return r15;
    L65:
        r110 = r26;
        r11 = r31;
        r12 = r9;
        r13 = r114;
        goto L125
    L83:
        e = move-exception;
        throw e;     // Catch: Throwable -> L96
    L81:
        th = th;
        goto L91
    L87:
        e = e;
    L85:
        th = th;
    L93:
        e = move-exception;
        throw e;     // Catch: Throwable -> L96
    L89:
        th = th;
    L101:
        th = th;
        Object r36 = r113;
        r25 = r31;
    L108:
        List<? extends com.obric.aiagent.skill.virt.api.x> r37 = p.a(r23);
        r7.f21150a = th;
        r7.f21151b = r36;
        r7.f21152c = r36;
        r7.f21153d = r36;
        r7.f21154e = r36;
        r7.f = r36;
        r7.g = r36;
        r7.j = 3;
        if (r9.a(r25, r37, r7) != r15) goto L139;
        return r15;
    L139:
        throw th;
    L34:
        th = th;
        r36 = null;
        goto L108
    L36:
        String r38 = (String) ZeusTransformUtils.preCheckCast(r7.g, String.class, "com.obric.aiagent.plugin");
        String r39 = (String) ZeusTransformUtils.preCheckCast(r7.f, String.class, "com.obric.aiagent.plugin");
        al r40 = (al) ZeusTransformUtils.preCheckCast(r7.f21154e, al.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.virt.api.a r41 = (com.obric.aiagent.skill.virt.api.a) ZeusTransformUtils.preCheckCast(r7.f21153d, com.obric.aiagent.skill.virt.api.a.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.ovirt.api.a.d r116 = (com.obric.aiagent.skill.ovirt.api.a.d) ZeusTransformUtils.preCheckCast(r7.f21152c, com.obric.aiagent.skill.ovirt.api.a.d.class, "com.obric.aiagent.plugin");
        y r117 = (y) ZeusTransformUtils.preCheckCast(r7.f21151b, y.class, "com.obric.aiagent.plugin");
        r9 = (b) ZeusTransformUtils.preCheckCast(r7.f21150a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r8);
        String r42 = r39;
        r1 = r117;
        ?? r118 = r116;
    L43:
        com.obric.aiagent.skill.virt.api.e r43 = (com.obric.aiagent.skill.virt.api.e) ZeusTransformUtils.preCheckCast(r8, com.obric.aiagent.skill.virt.api.e.class, "com.obric.aiagent.plugin");
        r17 = r1.a(".cache/imports/" + r38);
        JSONObject r119 = new JSONObject();
        r119.put(DBHelper.BATTERY_COL_SOURCE, r41.a());
        r119.put("output", r17.a());
        JSONArray r44 = new JSONArray();
        r44.put(r1.a().a());
        com.obric.aiagent.skill.virt.api.j r120 = r1.b();
        if (r120 == null) goto L48;
        String r121 = r120.a();
        if (r121 == null) goto L48;
        r44.put(r121);
    L48:
        x r122 = x.f38692a;
        r119.put("allowed_roots", r44);
        r119.put("max_entries", r40.l());
        r15 = r15;
        r119.put("max_entry_bytes", r40.m());
        r119.put("max_total_bytes", r40.n());
        r119.put("max_archive_bytes", r40.k());
        String r45 = r119.toString();
        d.h.b.o.c(r45, "toString(...)");
        r7.f21150a = r9;     // Catch: Throwable -> L105
        r7.f21151b = r1;     // Catch: Throwable -> L105
        r7.f21152c = r118;     // Catch: Throwable -> L105
        r7.f21153d = r43;     // Catch: Throwable -> L105
        r7.f21154e = r17;     // Catch: Throwable -> L105
        r113 = null;
        r7.f = null;     // Catch: Throwable -> L103
        r7.g = null;     // Catch: Throwable -> L103
        r7.j = 2;     // Catch: Throwable -> L103
        Object r46 = r9.a(r1, r42, r45, r7);     // Catch: Throwable -> L103
        r15 = r15;
        if (r46 != r15) goto L55;
        return r15;
    L55:
        r32 = r46;
        r31 = r1;
        r23 = r43;
        r26 = r118;
    L103:
        th = th;
        r36 = null;
    L107:
        r25 = r1;
        r23 = r43;
    L105:
        th = th;
        r36 = null;
        goto L107
    L37:
        d.o.a(r8);
        if (al.f19195a.a().F() == false) goto L113;
        r41 = a(r27, r28);
        al r47 = al.f19195a.a();
        String r48 = a();
        String r123 = "skill_archive_" + r48 + ".py";
        r42 = "skill_archive_" + r48 + ".json";
        String r49 = "skill_archive_" + r48 + ".zip";
        String r124 = com.obric.aiagent.skill.ovirt.impl.c.a.a();
        r7.f21150a = this;
        r7.f21151b = r1;
        r7.f21152c = r4;
        r7.f21153d = r41;
        r7.f21154e = r47;
        r7.f = r42;
        r7.g = r49;
        r7.j = 1;
        Object r125 = a(r1, r123, r124, r7);
        if (r125 != r15) goto L42;
        return r15;
    L42:
        r118 = r4;
        r40 = r47;
        r9 = this;
        r38 = r49;
        r8 = r125;
        goto L43
    L113:
        throw new com.obric.aiagent.skill.ovirt.api.a.a("exportDirectoryArchive: shell is disabled by settings", null, com.obric.aiagent.skill.ovirt.api.a.b.f20949d, 2, null);
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L96:
        th = move-exception;
        r7.f21150a = th;
        r7.f21151b = r1;
        r7.f21152c = r1;
        r7.f21153d = r1;
        r7.f21154e = r1;
        r7.j = 7;
        if (b.class.a(r4, r16, r7) != r15) goto L138;
        return r15;
    L138:
        throw th;
    L7:
        r7 = new g(this, r6);
        goto L8
    }

    private final String a(String r13) {
        if (o.d((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L18;
        if (o.c((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin"), '/', false, 2, null) == true) goto L16;
        if (o.c((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin"), 0, false, 2, null) == true) goto L16;
        if (d.h.b.o.a(r13, ".") == true) goto L14;
        if (d.h.b.o.a(r13, DownloadConstants.VULNERABILITY_PATH) == true) goto L14;
        return r13;
    L14:
        throw new com.obric.aiagent.skill.ovirt.api.a.a("importFile: fileName must not be '.' or '..'", null, null, 6, null);
    L16:
        throw new com.obric.aiagent.skill.ovirt.api.a.a("Invalid import file name", null, null, 6, null);
    L18:
        throw new com.obric.aiagent.skill.ovirt.api.a.a("importFile: fileName must not be blank", null, null, 6, null);
    }

    private final Object a(y r15, String r16, String r17, d.c.d<? super com.obric.aiagent.skill.virt.api.e> r18) {
        b r1 = this;
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r18, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, k.class) == false) goto L7;
        k r3 = (k) ZeusTransformUtils.preCheckCast(r0, k.class, "com.obric.aiagent.plugin");
        if ((r3.f21174e & Integer.MIN_VALUE) == 0) goto L7;
        r3.f21174e -= Integer.MIN_VALUE;
    L8:
        k r8 = r3;
        Object r2 = r8.f21172c;
        Object r4 = d.c.a.b.a();
        int r5 = r8.f21174e;
        if (r5 == 0) goto L18;
        if (r5 != 1) goto L17;
        com.obric.aiagent.skill.virt.api.e r6 = (com.obric.aiagent.skill.virt.api.e) ZeusTransformUtils.preCheckCast(r8.f21171b, com.obric.aiagent.skill.virt.api.e.class, "com.obric.aiagent.plugin");
        b r7 = (b) ZeusTransformUtils.preCheckCast(r8.f21170a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r2);     // Catch: Throwable -> L14
        com.obric.aiagent.skill.virt.api.e r11 = r6;
        r1 = r7;
    L24:
        com.obric.aiagent.skill.virt.api.h r9 = (com.obric.aiagent.skill.virt.api.h) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.virt.api.h.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        if (IAppContext.Companion.isDebug() == false) goto L28;
        ILogDepend.Companion.i(TAG, "importFile: fileName=" + r9.a() + " path=" + r11.a() + " bytes=" + r9.b());
    L29:
        return r11;
    L28:
        ILogDepend.Companion.i(TAG, "importFile: completed bytes=" + r9.b());
    L30:
        th = move-exception;
        Throwable r10 = th;
    L32:
        r1.a("importFile: IVirtService primitive failed", "importFile: IVirtService primitive failed target=" + r11.a(), r10);
        throw new com.obric.aiagent.skill.ovirt.api.a.a("File import failed", r10, null, 4, null);
    L14:
        th = move-exception;
        r10 = th;
        r11 = r6;
        r1 = r7;
        goto L32
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r2);
        String r12 = a(r16);
        String r13 = ".cache/imports/" + r12;
        r11 = r15.a(r13);     // Catch: Throwable -> L34
        byte[] r14 = r17.getBytes(d.o.d.f38623b);
        d.h.b.o.c(r14, "getBytes(...)");
        IVirtService.b r19 = r1.f21129b.getVirt$impl_release().getFiles();     // Catch: Throwable -> L30
        com.obric.aiagent.skill.virt.api.g r20 = (com.obric.aiagent.skill.virt.api.g) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.virt.api.g.c((InputStream) ZeusTransformUtils.preCheckCast(new ByteArrayInputStream(r14), InputStream.class, "com.obric.aiagent.plugin"), r12), com.obric.aiagent.skill.virt.api.g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        com.obric.aiagent.skill.virt.api.x r21 = (com.obric.aiagent.skill.virt.api.x) ZeusTransformUtils.preCheckCast(r11, com.obric.aiagent.skill.virt.api.x.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        r8.f21170a = r1;     // Catch: Throwable -> L30
        r8.f21171b = r11;     // Catch: Throwable -> L30
        r8.f21174e = 1;     // Catch: Throwable -> L30
        r2 = IVirtService.b.a.a(r19, r20, r21, null, r8, 4, null);     // Catch: Throwable -> L30
        if (r2 != r4) goto L24;
        return r4;
    L34:
        th = move-exception;
        a("importFile: rejected target", "importFile: rejected target relative='" + r13 + '\'', th);
        throw new com.obric.aiagent.skill.ovirt.api.a.a("Import target rejected", th, null, 4, null);
    L7:
        r3 = new k(this, r0);
        goto L8
    }

    private final Object a(y r23, List<? extends com.obric.aiagent.skill.virt.api.x> r24, d.c.d<? super x> r25) {
        b r1 = this;
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.aiagent.plugin");
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r25, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, c.class) == false) goto L7;
        c r5 = (c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.aiagent.plugin");
        if ((r5.f21138d & Integer.MIN_VALUE) == 0) goto L7;
        r5.f21138d -= Integer.MIN_VALUE;
    L8:
        c r12 = r5;
        Object r6 = r12.f21136b;
        Object r7 = d.c.a.b.a();
        int r8 = r12.f21138d;
        if (r8 == 0) goto L18;
        if (r8 != 1) goto L17;
        r1 = (b) ZeusTransformUtils.preCheckCast(r12.f21135a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r6);     // Catch: Throwable -> L14
    L25:
        Object r0 = n.f((z) ZeusTransformUtils.preCheckCast(r6, z.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L14
    L28:
        Throwable r3 = n.c(r0);
        if (r3 == null) goto L32;
        r1.a("exportDirectoryArchive: cleanup failed", "exportDirectoryArchive: cleanup failed", r3);
    L32:
        return x.f38692a;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r6);
        if (r2.isEmpty() == true) goto L21;
        n.a r9 = n.f38560a;     // Catch: Throwable -> L14
        com.obric.aiagent.skill.ovirt.impl.g.e r10 = ((b) ZeusTransformUtils.preCheckCast(r1, b.class, "com.obric.aiagent.plugin")).f21129b.getShellCapability$impl_release();     // Catch: Throwable -> L14
        com.obric.aiagent.skill.virt.api.x r11 = (com.obric.aiagent.skill.virt.api.x) ZeusTransformUtils.preCheckCast(r23.a(), com.obric.aiagent.skill.virt.api.x.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        String r13 = "rm -f -- " + p.a((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" ", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, $$Lambda$b$qLBcxOJC44HgTGgESHYCFj1DKs.INSTANCE, 30, null);     // Catch: Throwable -> L14
        r12.f21135a = r1;     // Catch: Throwable -> L14
        r12.f21138d = 1;     // Catch: Throwable -> L14
        r6 = r10.a(r11, r13, 60000, "skill_archive_cleanup", r12);     // Catch: Throwable -> L14
        if (r6 != r7) goto L25;
        return r7;
    L21:
        return x.f38692a;
    L14:
        th = move-exception;
        n.a r14 = n.f38560a;
        r0 = n.f(d.o.a(th));
    L7:
        r5 = new c(r1, r4);
        goto L8
    }

    private static final CharSequence a(com.obric.aiagent.skill.virt.api.x r2) {
        com.obric.aiagent.skill.virt.api.x r3 = (com.obric.aiagent.skill.virt.api.x) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.aiagent.skill.virt.api.x.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.ovirt.impl.a.a(r3.a()), CharSequence.class, "com.obric.aiagent.plugin");
    }

    private final String a() {
        byte[] r0 = new byte[12];
        f21128c.nextBytes(r0);
        return d.a.i.a(r0, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, $$Lambda$b$7d7ZL4Lk0oGvMWqRZvTstLU7rc.INSTANCE, 30, null);
    }

    private static final CharSequence a(byte r3) {
        String r4 = String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(r3 & 255)}, 1));
        d.h.b.o.c(r4, "format(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
    }

    private final com.obric.aiagent.skill.virt.api.a a(y r7, String r8) {
        com.obric.aiagent.skill.virt.api.a r9 = r7.c(r8);     // Catch: Exception -> L12
        if (b(r7, r9.a()) == false) goto L6;
        return r9;
    L6:
        if (IAppContext.Companion.isDebug() == false) goto L8;
        ILogDepend.Companion.w(TAG, "exportFile: path outside export roots path=" + r9.a());
    L10:
        throw new com.obric.aiagent.skill.ovirt.api.a.a("Export path is outside allowed roots", null, com.obric.aiagent.skill.ovirt.api.a.b.f20947b, 2, null);
    L8:
        ILogDepend.Companion.w(TAG, "exportFile: path outside export roots");
    L12:
        e = move-exception;
        a("exportFile: rejected path", "exportFile: rejected path=" + r8, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        throw new com.obric.aiagent.skill.ovirt.api.a.a("Export path rejected", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), com.obric.aiagent.skill.ovirt.api.a.b.f20946a);
    }

    private final boolean b(y r6, String r7) {
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(a(r6), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L5;
    L7:
        Iterator r8 = r5.iterator();
    L9:
        if (r8.hasNext() == false) goto L18;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(r7, r9) == false) goto L13;
    L16:
        boolean r10 = true;
    L17:
        if (r10 == false) goto L9;
        return true;
    L13:
        if (o.b(r7, r9 + '/', false, 2, null) == true) goto L16;
        r10 = false;
    L18:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    private final List<String> a(y r4) {
        String[] r0 = new String[3];
        r0[0] = b(r4.a().a());
        com.obric.aiagent.skill.virt.api.j r5 = r4.b();
        if (r5 == null) goto L7;
        String r6 = r5.a();
        if (r6 == null) goto L7;
        String r3 = b(r6);
    L8:
        r0[1] = r3;
        r0[2] = "/tmp";
        return p.e(r0);
    L7:
        r3 = null;
        goto L8
    }

    private final String b(String r6) {
        if (r6.length() > 1) goto L5;
        return r6;
    L5:
        if (o.b((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"), '/', false, 2, null) == true) goto L7;
        return r6;
    L7:
        return o.c(r6, new char[]{'/'});
    }

    private final Object a(y r11, com.obric.aiagent.skill.virt.api.x r12, d.c.d<? super x> r13) {
        com.obric.aiagent.skill.virt.api.x r14 = (com.obric.aiagent.skill.virt.api.x) ZeusTransformUtils.wrapperContextForParams(r12, com.obric.aiagent.skill.virt.api.x.class, "com.obric.aiagent.plugin");
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, C0443b.class) == false) goto L7;
        C0443b r0 = (C0443b) ZeusTransformUtils.preCheckCast(r15, C0443b.class, "com.obric.aiagent.plugin");
        if ((r0.f21134e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f21134e -= Integer.MIN_VALUE;
    L8:
        C0443b r8 = r0;
        Object r16 = r8.f21132c;
        Object r1 = d.c.a.b.a();
        int r2 = r8.f21134e;
        if (r2 == 0) goto L18;
        if (r2 != 1) goto L17;
        String r10 = (String) ZeusTransformUtils.preCheckCast(r8.f21131b, String.class, "com.obric.aiagent.plugin");
        b r17 = (b) ZeusTransformUtils.preCheckCast(r8.f21130a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r16);     // Catch: Throwable -> L14
    L23:
        z r18 = (z) ZeusTransformUtils.preCheckCast(r16, z.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        Integer r19 = null;
        if (ZeusTransformUtils.instanceOf(r18, z.a.class) == false) goto L27;
        z.a r110 = (z.a) ZeusTransformUtils.preCheckCast(r18, z.a.class, "com.obric.aiagent.plugin");
    L28:
        if (r110 == null) goto L30;
        r19 = d.c.b.a.b.a(r110.b());
    L30:
        if (r19 == null) goto L35;
        if (r19.intValue() != 0) goto L35;
        return x.f38692a;
    L35:
        if (IAppContext.Companion.isDebug() == false) goto L37;
        ILogDepend.Companion.w(TAG, "exportFile: not a readable regular file path=" + r10 + " exitCode=" + r19);
    L39:
        throw new com.obric.aiagent.skill.ovirt.api.a.a("File is not readable", null, com.obric.aiagent.skill.ovirt.api.a.b.f20948c, 2, null);
    L37:
        ILogDepend.Companion.w(TAG, "exportFile: source is not readable exitCode=" + r19);
        goto L39
    L27:
        r110 = null;
    L14:
        th = move-exception;
        String r111 = r10;
        b this = r17;
        th = th;
    L43:
        this.a("exportFile: readability probe failed", "exportFile: readability probe threw for '" + r111 + '\'', th);
        throw new com.obric.aiagent.skill.ovirt.api.a.a("File readability check failed", th, com.obric.aiagent.skill.ovirt.api.a.b.f20949d);
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r16);
        r111 = r14.a();
        String r112 = com.obric.aiagent.skill.ovirt.impl.a.a(r111);
        r8.f21130a = this;     // Catch: Throwable -> L42
        r8.f21131b = r111;     // Catch: Throwable -> L42
        r8.f21134e = 1;     // Catch: Throwable -> L42
        r16 = this.f21129b.getShellCapability$impl_release().a((com.obric.aiagent.skill.virt.api.x) ZeusTransformUtils.preCheckCast(r11.a(), com.obric.aiagent.skill.virt.api.x.class, "com.obric.aiagent.plugin"), "test -r " + r112 + " && test -f " + r112, 60000, "export_readability_probe", r8);     // Catch: Throwable -> L42
        if (r16 != r1) goto L22;
        return r1;
    L22:
        r17 = this;
        r10 = r111;
    L42:
        th = th;
    L7:
        r0 = new C0443b(this, r15);
        goto L8
    }

    private final com.obric.aiagent.skill.ovirt.api.a.b c(String r7) {
        Iterator r6 = d.n.m.d(o.f((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")), (d.h.a.b) ZeusTransformUtils.preCheckCast(d.f21139a, d.h.a.b.class, "com.obric.aiagent.plugin")).a();
    L3:
        Object r2 = null;
        if (r6.hasNext() == false) goto L8;
        Object r8 = r6.next();
        if (o.b((String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.aiagent.plugin"), "SKILL_ARCHIVE_ERROR:", false, 2, null) == false) goto L3;
        r2 = r8;
    L8:
        String r9 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L11;
        String r10 = o.a(r9, (CharSequence) ZeusTransformUtils.preCheckCast("SKILL_ARCHIVE_ERROR:", CharSequence.class, "com.obric.aiagent.plugin"));
        switch(r10.hashCode()) {
            case -1997941829: goto L58;
            case -1910805464: goto L54;
            case -1720541225: goto L50;
            case -1294743598: goto L46;
            case -813074659: goto L43;
            case -630838013: goto L39;
            case 453844792: goto L36;
            case 471195987: goto L32;
            case 836265863: goto L29;
            case 889325277: goto L26;
            case 1233671943: goto L23;
            case 1331820699: goto L20;
            case 2061055986: goto L16;
            default: goto L62;
        };
    L16:
        if (r10.equals("source_not_found") == false) goto L62;
        return com.obric.aiagent.skill.ovirt.api.a.b.f20950e;
    L20:
        if (r10.equals("reserved_entry") == false) goto L62;
    L71:
        return com.obric.aiagent.skill.ovirt.api.a.b.f;
    L23:
        if (r10.equals("source_not_absolute") == true) goto L71;
    L26:
        if (r10.equals("source_not_directory") == true) goto L71;
    L29:
        if (r10.equals("unsafe_directory_entry") == true) goto L71;
    L32:
        if (r10.equals("archive_too_large") == false) goto L62;
        return com.obric.aiagent.skill.ovirt.api.a.b.k;
    L36:
        if (r10.equals("source_outside_ovirt_roots") == true) goto L71;
    L39:
        if (r10.equals("entry_too_large") == false) goto L62;
        return com.obric.aiagent.skill.ovirt.api.a.b.i;
    L43:
        if (r10.equals("source_symlink") == true) goto L71;
    L46:
        if (r10.equals("file_changed_during_archive") == false) goto L62;
        return com.obric.aiagent.skill.ovirt.api.a.b.g;
    L50:
        if (r10.equals("package_too_large") == false) goto L62;
        return com.obric.aiagent.skill.ovirt.api.a.b.j;
    L54:
        if (r10.equals("unsafe_file_entry") == true) goto L71;
    L58:
        if (r10.equals("too_many_entries") == false) goto L62;
        return com.obric.aiagent.skill.ovirt.api.a.b.h;
    L62:
        return com.obric.aiagent.skill.ovirt.api.a.b.f20949d;
    L11:
        return com.obric.aiagent.skill.ovirt.api.a.b.f20949d;
    }

    private final com.obric.aiagent.skill.virt.api.c a(com.obric.aiagent.skill.ovirt.api.a.d r3) {
        com.obric.aiagent.skill.ovirt.api.a.d r2 = (com.obric.aiagent.skill.ovirt.api.a.d) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.aiagent.skill.ovirt.api.a.d.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(r2, com.obric.aiagent.skill.ovirt.api.a.d.a.f20954a) == false) goto L6;
        return (com.obric.aiagent.skill.virt.api.c) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.virt.api.c.a.f21558a, com.obric.aiagent.skill.virt.api.c.class, "com.obric.aiagent.plugin");
    L6:
        if (ZeusTransformUtils.instanceOf(r2, com.obric.aiagent.skill.ovirt.api.a.d.b.class) == false) goto L10;
        return (com.obric.aiagent.skill.virt.api.c) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.virt.api.c.b(((com.obric.aiagent.skill.ovirt.api.a.d.b) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.ovirt.api.a.d.b.class, "com.obric.aiagent.plugin")).a()), com.obric.aiagent.skill.virt.api.c.class, "com.obric.aiagent.plugin");
    L10:
        throw new d.k();
    }

    private final com.obric.aiagent.skill.virt.api.b a(com.obric.aiagent.skill.ovirt.api.a.c r3) {
        return new com.obric.aiagent.skill.virt.api.b(r3.a(), r3.b(), r3.c());
    }

    private final void a(String r2, String r3, Throwable r4) {
        if (IAppContext.Companion.isDebug() == false) goto L5;
        ILogDepend.Companion.e(TAG, r3, r4);
        return;
    L5:
        ILogDepend.Companion.e(TAG, r2);
    }

    static {
        f21127a = new a(null);
        f21128c = new SecureRandom();
    }
}
