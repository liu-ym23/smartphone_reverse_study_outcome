package androidx.compose.ui.modifier;

import C7.c;
import D7.q;
import Z0.a;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u001a\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a&\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0018\u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0004\u0012\u0002H\u00020\u0006\u001a?\u0010\u0000\u001a\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00042\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00042\u001a\u0010\t\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00040\n\"\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\u000b\u001ao\u0010\u0000\u001a\u00020\u00012\u0016\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\r0\u00062\u0016\u0010\u000e\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\r0\u000622\u0010\u000f\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\r0\u00060\n\"\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\r0\u0006¢\u0006\u0002\u0010\u0010\u001a)\u0010\u0000\u001a\u00020\u00012\u001a\u0010\t\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00040\n\"\u0006\u0012\u0002\b\u00030\u0004H\u0007¢\u0006\u0002\u0010\u0011\u001aA\u0010\u0000\u001a\u00020\u000122\u0010\u000f\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\r0\u00060\n\"\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\r0\u0006H\u0007¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"modifierLocalMapOf", "Landroidx/compose/ui/modifier/ModifierLocalMap;", ExifInterface.GPS_DIRECTION_TRUE, "key", "Landroidx/compose/ui/modifier/ModifierLocal;", "entry", "Lkotlin/Pair;", "key1", "key2", "keys", "", "(Landroidx/compose/ui/modifier/ModifierLocal;Landroidx/compose/ui/modifier/ModifierLocal;[Landroidx/compose/ui/modifier/ModifierLocal;)Landroidx/compose/ui/modifier/ModifierLocalMap;", "entry1", "", "entry2", "entries", "(Lkotlin/Pair;Lkotlin/Pair;[Lkotlin/Pair;)Landroidx/compose/ui/modifier/ModifierLocalMap;", "([Landroidx/compose/ui/modifier/ModifierLocal;)Landroidx/compose/ui/modifier/ModifierLocalMap;", "([Lkotlin/Pair;)Landroidx/compose/ui/modifier/ModifierLocalMap;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ModifierLocalModifierNodeKt {
    public static final ModifierLocalMap modifierLocalMapOf(ModifierLocal<?> modifierLocal, ModifierLocal<?> modifierLocal2, ModifierLocal<?>... modifierLocalArr) {
        Pair pair = new Pair(modifierLocal, null);
        a aVar = new a(2);
        ArrayList arrayList = (ArrayList) aVar.f1582a;
        aVar.D(new Pair(modifierLocal2, null));
        ArrayList arrayList2 = new ArrayList(modifierLocalArr.length);
        for (ModifierLocal<?> modifierLocal3 : modifierLocalArr) {
            arrayList2.add(new Pair(modifierLocal3, null));
        }
        aVar.E(arrayList2.toArray(new Pair[0]));
        return new MultiLocalMap(pair, (Pair[]) arrayList.toArray(new Pair[arrayList.size()]));
    }

    public static final ModifierLocalMap modifierLocalMapOf() {
        return EmptyMap.INSTANCE;
    }

    public static final <T> ModifierLocalMap modifierLocalMapOf(ModifierLocal<T> modifierLocal) {
        return new SingleLocalMap(modifierLocal);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> ModifierLocalMap modifierLocalMapOf(Pair<? extends ModifierLocal<T>, ? extends T> pair) {
        SingleLocalMap singleLocalMap = new SingleLocalMap((ModifierLocal) pair.f4886a);
        singleLocalMap.mo5681set$ui_release((ModifierLocal) pair.f4886a, pair.b);
        return singleLocalMap;
    }

    public static final ModifierLocalMap modifierLocalMapOf(Pair<? extends ModifierLocal<?>, ? extends Object> pair, Pair<? extends ModifierLocal<?>, ? extends Object> pair2, Pair<? extends ModifierLocal<?>, ? extends Object>... pairArr) {
        a aVar = new a(2);
        aVar.D(pair2);
        aVar.E(pairArr);
        ArrayList arrayList = (ArrayList) aVar.f1582a;
        return new MultiLocalMap(pair, (Pair[]) arrayList.toArray(new Pair[arrayList.size()]));
    }

    @c
    public static final ModifierLocalMap modifierLocalMapOf(ModifierLocal... modifierLocalArr) {
        int length = modifierLocalArr.length;
        if (length == 0) {
            return EmptyMap.INSTANCE;
        }
        if (length != 1) {
            Pair pair = new Pair(q.k0(modifierLocalArr), null);
            List listE0 = q.e0(1, modifierLocalArr);
            ArrayList arrayList = new ArrayList(listE0.size());
            int size = listE0.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(new Pair((ModifierLocal) listE0.get(i), null));
            }
            Pair[] pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
            return new MultiLocalMap(pair, (Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        }
        return new SingleLocalMap((ModifierLocal) q.k0(modifierLocalArr));
    }

    @c
    public static final /* synthetic */ ModifierLocalMap modifierLocalMapOf(Pair... pairArr) {
        int length = pairArr.length;
        if (length == 0) {
            return EmptyMap.INSTANCE;
        }
        if (length != 1) {
            Pair pair = (Pair) q.k0(pairArr);
            Pair[] pairArr2 = (Pair[]) q.e0(1, pairArr).toArray(new Pair[0]);
            return new MultiLocalMap(pair, (Pair[]) Arrays.copyOf(pairArr2, pairArr2.length));
        }
        return new MultiLocalMap((Pair) q.k0(pairArr), new Pair[0]);
    }
}
