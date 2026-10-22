package androidx.compose.ui.layout;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a1\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"mergeRulerValues", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "useGreater", "", "rulers", "", "Landroidx/compose/ui/layout/Ruler;", "defaultValue", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;Z[Landroidx/compose/ui/layout/Ruler;F)F", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class RulerKt {
    public static final /* synthetic */ float access$mergeRulerValues(Placeable.PlacementScope r100, boolean r101, Ruler[] r102, float r103) {
        return mergeRulerValues(r100, r101, r102, r103);
    }

    private static final float mergeRulerValues(Placeable.PlacementScope r100, boolean r101, Ruler[] r102, float r110) {
        int r103 = r102.length;
        int r104 = 0;
        float r105 = Float.NaN;
    L3:
        if (r104 >= r103) goto L14;
        float r106 = r100.current(r102[r104], Float.NaN);
        if (Float.isNaN(r105) == false) goto L7;
    L11:
        r105 = r106;
    L12:
        r104 = r104 + 1;
        goto L3
    L7:
        if (r106 <= r105) goto L9;
        boolean r107 = true;
    L10:
        if (r101 != r107) goto L12;
    L9:
        r107 = false;
        goto L10
    L14:
        if (Float.isNaN(r105) == false) goto L17;
        return r110;
    L17:
        return r105;
    }
}
