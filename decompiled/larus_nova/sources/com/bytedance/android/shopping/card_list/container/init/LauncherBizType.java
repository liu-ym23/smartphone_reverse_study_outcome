package com.bytedance.android.shopping.card_list.container.init;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/card_list/container/init/LauncherBizType;", "", UserProfileEvent.POSITION_NONE, "CART", "COLLECT", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LauncherBizType extends Enum<LauncherBizType> {
    public static final LauncherBizType CART = null;
    public static final LauncherBizType COLLECT = null;
    public static final LauncherBizType NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LauncherBizType[] f171550a = null;

    static {
        LauncherBizType r100 = new LauncherBizType(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        LauncherBizType r101 = new LauncherBizType("CART", 1);
        CART = r101;
        LauncherBizType r102 = new LauncherBizType("COLLECT", 2);
        COLLECT = r102;
        f171550a = new LauncherBizType[]{r100, r101, r102};
    }

    public static LauncherBizType valueOf(String r100) {
        return (LauncherBizType) r27.a.a(LauncherBizType.class, r100);
    }

    public static LauncherBizType[] values() {
        return (LauncherBizType[]) f171550a.clone();
    }

    public LauncherBizType(String r100, int r101) {
        super(r100, r101);
    }
}
