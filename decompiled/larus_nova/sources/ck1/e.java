package ck1;

import android.os.Bundle;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.livehostapi.business.depend.rerank.IReRankWebcastRoomFragmentPanel;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragment;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.distribution.ExternalRoomExitReason;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListProvider;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes7.dex */
public interface e extends IAbility {
    void Ho(FeedItem r100, Room r101, Bundle r102, long r103);

    void Jg();

    void Uk(boolean r100);

    ILiveRoomPlayFragment cq();

    ILiveRoomPlayFragment getCurrentFragment();

    int getCurrentItem();

    List<FeedItem> getFeedItems();

    void insertFeedItem(FeedItem r100, Room r101, Bundle r102, Long r103, int r104, Function1<? super Boolean, Unit> r105);

    void je(boolean r100);

    void removeCurrentRoom(long r100, ExternalRoomExitReason r101);

    void removeFeedItem(FeedItem r100);

    void removeRoom(long r100);

    void replaceFeedItems(int r100, List<? extends FeedItem> r101, List<? extends FeedItem> r102, IReRankWebcastRoomFragmentPanel.Callback r103);

    void rn();

    ILiveRoomListProvider s5();

    ILiveRoomPlayFragment te();

    void th();

    void updateEnterRoomMonitor();
}
