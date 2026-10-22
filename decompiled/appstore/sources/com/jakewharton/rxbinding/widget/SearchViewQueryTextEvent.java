package com.jakewharton.rxbinding.widget;

import android.widget.SearchView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding.view.ViewEvent;

/* JADX INFO: loaded from: classes3.dex */
public final class SearchViewQueryTextEvent extends ViewEvent<SearchView> {
    private final CharSequence queryText;
    private final boolean submitted;

    private SearchViewQueryTextEvent(@NonNull SearchView r10, @NonNull CharSequence r11, boolean r12) {
        super(r10);
        this.queryText = r11;
        this.submitted = r12;
    }

    @NonNull
    @CheckResult
    public static SearchViewQueryTextEvent create(@NonNull SearchView r10, @NonNull CharSequence r11, boolean r12) {
        return new SearchViewQueryTextEvent(r10, r11, r12);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof SearchViewQueryTextEvent) == true) goto L8;
        return false;
    L8:
        SearchViewQueryTextEvent r11 = (SearchViewQueryTextEvent) r10;
        if (r11.view() != view()) goto L16;
        if (r11.queryText.equals(this.queryText) == false) goto L16;
        if (r11.submitted != this.submitted) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        return ((((629 + view().hashCode()) * 37) + this.queryText.hashCode()) * 37) + (this.submitted ? 1 : 0);
    }

    public boolean isSubmitted() {
        return this.submitted;
    }

    @NonNull
    public CharSequence queryText() {
        return this.queryText;
    }

    public String toString() {
        return "SearchViewQueryTextEvent{view=" + view() + ", queryText=" + this.queryText + ", submitted=" + this.submitted + '}';
    }
}
