package com.bytedance.android.ec.common.api.abilities;

import com.alibaba.gaiax.model.GXAnimation;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/common/api/abilities/SecKillActivityType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", UserProfileEvent.POSITION_NONE, "PRE_SECKILL", "SECKILL", GXAnimation.STATE_END, "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public final enum SecKillActivityType extends Enum<SecKillActivityType> {
    public static final SecKillActivityType END = null;
    public static final SecKillActivityType NONE = null;
    public static final SecKillActivityType PRE_SECKILL = null;
    public static final SecKillActivityType SECKILL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SecKillActivityType[] f42824a = null;
    private final String value;

    static {
        SecKillActivityType r100 = new SecKillActivityType(UserProfileEvent.POSITION_NONE, 0, "");
        NONE = r100;
        SecKillActivityType r101 = new SecKillActivityType("PRE_SECKILL", 1, a.VALUE_PRE_SECKILL);
        PRE_SECKILL = r101;
        SecKillActivityType r102 = new SecKillActivityType("SECKILL", 2, "seckill");
        SECKILL = r102;
        SecKillActivityType r103 = new SecKillActivityType(GXAnimation.STATE_END, 3, "");
        END = r103;
        f42824a = new SecKillActivityType[]{r100, r101, r102, r103};
    }

    public static SecKillActivityType valueOf(String r100) {
        return (SecKillActivityType) r27.a.a(SecKillActivityType.class, r100);
    }

    public static SecKillActivityType[] values() {
        return (SecKillActivityType[]) f42824a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public SecKillActivityType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
