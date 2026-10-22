package stepos.support.v7.app;

import android.app.UiModeManager;
import android.content.Context;
import android.view.ActionMode;
import android.view.Window;
import stepos.support.v7.app.k;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class l extends k {
    public final UiModeManager U;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends k.b {
        public a(Window.Callback callback) {
            super(callback);
        }

        @Override // android.view.Window.Callback
        public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0060  */
        @Override // android.view.Window.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback r5, int r6) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.SecurityException, java.lang.IllegalArgumentException {
            /*
                r4 = this;
                stepos.support.v7.app.l r0 = stepos.support.v7.app.l.this
                boolean r0 = r0.R
                if (r0 == 0) goto L73
                if (r6 == 0) goto L9
                goto L73
            L9:
                fe.h$a r6 = new fe.h$a
                stepos.support.v7.app.k r4 = stepos.support.v7.app.k.this
                android.content.Context r0 = r4.f12125a
                r6.<init>(r0, r5)
                r0 = 0
                if (r5 != 0) goto L16
                goto L60
            L16:
                java.lang.Class r1 = r5.getClass()
                java.lang.String r1 = r1.getName()
                java.lang.String r2 = "com.android.internal.policy.impl.PhoneWindow$DecorView$ActionModeCallbackWrapper"
                boolean r2 = r1.equals(r2)
                if (r2 != 0) goto L2e
                java.lang.String r2 = "com.android.internal.policy.PhoneWindow$DecorView$ActionModeCallback2Wrapper"
                boolean r2 = r1.equals(r2)
                if (r2 == 0) goto L4f
            L2e:
                java.lang.Class r2 = r5.getClass()     // Catch: java.lang.Exception -> L4b
                java.lang.String r3 = "mWrapped"
                java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch: java.lang.Exception -> L4b
                r3 = 1
                r2.setAccessible(r3)     // Catch: java.lang.Exception -> L4b
                java.lang.Object r5 = r2.get(r5)     // Catch: java.lang.Exception -> L4b
                if (r5 == 0) goto L4f
                java.lang.Class r5 = r5.getClass()     // Catch: java.lang.Exception -> L4b
                java.lang.String r1 = r5.getName()     // Catch: java.lang.Exception -> L4b
                goto L4f
            L4b:
                r5 = move-exception
                r5.printStackTrace()
            L4f:
                java.lang.String r5 = "android.widget.AbsListView$MultiChoiceModeWrapper"
                boolean r5 = r1.equals(r5)
                if (r5 != 0) goto L62
                java.lang.String r5 = "stepos.support.v7.widget.StepOSRecyclerView$MultiChoiceModeWrapper"
                boolean r5 = r1.equals(r5)
                if (r5 == 0) goto L60
                goto L62
            L60:
                r5 = r0
                goto L66
            L62:
                fe.b r5 = r4.i(r6)
            L66:
                if (r5 != 0) goto L6c
                fe.b r5 = r4.j(r6)
            L6c:
                if (r5 == 0) goto L72
                fe.h r0 = r6.e(r5)
            L72:
                return r0
            L73:
                android.view.Window$Callback r4 = r4.f9831a
                android.view.ActionMode r4 = k.h.a.b(r4, r5, r6)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.app.l.a.onWindowStartingActionMode(android.view.ActionMode$Callback, int):android.view.ActionMode");
        }
    }

    public l(Context context, Window window, g gVar) {
        super(context, window, gVar);
        this.Q = -100;
        this.R = true;
        this.S = new k.a();
        this.U = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
    }

    @Override // stepos.support.v7.app.k
    public final int B(int i10) {
        if (i10 == 0 && this.U.getNightMode() == 0) {
            return -1;
        }
        return super.B(i10);
    }

    @Override // stepos.support.v7.app.i
    public final Window.Callback m(Window.Callback callback) {
        return new a(callback);
    }
}
