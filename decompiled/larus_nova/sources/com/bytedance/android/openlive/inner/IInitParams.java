package com.bytedance.android.openlive.inner;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\u0003H&¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/openlive/inner/IInitParams;", "", "appIcon", "", "appName", "", "clientKey", "isDebug", "", "needBindNetwork", "needBroadcast", "needInitFeed", "needInitGecko", "webcastAppId", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IInitParams {

    /* JADX INFO: renamed from: com.bytedance.android.openlive.inner.IInitParams$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$isDebug(IInitParams r100) {
            return false;
        }

        public static boolean $default$needBindNetwork(IInitParams r100) {
            return true;
        }

        public static boolean $default$needBroadcast(IInitParams r100) {
            return false;
        }

        public static boolean $default$needInitFeed(IInitParams r100) {
            return true;
        }

        public static boolean $default$needInitGecko(IInitParams r100) {
            return true;
        }

        public static /* synthetic */ boolean access$isDebug$jd(IInitParams r100) {
            return $default$isDebug(r100);
        }

        public static /* synthetic */ boolean access$needBindNetwork$jd(IInitParams r100) {
            return $default$needBindNetwork(r100);
        }

        public static /* synthetic */ boolean access$needBroadcast$jd(IInitParams r100) {
            return $default$needBroadcast(r100);
        }

        public static /* synthetic */ boolean access$needInitFeed$jd(IInitParams r100) {
            return $default$needInitFeed(r100);
        }

        public static /* synthetic */ boolean access$needInitGecko$jd(IInitParams r100) {
            return $default$needInitGecko(r100);
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static boolean isDebug(IInitParams r100) {
            return CC.access$isDebug$jd(r100);
        }

        public static boolean needBindNetwork(IInitParams r100) {
            return CC.access$needBindNetwork$jd(r100);
        }

        public static boolean needBroadcast(IInitParams r100) {
            return CC.access$needBroadcast$jd(r100);
        }

        public static boolean needInitFeed(IInitParams r100) {
            return CC.access$needInitFeed$jd(r100);
        }

        public static boolean needInitGecko(IInitParams r100) {
            return CC.access$needInitGecko$jd(r100);
        }
    }

    int appIcon();

    String appName();

    String clientKey();

    boolean isDebug();

    boolean needBindNetwork();

    boolean needBroadcast();

    boolean needInitFeed();

    boolean needInitGecko();

    int webcastAppId();
}
