package com.obric.oui.checkbox;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedanceos.common.ui.CommonConfirmDialog;
import com.obric.common.oui.R$drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tB!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0016\u0010\u000fR\u001e\u0010\u001a\u001a\n \u0018*\u0004\u0018\u00010\u00170\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0019R\u0016\u0010\u0014\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/obric/oui/checkbox/OCheckMark;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/widget/Checkable;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "a", "()V", "", CommonConfirmDialog.ARGS_CHECKED, "setChecked", "(Z)V", "isChecked", "()Z", "toggle", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "Landroid/graphics/drawable/Drawable;", "markDrawable", "b", "Z", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OCheckMark extends AppCompatImageView implements Checkable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f12772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f12773b;

    public OCheckMark(@NotNull Context r10) {
        q.g(r10, "context");
        super(r10);
        this.f12772a = getResources().getDrawable(R$drawable.o_card_list_item_tail_icon_mark);
        this.f12773b = true;
        a();
    }

    private final void a() {
        setMinimumWidth(this.f12772a.getMinimumWidth());
        setMinimumHeight(this.f12772a.getMinimumHeight());
        setBackgroundDrawable(this.f12772a);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f12773b;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r10) {
        if (this.f12773b != r10) goto L5;
        return;
    L5:
        this.f12773b = r10;
        if (r10 == false) goto L8;
        Drawable r11 = this.f12772a;
    L9:
        setBackgroundDrawable(r11);
        invalidate();
        return;
    L8:
        r11 = null;
        goto L9
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f12773b);
    }

    public OCheckMark(@NotNull Context r10, @NotNull AttributeSet r11) {
        q.g(r10, "context");
        q.g(r11, "attrs");
        super(r10, r11);
        this.f12772a = getResources().getDrawable(R$drawable.o_card_list_item_tail_icon_mark);
        this.f12773b = true;
        a();
    }

    public OCheckMark(@NotNull Context r10, @NotNull AttributeSet r11, int r12) {
        q.g(r10, "context");
        q.g(r11, "attrs");
        super(r10, r11, r12);
        this.f12772a = getResources().getDrawable(R$drawable.o_card_list_item_tail_icon_mark);
        this.f12773b = true;
        a();
    }
}
