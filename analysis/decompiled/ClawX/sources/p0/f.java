package p0;

import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.View;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f implements KeyListener {

    /* renamed from: a, reason: collision with root package name */
    public final KeyListener f4652a;

    /* renamed from: b, reason: collision with root package name */
    public final b f4653b;

    public f(KeyListener keyListener) {
        b bVar = new b(1);
        this.f4652a = keyListener;
        this.f4653b = bVar;
    }

    @Override // android.text.method.KeyListener
    public final void clearMetaKeyState(View view, Editable editable, int i8) {
        this.f4652a.clearMetaKeyState(view, editable, i8);
    }

    @Override // android.text.method.KeyListener
    public final int getInputType() {
        return this.f4652a.getInputType();
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyDown(View view, Editable editable, int i8, KeyEvent keyEvent) {
        boolean z;
        this.f4653b.getClass();
        if (i8 != 67 ? i8 != 112 ? false : a4.d.m(editable, keyEvent, true) : a4.d.m(editable, keyEvent, false)) {
            MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
            z = true;
        } else {
            z = false;
        }
        return z || this.f4652a.onKeyDown(view, editable, i8, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.f4652a.onKeyOther(view, editable, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyUp(View view, Editable editable, int i8, KeyEvent keyEvent) {
        return this.f4652a.onKeyUp(view, editable, i8, keyEvent);
    }
}
