package androidx.compose.runtime.snapshots;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import d0.f;
import j0.C4748f;
import j0.r;
import j0.t;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u001a9\u0010\u0006\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0018\u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a5\u0010\r\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\n\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a-\u0010\u0011\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0000¢\u0006\u0004\b\u0011\u0010\u0012\"\u0018\u0010\u0017\u001a\u00060\u0013j\u0002`\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016\"$\u0010\u001a\u001a\u00020\t\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\"0\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00018@X\u0080\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/snapshots/SnapshotStateSet;", "Lkotlin/Function1;", "", "", "block", "e", "(Landroidx/compose/runtime/snapshots/SnapshotStateSet;Lp9/l;)Z", "Lj0/t;", "", "currentModification", "Ld0/f;", "newSet", Const.INTENT_KEY_PKGNAME, "(Lj0/t;ILd0/f;)Z", "set", "Lj0/r;", "f", "(Landroidx/compose/runtime/snapshots/SnapshotStateSet;Ld0/f;)Lj0/r;", "", "Landroidx/compose/runtime/platform/SynchronizedObject;", Const.INTENT_KEY_APIKEY, "Ljava/lang/Object;", "sync", "c", "(Landroidx/compose/runtime/snapshots/SnapshotStateSet;)I", "modification", Const.INTENT_KEY_UMID, "(Landroidx/compose/runtime/snapshots/SnapshotStateSet;)Lj0/t;", "getReadable$annotations", "(Landroidx/compose/runtime/snapshots/SnapshotStateSet;)V", "readable", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f11800a = new Object();

    public static final <T> boolean b(t<T> tVar, int i10, f<? extends T> fVar) {
        boolean z10;
        synchronized (f11800a) {
            if (tVar.g() == i10) {
                tVar.j(fVar);
                z10 = true;
                tVar.i(tVar.g() + 1);
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    public static final <T> int c(SnapshotStateSet<T> snapshotStateSet) {
        r firstStateRecord = snapshotStateSet.getFirstStateRecord();
        p.g(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.withCurrent>");
        return ((t) d.e((t) firstStateRecord)).g();
    }

    public static final <T> t<T> d(SnapshotStateSet<T> snapshotStateSet) {
        r firstStateRecord = snapshotStateSet.getFirstStateRecord();
        p.g(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.<get-readable>>");
        return (t) d.o((t) firstStateRecord, snapshotStateSet);
    }

    public static final <T> boolean e(SnapshotStateSet<T> snapshotStateSet, InterfaceC5074l<? super Set<T>, Boolean> interfaceC5074l) {
        int iG;
        f<T> fVarH;
        f.a<T> aVarBuilder;
        Boolean boolInvoke;
        c cVarA;
        boolean zB;
        do {
            synchronized (f11800a) {
                r firstStateRecord = snapshotStateSet.getFirstStateRecord();
                p.g(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.withCurrent>");
                t tVar = (t) d.e((t) firstStateRecord);
                iG = tVar.g();
                fVarH = tVar.h();
                Y8.t tVar2 = Y8.t.f7040a;
            }
            if (fVarH != null && (aVarBuilder = fVarH.builder()) != null) {
                boolInvoke = interfaceC5074l.invoke(aVarBuilder);
                f<T> fVarBuild = aVarBuilder.build();
                if (p.d(fVarBuild, fVarH)) {
                    break;
                }
                r firstStateRecord2 = snapshotStateSet.getFirstStateRecord();
                p.g(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.writable>");
                t tVar3 = (t) firstStateRecord2;
                synchronized (d.h()) {
                    cVarA = c.INSTANCE.a();
                    zB = b((t) d.t(tVar3, snapshotStateSet, cVarA), iG, fVarBuild);
                }
                d.k(cVarA, snapshotStateSet);
            } else {
                throw new IllegalStateException("No set to mutate");
            }
        } while (!zB);
        return boolInvoke.booleanValue();
    }

    public static final <T> r f(SnapshotStateSet<T> snapshotStateSet, f<? extends T> fVar) {
        t tVar = new t(d.f().getSnapshotId(), fVar);
        if (c.INSTANCE.b()) {
            tVar.e(new t(C4748f.c(1), fVar));
        }
        return tVar;
    }
}
