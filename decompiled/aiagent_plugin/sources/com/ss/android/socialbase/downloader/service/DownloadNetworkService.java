package com.ss.android.socialbase.downloader.service;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadNetworkService implements IDownloadNetworkService {
    public DownloadNetworkService() {
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNetworkService
    public IDownloadHttpConnection downloadWithConnection(boolean r10, int r11, String r12, List<HttpHeader> r13) {
        return downloadWithConnection(r10, r11, r12, null, (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin"), 0, false, null);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNetworkService
    public IDownloadHttpConnection downloadWithConnection(boolean r18, int r19, String r20, String r21, List<HttpHeader> r22, int r23, boolean r24, DownloadInfo r25) {
        List<HttpHeader> r0 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r21) == true) goto L10;
        if (r0 != null) goto L6;
        r0 = new ArrayList();
    L6:
        r0.add(new HttpHeader(DownloadConstants.EXTRA_REQUEST_HOST_IP, r21));
        if (enableTTNetIpRequest(r25) == true) goto L12;
        int r1 = 1;
    L13:
        List<HttpHeader> r12 = r0;
        int[] r13 = getDownloadNetLibs(r1);
        int r14 = r13.length;
        int r8 = 0;
        Exception r2 = null;
    L14:
        if (r8 >= r14) goto L32;
        int r16 = r8;
        IDownloadHttpConnection r3 = downloadWithConnectionImpl(r19, r20, r21, r12, r13[r8], r24, r25);     // Catch: Exception -> L19
        if (r3 == null) goto L31;
        return r3;
    L31:
        r8 = r16 + 1;
    L19:
        e = move-exception;
        if (r25 != null) goto L23;
    L30:
        r2 = e;
        goto L31
    L23:
        if (r25.isExpiredRedownload() == false) goto L30;
        if (DownloadUtils.isResponseCode304Error(e) == false) goto L30;
        if (DownloadUtils.hasDownloadCacheHeader(r12) == false) goto L30;
        throw e;
    L32:
        if (r2 != null) goto L34;
        return null;
    L34:
        throw r2;
    L12:
        r1 = r23;
        goto L13
    L10:
        if (r18 == true) goto L12;
        r1 = 2;
        goto L13
    }

    private IDownloadHttpConnection downloadWithConnectionImpl(int r12, String r13, String r14, List<HttpHeader> r15, int r16, boolean r17, DownloadInfo r18) {
        List<HttpHeader> r0 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin");
        IDownloadHttpService r1 = getHttpServiceInternal(r16);
        if (r1 == null) goto L28;
        IOException r8 = null;
        long r3 = 0;
        if (r17 == false) goto L31;
        r3 = System.currentTimeMillis();     // Catch: Throwable -> L8 IOException -> L10
    L10:
        e = e;
    L20:
        IOException r2 = e;
        throw r2;     // Catch: Throwable -> L22
    L22:
        th = th;
        r8 = r2;
    L24:
        if (r17 == false) goto L26;
        DownloadMonitorHelper.monitorDownloadConnect(null, r13, r14, System.currentTimeMillis() - r3, MonitorConstants.CONNECT_TYPE_GET, r16, r8, r18);
    L26:
        throw th;
    L8:
        th = th;
    L31:
        IDownloadHttpConnection r4 = r1.downloadWithConnection(r12, r13, r0);     // Catch: Throwable -> L17 IOException -> L19
        if (r17 == false) goto L16;
        DownloadMonitorHelper.monitorDownloadConnect(r4, r13, r14, System.currentTimeMillis() - r3, MonitorConstants.CONNECT_TYPE_GET, r16, null, r18);
    L16:
        return r4;
    L19:
        e = e;
    L17:
        th = th;
        goto L24
    L28:
        throw new BaseException(DownloadErrorCode.ERROR_NO_CONNECTION, new IOException("httpService not exist, netLib = " + r16));
    }

    private IDownloadHttpService getHttpServiceInternal(int r1) {
        if (2 != r1) goto L10;
        IDownloadHttpService r0 = DownloadComponentManager.getHttpService();
        if (r0 == null) goto L8;
        return r0;
    L8:
        return DownloadComponentManager.getDefaultHttpService();
    L10:
        if (r1 != 1) goto L13;
        return DownloadComponentManager.getHttpService();
    L13:
        return DownloadComponentManager.getDefaultHttpService();
    }

    private int[] getDownloadNetLibs(int r4) {
        if (r4 == 1) goto L19;
        if (r4 == 2) goto L17;
        if (r4 == 3) goto L15;
        if (r4 == 5) goto L13;
        return new int[]{1, 0};
    L13:
        return new int[]{2};
    L15:
        return new int[]{0, 1};
    L17:
        return new int[]{1};
    L19:
        return new int[]{0};
    }

    private boolean enableTTNetIpRequest(DownloadInfo r2) {
        if (r2 == null) goto L10;
        JSONObject r3 = DownloadSetting.obtain(r2.getId()).optJSONObject(DownloadSettingKeys.SEGMENT_CONFIG);
        if (r3 != null) goto L7;
        return false;
    L7:
        if (r3.optInt(DownloadSettingKeys.SegmentConfig.ENABLE_TTNET_IP_REQUEST, 0) <= 0) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }
}
