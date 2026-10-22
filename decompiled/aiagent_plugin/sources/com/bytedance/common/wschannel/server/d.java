package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: FrontierPersistentBuffer.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    private static final String TAG = "d";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f7050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MappedByteBuffer f7051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PriorityQueue<Integer> f7052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap<String, a> f7053d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f7054e;

    /* JADX INFO: compiled from: FrontierPersistentBuffer.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f7063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f7064b;

        public a(long r1, int r3) {
            this.f7063a = r1;
            this.f7064b = r3;
        }

        public long a() {
            return this.f7063a;
        }

        public int b() {
            return this.f7064b;
        }

        public void a(int r1) {
            this.f7064b = r1;
        }
    }

    static {
    }

    static /* synthetic */ int a(d r0, String r1, long r2) {
        return r0.b(r1, r2);
    }

    static /* synthetic */ AtomicBoolean a(d r0) {
        return r0.f7054e;
    }

    static /* synthetic */ void a(d r0, int r1) {
        r0.c(r1);
    }

    static /* synthetic */ void a(d r0, String r1, int r2, long r3) {
        r0.a(r1, r2, r3);
    }

    static /* synthetic */ String b() {
        return TAG;
    }

    static /* synthetic */ void b(d r0) {
        r0.j();
    }

    static /* synthetic */ ConcurrentHashMap c(d r0) {
        return r0.f7053d;
    }

    static /* synthetic */ void d(d r0) {
        r0.k();
    }

    public d(Context r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        this.f7050a = new byte[40];
        this.f7052c = new PriorityQueue();
        this.f7053d = new ConcurrentHashMap();
        this.f7054e = new AtomicBoolean(false);
        long r1 = System.currentTimeMillis();     // Catch: Throwable -> L23
        FileChannel r15 = new RandomAccessFile(com.bytedance.common.wschannel.e.a.a(r14), "rw").getChannel();     // Catch: Throwable -> L23
        FileLock r3 = r15.tryLock();     // Catch: Throwable -> L21
        this.f7051b = r15.map(FileChannel.MapMode.READ_WRITE, 0, PlaybackStateCompat.ACTION_SET_REPEAT_MODE);     // Catch: Throwable -> L19
        if (Logger.debug() == false) goto L9;
        Logger.d(TAG, "magic number: " + d() + " file version: " + e() + " total count: " + f() + " total bytes: " + g());     // Catch: Throwable -> L19
    L9:
        if (d() == 2114) goto L11;
    L16:
        h();     // Catch: Throwable -> L19
    L17:
        com.bytedance.common.wschannel.e.d r4 = com.bytedance.common.wschannel.e.d.a();     // Catch: Throwable -> L19
        final long r7 = DownloadConstants.HOUR;
        final long r9 = DownloadConstants.HOUR;
        r4.a(new AnonymousClass1(this, r7, r9));     // Catch: Throwable -> L19
        a(null, 4, System.currentTimeMillis() - r1);     // Catch: Throwable -> L19
        return;
    L11:
        if (g() <= 0) goto L16;
        if (f() <= 0) goto L16;
        c();     // Catch: Throwable -> L19
    L19:
        Throwable th = th;
    L25:
        Logger.e(TAG, "create MappedByteBuffer failed: ", th);
        this.f7054e.set(true);
        a(5, th);
        if (r3 != null) goto L32;
    L28:
        if (r15 == null) goto L40;
        r15.close();     // Catch: IOException -> L31
        return;
    L42:
        return;
    L40:
        return;
    L32:
        r3.release();     // Catch: IOException -> L31
    L21:
        th = move-exception;
        r3 = null;
        th = th;
    L23:
        th = move-exception;
        r3 = null;
        th = th;
        r15 = null;
        goto L25
    }

    public void a() {
        c.a();
    }

    private void c() {
        this.f7051b.position(12);
        long r0 = System.currentTimeMillis();
        int r2 = g() / 40;
        int r3 = 0;
        boolean r4 = false;
    L3:
        if (r3 >= r2) goto L19;
        byte[] r5 = new byte[32];
        this.f7051b.get(r5);
        long r6 = this.f7051b.getLong();
        if (a(r5) == false) goto L11;
        if (Logger.debug() == false) goto L9;
        Logger.d(TAG, "Data is empty, bypass remove offset:" + r3);
    L9:
        this.f7052c.add(Integer.valueOf(r3));
    L18:
        r3 = r3 + 1;
        goto L3
    L11:
        if (r6 >= r0) goto L15;
        c(r3);
        if (r4 == true) goto L18;
        r4 = true;
        goto L18
    L15:
        String r8 = new String(r5, StandardCharsets.UTF_8);
        a r9 = new a(r6, r3);
        this.f7053d.put(r8, r9);
        if (Logger.debug() == false) goto L18;
        Logger.d(TAG, "initPersistentBuffer item: " + new String(r5) + "&" + r9.a() + "_" + r9.b());
        goto L18
    L19:
        if (r4 == false) goto L22;
        k();
    L22:
        if (Logger.debug() == false) goto L31;
        Logger.d(TAG, "map size:" + this.f7053d.size() + " total count:" + f() + " data size:" + r2 + " total bytes:" + g());
        return;
    }

    private boolean a(byte[] r4) {
        if (r4 != null) goto L5;
    L14:
        return true;
    L5:
        if (r4.length == 0) goto L14;
        int r1 = 0;
    L9:
        if (r1 >= r4.length) goto L14;
        if (r4[r1] != 0) goto L12;
        r1 = r1 + 1;
        goto L9
    L12:
        return false;
    }

    private short d() {
        return this.f7051b.getShort(0);
    }

    private long e() {
        return this.f7051b.getShort(2);
    }

    private int f() {
        return this.f7051b.getInt(4);
    }

    private void a(int r2) {
        this.f7051b.putInt(4, r2);
    }

    private int g() {
        return this.f7051b.getInt(8);
    }

    private void b(int r2) {
        this.f7051b.putInt(8, r2);
    }

    private void h() {
        Logger.i(TAG, "reset");
        this.f7051b.clear();
        this.f7051b.putShort(2114);
        this.f7051b.putShort(1);
        this.f7051b.putInt(0);
        this.f7051b.putInt(0);
    }

    private void a(int r2, Throwable r3) {
        JSONObject r1 = new JSONObject();
        r1.put("action", r2);     // Catch: JSONException -> L10
        String r4 = com.bytedance.common.wschannel.e.c.a(r3);     // Catch: JSONException -> L10
        if (TextUtils.isEmpty(r4) == false) goto L6;
    L8:
        r1.put("exception", r4);     // Catch: JSONException -> L10
    L12:
        c.a(r1);
        return;
    L6:
        if (r4.length() <= 2048) goto L8;
        r4 = r4.substring(0, 2048);     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    private void a(String r7, int r8, long r9) {
        int r0 = this.f7053d.size();
        int r1 = this.f7052c.size();
        int r2 = f();
        int r6 = g();
        JSONObject r3 = new JSONObject();
    L11:
        e = move-exception;
        e.printStackTrace();
    L13:
        c.a(r3);
        return;
    L4:
        if (TextUtils.isEmpty(r7) == true) goto L7;
        r3.put("messageId", r7);     // Catch: JSONException -> L11
    L7:
        if (r9 < 0) goto L9;
        r3.put("duration", r9);     // Catch: JSONException -> L11
    L9:
        r3.put("action", r8);     // Catch: JSONException -> L11
        r3.put("mapSize", r0);     // Catch: JSONException -> L11
        r3.put("queueSize", r1);     // Catch: JSONException -> L11
        r3.put("totalCount", r2);     // Catch: JSONException -> L11
        r3.put(DBDefinition.TOTAL_BYTES, r6);     // Catch: JSONException -> L11
        goto L13
    }

    public boolean a(final String r5, long r6) {
        if (this.f7054e.get() == false) goto L6;
        return false;
    L6:
        if (this.f7053d.containsKey(r5) == false) goto L9;
        Logger.i(TAG, "Drop existed messageId:" + r5);
        com.bytedance.common.wschannel.e.d.a().a(new AnonymousClass2(this, r5));
        return true;
    L9:
        final long r2 = System.currentTimeMillis() + r6;
        this.f7053d.put(r5, new a(r2, -1));
        com.bytedance.common.wschannel.e.d.a().a(new AnonymousClass3(this, r5, r2));
        return false;
    }

    public void a(String[] r7) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "ack message id: " + Arrays.toString(r7));
    L6:
        if (this.f7054e.get() == true) goto L36;
        if (r7 != null) goto L9;
        return;
    L9:
        if (r7.length == 0) goto L38;
        final ArrayList r0 = new ArrayList();
        int r1 = r7.length;
        int r2 = 0;
    L12:
        if (r2 >= r1) goto L25;
        String r3 = r7[r2];
        if (TextUtils.isEmpty(r3) == true) goto L23;
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    L17:
        if (r3.getBytes("UTF-8").length != 32) goto L23;
        r0.add(r3);     // Catch: UnsupportedEncodingException -> L21
    L23:
        r2 = r2 + 1;
        goto L12
    L25:
        if (r0.isEmpty() == false) goto L27;
        return;
    L27:
        com.bytedance.common.wschannel.e.d.a().a(new AnonymousClass4(this, r0));
        return;
    L38:
        return;
    }

    private void c(int r4) {
        if (r4 >= 0) goto L4;
        return;
    L4:
        this.f7051b.position((r4 * 40) + 12);
        this.f7051b.put(this.f7050a);
        a(f() - 1);
        this.f7052c.add(Integer.valueOf(r4));
        if (Logger.debug() == false) goto L8;
        Logger.d(TAG, String.format("remove success: offset=%s, totalCount=%s, totalBytes=%s", new Object[]{Integer.valueOf(r4), Integer.valueOf(f()), Integer.valueOf(g())}));
        return;
    }

    private int a(byte[] r4, long r5) {
        if (this.f7052c.isEmpty() == false) goto L6;
        return -1;
    L6:
        int r0 = ((Integer) ZeusTransformUtils.preCheckCast(this.f7052c.poll(), Integer.class, "com.obric.aiagent.plugin")).intValue();
        this.f7051b.position((r0 * 40) + 12);
        this.f7051b.put(r4);
        this.f7051b.putLong(r5);
        a(f() + 1);
        if (Logger.debug() == false) goto L9;
        Logger.d(TAG, String.format("push success in queue: offset=%s, totalCount=%s, totalBytes=%s, logItem=%s", new Object[]{Integer.valueOf(r0), Integer.valueOf(f()), Integer.valueOf(g()), new String(r4)}));
    L9:
        return r0;
    }

    private int b(String r9, long r10) {
        byte[] r0 = r9.getBytes();
        if (r0 != null) goto L5;
    L27:
        return -1;
    L5:
        if (r0.length != 32) goto L27;
        int r2 = a(r0, r10);
        if (r2 < 0) goto L11;
        return r2;
    L11:
        if (this.f7051b.remaining() >= 40) goto L13;
    L22:
        String r3 = TAG;
        Logger.i(r3, "remaining:" + this.f7051b.remaining() + " total count:" + f() + " threshold:6553 total bytes:" + g() + " threshold:262104");
        a(r9, 3, -1);
        i();
        int r8 = a(r0, r10);
        if (r8 >= 0) goto L26;
        Logger.e(r3, "Push data failed, removeDataForAvailableStorage is not working.");
        return -1;
    L26:
        return r8;
    L13:
        if (f() >= 6553) goto L22;
        if (g() >= 262104) goto L22;
        this.f7051b.position(g() + 12);
        this.f7051b.put(r0);
        this.f7051b.putLong(r10);
        int r11 = f();
        a(r11 + 1);
        b(g() + 40);
        if (Logger.debug() == false) goto L20;
        Logger.d(TAG, String.format("push success in file: offset=%s, totalCount=%s, totalBytes=%s, logItem=%s", new Object[]{Integer.valueOf(r11), Integer.valueOf(f()), Integer.valueOf(g()), r9}));
    L20:
        k();
        return r11;
    }

    private void i() {
        Logger.i(TAG, "available:1092 queue:" + this.f7052c.size());
        Iterator<Map.Entry<String, a>> r0 = this.f7053d.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        a r1 = (a) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), a.class, "com.obric.aiagent.plugin");
        if (r1.b() >= 1092) goto L4;
        c(r1.b());
        r0.remove();
        goto L4
    }

    private void j() {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "removeExpiredCachedData");
    L5:
        Iterator<Map.Entry<String, a>> r0 = this.f7053d.entrySet().iterator();
        long r1 = System.currentTimeMillis();
        boolean r3 = false;
    L7:
        if (r0.hasNext() == false) goto L13;
        a r4 = (a) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), a.class, "com.obric.aiagent.plugin");
        if (r4.a() >= r1) goto L7;
        c(r4.b());
        r0.remove();
        if (r3 == true) goto L7;
        r3 = true;
        goto L7
    L13:
        if (r3 == false) goto L23;
        k();
        return;
    }

    private void k() {
        this.f7051b.force();
    }
}
