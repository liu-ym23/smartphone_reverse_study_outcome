package f7;

import android.util.Log;
import b6.i;
import com.stepos.aicgroup.d;
import com.stepos.core.ability.AbilityManager;
import com.stepos.core.deepbinder.IModelChangeListener;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    public static volatile i f8776c;

    /* renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, ConcurrentHashMap<String, IModelChangeListener>> f8774a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, IModelChangeListener> f8775b = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    public static final ExecutorService f8777d = Executors.newSingleThreadExecutor(new d(7));

    public static List a(String str) {
        if (f8776c == null) {
            Log.w("ModelChangeBroadcaster", "findAbilitiesByModelId: abilityResolver not set, returning empty");
            return EmptyList.f10001a;
        }
        try {
            return AbilityManager.initialize$lambda$22(str);
        } catch (Exception e10) {
            Log.e("ModelChangeBroadcaster", "findAbilitiesByModelId failed for " + str + ": " + e10.getMessage());
            return EmptyList.f10001a;
        }
    }

    public static void b(String str, IModelChangeListener iModelChangeListener) {
        Object next;
        ConcurrentHashMap<String, ConcurrentHashMap<String, IModelChangeListener>> concurrentHashMap = f8774a;
        ConcurrentHashMap<String, IModelChangeListener> concurrentHashMap2 = concurrentHashMap.get(str);
        if (concurrentHashMap2 == null) {
            return;
        }
        Set<Map.Entry<String, IModelChangeListener>> setEntrySet = concurrentHashMap2.entrySet();
        g.e(setEntrySet, "<get-entries>(...)");
        Iterator<T> it = setEntrySet.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((Map.Entry) next).getValue() == iModelChangeListener) {
                    break;
                }
            }
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            concurrentHashMap2.remove(entry.getKey());
            Log.w("ModelChangeBroadcaster", "tryAutoUnregister: removed dead listener " + entry.getKey() + " from " + str);
            if (concurrentHashMap2.isEmpty()) {
                concurrentHashMap.remove(str);
            }
        }
    }
}
