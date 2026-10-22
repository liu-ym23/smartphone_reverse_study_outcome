package com.bytedance.android.livesdk.chatroom.ui;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class u9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f114251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f114252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f114253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f114254d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f114255e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f114256f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f114257a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f114258b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f114259c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f114260d;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.u9$a$a, reason: collision with other inner class name */
        public static final class C1686a {
        }

        static {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L14;
            a r101 = (a) r100;
            if (this.f114257a == r101.f114257a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f114258b, r101.f114258b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f114259c, r101.f114259c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f114260d, r101.f114260d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            int r100 = this.f114257a * 31;
            String r101 = this.f114258b;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = r101.hashCode();
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.f114259c;
            if (r105 == null) goto L9;
            int r106 = r105.hashCode();
        L10:
            int r107 = (r104 + r106) * 31;
            String r108 = this.f114260d;
            if (r108 == null) goto L14;
            r102 = r108.hashCode();
        L14:
            return r107 + r102;
        L9:
            r106 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        public final String toString() {
            return "TitleConfig(titleType=" + this.f114257a + ", titleString=" + this.f114258b + ", titleImg=" + this.f114259c + ", titleColor=" + this.f114260d + ")";
        }

        public a(int r100, String r101, String r102, String r103) {
            this.f114257a = r100;
            this.f114258b = r101;
            this.f114259c = r102;
            this.f114260d = r103;
        }
    }

    public u9(String r100, a r101, String r102, String r103, String r104, String r105) {
        this.f114251a = r100;
        this.f114252b = r101;
        this.f114253c = r102;
        this.f114254d = r103;
        this.f114255e = r104;
        this.f114256f = r105;
    }
}
