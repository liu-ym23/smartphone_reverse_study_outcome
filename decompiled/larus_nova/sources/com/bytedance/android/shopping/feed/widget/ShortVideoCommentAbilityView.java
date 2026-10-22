package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.bytedance.android.ec.core.utils.g1;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/ShortVideoCommentAbilityView;", "Landroid/widget/FrameLayout;", "", "Landroid/widget/TextSwitcher;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/widget/TextSwitcher;", "getTextSwitcher", "()Landroid/widget/TextSwitcher;", "textSwitcher", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShortVideoCommentAbilityView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextSwitcher f175994a;

    public static final class a implements ViewSwitcher.ViewFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f175995a;

        public a(Context r100) {
            this.f175995a = r100;
        }

        @Override // android.widget.ViewSwitcher.ViewFactory
        public final View makeView() {
            TextView r100 = new TextView(this.f175995a);
            r100.setTextSize(1, 10.0f);
            r100.setIncludeFontPadding(false);
            r100.setGravity(17);
            int r101 = g1.f45599a;
            r100.setTextColor(g1.a.a(this.f175995a, R.color.commerce_color_BF161823));
            return r100;
        }
    }

    public ShortVideoCommentAbilityView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ShortVideoCommentAbilityView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final TextSwitcher getTextSwitcher() {
        return this.f175994a;
    }

    public ShortVideoCommentAbilityView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.ec_short_video_comment_ability_view, this);
        TextSwitcher r103 = (TextSwitcher) findViewById(R.id.tv_product_comment);
        this.f175994a = r103;
        r103.setFactory(new a(r100));
    }

    public /* synthetic */ ShortVideoCommentAbilityView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
