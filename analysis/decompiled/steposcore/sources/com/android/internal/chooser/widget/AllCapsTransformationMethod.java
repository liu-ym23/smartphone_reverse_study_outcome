package com.android.internal.chooser.widget;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import java.util.Locale;

/* compiled from: Switch.java */
/* loaded from: classes.dex */
class AllCapsTransformationMethod implements TransformationMethod2 {
    private static final String TAG = "AllCapsTransformationMethod";
    private boolean mEnabled;
    private Locale mLocale;

    public AllCapsTransformationMethod(Context context) {
        this.mLocale = context.getResources().getConfiguration().locale;
    }

    @Override // android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence source, View view) {
        if (this.mEnabled) {
            if (source != null) {
                return source.toString().toUpperCase(this.mLocale);
            }
            return null;
        }
        return source;
    }

    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(View view, CharSequence sourceText, boolean focused, int direction, Rect previouslyFocusedRect) {
    }

    @Override // com.android.internal.chooser.widget.TransformationMethod2
    public void setLengthChangesAllowed(boolean allowLengthChanges) {
        this.mEnabled = allowLengthChanges;
    }
}
