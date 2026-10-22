package asa;

import android.app.Dialog;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.bytedcert.base.BytedCertSdkAbsActivity;
import com.ss.android.bytedcert.dialog.LoadingDialog;
import com.ss.android.cert.manager.ablity.ICertDialogDepend;
import com.ss.android.cert.manager.ablity.ICertLoadingDialog;
import rsa.b;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f16172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f16173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BytedCertSdkAbsActivity f16174c;

    /* JADX INFO: renamed from: asa.a$a, reason: collision with other inner class name */
    public class RunnableC0221a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f16175a;

        @Override // java.lang.Runnable
        public final void run() {
            Object r100 = this.f16175a.f16174c.f407262b;     // Catch: Throwable -> L9
            if ((r100 instanceof Dialog) == false) goto L6;
            ((Dialog) r100).setCancelable(true);     // Catch: Throwable -> L9
        L14:
            return;
        L6:
            if ((r100 instanceof LoadingDialog) == false) goto L14;
            ((LoadingDialog) r100).getDialog().setCancelable(true);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }

        public RunnableC0221a(a r100) {
            this.f16175a = r100;
        }
    }

    public final void a() {
        if (this.f16174c.B1() == false) goto L23;
        return;
    L23:
        ICertLoadingDialog r100 = this.f16174c.f407262b;     // Catch: Exception -> L22
        if (r100 != null) goto L8;
    L12:
        ICertDialogDepend r101 = this.f16174c.z1();     // Catch: Exception -> L22
        if (r101 != null) goto L15;
        BytedCertSdkAbsActivity r102 = this.f16174c;     // Catch: Exception -> L22
        r102.f407262b = LoadingDialog.create(this.f16174c, this.f16172a, this.f16173b);     // Catch: Exception -> L22
    L18:
        b.c(this.f16174c.f407262b);     // Catch: Exception -> L22
        if (this.f16173b == true) goto L24;
        this.f16174c.f407261a.postDelayed(new RunnableC0221a(this), 5000);     // Catch: Exception -> L22
        return;
    L24:
        return;
    L15:
        BytedCertSdkAbsActivity r103 = this.f16174c;     // Catch: Exception -> L22
        r103.f407262b = r101.showLoading(r103, this.f16172a);     // Catch: Exception -> L22
        Object r104 = this.f16174c.f407262b;     // Catch: Exception -> L22
        if ((r104 instanceof Dialog) == false) goto L18;
        ((Dialog) r104).setCancelable(this.f16173b);     // Catch: Exception -> L22
        goto L18
    L8:
        if ((r100 instanceof LoadingDialog) == false) goto L11;
        ((LoadingDialog) r100).setText(this.f16172a);     // Catch: Exception -> L22
        this.f16174c.f407262b.show();     // Catch: Exception -> L22
        return;
    L11:
        b.b(r100);     // Catch: Exception -> L22
        goto L12
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(BytedCertSdkAbsActivity r100, String r101) {
        this.f16174c = r100;
        this.f16172a = r101;
        this.f16173b = false;
    }
}
