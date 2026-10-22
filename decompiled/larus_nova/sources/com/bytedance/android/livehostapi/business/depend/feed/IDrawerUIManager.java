package com.bytedance.android.livehostapi.business.depend.feed;

import android.view.View;
import android.view.ViewGroup;
import com.alibaba.gaiax.model.GXScroll;
import com.bytedance.android.live.base.model.feed.FeedItem;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH&J\u001a\u0010\u000b\u001a\u00020\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH&J2\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J*\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\b\u0010\u0014\u001a\u00020\u0011H&¨\u0006\u0015À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/feed/IDrawerUIManager;", "", "initContentLayout", "", "contentView", "Landroid/view/View;", "needExtraItemPadding", "", "dataList", "", "Lcom/bytedance/android/live/base/model/feed/FeedItem;", "onDrawerDataChanged", GXScroll.TYPE_ON_SCROLL_STATE_CHANGED, "slideUp", "recyclerView", "Landroid/view/ViewGroup;", "newState", "", "onTabSelect", "reachTop", "panelSize", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IDrawerUIManager {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.depend.feed.IDrawerUIManager$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void onDrawerDataChanged$default(IDrawerUIManager r100, List r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L6;
            r101 = null;
        L6:
            r100.onDrawerDataChanged(r101);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onDrawerDataChanged");
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void onDrawerDataChanged$default(IDrawerUIManager r100, List r101, int r102, Object r103) {
            CC.onDrawerDataChanged$default(r100, r101, r102, r103);
        }
    }

    void initContentLayout(View r100);

    boolean needExtraItemPadding(List<? extends FeedItem> r100);

    void onDrawerDataChanged(List<? extends FeedItem> r100);

    void onScrollStateChanged(boolean r100, List<? extends FeedItem> r101, ViewGroup r102, int r103);

    void onTabSelect(boolean r100, List<? extends FeedItem> r101, ViewGroup r102);

    int panelSize();
}
