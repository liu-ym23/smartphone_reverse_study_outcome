package com.bytedance.android.shopping.commentgallery.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentNodeVO;
import com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionPagerAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0006\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0016J/\u0010\u0011\u001a\u00020\u00042%\u0010\u0010\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bH\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0006\u0010\u0015\u001a\u00020\u0014¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/commentgallery/view/CommentGalleryIndicator;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "Lkotlin/Function0;", "", "loadMoreListener", "setLoadMoreListener", "backListener", "setBackListener", "switchModeListener", "setSwitchModeListener", "Lkotlin/Function1;", "Lcom/bytedance/android/shopping/anchorv3/comment/model/CommentNodeVO;", "Lkotlin/ParameterName;", "name", "curComment", "diggCommentListener", "setDiggCommentListener", "Lcc3/c;", "getCurCommentGalleryModel", "", "getPosition", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentGalleryIndicator extends ConstraintLayout implements IIndicatorView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f172515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CommentGalleryExpandableTextView f172516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f172517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f172518d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f172519e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f172520f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<cc3.c> f172521g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function0<Unit> f172522h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function0<Unit> f172523i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function0<Unit> f172524j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function1<? super CommentNodeVO, Unit> f172525k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public CommentNodeVO f172526l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public cc3.c f172527m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f172528n;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentGalleryIndicator f172529a;

        public a(CommentGalleryIndicator r100) {
            this.f172529a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Function0<Unit> r101 = this.f172529a.f172523i;
            if (r101 == null) goto L6;
            Unit r102 = r101.invoke();
            return;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentGalleryIndicator f172530a;

        public b(CommentGalleryIndicator r100) {
            this.f172530a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Function0<Unit> r101 = this.f172530a.f172524j;
            if (r101 == null) goto L6;
            Unit r102 = r101.invoke();
            return;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentGalleryIndicator f172531a;

        public c(CommentGalleryIndicator r100) {
            this.f172531a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            CommentGalleryIndicator r101 = this.f172531a;
            Function1<? super CommentNodeVO, Unit> r102 = r101.f172525k;
            if (r102 == null) goto L6;
            Unit r103 = r102.invoke(r101.f172526l);
            return;
        }
    }

    public CommentGalleryIndicator(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CommentGalleryIndicator(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView
    public final void onDataChanged(TransitionPagerAdapter<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "adapter");
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public final void onTransitionBegin(int r100) {
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public final void onTransitionChanged(int r100, float r101) {
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public final void onTransitionEnd(int r100) {
    }

    public final int getPosition() {
        return this.f172528n + 1;
    }

    public cc3.c getCurCommentGalleryModel() {
        return this.f172527m;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView
    public final void onPageSelected(int r110) {
        this.f172528n = r110;
        CommentNodeVO r100 = this.f172526l;
        if (r100 == null) goto L5;
        long r101 = r100.getId();
    L6:
        this.f172527m = (cc3.c) ListProtector.get(this.f172521g, r110);
        this.f172526l = ((cc3.c) ListProtector.get(this.f172521g, r110)).f23230c;
        TextView r102 = this.f172517c;
        StringBuilder r103 = new StringBuilder("@");
        CommentNodeVO r104 = this.f172526l;
        Long r105 = null;
        if (r104 == null) goto L9;
        String r106 = r104.getUserName();
    L10:
        r103.append(r106);
        String r107 = r103.toString();
        String r108 = "";
        if (r107 != null) goto L14;
        r107 = "";
    L14:
        r102.setText(r107);
        TextView r109 = this.f172518d;
        CommentNodeVO r111 = this.f172526l;
        if (r111 == null) goto L19;
        String r112 = r111.getSku();
        if (r112 == null) goto L19;
    L20:
        r109.setText(r112);
        CommentGalleryExpandableTextView r113 = this.f172516b;
        CommentNodeVO r114 = this.f172526l;
        if (r114 == null) goto L26;
        String r115 = r114.getContent();
        if (r115 == null) goto L26;
        r108 = r115;
    L26:
        CommentNodeVO r116 = this.f172526l;
        if (r116 == null) goto L29;
        long r117 = r116.getId();
    L31:
        if (r101 == r117) goto L33;
        boolean r118 = true;
    L34:
        r113.getClass();
        Intrinsics.checkNotNullParameter(r108, "text");
        if (r118 == false) goto L37;
        r113.f172498a.setText(r108);
        r113.f172507j = r108;
        r113.c();
    L37:
        ImageView r119 = this.f172519e;
        CommentNodeVO r120 = this.f172526l;
        if (r120 != null) goto L40;
    L42:
        int r121 = R.drawable.commerce_comment_gallery_unliked;
    L43:
        r119.setImageResource(r121);
        TextView r122 = this.f172520f;
        CommentNodeVO r123 = this.f172526l;
        if (r123 == null) goto L46;
        long r124 = r123.getLikes();
    L48:
        if (r124 != 0) goto L50;
        String r125 = "有用";
    L54:
        r122.setText(r125);
        TextView r126 = this.f172515a;
        StringBuilder r127 = new StringBuilder();
        r127.append(r110 + 1);
        r127.append('/');
        r127.append(((ArrayList) this.f172521g).size());
        r126.setText(r127.toString());
        if (r110 != (((ArrayList) this.f172521g).size() - 2)) goto L60;
        Function0<Unit> r128 = this.f172522h;
        if (r128 == null) goto L61;
        Unit r129 = r128.invoke();
        return;
    L61:
        return;
    L60:
        return;
    L50:
        CommentNodeVO r130 = this.f172526l;
        if (r130 == null) goto L53;
        r105 = Long.valueOf(r130.getLikes());
    L53:
        r125 = String.valueOf(r105);
        goto L54
    L46:
        r124 = 0;
        goto L48
    L40:
        if (r120.getLiked() != true) goto L42;
        r121 = R.drawable.commerce_comment_gallery_liked;
        goto L43
    L33:
        r118 = false;
        goto L34
    L29:
        r117 = 0;
    L19:
        r112 = "";
        goto L20
    L9:
        r106 = null;
        goto L10
    L5:
        r101 = 0;
        goto L6
    }

    public void setBackListener(Function0<Unit> r100) {
        this.f172523i = r100;
    }

    public void setDiggCommentListener(Function1<? super CommentNodeVO, Unit> r100) {
        this.f172525k = r100;
    }

    public void setLoadMoreListener(Function0<Unit> r100) {
        this.f172522h = r100;
    }

    public void setSwitchModeListener(Function0<Unit> r100) {
        this.f172524j = r100;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView
    public final void onAttach(int r100, TransitionPagerAdapter<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "adapter");
        Intrinsics.checkNotNullParameter(r101, "adapter");
        IIndicatorView.DefaultImpls.onAttach(this, r100, r101);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView
    public final void onDetach(int r100, TransitionPagerAdapter<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "adapter");
        Intrinsics.checkNotNullParameter(r101, "adapter");
        IIndicatorView.DefaultImpls.onDetach(this, r100, r101);
    }

    public CommentGalleryIndicator(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f172521g = new ArrayList();
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_comment_gallery_activity_layout, this, true);
        this.f172515a = (TextView) findViewById(R.id.ec_comment_gallery_num);
        ImageView r103 = (ImageView) findViewById(R.id.ec_comment_gallery_iv_back);
        ImageView r104 = (ImageView) findViewById(R.id.ec_comment_multipic_mode);
        this.f172516b = (CommentGalleryExpandableTextView) findViewById(R.id.ec_comment_content_text);
        this.f172517c = (TextView) findViewById(R.id.ec_comment_user_name);
        this.f172518d = (TextView) findViewById(R.id.ec_comment_type);
        ImageView r105 = (ImageView) findViewById(R.id.ec_comment_iv_like);
        this.f172519e = r105;
        this.f172520f = (TextView) findViewById(R.id.ec_comment_tv_like);
        r103.setOnClickListener(new a(this));
        r104.setOnClickListener(new b(this));
        r105.setOnClickListener(new c(this));
    }

    public /* synthetic */ CommentGalleryIndicator(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
