package com.bytedance.android.livesdk.chatroom.replay.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.s;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mq1.o;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\b\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/view/ReplayErrorView;", "Landroid/widget/FrameLayout;", "", "text", "", "setText", "Lkotlin/Function0;", EventConstant.Value.RETRY, "setRetryListener", "", "color", "setContainerBackgroundColor", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayErrorView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f110283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f110284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f110285c;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f110286a = null;

        static {
            f110286a = new a();
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

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f110287a = null;

        static {
            f110287a = new b();
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f110288a;

        public c(Function0 r100) {
            this.f110288a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f110288a.invoke();
        }
    }

    public ReplayErrorView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ReplayErrorView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setContainerBackgroundColor(int r100) {
        findViewById(R.id.ttlive_replay_error_container).setBackgroundColor(r100);
    }

    public final void setRetryListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, EventConstant.Value.RETRY);
        this.f110284b.setOnClickListener(new c(r100));
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        UtilityKotlinExtentionsKt.j(this);
        this.f110283a.setText(r100);
    }

    public ReplayErrorView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_widget_replay_error_container, this, true);
        this.f110283a = (TextView) findViewById(R.id.tv_error_hint);
        this.f110284b = (TextView) findViewById(R.id.tv_retry);
        ImageView r103 = (ImageView) findViewById(R.id.iv_back_icon);
        this.f110285c = r103;
        r103.setOnClickListener(a.f110286a);
        setOnClickListener(b.f110287a);
    }

    public /* synthetic */ ReplayErrorView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
