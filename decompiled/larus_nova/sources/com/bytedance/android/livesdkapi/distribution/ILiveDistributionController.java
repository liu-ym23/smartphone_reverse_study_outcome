package com.bytedance.android.livesdkapi.distribution;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0007H&J\b\u0010\r\u001a\u00020\u000eH&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0007H&J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0013\u001a\u00020\u0003H&J\b\u0010\u0014\u001a\u00020\u0003H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0003H&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u001a\u001a\u00020\u0003H&¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdkapi/distribution/ILiveDistributionController;", "", "clearRoomCache", "", "uniqueKey", "", "clearWhenNotInLive", "", "enterLive", "enterParams", "Lcom/bytedance/android/livesdkapi/distribution/EnterParams;", "exitLive", "async", "getCurrentPosition", "", "getCurrentRoomId", "init", "invokeBackPress", "isInLive", "muteLive", "pauseLive", "preCreateContainer", "prePullStream", "release", "resumeLive", "stopPrePullStream", "unMuteLive", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveDistributionController {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void enterLive(ILiveDistributionController r100, EnterParams r101) {
            Intrinsics.checkNotNullParameter(r101, "enterParams");
        }

        public static void init(ILiveDistributionController r100) {
        }

        public static void preCreateContainer(ILiveDistributionController r100, EnterParams r101) {
            Intrinsics.checkNotNullParameter(r101, "enterParams");
        }

        public static void prePullStream(ILiveDistributionController r100, EnterParams r101) {
            Intrinsics.checkNotNullParameter(r101, "enterParams");
        }

        public static void release(ILiveDistributionController r100) {
        }

        public static void stopPrePullStream(ILiveDistributionController r100, EnterParams r101) {
            Intrinsics.checkNotNullParameter(r101, "enterParams");
        }
    }

    void clearRoomCache(String r100, boolean r101);

    void enterLive(EnterParams r100);

    void exitLive(boolean r100);

    int getCurrentPosition();

    String getCurrentRoomId();

    void init();

    boolean invokeBackPress();

    boolean isInLive(String r100);

    void muteLive();

    void pauseLive();

    void preCreateContainer(EnterParams r100);

    void prePullStream(EnterParams r100);

    void release();

    void resumeLive();

    void stopPrePullStream(EnterParams r100);

    void unMuteLive();
}
