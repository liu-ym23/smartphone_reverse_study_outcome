package com.android.ttcjpaysdk.kmp.common.crypto;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0005H&¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/crypto/KmpEncryptResult;", "", "getData", "", "getVersion", "", "getType1", "getType2", "getSupportCertType", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface KmpEncryptResult {
    String getData();

    int getSupportCertType();

    int getType1();

    int getType2();

    int getVersion();
}
