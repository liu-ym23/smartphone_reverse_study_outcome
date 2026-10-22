package com.bytedance.android.sdk.bdticketguard.key;

import android.util.Base64;
import com.bytedance.android.sdk.bdticketguard.r0;
import net.bytedance.zdplib.Delta;
import net.bytedance.zdplib.DeltaSignerVerifier;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f163909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DeltaSignerVerifier f163910c;

    @Override // com.bytedance.android.sdk.bdticketguard.key.f
    public final boolean b() {
        return true;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.key.f
    public final String a(int r100) {
        return Base64.encodeToString(Delta.e(this.f163909b), 2);
    }

    public n(boolean r100, String r101, DeltaSignerVerifier r102) {
        super(r100);
        this.f163909b = r101;
        this.f163910c = r102;
        int r103 = r0.f163979a;
        r0.a("ReeKeyObject", "ree public key=" + r101);
        Base64.encodeToString(Delta.e(r101), 2);
    }
}
