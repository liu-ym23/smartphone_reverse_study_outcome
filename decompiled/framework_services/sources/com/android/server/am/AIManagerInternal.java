package com.android.server.am;

import com.zte.ai.NameScore;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface AIManagerInternal {
    List<String> getAIPredictAppResult(String r1, int r2);

    List<NameScore> getAIPredictNameScoreInner(String r1);

    AIPredictResultInfo getAIPredictRawResultInner(String r1);

    List<String> getNextPredictAppsInner();

    String getStatusInner(String r1);

    int getVersionInner();

    boolean isAIPredictEnableInner();

    boolean isReliableLoactionInner(String r1);

    void reportUsageEventInner(int r1, int r2, long r3, String r5, String r6, String r7, Object r8);

    void updateDataInner();
}
