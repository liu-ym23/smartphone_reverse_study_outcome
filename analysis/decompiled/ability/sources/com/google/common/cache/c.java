package com.google.common.cache;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.logging.Logger;
import l3.h;
import l3.i;
import l3.j;
import l3.y;

/* loaded from: classes3.dex */
public final class c extends AbstractQueue {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2736a;
    public final h b;

    public c(int i) {
        this.f2736a = i;
        switch (i) {
            case 1:
                i iVar = new i(1);
                iVar.b = iVar;
                iVar.c = iVar;
                this.b = iVar;
                break;
            default:
                i iVar2 = new i(0);
                iVar2.b = iVar2;
                iVar2.c = iVar2;
                this.b = iVar2;
                break;
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        int i = this.f2736a;
        LocalCache$NullEntry localCache$NullEntry = LocalCache$NullEntry.f2729a;
        h hVar = this.b;
        switch (i) {
            case 0:
                i iVar = (i) hVar;
                y yVar = iVar.b;
                while (yVar != iVar) {
                    y yVarE = yVar.e();
                    Logger logger = e.u;
                    yVar.i(localCache$NullEntry);
                    yVar.a(localCache$NullEntry);
                    yVar = yVarE;
                }
                iVar.b = iVar;
                iVar.c = iVar;
                break;
            default:
                i iVar2 = (i) hVar;
                y yVar2 = iVar2.b;
                while (yVar2 != iVar2) {
                    y yVarC = yVar2.c();
                    Logger logger2 = e.u;
                    yVar2.o(localCache$NullEntry);
                    yVar2.n(localCache$NullEntry);
                    yVar2 = yVarC;
                }
                iVar2.b = iVar2;
                iVar2.c = iVar2;
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        switch (this.f2736a) {
            case 0:
                if (((y) obj).e() != LocalCache$NullEntry.f2729a) {
                }
                break;
            default:
                if (((y) obj).c() != LocalCache$NullEntry.f2729a) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        switch (this.f2736a) {
            case 0:
                i iVar = (i) this.b;
                if (iVar.b == iVar) {
                }
                break;
            default:
                i iVar2 = (i) this.b;
                if (iVar2.b == iVar2) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f2736a) {
            case 0:
                i iVar = (i) this.b;
                y yVar = iVar.b;
                if (yVar == iVar) {
                    yVar = null;
                }
                return new j(this, yVar, 0);
            default:
                i iVar2 = (i) this.b;
                y yVar2 = iVar2.b;
                if (yVar2 == iVar2) {
                    yVar2 = null;
                }
                return new j(this, yVar2, 1);
        }
    }

    @Override // java.util.Queue
    public final boolean offer(Object obj) {
        int i = this.f2736a;
        h hVar = this.b;
        switch (i) {
            case 0:
                y yVar = (y) obj;
                y yVarB = yVar.b();
                y yVarE = yVar.e();
                Logger logger = e.u;
                yVarB.i(yVarE);
                yVarE.a(yVarB);
                i iVar = (i) hVar;
                y yVar2 = iVar.c;
                yVar2.i(yVar);
                yVar.a(yVar2);
                yVar.i(iVar);
                iVar.c = yVar;
                break;
            default:
                y yVar3 = (y) obj;
                y yVarF = yVar3.f();
                y yVarC = yVar3.c();
                Logger logger2 = e.u;
                yVarF.o(yVarC);
                yVarC.n(yVarF);
                i iVar2 = (i) hVar;
                y yVar4 = iVar2.c;
                yVar4.o(yVar3);
                yVar3.n(yVar4);
                yVar3.o(iVar2);
                iVar2.c = yVar3;
                break;
        }
        return true;
    }

    @Override // java.util.Queue
    public final Object peek() {
        switch (this.f2736a) {
            case 0:
                i iVar = (i) this.b;
                y yVar = iVar.b;
                if (yVar == iVar) {
                    return null;
                }
                return yVar;
            default:
                i iVar2 = (i) this.b;
                y yVar2 = iVar2.b;
                if (yVar2 == iVar2) {
                    return null;
                }
                return yVar2;
        }
    }

    @Override // java.util.Queue
    public final Object poll() {
        switch (this.f2736a) {
            case 0:
                i iVar = (i) this.b;
                y yVar = iVar.b;
                if (yVar == iVar) {
                    return null;
                }
                remove(yVar);
                return yVar;
            default:
                i iVar2 = (i) this.b;
                y yVar2 = iVar2.b;
                if (yVar2 == iVar2) {
                    return null;
                }
                remove(yVar2);
                return yVar2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object obj) {
        int i = this.f2736a;
        LocalCache$NullEntry localCache$NullEntry = LocalCache$NullEntry.f2729a;
        switch (i) {
            case 0:
                y yVar = (y) obj;
                y yVarB = yVar.b();
                y yVarE = yVar.e();
                Logger logger = e.u;
                yVarB.i(yVarE);
                yVarE.a(yVarB);
                yVar.i(localCache$NullEntry);
                yVar.a(localCache$NullEntry);
                if (yVarE != localCache$NullEntry) {
                    break;
                }
                break;
            default:
                y yVar2 = (y) obj;
                y yVarF = yVar2.f();
                y yVarC = yVar2.c();
                Logger logger2 = e.u;
                yVarF.o(yVarC);
                yVarC.n(yVarF);
                yVar2.o(localCache$NullEntry);
                yVar2.n(localCache$NullEntry);
                if (yVarC != localCache$NullEntry) {
                    break;
                }
                break;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        switch (this.f2736a) {
            case 0:
                i iVar = (i) this.b;
                int i = 0;
                for (y yVarE = iVar.b; yVarE != iVar; yVarE = yVarE.e()) {
                    i++;
                }
                return i;
            default:
                i iVar2 = (i) this.b;
                int i6 = 0;
                for (y yVarC = iVar2.b; yVarC != iVar2; yVarC = yVarC.c()) {
                    i6++;
                }
                return i6;
        }
    }
}
