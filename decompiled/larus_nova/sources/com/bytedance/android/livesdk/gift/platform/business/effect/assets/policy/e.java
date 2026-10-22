package com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy;

import androidx.lifecycle.LiveData;
import java.util.List;
import kotlin.Pair;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public interface e {
    void a(JSONObject r100);

    void f(List r100, boolean r101);

    void g(List<com.bytedance.android.live.core.resources.e> r100, int r101, boolean r102);

    LiveData<List<Pair<com.bytedance.android.live.core.resources.e, Boolean>>> h0();
}
