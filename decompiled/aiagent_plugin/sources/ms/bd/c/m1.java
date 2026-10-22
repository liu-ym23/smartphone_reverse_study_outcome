package ms.bd.c;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.bytedance.keva.KevaImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static m1 f39559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f39560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ArrayList f39561c;

    private m1(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.f39560b = ZeusTransformUtils.wrapperContext(null, "com.obric.aiagent.plugin");
        this.f39561c = new ArrayList();
        this.f39560b = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
    }

    public static m1 a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (f39559a != null) goto L15;
        monitor-enter(m1.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f39559a != null) goto L9;
        f39559a = new m1(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(m1.class);     // Catch: Throwable -> L11
    L15:
        return f39559a;
    }

    public final int a() {
        Intent r10 = ZeusTransformUtils.registerReceiver(this.f39560b, null, new IntentFilter((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "b5c207", new byte[]{114, 57, 20, 84, 0, 41, 101, 90, 59, 108, 103, 50, 30, 82, 65, 33, 98, 0, 59, 109, 125, 121, 50, 103, 59, 20, 68, 38, 11, 93, 80, 31, 49, 104, 40, 5, 69}), String.class, "com.obric.aiagent.plugin")), "com.obric.aiagent.plugin");
        if (r10 != null) goto L6;
        return -1;
    L6:
        return Math.round(((r10.getIntExtra((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "edb461", new byte[]{120, 99, 7, 69, 5}), String.class, "com.obric.aiagent.plugin"), -1) / r10.getIntExtra((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "ae5367", new byte[]{99, 100, 71, 75, 12}), String.class, "com.obric.aiagent.plugin"), -1)) * 100.0f) * 10.0f) / 10;
    }

    public final int b() {
        Intent r10 = ZeusTransformUtils.registerReceiver(this.f39560b, null, new IntentFilter((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "56e42f", new byte[]{37, 58, 18, 82, 2, 120, 50, 89, 61, 106, 48, 49, 24, 84, 67, 112, 53, 3, 61, 107, 42, 122, 52, 97, 57, 69, 19, 37, 13, 91, 7, 28, 55, 110, 42, 84, 18}), String.class, "com.obric.aiagent.plugin")), "com.obric.aiagent.plugin");
        if (r10 != null) goto L5;
        return -1;
    L5:
        int r11 = r10.getIntExtra((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "75ba16", new byte[]{53, 35, 16, 1, 27, 50}), String.class, "com.obric.aiagent.plugin"), -1);
        if (r11 != 2) goto L8;
    L11:
        return 1;
    L8:
        if (r11 == 5) goto L11;
        return 0;
    }

    public final int c() {
        Intent r10 = ZeusTransformUtils.registerReceiver(this.f39560b, null, new IntentFilter((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "5c606d", new byte[]{37, 111, 65, 86, 6, 122, 50, 12, 110, 110, 48, 100, 75, 80, 71, 114, 53, 86, 110, 111, 42, 47, 103, 101, 61, 71, 19, 112, 94, 95, 7, 73, 100, 106, 46, 86, 18}), String.class, "com.obric.aiagent.plugin")), "com.obric.aiagent.plugin");
        if (r10 != null) goto L6;
        return -1;
    L6:
        return r10.getIntExtra((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "b6b205", new byte[]{99, 56, 4, 65, 8, 39, 101}), String.class, "com.obric.aiagent.plugin"), -1);
    }

    public final void d() {
        monitor-enter(this);     // Catch: Throwable -> L9 Exception -> L11
        int r0 = c();     // Catch: Throwable -> L6
        int r1 = a();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        int r2 = (r0 * KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD) + r1;     // Catch: Throwable -> L6
    L12:
        Integer r3 = Integer.valueOf(r2);
        if (r3 != null) goto L15;
        return;
    L15:
        this.f39561c.add(r3);
        int r4 = this.f39561c.size();     // Catch: Throwable -> L20
        if (r4 <= 20) goto L27;
        ArrayList r5 = new ArrayList(this.f39561c.subList(r4 - 10, r4));     // Catch: Throwable -> L20
        this.f39561c.clear();     // Catch: Throwable -> L20
        this.f39561c = r5;     // Catch: Throwable -> L20
        return;
    L27:
        return;
    L28:
        return;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9 Exception -> L11
    L11:
        r2 = -10001;
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized int[] e() {
        monitor-enter(this);
        int r0 = this.f39561c.size();     // Catch: Throwable -> L27
        if (r0 > 0) goto L9;
        int[] r1 = new int[0];     // Catch: Throwable -> L27
        monitor-exit(this);
        return r1;
    L9:
        if (r0 != 1) goto L31;
        int[] r2 = {((Integer) ZeusTransformUtils.preCheckCast(this.f39561c.get(0), Integer.class, "com.obric.aiagent.plugin")).intValue()};     // Catch: Throwable -> L27
        monitor-exit(this);
        return r2;
    L31:
        ArrayList r3 = this.f39561c;     // Catch: Throwable -> L24
        int r4 = r0 - 10;     // Catch: Throwable -> L24
        if (r4 > 0) goto L17;
        r4 = 0;
    L17:
        List r5 = r3.subList(r4, r0);     // Catch: Throwable -> L24
        int[] r6 = new int[r5.size()];     // Catch: Throwable -> L24
        int r7 = 0;
    L19:
        if (r7 >= r5.size()) goto L22;
        r6[r7] = ((Integer) ZeusTransformUtils.preCheckCast(r5.get(r7), Integer.class, "com.obric.aiagent.plugin")).intValue();     // Catch: Throwable -> L24
        r7 = r7 + 1;
        goto L19
        goto L26
    L22:
        monitor-exit(this);
        return r6;
    L26:
        return new int[0];
    L27:
        th = move-exception;
        throw th;
    }

    public final int f() {
        Intent r10 = ZeusTransformUtils.registerReceiver(this.f39560b, null, new IntentFilter((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "4a0e7f", new byte[]{36, 109, 71, 3, 7, 120, 51, 14, 104, 59, 49, 102, 77, 5, 70, 112, 52, 84, 104, 58, 43, 45, 97, 48, 60, 69, 18, 114, 88, 10, 6, 75, 98, 63, 47, 84, 19}), String.class, "com.obric.aiagent.plugin")), "com.obric.aiagent.plugin");
        if (r10 != null) goto L6;
        return -1;
    L6:
        return r10.getIntExtra((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "05949d", new byte[]{41, 50, 75, 76, 18, 123}), String.class, "com.obric.aiagent.plugin"), -1);
    }
}
