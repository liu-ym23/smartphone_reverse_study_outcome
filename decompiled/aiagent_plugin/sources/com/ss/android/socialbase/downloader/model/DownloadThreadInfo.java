package com.ss.android.socialbase.downloader.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadThreadInfo {
    public Map<String, ThreadExecutorInfo> afterDownloadThreadExecutors;
    public Map<String, ThreadExecutorInfo> beforeDownloadThreadExecutors;

    public static class ThreadExecutorInfo {
        public int activeCount;
        public int corePoolSize;
        public int maximumPoolSize;
        public int queueSize;

        public ThreadExecutorInfo() {
        }
    }

    public DownloadThreadInfo() {
        this.beforeDownloadThreadExecutors = new ConcurrentHashMap();
        this.afterDownloadThreadExecutors = new ConcurrentHashMap();
    }

    public static ThreadExecutorInfo parse(ExecutorService r3) {
        ExecutorService r4 = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r3, ExecutorService.class, "com.obric.aiagent.plugin");
        ThreadExecutorInfo r0 = new ThreadExecutorInfo();
        if (r4 != null) goto L5;
    L7:
        return r0;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, ThreadPoolExecutor.class) == false) goto L7;
        ThreadPoolExecutor r5 = (ThreadPoolExecutor) ZeusTransformUtils.preCheckCast(r4, ThreadPoolExecutor.class, "com.obric.aiagent.plugin");
        r0.activeCount = r5.getActiveCount();
        r0.corePoolSize = r5.getCorePoolSize();
        r0.maximumPoolSize = r5.getMaximumPoolSize();
        r0.queueSize = r5.getQueue().size();
        goto L7
    }

    public JSONObject obtainStats() {
        JSONObject r0 = new JSONObject();
        r0.put("beforeDownload", translate(this.beforeDownloadThreadExecutors));     // Catch: Throwable -> L5
        r0.put("afterDownload", translate(this.afterDownloadThreadExecutors));     // Catch: Throwable -> L5
    L7:
        return r0;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }

    private JSONObject translate(Map<String, ThreadExecutorInfo> r7) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        JSONObject r8 = new JSONObject();
        Iterator r9 = r6.entrySet().iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        ThreadExecutorInfo r2 = (ThreadExecutorInfo) ZeusTransformUtils.preCheckCast(r1.getValue(), ThreadExecutorInfo.class, "com.obric.aiagent.plugin");
        JSONObject r3 = new JSONObject();
        r3.put("active", r2.activeCount);
        r3.put("core", r2.corePoolSize);
        r3.put("max", r2.maximumPoolSize);
        r3.put("queue", r2.queueSize);
        r8.put((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin"), r3);
        goto L4
    L6:
        return r8;
    }

    public DownloadThreadInfo copy() {
        DownloadThreadInfo r0 = new DownloadThreadInfo();
        Iterator<Map.Entry<String, ThreadExecutorInfo>> r1 = this.beforeDownloadThreadExecutors.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        Map<String, ThreadExecutorInfo> r3 = r0.beforeDownloadThreadExecutors;
        Object r4 = r2.getKey();
        r3.put((String) r4, (ThreadExecutorInfo) r2.getValue());
        goto L4
    L6:
        Iterator<Map.Entry<String, ThreadExecutorInfo>> r5 = this.afterDownloadThreadExecutors.entrySet().iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        Map<String, ThreadExecutorInfo> r7 = r0.afterDownloadThreadExecutors;
        Object r8 = r6.getKey();
        r7.put((String) r8, (ThreadExecutorInfo) r6.getValue());
        goto L8
    L10:
        return r0;
    }

    public void reset() {
        this.beforeDownloadThreadExecutors.clear();
        this.afterDownloadThreadExecutors.clear();
    }
}
