package com.obric.common.oea.style.scene.alpha.alphaplayer.controller;

import android.view.View;
import android.view.ViewGroup;
import com.obric.common.oea.style.scene.alpha.alphaplayer.IMonitor;
import com.obric.common.oea.style.scene.alpha.alphaplayer.IPlayerAction;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.DataSource;
import kotlin.Metadata;

/* JADX INFO: compiled from: IPlayerController.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH&J\b\u0010\u001b\u001a\u00020\u0003H&¨\u0006\u001c"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/controller/IPlayerController;", "", "attachAlphaView", "", "parentView", "Landroid/view/ViewGroup;", "detachAlphaView", "getPlayerType", "", "getView", "Landroid/view/View;", "pause", "release", "reset", "resume", "setMonitor", "monitor", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/IMonitor;", "setPlayerAction", "playerAction", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/IPlayerAction;", "setVisibility", "visibility", "", "start", "dataSource", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/DataSource;", "stop", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public interface IPlayerController {
    void attachAlphaView(ViewGroup r1);

    void detachAlphaView(ViewGroup r1);

    String getPlayerType();

    View getView();

    void pause();

    void release();

    void reset();

    void resume();

    void setMonitor(IMonitor r1);

    void setPlayerAction(IPlayerAction r1);

    void setVisibility(int r1);

    void start(DataSource r1);

    void stop();
}
