package com.google.android.datatransport.runtime.backends;

/* loaded from: classes2.dex */
public abstract class BackendResponse {

    public enum Status {
        OK,
        TRANSIENT_ERROR,
        FATAL_ERROR
    }

    public static BackendResponse a() {
        return new a(Status.FATAL_ERROR, -1L);
    }

    public static BackendResponse d(long j10) {
        return new a(Status.OK, j10);
    }

    public static BackendResponse e() {
        return new a(Status.TRANSIENT_ERROR, -1L);
    }

    public abstract long b();

    public abstract Status c();
}
