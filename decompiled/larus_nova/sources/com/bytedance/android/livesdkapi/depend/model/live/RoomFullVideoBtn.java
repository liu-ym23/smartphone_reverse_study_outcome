package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import py.k;
import r27.a;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.RoomFullVideoBTN")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomFullVideoBtn;", "", "Lpy/k;", "icon", "Lpy/k;", "getIcon", "()Lpy/k;", "setIcon", "(Lpy/k;)V", "disableIcon", "getDisableIcon", "setDisableIcon", "", "show", "I", "getShow", "()I", "setShow", "(I)V", "showType", "getShowType", "setShowType", "<init>", "()V", "FullVideoBtnShow", "FullVideoBtnShowType", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomFullVideoBtn implements h {

    @SerializedName("disable_icon")
    protected k disableIcon;

    @SerializedName("icon")
    protected k icon;

    @SerializedName("show")
    protected int show;

    @SerializedName("show_type")
    protected int showType;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomFullVideoBtn$FullVideoBtnShow;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "is_Default", "is_Open", "is_Close", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum FullVideoBtnShow extends Enum<FullVideoBtnShow> {
        private static final /* synthetic */ FullVideoBtnShow[] $VALUES = null;
        public static final FullVideoBtnShow is_Close = null;
        public static final FullVideoBtnShow is_Default = null;
        public static final FullVideoBtnShow is_Open = null;
        private final int type;

        static {
            FullVideoBtnShow r100 = new FullVideoBtnShow("is_Default", 0, 0);
            is_Default = r100;
            FullVideoBtnShow r101 = new FullVideoBtnShow("is_Open", 1, 1);
            is_Open = r101;
            FullVideoBtnShow r102 = new FullVideoBtnShow("is_Close", 2, 2);
            is_Close = r102;
            $VALUES = new FullVideoBtnShow[]{r100, r101, r102};
        }

        public static FullVideoBtnShow valueOf(String r100) {
            return (FullVideoBtnShow) a.a(FullVideoBtnShow.class, r100);
        }

        public static FullVideoBtnShow[] values() {
            return (FullVideoBtnShow[]) $VALUES.clone();
        }

        public final int getType() {
            return this.type;
        }

        private FullVideoBtnShow(String r100, int r101, int r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomFullVideoBtn$FullVideoBtnShowType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "is_Default", "is_All_VISIBLE", "is_AUTO_DISMISS", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum FullVideoBtnShowType extends Enum<FullVideoBtnShowType> {
        private static final /* synthetic */ FullVideoBtnShowType[] $VALUES = null;
        public static final FullVideoBtnShowType is_AUTO_DISMISS = null;
        public static final FullVideoBtnShowType is_All_VISIBLE = null;
        public static final FullVideoBtnShowType is_Default = null;
        private final int type;

        static {
            FullVideoBtnShowType r100 = new FullVideoBtnShowType("is_Default", 0, 0);
            is_Default = r100;
            FullVideoBtnShowType r101 = new FullVideoBtnShowType("is_All_VISIBLE", 1, 1);
            is_All_VISIBLE = r101;
            FullVideoBtnShowType r102 = new FullVideoBtnShowType("is_AUTO_DISMISS", 2, 2);
            is_AUTO_DISMISS = r102;
            $VALUES = new FullVideoBtnShowType[]{r100, r101, r102};
        }

        public static FullVideoBtnShowType valueOf(String r100) {
            return (FullVideoBtnShowType) a.a(FullVideoBtnShowType.class, r100);
        }

        public static FullVideoBtnShowType[] values() {
            return (FullVideoBtnShowType[]) $VALUES.clone();
        }

        public final int getType() {
            return this.type;
        }

        private FullVideoBtnShowType(String r100, int r101, int r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    public RoomFullVideoBtn() {
    }

    public final k getDisableIcon() {
        return this.disableIcon;
    }

    public final k getIcon() {
        return this.icon;
    }

    public final int getShow() {
        return this.show;
    }

    public final int getShowType() {
        return this.showType;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, py.k] */
    public RoomFullVideoBtn(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.show = (int) r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.icon = f.a(r100, k.class);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.disableIcon = f.a(r100, k.class);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.showType = (int) r100.j();
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }

    public final void setDisableIcon(k r100) {
        this.disableIcon = r100;
    }

    public final void setIcon(k r100) {
        this.icon = r100;
    }

    public final void setShow(int r100) {
        this.show = r100;
    }

    public final void setShowType(int r100) {
        this.showType = r100;
    }
}
