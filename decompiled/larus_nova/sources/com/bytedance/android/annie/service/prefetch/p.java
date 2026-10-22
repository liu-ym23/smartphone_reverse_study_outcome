package com.bytedance.android.annie.service.prefetch;

import com.bytedance.android.annie.api.card.IHybridComponent;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public interface p extends com.bytedance.android.annie.service.a {
    String A0(String r100);

    void E(t r100);

    JSONObject getCacheJsonByScheme(String r100);

    List<n> o();

    void prefetch(String r100);

    void r0(IHybridComponent r100);
}
