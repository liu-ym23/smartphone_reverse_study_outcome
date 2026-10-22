package com.bytedance.android.live.liveinteract.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/liveinteract/view/MicSeatSponsorView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/live/core/widget/HSImageView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/live/core/widget/HSImageView;", "getImgAvatar", "()Lcom/bytedance/android/live/core/widget/HSImageView;", "setImgAvatar", "(Lcom/bytedance/android/live/core/widget/HSImageView;)V", "imgAvatar", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MicSeatSponsorView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HSImageView f79936a;

    public MicSeatSponsorView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MicSeatSponsorView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final HSImageView getImgAvatar() {
        return this.f79936a;
    }

    public final void setImgAvatar(HSImageView r100) {
        this.f79936a = r100;
    }

    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "avatarUrl");
        if (r101 == null) goto L8;
        GradientDrawable r102 = new GradientDrawable();
        r102.setColor(Color.parseColor(r101));     // Catch: Exception -> L7
        r102.setStroke(UtilityKotlinExtentionsKt.i(1), Color.parseColor("#99FFFFFF"));     // Catch: Exception -> L7
        r102.setCornerRadius(UtilityKotlinExtentionsKt.i(9));     // Catch: Exception -> L7
        setBackground(r102);     // Catch: Exception -> L7
    L8:
        HSImageView r103 = this.f79936a;
        if (r103 == null) goto L14;
        r103.setImageURI(r100);
        return;
    }

    public MicSeatSponsorView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.ttlive_mic_seat_sponsor_anim, this);
        setLayoutParams(new ViewGroup.LayoutParams(UtilityKotlinExtentionsKt.i(40), UtilityKotlinExtentionsKt.i(18)));
        setGravity(16);
        setOrientation(0);
        this.f79936a = (HSImageView) findViewById(R.id.img_mic_seat_sponsor_avatar);
    }

    public /* synthetic */ MicSeatSponsorView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
