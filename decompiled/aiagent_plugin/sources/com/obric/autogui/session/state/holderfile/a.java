package com.obric.autogui.session.state.holderfile;

import android.os.Bundle;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.autogui.common.api.AOFileUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.d;
import com.obric.autogui.util.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f.k;
import d.h.a.m;
import d.h.b.c;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.io.File;
import java.util.Iterator;

/* JADX INFO: compiled from: SessionStateHolderFile.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final String TAG = "Ses-SHF";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0858a f31409a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private File f31410b;

    /* JADX INFO: renamed from: com.obric.autogui.session.state.holderfile.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SessionStateHolderFile.kt */
    public static final class C0858a {
        public /* synthetic */ C0858a(h r1) {
            this();
        }

        private C0858a() {
        }

        public static final /* synthetic */ d a(C0858a r0) {
            return r0.b();
        }

        public final File a() {
            return new File(AOFileUtil.INSTANCE.getWritableAppDir(), "SHFs");
        }

        private final d<File> b() {
            File r4 = a();
            if (r4.exists() == true) goto L5;
        L19:
            boolean r1 = r4.mkdirs();     // Catch: Throwable -> L12
        L14:
            if (r1 == true) goto L18;
            Loog.INSTANCE.e(a.TAG, "cannot write to SHF dir `" + r4 + "`; exists=" + r4.exists() + ", canWrite=" + r4.canWrite() + ", isDir=" + r4.isDirectory());
            return d.f29012a.a("SHF directory under `" + r4 + "` is either a file or cannot be written.");
        L18:
            return d.f29012a.a(r4);
        L12:
            th = move-exception;
            Loog.INSTANCE.e(a.TAG, "mkdir failed.", th);
            r1 = false;
            goto L14
        L5:
            if (r4.isDirectory() == false) goto L19;
            if (r4.canWrite() == false) goto L19;
            return d.f29012a.a(r4);
        }

        public final void a(m<? super SHF, ? super File, x> r9) {
            m r10 = (m) ZeusTransformUtils.wrapperContextForParams(r9, m.class, "com.obric.aiagent.plugin");
            o.e(r10, "consumer");
            d<File> r8 = b();
            if (r8.g() == true) goto L6;
            Loog.INSTANCE.e(a.TAG, "cannot acquire SHF dir because of an IO error: " + r8);
            return;
        L6:
            File r11 = r8.a();
            o.a(r11);
            File r12 = (File) ZeusTransformUtils.preCheckCast(r11, File.class, "com.obric.aiagent.plugin");
            File[] r0 = r12.listFiles();
            if (r0 != null) goto L11;
            Loog.INSTANCE.e(a.TAG, "cannot list SHF files under `" + r12.getAbsolutePath() + "`.");
            return;
        L11:
            if (r0.length != 0) goto L13;
            boolean r4 = true;
        L14:
            if (r4 == false) goto L17;
            Loog.INSTANCE.d(a.TAG, " - no SHF files under `" + r12.getAbsolutePath() + "`.");
            return;
        L17:
            Iterator r13 = c.a(r0);
        L19:
            if (r13.hasNext() == false) goto L27;
            File r1 = (File) ZeusTransformUtils.preCheckCast(r13.next(), File.class, "com.obric.aiagent.plugin");
            o.a(r1);     // Catch: Throwable -> L25
            String r3 = k.a(r1, null, 1, null);     // Catch: Throwable -> L25
            Loog.INSTANCE.d(a.TAG, "found SHF under `" + r1.getAbsolutePath() + "` with content=" + r3);     // Catch: Throwable -> L25
            SHF r5 = (SHF) ZeusTransformUtils.preCheckCast(b.f31495a.a().fromJson(r3, SHF.class), SHF.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
            if (r5 == null) goto L19;
            r10.invoke(r5, r1);     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            Loog.INSTANCE.e(a.TAG, "failed to read SHF file: " + r1.getAbsolutePath(), th);
            goto L19
        L27:
            return;
        L13:
            r4 = false;
            goto L14
        }
    }

    static {
        f31409a = new C0858a(null);
    }

    public a() {
    }

    public final void a(com.obric.autogui.session.a r7) {
        o.e(r7, SensitiveType.SESSION);
        if (r7.c() == false) goto L5;
        return;
    L5:
        String r0 = r7.b();
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L10;
        Loog.INSTANCE.e(TAG, "please create SHF for a session without SessionId.");
        return;
    L10:
        if (this.f31410b == null) goto L17;
        Loog r8 = Loog.INSTANCE;
        StringBuilder r1 = new StringBuilder().append("SHF is already initialized at: ");
        File r6 = this.f31410b;
        if (r6 == null) goto L14;
        String r9 = r6.getAbsolutePath();
    L15:
        r8.w(TAG, r1.append(r9).toString());
        return;
    L14:
        r9 = null;
        goto L15
    L17:
        d r2 = C0858a.a(f31409a);
        if (r2.g() == true) goto L21;
        Loog.INSTANCE.e(TAG, "cannot acquire SHF dir for session=" + r0 + " because of an IO error.");
        return;
    L21:
        File r4 = new File((File) ZeusTransformUtils.preCheckCast(r2.a(), File.class, "com.obric.aiagent.plugin"), b(r7));
        if (r4.exists() == false) goto L30;
    L28:
        this.f31410b = r4;
        c(r7);
        Loog.INSTANCE.d(TAG, "initialized SHF under `" + r4.getAbsolutePath() + '`');
        return;
    L30:
        r4.createNewFile();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "failed to create SHF file for session=" + r0 + " under " + r4.getAbsolutePath(), th);
    }

    private final String b(com.obric.autogui.session.a r2) {
        return "aoses-" + r2.b() + ".shf";
    }

    private final void c(com.obric.autogui.session.a r12) {
        File r11 = this.f31410b;
        if (r11 != null) goto L6;
        Loog.INSTANCE.e(TAG, "SHF is not initialized.");
        return;
    L6:
        String r2 = r12.b();
        String r3 = r12.a();
        int r4 = r12.l().getLaunchOrigin();
        String r1 = r12.l().getUserTask();
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        String r5 = r1;
        Bundle r6 = r12.l().getTaskExtras();
        if (r6 == null) goto L12;
        Long r7 = Long.valueOf(r6.getLong("doubao_message_id"));
    L13:
        String r13 = b.f31495a.a().toJson(new SHF(r2, r3, r4, r5, r7, r12.R().a(), null));
        o.a(r13);     // Catch: Throwable -> L16
        k.a(r11, r13, null, 2, null);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "failed to write SessionId into SHF file: " + r11.getAbsolutePath(), th);
        return;
    L12:
        r7 = null;
        goto L13
    }

    public final void delete() {
        File r0 = this.f31410b;
        if (r0 != null) goto L12;
        Loog.INSTANCE.e(TAG, "SHF is not initialized.");
        return;
    L12:
        r0.delete();     // Catch: Throwable -> L9
        this.f31410b = null;
        Loog.INSTANCE.d(TAG, "deleted SHF file: " + r0.getAbsolutePath());
        return;
    L9:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "failed to delete SHF file: " + r0.getAbsolutePath(), th);
    }
}
