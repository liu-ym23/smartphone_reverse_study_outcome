package kotlin.reflect.jvm.internal.impl.protobuf;

import H8.AbstractC0241b;
import H8.i;
import H8.k;
import H8.l;
import H8.x;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class GeneratedMessageLite extends AbstractC0241b implements Serializable {
    public static l e(AbstractC0241b abstractC0241b, AbstractC0241b abstractC0241b2, int i, WireFormat$FieldType wireFormat$FieldType, Class cls) {
        return new l(abstractC0241b, Collections.EMPTY_LIST, abstractC0241b2, new k(i, wireFormat$FieldType, true), cls);
    }

    public static l f(AbstractC0241b abstractC0241b, Object obj, AbstractC0241b abstractC0241b2, int i, WireFormat$FieldType wireFormat$FieldType, Class cls) {
        return new l(abstractC0241b, obj, abstractC0241b2, new k(i, wireFormat$FieldType, false), cls);
    }

    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType>> extends GeneratedMessageLite {

        /* renamed from: a, reason: collision with root package name */
        public final i f5099a;

        public ExtendableMessage() {
            this.f5099a = new i();
        }

        public final boolean g() {
            x xVar = this.f5099a.f773a;
            int i = 0;
            while (true) {
                if (i >= xVar.b.size()) {
                    Iterator it = xVar.d().iterator();
                    while (it.hasNext()) {
                        if (!i.e((Map.Entry) it.next())) {
                        }
                    }
                    return true;
                }
                if (!i.e((Map.Entry) xVar.b.get(i))) {
                    break;
                }
                i++;
            }
            return false;
        }

        public final int h() {
            x xVar = this.f5099a.f773a;
            int iD = 0;
            for (int i = 0; i < xVar.b.size(); i++) {
                Map.Entry entry = (Map.Entry) xVar.b.get(i);
                iD += i.d((k) entry.getKey(), entry.getValue());
            }
            for (Map.Entry entry2 : xVar.d()) {
                iD += i.d((k) entry2.getKey(), entry2.getValue());
            }
            return iD;
        }

        public final Object i(l lVar) {
            m(lVar);
            k kVar = lVar.d;
            Object obj = this.f5099a.f773a.get(kVar);
            if (obj == null) {
                return lVar.b;
            }
            if (!kVar.c) {
                return lVar.a(obj);
            }
            if (kVar.b.f5101a != WireFormat$JavaType.ENUM) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                arrayList.add(lVar.a(it.next()));
            }
            return arrayList;
        }

        public final boolean j(l lVar) {
            m(lVar);
            k kVar = lVar.d;
            i iVar = this.f5099a;
            iVar.getClass();
            if (kVar.c) {
                throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
            }
            return iVar.f773a.get(kVar) != null;
        }

        public final void k() {
            this.f5099a.f();
        }

        /* JADX WARN: Removed duplicated region for block: B:4:0x0019  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean l(H8.C0245f r9, A0.d r10, H8.h r11, int r12) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
            /*
                Method dump skipped, instructions count: 265
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage.l(H8.f, A0.d, H8.h, int):boolean");
        }

        public final void m(l lVar) {
            if (lVar.f776a != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        public ExtendableMessage(a aVar) {
            aVar.b.f();
            aVar.c = false;
            this.f5099a = aVar.b;
        }
    }
}
