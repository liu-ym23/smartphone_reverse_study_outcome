package com.bytedance.android.livesdk.chatroom.room;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Double> f111154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f111155b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f111156a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f111157b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f111158c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f111159d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f111160e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L16;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f111156a, r101.f111156a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f111157b, r101.f111157b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f111158c, r101.f111158c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f111159d, r101.f111159d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.f111160e, r101.f111160e) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f111156a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f111157b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f111158c;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.f111159d;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.f111160e;
            if (r113 == null) goto L22;
            r101 = r113.hashCode();
        L22:
            return r112 + r101;
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
            return "FpsCommonParam(isFirstRoom=" + this.f111156a + ", hasPreload=" + this.f111157b + ", deviceRate=" + this.f111158c + ", liveModel=" + this.f111159d + ", scene=" + this.f111160e + ")";
        }

        public a(String r100, String r101, String r102, String r103, String r104) {
            this.f111156a = r100;
            this.f111157b = r101;
            this.f111158c = r102;
            this.f111159d = r103;
            this.f111160e = r104;
        }
    }

    public t0() {
        this.f111154a = new LinkedHashMap();
    }
}
