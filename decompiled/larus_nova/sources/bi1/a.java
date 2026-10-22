package bi1;

import android.os.Bundle;
import ck1.e;
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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public class a implements e {
    public a() {
    }

    @Override // ck1.e
    public final void Ho(FeedItem r100, Room r101, Bundle r102, long r103) {
    }

    @Override // ck1.e
    public final void Jg() {
    }

    @Override // ck1.e
    public final void Uk(boolean r100) {
    }

    @Override // ck1.e
    public final ILiveRoomPlayFragment cq() {
        return null;
    }

    @Override // ck1.e
    public final int getCurrentItem() {
        return 0;
    }

    @Override // ck1.e
    public final List<FeedItem> getFeedItems() {
        return null;
    }

    @Override // ck1.e
    public final void insertFeedItem(FeedItem r100, Room r101, Bundle r102, Long r103, int r104, Function1<? super Boolean, Unit> r105) {
    }

    @Override // ck1.e
    public final void je(boolean r100) {
    }

    @Override // com.bytedance.android.livesdk.ability.IAbility
    public final /* synthetic */ void onAbilityClear() {
        IAbility.CC.$default$onAbilityClear(this);
    }

    @Override // ck1.e
    public final void removeCurrentRoom(long r100, ExternalRoomExitReason r101) {
    }

    @Override // ck1.e
    public final void removeFeedItem(FeedItem r100) {
    }

    @Override // ck1.e
    public final void removeRoom(long r100) {
    }

    @Override // ck1.e
    public final void replaceFeedItems(int r100, List<? extends FeedItem> r101, List<? extends FeedItem> r102, IReRankWebcastRoomFragmentPanel.Callback r103) {
        Intrinsics.checkNotNullParameter(r103, "callback");
    }

    @Override // ck1.e
    public final void rn() {
    }

    @Override // ck1.e
    public final ILiveRoomListProvider s5() {
        return null;
    }

    @Override // ck1.e
    public final ILiveRoomPlayFragment te() {
        return null;
    }

    @Override // ck1.e
    public final void th() {
    }

    @Override // ck1.e
    public final void updateEnterRoomMonitor() {
    }
}
