package com.bytedance.android.livesdk.widget.desc;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.open.SocialConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u0010\u0010\t\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/widget/desc/CountDownWithDescTextView;", "Landroid/widget/LinearLayout;", "", "resId", "", "setContainerBackgroundResource", "width", "setCountDownViewWidth", "color", "setTextColor", "", SocialConstants.PARAM_APP_DESC, "setDescText", "", "textSize", "setDescTextSize", "setCountDownTextSize", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CountDownWithDescTextView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f161690a;

    public CountDownWithDescTextView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CountDownWithDescTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final View a(int r100) {
        if (this.f161690a != null) goto L5;
        this.f161690a = new LinkedHashMap();
    L5:
        View r101 = this.f161690a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f161690a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final void setContainerBackgroundResource(int r100) {
        setBackgroundResource(r100);
    }

    public final void setCountDownTextSize(float r100) {
        ((TextView) a(R.id.count_down_text)).setTextSize(r100);
    }

    public final void setCountDownViewWidth(int r100) {
        ViewGroup.LayoutParams r101 = ((TextView) a(R.id.count_down_text)).getLayoutParams();
        r101.width = r100;
        ((TextView) a(R.id.count_down_text)).setLayoutParams(r101);
    }

    public final void setDescText(String r100) {
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_APP_DESC);
        ((TextView) a(R.id.desc_text)).setText(r100);
        ((TextView) a(R.id.count_down_text)).setVisibility(8);
    }

    public final void setDescTextSize(float r100) {
        ((TextView) a(R.id.desc_text)).setTextSize(r100);
    }

    public final void setTextColor(int r100) {
        ((TextView) a(R.id.desc_text)).setTextColor(r100);
        ((TextView) a(R.id.count_down_text)).setTextColor(r100);
    }

    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_APP_DESC);
        Intrinsics.checkNotNullParameter(r101, "countDown");
        ((TextView) a(R.id.desc_text)).setText(r100);
        ((TextView) a(R.id.count_down_text)).setVisibility(0);
        ((TextView) a(R.id.count_down_text)).setText(r101);
    }

    public CountDownWithDescTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f161690a = new LinkedHashMap();
        LayoutInflater.from(r100).inflate(R.layout.ttlive_count_down_text_view, this);
    }

    public /* synthetic */ CountDownWithDescTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
