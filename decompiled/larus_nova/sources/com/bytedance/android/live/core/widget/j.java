package com.bytedance.android.live.core.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class j extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f66598a;

    public j(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        LayoutInflater.from(getContext()).inflate(R.layout.text_image_view_layout, this, true);
        this.f66598a = (TextView) findViewById(R.id.text_view);
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        TextView r101 = this.f66598a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
    L5:
        r101.setText(r100);
    }

    public final void setTextColor(int r100) {
        TextView r101 = this.f66598a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
    L5:
        r101.setTextColor(r100);
    }
}
