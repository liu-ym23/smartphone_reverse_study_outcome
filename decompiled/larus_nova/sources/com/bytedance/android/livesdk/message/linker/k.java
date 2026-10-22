package com.bytedance.android.livesdk.message.linker;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\"\u0010\r\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u000e\u0010\u0004R\u001a\u0010\u0015\u001a\u00020\u00118&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0018\u001a\u00020\u00118&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0016\u0010\u0013R\u001a\u0010\u001d\u001a\u00020\u00198&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010 \u001a\u00020\u00198&X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0006\u001a\u0004\b\u001e\u0010\u001b¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/message/linker/k;", "Lvh7/c;", "", "getInviteType", "()I", "getInviteType$annotations", "()V", "inviteType", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getUiImage", "()Lpy/k;", "getUiImage$annotations", "uiImage", "getTargetEnlargeGuestType", "getTargetEnlargeGuestType$annotations", "targetEnlargeGuestType", "", "get_fromUid", "()J", "get_fromUid$annotations", "_fromUid", "get_toUid", "get_toUid$annotations", "_toUid", "", "get_fromOpenId", "()Ljava/lang/String;", "get_fromOpenId$annotations", "_fromOpenId", "get_toOpenId", "get_toOpenId$annotations", "_toOpenId", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface k extends vh7.c<k> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "invite_type")
    int getInviteType();

    @FieldName(name = "target_enlarge_guest_type")
    int getTargetEnlargeGuestType();

    @FieldName(name = "ui_image")
    py.k getUiImage();

    @FieldName(name = "from_openid")
    String get_fromOpenId();

    @FieldName(name = "from_user_id")
    long get_fromUid();

    @FieldName(name = "to_openid")
    String get_toOpenId();

    @FieldName(name = com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID)
    long get_toUid();
}
