package com.bytedance.android.livesdk.livecommerce.network.response;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPublicBottomScreenDataType;", "", "", "type", "I", "getType", "()I", UserProfileEvent.POSITION_NONE, "PRODUCT", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ECPublicBottomScreenDataType extends Enum<ECPublicBottomScreenDataType> {
    public static final ECPublicBottomScreenDataType NONE = null;
    public static final ECPublicBottomScreenDataType PRODUCT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ECPublicBottomScreenDataType[] f149503a = null;
    private final int type;

    static {
        ECPublicBottomScreenDataType r100 = new ECPublicBottomScreenDataType(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r100;
        ECPublicBottomScreenDataType r101 = new ECPublicBottomScreenDataType("PRODUCT", 1, 1);
        PRODUCT = r101;
        f149503a = new ECPublicBottomScreenDataType[]{r100, r101};
    }

    public static ECPublicBottomScreenDataType valueOf(String r100) {
        return (ECPublicBottomScreenDataType) a.a(ECPublicBottomScreenDataType.class, r100);
    }

    public static ECPublicBottomScreenDataType[] values() {
        return (ECPublicBottomScreenDataType[]) f149503a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public ECPublicBottomScreenDataType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
