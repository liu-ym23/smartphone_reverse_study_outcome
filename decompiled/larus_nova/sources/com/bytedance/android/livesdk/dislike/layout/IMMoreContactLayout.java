package com.bytedance.android.livesdk.dislike.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdk.dislike.action.OptionAction;
import com.bytedance.android.livesdk.dislike.u;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\b\u0010\fB#\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\b\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/dislike/layout/IMMoreContactLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/dislike/u;", MapController.ITEM_LAYER_TAG, "", "update", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IMMoreContactLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IMMoreContactDescItemLayout f122135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OptionAction f122136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f122137c;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IMMoreContactLayout f122138a;

        public a(IMMoreContactLayout r100) {
            this.f122138a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            OptionAction r101 = this.f122138a.f122136b;
            if (r101 == null) goto L6;
            r101.b(r100);
            return;
        }
    }

    public IMMoreContactLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f122137c = View.inflate(getContext(), R.layout.ttlive_dialog_long_press_im_more, this);
        this.f122135a = (IMMoreContactDescItemLayout) findViewById(R.id.desc_layout);
        setOnClickListener(new a(this));
    }

    public final void update(u r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        this.f122136b = r100.f122167b;
        this.f122135a.update(r100.f122237c);
    }

    public IMMoreContactLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f122137c = View.inflate(getContext(), R.layout.ttlive_dialog_long_press_im_more, this);
        this.f122135a = (IMMoreContactDescItemLayout) findViewById(R.id.desc_layout);
        setOnClickListener(new a(this));
    }

    public IMMoreContactLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f122137c = View.inflate(getContext(), R.layout.ttlive_dialog_long_press_im_more, this);
        this.f122135a = (IMMoreContactDescItemLayout) findViewById(R.id.desc_layout);
        setOnClickListener(new a(this));
    }
}
