package com.bytedance.android.livesdk.announcement.instruction;

import android.content.Context;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends AppCompatTextView {
    public a(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100);
        setPadding(s1.f(16.0f), s1.f(14.0f), s1.f(16.0f), 0);
        setTextColor(s1.h(R.color.ttlive_white));
        setTextSize(1, 15.0f);
        if (r101 == false) goto L5;
        setTextColor(s1.h(R.color.ttlive_douyin_light_TextPrimary));
        return;
    L5:
        setTextColor(s1.h(R.color.ttlive_douyin_dark_TextPrimary));
    }
}
