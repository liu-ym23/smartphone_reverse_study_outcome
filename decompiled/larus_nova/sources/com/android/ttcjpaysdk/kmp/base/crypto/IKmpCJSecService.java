package com.android.ttcjpaysdk.kmp.base.crypto;

import kotlin.Metadata;
import pd6.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H&¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/crypto/IKmpCJSecService;", "Lcom/bytedance/kmp/spi/IKmpService;", "sm3", "", "input", "sign", "privateKey", "verifySign", "", "publicKey", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IKmpCJSecService extends a {
    byte[] sign(byte[] r100, byte[] r101);

    byte[] sm3(byte[] r100);

    boolean verifySign(byte[] r100, byte[] r101, byte[] r102);
}
