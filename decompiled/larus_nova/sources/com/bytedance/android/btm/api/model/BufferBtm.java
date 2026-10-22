package com.bytedance.android.btm.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010!\n\u0002\b\f\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001+BQ\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\n\u0012\u0006\u0010\u0016\u001a\u00020\n\u0012\u0006\u0010\u0018\u001a\u00020\n\u0012\u0006\u0010\u001a\u001a\u00020\n\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0 ¢\u0006\u0004\b'\u0010(B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b'\u0010)J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0017\u0010\f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0017\u0010\u000fR\u0017\u0010\u0018\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000fR\u0017\u0010\u001a\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u001b\u0010\u000fR\"\u0010\u001c\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u001fR(\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006,"}, d2 = {"Lcom/bytedance/android/btm/api/model/BufferBtm;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "describeContents", "", "toString", "btm", "Ljava/lang/String;", "getBtm", "()Ljava/lang/String;", "step", "I", "getStep", "()I", "pageId", "getPageId", "nodeId", "getNodeId", "treeId", "getTreeId", "btmShowId", "getBtmShowId", "useTimes", "getUseTimes", "setUseTimes", "(I)V", "", "targetPagesBtm", "Ljava/util/List;", "getTargetPagesBtm", "()Ljava/util/List;", "setTargetPagesBtm", "(Ljava/util/List;)V", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;)V", "(Landroid/os/Parcel;)V", "Companion", "b", "btm-api_cnRelease"}, k = 1, mv = {1, 4, 0})
public final class BufferBtm implements Parcelable, Serializable {
    public static final Parcelable.Creator<BufferBtm> CREATOR = null;
    public static final b Companion = null;
    private final String btm;
    private final String btmShowId;
    private final String nodeId;
    private final String pageId;
    private final int step;
    private List<String> targetPagesBtm;
    private final String treeId;
    private int useTimes;

    public static final class a implements Parcelable.Creator<BufferBtm> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BufferBtm createFromParcel(Parcel r100) {
            return new BufferBtm(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final BufferBtm[] newArray(int r100) {
            return new BufferBtm[r100];
        }
    }

    public static final class b {
        public b() {
        }

        public static BufferBtm a(BufferBtm r100) {
            return b(r100.getBtm(), r100.getStep(), r100.getPageId(), r100.getNodeId(), r100.getTreeId(), r100.getBtmShowId(), r100.getUseTimes(), r100.getTargetPagesBtm());
        }

        public static /* synthetic */ BufferBtm c(b r100, String r101, int r110, String r111, String r112, String r113, String r114) {
            ArrayList r102 = new ArrayList();
            r100.getClass();
            return b(r101, r110, r111, r112, r113, r114, 1, r102);
        }

        public static BufferBtm b(String r110, int r111, String r112, String r113, String r114, String r115, int r116, List r117) {
            if (r113 == null) goto L5;
            String r100 = r113;
        L6:
            if (r114 == null) goto L8;
            String r101 = r114;
        L10:
            return new BufferBtm(r110, r111, r112, r100, r101, r115, r116, r117);
        L8:
            r101 = "";
            goto L10
        L5:
            r100 = "";
            goto L6
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        Companion = new b();
        CREATOR = new a();
    }

    public String toString() {
        JSONObject r100 = new JSONObject();
        r100.put("btm", this.btm);     // Catch: Throwable -> L10
        r100.put("step", this.step);     // Catch: Throwable -> L10
        r100.put("pageId", this.pageId);     // Catch: Throwable -> L10
        r100.put("nodeId", this.nodeId);     // Catch: Throwable -> L10
        r100.put("treeId", this.treeId);     // Catch: Throwable -> L10
        r100.put("btmShowId", this.btmShowId);     // Catch: Throwable -> L10
        r100.put("useTimes", this.useTimes);     // Catch: Throwable -> L10
        JSONArray r101 = new JSONArray();     // Catch: Throwable -> L10
        Iterator<T> r102 = this.targetPagesBtm.iterator();     // Catch: Throwable -> L10
    L5:
        if (r102.hasNext() == false) goto L7;
        r101.put((String) r102.next());     // Catch: Throwable -> L10
        goto L5
    L7:
        r100.put("targetPagesBtm", r101);     // Catch: Throwable -> L10
    L9:
        return r100.toString();
    }

    public final String getBtm() {
        return this.btm;
    }

    public final String getBtmShowId() {
        return this.btmShowId;
    }

    public final String getNodeId() {
        return this.nodeId;
    }

    public final String getPageId() {
        return this.pageId;
    }

    public final int getStep() {
        return this.step;
    }

    public final List<String> getTargetPagesBtm() {
        return this.targetPagesBtm;
    }

    public final String getTreeId() {
        return this.treeId;
    }

    public final int getUseTimes() {
        return this.useTimes;
    }

    public BufferBtm(Parcel r110) {
        String r100 = r110.readString();
        if (r100 == null) goto L5;
        String r101 = r100;
    L6:
        int r102 = r110.readInt();
        String r103 = r110.readString();
        if (r103 == null) goto L9;
        String r104 = r103;
    L10:
        String r105 = r110.readString();
        if (r105 == null) goto L13;
        String r106 = r105;
    L14:
        String r107 = r110.readString();
        if (r107 == null) goto L17;
        String r108 = r107;
    L18:
        String r109 = r110.readString();
        if (r109 == null) goto L21;
        String r111 = r109;
    L22:
        this(r101, r102, r104, r106, r108, r111, r110.readInt(), null, 128, null);
        r110.readList(this.targetPagesBtm, String.class.getClassLoader());
        return;
    L21:
        r111 = "";
        goto L22
    L17:
        r108 = "";
        goto L18
    L13:
        r106 = "";
        goto L14
    L9:
        r104 = "";
        goto L10
    L5:
        r101 = "";
        goto L6
    }

    public final void setTargetPagesBtm(List<String> r100) {
        this.targetPagesBtm = r100;
    }

    public final void setUseTimes(int r100) {
        this.useTimes = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.btm);
        r100.writeInt(this.step);
        r100.writeString(this.pageId);
        r100.writeString(this.nodeId);
        r100.writeString(this.treeId);
        r100.writeString(this.btmShowId);
        r100.writeInt(this.useTimes);
        r100.writeList(this.targetPagesBtm);
    }

    public BufferBtm(String r100, int r101, String r102, String r103, String r104, String r105, int r106, List<String> r107) {
        this.btm = r100;
        this.step = r101;
        this.pageId = r102;
        this.nodeId = r103;
        this.treeId = r104;
        this.btmShowId = r105;
        this.useTimes = r106;
        this.targetPagesBtm = r107;
        this.useTimes = Math.max(r106, 1);
    }

    public /* synthetic */ BufferBtm(String r110, int r111, String r112, String r113, String r114, String r115, int r116, List r117, int r210, DefaultConstructorMarker r211) {
        if ((r210 & 64) == 0) goto L5;
        int r100 = 1;
    L7:
        if ((r210 & 128) == 0) goto L9;
        List r118 = new ArrayList();
    L10:
        this(r110, r111, r112, r113, r114, r115, r100, r118);
        return;
    L9:
        r118 = r117;
        goto L10
    L5:
        r100 = r116;
        goto L7
    }
}
