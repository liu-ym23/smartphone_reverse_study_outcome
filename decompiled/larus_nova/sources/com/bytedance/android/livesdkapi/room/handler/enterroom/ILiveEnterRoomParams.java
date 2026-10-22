package com.bytedance.android.livesdkapi.room.handler.enterroom;

import android.os.Bundle;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\"\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0005¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/enterroom/ILiveEnterRoomParams;", "", "businessBundle", "Landroid/os/Bundle;", "getBusinessBundle", "()Landroid/os/Bundle;", "clickMethod", "", "getClickMethod", "()Ljava/lang/String;", "commonLogParams", "", "getCommonLogParams", "()Ljava/util/Map;", "enterKey", "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/EnterKey;", "getEnterKey", "()Lcom/bytedance/android/livesdkapi/room/handler/enterroom/EnterKey;", "firstRoomLogParams", "getFirstRoomLogParams", "Companion", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveEnterRoomParams {
    public static final Companion Companion = null;

    /* JADX INFO: renamed from: com.bytedance.android.livesdkapi.room.handler.enterroom.ILiveEnterRoomParams$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        static {
            Companion r100 = ILiveEnterRoomParams.Companion;
        }

        @JvmStatic
        public static ILiveEnterRoomParams simple(EnterKey r100, String r101) {
            return ILiveEnterRoomParams.Companion.simple(r100, r101);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/enterroom/ILiveEnterRoomParams$Companion;", "", "()V", "Empty", "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/ILiveEnterRoomParams;", "getEmpty", "()Lcom/bytedance/android/livesdkapi/room/handler/enterroom/ILiveEnterRoomParams;", "simple", "enterKey", "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/EnterKey;", "clickMethod", "", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final ILiveEnterRoomParams Empty = null;

        private Companion() {
        }

        static {
            Companion r100 = new Companion();
            $$INSTANCE = r100;
            Empty = r100.simple(UnknownEnterKey.INSTANCE, "");
        }

        public final ILiveEnterRoomParams getEmpty() {
            return Empty;
        }

        @JvmStatic
        public final ILiveEnterRoomParams simple(final EnterKey r100, final String r101) {
            Intrinsics.checkNotNullParameter(r100, "enterKey");
            Intrinsics.checkNotNullParameter(r101, "clickMethod");
            return new ILiveEnterRoomParams$Companion$simple$1(r100, r101);
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    Bundle getBusinessBundle();

    String getClickMethod();

    Map<String, String> getCommonLogParams();

    EnterKey getEnterKey();

    Bundle getFirstRoomLogParams();
}
