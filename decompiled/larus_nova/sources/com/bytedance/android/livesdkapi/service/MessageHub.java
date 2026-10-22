package com.bytedance.android.livesdkapi.service;

import androidx.exifinterface.media.ExifInterface;
import com.alipay.sdk.m.p.e;
import com.bytedance.android.livesdkapi.depend.message.wrds.IPreviewSyncDataType;
import com.bytedance.android.livesdkapi.message.OnWRDSDataUpdateListener;
import kotlin.Metadata;
import tlc.d;
import vlc.l;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H&J\"\u0010\u0010\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH&J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\rH&J/\u0010\u0016\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0013*\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/MessageHub;", "", "", e.f25671s, "Lvlc/l;", "listener", "", "addMessageListener", "removeMessageListener", "", "messageType", "Lcom/bytedance/android/livesdkapi/depend/message/wrds/IPreviewSyncDataType;", "type", "Lcom/bytedance/android/livesdkapi/message/OnWRDSDataUpdateListener;", "", "sticky", "addWRDSListener", "removeWRDSListener", "Ltlc/d;", ExifInterface.GPS_DIRECTION_TRUE, "messageMethod", "wrdsSubKey", "getLatestWRDSMessage", "(Ljava/lang/String;Ljava/lang/String;)Ltlc/d;", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface MessageHub {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ d getLatestWRDSMessage$default(MessageHub r100, String r101, String r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L7;
            r102 = null;
        L7:
            return r100.getLatestWRDSMessage(r101, r102);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLatestWRDSMessage");
        }

        public static /* synthetic */ void addWRDSListener$default(MessageHub r100, IPreviewSyncDataType r101, OnWRDSDataUpdateListener r102, boolean r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L6;
            r103 = false;
        L6:
            r100.addWRDSListener(r101, r102, r103);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addWRDSListener");
        }
    }

    void addMessageListener(int r100, l r101);

    void addMessageListener(String r100, l r101);

    void addWRDSListener(IPreviewSyncDataType r100, OnWRDSDataUpdateListener r101, boolean r102);

    <T extends d> T getLatestWRDSMessage(String r100, String r101);

    void removeMessageListener(int r100, l r101);

    void removeMessageListener(String r100, l r101);

    void removeWRDSListener(IPreviewSyncDataType r100, OnWRDSDataUpdateListener r101);
}
