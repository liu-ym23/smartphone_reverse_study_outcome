package com.bytedance.android.livesdkapi.service;

import com.android.ttcjpaysdk.integrated.sign.counter.activity.SignCounterLaunchArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/UserCheckInfo;", "", SignCounterLaunchArgs.EXTRA_SCENE_TYPE, "", "dataId", "dataType", "", "itemRawInfo", "uid", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getDataId", "()Ljava/lang/String;", "getDataType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getItemRawInfo", "getSceneType", "getUid", "equals", "", "other", "hashCode", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserCheckInfo {
    private final String dataId;
    private final Integer dataType;
    private final String itemRawInfo;
    private final String sceneType;
    private final String uid;

    public int hashCode() {
        int r100 = this.sceneType.hashCode() * 31;
        String r101 = this.dataId;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        Integer r105 = this.dataType;
        if (r105 == null) goto L10;
        r102 = r105.intValue();
    L10:
        return r104 + r102;
    L5:
        r103 = 0;
        goto L6
    }

    public final String getDataId() {
        return this.dataId;
    }

    public final Integer getDataType() {
        return this.dataType;
    }

    public final String getItemRawInfo() {
        return this.itemRawInfo;
    }

    public final String getSceneType() {
        return this.sceneType;
    }

    public final String getUid() {
        return this.uid;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(UserCheckInfo.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L24;
        UserCheckInfo r102 = (UserCheckInfo) r100;
        if ((!Intrinsics.areEqual(this.sceneType, r102.sceneType)) == false) goto L17;
        return false;
    L17:
        if ((!Intrinsics.areEqual(this.dataId, r102.dataId)) == false) goto L20;
        return false;
    L20:
        if ((!Intrinsics.areEqual(this.dataType, r102.dataType)) == false) goto L22;
        return false;
    L22:
        return true;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.service.UserCheckInfo");
    L8:
        r101 = null;
        goto L10
    }

    public UserCheckInfo(String r100, String r101, Integer r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, SignCounterLaunchArgs.EXTRA_SCENE_TYPE);
        Intrinsics.checkNotNullParameter(r104, "uid");
        this.sceneType = r100;
        this.dataId = r101;
        this.dataType = r102;
        this.itemRawInfo = r103;
        this.uid = r104;
    }

    public /* synthetic */ UserCheckInfo(String r100, String r101, Integer r102, String r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 16) == 0) goto L5;
        r111 = "";
    L5:
        this(r100, r101, r102, r110, r111);
    }
}
