package com.android.server.permission.access.appop;

import com.android.modules.utils.BinaryXmlPullParser;
import com.android.modules.utils.BinaryXmlSerializer;
import com.android.server.permission.access.AccessState;
import com.android.server.permission.access.MutableAccessState;
import com.android.server.permission.access.SchemePolicy;

/* JADX INFO: compiled from: BaseAppOpPolicy.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseAppOpPolicy extends SchemePolicy {
    private final BaseAppOpPersistence persistence;

    public BaseAppOpPolicy(BaseAppOpPersistence persistence) {
        this.persistence = persistence;
    }

    @Override // com.android.server.permission.access.SchemePolicy
    public String getObjectScheme() {
        return "app-op";
    }

    @Override // com.android.server.permission.access.SchemePolicy
    public void parseUserState(BinaryXmlPullParser $this$parseUserState, MutableAccessState state, int userId) {
        BaseAppOpPersistence $this$parseUserState_u24lambda_u240 = this.persistence;
        $this$parseUserState_u24lambda_u240.parseUserState($this$parseUserState, state, userId);
    }

    @Override // com.android.server.permission.access.SchemePolicy
    public void serializeUserState(BinaryXmlSerializer $this$serializeUserState, AccessState state, int userId) {
        BaseAppOpPersistence $this$serializeUserState_u24lambda_u241 = this.persistence;
        $this$serializeUserState_u24lambda_u241.serializeUserState($this$serializeUserState, state, userId);
    }
}
