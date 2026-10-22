package com.bytedance.android.livesdk.chatroom.indicator.shortterm;

import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdkapi.sti.framework.IIconModel;
import com.bytedance.android.livesdkapi.sti.framework.IIconService;
import com.bytedance.android.livesdkapi.sti.framework.IconTemplate;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import kotlin.Unit;

/* JADX INFO: loaded from: classes7.dex */
public final class b extends com.bytedance.android.livesdk.chatroom.indicator.shortterm.framework.a<Boolean> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TiltedTempIconTemplate f106552e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f106553f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f106554g;

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public final IIconModel.EntryView getBigCardEntryViewForState() {
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public final void onClick() {
        f2.c("Mock!", 0);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.AbsIconModel
    public final void onCreate() {
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.AbsIconModel, com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public final void onHideTempState() {
        super.onHideTempState();
        TiltedTempIconTemplate r100 = this.f106552e;
        if (r100 == null) goto L6;
        r100.removeTempView();
        return;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public final IconTemplate getViewForState(Object r100) {
        AttributeSet r101 = null;
        if (((Boolean) r100).booleanValue() == false) goto L6;
        TiltedTempIconTemplate r102 = new TiltedTempIconTemplate(getContext(), r101, 6, 0);
        TextView r103 = new TextView(getContext());
        r103.setLayoutParams(new FrameLayout.LayoutParams(UtilityKotlinExtentionsKt.i(26), UtilityKotlinExtentionsKt.i(36)));
        r103.setText("P" + this.f106554g);
        r103.setBackground(new ColorDrawable(FakePickerAvatarCreator.BLUE));
        r103.setTextColor(-1);
        r103.setOnClickListener(new a(this));
        Unit r104 = Unit.INSTANCE;
        r102.setContentView(r103);
        r102.setContentRightMargin(UtilityKotlinExtentionsKt.i(8));
        r102.setContentTopMargin(UtilityKotlinExtentionsKt.i(5));
        this.f106552e = r102;
        return r102;
    L6:
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.AbsIconModel, com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public final void onShowTempState(int r100) {
        super.onShowTempState(r100);
        changeTempWidth();
        TiltedTempIconTemplate r101 = this.f106552e;
        if (r101 == null) goto L6;
        TextView r102 = new TextView(getContext());
        r102.setText("P" + this.f106554g);
        r102.setBackground(new ColorDrawable(-65536));
        r102.setTextColor(-1);
        Unit r103 = Unit.INSTANCE;
        r101.setTempShortTermView(r102);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public final IIconModel.EntryView getEntryViewForState(Object r100, Object r101) {
        Boolean r102 = (Boolean) r101;
        if (((Boolean) r100).booleanValue() == false) goto L5;
        TextView r103 = new TextView(getContext());
        r103.setLayoutParams(new FrameLayout.LayoutParams(UtilityKotlinExtentionsKt.i(80), UtilityKotlinExtentionsKt.i(96)));
        r103.setText("P" + this.f106554g);
        r103.setTextSize(UtilityKotlinExtentionsKt.h((float) 16));
        r103.setBackground(new ColorDrawable(FakePickerAvatarCreator.BLUE));
        r103.setTextColor(-1);
        return new IIconModel.EntryView(r103, 0, false, 6, null);
    L5:
        return null;
    }

    public b(int r100, long r101, int r102) {
        super(Boolean.TRUE, r100);
        this.f106553f = r101;
        this.f106554g = r102;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public final void applyState(Object r110, Object r111, IconTemplate r112) {
        Boolean r113 = (Boolean) r110;
        if (((Boolean) r111).booleanValue() == false) goto L5;
        IIconService.DefaultImpls.startCountDown$default(this, this.f106553f * ((long) 1000), Boolean.FALSE, null, null, 12, null);
        return;
    L5:
        requestDispose();
    }
}
