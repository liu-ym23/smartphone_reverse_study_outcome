package com.bytedance.android.shopping.anchorv3.comment.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.shopping.utils.k0;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\bB\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/comment/widget/CommentInteractiveView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentInteractiveView extends FrameLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f164619h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f164620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f164621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f164622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f164623d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f164624e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f164625f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f164626g;

    public static final class a {
    }

    static {
        f164619h = LazyKt.lazy(CommentInteractiveView$Companion$publishWorkBtnHasMobShowIdList$2.INSTANCE);
    }

    public CommentInteractiveView(Context r100) {
        this(r100, null);
    }

    public CommentInteractiveView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LayoutInflater.from(r100).inflate(R.layout.ec_commerce_comment_bottom_interactive_layout, this);
        this.f164620a = (TextView) findViewById(R.id.comment_tv_browse_count);
        this.f164621b = findViewById(R.id.comment_item_digg_view);
        this.f164622c = (ImageView) findViewById(R.id.comment_item_iv_digg_icon);
        this.f164623d = (TextView) findViewById(R.id.comment_item_tv_digg_count);
        this.f164624e = findViewById(R.id.comment_reply_view);
        ImageView r102 = (ImageView) findViewById(R.id.comment_reply_iv);
        this.f164625f = (TextView) findViewById(R.id.comment_reply_tv);
        ViewStub r103 = (ViewStub) findViewById(R.id.comment_publish_work_viewstub);
    }

    public final void a(boolean r100, long r101) {
        if (r100 == false) goto L4;
        this.f164622c.setImageResource(R.drawable.ec_comment_item_bottom_icon_digged);
        TextView r102 = this.f164623d;
        int r103 = g1.f45599a;
        r102.setTextColor(g1.a.a(getContext(), R.color.shopping_color_FE496A));
    L6:
        if (r101 > 0) goto L8;
        this.f164623d.setText(R.string.commerce_anchor_v3_comment_useful);
        return;
    L8:
        this.f164623d.setText(k0.a(r101));
        return;
    L4:
        this.f164622c.setImageResource(R.drawable.ec_comment_item_bottom_icon_undigg);
        TextView r104 = this.f164623d;
        int r105 = g1.f45599a;
        r104.setTextColor(g1.a.a(getContext(), R.color.shopping_color_99161823));
        goto L6
    }
}
