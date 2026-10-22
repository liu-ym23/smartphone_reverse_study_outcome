package com.google.protobuf;

/* loaded from: classes3.dex */
class Utf8$UnpairedSurrogateException extends IllegalArgumentException {
    public Utf8$UnpairedSurrogateException(int i, int i6) {
        super(androidx.compose.foundation.b.n(i, i6, "Unpaired surrogate at index ", " of "));
    }
}
