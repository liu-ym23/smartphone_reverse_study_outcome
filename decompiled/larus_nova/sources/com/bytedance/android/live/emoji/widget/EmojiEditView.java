package com.bytedance.android.live.emoji.widget;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.live.core.widget.GradientEditText;
import com.bytedance.bpea.entry.common.DataType;
import f06.b;
import f06.c;
import f06.d;
import jc1.a;

/* JADX INFO: loaded from: classes45.dex */
public class EmojiEditView extends GradientEditText {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f68964c;

    public EmojiEditView(Context r100) {
        super(r100);
        this.f68964c = LiveResUtil.dp2Px(16.0f);
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.EditText, android.widget.TextView
    public final boolean onTextContextMenuItem(int r110) {
        if (r110 != 16908322) goto L16;
        ClipboardManager r100 = (ClipboardManager) a.b().getSystemService(DataType.CLIPBOARD);
        c r111 = new c();
        Object[] r112 = new Object[0];
        b r113 = new b();
        d r114 = r111.b(101803, "android/content/ClipboardManager", "getPrimaryClip", r100, r112, "android.content.ClipData", r113);
        if (r114.f474982a == false) goto L7;
        r111.a(101803, "android/content/ClipboardManager", "getPrimaryClip", r100, r112, null, r113, false);
        ClipData r101 = (ClipData) r114.f474983b;
    L8:
        if (r101 == null) goto L16;
        if (r101.getItemAt(0) == null) goto L16;
        if (r101.getItemAt(0).getText() == null) goto L16;
        String r102 = r101.getItemAt(0).getText().toString();
        getText().insert(getSelectionStart(), r90.a.a().c(r102, this.f68964c, false));
        return true;
    L7:
        ClipData r115 = r100.getPrimaryClip();
        r111.a(101803, "android/content/ClipboardManager", "getPrimaryClip", r100, r112, r115, r113, true);
        r101 = r115;
    L16:
        return super.onTextContextMenuItem(r110);
    }

    public void setTextEmojiSize(int r100) {
        this.f68964c = r100;
    }

    public EmojiEditView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f68964c = LiveResUtil.dp2Px(16.0f);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public final void setText(CharSequence r100, TextView.BufferType r101) {
        super.setText(r90.a.a().c(r100, this.f68964c, false), r101);
    }

    public EmojiEditView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f68964c = LiveResUtil.dp2Px(16.0f);
    }
}
