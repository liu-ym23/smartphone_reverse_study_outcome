package androidx.compose.foundation.text.input.internal;

import android.view.inputmethod.EditorInfo;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Landroidx/compose/foundation/text/input/internal/LocaleListHelper;", "", "<init>", "()V", "setHintLocales", "", "editorInfo", "Landroid/view/inputmethod/EditorInfo;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LocaleListHelper {
    public static final int $stable = 0;
    public static final LocaleListHelper INSTANCE = null;

    static {
        INSTANCE = new LocaleListHelper();
    }

    private LocaleListHelper() {
    }

    public final void setHintLocales(EditorInfo r100, LocaleList r101) {
        if (Intrinsics.areEqual(r101, LocaleList.Companion.getEmpty()) == false) goto L5;
        r100.hintLocales = null;
        return;
    L5:
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<Locale> r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        r102.add(r103.next().getPlatformLocale());
        goto L7
    L9:
        java.util.Locale[] r104 = (java.util.Locale[]) r102.toArray(new java.util.Locale[0]);
        r100.hintLocales = new android.os.LocaleList((java.util.Locale[]) Arrays.copyOf(r104, r104.length));
    }
}
