package com.ss.android.socialbase.downloader.core.module.pcdn;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class PCDNChunkUrlPolicy {
    public static final int TYPE_CDN = 2;
    public static final int TYPE_PCDN = 1;
    private int mCdnIndex;
    private List<String> mCdnUrls;
    private int mPcdnIndex;
    private List<String> mPcdnUrls;
    private int mType;

    public PCDNChunkUrlPolicy(List<String> r3, List<String> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        this.mCdnUrls = new ArrayList();
        this.mPcdnUrls = new ArrayList();
        this.mCdnIndex = -1;
        this.mPcdnIndex = -1;
        if (r5 != null) goto L5;
    L7:
        if (r6 == null) goto L12;
        if (r6.isEmpty() == true) goto L12;
        this.mCdnUrls.addAll(r6);
    L12:
        if (this.mPcdnUrls.isEmpty() == true) goto L14;
        this.mType = 1;
        return;
    L14:
        this.mType = 2;
        return;
    L5:
        if (r5.isEmpty() == true) goto L7;
        this.mPcdnUrls.addAll(r5);
        goto L7
    }

    public String obtainUrl() {
        int r0 = this.mType;
        if (r0 == 1) goto L14;
        if (r0 == 2) goto L9;
        return null;
    L9:
        if (this.mCdnIndex >= 0) goto L11;
        this.mCdnIndex = 0;
    L11:
        List<String> r1 = this.mCdnUrls;
        return (String) ZeusTransformUtils.preCheckCast(r1.get(this.mCdnIndex % r1.size()), String.class, "com.obric.aiagent.plugin");
    L14:
        if (this.mPcdnIndex >= 0) goto L16;
        this.mPcdnIndex = 0;
    L16:
        List<String> r2 = this.mPcdnUrls;
        return (String) ZeusTransformUtils.preCheckCast(r2.get(this.mPcdnIndex % r2.size()), String.class, "com.obric.aiagent.plugin");
    }

    public boolean switchToCdn() {
        if (this.mCdnUrls.isEmpty() == false) goto L5;
        return false;
    L5:
        if (this.mType == 2) goto L11;
        this.mType = 2;
        return true;
    L11:
        return false;
    }

    public boolean isPCDN() {
        if (this.mType == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public void onError() {
        if (isPCDN() == false) goto L13;
        if (this.mPcdnUrls.isEmpty() == true) goto L13;
        if (this.mPcdnIndex >= (this.mPcdnUrls.size() - 1)) goto L9;
    L10:
        this.mPcdnIndex++;
        return;
    L9:
        if (this.mCdnUrls.isEmpty() == true) goto L10;
    L13:
        if (this.mCdnUrls.isEmpty() == true) goto L16;
        this.mCdnIndex++;
        this.mType = 2;
        return;
    }

    public PCDNChunkUrlPolicy copy() {
        PCDNChunkUrlPolicy r0 = new PCDNChunkUrlPolicy(this.mPcdnUrls, this.mCdnUrls);
        r0.mType = this.mType;
        r0.mPcdnIndex = this.mPcdnIndex;
        r0.mCdnIndex = this.mCdnIndex;
        return r0;
    }
}
