package androidx.compose.ui.modifier;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.SpreadBuilder;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u001a\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a&\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0018\u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0004\u0012\u0002H\u00020\u0006\u001a?\u0010\u0000\u001a\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00042\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00042\u001a\u0010\t\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00040\n\"\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\u000b\u001ao\u0010\u0000\u001a\u00020\u00012\u0016\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\r0\u00062\u0016\u0010\u000e\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\r0\u000622\u0010\u000f\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\r0\u00060\n\"\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\r0\u0006¢\u0006\u0002\u0010\u0010\u001a)\u0010\u0000\u001a\u00020\u00012\u001a\u0010\t\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00040\n\"\u0006\u0012\u0002\b\u00030\u0004H\u0007¢\u0006\u0002\u0010\u0011\u001aA\u0010\u0000\u001a\u00020\u000122\u0010\u000f\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\r0\u00060\n\"\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\r0\u0006H\u0007¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"modifierLocalMapOf", "Landroidx/compose/ui/modifier/ModifierLocalMap;", ExifInterface.GPS_DIRECTION_TRUE, "key", "Landroidx/compose/ui/modifier/ModifierLocal;", "entry", "Lkotlin/Pair;", "key1", "key2", "keys", "", "(Landroidx/compose/ui/modifier/ModifierLocal;Landroidx/compose/ui/modifier/ModifierLocal;[Landroidx/compose/ui/modifier/ModifierLocal;)Landroidx/compose/ui/modifier/ModifierLocalMap;", "entry1", "", "entry2", "entries", "(Lkotlin/Pair;Lkotlin/Pair;[Lkotlin/Pair;)Landroidx/compose/ui/modifier/ModifierLocalMap;", "([Landroidx/compose/ui/modifier/ModifierLocal;)Landroidx/compose/ui/modifier/ModifierLocalMap;", "([Lkotlin/Pair;)Landroidx/compose/ui/modifier/ModifierLocalMap;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ModifierLocalModifierNodeKt {
    public static final ModifierLocalMap modifierLocalMapOf() {
        return EmptyMap.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use a different overloaded version of this function")
    public static final /* synthetic */ ModifierLocalMap modifierLocalMapOf(ModifierLocal... r100) {
        int r101 = r100.length;
        if (r101 == 0) goto L12;
        if (r101 == 1) goto L15;
        Pair r102 = TuplesKt.to(ArraysKt.first(r100), null);
        List r103 = ArraysKt.drop(r100, 1);
        ArrayList r104 = new ArrayList(r103.size());
        int r105 = r103.size();
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L9;
        r104.add(TuplesKt.to((ModifierLocal) ListProtector.get(r103, r106), null));
        r106 = r106 + 1;
        goto L7
    L9:
        Pair[] r107 = (Pair[]) r104.toArray(new Pair[0]);
        return new MultiLocalMap(r102, (Pair[]) Arrays.copyOf(r107, r107.length));
    L15:
        return new SingleLocalMap((ModifierLocal) ArraysKt.first(r100));
    L12:
        return EmptyMap.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use a different overloaded version of this function")
    public static final /* synthetic */ ModifierLocalMap modifierLocalMapOf(Pair... r100) {
        int r101 = r100.length;
        if (r101 == 0) goto L9;
        if (r101 == 1) goto L11;
        Pair r102 = (Pair) ArraysKt.first(r100);
        Pair[] r103 = (Pair[]) ArraysKt.drop(r100, 1).toArray(new Pair[0]);
        return new MultiLocalMap(r102, (Pair[]) Arrays.copyOf(r103, r103.length));
    L11:
        return new MultiLocalMap((Pair) ArraysKt.first(r100), new Pair[0]);
    L9:
        return EmptyMap.INSTANCE;
    }

    public static final <T> ModifierLocalMap modifierLocalMapOf(Pair<? extends ModifierLocal<T>, ? extends T> r100) {
        SingleLocalMap r101 = new SingleLocalMap(r100.getFirst());
        r101.mo6392set$ui_release(r100.getFirst(), r100.getSecond());
        return r101;
    }

    public static final <T> ModifierLocalMap modifierLocalMapOf(ModifierLocal<T> r100) {
        return new SingleLocalMap(r100);
    }

    public static final ModifierLocalMap modifierLocalMapOf(ModifierLocal<?> r100, ModifierLocal<?> r101, ModifierLocal<?>... r102) {
        Pair r103 = TuplesKt.to(r100, null);
        SpreadBuilder r104 = new SpreadBuilder(2);
        r104.add(TuplesKt.to(r101, null));
        ArrayList r105 = new ArrayList(r102.length);
        int r106 = r102.length;
        int r107 = 0;
    L3:
        if (r107 >= r106) goto L5;
        r105.add(TuplesKt.to(r102[r107], null));
        r107 = r107 + 1;
        goto L3
    L5:
        r104.addSpread(r105.toArray(new Pair[0]));
        return new MultiLocalMap(r103, (Pair[]) r104.toArray(new Pair[r104.size()]));
    }

    public static final ModifierLocalMap modifierLocalMapOf(Pair<? extends ModifierLocal<?>, ? extends Object> r100, Pair<? extends ModifierLocal<?>, ? extends Object> r101, Pair<? extends ModifierLocal<?>, ? extends Object>... r102) {
        SpreadBuilder r103 = new SpreadBuilder(2);
        r103.add(r101);
        r103.addSpread(r102);
        return new MultiLocalMap(r100, (Pair[]) r103.toArray(new Pair[r103.size()]));
    }
}
