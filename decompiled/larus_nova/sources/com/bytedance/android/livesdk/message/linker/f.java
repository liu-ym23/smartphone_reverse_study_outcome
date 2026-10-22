package com.bytedance.android.livesdk.message.linker;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0006\u0010\u0004R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\n8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0013\u001a\u00020\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/message/linker/f;", "Lvh7/c;", "", "getFromUidStr", "()Ljava/lang/String;", "fromUidStr", "getApplyPrompts", "getApplyPrompts$annotations", "()V", "applyPrompts", "Lpy/k;", "getUiImage", "()Lpy/k;", "getUiImage$annotations", "uiImage", "", "getTargetEnlargeGuestType", "()I", "getTargetEnlargeGuestType$annotations", "targetEnlargeGuestType", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface f extends vh7.c<f> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "apply_prompts")
    String getApplyPrompts();

    String getFromUidStr();

    @FieldName(name = "target_enlarge_guest_type")
    int getTargetEnlargeGuestType();

    @FieldName(name = "ui_image")
    py.k getUiImage();
}
