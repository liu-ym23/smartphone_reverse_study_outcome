package com.bytedance.android.ec.adapter.api;

import android.widget.RelativeLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.util.HashMap;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f42668g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f42669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f42670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f42671c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f42672d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HashMap<String, String> f42673e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RelativeLayout.LayoutParams f42674f;

    /* JADX INFO: renamed from: com.bytedance.android.ec.adapter.api.a$a, reason: collision with other inner class name */
    public static final class C0777a {
        public C0777a() {
        }

        public static void a(int r100, Double r101) {
            int r102 = a.f42668g;
            HashMap r103 = new HashMap();
            r103.put("position_type", String.valueOf(0));
            r103.put(GXTemplateKey.FLEXBOX_MARGIN, String.valueOf(r100));
            if (r101 == null) goto L6;
            r103.put(MapBundleKey.OfflineMapKey.OFFLINE_RATION, String.valueOf(r101.doubleValue()));
            return;
        }
    }

    static {
        new C0777a();
    }

    public a() {
        this.f42669a = "";
    }
}
