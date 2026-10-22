package com.bytedance.android.livehostapi.business.depend.gamecp.cloudgame;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/gamecp/cloudgame/LiveGameOrientation;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "LANDSCAPE", "PORTRAIT", "Companion", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveGameOrientation extends Enum<LiveGameOrientation> {
    private static final /* synthetic */ LiveGameOrientation[] $VALUES = null;
    public static final Companion Companion = null;
    public static final LiveGameOrientation LANDSCAPE = null;
    public static final LiveGameOrientation PORTRAIT = null;
    private final int type;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/gamecp/cloudgame/LiveGameOrientation$Companion;", "", "()V", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        LiveGameOrientation r100 = new LiveGameOrientation("LANDSCAPE", 0, 0);
        LANDSCAPE = r100;
        LiveGameOrientation r101 = new LiveGameOrientation("PORTRAIT", 1, 1);
        PORTRAIT = r101;
        $VALUES = new LiveGameOrientation[]{r100, r101};
        Companion = new Companion(null);
    }

    public static LiveGameOrientation valueOf(String r100) {
        return (LiveGameOrientation) a.a(LiveGameOrientation.class, r100);
    }

    public static LiveGameOrientation[] values() {
        return (LiveGameOrientation[]) $VALUES.clone();
    }

    public final int getType() {
        return this.type;
    }

    private LiveGameOrientation(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
