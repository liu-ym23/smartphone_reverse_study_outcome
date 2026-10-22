package com.android.ttcjpaysdk.bindcard.base.utils;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.encrypt.CJEncryptScene;
import com.android.ttcjpaysdk.base.encrypt.CJPayEncryptHelper;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0016\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/utils/PwdUtils;", "", "()V", "checkPwdValid", "", BaseSwitches.V, "", "sub", "", "arr", "pwd", "", "encryptPwdWithSalt", "salt", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PwdUtils {
    public static final PwdUtils INSTANCE = null;

    static {
        INSTANCE = new PwdUtils();
    }

    private PwdUtils() {
    }

    public final boolean checkPwdValid(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        if (r100 == null) goto L16;
        int[] r101 = new int[r100.length()];
        int r102 = r100.length();
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L15;
        int r104 = r103 + 1;
        r101[r103] = CastIntegerProtector.parseInt(r100.substring(r103, r104));     // Catch: Throwable -> L11
        r103 = r104;
    L11:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("PwdUtils#checkPwdValid", th);
        CJBasicCommonUtils.logCatch("CJCatch", "PwdUtils#checkPwdValid", th);
        return false;
    L15:
        return INSTANCE.checkPwdValid(r101);
    L16:
        return false;
    }

    private final boolean checkPwdValid(int[] r100) {
        if (r100 != null) goto L5;
    L18:
        return false;
    L5:
        if (r100.length != 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L18;
        int r102 = r100.length - 1;
        if (r102 >= 0) goto L13;
        return true;
    L13:
        int[] r103 = new int[r102];
        int r104 = 0;
    L14:
        if (r104 >= r102) goto L17;
        int r105 = r104 + 1;
        r103[r104] = r100[r104] - r100[r105];
        r104 = r105;
        goto L14
    L17:
        return checkPwdValid(r103[0], r103);
    L7:
        r101 = false;
        goto L8
    }

    private final boolean checkPwdValid(int r100, int[] r101) {
        int r102 = r101.length;
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L9;
        if (r100 != r101[r103]) goto L7;
        r103 = r103 + 1;
        goto L4
    L7:
        return true;
    L9:
        if (r100 != 0) goto L11;
        return false;
    L11:
        if (r100 == (-1)) goto L18;
        if (r100 == 1) goto L19;
        return true;
    L19:
        return false;
    L18:
        return false;
    }

    public final String encryptPwdWithSalt(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "pwd");
        Intrinsics.checkNotNullParameter(r101, "salt");
        boolean r102 = true;
        if (r100.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        return "";
    L8:
        if (r101.length() == 0) goto L11;
        r102 = false;
    L11:
        if (r102 == true) goto L17;
        CJPayEncryptHelper.Companion r104 = CJPayEncryptHelper.Companion;
        return r104.getEncryptDataSM(CJEncryptScene.UNKNOWN, r104.md5Encrypt(r104.md5Encrypt(r104.md5Encrypt(r100)) + r101), "绑卡-设密", "pwd");
    L17:
        return "";
    L5:
        r103 = false;
        goto L6
    }
}
