package com.bytedance.android.livesdk.gift.platform.core.model;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/model/SeriesSendType;", "", UserProfileEvent.POSITION_NONE, AccountType.ALL, "SINGLE", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SeriesSendType extends Enum<SeriesSendType> {
    public static final SeriesSendType ALL = null;
    public static final SeriesSendType NONE = null;
    public static final SeriesSendType SINGLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SeriesSendType[] f130830a = null;

    static {
        SeriesSendType r100 = new SeriesSendType(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        SeriesSendType r101 = new SeriesSendType(AccountType.ALL, 1);
        ALL = r101;
        SeriesSendType r102 = new SeriesSendType("SINGLE", 2);
        SINGLE = r102;
        f130830a = new SeriesSendType[]{r100, r101, r102};
    }

    public static SeriesSendType valueOf(String r100) {
        return (SeriesSendType) r27.a.a(SeriesSendType.class, r100);
    }

    public static SeriesSendType[] values() {
        return (SeriesSendType[]) f130830a.clone();
    }

    public SeriesSendType(String r100, int r101) {
        super(r100, r101);
    }
}
