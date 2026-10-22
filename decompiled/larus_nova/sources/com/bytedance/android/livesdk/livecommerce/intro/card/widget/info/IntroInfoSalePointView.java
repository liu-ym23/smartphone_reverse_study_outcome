package com.bytedance.android.livesdk.livecommerce.intro.card.widget.info;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Space;
import android.widget.TextView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.view.AutoHideLinearLayout;
import com.bytedance.android.livesdk.livecommerce.view.GradientAndItalicTextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007B#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/card/widget/info/IntroInfoSalePointView;", "Lcom/bytedance/android/livesdk/livecommerce/view/AutoHideLinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
final class IntroInfoSalePointView extends AutoHideLinearLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<GradientAndItalicTextView> f148066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Space> f148067c;

    public IntroInfoSalePointView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f148066b = new ArrayList();
        this.f148067c = new ArrayList();
        setOrientation(0);
        setGravity(16);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.view.AutoHideLinearLayout, android.view.ViewGroup
    public final void onViewRemoved(View r100) {
        super.onViewRemoved(r100);
        if ((r100 instanceof GradientAndItalicTextView) == false) goto L6;
        ((ArrayList) this.f148066b).add(r100);
        return;
    L6:
        if ((r100 instanceof Space) == false) goto L10;
        ((ArrayList) this.f148067c).add(r100);
        return;
    }

    public IntroInfoSalePointView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f148066b = new ArrayList();
        this.f148067c = new ArrayList();
        setOrientation(0);
        setGravity(16);
    }

    public IntroInfoSalePointView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f148066b = new ArrayList();
        this.f148067c = new ArrayList();
        setOrientation(0);
        setGravity(16);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.view.AutoHideLinearLayout
    public final boolean e(View r100, boolean r101, int r102, int r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        if ((r100 instanceof TextView) == false) goto L12;
        if (UtilityKotlinExtentionsKt.e((TextView) r100) == false) goto L12;
        if (indexOfChild(r100) <= 0) goto L9;
        return true;
    L9:
        return false;
    L12:
        return super.e(r100, r101, r102, r103, r104, r105);
    }
}
