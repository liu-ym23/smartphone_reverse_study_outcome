package com.android.server;

import android.database.ContentObserver;
import com.zte.feature.Feature;

/* JADX INFO: loaded from: classes.dex */
public interface IZswGestureLauncherService {
    public static final boolean ZTE_FEATURE_WALLET = false;

    boolean getOnlyOpenSos();

    boolean getOpenSos(boolean r1, int r2);

    boolean getWalletFeature(boolean r1, int r2);

    boolean handleSosGesture();

    boolean handleWalletGesture();

    void registerContentSosObserver(ContentObserver r1, int r2);

    void registerContentWalletObserver(ContentObserver r1, int r2);

    void showLog(String r1, boolean r2);

    static {
        ZTE_FEATURE_WALLET = Feature.getBoolean("ZTE_FEATURE_WALLET", false);
    }
}
