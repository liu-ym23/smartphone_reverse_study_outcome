package com.bytedance.android.live.liveinteract.interact.audience.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017B\u001b\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0016\u0010\u001aB#\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u0016\u0010\u001dR*\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0013\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interact/audience/ui/StarView;", "Landroid/view/View;", "", "value", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, FaceService.girlLabel, "getPercent", "()F", "setPercent", "(F)V", "percent", "Landroid/graphics/drawable/Drawable;", "b", "Landroid/graphics/drawable/Drawable;", "getStarImageBg", "()Landroid/graphics/drawable/Drawable;", "starImageBg", "c", "getStarImageCover", "starImageCover", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class StarView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f73992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f73993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Drawable f73994c;

    public final float getPercent() {
        return this.f73992a;
    }

    public final Drawable getStarImageBg() {
        return this.f73993b;
    }

    public final Drawable getStarImageCover() {
        return this.f73994c;
    }

    public StarView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f73993b = getContext().getResources().getDrawable(R.drawable.ttlive_interact_profile_card_star);
        this.f73994c = getContext().getResources().getDrawable(R.drawable.ttlive_interact_profile_card_star_cover);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        this.f73993b.setBounds(0, 0, getWidth(), getHeight());
        this.f73993b.draw(r100);
        int r101 = r100.save();
        r100.clipRect(0, 0, (int) (getWidth() * this.f73992a), getHeight());
        this.f73994c.setBounds(0, 0, getWidth(), getHeight());
        this.f73994c.draw(r100);
        r100.restoreToCount(r101);
    }

    public final void setPercent(float r100) {
        if (r100 >= 0.0f) goto L5;
        return;
    L5:
        if (r100 > 1.0f) goto L10;
        this.f73992a = r100;
        return;
    }

    public StarView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f73993b = getContext().getResources().getDrawable(R.drawable.ttlive_interact_profile_card_star);
        this.f73994c = getContext().getResources().getDrawable(R.drawable.ttlive_interact_profile_card_star_cover);
    }

    public StarView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f73993b = getContext().getResources().getDrawable(R.drawable.ttlive_interact_profile_card_star);
        this.f73994c = getContext().getResources().getDrawable(R.drawable.ttlive_interact_profile_card_star_cover);
    }
}
