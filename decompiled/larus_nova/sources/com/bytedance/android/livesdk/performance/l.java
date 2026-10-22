package com.bytedance.android.livesdk.performance;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;

/* JADX INFO: loaded from: classes11.dex */
public final class l implements ff7.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ File f154675a;

    @Override // ff7.e
    public final void onSuccess() {
        boolean r100 = m.f154681a;
        m.d(true, this.f154675a);
    }

    public l(PolarisFileWrapper r100) {
        this.f154675a = r100;
    }

    @Override // ff7.e
    public final void onFail(String r100) {
        boolean r101 = m.f154681a;
        m.d(false, this.f154675a);
    }
}
