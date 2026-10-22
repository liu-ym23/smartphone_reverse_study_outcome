package android.ss.com.vboost;

import android.content.Context;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public interface ISchedulerInitialConfigProvider {
    HashSet<Integer> getAllowedScenes();

    VboostListener.VboostApplogListener getApplogListener();

    Context getContext();

    Integer getLogLevel();

    Boolean getSwitch();

    VboostListener.SystemListener getSystemListener();
}
