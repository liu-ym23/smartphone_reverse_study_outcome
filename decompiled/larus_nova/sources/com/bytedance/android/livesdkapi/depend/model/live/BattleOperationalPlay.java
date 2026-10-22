package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import r27.a;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.OperationalPlay")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/BattleOperationalPlay;", "", "()V", "multipleMatches3", "Lcom/bytedance/android/livesdkapi/depend/model/live/BattleMultipleMatches3;", "getMultipleMatches3", "()Lcom/bytedance/android/livesdkapi/depend/model/live/BattleMultipleMatches3;", "setMultipleMatches3", "(Lcom/bytedance/android/livesdkapi/depend/model/live/BattleMultipleMatches3;)V", "operationalPlayType", "", "getOperationalPlayType", "()I", "setOperationalPlayType", "(I)V", "OperationalPlayType", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BattleOperationalPlay implements h {

    @SerializedName("multiple_matches_3")
    protected BattleMultipleMatches3 multipleMatches3;

    @SerializedName("operational_play_type")
    protected int operationalPlayType;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/BattleOperationalPlay$OperationalPlayType;", "", "(Ljava/lang/String;I)V", "OperationalPlayType_Unknwon", "OperationalPlayType_Unknwon1", "OperationalPlayType_MultipleMatches3", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum OperationalPlayType extends Enum<OperationalPlayType> {
        private static final /* synthetic */ OperationalPlayType[] $VALUES = null;
        public static final OperationalPlayType OperationalPlayType_MultipleMatches3 = null;
        public static final OperationalPlayType OperationalPlayType_Unknwon = null;
        public static final OperationalPlayType OperationalPlayType_Unknwon1 = null;

        static {
            OperationalPlayType r100 = new OperationalPlayType("OperationalPlayType_Unknwon", 0);
            OperationalPlayType_Unknwon = r100;
            OperationalPlayType r101 = new OperationalPlayType("OperationalPlayType_Unknwon1", 1);
            OperationalPlayType_Unknwon1 = r101;
            OperationalPlayType r102 = new OperationalPlayType("OperationalPlayType_MultipleMatches3", 2);
            OperationalPlayType_MultipleMatches3 = r102;
            $VALUES = new OperationalPlayType[]{r100, r101, r102};
        }

        public static OperationalPlayType valueOf(String r100) {
            return (OperationalPlayType) a.a(OperationalPlayType.class, r100);
        }

        public static OperationalPlayType[] values() {
            return (OperationalPlayType[]) $VALUES.clone();
        }

        private OperationalPlayType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public BattleOperationalPlay() {
    }

    public final BattleMultipleMatches3 getMultipleMatches3() {
        return this.multipleMatches3;
    }

    public final int getOperationalPlayType() {
        return this.operationalPlayType;
    }

    public BattleOperationalPlay(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.operationalPlayType = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.multipleMatches3 = new BattleMultipleMatches3(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }

    public final void setMultipleMatches3(BattleMultipleMatches3 r100) {
        this.multipleMatches3 = r100;
    }

    public final void setOperationalPlayType(int r100) {
        this.operationalPlayType = r100;
    }
}
