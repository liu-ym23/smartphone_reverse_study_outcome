package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.BackendResponse;

/* loaded from: classes2.dex */
public final class a extends BackendResponse {

    /* renamed from: a, reason: collision with root package name */
    public final BackendResponse.Status f19387a;

    /* renamed from: b, reason: collision with root package name */
    public final long f19388b;

    public a(BackendResponse.Status status, long j10) {
        if (status == null) {
            throw new NullPointerException("Null status");
        }
        this.f19387a = status;
        this.f19388b = j10;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendResponse
    public long b() {
        return this.f19388b;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendResponse
    public BackendResponse.Status c() {
        return this.f19387a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BackendResponse) {
            BackendResponse backendResponse = (BackendResponse) obj;
            if (this.f19387a.equals(backendResponse.c()) && this.f19388b == backendResponse.b()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.f19387a.hashCode() ^ 1000003) * 1000003;
        long j10 = this.f19388b;
        return ((int) (j10 ^ (j10 >>> 32))) ^ iHashCode;
    }

    public String toString() {
        return "BackendResponse{status=" + this.f19387a + ", nextRequestWaitMillis=" + this.f19388b + "}";
    }
}
