package com.bytedance.ai.bridge.remote.model;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001aB)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/BatchGetAppMetaResponse;", "Ljava/io/Serializable;", "code", "", "message", "", "data", "Lcom/bytedance/ai/bridge/remote/model/BatchGetAppMetaResponse$Data;", "<init>", "(ILjava/lang/String;Lcom/bytedance/ai/bridge/remote/model/BatchGetAppMetaResponse$Data;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "getData", "()Lcom/bytedance/ai/bridge/remote/model/BatchGetAppMetaResponse$Data;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "Data", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BatchGetAppMetaResponse implements Serializable {

    @SerializedName("code")
    private final int code;

    @SerializedName("data")
    private final Data data;

    @SerializedName("message")
    private final String message;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/BatchGetAppMetaResponse$Data;", "Ljava/io/Serializable;", "items", "", "Lcom/bytedance/ai/bridge/remote/model/AppMeta;", "failedKeys", "Lcom/bytedance/ai/bridge/remote/model/FailedKey;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "getFailedKeys", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Data implements Serializable {

        @SerializedName("failed_keys")
        @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
        private final List<FailedKey> failedKeys;

        @SerializedName("items")
        @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
        private final List<AppMeta> items;

        /* JADX WARN: Multi-variable type inference failed */
        public Data() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Data copy$default(Data r100, List r101, List r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.items;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.failedKeys;
        L9:
            return r100.copy(r101, r102);
        }

        public final List<AppMeta> component1() {
            return this.items;
        }

        public final List<FailedKey> component2() {
            return this.failedKeys;
        }

        public final Data copy(List<AppMeta> r100, List<FailedKey> r101) {
            return new Data(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Data) == true) goto L8;
            return false;
        L8:
            Data r101 = (Data) r100;
            if (Intrinsics.areEqual(this.items, r101.items) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.failedKeys, r101.failedKeys) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            List<AppMeta> r100 = this.items;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            List<FailedKey> r104 = this.failedKeys;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public String toString() {
            return "Data(items=" + this.items + ", failedKeys=" + this.failedKeys + ')';
        }

        public final List<FailedKey> getFailedKeys() {
            return this.failedKeys;
        }

        public final List<AppMeta> getItems() {
            return this.items;
        }

        public Data(List<AppMeta> r100, List<FailedKey> r101) {
            this.items = r100;
            this.failedKeys = r101;
        }

        public /* synthetic */ Data(List r100, List r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = CollectionsKt.emptyList();
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = CollectionsKt.emptyList();
        L8:
            this(r100, r101);
        }
    }

    public BatchGetAppMetaResponse() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ BatchGetAppMetaResponse copy$default(BatchGetAppMetaResponse r100, int r101, String r102, Data r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.code;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.message;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.data;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final Data component3() {
        return this.data;
    }

    public final BatchGetAppMetaResponse copy(int r100, String r101, Data r102) {
        return new BatchGetAppMetaResponse(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BatchGetAppMetaResponse) == true) goto L8;
        return false;
    L8:
        BatchGetAppMetaResponse r101 = (BatchGetAppMetaResponse) r100;
        if (this.code == r101.code) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.message, r101.message) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.code * 31;
        String r101 = this.message;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Data r105 = this.data;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "BatchGetAppMetaResponse(code=" + this.code + ", message=" + this.message + ", data=" + this.data + ')';
    }

    public final int getCode() {
        return this.code;
    }

    public final Data getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public BatchGetAppMetaResponse(int r100, String r101, Data r102) {
        this.code = r100;
        this.message = r101;
        this.data = r102;
    }

    public /* synthetic */ BatchGetAppMetaResponse(int r100, String r101, Data r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
