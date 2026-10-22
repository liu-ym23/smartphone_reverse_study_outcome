package x9;

import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import w9.InterfaceC5744c;
import w9.InterfaceC5745d;
import w9.InterfaceC5748g;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\"(\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0000*\u0006\u0012\u0002\b\u00030\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0001\u0010\u0002\",\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006*\u0006\u0012\u0002\b\u00030\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0004\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lw9/d;", Const.INTENT_KEY_APIKEY, "(Lw9/d;)Lw9/d;", "getCompanionObject$annotations", "(Lw9/d;)V", "companionObject", "", "Lw9/g;", Const.INTENT_KEY_PKGNAME, "(Lw9/d;)Ljava/util/Collection;", "getFunctions$annotations", "functions", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: x9.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C5856a {
    public static final InterfaceC5745d<?> a(InterfaceC5745d<?> interfaceC5745d) {
        Object next;
        p.i(interfaceC5745d, "<this>");
        Iterator<T> it = interfaceC5745d.d().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((InterfaceC5745d) next).j()) {
                break;
            }
        }
        return (InterfaceC5745d) next;
    }

    public static final Collection<InterfaceC5748g<?>> b(InterfaceC5745d<?> interfaceC5745d) {
        p.i(interfaceC5745d, "<this>");
        Collection<InterfaceC5744c<?>> collectionB = interfaceC5745d.b();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionB) {
            if (obj instanceof InterfaceC5748g) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
