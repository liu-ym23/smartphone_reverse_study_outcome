package com.android.ttcjpaysdk.thirdparty.view;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPayBPEAService;
import com.android.ttcjpaysdk.base.theme.CJPayThemeManager;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.bpea.entry.common.DataType;
import com.larus.nova.R;
import f06.b;
import f06.c;
import f06.d;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayPasteAwareEditText extends AppCompatEditText {
    private Context mContext;
    private OnPasteListener mOnPasteListener;
    private OnUserClickBack onUserClickBack;
    private GradientDrawable shapeDrawable;

    public interface OnPasteListener {
        void onPaste(String r100);
    }

    public interface OnUserClickBack {
        void onBack();
    }

    public void changeCursorColor() {
        String r100 = CJPayThemeManager.getInstance().getThemeInfo().cursorInfo.cursorColor;     // Catch: Exception -> L8
        if (TextUtils.isEmpty(r100) == true) goto L13;
        GradientDrawable r101 = (GradientDrawable) ContextCompat.getDrawable(this.mContext, R.drawable.cj_pay_bg_universal_cursor);     // Catch: Exception -> L8
        this.shapeDrawable = r101;     // Catch: Exception -> L8
        if (r101 == null) goto L14;
        r101.setColor(Color.parseColor(r100));     // Catch: Exception -> L8
        return;
    L14:
        return;
    L13:
        return;
    L8:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayPasteAwareEditText#changeCursorColor", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayPasteAwareEditText#changeCursorColor", e);
    }

    public CJPayPasteAwareEditText(Context r100) {
        super(r100);
        this.mContext = r100;
    }

    private static ClipData com_android_ttcjpaysdk_thirdparty_view_CJPayPasteAwareEditText_android_content_ClipboardManager_getPrimaryClip(ClipboardManager r110) {
        c r100 = new c();
        Object[] r101 = new Object[0];
        b r111 = new b();
        d r112 = r100.b(101803, "android/content/ClipboardManager", "getPrimaryClip", r110, r101, "android.content.ClipData", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(101803, "android/content/ClipboardManager", "getPrimaryClip", r110, r101, null, r111, false);
        return (ClipData) r112.f474983b;
    L6:
        ClipData r113 = r110.getPrimaryClip();
        r100.a(101803, "android/content/ClipboardManager", "getPrimaryClip", r110, r101, r113, r111, true);
        return r113;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int r100) {
        if (r100 != 16908322) goto L29;
        ClipboardManager r101 = (ClipboardManager) getContext().getSystemService(DataType.CLIPBOARD);
        if (r101 == null) goto L7;
        ICJPayBPEAService r102 = (ICJPayBPEAService) CJPayServiceManager.getInstance().getIService(ICJPayBPEAService.class);
        if (r102 == null) goto L11;
        ClipData r103 = r102.getPrimaryClip(r101);
    L12:
        if (r103 == null) goto L14;
        String r104 = null;
        if (r103.getItemCount() <= 0) goto L18;
        ClipData.Item r105 = r103.getItemAt(0);
    L19:
        if (r105 != null) goto L21;
    L23:
        OnPasteListener r106 = this.mOnPasteListener;
        if (r106 == null) goto L29;
        if (r104 == null) goto L29;
        r106.onPaste(r104);
        return false;
    L21:
        if (r105.getText() == null) goto L23;
        r104 = r105.getText().toString();
        goto L23
    L18:
        r105 = null;
        goto L19
    L14:
        return super.onTextContextMenuItem(r100);
    L11:
        r103 = com_android_ttcjpaysdk_thirdparty_view_CJPayPasteAwareEditText_android_content_ClipboardManager_getPrimaryClip(r101);
        goto L12
    L7:
        return super.onTextContextMenuItem(r100);
    L29:
        return super.onTextContextMenuItem(r100);
    }

    public void setOnPasteListener(OnPasteListener r100) {
        this.mOnPasteListener = r100;
    }

    public void setOnUserClickBack(OnUserClickBack r100) {
        this.onUserClickBack = r100;
    }

    public CJPayPasteAwareEditText(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.mContext = r100;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int r100, KeyEvent r101) {
        if (r100 != 4) goto L9;
        OnUserClickBack r102 = this.onUserClickBack;
        if (r102 == null) goto L9;
        r102.onBack();
        return true;
    L9:
        return super.onKeyPreIme(r100, r101);
    }

    public CJPayPasteAwareEditText(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.mContext = r100;
    }
}
