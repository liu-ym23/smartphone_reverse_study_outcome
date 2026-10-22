package org.java_websocket;

import kc.AbstractC4846a;
import mc.f;
import mc.h;
import mc.i;
import org.java_websocket.exceptions.InvalidDataException;

/* loaded from: classes5.dex */
public abstract class c implements e {
    private h pingFrame;

    @Override // org.java_websocket.e
    public void a(b bVar, f fVar) {
    }

    @Override // org.java_websocket.e
    public void d(b bVar, nc.a aVar, nc.h hVar) throws InvalidDataException {
    }

    @Override // org.java_websocket.e
    public h e(b bVar) {
        if (this.pingFrame == null) {
            this.pingFrame = new h();
        }
        return this.pingFrame;
    }

    @Override // org.java_websocket.e
    public void g(b bVar, nc.a aVar) throws InvalidDataException {
    }

    @Override // org.java_websocket.e
    public void h(b bVar, f fVar) {
        bVar.n(new i((h) fVar));
    }

    @Override // org.java_websocket.e
    public nc.i i(b bVar, AbstractC4846a abstractC4846a, nc.a aVar) throws InvalidDataException {
        return new nc.e();
    }
}
