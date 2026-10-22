package cn.com.chinatelecom.account;

import android.content.Context;
import cn.com.chinatelecom.account.api.Helper;

/* JADX INFO: loaded from: classes28.dex */
public class a0 implements u {
    public a0() {
    }

    @Override // cn.com.chinatelecom.account.u
    public String a(Context r110, String r111, String r112, String r113, long r114, boolean r115, String r116) {
        return Helper.dnepah(r110, r111, r112, r113, r114, false, r115, r116);
    }

    @Override // cn.com.chinatelecom.account.u
    public String a(String r100, String r101) {
        byte[] r102 = Helper.dnepmret(b0.a(r100), r101);     // Catch: Throwable -> L8
        if (r102 != null) goto L6;
        return "";
    L6:
        return new String(r102);
    L8:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    @Override // cn.com.chinatelecom.account.u
    public String a(boolean r100) {
        return Helper.cepahsul(r100);
    }
}
