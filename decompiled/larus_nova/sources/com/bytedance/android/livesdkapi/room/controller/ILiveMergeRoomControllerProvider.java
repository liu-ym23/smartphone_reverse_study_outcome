package com.bytedance.android.livesdkapi.room.controller;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0016J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/controller/ILiveMergeRoomControllerProvider;", "Lcom/bytedance/android/livesdkapi/room/controller/ILiveRoomControllerProvider;", "getController", "Lcom/bytedance/android/livesdkapi/room/controller/ILiveRoomController;", "roomId", "", "uniqueKey", "source", "Lcom/bytedance/android/livesdkapi/room/controller/ILiveRoomControllerProvider$ProviderSource;", "substituteClearLiveRoomController", "", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveMergeRoomControllerProvider extends ILiveRoomControllerProvider {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static ILiveRoomController getController(ILiveMergeRoomControllerProvider r100, String r101, String r102, ILiveRoomControllerProvider.ProviderSource r103) {
            Intrinsics.checkNotNullParameter(r101, "roomId");
            Intrinsics.checkNotNullParameter(r102, "uniqueKey");
            Intrinsics.checkNotNullParameter(r103, "source");
            return r100.getController(r101, r102);
        }

        public static void substituteClearLiveRoomController(ILiveMergeRoomControllerProvider r100, String r101, String r102, ILiveRoomControllerProvider.ProviderSource r103) {
            Intrinsics.checkNotNullParameter(r101, "roomId");
            Intrinsics.checkNotNullParameter(r102, "uniqueKey");
            Intrinsics.checkNotNullParameter(r103, "source");
            r100.substituteClearLiveRoomController(r101, r102);
        }

        public static /* synthetic */ ILiveRoomController getController$default(ILiveMergeRoomControllerProvider r100, String r101, String r102, ILiveRoomControllerProvider.ProviderSource r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L7;
            r103 = ILiveRoomControllerProvider.ProviderSource.DEFAULT;
        L7:
            return r100.getController(r101, r102, r103);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getController");
        }

        public static /* synthetic */ void substituteClearLiveRoomController$default(ILiveMergeRoomControllerProvider r100, String r101, String r102, ILiveRoomControllerProvider.ProviderSource r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L6;
            r103 = ILiveRoomControllerProvider.ProviderSource.DEFAULT;
        L6:
            r100.substituteClearLiveRoomController(r101, r102, r103);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substituteClearLiveRoomController");
        }
    }

    ILiveRoomController getController(String r100, String r101, ILiveRoomControllerProvider.ProviderSource r102);

    void substituteClearLiveRoomController(String r100, String r101, ILiveRoomControllerProvider.ProviderSource r102);
}
