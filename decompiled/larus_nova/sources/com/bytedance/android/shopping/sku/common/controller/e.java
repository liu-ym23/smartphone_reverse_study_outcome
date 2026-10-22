package com.bytedance.android.shopping.sku.common.controller;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, a> f182641a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f182642a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f182643b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f182644c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f182645d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L14;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f182642a, r101.f182642a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f182643b, r101.f182643b) == true) goto L10;
            return false;
        L10:
            if (this.f182644c == r101.f182644c) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f182645d, r101.f182645d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r2v4, types: [int] */
        /* JADX WARN: Type inference failed for: r2v6 */
        /* JADX WARN: Type inference failed for: r2v8 */
        public final int hashCode() {
            String r100 = this.f182642a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f182643b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            boolean r107 = this.f182644c;
            ?? r108 = r107;
            if (r107 == false) goto L13;
            r108 = 1;
        L13:
            int r109 = (r106 + r108) * 31;
            String r110 = this.f182645d;
            if (r110 == null) goto L17;
            r101 = r110.hashCode();
        L17:
            return r109 + r101;
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Info(eventName=" + this.f182642a + ", opportunity=" + this.f182643b + ", needHold=" + this.f182644c + ", renderNodeKey=" + this.f182645d + ")";
        }

        public a(String r100, String r101, boolean r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            Intrinsics.checkNotNullParameter(r101, "opportunity");
            Intrinsics.checkNotNullParameter(r103, "renderNodeKey");
            this.f182642a = r100;
            this.f182643b = r101;
            this.f182644c = r102;
            this.f182645d = r103;
        }
    }

    public e() {
        this.f182641a = new ConcurrentHashMap();
    }
}
