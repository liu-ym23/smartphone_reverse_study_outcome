package com.bytedance.android.livesdkapi.depend.model.live.linker;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import r27.a;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0018\u0019R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerKickOutContent;", "Lvh7/c;", "", "getPaid_count", "()I", "getPaid_count$annotations", "()V", "paid_count", "getLink_duration", "getLink_duration$annotations", "link_duration", "getKickOutSource", "getKickOutSource$annotations", "kickOutSource", "", "getFromUserId", "()J", "getFromUserId$annotations", "fromUserId", "", "getFromUserOpenId", "()Ljava/lang/String;", "getFromUserOpenId$annotations", "fromUserOpenId", "KickOutSource", "LinkmicActionSource", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkerKickOutContent extends c<ILinkerKickOutContent> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "from_user_id")
        public static /* synthetic */ void getFromUserId$annotations() {
        }

        @FieldName(name = "from_open_id")
        public static /* synthetic */ void getFromUserOpenId$annotations() {
        }

        @FieldName(name = "kick_out_source")
        public static /* synthetic */ void getKickOutSource$annotations() {
        }

        @FieldName(name = "link_duration")
        public static /* synthetic */ void getLink_duration$annotations() {
        }

        @FieldName(name = "paid_count")
        public static /* synthetic */ void getPaid_count$annotations() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerKickOutContent$KickOutSource;", "", "(Ljava/lang/String;I)V", "Unknown", "FromOrganizer", "General", "RTCLeave", "RTCUnLink", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum KickOutSource extends Enum<KickOutSource> {
        private static final /* synthetic */ KickOutSource[] $VALUES = null;
        public static final KickOutSource FromOrganizer = null;
        public static final KickOutSource General = null;
        public static final KickOutSource RTCLeave = null;
        public static final KickOutSource RTCUnLink = null;
        public static final KickOutSource Unknown = null;

        static {
            KickOutSource r100 = new KickOutSource("Unknown", 0);
            Unknown = r100;
            KickOutSource r101 = new KickOutSource("FromOrganizer", 1);
            FromOrganizer = r101;
            KickOutSource r102 = new KickOutSource("General", 2);
            General = r102;
            KickOutSource r103 = new KickOutSource("RTCLeave", 3);
            RTCLeave = r103;
            KickOutSource r104 = new KickOutSource("RTCUnLink", 4);
            RTCUnLink = r104;
            $VALUES = new KickOutSource[]{r100, r101, r102, r103, r104};
        }

        public static KickOutSource valueOf(String r100) {
            return (KickOutSource) a.a(KickOutSource.class, r100);
        }

        public static KickOutSource[] values() {
            return (KickOutSource[]) $VALUES.clone();
        }

        private KickOutSource(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerKickOutContent$LinkmicActionSource;", "", "(Ljava/lang/String;I)V", "ActionSourceUndefined", "ActionSourceOrigin", "ActionSourceGamePannel", "ActionSourceRoomBattleUnselected", "ActionSourceSmallWindowToPKKicked", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum LinkmicActionSource extends Enum<LinkmicActionSource> {
        private static final /* synthetic */ LinkmicActionSource[] $VALUES = null;
        public static final LinkmicActionSource ActionSourceGamePannel = null;
        public static final LinkmicActionSource ActionSourceOrigin = null;
        public static final LinkmicActionSource ActionSourceRoomBattleUnselected = null;
        public static final LinkmicActionSource ActionSourceSmallWindowToPKKicked = null;
        public static final LinkmicActionSource ActionSourceUndefined = null;

        static {
            LinkmicActionSource r100 = new LinkmicActionSource("ActionSourceUndefined", 0);
            ActionSourceUndefined = r100;
            LinkmicActionSource r101 = new LinkmicActionSource("ActionSourceOrigin", 1);
            ActionSourceOrigin = r101;
            LinkmicActionSource r102 = new LinkmicActionSource("ActionSourceGamePannel", 2);
            ActionSourceGamePannel = r102;
            LinkmicActionSource r103 = new LinkmicActionSource("ActionSourceRoomBattleUnselected", 3);
            ActionSourceRoomBattleUnselected = r103;
            LinkmicActionSource r104 = new LinkmicActionSource("ActionSourceSmallWindowToPKKicked", 4);
            ActionSourceSmallWindowToPKKicked = r104;
            $VALUES = new LinkmicActionSource[]{r100, r101, r102, r103, r104};
        }

        public static LinkmicActionSource valueOf(String r100) {
            return (LinkmicActionSource) a.a(LinkmicActionSource.class, r100);
        }

        public static LinkmicActionSource[] values() {
            return (LinkmicActionSource[]) $VALUES.clone();
        }

        private LinkmicActionSource(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "from_user_id")
    long getFromUserId();

    @FieldName(name = "from_open_id")
    String getFromUserOpenId();

    @FieldName(name = "kick_out_source")
    int getKickOutSource();

    @FieldName(name = "link_duration")
    int getLink_duration();

    @FieldName(name = "paid_count")
    int getPaid_count();
}
