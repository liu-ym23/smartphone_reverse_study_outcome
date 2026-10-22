package com.obric.autogui.resourcemanage;

import android.content.Context;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: compiled from: DefaultResourceInstaller.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements t {
    private static final String TAG = "resource_downloader";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0829a f30586a = null;

    /* JADX INFO: renamed from: com.obric.autogui.resourcemanage.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DefaultResourceInstaller.kt */
    public static final class C0829a {
        public /* synthetic */ C0829a(d.h.b.h r1) {
            this();
        }

        private C0829a() {
        }
    }

    static {
        f30586a = new C0829a(null);
    }

    public a() {
    }

    @Override // com.obric.autogui.resourcemanage.t
    public boolean a(Context r23, o r24, File r25, p r26, d.h.a.m<? super o, ? super File, d.x> r27, d.h.a.m<? super o, ? super File, d.x> r28, boolean r29) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r23, Context.class, "com.obric.aiagent.plugin");
        d.h.a.m r5 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r27, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.a.m r4 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r28, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "context");
        d.h.b.o.e(r24, "description");
        d.h.b.o.e(r25, "zipFile");
        d.h.b.o.e(r26, "config");
        if (r25.exists() == false) goto L5;
        long r9 = System.currentTimeMillis();
        boolean r6 = aj.f30612a.a(r25, r24.b());
        ah.f30609a.a(r24.g(), System.currentTimeMillis() - r9, r6);
        if (r6 == false) goto L11;
        File r7 = r24.b(d.f30616a.a(r3, r26));
        o r10 = d.f30616a.a(r24.d());
        if (r10 == null) goto L18;
        String r11 = r10.f();
    L19:
        boolean r12 = !d.h.b.o.a(r11, r24.f());
        if (r29 == true) goto L22;
    L51:
        long r14 = System.currentTimeMillis();
        boolean r1 = ai.f30611a.a(r25, r7, r26.e());
        ah.f30609a.a(r24.g(), System.currentTimeMillis() - r14, r1, r26.e());
        if (r1 == false) goto L54;
        d.f30616a.a(r3, r24, r26);
        if (r12 == true) goto L60;
    L68:
        if (r5 == null) goto L72;
        r5.invoke(r24, r7);
        return true;
    L72:
        return true;
    L60:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L66;
        Loog r2 = Loog.INSTANCE;
        StringBuilder r8 = new StringBuilder().append("onResourceUpdate: version changed, old=");
        if (r10 == null) goto L64;
        String r13 = r10.f();
    L65:
        r2.d(TAG, r8.append(r13).append(", new=").append(r24.f()).toString());
        goto L66
    L64:
        r13 = null;
    L66:
        if (r4 == null) goto L68;
        r4.invoke(r24, r7);
        goto L68
    L54:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L56;
        Loog.INSTANCE.d(TAG, "handleDownloadSuccess: unzip failed.");
    L56:
        return false;
    L22:
        if (r7.isDirectory() == false) goto L51;
        String[] r15 = r7.list();
        if (r15 != null) goto L26;
    L32:
        boolean r16 = false;
    L33:
        if (r16 == false) goto L51;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L37;
        Loog.INSTANCE.d(TAG, "handleDownloadSuccess: installDir already populated, skip unzip: " + r7.getAbsolutePath());
    L37:
        ah.f30609a.a(r24.g(), 0, true, r26.e());
        d.f30616a.a(r3, r24, r26);
        if (r5 == null) goto L40;
        r5.invoke(r24, r7);
    L40:
        if (r12 == true) goto L42;
    L50:
        return true;
    L42:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L48;
        Loog r17 = Loog.INSTANCE;
        StringBuilder r18 = new StringBuilder().append("onResourceUpdate: version changed (skip unzip), old=");
        if (r10 == null) goto L46;
        String r19 = r10.f();
    L47:
        r17.d(TAG, r18.append(r19).append(", new=").append(r24.f()).toString());
        goto L48
    L46:
        r19 = null;
    L48:
        if (r4 == null) goto L50;
        r4.invoke(r24, r7);
        goto L50
    L26:
        if (r15.length != 0) goto L28;
        boolean r110 = true;
    L30:
        if ((!r110) != true) goto L32;
        r16 = true;
        goto L33
    L28:
        r110 = false;
        goto L30
    L18:
        r11 = null;
        goto L19
    L11:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L13;
        Loog.INSTANCE.d(TAG, "handleDownloadSuccess: verify zip failed, delete it.");
    L13:
        r25.delete();
        return false;
    L5:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L7;
        Loog.INSTANCE.d(TAG, "handleDownloadSuccess: zipFile not exist: " + r25.getAbsolutePath());
    L7:
        return false;
    }
}
