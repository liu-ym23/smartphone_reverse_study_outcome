package com.bytedanceos.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.apm.constant.CommonKey;
import com.bytedanceos.common.ui.CommonConfirmDialog;
import com.bytedanceos.oui.resource.R$color;
import com.bytedanceos.oui.resource.R$layout;
import com.obric.oui.chip.v2.OChip;
import i9.c;
import i9.d;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001:\u00014B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0013¢\u0006\u0004\b\u0018\u0010\u0016J\u0019\u0010\u001b\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR$\u0010'\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010.\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R*\u00103\u001a\u00020(2\u0006\u0010/\u001a\u00020(8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010)\u001a\u0004\b1\u0010+\"\u0004\b2\u0010-¨\u00065"}, d2 = {"Lcom/bytedanceos/ui/OUIChip;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "c", "", "setText", "(Ljava/lang/CharSequence;)V", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "Lcom/obric/oui/chip/v2/OChip;", "getTextView", "()Lcom/obric/oui/chip/v2/OChip;", "", "color", "setBackgroundColor", "(I)V", "tintColor", "setTint", "Landroid/view/View$OnClickListener;", "l", "setOnClickListener", "(Landroid/view/View$OnClickListener;)V", "a", "Lcom/obric/oui/chip/v2/OChip;", "chip", "Lcom/bytedanceos/ui/OUIChip$OnCheckedListener;", "b", "Lcom/bytedanceos/ui/OUIChip$OnCheckedListener;", "getOnCheckedListener", "()Lcom/bytedanceos/ui/OUIChip$OnCheckedListener;", "setOnCheckedListener", "(Lcom/bytedanceos/ui/OUIChip$OnCheckedListener;)V", "onCheckedListener", "", "Z", "getEnableChecked", "()Z", "setEnableChecked", "(Z)V", "enableChecked", CommonKey.KEY_VALUE, "d", "getChecked", "setChecked", CommonConfirmDialog.ARGS_CHECKED, "OnCheckedListener", "resource_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class OUIChip extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OChip f10230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OnCheckedListener f10231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f10233d;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedanceos/ui/OUIChip$OnCheckedListener;", "", "onChecked", "", "chip", "Lcom/bytedanceos/ui/OUIChip;", "resource_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnCheckedListener {
        void onChecked(@NotNull OUIChip r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OUIChip(@NotNull Context r10) {
        q.g(r10, "context");
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void a(OUIChip r10, View.OnClickListener r11, View r12) {
        d(r10, r11, r12);
    }

    public static /* synthetic */ void b(OUIChip r10, View r11) {
        c(r10, r11);
    }

    public static final void c(OUIChip r10, View r11) {
        q.g(r10, "this$0");
        if (r10.f10232c == false) goto L10;
        r10.setChecked(!r10.f10233d);
        if (r10.f10233d == false) goto L11;
        OnCheckedListener r12 = r10.f10231b;
        if (r12 == null) goto L12;
        r12.onChecked(r10);
        return;
    L12:
        return;
    L11:
        return;
    }

    public static final void d(OUIChip r10, View.OnClickListener r11, View r12) {
        q.g(r10, "this$0");
        if (r10.f10232c == false) goto L9;
        r10.setChecked(!r10.f10233d);
        if (r10.f10233d == false) goto L9;
        OnCheckedListener r13 = r10.f10231b;
        if (r13 == null) goto L9;
        r13.onChecked(r10);
    L9:
        if (r11 == null) goto L12;
        r11.onClick(r10);
        return;
    }

    public final boolean getChecked() {
        return this.f10233d;
    }

    public final boolean getEnableChecked() {
        return this.f10232c;
    }

    @NotNull
    public final ImageView getIcon() {
        return this.f10230a.getChipIcon();
    }

    @Nullable
    public final OnCheckedListener getOnCheckedListener() {
        return this.f10231b;
    }

    @NotNull
    public final OChip getTextView() {
        return this.f10230a;
    }

    @Override // android.view.View
    public void setBackgroundColor(int r10) {
        this.f10230a.setBackgroundColor(r10);
    }

    public final void setChecked(boolean r10) {
        if (r10 == false) goto L4;
        this.f10230a.setOn(r10);
    L5:
        this.f10233d = r10;
        return;
    L4:
        this.f10230a.setOn(r10);
        goto L5
    }

    public final void setEnableChecked(boolean r10) {
        this.f10232c = r10;
    }

    public final void setOnCheckedListener(@Nullable OnCheckedListener r10) {
        this.f10231b = r10;
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable final View.OnClickListener r10) {
        this.f10230a.setOnClickListener(new c(this, r10));
    }

    public final void setText(@Nullable CharSequence r10) {
        OChip r11 = this.f10230a;
        if (r10 != null) goto L5;
        r10 = "";
    L5:
        r11.setText(r10);
    }

    public final void setTint(int r10) {
        this.f10230a.getBackground().setTint(r10);
    }

    public /* synthetic */ OUIChip(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    @JvmOverloads
    public OUIChip(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        View r12 = LayoutInflater.from(r10).inflate(R$layout.category_top_item, this, false);
        q.e(r12, "null cannot be cast to non-null type com.obric.oui.chip.v2.OChip");
        OChip r13 = (OChip) r12;
        this.f10230a = r13;
        this.f10232c = true;
        addView(r13);
        r13.setBackgroundColor(r10.getColor(R$color.bg_oui_chip));
        r13.setOnClickListener(new d(this));
    }
}
