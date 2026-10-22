package com.stepos.ailauncher.homegesture;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.api.homegesture.HomeLayerHandle;
import com.stepos.ailauncher.contract.api.homegesture.HomeRootToken;
import com.stepos.ailauncher.contract.api.homegesture.RootStrategy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0012J\u0015\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0018\u0010\u0016J\u0017\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u001b\u0010\u001aJ\u001b\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001c2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ\u001b\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001c2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u001f\u0010\u001eJ\u0015\u0010!\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b!\u0010\"R0\u0010%\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060#j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006`$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R<\u0010(\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0'0#j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0'`$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010&R<\u0010)\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0'0#j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0'`$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010&¨\u0006*"}, d2 = {"Lcom/stepos/ailauncher/homegesture/C;", "", "<init>", "()V", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", M5.b.CREDENTIAL_TOKEN, "Lcom/stepos/ailauncher/contract/api/homegesture/RootStrategy;", "strategy", "LY8/t;", "f", "(Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;Lcom/stepos/ailauncher/contract/api/homegesture/RootStrategy;)V", "n", "(Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;)Lcom/stepos/ailauncher/contract/api/homegesture/RootStrategy;", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeLayerHandle;", "handle", "e", "(Lcom/stepos/ailauncher/contract/api/homegesture/HomeLayerHandle;)V", "", "layerId", "l", "(Ljava/lang/String;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "o", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;)Lcom/stepos/ailauncher/contract/api/homegesture/HomeLayerHandle;", "k", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;)Ljava/util/List;", Const.INTENT_KEY_UMID, "", "c", "(Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;)Z", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "roots", "Ljava/util/LinkedHashMap;", "", "popups", "sheets", "homegesture_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class C {
    private final LinkedHashMap<HomeRootToken, RootStrategy> roots = new LinkedHashMap<>();
    private final LinkedHashMap<HomeRootToken, List<HomeLayerHandle>> popups = new LinkedHashMap<>();
    private final LinkedHashMap<HomeRootToken, List<HomeLayerHandle>> sheets = new LinkedHashMap<>();

    public static final boolean m(String str, HomeLayerHandle it) {
        kotlin.jvm.internal.p.i(it, "it");
        return kotlin.jvm.internal.p.d(it.getLayerId(), str);
    }

    public static final boolean p(String str, HomeLayerHandle it) {
        kotlin.jvm.internal.p.i(it, "it");
        return kotlin.jvm.internal.p.d(it.getLayerId(), str);
    }

    public final boolean c(HomeRootToken token) {
        kotlin.jvm.internal.p.i(token, "token");
        return (j(token) == null && k(token) == null) ? false : true;
    }

    public final List<HomeLayerHandle> d(HomeRootToken token) {
        kotlin.jvm.internal.p.i(token, "token");
        List<HomeLayerHandle> list = this.popups.get(token);
        List<HomeLayerHandle> listM1 = list != null ? Z8.F.m1(list) : null;
        return listM1 == null ? C1173v.m() : listM1;
    }

    public final void e(HomeLayerHandle handle) {
        kotlin.jvm.internal.p.i(handle, "handle");
        l(handle.getLayerId());
        LinkedHashMap<HomeRootToken, List<HomeLayerHandle>> linkedHashMap = this.popups;
        HomeRootToken rootToken = handle.getRootToken();
        List<HomeLayerHandle> arrayList = linkedHashMap.get(rootToken);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            linkedHashMap.put(rootToken, arrayList);
        }
        arrayList.add(handle);
    }

    public final void f(HomeRootToken token, RootStrategy strategy) {
        kotlin.jvm.internal.p.i(token, "token");
        kotlin.jvm.internal.p.i(strategy, "strategy");
        this.roots.put(token, strategy);
    }

    public final void g(HomeLayerHandle handle) {
        kotlin.jvm.internal.p.i(handle, "handle");
        o(handle.getLayerId());
        LinkedHashMap<HomeRootToken, List<HomeLayerHandle>> linkedHashMap = this.sheets;
        HomeRootToken rootToken = handle.getRootToken();
        List<HomeLayerHandle> arrayList = linkedHashMap.get(rootToken);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            linkedHashMap.put(rootToken, arrayList);
        }
        arrayList.add(handle);
    }

    public final RootStrategy h(HomeRootToken token) {
        kotlin.jvm.internal.p.i(token, "token");
        return this.roots.get(token);
    }

    public final List<HomeLayerHandle> i(HomeRootToken token) {
        kotlin.jvm.internal.p.i(token, "token");
        List<HomeLayerHandle> list = this.sheets.get(token);
        List<HomeLayerHandle> listM1 = list != null ? Z8.F.m1(list) : null;
        return listM1 == null ? C1173v.m() : listM1;
    }

    public final HomeLayerHandle j(HomeRootToken token) {
        List listV;
        kotlin.jvm.internal.p.i(token, "token");
        List<HomeLayerHandle> list = this.popups.get(token);
        Object obj = null;
        if (list == null || (listV = Z8.B.V(list)) == null) {
            return null;
        }
        Iterator it = listV.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((HomeLayerHandle) next).isShowing()) {
                obj = next;
                break;
            }
        }
        return (HomeLayerHandle) obj;
    }

    public final HomeLayerHandle k(HomeRootToken token) {
        List listV;
        kotlin.jvm.internal.p.i(token, "token");
        List<HomeLayerHandle> list = this.sheets.get(token);
        Object obj = null;
        if (list == null || (listV = Z8.B.V(list)) == null) {
            return null;
        }
        Iterator it = listV.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((HomeLayerHandle) next).isShowing()) {
                obj = next;
                break;
            }
        }
        return (HomeLayerHandle) obj;
    }

    public final void l(final String layerId) {
        kotlin.jvm.internal.p.i(layerId, "layerId");
        Collection<List<HomeLayerHandle>> collectionValues = this.popups.values();
        kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            List list = (List) it.next();
            kotlin.jvm.internal.p.f(list);
            Z8.A.L(list, new InterfaceC5074l() { // from class: com.stepos.ailauncher.homegesture.B
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(C.m(layerId, (HomeLayerHandle) obj));
                }
            });
        }
    }

    public final void n(HomeRootToken token) {
        kotlin.jvm.internal.p.i(token, "token");
        this.roots.remove(token);
    }

    public final void o(final String layerId) {
        kotlin.jvm.internal.p.i(layerId, "layerId");
        Collection<List<HomeLayerHandle>> collectionValues = this.sheets.values();
        kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            List list = (List) it.next();
            kotlin.jvm.internal.p.f(list);
            Z8.A.L(list, new InterfaceC5074l() { // from class: com.stepos.ailauncher.homegesture.A
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(C.p(layerId, (HomeLayerHandle) obj));
                }
            });
        }
    }
}
