package com.bytedance.android.anniex.detect;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public abstract class c {

    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f40649a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f40650b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final FailureStage f40651c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f40649a == r101.f40649a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f40650b, r101.f40650b) == true) goto L15;
            return false;
        L15:
            if (this.f40651c == r101.f40651c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f40649a * 31) + this.f40650b.hashCode()) * 31) + this.f40651c.hashCode();
        }

        public final String toString() {
            return "Error(statusCode=" + this.f40649a + ", errorMsg=" + this.f40650b + ", stage=" + this.f40651c + ')';
        }

        public a(int r100, String r101, FailureStage r102) {
            Intrinsics.checkNotNullParameter(r101, "errorMsg");
            Intrinsics.checkNotNullParameter(r102, "stage");
            this.f40649a = r100;
            this.f40650b = r101;
            this.f40651c = r102;
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f40652a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f40653b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f40652a == r101.f40652a) goto L12;
            return false;
        L12:
            if (Float.compare(this.f40653b, r101.f40653b) == 0) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f40652a * 31) + Float.floatToIntBits(this.f40653b);
        }

        public final String toString() {
            return "PureWhite(statusCode=" + this.f40652a + ", probability=" + this.f40653b + ')';
        }

        public b(float r100) {
            this.f40652a = 1000;
            this.f40653b = r100;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.anniex.detect.c$c, reason: collision with other inner class name */
    public static final class C0757c extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f40654a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C0757c) == true) goto L9;
            return false;
        L9:
            if (this.f40654a == ((C0757c) r100).f40654a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f40654a;
        }

        public final String toString() {
            return "Success(statusCode=" + this.f40654a + ')';
        }

        public C0757c() {
            this.f40654a = 200;
        }
    }

    public c() {
    }
}
