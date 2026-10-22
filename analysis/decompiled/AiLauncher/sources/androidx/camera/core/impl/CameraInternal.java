package androidx.camera.core.impl;

import D.InterfaceC0771h;
import D.InterfaceC0778o;
import K.C0895s;
import K.InterfaceC0898v;
import androidx.camera.core.UseCase;
import g3.InterfaceFutureC4095a;
import java.util.Collection;

/* loaded from: classes.dex */
public interface CameraInternal extends InterfaceC0771h, UseCase.b {

    public enum State {
        RELEASED(false),
        RELEASING(true),
        CLOSED(false),
        PENDING_OPEN(false),
        CLOSING(true),
        OPENING(true),
        OPEN(true),
        CONFIGURED(true);

        private final boolean mHoldsCameraSlot;

        State(boolean z10) {
            this.mHoldsCameraSlot = z10;
        }

        public boolean holdsCameraSlot() {
            return this.mHoldsCameraSlot;
        }
    }

    @Override // D.InterfaceC0771h
    default InterfaceC0778o a() {
        return i();
    }

    h d();

    default g e() {
        return C0895s.a();
    }

    default void f(boolean z10) {
    }

    void g(Collection<UseCase> collection);

    void h(Collection<UseCase> collection);

    InterfaceC0898v i();

    default boolean j() {
        return a().k() == 0;
    }

    default void m(g gVar) {
    }

    default boolean n() {
        return false;
    }

    default void o() {
    }

    default boolean p() {
        return true;
    }

    default void q(boolean z10) {
    }

    InterfaceFutureC4095a<Void> release();
}
