package com.bytedance.android.livesdk.chatroom.indicator.shortterm.framework;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdkapi.sti.framework.AbsIconModel;
import com.bytedance.live.datacontext.DataContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public abstract class a<STATE> extends AbsIconModel<STATE> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f106631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f106632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final STATE f106633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f106634d;

    public final DataContext a() {
        ViewModel r100 = getProxy().getDataContext();
        if (r100 == null) goto L7;
        return (DataContext) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.live.datacontext.DataContext");
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.AbsIconModel, com.bytedance.android.livesdkapi.sti.framework.IIconService
    public final /* bridge */ /* synthetic */ ViewModel getDataContext() {
        return a();
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.AbsIconModel, com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public int getIconHeight() {
        return this.f106632b;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.AbsIconModel, com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public int getIconWidth() {
        return this.f106631a;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.AbsIconModel, com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public final STATE getInitialState() {
        return this.f106633c;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.AbsIconModel, com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public final int getTypeId() {
        return this.f106634d;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.AbsIconModel, com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public void setIconHeight(int r100) {
        this.f106632b = r100;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.AbsIconModel, com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public void setIconWidth(int r100) {
        this.f106631a = r100;
    }

    public a(STATE r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "initialState");
        super(r100, r101);
        this.f106633c = r100;
        this.f106634d = r101;
        this.f106631a = UtilityKotlinExtentionsKt.i(36);
        this.f106632b = UtilityKotlinExtentionsKt.i(36);
    }
}
