package com.bytedance.applet.debugger;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public interface x {

    public static final class a implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f191762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f191763b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f191762a, r101.f191762a) == true) goto L12;
            return false;
        L12:
            if (this.f191763b == r101.f191763b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f191762a.hashCode() * 31;
            if (this.f191763b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "Failure(reason=" + this.f191762a + ", retryable=" + this.f191763b + ')';
        }

        public a(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            this.f191762a = r100;
            this.f191763b = r101;
        }
    }

    public static final class b implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f191764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f191765b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f191764a, r101.f191764a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f191765b, r101.f191765b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f191764a.hashCode() * 31) + this.f191765b.hashCode();
        }

        public final String toString() {
            return "Success(conversationId=" + this.f191764a + ", botId=" + this.f191765b + ')';
        }

        public b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "conversationId");
            Intrinsics.checkNotNullParameter(r101, "botId");
            this.f191764a = r100;
            this.f191765b = r101;
        }
    }
}
