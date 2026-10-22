package com.bytedance.android.live.core.resources;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001e\u0010\u0012\u001a\u00060\rj\u0002`\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/core/resources/b;", "Lvh7/c;", "", "getCleanType", "()I", "getCleanType$annotations", "()V", "cleanType", "", "getAssetType", "()Ljava/lang/String;", "getAssetType$annotations", "assetType", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getKeepAliveTime", "()J", "getKeepAliveTime$annotations", "keepAliveTime", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface b extends vh7.c<b> {
    public static final int CLEAN_TYPE_DEFAULT = 0;
    public static final int CLEAN_TYPE_LRU = 1;
    public static final a Companion = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f65195a = null;

        public a() {
        }

        static {
            f65195a = new a();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.core.resources.b$b, reason: collision with other inner class name */
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class C1074b {
    }

    static {
        Companion = a.f65195a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "asset_pool_type")
    String getAssetType();

    @FieldName(name = "clean_type")
    int getCleanType();

    @FieldName(name = "keep_alive_time")
    long getKeepAliveTime();
}
