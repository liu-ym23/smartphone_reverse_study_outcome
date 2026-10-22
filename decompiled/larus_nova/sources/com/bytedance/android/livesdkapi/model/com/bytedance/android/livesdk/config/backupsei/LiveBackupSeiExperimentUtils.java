package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.backupsei;

import android.text.TextUtils;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.y;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004J\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004J\u0016\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004J\u0016\u0010\u0011\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/backupsei/LiveBackupSeiExperimentUtils;", "", "()V", "guestVersionEnable", "", "getGuestVersionEnable", "()Z", "testMock", "getTestMock", "setTestMock", "(Z)V", "isEnableLiveBackupSei", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "isAnchor", "isEnableMockCdnSeiException", "isEnableTestDebugInfo", "isSupportedServerMixStream", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveBackupSeiExperimentUtils {
    public static final LiveBackupSeiExperimentUtils INSTANCE = null;
    private static final boolean guestVersionEnable = false;
    private static boolean testMock;

    private LiveBackupSeiExperimentUtils() {
    }

    static {
        INSTANCE = new LiveBackupSeiExperimentUtils();
        y r100 = y.f162543a;
        testMock = r100.getValue().getForceDispatchBackupSei();
        guestVersionEnable = r100.getValue().getGuestVersionEnable();
    }

    public final boolean getGuestVersionEnable() {
        return guestVersionEnable;
    }

    public final boolean getTestMock() {
        return testMock;
    }

    public final void setTestMock(boolean r100) {
        testMock = r100;
    }

    public final boolean isEnableLiveBackupSei(IRoom r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "room");
        String r102 = r100.getAnchorAbValue("live_backup_sei_enable");
        if (r101 == false) goto L5;
        boolean r103 = true;
    L7:
        if (TextUtils.equals(r102, "true") == false) goto L10;
        if (r103 == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    L5:
        r103 = guestVersionEnable;
        goto L7
    }

    public final boolean isEnableMockCdnSeiException(IRoom r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "room");
        boolean r102 = isEnableLiveBackupSei(r100, r101);
        boolean r103 = v.a();
        if (r102 == false) goto L8;
        if (r103 == false) goto L8;
        if (testMock == false) goto L8;
        return true;
    L8:
        return false;
    }

    public final boolean isEnableTestDebugInfo(IRoom r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "room");
        boolean r102 = isEnableLiveBackupSei(r100, r101);
        boolean r103 = v.a();
        boolean r104 = y.f162543a.getValue().getEnableTestLogAndInfo();
        if (r102 == false) goto L7;
        if (r103 == false) goto L7;
        if (r104 == false) goto L7;
        return true;
    L7:
        return false;
    }

    public final boolean isSupportedServerMixStream(IRoom r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "room");
        boolean r102 = isEnableLiveBackupSei(r100, r101);
        boolean r103 = y.f162543a.getValue().getServerMixStreamIsSupported();
        if (r102 == false) goto L6;
        if (r103 == false) goto L6;
        return true;
    L6:
        return false;
    }
}
