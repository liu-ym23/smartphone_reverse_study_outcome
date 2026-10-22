package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.view.View;

/* loaded from: classes.dex */
public class a {
    public static String a(Context context, int i5) {
        if (i5 == -1) {
            return "UNKNOWN";
        }
        try {
            return context.getResources().getResourceEntryName(i5);
        } catch (Exception unused) {
            return "?" + i5;
        }
    }

    public static String b(View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return "UNKNOWN";
        }
    }
}
