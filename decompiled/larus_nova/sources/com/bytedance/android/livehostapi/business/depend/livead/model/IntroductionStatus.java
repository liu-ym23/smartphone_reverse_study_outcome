package com.bytedance.android.livehostapi.business.depend.livead.model;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/livead/model/IntroductionStatus;", "", "()V", GXAnimation.STATE_START, "", "getSTART", "()I", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntroductionStatus {
    public static final IntroductionStatus INSTANCE = null;
    private static final int START = 0;

    private IntroductionStatus() {
    }

    static {
        INSTANCE = new IntroductionStatus();
        START = 1;
    }

    public final int getSTART() {
        return START;
    }
}
