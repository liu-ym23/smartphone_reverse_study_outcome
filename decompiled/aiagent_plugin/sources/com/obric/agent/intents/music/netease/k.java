package com.obric.agent.intents.music.netease;

import android.os.Bundle;
import android.os.SystemClock;
import com.obric.agent.omnimodel.OmniModelServiceImpl;
import com.obric.aiagent.applog.IAppLog;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: MusicTraceReporter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class k {
    private static final String TAG = "MusicTraceReporter";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f14837a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f14838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static b f14839c;

    /* JADX INFO: compiled from: MusicTraceReporter.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f14840a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f14841b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f14842c;

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, a.class) == true) goto L8;
            return false;
        L8:
            a r8 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f14840a, r8.f14840a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f14841b, r8.f14841b) == true) goto L15;
            return false;
        L15:
            if (this.f14842c == r8.f14842c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            String r0 = this.f14840a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.f14841b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return ((r3 + r1) * 31) + Long.hashCode(this.f14842c);
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "MusicSession(localMessageId=" + this.f14840a + ", musicId=" + this.f14841b + ", startTime=" + this.f14842c + ')';
        }

        public a(String r1, String r2, long r3) {
            this.f14840a = r1;
            this.f14841b = r2;
            this.f14842c = r3;
        }

        public final String a() {
            return this.f14840a;
        }

        public final String b() {
            return this.f14841b;
        }

        public final long c() {
            return this.f14842c;
        }
    }

    /* JADX INFO: compiled from: MusicTraceReporter.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f14843a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f14844b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f14845c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f14843a, r6.f14843a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f14844b, r6.f14844b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f14845c, r6.f14845c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            String r0 = this.f14843a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.f14844b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return ((r3 + r1) * 31) + this.f14845c.hashCode();
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "PendingPlayReport(localMessageId=" + this.f14843a + ", musicId=" + this.f14844b + ", playMethod=" + this.f14845c + ')';
        }

        public b(String r2, String r3, String r4) {
            o.e(r4, "playMethod");
            this.f14843a = r2;
            this.f14844b = r3;
            this.f14845c = r4;
        }

        public final String a() {
            return this.f14843a;
        }

        public final String b() {
            return this.f14844b;
        }

        public final String c() {
            return this.f14845c;
        }
    }

    static {
        f14837a = new k();
    }

    private final String b(int r1) {
        if (r1 != 0) goto L4;
        return "1";
    L4:
        if (r1 != 100) goto L6;
        return "2";
    L6:
        if (r1 != 106) goto L8;
        return "6";
    L8:
        if (r1 != 201) goto L10;
        return "3";
    L10:
        if (r1 == 202) goto L12;
        return "5";
    L12:
        return "4";
    }

    private k() {
    }

    public final void a(String r4, String r5, String r6, int r7) {
        o.e(r6, "playMethod");
        Bundle r0 = a(r4, r5);
        r0.putString("play_method", r6);
        k r8 = f14837a;
        r0.putString("play_status", r8.b(r7));
        r0.putString("is_background", "1");
        x r1 = x.f38692a;
        a("obric_music_play", r0);
        if (r7 == 0) goto L5;
        return;
    L5:
        a r3 = f14838b;
        if (r3 != null) goto L8;
    L19:
        f14838b = new a(r4, r5, SystemClock.elapsedRealtime());
        return;
    L8:
        if (o.a(r3.a(), r4) == true) goto L10;
    L13:
        boolean r9 = true;
    L14:
        if (r9 == true) goto L17;
        r3 = null;
    L17:
        if (r3 == null) goto L19;
        r8.a(r3, "shift");
        goto L19
    L10:
        if (o.a(r3.b(), r5) == false) goto L13;
        r9 = false;
        goto L14
    }

    public final void a(String r1, String r2, String r3) {
        o.e(r3, "playMethod");
        f14839c = new b(r1, r2, r3);
    }

    public final void a(int r4) {
        if (r4 != 0) goto L4;
        return;
    L4:
        b r3 = f14839c;
        if (r3 == null) goto L8;
        k r0 = f14837a;
        f14839c = null;
        r0.a(r3.a(), r3.b(), r3.c(), r4);
        return;
    }

    private final void a() {
        b r4 = f14839c;
        if (r4 == null) goto L6;
        k r0 = f14837a;
        f14839c = null;
        r0.a(r4.a(), r4.b(), r4.c(), 0);
        return;
    }

    public final void a(String r2) {
        o.e(r2, "overMethod");
        a r0 = f14838b;
        if (r0 != null) goto L5;
        return;
    L5:
        a(r0, r2);
        f14838b = null;
    }

    public final void a(String r6, String r7, Bundle r8, Bundle r9) {
        o.e(r8, "previousMusicState");
        o.e(r9, "currentMusicState");
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L5;
    L8:
        boolean r11 = true;
    L9:
        if (r11 == false) goto L11;
        return;
    L11:
        b r12 = f14839c;
        String r0 = null;
        if (r12 != null) goto L14;
    L31:
        a r13 = f14838b;
        if (r13 == null) goto L34;
        String r1 = r13.a();
    L36:
        if (o.a(r1, r6) == false) goto L42;
        if (r13 == null) goto L40;
        r0 = r13.b();
    L40:
        if (o.a(r0, r7) == false) goto L42;
        return;
    L42:
        if (r13 == null) goto L44;
        k r2 = f14837a;
        r2.a(r13, r2.a(r8));
    L44:
        Bundle r14 = a(r6, r7);
        if (r13 != null) goto L47;
        String r15 = "others";
    L48:
        r14.putString("play_method", r15);
        r14.putString("play_status", "1");
        r14.putString("is_background", "1");
        x r16 = x.f38692a;
        a("obric_music_play", r14);
        f14838b = new a(r6, r7, SystemClock.elapsedRealtime());
        return;
    L47:
        r15 = "shift";
        goto L48
    L34:
        r1 = null;
        goto L36
    L14:
        if (f14838b != null) goto L24;
        if (o.a(r7, r12.b()) == true) goto L22;
        ILogDepend.Companion r5 = ILogDepend.Companion;
        StringBuilder r17 = new StringBuilder().append("skip, cmapi current play musicId=").append(r7).append(", pending.id=");
        b r18 = f14839c;
        if (r18 == null) goto L20;
        r0 = r18.b();
    L20:
        r5.w(TAG, r17.append(r0).toString());
        return;
    L22:
        a();
        goto L31
    L24:
        if (o.a(r7, r12.b()) == true) goto L30;
        ILogDepend.Companion r3 = ILogDepend.Companion;
        StringBuilder r19 = new StringBuilder().append("cmapi current play musicId=").append(r7).append(",pending.id=").append(r12.b()).append(",active.id=");
        a r4 = f14838b;
        if (r4 == null) goto L28;
        String r20 = r4.b();
    L29:
        r3.w(TAG, r19.append(r20).toString());
        goto L31
    L28:
        r20 = null;
        goto L29
    L30:
        a();
        goto L31
    L5:
        if (r10.length() == 0) goto L8;
        r11 = false;
        goto L9
    }

    private final void a(a r4, String r5) {
        Bundle r0 = a(r4.a(), r4.b());
        r0.putString("over_method", r5);
        r0.putLong("duration", SystemClock.elapsedRealtime() - r4.c());
        x r6 = x.f38692a;
        a("obric_music_over", r0);
    }

    private final String a(Bundle r13) {
        int r12 = r13.getInt("total_time", 0);
        int r0 = r13.getInt("current_time", 0);
        long r4 = r13.getLong(CMApiManager.KEY_MUSIC_INFO_UPDATE_TIME, 0);
        if (r12 <= 0) goto L12;
        if (r0 >= 0) goto L6;
        return "shift";
    L6:
        if (r4 <= 0) goto L15;
        long r6 = (((long) r0) + SystemClock.elapsedRealtime()) - r4;
        long r1 = r12;
        if (Math.abs(r1 - d.l.n.a(r6, 0, r1)) > 1000) goto L14;
        return "finished";
    L14:
        return "shift";
    L15:
        return "shift";
    L12:
        return "shift";
    }

    private final Bundle a(String r3, String r4) {
        Bundle r2 = new Bundle();
        r2.putString("scene_name", OmniModelServiceImpl.CURRENT_MODEL_CHAT);
        r2.putString("current_page", OmniModelServiceImpl.CURRENT_MODEL_CHAT);
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        r2.putString("group_id", r4);
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        r2.putString("message_id", r3);
        r2.putString("media_type", "audio");
        return r2;
    }

    private final void a(String r3, Bundle r4) {
        IAppLog r2 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.report(r3, r4);
        return;
    }
}
