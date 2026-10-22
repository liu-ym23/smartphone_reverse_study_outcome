package com.stepos.cloud.securedata;

import com.stepos.account.oauth.OAuthConstants;
import kotlin.Metadata;
import q7.f;
import q7.k;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/cloud/securedata/SdkException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", OAuthConstants.FACTOR_RESULT_MESSAGE, "", "cause", "", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SdkException extends Exception {
    public /* synthetic */ SdkException(String str, Throwable th, int i2, f fVar) {
        this(str, (i2 & 2) != 0 ? null : th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SdkException(String str, Throwable th) {
        super(str, th);
        k.e(str, OAuthConstants.FACTOR_RESULT_MESSAGE);
    }
}
