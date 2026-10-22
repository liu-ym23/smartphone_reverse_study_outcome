package com.bytedance.android.ec.hybrid.card.data;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/hybrid/card/data/MallLynxGroupLevel;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", UserProfileEvent.POSITION_NONE, "SHARE_DATA", "SHARE_DATA_WHITEBOARD", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum MallLynxGroupLevel extends Enum<MallLynxGroupLevel> {
    public static final MallLynxGroupLevel NONE = null;
    public static final MallLynxGroupLevel SHARE_DATA = null;
    public static final MallLynxGroupLevel SHARE_DATA_WHITEBOARD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MallLynxGroupLevel[] f46469a = null;
    private final String value;

    static {
        MallLynxGroupLevel r100 = new MallLynxGroupLevel(UserProfileEvent.POSITION_NONE, 0, "none");
        NONE = r100;
        MallLynxGroupLevel r101 = new MallLynxGroupLevel("SHARE_DATA", 1, "share_data");
        SHARE_DATA = r101;
        MallLynxGroupLevel r102 = new MallLynxGroupLevel("SHARE_DATA_WHITEBOARD", 2, "share_data_whiteboard");
        SHARE_DATA_WHITEBOARD = r102;
        f46469a = new MallLynxGroupLevel[]{r100, r101, r102};
    }

    public static MallLynxGroupLevel valueOf(String r100) {
        return (MallLynxGroupLevel) a.a(MallLynxGroupLevel.class, r100);
    }

    public static MallLynxGroupLevel[] values() {
        return (MallLynxGroupLevel[]) f46469a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public MallLynxGroupLevel(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
