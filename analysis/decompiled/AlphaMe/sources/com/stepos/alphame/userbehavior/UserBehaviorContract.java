package com.stepos.alphame.userbehavior;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stepos/alphame/userbehavior/UserBehaviorContract;", "", "()V", "DAY", "", "HOUR", "KEY_DIGITAL_HEALTH_CLEAR_DATA_TIME", "", "MINUTE", "MIN_SCREEN_OFF_TIME", "SECEND", "TAG", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class UserBehaviorContract {
    public static final long DAY = 86400000;
    public static final long HOUR = 3600000;

    @NotNull
    public static final UserBehaviorContract INSTANCE = new UserBehaviorContract();

    @NotNull
    public static final String KEY_DIGITAL_HEALTH_CLEAR_DATA_TIME = "KEY_DIGITAL_HEALTH_CLEAR_DATA_TIME";
    public static final long MINUTE = 60000;
    public static final long MIN_SCREEN_OFF_TIME = 1000;
    public static final long SECEND = 1000;

    @NotNull
    public static final String TAG = "UserBehavior";

    private UserBehaviorContract() {
    }
}
