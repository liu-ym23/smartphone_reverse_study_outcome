package com.android.ttcjpaysdk.base.service;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/IUpdateConfig;", "", "disableThrottle", "", "getAk", "", "getChannelList", "", "getGeckoAppName", "getLoopLevel", "", "getUpdateLevel", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IUpdateConfig {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean disableThrottle(IUpdateConfig r100) {
            return false;
        }

        public static String getAk(IUpdateConfig r100) {
            return "";
        }

        public static int getLoopLevel(IUpdateConfig r100) {
            return 2;
        }

        public static int getUpdateLevel(IUpdateConfig r100) {
            return 1;
        }
    }

    boolean disableThrottle();

    String getAk();

    List<String> getChannelList();

    String getGeckoAppName();

    int getLoopLevel();

    int getUpdateLevel();
}
