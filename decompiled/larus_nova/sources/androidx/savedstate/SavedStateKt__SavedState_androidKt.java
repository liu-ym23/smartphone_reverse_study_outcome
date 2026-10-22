package androidx.savedstate;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001aC\u0010\u0002\u001a\u00060\u0001j\u0002`\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\u0019\b\u0002\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\fH\u0086\bø\u0001\u0000\u001a7\u0010\u0002\u001a\u00060\u0001j\u0002`\u00032\n\u0010\u0004\u001a\u00060\u0001j\u0002`\u00032\u0019\b\u0002\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\fH\u0086\bø\u0001\u0000*\n\u0010\u0000\"\u00020\u00012\u00020\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"SavedState", "Landroid/os/Bundle;", "savedState", "Landroidx/savedstate/SavedState;", "initialState", "", "", "", "builderAction", "Lkotlin/Function1;", "Landroidx/savedstate/SavedStateWriter;", "", "Lkotlin/ExtensionFunctionType;", "savedstate"}, k = 5, mv = {2, 0, 0}, xi = 48, xs = "androidx/savedstate/SavedStateKt")
final /* synthetic */ class SavedStateKt__SavedState_androidKt {
    public static final Bundle savedState(Map<String, ? extends Object> r100, Function1<? super SavedStateWriter, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "initialState");
        Intrinsics.checkNotNullParameter(r101, "builderAction");
        if (r100.isEmpty() == false) goto L5;
        Pair[] r102 = new Pair[0];
    L10:
        Bundle r103 = BundleKt.bundleOf((Pair[]) Arrays.copyOf(r102, r102.length));
        r101.invoke(SavedStateWriter.m7915boximpl(SavedStateWriter.m7917constructorimpl(r103)));
        return r103;
    L5:
        ArrayList r104 = new ArrayList(r100.size());
        Iterator<Map.Entry<String, ? extends Object>> r105 = r100.entrySet().iterator();
    L7:
        if (r105.hasNext() == false) goto L9;
        Map.Entry<String, ? extends Object> r106 = r105.next();
        r104.add(TuplesKt.to(r106.getKey(), r106.getValue()));
        goto L7
    L9:
        r102 = (Pair[]) r104.toArray(new Pair[0]);
        goto L10
    }

    public static final Bundle savedState(Bundle r100, Function1<? super SavedStateWriter, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "initialState");
        Intrinsics.checkNotNullParameter(r101, "builderAction");
        Bundle r102 = new Bundle(r100);
        r101.invoke(SavedStateWriter.m7915boximpl(SavedStateWriter.m7917constructorimpl(r102)));
        return r102;
    }

    public static /* synthetic */ Bundle savedState$default(Map r100, Function1 r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = MapsKt.emptyMap();
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = AnonymousClass1.INSTANCE;
    L8:
        Intrinsics.checkNotNullParameter(r100, "initialState");
        Intrinsics.checkNotNullParameter(r101, "builderAction");
        if (r100.isEmpty() == false) goto L11;
        Pair[] r104 = new Pair[0];
    L16:
        Bundle r105 = BundleKt.bundleOf((Pair[]) Arrays.copyOf(r104, r104.length));
        r101.invoke(SavedStateWriter.m7915boximpl(SavedStateWriter.m7917constructorimpl(r105)));
        return r105;
    L11:
        ArrayList r106 = new ArrayList(r100.size());
        Iterator r107 = r100.entrySet().iterator();
    L13:
        if (r107.hasNext() == false) goto L15;
        Map.Entry r108 = (Map.Entry) r107.next();
        r106.add(TuplesKt.to((String) r108.getKey(), r108.getValue()));
        goto L13
    L15:
        r104 = (Pair[]) r106.toArray(new Pair[0]);
        goto L16
    }

    public static /* synthetic */ Bundle savedState$default(Bundle r100, Function1 r101, int r102, Object r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = AnonymousClass3.INSTANCE;
    L5:
        Intrinsics.checkNotNullParameter(r100, "initialState");
        Intrinsics.checkNotNullParameter(r101, "builderAction");
        Bundle r104 = new Bundle(r100);
        r101.invoke(SavedStateWriter.m7915boximpl(SavedStateWriter.m7917constructorimpl(r104)));
        return r104;
    }
}
