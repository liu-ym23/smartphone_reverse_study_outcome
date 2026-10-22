package com.bytedance.android.livesdk.interactivity.medialink.contract;

import com.bytedance.android.livesdk.chatroom.model.interact.MultiLiveCoreInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.MultiRtcInfo;
import com.bytedance.android.livesdk.message.linker.MultiAnchorExtra;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnchorLinkInitType f137985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f137986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f137987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f137988d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f137989e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MultiLiveCoreInfo f137990f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MultiRtcInfo f137991g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f137992h;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f137993a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f137994b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final MultiAnchorExtra f137995c;

        public a() {
            this(0, 7);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L12;
            a r101 = (a) r100;
            if (this.f137993a == r101.f137993a) goto L8;
            return false;
        L8:
            if (this.f137994b == r101.f137994b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f137995c, r101.f137995c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            int r100 = ((this.f137993a * 31) + this.f137994b) * 31;
            MultiAnchorExtra r101 = this.f137995c;
            if (r101 == null) goto L5;
            int r102 = r101.hashCode();
        L7:
            return r100 + r102;
        L5:
            r102 = 0;
            goto L7
        }

        public final String toString() {
            return "Extra(multiPkMode=" + this.f137993a + ", inviterFromScene=" + this.f137994b + ", multiAnchorExtra=" + this.f137995c + ")";
        }

        public a(int r100, int r101) {
            if ((r101 & 1) == 0) goto L5;
            r100 = 0;
        L5:
            this.f137993a = r100;
            this.f137994b = 0;
            this.f137995c = null;
        }
    }

    public final String toString() {
        return "MediaAnchorConnectionContext{Type=" + this.f137985a + ", inviteeList=" + this.f137986b + ", switchChannel=" + this.f137987c + ", connectionType=" + this.f137988d + ", extra=" + this.f137989e + '}';
    }

    public d(AnchorLinkInitType r100, String r101, String r102, a r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = AnchorLinkInitType.NONE;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r101 = "";
    L9:
        if ((r104 & 32) == 0) goto L12;
        r102 = "manual_link";
    L12:
        if ((r104 & 64) == 0) goto L14;
        r103 = new a(0, 7);
    L14:
        Intrinsics.checkNotNullParameter(r100, "initType");
        Intrinsics.checkNotNullParameter(r101, "inviteeList");
        Intrinsics.checkNotNullParameter(r102, "linkConnectionType");
        Intrinsics.checkNotNullParameter(r103, "extra");
        this.f137985a = r100;
        this.f137986b = r101;
        this.f137987c = false;
        this.f137988d = r102;
        this.f137989e = r103;
        this.f137990f = null;
        this.f137991g = null;
        this.f137992h = 0;
    }
}
