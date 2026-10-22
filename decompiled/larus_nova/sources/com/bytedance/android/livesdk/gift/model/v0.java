package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0011\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0014\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0017\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0015\u0010\u000fR\u001a\u0010\u001a\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u0018\u0010\u000fR\u001a\u0010\u001d\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001b\u0010\u000fR\u001a\u0010 \u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0006\u001a\u0004\b\u001e\u0010\u000fR\u001a\u0010%\u001a\u00020!8&X§\u0004¢\u0006\f\u0012\u0004\b$\u0010\u0006\u001a\u0004\b\"\u0010#R\u001a\u0010&\u001a\u00020!8&X§\u0004¢\u0006\f\u0012\u0004\b'\u0010\u0006\u001a\u0004\b&\u0010#¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/v0;", "Lvh7/c;", "", "getType", "()I", "getType$annotations", "()V", "type", "", "getPriority", "()J", "getPriority$annotations", "priority", "", "getContainerPayload", "()Ljava/lang/String;", "getContainerPayload$annotations", "containerPayload", "getPositionJson", "getPositionJson$annotations", "positionJson", "getUrl", "getUrl$annotations", "url", "getFoldUrl", "getFoldUrl$annotations", "foldUrl", "getHorizontalUrl", "getHorizontalUrl$annotations", "horizontalUrl", "getPreviewUrl", "getPreviewUrl$annotations", "previewUrl", "", "getCanAdjustPosition", "()Z", "getCanAdjustPosition$annotations", "canAdjustPosition", "isLiteMode", "isLiteMode$annotations", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface v0 extends vh7.c<v0> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "can_adjust_position")
    boolean getCanAdjustPosition();

    @FieldName(name = "container_payload")
    String getContainerPayload();

    @FieldName(name = "fold_url")
    String getFoldUrl();

    @FieldName(name = "horizontal_url")
    String getHorizontalUrl();

    @FieldName(name = "position")
    String getPositionJson();

    @FieldName(name = "preview_url")
    String getPreviewUrl();

    @FieldName(name = "priority")
    long getPriority();

    @FieldName(name = "type")
    int getType();

    @FieldName(name = "url")
    String getUrl();

    @FieldName(name = "is_lite_mode")
    boolean isLiteMode();
}
