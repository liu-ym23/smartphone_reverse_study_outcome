package com.bytedance.android.latch.internal.jsb;

import com.bytedance.android.latch.internal.LatchStateHolder;
import io.reactivex.Maybe;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public interface c {
    Set<LatchStateHolder.JsonPath> b();

    Maybe<JSONObject> d();

    void e(JSONObject r100);
}
