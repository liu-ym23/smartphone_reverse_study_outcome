package androidx.fragment.app;

import android.util.Log;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f678a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final l f679b = new l(0);

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f680c;
    public final AtomicInteger d;

    /* renamed from: e, reason: collision with root package name */
    public final int f681e;

    public k() {
        new t1.f(this, 6);
        this.d = new AtomicInteger();
        Collections.synchronizedMap(new HashMap());
        Collections.synchronizedMap(new HashMap());
        Collections.synchronizedMap(new HashMap());
        new t1.f(this, 5);
        new CopyOnWriteArrayList();
        final int i8 = 0;
        new d0.a(this) { // from class: androidx.fragment.app.g

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ k f676b;

            {
                this.f676b = this;
            }

            @Override // d0.a
            public final void accept(Object obj) {
                switch (i8) {
                    case 0:
                        this.f676b.a(false);
                        break;
                    default:
                        if (((Integer) obj).intValue() == 80) {
                            this.f676b.c(false);
                            break;
                        }
                        break;
                }
            }
        };
        final int i9 = 1;
        new d0.a(this) { // from class: androidx.fragment.app.g

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ k f676b;

            {
                this.f676b = this;
            }

            @Override // d0.a
            public final void accept(Object obj) {
                switch (i9) {
                    case 0:
                        this.f676b.a(false);
                        break;
                    default:
                        if (((Integer) obj).intValue() == 80) {
                            this.f676b.c(false);
                            break;
                        }
                        break;
                }
            }
        };
        final int i10 = 0;
        new d0.a(this) { // from class: androidx.fragment.app.h
            @Override // d0.a
            public final void accept(Object obj) {
                switch (i10) {
                    case 0:
                        if (obj != null) {
                            throw new ClassCastException();
                        }
                        throw null;
                    default:
                        if (obj != null) {
                            throw new ClassCastException();
                        }
                        throw null;
                }
            }
        };
        final int i11 = 1;
        new d0.a(this) { // from class: androidx.fragment.app.h
            @Override // d0.a
            public final void accept(Object obj) {
                switch (i11) {
                    case 0:
                        if (obj != null) {
                            throw new ClassCastException();
                        }
                        throw null;
                    default:
                        if (obj != null) {
                            throw new ClassCastException();
                        }
                        throw null;
                }
            }
        };
        this.f681e = -1;
        new ArrayDeque();
        new b(i11, this);
    }

    public static boolean f(int i8) {
        return Log.isLoggable("FragmentManager", i8);
    }

    public static boolean g(f fVar) {
        return fVar == null || fVar.d;
    }

    public final void a(boolean z) {
        for (f fVar : this.f679b.b()) {
            if (fVar != null && z) {
                fVar.f669c.a(true);
            }
        }
    }

    public final boolean b() {
        if (this.f681e < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z = false;
        for (f fVar : this.f679b.b()) {
            if (fVar != null && g(fVar) && fVar.f669c.b()) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(fVar);
                z = true;
            }
        }
        if (this.f680c != null) {
            for (int i8 = 0; i8 < this.f680c.size(); i8++) {
                f fVar2 = (f) this.f680c.get(i8);
                if (arrayList == null || !arrayList.contains(fVar2)) {
                    fVar2.getClass();
                }
            }
        }
        this.f680c = arrayList;
        return z;
    }

    public final void c(boolean z) {
        for (f fVar : this.f679b.b()) {
            if (fVar != null && z) {
                fVar.f669c.c(true);
            }
        }
    }

    public final boolean d() {
        if (this.f681e < 1) {
            return false;
        }
        for (f fVar : this.f679b.b()) {
            if (fVar != null && fVar.f669c.d()) {
                return true;
            }
        }
        return false;
    }

    public final boolean e() {
        boolean z = false;
        if (this.f681e < 1) {
            return false;
        }
        for (f fVar : this.f679b.b()) {
            if (fVar != null && g(fVar) && fVar.f669c.e()) {
                z = true;
            }
        }
        return z;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        sb.append(AbstractJsonLexerKt.NULL);
        sb.append("}}");
        return sb.toString();
    }
}
