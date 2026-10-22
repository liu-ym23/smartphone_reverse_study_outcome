package com.stepos.ailauncher.taskstore.livenotification;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.ConversationSessionIds;
import com.stepos.agentframework.chatcore.session.M0;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ=\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00112\b\u0010\r\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e¢\u0006\u0004\b\u0012\u0010\u0013JA\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00192\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/stepos/ailauncher/taskstore/livenotification/k;", "", "<init>", "()V", "", "id", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)Ljava/lang/String;", "left", "right", "", "f", "(Ljava/lang/String;Ljava/lang/String;)Z", "seed", "", "extra", "knownKeys", "", "c", "(Ljava/lang/String;Ljava/util/Collection;Ljava/util/Collection;)Ljava/util/Set;", "seeds", "e", "(Ljava/util/Collection;Ljava/util/Collection;Ljava/util/Collection;)Ljava/util/Set;", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "card", "", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;)Ljava/util/List;", "ids", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;Ljava/util/Set;)Z", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.taskstore.livenotification.k, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3723k {
    public static final C3723k INSTANCE = new C3723k();

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Set d(C3723k c3723k, String str, Collection collection, Collection collection2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            collection = C1173v.m();
        }
        if ((i10 & 4) != 0) {
            collection2 = C1173v.m();
        }
        return c3723k.c(str, collection, collection2);
    }

    public final List<String> a(TaskInfoCard card) {
        kotlin.jvm.internal.p.i(card, "card");
        String requestSessionKey = card.getRequestSessionKey();
        String str = null;
        if (requestSessionKey == null || La.H.x0(requestSessionKey)) {
            requestSessionKey = null;
        }
        String sessionKey = card.getSessionKey();
        if (sessionKey != null && !La.H.x0(sessionKey)) {
            str = sessionKey;
        }
        return Z8.F.g0(C1173v.r(requestSessionKey, str, A6.c.INSTANCE.c(card)));
    }

    public final boolean b(TaskInfoCard card, Set<String> ids) {
        kotlin.jvm.internal.p.i(card, "card");
        kotlin.jvm.internal.p.i(ids, "ids");
        if (ids.isEmpty()) {
            return false;
        }
        List<String> listA = a(card);
        if ((listA instanceof Collection) && listA.isEmpty()) {
            return false;
        }
        for (String str : listA) {
            Set<String> set = ids;
            if (!(set instanceof Collection) || !set.isEmpty()) {
                Iterator<T> it = set.iterator();
                while (it.hasNext()) {
                    if (INSTANCE.f((String) it.next(), str)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final Set<String> c(String seed, Collection<String> extra, Collection<String> knownKeys) {
        kotlin.jvm.internal.p.i(extra, "extra");
        kotlin.jvm.internal.p.i(knownKeys, "knownKeys");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        String string = seed != null ? La.H.D1(seed).toString() : null;
        if (string == null) {
            string = "";
        }
        if (!La.H.x0(string)) {
            linkedHashSet.add(string);
            linkedHashSet.add(g(string));
            Z8.A.E(linkedHashSet, M0.INSTANCE.a(string));
        }
        Iterator<T> it = extra.iterator();
        while (it.hasNext()) {
            String string2 = La.H.D1((String) it.next()).toString();
            if (string2.length() > 0) {
                linkedHashSet.add(string2);
            }
        }
        if (!knownKeys.isEmpty()) {
            List listM1 = Z8.F.m1(linkedHashSet);
            for (Object obj : knownKeys) {
                String str = (String) obj;
                if (!La.H.x0(str)) {
                    List list = listM1;
                    if (!(list instanceof Collection) || !list.isEmpty()) {
                        Iterator it2 = list.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                if (INSTANCE.f((String) it2.next(), str)) {
                                    linkedHashSet.add(obj);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        return linkedHashSet;
    }

    public final Set<String> e(Collection<String> seeds, Collection<String> extra, Collection<String> knownKeys) {
        kotlin.jvm.internal.p.i(seeds, "seeds");
        kotlin.jvm.internal.p.i(extra, "extra");
        kotlin.jvm.internal.p.i(knownKeys, "knownKeys");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<String> it = seeds.iterator();
        while (it.hasNext()) {
            String string = La.H.D1(it.next()).toString();
            if (string.length() != 0) {
                Z8.A.E(linkedHashSet, c(string, extra, knownKeys));
            }
        }
        if (!knownKeys.isEmpty() && !linkedHashSet.isEmpty()) {
            for (Object obj : knownKeys) {
                String str = (String) obj;
                if (!La.H.x0(str) && !linkedHashSet.isEmpty()) {
                    Iterator it2 = linkedHashSet.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (INSTANCE.f((String) it2.next(), str)) {
                                linkedHashSet.add(obj);
                                break;
                            }
                        }
                    }
                }
            }
        }
        return linkedHashSet;
    }

    public final boolean f(String left, String right) {
        kotlin.jvm.internal.p.i(left, "left");
        kotlin.jvm.internal.p.i(right, "right");
        if (La.H.x0(left) || La.H.x0(right)) {
            return false;
        }
        if (kotlin.jvm.internal.p.d(left, right)) {
            return true;
        }
        M0 m02 = M0.INSTANCE;
        String strF = m02.f(left);
        if (strF == null) {
            strF = left;
        }
        String strF2 = m02.f(right);
        if (strF2 == null) {
            strF2 = right;
        }
        if (kotlin.jvm.internal.p.d(strF, strF2)) {
            return true;
        }
        String strG = g(left);
        String strG2 = g(right);
        return kotlin.jvm.internal.p.d(strG, strG2) || kotlin.jvm.internal.p.d(strG, right) || kotlin.jvm.internal.p.d(strG2, left) || kotlin.jvm.internal.p.d(strG, strF2) || kotlin.jvm.internal.p.d(strG2, strF);
    }

    public final String g(String id) {
        kotlin.jvm.internal.p.i(id, "id");
        return ConversationSessionIds.INSTANCE.m(id);
    }
}
