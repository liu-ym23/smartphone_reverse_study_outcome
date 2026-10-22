package com.google.android.material.datepicker;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import com.google.android.material.dialog.InsetDialogOnTouchListener;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialStyledDatePickerDialog extends DatePickerDialog {
    private static final int DEF_STYLE_ATTR = 16843612;
    private static final int DEF_STYLE_RES = 0;
    private final Drawable background;
    private final Rect backgroundInsets;

    static {
        DEF_STYLE_RES = ZeusTransformUtils.mapRes(R.style.MaterialAlertDialog_MaterialComponents_Picker_Date_Spinner, "style", "MaterialAlertDialog_MaterialComponents_Picker_Date_Spinner");
    }

    public MaterialStyledDatePickerDialog(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), 0);
    }

    public MaterialStyledDatePickerDialog(Context r8, int r9) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin"), r9, null, -1, -1, -1);
    }

    public MaterialStyledDatePickerDialog(Context r10, DatePickerDialog.OnDateSetListener r11, int r12, int r13, int r14) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin"), 0, (DatePickerDialog.OnDateSetListener) ZeusTransformUtils.wrapperContextForParams(r11, DatePickerDialog.OnDateSetListener.class, "com.obric.aiagent.plugin"), r12, r13, r14);
    }

    public MaterialStyledDatePickerDialog(Context r10, int r11, DatePickerDialog.OnDateSetListener r12, int r13, int r14, int r15) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin"), r11, (DatePickerDialog.OnDateSetListener) ZeusTransformUtils.wrapperContextForParams(r12, DatePickerDialog.OnDateSetListener.class, "com.obric.aiagent.plugin"), r13, r14, r15);
        Context r16 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        int r17 = com.google.android.material.g.b.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.attr.colorSurface, "attr", "colorSurface"), getClass().getCanonicalName());
        int r18 = DEF_STYLE_RES;
        MaterialShapeDrawable r19 = new MaterialShapeDrawable(r16, null, 16843612, r18);
        if (Build.VERSION.SDK_INT < 21) goto L5;
        r19.setFillColor(ColorStateList.valueOf(r17));
    L6:
        Rect r110 = com.google.android.material.dialog.a.a(r16, 16843612, r18);
        this.backgroundInsets = r110;
        this.background = com.google.android.material.dialog.a.a(r19, r110);
        return;
    L5:
        r19.setFillColor(ColorStateList.valueOf(0));
        goto L6
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle r3) {
        super.onCreate(r3);
        getWindow().setBackgroundDrawable(this.background);
        getWindow().getDecorView().setOnTouchListener(new InsetDialogOnTouchListener(this, this.backgroundInsets));
    }
}
