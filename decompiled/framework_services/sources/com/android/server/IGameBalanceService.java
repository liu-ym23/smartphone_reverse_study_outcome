package com.android.server;

/* JADX INFO: loaded from: classes.dex */
public interface IGameBalanceService {
    default void setGameBalanceOpen(boolean open) {
    }

    default boolean isLastGameBalance() {
        return false;
    }

    default void setLastGameBalance(boolean lastGameBalance) {
    }

    default int getGameBalanceFlag() {
        return 0;
    }

    default boolean isGameBalanceMode() {
        return false;
    }

    default int getCurrentGameUid() {
        return 0;
    }

    default void notifySFGameBalanceChanged(boolean gameBalance) {
    }

    default void setDebugGameBalance(boolean debug) {
    }
}
