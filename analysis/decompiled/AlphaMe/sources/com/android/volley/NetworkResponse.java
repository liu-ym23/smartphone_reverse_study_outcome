package com.android.volley;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public class NetworkResponse implements Serializable {
    private static final long serialVersionUID = -20150728102000L;
    public final byte[] data;
    public final Map<String, String> headers;
    public final long networkTimeMs;
    public final boolean notModified;
    public final int statusCode;

    public NetworkResponse(int i4, byte[] bArr, Map<String, String> map, boolean z4, long j4) {
        this.statusCode = i4;
        this.data = bArr;
        this.headers = map;
        this.notModified = z4;
        this.networkTimeMs = j4;
    }

    public NetworkResponse(int i4, byte[] bArr, Map<String, String> map, boolean z4) {
        this(i4, bArr, map, z4, 0L);
    }

    public NetworkResponse(byte[] bArr) {
        this(200, bArr, Collections.emptyMap(), false, 0L);
    }

    public NetworkResponse(byte[] bArr, Map<String, String> map) {
        this(200, bArr, map, false, 0L);
    }
}
