package com.bytedance.android.live.profile.standard.honour.items.dressup;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.live.profile.standard.honour.items.StandardHonourCardView;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016R\u001d\u0010\r\u001a\u0004\u0018\u00010\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/profile/standard/honour/items/dressup/DressUpHonourCardView;", "Lcom/bytedance/android/live/profile/standard/honour/items/StandardHonourCardView;", "Lcom/bytedance/android/live/profile/standard/honour/items/dressup/b;", "", "scale", "", "setDressIconScale", "alpha", "setDressIconAlpha", RXScreenCaptureService.KEY_INDEX, "Lkotlin/Lazy;", "getTransitionViewHolder", "()Lcom/bytedance/android/live/profile/standard/honour/items/dressup/b;", "transitionViewHolder", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DressUpHonourCardView extends StandardHonourCardView implements b {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f86246j = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f86247i;

    public DressUpHonourCardView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DressUpHonourCardView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final b getTransitionViewHolder() {
        return (b) this.f86247i.getValue();
    }

    @Override // com.bytedance.android.live.profile.standard.honour.items.dressup.b
    public void setDressIconAlpha(float r100) {
        b r101 = getTransitionViewHolder();
        if (r101 == null) goto L6;
        r101.setDressIconAlpha(r100);
        return;
    }

    @Override // com.bytedance.android.live.profile.standard.honour.items.dressup.b
    public void setDressIconScale(float r100) {
        b r101 = getTransitionViewHolder();
        if (r101 == null) goto L6;
        r101.setDressIconScale(r100);
        return;
    }

    public DressUpHonourCardView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f86247i = LazyKt.lazy(new DressUpHonourCardView$transitionViewHolder$2(this));
    }

    public /* synthetic */ DressUpHonourCardView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
