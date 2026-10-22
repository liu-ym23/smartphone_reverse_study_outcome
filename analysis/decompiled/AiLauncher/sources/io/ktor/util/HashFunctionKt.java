package io.ktor.util;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u001a/\u0010\u0006\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001c\u0010\t\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0082\u0004¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/ktor/util/HashFunction;", "", "input", "", "offset", "length", "digest", "(Lio/ktor/util/HashFunction;[BII)[B", "bitCount", "leftRotate", "(II)I", "ktor-utils"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HashFunctionKt {
    public static final byte[] digest(HashFunction hashFunction, byte[] input, int i10, int i11) {
        kotlin.jvm.internal.p.i(hashFunction, "<this>");
        kotlin.jvm.internal.p.i(input, "input");
        hashFunction.update(input, i10, i11);
        return hashFunction.digest();
    }

    public static /* synthetic */ byte[] digest$default(HashFunction hashFunction, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length;
        }
        return digest(hashFunction, bArr, i10, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int leftRotate(int i10, int i11) {
        return (i10 >>> (32 - i11)) | (i10 << i11);
    }
}
