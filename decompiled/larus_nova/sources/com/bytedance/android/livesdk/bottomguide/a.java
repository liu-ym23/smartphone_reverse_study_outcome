package com.bytedance.android.livesdk.bottomguide;

import com.bytedance.android.live.core.utils.LiveResUtil;
import com.google.gson.annotations.SerializedName;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/bottomguide/a;", "", "", "defaultTitle", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "justAdTitle", "c", "excitationTitle", "b", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("0")
    private final String defaultTitle;

    @SerializedName("2")
    private final String excitationTitle;

    @SerializedName("1")
    private final String justAdTitle;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.defaultTitle, r101.defaultTitle) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.justAdTitle, r101.justAdTitle) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.excitationTitle, r101.excitationTitle) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.defaultTitle;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.justAdTitle;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.excitationTitle;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "AuthGuideDialogTitle(defaultTitle=" + this.defaultTitle + ", justAdTitle=" + this.justAdTitle + ", excitationTitle=" + this.excitationTitle + ")";
    }

    public a() {
        String r100 = LiveResUtil.getString(R.string.ttlive_silent_auth_guide_title_default);
        String r101 = LiveResUtil.getString(R.string.ttlive_silent_auth_guide_title_just_ad);
        String r102 = LiveResUtil.getString(R.string.ttlive_silent_auth_guide_title_excitation);
        Intrinsics.checkNotNullParameter(r100, "defaultTitle");
        Intrinsics.checkNotNullParameter(r101, "justAdTitle");
        Intrinsics.checkNotNullParameter(r102, "excitationTitle");
        this.defaultTitle = r100;
        this.justAdTitle = r101;
        this.excitationTitle = r102;
    }

    public final String a() {
        return this.defaultTitle;
    }

    public final String b() {
        return this.excitationTitle;
    }

    public final String c() {
        return this.justAdTitle;
    }
}
