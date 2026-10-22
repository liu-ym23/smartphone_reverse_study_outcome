package com.zyql.ai.selector;

import android.content.Context;
import android.content.ContextWrapper;
import com.zyql.ai.selector.language.PictureLanguageUtils;

/* loaded from: classes4.dex */
public class PictureContextWrapper extends ContextWrapper {
    public PictureContextWrapper(Context context) {
        super(context);
    }

    public static ContextWrapper wrap(Context context, int i10) {
        PictureLanguageUtils.setAppLanguage(context, i10);
        return new PictureContextWrapper(context);
    }
}
