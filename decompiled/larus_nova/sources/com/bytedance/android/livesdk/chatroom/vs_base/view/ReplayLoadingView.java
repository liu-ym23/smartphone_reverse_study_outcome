package com.bytedance.android.livesdk.chatroom.vs_base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.ui.DouyinLoadingLayout;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.s;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mq1.o;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0002¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/view/ReplayLoadingView;", "Landroid/widget/FrameLayout;", "", "text", "", "setText", "", "color", "setTextColor", "url", "setLandBackgroundUrl", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayLoadingView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f118225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HSImageView f118226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f118227c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DouyinLoadingLayout f118228d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f118229e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f118230f;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f118231a = null;

        static {
            f118231a = new a();
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            o r101 = s.d();
            if (r101 == null) goto L6;
            o.a.a(r101, 1, 0, 0, null, 30);
            return;
        }
    }

    public ReplayLoadingView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ReplayLoadingView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a() {
        UtilityKotlinExtentionsKt.h(this.f118226b);
        if (this.f118229e == true) goto L6;
        UtilityKotlinExtentionsKt.j(this.f118227c);
        return;
    }

    public final void setLandBackgroundUrl(String r100) {
        this.f118230f = r100;
        if (this.f118226b.getVisibility() != 0) goto L8;
        String r101 = this.f118230f;
        if (r101 == null) goto L9;
        a1.r(this.f118226b, r101, R.color.ttlive_std_bg_inverse);
        return;
    L9:
        return;
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        UtilityKotlinExtentionsKt.j(this);
        this.f118228d.setVisibility(0);
        this.f118225a.setText(r100);
    }

    public final void setTextColor(int r100) {
        UtilityKotlinExtentionsKt.j(this);
        this.f118228d.setVisibility(0);
        this.f118225a.setTextColor(s1.h(r100));
    }

    public ReplayLoadingView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_replay_end_loading_switch_view, this, true);
        this.f118225a = (TextView) findViewById(R.id.vs_end_loading_switch_tv);
        this.f118226b = (HSImageView) findViewById(R.id.iv_landscape_bg);
        ImageView r103 = (ImageView) findViewById(R.id.iv_back_icon);
        this.f118227c = r103;
        this.f118228d = (DouyinLoadingLayout) findViewById(R.id.vs_end_loading_switch_icon);
        r103.setOnClickListener(a.f118231a);
        a();
    }

    public /* synthetic */ ReplayLoadingView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
