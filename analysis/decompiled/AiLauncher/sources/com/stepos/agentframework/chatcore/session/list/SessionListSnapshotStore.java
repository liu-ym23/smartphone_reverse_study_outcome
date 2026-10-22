package com.stepos.agentframework.chatcore.session.list;

import La.H;
import Ua.C1056g;
import Ua.Y;
import Z8.C1174w;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0086@¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/list/SessionListSnapshotStore;", "", "<init>", "()V", "Lcom/stepos/agentframework/chatcore/session/list/c;", Const.INTENT_KEY_APIKEY, "(Le9/c;)Ljava/lang/Object;", "", "", "sessionIds", "", Const.INTENT_KEY_PKGNAME, "(Ljava/util/Collection;Le9/c;)Ljava/lang/Object;", "TAG", "Ljava/lang/String;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SessionListSnapshotStore {
    public static final SessionListSnapshotStore INSTANCE = new SessionListSnapshotStore();
    private static final String TAG = "SessionList";

    public final Object a(InterfaceC4014c<? super SessionListSnapshot> interfaceC4014c) {
        return C1056g.j(Y.b(), new SessionListSnapshotStore$findAll$2(null), interfaceC4014c);
    }

    public final Object b(Collection<String> collection, InterfaceC4014c<? super Set<String>> interfaceC4014c) {
        Collection<String> collection2 = collection;
        ArrayList arrayList = new ArrayList(C1174w.x(collection2, 10));
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            arrayList.add(H.D1((String) it.next()).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        List listG0 = F.g0(arrayList2);
        return listG0.isEmpty() ? Z8.Y.e() : C1056g.j(Y.b(), new SessionListSnapshotStore$sessionIdsWithUserMessages$2(listG0, null), interfaceC4014c);
    }
}
