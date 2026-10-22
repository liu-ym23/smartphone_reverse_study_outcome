package com.bytedance.android.live.revlink.impl.pk.vm.pk;

import androidx.lifecycle.LiveData;
import com.bytedance.android.livesdk.link.model.ITeamTask;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes47.dex */
public interface e {
    NextLiveData<Map<String, String>> getHandleFirstUpdateMessage();

    NextLiveData<ArrayList<String>> getHandlePkConsecutiveWin();

    NextLiveData<Boolean> getHandleTeamTaskOverLine();

    LiveData<ITeamTask> getPkTeamTask();

    LiveData<String> getPkTeamTaskLynxData();

    LiveData<g> getPkTeamTaskState();

    boolean getTopSecKillTrigger();

    void setTeamTaskRatio(float r100);
}
