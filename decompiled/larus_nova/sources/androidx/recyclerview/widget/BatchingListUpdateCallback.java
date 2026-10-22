package androidx.recyclerview.widget;

/* JADX INFO: loaded from: classes17.dex */
public class BatchingListUpdateCallback implements ListUpdateCallback {
    private static final int TYPE_ADD = 1;
    private static final int TYPE_CHANGE = 3;
    private static final int TYPE_NONE = 0;
    private static final int TYPE_REMOVE = 2;
    int mLastEventCount;
    Object mLastEventPayload;
    int mLastEventPosition;
    int mLastEventType;
    final ListUpdateCallback mWrapped;

    public void dispatchLastEvent() {
        int r100 = this.mLastEventType;
        if (r100 != 0) goto L6;
        return;
    L6:
        if (r100 != 1) goto L8;
        this.mWrapped.onInserted(this.mLastEventPosition, this.mLastEventCount);
    L15:
        this.mLastEventPayload = null;
        this.mLastEventType = 0;
        return;
    L8:
        if (r100 != 2) goto L10;
        this.mWrapped.onRemoved(this.mLastEventPosition, this.mLastEventCount);
        goto L15
    L10:
        if (r100 != 3) goto L15;
        this.mWrapped.onChanged(this.mLastEventPosition, this.mLastEventCount, this.mLastEventPayload);
        goto L15
    }

    public BatchingListUpdateCallback(ListUpdateCallback r100) {
        this.mLastEventType = 0;
        this.mLastEventPosition = -1;
        this.mLastEventCount = -1;
        this.mLastEventPayload = null;
        this.mWrapped = r100;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int r100, int r101) {
        if (this.mLastEventType != 1) goto L10;
        int r102 = this.mLastEventPosition;
        if (r100 < r102) goto L10;
        int r103 = this.mLastEventCount;
        if (r100 > (r102 + r103)) goto L10;
        this.mLastEventCount = r103 + r101;
        this.mLastEventPosition = Math.min(r100, r102);
        return;
    L10:
        dispatchLastEvent();
        this.mLastEventPosition = r100;
        this.mLastEventCount = r101;
        this.mLastEventType = 1;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int r100, int r101) {
        dispatchLastEvent();
        this.mWrapped.onMoved(r100, r101);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int r100, int r101) {
        if (this.mLastEventType != 2) goto L10;
        int r102 = this.mLastEventPosition;
        if (r102 < r100) goto L10;
        if (r102 > (r100 + r101)) goto L10;
        this.mLastEventCount += r101;
        this.mLastEventPosition = r100;
        return;
    L10:
        dispatchLastEvent();
        this.mLastEventPosition = r100;
        this.mLastEventCount = r101;
        this.mLastEventType = 2;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onChanged(int r100, int r101, Object r102) {
        if (this.mLastEventType != 3) goto L12;
        int r103 = this.mLastEventPosition;
        int r104 = this.mLastEventCount;
        if (r100 > (r103 + r104)) goto L12;
        int r105 = r100 + r101;
        if (r105 < r103) goto L12;
        if (this.mLastEventPayload != r102) goto L12;
        this.mLastEventPosition = Math.min(r100, r103);
        this.mLastEventCount = Math.max(r104 + r103, r105) - this.mLastEventPosition;
        return;
    L12:
        dispatchLastEvent();
        this.mLastEventPosition = r100;
        this.mLastEventCount = r101;
        this.mLastEventPayload = r102;
        this.mLastEventType = 3;
    }
}
