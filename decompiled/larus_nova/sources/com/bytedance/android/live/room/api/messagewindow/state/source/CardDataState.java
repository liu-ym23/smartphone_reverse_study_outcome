package com.bytedance.android.live.room.api.messagewindow.state.source;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/room/api/messagewindow/state/source/CardDataState;", "", ErrorCode.INIT, "SHOW", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CardDataState extends Enum<CardDataState> {
    public static final CardDataState INIT = null;
    public static final CardDataState SHOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CardDataState[] f99037a = null;

    static {
        CardDataState r100 = new CardDataState(ErrorCode.INIT, 0);
        INIT = r100;
        CardDataState r101 = new CardDataState("SHOW", 1);
        SHOW = r101;
        f99037a = new CardDataState[]{r100, r101};
    }

    public static CardDataState valueOf(String r100) {
        return (CardDataState) a.a(CardDataState.class, r100);
    }

    public static CardDataState[] values() {
        return (CardDataState[]) f99037a.clone();
    }

    public CardDataState(String r100, int r101) {
        super(r100, r101);
    }
}
