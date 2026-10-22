package com.bytedance.android.live.browser.jsbridge.base;

import com.amap.api.col.s.ce;
import com.bytedance.android.livesdk.gift.model.n;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import e7.j0;
import e7.k0;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0005\u0012\u0007\u000e\u0013\u0014B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetSelectGiftInfoResultModel;", "Le7/k0;", "Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetSelectGiftInfoResultModel$Code;", "code", "Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetSelectGiftInfoResultModel$Code;", "getCode", "()Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetSelectGiftInfoResultModel$Code;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetSelectGiftInfoResultModel$Code;)V", "Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetSelectGiftInfoResultModel$b;", "data", "Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetSelectGiftInfoResultModel$b;", "getData", "()Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetSelectGiftInfoResultModel$b;", "b", "(Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetSelectGiftInfoResultModel$b;)V", "<init>", "()V", "Code", "c", "d", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveGetSelectGiftInfoResultModel implements k0 {

    @SerializedName("code")
    private Code code;

    @SerializedName("data")
    private b data;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetSelectGiftInfoResultModel$Code;", "", "Le7/j0;", "", "getCode", "value", "I", "getValue", "()I", "Success", "Failed", "NO_PERMISSION", "NOT_REGISTER", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Code extends Enum<Code> implements j0 {
        public static final Code Failed = null;
        public static final Code NOT_REGISTER = null;
        public static final Code NO_PERMISSION = null;
        public static final Code Success = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Code[] f63062a = null;
        private final int value;

        static {
            Code r100 = new Code("Success", 0, 1);
            Success = r100;
            Code r101 = new Code("Failed", 1, 0);
            Failed = r101;
            Code r102 = new Code("NO_PERMISSION", 2, -1);
            NO_PERMISSION = r102;
            Code r103 = new Code("NOT_REGISTER", 3, -2);
            NOT_REGISTER = r103;
            f63062a = new Code[]{r100, r101, r102, r103};
        }

        public static Code valueOf(String r100) {
            return (Code) r27.a.a(Code.class, r100);
        }

        public static Code[] values() {
            return (Code[]) f63062a.clone();
        }

        @Override // e7.j0
        public int getCode() {
            return this.value;
        }

        public final int getValue() {
            return this.value;
        }

        public Code(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0004\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetSelectGiftInfoResultModel$a;", "", "", "buffLevel", "Ljava/lang/Number;", "getBuffLevel", "()Ljava/lang/Number;", "d", "(Ljava/lang/Number;)V", "buffGiftId", "getBuffGiftId", "b", "buffDiamondCount", "getBuffDiamondCount", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "buffIcon", "Ljava/lang/String;", "getBuffIcon", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("buffDiamondCount")
        private Number buffDiamondCount;

        @SerializedName("buffGiftId")
        private Number buffGiftId;

        @SerializedName("buffIcon")
        private String buffIcon;

        @SerializedName("buffLevel")
        private Number buffLevel;

        public a() {
        }

        public final void a(Number r100) {
            this.buffDiamondCount = r100;
        }

        public final void b(Number r100) {
            this.buffGiftId = r100;
        }

        public final void c(String r100) {
            this.buffIcon = r100;
        }

        public final void d(Number r100) {
            this.buffLevel = r100;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0004\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b*\u0010+R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetSelectGiftInfoResultModel$b;", "", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", ce.f26391f, "(Ljava/lang/String;)V", "", "giftId", "Ljava/lang/Number;", "getGiftId", "()Ljava/lang/Number;", "e", "(Ljava/lang/Number;)V", "icon", "getIcon", "f", "diamondCount", "getDiamondCount", "c", "type", "getType", "h", "describe", "getDescribe", "b", "Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetSelectGiftInfoResultModel$a;", "buffInfo", "Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetSelectGiftInfoResultModel$a;", "getBuffInfo", "()Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetSelectGiftInfoResultModel$a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetSelectGiftInfoResultModel$a;)V", "Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetSelectGiftInfoResultModel$c;", "diyCardInfo", "Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetSelectGiftInfoResultModel$c;", "getDiyCardInfo", "()Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetSelectGiftInfoResultModel$c;", "d", "(Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetSelectGiftInfoResultModel$c;)V", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("buffInfo")
        private a buffInfo;

        @SerializedName("describe")
        private String describe;

        @SerializedName("diamondCount")
        private Number diamondCount;

        @SerializedName("diyCardInfo")
        private c diyCardInfo;

        @SerializedName("giftId")
        private Number giftId;

        @SerializedName("icon")
        private String icon;

        @SerializedName("name")
        private String name;

        @SerializedName("type")
        private Number type;

        public b() {
        }

        public final Number getType() {
            return this.type;
        }

        public final void a(a r100) {
            this.buffInfo = r100;
        }

        public final void b(String r100) {
            this.describe = r100;
        }

        public final void c(Number r100) {
            this.diamondCount = r100;
        }

        public final void d(c r100) {
            this.diyCardInfo = r100;
        }

        public final void e(Number r100) {
            this.giftId = r100;
        }

        public final void f(String r100) {
            this.icon = r100;
        }

        public final void g(String r100) {
            this.name = r100;
        }

        public final void h(Number r100) {
            this.type = r100;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0004\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010%R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR*\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetSelectGiftInfoResultModel$c;", "", "", n.KEY_MAIN_TEXT, "Ljava/lang/String;", "getMainText", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", n.KEY_SUB_TEXT, "getSubText", "f", "giftCellIcon", "getGiftCellIcon", "b", "localIconBitmap", "getLocalIconBitmap", "c", "", n.KEY_TOTAL_DIAMONDS, "Ljava/lang/Number;", "getTotalDiamonds", "()Ljava/lang/Number;", ce.f26391f, "(Ljava/lang/Number;)V", "cardName", "getCardName", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetSelectGiftInfoResultModel$d;", n.KEY_PLUGINS, "Ljava/util/List;", "getPlugins", "()Ljava/util/List;", "e", "(Ljava/util/List;)V", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("cardName")
        private String cardName;

        @SerializedName("giftCellIcon")
        private String giftCellIcon;

        @SerializedName("localIconBitmap")
        private String localIconBitmap;

        @SerializedName(n.KEY_MAIN_TEXT)
        private String mainText;

        @SerializedName(n.KEY_PLUGINS)
        private List<d> plugins;

        @SerializedName(n.KEY_SUB_TEXT)
        private String subText;

        @SerializedName(n.KEY_TOTAL_DIAMONDS)
        private Number totalDiamonds;

        public c() {
        }

        public final void a(String r100) {
            this.cardName = r100;
        }

        public final void b(String r100) {
            this.giftCellIcon = r100;
        }

        public final void c(String r100) {
            this.localIconBitmap = r100;
        }

        public final void d(String r100) {
            this.mainText = r100;
        }

        public final void e(List<d> r100) {
            this.plugins = r100;
        }

        public final void f(String r100) {
            this.subText = r100;
        }

        public final void g(Number r100) {
            this.totalDiamonds = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0004\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetSelectGiftInfoResultModel$d;", "", "", "pluginId", "Ljava/lang/Number;", "getPluginId", "()Ljava/lang/Number;", "b", "(Ljava/lang/Number;)V", "", "itemPotentialValueHint", "Ljava/lang/String;", "getItemPotentialValueHint", "()Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Ljava/lang/String;)V", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class d {

        @SerializedName("itemPotentialValueHint")
        private String itemPotentialValueHint;

        @SerializedName("pluginId")
        private Number pluginId;

        public d() {
        }

        public final void a(String r100) {
            this.itemPotentialValueHint = r100;
        }

        public final void b(Number r100) {
            this.pluginId = r100;
        }
    }

    public LiveGetSelectGiftInfoResultModel() {
    }

    public final void a(Code r100) {
        this.code = r100;
    }

    public final void b(b r100) {
        this.data = r100;
    }
}
