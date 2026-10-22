package Za;

import Ua.A0;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.sequences.SequencesKt___SequencesKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"LZa/r;", "", "<init>", "()V", "LUa/A0;", Const.INTENT_KEY_APIKEY, "()LUa/A0;", Const.INTENT_KEY_PKGNAME, "LUa/A0;", "dispatcher", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public static final r f7757a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final A0 dispatcher;

    static {
        r rVar = new r();
        f7757a = rVar;
        D.f("kotlinx.coroutines.fast.service.loader", true);
        dispatcher = rVar.a();
    }

    public final A0 a() {
        Object next;
        A0 a0E;
        try {
            List listD0 = SequencesKt___SequencesKt.d0(Ka.t.h(ServiceLoader.load(q.class, q.class.getClassLoader()).iterator()));
            Iterator it = listD0.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int iC = ((q) next).c();
                    do {
                        Object next2 = it.next();
                        int iC2 = ((q) next2).c();
                        if (iC < iC2) {
                            next = next2;
                            iC = iC2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            q qVar = (q) next;
            if (qVar != null && (a0E = s.e(qVar, listD0)) != null) {
                return a0E;
            }
            return s.b(null, null, 3, null);
        } catch (Throwable th) {
            return s.b(th, null, 2, null);
        }
    }
}
