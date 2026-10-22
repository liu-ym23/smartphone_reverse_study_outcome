package kotlin.reflect.jvm.internal.impl.protobuf;

import A0.d;
import H8.AbstractC0241b;
import H8.D;
import H8.i;
import H8.k;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator f5104a;
    public Map.Entry b;

    public b(GeneratedMessageLite.ExtendableMessage extendableMessage) {
        Iterator it = ((D) extendableMessage.f5099a.f773a.entrySet()).iterator();
        this.f5104a = it;
        if (it.hasNext()) {
            this.b = (Map.Entry) it.next();
        }
    }

    public final void a(int i, d dVar) {
        while (true) {
            Map.Entry entry = this.b;
            if (entry == null || ((k) entry.getKey()).f775a >= i) {
                return;
            }
            k kVar = (k) this.b.getKey();
            Object value = this.b.getValue();
            i iVar = i.c;
            WireFormat$FieldType wireFormat$FieldType = kVar.b;
            int i6 = kVar.f775a;
            if (kVar.c) {
                for (Object obj : (List) value) {
                    if (wireFormat$FieldType == WireFormat$FieldType.e) {
                        dVar.B(i6, 3);
                        ((AbstractC0241b) obj).d(dVar);
                        dVar.B(i6, 4);
                    } else {
                        dVar.B(i6, wireFormat$FieldType.b);
                        i.k(dVar, wireFormat$FieldType, obj);
                    }
                }
            } else if (wireFormat$FieldType == WireFormat$FieldType.e) {
                dVar.B(i6, 3);
                ((AbstractC0241b) value).d(dVar);
                dVar.B(i6, 4);
            } else {
                dVar.B(i6, wireFormat$FieldType.b);
                i.k(dVar, wireFormat$FieldType, value);
            }
            Iterator it = this.f5104a;
            if (it.hasNext()) {
                this.b = (Map.Entry) it.next();
            } else {
                this.b = null;
            }
        }
    }
}
