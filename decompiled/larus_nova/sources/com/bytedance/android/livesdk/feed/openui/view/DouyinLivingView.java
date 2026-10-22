package com.bytedance.android.livesdk.feed.openui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdkapi.view.SaasLiveCircleView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/feed/openui/view/DouyinLivingView;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "saasfeed_release"}, k = 1, mv = {1, 4, 3})
public final class DouyinLivingView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap f124195a;

    public DouyinLivingView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DouyinLivingView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final View a(int r100) {
        if (this.f124195a != null) goto L5;
        this.f124195a = new HashMap();
    L5:
        View r101 = (View) this.f124195a.get(Integer.valueOf(r100));
        if (r101 != null) goto L9;
        View r102 = findViewById(r100);
        this.f124195a.put(Integer.valueOf(r100), r102);
        return r102;
    L9:
        return r101;
    }

    public DouyinLivingView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        HSImageView r103 = (HSImageView) a(R.id.iv_cover);
        TextView r104 = (TextView) a(R.id.tv_name);
        SaasLiveCircleView r105 = (SaasLiveCircleView) a(R.id.iv_live_circle);
        LinearLayout r106 = (LinearLayout) a(R.id.live_tag_layout);
        TextView r107 = (TextView) a(R.id.tv_live_tag);
        View.inflate(getContext(), R.layout.ttlive_feed_item_horizontal_list, this);
    }

    public /* synthetic */ DouyinLivingView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
