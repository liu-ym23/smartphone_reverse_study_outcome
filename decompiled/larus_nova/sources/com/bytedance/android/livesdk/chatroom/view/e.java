package com.bytedance.android.livesdk.chatroom.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class e extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f114742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f114743b;

    public final void setContentText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        this.f114742a.setText(r100);
    }

    public final void setTitleText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        this.f114743b.setText(r100);
    }

    public e(Context r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        LayoutInflater.from(r100).inflate(R.layout.ttlive_view_dialog_text, this);
        this.f114743b = (TextView) findViewById(R.id.title);
        this.f114742a = (TextView) findViewById(R.id.sub_title);
        if (r101 == null) goto L5;
        setTitleText(r101);
    L5:
        if (r102 == null) goto L8;
        setContentText(r102);
        return;
    }
}
