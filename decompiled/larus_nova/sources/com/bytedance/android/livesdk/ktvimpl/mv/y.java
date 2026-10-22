package com.bytedance.android.livesdk.ktvimpl.mv;

import com.bytedance.android.livesdk.message.model.KtvMusic;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<Function3<l, Integer, String, Unit>> f146207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f146208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f146209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f146210d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f146211e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f146212f;

    public static final class a {
    }

    static {
    }

    public /* synthetic */ y() {
        throw null;
    }

    public final int hashCode() {
        long r100 = this.f146208b;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.f146209c;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f146210d;
        if (r106 == null) goto L9;
        int r107 = r106.hashCode();
    L10:
        int r108 = (r105 + r107) * 31;
        Long r109 = this.f146211e;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (r108 + r110) * 31;
        Integer r112 = this.f146212f;
        if (r112 == null) goto L18;
        r103 = r112.hashCode();
    L18:
        return r111 + r103;
    L13:
        r110 = 0;
        goto L14
    L9:
        r107 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "SongMvParam(songId=" + this.f146208b + ", songName=" + this.f146209c + ", orderUidString=" + this.f146210d + ", songOffset=" + this.f146211e + ", fetchType=" + this.f146212f + ")";
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof y) == false) goto L12;
        y r101 = (y) r100;
        if (r101.f146208b == this.f146208b) goto L7;
    L9:
        return false;
    L7:
        if (Intrinsics.areEqual(this.f146210d, r101.f146210d) == false) goto L9;
        return true;
    L12:
        return super.equals(r100);
    }

    public y(KtvMusic r110, Integer r111) {
        Intrinsics.checkNotNullParameter(r110, "music");
        this(r110.getMId(), r110.getMTitle(), r110.getOrderUserIdString(), null, r111, 8);
    }

    public y(long r100, String r101, String r102, Long r103, Integer r104) {
        Intrinsics.checkNotNullParameter(r102, "orderUidString");
        this.f146208b = r100;
        this.f146209c = r101;
        this.f146210d = r102;
        this.f146211e = r103;
        this.f146212f = r104;
    }

    public /* synthetic */ y(long r110, String r111, String r112, Long r113, Integer r114, int r115) {
        if ((r115 & 2) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r115 & 8) == 0) goto L9;
        Long r101 = null;
    L11:
        if ((r115 & 16) == 0) goto L13;
        Integer r102 = null;
    L14:
        this(r110, r100, r112, r101, r102);
        return;
    L13:
        r102 = r114;
        goto L14
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
