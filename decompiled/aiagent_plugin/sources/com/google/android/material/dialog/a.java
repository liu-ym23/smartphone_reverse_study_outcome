package com.google.android.material.dialog;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import com.google.android.material.internal.l;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MaterialDialogs.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static InsetDrawable a(Drawable r7, Rect r8) {
        return new InsetDrawable(r7, r8.left, r8.top, r8.right, r8.bottom);
    }

    public static Rect a(Context r9, int r10, int r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        TypedArray r13 = l.a(r12, null, R.styleable.MaterialAlertDialog, r10, r11, new int[0]);
        int r14 = r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.MaterialAlertDialog_backgroundInsetStart, "styleable", "MaterialAlertDialog_backgroundInsetStart"), ZeusTransformUtils.getResources(r12, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.mtrl_alert_dialog_background_inset_start, "dimen", "mtrl_alert_dialog_background_inset_start")));
        int r2 = r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.MaterialAlertDialog_backgroundInsetTop, "styleable", "MaterialAlertDialog_backgroundInsetTop"), ZeusTransformUtils.getResources(r12, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.mtrl_alert_dialog_background_inset_top, "dimen", "mtrl_alert_dialog_background_inset_top")));
        int r3 = r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.MaterialAlertDialog_backgroundInsetEnd, "styleable", "MaterialAlertDialog_backgroundInsetEnd"), ZeusTransformUtils.getResources(r12, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.mtrl_alert_dialog_background_inset_end, "dimen", "mtrl_alert_dialog_background_inset_end")));
        int r0 = r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.MaterialAlertDialog_backgroundInsetBottom, "styleable", "MaterialAlertDialog_backgroundInsetBottom"), ZeusTransformUtils.getResources(r12, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.mtrl_alert_dialog_background_inset_bottom, "dimen", "mtrl_alert_dialog_background_inset_bottom")));
        r13.recycle();
        if (Build.VERSION.SDK_INT < 17) goto L8;
        if (ZeusTransformUtils.getResources(r12, "com.obric.aiagent.plugin").getConfiguration().getLayoutDirection() != 1) goto L8;
        r3 = r14;
        r14 = r3;
    L8:
        return new Rect(r14, r2, r3, r0);
    }
}
