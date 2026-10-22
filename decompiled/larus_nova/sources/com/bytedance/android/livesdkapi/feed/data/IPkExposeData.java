package com.bytedance.android.livesdkapi.feed.data;

import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\bf\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0012\u0010\f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/data/IPkExposeData;", "", "iconId", "", "getIconId", "()I", "leftTime", "getLeftTime", "loadStatus", "getLoadStatus", "pkState", "getPkState", Keys.API_EVENT_KEY_PLAY_MODE, "getPlayMode", "Companion", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPkExposeData {
    public static final Companion Companion = null;
    public static final int PLAYMODE_CONNECTION = 3;
    public static final int PLAYMODE_PK = 0;
    public static final int PLAYMODE_PVE = 4;
    public static final int PLAYMODE_SHELLCONFIG = 2;
    public static final int PLAYMODE_VOTE = 1;
    public static final int STATE_LINK = 3;
    public static final int STATE_OTHER = 0;
    public static final int STATE_PENAL = 2;
    public static final int STATE_PK = 1;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/data/IPkExposeData$Companion;", "", "()V", "PLAYMODE_CONNECTION", "", "PLAYMODE_PK", "PLAYMODE_PVE", "PLAYMODE_SHELLCONFIG", "PLAYMODE_VOTE", "STATE_LINK", "STATE_OTHER", "STATE_PENAL", "STATE_PK", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int PLAYMODE_CONNECTION = 3;
        public static final int PLAYMODE_PK = 0;
        public static final int PLAYMODE_PVE = 4;
        public static final int PLAYMODE_SHELLCONFIG = 2;
        public static final int PLAYMODE_VOTE = 1;
        public static final int STATE_LINK = 3;
        public static final int STATE_OTHER = 0;
        public static final int STATE_PENAL = 2;
        public static final int STATE_PK = 1;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    int getIconId();

    int getLeftTime();

    int getLoadStatus();

    int getPkState();

    int getPlayMode();
}
