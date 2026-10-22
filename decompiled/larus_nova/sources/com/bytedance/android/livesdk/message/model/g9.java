package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.minigame.SeiMessageConst;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00128&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00178&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010 \u001a\u0004\u0018\u00010\u001c8&X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/g9;", "Lvh7/c;", "", "getMsg_type", "()I", "getMsg_type$annotations", "()V", SeiMessageConst.MSG_TYPE, "Lcom/bytedance/android/live/base/model/message/b3;", "getChangeContent", "()Lcom/bytedance/android/live/base/model/message/b3;", "getChangeContent$annotations", "changeContent", "Lcom/bytedance/android/live/base/model/message/x5;", "getXplayINitContent", "()Lcom/bytedance/android/live/base/model/message/x5;", "getXplayINitContent$annotations", "xplayINitContent", "Lcom/bytedance/android/live/base/model/message/e1;", "getHamletAvatarStartContent", "()Lcom/bytedance/android/live/base/model/message/e1;", "getHamletAvatarStartContent$annotations", "hamletAvatarStartContent", "Lcom/bytedance/android/live/base/model/message/i3;", "getNotifyMultiAvatarPublicStream", "()Lcom/bytedance/android/live/base/model/message/i3;", "getNotifyMultiAvatarPublicStream$annotations", "notifyMultiAvatarPublicStream", "Lcom/bytedance/android/live/base/model/message/s;", "getAudioShowMediaContent", "()Lcom/bytedance/android/live/base/model/message/s;", "getAudioShowMediaContent$annotations", "audioShowMediaContent", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface g9 extends vh7.c<g9> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "audio_show_media_content")
    com.bytedance.android.live.base.model.message.s getAudioShowMediaContent();

    @FieldName(name = "live_matrix_entrance_change_content")
    com.bytedance.android.live.base.model.message.b3 getChangeContent();

    @FieldName(name = "hamlet_avatar_start_content")
    com.bytedance.android.live.base.model.message.e1 getHamletAvatarStartContent();

    @FieldName(name = SeiMessageConst.MSG_TYPE)
    int getMsg_type();

    @FieldName(name = "notify_multi_avatar_publick_stream")
    com.bytedance.android.live.base.model.message.i3 getNotifyMultiAvatarPublicStream();

    @FieldName(name = "xplay_init_content")
    com.bytedance.android.live.base.model.message.x5 getXplayINitContent();
}
