package com.bytedance.android.livesdk.roommanage;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes11.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface RoomManageType {
    public static final int ADMIN = 1;
    public static final int BAN_TALK = 2;
    public static final int FANS_GROUP = 4;
    public static final int KICK_OUT = 3;
    public static final int LIVE_MANAGE = 5;
}
