package com.bytedance.android.live.soloktv.floatwindow;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.uicomponent.loading.CircularProgressView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public class a extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CircularProgressView f101099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f101100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HSImageView f101101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HSImageView f101102d;

    /* JADX INFO: renamed from: com.bytedance.android.live.soloktv.floatwindow.a$a, reason: collision with other inner class name */
    public static final class C1538a {
    }

    static {
    }

    public void setCancelListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "cb");
    }

    public final HSImageView getProgressBgBlur() {
        return this.f101102d;
    }

    public final HSImageView getProgressBgImage() {
        return this.f101101c;
    }

    public final TextView getProgressText() {
        return this.f101100b;
    }

    public final CircularProgressView getProgressView() {
        return this.f101099a;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    public final void a(int r100) {
        CircularProgressView r101 = this.f101099a;
        if (r101 == null) goto L5;
        r101.setProgress(r100);
    L5:
        TextView r102 = this.f101100b;
        if (r102 == null) goto L9;
        StringBuilder r103 = new StringBuilder();
        r103.append(r100);
        r103.append('%');
        r102.setText(r103.toString());
        return;
    }

    public final void setProgressBgBlur(HSImageView r100) {
        this.f101102d = r100;
    }

    public final void setProgressBgImage(HSImageView r100) {
        this.f101101c = r100;
    }

    public final void setProgressText(TextView r100) {
        this.f101100b = r100;
    }

    public final void setProgressView(CircularProgressView r100) {
        this.f101099a = r100;
    }
}
