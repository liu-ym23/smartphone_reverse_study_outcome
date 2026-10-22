package com.obric.autogui.agents.vlm.cocreation;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.cocreation.IOmniLabelingDataSink;
import com.obric.autogui.common.api.cocreation.OmniLabelingUserStopRecord;
import com.obric.autogui.common.api.logging.Loog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.n;
import d.x;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: OmniLabelingStopRecorder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final String TAG = "OmniLabelingStopRecorder";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f27230a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final LinkedHashSet<String> f27231b = null;

    private a() {
    }

    static {
        f27230a = new a();
        f27231b = new LinkedHashSet();
    }

    public static /* synthetic */ void a(a r0, com.obric.autogui.session.a r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.a(r1, r2);
    }

    public final void a(com.obric.autogui.session.a r20, String r21) {
        String r2 = r21;
        o.e(r20, SensitiveType.SESSION);
        if (r20.c() == true) goto L5;
        return;
    L5:
        String r3 = r20.b();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L9;
        r3 = null;
    L9:
        if (r3 != null) goto L11;
        r3 = r20.a();
    L11:
        String r4 = r20.l().getRepresentativeTaskString();
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L14;
    L49:
        Loog.INSTANCE.w(TAG, "skip invalid user stop recordId=" + r3 + ", userQueryLength=" + r4.length());
        return;
    L14:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L49;
        if (a(r3) == true) goto L20;
        Loog.INSTANCE.i(TAG, "skip duplicated user stop recordId=" + r3);
        return;
    L20:
        if (r2 != null) goto L22;
    L26:
        r2 = "user_termination";
    L27:
        String r13 = c.f27232a.a(r20);
        n.a r8 = n.f38560a;     // Catch: Throwable -> L42
        a r0 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L42
        IOmniLabelingDataSink r5 = (IOmniLabelingDataSink) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IOmniLabelingDataSink.class), IOmniLabelingDataSink.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L42
        if (r5 != null) goto L54;
        Loog.INSTANCE.w(TAG, "data sink missing for user stop, recordId=" + r3);     // Catch: Throwable -> L42
        r0.b(r3);     // Catch: Throwable -> L42
        String r1 = TAG;
    L36:
        Object r6 = n.f(x.f38692a);     // Catch: Throwable -> L38
    L45:
        Throwable r7 = n.c(r6);
        if (r7 == null) goto L56;
        f27230a.b(r3);
        Loog.INSTANCE.w(r1, "failed to dispatch user stop, recordId=" + r3 + ", error=" + r7.getMessage());
        return;
    L56:
        return;
    L38:
        th = th;
    L44:
        n.a r9 = n.f38560a;
        r6 = n.f(d.o.a(th));
        goto L45
    L54:
        r5.onUserStopped(new OmniLabelingUserStopRecord(r3, r20.e().getTime(), r4, AOSystemTools.INSTANCE.nowTimeMillis(), r2, r13));     // Catch: Throwable -> L40
        Loog r10 = Loog.INSTANCE;     // Catch: Throwable -> L40
        String r11 = "dispatch user stop recordId=" + r3 + ", sessionId=" + r20.b() + ", sessionKey=" + r20.a() + ", createdAt=" + r20.e().getTime() + ", reason=" + r2 + ", taskTriggerType=" + r13 + ", query=" + a(r0, r4, 0, 1, null);     // Catch: Throwable -> L40
        r1 = TAG;
        r10.i(r1, r11);     // Catch: Throwable -> L38
    L40:
        th = th;
        r1 = TAG;
    L42:
        th = th;
        r1 = TAG;
        goto L44
    L22:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L25;
        r2 = null;
    L25:
        if (r2 != null) goto L27;
        goto L26
    }

    private final boolean a(String r3) {
        LinkedHashSet<String> r2 = f27231b;
        monitor-enter(r2);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (r2.add(r3) == true) goto L7;
        boolean r4 = false;
    L15:
        monitor-exit(r2);
        return r4;
    L7:
        LinkedHashSet<String> r5 = f27231b;     // Catch: Throwable -> L17
        if (r5.size() <= 64) goto L14;
        Iterator<String> r6 = r5.iterator();     // Catch: Throwable -> L17
        o.c(r6, "iterator(...)");     // Catch: Throwable -> L17
        if (r6.hasNext() == false) goto L14;
        r6.next();     // Catch: Throwable -> L17
        r6.remove();     // Catch: Throwable -> L17
    L14:
        r4 = true;
        goto L15
    }

    private final void b(String r1) {
        LinkedHashSet<String> r0 = f27231b;
        monitor-enter(r0);
        r0.remove(r1);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ String a(a r0, String r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r2 = 96;
    L6:
        return r0.a(r1, r2);
    }

    private final String a(String r7, int r8) {
        String r6 = d.o.o.a(r7, "\n", "\\n", false, 4, null);
        if (r6.length() > r8) goto L6;
        return r6;
    L6:
        return d.o.o.e(r6, r8) + "...";
    }
}
