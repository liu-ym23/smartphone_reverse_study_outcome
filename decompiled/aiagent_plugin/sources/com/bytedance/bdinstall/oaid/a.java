package com.bytedance.bdinstall.oaid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.bytedance.bdinstall.oaid.impl.IDidAidlInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ASUSOaidImpl.java */
/* JADX INFO: loaded from: classes.dex */
final class a extends b<IDidAidlInterface> {
    @Override // com.bytedance.bdinstall.oaid.k
    public String b() {
        return "ASUS";
    }

    a() {
        super("com.asus.msa.SupplementaryDID");
    }

    @Override // com.bytedance.bdinstall.oaid.b
    public ServiceBlockBinder.a<IDidAidlInterface, String> a() {
        return new AnonymousClass1(this);
    }

    @Override // com.bytedance.bdinstall.oaid.b
    public Intent a(Context r3) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        Intent r4 = new Intent();
        r4.setAction("com.asus.msa.action.ACCESS_DID");
        r4.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        return r4;
    }
}
