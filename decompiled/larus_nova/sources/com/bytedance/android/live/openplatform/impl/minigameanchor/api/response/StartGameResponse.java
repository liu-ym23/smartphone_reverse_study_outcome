package com.bytedance.android.live.openplatform.impl.minigameanchor.api.response;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigameanchor/api/response/StartGameResponse;", "", "", "startId", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setStartId", "(Ljava/lang/String;)V", "appId", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setAppId", "", "cardSetStatus", "I", "b", "()I", "setCardSetStatus", "(I)V", "<init>", "()V", "CardSetStatus", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StartGameResponse {

    @SerializedName(BdpAppEventConstant.PARAMS_MP_ID)
    private String appId;

    @SerializedName("card_set_status")
    private int cardSetStatus;

    @SerializedName("start_id")
    private String startId;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigameanchor/api/response/StartGameResponse$CardSetStatus;", "", "", "status", "I", "getStatus", "()I", "Success", "Failed", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum CardSetStatus extends Enum<CardSetStatus> {
        public static final CardSetStatus Failed = null;
        public static final CardSetStatus Success = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CardSetStatus[] f85093a = null;
        private final int status;

        static {
            CardSetStatus r100 = new CardSetStatus("Success", 0, 1);
            Success = r100;
            CardSetStatus r101 = new CardSetStatus("Failed", 1, 2);
            Failed = r101;
            f85093a = new CardSetStatus[]{r100, r101};
        }

        public static CardSetStatus valueOf(String r100) {
            return (CardSetStatus) a.a(CardSetStatus.class, r100);
        }

        public static CardSetStatus[] values() {
            return (CardSetStatus[]) f85093a.clone();
        }

        public final int getStatus() {
            return this.status;
        }

        public CardSetStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.status = r102;
        }
    }

    public StartGameResponse() {
        this.startId = "";
        this.appId = "";
    }

    public final String a() {
        return this.appId;
    }

    public final int b() {
        return this.cardSetStatus;
    }

    public final String c() {
        return this.startId;
    }
}
