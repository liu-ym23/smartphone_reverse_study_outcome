package com.stepos.activeview.download;

import B0.g;
import android.content.Context;
import android.text.TextUtils;
import androidx.room.AbstractC0351g;
import com.stepos.activeview.utils.LogUtil;

/* loaded from: classes.dex */
public class DownloadFileChecker implements IFileChecker {
    private static final int MASK_FILE_LENGTH = 1;
    private static final int MASK_HEAD_TAIL_MD5 = 4;
    private static final int MASK_PACKAGE_NAME = 8;
    private static final int MASK_VERSION_CODE = 16;
    private static final int MASK_WHOLE_MD5 = 2;
    private Context mContext;
    private String mMd5;
    private long mTargetLength;
    private String mTargetPackageName;
    private int mVerifyMode;
    private int mVersionCode;
    private boolean mEnableCheck = true;
    private boolean mNoContentLength = false;

    public DownloadFileChecker(Context context, int i4, String str, long j4, String str2, int i5) {
        this.mContext = context;
        this.mVerifyMode = i4;
        this.mTargetPackageName = str;
        this.mTargetLength = j4;
        this.mMd5 = str2;
        this.mVersionCode = i5;
        logE("Checker limit:" + toString());
    }

    private boolean isMaskEnable(int i4) {
        return (this.mVerifyMode & i4) > 0;
    }

