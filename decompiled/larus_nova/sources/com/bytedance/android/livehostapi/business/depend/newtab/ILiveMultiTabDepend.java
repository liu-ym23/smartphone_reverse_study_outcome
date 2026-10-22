package com.bytedance.android.livehostapi.business.depend.newtab;

import android.os.Bundle;
import com.bytedance.android.live.base.model.moreliveentrance.b;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0002H&J\u001a\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0002H&J\b\u0010\u0012\u001a\u00020\u0002H&J\b\u0010\u0013\u001a\u00020\u0002H&J\n\u0010\u0014\u001a\u0004\u0018\u00010\bH&J\b\u0010\u0015\u001a\u00020\u0002H&J\b\u0010\u0016\u001a\u00020\u0002H&J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u0002H&J\b\u0010\u001c\u001a\u00020\u0002H&J\b\u0010\u001d\u001a\u00020\u0002H&J\b\u0010\u001e\u001a\u00020\u0002H\u0016J\b\u0010\u001f\u001a\u00020\u0018H\u0016J\b\u0010!\u001a\u00020 H\u0016J\b\u0010\"\u001a\u00020 H\u0016¨\u0006#À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/newtab/ILiveMultiTabDepend;", "", "", "canBackMultiTab", "canShowFloatWindow", "hasLiveMultiTab", "canStackRoom", "canInterceptDrawerSlideTips", "", "caller", "Landroid/os/Bundle;", "enterParams", "", "tryBootPreload", "Lcom/bytedance/android/live/base/model/moreliveentrance/b;", "entranceInfo", "dispatchMoreLiveEntranceItem", "floatWindowPauseWhenBackground", "canForceNotSharedLiveClient", "interceptLeftSlideOpenDrawer", "getMoreEntranceTitle", "canSkipCheckResumed", "useNewStop", "enableMoreEntranceMarqueeType", "", "marqueeDelayTime", "enableLiveTab", "whetherUnMuteClientWhenStop", "canFixAudioConflict", "hitNewLiveTabReverse", "useNewShowStrategy", "marqueeSingleInternalDuration", "", "moreLiveTabRefreshStyle", "maxSingleRequestTime", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveMultiTabDepend {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.depend.newtab.ILiveMultiTabDepend$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$dispatchMoreLiveEntranceItem(ILiveMultiTabDepend r100, b r101) {
        }

        public static boolean $default$enableLiveTab(ILiveMultiTabDepend r100) {
            return false;
        }

        public static boolean $default$enableMoreEntranceMarqueeType(ILiveMultiTabDepend r100) {
            return false;
        }

        public static long $default$marqueeDelayTime(ILiveMultiTabDepend r100) {
            return -1;
        }

        public static long $default$marqueeSingleInternalDuration(ILiveMultiTabDepend r100) {
            return 0;
        }

        public static int $default$maxSingleRequestTime(ILiveMultiTabDepend r100) {
            return 1;
        }

        public static int $default$moreLiveTabRefreshStyle(ILiveMultiTabDepend r100) {
            return 0;
        }

        public static boolean $default$useNewShowStrategy(ILiveMultiTabDepend r100) {
            return false;
        }

        public static /* synthetic */ boolean access$enableLiveTab$jd(ILiveMultiTabDepend r100) {
            return $default$enableLiveTab(r100);
        }

        public static /* synthetic */ boolean access$enableMoreEntranceMarqueeType$jd(ILiveMultiTabDepend r100) {
            return $default$enableMoreEntranceMarqueeType(r100);
        }

        public static /* synthetic */ long access$marqueeDelayTime$jd(ILiveMultiTabDepend r100) {
            return $default$marqueeDelayTime(r100);
        }

        public static /* synthetic */ long access$marqueeSingleInternalDuration$jd(ILiveMultiTabDepend r100) {
            return $default$marqueeSingleInternalDuration(r100);
        }

        public static /* synthetic */ int access$maxSingleRequestTime$jd(ILiveMultiTabDepend r100) {
            return $default$maxSingleRequestTime(r100);
        }

        public static /* synthetic */ int access$moreLiveTabRefreshStyle$jd(ILiveMultiTabDepend r100) {
            return $default$moreLiveTabRefreshStyle(r100);
        }

        public static /* synthetic */ boolean access$useNewShowStrategy$jd(ILiveMultiTabDepend r100) {
            return $default$useNewShowStrategy(r100);
        }

        public static /* synthetic */ void access$dispatchMoreLiveEntranceItem$jd(ILiveMultiTabDepend r100, b r101) {
            $default$dispatchMoreLiveEntranceItem(r100, r101);
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static boolean enableLiveTab(ILiveMultiTabDepend r100) {
            return CC.access$enableLiveTab$jd(r100);
        }

        public static boolean enableMoreEntranceMarqueeType(ILiveMultiTabDepend r100) {
            return CC.access$enableMoreEntranceMarqueeType$jd(r100);
        }

        public static long marqueeDelayTime(ILiveMultiTabDepend r100) {
            return CC.access$marqueeDelayTime$jd(r100);
        }

        public static long marqueeSingleInternalDuration(ILiveMultiTabDepend r100) {
            return CC.access$marqueeSingleInternalDuration$jd(r100);
        }

        public static int maxSingleRequestTime(ILiveMultiTabDepend r100) {
            return CC.access$maxSingleRequestTime$jd(r100);
        }

        public static int moreLiveTabRefreshStyle(ILiveMultiTabDepend r100) {
            return CC.access$moreLiveTabRefreshStyle$jd(r100);
        }

        public static boolean useNewShowStrategy(ILiveMultiTabDepend r100) {
            return CC.access$useNewShowStrategy$jd(r100);
        }

        public static void dispatchMoreLiveEntranceItem(ILiveMultiTabDepend r100, b r101) {
            CC.access$dispatchMoreLiveEntranceItem$jd(r100, r101);
        }
    }

    boolean canBackMultiTab();

    boolean canFixAudioConflict();

    boolean canForceNotSharedLiveClient();

    boolean canInterceptDrawerSlideTips();

    boolean canShowFloatWindow();

    boolean canSkipCheckResumed();

    boolean canStackRoom();

    void dispatchMoreLiveEntranceItem(b r100);

    boolean enableLiveTab();

    boolean enableMoreEntranceMarqueeType();

    boolean floatWindowPauseWhenBackground();

    String getMoreEntranceTitle();

    boolean hasLiveMultiTab();

    boolean hitNewLiveTabReverse();

    boolean interceptLeftSlideOpenDrawer();

    long marqueeDelayTime();

    long marqueeSingleInternalDuration();

    int maxSingleRequestTime();

    int moreLiveTabRefreshStyle();

    void tryBootPreload(String r100, Bundle r101);

    boolean useNewShowStrategy();

    boolean useNewStop();

    boolean whetherUnMuteClientWhenStop();
}
