package com.bytedance.android.livesdk.message.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u0003:\u0001\u0013R\u0014\u0010\u0007\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u000b\u001a\u00020\u00048&@&X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\nR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\f8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/q7;", "Lvh7/c;", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "", "getMsgType", "()J", "msgType", "getMinConsumeLevel", "setMinConsumeLevel", "(J)V", "minConsumeLevel", "Lcom/bytedance/android/livesdk/gift/model/a2;", "getSceneInsertStrategy", "()Lcom/bytedance/android/livesdk/gift/model/a2;", "setSceneInsertStrategy", "(Lcom/bytedance/android/livesdk/gift/model/a2;)V", "sceneInsertStrategy", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface q7 extends vh7.c<q7>, yh6.c {
    public static final a Companion = null;
    public static final int MessageTypeConsumeLevelSceneStrategy = 4;
    public static final int MessageTypeGiftSortAll = 1;
    public static final int MessageTypeGiftSortConsumeLevel = 2;
    public static final int MessageTypeSceneStrategy = 3;
    public static final int MessageTypeUnknown = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f153683a = null;

        public a() {
        }

        static {
            f153683a = new a();
        }
    }

    static {
        Companion = a.f153683a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @Override // yh6.c
    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    long getMinConsumeLevel();

    long getMsgType();

    com.bytedance.android.livesdk.gift.model.a2 getSceneInsertStrategy();

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r100);

    void setMinConsumeLevel(long r100);

    void setSceneInsertStrategy(com.bytedance.android.livesdk.gift.model.a2 r100);
}
