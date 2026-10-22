package com.bytedance.android.livesdk.revenue.vs;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"com/bytedance/android/livesdk/revenue/vs/RevPlayViewControl$Type", "", "Lcom/bytedance/android/livesdk/revenue/vs/RevPlayViewControl$Type;", "TOP", "BOTTOM", "LEFT", "RIGHT", UserProfileEvent.POSITION_NONE, "ALPHA", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RevPlayViewControl$Type extends Enum<RevPlayViewControl$Type> {
    public static final RevPlayViewControl$Type ALPHA = null;
    public static final RevPlayViewControl$Type BOTTOM = null;
    public static final RevPlayViewControl$Type LEFT = null;
    public static final RevPlayViewControl$Type NONE = null;
    public static final RevPlayViewControl$Type RIGHT = null;
    public static final RevPlayViewControl$Type TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RevPlayViewControl$Type[] f157548a = null;

    static {
        RevPlayViewControl$Type r100 = new RevPlayViewControl$Type("TOP", 0);
        TOP = r100;
        RevPlayViewControl$Type r101 = new RevPlayViewControl$Type("BOTTOM", 1);
        BOTTOM = r101;
        RevPlayViewControl$Type r102 = new RevPlayViewControl$Type("LEFT", 2);
        LEFT = r102;
        RevPlayViewControl$Type r103 = new RevPlayViewControl$Type("RIGHT", 3);
        RIGHT = r103;
        RevPlayViewControl$Type r104 = new RevPlayViewControl$Type(UserProfileEvent.POSITION_NONE, 4);
        NONE = r104;
        RevPlayViewControl$Type r105 = new RevPlayViewControl$Type("ALPHA", 5);
        ALPHA = r105;
        f157548a = new RevPlayViewControl$Type[]{r100, r101, r102, r103, r104, r105};
    }

    public static RevPlayViewControl$Type valueOf(String r100) {
        return (RevPlayViewControl$Type) a.a(RevPlayViewControl$Type.class, r100);
    }

    public static RevPlayViewControl$Type[] values() {
        return (RevPlayViewControl$Type[]) f157548a.clone();
    }

    public RevPlayViewControl$Type(String r100, int r101) {
        super(r100, r101);
    }
}
