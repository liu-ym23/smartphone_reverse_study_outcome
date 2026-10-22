package com.smt.obric.appstore.ui.app;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class AppUIStatus {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f18171h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f18172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f18174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f18175d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Status f18176e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.smt.obric.appstore.domain.app.entity.a f18177f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final he.a f18178g;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/smt/obric/appstore/ui/app/AppUIStatus$Status;", "", "(Ljava/lang/String;I)V", "NotInstalled", "UpdateAvailable", "DownloadPending", "DownloadRunning", "DownloadPaused", "DownloadWaitWiFi", "DownloadFailed", "Installing", "Installed", "appstorecommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final enum Status extends Enum<Status> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final Status DownloadFailed = null;
        public static final Status DownloadPaused = null;
        public static final Status DownloadPending = null;
        public static final Status DownloadRunning = null;
        public static final Status DownloadWaitWiFi = null;
        public static final Status Installed = null;
        public static final Status Installing = null;
        public static final Status NotInstalled = null;
        public static final Status UpdateAvailable = null;

        private static final /* synthetic */ Status[] $values() {
            return new Status[]{NotInstalled, UpdateAvailable, DownloadPending, DownloadRunning, DownloadPaused, DownloadWaitWiFi, DownloadFailed, Installing, Installed};
        }

        static {
            NotInstalled = new Status("NotInstalled", 0);
            UpdateAvailable = new Status("UpdateAvailable", 1);
            DownloadPending = new Status("DownloadPending", 2);
            DownloadRunning = new Status("DownloadRunning", 3);
            DownloadPaused = new Status("DownloadPaused", 4);
            DownloadWaitWiFi = new Status("DownloadWaitWiFi", 5);
            DownloadFailed = new Status("DownloadFailed", 6);
            Installing = new Status("Installing", 7);
            Installed = new Status("Installed", 8);
            Status[] r10 = $values();
            $VALUES = r10;
            $ENTRIES = kotlin.enums.a.a(r10);
        }

        private Status(String r10, int r11) {
            super(r10, r11);
        }

        @NotNull
        public static EnumEntries<Status> getEntries() {
            return $ENTRIES;
        }

        public static Status valueOf(String r10) {
            return (Status) Enum.valueOf(Status.class, r10);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final AppUIStatus a() {
            boolean r10 = true;
            String r11 = null;
            Long r12 = null;
            String r13 = null;
            Status r14 = null;
            com.smt.obric.appstore.domain.app.entity.a r15 = null;
            he.a r16 = null;
            return new AppUIStatus(r10, r11, r12, r13, r14, r15, r16, 96, null);
        }

        public a() {
        }
    }

    static {
        f18171h = new a(null);
    }

    public AppUIStatus(boolean r10, String r11, Long r12, String r13, Status r14, com.smt.obric.appstore.domain.app.entity.a r15, he.a r16) {
        this.f18172a = r10;
        this.f18173b = r11;
        this.f18174c = r12;
        this.f18175d = r13;
        this.f18176e = r14;
        this.f18177f = r15;
        this.f18178g = r16;
    }

    public final AppUIStatus a(boolean r10, String r11, Long r12, String r13, Status r14, com.smt.obric.appstore.domain.app.entity.a r15, he.a r16) {
        return new AppUIStatus(r10, r11, r12, r13, r14, r15, r16);
    }

    public final he.a b() {
        return this.f18178g;
    }

    public final com.smt.obric.appstore.domain.app.entity.a c() {
        return this.f18177f;
    }

    public final boolean d() {
        return this.f18172a;
    }

    public final String e() {
        return this.f18173b;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AppUIStatus) == true) goto L8;
        return false;
    L8:
        AppUIStatus r11 = (AppUIStatus) r10;
        if (this.f18172a == r11.f18172a) goto L12;
        return false;
    L12:
        if (q.b(this.f18173b, r11.f18173b) == true) goto L15;
        return false;
    L15:
        if (q.b(this.f18174c, r11.f18174c) == true) goto L18;
        return false;
    L18:
        if (q.b(this.f18175d, r11.f18175d) == true) goto L21;
        return false;
    L21:
        if (this.f18176e == r11.f18176e) goto L24;
        return false;
    L24:
        if (q.b(this.f18177f, r11.f18177f) == true) goto L27;
        return false;
    L27:
        if (q.b(this.f18178g, r11.f18178g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final Status f() {
        return this.f18176e;
    }

    public int hashCode() {
        int r10 = Boolean.hashCode(this.f18172a) * 31;
        String r11 = this.f18173b;
        int r12 = 0;
        if (r11 != null) goto L5;
        int r13 = 0;
    L6:
        int r14 = (r10 + r13) * 31;
        Long r15 = this.f18174c;
        if (r15 != null) goto L9;
        int r16 = 0;
    L10:
        int r17 = (r14 + r16) * 31;
        String r18 = this.f18175d;
        if (r18 != null) goto L13;
        int r19 = 0;
    L14:
        int r20 = (r17 + r19) * 31;
        Status r21 = this.f18176e;
        if (r21 != null) goto L17;
        int r22 = 0;
    L18:
        int r23 = (r20 + r22) * 31;
        com.smt.obric.appstore.domain.app.entity.a r24 = this.f18177f;
        if (r24 != null) goto L21;
        int r25 = 0;
    L22:
        int r26 = (r23 + r25) * 31;
        he.a r27 = this.f18178g;
        if (r27 == null) goto L27;
        r12 = r27.hashCode();
    L27:
        return r26 + r12;
    L21:
        r25 = r24.hashCode();
        goto L22
    L17:
        r22 = r21.hashCode();
        goto L18
    L13:
        r19 = r18.hashCode();
        goto L14
    L9:
        r16 = r15.hashCode();
        goto L10
    L5:
        r13 = r11.hashCode();
        goto L6
    }

    public String toString() {
        return "AppUIStatus(loading=" + this.f18172a + ", pkg=" + this.f18173b + ", versionCode=" + this.f18174c + ", name=" + this.f18175d + ", status=" + this.f18176e + ", installTask=" + this.f18177f + ", appInfo=" + this.f18178g + ')';
    }

    public /* synthetic */ AppUIStatus(boolean r11, String r12, Long r13, String r14, Status r15, com.smt.obric.appstore.domain.app.entity.a r16, he.a r17, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 32) == 0) goto L5;
        com.smt.obric.appstore.domain.app.entity.a r10 = null;
    L7:
        if ((r18 & 64) == 0) goto L9;
        he.a r20 = null;
    L10:
        this(r11, r12, r13, r14, r15, r10, r20);
        return;
    L9:
        r20 = r17;
        goto L10
    L5:
        r10 = r16;
        goto L7
    }
}
