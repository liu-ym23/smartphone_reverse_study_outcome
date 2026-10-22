package com.bytedance.android.livesdkapi.paidlive;

import android.os.Bundle;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00132\u00020\u0001:\u0002\u0013\u0014J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J1\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH&¢\u0006\u0002\u0010\u000fJ\u0012\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/paidlive/PaidLiveCallback;", "", "enterRoom", "", "info", "Landroid/os/Bundle;", "onStateUpdate", "status", "", "label", "", "remainTime", "", "showBlurBg", "", "(ILjava/lang/String;Ljava/lang/Long;Z)V", "refreshStreamUrl", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Companion", "PaidLiveStatus", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface PaidLiveCallback {
    public static final Companion Companion = null;
    public static final int STATUS_HAS_DELIVERY = 2;
    public static final int STATUS_NEED_DELIVERY_NOTICE = 3;
    public static final int STATUS_NOT_NEED_NOTICE = 4;
    public static final int STATUS_TEMP_WATCH = 0;
    public static final int STATUS_TEMP_WATCH_END = 1;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/paidlive/PaidLiveCallback$Companion;", "", "()V", "STATUS_HAS_DELIVERY", "", "STATUS_NEED_DELIVERY_NOTICE", "STATUS_NOT_NEED_NOTICE", "STATUS_TEMP_WATCH", "STATUS_TEMP_WATCH_END", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
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
        public static void refreshStreamUrl(PaidLiveCallback r100, IRoom r101) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdkapi/paidlive/PaidLiveCallback$PaidLiveStatus;", "", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface PaidLiveStatus {
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void enterRoom(Bundle r100);

    void onStateUpdate(int r100, String r101, Long r102, boolean r103);

    void refreshStreamUrl(IRoom r100);
}
