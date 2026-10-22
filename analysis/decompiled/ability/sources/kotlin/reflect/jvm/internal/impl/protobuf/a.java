package kotlin.reflect.jvm.internal.impl.protobuf;

import H8.i;
import H8.j;
import H8.s;
import H8.x;
import java.util.Iterator;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;

/* loaded from: classes4.dex */
public abstract class a extends j implements s {
    public i b = i.c;
    public boolean c;

    public final void d(GeneratedMessageLite.ExtendableMessage extendableMessage) {
        x xVar;
        if (!this.c) {
            this.b = this.b.clone();
            this.c = true;
        }
        i iVar = this.b;
        i iVar2 = extendableMessage.f5099a;
        iVar.getClass();
        int i = 0;
        while (true) {
            xVar = iVar2.f773a;
            if (i >= xVar.b.size()) {
                break;
            }
            iVar.g((Map.Entry) xVar.b.get(i));
            i++;
        }
        Iterator it = xVar.d().iterator();
        while (it.hasNext()) {
            iVar.g((Map.Entry) it.next());
        }
    }
}
