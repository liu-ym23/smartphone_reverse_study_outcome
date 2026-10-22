package f1;

import Z8.C1173v;
import androidx.room.C1407c;
import androidx.room.RoomDatabase;
import com.autonavi.aps.amapapi.config.Const;
import d1.AbstractC3942a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\u001a#\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a#\u0010\n\u001a\u00020\u0004*\u00020\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a+\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e*\u00020\u00072\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001aA\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e*\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00122\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/room/c;", "", "fromVersion", "toVersion", "", Const.INTENT_KEY_UMID, "(Landroidx/room/c;II)Z", "Landroidx/room/RoomDatabase$d;", "startVersion", "endVersion", Const.INTENT_KEY_APIKEY, "(Landroidx/room/RoomDatabase$d;II)Z", "start", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "", "Ld1/a;", Const.INTENT_KEY_PKGNAME, "(Landroidx/room/RoomDatabase$d;II)Ljava/util/List;", "", "result", "upgrade", "c", "(Landroidx/room/RoomDatabase$d;Ljava/util/List;ZII)Ljava/util/List;", "room-runtime"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* renamed from: f1.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4037g {
    public static final boolean a(RoomDatabase.d dVar, int i10, int i11) {
        p.i(dVar, "<this>");
        Map<Integer, Map<Integer, AbstractC3942a>> mapE = dVar.e();
        if (!mapE.containsKey(Integer.valueOf(i10))) {
            return false;
        }
        Map<Integer, AbstractC3942a> mapI = mapE.get(Integer.valueOf(i10));
        if (mapI == null) {
            mapI = kotlin.collections.a.i();
        }
        return mapI.containsKey(Integer.valueOf(i11));
    }

    public static final List<AbstractC3942a> b(RoomDatabase.d dVar, int i10, int i11) {
        p.i(dVar, "<this>");
        if (i10 == i11) {
            return C1173v.m();
        }
        return c(dVar, new ArrayList(), i11 > i10, i10, i11);
    }

    public static final List<AbstractC3942a> c(RoomDatabase.d dVar, List<AbstractC3942a> list, boolean z10, int i10, int i11) {
        int iIntValue;
        boolean z11;
        while (true) {
            if (z10) {
                if (i10 >= i11) {
                    return list;
                }
            } else if (i10 <= i11) {
                return list;
            }
            Pair<Map<Integer, AbstractC3942a>, Iterable<Integer>> pairF = z10 ? dVar.f(i10) : dVar.g(i10);
            if (pairF == null) {
                return null;
            }
            Map<Integer, AbstractC3942a> mapA = pairF.a();
            Iterator<Integer> it = pairF.b().iterator();
            while (it.hasNext()) {
                iIntValue = it.next().intValue();
                if (!z10) {
                    if (i11 <= iIntValue && iIntValue < i10) {
                        AbstractC3942a abstractC3942a = mapA.get(Integer.valueOf(iIntValue));
                        p.f(abstractC3942a);
                        list.add(abstractC3942a);
                        z11 = true;
                        break;
                    }
                } else if (i10 + 1 <= iIntValue && iIntValue <= i11) {
                    AbstractC3942a abstractC3942a2 = mapA.get(Integer.valueOf(iIntValue));
                    p.f(abstractC3942a2);
                    list.add(abstractC3942a2);
                    z11 = true;
                    break;
                }
            }
            iIntValue = i10;
            z11 = false;
            if (!z11) {
                return null;
            }
            i10 = iIntValue;
        }
    }

    public static final boolean d(C1407c c1407c, int i10, int i11) {
        p.i(c1407c, "<this>");
        if (i10 > i11 && c1407c.allowDestructiveMigrationOnDowngrade) {
            return false;
        }
        Set<Integer> setC = c1407c.c();
        return c1407c.requireMigration && (setC == null || !setC.contains(Integer.valueOf(i10)));
    }
}
