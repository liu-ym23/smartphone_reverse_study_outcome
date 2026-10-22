package com.bytedance.android.livesdk.chatroom.msgboard;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.n;
import io.reactivex.Observable;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes7.dex */
public interface a {
    n<String> getCommentLikeRelation();

    j<VSMsgBoardCommentListSyncDataModel> getCommentListDataSyncModel();

    Episode getEpisode();

    j<String> getExtra();

    Observable<String> getInteractDressInfo();

    Observable<List<String>> getMessageBoardSelfComment();

    Set<String> getPaidEntityIds();

    String getPayScheme();

    boolean getRequestDressAlready();

    IRoom getRoom();

    String getVsMsgBoardDressInfo();

    List<String> getVsMsgSelfCommentData();

    void setPaidStatusChanged(boolean r100);

    void setRequestDressInfoFailed(boolean r100);
}
