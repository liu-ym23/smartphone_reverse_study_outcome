package awb;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f16599a;

    public b(c r100) {
        this.f16599a = r100;
    }

    public final void a() {
        c r100 = this.f16599a;
        CharSequence r101 = r100.f16600a.getText();
        boolean r102 = false;
        if (r101 == null) goto L16;
        int r103 = r101.length();
        int r104 = r100.f16600a.getSelectionStart();
        int r105 = r100.f16600a.getSelectionEnd();
        if (r104 < 0) goto L16;
        if (r105 < 0) goto L16;
        int r106 = Math.max(0, Math.min(r104, r105));
        int r107 = Math.max(0, Math.max(r104, r105));
        if (r106 == r107) goto L16;
        if (r106 < 0) goto L16;
        if (r107 < 0) goto L16;
        if (r107 > r103) goto L16;
        String r108 = r101.subSequence(r106, r107).toString();
    L18:
        if (r108.length() != 0) goto L20;
        r102 = true;
    L20:
        if (r102 == false) goto L23;
        return;
    L23:
        if (Intrinsics.areEqual(r108, this.f16599a.f16603d) == true) goto L25;
    L26:
        c r109 = this.f16599a;
        r109.f16603d = r108;
        r109.f16604e = System.currentTimeMillis();
        Function1<String, Unit> r110 = this.f16599a.f16601b.f16607b;
        if (r110 == null) goto L31;
        r110.invoke(r108);
        return;
    L31:
        return;
    L25:
        if ((System.currentTimeMillis() - this.f16599a.f16604e) > 1000) goto L26;
        return;
    L16:
        r108 = "";
        goto L18
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
}
