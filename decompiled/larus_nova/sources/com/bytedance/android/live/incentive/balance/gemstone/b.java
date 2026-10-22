package com.bytedance.android.live.incentive.balance.gemstone;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.open.SocialConstants;
import java.util.List;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tR \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/incentive/balance/gemstone/b;", "Lvh7/c;", "", "Lcom/bytedance/android/live/incentive/balance/gemstone/b$a;", "getBalances", "()Ljava/util/List;", "getBalances$annotations", "()V", "balances", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface b extends c<b> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0011\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/incentive/balance/gemstone/b$a;", "Lvh7/c;", "", "getType", "()I", "getType$annotations", "()V", "type", "", "getAmount", "()J", "getAmount$annotations", "amount", "", "getDesc", "()Ljava/lang/String;", "getDesc$annotations", SocialConstants.PARAM_APP_DESC, "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    @ForMain
    public interface a extends c<a> {

        /* JADX INFO: renamed from: com.bytedance.android.live.incentive.balance.gemstone.b$a$a, reason: collision with other inner class name */
        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class C1126a {
        }

        @Override // vh7.c
        /* synthetic */ e castTo(Class r100);

        @Override // vh7.c
        /* synthetic */ e castToOrNull(Class r100);

        @FieldName(name = "amount")
        long getAmount();

        @FieldName(name = SocialConstants.PARAM_APP_DESC)
        String getDesc();

        @FieldName(name = "type")
        int getType();
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.incentive.balance.gemstone.b$b, reason: collision with other inner class name */
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class C1127b {
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "balances")
    List<a> getBalances();
}
