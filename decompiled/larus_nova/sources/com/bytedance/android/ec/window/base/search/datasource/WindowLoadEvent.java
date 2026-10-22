package com.bytedance.android.ec.window.base.search.datasource;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \u00022\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/ec/window/base/search/datasource/WindowLoadEvent;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, EffectConstants.NORMAL, "RECOMMEND_ON_NO_RESULT", "RECOMMEND_ON_LESS_RESULT", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WindowLoadEvent extends Enum<WindowLoadEvent> {
    public static final a Companion = null;
    public static final WindowLoadEvent NORMAL = null;
    public static final WindowLoadEvent RECOMMEND_ON_LESS_RESULT = null;
    public static final WindowLoadEvent RECOMMEND_ON_NO_RESULT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WindowLoadEvent[] f49510a = null;

    public static final class a {
        public a() {
        }
    }

    static {
        WindowLoadEvent r100 = new WindowLoadEvent(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        WindowLoadEvent r101 = new WindowLoadEvent("RECOMMEND_ON_NO_RESULT", 1);
        RECOMMEND_ON_NO_RESULT = r101;
        WindowLoadEvent r102 = new WindowLoadEvent("RECOMMEND_ON_LESS_RESULT", 2);
        RECOMMEND_ON_LESS_RESULT = r102;
        f49510a = new WindowLoadEvent[]{r100, r101, r102};
        Companion = new a();
    }

    public static WindowLoadEvent valueOf(String r100) {
        return (WindowLoadEvent) r27.a.a(WindowLoadEvent.class, r100);
    }

    public static WindowLoadEvent[] values() {
        return (WindowLoadEvent[]) f49510a.clone();
    }

    public WindowLoadEvent(String r100, int r101) {
        super(r100, r101);
    }
}
