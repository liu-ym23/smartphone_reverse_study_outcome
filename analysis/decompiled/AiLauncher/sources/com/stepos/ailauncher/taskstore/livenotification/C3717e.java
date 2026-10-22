package com.stepos.ailauncher.taskstore.livenotification;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.model.search.SessionActivityState;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import com.stepos.ailauncher.taskstore.entity.TaskInfoStatus;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u000e\u001a\u00020\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/ailauncher/taskstore/livenotification/e;", "", "<init>", "()V", "", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "cards", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;)Ljava/util/List;", "failedCards", "Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;", "livePhase", "", "postedFailed", Const.INTENT_KEY_PKGNAME, "(Ljava/util/List;Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;Z)Z", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.taskstore.livenotification.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3717e {
    public static final C3717e INSTANCE = new C3717e();

    public final List<TaskInfoCard> a(List<TaskInfoCard> cards) {
        kotlin.jvm.internal.p.i(cards, "cards");
        ArrayList arrayList = new ArrayList();
        for (Object obj : cards) {
            if (((TaskInfoCard) obj).getStatus() == TaskInfoStatus.FAILED) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final boolean b(List<TaskInfoCard> failedCards, SessionActivityState livePhase, boolean postedFailed) {
        kotlin.jvm.internal.p.i(failedCards, "failedCards");
        return !failedCards.isEmpty() || livePhase == SessionActivityState.FAILED || postedFailed;
    }
}
