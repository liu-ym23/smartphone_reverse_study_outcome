package com.autonavi.aps.protocol.aps.request.model.fields;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private boolean f18945a = true;

    /* renamed from: b, reason: collision with root package name */
    private boolean f18946b = true;

    /* renamed from: c, reason: collision with root package name */
    private boolean f18947c = true;

    /* renamed from: d, reason: collision with root package name */
    private boolean f18948d = true;

    /* renamed from: e, reason: collision with root package name */
    private boolean f18949e = true;

    public String toString() {
        String hexString = Integer.toHexString((this.f18945a ? 128 : 0) | (this.f18946b ? 64 : 0) | (this.f18947c ? 32 : 0) | (this.f18948d ? 16 : 0) | (this.f18949e ? 8 : 0));
        if (hexString.length() != 1) {
            return hexString;
        }
        return "0" + hexString;
    }
}
