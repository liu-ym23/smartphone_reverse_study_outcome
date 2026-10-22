package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002#$R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0013\u0010\u0010R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0016\u0010\u0010R\u001a\u0010\u001d\u001a\u00020\u00198&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\"\u001a\u0004\u0018\u00010\u001e8&X§\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/ILinkmicInteractEntrance;", "Lvh7/c;", "", "getStatus", "()I", "getStatus$annotations", "()V", "status", "", "Lcom/bytedance/android/livesdk/chatroom/model/interact/r;", "getButtons", "()Ljava/util/List;", "getButtons$annotations", "buttons", "", "getSource", "()Ljava/lang/String;", "getSource$annotations", "source", "getName", "getName$annotations", "name", "getNameColor", "getNameColor$annotations", "nameColor", "", "getEntranceId", "()J", "getEntranceId$annotations", "entranceId", "Lcom/bytedance/android/livesdk/chatroom/model/interact/p;", "getBanners", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/p;", "getBanners$annotations", PromotionProductPrivilegesStruct.BANNERS, "LinkmicEntranceStatus", "LinkmicInteractEntranceID", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkmicInteractEntrance extends vh7.c<ILinkmicInteractEntrance> {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/ILinkmicInteractEntrance$LinkmicEntranceStatus;", "", "", "value", "I", "getValue", "()I", "setValue", "(I)V", "ENTRANCE_STATUS_UNKONWN", "ENTRANCE_STATUS_PREHEAT", "ENTRANCE_STATUS_TIMELIMIT", "ENTRANCE_STATUS_SHUTDOWN", "ENTRANCE_STATUS_NORMAL", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum LinkmicEntranceStatus extends Enum<LinkmicEntranceStatus> {
        public static final LinkmicEntranceStatus ENTRANCE_STATUS_NORMAL = null;
        public static final LinkmicEntranceStatus ENTRANCE_STATUS_PREHEAT = null;
        public static final LinkmicEntranceStatus ENTRANCE_STATUS_SHUTDOWN = null;
        public static final LinkmicEntranceStatus ENTRANCE_STATUS_TIMELIMIT = null;
        public static final LinkmicEntranceStatus ENTRANCE_STATUS_UNKONWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LinkmicEntranceStatus[] f106894a = null;
        private int value;

        static {
            LinkmicEntranceStatus r100 = new LinkmicEntranceStatus("ENTRANCE_STATUS_UNKONWN", 0, 0);
            ENTRANCE_STATUS_UNKONWN = r100;
            LinkmicEntranceStatus r101 = new LinkmicEntranceStatus("ENTRANCE_STATUS_PREHEAT", 1, 1);
            ENTRANCE_STATUS_PREHEAT = r101;
            LinkmicEntranceStatus r102 = new LinkmicEntranceStatus("ENTRANCE_STATUS_TIMELIMIT", 2, 2);
            ENTRANCE_STATUS_TIMELIMIT = r102;
            LinkmicEntranceStatus r103 = new LinkmicEntranceStatus("ENTRANCE_STATUS_SHUTDOWN", 3, 3);
            ENTRANCE_STATUS_SHUTDOWN = r103;
            LinkmicEntranceStatus r104 = new LinkmicEntranceStatus("ENTRANCE_STATUS_NORMAL", 4, 4);
            ENTRANCE_STATUS_NORMAL = r104;
            f106894a = new LinkmicEntranceStatus[]{r100, r101, r102, r103, r104};
        }

        public static LinkmicEntranceStatus valueOf(String r100) {
            return (LinkmicEntranceStatus) r27.a.a(LinkmicEntranceStatus.class, r100);
        }

        public static LinkmicEntranceStatus[] values() {
            return (LinkmicEntranceStatus[]) f106894a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public final void setValue(int r100) {
            this.value = r100;
        }

        public LinkmicEntranceStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/ILinkmicInteractEntrance$LinkmicInteractEntranceID;", "", "", "value", "J", "getValue", "()J", "LINKMIC_INTERACT_ENTRANCE_ID_UNKNOWN", "LINKMIC_INTERACT_ENTRANCE_ID_FRIENDSHIP", "LINKMIC_INTERACT_ENTRANCE_ID_ADVENTURE_INVITE", "LINKMIC_INTERACT_ENTRANCE_ID_ADVENTURE_INVITE_LIST", "LINKMIC_INTERACT_ENTRANCE_ID_ADVENTURE_SET_MVP", "LINKMIC_INTERACT_ENTRANCE_ID_ADVENTURE_UNSET_MVP", "LINKMIC_INTERACT_ENTRANCE_ID_GUEST_LINK_INVITE", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum LinkmicInteractEntranceID extends Enum<LinkmicInteractEntranceID> {
        public static final LinkmicInteractEntranceID LINKMIC_INTERACT_ENTRANCE_ID_ADVENTURE_INVITE = null;
        public static final LinkmicInteractEntranceID LINKMIC_INTERACT_ENTRANCE_ID_ADVENTURE_INVITE_LIST = null;
        public static final LinkmicInteractEntranceID LINKMIC_INTERACT_ENTRANCE_ID_ADVENTURE_SET_MVP = null;
        public static final LinkmicInteractEntranceID LINKMIC_INTERACT_ENTRANCE_ID_ADVENTURE_UNSET_MVP = null;
        public static final LinkmicInteractEntranceID LINKMIC_INTERACT_ENTRANCE_ID_FRIENDSHIP = null;
        public static final LinkmicInteractEntranceID LINKMIC_INTERACT_ENTRANCE_ID_GUEST_LINK_INVITE = null;
        public static final LinkmicInteractEntranceID LINKMIC_INTERACT_ENTRANCE_ID_UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LinkmicInteractEntranceID[] f106895a = null;
        private final long value;

        static {
            LinkmicInteractEntranceID r100 = new LinkmicInteractEntranceID("LINKMIC_INTERACT_ENTRANCE_ID_UNKNOWN", 0, 0);
            LINKMIC_INTERACT_ENTRANCE_ID_UNKNOWN = r100;
            LinkmicInteractEntranceID r101 = new LinkmicInteractEntranceID("LINKMIC_INTERACT_ENTRANCE_ID_FRIENDSHIP", 1, 1);
            LINKMIC_INTERACT_ENTRANCE_ID_FRIENDSHIP = r101;
            LinkmicInteractEntranceID r102 = new LinkmicInteractEntranceID("LINKMIC_INTERACT_ENTRANCE_ID_ADVENTURE_INVITE", 2, 2);
            LINKMIC_INTERACT_ENTRANCE_ID_ADVENTURE_INVITE = r102;
            LinkmicInteractEntranceID r103 = new LinkmicInteractEntranceID("LINKMIC_INTERACT_ENTRANCE_ID_ADVENTURE_INVITE_LIST", 3, 3);
            LINKMIC_INTERACT_ENTRANCE_ID_ADVENTURE_INVITE_LIST = r103;
            LinkmicInteractEntranceID r104 = new LinkmicInteractEntranceID("LINKMIC_INTERACT_ENTRANCE_ID_ADVENTURE_SET_MVP", 4, 4);
            LINKMIC_INTERACT_ENTRANCE_ID_ADVENTURE_SET_MVP = r104;
            LinkmicInteractEntranceID r105 = new LinkmicInteractEntranceID("LINKMIC_INTERACT_ENTRANCE_ID_ADVENTURE_UNSET_MVP", 5, 5);
            LINKMIC_INTERACT_ENTRANCE_ID_ADVENTURE_UNSET_MVP = r105;
            LinkmicInteractEntranceID r106 = new LinkmicInteractEntranceID("LINKMIC_INTERACT_ENTRANCE_ID_GUEST_LINK_INVITE", 6, 6);
            LINKMIC_INTERACT_ENTRANCE_ID_GUEST_LINK_INVITE = r106;
            f106895a = new LinkmicInteractEntranceID[]{r100, r101, r102, r103, r104, r105, r106};
        }

        public static LinkmicInteractEntranceID valueOf(String r100) {
            return (LinkmicInteractEntranceID) r27.a.a(LinkmicInteractEntranceID.class, r100);
        }

        public static LinkmicInteractEntranceID[] values() {
            return (LinkmicInteractEntranceID[]) f106895a.clone();
        }

        public final long getValue() {
            return this.value;
        }

        public LinkmicInteractEntranceID(String r100, int r101, long r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "banner_info")
    com.bytedance.android.livesdk.chatroom.model.interact.p getBanners();

    @FieldName(name = "button_infos")
    List<com.bytedance.android.livesdk.chatroom.model.interact.r> getButtons();

    @FieldName(name = "entrance_id")
    long getEntranceId();

    @FieldName(name = "name")
    String getName();

    @FieldName(name = "name_color")
    String getNameColor();

    @FieldName(name = "source")
    String getSource();

    @FieldName(name = "status")
    int getStatus();
}
