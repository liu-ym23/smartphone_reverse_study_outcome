package com.baidu.lbsapi.auth;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Hashtable;
import javax.crypto.NoSuchPaddingException;

/* loaded from: classes.dex */
class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4949a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f4950b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f4951c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f4952d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Hashtable f4953e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ LBSAuthManager f4954f;

    public m(LBSAuthManager lBSAuthManager, int i4, boolean z4, String str, String str2, Hashtable hashtable) {
        this.f4954f = lBSAuthManager;
        this.f4949a = i4;
        this.f4950b = z4;
        this.f4951c = str;
        this.f4952d = str2;
        this.f4953e = hashtable;
    }

    @Override // java.lang.Runnable
    public void run() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        b.a("status = " + this.f4949a + "; forced = " + this.f4950b + "checkAK = " + this.f4954f.a(this.f4951c, this.f4952d));
        int i4 = this.f4949a;
        if (i4 != 601 && !this.f4950b && i4 != -1 && !this.f4954f.a(this.f4951c, this.f4952d)) {
            if (602 == this.f4949a) {
                b.a("authenticate wait ");
                if (LBSAuthManager.f4905h != null) {
                    LBSAuthManager.f4905h.b();
                }
            } else {
                b.a("authenticate else");
            }
            this.f4954f.a(this.f4951c, (String) null, this.f4952d);
            return;
        }
        b.a("authenticate sendAuthRequest");
        String[] strArrB = d.b(LBSAuthManager.f4900a);
        if (strArrB == null || strArrB.length <= 1) {
            this.f4954f.a(this.f4950b, this.f4951c, this.f4953e, this.f4952d, LBSAuthManager.f4901b, LBSAuthManager.f4902c, LBSAuthManager.f4903d, LBSAuthManager.f4904e);
            return;
        }
        b.a("authStrings.length:" + strArrB.length);
        b.a("more sha1 auth");
        this.f4954f.a(this.f4950b, this.f4951c, this.f4953e, strArrB, this.f4952d, LBSAuthManager.f4901b, LBSAuthManager.f4902c, LBSAuthManager.f4903d, LBSAuthManager.f4904e);
    }
}