    private void logE(String str) {
        LogUtil.e(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0089  */
    @Override // com.stepos.activeview.download.IFileChecker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.stepos.activeview.download.FileCheckResult checkFileDataInfo(java.lang.String r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r7.mEnableCheck
            if (r0 == 0) goto Lcf
            java.lang.String r0 = r7.mMd5
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r1 = ")"
            java.lang.String r2 = "->"
            if (r0 != 0) goto L89
            r0 = 2
            boolean r0 = r7.isMaskEnable(r0)
            if (r0 == 0) goto L53
            java.lang.String r8 = com.stepos.activeview.utils.Md5Helper.md5sum(r8)
            java.lang.String r0 = r7.mMd5
            boolean r0 = r0.equalsIgnoreCase(r8)
            if (r0 != 0) goto L44
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "Whole md5 not match("
            r0.<init>(r3)
            java.lang.String r3 = r7.mMd5
            r0.append(r3)
            r0.append(r2)
            r0.append(r8)
            r0.append(r1)
            java.lang.String r8 = r0.toString()
            r7.logE(r8)
            com.stepos.activeview.download.FileCheckResult r7 = com.stepos.activeview.download.FileCheckResult.instanceErrorResult(r8)
            return r7
        L44:
            android.content.Context r8 = r7.mContext
            com.stepos.activeview.utils.CacheUtils r8 = com.stepos.activeview.utils.CacheUtils.getInstance(r8)
            java.lang.String r0 = "md5sum_tmp"
            java.lang.String r7 = r7.mMd5
            r8.saveToSharedPreferences(r0, r7)
            goto Lcf
        L53:
            r0 = 4
            boolean r0 = r7.isMaskEnable(r0)
            if (r0 == 0) goto L89
            r0 = 1048576(0x100000, float:1.469368E-39)
            java.lang.String r8 = com.stepos.activeview.utils.Md5Helper.md5sumHeadTail(r8, r0)
            java.lang.String r0 = r7.mMd5
            boolean r0 = r0.equalsIgnoreCase(r8)
            if (r0 != 0) goto Lcf
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "HeadTail md5 not match("
            r0.<init>(r3)
            java.lang.String r3 = r7.mMd5
            r0.append(r3)
            r0.append(r2)
            r0.append(r8)
            r0.append(r1)
            java.lang.String r8 = r0.toString()
            r7.logE(r8)
            com.stepos.activeview.download.FileCheckResult r7 = com.stepos.activeview.download.FileCheckResult.instanceErrorResult(r8)
            return r7
        L89:
            long r3 = r7.mTargetLength
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 <= 0) goto Lcf
            boolean r0 = r7.mNoContentLength
            if (r0 == 0) goto Lcf
            r0 = 1
            boolean r0 = r7.isMaskEnable(r0)
            if (r0 == 0) goto Lcf
            r0 = 0
            r7.mNoContentLength = r0
            long r3 = com.stepos.activeview.utils.Utility.getFileLength(r8)
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 <= 0) goto Lcf
            long r5 = r7.mTargetLength
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 != 0) goto Lae
            goto Lcf
        Lae:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "Download File length not match("
            r8.<init>(r0)
            long r5 = r7.mTargetLength
            r8.append(r5)
            r8.append(r2)
            r8.append(r3)
            r8.append(r1)
            java.lang.String r8 = r8.toString()
            r7.logE(r8)
            com.stepos.activeview.download.FileCheckResult r7 = com.stepos.activeview.download.FileCheckResult.instanceErrorResult(r8)
            return r7
        Lcf:
            com.stepos.activeview.download.FileCheckResult r7 = com.stepos.activeview.download.FileCheckResult.instanceSuccessResult()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.activeview.download.DownloadFileChecker.checkFileDataInfo(java.lang.String):com.stepos.activeview.download.FileCheckResult");
    }

    @Override // com.stepos.activeview.download.IFileChecker
    public FileCheckResult checkHttpContentLength(long j4, long j5) {
        if (this.mEnableCheck) {
            boolean z4 = j5 <= 0;
            this.mNoContentLength = z4;
            if (this.mTargetLength > 0 && !z4 && isMaskEnable(1)) {
                long j6 = j4 + j5;
                if (j6 != this.mTargetLength) {
                    String str = "File length not match(" + this.mTargetLength + "->" + j6 + ")";
                    logE(str);
                    return FileCheckResult.instanceErrorResult(str);
                }
            }
        }
        return FileCheckResult.instanceSuccessResult();
    }

    @Override // com.stepos.activeview.download.IFileChecker
    public void enableCheck(boolean z4) {
        this.mEnableCheck = z4;
    }

    @Override // com.stepos.activeview.download.IFileChecker
    public long getCheckFileSize() {
        if (this.mTargetLength <= 0 || !isMaskEnable(1)) {
            return 0L;
        }
        return this.mTargetLength;
    }

    @Override // com.stepos.activeview.download.IFileChecker
    public String getCheckMd5() {
        if (TextUtils.isEmpty(this.mMd5) || !isMaskEnable(2)) {
            return null;
        }
        return this.mMd5;
    }

    @Override // com.stepos.activeview.download.IFileChecker
    public String getCheckPartialMd5() {
        if (TextUtils.isEmpty(this.mMd5) || !isMaskEnable(4)) {
            return null;
        }
        return this.mMd5;
    }

    @Override // com.stepos.activeview.download.IFileChecker
    public String getLogVersion() {
        int i4 = this.mVersionCode;
        if (i4 > 0) {
            return String.valueOf(i4);
        }
        return null;
    }

    @Override // com.stepos.activeview.download.IFileChecker
    public boolean isFileDataMatch(String str) {
        return checkFileDataInfo(str).isMatch();
    }

    @Override // com.stepos.activeview.download.IFileChecker
    public boolean isFileLengthMatch(long j4) {
        return checkHttpContentLength(0L, j4).isMatch();
    }

    public String toString() {
        String strP = isMaskEnable(1) ? "size " : "";
        if (isMaskEnable(4)) {
            strP = AbstractC0351g.p(strP, "1mmd5 ");
        }
        if (isMaskEnable(8)) {
            strP = AbstractC0351g.p(strP, "pkg ");
        }
        if (isMaskEnable(16)) {
            strP = AbstractC0351g.p(strP, "vcode ");
        }
        if (isMaskEnable(2)) {
            strP = AbstractC0351g.p(strP, "md5 ");
        }
        if (TextUtils.isEmpty(strP)) {
            strP = "null";
        }
        StringBuilder sbW = g.w("verify_mode=", strP, ",pk=");
        sbW.append(this.mTargetPackageName);
        sbW.append(",size=");
        sbW.append(this.mTargetLength);
        sbW.append(",md5=");
        sbW.append(this.mMd5);
        sbW.append(",v_code=");
        sbW.append(this.mVersionCode);
        return sbW.toString();
    }
}
