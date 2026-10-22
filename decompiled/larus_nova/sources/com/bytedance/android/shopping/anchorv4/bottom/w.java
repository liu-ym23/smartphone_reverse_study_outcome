package com.bytedance.android.shopping.anchorv4.bottom;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public interface w {

    public static final class a {
        public static /* synthetic */ void a(w r100, String r101, Map r102) {
            r100.n(r101, r102, true, true, null, null);
        }
    }

    CommonMeta a();

    long getDuration();

    LinkedTreeMap<String, Object> getTrackMeta();

    void n(String r100, Map<String, ? extends Object> r101, boolean r102, boolean r103, String r104, PageFinder r105);
}
