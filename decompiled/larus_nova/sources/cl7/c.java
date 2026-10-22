package cl7;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.ug.sdk.luckydog.api.model.SchemaAckType;
import il7.m;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import rk7.u;
import tk7.g;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final c f24113l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<cl7.b> f24114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f24115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayDeque<String> f24116c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public cl7.a f24117d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f24118e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f24119f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f24120g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public JSONObject f24121h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public g f24122i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicBoolean f24123j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f24124k;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f24125a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final g f24126b;

        public b() {
            this(null, null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L10;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f24125a, r101.f24125a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f24126b, r101.f24126b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f24125a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            g r104 = this.f24126b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "CrossOverGuideEventArgs(domainId=" + this.f24125a + ", bean=" + this.f24126b + ")";
        }

        public b(String r100, g r101) {
            this.f24125a = r100;
            this.f24126b = r101;
        }
    }

    static {
        f24113l = new c();
    }

    public c() {
        m r100 = m.b("luckydog_cross_over_guide");
        this.f24115b = r100;
        String r101 = r100.e("act_show_list", "");
        ArrayDeque<String> r102 = new ArrayDeque(20);
        if (r101.length() <= 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L8;
    L13:
        this.f24116c = r102;
        this.f24118e = new b(null, null);
        this.f24119f = new AtomicBoolean(false);
        this.f24120g = new AtomicBoolean(false);
        new AtomicBoolean(false);
        this.f24123j = new AtomicBoolean(this.f24115b.f("has_settings_update", Boolean.FALSE));
        this.f24124k = this.f24115b.c("show_crossover_guide", 0);
        return;
    L8:
        if (r101.length() <= 1) goto L13;
        Iterator r104 = StringsKt.split$default(r101.substring(1, r101.length() - 1), new String[]{","}, false, 0, 6, null).iterator();
    L11:
        if (r104.hasNext() == false) goto L13;
        r102.offer((String) r104.next());
        goto L11
    L5:
        r103 = false;
        goto L6
    }

    public static JSONObject c(b r100) {
        JSONObject r101 = new JSONObject();
        g r102 = r100.f24126b;
        if (r102 == null) goto L13;
        r101.put("luckydog_activity_id", r102.f546562a);
        String r103 = "1";
        if (r100.f24126b.f546565d != SchemaAckType.ACK_TIME) goto L7;
        Object r104 = "1";
    L8:
        r101.put("luckydog_cross_ack_time", r104);
        if (r100.f24126b.f546566e == true) goto L12;
        r103 = "0";
    L12:
        r101.put("luckydog_cross_reack_install", r103);
        r101.put("luckydog_from_aid", String.valueOf(r100.f24126b.f546563b));
        Application r105 = rk7.m.f538347a;
        r101.put("luckydog_to_aid", String.valueOf(rk7.m.f()));
        r101.put("luckydog_task_id", String.valueOf(r100.f24126b.f546570i));
        goto L13
    L7:
        r104 = "0";
    L13:
        return r101;
    }

    public final void a(JSONObject r110, g r210) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogCrossOverGuideMgr", "handleCrossOverGuide onCalled, ack_time请求结束后判断是否要通知端上展示挂件");
        if (r110 == null) goto L5;
        JSONObject r100 = r110.optJSONObject("activation_guide_component");
    L6:
        if (r100 != null) goto L9;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogCrossOverGuideMgr", "服务端未下发导量引导相关内容");
        return;
    L9:
        boolean r101 = r100.optBoolean("enable_show_guide", false);
        int r102 = r100.optInt("frequency_control_type", 1);
        JSONObject r103 = r100.optJSONObject("guide_config");
        if (r103 != null) goto L13;
        r103 = new JSONObject();
    L13:
        String r104 = r100.optString("domain_id", "");
        b r111 = new b(r104, r210);
        JSONObject r112 = c(r111);
        if (r101 == true) goto L18;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogCrossOverGuideMgr", "导量引导开关关闭，不通知");
        r112.put("action_name", "fail");
        r112.put("fail_reason", "activity disable");
        com.bytedance.ug.sdk.luckydog.api.log.b.a("luckydog_crossover_guide", r112);
        return;
    L18:
        if (this.f24123j.get() == true) goto L21;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogCrossOverGuideMgr", "端上还没有调updateSettings 不能判断是否命中实验 先pending通知");
        this.f24120g.compareAndSet(false, true);
        this.f24121h = r110;
        this.f24122i = r210;
        return;
    L21:
        AtomicBoolean r105 = u.f538372v;
        u.c.f538395a.getClass();
        Application r106 = rk7.m.f538347a;
        if (this.f24124k != 0) goto L26;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogCrossOverGuideMgr", "导量引导未命中实验 不通知");
        r112.put("action_name", "fail");
        r112.put("fail_reason", "ABTest");
        com.bytedance.ug.sdk.luckydog.api.log.b.a("luckydog_crossover_guide", r112);
        return;
    L26:
        if (this.f24119f.get() == false) goto L29;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogCrossOverGuideMgr", "导量引导的前一个通知端上还未处理完成 新的引导不通知");
        r112.put("action_name", "fail");
        r112.put("fail_reason", "not returned");
        com.bytedance.ug.sdk.luckydog.api.log.b.a("luckydog_crossover_guide", r112);
        return;
    L29:
        if (r102 != 1) goto L39;
        long r107 = hl7.b.b().a();
        if (r107 != 0) goto L34;
        r107 = System.currentTimeMillis();
    L34:
        if (Intrinsics.areEqual(this.f24115b.e("last_show_date", ""), new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Long.valueOf(r107))) == true) goto L39;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogCrossOverGuideMgr", "天级别频控且今天未展示过, 通知端上展示导量拉活引导");
        this.f24119f.compareAndSet(false, true);
        b(new cl7.a(r103), 1, r111);
        return;
    L39:
        if (r102 == 2) goto L41;
    L50:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogCrossOverGuideMgr", "通知被频控了 不发送通知.frequencyControlType: " + r102);
        r112.put("action_name", "fail");
        r112.put("fail_reason", "frequency control");
        com.bytedance.ug.sdk.luckydog.api.log.b.a("luckydog_crossover_guide", r112);
        return;
    L41:
        if (r104.length() <= 0) goto L43;
        boolean r108 = true;
    L44:
        if (r108 == false) goto L46;
        boolean r109 = this.f24116c.contains(r104);
    L47:
        if (r109 == true) goto L50;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogCrossOverGuideMgr", "活动级别频控且该活动未展示过, 通知端上展示导量拉活引导");
        this.f24119f.compareAndSet(false, true);
        b(new cl7.a(r103), 2, r111);
        return;
    L46:
        r109 = true;
        goto L47
    L43:
        r108 = false;
        goto L44
    L5:
        r100 = null;
        goto L6
    }

    public final void b(cl7.a r100, int r101, b r102) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogCrossOverGuideMgr", "notifyCrossOverGuide onCall");
        WeakReference<cl7.b> r103 = this.f24114a;
        if (r103 == null) goto L7;
        cl7.b r104 = r103.get();
        if (r104 == null) goto L7;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogCrossOverGuideMgr", "监听已注册 发送通知");
        new Handler(Looper.getMainLooper()).post(new d(this, r102, r104, r100));
        return;
    L7:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogCrossOverGuideMgr", "监听还没有注册 先pending通知");
        this.f24117d = r100;
        this.f24118e = r102;
    }
}
