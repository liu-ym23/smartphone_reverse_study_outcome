package a0a;

import android.os.Bundle;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class b implements t1a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f1331a;

    public b() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f1331a, ((b) r100).f1331a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Bundle r100 = this.f1331a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "SpringMainVenueArgumentData(arguments=" + this.f1331a + ')';
    }

    public final String a() {
        Bundle r100 = this.f1331a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getString("action_bar_key");
    }

    public final String b() {
        Bundle r100 = this.f1331a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getString("enter_method");
    }

    public b(Bundle r100) {
        this.f1331a = r100;
    }

    public final List<a> c(String r210) {
        List r100 = StringsKt.split$default(r210, new String[]{"_"}, false, 0, 6, null);
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(StringsKt.trim((String) r102.next()).toString());
        goto L4
    L6:
        ArrayList r103 = new ArrayList();
        Iterator r104 = r101.iterator();
    L7:
        boolean r105 = false;
        if (r104.hasNext() == false) goto L14;
        Object r106 = r104.next();
        if (((String) r106).length() <= 0) goto L12;
        r105 = true;
    L12:
        if (r105 == false) goto L7;
        r103.add(r106);
        goto L7
    L14:
        ArrayList r107 = new ArrayList();
        int r108 = ProgressionUtilKt.getProgressionLastElement(0, r103.size() - 1, 2);
        if (r108 < 0) goto L45;
        int r109 = 0;
    L17:
        int r110 = r109 + 1;
        if (r110 >= r103.size()) goto L45;
        String r111 = (String) ListProtector.get(r103, r109);
        String r112 = (String) ListProtector.get(r103, r110);
        Float r113 = StringsKt.toFloatOrNull(r111);
        if (r113 == null) goto L43;
        float r114 = r113.floatValue();
        if (r114 < 0.0f) goto L43;
        if (r114 > 1.0f) goto L43;
        String r115 = StringsKt.replace$default(r112, "#", "", false, 4, null).toUpperCase(Locale.ROOT);
        if (new Regex("[0-9A-F]+").matches(r115) == false) goto L33;
        int r116 = r115.length();
        if (r116 != 3) goto L32;
        StringBuilder r117 = new StringBuilder("#");
        ArrayList r118 = new ArrayList(r115.length());
        int r119 = 0;
    L37:
        if (r119 >= r115.length()) goto L39;
        r118.add(StringsKt.repeat(String.valueOf(r115.charAt(r119)), 2));
        r119 = r119 + 1;
        goto L37
    L39:
        r117.append(CollectionsKt.joinToString$default(r118, "", null, null, 0, null, null, 62, null));
        String r120 = r117.toString();
    L40:
        if (r120 == null) goto L43;
        r107.add(new a(r120, r114));
        goto L43
    L32:
        if (r116 != 6) goto L33;
        r120 = "#".concat(r115);
    L33:
        r120 = null;
    L43:
        if (r109 == r108) goto L45;
        r109 = r109 + 2;
    L45:
        return r107;
    }
}
