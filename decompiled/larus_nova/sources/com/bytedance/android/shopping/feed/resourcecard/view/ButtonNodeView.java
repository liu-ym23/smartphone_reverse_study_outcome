package com.bytedance.android.shopping.feed.resourcecard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/view/ButtonNodeView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ButtonNodeView extends FrameLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f175195f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public yd3.a f175196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f175197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public rd3.a f175198c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f175199d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f175200e;

    public static final class a extends com.bytedance.android.ec.core.widget.d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ ButtonNodeView f175201g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ Context f175202h;

        @Override // com.bytedance.android.ec.core.widget.d
        public final void a(View r110) {
            Intrinsics.checkNotNullParameter(r110, BaseSwitches.V);
            yd3.a r111 = this.f175201g.f175196a;
            if (r111 == null) goto L7;
            String r112 = r111.c();
            if (r112 == null) goto L7;
            com.bytedance.android.ec.sdk.helper.p.f48130a.openSchema(this.f175202h, r112);
        L7:
            rd3.a r100 = this.f175201g.f175198c;
            if (r100 == null) goto L11;
            FeedProductEventTracker.m(FeedProductEventTracker.f174442a, r100, "button", null, null, null, null, null, 124);
            return;
        }

        public a(ButtonNodeView r100, Context r101) {
            this.f175201g = r100;
            this.f175202h = r101;
            super(null, "bind_product_flow_card", 1);
        }
    }

    public static final class b {
    }

    static {
    }

    public ButtonNodeView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ButtonNodeView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public ButtonNodeView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_button_node_view, this, true);
        this.f175199d = (ImageView) findViewById(R.id.button_node_arrow);
        this.f175197b = (TextView) findViewById(R.id.button_node_tv);
        this.f175200e = findViewById(R.id.button_node_bg);
        setOnClickListener(new a(this, r100));
    }

    public /* synthetic */ ButtonNodeView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
