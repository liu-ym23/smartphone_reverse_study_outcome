package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.multilink.ktv.SongUniqueInfo;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001'R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u0010\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0016\u0010\b\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001b\u001a\u00020\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\"\u0010\u001f\u001a\u00020\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001e\u0010\b\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R*\u0010%\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b$\u0010\b\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010#¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/message/model/t8;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/message/t;", "", "Lcom/bytedance/android/livesdk/message/model/de$a;", "getMusicInfoList", "()Ljava/util/List;", "getMusicInfoList$annotations", "()V", "musicInfoList", "", "getMessageIntType", "()I", "setMessageIntType", "(I)V", "getMessageIntType$annotations", "messageIntType", "", "getSungSongCount", "()J", "setSungSongCount", "(J)V", "getSungSongCount$annotations", "sungSongCount", "getWantSingSongThreshold", "setWantSingSongThreshold", "getWantSingSongThreshold$annotations", "wantSingSongThreshold", "getWantSingCount", "setWantSingCount", "getWantSingCount$annotations", "wantSingCount", "Lcom/bytedance/android/live/multilink/ktv/SongUniqueInfo;", "getAllSongUniqueList", "setAllSongUniqueList", "(Ljava/util/List;)V", "getAllSongUniqueList$annotations", "allSongUniqueList", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface t8 extends vh7.c<t8>, com.bytedance.android.live.base.model.message.t {
    public static final a Companion = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f153699a = null;

        public a() {
        }

        static {
            f153699a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.f153699a;
    }

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean canText();

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean currUserIsAnchor();

    @FieldName(name = "all_song_unique_list")
    List<SongUniqueInfo> getAllSongUniqueList();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getBaseMessage();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getConsumeTime();

    @Override // tlc.d
    /* synthetic */ long getDelayDispatchMs();

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

    @FieldName(name = "message_type")
    int getMessageIntType();

    @Override // tlc.d
    /* synthetic */ String getMessageMethod();

    @FieldName(name = "list_info")
    List<de.a> getMusicInfoList();

    /* synthetic */ int getPriority();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ byte[] getRawPayload();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getReceiveTime();

    @Override // tlc.d
    /* synthetic */ long getRoomId();

    @FieldName(name = "sung_song_count")
    long getSungSongCount();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getTimestamp();

    @Override // xlc.b
    /* synthetic */ String getWRDSKey();

    @Override // xlc.b
    /* synthetic */ String getWRDSSubKey();

    @Override // xlc.b
    /* synthetic */ long getWRDSVersion();

    @FieldName(name = "want_sing_count")
    long getWantSingCount();

    @FieldName(name = "want_sing_song_threshold")
    long getWantSingSongThreshold();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isCurrentRoom(long r100);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isFirstHistoryMessage();

    @Override // tlc.d
    /* synthetic */ boolean isFromFirstRequest();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isFromOtherIntercomRoom();

    @Override // tlc.d
    /* synthetic */ boolean isGlobalMessage();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isInsert();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isTooMuchMsg();

    @Override // xlc.b
    /* synthetic */ boolean isWRDSMessage();

    @Override // tlc.d
    /* synthetic */ boolean needMonitor();

    @FieldName(name = "all_song_unique_list#setter")
    void setAllSongUniqueList(List<SongUniqueInfo> r100);

    /* synthetic */ void setBaseMessage(com.bytedance.android.live.base.model.message.m0 r100);

    @Override // tlc.d
    /* synthetic */ void setConsumeTime(long r100);

    @Override // tlc.d
    /* synthetic */ void setDecodeEndTime(long r100);

    @Override // tlc.d
    /* synthetic */ void setDecodeStartTime(long r100);

    @Override // tlc.d
    /* synthetic */ void setEnqueueDispatchTime(long r100);

    @Override // tlc.d
    /* synthetic */ void setHttpSendTime(long r100);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ void setIsFirstHistoryMessage(boolean r100);

    @Override // tlc.d
    /* synthetic */ void setIsFromFirstRequest(boolean r100);

    @Override // tlc.d
    /* synthetic */ void setIsInsert(boolean r100);

    /* synthetic */ void setLocalInsertMsg(boolean r100);

    @FieldName(name = "message_type#setter")
    void setMessageIntType(int r100);

    @Override // tlc.d
    /* synthetic */ void setMessageMethod(String r100);

    @Override // tlc.d
    /* synthetic */ void setReceiveTime(long r100);

    @FieldName(name = "sung_song_count#setter")
    void setSungSongCount(long r100);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ void setTooMuchMsg(boolean r100);

    @Override // xlc.b
    /* synthetic */ void setWRDSMessage(boolean r100);

    @Override // xlc.b
    /* synthetic */ void setWRDSSubKey(String r100);

    @Override // xlc.b
    /* synthetic */ void setWRDSVersion(long r100);

    @FieldName(name = "want_sing_count#setter")
    void setWantSingCount(long r100);

    @FieldName(name = "want_sing_song_threshold#setter")
    void setWantSingSongThreshold(long r100);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean supportDisplayText();
}
