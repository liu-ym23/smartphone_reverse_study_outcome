package com.bytedance.android.livesdkapi.replay;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u0000 \t2\u00020\u0001:\u0002\t\nJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/replay/PaidReplayCallback;", "", "onFreePlayCountDown", "", "countDown", "", "onStateUpdate", "status", "", "Companion", "PaidReplayStatus", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface PaidReplayCallback {
    public static final Companion Companion = null;
    public static final int STATUS_HAS_DELIVERY = 2;
    public static final int STATUS_NEED_DELIVERY_NOTICE = 3;
    public static final int STATUS_NOT_NEED_NOTICE = 4;
    public static final int STATUS_TEMP_WATCH = 0;
    public static final int STATUS_TEMP_WATCH_END = 1;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/replay/PaidReplayCallback$Companion;", "", "()V", "STATUS_HAS_DELIVERY", "", "STATUS_NEED_DELIVERY_NOTICE", "STATUS_NOT_NEED_NOTICE", "STATUS_TEMP_WATCH", "STATUS_TEMP_WATCH_END", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int STATUS_HAS_DELIVERY = 2;
        public static final int STATUS_NEED_DELIVERY_NOTICE = 3;
        public static final int STATUS_NOT_NEED_NOTICE = 4;
        public static final int STATUS_TEMP_WATCH = 0;
        public static final int STATUS_TEMP_WATCH_END = 1;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void onFreePlayCountDown(PaidReplayCallback r100, long r101) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdkapi/replay/PaidReplayCallback$PaidReplayStatus;", "", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface PaidReplayStatus {
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void onFreePlayCountDown(long r100);

    void onStateUpdate(int r100);
}
