package com.bytedance.android.shopping.deepfeed.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.shopping.deepfeed.action.DeepFeedCommentClickArea;
import com.bytedance.android.shopping.infeed.data.idl.ImageURL;
import com.bytedance.android.shopping.infeed.data.idl.InFeedUrlModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\u0006\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/ui/view/CommentItemView;", "Landroid/widget/LinearLayout;", "Lkotlin/Function1;", "Lcom/bytedance/android/shopping/deepfeed/action/DeepFeedCommentClickArea;", "", "listener", "setOnCommentAreaClickListener", "", "enabled", "setCommentAreaClickEnabled", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentItemView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleDraweeView f173877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatTextView f173878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f173879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f173880d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DeepFeedMaskTextView f173881e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DeepFeedMaskTextView f173882f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f173883g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f173884h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function1<? super DeepFeedCommentClickArea, Unit> f173885i;

    public CommentItemView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CommentItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setCommentAreaClickEnabled(boolean r100) {
        setClickable(r100);
        this.f173877a.setClickable(r100);
        this.f173884h.setClickable(r100);
        this.f173883g.setClickable(r100);
    }

    public final void setOnCommentAreaClickListener(Function1<? super DeepFeedCommentClickArea, Unit> r100) {
        this.f173885i = r100;
    }

    public final void b(boolean r100, boolean r101) {
        this.f173881e.setMaskEnabled(r101);
        this.f173882f.setMaskEnabled(r100);
    }

    public CommentItemView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setOrientation(1);
        LayoutInflater.from(r100).inflate(R.layout.shopping_deepfeed_comment_item_view, this, true);
        SimpleDraweeView r103 = (SimpleDraweeView) findViewById(R.id.iv_comment_avatar);
        this.f173877a = r103;
        this.f173878b = (AppCompatTextView) findViewById(R.id.tv_comment_user_name);
        this.f173879c = (SimpleDraweeView) findViewById(R.id.iv_comment_user_icon);
        this.f173880d = findViewById(R.id.view_comment_divider);
        this.f173881e = (DeepFeedMaskTextView) findViewById(R.id.tv_comment_content_first_line);
        this.f173882f = (DeepFeedMaskTextView) findViewById(R.id.tv_comment_content_second_line);
        View r104 = findViewById(R.id.layout_comment_more);
        this.f173883g = r104;
        View r105 = findViewById(R.id.layout_comment_text_container);
        this.f173884h = r105;
        setOnClickListener(new b(this));
        r103.setOnClickListener(new c(this));
        r105.setOnClickListener(new d(this));
        r104.setOnClickListener(new e(this));
    }

    public final void a(he3.f r210, r r211, boolean r212) {
        String r100 = null;
        if (r210 == null) goto L7;
        ImageURL r101 = r210.b();
        if (r101 == null) goto L7;
        InFeedUrlModel r102 = new InFeedUrlModel();
        r102.setUrlList(r101.getUrlList());
        InFeedUrlModel r103 = r102;
    L8:
        h0.d(this.f173877a, r103, r211, null, null, null, null, 120);
        if (r210 == null) goto L11;
        String r104 = r210.d();
    L13:
        if (r104 != null) goto L15;
        r104 = "";
    L15:
        this.f173878b.setText(r104);
        AppCompatTextView r105 = this.f173878b;
        if (StringsKt.isBlank(r104) == false) goto L18;
        int r106 = 8;
    L19:
        r105.setVisibility(r106);
        if (r210 == null) goto L24;
        ImageURL r107 = r210.c();
        if (r107 == null) goto L24;
        InFeedUrlModel r108 = new InFeedUrlModel();
        r108.setUrlList(r107.getUrlList());
        InFeedUrlModel r109 = r108;
    L25:
        if (r109 != null) goto L27;
        this.f173879c.setVisibility(8);
    L28:
        View r110 = this.f173883g;
        if (r212 == false) goto L31;
        int r111 = 0;
    L32:
        r110.setVisibility(r111);
        if (r210 == null) goto L35;
        r100 = r210.a();
    L35:
        if (r100 != null) goto L37;
        r100 = "";
    L37:
        String r112 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r100, "\\n", "", false, 4, null), "\r", "", false, 4, null), "\n", "", false, 4, null);
        String r113 = this.f173878b.getText() + '\n' + r100 + '\n' + this.f173879c.getVisibility() + '\n' + r212;
        this.f173881e.setTag(r113);
        this.f173881e.setText("");
        DeepFeedMaskTextView r114 = this.f173881e;
        r114.setPadding(r114.getPaddingLeft(), this.f173881e.getPaddingTop(), 0, this.f173881e.getPaddingBottom());
        this.f173881e.setMaskEnabled(false);
        this.f173882f.setText("");
        this.f173882f.setVisibility(8);
        DeepFeedMaskTextView r115 = this.f173882f;
        r115.setPadding(r115.getPaddingLeft(), this.f173882f.getPaddingTop(), 0, this.f173882f.getPaddingBottom());
        this.f173882f.setMaskEnabled(false);
        this.f173881e.post(new f(this, r113, r212, r112));
        return;
    L31:
        r111 = 8;
        goto L32
    L27:
        this.f173879c.setVisibility(0);
        h0.d(this.f173879c, r109, r211, null, null, null, null, 120);
    L24:
        r109 = null;
        goto L25
    L18:
        r106 = 0;
        goto L19
    L11:
        r104 = null;
    L7:
        r103 = null;
        goto L8
    }

    public /* synthetic */ CommentItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
