package com.obric.cloudsdk.kv.syncconfig;

import com.android.contacts.ContactSaveService;
import com.google.gson.annotations.SerializedName;
import com.obric.cloudsdk.kv.base.KvConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SyncData.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\u0002\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\tHÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003Jy\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\t2\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0005HÖ\u0001J\b\u0010*\u001a\u00020\u0003H\u0016R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013¨\u0006+"}, d2 = {"Lcom/obric/cloudsdk/kv/syncconfig/SyncData;", "", "tableName", "", "priority", "", ContactSaveService.EXTRA_DATA_ID, "uri", "columnList", "", "dependenceList", "Lcom/obric/cloudsdk/kv/syncconfig/Dependence;", "syncType", "mainFile", "expandFiles", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;ILjava/lang/String;Ljava/util/List;)V", "getColumnList", "()Ljava/util/List;", "getDataId", "()Ljava/lang/String;", "getDependenceList", "getExpandFiles", "getMainFile", "getPriority", "()I", "getSyncType", "getTableName", "getUri", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "cloudsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SyncData {

    @SerializedName("column_list")
    private final List<String> columnList;

    @SerializedName(KvConstant.KV_DATA_ID)
    private final String dataId;

    @SerializedName("dependence_list")
    private final List<Dependence> dependenceList;

    @SerializedName("expand_files")
    private final List<String> expandFiles;

    @SerializedName("main_file")
    private final String mainFile;

    @SerializedName("priority")
    private final int priority;

    @SerializedName("sync_type")
    private final int syncType;

    @SerializedName("table_name")
    private final String tableName;

    @SerializedName("uri")
    private final String uri;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SyncData copy$default(SyncData r10, String r11, int r12, String r13, String r14, List r15, List r16, int r17, String r18, List r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        String r2 = r10.tableName;
    L7:
        if ((r20 & 2) == 0) goto L9;
        int r3 = r10.priority;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r4 = r10.dataId;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r5 = r10.uri;
    L19:
        if ((r20 & 16) == 0) goto L21;
        List r6 = r10.columnList;
    L23:
        if ((r20 & 32) == 0) goto L25;
        List r7 = r10.dependenceList;
    L27:
        if ((r20 & 64) == 0) goto L29;
        int r8 = r10.syncType;
    L31:
        if ((r20 & 128) == 0) goto L33;
        String r9 = r10.mainFile;
    L35:
        if ((r20 & 256) == 0) goto L37;
        List r1 = r10.expandFiles;
    L39:
        return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
    L37:
        r1 = r19;
        goto L39
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }

    public final String component1() {
        return this.tableName;
    }

    public final int component2() {
        return this.priority;
    }

    public final String component3() {
        return this.dataId;
    }

    public final String component4() {
        return this.uri;
    }

    public final List<String> component5() {
        return this.columnList;
    }

    public final List<Dependence> component6() {
        return this.dependenceList;
    }

    public final int component7() {
        return this.syncType;
    }

    public final String component8() {
        return this.mainFile;
    }

    public final List<String> component9() {
        return this.expandFiles;
    }

    public final SyncData copy(String r12, int r13, String r14, String r15, List<String> r16, List<Dependence> r17, int r18, String r19, List<String> r20) {
        Intrinsics.checkNotNullParameter(r12, "tableName");
        Intrinsics.checkNotNullParameter(r14, ContactSaveService.EXTRA_DATA_ID);
        Intrinsics.checkNotNullParameter(r15, "uri");
        Intrinsics.checkNotNullParameter(r16, "columnList");
        Intrinsics.checkNotNullParameter(r17, "dependenceList");
        return new SyncData(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SyncData) == true) goto L8;
        return false;
    L8:
        SyncData r6 = (SyncData) r5;
        if (Intrinsics.areEqual(this.tableName, r6.tableName) == true) goto L12;
        return false;
    L12:
        if (this.priority == r6.priority) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.dataId, r6.dataId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.uri, r6.uri) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.columnList, r6.columnList) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.dependenceList, r6.dependenceList) == true) goto L27;
        return false;
    L27:
        if (this.syncType == r6.syncType) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.mainFile, r6.mainFile) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.expandFiles, r6.expandFiles) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((((((this.tableName.hashCode() * 31) + Integer.hashCode(this.priority)) * 31) + this.dataId.hashCode()) * 31) + this.uri.hashCode()) * 31) + this.columnList.hashCode()) * 31) + this.dependenceList.hashCode()) * 31) + Integer.hashCode(this.syncType)) * 31;
        String r1 = this.mainFile;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        List<String> r5 = this.expandFiles;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public SyncData(String r2, int r3, String r4, String r5, List<String> r6, List<Dependence> r7, int r8, String r9, List<String> r10) {
        Intrinsics.checkNotNullParameter(r2, "tableName");
        Intrinsics.checkNotNullParameter(r4, ContactSaveService.EXTRA_DATA_ID);
        Intrinsics.checkNotNullParameter(r5, "uri");
        Intrinsics.checkNotNullParameter(r6, "columnList");
        Intrinsics.checkNotNullParameter(r7, "dependenceList");
        this.tableName = r2;
        this.priority = r3;
        this.dataId = r4;
        this.uri = r5;
        this.columnList = r6;
        this.dependenceList = r7;
        this.syncType = r8;
        this.mainFile = r9;
        this.expandFiles = r10;
    }

    public final String getTableName() {
        return this.tableName;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final String getDataId() {
        return this.dataId;
    }

    public final String getUri() {
        return this.uri;
    }

    public final List<String> getColumnList() {
        return this.columnList;
    }

    public /* synthetic */ SyncData(String r13, int r14, String r15, String r16, List r17, List r18, int r19, String r20, List r21, int r22, DefaultConstructorMarker r23) {
        if ((r22 & 32) == 0) goto L5;
        List r8 = CollectionsKt.emptyList();
    L7:
        if ((r22 & 64) == 0) goto L9;
        int r9 = 0;
    L11:
        if ((r22 & 128) == 0) goto L13;
        String r10 = null;
    L15:
        if ((r22 & 256) == 0) goto L17;
        List r11 = null;
    L18:
        this(r13, r14, r15, r16, r17, r8, r9, r10, r11);
        return;
    L17:
        r11 = r21;
        goto L18
    L13:
        r10 = r20;
        goto L15
    L9:
        r9 = r19;
        goto L11
    L5:
        r8 = r18;
        goto L7
    }

    public final List<Dependence> getDependenceList() {
        return this.dependenceList;
    }

    public final int getSyncType() {
        return this.syncType;
    }

    public final String getMainFile() {
        return this.mainFile;
    }

    public final List<String> getExpandFiles() {
        return this.expandFiles;
    }

    public String toString() {
        return "SyncData(tableName='" + this.tableName + "', priority=" + this.priority + ", dataId='" + this.dataId + "', uri='" + this.uri + "', columnList=" + this.columnList + ", dependenceList=" + this.dependenceList + ", syncType=" + this.syncType + ", mainFile=" + this.mainFile + ", expandFiles=" + this.expandFiles + ')';
    }
}
