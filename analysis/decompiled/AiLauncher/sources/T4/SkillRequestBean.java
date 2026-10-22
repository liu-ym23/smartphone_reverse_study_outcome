package T4;

import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u001a\u0010\u0013R\u001a\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u001b\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u001c\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u001d\u0010\u0013R\u001a\u0010\b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u001e\u0010\u0013R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u001f\u0010\u0013R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010 \u001a\u0004\b!\u0010\u0011R\u001c\u0010\f\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b\"\u0010\u0011R\u001c\u0010\r\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010 \u001a\u0004\b#\u0010\u0011¨\u0006$"}, d2 = {"LT4/a;", "", "", "pageNumber", "pageSize", "necessary", ChatTracker.RETRY_RELOAD, HomeGestureEligibilityContract.EXTRA_SCENE, "useCache", "testing", "", "scanSource", "scanType", "assetId", "<init>", "(IIIIIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getPageNumber", "getPageSize", "getNecessary", "getReload", "getScene", "getUseCache", "getTesting", "Ljava/lang/String;", "getScanSource", "getScanType", "getAssetId", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: T4.a, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class SkillRequestBean {

    @SerializedName("asset_id")
    private final String assetId;

    @SerializedName("necessary")
    private final int necessary;

    @SerializedName("page_number")
    private final int pageNumber;

    @SerializedName("page_size")
    private final int pageSize;

    @SerializedName(ChatTracker.RETRY_RELOAD)
    private final int reload;

    @SerializedName("scan_source")
    private final String scanSource;

    @SerializedName("scan_type")
    private final String scanType;

    @SerializedName(HomeGestureEligibilityContract.EXTRA_SCENE)
    private final int scene;

    @SerializedName("testing")
    private final int testing;

    @SerializedName("use_cache")
    private final int useCache;

    public SkillRequestBean(int i10, int i11, int i12, int i13, int i14, int i15, int i16, String str, String str2, String str3) {
        this.pageNumber = i10;
        this.pageSize = i11;
        this.necessary = i12;
        this.reload = i13;
        this.scene = i14;
        this.useCache = i15;
        this.testing = i16;
        this.scanSource = str;
        this.scanType = str2;
        this.assetId = str3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SkillRequestBean)) {
            return false;
        }
        SkillRequestBean skillRequestBean = (SkillRequestBean) other;
        return this.pageNumber == skillRequestBean.pageNumber && this.pageSize == skillRequestBean.pageSize && this.necessary == skillRequestBean.necessary && this.reload == skillRequestBean.reload && this.scene == skillRequestBean.scene && this.useCache == skillRequestBean.useCache && this.testing == skillRequestBean.testing && p.d(this.scanSource, skillRequestBean.scanSource) && p.d(this.scanType, skillRequestBean.scanType) && p.d(this.assetId, skillRequestBean.assetId);
    }

    public int hashCode() {
        int iHashCode = ((((((((((((Integer.hashCode(this.pageNumber) * 31) + Integer.hashCode(this.pageSize)) * 31) + Integer.hashCode(this.necessary)) * 31) + Integer.hashCode(this.reload)) * 31) + Integer.hashCode(this.scene)) * 31) + Integer.hashCode(this.useCache)) * 31) + Integer.hashCode(this.testing)) * 31;
        String str = this.scanSource;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.scanType;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.assetId;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "SkillRequestBean(pageNumber=" + this.pageNumber + ", pageSize=" + this.pageSize + ", necessary=" + this.necessary + ", reload=" + this.reload + ", scene=" + this.scene + ", useCache=" + this.useCache + ", testing=" + this.testing + ", scanSource=" + this.scanSource + ", scanType=" + this.scanType + ", assetId=" + this.assetId + ")";
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ SkillRequestBean(int r2, int r3, int r4, int r5, int r6, int r7, int r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, int r12, kotlin.jvm.internal.i r13) {
        /*
            r1 = this;
            r13 = r12 & 1
            if (r13 == 0) goto L5
            r2 = 1
        L5:
            r13 = r12 & 2
            if (r13 == 0) goto Lb
            r3 = 20
        Lb:
            r13 = r12 & 8
            r0 = -1
            if (r13 == 0) goto L11
            r5 = r0
        L11:
            r13 = r12 & 16
            if (r13 == 0) goto L16
            r6 = r0
        L16:
            r13 = r12 & 32
            r0 = 0
            if (r13 == 0) goto L1c
            r7 = r0
        L1c:
            r13 = r12 & 64
            if (r13 == 0) goto L21
            r8 = r0
        L21:
            r13 = r12 & 128(0x80, float:1.8E-43)
            r0 = 0
            if (r13 == 0) goto L27
            r9 = r0
        L27:
            r13 = r12 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L2c
            r10 = r0
        L2c:
            r12 = r12 & 512(0x200, float:7.17E-43)
            if (r12 == 0) goto L3c
            r13 = r0
            r11 = r9
            r12 = r10
            r9 = r7
            r10 = r8
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            goto L47
        L3c:
            r13 = r11
            r12 = r10
            r10 = r8
            r11 = r9
            r8 = r6
            r9 = r7
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
        L47:
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: T4.SkillRequestBean.<init>(int, int, int, int, int, int, int, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.i):void");
    }
}
