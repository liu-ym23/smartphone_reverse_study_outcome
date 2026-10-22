package com.bytedance.android.livesdkapi.announcement;

import com.ss.texturerender.VideoSurfaceTexture;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdkapi/announcement/AnnounceChoosePage;", "Lcom/bytedance/android/livesdkapi/announcement/AnnounceCommand;", "()V", "LinkResult", "OldCallbackCompact", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AnnounceChoosePage implements AnnounceCommand {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/announcement/AnnounceChoosePage$LinkResult;", "Lcom/bytedance/android/livesdkapi/announcement/AnnounceChoosePage;", "appointmentId", "", VideoSurfaceTexture.KEY_TIME, "(Ljava/lang/String;Ljava/lang/String;)V", "getAppointmentId", "()Ljava/lang/String;", "getTimeStamp", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class LinkResult extends AnnounceChoosePage {
        private final String appointmentId;
        private final String timeStamp;

        public final String getAppointmentId() {
            return this.appointmentId;
        }

        public final String getTimeStamp() {
            return this.timeStamp;
        }

        public LinkResult(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "appointmentId");
            Intrinsics.checkNotNullParameter(r101, VideoSurfaceTexture.KEY_TIME);
            this.appointmentId = r100;
            this.timeStamp = r101;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/announcement/AnnounceChoosePage$OldCallbackCompact;", "Lcom/bytedance/android/livesdkapi/announcement/AnnounceChoosePage;", "()V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class OldCallbackCompact extends AnnounceChoosePage {
        public static final OldCallbackCompact INSTANCE = null;

        static {
            INSTANCE = new OldCallbackCompact();
        }

        private OldCallbackCompact() {
        }
    }

    public AnnounceChoosePage() {
    }
}
