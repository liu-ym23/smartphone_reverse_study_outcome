package com.stepos.taskrobot.logger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
public interface LogAdapter {
    boolean isLoggable(int i, @Nullable String str);

    void log(int i, @Nullable String str, @NonNull String str2);
}
