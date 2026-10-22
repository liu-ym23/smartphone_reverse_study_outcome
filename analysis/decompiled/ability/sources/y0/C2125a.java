package y0;

import android.os.MessageQueue;
import z0.C2153a;

/* renamed from: y0.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2125a implements MessageQueue.IdleHandler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2153a f6886a;

    public C2125a(C2153a c2153a) {
        this.f6886a = c2153a;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:5|(2:24|(1:26))(3:42|9|(2:12|(2:14|(1:18)))(2:11|39))|40|27|(3:30|31|28)|44|36|(1:38)|39) */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a9, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ac, code lost:
    
        if (H.h.b != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ae, code lost:
    
        android.util.Log.w("ApmInsight:ActivityLeakFixer", U7.a.e(new java.lang.String[]{"caught unexpected exception when unbind fragment.", r7.getMessage()}));
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.MessageQueue.IdleHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean queueIdle() {
        /*
            r7 = this;
            z0.a r7 = r7.f6886a
            java.lang.Object r7 = r7.get()
            android.app.Activity r7 = (android.app.Activity) r7
            r0 = 0
            if (r7 != 0) goto Lc
            return r0
        Lc:
            long r1 = java.lang.System.currentTimeMillis()
            android.view.Window r3 = r7.getWindow()
            java.lang.String r4 = "ApmInsight:ActivityLeakFixer"
            if (r3 == 0) goto L74
            android.view.Window r3 = r7.getWindow()
            android.view.View r3 = r3.peekDecorView()
            if (r3 == 0) goto L74
            boolean r3 = r7.isDestroyed()     // Catch: java.lang.Throwable -> L5d
            if (r3 != 0) goto L2a
            goto Le6
        L2a:
            android.view.Window r3 = r7.getWindow()     // Catch: java.lang.Throwable -> L5d
            android.content.Context r3 = r3.getContext()     // Catch: java.lang.Throwable -> L5d
            if (r3 != r7) goto L85
            android.view.Window r3 = r7.getWindow()     // Catch: java.lang.Throwable -> L5d
            android.view.View r3 = r3.peekDecorView()     // Catch: java.lang.Throwable -> L5d
            android.view.View r3 = r3.getRootView()     // Catch: java.lang.Throwable -> L5d
            r5 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r5 = r3.findViewById(r5)     // Catch: java.lang.Throwable -> L5d
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5     // Catch: java.lang.Throwable -> L5d
            int r6 = r5.getChildCount()     // Catch: java.lang.Throwable -> L5d
            if (r6 <= 0) goto L85
            android.view.View r5 = r5.getChildAt(r0)     // Catch: java.lang.Throwable -> L5d
            android.content.Context r5 = r5.getContext()     // Catch: java.lang.Throwable -> L5d
            if (r5 != r7) goto L85
            S0.b.B(r3, r7)     // Catch: java.lang.Throwable -> L5d
            goto L85
        L5d:
            r3 = move-exception
            boolean r5 = H.h.b
            if (r5 == 0) goto L85
            java.lang.String r5 = "caught unexpected exception when unbind drawables."
            java.lang.String r3 = r3.getMessage()
            java.lang.String[] r3 = new java.lang.String[]{r5, r3}
            java.lang.String r3 = U7.a.e(r3)
            android.util.Log.w(r4, r3)
            goto L85
        L74:
            boolean r3 = H.h.b
            if (r3 == 0) goto L85
            java.lang.String r3 = "unbindDrawables, ui or ui's window is null, skip rest works."
            java.lang.String[] r3 = new java.lang.String[]{r3}
            java.lang.String r3 = U7.a.e(r3)
            android.util.Log.i(r4, r3)
        L85:
            android.app.FragmentManager r3 = r7.getFragmentManager()     // Catch: java.lang.Throwable -> La9
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.Throwable -> La9
            r5.<init>()     // Catch: java.lang.Throwable -> La9
            java.util.List r3 = r3.getFragments()     // Catch: java.lang.Throwable -> La9
            r5 = r0
        L93:
            int r6 = r3.size()     // Catch: java.lang.Throwable -> La9
            if (r5 >= r6) goto Lbf
            java.lang.Object r6 = r3.get(r5)     // Catch: java.lang.Throwable -> La9
            android.app.Fragment r6 = (android.app.Fragment) r6     // Catch: java.lang.Throwable -> La9
            android.view.View r6 = r6.getView()     // Catch: java.lang.Throwable -> La9
            S0.b.B(r6, r7)     // Catch: java.lang.Throwable -> La9
            int r5 = r5 + 1
            goto L93
        La9:
            r7 = move-exception
            boolean r3 = H.h.b
            if (r3 == 0) goto Lbf
            java.lang.String r3 = "caught unexpected exception when unbind fragment."
            java.lang.String r7 = r7.getMessage()
            java.lang.String[] r7 = new java.lang.String[]{r3, r7}
            java.lang.String r7 = U7.a.e(r7)
            android.util.Log.w(r4, r7)
        Lbf:
            boolean r7 = H.h.b
            if (r7 == 0) goto Le6
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r3 = "unbindDrawables done, cost: "
            r7.<init>(r3)
            long r5 = java.lang.System.currentTimeMillis()
            long r5 = r5 - r1
            r7.append(r5)
            java.lang.String r1 = " ms."
            r7.append(r1)
            java.lang.String r7 = r7.toString()
            java.lang.String[] r7 = new java.lang.String[]{r7}
            java.lang.String r7 = U7.a.e(r7)
            android.util.Log.i(r4, r7)
        Le6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: y0.C2125a.queueIdle():boolean");
    }
}
