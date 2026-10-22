package com.bytedance.android.livehostapi.business.depend.rerank;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/rerank/WebcastReRankConstants;", "", "()V", "ROOM_TYPE_DEFAULT", "", "getROOM_TYPE_DEFAULT", "()I", "ROOM_TYPE_IS_CARD_ROOM", "getROOM_TYPE_IS_CARD_ROOM", "ROOM_TYPE_IS_GAME_PROM", "getROOM_TYPE_IS_GAME_PROM", "ROOM_TYPE_IS_MIC", "getROOM_TYPE_IS_MIC", "ROOM_TYPE_IS_MINI_PROG", "getROOM_TYPE_IS_MINI_PROG", "ROOM_TYPE_IS_PK", "getROOM_TYPE_IS_PK", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WebcastReRankConstants {
    public static final WebcastReRankConstants INSTANCE = null;
    private static final int ROOM_TYPE_DEFAULT = 0;
    private static final int ROOM_TYPE_IS_CARD_ROOM = 0;
    private static final int ROOM_TYPE_IS_GAME_PROM = 0;
    private static final int ROOM_TYPE_IS_MIC = 0;
    private static final int ROOM_TYPE_IS_MINI_PROG = 0;
    private static final int ROOM_TYPE_IS_PK = 0;

    private WebcastReRankConstants() {
    }

    static {
        INSTANCE = new WebcastReRankConstants();
        ROOM_TYPE_IS_PK = 1;
        ROOM_TYPE_IS_MIC = 2;
        ROOM_TYPE_IS_GAME_PROM = 3;
        ROOM_TYPE_IS_MINI_PROG = 4;
        ROOM_TYPE_IS_CARD_ROOM = 5;
    }

    public final int getROOM_TYPE_DEFAULT() {
        return ROOM_TYPE_DEFAULT;
    }

    public final int getROOM_TYPE_IS_CARD_ROOM() {
        return ROOM_TYPE_IS_CARD_ROOM;
    }

    public final int getROOM_TYPE_IS_GAME_PROM() {
        return ROOM_TYPE_IS_GAME_PROM;
    }

    public final int getROOM_TYPE_IS_MIC() {
        return ROOM_TYPE_IS_MIC;
    }

    public final int getROOM_TYPE_IS_MINI_PROG() {
        return ROOM_TYPE_IS_MINI_PROG;
    }

    public final int getROOM_TYPE_IS_PK() {
        return ROOM_TYPE_IS_PK;
    }
}
