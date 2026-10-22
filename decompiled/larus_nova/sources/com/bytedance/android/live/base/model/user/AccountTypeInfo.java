package com.bytedance.android.live.base.model.user;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.data.User.AuthenticationInfo.AccountTypeInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0007\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001\u000fB\u0007¢\u0006\u0004\b\f\u0010\rR0\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/base/model/user/AccountTypeInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lpy/a;", "", "", "", "typeMap", "Ljava/util/Map;", "getTypeMap", "()Ljava/util/Map;", "setTypeMap", "(Ljava/util/Map;)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AccountTypeInfo extends FlexModelBase<py.a> implements py.a, vh7.h {
    public static final a Companion = null;
    public static final long mediaType = 1;

    @SerializedName("account_type_map")
    protected Map<Long, Boolean> typeMap;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public AccountTypeInfo() {
        super(py.a.class);
    }

    @Override // py.a
    public Map<Long, Boolean> getTypeMap() {
        return this.typeMap;
    }

    public AccountTypeInfo(am3.g r110) {
        super(py.a.class);
        this.typeMap = new HashMap();
        setThreadSafe(false);
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L25;
        am3.g.a r102 = decodeExtensionFields(r101, r110);
        if (r101 != 1) goto L7;
        long r103 = r110.c();
        Long r104 = null;
        Boolean r105 = null;
    L9:
        int r106 = r110.f();
        if (r106 == (-1)) goto L17;
        if (r106 != 1) goto L13;
        r104 = Long.valueOf(r110.j());
        goto L9
    L13:
        if (r106 != 2) goto L14;
        r105 = Boolean.valueOf(am3.h.a(r110));
        goto L9
    L14:
        am3.h.e(r110);
        goto L9
    L17:
        r110.d(r103);
        Map<Long, Boolean> r107 = this.typeMap;
        if (r104 == null) goto L24;
        if (r105 == null) goto L22;
        r107.put(r104, r105);
        goto L3
    L22:
        throw new IllegalStateException("Value must not be null");
    L24:
        throw new IllegalStateException("Key must not be null");
    L7:
        am3.h.d(r102, r110);
        goto L3
    L25:
        r110.d(r100);
        setThreadSafe(true);
    }

    public void setTypeMap(Map<Long, Boolean> r100) {
        this.typeMap = r100;
    }
}
