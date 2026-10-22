package com.bytedance.android.gamecp.business.gamedetail.component.layoutcomponent.collist;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/layoutcomponent/collist/k;", "", "", "hasMore", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "preloadNextPage", "b", "", "offset", "I", "getOffset", "()I", "size", "getSize", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k {

    @SerializedName("has_more")
    private final boolean hasMore;

    @SerializedName("offset")
    private final int offset;

    @SerializedName("preload_next_page")
    private final boolean preloadNextPage;

    @SerializedName("size")
    private final int size;

    public static final class a {
    }

    static {
    }

    public k() {
    }

    public final boolean a() {
        return this.hasMore;
    }

    public final boolean b() {
        return this.preloadNextPage;
    }
}
