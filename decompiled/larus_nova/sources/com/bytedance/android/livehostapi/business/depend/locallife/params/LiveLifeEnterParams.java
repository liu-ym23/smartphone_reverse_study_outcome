package com.bytedance.android.livehostapi.business.depend.locallife.params;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006\u0012\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006\u0012\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006¢\u0006\u0002\u0010\nJ\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006HÆ\u0003J\u0019\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006HÆ\u0003J\u0019\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006HÆ\u0003Ji\u0010\u001b\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00062\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00062\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0006\u0010!\u001a\u00020\u001dJ\t\u0010\"\u001a\u00020\u0007HÖ\u0001R&\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR.\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R.\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R.\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012¨\u0006#"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/locallife/params/LiveLifeEnterParams;", "", "action", "", "Lcom/bytedance/android/livehostapi/business/depend/locallife/params/LiveLifeActionParams;", "logInfo", "", "", "requestParams", "extra", "(Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "getAction", "()Ljava/util/List;", "setAction", "(Ljava/util/List;)V", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "getLogInfo", "setLogInfo", "getRequestParams", "setRequestParams", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "isEmpty", "toString", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveLifeEnterParams {

    @SerializedName("action")
    private List<LiveLifeActionParams> action;

    @SerializedName("extra")
    private Map<String, Object> extra;

    @SerializedName("log_info")
    private Map<String, Object> logInfo;

    @SerializedName("request_params")
    private Map<String, Object> requestParams;

    public LiveLifeEnterParams() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LiveLifeEnterParams copy$default(LiveLifeEnterParams r100, List r101, Map r102, Map r103, Map r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.action;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.logInfo;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.requestParams;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.extra;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final List<LiveLifeActionParams> component1() {
        return this.action;
    }

    public final Map<String, Object> component2() {
        return this.logInfo;
    }

    public final Map<String, Object> component3() {
        return this.requestParams;
    }

    public final Map<String, Object> component4() {
        return this.extra;
    }

    public final LiveLifeEnterParams copy(List<LiveLifeActionParams> r100, Map<String, Object> r101, Map<String, Object> r102, Map<String, Object> r103) {
        return new LiveLifeEnterParams(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LiveLifeEnterParams) == false) goto L14;
        LiveLifeEnterParams r101 = (LiveLifeEnterParams) r100;
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.logInfo, r101.logInfo) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.requestParams, r101.requestParams) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        List<LiveLifeActionParams> r100 = this.action;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, Object> r104 = this.logInfo;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, Object> r107 = this.requestParams;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, Object> r110 = this.extra;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "LiveLifeEnterParams(action=" + this.action + ", logInfo=" + this.logInfo + ", requestParams=" + this.requestParams + ", extra=" + this.extra + ")";
    }

    public final boolean isEmpty() {
        List<LiveLifeActionParams> r100 = this.action;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L36;
        Map<String, Object> r102 = this.logInfo;
        if (r102 != null) goto L13;
    L16:
        boolean r103 = true;
    L17:
        if (r103 == false) goto L37;
        Map<String, Object> r104 = this.requestParams;
        if (r104 != null) goto L21;
    L24:
        boolean r105 = true;
    L25:
        if (r105 == false) goto L38;
        Map<String, Object> r106 = this.extra;
        if (r106 != null) goto L29;
    L32:
        boolean r107 = true;
    L33:
        if (r107 == false) goto L39;
        return true;
    L39:
        return false;
    L29:
        if (r106.isEmpty() == true) goto L32;
        r107 = false;
        goto L33
    L38:
        return false;
    L21:
        if (r104.isEmpty() == true) goto L24;
        r105 = false;
        goto L25
    L37:
        return false;
    L13:
        if (r102.isEmpty() == true) goto L16;
        r103 = false;
        goto L17
    L36:
        return false;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    public final List<LiveLifeActionParams> getAction() {
        return this.action;
    }

    public final Map<String, Object> getExtra() {
        return this.extra;
    }

    public final Map<String, Object> getLogInfo() {
        return this.logInfo;
    }

    public final Map<String, Object> getRequestParams() {
        return this.requestParams;
    }

    public final void setAction(List<LiveLifeActionParams> r100) {
        this.action = r100;
    }

    public final void setExtra(Map<String, Object> r100) {
        this.extra = r100;
    }

    public final void setLogInfo(Map<String, Object> r100) {
        this.logInfo = r100;
    }

    public final void setRequestParams(Map<String, Object> r100) {
        this.requestParams = r100;
    }

    public LiveLifeEnterParams(List<LiveLifeActionParams> r100, Map<String, Object> r101, Map<String, Object> r102, Map<String, Object> r103) {
        this.action = r100;
        this.logInfo = r101;
        this.requestParams = r102;
        this.extra = r103;
    }

    public /* synthetic */ LiveLifeEnterParams(List r100, Map r101, Map r102, Map r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
