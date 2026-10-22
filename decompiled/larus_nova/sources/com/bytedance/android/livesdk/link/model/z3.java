package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\"\u0010\u0012\u001a\n\u0018\u00010\rj\u0004\u0018\u0001`\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/z3;", "Lvh7/c;", "", "getType", "()Ljava/lang/Integer;", "getType$annotations", "()V", "type", "", "getText", "()Ljava/lang/String;", "getText$annotations", "text", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getImage", "()Lpy/k;", "getImage$annotations", "image", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface z3 extends vh7.c<z3> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "image")
    py.k getImage();

    @FieldName(name = "text")
    String getText();

    @FieldName(name = "type")
    Integer getType();
}
