package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0013\u0010\u0004R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001a8&X§\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/r;", "Lvh7/c;", "", "getToast", "()Ljava/lang/String;", "getToast$annotations", "()V", "toast", "getToastColor", "getToastColor$annotations", "toastColor", "getToastTextColor", "getToastTextColor$annotations", "toastTextColor", "", "getDisable", "()Z", "getDisable$annotations", "disable", "getSchema", "getSchema$annotations", "schema", "getClickToNext", "()Ljava/lang/Boolean;", "getClickToNext$annotations", "clickToNext", "Lpy/k;", "getIcon", "()Lpy/k;", "getIcon$annotations", "icon", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface r extends vh7.c<r> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "click_to_next")
    Boolean getClickToNext();

    @FieldName(name = "disable")
    boolean getDisable();

    @FieldName(name = "image")
    py.k getIcon();

    @FieldName(name = "schema")
    String getSchema();

    @FieldName(name = "toast")
    String getToast();

    @FieldName(name = "toast_color")
    String getToastColor();

    @FieldName(name = "toast_text_color")
    String getToastTextColor();
}
