package com.obric.autoaction.vdplayer.legacy.c;

import android.content.ComponentName;
import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.autogui.vdplayer.api.fws.IPlatformTools;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.x;
import org.json.JSONObject;

/* JADX INFO: compiled from: PlayerExposureTracker.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final String TAG = "PlayerExpo-Track";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f25675a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static C0632a f25676b;

    /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.legacy.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PlayerExposureTracker.kt */
    private static final class C0632a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f25677a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f25678b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ComponentName f25679c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private IAutoActionAgentEventListener.SessionInfo f25680d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f25681e;

        public C0632a() {
            this(0, null, null, null, false, 31, null);
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, C0632a.class) == true) goto L8;
            return false;
        L8:
            C0632a r10 = (C0632a) ZeusTransformUtils.preCheckCast(r9, C0632a.class, "com.obric.aiagent.plugin");
            if (this.f25677a == r10.f25677a) goto L12;
            return false;
        L12:
            if (o.a(this.f25678b, r10.f25678b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f25679c, r10.f25679c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f25680d, r10.f25680d) == true) goto L21;
            return false;
        L21:
            if (this.f25681e == r10.f25681e) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            int r0 = Long.hashCode(this.f25677a) * 31;
            String r1 = this.f25678b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            ComponentName r5 = this.f25679c;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            IAutoActionAgentEventListener.SessionInfo r8 = this.f25680d;
            if (r8 == null) goto L15;
            r2 = r8.hashCode();
        L15:
            return ((r7 + r2) * 31) + Boolean.hashCode(this.f25681e);
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "PlayerShownSession(timeEntered=" + this.f25677a + ", sourceFrom=" + this.f25678b + ", sourceComponentName=" + this.f25679c + ", sessionInfo=" + this.f25680d + ", isNotifiedStarted=" + this.f25681e + ')';
        }

        public C0632a(long r1, String r3, ComponentName r4, IAutoActionAgentEventListener.SessionInfo r5, boolean r6) {
            this.f25677a = r1;
            this.f25678b = r3;
            this.f25679c = r4;
            this.f25680d = r5;
            this.f25681e = r6;
        }

        public /* synthetic */ C0632a(long r8, String r10, ComponentName r11, IAutoActionAgentEventListener.SessionInfo r12, boolean r13, int r14, h r15) {
            if ((r14 & 1) == 0) goto L5;
            r8 = AOSystemTools.INSTANCE.nowTimeMillis();
        L5:
            long r1 = r8;
            if ((r14 & 2) == 0) goto L8;
            String r3 = null;
        L10:
            if ((r14 & 4) == 0) goto L12;
            ComponentName r4 = null;
        L14:
            if ((r14 & 8) == 0) goto L16;
            IAutoActionAgentEventListener.SessionInfo r5 = null;
        L18:
            if ((r14 & 16) == 0) goto L20;
            r13 = false;
        L20:
            this(r1, r3, r4, r5, r13);
            return;
        L16:
            r5 = r12;
            goto L18
        L12:
            r4 = r11;
            goto L14
        L8:
            r3 = r10;
            goto L10
        }

        public final long a() {
            return this.f25677a;
        }

        public final void a(String r1) {
            this.f25678b = r1;
        }

        public final String b() {
            return this.f25678b;
        }

        public final void a(ComponentName r1) {
            this.f25679c = r1;
        }

        public final ComponentName c() {
            return this.f25679c;
        }

        public final void a(IAutoActionAgentEventListener.SessionInfo r1) {
            this.f25680d = r1;
        }

        public final IAutoActionAgentEventListener.SessionInfo d() {
            return this.f25680d;
        }

        public final void a(boolean r1) {
            this.f25681e = r1;
        }

        public final boolean e() {
            return this.f25681e;
        }

        public final boolean f() {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(this.f25678b, CharSequence.class, "com.obric.aiagent.plugin");
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == false) goto L11;
            return false;
        L11:
            if (this.f25680d != null) goto L13;
            return false;
        L13:
            return true;
        L5:
            if (d.o.o.d(r0) == true) goto L8;
            r1 = false;
            goto L9
        }
    }

    static {
        f25675a = new a();
    }

    private a() {
    }

    public final void a(String r11, ComponentName r12) {
        if (f25676b != null) goto L5;
        f25676b = new C0632a(0, null, null, null, false, 31, null);
    L5:
        C0632a r0 = f25676b;
        if (r0 != null) goto L8;
    L13:
        b();
        return;
    L8:
        if (r0.b() != null) goto L11;
        Loog.INSTANCE.d(TAG, " - [PlayerExposure] sourceFrom=" + r11);
        r0.a(r11);
    L11:
        if (r0.c() != null) goto L13;
        Loog.INSTANCE.d(TAG, " - [PlayerExposure] sourceComponentName=" + r12);
        r0.a(r12);
        goto L13
    }

    public final void a(IAutoActionAgentEventListener.SessionInfo r11) {
        o.e(r11, "sessionInfo");
        if (f25676b != null) goto L5;
        f25676b = new C0632a(0, null, null, null, false, 31, null);
    L5:
        C0632a r0 = f25676b;
        if (r0 == null) goto L8;
        r0.a(r11);
    L8:
        b();
    }

    private final void b() {
        C0632a r11 = f25676b;
        if (r11 != null) goto L6;
        return;
    L6:
        if (r11.e() == false) goto L8;
        return;
    L8:
        if (r11.f() == false) goto L17;
        IAutoActionTrackingApi r3 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r5 = new JSONObject();
        r5.put("enter_method", r11.b());
        r5.put(DBHelper.COL_TIME, r11.a());
        IAutoActionAgentEventListener.SessionInfo r0 = r11.d();
        if (r0 == null) goto L14;
        IPlatformTools r1 = (IPlatformTools) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IPlatformTools.class), IPlatformTools.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L14;
        r1.putSessionInfo(r5, r0);
    L14:
        x r2 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r3, "oauto_virtual_screen_show", r5, false, false, null, 28, null);
        r11.a(true);
        return;
    }

    public final void a() {
        C0632a r15 = f25676b;
        if (r15 != null) goto L6;
        Loog.INSTANCE.e(TAG, " - [PlayerExpo] PlayerHidden but no shownSession!");
        return;
    L6:
        f25676b = null;
        long r1 = AOSystemTools.INSTANCE.nowTimeMillis();
        long r3 = r1 - r15.a();
        Loog.INSTANCE.d(TAG, " - [PlayerExpo] (" + r3 + "ms), from: " + r15.b());
        if (r15.f() == false) goto L15;
        IAutoActionTrackingApi r7 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r9 = new JSONObject();
        r9.put("enter_method", r15.b());
        r9.put(DBHelper.COL_TIME, r1);
        r9.put("duration", r3);
        IAutoActionAgentEventListener.SessionInfo r16 = r15.d();
        if (r16 == null) goto L13;
        IPlatformTools r0 = (IPlatformTools) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IPlatformTools.class), IPlatformTools.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L13;
        r0.putSessionInfo(r9, r16);
    L13:
        x r17 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r7, "oauto_virtual_screen_exit", r9, false, false, null, 28, null);
        return;
    }
}
