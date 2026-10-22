package h2;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.lifecycle.d0;
import androidx.lifecycle.f0;
import androidx.lifecycle.q;
import androidx.lifecycle.v;
import androidx.lifecycle.x;
import o2.m;
import q7.k;

/* loaded from: classes.dex */
public abstract class a extends Activity implements v {

    /* renamed from: f, reason: collision with root package name */
    public final x f4074f = new x(this);

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        k.e(keyEvent, "event");
        k.d(getWindow().getDecorView(), "getDecorView(...)");
        int i2 = m.f7237a;
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        k.e(keyEvent, "event");
        k.d(getWindow().getDecorView(), "getDecorView(...)");
        int i2 = m.f7237a;
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i2 = f0.f993f;
        d0.b(this);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        k.e(bundle, "outState");
        q qVar = q.f1020f;
        x xVar = this.f4074f;
        xVar.getClass();
        q qVar2 = q.f1022h;
        xVar.c("setCurrentState");
        xVar.e(qVar2);
        super.onSaveInstanceState(bundle);
    }
}
