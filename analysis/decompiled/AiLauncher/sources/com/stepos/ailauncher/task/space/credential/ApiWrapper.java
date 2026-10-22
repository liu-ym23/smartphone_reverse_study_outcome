package com.stepos.ailauncher.task.space.credential;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B)\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0015\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00018\u00008\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/stepos/ailauncher/task/space/credential/a;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "status", "", "msg", "data", "<init>", "(ILjava/lang/String;Ljava/lang/Object;)V", "", Const.INTENT_KEY_UMID, "()Z", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "I", "c", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/Object;", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.task.space.credential.a, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class ApiWrapper<T> {

    @SerializedName("data")
    private final T data;

    @SerializedName("msg")
    private final String msg;

    @SerializedName("status")
    private final int status;

    public ApiWrapper() {
        this(0, null, null, 7, null);
    }

    public final T a() {
        return this.data;
    }

    /* renamed from: b, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    /* renamed from: c, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    public final boolean d() {
        return this.status == 200;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApiWrapper)) {
            return false;
        }
        ApiWrapper apiWrapper = (ApiWrapper) other;
        return this.status == apiWrapper.status && kotlin.jvm.internal.p.d(this.msg, apiWrapper.msg) && kotlin.jvm.internal.p.d(this.data, apiWrapper.data);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.status) * 31;
        String str = this.msg;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        T t10 = this.data;
        return iHashCode2 + (t10 != null ? t10.hashCode() : 0);
    }

    public String toString() {
        return "ApiWrapper(status=" + this.status + ", msg=" + this.msg + ", data=" + this.data + ")";
    }

    public ApiWrapper(int i10, String str, T t10) {
        this.status = i10;
        this.msg = str;
        this.data = t10;
    }

    public /* synthetic */ ApiWrapper(int i10, String str, Object obj, int i11, kotlin.jvm.internal.i iVar) {
        this((i11 & 1) != 0 ? 0 : i10, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : obj);
    }
}
