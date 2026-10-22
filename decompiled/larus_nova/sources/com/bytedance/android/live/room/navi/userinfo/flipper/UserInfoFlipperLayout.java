package com.bytedance.android.live.room.navi.userinfo.flipper;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.room.navi.userinfo.flipper.core.BaseTabFlipper;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0011B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo/flipper/UserInfoFlipperLayout;", "Lcom/bytedance/android/live/room/navi/userinfo/flipper/core/BaseTabFlipper;", "Lh91/a;", "tabFlipSynchronizer", "Lh91/a;", "getTabFlipSynchronizer", "()Lh91/a;", "setTabFlipSynchronizer", "(Lh91/a;)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserInfoFlipperLayout extends BaseTabFlipper {

    public static final class a {
    }

    static {
    }

    public UserInfoFlipperLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public UserInfoFlipperLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final h91.a getTabFlipSynchronizer() {
        return null;
    }

    public final void setTabFlipSynchronizer(h91.a r100) {
    }

    @Override // com.bytedance.android.live.room.navi.userinfo.flipper.core.BaseTabFlipper
    public final void c() {
        WeakReference<View> r100 = getDisplayView();
        if (r100 == null) goto L5;
        View r101 = r100.get();
    L6:
        getAdapter();
        setExpectAdapterCount(0);
        if (r101 == null) goto L18;
        BaseTabFlipper.LayoutParams r102 = com.bytedance.android.live.room.navi.userinfo.flipper.core.a.a(r101);
        if (r102 != null) goto L11;
        return;
    L11:
        if (r102.f99798b != null) goto L14;
        return;
    L14:
        if (r102.f99797a != null) goto L16;
        return;
    L16:
        b();
        setDisplayView(null);
        setCurShowPos(-1);
        a();
        e();
        return;
    L18:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public UserInfoFlipperLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ UserInfoFlipperLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
