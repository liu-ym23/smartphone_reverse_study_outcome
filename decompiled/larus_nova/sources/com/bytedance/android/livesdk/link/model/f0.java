package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R$\u0010\n\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/f0;", "Lvh7/c;", "Laf2/a;", "Lcom/bytedance/android/livesdk/link/model/d0;", "getConfig", "()Lcom/bytedance/android/livesdk/link/model/d0;", "setConfig", "(Lcom/bytedance/android/livesdk/link/model/d0;)V", "getConfig$annotations", "()V", "config", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface f0 extends vh7.c<f0>, af2.a {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    /* synthetic */ long getAccelerateLimit();

    @FieldName(name = "config")
    d0 getConfig();

    /* synthetic */ long getDefaultWaitLimit();

    /* synthetic */ String getMainTitle();

    /* synthetic */ String getSubTitle();

    /* synthetic */ long getWaitSec();

    /* synthetic */ void setAccelerateLimit(long r100);

    @FieldName(name = "config#setter")
    void setConfig(d0 r100);

    /* synthetic */ void setDefaultWaitLimit(long r100);

    /* synthetic */ void setMainTitle(String r100);

    /* synthetic */ void setSubTitle(String r100);

    /* synthetic */ void setWaitSec(long r100);
}
