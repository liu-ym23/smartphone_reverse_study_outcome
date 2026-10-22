package com.bytedance.android.sdk.bdticketguard.attestation;

import com.bytedance.android.sdk.bdticketguard.r0;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public abstract class AttestSignResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f163543a = 0;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\u0018\u00002\u00060\u0001j\u0002`\u0002B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/attestation/AttestSignResult$AttestSignFailedException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "errorCode", "", "errorMessage", "", "cause", "", "(ILjava/lang/String;Ljava/lang/Throwable;)V", "getErrorCode", "()I", "getErrorMessage", "()Ljava/lang/String;", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
    public static final class AttestSignFailedException extends RuntimeException {
        private final int errorCode;
        private final String errorMessage;

        public final int getErrorCode() {
            return this.errorCode;
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public AttestSignFailedException(int r100, String r101, Throwable r102) {
            StringBuilder r103 = new StringBuilder("Attest sign failed: ");
            r103.append(r101);
            r103.append(' ');
            if (r102 == null) goto L5;
            String r104 = "cause: [" + r102.getClass().getName() + ": " + r102.getMessage() + ']';
        L6:
            r103.append(r104);
            super(r103.toString(), r102);
            this.errorCode = r100;
            this.errorMessage = r101;
            return;
        L5:
            r104 = "";
            goto L6
        }

        public /* synthetic */ AttestSignFailedException(int r100, String r101, Throwable r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 4) == 0) goto L5;
            r102 = null;
        L5:
            this(r100, r101, r102);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/attestation/AttestSignResult$NoAttestSignCacheException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "lastResult", "Lcom/bytedance/android/sdk/bdticketguard/attestation/AttestSignResult;", "(Lcom/bytedance/android/sdk/bdticketguard/attestation/AttestSignResult;)V", "getLastResult", "()Lcom/bytedance/android/sdk/bdticketguard/attestation/AttestSignResult;", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
    public static final class NoAttestSignCacheException extends RuntimeException {
        private final AttestSignResult lastResult;

        public final AttestSignResult getLastResult() {
            return this.lastResult;
        }

        public NoAttestSignCacheException(AttestSignResult r100) {
            super("No attest sign cache, last result: " + r100);
            this.lastResult = r100;
        }
    }

    public static final class a {
        public static AttestSignResult a(String r110) {
            JSONObject r100 = new JSONObject(r110);     // Catch: Exception -> L7
            boolean r111 = JSONObjectProtectorUtils.getBoolean(r100, "isSuccess");     // Catch: Exception -> L7
            String r101 = JSONObjectProtectorUtils.getString(r100, "adapterName");     // Catch: Exception -> L7
            boolean r102 = JSONObjectProtectorUtils.getBoolean(r100, "isCached");     // Catch: Exception -> L7
            String r103 = JSONObjectProtectorUtils.getString(r100, "signContent");     // Catch: Exception -> L7
            AttestSignContent.f163541c.getClass();     // Catch: Exception -> L7
            AttestSignContent r104 = AttestSignContent.a.a(r103);     // Catch: Exception -> L7
            long r105 = JSONObjectProtectorUtils.getLong(r100, "durationNs");     // Catch: Exception -> L7
            String r106 = JSONObjectProtectorUtils.getString(r100, "attestPubKey");     // Catch: Exception -> L7
            if (r111 == false) goto L5;
            AttestSignResult r112 = new c(r101, JSONObjectProtectorUtils.getString(r100, "attestSign"), r102, r104, r105, r106);     // Catch: Exception -> L7
        L10:
            return r112;
        L5:
            r112 = new b(r101, new Exception(JSONObjectProtectorUtils.getString(r100, "error")), r100.optInt("errorCode", -1));     // Catch: Exception -> L7
        L7:
            e = move-exception;
            r0.d(6, "AttestSignResult", "fromJson error", e);
            return null;
        }
    }

    public static final class b extends AttestSignResult {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f163544b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Throwable f163545c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f163546d;

        public final int hashCode() {
            String r100 = this.f163544b;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Throwable r104 = this.f163545c;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return ((r103 + r101) * 31) + this.f163546d;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Failed(adapterName=" + this.f163544b + ", error=" + this.f163545c + ", errorCode=" + this.f163546d + ")";
        }

        @Override // com.bytedance.android.sdk.bdticketguard.attestation.AttestSignResult
        public final String a() {
            return this.f163544b;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L5;
        L17:
            return true;
        L5:
            if ((r100 instanceof b) == false) goto L16;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f163544b, r101.f163544b) == false) goto L16;
            if (Intrinsics.areEqual(this.f163545c, r101.f163545c) == false) goto L16;
            if (this.f163546d != r101.f163546d) goto L13;
            boolean r102 = true;
        L14:
            if (r102 == false) goto L16;
        L13:
            r102 = false;
        L16:
            return false;
        }

        public b(String r100, Throwable r101, int r102) {
            this.f163544b = r100;
            this.f163545c = r101;
            this.f163546d = r102;
        }
    }

    public static final class c extends AttestSignResult {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f163547b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f163548c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f163549d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AttestSignContent f163550e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f163551f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f163552g;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r2v12 */
        /* JADX WARN: Type inference failed for: r2v14 */
        /* JADX WARN: Type inference failed for: r2v4, types: [int] */
        public final int hashCode() {
            String r100 = this.f163547b;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f163548c;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            boolean r107 = this.f163549d;
            ?? r108 = r107;
            if (r107 == false) goto L13;
            r108 = 1;
        L13:
            int r109 = (r106 + r108) * 31;
            AttestSignContent r110 = this.f163550e;
            if (r110 == null) goto L16;
            int r111 = r110.hashCode();
        L17:
            int r112 = (r109 + r111) * 31;
            long r113 = this.f163551f;
            int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
            String r115 = this.f163552g;
            if (r115 == null) goto L21;
            r101 = r115.hashCode();
        L21:
            return r114 + r101;
        L16:
            r111 = 0;
            goto L17
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Success(adapterName=" + this.f163547b + ", attestSign=" + this.f163548c + ", isCached=" + this.f163549d + ", signContent=" + this.f163550e + ", durationNs=" + this.f163551f + ", attestPubKey=" + this.f163552g + ")";
        }

        @Override // com.bytedance.android.sdk.bdticketguard.attestation.AttestSignResult
        public final String a() {
            return this.f163547b;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L5;
        L26:
            return true;
        L5:
            if ((r100 instanceof c) == false) goto L25;
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f163547b, r101.f163547b) == false) goto L25;
            if (Intrinsics.areEqual(this.f163548c, r101.f163548c) == false) goto L25;
            if (this.f163549d != r101.f163549d) goto L13;
            boolean r102 = true;
        L14:
            if (r102 == false) goto L25;
            if (Intrinsics.areEqual(this.f163550e, r101.f163550e) == false) goto L25;
            if (this.f163551f != r101.f163551f) goto L20;
            boolean r103 = true;
        L21:
            if (r103 == false) goto L25;
            if (Intrinsics.areEqual(this.f163552g, r101.f163552g) == false) goto L25;
        L20:
            r103 = false;
            goto L21
        L13:
            r102 = false;
        L25:
            return false;
        }

        public c(String r100, String r101, boolean r102, AttestSignContent r103, long r104, String r105) {
            this.f163547b = r100;
            this.f163548c = r101;
            this.f163549d = r102;
            this.f163550e = r103;
            this.f163551f = r104;
            this.f163552g = r105;
        }
    }

    static {
    }

    public AttestSignResult() {
    }

    public abstract String a();
}
