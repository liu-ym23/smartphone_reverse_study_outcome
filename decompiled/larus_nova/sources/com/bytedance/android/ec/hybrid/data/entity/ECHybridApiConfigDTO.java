package com.bytedance.android.ec.hybrid.data.entity;

import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b,\u0010-J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nR*\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R*\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R*\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R*\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R*\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0012R0\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R*\u0010)\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u000e\u001a\u0004\b*\u0010\u0010\"\u0004\b+\u0010\u0012¨\u0006."}, d2 = {"Lcom/bytedance/android/ec/hybrid/data/entity/ECHybridApiConfigDTO;", "Ljava/io/Serializable;", "", "", "getFirstScreenKeyList", "getLoginStateChangeKeyList", "getClientAiPrefetchKeyList", "getClientAiFirstScreenKeyList", "getRefreshKeyList", "getLoadMoreKeyList", "", "Lcom/bytedance/android/ec/hybrid/data/entity/ECHybridNetworkDTO;", "getApiKey2NetworkDTOMap", "firstScreenApiKeyList", "Ljava/util/List;", "getFirstScreenApiKeyList", "()Ljava/util/List;", "setFirstScreenApiKeyList", "(Ljava/util/List;)V", "loginStateChangeApiKeyList", "getLoginStateChangeApiKeyList", "setLoginStateChangeApiKeyList", "clientAiPrefetchApiKeyList", "getClientAiPrefetchApiKeyList", "setClientAiPrefetchApiKeyList", "clientAiFirstScreenApiKeyList", "getClientAiFirstScreenApiKeyList", "setClientAiFirstScreenApiKeyList", "refreshApiKeyList", "getRefreshApiKeyList", "setRefreshApiKeyList", "loadMoreApiKeyList", "getLoadMoreApiKeyList", "setLoadMoreApiKeyList", "apiKeyToNetworkDTOMap", "Ljava/util/Map;", "getApiKeyToNetworkDTOMap", "()Ljava/util/Map;", "setApiKeyToNetworkDTOMap", "(Ljava/util/Map;)V", "Lcom/bytedance/android/ec/hybrid/data/entity/RequireClientVersionItem;", "requireClientVersion", "getRequireClientVersion", "setRequireClientVersion", "<init>", "()V", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECHybridApiConfigDTO implements Serializable {

    @SerializedName("apis")
    private Map<String, ECHybridNetworkDTO> apiKeyToNetworkDTOMap;

    @SerializedName("client_ai_first_screen_apis")
    private List<String> clientAiFirstScreenApiKeyList;

    @SerializedName("client_ai_prefetch_apis")
    private List<String> clientAiPrefetchApiKeyList;

    @SerializedName("first_screen_apis")
    private List<String> firstScreenApiKeyList;

    @SerializedName("load_more_apis")
    private List<String> loadMoreApiKeyList;

    @SerializedName("login_state_change_apis")
    private List<String> loginStateChangeApiKeyList;

    @SerializedName("refresh_apis")
    private List<String> refreshApiKeyList;

    @SerializedName("require_client_version")
    private List<RequireClientVersionItem> requireClientVersion;

    public ECHybridApiConfigDTO() {
    }

    public final Map<String, ECHybridNetworkDTO> getApiKey2NetworkDTOMap() {
        Map<String, ECHybridNetworkDTO> r100 = this.apiKeyToNetworkDTOMap;
        if (r100 == null) goto L15;
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<Map.Entry<String, ECHybridNetworkDTO>> r102 = r100.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L22;
        Map.Entry<String, ECHybridNetworkDTO> r103 = r102.next();
        if (r103.getValue().getUrl() != null) goto L10;
    L12:
        boolean r104 = false;
    L13:
        if (r104 == false) goto L6;
        r101.put(r103.getKey(), r103.getValue());
        goto L6
    L10:
        if (r103.getValue().getMethod() == null) goto L12;
        r104 = true;
        goto L13
    L22:
        return r101;
    L15:
        return null;
    }

    public final List<String> getClientAiFirstScreenKeyList() {
        List<String> r100 = this.clientAiFirstScreenApiKeyList;
        if (r100 == null) goto L6;
        List<String> r101 = CollectionsKt.toMutableList(r100);
        if (r101 == null) goto L6;
    L7:
        a(r101, "client_ai_first_screen_apis");
        return r101;
    L6:
        r101 = new ArrayList();
        goto L7
    }

    public final List<String> getClientAiPrefetchKeyList() {
        List<String> r100 = this.clientAiPrefetchApiKeyList;
        if (r100 == null) goto L6;
        List<String> r101 = CollectionsKt.toMutableList(r100);
        if (r101 == null) goto L6;
    L7:
        a(r101, "client_ai_prefetch_apis");
        return r101;
    L6:
        r101 = new ArrayList();
        goto L7
    }

    public final List<String> getFirstScreenKeyList() {
        List<String> r100 = this.firstScreenApiKeyList;
        if (r100 == null) goto L6;
        List<String> r101 = CollectionsKt.toMutableList(r100);
        if (r101 == null) goto L6;
    L7:
        a(r101, "first_screen_apis");
        return r101;
    L6:
        r101 = new ArrayList();
        goto L7
    }

    public final List<String> getLoadMoreKeyList() {
        List<String> r100 = this.loadMoreApiKeyList;
        if (r100 == null) goto L6;
        List<String> r101 = CollectionsKt.toMutableList(r100);
        if (r101 == null) goto L6;
    L7:
        a(r101, "load_more_apis");
        return r101;
    L6:
        r101 = new ArrayList();
        goto L7
    }

    public final List<String> getLoginStateChangeKeyList() {
        List<String> r100 = this.loginStateChangeApiKeyList;
        if (r100 == null) goto L6;
        List<String> r101 = CollectionsKt.toMutableList(r100);
        if (r101 == null) goto L6;
    L7:
        a(r101, "login_state_change_apis");
        return r101;
    L6:
        r101 = new ArrayList();
        goto L7
    }

    public final List<String> getRefreshKeyList() {
        List<String> r100 = this.refreshApiKeyList;
        if (r100 == null) goto L6;
        List<String> r101 = CollectionsKt.toMutableList(r100);
        if (r101 == null) goto L6;
    L7:
        a(r101, "refresh_apis");
        return r101;
    L6:
        r101 = new ArrayList();
        goto L7
    }

    public final Map<String, ECHybridNetworkDTO> getApiKeyToNetworkDTOMap() {
        return this.apiKeyToNetworkDTOMap;
    }

    public final List<String> getClientAiFirstScreenApiKeyList() {
        return this.clientAiFirstScreenApiKeyList;
    }

    public final List<String> getClientAiPrefetchApiKeyList() {
        return this.clientAiPrefetchApiKeyList;
    }

    public final List<String> getFirstScreenApiKeyList() {
        return this.firstScreenApiKeyList;
    }

    public final List<String> getLoadMoreApiKeyList() {
        return this.loadMoreApiKeyList;
    }

    public final List<String> getLoginStateChangeApiKeyList() {
        return this.loginStateChangeApiKeyList;
    }

    public final List<String> getRefreshApiKeyList() {
        return this.refreshApiKeyList;
    }

    public final List<RequireClientVersionItem> getRequireClientVersion() {
        return this.requireClientVersion;
    }

    public final void setApiKeyToNetworkDTOMap(Map<String, ECHybridNetworkDTO> r100) {
        this.apiKeyToNetworkDTOMap = r100;
    }

    public final void setClientAiFirstScreenApiKeyList(List<String> r100) {
        this.clientAiFirstScreenApiKeyList = r100;
    }

    public final void setClientAiPrefetchApiKeyList(List<String> r100) {
        this.clientAiPrefetchApiKeyList = r100;
    }

    public final void setFirstScreenApiKeyList(List<String> r100) {
        this.firstScreenApiKeyList = r100;
    }

    public final void setLoadMoreApiKeyList(List<String> r100) {
        this.loadMoreApiKeyList = r100;
    }

    public final void setLoginStateChangeApiKeyList(List<String> r100) {
        this.loginStateChangeApiKeyList = r100;
    }

    public final void setRefreshApiKeyList(List<String> r100) {
        this.refreshApiKeyList = r100;
    }

    public final void setRequireClientVersion(List<RequireClientVersionItem> r100) {
        this.requireClientVersion = r100;
    }

    public final void a(List r100, String r101) {
        List<RequireClientVersionItem> r102 = this.requireClientVersion;     // Catch: Exception -> L37
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        return;
    L11:
        List<RequireClientVersionItem> r104 = this.requireClientVersion;     // Catch: Exception -> L37
        if (r104 == null) goto L36;
        Iterator<T> r105 = r104.iterator();     // Catch: Exception -> L37
    L14:
        if (r105.hasNext() == false) goto L49;
        RequireClientVersionItem r106 = (RequireClientVersionItem) r105.next();     // Catch: Exception -> L37
        List<String> r107 = r106.getGroup();     // Catch: Exception -> L37
        if (r107 != null) goto L20;
        r107 = CollectionsKt.emptyList();     // Catch: Exception -> L37
    L20:
        if (r107.contains(r101) == false) goto L14;
        Long r108 = r106.getMinVersion();     // Catch: Exception -> L37
        if (r108 == null) goto L25;
        long r109 = r108.longValue();     // Catch: Exception -> L37
    L26:
        String r110 = HybridAppInfoService.f47545p.getAppVersion();     // Catch: Exception -> L37
        if (r110 != null) goto L30;
        r110 = "0";
    L30:
        if (CastLongProtector.parseLong(r110) < r109) goto L14;
        String r111 = r106.getApi();     // Catch: Exception -> L37
        if (r111 != null) goto L34;
        r111 = "";
    L34:
        r100.add(r111);     // Catch: Exception -> L37
        goto L14
    L25:
        r109 = 999999;
        goto L26
    L49:
        return;
    L36:
        return;
    L5:
        if (r102.isEmpty() == true) goto L8;
        r103 = false;
    }
}
