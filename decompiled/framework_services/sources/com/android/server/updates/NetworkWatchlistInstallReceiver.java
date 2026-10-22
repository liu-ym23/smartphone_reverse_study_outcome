package com.android.server.updates;

import android.content.Context;
import android.content.Intent;
import android.net.NetworkWatchlistManager;
import android.util.Slog;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkWatchlistInstallReceiver extends ConfigUpdateInstallReceiver {
    public NetworkWatchlistInstallReceiver() {
        super("/data/misc/network_watchlist/", "network_watchlist.xml", "metadata/", "version");
    }

    @Override // com.android.server.updates.ConfigUpdateInstallReceiver
    protected void postInstall(Context context, Intent intent) {
        ((NetworkWatchlistManager) context.getSystemService(NetworkWatchlistManager.class)).reloadWatchlist();     // Catch: Exception -> L4
        return;
    L5:
        Slog.wtf("NetworkWatchlistInstallReceiver", "Unable to reload watchlist");
    }
}
