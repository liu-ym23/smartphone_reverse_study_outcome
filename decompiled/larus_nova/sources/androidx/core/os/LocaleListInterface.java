package androidx.core.os;

import java.util.Locale;

/* JADX INFO: loaded from: classes17.dex */
interface LocaleListInterface {
    Locale get(int r100);

    Locale getFirstMatch(String[] r100);

    Object getLocaleList();

    int indexOf(Locale r100);

    boolean isEmpty();

    int size();

    String toLanguageTags();
}
