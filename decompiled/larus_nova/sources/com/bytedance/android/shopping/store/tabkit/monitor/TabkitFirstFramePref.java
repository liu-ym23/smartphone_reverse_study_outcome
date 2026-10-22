package com.bytedance.android.shopping.store.tabkit.monitor;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\nB\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u001d\b\u0016\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0002\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/monitor/TabkitFirstFramePref;", "Lcom/bytedance/android/shopping/store/tabkit/monitor/TabkitFramePref;", "<init>", "()V", "", "", "", "map", "(Ljava/util/Map;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabkitFirstFramePref extends TabkitFramePref {
    public static final a Companion = null;
    public static final String KEY_TABKIT_MONITOR = "tabkit_monitor";
    public static final String T_PAGE_INIT_END = "t_page_init_end";
    public static final String T_PAGE_INIT_START = "t_page_init_start";
    public static final String T_PAGE_ROUTE_START = "t_page_route_start";
    public static final String T_PAGE_SHOW = "t_page_show";
    public static final String T_RENDER_TAB_END = "t_render_tab_end";
    public static final String T_REQUEST_END = "t_request_end";
    public static final String T_REQUEST_START = "t_request_start";
    public static final String T_TAB_CLICK_TIME = "t_tab_click_time";
    public static final String T_TAB_CONTAINER_INIT_END = "t_tab_container_init_end";
    public static final String T_TAB_CONTAINER_INIT_START = "t_tab_container_init_start";
    public static final String T_TAB_INIT = "t_tab_init";
    public static final String T_TAB_REQUEST_END = "t_tab_request_end";
    public static final String T_TAB_REQUEST_START = "t_tab_request_start";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public TabkitFirstFramePref() {
    }

    public TabkitFirstFramePref(Map<String, Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        this();
        putAll(r100);
    }
}
