package com.bytedance.android.live.ktv.common.model.api;

import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R0\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR0\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/k0;", "", "", "", "Lcom/bytedance/android/live/ktv/common/model/api/l0;", "userBaseMap", "Ljava/util/Map;", "getUserBaseMap", "()Ljava/util/Map;", "setUserBaseMap", "(Ljava/util/Map;)V", "", "openUserBaseMap", "getOpenUserBaseMap", "setOpenUserBaseMap", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class k0 implements vh7.h {

    @IgnoreProtoFieldCheck
    @SerializedName("open_user_base_map")
    protected Map<String, l0> openUserBaseMap;

    @IgnoreProtoFieldCheck
    @SerializedName("user_base_map")
    protected Map<Long, l0> userBaseMap;

    public k0() {
    }

    public final Map<String, l0> a() {
        return this.openUserBaseMap;
    }

    public k0(am3.g r110) {
        this.userBaseMap = new HashMap();
        this.openUserBaseMap = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L42;
        Object r102 = null;
        if (r101 == 1) goto L26;
        if (r101 != 5000) goto L9;
        long r103 = r110.c();
        l0 r104 = null;
    L11:
        int r111 = r110.f();
        if (r111 == (-1)) goto L18;
        if (r111 != 1) goto L14;
        r102 = am3.h.c(r110);
        goto L11
    L14:
        if (r111 != 2) goto L15;
        r104 = new l0(r110);
        goto L11
    L15:
        am3.h.e(r110);
        goto L11
    L18:
        r110.d(r103);
        Map r105 = this.openUserBaseMap;
        if (r102 == null) goto L25;
        if (r104 == null) goto L23;
    L37:
        r105.put(r102, r104);
        goto L3
    L23:
        throw new IllegalStateException("Value must not be null");
    L25:
        throw new IllegalStateException("Key must not be null");
    L9:
        am3.h.e(r110);
        goto L3
    L26:
        long r106 = r110.c();
        r104 = null;
    L27:
        int r112 = r110.f();
        if (r112 == (-1)) goto L34;
        if (r112 != 1) goto L30;
        r102 = Long.valueOf(r110.j());
        goto L27
    L30:
        if (r112 != 2) goto L31;
        r104 = new l0(r110);
        goto L27
    L31:
        am3.h.e(r110);
        goto L27
    L34:
        r110.d(r106);
        r105 = this.userBaseMap;
        if (r102 == null) goto L41;
        if (r104 != null) goto L37;
        throw new IllegalStateException("Value must not be null");
    L41:
        throw new IllegalStateException("Key must not be null");
    L42:
        r110.d(r100);
    }
}
