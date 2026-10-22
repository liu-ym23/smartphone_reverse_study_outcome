package com.bytedance.android.shopping.deepfeed.data.repo;

import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public interface o {
    void a(Function2<? super Boolean, ? super InFeedProductV2, Unit> r100);

    Map<String, String> b();

    void c(JSONObject r100, JSONObject r101, boolean r102);

    void d(int r100, String r101, String r102, boolean r103);

    void loadProductFeed(n r100);
}
