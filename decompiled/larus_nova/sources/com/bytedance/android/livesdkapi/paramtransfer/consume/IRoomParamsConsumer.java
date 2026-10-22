package com.bytedance.android.livesdkapi.paramtransfer.consume;

import android.os.Bundle;
import com.bytedance.android.livesdk.paramtransfer.RoomParamsConsumeStage;
import com.bytedance.android.livesdkapi.paramtransfer.model.RoomBundleParams;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011J<\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH&J\b\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/paramtransfer/consume/IRoomParamsConsumer;", "", "consume", "", "data", "Lcom/bytedance/android/livesdkapi/paramtransfer/model/RoomBundleParams;", "stage", "Lcom/bytedance/android/livesdk/paramtransfer/RoomParamsConsumeStage;", "bundle", "Landroid/os/Bundle;", "map", "", "", "getBundleKey", "getClickParam", "getCommonParam", "getFirstShowParam", "Companion", "room_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IRoomParamsConsumer {
    public static final Companion Companion = null;
    public static final int TYPE_CLICK = 2;
    public static final int TYPE_COMMON = 1;
    public static final int TYPE_FIRST_SHOW = 3;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/paramtransfer/consume/IRoomParamsConsumer$Companion;", "", "()V", "TYPE_CLICK", "", "TYPE_COMMON", "TYPE_FIRST_SHOW", "room_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int TYPE_CLICK = 2;
        public static final int TYPE_COMMON = 1;
        public static final int TYPE_FIRST_SHOW = 3;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static String getBundleKey(IRoomParamsConsumer r100) {
            return "";
        }

        public static String getClickParam(IRoomParamsConsumer r100, RoomBundleParams r101) {
            return "";
        }

        public static String getCommonParam(IRoomParamsConsumer r100, RoomBundleParams r101) {
            return "";
        }

        public static String getFirstShowParam(IRoomParamsConsumer r100, RoomBundleParams r101) {
            return "";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void consume$default(IRoomParamsConsumer r100, RoomBundleParams r101, RoomParamsConsumeStage r102, Bundle r103, Map r104, int r105, Object r106) {
            if (r106 != null) goto L9;
            if ((r105 & 8) == 0) goto L6;
            r104 = null;
        L6:
            r100.consume(r101, r102, r103, r104);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: consume");
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void consume(RoomBundleParams r100, RoomParamsConsumeStage r101, Bundle r102, Map<String, String> r103);

    String getBundleKey();

    String getClickParam(RoomBundleParams r100);

    String getCommonParam(RoomBundleParams r100);

    String getFirstShowParam(RoomBundleParams r100);
}
