package com.ss.android.socialbase.downloader.core.module.pcdn;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.core.DownloadSingleResponseHandler;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PCDNStats {
    private int mCdnConcurrentCount;
    private long mCdnDur;
    private long mCdnSize;
    private long mCdnStartTime;
    private int mChunkRetryCount;
    private DownloadInfo mDownloadInfo;
    private int mPcdnConcurrentCount;
    private long mPcdnDur;
    private long mPcdnSize;
    private long mPcdnStartTime;
    private Map<String, UrlStats> mUrlStats;

    public class UrlStats {
        private int mCode;
        private int mConcurrentCount;
        private long mDuration;
        private String mErr;
        private boolean mIsPcdn;
        private int mProtocol;
        private long mSize;
        private long mStartTime;
        private int mTtfb;
        final /* synthetic */ PCDNStats this$0;

        public UrlStats(PCDNStats r1) {
            this.this$0 = r1;
        }

        static /* synthetic */ boolean access$000(UrlStats r0) {
            return r0.mIsPcdn;
        }

        static /* synthetic */ boolean access$002(UrlStats r0, boolean r1) {
            r0.mIsPcdn = r1;
            return r1;
        }

        static /* synthetic */ long access$100(UrlStats r2) {
            return r2.mStartTime;
        }

        static /* synthetic */ long access$102(UrlStats r0, long r1) {
            r0.mStartTime = r1;
            return r1;
        }

        static /* synthetic */ int access$200(UrlStats r0) {
            return r0.mConcurrentCount;
        }

        static /* synthetic */ int access$204(UrlStats r1) {
            int r0 = r1.mConcurrentCount + 1;
            r1.mConcurrentCount = r0;
            return r0;
        }

        static /* synthetic */ int access$206(UrlStats r1) {
            int r0 = r1.mConcurrentCount - 1;
            r1.mConcurrentCount = r0;
            return r0;
        }

        static /* synthetic */ int access$300(UrlStats r0) {
            return r0.mProtocol;
        }

        static /* synthetic */ int access$302(UrlStats r0, int r1) {
            r0.mProtocol = r1;
            return r1;
        }

        static /* synthetic */ int access$400(UrlStats r0) {
            return r0.mTtfb;
        }

        static /* synthetic */ int access$402(UrlStats r0, int r1) {
            r0.mTtfb = r1;
            return r1;
        }

        static /* synthetic */ int access$500(UrlStats r0) {
            return r0.mCode;
        }

        static /* synthetic */ int access$502(UrlStats r0, int r1) {
            r0.mCode = r1;
            return r1;
        }

        static /* synthetic */ String access$600(UrlStats r0) {
            return r0.mErr;
        }

        static /* synthetic */ String access$602(UrlStats r0, String r1) {
            r0.mErr = r1;
            return r1;
        }

        static /* synthetic */ long access$700(UrlStats r2) {
            return r2.mDuration;
        }

        static /* synthetic */ long access$702(UrlStats r0, long r1) {
            r0.mDuration = r1;
            return r1;
        }

        static /* synthetic */ long access$800(UrlStats r2) {
            return r2.mSize;
        }

        static /* synthetic */ long access$802(UrlStats r0, long r1) {
            r0.mSize = r1;
            return r1;
        }
    }

    public PCDNStats(DownloadInfo r2, int r3) {
        this.mUrlStats = new LinkedHashMap();
        this.mCdnConcurrentCount = 0;
        this.mPcdnConcurrentCount = 0;
        this.mDownloadInfo = r2;
        r2.setPcdnStats(null);
        this.mChunkRetryCount = r3;
    }

    public void beforeDownload(String r1, boolean r2) {
        monitor-enter(this);
        beforeUrlStats(r1, r2);     // Catch: Throwable -> L6
        afterTotalStats(r2);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void beforeUrlStats(String r6, boolean r7) {
        UrlStats r0 = (UrlStats) ZeusTransformUtils.preCheckCast(this.mUrlStats.get(r6), UrlStats.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new UrlStats(this);
        UrlStats.access$002(r0, r7);
    L6:
        if (UrlStats.access$100(r0) > 0) goto L8;
        UrlStats.access$102(r0, System.currentTimeMillis());
    L8:
        UrlStats.access$204(r0);
        this.mUrlStats.put(r6, r0);
    }

    private void afterTotalStats(boolean r5) {
        if (r5 == false) goto L9;
        if (this.mPcdnStartTime > 0) goto L7;
        this.mPcdnStartTime = System.currentTimeMillis();
    L7:
        this.mPcdnConcurrentCount++;
        return;
    L9:
        if (this.mCdnStartTime > 0) goto L11;
        this.mCdnStartTime = System.currentTimeMillis();
    L11:
        this.mCdnConcurrentCount++;
    }

    public void afterDownload(String r15, long r16, boolean r18, boolean r19, IDownloadHttpConnection r20, DownloadSingleResponseHandler r21, Throwable r22) {
        IDownloadHttpConnection r5 = (IDownloadHttpConnection) ZeusTransformUtils.wrapperContextForParams(r20, IDownloadHttpConnection.class, "com.obric.aiagent.plugin");
        monitor-enter(this);
        long r0 = 0;
        if (r21 != null) goto L13;
    L7:
        long r10 = r0;
        long r12 = System.currentTimeMillis();     // Catch: Throwable -> L10
        afterUrlStats(r12, r15, r5, r22, r19, r10);     // Catch: Throwable -> L10
        afterTotalStats(r12, r18, r10);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    L13:
        r0 = r21.getCurOffset() - r16;     // Catch: Throwable -> L10
        goto L7
    }

    private void afterUrlStats(long r6, String r8, IDownloadHttpConnection r9, Throwable r10, boolean r11, long r12) {
        IDownloadHttpConnection r13 = (IDownloadHttpConnection) ZeusTransformUtils.wrapperContextForParams(r9, IDownloadHttpConnection.class, "com.obric.aiagent.plugin");
        UrlStats r0 = (UrlStats) ZeusTransformUtils.preCheckCast(this.mUrlStats.get(r8), UrlStats.class, "com.obric.aiagent.plugin");
        if (UrlStats.access$300(r0) != 0) goto L16;
        if (r13 == null) goto L16;
        if (ZeusTransformUtils.instanceOf(r13, AbsDownloadHttpConnection.class) == false) goto L16;
        AbsDownloadHttpConnection r2 = (AbsDownloadHttpConnection) ZeusTransformUtils.preCheckCast(r13, AbsDownloadHttpConnection.class, "com.obric.aiagent.plugin");
        if (r2.isOkhttp() == true) goto L15;
        UrlStats.access$302(r0, 4);
        String r3 = r2.getRequestLog();
        if (TextUtils.isEmpty(r3) == true) goto L16;
        JSONObject r4 = new JSONObject(r3);     // Catch: Throwable -> L13
        UrlStats.access$302(r0, r4.optJSONObject("response").optInt("connection_info"));     // Catch: Throwable -> L13
        UrlStats.access$402(r0, r4.optJSONObject("timing").optJSONObject("detailed_duration").optInt(MonitorConstants.TTFB));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.printStackTrace();
        goto L16
    L15:
        UrlStats.access$302(r0, 1);
    L16:
        if (r10 == null) goto L23;
        if (r11 == true) goto L23;
        if (ZeusTransformUtils.instanceOf(r10, BaseException.class) == false) goto L21;
        UrlStats.access$502(r0, ((BaseException) ZeusTransformUtils.preCheckCast(r10, BaseException.class, "com.obric.aiagent.plugin")).getErrorCode());
    L22:
        UrlStats.access$602(r0, r10.toString());
    L28:
        UrlStats.access$206(r0);
        UrlStats.access$702(r0, UrlStats.access$700(r0) + (r6 - UrlStats.access$100(r0)));
        if (UrlStats.access$200(r0) != 0) goto L31;
        UrlStats.access$102(r0, 0);
    L32:
        UrlStats.access$802(r0, UrlStats.access$800(r0) + r12);
        this.mUrlStats.put(r8, r0);
        return;
    L31:
        UrlStats.access$102(r0, r6);
        goto L32
    L21:
        UrlStats.access$502(r0, 1000);
    L23:
        if (r13 == null) goto L28;
        UrlStats.access$502(r0, r13.getResponseCode());     // Catch: Throwable -> L26
        UrlStats.access$602(r0, "");     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        th.printStackTrace();
        goto L28
    }

    private void afterTotalStats(long r5, boolean r7, long r8) {
        if (r7 == false) goto L8;
        int r9 = this.mPcdnConcurrentCount - 1;
        this.mPcdnConcurrentCount = r9;
        this.mPcdnSize += r8;
        this.mPcdnDur += r5 - this.mPcdnStartTime;
        if (r9 != 0) goto L7;
        this.mPcdnStartTime = 0;
        return;
    L7:
        this.mPcdnStartTime = r5;
        return;
    L8:
        int r10 = this.mCdnConcurrentCount - 1;
        this.mCdnConcurrentCount = r10;
        this.mCdnSize += r8;
        this.mCdnDur += r5 - this.mCdnStartTime;
        if (r10 != 0) goto L11;
        this.mCdnStartTime = 0;
        return;
    L11:
        this.mCdnStartTime = r5;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void collectPCDNStats() {
        monitor-enter(this);
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L9
        r0.put(MonitorConstants.PCDN_BUSINESSID, this.mDownloadInfo.getMonitorScene());     // Catch: Throwable -> L9
        r0.put(MonitorConstants.PCDN_SIZE, this.mPcdnSize);     // Catch: Throwable -> L9
        r0.put(MonitorConstants.PCDN_DUR, this.mPcdnDur);     // Catch: Throwable -> L9
        r0.put(MonitorConstants.CDN_SIZE, this.mCdnSize);     // Catch: Throwable -> L9
        r0.put(MonitorConstants.CDN_DUR, this.mCdnDur);     // Catch: Throwable -> L9
        r0.put(MonitorConstants.RETRY_TIMES_MAX, this.mChunkRetryCount);     // Catch: Throwable -> L9
        JSONArray r1 = new JSONArray();     // Catch: Throwable -> L9
        Iterator<Map.Entry<String, UrlStats>> r2 = this.mUrlStats.entrySet().iterator();     // Catch: Throwable -> L9
    L5:
        if (r2.hasNext() == false) goto L7;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        JSONObject r4 = new JSONObject();     // Catch: Throwable -> L9
        r4.put("url", r3.getKey());     // Catch: Throwable -> L9
        UrlStats r5 = (UrlStats) ZeusTransformUtils.preCheckCast(r3.getValue(), UrlStats.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        r4.put(MonitorConstants.IS_PCDN, UrlStats.access$000(r5));     // Catch: Throwable -> L9
        r4.put(MonitorConstants.CODE, UrlStats.access$500(r5));     // Catch: Throwable -> L9
        r4.put(MonitorConstants.SIZE, UrlStats.access$800(r5));     // Catch: Throwable -> L9
        r4.put("duration", UrlStats.access$700(r5));     // Catch: Throwable -> L9
        r4.put(MonitorConstants.PROTOCOL, UrlStats.access$300(r5));     // Catch: Throwable -> L9
        r4.put(MonitorConstants.TTFB, UrlStats.access$400(r5));     // Catch: Throwable -> L9
        r4.put(MonitorConstants.ERR, UrlStats.access$600(r5));     // Catch: Throwable -> L9
        r1.put(r4);     // Catch: Throwable -> L9
        goto L5
    L7:
        r0.put(MonitorConstants.URLS, r1);     // Catch: Throwable -> L9
        this.mDownloadInfo.setPcdnStats(r0);     // Catch: Throwable -> L9
    L11:
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L9:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }
}
