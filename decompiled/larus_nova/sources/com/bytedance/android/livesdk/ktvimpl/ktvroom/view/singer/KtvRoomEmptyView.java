package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.ktvimpl.base.util.p;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0015B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/singer/KtvRoomEmptyView;", "Landroid/widget/FrameLayout;", "", RemoteMessageConst.Notification.VISIBILITY, "", "setVisibility", "", "b", "Z", "getEnableRecordState", "()Z", "setEnableRecordState", "(Z)V", "enableRecordState", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvRoomEmptyView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f145287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f145288b;

    public static final class a {
    }

    static {
    }

    public KtvRoomEmptyView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KtvRoomEmptyView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final boolean getEnableRecordState() {
        return this.f145288b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public final void setEnableRecordState(boolean r100) {
        this.f145288b = r100;
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        StringBuilder r101 = new StringBuilder("visibility == ");
        if (r100 != 8) goto L5;
        boolean r102 = true;
    L6:
        r101.append(r102);
        ALogger.e("KtvRoomEmptyView", r101.toString());
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r100, final int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        super.onVisibilityChanged(r100, r101);
        Function1<p, Unit> r102 = new AnonymousClass1(this, r101);
        Intrinsics.checkNotNullParameter(r102, "cb");
        if (this.f145288b == false) goto L6;
        p.f143569g.getClass();
        p.a.a(r102);
        return;
    }

    public KtvRoomEmptyView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f145287a = new LinkedHashMap();
        View.inflate(r100, R.layout.ttlive_view_ktv_room_empty, this);
    }

    public /* synthetic */ KtvRoomEmptyView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
