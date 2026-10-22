package com.bytedance.android.shopping.feed.resourcecard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yd3.t;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/view/HeaderNodeViewStyle67;", "Lcom/bytedance/android/shopping/feed/resourcecard/view/HeaderNodeView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeaderNodeViewStyle67 extends HeaderNodeView {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f175266e = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ECDraweeView f175267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f175268d;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HeaderNodeViewStyle67 f175269a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f175270b;

        public a(HeaderNodeViewStyle67 r100, Context r101) {
            this.f175269a = r100;
            this.f175270b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r110) {
            rd3.a r100 = this.f175269a.getAnchorInflowFeedItem();
            if (r100 == null) goto L5;
            FeedProductEventTracker.m(FeedProductEventTracker.f174442a, r100, "button", null, null, null, null, null, 124);
        L5:
            yd3.f r111 = this.f175269a.getHeaderNode();
            if (r111 == null) goto L11;
            yd3.g r112 = r111.c();
            if (r112 == null) goto L12;
            com.bytedance.android.ec.sdk.helper.p.f48130a.openSchema(this.f175270b, r112.c());
            return;
        L12:
            return;
        }
    }

    public static final class b {
    }

    static {
    }

    public HeaderNodeViewStyle67(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public HeaderNodeViewStyle67(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.resourcecard.view.HeaderNodeView
    public final void a(rd3.a r110) {
        Intrinsics.checkNotNullParameter(r110, "anchorInflowFeedItem");
        super.a(r110);
        TextView r111 = this.f175268d;
        yd3.f r100 = getHeaderNode();
        ECUrlModel r101 = null;
        if (r100 == null) goto L7;
        yd3.g r102 = r100.c();
        if (r102 == null) goto L7;
        String r103 = r102.d();
    L8:
        r111.setText(r103);
        ECDraweeView r104 = this.f175267c;
        yd3.f r112 = getHeaderNode();
        if (r112 == null) goto L13;
        t r113 = r112.f();
        if (r113 == null) goto L13;
        r101 = r113.b();
    L13:
        h0.d(r104, r101, null, null, null, null, null, 120);
        return;
    L7:
        r103 = null;
        goto L8
    }

    public HeaderNodeViewStyle67(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_commerce_header_node_view_style_67, this, true);
        this.f175267c = (ECDraweeView) findViewById(R.id.head_left_img_dv);
        this.f175268d = (TextView) findViewById(R.id.head_right_tv);
        ((LinearLayout) findViewById(R.id.head_right_ll)).setOnClickListener(new a(this, r100));
    }

    public /* synthetic */ HeaderNodeViewStyle67(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
