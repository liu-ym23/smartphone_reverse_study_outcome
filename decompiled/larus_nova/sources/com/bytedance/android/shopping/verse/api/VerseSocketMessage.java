package com.bytedance.android.shopping.verse.api;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0001#B9\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b \u0010!J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0001HÆ\u0003JL\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0011\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0019\u0010\u0018R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006$"}, d2 = {"Lcom/bytedance/android/shopping/verse/api/VerseSocketMessage;", "", "", "component1", "component2", "", "component3", "()Ljava/lang/Integer;", "component4", "component5", "key", "path", "code", "msg", "data", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Object;)Lcom/bytedance/android/shopping/verse/api/VerseSocketMessage;", "toString", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "getPath", "Ljava/lang/Integer;", "getCode", "getMsg", "Ljava/lang/Object;", "getData", "()Ljava/lang/Object;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Object;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-verse-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VerseSocketMessage {
    public static final a Companion = null;

    @SerializedName("code")
    private final Integer code;

    @SerializedName("data")
    private final Object data;

    @SerializedName("key")
    private final String key;

    @SerializedName("msg")
    private final String msg;

    @SerializedName("path")
    private final String path;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ VerseSocketMessage copy$default(VerseSocketMessage r100, String r101, String r102, Integer r103, String r104, Object r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.key;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.path;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.code;
    L11:
        Integer r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.msg;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.data;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.key;
    }

    public final String component2() {
        return this.path;
    }

    public final Integer component3() {
        return this.code;
    }

    public final String component4() {
        return this.msg;
    }

    public final Object component5() {
        return this.data;
    }

    public final VerseSocketMessage copy(String r100, String r101, Integer r110, String r111, Object r112) {
        return new VerseSocketMessage(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof VerseSocketMessage) == false) goto L16;
        VerseSocketMessage r101 = (VerseSocketMessage) r100;
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.path, r101.path) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.code, r101.code) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.msg, r101.msg) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r100 = this.key;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.path;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.code;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.msg;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Object r113 = this.data;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
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
        return "VerseSocketMessage(key=" + this.key + ", path=" + this.path + ", code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ")";
    }

    public final Integer getCode() {
        return this.code;
    }

    public final Object getData() {
        return this.data;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final String getPath() {
        return this.path;
    }

    public VerseSocketMessage(String r100, String r101, Integer r102, String r103, Object r104) {
        this.key = r100;
        this.path = r101;
        this.code = r102;
        this.msg = r103;
        this.data = r104;
    }
}
