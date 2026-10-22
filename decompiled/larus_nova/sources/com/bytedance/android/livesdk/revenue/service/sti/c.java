package com.bytedance.android.livesdk.revenue.service.sti;

import com.bytedance.android.livesdk.revenue.sti.IRevIconModel;
import com.bytedance.android.livesdkapi.sti.framework.IIconModel;
import com.bytedance.android.livesdkapi.sti.framework.IIconService;
import com.bytedance.android.livesdkapi.sti.framework.IconTemplate;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import xr2.h;

/* JADX INFO: loaded from: classes11.dex */
public final class c<S> implements IIconModel<S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d<S> f157450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IRevIconModel<S> f157451b;

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public final IIconModel.EntryView getBigCardEntryViewForState() {
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public final String getIconDesc() {
        return "";
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public final int getIconHeight() {
        return this.f157451b.getIconHeight();
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public final int getIconWidth() {
        return this.f157451b.getIconWidth();
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public final S getInitialState() {
        return this.f157451b.getInitialState();
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public final int getTypeId() {
        return this.f157451b.getTypeId();
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public final void onAppear() {
        this.f157451b.onAppear();
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public final void onClick() {
        this.f157451b.onClick();
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public final void onDestroy() {
        this.f157451b.onDestroy();
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public final void onHideTempState() {
        this.f157451b.onHideTempState();
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public final long getDynamicPriorityShortTouch() {
        return IIconModel.DefaultImpls.getDynamicPriorityShortTouch(this);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public final boolean isEnhancedStyleShortTouch() {
        return IIconModel.DefaultImpls.isEnhancedStyleShortTouch(this);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IShortTouchLifeCycle
    public final void onPause() {
        IIconModel.DefaultImpls.onPause(this);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IShortTouchLifeCycle
    public final void onResume() {
        IIconModel.DefaultImpls.onResume(this);
    }

    public c(IRevIconModel<S> r100) {
        Intrinsics.checkNotNullParameter(r100, "original");
        this.f157451b = r100;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public final IconTemplate getViewForState(S r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        h r101 = this.f157451b.getViewForState(r100);
        IconTemplate r102 = null;
        if (r101 == null) goto L14;
        d<S> r103 = this.f157450a;
        if (r103 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("revIconService");
    L7:
        r103.f157452a.getClass();
        Intrinsics.checkNotNullParameter(r101, "wrapper");
        if ((r101 instanceof b) == true) goto L10;
        r101 = null;
    L10:
        b r104 = (b) r101;
        if (r104 == null) goto L13;
        r102 = r104.getOriginal();
    L13:
        Intrinsics.checkNotNull(r102);
    L14:
        return r102;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public final void onCreate(IIconService<S> r100) {
        Intrinsics.checkNotNullParameter(r100, "service");
        d<S> r101 = new d(r100);
        this.f157450a = r101;
        this.f157451b.d(r101);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public final void onShowTempState(int r100) {
        this.f157451b.onShowTempState(r100);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public final void setIconHeight(int r100) {
        this.f157451b.setIconHeight(r100);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public final void setIconWidth(int r100) {
        this.f157451b.setIconWidth(r100);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public final IIconModel.EntryView getEntryViewForState(S r100, S r101) {
        Intrinsics.checkNotNullParameter(r100, "state");
        IRevIconModel.a r102 = this.f157451b.getEntryViewForState(r100, r101);
        if (r102 == null) goto L5;
        Intrinsics.checkNotNullParameter(r102, "$this$toLiveType");
        return new IIconModel.EntryView(r102.f157513a, r102.f157514b, r102.f157515c);
    L5:
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public final void onEntryEvent(IIconModel.EntryView r100, IIconModel.EntryEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "entryView");
        Intrinsics.checkNotNullParameter(r101, "event");
        IRevIconModel<S> r102 = this.f157451b;
        Intrinsics.checkNotNullParameter(r100, "$this$toRevType");
        IRevIconModel.a r103 = new IRevIconModel.a(r100.getView(), r100.getDisplayDuration(), r100.getClipToBounds());
        Intrinsics.checkNotNullParameter(r101, "$this$toRevType");
        int r104 = f.f157455a[r101.ordinal()];
        if (r104 != 1) goto L5;
        IRevIconModel.EntryEvent r105 = IRevIconModel.EntryEvent.Start;
    L13:
        r102.a(r103, r105);
        return;
    L5:
        if (r104 != 2) goto L7;
        r105 = IRevIconModel.EntryEvent.End;
        goto L13
    L7:
        if (r104 != 3) goto L10;
        r105 = IRevIconModel.EntryEvent.Skip;
        goto L13
    L10:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public final void applyState(S r100, S r101, IconTemplate r102) {
        Intrinsics.checkNotNullParameter(r101, "curState");
        IRevIconModel<S> r103 = this.f157451b;
        if (r102 == null) goto L8;
        d<S> r104 = this.f157450a;
        if (r104 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("revIconService");
    L7:
        h r105 = r104.f157452a.a(r102);
    L9:
        r103.c(r100, r101, r105);
        return;
    L8:
        r105 = null;
        goto L9
    }
}
