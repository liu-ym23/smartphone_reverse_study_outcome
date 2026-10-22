package com.bytedance.android.livesdk.announcement.instruction;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.nova.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class ImageDescView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f103519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f103520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f103521c;

    public ImageDescView(final Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100);
        Lazy r102 = LazyKt.lazy(new ImageDescView$tv$2(r100));
        this.f103519a = r102;
        Lazy r103 = LazyKt.lazy(new ImageDescView$iv$2(this));
        this.f103520b = r103;
        int r104 = s1.f(16.0f);
        this.f103521c = s1.y() - (r104 * 2);
        setPadding(r104, s1.f(20.0f), r104, s1.f(16.0f));
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(1);
        addView((TextView) r102.getValue());
        addView((HSImageView) r103.getValue());
        if (r101 == false) goto L5;
        ((TextView) r102.getValue()).setTextColor(s1.h(R.color.ttlive_douyin_light_TextPrimary));
        return;
    L5:
        ((TextView) r102.getValue()).setTextColor(s1.h(R.color.ttlive_douyin_dark_TextPrimary));
    }
}
