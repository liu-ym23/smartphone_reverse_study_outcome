package ms.bd.c;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes4.dex */
public final class n1 implements SensorEventListener {
    private static volatile n1 f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SensorManager f39567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f39568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f39569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float[] f39570d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ArrayList f39571e;

    static {
        new DecimalFormat((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "696cd0", new byte[]{119, 117, 21}), String.class, "com.obric.aiagent.plugin"));
        f = null;
    }

    private n1(Context r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        this.f39567a = null;
        this.f39569c = 0;
        this.f39570d = new float[3];
        this.f39571e = new ArrayList();
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L6;
        this.f39567a = (SensorManager) ZeusTransformUtils.preCheckCast(r11.getSystemService((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "d10e2e", new byte[]{102, 54, 77, 2, 2, 96}), String.class, "com.obric.aiagent.plugin")), SensorManager.class, "com.obric.aiagent.plugin");
        return;
    }

    public static n1 a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (f != null) goto L15;
        monitor-enter(n1.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f != null) goto L9;
        f = new n1(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(n1.class);     // Catch: Throwable -> L11
    L15:
        return f;
    }

    private synchronized void d() {
        monitor-enter(this);
        SensorManager r0 = this.f39567a;     // Catch: Throwable -> L13 Exception -> L18
        if (r0 == null) goto L16;
        if (this.f39568b == 0) goto L8;
    L11:
        this.f39568b++;     // Catch: Throwable -> L13 Exception -> L18
        goto L16
    L8:
        if (this.f39567a.registerListener(this, r0.getDefaultSensor(1), 3) == true) goto L11;
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    L16:
        monitor-exit(this);
    }

    private synchronized void e() {
        monitor-enter(this);
        SensorManager r1 = this.f39567a;     // Catch: Throwable -> L10 Exception -> L12
        if (r1 == null) goto L14;
        int r2 = this.f39568b - 1;     // Catch: Throwable -> L10 Exception -> L12
        this.f39568b = r2;     // Catch: Throwable -> L10 Exception -> L12
        if (r2 != 0) goto L14;
        INVOKEVIRTUAL_ms_bd_c_n1_com_obric_performance_power_monitor_sensor_SensorLancet_unregisterListener(r1, this);     // Catch: Throwable -> L10 Exception -> L12
    L14:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    L13:
        String r0 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "fc2a3f", new byte[]{100, 114, 66, 42, 25}), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        goto L14
    }

    public final synchronized void a() {
        monitor-enter(this);
        JSONArray r0 = c();     // Catch: Throwable -> L13
        if (r0 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.f39571e.add(r0);     // Catch: Throwable -> L13
        int r1 = this.f39571e.size();     // Catch: Throwable -> L16
        if (r1 <= 100) goto L11;
        ArrayList r2 = new ArrayList(this.f39571e.subList(r1 - 50, r1));     // Catch: Throwable -> L16
        this.f39571e.clear();     // Catch: Throwable -> L16
        this.f39571e = r2;     // Catch: Throwable -> L16
    L11:
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized String b() {
        monitor-enter(this);
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L27
        int r1 = this.f39571e.size();     // Catch: Throwable -> L27
        if (r1 <= 0) goto L6;
        ArrayList r2 = this.f39571e;     // Catch: Throwable -> L30
        int r3 = r1 - 50;     // Catch: Throwable -> L30
        if (r3 > 0) goto L12;
        r3 = 0;
    L12:
        List r4 = r2.subList(r3, r1);     // Catch: Throwable -> L30
        if (r4.size() <= 0) goto L22;
        Iterator r5 = r4.iterator();     // Catch: Throwable -> L30
    L16:
        if (r5.hasNext() == false) goto L22;
        JSONArray r6 = (JSONArray) ZeusTransformUtils.preCheckCast(r5.next(), JSONArray.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        if (r6 == null) goto L16;
        r0.append(r6.get(0).toString());     // Catch: Throwable -> L30
        r0.append((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "337a50", new byte[]{110}), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L30
        r0.append(r6.get(1).toString());     // Catch: Throwable -> L30
        r0.append((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "41bfd5", new byte[]{105}), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L30
        r0.append(r6.get(2).toString());     // Catch: Throwable -> L30
        r0.append((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "8e511e", new byte[]{53}), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L30
    L22:
        if (r0.length() <= 0) goto L24;
        r0.delete(r0.length() - 1, r0.length());     // Catch: Throwable -> L30
    L24:
        String r7 = r0.toString();     // Catch: Throwable -> L27
        monitor-exit(this);
        return r7;
    L6:
        monitor-exit(this);
        return null;
    L27:
        th = move-exception;
        throw th;
    }

    public final JSONArray c() {
        if (((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.a(), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin")) == null) goto L6;
        byte r2 = 1;
    L8:
        if (r2 == 1) goto L11;
        return null;
    L11:
        d();
        monitor-enter(this);     // Catch: Throwable -> L25 Exception -> L27
        int r4 = 0;
    L35:
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25 Exception -> L27
        goto L28
    L15:
        if (this.f39569c != 0) goto L19;
        if (r4 >= 10) goto L19;
        r4 = r4 + 1;     // Catch: Throwable -> L22
        wait(1000);     // Catch: Throwable -> L22
    L19:
        monitor-exit(this);     // Catch: Throwable -> L22
        JSONArray r5 = new JSONArray();
        r5.put(new BigDecimal(this.f39570d[0]).setScale(2, 4));
        r5.put(new BigDecimal(this.f39570d[1]).setScale(2, 4));
        BigDecimal r0 = new BigDecimal(this.f39570d[2]);
    L21:
        r5.put(r0.setScale(2, 4));
        e();
        this.f39569c = 0;
        return r5;
    L25:
        th = move-exception;
        JSONArray r6 = new JSONArray();
        r6.put(new BigDecimal(this.f39570d[0]).setScale(2, 4));
        r6.put(new BigDecimal(this.f39570d[1]).setScale(2, 4));
        r6.put(new BigDecimal(this.f39570d[2]).setScale(2, 4));
        e();
        this.f39569c = 0;
        throw th;
    L28:
        String r7 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "ffb842", new byte[]{100, 119, 18, 115, 12}), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        r5 = new JSONArray();
        r5.put(new BigDecimal(this.f39570d[0]).setScale(2, 4));
        r5.put(new BigDecimal(this.f39570d[1]).setScale(2, 4));
        r0 = new BigDecimal(this.f39570d[2]);
        goto L21
    L6:
        r2 = 0;
    L7:
        r2 = -1;
        goto L8
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor r1, int r2) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent r1) {
        this.f39570d = r1.values;
        this.f39569c = 1;
    }

    public static void INVOKEVIRTUAL_ms_bd_c_n1_com_obric_performance_power_monitor_sensor_SensorLancet_unregisterListener(SensorManager r2, SensorEventListener r3) {
        SensorEventListener r4 = (SensorEventListener) ZeusTransformUtils.wrapperContextForParams(r3, SensorEventListener.class, "com.obric.aiagent.plugin");
        if (com.obric.performance.power.monitor.a.f36932a.a() == true) goto L6;
        r2.unregisterListener(r4);
        return;
    L6:
        r2.unregisterListener(r4);
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        com.obric.performance.power.monitor.h.b.b(new com.obric.performance.power.monitor.h.a(r5, null));
        return;
    L9:
        r5 = 0;
        goto L10
    }
}
