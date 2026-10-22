package com.bytedance.android.livehostapi.business.depend.gamecp;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0005H&J*\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0005H&J\"\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0005H&J\"\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0005H&J\"\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H&J*\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u0015H&J \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H&J(\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H&J\u001a\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u001eÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCPFmpMonitorService;", "", "addEventExtra", "", "trackId", "", "event", "field", "value", "addEventField", "addTrackExtra", "addTrackField", "endComponentFmp", "componentName", "duration", "", "markActionEnd", "action", "markActionStart", "durationKey", "isExtra", "", "markEventActionEnd", "eventName", "markEventActionStart", "startComponentFmp", "startFmpTrack", "trackEvent", "stopFmpTrack", "reason", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IGameCPFmpMonitorService {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPFmpMonitorService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void markActionStart$default(IGameCPFmpMonitorService r100, String r101, String r102, String r103, boolean r104, int r105, Object r106) {
            if (r106 != null) goto L9;
            if ((r105 & 8) == 0) goto L6;
            r104 = false;
        L6:
            r100.markActionStart(r101, r102, r103, r104);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: markActionStart");
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void markActionStart$default(IGameCPFmpMonitorService r100, String r101, String r102, String r103, boolean r104, int r105, Object r106) {
            CC.markActionStart$default(r100, r101, r102, r103, r104, r105, r106);
        }
    }

    void addEventExtra(String r100, String r101, String r102, String r103);

    void addEventField(String r100, String r101, String r102, String r103);

    void addTrackExtra(String r100, String r101, String r102);

    void addTrackField(String r100, String r101, String r102);

    void endComponentFmp(String r100, String r101, long r102);

    void markActionEnd(String r100, String r101);

    void markActionStart(String r100, String r101, String r102, boolean r103);

    void markEventActionEnd(String r100, String r101, String r102);

    void markEventActionStart(String r100, String r101, String r102, String r103);

    void startComponentFmp(String r100, String r101);

    void startFmpTrack(String r100, String r101);

    void stopFmpTrack(String r100, String r101);
}
