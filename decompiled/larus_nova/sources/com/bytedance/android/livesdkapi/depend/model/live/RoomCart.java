package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.RoomCart")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0004;<=>B\u0005¢\u0006\u0002\u0010\u0003J&\u00104\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010605j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u000106`7J&\u00108\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u000206\u0018\u000105j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u000206\u0018\u0001`7J\u0006\u00109\u001a\u00020\u000eJ&\u0010:\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u000206\u0018\u000105j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u000206\u0018\u0001`7R&\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\bR\u0014\u0010\u0018\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0010R \u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R \u0010#\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0012\u0010)\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u0010R\u0014\u0010,\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u0010R \u0010.\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u0006?"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomCart;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomCart;", "()V", "_cartIcon", "", "get_cartIcon$annotations", "get_cartIcon", "()Ljava/lang/String;", "set_cartIcon", "(Ljava/lang/String;)V", "_containCart", "", "_flashTotal", "", "get_flashTotal", "()I", "set_flashTotal", "(I)V", "_total", "get_total", "set_total", "cartIcon", "getCartIcon", "containCart", "getContainCart", "()Z", "flashTotal", "getFlashTotal", "horizontal", "Lcom/bytedance/android/livesdkapi/depend/model/live/RoomCart$RoomCartStateHorizontal;", "getHorizontal", "()Lcom/bytedance/android/livesdkapi/depend/model/live/RoomCart$RoomCartStateHorizontal;", "setHorizontal", "(Lcom/bytedance/android/livesdkapi/depend/model/live/RoomCart$RoomCartStateHorizontal;)V", "roomCartIcons", "Lcom/bytedance/android/livesdkapi/depend/model/live/RoomCart$RoomCartIcons;", "getRoomCartIcons", "()Lcom/bytedance/android/livesdkapi/depend/model/live/RoomCart$RoomCartIcons;", "setRoomCartIcons", "(Lcom/bytedance/android/livesdkapi/depend/model/live/RoomCart$RoomCartIcons;)V", "showCart", "showCartExt", "getShowCartExt", "total", "getTotal", "vertical", "Lcom/bytedance/android/livesdkapi/depend/model/live/RoomCart$RoomCartStateVertical;", "getVertical", "()Lcom/bytedance/android/livesdkapi/depend/model/live/RoomCart$RoomCartStateVertical;", "setVertical", "(Lcom/bytedance/android/livesdkapi/depend/model/live/RoomCart$RoomCartStateVertical;)V", "getCartStyleMap", "Ljava/util/HashMap;", "Ljava/io/Serializable;", "Lkotlin/collections/HashMap;", "getHorizontalMap", "getShowCart", "getVerticalMap", "RoomCartIcons", "RoomCartState", "RoomCartStateHorizontal", "RoomCartStateVertical", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomCart extends FlexModelBase<IRoomCart> implements IRoomCart, h {

    @SerializedName("cart_icon")
    protected String _cartIcon;

    @SerializedName("contain_cart")
    public boolean _containCart;

    @SerializedName("flash_total")
    protected int _flashTotal;

    @SerializedName("total")
    protected int _total;

    @SerializedName("horizontal")
    protected RoomCartStateHorizontal horizontal;

    @SerializedName("global_custom_icons")
    protected RoomCartIcons roomCartIcons;

    @SerializedName("show_cart")
    public int showCart;

    @SerializedName("vertical")
    protected RoomCartStateVertical vertical;

    @ProtoMessage("webcast.data.GlobalCustomIcons")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomCart$RoomCartIcons;", "", "()V", "animatedCommonIconUrl", "", "getAnimatedCommonIconUrl", "()Ljava/lang/String;", "setAnimatedCommonIconUrl", "(Ljava/lang/String;)V", "animatedIconUrl", "getAnimatedIconUrl", "setAnimatedIconUrl", "staticIconUrl", "getStaticIconUrl", "setStaticIconUrl", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static class RoomCartIcons implements h {

        @SerializedName("animated_common_icon_url")
        protected String animatedCommonIconUrl;

        @SerializedName("animated_icon_url")
        protected String animatedIconUrl;

        @SerializedName("static_icon_url")
        protected String staticIconUrl;

        public RoomCartIcons() {
        }

        public RoomCartIcons(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L15;
            if (r102 != 1) goto L8;
            this.staticIconUrl = am3.h.c(r100);
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.animatedIconUrl = am3.h.c(r100);
            goto L3
        L10:
            if (r102 != 3) goto L11;
            this.animatedCommonIconUrl = am3.h.c(r100);
            goto L3
        L11:
            am3.h.e(r100);
            goto L3
        L15:
            r100.d(r101);
        }

        public final String getAnimatedCommonIconUrl() {
            return this.animatedCommonIconUrl;
        }

        public final String getAnimatedIconUrl() {
            return this.animatedIconUrl;
        }

        public final String getStaticIconUrl() {
            return this.staticIconUrl;
        }

        public final void setAnimatedCommonIconUrl(String r100) {
            this.animatedCommonIconUrl = r100;
        }

        public final void setAnimatedIconUrl(String r100) {
            this.animatedIconUrl = r100;
        }

        public final void setStaticIconUrl(String r100) {
            this.staticIconUrl = r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomCart$RoomCartState;", "", "()V", "allowShowCart", "", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static class RoomCartState {

        @SerializedName("allow_show_cart")
        public boolean allowShowCart;

        public RoomCartState() {
        }
    }

    @ProtoMessage("webcast.data.CartHorizontal")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomCart$RoomCartStateHorizontal;", "Lcom/bytedance/android/livesdkapi/depend/model/live/RoomCart$RoomCartState;", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class RoomCartStateHorizontal extends RoomCartState implements h {
        public RoomCartStateHorizontal() {
        }

        public RoomCartStateHorizontal(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L9;
            if (r102 != 1) goto L7;
            this.allowShowCart = am3.h.a(r100);
            goto L3
        L7:
            am3.h.e(r100);
            goto L3
        L9:
            r100.d(r101);
        }
    }

    @ProtoMessage("webcast.data.CartVertical")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomCart$RoomCartStateVertical;", "Lcom/bytedance/android/livesdkapi/depend/model/live/RoomCart$RoomCartState;", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class RoomCartStateVertical extends RoomCartState implements h {
        public RoomCartStateVertical() {
        }

        public RoomCartStateVertical(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L9;
            if (r102 != 1) goto L7;
            this.allowShowCart = am3.h.a(r100);
            goto L3
        L7:
            am3.h.e(r100);
            goto L3
        L9:
            r100.d(r101);
        }
    }

    public RoomCart() {
        super(IRoomCart.class);
    }

    @Deprecated(message = "使用 roomCartIcons 来控制")
    public static /* synthetic */ void get_cartIcon$annotations() {
    }

    public final HashMap<String, Serializable> getCartStyleMap() {
        HashMap<String, Serializable> r100 = new HashMap();
        RoomCartIcons r101 = this.roomCartIcons;
        if (r101 == null) goto L5;
        Intrinsics.checkNotNull(r101);
        r100.put("static_icon_url", r101.getStaticIconUrl());
        RoomCartIcons r102 = this.roomCartIcons;
        Intrinsics.checkNotNull(r102);
        r100.put("animated_icon_url", r102.getAnimatedIconUrl());
        RoomCartIcons r103 = this.roomCartIcons;
        Intrinsics.checkNotNull(r103);
        r100.put("animated_common_icon_url", r103.getAnimatedCommonIconUrl());
    L5:
        return r100;
    }

    public final HashMap<String, Serializable> getHorizontalMap() {
        HashMap<String, Serializable> r100 = new HashMap();
        RoomCartStateHorizontal r101 = this.horizontal;
        if (r101 == null) goto L5;
        Intrinsics.checkNotNull(r101);
        r100.put("allow_show_cart", Boolean.valueOf(r101.allowShowCart));
    L5:
        return r100;
    }

    public final HashMap<String, Serializable> getVerticalMap() {
        HashMap<String, Serializable> r100 = new HashMap();
        RoomCartStateVertical r101 = this.vertical;
        if (r101 == null) goto L5;
        Intrinsics.checkNotNull(r101);
        r100.put("allow_show_cart", Boolean.valueOf(r101.allowShowCart));
    L5:
        return r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomCart
    public String getCartIcon() {
        return this._cartIcon;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomCart
    public boolean getContainCart() {
        return this._containCart;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomCart
    public int getFlashTotal() {
        return this._flashTotal;
    }

    public final RoomCartStateHorizontal getHorizontal() {
        return this.horizontal;
    }

    public final RoomCartIcons getRoomCartIcons() {
        return this.roomCartIcons;
    }

    public final int getShowCart() {
        return this.showCart;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomCart
    public int getShowCartExt() {
        return this.showCart;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomCart
    public int getTotal() {
        return this._total;
    }

    public final RoomCartStateVertical getVertical() {
        return this.vertical;
    }

    public final String get_cartIcon() {
        return this._cartIcon;
    }

    public final int get_flashTotal() {
        return this._flashTotal;
    }

    public final int get_total() {
        return this._total;
    }

    public RoomCart(g r100) {
        super(IRoomCart.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L16;
        g.a r103 = decodeExtensionFields(r102, r100);
        switch(r102) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            default: goto L7;
        };
    L8:
        this.roomCartIcons = new RoomCartIcons(r100);
        goto L3
    L9:
        this.horizontal = new RoomCartStateHorizontal(r100);
        goto L3
    L10:
        this.vertical = new RoomCartStateVertical(r100);
        goto L3
    L11:
        this.showCart = r100.i();
        goto L3
    L12:
        this._cartIcon = am3.h.c(r100);
        goto L3
    L13:
        this._flashTotal = (int) r100.j();
        goto L3
    L14:
        this._total = (int) r100.j();
        goto L3
    L15:
        this._containCart = am3.h.a(r100);
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L16:
        r100.d(r101);
        setThreadSafe(true);
    }

    public final void setHorizontal(RoomCartStateHorizontal r100) {
        this.horizontal = r100;
    }

    public final void setRoomCartIcons(RoomCartIcons r100) {
        this.roomCartIcons = r100;
    }

    public final void setVertical(RoomCartStateVertical r100) {
        this.vertical = r100;
    }

    public final void set_cartIcon(String r100) {
        this._cartIcon = r100;
    }

    public final void set_flashTotal(int r100) {
        this._flashTotal = r100;
    }

    public final void set_total(int r100) {
        this._total = r100;
    }
}
