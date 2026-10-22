package com.bytedance.android.sdk.bdticketguard.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public abstract class TeeStaticSignResult {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/data/TeeStaticSignResult$NoTeeStaticSignCacheException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "lastResult", "Lcom/bytedance/android/sdk/bdticketguard/data/TeeStaticSignResult;", "(Lcom/bytedance/android/sdk/bdticketguard/data/TeeStaticSignResult;)V", "getLastResult", "()Lcom/bytedance/android/sdk/bdticketguard/data/TeeStaticSignResult;", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
    public static final class NoTeeStaticSignCacheException extends Exception {
        private final TeeStaticSignResult lastResult;

        public final TeeStaticSignResult getLastResult() {
            return this.lastResult;
        }

        public NoTeeStaticSignCacheException(TeeStaticSignResult r100) {
            super("no tee static sign cache, last result " + r100);
            this.lastResult = r100;
        }
    }

    public static final class a {
    }

    public static final class b extends TeeStaticSignResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f163581a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f163582b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Throwable f163583c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L5;
        L17:
            return true;
        L5:
            if ((r100 instanceof b) == false) goto L16;
            b r101 = (b) r100;
            if (this.f163581a != r101.f163581a) goto L9;
            boolean r102 = true;
        L10:
            if (r102 == false) goto L16;
            if (Intrinsics.areEqual(this.f163582b, r101.f163582b) == false) goto L16;
            if (Intrinsics.areEqual(this.f163583c, r101.f163583c) == false) goto L16;
        L9:
            r102 = false;
        L16:
            return false;
        }

        public final int hashCode() {
            int r100 = this.f163581a * 31;
            String r101 = this.f163582b;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = r101.hashCode();
        L6:
            int r104 = (r100 + r103) * 31;
            Throwable r105 = this.f163583c;
            if (r105 == null) goto L10;
            r102 = r105.hashCode();
        L10:
            return r104 + r102;
        L5:
            r103 = 0;
            goto L6
        }

        public final String toString() {
            return "Fail(errorCode=" + this.f163581a + ", errorMsg=" + this.f163582b + ", throwable=" + this.f163583c + ")";
        }

        public b(int r100, String r101, Throwable r102) {
            this.f163581a = r100;
            this.f163582b = r101;
            this.f163583c = r102;
        }
    }

    public static final class c extends TeeStaticSignResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f163584a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f163585b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f163586c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f163587d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L5;
        L19:
            return true;
        L5:
            if ((r100 instanceof c) == false) goto L18;
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f163584a, r101.f163584a) == false) goto L18;
            if (Intrinsics.areEqual(this.f163585b, r101.f163585b) == false) goto L18;
            if (Intrinsics.areEqual(this.f163586c, r101.f163586c) == false) goto L18;
            if (this.f163587d != r101.f163587d) goto L15;
            boolean r102 = true;
        L16:
            if (r102 == false) goto L18;
        L15:
            r102 = false;
        L18:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f163584a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f163585b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f163586c;
            if (r107 == null) goto L13;
            r101 = r107.hashCode();
        L13:
            int r108 = (r106 + r101) * 31;
            long r109 = this.f163587d;
            return r108 + ((int) (r109 ^ (r109 >>> 32)));
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Success(secTs=" + this.f163584a + ", sign=" + this.f163585b + ", teePubKey=" + this.f163586c + ", serverTime=" + this.f163587d + ")";
        }

        public c(String r100, String r101, String r102, long r103) {
            this.f163584a = r100;
            this.f163585b = r101;
            this.f163586c = r102;
            this.f163587d = r103;
        }
    }

    static {
    }

    public TeeStaticSignResult() {
    }
}
