package aeb;

import android.view.View;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.action.ActionScene;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionStatus;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionType;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public interface f {
    void a(UIFeedCard r100);

    void b(FeedActionType r100, FeedActionStatus r101, UIFeedCard r102);

    List<c> c();

    List<FeedActionType> e(UIFeedCard r100);

    List<FeedActionType> f(UIFeedCard r100);

    void g(UIFeedCard r100);

    List<FeedActionType> h(UIFeedCard r100);

    void j(UIFeedCard r100, View r101, int r102, ActionScene r103);

    List<FeedActionType> k(UIFeedCard r100);

    void l(UIFeedCard r100);

    List<FeedActionType> n(UIFeedCard r100);
}
