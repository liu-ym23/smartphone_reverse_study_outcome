package com.bytedance.android.gamecp.business.monitorlink;

import com.ss.android.download.api.config.HttpMethod;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
public final class Attribution {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f56165a = 0;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/gamecp/business/monitorlink/Attribution$EVENT;", "", "", "type", "I", "getType", "()I", "UNKNOW", "SHOW", "CLICK", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum EVENT extends Enum<EVENT> {
        public static final EVENT CLICK = null;
        public static final EVENT SHOW = null;
        public static final EVENT UNKNOW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EVENT[] f56166a = null;
        private final int type;

        static {
            EVENT r100 = new EVENT("UNKNOW", 0, 0);
            UNKNOW = r100;
            EVENT r101 = new EVENT("SHOW", 1, 1);
            SHOW = r101;
            EVENT r102 = new EVENT("CLICK", 2, 2);
            CLICK = r102;
            f56166a = new EVENT[]{r100, r101, r102};
        }

        public static EVENT valueOf(String r100) {
            return (EVENT) r27.a.a(EVENT.class, r100);
        }

        public static EVENT[] values() {
            return (EVENT[]) f56166a.clone();
        }

        public final int getType() {
            return this.type;
        }

        public EVENT(String r100, int r101, int r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/gamecp/business/monitorlink/Attribution$FROM;", "", "", "type", "I", "getType", "()I", "UNKNOW", "PROMOTE_ICON", HttpMethod.DOWNLOAD, "BOOK", "CARD_GAME_ICON", "LIVE_CELL_CARD", "CANCEL_BOOK", "PLAY_VALID", "UPDATE", "WIFI_AUTO_DOWNLOAD", "MESSAGE_REACH_DOWNLOAD", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum FROM extends Enum<FROM> {
        public static final FROM BOOK = null;
        public static final FROM CANCEL_BOOK = null;
        public static final FROM CARD_GAME_ICON = null;
        public static final FROM DOWNLOAD = null;
        public static final FROM LIVE_CELL_CARD = null;
        public static final FROM MESSAGE_REACH_DOWNLOAD = null;
        public static final FROM PLAY_VALID = null;
        public static final FROM PROMOTE_ICON = null;
        public static final FROM UNKNOW = null;
        public static final FROM UPDATE = null;
        public static final FROM WIFI_AUTO_DOWNLOAD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FROM[] f56167a = null;
        private final int type;

        public static FROM valueOf(String r100) {
            return (FROM) r27.a.a(FROM.class, r100);
        }

        public static FROM[] values() {
            return (FROM[]) f56167a.clone();
        }

        static {
            FROM r100 = new FROM("UNKNOW", 0, 0);
            UNKNOW = r100;
            FROM r101 = new FROM("PROMOTE_ICON", 1, 1);
            PROMOTE_ICON = r101;
            FROM r102 = new FROM(HttpMethod.DOWNLOAD, 2, 2);
            DOWNLOAD = r102;
            FROM r103 = new FROM("BOOK", 3, 3);
            BOOK = r103;
            FROM r104 = new FROM("CARD_GAME_ICON", 4, 4);
            CARD_GAME_ICON = r104;
            FROM r105 = new FROM("LIVE_CELL_CARD", 5, 5);
            LIVE_CELL_CARD = r105;
            FROM r106 = new FROM("CANCEL_BOOK", 6, 6);
            CANCEL_BOOK = r106;
            FROM r107 = new FROM("PLAY_VALID", 7, 7);
            PLAY_VALID = r107;
            FROM r108 = new FROM("UPDATE", 8, 8);
            UPDATE = r108;
            FROM r109 = new FROM("WIFI_AUTO_DOWNLOAD", 9, 9);
            WIFI_AUTO_DOWNLOAD = r109;
            FROM r110 = new FROM("MESSAGE_REACH_DOWNLOAD", 10, 10);
            MESSAGE_REACH_DOWNLOAD = r110;
            f56167a = new FROM[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110};
        }

        public final int getType() {
            return this.type;
        }

        public FROM(String r100, int r101, int r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    static {
    }
}
