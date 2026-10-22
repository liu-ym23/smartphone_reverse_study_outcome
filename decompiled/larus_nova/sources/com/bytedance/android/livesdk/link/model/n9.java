package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R6\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00058&X§\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0011\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u00128&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\t\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/n9;", "Lvh7/c;", "", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getNotAllowMap", "()Ljava/util/Map;", "getNotAllowMap$annotations", "()V", "notAllowMap", "isFailure", "()Z", "isFailure$annotations", "getToast", "()Ljava/lang/String;", "getToast$annotations", "toast", "", "getWaitSec", "()J", "getWaitSec$annotations", "waitSec", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface n9 extends vh7.c<n9> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "open_not_allow_map")
    Map<String, Boolean> getNotAllowMap();

    @FieldName(name = "toast")
    String getToast();

    @FieldName(name = "wait_sec")
    long getWaitSec();

    @FieldName(name = "is_failure")
    boolean isFailure();
}
