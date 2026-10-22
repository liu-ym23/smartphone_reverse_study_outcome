package com.bytedance.android.shopping.commentfeed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.shopping.commentfeed.utils.CommentListViewModel;
import com.bytedance.android.shopping.utils.k0;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/commentfeed/widget/CommentItemDiggView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentItemDiggView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f172415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f172416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public zb3.a f172417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CommentListViewModel f172418d;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.commentfeed.widget.CommentItemDiggView$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentItemDiggView f172419a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f172420b;

        public AnonymousClass1(CommentItemDiggView r100, Context r101) {
            this.f172419a = r100;
            this.f172420b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r110) {
            CommentItemDiggView r100 = this.f172419a;
            zb3.a r101 = r100.f172417c;
            final boolean r102 = r101.f571127b;
            final long r103 = r101.f571128c;
            if (r102 == true) goto L5;
            final long r104 = 1;
        L6:
            String r105 = r101.f571126a;
            if (r105 == null) goto L12;
            CommentListViewModel r106 = r100.f172418d;
            if (r106 == null) goto L12;
            r106.diggCommentAction(new zb3.b(CastLongProtector.parseLong(r105), r104, r103), new CommentItemDiggView$1$$special$$inlined$let$lambda$1(this, r104, r103, r102));
        L12:
            CommentItemDiggView r107 = this.f172419a;
            boolean r108 = !r102;
            if (r102 == false) goto L15;
            long r109 = r103 - 1;
        L16:
            r107.a(r108, r109);
            return;
        L15:
            r109 = r103 + 1;
            goto L16
        L5:
            r104 = 2;
            goto L6
        }
    }

    public CommentItemDiggView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CommentItemDiggView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a(boolean r100, long r101) {
        if (r100 == false) goto L4;
        this.f172416b.setImageResource(R.drawable.ec_commerce_icon_comment_digged);
    L6:
        if (r101 <= 0) goto L8;
        this.f172415a.setText(k0.a(r101));
        return;
    L8:
        this.f172415a.setText(th.a.f(getContext()).getString(R.string.shopping_tip_digg));
        return;
    L4:
        this.f172416b.setImageResource(R.drawable.ec_commerce_icon_comment_undigg);
        goto L6
    }

    public CommentItemDiggView(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r110);
        this.f172417c = new zb3.a(null, false, 0, 15);
        LayoutInflater.from(r100).inflate(R.layout.ec_commerce_comment_digg_layout, this);
        ImageView r102 = (ImageView) findViewById(R.id.ec_commerce_iv_comment_digg_icon);
        this.f172416b = r102;
        this.f172415a = (TextView) findViewById(R.id.ec_commerce_tv_comment_digg_count);
        r102.setOnClickListener(new AnonymousClass1(this, r100));
    }

    public /* synthetic */ CommentItemDiggView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
