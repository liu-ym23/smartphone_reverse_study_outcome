package com.ss.android.deviceregister.base;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ASUSOaidImpl.java */
/* JADX INFO: loaded from: classes4.dex */
final class a extends c<IDidAidlInterface> {
    a() {
        super("com.asus.msa.SupplementaryDID");
    }

    @Override // com.ss.android.deviceregister.base.c
    public ServiceBlockBinder.a<IDidAidlInterface, String> a() {
        return new AnonymousClass1(this);
    }

    @Override // com.ss.android.deviceregister.base.c
    public Intent a(Context r3) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        Intent r4 = new Intent();
        r4.setAction("com.asus.msa.action.ACCESS_DID");
        r4.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        return r4;
    }
}
