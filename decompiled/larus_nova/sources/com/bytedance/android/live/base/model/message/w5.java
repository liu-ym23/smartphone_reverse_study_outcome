package com.bytedance.android.live.base.model.message;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\"\u0010\u000e\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\r\u0010\u0007\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0014\u0010\u0007\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/base/model/message/w5;", "Lvh7/c;", "", "", "getAllAvatarIds", "()Ljava/util/List;", "getAllAvatarIds$annotations", "()V", "allAvatarIds", "getAvatarId", "()J", "setAvatarId", "(J)V", "getAvatarId$annotations", "avatarId", "", "getMultiAvatarMode", "()Z", "setMultiAvatarMode", "(Z)V", "getMultiAvatarMode$annotations", "multiAvatarMode", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface w5 extends vh7.c<w5> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "all_avatar_ids")
    List<Long> getAllAvatarIds();

    @FieldName(name = "avatar_id")
    long getAvatarId();

    @FieldName(name = "multi_avatar_mode")
    boolean getMultiAvatarMode();

    @FieldName(name = "avatar_id#setter")
    void setAvatarId(long r100);

    @FieldName(name = "multi_avatar_mode#setter")
    void setMultiAvatarMode(boolean r100);
}
