package androidx.compose.ui.text;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u001e\u0010\u0000\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00030\u0002H\u0000\u001a*\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0018\u00010\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0002¨\u0006\f"}, d2 = {"transform", "Landroidx/compose/ui/text/AnnotatedString;", "Lkotlin/Function3;", "", "", "collectRangeTransitions", "", "ranges", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", PickerReporterConstants.KEY.TARGET, "Ljava/util/SortedSet;", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class JvmAnnotatedString_jvmKt {
    public static /* synthetic */ Integer a(Ref.ObjectRef r100, Function3 r101, AnnotatedString r102, Map r103, List r104) {
        return transform$lambda$0(r100, r101, r102, r103, r104);
    }

    private static final void collectRangeTransitions(List<? extends AnnotatedString.Range<?>> r100, SortedSet<Integer> r101) {
        if (r100 == null) goto L6;
        int r102 = r100.size();
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L8;
        AnnotatedString.Range r104 = (AnnotatedString.Range) ListProtector.get(r100, r103);
        r101.add(Integer.valueOf(r104.getStart()));
        r101.add(Integer.valueOf(r104.getEnd()));
        r103 = r103 + 1;
        goto L4
    L8:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final AnnotatedString transform(final AnnotatedString r110, final Function3<? super String, ? super Integer, ? super Integer, String> r111) {
        int r100 = 0;
        TreeSet r101 = SetsKt.sortedSetOf(new Integer[]{0, Integer.valueOf(r110.getText().length())});
        collectRangeTransitions(r110.getAnnotations$ui_text(), r101);
        final Ref.ObjectRef r102 = new Ref.ObjectRef();
        r102.element = "";
        final Map r103 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(0, 0)});
        CollectionsKt.windowed$default(r101, 2, 0, false, new g(r102, r111, r110, r103), 6, null);
        List<AnnotatedString.Range<? extends AnnotatedString.Annotation>> r112 = r110.getAnnotations$ui_text();
        if (r112 == null) goto L7;
        ArrayList r113 = new ArrayList(r112.size());
        int r104 = r112.size();
    L5:
        if (r100 >= r104) goto L9;
        AnnotatedString.Range r105 = (AnnotatedString.Range) ListProtector.get(r112, r100);
        Object r106 = r105.getItem();
        Object r107 = r103.get(Integer.valueOf(r105.getStart()));
        Intrinsics.checkNotNull(r107);
        int r108 = ((Number) r107).intValue();
        Object r109 = r103.get(Integer.valueOf(r105.getEnd()));
        Intrinsics.checkNotNull(r109);
        r113.add(new AnnotatedString.Range(r106, r108, ((Number) r109).intValue()));
        r100 = r100 + 1;
    L9:
        return new AnnotatedString(r113, (String) r102.element);
    L7:
        r113 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.String] */
    private static final Integer transform$lambda$0(Ref.ObjectRef r100, Function3 r101, AnnotatedString r102, Map r103, List r104) {
        int r105 = ((Number) ListProtector.get(r104, 0)).intValue();
        int r106 = ((Number) ListProtector.get(r104, 1)).intValue();
        r100.element = ((String) r100.element) + ((String) r101.invoke(r102.getText(), Integer.valueOf(r105), Integer.valueOf(r106)));
        return (Integer) r103.put(Integer.valueOf(r106), Integer.valueOf(((String) r100.element).length()));
    }
}
