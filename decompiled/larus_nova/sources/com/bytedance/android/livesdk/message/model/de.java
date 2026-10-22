package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.multilink.ktv.SongUniqueInfo;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.livesdkapi.util.KotlinTypeUtilsKt;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.internal.FlexModelDelegate;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.LinkMicAudienceKtvMessage")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0003:\u0002EFB\u0007¢\u0006\u0004\bC\u0010DJ-\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00030\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ/\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00030\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016¢\u0006\u0004\b\n\u0010\tR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010&\u001a\u00020\u001f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b&\u0010!\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\"\u0010)\u001a\u00020\u001f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b)\u0010!\u001a\u0004\b*\u0010#\"\u0004\b+\u0010%R\"\u0010-\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b-\u0010/\"\u0004\b0\u00101R*\u00103\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010\u00178\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b3\u0010\u001a\u001a\u0004\b4\u0010\u001c\"\u0004\b5\u0010\u001eR(\u0010<\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u0001068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u0010\u001cR$\u0010B\u001a\u00020\u00102\u0006\u0010?\u001a\u00020\u00108V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b@\u0010\u0014\"\u0004\bA\u0010\u0016¨\u0006G"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/de;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Lvh7/c$a;", "Lcom/bytedance/android/livesdk/message/model/t8;", "Lvh7/e;", "R", "Ljava/lang/Class;", "aClass", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "delegate", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "getDelegate", "()Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "", "messageType", "I", "getMessageType", "()I", "setMessageType", "(I)V", "", "Lcom/bytedance/android/livesdk/message/model/de$a;", "mMusicInfoList", "Ljava/util/List;", "getMMusicInfoList", "()Ljava/util/List;", "setMMusicInfoList", "(Ljava/util/List;)V", "", "wantSingCount", "J", "getWantSingCount", "()J", "setWantSingCount", "(J)V", "wantSingSongThreshold", "getWantSingSongThreshold", "setWantSingSongThreshold", "sungSongCount", "getSungSongCount", "setSungSongCount", "", "isDowngrade", "Z", "()Z", "setDowngrade", "(Z)V", "Lcom/bytedance/android/live/multilink/ktv/SongUniqueInfo;", "allSongUniqueList", "getAllSongUniqueList", "setAllSongUniqueList", "Lcom/bytedance/android/live/base/model/message/m0;", "iCommonMessageData", "getCommonData", "()Lcom/bytedance/android/live/base/model/message/m0;", "setCommonData", "(Lcom/bytedance/android/live/base/model/message/m0;)V", "commonData", "getMusicInfoList", "musicInfoList", RXScreenCaptureService.KEY_INDEX, "getMessageIntType", "setMessageIntType", "messageIntType", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class de extends o0 implements vh7.c.a<t8>, t8, vh7.h {

    @SerializedName("all_song_unique_list")
    protected List<SongUniqueInfo> allSongUniqueList;
    private final transient FlexModelDelegate<t8> delegate;

    @SerializedName("is_downgrade")
    protected boolean isDowngrade;

    @SerializedName("list_info")
    protected List<? extends a> mMusicInfoList;

    @SerializedName("message_type")
    protected int messageType;

    @SerializedName("sung_song_count")
    protected long sungSongCount;

    @SerializedName("want_sing_count")
    protected long wantSingCount;

    @SerializedName("want_sing_song_threshold")
    protected long wantSingSongThreshold;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/de$a;", "", "Lcom/bytedance/android/livesdk/message/model/KtvMusic;", "music", "Lcom/bytedance/android/livesdk/message/model/KtvMusic;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/message/model/KtvMusic;", "setMusic", "(Lcom/bytedance/android/livesdk/message/model/KtvMusic;)V", "", "isSelfSeeing", "Z", "b", "()Z", "setSelfSeeing", "(Z)V", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static class a implements vh7.h {

        @SerializedName("is_self_seeing")
        protected boolean isSelfSeeing;

        @SerializedName("music")
        protected KtvMusic music;

        public a() {
        }

        public a(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L12;
            if (r102 != 1) goto L8;
            this.music = new KtvMusic(r100);
            goto L3
        L8:
            if (r102 != 2) goto L9;
            this.isSelfSeeing = am3.h.a(r100);
            goto L3
        L9:
            am3.h.e(r100);
            goto L3
        L12:
            r100.d(r101);
        }

        public final KtvMusic a() {
            return this.music;
        }

        public final boolean b() {
            return this.isSelfSeeing;
        }
    }

    public static final class b extends a {
        public b(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L12;
            if (r102 != 1) goto L8;
            this.music = new KtvMusic(r100);
            goto L3
        L8:
            if (r102 != 2) goto L9;
            this.isSelfSeeing = am3.h.a(r100);
            goto L3
        L9:
            am3.h.e(r100);
            goto L3
        L12:
            r100.d(r101);
        }
    }

    @Override // com.bytedance.android.livesdk.message.model.t8
    public void setMessageIntType(int r100) {
    }

    @Override // com.bytedance.android.livesdk.message.model.t8
    public List<a> getMusicInfoList() {
        return KotlinTypeUtilsKt.castElementType(this.mMusicInfoList);
    }

    public de() {
        this.delegate = new FlexModelDelegate(t8.class, this);
        this.type = MessageType.LINK_MIC_AUDIENCE_KTV_MESSAGE;
    }

    public final com.bytedance.android.live.base.model.message.m0 getCommonData() {
        return getBaseMessage();
    }

    @Override // com.bytedance.android.livesdk.message.model.t8
    public List<SongUniqueInfo> getAllSongUniqueList() {
        return this.allSongUniqueList;
    }

    @Override // vh7.c.a
    public FlexModelDelegate<t8> getDelegate() {
        return this.delegate;
    }

    public final List<a> getMMusicInfoList() {
        return this.mMusicInfoList;
    }

    @Override // com.bytedance.android.livesdk.message.model.t8
    public int getMessageIntType() {
        return this.messageType;
    }

    public final int getMessageType() {
        return this.messageType;
    }

    @Override // com.bytedance.android.livesdk.message.model.t8
    public long getSungSongCount() {
        return this.sungSongCount;
    }

    @Override // com.bytedance.android.livesdk.message.model.t8
    public long getWantSingCount() {
        return this.wantSingCount;
    }

    @Override // com.bytedance.android.livesdk.message.model.t8
    public long getWantSingSongThreshold() {
        return this.wantSingSongThreshold;
    }

    public final boolean isDowngrade() {
        return this.isDowngrade;
    }

    public de(am3.g r100) {
        this.mMusicInfoList = new ArrayList();
        this.allSongUniqueList = new ArrayList();
        this.delegate = new FlexModelDelegate(t8.class, this);
        getDelegate().setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L17;
        am3.g.a r103 = getDelegate().decodeExtensionFields(r102, r100);
        switch(r102) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            default: goto L7;
        };
    L8:
        List r104 = this.allSongUniqueList;
        vh7.h r105 = new SongUniqueInfo(r100);
    L14:
        r104.add(r105);
        goto L3
    L9:
        this.isDowngrade = am3.h.a(r100);
        goto L3
    L10:
        this.sungSongCount = r100.j();
        goto L3
    L11:
        this.wantSingSongThreshold = r100.j();
        goto L3
    L12:
        this.wantSingCount = r100.j();
        goto L3
    L13:
        r104 = this.mMusicInfoList;
        r105 = new a(r100);
        goto L14
    L15:
        this.messageType = (int) r100.j();
        goto L3
    L16:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L17:
        r100.d(r101);
        getDelegate().setThreadSafe(true);
        this.type = MessageType.LINK_MIC_AUDIENCE_KTV_MESSAGE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // vh7.c.a, vh7.c
    public <R extends vh7.e<t8>> R castTo(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "aClass");
        return (R) getDelegate().castTo(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // vh7.c.a, vh7.c
    public <R extends vh7.e<t8>> R castToOrNull(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "aClass");
        return (R) getDelegate().castToOrNull(r100);
    }

    @Override // com.bytedance.android.livesdk.message.model.t8
    public void setAllSongUniqueList(List<SongUniqueInfo> r100) {
        this.allSongUniqueList = r100;
    }

    public final void setCommonData(com.bytedance.android.live.base.model.message.m0 r100) {
        setBaseMessage(r100);
    }

    public final void setDowngrade(boolean r100) {
        this.isDowngrade = r100;
    }

    public final void setMMusicInfoList(List<? extends a> r100) {
        this.mMusicInfoList = r100;
    }

    public final void setMessageType(int r100) {
        this.messageType = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.t8
    public void setSungSongCount(long r100) {
        this.sungSongCount = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.t8
    public void setWantSingCount(long r100) {
        this.wantSingCount = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.t8
    public void setWantSingSongThreshold(long r100) {
        this.wantSingSongThreshold = r100;
    }
}
