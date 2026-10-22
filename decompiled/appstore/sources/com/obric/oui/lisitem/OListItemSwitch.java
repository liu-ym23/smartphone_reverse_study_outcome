package com.obric.oui.lisitem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import com.bytedanceos.common.ui.CommonConfirmDialog;
import com.obric.common.oui.R$layout;
import com.obric.oui.oswitch.OSwitch;
import com.tmall.wireless.tangram.structure.card.FixCard;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0016\u0010\u0012J\r\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/obric/oui/lisitem/OListItemSwitch;", "Lcom/obric/oui/lisitem/OListItemSettings;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "b", "()V", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "listener", "setOnCheckedChangeListener", "(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V", "", CommonConfirmDialog.ARGS_CHECKED, "setChecked", "(Z)V", "isPressable", "()Z", "enabled", "setEnabled", "Lcom/obric/oui/oswitch/OSwitch;", "getSwitch", "()Lcom/obric/oui/oswitch/OSwitch;", "w", "Lcom/obric/oui/oswitch/OSwitch;", "mOSwitch", FixCard.FixStyle.KEY_X, "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "mOnCheckedChangeListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OListItemSwitch extends OListItemSettings {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final OSwitch f15176w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f15177x;

    public OListItemSwitch(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        setClickable(false);
        OSwitch r12 = new OSwitch(r10, null, 0, 6, null);
        r12.setClickable(true);
        r12.setOnCheckedChangeListener(new d(this));
        this.f15176w = r12;
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(-2, -2);
        r13.gravity = 17;
        r13.leftMargin = f.r(this, 4);
        r13.rightMargin = f.r(this, 4);
        f(r12, r13);
    }

    public static /* synthetic */ void h(OListItemSwitch r10, CompoundButton r11, boolean r12) {
        i(r10, r11, r12);
    }

    public static final void i(OListItemSwitch r10, CompoundButton r11, boolean r12) {
        q.g(r10, "this$0");
        CompoundButton.OnCheckedChangeListener r13 = r10.f15177x;
        if (r13 == null) goto L7;
        r13.onCheckedChanged(r11, r12);
        return;
    }

    @Override // com.obric.oui.lisitem.OListItemSettings, com.obric.oui.lisitem.OListItemGeneral
    public void b() {
        LayoutInflater.from(getContext()).inflate(R$layout.o_listitem_switch, this);
    }

    @NotNull
    public final OSwitch getSwitch() {
        return this.f15176w;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout
    public boolean isPressable() {
        return false;
    }

    public final void setChecked(boolean r10) {
        this.f15176w.setChecked(r10);
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral, com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        this.f15176w.setAlpha(1.0f);
    }

    public final void setOnCheckedChangeListener(@Nullable CompoundButton.OnCheckedChangeListener r10) {
        this.f15177x = r10;
    }
}
