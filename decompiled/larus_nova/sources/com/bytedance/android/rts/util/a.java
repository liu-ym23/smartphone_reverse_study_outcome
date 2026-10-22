package com.bytedance.android.rts.util;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.rts.foundation.j;
import java.util.ArrayList;
import java.util.List;
import py.k;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f163394a = 0;

    /* JADX INFO: renamed from: com.bytedance.android.rts.util.a$a, reason: collision with other inner class name */
    public static final class C2497a {
        public static String a(k r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            ArrayList r101 = (ArrayList) r100.getUrls();
            if (r101 == null) goto L8;
            int r102 = j.d(r101);
        L9:
            if (r102 <= 0) goto L14;
            List<String> r103 = r100.getUrls();
            if (r103 != null) goto L13;
            return null;
        L13:
            return (String) ListProtector.get(r103, 0);
        L14:
            return null;
        L8:
            r102 = 0;
            goto L9
        }
    }

    static {
    }
}
