package com.bytedance.android.livesdkapi.livestate;

import com.bytedance.android.livesdkapi.model.UserLiveStatusModel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001$B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R7\u0010\u0005\u001a(\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u00070\u0007\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001f\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\rR\u0019\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0019\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0019\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011R\u0019\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0011R\u0011\u0010\u001f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdkapi/livestate/LiveStateRequest;", "", "builder", "Lcom/bytedance/android/livesdkapi/livestate/LiveStateRequest$Builder;", "(Lcom/bytedance/android/livesdkapi/livestate/LiveStateRequest$Builder;)V", "callback", "Lkotlin/Function1;", "", "", "", "Lcom/bytedance/android/livesdkapi/model/UserLiveStatusModel;", "", "getCallback", "()Lkotlin/jvm/functions/Function1;", "eagerSceneIds", "", "getEagerSceneIds", "()Ljava/util/List;", "eagerUserIds", "getEagerUserIds", "errorCallback", "", "getErrorCallback", "isLiving", "", "preloadSceneIds", "getPreloadSceneIds", "preloadUserIds", "getPreloadUserIds", "requestIds", "getRequestIds", "requestInterval", "getRequestInterval", "()J", "requestNetWorkTimeOut", "getRequestNetWorkTimeOut", "Builder", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveStateRequest {
    private final Function1<Map<Long, ? extends Map<String, ? extends UserLiveStatusModel>>, Unit> callback;
    private final List<Long> eagerSceneIds;
    private final List<String> eagerUserIds;
    private final Function1<Throwable, Unit> errorCallback;
    private final List<Integer> isLiving;
    private final List<Long> preloadSceneIds;
    private final List<String> preloadUserIds;
    private final List<String> requestIds;
    private final long requestInterval;
    private final long requestNetWorkTimeOut;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010#\u001a\u00020$J2\u0010\n\u001a\u00020\u00002*\u0010\n\u001a&\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00050\u0005\u0012\u0004\u0012\u00020\t0\u0004J\u0014\u0010\u000e\u001a\u00020\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\rJ\u0014\u0010\u0011\u001a\u00020\u00002\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\rJ\u001a\u0010\u0014\u001a\u00020\u00002\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\t0\u0004J\u0014\u0010\u0017\u001a\u00020\u00002\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\rJ\u0014\u0010\u0018\u001a\u00020\u00002\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\rJ\u0014\u0010\u001a\u001a\u00020\u00002\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\rJ\u0014\u0010\u001c\u001a\u00020\u00002\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\rJ\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0006J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u0006Rf\u0010\n\u001a&\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00050\u0005\u0012\u0004\u0012\u00020\t0\u00042*\u0010\u0003\u001a&\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00050\u0005\u0012\u0004\u0012\u00020\t0\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR.\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r2\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R.\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\r2\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R6\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\t0\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\t0\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\fR.\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\r2\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R.\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r2\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R.\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\r2\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0010R.\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\r2\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0010R\u001e\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 ¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdkapi/livestate/LiveStateRequest$Builder;", "", "()V", "<set-?>", "Lkotlin/Function1;", "", "", "", "Lcom/bytedance/android/livesdkapi/model/UserLiveStatusModel;", "", "callback", "getCallback", "()Lkotlin/jvm/functions/Function1;", "", "eagerSceneIds", "getEagerSceneIds", "()Ljava/util/List;", "eagerUserIds", "getEagerUserIds", "", "errorCallback", "getErrorCallback", "", "isLiving", "preloadSceneIds", "getPreloadSceneIds", "preloadUserIds", "getPreloadUserIds", "requestIds", "getRequestIds", "requestInterval", "getRequestInterval", "()J", "requestNetWorkTimeOut", "getRequestNetWorkTimeOut", "build", "Lcom/bytedance/android/livesdkapi/livestate/LiveStateRequest;", "timeOut", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Builder {
        private Function1<? super Map<Long, ? extends Map<String, ? extends UserLiveStatusModel>>, Unit> callback;
        private List<Long> eagerSceneIds;
        private List<String> eagerUserIds;
        private Function1<? super Throwable, Unit> errorCallback;
        private List<Integer> isLiving;
        private List<Long> preloadSceneIds;
        private List<String> preloadUserIds;
        private List<String> requestIds;
        private long requestInterval;
        private long requestNetWorkTimeOut;

        public final LiveStateRequest build() {
            return new LiveStateRequest(this);
        }

        public Builder() {
            this.callback = LiveStateRequest$Builder$callback$1.INSTANCE;
            this.requestNetWorkTimeOut = 60000;
            this.requestInterval = 3000;
            this.errorCallback = LiveStateRequest$Builder$errorCallback$1.INSTANCE;
        }

        public final Function1<Map<Long, ? extends Map<String, ? extends UserLiveStatusModel>>, Unit> getCallback() {
            return this.callback;
        }

        public final List<Long> getEagerSceneIds() {
            return this.eagerSceneIds;
        }

        public final List<String> getEagerUserIds() {
            return this.eagerUserIds;
        }

        public final Function1<Throwable, Unit> getErrorCallback() {
            return this.errorCallback;
        }

        public final List<Long> getPreloadSceneIds() {
            return this.preloadSceneIds;
        }

        public final List<String> getPreloadUserIds() {
            return this.preloadUserIds;
        }

        public final List<String> getRequestIds() {
            return this.requestIds;
        }

        public final long getRequestInterval() {
            return this.requestInterval;
        }

        public final long getRequestNetWorkTimeOut() {
            return this.requestNetWorkTimeOut;
        }

        public final List<Integer> isLiving() {
            return this.isLiving;
        }

        public final Builder callback(Function1<? super Map<Long, ? extends Map<String, ? extends UserLiveStatusModel>>, Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "callback");
            this.callback = r100;
            return this;
        }

        public final Builder eagerSceneIds(List<Long> r100) {
            Intrinsics.checkNotNullParameter(r100, "eagerSceneIds");
            this.eagerSceneIds = r100;
            return this;
        }

        public final Builder eagerUserIds(List<String> r100) {
            Intrinsics.checkNotNullParameter(r100, "eagerUserIds");
            this.eagerUserIds = r100;
            return this;
        }

        public final Builder errorCallback(Function1<? super Throwable, Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "errorCallback");
            this.errorCallback = r100;
            return this;
        }

        public final Builder isLiving(List<Integer> r100) {
            Intrinsics.checkNotNullParameter(r100, "isLiving");
            this.isLiving = r100;
            return this;
        }

        public final Builder preloadSceneIds(List<Long> r100) {
            Intrinsics.checkNotNullParameter(r100, "preloadSceneIds");
            this.preloadSceneIds = r100;
            return this;
        }

        public final Builder preloadUserIds(List<String> r100) {
            Intrinsics.checkNotNullParameter(r100, "preloadUserIds");
            this.preloadUserIds = r100;
            return this;
        }

        public final Builder requestIds(List<String> r100) {
            Intrinsics.checkNotNullParameter(r100, "requestIds");
            this.requestIds = r100;
            return this;
        }

        public final Builder requestInterval(long r100) {
            this.requestInterval = r100;
            return this;
        }

        public final Builder requestNetWorkTimeOut(long r100) {
            this.requestNetWorkTimeOut = r100;
            return this;
        }
    }

    public final Function1<Map<Long, ? extends Map<String, ? extends UserLiveStatusModel>>, Unit> getCallback() {
        return this.callback;
    }

    public final List<Long> getEagerSceneIds() {
        return this.eagerSceneIds;
    }

    public final List<String> getEagerUserIds() {
        return this.eagerUserIds;
    }

    public final Function1<Throwable, Unit> getErrorCallback() {
        return this.errorCallback;
    }

    public final List<Long> getPreloadSceneIds() {
        return this.preloadSceneIds;
    }

    public final List<String> getPreloadUserIds() {
        return this.preloadUserIds;
    }

    public final List<String> getRequestIds() {
        return this.requestIds;
    }

    public final long getRequestInterval() {
        return this.requestInterval;
    }

    public final long getRequestNetWorkTimeOut() {
        return this.requestNetWorkTimeOut;
    }

    public final List<Integer> isLiving() {
        return this.isLiving;
    }

    public LiveStateRequest(Builder r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.eagerUserIds = r100.getEagerUserIds();
        this.preloadUserIds = r100.getPreloadUserIds();
        this.eagerSceneIds = r100.getEagerSceneIds();
        this.preloadSceneIds = r100.getPreloadSceneIds();
        this.requestIds = r100.getRequestIds();
        this.isLiving = r100.isLiving();
        this.callback = r100.getCallback();
        this.requestNetWorkTimeOut = r100.getRequestNetWorkTimeOut();
        this.requestInterval = r100.getRequestInterval();
        this.errorCallback = r100.getErrorCallback();
    }
}
