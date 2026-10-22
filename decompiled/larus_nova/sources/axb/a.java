package axb;

import android.app.Application;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.utils.di.d;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officesdk.utils.di.r;
import dxb.c;
import dxb.g;
import dxb.t;
import java.io.IOException;
import java.util.zip.ZipInputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f16645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ cxb.a f16646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f16647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f16648d;

    public final void a() {
        j.e("WebErrorPageUIOptimize", "start try unzip error page");
        int r100 = d.f437220a;
        Application r101 = d.a.a();
        if (r101 != null) goto L6;
        j.e("WebErrorPageUIOptimize", "context not init");
        return;
    L6:
        String r102 = b.b(r101);
        boolean r103 = false;
        if (r102 != null) goto L9;
    L14:
        boolean r104 = false;
    L15:
        if (r104 == false) goto L20;
        j.e("WebErrorPageUIOptimize", "error page exists, jump unzip");
        Runnable r105 = this.f16645a;
        if (r105 == null) goto L36;
        r105.run();
        return;
    L36:
        return;
    L20:
        long r106 = System.currentTimeMillis();
        String r107 = b.a(r101, "lk_error_page");     // Catch: Throwable -> L32
        if (r107 != null) goto L24;
    L25:
        r103 = true;
    L26:
        if (r103 == true) goto L31;
        ZipInputStream r108 = new ZipInputStream(r101.getAssets().open("lk_error_page_html.zip"));     // Catch: Throwable -> L32
        int r109 = r.f437233a;     // Catch: Throwable -> L32
        r.a.c(r108, r107);     // Catch: Throwable -> L32
        j.e("WebErrorPageUIOptimize", "unzip error page cost :" + (System.currentTimeMillis() - r106));     // Catch: Throwable -> L32
        Runnable r110 = this.f16645a;     // Catch: Throwable -> L32
        if (r110 == null) goto L37;
        r110.run();     // Catch: Throwable -> L32
        return;
    L37:
        return;
    L31:
        throw new IOException("outPathString is null");     // Catch: Throwable -> L32
    L24:
        if (r107.length() != 0) goto L26;
    L32:
        th = move-exception;
        int r111 = t.f470510a;
        cxb.a r112 = this.f16646b;
        String r113 = this.f16647c;
        String r114 = "unzip error pag error:" + this.f16648d;
        Intrinsics.checkNotNullParameter(r114, "message");
        g r115 = new g("wb_container_error_page_message", c.f470468m, r112);
        t.c(r115, r113);
        r115.a("error_page_message", r114);
        r115.b();
        j.b("WebErrorPageUIOptimize", "unzip error page error:" + th.getMessage());
        return;
    L9:
        if (r102.length() <= 0) goto L11;
        boolean r116 = true;
    L12:
        if (r116 != true) goto L14;
        r104 = true;
        goto L15
    L11:
        r116 = false;
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

    public a(cxb.a r100, String r101) {
        this.f16645a = null;
        this.f16646b = r100;
        this.f16647c = r101;
        this.f16648d = false;
    }
}
