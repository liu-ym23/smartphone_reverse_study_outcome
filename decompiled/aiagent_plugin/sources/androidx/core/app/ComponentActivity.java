package androidx.core.app;

import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.lifecycle.ReportFragment;
import com.volcengine.zeus.activity.GeneratePluginActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class ComponentActivity extends GeneratePluginActivity implements androidx.core.view.e.a, androidx.lifecycle.p {
    private androidx.b.g<Class<? extends a>, a> mExtraDataMap;
    private androidx.lifecycle.r mLifecycleRegistry;

    @Deprecated
    public static class a {
        public a() {
        }
    }

    public String getPluginPkgName() {
        return "com.obric.aiagent.plugin";
    }

    public ComponentActivity() {
        this.mExtraDataMap = new androidx.b.g();
        this.mLifecycleRegistry = new androidx.lifecycle.r(this);
    }

    @Deprecated
    public void putExtraData(a r2) {
        this.mExtraDataMap.put((Class<? extends a>) r2.getClass(), r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle r1) {
        super/*android.app.Activity*/.onCreate(r1);
        ReportFragment.injectIfNeededIn(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onSaveInstanceState(Bundle r3) {
        this.mLifecycleRegistry.a(androidx.lifecycle.i.b.f2056c);
        super/*android.app.Activity*/.onSaveInstanceState(r3);
    }

    @Deprecated
    public <T extends a> T getExtraData(Class<T> r2) {
        return (T) ZeusTransformUtils.preCheckCast(this.mExtraDataMap.get(r2), a.class, "com.obric.aiagent.plugin");
    }

    public androidx.lifecycle.i getLifecycle() {
        return this.mLifecycleRegistry;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.core.view.e.a
    public boolean superDispatchKeyEvent(KeyEvent r1) {
        return super/*android.app.Activity*/.dispatchKeyEvent(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean dispatchKeyShortcutEvent(KeyEvent r2) {
        View r0 = getWindow().getDecorView();
        if (r0 == null) goto L9;
        if (androidx.core.view.e.a(r0, r2) == false) goto L9;
        return true;
    L9:
        return super/*android.app.Activity*/.dispatchKeyShortcutEvent(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean dispatchKeyEvent(KeyEvent r3) {
        View r0 = getWindow().getDecorView();
        if (r0 == null) goto L9;
        if (androidx.core.view.e.a(r0, r3) == false) goto L9;
        return true;
    L9:
        return androidx.core.view.e.a(this, r0, this, r3);
    }

    public final boolean shouldDumpInternalState(String[] r1) {
        return !shouldSkipDump(r1);
    }

    private static boolean shouldSkipDump(String[] r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        if (r4.length <= 0) goto L51;
        String r5 = r4[0];
        r5.hashCode();
        byte r1 = -1;
        switch(r5.hashCode()) {
            case -645125871: goto L26;
            case 100470631: goto L22;
            case 472614934: goto L18;
            case 1159329357: goto L14;
            case 1455016274: goto L10;
            default: goto L29;
        };
    L29:
        switch(r1) {
            case 0: goto L44;
            case 1: goto L40;
            case 2: goto L40;
            case 3: goto L36;
            case 4: goto L32;
            default: goto L53;
        };
    L53:
        return false;
    L32:
        if (Build.VERSION.SDK_INT >= 26) goto L34;
        return false;
    L34:
        return true;
    L36:
        if (Build.VERSION.SDK_INT >= 29) goto L38;
        return false;
    L38:
        return true;
    L40:
        if (Build.VERSION.SDK_INT >= 33) goto L42;
        return false;
    L42:
        return true;
    L44:
        if (Build.VERSION.SDK_INT >= 31) goto L46;
        return false;
    L46:
        return true;
    L10:
        if (r5.equals("--autofill") == false) goto L29;
        r1 = 4;
        goto L29
    L14:
        if (r5.equals("--contentcapture") == false) goto L29;
        r1 = 3;
        goto L29
    L18:
        if (r5.equals("--list-dumpables") == false) goto L29;
        r1 = 2;
        goto L29
    L22:
        if (r5.equals("--dump-dumpable") == false) goto L29;
        r1 = 1;
        goto L29
    L26:
        if (r5.equals("--translation") == false) goto L29;
        r1 = 0;
        goto L29
    L51:
        return false;
    }
}
