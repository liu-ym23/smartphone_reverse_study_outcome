package com.obric.autogui.session.a;

import android.content.Context;
import com.bytedance.applog.et_verify.BuildConfig;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.autogui.common.api.AOFileUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: AOLocalJournalImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public class c implements com.obric.autogui.session.a.d {
    private static final String TAG = "[StepRecorder]";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f30720a = null;
    private static final SimpleDateFormat j = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f30721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.autogui.session.a f30722c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f30723d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private File f30724e;
    private JsonObject f;
    private final JsonArray g;
    private int h;
    private boolean i;

    /* JADX INFO: compiled from: AOLocalJournalImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final File a() {
            return new File(AOFileUtil.INSTANCE.getWritableAppDir(), "journal");
        }

        private final String c(String r2) {
            return "k_" + r2;
        }

        public final File a(String r2) {
            o.e(r2, "sessionKey");
            return new File(a(), c(r2));
        }

        public final File a(String r5, String r6) {
            o.e(r6, "sessionKey");
            File r0 = a();
            String r4 = c(r6);
            CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
            if (r7 != null) goto L5;
        L8:
            boolean r8 = true;
        L9:
            if (r8 == true) goto L12;
            return new File(new File(r0, "id_" + r5), r4);
        L12:
            return new File(r0, r4);
        L5:
            if (d.o.o.d(r7) == true) goto L8;
            r8 = false;
            goto L9
        }

        public final File a(com.obric.autogui.session.a r5) {
            o.e(r5, SensitiveType.SESSION);
            File r0 = a();
            String r4 = c(r5.a());
            String r1 = r5.b();
            if (r5.c() == false) goto L8;
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L8;
            return new File(new File(r0, "id_" + r1), r4);
        L8:
            return new File(r0, r4);
        }

        public final File a(File r2) {
            o.e(r2, "journalDir");
            return new File(r2, "omni_upload_logs");
        }

        public final File b(String r2) {
            o.e(r2, "sessionKey");
            return a(a(r2));
        }

        public final File b(String r2, String r3) {
            o.e(r3, "sessionKey");
            return a(a(r2, r3));
        }

        public final File b(com.obric.autogui.session.a r2) {
            o.e(r2, SensitiveType.SESSION);
            return a(a(r2));
        }

        public final com.obric.autogui.common.d<File> c(com.obric.autogui.session.a r5) {
            o.e(r5, SensitiveType.SESSION);
            File r4 = a(r5);
            if (r4.exists() == true) goto L5;
        L19:
            boolean r6 = r4.mkdirs();     // Catch: Throwable -> L12
        L14:
            if (r6 == true) goto L18;
            String r7 = "cannot make journal directory under `" + r4 + "`.";
            Loog.INSTANCE.e(c.TAG, r7 + " exists=" + r4.exists() + ", canWrite=" + r4.canWrite() + ", isDir=" + r4.isDirectory());
            return com.obric.autogui.common.d.f29012a.a(r7);
        L18:
            return com.obric.autogui.common.d.f29012a.a(r4);
        L12:
            th = move-exception;
            Loog.INSTANCE.e(c.TAG, "mkdir failed.", th);
            r6 = false;
            goto L14
        L5:
            if (r4.isDirectory() == false) goto L19;
            if (r4.canWrite() == false) goto L19;
            return com.obric.autogui.common.d.f29012a.a(r4);
        }
    }

    /* JADX INFO: compiled from: AOLocalJournalImpl.kt */
    @f(b = "AOLocalJournalImpl.kt", c = {BuildConfig.VERSION_CODE}, d = "invokeSuspend", e = "com.obric.autogui.session.journal.AOLocalJournalImpl$saveStepJournal$2")
    static final class b extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30725a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f30726b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f30727c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ JsonObject f30728d;

        b(c r3, String r4, JsonObject r5, d.c.d<? super b> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30726b = r3;
            this.f30727c = r4;
            this.f30728d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f30726b, this.f30727c, this.f30728d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f30725a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            c r8 = this.f30726b;
            String r2 = this.f30727c;
            String r3 = com.obric.autogui.util.b.f31495a.a(this.f30728d);
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30725a = 1;
            if (c.a(r8, r2, r3, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.session.a.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AOLocalJournalImpl.kt */
    @f(b = "AOLocalJournalImpl.kt", c = {289}, d = "saveString", e = "com.obric.autogui.session.journal.AOLocalJournalImpl")
    static final class C0833c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f30729a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f30730b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f30731c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f30732d;

        C0833c(c r3, d.c.d<? super C0833c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30731c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f30730b = r3;
            this.f30732d |= Integer.MIN_VALUE;
            return c.a(this.f30731c, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AOLocalJournalImpl.kt */
    @f(b = "AOLocalJournalImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.session.journal.AOLocalJournalImpl$saveString$2")
    static final class d extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30733a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ File f30734b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f30735c;

        d(File r3, String r4, d.c.d<? super d> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30734b = r3;
            this.f30735c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f30734b, this.f30735c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f30733a != 0) goto L14;
            d.o.a(r4);
            Closeable r5 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(this.f30734b), Closeable.class, "com.obric.aiagent.plugin");
            String r3 = this.f30735c;
            FileOutputStream r1 = (FileOutputStream) ZeusTransformUtils.preCheckCast(r5, FileOutputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
            byte[] r6 = r3.getBytes(d.o.d.f38623b);     // Catch: Throwable -> L8
            o.c(r6, "getBytes(...)");     // Catch: Throwable -> L8
            r1.write(r6);     // Catch: Throwable -> L8
            x r7 = x.f38692a;     // Catch: Throwable -> L8
            d.f.c.a(r5, null);
            return x.f38692a;
        L8:
            th = move-exception;
            throw th;     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            d.f.c.a(r5, th);
            throw th;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AOLocalJournalImpl.kt */
    @f(b = "AOLocalJournalImpl.kt", c = {336}, d = "saveTaskJournal$suspendImpl", e = "com.obric.autogui.session.journal.AOLocalJournalImpl")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f30736a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f30737b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f30738c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f30739d;

        e(c r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30738c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f30737b = r3;
            this.f30739d |= Integer.MIN_VALUE;
            return c.b(this.f30738c, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    @Override // com.obric.autogui.session.a.d
    public Object a(d.c.d<? super com.obric.autogui.session.a.d> r3) {
        return a(this, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.session.a.d
    public Object b(d.c.d<? super com.obric.autogui.session.a.d> r3) {
        return b(this, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(c r2, String r3, String r4, d.c.d r5) {
        return r2.a(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public c(Context r3, com.obric.autogui.session.a r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r4, "targetSession");
        this.f30721b = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
        this.f30722c = r4;
        this.f = new JsonObject();
        this.g = new JsonArray();
    }

    public final Context getContext() {
        return this.f30721b;
    }

    static {
        f30720a = new a(null);
        j = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    }

    private final void c() {
        com.obric.autogui.common.d<File> r0 = d();
        File r1 = (File) ZeusTransformUtils.preCheckCast(r0.a(), File.class, "com.obric.aiagent.plugin");
        if (r0.g() == false) goto L19;
        if (r1 == null) goto L19;
        if (this.i == false) goto L15;
        File r2 = new File(r1, "step-" + this.h);
        if (r2.exists() == false) goto L11;
    L14:
        r1 = r2;
        goto L15
    L11:
        if (r2.mkdirs() == true) goto L14;
        Loog.INSTANCE.e(TAG, "init journal failed for STEP#" + this.h + ", session=" + this.f30722c + " because of an IO error.");
        return;
    L15:
        this.f30724e = r1;
        this.f30723d = true;
        Loog.INSTANCE.d(TAG, "[Step #" + this.h + "] initialized journal, s=" + this.f30722c);
        if (com.obric.autogui.common.b.b.f29001a.a() == false) goto L21;
        Loog.INSTANCE.d(TAG, "[Step #" + this.h + "] journal dir=" + r1.getAbsolutePath() + " (stwj=" + this.i + ')');
        return;
    L21:
        return;
    L19:
        Loog.INSTANCE.e(TAG, "init journal failed for session=" + this.f30722c + " because of an IO error.");
    }

    private final com.obric.autogui.common.d<File> d() {
        return f30720a.c(this.f30722c);
    }

    @Override // com.obric.autogui.session.a.d
    public int a() {
        return this.h;
    }

    @Override // com.obric.autogui.session.a.d
    public void a(int r1) {
        this.h = r1;
        c();
    }

    @Override // com.obric.autogui.session.a.d
    public com.obric.autogui.session.a.d a(JsonObject r4) {
        o.e(r4, "jsonObj");
        if (this.f30723d == true) goto L5;
        Loog.INSTANCE.d(TAG, "- JSON object not saved because the journal dir is not initialized.");
    L5:
        this.g.add((JsonElement) ZeusTransformUtils.preCheckCast(r4, JsonElement.class, "com.obric.aiagent.plugin"));
        return (com.obric.autogui.session.a.d) ZeusTransformUtils.preCheckCast(this, com.obric.autogui.session.a.d.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.session.a.d
    public com.obric.autogui.session.a.d a(String r2, JsonElement r3) {
        o.e(r2, "key");
        o.e(r3, "journal");
        this.f.add(r2, r3);
        return (com.obric.autogui.session.a.d) ZeusTransformUtils.preCheckCast(this, com.obric.autogui.session.a.d.class, "com.obric.aiagent.plugin");
    }

    private final Object a(String r9, String r10, d.c.d<? super x> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, C0833c.class) == false) goto L7;
        C0833c r0 = (C0833c) ZeusTransformUtils.preCheckCast(r12, C0833c.class, "com.obric.aiagent.plugin");
        if ((r0.f30732d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f30732d -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.f30730b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f30732d;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        c this = (c) ZeusTransformUtils.preCheckCast(r0.f30729a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r13);     // Catch: IOException -> L14
    L26:
        Loog.INSTANCE.d(TAG, " - [SUCCESS (at-step=" + this.h + ")] log saved.");     // Catch: IOException -> L14
    L30:
        return x.f38692a;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r13);
        File r14 = e();
        if (r14 != null) goto L22;
        Loog.INSTANCE.d(TAG, "cannot save journal file because the journal dir is not initialized.");
        return x.f38692a;
    L22:
        File r4 = new File(r14, r9);
        AOThreadingTools r15 = AOThreadingTools.INSTANCE;     // Catch: IOException -> L14
        m r16 = (m) ZeusTransformUtils.preCheckCast(new d(r4, r10, null), m.class, "com.obric.aiagent.plugin");     // Catch: IOException -> L14
        r0.f30729a = this;     // Catch: IOException -> L14
        r0.f30732d = 1;     // Catch: IOException -> L14
        if (r15.runIO(r16, r0) != r2) goto L26;
        return r2;
    L14:
        e = move-exception;
        Loog.INSTANCE.e(TAG, " - [SUCCESS (at-step=" + this.h + ")] failed to save journal file.", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L7:
        r0 = new C0833c(this, r12);
        goto L8
    }

    static /* synthetic */ Object a(c r5, d.c.d<? super com.obric.autogui.session.a.d> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (r5.f30723d == true) goto L7;
        Loog.INSTANCE.d(TAG, "cannot save an uninitialized journal.");
        return r5;
    L7:
        if (r5.f.size() != 0) goto L9;
        return r5;
    L9:
        String r8 = String.format("%03d", Arrays.copyOf(new Object[]{d.c.b.a.b.a(r5.h)}, 1));
        o.c(r8, "format(...)");
        JsonObject r0 = r5.f;
        r5.f = new JsonObject();
        AOThreadingTools.INSTANCE.launchIOJob((m) ZeusTransformUtils.preCheckCast(new b(r5, r8 + "_00_journal.json", r0, null), m.class, "com.obric.aiagent.plugin"));
        return r5;
    }

    static /* synthetic */ Object b(c r6, d.c.d<? super com.obric.autogui.session.a.d> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, e.class) == false) goto L7;
        e r0 = (e) ZeusTransformUtils.preCheckCast(r8, e.class, "com.obric.aiagent.plugin");
        if ((r0.f30739d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f30739d -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.f30737b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f30739d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r6 = (c) ZeusTransformUtils.preCheckCast(r0.f30736a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r9);
    L22:
        if (com.obric.autogui.common.b.b.f29001a.a() == false) goto L28;
        Loog r10 = Loog.INSTANCE;
        StringBuilder r1 = new StringBuilder().append("[SUCCESS] task journal saved to ");
        File r4 = r6.f30724e;
        if (r4 == null) goto L26;
        String r5 = r4.getAbsolutePath();
    L27:
        r10.d(TAG, r1.append(r5).toString());
    L29:
        return r6;
    L26:
        r5 = null;
        goto L27
    L28:
        Loog.INSTANCE.i(TAG, "[SUCCESS] task journal saved. ses=" + r6.f30722c.a() + '/' + r6.f30722c.b());
        goto L29
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r9);
        if (r6.f30723d == true) goto L18;
        Loog.INSTANCE.d(TAG, "cannot save an uninitialized journal.");
        return r6;
    L18:
        String r11 = com.obric.autogui.util.b.f31495a.a(r6.g);
        r0.f30736a = r6;
        r0.f30739d = 1;
        if (r6.a("log_json_file.json", r11, r0) != r2) goto L22;
        return r2;
    L7:
        r0 = new e(r6, r8);
        goto L8
    }

    @Override // com.obric.autogui.session.a.d
    public File b() {
        return this.f30724e;
    }

    private final File e() {
        File r0 = this.f30724e;
        if (r0 != null) goto L7;
        return null;
    L7:
        if (this.f30722c.c() == false) goto L13;
        r0 = f30720a.a(r0);
        if (r0.exists() == true) goto L13;
        if (r0.mkdirs() == true) goto L13;
        Loog.INSTANCE.w(TAG, "cannot make omni upload log dir, dir=" + r0.getAbsolutePath());
    L13:
        return r0;
    }
}
