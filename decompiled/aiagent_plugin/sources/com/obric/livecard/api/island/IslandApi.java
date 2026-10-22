package com.obric.livecard.api.island;

import android.content.Context;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.entity.IslandWidget;
import com.obric.livecard.api.impl.OnTopCardChangedListener;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.x;

/* JADX INFO: compiled from: IslandApi.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface IslandApi {

    /* JADX INFO: compiled from: IslandApi.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void tryExpand$default(IslandApi r2, IslandSession r3, Boolean r4, int r5, Object r6) {
            IslandApi r7 = (IslandApi) ZeusTransformUtils.wrapperContextForParams(r2, IslandApi.class, "com.obric.aiagent.plugin");
            if (r6 != null) goto L10;
            if ((r5 & 2) == 0) goto L7;
            r4 = null;
        L7:
            r7.tryExpand(r3, r4);
            return;
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryExpand");
        }
    }

    void addOnTopCardChangedListener(OnTopCardChangedListener r1);

    void collapseIsland();

    boolean createSession(IslandSession r1, Context r2);

    void destroySession(IslandSession r1);

    int getIslandVersion();

    Object getPriority(IslandSession r1, d<? super Long> r2);

    void removeOnTopCardChangedListener(OnTopCardChangedListener r1);

    void sendEvent(IslandSession r1, IslandWidget r2, String r3, String r4);

    void setPriority(IslandSession r1, long r2);

    void tryExpand(IslandSession r1, Boolean r2);

    Object updateAnimation(IslandSession r1, IslandWidget r2, d<? super x> r3);

    void updateSessionFlags(IslandSession r1);

    void updateWidget(IslandSession r1, IslandWidget r2);
}
