package com.bytedance.android.livesdk.interactivity.service.model;

import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b$\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R\"\u0010\n\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u000e\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000b\u0010\u0005\"\u0004\b\f\u0010\u0007R\"\u0010\u0012\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0011\u0010\t\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007R\"\u0010\u0016\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0015\u0010\t\u001a\u0004\b\u0013\u0010\u0005\"\u0004\b\u0014\u0010\u0007R\"\u0010\u001a\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0019\u0010\t\u001a\u0004\b\u0017\u0010\u0005\"\u0004\b\u0018\u0010\u0007R\"\u0010\u001e\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001d\u0010\t\u001a\u0004\b\u001b\u0010\u0005\"\u0004\b\u001c\u0010\u0007R\"\u0010\"\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b!\u0010\t\u001a\u0004\b\u001f\u0010\u0005\"\u0004\b \u0010\u0007R\"\u0010&\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b%\u0010\t\u001a\u0004\b#\u0010\u0005\"\u0004\b$\u0010\u0007¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/service/model/c;", "Lvh7/e;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatus;", "", "getWordAssociation", "()J", "setWordAssociation", "(J)V", "getWordAssociation$annotations", "()V", "wordAssociation", "getEnableEmojiExpose", "setEnableEmojiExpose", "getEnableEmojiExpose$annotations", "enableEmojiExpose", "getEnableChatReply", "setEnableChatReply", "getEnableChatReply$annotations", "enableChatReply", "getEnableChatMention", "setEnableChatMention", "getEnableChatMention$annotations", "enableChatMention", "getAudioChatToText", "setAudioChatToText", "getAudioChatToText$annotations", "audioChatToText", "getEnableAudioComment", "setEnableAudioComment", "getEnableAudioComment$annotations", "enableAudioComment", "getFixedChat", "setFixedChat", "getFixedChat$annotations", "fixedChat", "getMyLiveEntrance", "setMyLiveEntrance", "getMyLiveEntrance$annotations", "myLiveEntrance", "community-service_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface c extends vh7.e<IRoomAuthStatus>, IRoomAuthStatus {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class a {
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "AudioChatTotext")
    long getAudioChatToText();

    @FieldName(name = "AudioChat")
    long getEnableAudioComment();

    @FieldName(name = "ChatMention")
    long getEnableChatMention();

    @FieldName(name = "ChatReply")
    long getEnableChatReply();

    @FieldName(name = "EmojiOutside")
    long getEnableEmojiExpose();

    @FieldName(name = "FixedChat")
    long getFixedChat();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "MyLiveEntrance")
    long getMyLiveEntrance();

    @FieldName(name = "WordAssociation")
    long getWordAssociation();

    @FieldName(name = "AudioChatTotext#setter")
    void setAudioChatToText(long r100);

    @FieldName(name = "AudioChat#setter")
    void setEnableAudioComment(long r100);

    @FieldName(name = "ChatMention#setter")
    void setEnableChatMention(long r100);

    @FieldName(name = "ChatReply#setter")
    void setEnableChatReply(long r100);

    @FieldName(name = "EmojiOutside#setter")
    void setEnableEmojiExpose(long r100);

    @FieldName(name = "FixedChat#setter")
    void setFixedChat(long r100);

    @FieldName(name = "MyLiveEntrance#setter")
    void setMyLiveEntrance(long r100);

    @FieldName(name = "WordAssociation#setter")
    void setWordAssociation(long r100);
}
