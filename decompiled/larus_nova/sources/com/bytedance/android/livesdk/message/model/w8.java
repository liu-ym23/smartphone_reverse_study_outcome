package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&R$\u0010\u000e\u001a\u0004\u0018\u00010\u00078&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00078&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u000f\u0010\tR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00128&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\r\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00178&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010#\u001a\u0004\u0018\u00010\u001d8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\"\u0010\r\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010(\u001a\u0004\u0018\u00010$8&X§\u0004¢\u0006\f\u0012\u0004\b'\u0010\r\u001a\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010*R\u0014\u0010,\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010*R\u0014\u0010-\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010*¨\u0006."}, d2 = {"Lcom/bytedance/android/livesdk/message/model/w8;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/message/t;", "", "currUserIsAnchor", "", "setCurrUserIsAnchor", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getFromUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setFromUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "getFromUser$annotations", "()V", "fromUser", "getToUser", "getToUser$annotations", "toUser", "Lcom/bytedance/android/live/liveinteract/videotalk/emoji/model/i;", "getDynamicEmoji", "()Lcom/bytedance/android/live/liveinteract/videotalk/emoji/model/i;", "getDynamicEmoji$annotations", "dynamicEmoji", "Lcom/bytedance/android/live/liveinteract/videotalk/emoji/model/j;", "getDynamicEmojiFlex", "()Lcom/bytedance/android/live/liveinteract/videotalk/emoji/model/j;", "setDynamicEmojiFlex", "(Lcom/bytedance/android/live/liveinteract/videotalk/emoji/model/j;)V", "dynamicEmojiFlex", "Lpy/k;", "getRandomEmojiImage", "()Lpy/k;", "setRandomEmojiImage", "(Lpy/k;)V", "getRandomEmojiImage$annotations", "randomEmojiImage", "Lcom/bytedance/android/livesdkapi/message/IPublicAreaCommon;", "getPublicAreaCommon", "()Lcom/bytedance/android/livesdkapi/message/IPublicAreaCommon;", "getPublicAreaCommon$annotations", "publicAreaCommon", "isInteractEmoji", "()Z", "isFriendTreeInteractEmoji", "isThanksInteractEmoji", "isSoundEmoji", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface w8 extends vh7.c<w8>, com.bytedance.android.live.base.model.message.t {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean canText();

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean currUserIsAnchor();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getBaseMessage();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getConsumeTime();

    @Override // tlc.d
    /* synthetic */ long getDelayDispatchMs();

    @FieldName(name = "emoji")
    com.bytedance.android.live.liveinteract.videotalk.emoji.model.i getDynamicEmoji();

    com.bytedance.android.live.liveinteract.videotalk.emoji.model.j getDynamicEmojiFlex();

    @FieldName(name = "from_user")
    IBaseUser getFromUser();

    @Override // tlc.d
    /* synthetic */ int getGeneralMessageType();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getHttpSendTime();

    @Override // tlc.d, com.bytedance.android.livesdkapi.message.IExternalLiveMessage
    /* synthetic */ int getIntType();

    /* synthetic */ long getLocalTimestamp();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ Map<String, String> getMessageExtra();

    @Override // tlc.d
    /* synthetic */ int getMessageFrom();

    @Override // tlc.d
    /* synthetic */ long getMessageId();

    @Override // tlc.d
    /* synthetic */ String getMessageMethod();

    /* synthetic */ int getPriority();

    @FieldName(name = "public_area_common")
    IPublicAreaCommon getPublicAreaCommon();

    @FieldName(name = "emoji_image_result")
    py.k getRandomEmojiImage();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ byte[] getRawPayload();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getReceiveTime();

    @Override // tlc.d
    /* synthetic */ long getRoomId();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getTimestamp();

    @FieldName(name = "to_user")
    IBaseUser getToUser();

    @Override // xlc.b
    /* synthetic */ String getWRDSKey();

    @Override // xlc.b
    /* synthetic */ String getWRDSSubKey();

    @Override // xlc.b
    /* synthetic */ long getWRDSVersion();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isCurrentRoom(long r100);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isFirstHistoryMessage();

    boolean isFriendTreeInteractEmoji();

    @Override // tlc.d
    /* synthetic */ boolean isFromFirstRequest();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isFromOtherIntercomRoom();

    @Override // tlc.d
    /* synthetic */ boolean isGlobalMessage();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isInsert();

    boolean isInteractEmoji();

    boolean isSoundEmoji();

    boolean isThanksInteractEmoji();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isTooMuchMsg();

    @Override // xlc.b
    /* synthetic */ boolean isWRDSMessage();

    @Override // tlc.d
    /* synthetic */ boolean needMonitor();

    /* synthetic */ void setBaseMessage(com.bytedance.android.live.base.model.message.m0 r100);

    @Override // tlc.d
    /* synthetic */ void setConsumeTime(long r100);

    void setCurrUserIsAnchor(boolean r100);

    @Override // tlc.d
    /* synthetic */ void setDecodeEndTime(long r100);

    @Override // tlc.d
    /* synthetic */ void setDecodeStartTime(long r100);

    void setDynamicEmojiFlex(com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r100);

    @Override // tlc.d
    /* synthetic */ void setEnqueueDispatchTime(long r100);

    @FieldName(name = "from_user#setter")
    void setFromUser(IBaseUser r100);

    @Override // tlc.d
    /* synthetic */ void setHttpSendTime(long r100);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ void setIsFirstHistoryMessage(boolean r100);

    @Override // tlc.d
    /* synthetic */ void setIsFromFirstRequest(boolean r100);

    @Override // tlc.d
    /* synthetic */ void setIsInsert(boolean r100);

    /* synthetic */ void setLocalInsertMsg(boolean r100);

    @Override // tlc.d
    /* synthetic */ void setMessageMethod(String r100);

    @FieldName(name = "emoji_image_result#setter")
    void setRandomEmojiImage(py.k r100);

    @Override // tlc.d
    /* synthetic */ void setReceiveTime(long r100);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ void setTooMuchMsg(boolean r100);

    @Override // xlc.b
    /* synthetic */ void setWRDSMessage(boolean r100);

    @Override // xlc.b
    /* synthetic */ void setWRDSSubKey(String r100);

    @Override // xlc.b
    /* synthetic */ void setWRDSVersion(long r100);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean supportDisplayText();
}
