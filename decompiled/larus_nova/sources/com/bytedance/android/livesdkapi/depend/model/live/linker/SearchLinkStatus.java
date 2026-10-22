package com.bytedance.android.livesdkapi.depend.model.live.linker;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\b\u0086\u0001\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/SearchLinkStatus;", "", "value", "", "(Ljava/lang/String;IJ)V", "getValue", "()J", "UNKNOWN", "INVITED", "PKING", "DISABLE_PK", "ROOM_BATTLING", "DISABLE_INVITE", "DISABLE_ROOM_BATTLE", "DISABLE_PLAY_MODE", "INVITING", "MATCHING", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SearchLinkStatus extends Enum<SearchLinkStatus> {
    private static final /* synthetic */ SearchLinkStatus[] $VALUES = null;
    public static final Companion Companion = null;
    public static final SearchLinkStatus DISABLE_INVITE = null;
    public static final SearchLinkStatus DISABLE_PK = null;
    public static final SearchLinkStatus DISABLE_PLAY_MODE = null;
    public static final SearchLinkStatus DISABLE_ROOM_BATTLE = null;
    public static final SearchLinkStatus INVITED = null;
    public static final SearchLinkStatus INVITING = null;
    public static final SearchLinkStatus MATCHING = null;
    public static final SearchLinkStatus PKING = null;
    public static final SearchLinkStatus ROOM_BATTLING = null;
    public static final SearchLinkStatus UNKNOWN = null;
    private final long value;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/SearchLinkStatus$Companion;", "", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    public static SearchLinkStatus valueOf(String r100) {
        return (SearchLinkStatus) a.a(SearchLinkStatus.class, r100);
    }

    public static SearchLinkStatus[] values() {
        return (SearchLinkStatus[]) $VALUES.clone();
    }

    static {
        SearchLinkStatus r100 = new SearchLinkStatus("UNKNOWN", 0, -1);
        UNKNOWN = r100;
        SearchLinkStatus r101 = new SearchLinkStatus("INVITED", 1, 0);
        INVITED = r101;
        SearchLinkStatus r102 = new SearchLinkStatus("PKING", 2, 1);
        PKING = r102;
        SearchLinkStatus r103 = new SearchLinkStatus("DISABLE_PK", 3, 2);
        DISABLE_PK = r103;
        SearchLinkStatus r104 = new SearchLinkStatus("ROOM_BATTLING", 4, 3);
        ROOM_BATTLING = r104;
        SearchLinkStatus r105 = new SearchLinkStatus("DISABLE_INVITE", 5, 4);
        DISABLE_INVITE = r105;
        SearchLinkStatus r106 = new SearchLinkStatus("DISABLE_ROOM_BATTLE", 6, 5);
        DISABLE_ROOM_BATTLE = r106;
        SearchLinkStatus r107 = new SearchLinkStatus("DISABLE_PLAY_MODE", 7, 6);
        DISABLE_PLAY_MODE = r107;
        SearchLinkStatus r108 = new SearchLinkStatus("INVITING", 8, 7);
        INVITING = r108;
        SearchLinkStatus r109 = new SearchLinkStatus("MATCHING", 9, 8);
        MATCHING = r109;
        $VALUES = new SearchLinkStatus[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109};
        Companion = new Companion(null);
    }

    public final long getValue() {
        return this.value;
    }

    private SearchLinkStatus(String r100, int r101, long r102) {
        super(r100, r101);
        this.value = r102;
    }
}
