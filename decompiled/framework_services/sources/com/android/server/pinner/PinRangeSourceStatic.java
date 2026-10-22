package com.android.server.pinner;

/* JADX INFO: loaded from: classes2.dex */
class PinRangeSourceStatic extends PinRangeSource {
    private boolean mDone;
    private final int mPinLength;
    private final int mPinStart;

    PinRangeSourceStatic(int pinStart, int pinLength) {
        this.mDone = false;
        this.mPinStart = pinStart;
        this.mPinLength = pinLength;
    }

    @Override // com.android.server.pinner.PinRangeSource
    boolean read(PinnerService.PinRange outPinRange) {
        outPinRange.start = this.mPinStart;
        outPinRange.length = this.mPinLength;
        boolean done = this.mDone;
        this.mDone = true;
        return !done;
    }
}
