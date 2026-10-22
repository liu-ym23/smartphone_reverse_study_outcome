package androidx.core.content;

import android.content.ContentValues;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u00012.\u0010\u0002\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"contentValuesOf", "Landroid/content/ContentValues;", "pairs", "", "Lkotlin/Pair;", "", "", "([Lkotlin/Pair;)Landroid/content/ContentValues;", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ContentValuesKt {
    public static final ContentValues contentValuesOf(Pair<String, ? extends Object>... r100) {
        ContentValues r101 = new ContentValues(r100.length);
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L37;
        Pair<String, ? extends Object> r104 = r100[r103];
        String r105 = r104.component1();
        Object r106 = r104.component2();
        if (r106 != null) goto L8;
        r101.putNull(r105);
    L34:
        r103 = r103 + 1;
        goto L3
    L8:
        if ((r106 instanceof String) == false) goto L11;
        r101.put(r105, (String) r106);
        goto L34
    L11:
        if ((r106 instanceof Integer) == false) goto L14;
        r101.put(r105, (Integer) r106);
        goto L34
    L14:
        if ((r106 instanceof Long) == false) goto L17;
        r101.put(r105, (Long) r106);
        goto L34
    L17:
        if ((r106 instanceof Boolean) == false) goto L20;
        r101.put(r105, (Boolean) r106);
        goto L34
    L20:
        if ((r106 instanceof Float) == false) goto L23;
        r101.put(r105, (Float) r106);
        goto L34
    L23:
        if ((r106 instanceof Double) == false) goto L26;
        r101.put(r105, (Double) r106);
        goto L34
    L26:
        if ((r106 instanceof byte[]) == false) goto L29;
        r101.put(r105, (byte[]) r106);
        goto L34
    L29:
        if ((r106 instanceof Byte) == false) goto L32;
        r101.put(r105, (Byte) r106);
        goto L34
    L32:
        if ((r106 instanceof Short) == false) goto L36;
        r101.put(r105, (Short) r106);
        goto L34
    L36:
        throw new IllegalArgumentException("Illegal value type " + r106.getClass().getCanonicalName() + " for key \"" + r105 + Typography.quote);
    L37:
        return r101;
    }
}
