package com.android.ttcjpaysdk.kmp.base.util;

import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import kotlin.Metadata;
import kotlin.random.Random;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/util/CJUUIDUtils;", "", "<init>", "()V", "generateUUID", "", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJUUIDUtils {
    public static final int $stable = 0;
    public static final CJUUIDUtils INSTANCE = null;

    static {
        INSTANCE = new CJUUIDUtils();
    }

    private CJUUIDUtils() {
    }

    public final String generateUUID() {
        Random.Default r100 = Random.Default;
        StringBuilder r101 = new StringBuilder();
        int r102 = 0;
    L4:
        if (r102 >= 8) goto L6;
        r101.append(Integer.toString(r100.nextInt(0, 16), CharsKt.checkRadix(16)));
        r102 = r102 + 1;
        goto L4
    L6:
        r101.append('-');
        int r103 = 0;
    L8:
        if (r103 >= 4) goto L10;
        r101.append(Integer.toString(r100.nextInt(0, 16), CharsKt.checkRadix(16)));
        r103 = r103 + 1;
        goto L8
    L10:
        r101.append(OnekeyLoginConstants.ErrorCode.ERROR_CU_REQUEST_TIMEOUT);
        int r104 = 0;
    L12:
        if (r104 >= 3) goto L14;
        r101.append(Integer.toString(r100.nextInt(0, 16), CharsKt.checkRadix(16)));
        r104 = r104 + 1;
        goto L12
    L14:
        r101.append('-');
        r101.append(Integer.toString(r100.nextInt(8, 16), CharsKt.checkRadix(16)));
        int r105 = 0;
    L15:
        if (r105 >= 3) goto L17;
        r101.append(Integer.toString(r100.nextInt(0, 16), CharsKt.checkRadix(16)));
        r105 = r105 + 1;
        goto L15
    L17:
        r101.append('-');
        int r106 = 0;
    L19:
        if (r106 >= 12) goto L22;
        r101.append(Integer.toString(r100.nextInt(0, 16), CharsKt.checkRadix(16)));
        r106 = r106 + 1;
        goto L19
    L22:
        return r101.toString();
    }
}
