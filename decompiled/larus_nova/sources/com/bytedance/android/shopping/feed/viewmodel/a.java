package com.bytedance.android.shopping.feed.viewmodel;

import com.bytedance.android.ec.model.InnerFlowAdRawData;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f175739a = 0;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.feed.viewmodel.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/android/shopping/feed/viewmodel/a$a", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/android/ec/model/InnerFlowAdRawData;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class C2606a extends TypeToken<InnerFlowAdRawData> {
        public C2606a() {
        }
    }

    static {
    }

    public static InnerFlowAdRawData a(String r100) {
        if (r100 != null) goto L10;
        return null;
    L10:
        return (InnerFlowAdRawData) GsonProtectorUtils.fromJson(new Gson(), r100, new C2606a().getType());
    L7:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
        return null;
    }
}
