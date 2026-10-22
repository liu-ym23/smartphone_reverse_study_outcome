package com.stepos.alphame.persona.common.list;

import R1.a;
import com.stepos.alphame.persona.PersonalContract;
import com.stepos.alphame.persona.data.repo.PersonalRepo;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/stepos/alphame/persona/common/list/PersonalCommonRequester;", "LR1/a;", "", "requestDataList", "()V", "", "autoLearningState", "Z", PersonalContract.FUN_GET_AUTO_LEARNING_STATE, "()Z", "<init>", "app_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public abstract class PersonalCommonRequester extends a {
    private final boolean autoLearningState = PersonalRepo.INSTANCE.getINSTANCE().getAutoLearningState();

    public final boolean getAutoLearningState() {
        return this.autoLearningState;
    }

    public abstract void requestDataList();
}
