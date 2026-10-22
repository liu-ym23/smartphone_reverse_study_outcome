package com.bytedance.android.live.core.i18n;

import android.text.TextUtils;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.config.yn;
import com.bytedance.common.utility.Logger;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import w50.h;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static a f64859h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f64860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f64861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, String> f64862c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public I18nUpdateManager f64863d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C1065a f64864e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.android.live.core.i18n.b f64865f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f64866g;

    /* JADX INFO: renamed from: com.bytedance.android.live.core.i18n.a$a, reason: collision with other inner class name */
    public class C1065a implements I18nUpdateManager.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f64867a;

        public C1065a(a r100) {
            this.f64867a = r100;
        }
    }

    public class b implements com.bytedance.android.live.core.i18n.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f64868a;

        public b(a r100) {
            this.f64868a = r100;
        }
    }

    public static a b() {
        if (f64859h != null) goto L6;
        f64859h = new a();
    L6:
        return f64859h;
    }

    public a() {
        this.f64860a = "";
        this.f64861b = 0;
        this.f64862c = new HashMap();
        this.f64864e = new C1065a(this);
        this.f64866g = new b(this);
    }

    public final String a(String r100) {
        if (yn.f121702a.getValue().booleanValue() == false) goto L5;
        return null;
    L5:
        if (r100 != null) goto L8;
        return null;
    L8:
        if (this.f64862c.containsKey(r100) == true) goto L14;
        I18nUpdateManager r101 = this.f64863d;
        if (r101 == null) goto L12;
        r101.update(this.f64861b);
    L12:
        h.a().c(r100, null);
        return null;
    L14:
        String r102 = this.f64862c.get(r100);
        h.a().c(r100, r102);
        return r102;
    }

    public final void c(Locale r100) {
        if (yn.f121702a.getValue().booleanValue() == false) goto L5;
        return;
    L5:
        h r101 = h.a();
        r101.getClass();
        if (v.a() == true) goto L9;
        r101.f558309h++;
    L9:
        Logger.d("i18n_translation", "wanna switch locale");
        if (r100 != null) goto L13;
        Logger.e("i18n_translation", "new locale is empty, return");
        return;
    L13:
        String r102 = r100.getLanguage() + "_" + r100.getCountry().toLowerCase();
        Logger.d("i18n_translation", "new locale is " + r102);
        if (TextUtils.equals(r102, this.f64860a) == false) goto L17;
        Logger.d("i18n_translation", "new locale is equals to current locale, return");
        return;
    L17:
        I18nUpdateManager r103 = this.f64863d;
        if (r103 == null) goto L25;
        Logger.d("i18n_translation", "I18nUpdateManager destroy");
        r103.f64848b.removeCallbacksAndMessages(null);
        Disposable r104 = r103.f64854h;
        if (r104 != null) goto L22;
    L24:
        r103.f64849c = null;
        goto L25
    L22:
        if (r104.isDisposed() == true) goto L24;
        r103.f64854h.dispose();
    L25:
        com.bytedance.android.live.core.i18n.b r105 = this.f64865f;
        if (r105 == null) goto L38;
        Logger.d("i18n_translation", "I18nDbManager destroy");
        Disposable r106 = r105.f64877g;
        if (r106 != null) goto L30;
    L32:
        Disposable r107 = r105.f64878h;
        if (r107 != null) goto L35;
    L37:
        r105.f64872b = null;
        goto L38
    L35:
        if (r107.isDisposed() == true) goto L37;
        r105.f64878h.dispose();
        goto L37
    L30:
        if (r106.isDisposed() == true) goto L32;
        r105.f64877g.dispose();
    L38:
        this.f64862c.clear();
        this.f64861b = 0;
        this.f64865f = new com.bytedance.android.live.core.i18n.b(r102, this.f64866g);
        this.f64863d = new I18nUpdateManager(r102, this.f64864e);
        if (TextUtils.isEmpty(this.f64860a) == false) goto L41;
        Logger.d("i18n_translation", "switch locale when app start, first query db");
        this.f64865f.a();
    L42:
        this.f64860a = r102;
        h r108 = h.a();
        r108.getClass();
        if (v.a() == true) goto L47;
        r108.f558310i++;
        return;
    L47:
        return;
    L41:
        Logger.d("i18n_translation", "switch locale during app running, directly query api");
        this.f64863d.update(this.f64861b);
        goto L42
    }
}
