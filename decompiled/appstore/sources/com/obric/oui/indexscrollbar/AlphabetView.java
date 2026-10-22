package com.obric.oui.indexscrollbar;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.TextView;
import com.obric.common.oui.R$dimen;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B)\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/oui/indexscrollbar/AlphabetView;", "Landroid/widget/TextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "a", "()V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AlphabetView extends TextView {
    @JvmOverloads
    public AlphabetView(@Nullable Context r10) {
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public final void a() {
        setGravity(17);
        setTextSize(0, getResources().getDimension(R$dimen.bytedance_quickbarex_gridview_font_size));
        setTypeface(null, 1);
        setTextColor(Color.parseColor("#80000000"));
    }

    @JvmOverloads
    public AlphabetView(@Nullable Context r10, @Nullable AttributeSet r11) {
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ AlphabetView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public AlphabetView(@Nullable Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        a();
    }
}
