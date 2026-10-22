package com.bytedance.android.livesdkapi.message;

import com.alipay.sdk.m.p.e;
import com.bytedance.android.livesdkapi.depend.message.wrds.IPreviewSyncDataType;
import kotlin.Metadata;
import vlc.d;
import vlc.l;
import wlc.b;
import wlc.c;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0001H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0005H&J\u001a\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\u001a\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\u001a\u0010\f\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\u001a\u0010\r\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\"\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u0013H&J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u0012H&J\b\u0010\u0017\u001a\u00020\u0005H&¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/message/IPreviewMessageManager;", "Lwlc/c;", "Lvlc/d;", "getInnerMessageManager", "getInnerStreamMessageManager", "", "startMessage", "stopMessage", "", "messageType", "Lvlc/l;", "listener", "addMessageListener", "removeMessageListener", "", e.f25671s, "Lcom/bytedance/android/livesdkapi/depend/message/wrds/IPreviewSyncDataType;", "type", "Lcom/bytedance/android/livesdkapi/message/OnWRDSDataUpdateListener;", "", "sticky", "addWRDSListener", "removeWRDSListener", "releaseWRDS", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPreviewMessageManager extends c {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void addWRDSListener$default(IPreviewMessageManager r100, IPreviewSyncDataType r101, OnWRDSDataUpdateListener r102, boolean r103, int r104, Object r105) {
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

    @Override // wlc.c
    /* synthetic */ void addMessageListener(int r100, b r101);

    void addMessageListener(String r100, l r101);

    @Override // wlc.c
    /* synthetic */ void addMessageListener(String r100, b r101);

    void addWRDSListener(IPreviewSyncDataType r100, OnWRDSDataUpdateListener r101, boolean r102);

    d getInnerMessageManager();

    c getInnerStreamMessageManager();

    @Override // wlc.c
    /* synthetic */ void release();

    void releaseWRDS();

    void removeMessageListener(int r100, l r101);

    @Override // wlc.c
    /* synthetic */ void removeMessageListener(int r100, b r101);

    void removeMessageListener(String r100, l r101);

    @Override // wlc.c
    /* synthetic */ void removeMessageListener(String r100, b r101);

    void removeMessageListener(l r100);

    void removeWRDSListener(IPreviewSyncDataType r100, OnWRDSDataUpdateListener r101);

    void startMessage();

    void stopMessage();

    @Override // wlc.c
    /* synthetic */ void updateStreamDelay(long r100);
}
