package com.bytedance.bdtracker;

import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class d5 {
    public final ArrayList<String> a = new ArrayList<>();

    public final void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        StringBuilder sbA = a.a(str);
        sbA.append(File.separator);
        sbA.append(str2);
        sbA.append(".dat");
        File file = new File(sbA.toString());
        if (file.exists()) {
            file.delete();
        }
    }
}
