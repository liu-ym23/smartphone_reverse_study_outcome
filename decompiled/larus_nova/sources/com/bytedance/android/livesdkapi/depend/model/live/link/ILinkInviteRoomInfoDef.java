package com.bytedance.android.livesdkapi.depend.model.live.link;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0010\bf\u0018\u00002\u00020\u0001R\u001e\u0010\u0002\u001a\u00060\u0003j\u0002`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00060\u0003j\u0002`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00060\u0003j\u0002`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0013\u0010\bR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0016\u0010\u0010R\u001e\u0010\u0017\u001a\u00060\u0003j\u0002`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0019\u0010\bR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001c\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/link/ILinkInviteRoomInfoDef;", "", "inviterRoomId", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getInviterRoomId$annotations", "()V", "getInviterRoomId", "()J", "liveRoomMode", "getLiveRoomMode$annotations", "getLiveRoomMode", "roomDesc", "", "getRoomDesc$annotations", "getRoomDesc", "()Ljava/lang/String;", a.KEY_SCORE, "getScore$annotations", "getScore", "scoreFuzzy", "getScoreFuzzy$annotations", "getScoreFuzzy", "userCount", "getUserCount$annotations", "getUserCount", "userCountFuzzy", "getUserCountFuzzy$annotations", "getUserCountFuzzy", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkInviteRoomInfoDef {

    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "inviter_room_id")
        public static /* synthetic */ void getInviterRoomId$annotations() {
        }

        @FieldName(name = "live_room_mode")
        public static /* synthetic */ void getLiveRoomMode$annotations() {
        }

        @FieldName(name = "room_desc")
        public static /* synthetic */ void getRoomDesc$annotations() {
        }

        @FieldName(name = a.KEY_SCORE)
        public static /* synthetic */ void getScore$annotations() {
        }

        @FieldName(name = "score_fuzzy")
        public static /* synthetic */ void getScoreFuzzy$annotations() {
        }

        @FieldName(name = "user_count")
        public static /* synthetic */ void getUserCount$annotations() {
        }

        @FieldName(name = "user_count_fuzzy")
        public static /* synthetic */ void getUserCountFuzzy$annotations() {
        }
    }

    long getInviterRoomId();

    long getLiveRoomMode();

    String getRoomDesc();

    long getScore();

    String getScoreFuzzy();

    long getUserCount();

    String getUserCountFuzzy();
}
