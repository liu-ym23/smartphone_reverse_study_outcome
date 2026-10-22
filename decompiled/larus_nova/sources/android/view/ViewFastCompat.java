package android.view;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class ViewFastCompat extends View {
    public ViewFastCompat(Context r100) {
        super(r100);
    }

    public static void finishInflate(View r100) {
        r100.onFinishInflate();
    }
}
