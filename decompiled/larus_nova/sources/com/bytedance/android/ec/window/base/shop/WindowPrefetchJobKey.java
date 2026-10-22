package com.bytedance.android.ec.window.base.shop;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.annotations.SerializedName;
import com.obric.capabilitykit.common.Ext;
import faceverify.w;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B1\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0086\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016R\u001b\u0010\r\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/ec/window/base/shop/WindowPrefetchJobKey;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/io/Serializable;", "", "other", "", "equals", "", "hashCode", "hash$delegate", "Lkotlin/Lazy;", "getHash", "()I", w.BLOB_ELEM_IMAGE_HASHCODE, "Ljava/lang/Class;", "clazz", "Ljava/lang/Class;", "", "jobId", "Ljava/lang/String;", "jobName", "<init>", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class WindowPrefetchJobKey<T> implements Serializable {

    @SerializedName("clazz")
    private final Class<T> clazz;
    private final Lazy hash$delegate;

    @SerializedName(Ext.KEY_JOB_ID)
    private final String jobId;

    @SerializedName("job_name")
    private final String jobName;

    public WindowPrefetchJobKey() {
        this(null, null, null, 7, null);
    }

    public int hashCode() {
        return ((Number) this.hash$delegate.getValue()).intValue();
    }

    public static final int access$genHashCode(WindowPrefetchJobKey r100) {
        Class<T> r101 = r100.clazz;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = r103 * 31;
        String r105 = r100.jobId;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = r100.jobName;
        if (r108 == null) goto L14;
        r102 = r108.hashCode();
    L14:
        return r107 + r102;
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof WindowPrefetchJobKey) == true) goto L8;
        return false;
    L8:
        WindowPrefetchJobKey r101 = (WindowPrefetchJobKey) r100;
        if ((!Intrinsics.areEqual(this.clazz, r101.clazz)) == false) goto L12;
        return false;
    L12:
        if ((!Intrinsics.areEqual(this.jobId, r101.jobId)) == false) goto L15;
        return false;
    L15:
        if ((!Intrinsics.areEqual(this.jobName, r101.jobName)) == false) goto L17;
        return false;
    L17:
        return true;
    }

    public WindowPrefetchJobKey(Class<T> r100, String r101, String r102) {
        this.clazz = r100;
        this.jobId = r101;
        this.jobName = r102;
        this.hash$delegate = LazyKt.lazy(new WindowPrefetchJobKey$hash$2(this));
    }

    public /* synthetic */ WindowPrefetchJobKey(Class r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = String.valueOf(System.nanoTime());
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = "";
    L11:
        this(r100, r101, r102);
    }
}
