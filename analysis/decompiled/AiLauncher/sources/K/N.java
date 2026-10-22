package K;

import D.C0761b0;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraUpdateException;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import g3.InterfaceFutureC4095a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class N implements InterfaceC0876c0 {

    /* renamed from: a, reason: collision with root package name */
    public final Object f3917a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final Map<String, CameraInternal> f3918b = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name */
    public final Set<CameraInternal> f3919c = new HashSet();

    /* renamed from: d, reason: collision with root package name */
    public InterfaceFutureC4095a<Void> f3920d;

    /* renamed from: e, reason: collision with root package name */
    public CallbackToFutureAdapter.a<Void> f3921e;

    /* renamed from: f, reason: collision with root package name */
    public InterfaceC0897u f3922f;

    public static /* synthetic */ void i(N n10, CameraInternal cameraInternal) {
        synchronized (n10.f3917a) {
            try {
                n10.f3919c.remove(cameraInternal);
                if (n10.f3919c.isEmpty()) {
                    B0.h.f(n10.f3921e);
                    n10.f3921e.c(null);
                    n10.f3921e = null;
                    n10.f3920d = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static /* synthetic */ Object j(N n10, CallbackToFutureAdapter.a aVar) {
        synchronized (n10.f3917a) {
            n10.f3921e = aVar;
        }
        return "CameraRepository-deinit";
    }

    @Override // K.InterfaceC0876c0
    public void f(List<String> list) throws CameraUpdateException {
        HashSet<String> hashSet;
        HashMap map = new HashMap();
        synchronized (this.f3917a) {
            hashSet = new HashSet(list);
            hashSet.removeAll(this.f3918b.keySet());
        }
        try {
            for (String str : hashSet) {
                map.put(str, this.f3922f.a(str));
            }
            synchronized (this.f3917a) {
                try {
                    HashSet hashSet2 = new HashSet(this.f3918b.keySet());
                    hashSet2.removeAll(list);
                    ArrayList<CameraInternal> arrayList = new ArrayList();
                    Iterator it = hashSet2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(this.f3918b.get((String) it.next()));
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (String str2 : list) {
                        if (this.f3918b.containsKey(str2)) {
                            linkedHashMap.put(str2, this.f3918b.get(str2));
                        } else {
                            linkedHashMap.put(str2, (CameraInternal) map.get(str2));
                        }
                    }
                    this.f3918b.clear();
                    this.f3918b.putAll(linkedHashMap);
                    for (CameraInternal cameraInternal : arrayList) {
                        if (cameraInternal != null) {
                            cameraInternal.o();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (CameraUnavailableException e10) {
            throw new CameraUpdateException("Failed to create CameraInternal", e10);
        }
    }

    public InterfaceFutureC4095a<Void> k() {
        synchronized (this.f3917a) {
            try {
                if (this.f3918b.isEmpty()) {
                    InterfaceFutureC4095a<Void> interfaceFutureC4095aH = this.f3920d;
                    if (interfaceFutureC4095aH == null) {
                        interfaceFutureC4095aH = O.f.h(null);
                    }
                    return interfaceFutureC4095aH;
                }
                InterfaceFutureC4095a<Void> interfaceFutureC4095aA = this.f3920d;
                if (interfaceFutureC4095aA == null) {
                    interfaceFutureC4095aA = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: K.L
                        @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
                        public final Object a(CallbackToFutureAdapter.a aVar) {
                            return N.j(this.f3914a, aVar);
                        }
                    });
                    this.f3920d = interfaceFutureC4095aA;
                }
                this.f3919c.addAll(this.f3918b.values());
                for (final CameraInternal cameraInternal : this.f3918b.values()) {
                    cameraInternal.release().a(new Runnable() { // from class: K.M
                        @Override // java.lang.Runnable
                        public final void run() {
                            N.i(this.f3915a, cameraInternal);
                        }
                    }, N.a.a());
                }
                this.f3918b.clear();
                return interfaceFutureC4095aA;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public CameraInternal l(String str) {
        CameraInternal cameraInternal;
        synchronized (this.f3917a) {
            try {
                cameraInternal = this.f3918b.get(str);
                if (cameraInternal == null) {
                    throw new IllegalArgumentException("Invalid camera: " + str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cameraInternal;
    }

    public LinkedHashSet<CameraInternal> m() {
        LinkedHashSet<CameraInternal> linkedHashSet;
        synchronized (this.f3917a) {
            linkedHashSet = new LinkedHashSet<>(this.f3918b.values());
        }
        return linkedHashSet;
    }

    public void n(InterfaceC0897u interfaceC0897u) throws InitializationException {
        this.f3922f = interfaceC0897u;
        synchronized (this.f3917a) {
            try {
                for (String str : interfaceC0897u.c()) {
                    C0761b0.a("CameraRepository", "Added camera: " + str);
                    CameraInternal cameraInternalPut = this.f3918b.put(str, interfaceC0897u.a(str));
                    if (cameraInternalPut != null) {
                        cameraInternalPut.release();
                    }
                }
            } catch (CameraUnavailableException e10) {
                throw new InitializationException(e10);
            }
        }
    }
}
