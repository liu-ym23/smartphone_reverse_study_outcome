package h3;

import ch.qos.logback.core.CoreConstants;
import java.util.ArrayList;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes2.dex */
public final class G {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f12711a = new ArrayList(20);

    public final void a(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        C0611u.e(name);
        C0611u.f(value, name);
        c(name, value);
    }

    public final void b(String line) {
        Intrinsics.checkNotNullParameter(line, "line");
        int iIndexOf$default = StringsKt__StringsKt.indexOf$default(line, CoreConstants.COLON_CHAR, 1, false, 4, (Object) null);
        if (iIndexOf$default != -1) {
            String strSubstring = line.substring(0, iIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            String strSubstring2 = line.substring(iIndexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
            c(strSubstring, strSubstring2);
            return;
        }
        if (line.charAt(0) != ':') {
            c("", line);
            return;
        }
        String strSubstring3 = line.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring3, "this as java.lang.String).substring(startIndex)");
        c("", strSubstring3);
    }

    public final void c(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        ArrayList arrayList = this.f12711a;
        arrayList.add(name);
        arrayList.add(StringsKt.trim((CharSequence) value).toString());
    }

    public final H d() {
        Object[] array = this.f12711a.toArray(new String[0]);
        if (array != null) {
            return new H((String[]) array);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public final String e(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        ArrayList arrayList = this.f12711a;
        int size = arrayList.size() - 2;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(size, 0, -2);
        if (progressionLastElement > size) {
            return null;
        }
        while (true) {
            int i4 = size - 2;
            if (StringsKt__StringsJVMKt.equals(name, (String) arrayList.get(size), true)) {
                return (String) arrayList.get(size + 1);
            }
            if (size == progressionLastElement) {
                return null;
            }
            size = i4;
        }
    }

    public final void f(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        int i4 = 0;
        while (true) {
            ArrayList arrayList = this.f12711a;
            if (i4 >= arrayList.size()) {
                return;
            }
            if (StringsKt__StringsJVMKt.equals(name, (String) arrayList.get(i4), true)) {
                arrayList.remove(i4);
                arrayList.remove(i4);
                i4 -= 2;
            }
            i4 += 2;
        }
    }
}
