package com.bytedance.android.livesdkapi.announcement;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/announcement/AnnounceSettingPage;", "Lcom/bytedance/android/livesdkapi/announcement/AnnounceCommand;", "()V", "ClosePageWithoutCreate", "CreateFailed", "CreateSuccess", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AnnounceSettingPage implements AnnounceCommand {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/announcement/AnnounceSettingPage$ClosePageWithoutCreate;", "Lcom/bytedance/android/livesdkapi/announcement/AnnounceSettingPage;", "()V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ClosePageWithoutCreate extends AnnounceSettingPage {
        public static final ClosePageWithoutCreate INSTANCE = null;

        static {
            INSTANCE = new ClosePageWithoutCreate();
        }

        private ClosePageWithoutCreate() {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/announcement/AnnounceSettingPage$CreateFailed;", "Lcom/bytedance/android/livesdkapi/announcement/AnnounceSettingPage;", "()V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class CreateFailed extends AnnounceSettingPage {
        public static final CreateFailed INSTANCE = null;

        static {
            INSTANCE = new CreateFailed();
        }

        private CreateFailed() {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/announcement/AnnounceSettingPage$CreateSuccess;", "Lcom/bytedance/android/livesdkapi/announcement/AnnounceSettingPage;", "appointmentId", "", "timestamp", "(JJ)V", "getAppointmentId", "()J", "getTimestamp", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class CreateSuccess extends AnnounceSettingPage {
        private final long appointmentId;
        private final long timestamp;

        public final long getAppointmentId() {
            return this.appointmentId;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public CreateSuccess(long r100, long r101) {
            this.appointmentId = r100;
            this.timestamp = r101;
        }
    }

    public AnnounceSettingPage() {
    }
}
