package com.android.volley;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class NetworkResponse {
    public final byte[] data;
    public final Map<String, String> headers;
    public final long networkTimeMs;
    public final boolean notModified;
    public final int statusCode;

    public NetworkResponse(int r10, byte[] r11, Map<String, String> r12, boolean r13, long r14) {
        this.statusCode = r10;
        this.data = r11;
        this.headers = r12;
        this.notModified = r13;
        this.networkTimeMs = r14;
    }

    public NetworkResponse(int r10, byte[] r11, Map<String, String> r12, boolean r13) {
        this(r10, r11, r12, r13, 0);
    }

    public NetworkResponse(byte[] r10) {
        this(200, r10, Collections.emptyMap(), false, 0);
    }

    public NetworkResponse(byte[] r10, Map<String, String> r11) {
        this(200, r10, r11, false, 0);
    }
}
