package com.bytedance.android.ec.hybrid.ui;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R0\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR0\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/ec/hybrid/ui/b;", "", "", "diskCache", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "backupDiskCacheMap", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "e", "(Ljava/util/Map;)V", "enterFromToBackupDiskCacheMap", "getEnterFromToBackupDiskCacheMap", "setEnterFromToBackupDiskCacheMap", "", "bizTags", "Ljava/util/List;", "getBizTags", "()Ljava/util/List;", "sceneTags", "getSceneTags", "content", "getContent", "pattern", "getPattern", "<init>", "()V", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("backup_disk_cache_map")
    private Map<String, String> backupDiskCacheMap;

    @SerializedName("biz_tags")
    private final List<String> bizTags;

    @SerializedName("content")
    private final String content;

    @SerializedName("disk_cache")
    private final String diskCache;

    @SerializedName("enter_from_to_backup_disk_cache_map")
    private Map<String, String> enterFromToBackupDiskCacheMap;

    @SerializedName("pattern")
    private final String pattern;

    @SerializedName("scene_tags")
    private final List<String> sceneTags;

    public b() {
    }

    public final Map<String, String> a() {
        return this.backupDiskCacheMap;
    }

    public final String b() {
        return this.diskCache;
    }

    public final void e(Map<String, String> r100) {
        this.backupDiskCacheMap = r100;
    }

    public final String c(String r100, String r101) {
        if (r100 != null) goto L6;
        if (r101 != null) goto L6;
        return this.diskCache;
    L6:
        Map<String, String> r102 = this.backupDiskCacheMap;
        String r103 = null;
        if (r102 == null) goto L11;
        if (r100 == null) goto L11;
        if (r102 == null) goto L11;
        String r104 = r102.get(r100);
    L12:
        if (r104 == null) goto L14;
        return r104;
    L14:
        Map<String, String> r105 = this.enterFromToBackupDiskCacheMap;
        if (r105 == null) goto L31;
        if (r101 == null) goto L31;
        if (r105 == null) goto L30;
        Set<Map.Entry<String, String>> r106 = r105.entrySet();
        if (r106 == null) goto L30;
        Iterator<T> r107 = r106.iterator();
    L22:
        if (r107.hasNext() == false) goto L26;
        Object r108 = r107.next();
        if (StringsKt.contains$default(r101, (CharSequence) ((Map.Entry) r108).getKey(), false, 2, null) == false) goto L22;
    L27:
        Map.Entry r109 = (Map.Entry) r108;
        if (r109 == null) goto L30;
        r103 = (String) r109.getValue();
        goto L30
    L26:
        r108 = null;
    L30:
        r104 = r103;
    L31:
        if (r104 == null) goto L33;
        return r104;
    L33:
        return this.diskCache;
    L11:
        r104 = null;
        goto L12
    }

    public final boolean d(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "url");
        List<String> r103 = this.bizTags;
        if (r103 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L14;
        if (r100 != null) goto L12;
    L13:
        return false;
    L12:
        if (this.bizTags.contains(r100) == false) goto L13;
    L14:
        List<String> r105 = this.sceneTags;
        if (r105 != null) goto L17;
    L20:
        boolean r106 = true;
    L21:
        if (r106 == true) goto L26;
        if (r101 != null) goto L24;
    L25:
        return false;
    L24:
        if (this.sceneTags.contains(r101) == false) goto L25;
    L26:
        String r107 = this.content;
        if (r107 == null) goto L32;
        if (StringsKt.contains$default(r102, r107, false, 2, null) == true) goto L32;
        return false;
    L32:
        if (this.pattern != null) goto L34;
    L36:
        return true;
    L34:
        if (Regex.find$default(new Regex(this.pattern), r102, 0, 2, null) != null) goto L36;
        return false;
    L17:
        if (r105.isEmpty() == true) goto L20;
        r106 = false;
        goto L21
    L5:
        if (r103.isEmpty() == true) goto L8;
        r104 = false;
        goto L9
    }
}
