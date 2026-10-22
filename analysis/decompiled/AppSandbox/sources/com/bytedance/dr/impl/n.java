package com.bytedance.dr.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.bdtracker.e6;
import com.bytedance.dr.aidl.c;

/* loaded from: classes.dex */
public final class n extends b<com.bytedance.dr.aidl.c> {

    public class a implements e6.b<com.bytedance.dr.aidl.c, String> {
        public a(n nVar) {
        }

        @Override // com.bytedance.bdtracker.e6.b
        public com.bytedance.dr.aidl.c a(IBinder iBinder) {
            return c.a.a(iBinder);
        }

        @Override // com.bytedance.bdtracker.e6.b
        public String a(com.bytedance.dr.aidl.c cVar) {
            return ((c.a.C0005a) cVar).a();
        }
    }

    public n() {
        super("com.samsung.android.deviceidservice");
    }

    @Override // com.bytedance.dr.impl.b
    public Intent a(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        return intent;
    }

    @Override // com.bytedance.dr.impl.b
    public e6.b<com.bytedance.dr.aidl.c, String> a() {
        return new a(this);
    }

    @Override // com.bytedance.dr.OaidApi
    public String getName() {
        return "Samsung";
    }
}
