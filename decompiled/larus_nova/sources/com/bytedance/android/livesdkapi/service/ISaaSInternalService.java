package com.bytedance.android.livesdkapi.service;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0016JW\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0007H\u0016¢\u0006\u0002\u0010\u0014J \u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0017J\b\u0010\u0018\u001a\u00020\u0003H\u0016J0\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\b2\u000e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007H\u0016¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/ISaaSInternalService;", "Lcom/bytedance/android/livesdkapi/service/ILiveService;", "checkAccessTokenValid", "", "token", "", "isValidILiveCallback", "Lcom/bytedance/android/livesdkapi/service/ILiveCallback;", "", "getAppointmentSetting", "hostSubscribe", "subscribed", "from", "", "appointmentId", "", "groupId", "source", "anchorUid", "hostSubscribeCallback", "(ZLjava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lcom/bytedance/android/livesdkapi/service/ILiveCallback;)V", "isBroadcastSignAnchor", "ticket", "isSignILiveCallback", "notifyChangeBindSuccess", "preStartBroadcast", "scene", "isBindDouyin", "preStartILiveCallback", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ISaaSInternalService extends ILiveService {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void checkAccessTokenValid(ISaaSInternalService r100, String r101, ILiveCallback<Boolean> r102) {
            Intrinsics.checkNotNullParameter(r102, "isValidILiveCallback");
        }

        public static String getAppointmentSetting(ISaaSInternalService r100) {
            return null;
        }

        public static void hostSubscribe(ISaaSInternalService r100, boolean r101, Integer r102, Long r103, Long r104, Long r105, Long r106, ILiveCallback<Integer> r107) {
            Intrinsics.checkNotNullParameter(r107, "hostSubscribeCallback");
        }

        @Deprecated(message = "6/1之后 不再能原生开播 直接认为已签约即可")
        public static void isBroadcastSignAnchor(ISaaSInternalService r100, String r101, ILiveCallback<Boolean> r102) {
            Intrinsics.checkNotNullParameter(r102, "isSignILiveCallback");
        }

        public static void notifyChangeBindSuccess(ISaaSInternalService r100) {
        }

        public static void preStartBroadcast(ISaaSInternalService r100, String r101, String r102, boolean r103, ILiveCallback<String> r104) {
            Intrinsics.checkNotNullParameter(r101, "ticket");
            Intrinsics.checkNotNullParameter(r102, "scene");
            Intrinsics.checkNotNullParameter(r104, "preStartILiveCallback");
        }
    }

    void checkAccessTokenValid(String r100, ILiveCallback<Boolean> r101);

    String getAppointmentSetting();

    void hostSubscribe(boolean r100, Integer r101, Long r102, Long r103, Long r104, Long r105, ILiveCallback<Integer> r106);

    @Deprecated(message = "6/1之后 不再能原生开播 直接认为已签约即可")
    void isBroadcastSignAnchor(String r100, ILiveCallback<Boolean> r101);

    void notifyChangeBindSuccess();

    void preStartBroadcast(String r100, String r101, boolean r102, ILiveCallback<String> r103);
}
