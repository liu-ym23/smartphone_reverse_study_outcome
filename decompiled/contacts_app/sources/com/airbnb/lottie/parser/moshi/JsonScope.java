package com.airbnb.lottie.parser.moshi;

import com.android.contacts.common.list.DefaultContactListAdapter;

/* JADX INFO: loaded from: classes.dex */
final class JsonScope {
    static final int CLOSED = 8;
    static final int DANGLING_NAME = 4;
    static final int EMPTY_ARRAY = 1;
    static final int EMPTY_DOCUMENT = 6;
    static final int EMPTY_OBJECT = 3;
    static final int NONEMPTY_ARRAY = 2;
    static final int NONEMPTY_DOCUMENT = 7;
    static final int NONEMPTY_OBJECT = 5;

    private JsonScope() {
    }

    static String getPath(int r4, int[] r5, String[] r6, int[] r7) {
        StringBuilder r0 = new StringBuilder("$");
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L21;
        int r2 = r5[r1];
        if (r2 != 1) goto L7;
    L18:
        r0.append(DefaultContactListAdapter.SNIPPET_START_MATCH).append(r7[r1]).append(DefaultContactListAdapter.SNIPPET_END_MATCH);
    L19:
        r1 = r1 + 1;
        goto L3
    L7:
        if (r2 == 2) goto L18;
        if (r2 != 3) goto L11;
    L15:
        r0.append('.');
        String r3 = r6[r1];
        if (r3 == null) goto L19;
        r0.append(r3);
        goto L19
    L11:
        if (r2 == 4) goto L15;
        if (r2 == 5) goto L15;
    L21:
        return r0.toString();
    }
}
