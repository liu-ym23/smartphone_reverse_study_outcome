package com.android.common;

import android.app.SearchableInfo;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.obric.aikernel.sdk.ext.Params;

/* JADX INFO: loaded from: classes.dex */
public class Search {
    public static final String SOURCE = "source";
    public static final String SUGGEST_COLUMN_LAST_ACCESS_HINT = "suggest_last_access_hint";

    private Search() {
    }

    public static Cursor getSuggestions(Context r1, SearchableInfo r2, String r3) {
        return getSuggestions(r1, r2, r3, -1);
    }

    public static Cursor getSuggestions(Context r9, SearchableInfo r10, String r11, int r12) {
        String[] r0 = null;
        if (r10 != null) goto L5;
        return null;
    L5:
        String r1 = r10.getSuggestAuthority();
        if (r1 != null) goto L8;
        return null;
    L8:
        Uri.Builder r2 = new Uri.Builder().scheme(Params.CONTENT).authority(r1).query("").fragment("");
        String r3 = r10.getSuggestPath();
        if (r3 == null) goto L11;
        r2.appendEncodedPath(r3);
    L11:
        r2.appendPath("search_suggest_query");
        String r6 = r10.getSuggestSelection();
        if (r6 == null) goto L14;
        r0 = new String[]{r11};
    L15:
        String[] r7 = r0;
        if (r12 <= 0) goto L19;
        r2.appendQueryParameter("limit", String.valueOf(r12));
    L19:
        return r9.getContentResolver().query(r2.build(), null, r6, r7, null);
    L14:
        r2.appendPath(r11);
        goto L15
    }
}
