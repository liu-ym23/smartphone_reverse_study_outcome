package com.obric.memorydata.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: MemoryResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class MemoryResponse<T> implements Parcelable {
    public static final CREATOR CREATOR = null;
    private static final MemoryResponse<Void> SUCCESS = null;
    private int code;
    private T data;
    private String message;

    /* JADX INFO: compiled from: MemoryResponse.kt */
    public static final class CREATOR implements Parcelable.Creator<MemoryResponse<?>> {
        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MemoryResponse<?> createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MemoryResponse<?>[] newArray(int r1) {
            return newArray(r1);
        }

        public final MemoryResponse<Void> getSUCCESS() {
            return MemoryResponse.access$getSUCCESS$cp();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MemoryResponse<?> createFromParcel(Parcel r4) {
            o.e(r4, "parcel");
            return new MemoryResponse(r4.readInt(), r4.readString(), r4.readValue(MemoryResponse.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MemoryResponse<?>[] newArray(int r1) {
            return new MemoryResponse[r1];
        }
    }

    public MemoryResponse() {
        this(0, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MemoryResponse copy$default(MemoryResponse r0, int r1, String r2, Object r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.code;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.message;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.data;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final T component3() {
        return this.data;
    }

    public final MemoryResponse<T> copy(int r1, String r2, T r3) {
        return new MemoryResponse(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, MemoryResponse.class) == true) goto L8;
        return false;
    L8:
        MemoryResponse r6 = (MemoryResponse) ZeusTransformUtils.preCheckCast(r5, MemoryResponse.class, "com.obric.aiagent.plugin");
        if (this.code == r6.code) goto L12;
        return false;
    L12:
        if (o.a(this.message, r6.message) == true) goto L15;
        return false;
    L15:
        if (o.a(this.data, r6.data) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = Integer.hashCode(this.code) * 31;
        String r1 = this.message;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        T r5 = this.data;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "MemoryResponse(code=" + this.code + ", message=" + this.message + ", data=" + this.data + ')';
    }

    public MemoryResponse(int r1, String r2, T r3) {
        this.code = r1;
        this.message = r2;
        this.data = r3;
    }

    public /* synthetic */ MemoryResponse(int r2, String r3, Object r4, int r5, h r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }

    public static final /* synthetic */ MemoryResponse access$getSUCCESS$cp() {
        return SUCCESS;
    }

    public final int getCode() {
        return this.code;
    }

    public final T getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setCode(int r1) {
        this.code = r1;
    }

    public final void setData(T r1) {
        this.data = r1;
    }

    public final void setMessage(String r1) {
        this.message = r1;
    }

    public MemoryResponse(Parcel r4) {
        o.e(r4, "parcel");
        this(r4.readInt(), r4.readString(), r4.readValue(MemoryResponse.class.getClassLoader()));
    }

    public final boolean isSuccess() {
        if (this.code != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeInt(this.code);
        r1.writeString(this.message);
        r1.writeValue(this.data);
    }

    static {
        CREATOR = new CREATOR(null);
        SUCCESS = new MemoryResponse(0, "success", null, 4, null);
    }
}
