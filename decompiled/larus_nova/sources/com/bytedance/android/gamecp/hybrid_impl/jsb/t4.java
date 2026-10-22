package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/gamecp/hybrid_impl/jsb/t4;", "", "", "game_id", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setGame_id", "(Ljava/lang/String;)V", "room_id", "e", "setRoom_id", "anchor_id", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setAnchor_id", "enter_from", "c", "setEnter_from", "start_page", "f", "setStart_page", com.bytedance.android.ec.core.event.a.KEY_COUPON_TYPE, "b", "setCoupon_type", "<init>", "()V", "gamecp-hybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class t4 {

    @SerializedName("anchor_id")
    private String anchor_id;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_COUPON_TYPE)
    private String coupon_type;

    @SerializedName("enter_from")
    private String enter_from;

    @SerializedName("game_id")
    private String game_id;

    @SerializedName("room_id")
    private String room_id;

    @SerializedName("start_page")
    private String start_page;

    public t4() {
    }

    public final String a() {
        return this.anchor_id;
    }

    public final String b() {
        return this.coupon_type;
    }

    public final String c() {
        return this.enter_from;
    }

    public final String d() {
        return this.game_id;
    }

    public final String e() {
        return this.room_id;
    }

    public final String f() {
        return this.start_page;
    }
}
