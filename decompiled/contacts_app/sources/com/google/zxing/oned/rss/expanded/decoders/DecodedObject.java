package com.google.zxing.oned.rss.expanded.decoders;

/* JADX INFO: loaded from: classes3.dex */
abstract class DecodedObject {
    private final int newPosition;

    DecodedObject(int r1) {
        this.newPosition = r1;
    }

    final int getNewPosition() {
        return this.newPosition;
    }
}
