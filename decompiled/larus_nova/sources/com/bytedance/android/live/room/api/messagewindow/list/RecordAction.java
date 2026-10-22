package com.bytedance.android.live.room.api.messagewindow.list;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/room/api/messagewindow/list/RecordAction;", "", "OfferShowingRecord", "RemoveShowingRecord", "OfferPendingRecord", "PeekPendingRecord", "RemovePendingRecord", "RemoveFromRecords", "PollWaitingRecord", "OfferWaitingRecords", "RemoveWaitingRecord", "OfferTemporaryRecord", "RemoveTemporaryRecord", "ClearAllRecords", "LogRecords", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RecordAction extends Enum<RecordAction> {
    public static final RecordAction ClearAllRecords = null;
    public static final RecordAction LogRecords = null;
    public static final RecordAction OfferPendingRecord = null;
    public static final RecordAction OfferShowingRecord = null;
    public static final RecordAction OfferTemporaryRecord = null;
    public static final RecordAction OfferWaitingRecords = null;
    public static final RecordAction PeekPendingRecord = null;
    public static final RecordAction PollWaitingRecord = null;
    public static final RecordAction RemoveFromRecords = null;
    public static final RecordAction RemovePendingRecord = null;
    public static final RecordAction RemoveShowingRecord = null;
    public static final RecordAction RemoveTemporaryRecord = null;
    public static final RecordAction RemoveWaitingRecord = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RecordAction[] f98991a = null;

    static {
        RecordAction r100 = new RecordAction("OfferShowingRecord", 0);
        OfferShowingRecord = r100;
        RecordAction r101 = new RecordAction("RemoveShowingRecord", 1);
        RemoveShowingRecord = r101;
        RecordAction r102 = new RecordAction("OfferPendingRecord", 2);
        OfferPendingRecord = r102;
        RecordAction r103 = new RecordAction("PeekPendingRecord", 3);
        PeekPendingRecord = r103;
        RecordAction r104 = new RecordAction("RemovePendingRecord", 4);
        RemovePendingRecord = r104;
        RecordAction r105 = new RecordAction("RemoveFromRecords", 5);
        RemoveFromRecords = r105;
        RecordAction r106 = new RecordAction("PollWaitingRecord", 6);
        PollWaitingRecord = r106;
        RecordAction r107 = new RecordAction("OfferWaitingRecords", 7);
        OfferWaitingRecords = r107;
        RecordAction r108 = new RecordAction("RemoveWaitingRecord", 8);
        RemoveWaitingRecord = r108;
        RecordAction r109 = new RecordAction("OfferTemporaryRecord", 9);
        OfferTemporaryRecord = r109;
        RecordAction r110 = new RecordAction("RemoveTemporaryRecord", 10);
        RemoveTemporaryRecord = r110;
        RecordAction r111 = new RecordAction("ClearAllRecords", 11);
        ClearAllRecords = r111;
        RecordAction r112 = new RecordAction("LogRecords", 12);
        LogRecords = r112;
        f98991a = new RecordAction[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112};
    }

    public static RecordAction valueOf(String r100) {
        return (RecordAction) a.a(RecordAction.class, r100);
    }

    public static RecordAction[] values() {
        return (RecordAction[]) f98991a.clone();
    }

    public RecordAction(String r100, int r101) {
        super(r100, r101);
    }
}
