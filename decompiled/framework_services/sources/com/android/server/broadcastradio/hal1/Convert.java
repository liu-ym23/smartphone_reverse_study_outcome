package com.android.server.broadcastradio.hal1;

import com.android.server.utils.Slogf;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class Convert {
    private static final String TAG = "BcRadio1Srv.Convert";

    Convert() {
    }

    static String[][] stringMapToNative(Map<String, String> map) {
        if (map != null) goto L6;
        Slogf.v(TAG, "map is null, returning zero-elements array");
        return (String[][]) Array.newInstance(String.class, new int[]{0, 0});
    L6:
        Set<Map.Entry<String, String>> entries = map.entrySet();
        int len = entries.size();
        String[][] arr = (String[][]) Array.newInstance(String.class, new int[]{len, 2});
        int i = 0;
        Iterator<Map.Entry<String, String>> r7 = entries.iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        Map.Entry<String, String> entry = r7.next();
        arr[i][0] = entry.getKey();
        arr[i][1] = entry.getValue();
        i = i + 1;
        goto L8
    L10:
        Slogf.v(TAG, "converted " + i + " element(s)");
        return arr;
    }
}
