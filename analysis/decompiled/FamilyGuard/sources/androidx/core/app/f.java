package androidx.core.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.view.C0465j;
import androidx.lifecycle.AbstractC0533m;
import androidx.lifecycle.C0541v;
import androidx.lifecycle.H;
import androidx.lifecycle.InterfaceC0539t;

/* loaded from: classes.dex */
public class f extends Activity implements InterfaceC0539t, C0465j.a {
    private final q.i<Class<? extends a>, a> extraDataMap = new q.i<>();
    private final C0541v lifecycleRegistry = new C0541v(this);

    public static class a {
    }

    private static /* synthetic */ void getExtraDataMap$annotations() {
    }

    private static /* synthetic */ void getLifecycleRegistry$annotations() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    private final boolean shouldSkipDump(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            String str = strArr[0];
            switch (str.hashCode()) {
                case -645125871:
                    if (!str.equals("--translation")) {
                    }
                    break;
                case 100470631:
                    if (!str.equals("--dump-dumpable")) {
                    }
                    break;
                case 472614934:
                    if (!str.equals("--list-dumpables")) {
                    }
                    break;
                case 1159329357:
                    if (!str.equals("--contentcapture")) {
                    }
                    break;
                case 1455016274:
                    if (!str.equals("--autofill")) {
                    }
                    break;
            }
            return true;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        j4.k.g(keyEvent, "event");
        View decorView = getWindow().getDecorView();
        j4.k.f(decorView, "window.decorView");
        if (C0465j.a(decorView, keyEvent)) {
            return true;
        }
        return C0465j.b(this, decorView, this, keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        j4.k.g(keyEvent, "event");
        View decorView = getWindow().getDecorView();
        j4.k.f(decorView, "window.decorView");
        if (C0465j.a(decorView, keyEvent)) {
            return true;
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    public <T extends a> T getExtraData(Class<T> cls) {
        j4.k.g(cls, "extraDataClass");
        return (T) this.extraDataMap.get(cls);
    }

    public AbstractC0533m getLifecycle() {
        return this.lifecycleRegistry;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        H.f10809b.b(this);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        j4.k.g(bundle, "outState");
        this.lifecycleRegistry.n(AbstractC0533m.b.CREATED);
        super.onSaveInstanceState(bundle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void putExtraData(a aVar) {
        j4.k.g(aVar, "extraData");
        this.extraDataMap.put(aVar.getClass(), aVar);
    }

    protected final boolean shouldDumpInternalState(String[] strArr) {
        return !shouldSkipDump(strArr);
    }

    @Override // androidx.core.view.C0465j.a
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        j4.k.g(keyEvent, "event");
        return super.dispatchKeyEvent(keyEvent);
    }
}
