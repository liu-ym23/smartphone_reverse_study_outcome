package B3;

import A3.o;
import Z2.I;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public final class l implements t3.h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f236a;

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f237b;

    /* renamed from: c, reason: collision with root package name */
    public AbstractCollection f238c;

    @Override // t3.h
    public final boolean a() {
        switch (this.f236a) {
        }
        return this.f237b;
    }

    public final void b(t3.h hVar) {
        switch (this.f236a) {
            case 0:
                if (hVar.a()) {
                    return;
                }
                if (!this.f237b) {
                    synchronized (this) {
                        try {
                            if (!this.f237b) {
                                List list = (List) this.f238c;
                                List list2 = list;
                                if (list == null) {
                                    LinkedList linkedList = new LinkedList();
                                    this.f238c = linkedList;
                                    list2 = linkedList;
                                }
                                list2.add(hVar);
                                return;
                            }
                        } finally {
                        }
                    }
                }
                hVar.c();
                return;
            default:
                if (hVar.a()) {
                    return;
                }
                if (!this.f237b) {
                    synchronized (this) {
                        try {
                            if (!this.f237b) {
                                if (((Set) this.f238c) == null) {
                                    this.f238c = new HashSet(4);
                                }
                                ((Set) this.f238c).add(hVar);
                                return;
                            }
                        } finally {
                        }
                    }
                }
                hVar.c();
                return;
        }
    }

    @Override // t3.h
    public final void c() {
        ArrayList arrayList = null;
        switch (this.f236a) {
            case 0:
                if (this.f237b) {
                    return;
                }
                synchronized (this) {
                    try {
                        if (!this.f237b) {
                            this.f237b = true;
                            List list = (List) this.f238c;
                            this.f238c = null;
                            if (list != null) {
                                Iterator it = list.iterator();
                                while (it.hasNext()) {
                                    try {
                                        ((t3.h) it.next()).c();
                                    } catch (Throwable th) {
                                        if (arrayList == null) {
                                            arrayList = new ArrayList();
                                        }
                                        arrayList.add(th);
                                    }
                                }
                                I.C(arrayList);
                            }
                        }
                    } finally {
                    }
                }
                return;
            default:
                if (this.f237b) {
                    return;
                }
                synchronized (this) {
                    try {
                        if (!this.f237b) {
                            this.f237b = true;
                            Set set = (Set) this.f238c;
                            this.f238c = null;
                            if (set != null) {
                                Iterator it2 = set.iterator();
                                while (it2.hasNext()) {
                                    try {
                                        ((t3.h) it2.next()).c();
                                    } catch (Throwable th2) {
                                        if (arrayList == null) {
                                            arrayList = new ArrayList();
                                        }
                                        arrayList.add(th2);
                                    }
                                }
                                I.C(arrayList);
                            }
                        }
                    } finally {
                    }
                }
                return;
        }
    }

    public final void d(t3.h hVar) {
        switch (this.f236a) {
            case 0:
                if (this.f237b) {
                    return;
                }
                synchronized (this) {
                    List list = (List) this.f238c;
                    if (!this.f237b && list != null) {
                        boolean zRemove = list.remove(hVar);
                        if (zRemove) {
                            hVar.c();
                        }
                    }
                }
                return;
            default:
                if (this.f237b) {
                    return;
                }
                synchronized (this) {
                    if (!this.f237b) {
                        Collection collection = this.f238c;
                        if (((Set) collection) != null) {
                            boolean zRemove2 = ((Set) collection).remove(hVar);
                            if (zRemove2) {
                                hVar.c();
                            }
                        }
                    }
                }
                return;
        }
    }

    public l(t3.h[] hVarArr) {
        this.f236a = 0;
        this.f238c = new LinkedList(Arrays.asList(hVarArr));
    }

    public l(o oVar) {
        this.f236a = 0;
        LinkedList linkedList = new LinkedList();
        this.f238c = linkedList;
        linkedList.add(oVar);
    }
}
