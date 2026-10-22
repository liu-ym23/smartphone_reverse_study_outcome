package com.bytedance.android.livesdk.gift.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001e\u0010\b\u001a\u00060\u0002j\u0002`\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\"\u0010\u000e\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0007\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0013\u001a\u00020\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0007\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/v;", "Lvh7/c;", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getCount", "()J", "getCount$annotations", "()V", "count", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getHintImg", "()Lpy/k;", "getHintImg$annotations", "hintImg", "", "getComboHintType", "()I", "getComboHintType$annotations", "comboHintType", "", "getName", "()Ljava/lang/String;", "getName$annotations", "name", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface v extends vh7.c<v> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "combo_hint_type")
    int getComboHintType();

    @FieldName(name = "count")
    long getCount();

    @FieldName(name = "hint_img")
    py.k getHintImg();

    @FieldName(name = "name")
    String getName();
}
