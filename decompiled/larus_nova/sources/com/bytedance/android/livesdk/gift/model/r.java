package com.bytedance.android.livesdk.gift.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u000e\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0011\u0010\u0004R\u001a\u0010\u0016\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0014\u0010\u0004R\u001a\u0010\u0019\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0017\u0010\u0004R\u001a\u0010\u001c\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001a\u0010\u0004R\u001a\u0010\u001f\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001d\u0010\u0004R\u001a\u0010$\u001a\u00020 8&X§\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0006\u001a\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/r;", "Lvh7/c;", "", "getIcon", "()Ljava/lang/String;", "getIcon$annotations", "()V", "icon", "getSlogan", "getSlogan$annotations", "slogan", "getBackground", "getBackground$annotations", "background", "getTitle", "getTitle$annotations", "title", "getLeftButtonText", "getLeftButtonText$annotations", "leftButtonText", "getRightButtonText", "getRightButtonText$annotations", "rightButtonText", "getSchemaUrl", "getSchemaUrl$annotations", "schemaUrl", "getLimitScene", "getLimitScene$annotations", "limitScene", "getText", "getText$annotations", "text", "", "getErrorCode", "()I", "getErrorCode$annotations", "errorCode", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface r extends vh7.c<r> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "background")
    String getBackground();

    @FieldName(name = "err_code")
    int getErrorCode();

    @FieldName(name = "icon")
    String getIcon();

    @FieldName(name = "left_button_text")
    String getLeftButtonText();

    @FieldName(name = "limit_scene")
    String getLimitScene();

    @FieldName(name = "right_button_text")
    String getRightButtonText();

    @FieldName(name = com.bytedance.android.ec.core.event.a.KEY_SCHEMA_URL)
    String getSchemaUrl();

    @FieldName(name = "slogan")
    String getSlogan();

    @FieldName(name = "text")
    String getText();

    @FieldName(name = "title")
    String getTitle();
}
