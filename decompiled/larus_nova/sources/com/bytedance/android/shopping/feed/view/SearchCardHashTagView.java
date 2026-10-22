package com.bytedance.android.shopping.feed.view;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.ec.core.widget.flow.TagFlowLayout;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012R(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/feed/view/SearchCardHashTagView;", "Lcom/bytedance/android/ec/core/widget/flow/TagFlowLayout;", "", "", OfficeSDKRequestTag.KEY_NEW_USER, "Ljava/util/List;", "getRemainedKeywordList", "()Ljava/util/List;", "setRemainedKeywordList", "(Ljava/util/List;)V", "remainedKeywordList", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchCardHashTagView extends TagFlowLayout {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<String> f175602n;

    public SearchCardHashTagView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SearchCardHashTagView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final List<String> getRemainedKeywordList() {
        return this.f175602n;
    }

    public final void setRemainedKeywordList(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f175602n = r100;
    }

    public SearchCardHashTagView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f175602n = new ArrayList();
    }

    public /* synthetic */ SearchCardHashTagView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
