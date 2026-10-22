package androidx.core.app;

import K.InterfaceC0077i;
import K.S;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.G;
import androidx.lifecycle.I;
import androidx.lifecycle.c0;
import e.EnumC0546d;
import java.util.WeakHashMap;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes.dex */
public abstract class k extends Activity implements G, InterfaceC0077i {

    @NotNull
    private final q.l extraDataMap = new q.l();

    @NotNull
    private final I lifecycleRegistry = new I(this);

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullExpressionValue(getWindow().getDecorView(), "window.decorView");
        WeakHashMap weakHashMap = S.f939a;
        return superDispatchKeyEvent(event);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(@NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullExpressionValue(getWindow().getDecorView(), "window.decorView");
        WeakHashMap weakHashMap = S.f939a;
        return super.dispatchKeyShortcutEvent(event);
    }

    @Deprecated(message = "Use {@link View#getTag(int)} with the window's decor view.")
    @RestrictTo({EnumC0546d.f12494c})
    @Nullable
    public <T extends j> T getExtraData(@NotNull Class<T> extraDataClass) {
        Intrinsics.checkNotNullParameter(extraDataClass, "extraDataClass");
        B0.g.y(this.extraDataMap.get(extraDataClass));
        return null;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i4 = c0.f3918a;
        y1.f.j(this);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        this.lifecycleRegistry.g();
        super.onSaveInstanceState(outState);
    }

    @Deprecated(message = "Use {@link View#setTag(int, Object)} with the window's decor view.")
    @RestrictTo({EnumC0546d.f12494c})
    public void putExtraData(@NotNull j extraData) {
        Intrinsics.checkNotNullParameter(extraData, "extraData");
        throw null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:13:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean shouldDumpInternalState(@org.jetbrains.annotations.Nullable java.lang.String[] r3) {
        /*
            r2 = this;
            r2 = 1
            r0 = 0
            if (r3 == 0) goto L40
            int r1 = r3.length
            if (r1 != 0) goto L8
            goto L40
        L8:
            r3 = r3[r0]
            int r1 = r3.hashCode()
            switch(r1) {
                case -645125871: goto L38;
                case 100470631: goto L2f;
                case 472614934: goto L26;
                case 1159329357: goto L1d;
                case 1455016274: goto L12;
                default: goto L11;
            }
        L11:
            goto L40
        L12:
            java.lang.String r1 = "--autofill"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L1b
            goto L40
        L1b:
            r0 = r2
            goto L40
        L1d:
            java.lang.String r1 = "--contentcapture"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L1b
            goto L40
        L26:
            java.lang.String r1 = "--list-dumpables"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L1b
            goto L40
        L2f:
            java.lang.String r1 = "--dump-dumpable"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L1b
            goto L40
        L38:
            java.lang.String r1 = "--translation"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L1b
        L40:
            r2 = r2 ^ r0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.k.shouldDumpInternalState(java.lang.String[]):boolean");
    }

    @Override // K.InterfaceC0077i
    @RestrictTo({EnumC0546d.f12494c})
    public boolean superDispatchKeyEvent(@NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return super.dispatchKeyEvent(event);
    }
}
