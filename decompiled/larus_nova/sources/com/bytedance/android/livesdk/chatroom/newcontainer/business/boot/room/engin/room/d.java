package com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import kotlin.jvm.internal.Intrinsics;
import ts2.l;

/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f107065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f107066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f107067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f107068d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Boolean f107069e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Bundle f107070f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l f107071g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ts2.e f107072h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Configuration f107073i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f107074j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Boolean f107075k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Boolean f107076l;

    public d() {
        this(null, null, null, null, null, UnixStat.PERM_MASK);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L30;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f107065a, r101.f107065a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f107066b, r101.f107066b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f107067c, r101.f107067c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f107068d, r101.f107068d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f107069e, r101.f107069e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f107070f, r101.f107070f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f107071g, r101.f107071g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f107072h, r101.f107072h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f107073i, r101.f107073i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f107074j, r101.f107074j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f107075k, r101.f107075k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f107076l, r101.f107076l) == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    public final int hashCode() {
        Boolean r100 = this.f107065a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        View r104 = this.f107066b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.f107067c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f107068d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.f107069e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Bundle r116 = this.f107070f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        l r119 = this.f107071g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        ts2.e r122 = this.f107072h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Configuration r125 = this.f107073i;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.f107074j;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        Boolean r131 = this.f107075k;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        Boolean r134 = this.f107076l;
        if (r134 == null) goto L50;
        r101 = r134.hashCode();
    L50:
        return r133 + r101;
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "OnContainerChangerData(isContainerResumed=" + this.f107065a + ", rootView=" + this.f107066b + ", isNeedDestroyStopRoom=" + this.f107067c + ", state=" + this.f107068d + ", isVisibleToUser=" + this.f107069e + ", outState=" + this.f107070f + ", picData=" + this.f107071g + ", configurationChangedData=" + this.f107072h + ", newConfig=" + this.f107073i + ", position=" + this.f107074j + ", isCurrentPageSelected=" + this.f107075k + ", isRoomVisible=" + this.f107076l + ")";
    }

    public /* synthetic */ d(Integer r110, Boolean r111, Integer r112, Boolean r210, Boolean r211, int r212) {
        if ((r212 & 1) == 0) goto L5;
        Boolean r100 = Boolean.FALSE;
    L7:
        if ((r212 & 4) == 0) goto L9;
        Boolean r101 = Boolean.FALSE;
    L11:
        if ((r212 & 8) == 0) goto L13;
        Integer r102 = null;
    L15:
        if ((r212 & 16) == 0) goto L17;
        Boolean r103 = null;
    L19:
        if ((r212 & 512) == 0) goto L21;
        Integer r113 = null;
    L23:
        if ((r212 & 1024) == 0) goto L25;
        Boolean r114 = Boolean.FALSE;
    L27:
        if ((r212 & 2048) == 0) goto L29;
        Boolean r115 = Boolean.FALSE;
    L30:
        this(r100, null, r101, r102, r103, null, null, null, null, r113, r114, r115);
        return;
    L29:
        r115 = r211;
        goto L30
    L25:
        r114 = r210;
        goto L27
    L21:
        r113 = r112;
        goto L23
    L17:
        r103 = r111;
        goto L19
    L13:
        r102 = r110;
        goto L15
    L9:
        r101 = null;
        goto L11
    L5:
        r100 = null;
        goto L7
    }

    public d(Boolean r100, View r101, Boolean r102, Integer r103, Boolean r104, Bundle r105, l r106, ts2.e r107, Configuration r108, Integer r110, Boolean r111, Boolean r112) {
        this.f107065a = r100;
        this.f107066b = r101;
        this.f107067c = r102;
        this.f107068d = r103;
        this.f107069e = r104;
        this.f107070f = r105;
        this.f107071g = r106;
        this.f107072h = r107;
        this.f107073i = r108;
        this.f107074j = r110;
        this.f107075k = r111;
        this.f107076l = r112;
    }
}
