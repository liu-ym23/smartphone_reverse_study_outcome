package a35;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.mira.conig.Constants;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ml5.b f1529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReadWriteLock f1530b;

    public b0() {
        this.f1529a = new ml5.b("sync_offline_retry_recorder");
        this.f1530b = new ReentrantReadWriteLock();
    }

    public final void a(OfflineDoc r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r100.getObj_token()) == true) goto L15;
        AccountService$Account r101 = ((h0) org.koin.java.a.a(h0.class)).G2();
        String r102 = d(r101, r100.getObj_token());
        if (TextUtils.isEmpty(r102) == false) goto L9;
        return;
    L9:
        g(r102, r100.getObj_token(), true, -1);
        if (c(r102, r100) != 1) goto L14;
        h(e(r101, r100.getObj_token()), System.currentTimeMillis(), r100.getObj_token());
        return;
    L14:
        return;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [F, java.lang.Boolean, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v2, types: [F, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r0v3, types: [S, java.lang.Integer] */
    public final com.bytedance.apm.util.n<Boolean, Integer> b(OfflineDoc r210) {
        ?? r100 = Boolean.FALSE;
        com.bytedance.apm.util.n<Boolean, Integer> r101 = new com.bytedance.apm.util.n(r100, 0);
        if (r210 != null) goto L5;
    L33:
        r101.f190676a = r100;
        return r101;
    L5:
        if (TextUtils.isEmpty(r210.getObj_token()) == true) goto L33;
        AccountService$Account r102 = ((h0) org.koin.java.a.a(h0.class)).G2();
        String r103 = d(r102, r210.getObj_token());
        if (TextUtils.isEmpty(r103) == false) goto L11;
        r101.f190676a = r100;
        return r101;
    L11:
        int r104 = c(r103, r210);
        boolean r105 = true;
        if (r104 > 2) goto L14;
        boolean r106 = true;
    L15:
        if (r106 == true) goto L30;
        String r107 = e(r102, r210.getObj_token());
        ((ReentrantReadWriteLock) this.f1530b).readLock().lock();     // Catch: Throwable -> L19 Exception -> L21
        tt5.a.b("SyncOfflineRecorder", "fetchLastSyncTimeStamp... for doc : " + r210.getObj_token());     // Catch: Throwable -> L19 Exception -> L21
        long r110 = this.f1529a.f514368a.getLong(r107, 0);     // Catch: Throwable -> L19 Exception -> L21
        tt5.a.b("SyncOfflineRecorder", "fetchLastSyncTimeStamp... target doc : " + r210.getObj_token() + " last sync time : " + r110);     // Catch: Throwable -> L19 Exception -> L21
        ((ReentrantReadWriteLock) this.f1530b).readLock().unlock();
    L24:
        long r111 = System.currentTimeMillis();
        tt5.a.h("SyncOfflineRecorder", "can`t sync, last sync time = " + r110);
        if (Math.abs(r111 - r110) < Constants.DOWNLOAD_TEMP_FILE_PAST_TIME) goto L27;
        tt5.a.h("SyncOfflineRecorder", "last sync time is one day ago from: " + r110 + "to : " + r111);
        f(r210.getObj_token());
        h(e(r102, r210.getObj_token()), 0, r210.getObj_token());
        int r108 = 0;
    L31:
        r101.f190676a = Boolean.valueOf(r105);
        r101.f190677b = Integer.valueOf(r108);
        return r101;
    L27:
        tt5.a.d("SyncOfflineRecorder", "too many trials within one day, shall be reject");
        goto L30
    L19:
        th = move-exception;
        ((ReentrantReadWriteLock) this.f1530b).readLock().unlock();
        throw th;
    L21:
        e = move-exception;
        tt5.a.e("SyncOfflineRecorder", "fetchLastSyncTimeStamp... err happens", e, false);     // Catch: Throwable -> L19
        ((ReentrantReadWriteLock) this.f1530b).readLock().unlock();
        r110 = 0;
    L30:
        r108 = r104;
        r105 = r106;
        goto L31
    L14:
        r106 = false;
        goto L15
    }

    public final void f(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        AccountService$Account r101 = ((h0) org.koin.java.a.a(h0.class)).G2();
        String r102 = d(r101, r100);
        if (TextUtils.isEmpty(r102) == false) goto L8;
        return;
    L8:
        g(r102, r100, false, 0);
        h(e(r101, r100), 0, r100);
    }

    public static String d(AccountService$Account r100, String r101) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (TextUtils.isEmpty(r100.uid) == false) goto L6;
        return "";
    L6:
        if (TextUtils.isEmpty(r100.token) == false) goto L8;
        return "";
    L8:
        if (TextUtils.isEmpty(r101) == false) goto L11;
        return "";
    L11:
        return r100.uid + "-" + r100.token + "-" + r101;
    }

    public static String e(AccountService$Account r100, String r101) {
        String r102 = d(r100, r101);
        if (TextUtils.isEmpty(r102) == false) goto L7;
        return "";
    L7:
        return "last_sync_time_" + r102;
    }

    public final int c(String r100, OfflineDoc r101) {
        ((ReentrantReadWriteLock) this.f1530b).readLock().lock();     // Catch: Exception -> L6 Throwable -> L8
        tt5.a.b("SyncOfflineRecorder", "fetchRetryTimes... for doc : " + r101.getObj_token());     // Catch: Exception -> L6 Throwable -> L8
        int r102 = this.f1529a.f514368a.getInt(r100, 0);     // Catch: Exception -> L6 Throwable -> L8
        tt5.a.b("SyncOfflineRecorder", "fetchRetryTimes... target doc : " + r101.getObj_token() + " retry times : " + r102);     // Catch: Exception -> L6 Throwable -> L8
        ((ReentrantReadWriteLock) this.f1530b).readLock().unlock();
        return r102;
    L8:
        th = move-exception;
        ((ReentrantReadWriteLock) this.f1530b).readLock().unlock();
        throw th;
    L6:
        e = move-exception;
        tt5.a.e("SyncOfflineRecorder", "fetchRetryTimes... err happens", e, false);     // Catch: Throwable -> L8
        ((ReentrantReadWriteLock) this.f1530b).readLock().unlock();
        return 0;
    }

    public final void h(String r100, long r101, String r102) {
        ((ReentrantReadWriteLock) this.f1530b).writeLock().lock();     // Catch: Throwable -> L6 Exception -> L8
        tt5.a.b("SyncOfflineRecorder", "writeLastSyncTimeStamp... for doc : " + r102);     // Catch: Throwable -> L6 Exception -> L8
        if (r101 != 0) goto L10;
        ml5.b r103 = this.f1529a;     // Catch: Throwable -> L6 Exception -> L8
        r103.getClass();     // Catch: Throwable -> L6 Exception -> L8
        Intrinsics.checkNotNullParameter(r100, "key");     // Catch: Throwable -> L6 Exception -> L8
        String r104 = r100.toString();     // Catch: Throwable -> L6 Exception -> L8
        ml5.b.a r105 = r103.f514368a;     // Catch: Throwable -> L6 Exception -> L8
        r105.getClass();     // Catch: Throwable -> L6 Exception -> L8
        r105.remove(r104);     // Catch: Throwable -> L6 Exception -> L8
    L11:
        tt5.a.b("SyncOfflineRecorder", "writeLastSyncTimeStamp... target doc : " + r102 + " last sync time : " + r101);     // Catch: Throwable -> L6 Exception -> L8
    L14:
        ((ReentrantReadWriteLock) this.f1530b).writeLock().unlock();
        return;
    L10:
        this.f1529a.b(r100, Long.valueOf(r101));     // Catch: Throwable -> L6 Exception -> L8
    L8:
        e = move-exception;
        tt5.a.e("SyncOfflineRecorder", "writeLastSyncTimeStamp... err happens", e, false);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        ((ReentrantReadWriteLock) this.f1530b).writeLock().unlock();
        throw th;
    }

    public final void g(String r100, String r101, boolean r102, int r103) {
        ((ReentrantReadWriteLock) this.f1530b).writeLock().lock();     // Catch: Throwable -> L10 Exception -> L12
        tt5.a.b("SyncOfflineRecorder", "updateRetryTimes... for doc : " + r101);     // Catch: Throwable -> L10 Exception -> L12
        int r104 = ((Integer) this.f1529a.a(r100, 0)).intValue();     // Catch: Throwable -> L10 Exception -> L12
        if (r102 == false) goto L8;
        int r105 = r104 + 1;
        this.f1529a.b(r100, Integer.valueOf(r105));     // Catch: Throwable -> L10 Exception -> L12
        tt5.a.b("SyncOfflineRecorder", "updateRetryTimes... target doc : " + r101 + " retry times set to be : " + r105);     // Catch: Throwable -> L10 Exception -> L12
    L23:
    L17:
        ((ReentrantReadWriteLock) this.f1530b).writeLock().unlock();
        return;
    L8:
        if (r103 != 0) goto L14;
        ml5.b r106 = this.f1529a;     // Catch: Throwable -> L10 Exception -> L12
        r106.getClass();     // Catch: Throwable -> L10 Exception -> L12
        Intrinsics.checkNotNullParameter(r100, "key");     // Catch: Throwable -> L10 Exception -> L12
        String r107 = r100.toString();     // Catch: Throwable -> L10 Exception -> L12
        ml5.b.a r108 = r106.f514368a;     // Catch: Throwable -> L10 Exception -> L12
        r108.getClass();     // Catch: Throwable -> L10 Exception -> L12
        r108.remove(r107);     // Catch: Throwable -> L10 Exception -> L12
        tt5.a.b("SyncOfflineRecorder", "updateRetryTimes... target doc : " + r101 + " retry times shall be removed");     // Catch: Throwable -> L10 Exception -> L12
        goto L23
    L14:
        this.f1529a.b(r100, Integer.valueOf(r103));     // Catch: Throwable -> L10 Exception -> L12
        tt5.a.b("SyncOfflineRecorder", "updateRetryTimes... target doc : " + r101 + " retry times set to be : " + r103);     // Catch: Throwable -> L10 Exception -> L12
    L10:
        th = move-exception;
        ((ReentrantReadWriteLock) this.f1530b).writeLock().unlock();
        throw th;
    L12:
        e = move-exception;
        tt5.a.e("SyncOfflineRecorder", "updateRetryTimes... err happens : ", e, false);     // Catch: Throwable -> L10
        goto L17
    }
}
