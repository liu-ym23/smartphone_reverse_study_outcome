package com.bytedance.android.livesdk.message.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/zb;", "Lvh7/c;", "Lcom/bytedance/android/livesdk/message/model/zb$a;", "getPortraitDetail", "()Lcom/bytedance/android/livesdk/message/model/zb$a;", "portraitDetail", "getLandscapeDetail", "landscapeDetail", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface zb extends vh7.c<zb> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u0004\u0018\u00010\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\bR\u0014\u0010\u0017\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\bR\u0014\u0010\u0019\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\bR\u0014\u0010\u001b\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\bR\u0014\u0010\u001f\u001a\u00020\u001c8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\u001c8&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001eR\u0014\u0010#\u001a\u00020\u001c8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001eR\u0016\u0010'\u001a\u0004\u0018\u00010$8&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0016\u0010)\u001a\u0004\u0018\u00010$8&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010&R\u0014\u0010+\u001a\u00020\u001c8&X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u001e¨\u0006,"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/zb$a;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/message/a5;", "getText", "()Lcom/bytedance/android/live/base/model/message/a5;", "text", "", "getTextFontSize", "()I", "textFontSize", "Lpy/k;", "getBackground", "()Lpy/k;", "background", "", "getStart", "()J", "start", "getDuration", "duration", "getX", "x", "getY", "y", "getWidth", "width", "getHeight", "height", "", "getShadowDx", "()F", "shadowDx", "getShadowDy", "shadowDy", "getShadowRadius", "shadowRadius", "", "getShadowColor", "()Ljava/lang/String;", "shadowColor", "getStrokeColor", "strokeColor", "getStrokeWidth", "strokeWidth", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface a extends vh7.c<a> {
        @Override // vh7.c
        /* synthetic */ vh7.e castTo(Class r100);

        @Override // vh7.c
        /* synthetic */ vh7.e castToOrNull(Class r100);

        py.k getBackground();

        long getDuration();

        int getHeight();

        String getShadowColor();

        float getShadowDx();

        float getShadowDy();

        float getShadowRadius();

        long getStart();

        String getStrokeColor();

        float getStrokeWidth();

        com.bytedance.android.live.base.model.message.a5 getText();

        int getTextFontSize();

        int getWidth();

        int getX();

        int getY();
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    a getLandscapeDetail();

    a getPortraitDetail();
}
