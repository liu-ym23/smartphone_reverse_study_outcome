package com.obric.oui.lisitem;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import com.bytedanceos.common.ui.CommonConfirmDialog;
import com.obric.oui.oswitch.OSwitch;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/lisitem/OListItemCircleImgSwitch;", "Lcom/obric/oui/lisitem/OListItemCircleImg;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "listener", "", "setOnCheckedChangeListener", "(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V", "", CommonConfirmDialog.ARGS_CHECKED, "setChecked", "(Z)V", "Lcom/obric/oui/oswitch/OSwitch;", "v", "Lcom/obric/oui/oswitch/OSwitch;", "mOSwitch", "w", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "mOnCheckedChangeListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OListItemCircleImgSwitch extends OListItemCircleImg {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final OSwitch f15143v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f15144w;

    public OListItemCircleImgSwitch(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        OSwitch r12 = new OSwitch(r10, null, 0, 6, null);
        r12.setClickable(true);
        r12.setOnCheckedChangeListener(new c(this));
        this.f15143v = r12;
        setTrailingView(r12);
    }

    public static /* synthetic */ void h(OListItemCircleImgSwitch r10, CompoundButton r11, boolean r12) {
        i(r10, r11, r12);
    }

    public static final void i(OListItemCircleImgSwitch r10, CompoundButton r11, boolean r12) {
        q.g(r10, "this$0");
        CompoundButton.OnCheckedChangeListener r13 = r10.f15144w;
        if (r13 == null) goto L7;
        r13.onCheckedChanged(r11, r12);
        return;
    }

    public final void setChecked(boolean r10) {
        this.f15143v.setChecked(r10);
    }

    public final void setOnCheckedChangeListener(@Nullable CompoundButton.OnCheckedChangeListener r10) {
        this.f15144w = r10;
    }
}
