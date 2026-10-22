package com.bytedance.android.ec.core.hybrid.model;

import com.bytedance.android.ec.core.opt.ab.p;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.List;
import jj4.b;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB%\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J.\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\f\u001a\u00020\u0006HÖ\u0001J\t\u0010\r\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004\"\u0004\b\u0014\u0010\u0015R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/model/ECPreProcessorJsbOptConfig;", "Ljava/io/Serializable;", "", "component1", "()Ljava/lang/Integer;", "", "", "component2", "open", "blackList", "copy", "(Ljava/lang/Integer;Ljava/util/List;)Lcom/bytedance/android/ec/core/hybrid/model/ECPreProcessorJsbOptConfig;", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/Integer;", "getOpen", "setOpen", "(Ljava/lang/Integer;)V", "Ljava/util/List;", "getBlackList", "()Ljava/util/List;", "<init>", "(Ljava/lang/Integer;Ljava/util/List;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECPreProcessorJsbOptConfig implements Serializable {
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ECPreProcessorJsbOptConfig f44174a = null;

    @SerializedName("black_list")
    private final List<String> blackList;

    @SerializedName("open")
    private Integer open;

    public static final class a {
        public a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECPreProcessorJsbOptConfig() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECPreProcessorJsbOptConfig copy$default(ECPreProcessorJsbOptConfig r100, Integer r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.open;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.blackList;
    L9:
        return r100.copy(r101, r102);
    }

    public final Integer component1() {
        return this.open;
    }

    public final List<String> component2() {
        return this.blackList;
    }

    public final ECPreProcessorJsbOptConfig copy(Integer r100, List<String> r101) {
        return new ECPreProcessorJsbOptConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECPreProcessorJsbOptConfig) == false) goto L10;
        ECPreProcessorJsbOptConfig r101 = (ECPreProcessorJsbOptConfig) r100;
        if (Intrinsics.areEqual(this.open, r101.open) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.blackList, r101.blackList) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        Integer r100 = this.open;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.blackList;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ECPreProcessorJsbOptConfig(open=" + this.open + ", blackList=" + this.blackList + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Companion = new a();
        int r100 = zg.a.f571786a;
        int r101 = p.f45243a;
        Integer r102 = null;
        Object[] r103 = 0 == true ? 1 : 0;
        Object r104 = new ECPreProcessorJsbOptConfig(r102, r103, 3, 0 == true ? 1 : 0);
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L7
        b r106 = b.f499326b;     // Catch: Throwable -> L7
        Object r107 = jj4.a.a("ec_preprocessor_jsb_opt", ECPreProcessorJsbOptConfig.class, r104, false);     // Catch: Throwable -> L7
        if (r107 != null) goto L13;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L13:
        f44174a = (ECPreProcessorJsbOptConfig) r107;
        return;
    L7:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Object r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r109) == true) goto L12;
        r104 = r109;
    L12:
        r107 = r104;
        goto L13
    }

    public static final /* synthetic */ ECPreProcessorJsbOptConfig access$getCONFIG$cp() {
        return f44174a;
    }

    public final List<String> getBlackList() {
        return this.blackList;
    }

    public final Integer getOpen() {
        return this.open;
    }

    public final void setOpen(Integer r100) {
        this.open = r100;
    }

    public ECPreProcessorJsbOptConfig(Integer r100, List<String> r101) {
        this.open = r100;
        this.blackList = r101;
    }

    public /* synthetic */ ECPreProcessorJsbOptConfig(Integer r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 1;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
