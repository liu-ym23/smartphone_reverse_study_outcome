package kotlin.reflect.jvm.internal.impl.renderer;

import com.bytedance.librarian.LibrarianImpl;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: compiled from: RenderingUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class RenderingUtilsKt {
    public static final String render(Name r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (shouldBeEscaped(r3) == false) goto L5;
        StringBuilder r0 = new StringBuilder();
        String r4 = r3.asString();
        Intrinsics.checkNotNullExpressionValue(r4, "asString()");
        return r0.append("`" + r4).append('`').toString();
    L5:
        String r5 = r3.asString();
        Intrinsics.checkNotNullExpressionValue(r5, "asString()");
        return r5;
    }

    private static final boolean shouldBeEscaped(Name r5) {
        String r6 = r5.asString();
        Intrinsics.checkNotNullExpressionValue(r6, "asString()");
        if (KeywordStringsGenerated.KEYWORDS.contains(r6) == true) goto L23;
        String r7 = r6;
        int r2 = 0;
    L6:
        if (r2 >= r7.length()) goto L16;
        char r3 = r7.charAt(r2);
        if (Character.isLetterOrDigit(r3) == false) goto L10;
    L12:
        boolean r4 = false;
    L13:
        if (r4 == true) goto L14;
        r2 = r2 + 1;
        goto L6
    L14:
        boolean r8 = true;
    L17:
        if (r8 == false) goto L20;
        return true;
    L20:
        return false;
    L10:
        if (r3 == '_') goto L12;
        r4 = true;
        goto L13
    L16:
        r8 = false;
        goto L17
    L23:
        return true;
    }

    public static final String render(FqNameUnsafe r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        List<Name> r2 = r1.pathSegments();
        Intrinsics.checkNotNullExpressionValue(r2, "pathSegments()");
        return renderFqName(r2);
    }

    public static final String renderFqName(List<Name> r3) {
        Intrinsics.checkNotNullParameter(r3, "pathSegments");
        StringBuilder r0 = new StringBuilder();
        Iterator<Name> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        Name r1 = r4.next();
        if (r0.length() <= 0) goto L8;
        r0.append(LibrarianImpl.Constants.DOT);
    L8:
        r0.append(render(r1));
        goto L4
    L9:
        String r5 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r5, "StringBuilder().apply(builderAction).toString()");
        return r5;
    }
}
