package com.ss.android.socialbase.downloader.downloader;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadTTNetException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class NetworkFailoverStrategy {
    private static final String FALLBACK_ERROR_IP = "0.0.0.0";
    private static final String TAG = "NetworkFailoverStrategy";
    private static final int TTNET_HTTP_PROTO_TYPE_HTTP1 = 1;
    private static final int TTNET_HTTP_PROTO_TYPE_HTTP2 = 2;
    private static final int TTNET_HTTP_PROTO_TYPE_QUIC = 3;
    private static final String TTNET_ISOLATION_HEADER_KEY = "x-ttnet-isolation-info";
    private static final String TTNET_ISOLATION_HEADER_VALUE = "https://dl";
    private int mBackHostCountLimit;
    private Set<Integer> mBackHostErrorCodeSet;
    private List<String> mBackHostList;
    private List<Long> mConnectTimeoutList;
    private String mDownloadHost;
    private int mDownloadId;
    private List<FailoverStrategy> mFailoverStrategyList;
    private List<Long> mIoTimeoutList;
    private int mIpChangeCountLimit;
    private Set<Integer> mIpChangeErrorCodeSet;
    private int mIsolationCount;
    private Set<Integer> mIsolationErrorCodeSet;
    private int mIsolationHttpProtoType;
    private Set<Integer> mTimeoutErrorCodeSet;

    private class BackHostStrategyImpl implements FailoverStrategy {
        private boolean mBackHostEnable;
        private int mCurrentBackHostCount;
        private boolean mHandleCurrentBackHostHeader;
        final /* synthetic */ NetworkFailoverStrategy this$0;

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public boolean isFailoverOnly() {
            return true;
        }

        BackHostStrategyImpl(NetworkFailoverStrategy r2) {
            this.this$0 = r2;
            this.mBackHostEnable = false;
            this.mHandleCurrentBackHostHeader = false;
            this.mCurrentBackHostCount = -1;
            if (NetworkFailoverStrategy.access$600(r2) > 0) goto L5;
            return;
        L5:
            if (NetworkFailoverStrategy.access$700(r2).isEmpty() == true) goto L9;
            this.mBackHostEnable = true;
            return;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public boolean handleError(BaseException r1) {
            boolean r2 = handleBackHostError(r1);
            this.mHandleCurrentBackHostHeader = r2;
            return r2;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public void handleHeader(List<HttpHeader> r3) {
            handleBackHostHeader((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
        }

        private boolean handleBackHostError(BaseException r9) {
            if (this.mBackHostEnable == true) goto L5;
        L26:
            return false;
        L5:
            if (this.mCurrentBackHostCount >= NetworkFailoverStrategy.access$600(this.this$0)) goto L26;
            if (NetworkFailoverStrategy.access$800(this.this$0).isEmpty() == false) goto L10;
        L13:
            boolean r0 = true;
        L15:
            if (r0 == false) goto L24;
            int r1 = this.mCurrentBackHostCount + 1;
            this.mCurrentBackHostCount = r1;
            if (r1 == NetworkFailoverStrategy.access$600(this.this$0)) goto L19;
            return true;
        L19:
            if (Logger.debug() == false) goto L21;
            Logger.taskDebug(NetworkFailoverStrategy.TAG, NetworkFailoverStrategy.access$200(this.this$0), "handleBackHostError", "BackHostCountLimit" + NetworkFailoverStrategy.access$600(this.this$0) + " currentBackHostCount:" + this.mCurrentBackHostCount + " errorCode:" + r9.getErrorCode());
        L21:
            return false;
        L24:
            if (Logger.debug() == false) goto L26;
            Logger.taskDebug(NetworkFailoverStrategy.TAG, NetworkFailoverStrategy.access$200(this.this$0), "handleBackHostError", "IsMatch" + r0 + " BackHostCountLimit:" + NetworkFailoverStrategy.access$600(this.this$0) + " errorCode:" + r9.getErrorCode());
            goto L26
        L10:
            if (NetworkFailoverStrategy.access$800(this.this$0).contains(Integer.valueOf(r9.getErrorCode())) == true) goto L13;
            r0 = false;
            goto L15
        }

        private void handleBackHostHeader(List<HttpHeader> r5) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            if (this.mBackHostEnable == true) goto L5;
            return;
        L5:
            if (this.mHandleCurrentBackHostHeader == false) goto L17;
            int r0 = this.mCurrentBackHostCount;
            if (r0 >= 0) goto L9;
            return;
        L9:
            if (r0 >= NetworkFailoverStrategy.access$600(this.this$0)) goto L19;
            this.mHandleCurrentBackHostHeader = false;
            String r1 = (String) ZeusTransformUtils.preCheckCast(NetworkFailoverStrategy.access$700(this.this$0).get(this.mCurrentBackHostCount % NetworkFailoverStrategy.access$700(this.this$0).size()), String.class, "com.obric.aiagent.plugin");
            if (Logger.debug() == false) goto L14;
            Logger.taskDebug(NetworkFailoverStrategy.TAG, NetworkFailoverStrategy.access$200(this.this$0), "handleBackHostHeader", "Add BackHost Header: " + r1);
        L14:
            r6.add(new HttpHeader(DownloadConstants.EXTRA_TTNET_BACK_HOST, r1));
            return;
        L19:
            return;
        }
    }

    private class DefaultIpChangeStrategyImpl implements FailoverStrategy {
        private int mCurrentIpChangeCount;
        private boolean mHandleCurrentIpChangeHeader;
        private boolean mIpChangeEnable;
        private Set<String> mIpChangeErrorIps;
        final /* synthetic */ NetworkFailoverStrategy this$0;

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public boolean isFailoverOnly() {
            return true;
        }

        DefaultIpChangeStrategyImpl(NetworkFailoverStrategy r2) {
            this.this$0 = r2;
            this.mIpChangeEnable = false;
            this.mHandleCurrentIpChangeHeader = false;
            this.mCurrentIpChangeCount = -1;
            this.mIpChangeErrorIps = new HashSet();
            if (NetworkFailoverStrategy.access$000(r2) > 0) goto L5;
            return;
        L5:
            if (NetworkFailoverStrategy.access$100(r2).isEmpty() == true) goto L9;
            this.mIpChangeEnable = true;
            return;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public boolean handleError(BaseException r1) {
            boolean r2 = handleIpChangeError(r1);
            this.mHandleCurrentIpChangeHeader = r2;
            return r2;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public void handleHeader(List<HttpHeader> r3) {
            handleIpChangeHeader((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
        }

        private boolean handleIpChangeError(BaseException r8) {
            if (this.mIpChangeEnable == true) goto L5;
        L29:
            return false;
        L5:
            if (ZeusTransformUtils.instanceOf(r8, DownloadTTNetException.class) == false) goto L29;
            if (this.mCurrentIpChangeCount >= NetworkFailoverStrategy.access$000(this.this$0)) goto L29;
            if (NetworkFailoverStrategy.access$100(this.this$0).contains(Integer.valueOf(r8.getErrorCode())) == true) goto L12;
            return false;
        L12:
            String r0 = ((DownloadTTNetException) ZeusTransformUtils.preCheckCast(r8, DownloadTTNetException.class, "com.obric.aiagent.plugin")).getRemoteIp();
            if (this.mCurrentIpChangeCount >= NetworkFailoverStrategy.access$000(this.this$0)) goto L27;
            int r9 = this.mCurrentIpChangeCount + 1;
            this.mCurrentIpChangeCount = r9;
            if (r9 != NetworkFailoverStrategy.access$000(this.this$0)) goto L21;
            if (Logger.debug() == false) goto L19;
            Logger.taskDebug(NetworkFailoverStrategy.TAG, NetworkFailoverStrategy.access$200(this.this$0), "handleIpChangeError", "CurrentIpChangeCount:" + this.mCurrentIpChangeCount + " mIpChangeCountLimit:" + NetworkFailoverStrategy.access$000(this.this$0));
        L19:
            return false;
        L21:
            if (TextUtils.isEmpty(r0) == true) goto L24;
            this.mIpChangeErrorIps.add(r0);
            return true;
        L24:
            this.mIpChangeErrorIps.add(NetworkFailoverStrategy.FALLBACK_ERROR_IP);
            return true;
        L27:
            if (Logger.debug() == false) goto L29;
            Logger.taskDebug(NetworkFailoverStrategy.TAG, NetworkFailoverStrategy.access$200(this.this$0), "handleIpChangeError", " RemoteIp:" + r0 + " currentIpChangeCount:" + this.mCurrentIpChangeCount + " errorCode:" + r8.getErrorCode() + " mIpChangeErrorIps:" + this.mIpChangeErrorIps.toString());
            goto L29
        }

        private void handleIpChangeHeader(List<HttpHeader> r6) {
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
            if (this.mIpChangeEnable == true) goto L5;
            return;
        L5:
            if (this.mHandleCurrentIpChangeHeader == false) goto L22;
            int r0 = this.mCurrentIpChangeCount;
            if (r0 >= 0) goto L9;
            return;
        L9:
            if (r0 >= NetworkFailoverStrategy.access$000(this.this$0)) goto L24;
            this.mHandleCurrentIpChangeHeader = false;
            StringBuilder r1 = new StringBuilder();
            Iterator<String> r2 = this.mIpChangeErrorIps.iterator();
        L13:
            if (r2.hasNext() == false) goto L16;
            r1.append((String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin"));
            r1.append(",");
            goto L13
        L16:
            if (Logger.debug() == false) goto L18;
            Logger.taskDebug(NetworkFailoverStrategy.TAG, NetworkFailoverStrategy.access$200(this.this$0), "handleIpChangeHeader", "Add extra_ttnet_change_ip:" + r1.toString());
        L18:
            r7.add(new HttpHeader(DownloadConstants.EXTRA_TTNET_CHANGE_IP, r1.toString()));
            return;
        L24:
            return;
        }
    }

    private interface FailoverStrategy {
        boolean handleError(BaseException r1);

        void handleHeader(List<HttpHeader> r1);

        boolean isFailoverOnly();
    }

    private class IsolationIpChangeStrategyImpl extends DefaultIpChangeStrategyImpl {
        private boolean mHandleCurrentIsolationHeader;
        private boolean mIsolationEnable;
        private int mIsolationIndex;
        final /* synthetic */ NetworkFailoverStrategy this$0;

        IsolationIpChangeStrategyImpl(NetworkFailoverStrategy r2) {
            this.this$0 = r2;
            super(r2);
            this.mIsolationEnable = false;
            this.mHandleCurrentIsolationHeader = false;
            this.mIsolationIndex = -1;
            if (NetworkFailoverStrategy.access$300(r2) > 0) goto L5;
            return;
        L5:
            if (NetworkFailoverStrategy.access$400(r2).isEmpty() == true) goto L9;
            this.mIsolationEnable = true;
            return;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.DefaultIpChangeStrategyImpl, com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public boolean handleError(BaseException r2) {
            boolean r0 = handleIsolationError(r2);
            this.mHandleCurrentIsolationHeader = r0;
            if (r0 == false) goto L6;
            super.handleError(r2);
        L6:
            return this.mHandleCurrentIsolationHeader;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.DefaultIpChangeStrategyImpl, com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public void handleHeader(List<HttpHeader> r3) {
            List<HttpHeader> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            if (handleIsolationHeader(r4) == false) goto L6;
            super.handleHeader(r4);
            return;
        }

        private boolean handleIsolationError(BaseException r10) {
            if (this.mIsolationEnable == true) goto L5;
        L19:
            return false;
        L5:
            if (this.mIsolationIndex >= NetworkFailoverStrategy.access$300(this.this$0)) goto L19;
            boolean r0 = NetworkFailoverStrategy.access$400(this.this$0).contains(Integer.valueOf(r10.getErrorCode()));
            if (r0 == false) goto L17;
            int r1 = this.mIsolationIndex + 1;
            this.mIsolationIndex = r1;
            if (r1 == NetworkFailoverStrategy.access$300(this.this$0)) goto L12;
            return true;
        L12:
            if (Logger.debug() == false) goto L14;
            Logger.taskDebug(NetworkFailoverStrategy.TAG, NetworkFailoverStrategy.access$200(this.this$0), "handleIsolationError", "IsolationCount" + NetworkFailoverStrategy.access$300(this.this$0) + " ttnetIsolationIndex:" + this.mIsolationIndex + " errorCode:" + r10.getErrorCode());
        L14:
            return false;
        L17:
            if (Logger.debug() == false) goto L19;
            Logger.taskDebug(NetworkFailoverStrategy.TAG, NetworkFailoverStrategy.access$200(this.this$0), "handleIsolationError", "IsMatch" + r0 + " ttnetIsolationIndex:" + this.mIsolationIndex + " errorCode:" + r10.getErrorCode());
            goto L19
        }

        private boolean handleIsolationHeader(List<HttpHeader> r6) {
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
            if (this.mIsolationEnable == true) goto L5;
        L22:
            return false;
        L5:
            if (this.mHandleCurrentIsolationHeader == false) goto L22;
            int r0 = this.mIsolationIndex;
            if (r0 < 0) goto L22;
            if (r0 >= NetworkFailoverStrategy.access$300(this.this$0)) goto L22;
            this.mHandleCurrentIsolationHeader = false;
            if (Logger.debug() == false) goto L14;
            Logger.taskDebug(NetworkFailoverStrategy.TAG, NetworkFailoverStrategy.access$200(this.this$0), "handleIsolationHeader", "Add handleIsolationHeader: https://dl");
        L14:
            r7.add(new HttpHeader(NetworkFailoverStrategy.TTNET_ISOLATION_HEADER_KEY, NetworkFailoverStrategy.TTNET_ISOLATION_HEADER_VALUE));
            if (NetworkFailoverStrategy.access$500(this.this$0) > 0) goto L17;
            return true;
        L17:
            if (Logger.debug() == false) goto L19;
            Logger.taskDebug(NetworkFailoverStrategy.TAG, NetworkFailoverStrategy.access$200(this.this$0), "handleIsolationHeader", "Add x-ttnet-http-proto-type: " + NetworkFailoverStrategy.access$500(this.this$0));
        L19:
            DownloadHelper.removeHeaderKey(r7, DownloadHelper.TTNET_PROTO_TYPE);
            r7.add(new HttpHeader(DownloadHelper.TTNET_PROTO_TYPE, String.valueOf(NetworkFailoverStrategy.access$500(this.this$0))));
            return true;
        }
    }

    private class TimeoutStrategyImpl implements FailoverStrategy {
        private boolean mTimeoutEnable;
        private int mTimeoutIndex;
        final /* synthetic */ NetworkFailoverStrategy this$0;

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public boolean isFailoverOnly() {
            return false;
        }

        TimeoutStrategyImpl(NetworkFailoverStrategy r2) {
            this.this$0 = r2;
            this.mTimeoutEnable = false;
            this.mTimeoutIndex = -1;
            if (NetworkFailoverStrategy.access$900(r2).isEmpty() == false) goto L5;
            return;
        L5:
            if (NetworkFailoverStrategy.access$1000(r2).isEmpty() == true) goto L7;
        L8:
            this.mTimeoutEnable = true;
            return;
        L7:
            if (NetworkFailoverStrategy.access$1100(r2).isEmpty() == false) goto L8;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public boolean handleError(BaseException r1) {
            return handleTimeoutError(r1);
        }

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public void handleHeader(List<HttpHeader> r3) {
            handleTimeoutHeader((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
        }

        private boolean handleTimeoutError(BaseException r6) {
            if (this.mTimeoutEnable == true) goto L5;
            return false;
        L5:
            boolean r0 = NetworkFailoverStrategy.access$900(this.this$0).contains(Integer.valueOf(r6.getErrorCode()));
            if (r0 == false) goto L10;
            this.mTimeoutIndex++;
            return true;
        L10:
            if (Logger.debug() == false) goto L12;
            Logger.taskDebug(NetworkFailoverStrategy.TAG, NetworkFailoverStrategy.access$200(this.this$0), "handleTimeoutError", "IsMatch:" + r0 + " ttnetTimeoutIndex:" + this.mTimeoutIndex + " errorCode:" + r6.getErrorCode());
        L12:
            return false;
        }

        private void handleTimeoutHeader(List<HttpHeader> r7) {
            List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
            if (this.mTimeoutEnable == true) goto L5;
            return;
        L5:
            if (this.mTimeoutIndex >= 0) goto L8;
            return;
        L8:
            if (NetworkFailoverStrategy.access$1100(this.this$0).isEmpty() == true) goto L18;
            if (this.mTimeoutIndex >= NetworkFailoverStrategy.access$1100(this.this$0).size()) goto L12;
            int r0 = this.mTimeoutIndex;
        L13:
            String r1 = String.valueOf(NetworkFailoverStrategy.access$1100(this.this$0).get(r0));
            if (Logger.debug() == false) goto L16;
            Logger.taskDebug(NetworkFailoverStrategy.TAG, NetworkFailoverStrategy.access$200(this.this$0), "handleTimeoutHeader", "Add ConnectTimeout:" + r1);
        L16:
            r8.add(new HttpHeader(DownloadConstants.EXTRA_TTNET_CONNECT_TIMEOUT, r1));
            goto L18
        L12:
            r0 = NetworkFailoverStrategy.access$1100(this.this$0).size() - 1;
        L18:
            if (NetworkFailoverStrategy.access$1000(this.this$0).isEmpty() == false) goto L20;
            return;
        L20:
            if (this.mTimeoutIndex >= NetworkFailoverStrategy.access$1000(this.this$0).size()) goto L22;
            int r2 = this.mTimeoutIndex;
        L23:
            String r3 = String.valueOf(NetworkFailoverStrategy.access$1000(this.this$0).get(r2));
            if (Logger.debug() == false) goto L26;
            Logger.taskDebug(NetworkFailoverStrategy.TAG, NetworkFailoverStrategy.access$200(this.this$0), "handleTimeoutHeader", "Add IoTimeout:" + r3);
        L26:
            r8.add(new HttpHeader(DownloadConstants.EXTRA_TTNET_IO_TIMEOUT, r3));
            return;
        L22:
            r2 = NetworkFailoverStrategy.access$1000(this.this$0).size() - 1;
            goto L23
        }
    }

    static /* synthetic */ int access$000(NetworkFailoverStrategy r0) {
        return r0.mIpChangeCountLimit;
    }

    static /* synthetic */ Set access$100(NetworkFailoverStrategy r0) {
        return r0.mIpChangeErrorCodeSet;
    }

    static /* synthetic */ List access$1000(NetworkFailoverStrategy r0) {
        return r0.mIoTimeoutList;
    }

    static /* synthetic */ List access$1100(NetworkFailoverStrategy r0) {
        return r0.mConnectTimeoutList;
    }

    static /* synthetic */ int access$200(NetworkFailoverStrategy r0) {
        return r0.mDownloadId;
    }

    static /* synthetic */ int access$300(NetworkFailoverStrategy r0) {
        return r0.mIsolationCount;
    }

    static /* synthetic */ Set access$400(NetworkFailoverStrategy r0) {
        return r0.mIsolationErrorCodeSet;
    }

    static /* synthetic */ int access$500(NetworkFailoverStrategy r0) {
        return r0.mIsolationHttpProtoType;
    }

    static /* synthetic */ int access$600(NetworkFailoverStrategy r0) {
        return r0.mBackHostCountLimit;
    }

    static /* synthetic */ List access$700(NetworkFailoverStrategy r0) {
        return r0.mBackHostList;
    }

    static /* synthetic */ Set access$800(NetworkFailoverStrategy r0) {
        return r0.mBackHostErrorCodeSet;
    }

    static /* synthetic */ Set access$900(NetworkFailoverStrategy r0) {
        return r0.mTimeoutErrorCodeSet;
    }

    public NetworkFailoverStrategy(DownloadInfo r20) {
        this.mIsolationErrorCodeSet = new HashSet();
        this.mIsolationCount = 0;
        this.mIsolationHttpProtoType = 0;
        this.mTimeoutErrorCodeSet = new HashSet();
        this.mConnectTimeoutList = new ArrayList();
        this.mIoTimeoutList = new ArrayList();
        this.mIpChangeErrorCodeSet = new HashSet();
        this.mIpChangeCountLimit = 0;
        this.mBackHostList = new ArrayList();
        this.mBackHostErrorCodeSet = new HashSet();
        this.mBackHostCountLimit = 0;
        this.mFailoverStrategyList = new ArrayList();
        this.mDownloadId = 0;
        initInternal(r20);     // Catch: Throwable -> L7
        if (Logger.debugScene(r20) == false) goto L16;
        Logger.taskDebug(TAG, r20, TAG, "Init ttnetIsolationCount:" + this.mIsolationCount + " mIsolationErrorCodeSet:" + this.mIsolationErrorCodeSet.toString() + " mIsolationHttpProtoType:" + this.mIsolationHttpProtoType + " ttnetTimeoutErrorCodes:" + this.mTimeoutErrorCodeSet.toString() + " ttnetConnectTimeout:" + this.mConnectTimeoutList.toString() + " ttnetIoTimeout:" + this.mIoTimeoutList.toString() + " ipChangeCountLimit:" + this.mIpChangeCountLimit + " ipChangeErrorCodeSet:" + this.mIpChangeErrorCodeSet + " host:" + this.mDownloadHost + " backHostList:" + this.mBackHostList.toString() + " backHostCountLimit:" + this.mBackHostCountLimit + " backHostErrorCodeSet:" + this.mBackHostErrorCodeSet);
    L16:
        this.mFailoverStrategyList.add(new TimeoutStrategyImpl(this));
        this.mFailoverStrategyList.add(new DefaultIpChangeStrategyImpl(this));
        this.mFailoverStrategyList.add(new IsolationIpChangeStrategyImpl(this));
        this.mFailoverStrategyList.add(new BackHostStrategyImpl(this));
        this.mFailoverStrategyList.add(new TimeoutStrategyImpl(this));
        return;
    L7:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L22
        Logger.taskError(TAG, this.mDownloadId, TAG, "Init Error" + th.toString());     // Catch: Throwable -> L18
        if (Logger.debugScene(r20) == false) goto L16;
        Logger.taskDebug(TAG, r20, TAG, "Init ttnetIsolationCount:" + this.mIsolationCount + " mIsolationErrorCodeSet:" + this.mIsolationErrorCodeSet.toString() + " mIsolationHttpProtoType:" + this.mIsolationHttpProtoType + " ttnetTimeoutErrorCodes:" + this.mTimeoutErrorCodeSet.toString() + " ttnetConnectTimeout:" + this.mConnectTimeoutList.toString() + " ttnetIoTimeout:" + this.mIoTimeoutList.toString() + " ipChangeCountLimit:" + this.mIpChangeCountLimit + " ipChangeErrorCodeSet:" + this.mIpChangeErrorCodeSet + " host:" + this.mDownloadHost + " backHostList:" + this.mBackHostList.toString() + " backHostCountLimit:" + this.mBackHostCountLimit + " backHostErrorCodeSet:" + this.mBackHostErrorCodeSet);
    L18:
        th = th;
        DownloadInfo r3 = r20;
        String r2 = " backHostErrorCodeSet:";
    L25:
        if (Logger.debugScene(r20) == false) goto L28;
        Throwable r16 = th;
        Logger.taskDebug(TAG, r3, TAG, "Init ttnetIsolationCount:" + this.mIsolationCount + " mIsolationErrorCodeSet:" + this.mIsolationErrorCodeSet.toString() + " mIsolationHttpProtoType:" + this.mIsolationHttpProtoType + " ttnetTimeoutErrorCodes:" + this.mTimeoutErrorCodeSet.toString() + " ttnetConnectTimeout:" + this.mConnectTimeoutList.toString() + " ttnetIoTimeout:" + this.mIoTimeoutList.toString() + " ipChangeCountLimit:" + this.mIpChangeCountLimit + " ipChangeErrorCodeSet:" + this.mIpChangeErrorCodeSet + " host:" + this.mDownloadHost + " backHostList:" + this.mBackHostList.toString() + " backHostCountLimit:" + this.mBackHostCountLimit + r2 + this.mBackHostErrorCodeSet);
        throw r16;
    L28:
        throw th;
    L20:
        th = th;
        r2 = " backHostErrorCodeSet:";
        r3 = r20;
    L22:
        th = th;
        r3 = r20;
        r2 = " backHostErrorCodeSet:";
        goto L25
    }

    private void initInternal(DownloadInfo r9) {
        if (r9 == null) goto L5;
        this.mDownloadId = r9.getId();
        this.mDownloadHost = new URL(r9.getUrl()).getHost();
        JSONObject r10 = DownloadSetting.obtain(this.mDownloadId).optJSONObject(DownloadSettingKeys.NETWORK_FAILOVER_STRATEGY);
    L6:
        if (r10 != null) goto L8;
        return;
    L8:
        int r0 = r10.optInt(DownloadSettingKeys.NetworkFailoverStrategy.KEY_TTNET_BACK_HOST_COUNT_LIMIT);
        if (r0 <= 0) goto L11;
        this.mBackHostCountLimit = r0;
    L11:
        JSONArray r1 = r10.optJSONArray(DownloadSettingKeys.NetworkFailoverStrategy.KEY_TTNET_BACK_HOST);
        int r3 = 0;
        if (TextUtils.isEmpty(this.mDownloadHost) == true) goto L40;
        if (r1 == null) goto L40;
        if (r1.length() <= 0) goto L40;
        int r2 = 0;
    L18:
        if (r2 >= r1.length()) goto L40;
        String r5 = r1.optString(r2);
        if (TextUtils.isEmpty(r5) == true) goto L39;
        String[] r6 = r5.split(":");
        if (r6 == null) goto L39;
        if (r6.length != 2) goto L39;
        if (this.mDownloadHost.equals(r6[0]) == false) goto L39;
        if (TextUtils.isEmpty(r6[1]) == true) goto L39;
        String[] r4 = r6[1].split(",");
        if (r4 == null) goto L40;
        if (r4.length <= 0) goto L40;
        int r7 = r4.length;
        int r8 = 0;
    L34:
        if (r8 >= r7) goto L40;
        String r11 = r4[r8];
        if (TextUtils.isEmpty(r11) == true) goto L38;
        this.mBackHostList.add(r11);
    L38:
        r8 = r8 + 1;
    L39:
        r2 = r2 + 1;
    L40:
        JSONArray r12 = r10.optJSONArray(DownloadSettingKeys.NetworkFailoverStrategy.KEY_TTNET_BACK_HOST_ERROR_CODE);
        if (r12 != null) goto L43;
    L51:
        int r13 = r10.optInt(DownloadSettingKeys.NetworkFailoverStrategy.KEY_TTNET_ISOLATION_COUNT);
        if (r13 <= 0) goto L54;
        this.mIsolationCount = r13;
    L54:
        JSONArray r14 = r10.optJSONArray(DownloadSettingKeys.NetworkFailoverStrategy.KEY_TTNET_ISOLATION_ERROR_CODE);
        if (r14 != null) goto L57;
    L65:
        int r15 = r10.optInt(DownloadSettingKeys.NetworkFailoverStrategy.KEY_TTNET_ISOLATION_HTTP_PROTO_TYPE);
        if (1 == r15) goto L70;
        if (2 == r15) goto L70;
        if (3 == r15) goto L70;
    L71:
        JSONArray r16 = r10.optJSONArray(DownloadSettingKeys.NetworkFailoverStrategy.KEY_TTNET_TIMEOUT_ERROR_CODE);
        if (r16 != null) goto L74;
    L82:
        JSONArray r17 = r10.optJSONArray(DownloadSettingKeys.NetworkFailoverStrategy.KEY_TTNET_TIMEOUT_CONNECT);
        if (r17 != null) goto L85;
    L93:
        JSONArray r18 = r10.optJSONArray(DownloadSettingKeys.NetworkFailoverStrategy.KEY_TTNET_TIMEOUT_IO);
        if (r18 != null) goto L96;
    L104:
        JSONArray r19 = r10.optJSONArray(DownloadSettingKeys.NetworkFailoverStrategy.KEY_TTNET_IP_CHANGE_ERROR_CODE);
        if (r19 != null) goto L107;
    L114:
        int r20 = r10.optInt(DownloadSettingKeys.NetworkFailoverStrategy.KEY_TTNET_IP_CHANGE_COUNT_LIMIT);
        if (r20 <= 0) goto L146;
        this.mIpChangeCountLimit = r20;
        return;
    L146:
        return;
    L107:
        if (r19.length() <= 0) goto L114;
    L109:
        if (r3 >= r19.length()) goto L114;
        int r21 = r19.optInt(r3);
        if (r21 <= 0) goto L113;
        this.mIpChangeErrorCodeSet.add(Integer.valueOf(r21));
    L113:
        r3 = r3 + 1;
        goto L109
    L96:
        if (r18.length() <= 0) goto L104;
        int r22 = 0;
    L99:
        if (r22 >= r18.length()) goto L104;
        long r23 = r18.optLong(r22);
        if (r23 <= 0) goto L103;
        this.mIoTimeoutList.add(Long.valueOf(r23));
    L103:
        r22 = r22 + 1;
        goto L99
    L85:
        if (r17.length() <= 0) goto L93;
        int r24 = 0;
    L88:
        if (r24 >= r17.length()) goto L93;
        long r25 = r17.optLong(r24);
        if (r25 <= 0) goto L92;
        this.mConnectTimeoutList.add(Long.valueOf(r25));
    L92:
        r24 = r24 + 1;
        goto L88
    L74:
        if (r16.length() <= 0) goto L82;
        int r26 = 0;
    L77:
        if (r26 >= r16.length()) goto L82;
        int r27 = r16.optInt(r26);
        if (r27 <= 0) goto L81;
        this.mTimeoutErrorCodeSet.add(Integer.valueOf(r27));
    L81:
        r26 = r26 + 1;
    L70:
        this.mIsolationHttpProtoType = r15;
        goto L71
    L57:
        if (r14.length() <= 0) goto L65;
        int r28 = 0;
    L60:
        if (r28 >= r14.length()) goto L65;
        int r29 = r14.optInt(r28);
        if (r29 <= 0) goto L64;
        this.mIsolationErrorCodeSet.add(Integer.valueOf(r29));
    L64:
        r28 = r28 + 1;
        goto L60
    L43:
        if (r12.length() <= 0) goto L51;
        int r30 = 0;
    L46:
        if (r30 >= r12.length()) goto L51;
        int r31 = r12.optInt(r30);
        if (r31 <= 0) goto L50;
        this.mBackHostErrorCodeSet.add(Integer.valueOf(r31));
    L50:
        r30 = r30 + 1;
        goto L46
    L5:
        r10 = DownloadSetting.obtainGlobal().optJSONObject(DownloadSettingKeys.NETWORK_FAILOVER_STRATEGY);
        goto L6
    }

    public void handleError(BaseException r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        Iterator<FailoverStrategy> r3 = this.mFailoverStrategyList.iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        FailoverStrategy r0 = (FailoverStrategy) ZeusTransformUtils.preCheckCast(r3.next(), FailoverStrategy.class, "com.obric.aiagent.plugin");
        boolean r1 = r0.handleError(r4);
        if (r0.isFailoverOnly() == false) goto L6;
        if (r1 == false) goto L6;
        return;
    }

    public void handleHeader(List<HttpHeader> r4) {
        List<HttpHeader> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        Iterator<FailoverStrategy> r3 = this.mFailoverStrategyList.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        ((FailoverStrategy) ZeusTransformUtils.preCheckCast(r3.next(), FailoverStrategy.class, "com.obric.aiagent.plugin")).handleHeader(r5);
        goto L7
    }
}
