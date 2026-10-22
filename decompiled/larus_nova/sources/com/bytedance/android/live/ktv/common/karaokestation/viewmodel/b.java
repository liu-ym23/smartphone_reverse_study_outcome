package com.bytedance.android.live.ktv.common.karaokestation.viewmodel;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.karaokestation.model.UpdateTabType;
import com.bytedance.android.live.ktv.common.karaokestation.model.d;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.livesdk.config.t61;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.utils.MultiLinkSettingHelper;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes45.dex */
public interface b {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(b r110, long r111, int r210, String r211, int r212, long r213, long r214, boolean r215, String r216, Function1 r217, int r310) {
            if ((r310 & 16) == 0) goto L5;
            long r112 = 0;
        L7:
            if ((r310 & 32) == 0) goto L9;
            long r113 = 0;
        L11:
            if ((r310 & 64) == 0) goto L13;
            boolean r114 = false;
        L15:
            if ((r310 & 128) == 0) goto L17;
            String r115 = null;
        L19:
            if ((r310 & 256) == 0) goto L21;
            Function1 r116 = null;
        L22:
            r110.syncSecondLevelTabList(r111, r210, r211, r212, r112, r113, r114, r115, r116);
            return;
        L21:
            r116 = r217;
            goto L22
        L17:
            r115 = r216;
            goto L19
        L13:
            r114 = r215;
            goto L15
        L9:
            r113 = r214;
            goto L11
        L5:
            r112 = r213;
            goto L7
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static void b(b r110, long r111, boolean r112, int r113, int r210, y r211, long r212, long r213, String r214, Function1 r215, int r216) {
            if ((r216 & 4) == 0) goto L5;
            int r100 = ((t61) MultiLinkSettingHelper.f158771a.getValue()).L6();
        L7:
            if ((r216 & 32) == 0) goto L9;
            long r101 = 0;
        L11:
            if ((r216 & 64) == 0) goto L13;
            long r114 = 0;
        L15:
            if ((r216 & 128) == 0) goto L17;
            String r115 = null;
        L19:
            if ((r216 & 256) == 0) goto L21;
            Function1 r116 = null;
        L22:
            r110.syncSecondLevelTabSongList(r111, r112, r100, r210, r211, r101, r114, r115, r116);
            return;
        L21:
            r116 = r215;
            goto L22
        L17:
            r115 = r214;
            goto L19
        L13:
            r114 = r213;
            goto L15
        L9:
            r101 = r212;
            goto L11
        L5:
            r100 = r113;
            goto L7
        }
    }

    void addFavorite(MusicPanel r100, ic0.a r101);

    void addSong(Context r100, MusicPanel r101, RecyclerView.ViewHolder r102);

    void clearData();

    void delFavorite(MusicPanel r100, ic0.a r101);

    int getCurTabMode();

    d getFirstLevelTabDataByTopValue(int r100);

    y getSecondLevelTabDataByParams(int r100, String r101);

    List<y> getSecondLevelTabDataList(int r100);

    Pair<Integer, UpdateTabType> getSelectedFirstLevelTabValue();

    y getSelectedSecondLevelTabData(int r100);

    void observeSelectedFirstLevelTabValueChange(LifecycleOwner r100, Observer<Pair<Integer, UpdateTabType>> r101);

    void observeSongListDataChange(LifecycleOwner r100, Observer<y> r101);

    void observeTabListDataChange(LifecycleOwner r100, Observer<Pair<d, List<y>>> r101);

    void observeTabListStateChange(LifecycleOwner r100, Observer<List<y>> r101);

    void syncSecondLevelTabList(long r100, int r101, String r102, int r103, long r104, long r105, boolean r110, String r111, Function1<? super Boolean, Unit> r112);

    void syncSecondLevelTabSongList(long r100, boolean r101, int r102, int r103, y r104, long r105, long r106, String r110, Function1<? super Boolean, Unit> r111);

    void updateSecondLevelTabListState(y r100);

    void updateSecondLevelTabListState(y r100, boolean r101);

    void updateSelectFirstLevelTabValue(int r100, UpdateTabType r101);

    void updateSongListData(y r100);

    void updateTabListData(d r100);
}
