package com.obric.oui.lisitem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.oswitch.OSwitch;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OListItemSwitch.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\bJ\b\u0010\f\u001a\u00020\rH\u0016J\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u000fJ\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u0010\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/lisitem/OListItemSwitch;", "Lcom/obric/oui/lisitem/OListItemSettings;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mOSwitch", "Lcom/obric/oui/oswitch/OSwitch;", "mOnCheckedChangeListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "getSwitch", "inflateContent", "", "isChecked", "", "isPressable", "setChecked", MaterialConfigFormatNames.CHECKED, "setEnabled", "enabled", "setOnCheckedChangeListener", "listener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OListItemSwitch extends OListItemSettings {
    private final OSwitch mOSwitch;
    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener;

    /* JADX INFO: renamed from: $r8$lambda$bqL3dzCrCn2gUP7MWkmLH-lprVg, reason: not valid java name */
    public static /* synthetic */ void m553$r8$lambda$bqL3dzCrCn2gUP7MWkmLHlprVg(OListItemSwitch r0, CompoundButton r1, boolean r2) {
        m554lambda1$lambda0(r0, r1, r2);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout
    public boolean isPressable() {
        return false;
    }

    public /* synthetic */ OListItemSwitch(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public OListItemSwitch(Context r7, AttributeSet r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8);
        setClickable(false);
        OSwitch r9 = new OSwitch(r7, null, 0, 6, null);
        r9.setClickable(true);
        r9.setOnCheckedChangeListener(new OListItemSwitch$$ExternalSyntheticLambda0(this));
        this.mOSwitch = r9;
        FrameLayout.LayoutParams r10 = new FrameLayout.LayoutParams(-2, -2);
        r10.gravity = 17;
        OListItemSwitch r0 = this;
        r10.leftMargin = OUnitExtensionKt.vdp(r0, 4);
        r10.rightMargin = OUnitExtensionKt.vdp(r0, 4);
        setTrailingView(r9, r10);
    }

    /* JADX INFO: renamed from: lambda-1$lambda-0, reason: not valid java name */
    private static final void m554lambda1$lambda0(OListItemSwitch r1, CompoundButton r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        CompoundButton.OnCheckedChangeListener r4 = r1.mOnCheckedChangeListener;
        if (r4 == null) goto L7;
        r4.onCheckedChanged(r2, r3);
        return;
    }

    @Override // com.obric.oui.lisitem.OListItemSettings, com.obric.oui.lisitem.OListItemGeneral
    public void inflateContent() {
        LayoutInflater.from(getContext()).inflate(R.layout.o_listitem_switch, this);
    }

    public final void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener r1) {
        this.mOnCheckedChangeListener = r1;
    }

    public final void setChecked(boolean r1) {
        this.mOSwitch.setChecked(r1);
    }

    public final boolean isChecked() {
        return this.mOSwitch.isChecked();
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral, com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        this.mOSwitch.setAlpha(1.0f);
    }

    public final OSwitch getSwitch() {
        return this.mOSwitch;
    }
}
