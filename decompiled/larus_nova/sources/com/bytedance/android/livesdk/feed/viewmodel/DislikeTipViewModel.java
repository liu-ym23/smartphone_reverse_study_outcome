package com.bytedance.android.livesdk.feed.viewmodel;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.live.core.utils.rxutils.RxViewModel;
import com.bytedance.ies.utility.SharedPrefHelper;

/* JADX INFO: loaded from: classes8.dex */
public class DislikeTipViewModel extends RxViewModel {
    private static final String KEY_SHOW_DISLIKE_GUIDE = "HAVE_SHOW_DISLIKE_GUIDE";
    private static final int SHOW_DISLIKE_GUIDE_TIME = 10;
    private boolean allowShowDislike;
    private Context appContext;
    private boolean haveShowDislikeGuide;
    private int scrollStartPos;

    public void onLeave() {
        this.scrollStartPos = -1;
    }

    private void init() {
        this.haveShowDislikeGuide = SharedPrefHelper.c(this.appContext, "ttlive_live_user").f(KEY_SHOW_DISLIKE_GUIDE, false);
    }

    public void onScrollStart(RecyclerView r100) {
        if (this.allowShowDislike == false) goto L17;
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.haveShowDislikeGuide == false) goto L9;
        return;
    L9:
        if (this.scrollStartPos != (-1)) goto L19;
        RecyclerView.LayoutManager r101 = r100.getLayoutManager();
        if ((r101 instanceof StaggeredGridLayoutManager) == false) goto L14;
        this.scrollStartPos = ((StaggeredGridLayoutManager) r101).findLastVisibleItemPositions(null)[0];
        return;
    L14:
        if ((r101 instanceof GridLayoutManager) == false) goto L21;
        this.scrollStartPos = ((GridLayoutManager) r101).findLastVisibleItemPosition();
        return;
    L21:
        return;
    L19:
        return;
    }

    public boolean onScrollStop(RecyclerView r100) {
        if (this.allowShowDislike == false) goto L24;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this.haveShowDislikeGuide == false) goto L9;
        return false;
    L9:
        if (this.scrollStartPos == (-1)) goto L27;
        RecyclerView.LayoutManager r101 = r100.getLayoutManager();
        if ((r101 instanceof StaggeredGridLayoutManager) == false) goto L16;
        int[] r102 = ((StaggeredGridLayoutManager) r101).findLastVisibleItemPositions(null);
        if (r102.length <= 1) goto L18;
        int r103 = r102[1];
    L19:
        if (r103 >= 0) goto L21;
        return false;
    L21:
        if ((r103 - this.scrollStartPos) <= 10) goto L29;
        this.scrollStartPos = -1;
        SharedPrefHelper r104 = SharedPrefHelper.c(this.appContext, "ttlive_live_user");
        r104.l(KEY_SHOW_DISLIKE_GUIDE, Boolean.TRUE);
        r104.a();
        this.haveShowDislikeGuide = true;
        return true;
    L29:
        return false;
    L18:
        r103 = -1;
        goto L19
    L16:
        if ((r101 instanceof GridLayoutManager) == false) goto L18;
        r103 = ((GridLayoutManager) r101).findLastVisibleItemPosition();
        goto L19
    L27:
        return false;
    L24:
        return false;
    }

    public DislikeTipViewModel(com.bytedance.android.livesdk.feed.j r100, long r101, Context r102) {
        r100.d(r101);
        this.allowShowDislike = false;
        this.appContext = r102;
        init();
    }
}
