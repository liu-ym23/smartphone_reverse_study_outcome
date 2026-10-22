package d;

import B0.f;
import android.content.Intent;
import androidx.activity.o;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* renamed from: d.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0529c extends AbstractC0528b {
    @Override // d.AbstractC0528b
    public final Intent a(o context, Object obj) {
        String[] input = (String[]) obj;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(input, "input");
        Intent intentPutExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", input);
        Intrinsics.checkNotNullExpressionValue(intentPutExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
        return intentPutExtra;
    }

    @Override // d.AbstractC0528b
    public final C0527a b(o context, Object obj) {
        String[] input = (String[]) obj;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        if (input.length == 0) {
            return new C0527a(0, MapsKt.emptyMap());
        }
        for (String str : input) {
            if (f.i(context, str) != 0) {
                return null;
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(input.length), 16));
        for (String str2 : input) {
            Pair pair = TuplesKt.to(str2, Boolean.TRUE);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return new C0527a(0, linkedHashMap);
    }

    @Override // d.AbstractC0528b
    public final Object c(int i4, Intent intent) {
        if (i4 == -1 && intent != null) {
            String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
            if (intArrayExtra == null || stringArrayExtra == null) {
                return MapsKt.emptyMap();
            }
            ArrayList arrayList = new ArrayList(intArrayExtra.length);
            for (int i5 : intArrayExtra) {
                arrayList.add(Boolean.valueOf(i5 == 0));
            }
            return MapsKt.toMap(CollectionsKt___CollectionsKt.zip(ArraysKt.filterNotNull(stringArrayExtra), arrayList));
        }
        return MapsKt.emptyMap();
    }
}
