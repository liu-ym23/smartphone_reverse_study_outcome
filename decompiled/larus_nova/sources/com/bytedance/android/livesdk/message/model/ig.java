package com.bytedance.android.livesdk.message.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R*\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ig;", "", "", "joined", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "", "", "userIds", "Ljava/util/List;", "getUserIds", "()Ljava/util/List;", "setUserIds", "(Ljava/util/List;)V", "", "userOpenIds", "getUserOpenIds", "setUserOpenIds", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ig implements vh7.h {

    @SerializedName("is_joined")
    protected boolean joined;

    @SerializedName("user_ids")
    protected List<Long> userIds;

    @SerializedName("user_open_ids")
    protected List<String> userOpenIds;

    public ig() {
    }

    public final int hashCode() {
        if (this.joined == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        List<Long> r102 = this.userIds;
        int r103 = 0;
        if (r102 == null) goto L9;
        int r104 = r102.hashCode();
    L10:
        int r105 = (r101 + r104) * 31;
        List<String> r106 = this.userOpenIds;
        if (r106 == null) goto L14;
        r103 = r106.hashCode();
    L14:
        return r105 + r103;
    L9:
        r104 = 0;
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final boolean a() {
        return this.joined;
    }

    public final List<String> b() {
        return this.userOpenIds;
    }

    public ig(am3.g r100) {
        this.userIds = new ArrayList();
        this.userOpenIds = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L16;
        if (r102 == 1) goto L14;
        if (r102 != 2) goto L10;
        this.joined = am3.h.a(r100);
        goto L3
    L10:
        if (r102 != 5000) goto L11;
        List r103 = this.userOpenIds;
        Comparable r104 = am3.h.c(r100);
    L15:
        r103.add(r104);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L14:
        r103 = this.userIds;
        r104 = Long.valueOf(r100.j());
        goto L15
    L16:
        r100.d(r101);
    }

    public final void c(List<String> r100) {
        MutablePropertyReference0Impl r101 = new MultiChorusSongItem$userOpenIdStringList$1(this);
        MutablePropertyReference0Impl r102 = new MultiChorusSongItem$userOpenIdStringList$2(this);
        Intrinsics.checkNotNullParameter(r101, "uid");
        Intrinsics.checkNotNullParameter(r102, "uidString");
        if (r100 == null) goto L8;
        List<String> r103 = r100;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L6:
        if (r105.hasNext() == false) goto L9;
        r104.add(Long.valueOf(com.bytedance.android.livesdk.utils.d5.c((String) r105.next())));
    L9:
        r101.set(r104);
        r102.set(r100);
        return;
    L8:
        r104 = null;
        goto L9
    }

    public final boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this != r100) goto L9;
        return true;
    L9:
        if ((!Intrinsics.areEqual(ig.class, r100.getClass())) == false) goto L11;
        return false;
    L11:
        ig r101 = (ig) r100;
        if (this.joined == r101.joined) goto L15;
        return false;
    L15:
        if ((!Intrinsics.areEqual(this.userIds, r101.userIds)) == false) goto L18;
        return false;
    L18:
        if ((!Intrinsics.areEqual(this.userOpenIds, r101.userOpenIds)) == false) goto L20;
        return false;
    L20:
        return true;
    }
}
