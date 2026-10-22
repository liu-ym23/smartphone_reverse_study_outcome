package a6;

import android.content.Context;
import com.stepos.aiengine.cta.WithdrawActivity;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f49b;

    public /* synthetic */ e(Context context, int i10) {
        this.f48a = i10;
        this.f49b = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00aa  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() throws android.content.pm.PackageManager.NameNotFoundException, java.io.IOException {
        /*
            r6 = this;
            int r0 = r6.f48a
            r1 = 1
            android.content.Context r6 = r6.f49b
            switch(r0) {
                case 0: goto Lc5;
                case 1: goto L43;
                case 2: goto L2e;
                case 3: goto L2a;
                case 4: goto L26;
                case 5: goto L14;
                default: goto L8;
            }
        L8:
            t1.b r0 = new t1.b
            r0.<init>()
            androidx.profileinstaller.c$a r1 = androidx.profileinstaller.c.f2454a
            r2 = 0
            androidx.profileinstaller.c.b(r6, r0, r1, r2)
            return
        L14:
            r0 = 2131886493(0x7f12019d, float:1.9407566E38)
            android.widget.Toast r6 = android.widget.Toast.makeText(r6, r0, r1)     // Catch: java.lang.Throwable -> L21
            r6.show()     // Catch: java.lang.Throwable -> L21
            lb.n r6 = lb.n.f10413a     // Catch: java.lang.Throwable -> L21
            goto L25
        L21:
            r6 = move-exception
            kotlin.c.a(r6)
        L25:
            return
        L26:
            com.stepos.core.ota.deepbinder.OtaInteractiveDownloadFlow.j(r6)
            return
        L2a:
            com.stepos.core.ota.OtaEngine.b(r6)
            return
        L2e:
            int r0 = com.stepos.aiengine.cta.WithdrawActivity.f5770c
            k6.b r0 = k6.b.f9949a     // Catch: java.lang.Throwable -> L3e
            kotlin.jvm.internal.g.c(r6)     // Catch: java.lang.Throwable -> L3e
            r0.getClass()     // Catch: java.lang.Throwable -> L3e
            k6.b.a(r6)     // Catch: java.lang.Throwable -> L3e
            lb.n r6 = lb.n.f10413a     // Catch: java.lang.Throwable -> L3e
            goto L42
        L3e:
            r6 = move-exception
            kotlin.c.a(r6)
        L42:
            return
        L43:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 33
            if (r0 < r2) goto Lc2
            android.content.ComponentName r3 = new android.content.ComponentName
            java.lang.String r4 = "androidx.appcompat.app.AppLocalesMetadataHolderService"
            r3.<init>(r6, r4)
            android.content.pm.PackageManager r4 = r6.getPackageManager()
            int r4 = r4.getComponentEnabledSetting(r3)
            if (r4 == r1) goto Lc2
            java.lang.String r4 = "locale"
            if (r0 < r2) goto L99
            p.b<java.lang.ref.WeakReference<androidx.appcompat.app.k>> r0 = androidx.appcompat.app.k.f333j
            r0.getClass()
            p.b$a r2 = new p.b$a
            r2.<init>()
        L68:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L87
            java.lang.Object r0 = r2.next()
            java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0
            java.lang.Object r0 = r0.get()
            androidx.appcompat.app.k r0 = (androidx.appcompat.app.k) r0
            if (r0 == 0) goto L68
            android.content.Context r0 = r0.e()
            if (r0 == 0) goto L68
            java.lang.Object r0 = r0.getSystemService(r4)
            goto L88
        L87:
            r0 = 0
        L88:
            if (r0 == 0) goto L9e
            android.os.LocaleList r0 = androidx.appcompat.app.k.b.a(r0)
            r0.d r2 = new r0.d
            r0.f r5 = new r0.f
            r5.<init>(r0)
            r2.<init>(r5)
            goto La0
        L99:
            r0.d r2 = androidx.appcompat.app.k.f330c
            if (r2 == 0) goto L9e
            goto La0
        L9e:
            r0.d r2 = r0.d.f11676b
        La0:
            r0.f r0 = r2.f11677a
            android.os.LocaleList r0 = r0.f11679a
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto Lbb
            java.lang.String r0 = androidx.core.app.b.b(r6)
            java.lang.Object r2 = r6.getSystemService(r4)
            if (r2 == 0) goto Lbb
            android.os.LocaleList r0 = androidx.appcompat.app.k.a.a(r0)
            androidx.appcompat.app.k.b.b(r2, r0)
        Lbb:
            android.content.pm.PackageManager r6 = r6.getPackageManager()
            r6.setComponentEnabledSetting(r3, r1, r1)
        Lc2:
            androidx.appcompat.app.k.h = r1
            return
        Lc5:
            com.stepos.aicgroup.resource.ResourcePressureSceneManager.c(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.e.run():void");
    }

    public /* synthetic */ e(WithdrawActivity withdrawActivity, Context context) {
        this.f48a = 2;
        this.f49b = context;
    }
}
