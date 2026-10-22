package com.obric.autogui.util;

import android.content.ComponentName;
import android.content.Context;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aiagent.product.platform.api.notification.ObricToastShowListener;
import com.obric.aiagent.product.platform.api.notification.ToastShowInfo;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.AOPackagesTools;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.obric.autogui.common.api.platform.packages.appinfo.AppInfoEntry;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.common.api.space.OperatingSpaceManager;
import com.obric.autogui.common.api.space.RobotsScreenshotBlockReason;
import com.obric.autogui.common.api.space.status.SpaceStatus;
import com.obric.autogui.common.api.space.vd.VDSpace;
import com.obric.autogui.common.api.virtualdisplay.AutoActionVirtualDisplay;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.n;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
import os.teatracker.IBdInstall;

/* JADX INFO: compiled from: ToastSystemHintRecorder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {
    private static final String TAG = "ToastSystemHintRecorder";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f31557a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f31558b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final List<b> f31559c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static com.obric.autogui.session.a f31560d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f31561e;
    private static String f;
    private static final c g = null;

    /* JADX INFO: compiled from: ToastSystemHintRecorder.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f31562a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f31563b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f31564c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ComponentName f31565d;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f31562a, r6.f31562a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f31563b, r6.f31563b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f31564c, r6.f31564c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f31565d, r6.f31565d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            String r0 = this.f31562a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = ((((r2 * 31) + this.f31563b.hashCode()) * 31) + this.f31564c.hashCode()) * 31;
            ComponentName r4 = this.f31565d;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "PageInfo(packageName=" + this.f31562a + ", appName=" + this.f31563b + ", activityName=" + this.f31564c + ", component=" + this.f31565d + ')';
        }

        public a(String r2, String r3, String r4, ComponentName r5) {
            o.e(r3, "appName");
            o.e(r4, "activityName");
            this.f31562a = r2;
            this.f31563b = r3;
            this.f31564c = r4;
            this.f31565d = r5;
        }

        public final String a() {
            return this.f31563b;
        }

        public final String b() {
            return this.f31564c;
        }

        public final ComponentName c() {
            return this.f31565d;
        }
    }

    /* JADX INFO: compiled from: ToastSystemHintRecorder.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f31566a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f31567b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f31568c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f31569d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f31570e;
        private final String f;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f31566a, r6.f31566a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f31567b, r6.f31567b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f31568c, r6.f31568c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f31569d, r6.f31569d) == true) goto L21;
            return false;
        L21:
            if (o.a(this.f31570e, r6.f31570e) == true) goto L24;
            return false;
        L24:
            if (o.a(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            return (((((((((this.f31566a.hashCode() * 31) + this.f31567b.hashCode()) * 31) + this.f31568c.hashCode()) * 31) + this.f31569d.hashCode()) * 31) + this.f31570e.hashCode()) * 31) + this.f.hashCode();
        }

        public String toString() {
            return "ToastRecord(sessionId=" + this.f31566a + ", sessionKey=" + this.f31567b + ", type=" + this.f31568c + ", content=" + this.f31569d + ", appName=" + this.f31570e + ", activityName=" + this.f + ')';
        }

        public b(String r2, String r3, String r4, String r5, String r6, String r7) {
            o.e(r2, ObricMemoryConstants.KEY_SESSION_ID);
            o.e(r3, "sessionKey");
            o.e(r4, "type");
            o.e(r5, "content");
            o.e(r6, "appName");
            o.e(r7, "activityName");
            this.f31566a = r2;
            this.f31567b = r3;
            this.f31568c = r4;
            this.f31569d = r5;
            this.f31570e = r6;
            this.f = r7;
        }

        public final String a() {
            return this.f31566a;
        }

        public final String b() {
            return this.f31567b;
        }

        public final String getType() {
            return this.f31568c;
        }

        public final String c() {
            return this.f31569d;
        }

        public final String d() {
            return this.f31570e;
        }

        public final String e() {
            return this.f;
        }
    }

    /* JADX INFO: compiled from: ToastSystemHintRecorder.kt */
    public static final class c extends ObricToastShowListener {
        c() {
        }

        @Override // com.obric.aiagent.product.platform.api.notification.ObricToastShowListener
        public void onToastShown(ToastShowInfo r1) {
            o.e(r1, DBDefinition.SEGMENT_INFO);
            h.a(h.f31557a, r1);
        }
    }

    public static /* synthetic */ boolean lambda$6oe1zK6P_fjMDI2mcb3ikOUl2r0(com.obric.autogui.session.a r0, b r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$sEmK-DrQlSFSnJClr5fYgApOPAI, reason: not valid java name */
    public static /* synthetic */ boolean m919lambda$sEmKDrQlSFSnJClr5fYgApOPAI(com.obric.autogui.session.a r0, b r1) {
        return b(r0, r1);
    }

    private h() {
    }

    public static final /* synthetic */ void a(h r0, ToastShowInfo r1) {
        r0.a(r1);
    }

    static {
        f31557a = new h();
        f31558b = new Object();
        f31559c = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        g = new c();
    }

    public final void a(com.obric.autogui.session.a r7, String r8) {
        o.e(r7, SensitiveType.SESSION);
        if (com.obric.autogui.common.a.d.f28974a.i() == true) goto L7;
        c(r7, "[ToastHint] disabled on step start");
        return;
    L7:
        if (com.obric.autogui.common.a.d.f28974a.a(r8) == true) goto L10;
        c(r7, "[ToastHint] action not in whitelist on step start, actionType=" + r8);
        return;
    L10:
        Object r0 = f31558b;
        monitor-enter(r0);
        com.obric.autogui.session.a r1 = f31560d;     // Catch: Throwable -> L51
        boolean r2 = true;
        if (r1 != null) goto L15;
    L22:
        r2 = false;
    L23:
        f31560d = r7;     // Catch: Throwable -> L51
        if (r2 == true) goto L26;
        f31559c.clear();     // Catch: Throwable -> L51
        f = null;     // Catch: Throwable -> L51
    L26:
        x r9 = x.f38692a;     // Catch: Throwable -> L51
        monitor-exit(r0);
        if (f31561e == false) goto L56;
        Loog.INSTANCE.i(TAG, "[ToastHint] step start, already registered, actionType=" + r8);
        return;
    L56:
        n.a r10 = n.f38560a;     // Catch: Throwable -> L34
        h r6 = (h) ZeusTransformUtils.preCheckCast(this, h.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
        Object r11 = n.f(Boolean.valueOf(AOPlatformTools.INSTANCE.special().addToastShowListener((ObricToastShowListener) ZeusTransformUtils.preCheckCast(g, ObricToastShowListener.class, "com.obric.aiagent.plugin"))));     // Catch: Throwable -> L34
    L36:
        Throwable r12 = n.c(r11);
        if (r12 == null) goto L40;
        Loog.INSTANCE.e(TAG, "[ToastHint] register Toast listener failed", r12);
    L40:
        if (n.b(r11) == false) goto L42;
        r11 = false;
    L42:
        boolean r13 = ((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        Object r14 = f31558b;
        monitor-enter(r14);
        f31561e = r13;     // Catch: Throwable -> L48
        x r3 = x.f38692a;     // Catch: Throwable -> L48
        monitor-exit(r14);
        Loog.INSTANCE.i(TAG, "[ToastHint] step start, registered=" + r13 + ", actionType=" + r8);
        return;
    L48:
        th = move-exception;
        throw th;
    L34:
        th = move-exception;
        n.a r15 = n.f38560a;
        r11 = n.f(d.o.a(th));
        goto L36
    L15:
        if (o.a(r1.b(), r7.b()) == true) goto L17;
    L19:
        boolean r4 = false;
    L20:
        if (r4 != true) goto L22;
    L17:
        if (o.a(r1.a(), r7.a()) == false) goto L19;
        r4 = true;
    L51:
        th = move-exception;
        throw th;
    }

    public final void b(com.obric.autogui.session.a r3, String r4) {
        o.e(r3, SensitiveType.SESSION);
        o.e(r4, "reason");
        c(r3, "[ToastHint] " + r4);
    }

    public final String a(com.obric.autogui.session.a r2) {
        o.e(r2, SensitiveType.SESSION);
        String r1 = c(r2);
        f31557a.b(r2);
        return r1;
    }

    public final void b(com.obric.autogui.session.a r2) {
        o.e(r2, SensitiveType.SESSION);
        c(r2, "[ToastHint] session stop");
    }

    public final String c(com.obric.autogui.session.a r11) {
        o.e(r11, SensitiveType.SESSION);
        if (com.obric.autogui.common.a.d.f28974a.i() == true) goto L58;
        c(r11, "[ToastHint] disabled on drain");
        return null;
    L58:
        n.a r1 = n.f38560a;     // Catch: Throwable -> L8
        Object r2 = n.f(((h) ZeusTransformUtils.preCheckCast(this, h.class, "com.obric.aiagent.plugin")).d(r11));     // Catch: Throwable -> L8
    L10:
        Throwable r3 = n.c(r2);
        if (r3 != null) goto L55;
        a r4 = (a) ZeusTransformUtils.preCheckCast(r2, a.class, "com.obric.aiagent.plugin");
        n.a r5 = n.f38560a;     // Catch: Throwable -> L15
        Object r0 = n.f(Boolean.valueOf(((h) ZeusTransformUtils.preCheckCast(this, h.class, "com.obric.aiagent.plugin")).a(r11, r4)));     // Catch: Throwable -> L15
    L17:
        Throwable r6 = n.c(r0);
        if (r6 == null) goto L20;
        f31557a.e(r11);
        Loog.INSTANCE.e(TAG, "[ToastHint] drain skipped by sensitive check failure", r6);
        return null;
    L20:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r0, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L23;
        e(r11);
        Loog.INSTANCE.i(TAG, "[ToastHint] drain skipped by sensitive page");
        return null;
    L23:
        Object r7 = f31558b;
        monitor-enter(r7);
    L50:
        th = move-exception;
        throw th;
    L26:
        if (f31560d == r11) goto L28;
        List<b> r8 = p.b();     // Catch: Throwable -> L50
    L40:
        monitor-exit(r7);
        if (r8.isEmpty() == false) goto L44;
        return null;
    L44:
        a(r11, r8);
        JSONArray r10 = new JSONArray();
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L46:
        if (r12.hasNext() == false) goto L49;
        b r9 = (b) ZeusTransformUtils.preCheckCast(r12.next(), b.class, "com.obric.aiagent.plugin");
        JSONObject r13 = new JSONObject();
        r13.put("type", r9.getType());
        r13.put("content", r9.c());
        r10.put(r13);
        goto L46
    L49:
        return r10.toString();
    L28:
        int r14 = d.l.n.c(com.obric.autogui.common.a.d.f28974a.j(), 1);     // Catch: Throwable -> L50
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(f31559c, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L50
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L50
        Iterator r17 = r15.iterator();     // Catch: Throwable -> L50
    L30:
        if (r17.hasNext() == false) goto L39;
        Object r18 = r17.next();     // Catch: Throwable -> L50
        b r19 = (b) ZeusTransformUtils.preCheckCast(r18, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L50
        if (o.a(r19.a(), r11.b()) == true) goto L34;
    L36:
        boolean r20 = false;
    L37:
        if (r20 == false) goto L30;
        r16.add(r18);     // Catch: Throwable -> L50
        goto L30
    L34:
        if (o.a(r19.b(), r11.a()) == false) goto L36;
        r20 = true;
        goto L37
    L39:
        r8 = p.c((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), r14);     // Catch: Throwable -> L50
        f31559c.removeAll((Collection) ZeusTransformUtils.preCheckCast(p.q((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin")), Collection.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L50
    L15:
        th = move-exception;
        n.a r21 = n.f38560a;
        r0 = n.f(d.o.a(th));
        goto L17
    L55:
        f31557a.e(r11);
        Loog.INSTANCE.e(TAG, "[ToastHint] drain skipped by page resolve failure", r3);
        return null;
    L8:
        th = move-exception;
        n.a r22 = n.f38560a;
        r2 = n.f(d.o.a(th));
        goto L10
    }

    private final void a(ToastShowInfo r20) {
        if (com.obric.autogui.common.a.d.f28974a.i() == true) goto L6;
        c(null, "[ToastHint] disabled on callback");
        return;
    L6:
        com.obric.autogui.session.a r2 = f31560d;
        if (r2 != null) goto L9;
        return;
    L9:
        String r10 = a(r20.getContent());
        if (r10 != null) goto L47;
        return;
    L47:
        n.a r0 = n.f38560a;     // Catch: Throwable -> L14
        Object r1 = n.f(((h) ZeusTransformUtils.preCheckCast(this, h.class, "com.obric.aiagent.plugin")).d(r2));     // Catch: Throwable -> L14
    L16:
        Throwable r3 = n.c(r1);
        if (r3 != null) goto L43;
        a r4 = (a) ZeusTransformUtils.preCheckCast(r1, a.class, "com.obric.aiagent.plugin");
        if (a(r2, r4) == false) goto L22;
        Loog.INSTANCE.i(TAG, "[ToastHint] callback skipped by sensitive page");
        return;
    L22:
        b r5 = new b(r2.b(), r2.a(), "toast", r10, r4.a(), r4.b());
        Loog.INSTANCE.i(TAG, "record=" + r5 + "， info=" + r20);
        Object r6 = f31558b;
        monitor-enter(r6);
    L40:
        th = move-exception;
        throw th;
    L25:
        if (f31560d == r2) goto L29;
        monitor-exit(r6);
        return;
    L29:
        if (f31557a.b(r10) == false) goto L32;
        monitor-exit(r6);
        return;
    L32:
        int r7 = d.l.n.c(com.obric.autogui.common.a.d.f28974a.j(), 1);     // Catch: Throwable -> L40
        f31559c.add(r5);     // Catch: Throwable -> L40
    L33:
        List<b> r8 = f31559c;     // Catch: Throwable -> L40
        if (r8.size() <= r7) goto L36;
        r8.remove(0);     // Catch: Throwable -> L40
        goto L33
    L36:
        h r9 = f31557a;     // Catch: Throwable -> L40
        f = r10;     // Catch: Throwable -> L40
        monitor-exit(r6);
        IAutoActionTrackingApi r11 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r13 = new JSONObject();
        com.obric.autogui.session.c.b.a(r13, r2);
        r13.put("instruction_id", r2.b());
        r13.put(IBdInstall.PARAM_APP_NAME, r4.a());
        r13.put("activity_name", r4.b());
        r13.put("device_id", r2.R().a());
        r9.a(r13, r10);
        x r12 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r11, "obric_oauto_toast_tips", r13, false, false, null, 16, null);
        return;
    L43:
        Loog.INSTANCE.e(TAG, "[ToastHint] callback skipped by page resolve failure", r3);
        return;
    L14:
        th = move-exception;
        n.a r14 = n.f38560a;
        r1 = n.f(d.o.a(th));
        goto L16
    }

    private final String a(String r2) {
        String r1 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L10;
        return null;
    L10:
        return d.o.o.e(r1, d.l.n.c(com.obric.autogui.common.a.d.f28974a.k(), 1));
    L5:
        r3 = false;
        goto L6
    }

    private final boolean b(String r1) {
        return o.a(f, r1);
    }

    private final a d(com.obric.autogui.session.a r8) {
        n.a r2 = n.f38560a;     // Catch: Throwable -> L5
        h r3 = (h) ZeusTransformUtils.preCheckCast(this, h.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r4 = n.f(AutoActionVirtualDisplay.INSTANCE.fetchVdTopAppInfo());     // Catch: Throwable -> L5
    L7:
        String r5 = null;
        if (n.b(r4) == false) goto L10;
        r4 = null;
    L10:
        DisplayedAppInfo r6 = (DisplayedAppInfo) ZeusTransformUtils.preCheckCast(r4, DisplayedAppInfo.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L62;
        ComponentName r7 = r6.getTopActivity();
        if (r7 == null) goto L62;
    L22:
        if (r7 == null) goto L24;
        String r9 = r7.getPackageName();
    L25:
        if (r7 == null) goto L27;
        String r0 = r7.getClassName();
    L28:
        String r10 = "";
        if (r0 != null) goto L31;
        r0 = "";
    L31:
        if (r6 == null) goto L42;
        CharSequence r11 = r6.getTaskLabel();
        if (r11 == null) goto L42;
        String r12 = r11.toString();
        if (r12 == null) goto L42;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L40;
        r12 = null;
    L40:
        if (r12 == null) goto L42;
        r10 = r12;
    L59:
        return new a(r9, r10, r0, r7);
    L42:
        if (r9 == null) goto L53;
        AppInfoEntry r13 = AOPackagesTools.INSTANCE.getAppInfo((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r9);
        if (r13 == null) goto L48;
        CharSequence r14 = r13.getAppLabel();
        if (r14 == null) goto L48;
        String r15 = r14.toString();
    L49:
        if (r15 == null) goto L53;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L53;
        r5 = r15;
    L48:
        r15 = null;
    L53:
        if (r5 != null) goto L57;
        if (r9 == null) goto L59;
        r10 = r9;
        goto L59
    L57:
        r10 = r5;
        goto L59
    L27:
        r0 = null;
        goto L28
    L24:
        r9 = null;
    L62:
        n.a r16 = n.f38560a;     // Catch: Throwable -> L16
        h r17 = (h) ZeusTransformUtils.preCheckCast(this, h.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        Object r18 = n.f((ComponentName) ZeusTransformUtils.preCheckCast(AutoActionVirtualDisplay.INSTANCE.getVdTopComponent().a(), ComponentName.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L16
    L19:
        if (n.b(r18) == false) goto L21;
        r18 = null;
    L21:
        r7 = (ComponentName) ZeusTransformUtils.preCheckCast(r18, ComponentName.class, "com.obric.aiagent.plugin");
    L16:
        th = move-exception;
        n.a r1 = n.f38560a;
        r18 = n.f(d.o.a(th));
    L5:
        th = move-exception;
        n.a r19 = n.f38560a;
        r4 = n.f(d.o.a(th));
        goto L7
    }

    private final boolean a(com.obric.autogui.session.a r9, a r10) {
        n.a r2 = n.f38560a;     // Catch: Throwable -> L5
        h r3 = (h) ZeusTransformUtils.preCheckCast(this, h.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r4 = n.f(OperatingSpaceManager.INSTANCE.getActiveSpace());     // Catch: Throwable -> L5
    L7:
        Throwable r5 = n.c(r4);
        if (r5 != null) goto L52;
        AOOperatingSpace r6 = (AOOperatingSpace) ZeusTransformUtils.preCheckCast(r4, AOOperatingSpace.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L16;
        SpaceStatus r7 = r6.getSpaceStatus();
        if (r7 == null) goto L16;
        if (r7.isSecure() != true) goto L16;
        boolean r8 = true;
    L17:
        if (r8 == false) goto L19;
        return true;
    L19:
        ComponentName r11 = r10.c();
        RobotsScreenshotBlockReason r12 = null;
        if (ZeusTransformUtils.instanceOf(r6, VDSpace.class) == false) goto L22;
        VDSpace r13 = (VDSpace) ZeusTransformUtils.preCheckCast(r6, VDSpace.class, "com.obric.aiagent.plugin");
    L23:
        if (r13 != null) goto L54;
    L32:
        if (r13 == null) goto L34;
        r12 = r13.getRobotsScreenshotBlockReason();
    L34:
        if (r12 != null) goto L36;
    L38:
        if (r11 != null) goto L41;
        return true;
    L41:
        if (a(r11) == false) goto L58;
        return true;
    L58:
    L49:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "[ToastHint] sensitive page check failed", th);
        return true;
    L44:
        if (AOPlatformTools.INSTANCE.security().acquirePageOperationPolicy((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r11) != null) goto L60;
        if (AOPlatformTools.INSTANCE.security().acquireSensitiveOperation((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r11) == null) goto L61;
        return true;
    L61:
        return false;
    L60:
        return true;
    L36:
        if (r12 == RobotsScreenshotBlockReason.None) goto L38;
        return true;
    L54:
        n.a r14 = n.f38560a;     // Catch: Throwable -> L26
        h r0 = (h) ZeusTransformUtils.preCheckCast(this, h.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        r13.updateRobotsPolicyCache(r11);     // Catch: Throwable -> L26
        Object r1 = n.f(x.f38692a);     // Catch: Throwable -> L26
    L28:
        Throwable r15 = n.c(r1);
        if (r15 == null) goto L32;
        Loog.INSTANCE.e(TAG, "[ToastHint] update robots policy failed", r15);
        return true;
    L26:
        th = move-exception;
        n.a r16 = n.f38560a;
        r1 = n.f(d.o.a(th));
        goto L28
    L22:
        r13 = null;
    L16:
        r8 = false;
        goto L17
    L52:
        Loog.INSTANCE.e(TAG, "[ToastHint] get active space failed", r5);
        return true;
    L5:
        th = move-exception;
        n.a r17 = n.f38560a;
        r4 = n.f(d.o.a(th));
        goto L7
    }

    private final boolean a(ComponentName r7) {
        String r6 = r7.flattenToString();
        o.c(r6, "flattenToString(...)");
        String r8 = r6.toLowerCase(Locale.ROOT);
        o.c(r8, "toLowerCase(...)");
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("privacy", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L5;
    L12:
        return true;
    L5:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("permission", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == true) goto L12;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(SensitiveType.PASSWORD, CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == true) goto L12;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("payment", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == true) goto L12;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("security", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == true) goto L12;
        return false;
    }

    private final void a(com.obric.autogui.session.a r10, List<b> r11) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        b r12 = (b) ZeusTransformUtils.preCheckCast(p.k(r9), b.class, "com.obric.aiagent.plugin");
        IAutoActionTrackingApi r1 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r3 = new JSONObject();
        com.obric.autogui.session.c.b.a(r3, r10);
        r3.put("toast_count", r9.size());
        r3.put("instruction_id", r10.b());
        r3.put(IBdInstall.PARAM_APP_NAME, r12.d());
        r3.put("activity_name", r12.e());
        r3.put("device_id", r10.R().a());
        f31557a.a(r3, r12.c());
        x r13 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r1, "obric_oauto_toast_tips_extra", r3, false, false, null, 16, null);
    }

    private final void a(JSONObject r1, String r2) {
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L6;
        r1.put("content", r2);
        return;
    }

    private final void e(final com.obric.autogui.session.a r3) {
        Object r2 = f31558b;
        monitor-enter(r2);
        p.a(f31559c, new $$Lambda$h$6oe1zK6P_fjMDI2mcb3ikOUl2r0(r3));     // Catch: Throwable -> L10
        if (f31560d != r3) goto L7;
        f = null;     // Catch: Throwable -> L10
    L7:
        x r4 = x.f38692a;     // Catch: Throwable -> L10
        monitor-exit(r2);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private static final boolean a(com.obric.autogui.session.a r2, b r3) {
        o.e(r3, "it");
        if (o.a(r3.a(), r2.b()) == true) goto L5;
    L7:
        return false;
    L5:
        if (o.a(r3.b(), r2.a()) == false) goto L7;
        return true;
    }

    private final void c(final com.obric.autogui.session.a r5, String r6) {
        Object r0 = f31558b;
        monitor-enter(r0);
        boolean r1 = f31561e;     // Catch: Throwable -> L18
        if (r5 != null) goto L7;
    L10:
        f31560d = null;     // Catch: Throwable -> L18
        f31559c.clear();     // Catch: Throwable -> L18
        f = null;     // Catch: Throwable -> L18
        x r7 = x.f38692a;     // Catch: Throwable -> L18
    L11:
        monitor-exit(r0);
        a(r1);     // Catch: Throwable -> L15
        Loog.INSTANCE.i(TAG, r6 + ", registered=" + f31561e);
        return;
    L15:
        th = move-exception;
        Loog.INSTANCE.i(TAG, r6 + ", registered=" + f31561e);
        throw th;
    L7:
        if (f31560d == r5) goto L10;
        Boolean.valueOf(p.a(f31559c, new $$Lambda$h$sEmKDrQlSFSnJClr5fYgApOPAI(r5)));     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    private static final boolean b(com.obric.autogui.session.a r2, b r3) {
        o.e(r3, "it");
        if (o.a(r3.a(), r2.b()) == true) goto L5;
    L7:
        return false;
    L5:
        if (o.a(r3.b(), r2.a()) == false) goto L7;
        return true;
    }

    private final void a(boolean r4) {
        if (r4 == true) goto L28;
        return;
    L28:
        n.a r5 = n.f38560a;     // Catch: Throwable -> L6
        h r3 = (h) ZeusTransformUtils.preCheckCast(this, h.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        Object r6 = n.f(Boolean.valueOf(AOPlatformTools.INSTANCE.special().removeToastShowListener((ObricToastShowListener) ZeusTransformUtils.preCheckCast(g, ObricToastShowListener.class, "com.obric.aiagent.plugin"))));     // Catch: Throwable -> L6
    L8:
        Throwable r7 = n.c(r6);
        if (r7 == null) goto L12;
        Loog.INSTANCE.e(TAG, "[ToastHint] unregister Toast listener failed", r7);
    L12:
        if (n.b(r6) == false) goto L14;
        r6 = false;
    L14:
        boolean r8 = ((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        Object r0 = f31558b;
        monitor-enter(r0);
        if (r8 == true) goto L26;
    L18:
        x r9 = x.f38692a;     // Catch: Throwable -> L23
        monitor-exit(r0);
        if (r8 == true) goto L30;
        Loog.INSTANCE.e(TAG, "[ToastHint] unregister Toast listener returned false");
        return;
    L30:
        return;
    L23:
        th = move-exception;
        throw th;
    L26:
        f31561e = false;     // Catch: Throwable -> L23
    L6:
        th = move-exception;
        n.a r10 = n.f38560a;
        r6 = n.f(d.o.a(th));
        goto L8
    }
}
