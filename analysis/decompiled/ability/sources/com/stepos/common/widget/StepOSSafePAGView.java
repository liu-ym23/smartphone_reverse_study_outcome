package com.stepos.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import org.libpag.PAGView;

/* loaded from: classes3.dex */
public class StepOSSafePAGView extends PAGView {
    public StepOSSafePAGView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // org.libpag.PAGView
    public final boolean flush() {
        try {
            return super.flush();
        } catch (Exception e) {
            Log.w("StepOSSafePAGView", "flush has an error:" + e);
            return false;
        }
    }
}
