package c50;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.live.core.cmc.setting.CMCSettings;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashMap;

/* JADX INFO: loaded from: classes45.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, Integer> f22455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<Integer, d> f22456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f50.a f22457c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d50.a f22458d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f22459e;

    public class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f22460a;

        public a(e r100) {
            this.f22460a = r100;
        }
    }

    public e(c50.a r100) {
        this.f22455a = new HashMap();
        HashMap<Integer, d> r101 = new HashMap();
        this.f22456b = r101;
        this.f22457c = null;
        this.f22459e = new a(this);
        SettingKey<e50.a> r102 = CMCSettings.LIVE_CMC_CONFIG;
        f50.a r103 = new f50.a(r102.getValue().mEnableLog, r102.getValue().mSimpleLog);
        this.f22457c = r103;
        e50.a r104 = r102.getValue();
        int r105 = r104.mDispatcherType;
        long r106 = r104.mDispatcherTaskInnerDelay;
        if (r105 != 1) goto L6;
        d50.a r107 = new d50.c(r100, r101, r103, r106);
    L9:
        this.f22458d = r107;
        return;
    L6:
        if (r105 != 2) goto L8;
        r107 = new d50.d(r100, r101, r103, r106);
        goto L9
    L8:
        r107 = new d50.b(r100, r101, r103);
        goto L9
    }

    public final int a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return -1;
    L6:
        Integer r101 = this.f22455a.get(r100);
        if (r101 != null) goto L9;
        int r102 = (int) ((SystemClock.elapsedRealtime() * 100) + ((long) (r100.hashCode() % 100)));
        d r103 = new d(r100, r102, this.f22459e);
        this.f22455a.put(r100, Integer.valueOf(r102));
        this.f22456b.put(Integer.valueOf(r102), r103);
        return r102;
    L9:
        return r101.intValue();
    }

    public final boolean b(String r110, Runnable r111, long r112) {
        if (this.f22457c.f475607a == false) goto L7;
    L7:
        if (r111 != null) goto L9;
    L35:
        return false;
    L9:
        if (TextUtils.isEmpty(r110) == true) goto L35;
        int r113 = a(r110);
        d r100 = this.f22456b.get(Integer.valueOf(r113));
        int r101 = -1;
        if (r113 == (-1)) goto L35;
        if (r100 == null) goto L35;
        c r114 = new c(r100.f22451a, r100.f22452b, r111, r100.f22453c, r112);
        int r115 = r100.f22454d.size() - 1;
    L17:
        if (r115 < 0) goto L24;
        c r116 = (c) ListProtector.get(r100.f22454d, r115);
        if (r116 == null) goto L23;
        if (r116.f22449c > r114.f22449c) goto L23;
        r101 = r115 + 1;
    L23:
        r115 = r115 - 1;
    L24:
        if (r101 >= 0) goto L26;
    L29:
        r100.f22454d.add(r114);
    L31:
        if (this.f22458d.c(r114) == true) goto L34;
        r100.f22454d.remove(r114);
        return false;
    L34:
        return true;
    L26:
        if (r101 == r100.f22454d.size()) goto L29;
        ListProtector.add(r100.f22454d, r101, r114);
        goto L31
    }
}
