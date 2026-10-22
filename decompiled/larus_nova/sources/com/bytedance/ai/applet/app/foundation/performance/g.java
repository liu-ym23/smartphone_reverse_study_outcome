package com.bytedance.ai.applet.app.foundation.performance;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public interface g {

    public static final class a implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f34327a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f34328b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f34327a == r101.f34327a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f34328b, r101.f34328b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f34327a;
            return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.f34328b.hashCode();
        }

        public final String toString() {
            return "Page(traceId=" + this.f34327a + ", path=" + this.f34328b + ')';
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.g
        public final long getTraceId() {
            return this.f34327a;
        }

        public a(long r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "path");
            this.f34327a = r100;
            this.f34328b = r101;
        }
    }

    public static final class b implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f34329a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.f34329a == ((b) r100).f34329a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f34329a;
            return (int) (r100 ^ (r100 >>> 32));
        }

        public final String toString() {
            return "Standalone(traceId=" + this.f34329a + ')';
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.g
        public final long getTraceId() {
            return this.f34329a;
        }

        public b(long r100) {
            this.f34329a = r100;
        }
    }

    public static final class c implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f34330a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f34331b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f34332c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f34333d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f34330a == r101.f34330a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f34331b, r101.f34331b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f34332c, r101.f34332c) == true) goto L18;
            return false;
        L18:
            if (this.f34333d == r101.f34333d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f34330a;
            int r101 = ((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f34331b.hashCode()) * 31) + this.f34332c.hashCode()) * 31;
            if (this.f34333d == false) goto L5;
            int r102 = 1231;
        L7:
            return r101 + r102;
        L5:
            r102 = 1237;
            goto L7
        }

        public final String toString() {
            return "Widget(traceId=" + this.f34330a + ", widgetId=" + this.f34331b + ", widgetInstanceId=" + this.f34332c + ", isAppColdLaunch=" + this.f34333d + ')';
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.g
        public final long getTraceId() {
            return this.f34330a;
        }

        public c(long r100, String r101, String r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r101, "widgetId");
            Intrinsics.checkNotNullParameter(r102, "widgetInstanceId");
            this.f34330a = r100;
            this.f34331b = r101;
            this.f34332c = r102;
            this.f34333d = r103;
        }
    }

    long getTraceId();
}
