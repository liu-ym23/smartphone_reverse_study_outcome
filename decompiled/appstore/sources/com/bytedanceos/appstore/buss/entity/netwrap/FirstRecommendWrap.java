package com.bytedanceos.appstore.buss.entity.netwrap;

import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.common.model.AppInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/netwrap/FirstRecommendWrap;", "", "bio", "", SlardarSettingsConsts.SETTING_IMAGE, "apps", "", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getApps", "()Ljava/util/List;", "setApps", "(Ljava/util/List;)V", "getBio", "()Ljava/lang/String;", "setBio", "(Ljava/lang/String;)V", "getImage", "setImage", "component1", "component2", "component3", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FirstRecommendWrap {

    @Nullable
    private List<CommonAppEntity> apps;

    @Nullable
    private String bio;

    @Nullable
    private String image;

    public FirstRecommendWrap(@Nullable String r10, @Nullable String r11, @Nullable List<CommonAppEntity> r12) {
        this.bio = r10;
        this.image = r11;
        this.apps = r12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FirstRecommendWrap copy$default(FirstRecommendWrap r10, String r11, String r12, List r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = r10.bio;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.image;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = r10.apps;
    L12:
        return r10.copy(r11, r12, r13);
    }

    @Nullable
    public final String component1() {
        return this.bio;
    }

    @Nullable
    public final String component2() {
        return this.image;
    }

    @Nullable
    public final List<CommonAppEntity> component3() {
        return this.apps;
    }

    @NotNull
    public final FirstRecommendWrap copy(@Nullable String r10, @Nullable String r11, @Nullable List<CommonAppEntity> r12) {
        return new FirstRecommendWrap(r10, r11, r12);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof FirstRecommendWrap) == true) goto L8;
        return false;
    L8:
        FirstRecommendWrap r11 = (FirstRecommendWrap) r10;
        if (q.b(this.bio, r11.bio) == true) goto L12;
        return false;
    L12:
        if (q.b(this.image, r11.image) == true) goto L15;
        return false;
    L15:
        if (q.b(this.apps, r11.apps) == true) goto L17;
        return false;
    L17:
        return true;
    }

    @Nullable
    public final List<CommonAppEntity> getApps() {
        return this.apps;
    }

    @Nullable
    public final String getBio() {
        return this.bio;
    }

    @Nullable
    public final String getImage() {
        return this.image;
    }

    public int hashCode() {
        String r10 = this.bio;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.image;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        List<CommonAppEntity> r17 = this.apps;
        if (r17 == null) goto L15;
        r11 = r17.hashCode();
    L15:
        return r16 + r11;
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public final void setApps(@Nullable List<CommonAppEntity> r10) {
        this.apps = r10;
    }

    public final void setBio(@Nullable String r10) {
        this.bio = r10;
    }

    public final void setImage(@Nullable String r10) {
        this.image = r10;
    }

    @NotNull
    public String toString() {
        return "FirstRecommendWrap(bio=" + this.bio + ", image=" + this.image + ", apps=" + this.apps + ')';
    }
}
