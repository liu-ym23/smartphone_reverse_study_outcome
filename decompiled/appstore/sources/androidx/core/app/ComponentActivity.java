package androidx.core.app;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.core.os.BuildCompat;
import androidx.core.view.KeyEventDispatcher;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ComponentActivity extends Activity implements LifecycleOwner, KeyEventDispatcher.Component {
    private SimpleArrayMap mExtraDataMap;
    private LifecycleRegistry mLifecycleRegistry;

    public static class ExtraData {
        public ExtraData() {
        }
    }

    public ComponentActivity() {
        this.mExtraDataMap = new SimpleArrayMap();
        this.mLifecycleRegistry = new LifecycleRegistry(this);
    }

    public static boolean a(String[] r10) {
        if (r10 != null) goto L5;
    L39:
        return false;
    L5:
        if (r10.length <= 0) goto L39;
        String r11 = r10[0];
        r11.hashCode();
        byte r12 = -1;
        switch(r11.hashCode()) {
            case -645125871: goto L26;
            case 100470631: goto L22;
            case 472614934: goto L18;
            case 1159329357: goto L14;
            case 1455016274: goto L10;
            default: goto L29;
        };
    L29:
        switch(r12) {
            case 0: goto L35;
            case 1: goto L33;
            case 2: goto L33;
            case 3: goto L31;
            case 4: goto L31;
            default: goto L39;
        };
    L31:
        return true;
    L33:
        return BuildCompat.c();
    L35:
        if (Build.VERSION.SDK_INT < 31) goto L38;
        return true;
    L38:
        return false;
    L10:
        if (r11.equals("--autofill") == false) goto L29;
        r12 = 4;
        goto L29
    L14:
        if (r11.equals("--contentcapture") == false) goto L29;
        r12 = 3;
        goto L29
    L18:
        if (r11.equals("--list-dumpables") == false) goto L29;
        r12 = 2;
        goto L29
    L22:
        if (r11.equals("--dump-dumpable") == false) goto L29;
        r12 = 1;
        goto L29
    L26:
        if (r11.equals("--translation") == false) goto L29;
        r12 = 0;
        goto L29
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent r10) {
        View r11 = getWindow().getDecorView();
        if (r11 == null) goto L9;
        if (KeyEventDispatcher.a(r11, r10) == false) goto L9;
        return true;
    L9:
        return KeyEventDispatcher.b(this, r11, this, r10);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent r10) {
        View r11 = getWindow().getDecorView();
        if (r11 == null) goto L9;
        if (KeyEventDispatcher.a(r11, r10) == false) goto L9;
        return true;
    L9:
        return super.dispatchKeyShortcutEvent(r10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public <T extends ExtraData> T getExtraData(Class<T> r10) {
        return (T) this.mExtraDataMap.get(r10);
    }

    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        ReportFragment.d(this);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle r10) {
        this.mLifecycleRegistry.j(Lifecycle.State.CREATED);
        super.onSaveInstanceState(r10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public void putExtraData(ExtraData r10) {
        this.mExtraDataMap.put(r10.getClass(), r10);
    }

    public final boolean shouldDumpInternalState(@Nullable String[] r10) {
        return !a(r10);
    }

    @Override // androidx.core.view.KeyEventDispatcher.Component
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean superDispatchKeyEvent(@NonNull KeyEvent r10) {
        return super.dispatchKeyEvent(r10);
    }
}
