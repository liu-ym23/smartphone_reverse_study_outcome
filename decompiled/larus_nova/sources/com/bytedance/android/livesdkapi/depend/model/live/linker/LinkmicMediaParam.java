package com.bytedance.android.livesdkapi.depend.model.live.linker;

import am3.g;
import com.bytedance.android.live.liveinteract.plantform.model.LinkmicMediaInfo;
import com.bytedance.android.live.liveinteract.plantform.model.LinkmicMediaInfoForEnterRoom;
import com.bytedance.android.live.liveinteract.plantform.model.LinkmicStreamInfo;
import com.bytedance.android.live.liveinteract.plantform.model.PersonalKaraokeMediaInfo;
import com.bytedance.android.live.liveinteract.plantform.model.UpdateMediaInfoNotify;
import com.bytedance.android.live.liveinteract.plantform.model.i0;
import com.bytedance.android.live.liveinteract.plantform.model.k;
import com.bytedance.android.live.liveinteract.plantform.model.k0;
import com.bytedance.android.live.liveinteract.plantform.model.r;
import com.bytedance.android.live.liveinteract.plantform.model.r0;
import com.bytedance.android.livesdk.link.model.bridge.j1;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 62\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u00016B\u0007¢\u0006\u0004\b4\u00105R\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010'\u001a\u0004\u0018\u00010&8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010.\u001a\u0004\u0018\u00010-8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u00067"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkmicMediaParam;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkmicMediaParam;", "", "linkmicMediaType", "I", "getLinkmicMediaType", "()I", "setLinkmicMediaType", "(I)V", "Lcom/bytedance/android/live/liveinteract/plantform/model/LinkmicMediaInfo;", "linkmicMediaInfo", "Lcom/bytedance/android/live/liveinteract/plantform/model/LinkmicMediaInfo;", "getLinkmicMediaInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/LinkmicMediaInfo;", "setLinkmicMediaInfo", "(Lcom/bytedance/android/live/liveinteract/plantform/model/LinkmicMediaInfo;)V", "Lcom/bytedance/android/live/liveinteract/plantform/model/r0;", "ktvComponentMediaInfo", "Lcom/bytedance/android/live/liveinteract/plantform/model/r0;", "getKtvComponentMediaInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/r0;", "setKtvComponentMediaInfo", "(Lcom/bytedance/android/live/liveinteract/plantform/model/r0;)V", "Lcom/bytedance/android/live/liveinteract/plantform/model/PersonalKaraokeMediaInfo;", "personalKaraokeMediaInfo", "Lcom/bytedance/android/live/liveinteract/plantform/model/PersonalKaraokeMediaInfo;", "getPersonalKaraokeMediaInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/PersonalKaraokeMediaInfo;", "setPersonalKaraokeMediaInfo", "(Lcom/bytedance/android/live/liveinteract/plantform/model/PersonalKaraokeMediaInfo;)V", "Lcom/bytedance/android/live/liveinteract/plantform/model/UpdateMediaInfoNotify;", "updateMediaInfoNotify", "Lcom/bytedance/android/live/liveinteract/plantform/model/UpdateMediaInfoNotify;", "getUpdateMediaInfoNotify", "()Lcom/bytedance/android/live/liveinteract/plantform/model/UpdateMediaInfoNotify;", "setUpdateMediaInfoNotify", "(Lcom/bytedance/android/live/liveinteract/plantform/model/UpdateMediaInfoNotify;)V", "Lcom/bytedance/android/live/liveinteract/plantform/model/LinkmicStreamInfo;", "linkmicStreamInfo", "Lcom/bytedance/android/live/liveinteract/plantform/model/LinkmicStreamInfo;", "getLinkmicStreamInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/LinkmicStreamInfo;", "setLinkmicStreamInfo", "(Lcom/bytedance/android/live/liveinteract/plantform/model/LinkmicStreamInfo;)V", "Lcom/bytedance/android/live/liveinteract/plantform/model/LinkmicMediaInfoForEnterRoom;", "linkMediaInfoForEnterRoom", "Lcom/bytedance/android/live/liveinteract/plantform/model/LinkmicMediaInfoForEnterRoom;", "getLinkMediaInfoForEnterRoom", "()Lcom/bytedance/android/live/liveinteract/plantform/model/LinkmicMediaInfoForEnterRoom;", "setLinkMediaInfoForEnterRoom", "(Lcom/bytedance/android/live/liveinteract/plantform/model/LinkmicMediaInfoForEnterRoom;)V", "<init>", "()V", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkmicMediaParam extends FlexModelBase<ILinkmicMediaParam> implements ILinkmicMediaParam, h {
    public static final Companion Companion = null;
    private static final int TYPE_LINKMIC_MEDIA_CHANGE = 0;
    private static final int TYPE_LINKMIC_MEDIA_ENTER_ROOM = 0;
    private static final int TYPE_LINKMIC_MEDIA_KTV_COMPONENT = 0;
    private static final int TYPE_LINKMIC_MEDIA_UNKNOWN = 0;
    private static final int TYPE_LINKMIC_MEDIA_UPDATE_PARAM_NOTIFY = 0;
    public static final int TYPE_LINKMIC_STREAM_INFO = 0;

    @SerializedName("ktv_component_media_info")
    protected r0 ktvComponentMediaInfo;

    @SerializedName("media_info_for_enter_room")
    protected LinkmicMediaInfoForEnterRoom linkMediaInfoForEnterRoom;

    @SerializedName("linkmic_media_info")
    protected LinkmicMediaInfo linkmicMediaInfo;

    @SerializedName("linkmic_media_type")
    protected int linkmicMediaType;

    @SerializedName("linkmic_stream_info")
    protected LinkmicStreamInfo linkmicStreamInfo;

    @SerializedName("personal_karaoke_info")
    protected PersonalKaraokeMediaInfo personalKaraokeMediaInfo;

    @SerializedName("update_media_info_notify")
    protected UpdateMediaInfoNotify updateMediaInfoNotify;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0010\u0010\u000f\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkmicMediaParam$Companion;", "", "()V", "TYPE_LINKMIC_MEDIA_CHANGE", "", "getTYPE_LINKMIC_MEDIA_CHANGE", "()I", "TYPE_LINKMIC_MEDIA_ENTER_ROOM", "getTYPE_LINKMIC_MEDIA_ENTER_ROOM", "TYPE_LINKMIC_MEDIA_KTV_COMPONENT", "getTYPE_LINKMIC_MEDIA_KTV_COMPONENT", "TYPE_LINKMIC_MEDIA_UNKNOWN", "getTYPE_LINKMIC_MEDIA_UNKNOWN", "TYPE_LINKMIC_MEDIA_UPDATE_PARAM_NOTIFY", "getTYPE_LINKMIC_MEDIA_UPDATE_PARAM_NOTIFY", "TYPE_LINKMIC_STREAM_INFO", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public final int getTYPE_LINKMIC_MEDIA_CHANGE() {
            return LinkmicMediaParam.access$getTYPE_LINKMIC_MEDIA_CHANGE$cp();
        }

        public final int getTYPE_LINKMIC_MEDIA_ENTER_ROOM() {
            return LinkmicMediaParam.access$getTYPE_LINKMIC_MEDIA_ENTER_ROOM$cp();
        }

        public final int getTYPE_LINKMIC_MEDIA_KTV_COMPONENT() {
            return LinkmicMediaParam.access$getTYPE_LINKMIC_MEDIA_KTV_COMPONENT$cp();
        }

        public final int getTYPE_LINKMIC_MEDIA_UNKNOWN() {
            return LinkmicMediaParam.access$getTYPE_LINKMIC_MEDIA_UNKNOWN$cp();
        }

        public final int getTYPE_LINKMIC_MEDIA_UPDATE_PARAM_NOTIFY() {
            return LinkmicMediaParam.access$getTYPE_LINKMIC_MEDIA_UPDATE_PARAM_NOTIFY$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        TYPE_LINKMIC_MEDIA_CHANGE = 1;
        TYPE_LINKMIC_MEDIA_KTV_COMPONENT = 2;
        TYPE_LINKMIC_MEDIA_UPDATE_PARAM_NOTIFY = 3;
        TYPE_LINKMIC_STREAM_INFO = 5;
        TYPE_LINKMIC_MEDIA_ENTER_ROOM = 6;
    }

    public LinkmicMediaParam() {
        super(ILinkmicMediaParam.class);
        this.linkmicMediaType = TYPE_LINKMIC_MEDIA_UNKNOWN;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkmicMediaParamDef
    public /* bridge */ /* synthetic */ k getLinkMediaInfoForEnterRoom() {
        return getLinkMediaInfoForEnterRoom();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkmicMediaParamDef
    public /* bridge */ /* synthetic */ j1 getLinkmicMediaInfo() {
        return getLinkmicMediaInfo();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkmicMediaParam
    public /* bridge */ /* synthetic */ r getLinkmicStreamInfo() {
        return getLinkmicStreamInfo();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkmicMediaParam
    public /* bridge */ /* synthetic */ i0 getPersonalKaraokeMediaInfo() {
        return getPersonalKaraokeMediaInfo();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkmicMediaParam, com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkmicMediaParamDef
    public /* bridge */ /* synthetic */ k0 getUpdateMediaInfoNotify() {
        return getUpdateMediaInfoNotify();
    }

    public static final /* synthetic */ int access$getTYPE_LINKMIC_MEDIA_CHANGE$cp() {
        return TYPE_LINKMIC_MEDIA_CHANGE;
    }

    public static final /* synthetic */ int access$getTYPE_LINKMIC_MEDIA_ENTER_ROOM$cp() {
        return TYPE_LINKMIC_MEDIA_ENTER_ROOM;
    }

    public static final /* synthetic */ int access$getTYPE_LINKMIC_MEDIA_KTV_COMPONENT$cp() {
        return TYPE_LINKMIC_MEDIA_KTV_COMPONENT;
    }

    public static final /* synthetic */ int access$getTYPE_LINKMIC_MEDIA_UNKNOWN$cp() {
        return TYPE_LINKMIC_MEDIA_UNKNOWN;
    }

    public static final /* synthetic */ int access$getTYPE_LINKMIC_MEDIA_UPDATE_PARAM_NOTIFY$cp() {
        return TYPE_LINKMIC_MEDIA_UPDATE_PARAM_NOTIFY;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkmicMediaParam
    public r0 getKtvComponentMediaInfo() {
        return this.ktvComponentMediaInfo;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkmicMediaParamDef
    public int getLinkmicMediaType() {
        return this.linkmicMediaType;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkmicMediaParamDef
    public LinkmicMediaInfoForEnterRoom getLinkMediaInfoForEnterRoom() {
        return this.linkMediaInfoForEnterRoom;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkmicMediaParamDef
    public LinkmicMediaInfo getLinkmicMediaInfo() {
        return this.linkmicMediaInfo;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkmicMediaParam
    public LinkmicStreamInfo getLinkmicStreamInfo() {
        return this.linkmicStreamInfo;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkmicMediaParam
    public PersonalKaraokeMediaInfo getPersonalKaraokeMediaInfo() {
        return this.personalKaraokeMediaInfo;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkmicMediaParam, com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkmicMediaParamDef
    public UpdateMediaInfoNotify getUpdateMediaInfoNotify() {
        return this.updateMediaInfoNotify;
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [com.bytedance.android.live.liveinteract.plantform.model.r0, java.lang.Object] */
    public LinkmicMediaParam(g r100) {
        super(ILinkmicMediaParam.class);
        boolean r101 = false;
        setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        g.a r104 = decodeExtensionFields(r103, r100);
        switch(r103) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L7;
        };
    L8:
        this.linkMediaInfoForEnterRoom = new LinkmicMediaInfoForEnterRoom(r100);
        goto L3
    L9:
        this.linkmicStreamInfo = new LinkmicStreamInfo(r100);
        goto L3
    L10:
        this.personalKaraokeMediaInfo = new PersonalKaraokeMediaInfo(r100);
        goto L3
    L11:
        this.updateMediaInfoNotify = new UpdateMediaInfoNotify(r100);
        goto L3
    L12:
        this.ktvComponentMediaInfo = f.a(r100, r0.class);
        goto L3
    L13:
        this.linkmicMediaInfo = new LinkmicMediaInfo(r100);
        goto L3
    L14:
        this.linkmicMediaType = r100.i();
        r101 = r101 | true;
        goto L3
    L7:
        am3.h.d(r104, r100);
        goto L3
    L15:
        r100.d(r102);
        setThreadSafe(true);
        if ((true & r101) == true) goto L37;
        this.linkmicMediaType = TYPE_LINKMIC_MEDIA_UNKNOWN;
        return;
    }

    public void setKtvComponentMediaInfo(r0 r100) {
        this.ktvComponentMediaInfo = r100;
    }

    public void setLinkMediaInfoForEnterRoom(LinkmicMediaInfoForEnterRoom r100) {
        this.linkMediaInfoForEnterRoom = r100;
    }

    public void setLinkmicMediaInfo(LinkmicMediaInfo r100) {
        this.linkmicMediaInfo = r100;
    }

    public void setLinkmicMediaType(int r100) {
        this.linkmicMediaType = r100;
    }

    public void setLinkmicStreamInfo(LinkmicStreamInfo r100) {
        this.linkmicStreamInfo = r100;
    }

    public void setPersonalKaraokeMediaInfo(PersonalKaraokeMediaInfo r100) {
        this.personalKaraokeMediaInfo = r100;
    }

    public void setUpdateMediaInfoNotify(UpdateMediaInfoNotify r100) {
        this.updateMediaInfoNotify = r100;
    }
}
