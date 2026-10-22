package lc;

import mc.f;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;

/* renamed from: lc.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C4885a implements InterfaceC4886b {
    @Override // lc.InterfaceC4886b
    public InterfaceC4886b a() {
        return new C4885a();
    }

    @Override // lc.InterfaceC4886b
    public boolean b(String str) {
        return true;
    }

    @Override // lc.InterfaceC4886b
    public void c(f fVar) throws InvalidDataException {
    }

    @Override // lc.InterfaceC4886b
    public String d() {
        return "";
    }

    @Override // lc.InterfaceC4886b
    public boolean e(String str) {
        return true;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return obj != null && getClass() == obj.getClass();
        }
        return true;
    }

    @Override // lc.InterfaceC4886b
    public void f(f fVar) {
    }

    @Override // lc.InterfaceC4886b
    public void g(f fVar) throws InvalidDataException {
        if (fVar.a() || fVar.b() || fVar.d()) {
            throw new InvalidFrameException("bad rsv RSV1: " + fVar.a() + " RSV2: " + fVar.b() + " RSV3: " + fVar.d());
        }
    }

    @Override // lc.InterfaceC4886b
    public String h() {
        return "";
    }

    public int hashCode() {
        return getClass().hashCode();
    }

    @Override // lc.InterfaceC4886b
    public void reset() {
    }

    @Override // lc.InterfaceC4886b
    public String toString() {
        return getClass().getSimpleName();
    }
}
