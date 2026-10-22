package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.texturerender.VideoSurfaceTexture;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\n\u001a\u00020\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tRT\u0010\u0019\u001a4\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/FirstDrawWatcherFrameLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/ktv/common/util/c;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "setTypeName", "(Ljava/lang/String;)V", "typeName", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isTimeOut", "", VideoSurfaceTexture.KEY_TIME, "", "b", "Lkotlin/jvm/functions/Function2;", "getOneDrawCallback", "()Lkotlin/jvm/functions/Function2;", "setOneDrawCallback", "(Lkotlin/jvm/functions/Function2;)V", "oneDrawCallback", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class FirstDrawWatcherFrameLayout extends FrameLayout implements com.bytedance.android.live.ktv.common.util.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f144901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function2<? super Boolean, ? super Long, Unit> f144902b;

    @Override // com.bytedance.android.live.ktv.common.util.c
    public Function2<Boolean, Long, Unit> getOneDrawCallback() {
        return this.f144902b;
    }

    @Override // com.bytedance.android.live.ktv.common.util.b
    public String getTypeName() {
        return this.f144901a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.dispatchDraw(r100);
        Function2<Boolean, Long, Unit> r101 = getOneDrawCallback();
        if (r101 == null) goto L6;
        Unit r102 = r101.invoke(Boolean.FALSE, Long.valueOf(System.currentTimeMillis()));
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.util.c
    public void setOneDrawCallback(Function2<? super Boolean, ? super Long, Unit> r100) {
        this.f144902b = r100;
    }

    public void setTypeName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f144901a = r100;
    }

    public FirstDrawWatcherFrameLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f144901a = KtvSubElement.CONTAINER;
    }
}
