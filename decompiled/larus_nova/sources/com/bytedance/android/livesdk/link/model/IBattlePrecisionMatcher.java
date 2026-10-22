package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.tencent.connect.common.Constants;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001dR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\"\u0010\r\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010R.\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u00158&X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001c\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattlePrecisionMatcher;", "Lvh7/c;", "", "getUserId", "()Ljava/lang/String;", "getUserId$annotations", "()V", "userId", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomKt;", "getRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getRoom$annotations", "room", "", "getStatus", "()I", "getStatus$annotations", "status", "", "Lcom/bytedance/android/livesdk/link/model/IBattleRivalTag;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getTagList", "()Ljava/util/List;", "getTagList$annotations", "tagList", "getDescText", "getDescText$annotations", "descText", "Status", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IBattlePrecisionMatcher extends vh7.c<IBattlePrecisionMatcher> {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattlePrecisionMatcher$Status;", "", "StatusUndefined", "StatusNotReady", "StatusReady", "StatusRejected", "StatusLater", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Status extends Enum<Status> {
        public static final Status StatusLater = null;
        public static final Status StatusNotReady = null;
        public static final Status StatusReady = null;
        public static final Status StatusRejected = null;
        public static final Status StatusUndefined = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Status[] f147032a = null;

        static {
            Status r100 = new Status("StatusUndefined", 0);
            StatusUndefined = r100;
            Status r101 = new Status("StatusNotReady", 1);
            StatusNotReady = r101;
            Status r102 = new Status("StatusReady", 2);
            StatusReady = r102;
            Status r103 = new Status("StatusRejected", 3);
            StatusRejected = r103;
            Status r104 = new Status("StatusLater", 4);
            StatusLater = r104;
            f147032a = new Status[]{r100, r101, r102, r103, r104};
        }

        public static Status valueOf(String r100) {
            return (Status) r27.a.a(Status.class, r100);
        }

        public static Status[] values() {
            return (Status[]) f147032a.clone();
        }

        public Status(String r100, int r101) {
            super(r100, r101);
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

    @FieldName(name = "desc_text")
    String getDescText();

    @FieldName(name = "room")
    IRoom getRoom();

    @FieldName(name = "status")
    int getStatus();

    @FieldName(name = PromotionProductPrivilegesStruct.TAGS)
    List<IBattleRivalTag> getTagList();

    @FieldName(name = Constants.JumpUrlConstants.URL_KEY_OPENID)
    String getUserId();
}
