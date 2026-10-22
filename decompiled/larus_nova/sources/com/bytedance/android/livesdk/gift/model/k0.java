package com.bytedance.android.livesdk.gift.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0011\bg\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\"R&\u0010\n\u001a\u00060\u0002j\u0002`\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u0011\u001a\u00020\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\t\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001c\u001a\u00020\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\t\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000fR\"\u0010 \u001a\u00020\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001f\u0010\t\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/k0;", "Lvh7/c;", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getLockStatus", "()J", "setLockStatus", "(J)V", "getLockStatus$annotations", "()V", "lockStatus", "", "getClientBlockUseSchemeUrl", "()Z", "setClientBlockUseSchemeUrl", "(Z)V", "getClientBlockUseSchemeUrl$annotations", "clientBlockUseSchemeUrl", "", "getBlockSchemeUrl", "()Ljava/lang/String;", "setBlockSchemeUrl", "(Ljava/lang/String;)V", "getBlockSchemeUrl$annotations", "blockSchemeUrl", "getClientCheckLeftDiamond", "setClientCheckLeftDiamond", "getClientCheckLeftDiamond$annotations", "clientCheckLeftDiamond", "getBlockToast", "setBlockToast", "getBlockToast$annotations", "blockToast", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface k0 extends vh7.c<k0> {
    public static final a Companion = null;
    public static final long LOCKED_GRAY = 0;
    public static final long LOCKED_NORMAL = 0;
    public static final long UNLOCKED = 0;

    public static final class a {
        public a() {
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "block_scheme_url")
    String getBlockSchemeUrl();

    @FieldName(name = "block_toast")
    String getBlockToast();

    @FieldName(name = "client_block_use_scheme_url")
    boolean getClientBlockUseSchemeUrl();

    @FieldName(name = "client_check_left_diamond")
    boolean getClientCheckLeftDiamond();

    @FieldName(name = "lock_status")
    long getLockStatus();

    @FieldName(name = "block_scheme_url#setter")
    void setBlockSchemeUrl(String r100);

    @FieldName(name = "block_toast#setter")
    void setBlockToast(String r100);

    @FieldName(name = "client_block_use_scheme_url#setter")
    void setClientBlockUseSchemeUrl(boolean r100);

    @FieldName(name = "client_check_left_diamond#setter")
    void setClientCheckLeftDiamond(boolean r100);

    @FieldName(name = "lock_status#setter")
    void setLockStatus(long r100);

    static {
        Companion = new a();
        UNLOCKED = 0;
        LOCKED_GRAY = 1;
        LOCKED_NORMAL = 2;
    }
}
