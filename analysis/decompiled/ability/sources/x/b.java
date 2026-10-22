package x;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes2.dex */
public final class b extends K1.b {
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(String str, int i) {
        super(str);
        this.c = i;
    }

    @Override // K1.b
    public final o a() {
        switch (this.c) {
            case 0:
                return new C2111a();
            case 1:
                return new e();
            case 2:
                return new h();
            default:
                return new m();
        }
    }

    @Override // K1.b
    public final Intent b(Context context) {
        switch (this.c) {
            case 0:
                Intent intent = new Intent();
                intent.setAction("com.asus.msa.action.ACCESS_DID");
                intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
                return intent;
            case 1:
                Intent intent2 = new Intent();
                intent2.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
                intent2.setAction("com.bun.msa.action.bindto.service");
                intent2.putExtra("com.bun.msa.param.pkgname", context.getPackageName());
                return intent2;
            case 2:
                Intent intent3 = new Intent();
                intent3.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
                return intent3;
            default:
                Intent intent4 = new Intent();
                intent4.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
                return intent4;
        }
    }

    @Override // K1.b, x.j
    public D9.n c(Context context) {
        switch (this.c) {
            case 1:
                String packageName = context.getPackageName();
                Intent intent = new Intent();
                intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
                intent.setAction("com.bun.msa.action.start.service");
                intent.putExtra("com.bun.msa.param.pkgname", packageName);
                try {
                    intent.putExtra("com.bun.msa.param.runinset", true);
                    context.startService(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
        return super.c(context);
    }
}
