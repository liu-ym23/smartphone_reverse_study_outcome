package org.java_websocket;

import java.nio.ByteBuffer;
import kc.AbstractC4846a;
import mc.f;
import nc.h;
import nc.i;
import org.java_websocket.exceptions.InvalidDataException;

/* loaded from: classes5.dex */
public interface e {
    void a(b bVar, f fVar);

    void b(b bVar, int i10, String str, boolean z10);

    void c(b bVar, ByteBuffer byteBuffer);

    void d(b bVar, nc.a aVar, h hVar) throws InvalidDataException;

    mc.h e(b bVar);

    void f(b bVar, nc.f fVar);

    void g(b bVar, nc.a aVar) throws InvalidDataException;

    void h(b bVar, f fVar);

    i i(b bVar, AbstractC4846a abstractC4846a, nc.a aVar) throws InvalidDataException;

    void j(b bVar);

    void k(b bVar, int i10, String str);

    void l(b bVar, Exception exc);

    void m(b bVar, String str);

    void o(b bVar, int i10, String str, boolean z10);
}
