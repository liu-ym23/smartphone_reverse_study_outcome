package com.bytedance.android.ec.core.widget;

import android.os.SystemClock;
import android.view.View;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public abstract class d implements View.OnClickListener {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, Long> f46077e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f46078f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f46079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f46080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f46081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f46082d;

    public static final class a {
    }

    public abstract void a(View r100);

    static {
        f46077e = new LinkedHashMap();
        f46078f = ECSettingKeys.r();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        String r100 = this.f46082d;
        if (r100 != null) goto L5;
    L17:
        boolean r101 = true;
    L18:
        if (r101 == true) goto L20;
        return;
    L20:
        long r102 = SystemClock.uptimeMillis();
        long r103 = r102 - this.f46080b;
        dm.a.a("FreqLimitClickListener").a("canClick nowTime=" + r102 + ", lastClickTime=" + this.f46080b + ", duration=" + r103 + ", clickDisableDuration=" + this.f46079a);
        if (r103 <= this.f46079a) goto L23;
        this.f46080b = r102;
        boolean r104 = true;
    L24:
        if (r104 == true) goto L26;
        return;
    L26:
        if (r110 == null) goto L29;
        dm.a.a("FreqLimitClickListener").a("doClick");
        a(r110);
        return;
    L29:
        return;
    L23:
        r104 = false;
        goto L24
    L5:
        if ((!StringsKt.isBlank(r100)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L17;
        long r105 = SystemClock.uptimeMillis();
        Map<String, Long> r106 = f46077e;
        Long r111 = (Long) ((LinkedHashMap) r106).get(r100);
        if (r111 == null) goto L12;
        long r112 = r111.longValue();
    L13:
        long r113 = r105 - r112;
        dm.a.a("FreqLimitClickListener").a("canBindClick bindKey=" + this.f46082d + ", nowTime=" + r105 + ", lastClickTime=" + r112 + ", duration=" + r113 + ", bindKeyClickDisableDuration=" + this.f46081c);
        if (r113 <= this.f46081c) goto L16;
        r106.put(r100, Long.valueOf(r105));
        goto L17
    L16:
        r101 = false;
        goto L18
    L12:
        r112 = 0;
        goto L13
    }

    public d(Long r100, String r101) {
        this.f46082d = r101;
        if (r100 == null) goto L5;
        long r102 = r100.longValue();
    L6:
        this.f46079a = r102;
        if (r100 == null) goto L9;
        long r103 = r100.longValue();
    L10:
        this.f46081c = r103;
        return;
    L9:
        r103 = f46078f;
        goto L10
    L5:
        r102 = f46078f;
        goto L6
    }

    public /* synthetic */ d(Long r100, String r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
