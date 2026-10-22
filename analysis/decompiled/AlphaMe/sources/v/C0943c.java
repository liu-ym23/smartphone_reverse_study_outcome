package v;

import com.stepos.alphame.awareness.AwarenessDataItem;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import s.AbstractC0831a;
import w.o;

/* renamed from: v.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0943c {

    /* renamed from: b, reason: collision with root package name */
    public int f15516b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f15517c;

    /* renamed from: d, reason: collision with root package name */
    public final C0944d f15518d;

    /* renamed from: e, reason: collision with root package name */
    public final int f15519e;

    /* renamed from: f, reason: collision with root package name */
    public C0943c f15520f;

    /* renamed from: i, reason: collision with root package name */
    public t.i f15523i;

    /* renamed from: a, reason: collision with root package name */
    public HashSet f15515a = null;

    /* renamed from: g, reason: collision with root package name */
    public int f15521g = 0;

    /* renamed from: h, reason: collision with root package name */
    public int f15522h = Integer.MIN_VALUE;

    public C0943c(C0944d c0944d, int i4) {
        this.f15518d = c0944d;
        this.f15519e = i4;
    }

    public final void a(C0943c c0943c, int i4) {
        b(c0943c, i4, Integer.MIN_VALUE, false);
    }

    public final boolean b(C0943c c0943c, int i4, int i5, boolean z4) {
        if (c0943c == null) {
            j();
            return true;
        }
        if (!z4 && !i(c0943c)) {
            return false;
        }
        this.f15520f = c0943c;
        if (c0943c.f15515a == null) {
            c0943c.f15515a = new HashSet();
        }
        HashSet hashSet = this.f15520f.f15515a;
        if (hashSet != null) {
            hashSet.add(this);
        }
        this.f15521g = i4;
        this.f15522h = i5;
        return true;
    }

    public final void c(int i4, o oVar, ArrayList arrayList) {
        HashSet hashSet = this.f15515a;
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                B0.f.u(((C0943c) it.next()).f15518d, i4, arrayList, oVar);
            }
        }
    }

    public final int d() {
        if (this.f15517c) {
            return this.f15516b;
        }
        return 0;
    }

    public final int e() {
        C0943c c0943c;
        if (this.f15518d.f15562g0 == 8) {
            return 0;
        }
        int i4 = this.f15522h;
        return (i4 == Integer.MIN_VALUE || (c0943c = this.f15520f) == null || c0943c.f15518d.f15562g0 != 8) ? this.f15521g : i4;
    }

    public final C0943c f() {
        int i4 = this.f15519e;
        int iA = t.h.a(i4);
        C0944d c0944d = this.f15518d;
        switch (iA) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
                return null;
            case 1:
                return c0944d.f15534K;
            case 2:
                return c0944d.f15535L;
            case 3:
                return c0944d.f15532I;
            case 4:
                return c0944d.f15533J;
            default:
                throw new AssertionError(AbstractC0831a.i(i4));
        }
    }

    public final boolean g() {
        HashSet hashSet = this.f15515a;
        if (hashSet == null) {
            return false;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((C0943c) it.next()).f().h()) {
                return true;
            }
        }
        return false;
    }

    public final boolean h() {
        return this.f15520f != null;
    }

    public final boolean i(C0943c c0943c) {
        if (c0943c == null) {
            return false;
        }
        int i4 = this.f15519e;
        C0944d c0944d = c0943c.f15518d;
        int i5 = c0943c.f15519e;
        if (i5 == i4) {
            return i4 != 6 || (c0944d.f15528E && this.f15518d.f15528E);
        }
        switch (t.h.a(i4)) {
            case 0:
            case 7:
            case 8:
                return false;
            case 1:
            case 3:
                boolean z4 = i5 == 2 || i5 == 4;
                if (c0944d instanceof C0948h) {
                    return z4 || i5 == 8;
                }
                return z4;
            case 2:
            case 4:
                boolean z5 = i5 == 3 || i5 == 5;
                if (c0944d instanceof C0948h) {
                    return z5 || i5 == 9;
                }
                return z5;
            case 5:
                return (i5 == 2 || i5 == 4) ? false : true;
            case 6:
                return (i5 == 6 || i5 == 8 || i5 == 9) ? false : true;
            default:
                throw new AssertionError(AbstractC0831a.i(i4));
        }
    }

    public final void j() {
        HashSet hashSet;
        C0943c c0943c = this.f15520f;
        if (c0943c != null && (hashSet = c0943c.f15515a) != null) {
            hashSet.remove(this);
            if (this.f15520f.f15515a.size() == 0) {
                this.f15520f.f15515a = null;
            }
        }
        this.f15515a = null;
        this.f15520f = null;
        this.f15521g = 0;
        this.f15522h = Integer.MIN_VALUE;
        this.f15517c = false;
        this.f15516b = 0;
    }

    public final void k() {
        t.i iVar = this.f15523i;
        if (iVar == null) {
            this.f15523i = new t.i(1);
        } else {
            iVar.c();
        }
    }

    public final void l(int i4) {
        this.f15516b = i4;
        this.f15517c = true;
    }

    public final String toString() {
        return this.f15518d.f15564h0 + AwarenessDataItem.USERID_SPLITTER + AbstractC0831a.i(this.f15519e);
    }
}
