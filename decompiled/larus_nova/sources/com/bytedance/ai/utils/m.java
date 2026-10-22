package com.bytedance.ai.utils;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public abstract class m {

    public static final class a extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f37676a;

        public final String toString() {
            return "BinaryResponse(data=" + Arrays.toString(this.f37676a) + ')';
        }

        public final int hashCode() {
            return Arrays.hashCode(this.f37676a);
        }

        public a(byte[] r100) {
            this.f37676a = r100;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 == null) goto L8;
            Class<?> r101 = r100.getClass();
        L10:
            if (Intrinsics.areEqual(a.class, r101) == true) goto L13;
            return false;
        L13:
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ai.utils.ResponseData.BinaryResponse");
            return Arrays.equals(this.f37676a, ((a) r100).f37676a);
        L8:
            r101 = null;
            goto L10
        }
    }

    public static final class b extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f37677a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f37677a, ((b) r100).f37677a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f37677a.hashCode();
        }

        public final String toString() {
            return "StringResponse(data=" + this.f37677a + ')';
        }

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f37677a = r100;
        }
    }

    public m() {
    }
}
