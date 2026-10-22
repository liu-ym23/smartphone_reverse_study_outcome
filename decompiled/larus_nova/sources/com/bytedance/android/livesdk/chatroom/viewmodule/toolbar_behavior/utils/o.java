package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f117427a = 0;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u00040\u0001¨\u0006\u0005"}, d2 = {"com/bytedance/android/livesdk/chatroom/viewmodule/toolbar_behavior/utils/o$a", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<HashMap<String, String>> {
        public a() {
        }
    }

    static {
    }

    public static Map a(String r100) {
        return (Map) GsonHelper.getDefault().fromJson(r100, new a().getType());
    L4:
        th = move-exception;
        ALogger.d("wrapParamsUponMatchRoom", "handleLogExtra " + th.getMessage());
        return null;
    }
}
