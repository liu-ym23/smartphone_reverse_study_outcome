package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.minigame.SeiMessageConst;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/r9;", "Lvh7/c;", "", "getMsgType", "()I", "getMsgType$annotations", "()V", "msgType", "Lcom/bytedance/android/livesdk/message/model/z9;", "getEggInfo", "()Lcom/bytedance/android/livesdk/message/model/z9;", "getEggInfo$annotations", "eggInfo", "Lcom/bytedance/android/livesdk/message/model/p9;", "getContributeContent", "()Lcom/bytedance/android/livesdk/message/model/p9;", "getContributeContent$annotations", "contributeContent", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface r9 extends vh7.c<r9> {
    public static final a Companion = null;
    public static final int TypeProfitEgg_Contribute = 6;
    public static final int TypeProfitEgg_Create = 1;
    public static final int TypeProfitEgg_Finish = 5;
    public static final int TypeProfitEgg_Settle = 4;
    public static final int TypeProfitEgg_Start = 2;
    public static final int TypeProfitEgg_Unknown = 0;
    public static final int TypeProfitEgg_Update = 3;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f153695a = null;

        public a() {
        }

        static {
            f153695a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.f153695a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "contribute_content")
    p9 getContributeContent();

    @FieldName(name = "egg_info")
    z9 getEggInfo();

    @FieldName(name = SeiMessageConst.MSG_TYPE)
    int getMsgType();
}
