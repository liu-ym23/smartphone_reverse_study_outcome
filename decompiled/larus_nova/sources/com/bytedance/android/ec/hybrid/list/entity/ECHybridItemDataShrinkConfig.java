package com.bytedance.android.ec.hybrid.list.entity;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0011\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u000f\u0018\u0000 ,2\u00020\u0001:\u0002-.B\u0007¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\"\u0010\u0010\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\b\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR(\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR0\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R0\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\"\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&¨\u0006/"}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/entity/ECHybridItemDataShrinkConfig;", "Ljava/io/Serializable;", "", "pageName", "Lcom/bytedance/android/ec/hybrid/list/entity/ECHybridItemDataShrinkConfig$b;", "strategyOf", "", "deleteOnBootFinish", "Z", "getDeleteOnBootFinish", "()Z", "setDeleteOnBootFinish", "(Z)V", "deleteOnDestroy", "getDeleteOnDestroy", "setDeleteOnDestroy", "onlyString", "getOnlyString", "setOnlyString", "", "filedNames", "[Ljava/lang/String;", "getFiledNames", "()[Ljava/lang/String;", "setFiledNames", "([Ljava/lang/String;)V", "repoPath", "Ljava/lang/String;", "getRepoPath", "()Ljava/lang/String;", "setRepoPath", "(Ljava/lang/String;)V", "", "lookupMap", "Ljava/util/Map;", "getLookupMap", "()Ljava/util/Map;", "setLookupMap", "(Ljava/util/Map;)V", "strategyMap", "getStrategyMap", "setStrategyMap", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECHybridItemDataShrinkConfig implements Serializable {
    public static final a Companion = null;
    public static final String PLACEHOLDER_FILE_SEPARATOR = "#FILE_SEPARATOR#";

    @SerializedName("delete_on_boot_finish")
    private boolean deleteOnBootFinish;

    @SerializedName("delete_on_destroy")
    private boolean deleteOnDestroy;

    @SerializedName("filed_names")
    private String[] filedNames;

    @SerializedName("lookup_map")
    private Map<String, String> lookupMap;

    @SerializedName("only_string")
    private boolean onlyString;

    @SerializedName("repo_path")
    private String repoPath;

    @SerializedName("strategy_map")
    private Map<String, b> strategyMap;

    public static final class a {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\"\u0010#R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0017\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001b¨\u0006$"}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/entity/ECHybridItemDataShrinkConfig$b;", "", "", "deleteOnDestroy", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "setDeleteOnDestroy", "(Ljava/lang/Boolean;)V", "onlyString", "f", "setOnlyString", "", "fromIndex", "I", "c", "()I", "setFromIndex", "(I)V", "offscreenSize", "e", "setOffscreenSize", "async", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setAsync", "(Z)V", "justDisk", "d", "setJustDisk", "rangeCut", ce.f26391f, "setRangeCut", "<init>", "()V", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("async")
        private boolean async;

        @SerializedName("delete_on_destroy")
        private Boolean deleteOnDestroy;

        @SerializedName("from_index")
        private int fromIndex;

        @SerializedName("just_disk")
        private boolean justDisk;

        @SerializedName("offscreen_size")
        private int offscreenSize;

        @SerializedName("only_string")
        private Boolean onlyString;

        @SerializedName("range_cut")
        private boolean rangeCut;

        public b() {
            this.offscreenSize = -1;
            this.async = true;
            this.justDisk = true;
            this.rangeCut = true;
        }

        public final boolean a() {
            return this.async;
        }

        public final Boolean b() {
            return this.deleteOnDestroy;
        }

        public final int c() {
            return this.fromIndex;
        }

        public final boolean d() {
            return this.justDisk;
        }

        public final int e() {
            return this.offscreenSize;
        }

        public final Boolean f() {
            return this.onlyString;
        }

        public final boolean g() {
            return this.rangeCut;
        }
    }

    static {
        Companion = new a();
    }

    public ECHybridItemDataShrinkConfig() {
        this.deleteOnBootFinish = true;
        this.deleteOnDestroy = true;
        this.onlyString = true;
        this.filedNames = new String[]{"rawItemData", "itemData"};
        this.repoPath = "#FILE_SEPARATOR#keva#FILE_SEPARATOR#repo";
    }

    public final boolean getDeleteOnBootFinish() {
        return this.deleteOnBootFinish;
    }

    public final boolean getDeleteOnDestroy() {
        return this.deleteOnDestroy;
    }

    public final String[] getFiledNames() {
        return this.filedNames;
    }

    public final Map<String, String> getLookupMap() {
        return this.lookupMap;
    }

    public final boolean getOnlyString() {
        return this.onlyString;
    }

    public final String getRepoPath() {
        return this.repoPath;
    }

    public final Map<String, b> getStrategyMap() {
        return this.strategyMap;
    }

    public final void setDeleteOnBootFinish(boolean r100) {
        this.deleteOnBootFinish = r100;
    }

    public final void setDeleteOnDestroy(boolean r100) {
        this.deleteOnDestroy = r100;
    }

    public final void setFiledNames(String[] r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.filedNames = r100;
    }

    public final void setLookupMap(Map<String, String> r100) {
        this.lookupMap = r100;
    }

    public final void setOnlyString(boolean r100) {
        this.onlyString = r100;
    }

    public final void setRepoPath(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.repoPath = r100;
    }

    public final void setStrategyMap(Map<String, b> r100) {
        this.strategyMap = r100;
    }

    public final b strategyOf(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
        Map<String, String> r101 = this.lookupMap;
        if (r101 == null) goto L5;
        String r102 = r101.get(r100);
    L6:
        boolean r103 = false;
        if (r102 != null) goto L9;
    L12:
        boolean r104 = true;
    L13:
        if (r104 == false) goto L15;
        return null;
    L15:
        Map<String, b> r105 = this.strategyMap;
        if (r105 == null) goto L25;
        b r106 = r105.get(r102);
        if (r106 != null) goto L20;
        return null;
    L20:
        if (r106.e() < 0) goto L22;
        r103 = true;
    L22:
        if (r103 == true) goto L24;
        return null;
    L24:
        return r106;
    L25:
        return null;
    L9:
        if (r102.length() == 0) goto L12;
        r104 = false;
        goto L13
    L5:
        r102 = null;
        goto L6
    }
}
