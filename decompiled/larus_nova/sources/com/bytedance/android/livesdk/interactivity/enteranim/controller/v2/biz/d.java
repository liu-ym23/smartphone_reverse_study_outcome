package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz;

import com.google.gson.annotations.SerializedName;
import com.obric.aiagent.messenger.stub.FlowNetworkIDLStub;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/enteranim/controller/v2/biz/d;", "", "", "Lcom/bytedance/android/livesdk/interactivity/enteranim/controller/v2/biz/c;", FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY, "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "<init>", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName(FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY)
    private final List<c> configs;

    public d() {
    }

    public final List<c> a() {
        return this.configs;
    }
}
