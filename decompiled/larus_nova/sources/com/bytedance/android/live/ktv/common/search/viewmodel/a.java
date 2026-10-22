package com.bytedance.android.live.ktv.common.search.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.ktv.common.model.api.s;
import com.bytedance.android.live.ktv.common.model.api.u;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes45.dex */
public interface a {
    void continueSearch(String r100, String r101, Function1<? super Boolean, Unit> r102);

    void doSearch(String r100, boolean r101, String r102, boolean r103);

    com.bytedance.android.live.ktv.common.ordersong.feedback.a getCurPredicateContent();

    String getCurSearchInitText();

    String getCurSearchKeyword();

    xb0.a getExtraRequestData();

    String getSearchContentType();

    List<MusicPanel> getSearchedMusicList();

    boolean hasMoreSearchResult();

    void loadSearchHistory();

    void observeGuessWordListChange(LifecycleOwner r100, Observer<List<s>> r101);

    void observeHistoryListChange(LifecycleOwner r100, Observer<List<String>> r101);

    void observeHotWordListChange(LifecycleOwner r100, Observer<List<u>> r101);

    void observeSearchedMusicListChange(LifecycleOwner r100, Observer<List<MusicPanel>> r101);

    void onHotWordClick(String r100, boolean r101);

    void removeSearchHistory(String r100);

    void syncGuessWords(String r100);

    void syncHotWords();

    void updateCurSearchKeyword(String r100);

    void updateExtraRequestData(xb0.a r100);

    void updateHistoryCountPerPage(int r100);

    void updatePredicateContent(com.bytedance.android.live.ktv.common.ordersong.feedback.a r100);

    void updateSearchInitText(String r100);

    void updateSearchedMusicList(List<MusicPanel> r100);
}
