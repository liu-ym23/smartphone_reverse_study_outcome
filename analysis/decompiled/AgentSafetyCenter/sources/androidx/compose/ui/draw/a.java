package androidx.compose.ui.draw;

import h1.b;
import java.lang.invoke.VarHandle;
import s1.j;
import w0.e;
import w0.m;
import xb.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a {
    public static final m a(m mVar, l lVar) {
        DrawBehindElement drawBehindElement = new DrawBehindElement();
        drawBehindElement.f946c = lVar;
        VarHandle.storeStoreFence();
        return mVar.d(drawBehindElement);
    }

    public static m b(m mVar, b bVar, e eVar, j jVar, float f5, d1.l lVar, int i) {
        if ((i & 4) != 0) {
            eVar = w0.b.i;
        }
        if ((i & 16) != 0) {
            f5 = 1.0f;
        }
        PainterElement painterElement = new PainterElement();
        painterElement.f947c = bVar;
        painterElement.f948f = true;
        painterElement.f949g = eVar;
        painterElement.f950h = jVar;
        painterElement.i = f5;
        painterElement.f951j = lVar;
        VarHandle.storeStoreFence();
        return mVar.d(painterElement);
    }
}
