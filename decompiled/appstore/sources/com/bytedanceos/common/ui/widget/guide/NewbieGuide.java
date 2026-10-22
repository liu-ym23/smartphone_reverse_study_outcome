package com.bytedanceos.common.ui.widget.guide;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import com.bytedanceos.common.toolbox.b0;
import com.bytedanceos.common.ui.widget.guide.core.Builder;

/* JADX INFO: loaded from: classes2.dex */
public class NewbieGuide {
    public static final int FAILED = -1;
    public static final int SUCCESS = 1;
    public static final String TAG = "NewbieGuide";

    public NewbieGuide() {
    }

    public static void resetLabel(Context r10, String r11) {
        b0.n().E(r11, 0, TAG, r10);
    }

    public static Builder with(Activity r10) {
        return new Builder(r10);
    }

    public static Builder with(Fragment r10) {
        return new Builder(r10);
    }

    public static Builder with(androidx.fragment.app.Fragment r10) {
        return new Builder(r10);
    }
}
