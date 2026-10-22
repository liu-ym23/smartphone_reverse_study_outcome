package com.ss.android.socialbase.downloader.network;

import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.thread.DownloadWatchDog;
import com.ss.android.socialbase.downloader.utils.LruCache;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.InetAddress;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadDnsManager {
    private static volatile DownloadDnsManager INSTANCE;
    private final LruCache<String, DnsRecord> cache;
    private final Handler cpuHandler;
    private final Looper mLooper;
    private final Handler networkHandler;

    public interface Callback {
        void onDnsResolved(String r1, List<InetAddress> r2);
    }

    private static class DnsRecord {
        long timestamp;
        List<InetAddress> value;

        private DnsRecord() {
        }

        /* synthetic */ DnsRecord(AnonymousClass1 r1) {
            this();
        }
    }

    static /* synthetic */ void access$000(DownloadDnsManager r2, String r3, Callback r4, long r5) {
        r2.resolveDns(r3, (Callback) ZeusTransformUtils.wrapperContextForParams(r4, Callback.class, "com.obric.aiagent.plugin"), r5);
    }

    private DownloadDnsManager() {
        this.cache = new LruCache(4, 16, false);
        HandlerThread r0 = new HandlerThread("Network-Handler");
        r0.start();
        Looper r1 = r0.getLooper();
        this.mLooper = r1;
        this.networkHandler = new Handler(r1);
        this.cpuHandler = new Handler(DownloadWatchDog.getThreadLooper());
    }

    public static DownloadDnsManager getInstance() {
        if (INSTANCE != null) goto L15;
        monitor-enter(DownloadDnsManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (INSTANCE != null) goto L9;
        INSTANCE = new DownloadDnsManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadDnsManager.class);     // Catch: Throwable -> L11
    L15:
        return INSTANCE;
    }

    public void resolveDnsAsync(final String r8, Callback r9, final long r10) {
        final Callback r3 = (Callback) ZeusTransformUtils.wrapperContextForParams(r9, Callback.class, "com.obric.aiagent.plugin");
        this.networkHandler.post(new AnonymousClass1(this, r8, r3, r10));
    }

    private void resolveDns(final String r8, Callback r9, long r10) {
        final Callback r11 = (Callback) ZeusTransformUtils.wrapperContextForParams(r9, Callback.class, "com.obric.aiagent.plugin");
        String r0 = Uri.parse(r8).getHost();     // Catch: Throwable -> L43
        LruCache<String, DnsRecord> r1 = this.cache;     // Catch: Throwable -> L43
        monitor-enter(r1);     // Catch: Throwable -> L43
        final DnsRecord r2 = (DnsRecord) ZeusTransformUtils.preCheckCast(this.cache.get(r0), DnsRecord.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L40
        monitor-exit(r1);     // Catch: Throwable -> L40
        if (r2 != null) goto L9;
    L13:
        Runnable r3 = new AnonymousClass2(this, r11, r8, r2);     // Catch: Throwable -> L43
        this.cpuHandler.postDelayed(r3, r10);     // Catch: Throwable -> L43
        List<InetAddress> r12 = null;
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.USE_HOST_DNS, 1) != 1) goto L21;
        IDownloadDns r13 = DownloadComponentManager.getDownloadDns();     // Catch: Throwable -> L43
        if (r13 == null) goto L21;
        r12 = r13.lookup(r0);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L43
    L21:
        if (r12 == null) goto L46;
        if (r12.isEmpty() == true) goto L46;
    L29:
        if (r12 != null) goto L31;
    L34:
        if (r2 == null) goto L36;
        r12 = r2.value;     // Catch: Throwable -> L43
    L36:
        this.cpuHandler.removeCallbacks(r3);     // Catch: Throwable -> L43
        if (r11 == null) goto L54;
        r11.onDnsResolved(r8, r12);     // Catch: Throwable -> L43
        return;
    L54:
        return;
    L31:
        if (r12.isEmpty() == true) goto L34;
        updateIpAddressToCache(r0, r12);     // Catch: Throwable -> L43
    L46:
        r12 = DownloadComponentManager.getDefaultDownloadDns().lookup(r0);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L43
        goto L29
    L9:
        if ((System.currentTimeMillis() - r2.timestamp) >= ((DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.DNS_EXPIRE_MIN, 10) * 60) * 1000)) goto L13;
        if (r11 == null) goto L53;
        r11.onDnsResolved(r8, r2.value);     // Catch: Throwable -> L43
        return;
    L53:
        return;
    L40:
        th = move-exception;
        throw th;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        th.printStackTrace();
    }

    private void updateIpAddressToCache(String r5, List<InetAddress> r6) {
        List<InetAddress> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        LruCache<String, DnsRecord> r0 = this.cache;
        monitor-enter(r0);
        DnsRecord r1 = (DnsRecord) ZeusTransformUtils.preCheckCast(this.cache.get(r5), DnsRecord.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        if (r1 != null) goto L7;
        r1 = new DnsRecord(null);     // Catch: Throwable -> L10
        this.cache.put(r5, r1);     // Catch: Throwable -> L10
    L7:
        r1.value = r7;     // Catch: Throwable -> L10
        r1.timestamp = System.currentTimeMillis();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
