package com.bytedance.android.ec.store.prefetch;

import androidx.exifinterface.media.ExifInterface;
import faceverify.w;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B)\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0086\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016R\u001b\u0010\r\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/ec/store/prefetch/PrefetchJobKey;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/io/Serializable;", "", "other", "", "equals", "", "hashCode", "hash$delegate", "Lkotlin/Lazy;", "getHash", "()I", w.BLOB_ELEM_IMAGE_HASHCODE, "Ljava/lang/Class;", "clazz", "Ljava/lang/Class;", "", "jobId", "Ljava/lang/String;", "jobName", "<init>", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class PrefetchJobKey<T> implements Serializable {
    private final Class<T> clazz;
    private final Lazy hash$delegate;
    private final String jobId;
    private final String jobName;

    public int hashCode() {
        return ((Number) this.hash$delegate.getValue()).intValue();
    }

    public static final int access$genHashCode(PrefetchJobKey r100) {
        return (((r100.clazz.hashCode() * 31) + r100.jobId.hashCode()) * 31) + r100.jobName.hashCode();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PrefetchJobKey) == true) goto L8;
        return false;
    L8:
        PrefetchJobKey r101 = (PrefetchJobKey) r100;
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

    public PrefetchJobKey(Class<T> r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "jobId");
        Intrinsics.checkNotNullParameter(r102, "jobName");
        this.clazz = r100;
        this.jobId = r101;
        this.jobName = r102;
        this.hash$delegate = LazyKt.lazy(new PrefetchJobKey$hash$2(this));
    }

    public /* synthetic */ PrefetchJobKey(Class r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = String.valueOf(System.nanoTime());
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = "";
    L8:
        this(r100, r101, r102);
    }
}
