package com.zyql.ai.selector.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import com.zyql.ai.selector.R;

/* loaded from: classes4.dex */
public class PictureCustomDialog extends Dialog {
    public PictureCustomDialog(Context context, int i10) {
        super(context, R.style.Picture_Theme_Dialog);
        setContentView(i10);
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -2;
            attributes.height = -2;
            attributes.gravity = 17;
            window.setAttributes(attributes);
        }
    }
}
