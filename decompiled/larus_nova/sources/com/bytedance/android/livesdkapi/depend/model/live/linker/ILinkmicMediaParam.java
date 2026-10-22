package com.bytedance.android.livesdkapi.depend.model.live.linker;

import com.bytedance.android.live.liveinteract.plantform.model.i0;
import com.bytedance.android.live.liveinteract.plantform.model.k0;
import com.bytedance.android.live.liveinteract.plantform.model.r;
import com.bytedance.android.live.liveinteract.plantform.model.r0;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0018R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\r\u001a\u0004\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0007\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkmicMediaParam;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkmicMediaParamDef;", "Lcom/bytedance/android/live/liveinteract/plantform/model/r0;", "getKtvComponentMediaInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/r0;", "getKtvComponentMediaInfo$annotations", "()V", "ktvComponentMediaInfo", "Lcom/bytedance/android/live/liveinteract/plantform/model/i0;", "getPersonalKaraokeMediaInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/i0;", "getPersonalKaraokeMediaInfo$annotations", "personalKaraokeMediaInfo", "Lcom/bytedance/android/live/liveinteract/plantform/model/k0;", "getUpdateMediaInfoNotify", "()Lcom/bytedance/android/live/liveinteract/plantform/model/k0;", "getUpdateMediaInfoNotify$annotations", "updateMediaInfoNotify", "Lcom/bytedance/android/live/liveinteract/plantform/model/r;", "getLinkmicStreamInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/r;", "getLinkmicStreamInfo$annotations", "linkmicStreamInfo", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkmicMediaParam extends c<ILinkmicMediaParam>, ILinkmicMediaParamDef {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkmicMediaParam$Companion;", "", "()V", "TYPE_LINKMIC_MEDIA_CHANGE", "", "getTYPE_LINKMIC_MEDIA_CHANGE", "()I", "TYPE_LINKMIC_MEDIA_ENTER_ROOM", "getTYPE_LINKMIC_MEDIA_ENTER_ROOM", "TYPE_LINKMIC_MEDIA_KTV_COMPONENT", "getTYPE_LINKMIC_MEDIA_KTV_COMPONENT", "TYPE_LINKMIC_MEDIA_UNKNOWN", "getTYPE_LINKMIC_MEDIA_UNKNOWN", "TYPE_LINKMIC_MEDIA_UPDATE_PARAM_NOTIFY", "getTYPE_LINKMIC_MEDIA_UPDATE_PARAM_NOTIFY", "TYPE_LINKMIC_STREAM_INFO", "getTYPE_LINKMIC_STREAM_INFO", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final int TYPE_LINKMIC_MEDIA_CHANGE = 0;
        private static final int TYPE_LINKMIC_MEDIA_ENTER_ROOM = 0;
        private static final int TYPE_LINKMIC_MEDIA_KTV_COMPONENT = 0;
        private static final int TYPE_LINKMIC_MEDIA_UNKNOWN = 0;
        private static final int TYPE_LINKMIC_MEDIA_UPDATE_PARAM_NOTIFY = 0;
        private static final int TYPE_LINKMIC_STREAM_INFO = 0;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
            TYPE_LINKMIC_MEDIA_CHANGE = 1;
            TYPE_LINKMIC_MEDIA_KTV_COMPONENT = 2;
            TYPE_LINKMIC_MEDIA_UPDATE_PARAM_NOTIFY = 3;
            TYPE_LINKMIC_STREAM_INFO = 5;
            TYPE_LINKMIC_MEDIA_ENTER_ROOM = 6;
        }

        public final int getTYPE_LINKMIC_MEDIA_CHANGE() {
            return TYPE_LINKMIC_MEDIA_CHANGE;
        }

        public final int getTYPE_LINKMIC_MEDIA_ENTER_ROOM() {
            return TYPE_LINKMIC_MEDIA_ENTER_ROOM;
        }

        public final int getTYPE_LINKMIC_MEDIA_KTV_COMPONENT() {
            return TYPE_LINKMIC_MEDIA_KTV_COMPONENT;
        }

        public final int getTYPE_LINKMIC_MEDIA_UNKNOWN() {
            return TYPE_LINKMIC_MEDIA_UNKNOWN;
        }

        public final int getTYPE_LINKMIC_MEDIA_UPDATE_PARAM_NOTIFY() {
            return TYPE_LINKMIC_MEDIA_UPDATE_PARAM_NOTIFY;
        }

        public final int getTYPE_LINKMIC_STREAM_INFO() {
            return TYPE_LINKMIC_STREAM_INFO;
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "ktv_component_media_info")
        public static /* synthetic */ void getKtvComponentMediaInfo$annotations() {
        }

        @FieldName(name = "linkmic_stream_info")
        public static /* synthetic */ void getLinkmicStreamInfo$annotations() {
        }

        @FieldName(name = "personal_karaoke_info")
        public static /* synthetic */ void getPersonalKaraokeMediaInfo$annotations() {
        }

        @FieldName(name = "update_media_info_notify")
        public static /* synthetic */ void getUpdateMediaInfoNotify$annotations() {
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "ktv_component_media_info")
    r0 getKtvComponentMediaInfo();

    @FieldName(name = "linkmic_stream_info")
    r getLinkmicStreamInfo();

    @FieldName(name = "personal_karaoke_info")
    i0 getPersonalKaraokeMediaInfo();

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkmicMediaParamDef
    @FieldName(name = "update_media_info_notify")
    k0 getUpdateMediaInfoNotify();
}
