package androidx.core.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.collection.SimpleArrayMap;
import androidx.core.os.BuildCompat;
import androidx.core.view.KeyEventDispatcher;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;

/* JADX INFO: loaded from: classes.dex */
public class ComponentActivity extends Activity implements LifecycleOwner, KeyEventDispatcher.Component {
    private SimpleArrayMap<Class<? extends ExtraData>, ExtraData> mExtraDataMap;
    private LifecycleRegistry mLifecycleRegistry;

    @Deprecated
    public static class ExtraData {
        public ExtraData() {
        }
    }

    public ComponentActivity() {
        this.mExtraDataMap = new SimpleArrayMap();
        this.mLifecycleRegistry = new LifecycleRegistry(this);
    }

    @Deprecated
    public void putExtraData(ExtraData r2) {
        this.mExtraDataMap.put((Class<? extends ExtraData>) r2.getClass(), r2);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle r1) {
        super.onCreate(r1);
        ReportFragment.injectIfNeededIn(this);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle r3) {
        this.mLifecycleRegistry.markState(Lifecycle.State.CREATED);
        super.onSaveInstanceState(r3);
    }

    @Deprecated
    public <T extends ExtraData> T getExtraData(Class<T> r1) {
        return (T) this.mExtraDataMap.get(r1);
    }

    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.core.view.KeyEventDispatcher.Component
    public boolean superDispatchKeyEvent(KeyEvent r1) {
        return super.dispatchKeyEvent(r1);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent r2) {
        View r0 = getWindow().getDecorView();
        if (r0 == null) goto L9;
        if (KeyEventDispatcher.dispatchBeforeHierarchy(r0, r2) == false) goto L9;
        return true;
    L9:
        return super.dispatchKeyShortcutEvent(r2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent r3) {
        View r0 = getWindow().getDecorView();
        if (r0 == null) goto L9;
        if (KeyEventDispatcher.dispatchBeforeHierarchy(r0, r3) == false) goto L9;
        return true;
    L9:
        return KeyEventDispatcher.dispatchKeyEvent(this, r0, this, r3);
    }

    protected final boolean shouldDumpInternalState(String[] r1) {
        return !shouldSkipDump(r1);
    }

    private static boolean shouldSkipDump(String[] r4) {
        if (r4 != null) goto L5;
    L35:
        return false;
    L5:
        if (r4.length <= 0) goto L35;
        String r5 = r4[0];
        r5.hashCode();
        byte r3 = -1;
        switch(r5.hashCode()) {
            case -645125871: goto L26;
            case 100470631: goto L22;
            case 472614934: goto L18;
            case 1159329357: goto L14;
            case 1455016274: goto L10;
            default: goto L29;
        };
    L29:
        switch(r3) {
            case 0: goto L34;
            case 1: goto L33;
            case 2: goto L33;
            case 3: goto L31;
            case 4: goto L31;
            default: goto L35;
        };
    L31:
        return true;
    L34:
        return true;
    L33:
        return BuildCompat.isAtLeastT();
    L10:
        if (r5.equals("--autofill") == false) goto L29;
        r3 = 4;
        goto L29
    L14:
        if (r5.equals("--contentcapture") == false) goto L29;
        r3 = 3;
        goto L29
    L18:
        if (r5.equals("--list-dumpables") == false) goto L29;
        r3 = 2;
        goto L29
    L22:
        if (r5.equals("--dump-dumpable") == false) goto L29;
        r3 = 1;
        goto L29
    L26:
        if (r5.equals("--translation") == false) goto L29;
        r3 = 0;
        goto L29
    }
}
