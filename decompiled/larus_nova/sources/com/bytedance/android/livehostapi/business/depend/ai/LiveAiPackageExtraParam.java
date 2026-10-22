package com.bytedance.android.livehostapi.business.depend.ai;

import com.bytedance.android.ec.slice.SliceInitService;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/ai/LiveAiPackageExtraParam;", "", "extString", "", "packageBufferList", "", "Lcom/bytedance/android/livehostapi/business/depend/ai/LiveAiPackageBuffer;", "inputParams", "", "(Ljava/lang/String;Ljava/util/List;[F)V", "getExtString", "()Ljava/lang/String;", "setExtString", "(Ljava/lang/String;)V", "getInputParams", "()[F", "getPackageBufferList", "()Ljava/util/List;", "equals", "", "other", "hashCode", "", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveAiPackageExtraParam {
    private String extString;
    private final float[] inputParams;
    private final List<LiveAiPackageBuffer> packageBufferList;

    public LiveAiPackageExtraParam() {
        this(null, null, null, 7, null);
    }

    public int hashCode() {
        int r100 = this.extString.hashCode() * 31;
        List<LiveAiPackageBuffer> r101 = this.packageBufferList;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        float[] r105 = this.inputParams;
        if (r105 == null) goto L10;
        r102 = Arrays.hashCode(r105);
    L10:
        return r104 + r102;
    L5:
        r103 = 0;
        goto L6
    }

    public final String getExtString() {
        return this.extString;
    }

    public final float[] getInputParams() {
        return this.inputParams;
    }

    public final List<LiveAiPackageBuffer> getPackageBufferList() {
        return this.packageBufferList;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(LiveAiPackageExtraParam.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L32;
        LiveAiPackageExtraParam r102 = (LiveAiPackageExtraParam) r100;
        if ((!Intrinsics.areEqual(this.extString, r102.extString)) == false) goto L17;
        return false;
    L17:
        if ((!Intrinsics.areEqual(this.packageBufferList, r102.packageBufferList)) == false) goto L19;
        return false;
    L19:
        float[] r103 = this.inputParams;
        if (r103 == null) goto L28;
        float[] r104 = r102.inputParams;
        if (r104 != null) goto L25;
        return false;
    L25:
        if (Arrays.equals(r103, r104) == true) goto L30;
        return false;
    L30:
        return true;
    L28:
        if (r102.inputParams == null) goto L30;
        return false;
    L32:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livehostapi.business.depend.ai.LiveAiPackageExtraParam");
    L8:
        r101 = null;
        goto L10
    }

    public final void setExtString(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.extString = r100;
    }

    public LiveAiPackageExtraParam(String r100, List<LiveAiPackageBuffer> r101, float[] r102) {
        Intrinsics.checkNotNullParameter(r100, "extString");
        this.extString = r100;
        this.packageBufferList = r101;
        this.inputParams = r102;
    }

    public /* synthetic */ LiveAiPackageExtraParam(String r100, List r101, float[] r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = SliceInitService.DEFAULT_SWITCH;
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
