package androidx.core.content;

import android.content.ContentValues;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: compiled from: ContentValues.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u00012.\u0010\u0002\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"contentValuesOf", "Landroid/content/ContentValues;", "pairs", "", "Lkotlin/Pair;", "", "", "([Lkotlin/Pair;)Landroid/content/ContentValues;", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ContentValuesKt {
    public static final ContentValues contentValuesOf(Pair<String, ? extends Object>... r6) {
        Intrinsics.checkNotNullParameter(r6, "pairs");
        ContentValues r0 = new ContentValues(r6.length);
        int r1 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L37;
        Pair<String, ? extends Object> r3 = r6[r2];
        String r4 = r3.component1();
        Object r5 = r3.component2();
        if (r5 != null) goto L8;
        r0.putNull(r4);
    L34:
        r2 = r2 + 1;
        goto L3
    L8:
        if ((r5 instanceof String) == false) goto L11;
        r0.put(r4, (String) r5);
        goto L34
    L11:
        if ((r5 instanceof Integer) == false) goto L14;
        r0.put(r4, (Integer) r5);
        goto L34
    L14:
        if ((r5 instanceof Long) == false) goto L17;
        r0.put(r4, (Long) r5);
        goto L34
    L17:
        if ((r5 instanceof Boolean) == false) goto L20;
        r0.put(r4, (Boolean) r5);
        goto L34
    L20:
        if ((r5 instanceof Float) == false) goto L23;
        r0.put(r4, (Float) r5);
        goto L34
    L23:
        if ((r5 instanceof Double) == false) goto L26;
        r0.put(r4, (Double) r5);
        goto L34
    L26:
        if ((r5 instanceof byte[]) == false) goto L29;
        r0.put(r4, (byte[]) r5);
        goto L34
    L29:
        if ((r5 instanceof Byte) == false) goto L32;
        r0.put(r4, (Byte) r5);
        goto L34
    L32:
        if ((r5 instanceof Short) == false) goto L36;
        r0.put(r4, (Short) r5);
        goto L34
    L36:
        throw new IllegalArgumentException("Illegal value type " + r5.getClass().getCanonicalName() + " for key \"" + r4 + Typography.quote);
    L37:
        return r0;
    }
}
