package com.obric.autoaction.presentation.biztrack;

import android.content.ComponentName;
import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.x;
import org.json.JSONObject;

/* JADX INFO: compiled from: PlayerExposureTracker.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final String TAG = "PlayerExpo-Track";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f24834a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f24835b;

    /* JADX INFO: compiled from: PlayerExposureTracker.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f24836a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f24837b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ComponentName f24838c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private IAutoActionAgentEventListener.SessionInfo f24839d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f24840e;

        public a() {
            this(0, null, null, null, false, 31, null);
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, a.class) == true) goto L8;
            return false;
        L8:
            a r10 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.aiagent.plugin");
            if (this.f24836a == r10.f24836a) goto L12;
            return false;
        L12:
            if (o.a(this.f24837b, r10.f24837b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f24838c, r10.f24838c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f24839d, r10.f24839d) == true) goto L21;
            return false;
        L21:
            if (this.f24840e == r10.f24840e) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            int r0 = Long.hashCode(this.f24836a) * 31;
            String r1 = this.f24837b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            ComponentName r5 = this.f24838c;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            IAutoActionAgentEventListener.SessionInfo r8 = this.f24839d;
            if (r8 == null) goto L15;
            r2 = r8.hashCode();
        L15:
            return ((r7 + r2) * 31) + Boolean.hashCode(this.f24840e);
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "PlayerShownSession(timeEntered=" + this.f24836a + ", sourceFrom=" + this.f24837b + ", sourceComponentName=" + this.f24838c + ", sessionInfo=" + this.f24839d + ", isNotifiedStarted=" + this.f24840e + ')';
        }

        public a(long r1, String r3, ComponentName r4, IAutoActionAgentEventListener.SessionInfo r5, boolean r6) {
            this.f24836a = r1;
            this.f24837b = r3;
            this.f24838c = r4;
            this.f24839d = r5;
            this.f24840e = r6;
        }

        public /* synthetic */ a(long r8, String r10, ComponentName r11, IAutoActionAgentEventListener.SessionInfo r12, boolean r13, int r14, h r15) {
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
            return this.f24836a;
        }

        public final void a(String r1) {
            this.f24837b = r1;
        }

        public final String b() {
            return this.f24837b;
        }

        public final void a(ComponentName r1) {
            this.f24838c = r1;
        }

        public final ComponentName c() {
            return this.f24838c;
        }

        public final void a(IAutoActionAgentEventListener.SessionInfo r1) {
            this.f24839d = r1;
        }

        public final IAutoActionAgentEventListener.SessionInfo d() {
            return this.f24839d;
        }

        public final void a(boolean r1) {
            this.f24840e = r1;
        }

        public final boolean e() {
            return this.f24840e;
        }

        public final boolean f() {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(this.f24837b, CharSequence.class, "com.obric.aiagent.plugin");
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == false) goto L11;
            return false;
        L11:
            if (this.f24839d != null) goto L13;
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
        f24834a = new b();
    }

    private b() {
    }

    public final void a(String r11, ComponentName r12) {
        if (f24835b != null) goto L5;
        f24835b = new a(0, null, null, null, false, 31, null);
    L5:
        a r0 = f24835b;
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
        if (f24835b != null) goto L5;
        f24835b = new a(0, null, null, null, false, 31, null);
    L5:
        a r0 = f24835b;
        if (r0 == null) goto L8;
        r0.a(r11);
    L8:
        b();
    }

    private final void b() {
        a r9 = f24835b;
        if (r9 != null) goto L6;
        return;
    L6:
        if (r9.e() == false) goto L8;
        return;
    L8:
        if (r9.f() == false) goto L15;
        IAutoActionTrackingApi r1 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r3 = new JSONObject();
        r3.put("enter_method", r9.b());
        r3.put(DBHelper.COL_TIME, r9.a());
        IAutoActionAgentEventListener.SessionInfo r0 = r9.d();
        if (r0 == null) goto L12;
        com.obric.autogui.session.c.b.a(r3, r0);
    L12:
        x r2 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r1, "oauto_virtual_screen_show", r3, false, false, null, 28, null);
        r9.a(true);
        return;
    }

    public final void a() {
        a r13 = f24835b;
        if (r13 != null) goto L6;
        Loog.INSTANCE.e(TAG, " - [PlayerExpo] PlayerHidden but no shownSession!");
        return;
    L6:
        f24835b = null;
        long r1 = AOSystemTools.INSTANCE.nowTimeMillis();
        long r3 = r1 - r13.a();
        Loog.INSTANCE.d(TAG, " - [PlayerExpo] (" + r3 + "ms), from: " + r13.b());
        if (r13.f() == false) goto L13;
        IAutoActionTrackingApi r5 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r7 = new JSONObject();
        r7.put("enter_method", r13.b());
        r7.put(DBHelper.COL_TIME, r1);
        r7.put("duration", r3);
        IAutoActionAgentEventListener.SessionInfo r14 = r13.d();
        if (r14 == null) goto L11;
        com.obric.autogui.session.c.b.a(r7, r14);
    L11:
        x r15 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r5, "oauto_virtual_screen_exit", r7, false, false, null, 28, null);
        return;
    }
}
