package com.bytedance.android.ec.hybrid.ui;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/android/ec/hybrid/ui/a;", "", "", "Lcom/bytedance/android/ec/hybrid/ui/b;", "rules", "Ljava/util/List;", "b", "()Ljava/util/List;", "", "mallBackupDiskCacheAccessibleBizTags", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "<init>", "()V", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("mall_backup_disk_cache_accessible_biz_tags")
    private final List<String> mallBackupDiskCacheAccessibleBizTags;

    @SerializedName("rules")
    private final List<b> rules;

    public a() {
    }

    public final List<String> a() {
        return this.mallBackupDiskCacheAccessibleBizTags;
    }

    public final List<b> b() {
        return this.rules;
    }
}
