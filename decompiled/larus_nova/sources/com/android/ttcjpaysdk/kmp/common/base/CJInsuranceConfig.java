package com.android.ttcjpaysdk.kmp.common.base;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import juc.d;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import luc.f;
import nuc.b2;
import nuc.q2;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 L2\u00020\u0001:\u0002KLB\u007f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011B\u008f\u0001\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0010\u0010\u0016J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\t\u0010:\u001a\u00020\u0005HÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\u0081\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010?\u001a\u00020\u00032\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010A\u001a\u00020\u0013HÖ\u0001J\t\u0010B\u001a\u00020\u0005HÖ\u0001J%\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u00002\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020IH\u0001¢\u0006\u0002\bJR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001eR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001c\"\u0004\b(\u0010\u001eR\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010\u001eR\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001c\"\u0004\b,\u0010\u001eR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001c\"\u0004\b.\u0010\u001eR\u001a\u0010\u000e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001c\"\u0004\b0\u0010\u001eR\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0018\"\u0004\b1\u0010\u001a¨\u0006M"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/base/CJInsuranceConfig;", "", "show", "", "light_icon", "", "dark_icon", "new_light_icon", "new_dark_icon", "keyboard_icon", "keyboard_denoise_icon", "new_keyboard_denoise_icon", "light_amount_keyboard_icon", "dark_amount_keyboard_icon", "unified_keyboard_icon", "is_no_show_douyin_logo", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getShow", "()Z", "setShow", "(Z)V", "getLight_icon", "()Ljava/lang/String;", "setLight_icon", "(Ljava/lang/String;)V", "getDark_icon", "setDark_icon", "getNew_light_icon", "setNew_light_icon", "getNew_dark_icon", "setNew_dark_icon", "getKeyboard_icon", "setKeyboard_icon", "getKeyboard_denoise_icon", "setKeyboard_denoise_icon", "getNew_keyboard_denoise_icon", "setNew_keyboard_denoise_icon", "getLight_amount_keyboard_icon", "setLight_amount_keyboard_icon", "getDark_amount_keyboard_icon", "setDark_amount_keyboard_icon", "getUnified_keyboard_icon", "setUnified_keyboard_icon", "set_no_show_douyin_logo", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cj_common_release", "$serializer", "Companion", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class CJInsuranceConfig {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private String dark_amount_keyboard_icon;
    private String dark_icon;
    private boolean is_no_show_douyin_logo;
    private String keyboard_denoise_icon;
    private String keyboard_icon;
    private String light_amount_keyboard_icon;
    private String light_icon;
    private String new_dark_icon;
    private String new_keyboard_denoise_icon;
    private String new_light_icon;
    private boolean show;
    private String unified_keyboard_icon;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/base/CJInsuranceConfig$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/android/ttcjpaysdk/kmp/common/base/CJInsuranceConfig;", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<CJInsuranceConfig> serializer() {
            return CJInsuranceConfig$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    public CJInsuranceConfig() {
        this(false, null, null, null, null, null, null, null, null, null, null, false, UnixStat.PERM_MASK, null);
    }

    public static /* synthetic */ CJInsuranceConfig copy$default(CJInsuranceConfig r110, boolean r111, String r112, String r113, String r114, String r115, String r116, String r210, String r211, String r212, String r213, String r214, boolean r215, int r216, Object r217) {
        if ((r216 & 1) == 0) goto L5;
        boolean r100 = r110.show;
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r101 = r110.light_icon;
    L11:
        if ((r216 & 4) == 0) goto L13;
        String r102 = r110.dark_icon;
    L15:
        if ((r216 & 8) == 0) goto L17;
        String r103 = r110.new_light_icon;
    L19:
        if ((r216 & 16) == 0) goto L21;
        String r104 = r110.new_dark_icon;
    L23:
        if ((r216 & 32) == 0) goto L25;
        String r105 = r110.keyboard_icon;
    L27:
        if ((r216 & 64) == 0) goto L29;
        String r106 = r110.keyboard_denoise_icon;
    L31:
        if ((r216 & 128) == 0) goto L33;
        String r107 = r110.new_keyboard_denoise_icon;
    L35:
        if ((r216 & 256) == 0) goto L37;
        String r117 = r110.light_amount_keyboard_icon;
    L39:
        if ((r216 & 512) == 0) goto L41;
        String r118 = r110.dark_amount_keyboard_icon;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        String r119 = r110.unified_keyboard_icon;
    L47:
        if ((r216 & 2048) == 0) goto L49;
        boolean r108 = r110.is_no_show_douyin_logo;
    L51:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r117, r118, r119, r108);
    L49:
        r108 = r215;
        goto L51
    L45:
        r119 = r214;
        goto L47
    L41:
        r118 = r213;
        goto L43
    L37:
        r117 = r212;
        goto L39
    L33:
        r107 = r211;
        goto L35
    L29:
        r106 = r210;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final boolean component1() {
        return this.show;
    }

    public final String component10() {
        return this.dark_amount_keyboard_icon;
    }

    public final String component11() {
        return this.unified_keyboard_icon;
    }

    public final boolean component12() {
        return this.is_no_show_douyin_logo;
    }

    public final String component2() {
        return this.light_icon;
    }

    public final String component3() {
        return this.dark_icon;
    }

    public final String component4() {
        return this.new_light_icon;
    }

    public final String component5() {
        return this.new_dark_icon;
    }

    public final String component6() {
        return this.keyboard_icon;
    }

    public final String component7() {
        return this.keyboard_denoise_icon;
    }

    public final String component8() {
        return this.new_keyboard_denoise_icon;
    }

    public final String component9() {
        return this.light_amount_keyboard_icon;
    }

    public final CJInsuranceConfig copy(boolean r110, String r111, String r112, String r113, String r114, String r210, String r211, String r212, String r213, String r214, String r215, boolean r216) {
        Intrinsics.checkNotNullParameter(r111, "light_icon");
        Intrinsics.checkNotNullParameter(r112, "dark_icon");
        Intrinsics.checkNotNullParameter(r113, "new_light_icon");
        Intrinsics.checkNotNullParameter(r114, "new_dark_icon");
        Intrinsics.checkNotNullParameter(r210, "keyboard_icon");
        Intrinsics.checkNotNullParameter(r211, "keyboard_denoise_icon");
        Intrinsics.checkNotNullParameter(r212, "new_keyboard_denoise_icon");
        Intrinsics.checkNotNullParameter(r213, "light_amount_keyboard_icon");
        Intrinsics.checkNotNullParameter(r214, "dark_amount_keyboard_icon");
        Intrinsics.checkNotNullParameter(r215, "unified_keyboard_icon");
        return new CJInsuranceConfig(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJInsuranceConfig) == true) goto L8;
        return false;
    L8:
        CJInsuranceConfig r101 = (CJInsuranceConfig) r100;
        if (this.show == r101.show) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.light_icon, r101.light_icon) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.dark_icon, r101.dark_icon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.new_light_icon, r101.new_light_icon) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.new_dark_icon, r101.new_dark_icon) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.keyboard_icon, r101.keyboard_icon) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.keyboard_denoise_icon, r101.keyboard_denoise_icon) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.new_keyboard_denoise_icon, r101.new_keyboard_denoise_icon) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.light_amount_keyboard_icon, r101.light_amount_keyboard_icon) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.dark_amount_keyboard_icon, r101.dark_amount_keyboard_icon) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.unified_keyboard_icon, r101.unified_keyboard_icon) == true) goto L42;
        return false;
    L42:
        if (this.is_no_show_douyin_logo == r101.is_no_show_douyin_logo) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.show == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((((((((((((((((((((r101 * 31) + this.light_icon.hashCode()) * 31) + this.dark_icon.hashCode()) * 31) + this.new_light_icon.hashCode()) * 31) + this.new_dark_icon.hashCode()) * 31) + this.keyboard_icon.hashCode()) * 31) + this.keyboard_denoise_icon.hashCode()) * 31) + this.new_keyboard_denoise_icon.hashCode()) * 31) + this.light_amount_keyboard_icon.hashCode()) * 31) + this.dark_amount_keyboard_icon.hashCode()) * 31) + this.unified_keyboard_icon.hashCode()) * 31;
        if (this.is_no_show_douyin_logo == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "CJInsuranceConfig(show=" + this.show + ", light_icon=" + this.light_icon + ", dark_icon=" + this.dark_icon + ", new_light_icon=" + this.new_light_icon + ", new_dark_icon=" + this.new_dark_icon + ", keyboard_icon=" + this.keyboard_icon + ", keyboard_denoise_icon=" + this.keyboard_denoise_icon + ", new_keyboard_denoise_icon=" + this.new_keyboard_denoise_icon + ", light_amount_keyboard_icon=" + this.light_amount_keyboard_icon + ", dark_amount_keyboard_icon=" + this.dark_amount_keyboard_icon + ", unified_keyboard_icon=" + this.unified_keyboard_icon + ", is_no_show_douyin_logo=" + this.is_no_show_douyin_logo + ')';
    }

    public final String getDark_amount_keyboard_icon() {
        return this.dark_amount_keyboard_icon;
    }

    public final String getDark_icon() {
        return this.dark_icon;
    }

    public final String getKeyboard_denoise_icon() {
        return this.keyboard_denoise_icon;
    }

    public final String getKeyboard_icon() {
        return this.keyboard_icon;
    }

    public final String getLight_amount_keyboard_icon() {
        return this.light_amount_keyboard_icon;
    }

    public final String getLight_icon() {
        return this.light_icon;
    }

    public final String getNew_dark_icon() {
        return this.new_dark_icon;
    }

    public final String getNew_keyboard_denoise_icon() {
        return this.new_keyboard_denoise_icon;
    }

    public final String getNew_light_icon() {
        return this.new_light_icon;
    }

    public final boolean getShow() {
        return this.show;
    }

    public final String getUnified_keyboard_icon() {
        return this.unified_keyboard_icon;
    }

    public final boolean is_no_show_douyin_logo() {
        return this.is_no_show_douyin_logo;
    }

    public final void setDark_amount_keyboard_icon(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.dark_amount_keyboard_icon = r100;
    }

    public final void setDark_icon(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.dark_icon = r100;
    }

    public final void setKeyboard_denoise_icon(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.keyboard_denoise_icon = r100;
    }

    public final void setKeyboard_icon(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.keyboard_icon = r100;
    }

    public final void setLight_amount_keyboard_icon(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.light_amount_keyboard_icon = r100;
    }

    public final void setLight_icon(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.light_icon = r100;
    }

    public final void setNew_dark_icon(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.new_dark_icon = r100;
    }

    public final void setNew_keyboard_denoise_icon(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.new_keyboard_denoise_icon = r100;
    }

    public final void setNew_light_icon(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.new_light_icon = r100;
    }

    public final void setShow(boolean r100) {
        this.show = r100;
    }

    public final void setUnified_keyboard_icon(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.unified_keyboard_icon = r100;
    }

    public final void set_no_show_douyin_logo(boolean r100) {
        this.is_no_show_douyin_logo = r100;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$cj_common_release(CJInsuranceConfig r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeBooleanElement(r102, 0, r100.show);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeStringElement(r102, 1, r100.light_icon);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeStringElement(r102, 2, r100.dark_icon);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeStringElement(r102, 3, r100.new_light_icon);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r108 = true;
    L45:
        if (r108 == false) goto L48;
        r101.encodeStringElement(r102, 4, r100.new_dark_icon);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        boolean r109 = true;
    L54:
        if (r109 == false) goto L57;
        r101.encodeStringElement(r102, 5, r100.keyboard_icon);
    L57:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L60;
    L58:
        boolean r110 = true;
    L63:
        if (r110 == false) goto L66;
        r101.encodeStringElement(r102, 6, r100.keyboard_denoise_icon);
    L66:
        if (r101.shouldEncodeElementDefault(r102, 7) == false) goto L69;
    L67:
        boolean r111 = true;
    L72:
        if (r111 == false) goto L75;
        r101.encodeStringElement(r102, 7, r100.new_keyboard_denoise_icon);
    L75:
        if (r101.shouldEncodeElementDefault(r102, 8) == false) goto L78;
    L76:
        boolean r112 = true;
    L81:
        if (r112 == false) goto L84;
        r101.encodeStringElement(r102, 8, r100.light_amount_keyboard_icon);
    L84:
        if (r101.shouldEncodeElementDefault(r102, 9) == false) goto L87;
    L85:
        boolean r113 = true;
    L90:
        if (r113 == false) goto L93;
        r101.encodeStringElement(r102, 9, r100.dark_amount_keyboard_icon);
    L93:
        if (r101.shouldEncodeElementDefault(r102, 10) == false) goto L96;
    L94:
        boolean r114 = true;
    L99:
        if (r114 == false) goto L102;
        r101.encodeStringElement(r102, 10, r100.unified_keyboard_icon);
    L102:
        if (r101.shouldEncodeElementDefault(r102, 11) == false) goto L105;
    L103:
        r103 = true;
    L107:
        if (r103 == false) goto L110;
        r101.encodeBooleanElement(r102, 11, r100.is_no_show_douyin_logo);
        return;
    L110:
        return;
    L105:
        if (r100.is_no_show_douyin_logo == false) goto L107;
    L96:
        if (Intrinsics.areEqual(r100.unified_keyboard_icon, "") == false) goto L94;
        r114 = false;
        goto L99
    L87:
        if (Intrinsics.areEqual(r100.dark_amount_keyboard_icon, "") == false) goto L85;
        r113 = false;
        goto L90
    L78:
        if (Intrinsics.areEqual(r100.light_amount_keyboard_icon, "") == false) goto L76;
        r112 = false;
        goto L81
    L69:
        if (Intrinsics.areEqual(r100.new_keyboard_denoise_icon, "") == false) goto L67;
        r111 = false;
        goto L72
    L60:
        if (Intrinsics.areEqual(r100.keyboard_denoise_icon, "") == false) goto L58;
        r110 = false;
        goto L63
    L51:
        if (Intrinsics.areEqual(r100.keyboard_icon, "") == false) goto L49;
        r109 = false;
        goto L54
    L42:
        if (Intrinsics.areEqual(r100.new_dark_icon, "") == false) goto L40;
        r108 = false;
        goto L45
    L33:
        if (Intrinsics.areEqual(r100.new_light_icon, "") == false) goto L31;
        r107 = false;
        goto L36
    L24:
        if (Intrinsics.areEqual(r100.dark_icon, "") == false) goto L22;
        r106 = false;
        goto L27
    L15:
        if (Intrinsics.areEqual(r100.light_icon, "") == false) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.show == true) goto L4;
        r104 = false;
        goto L9
    }

    public CJInsuranceConfig(boolean r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, String r111, String r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r101, "light_icon");
        Intrinsics.checkNotNullParameter(r102, "dark_icon");
        Intrinsics.checkNotNullParameter(r103, "new_light_icon");
        Intrinsics.checkNotNullParameter(r104, "new_dark_icon");
        Intrinsics.checkNotNullParameter(r105, "keyboard_icon");
        Intrinsics.checkNotNullParameter(r106, "keyboard_denoise_icon");
        Intrinsics.checkNotNullParameter(r107, "new_keyboard_denoise_icon");
        Intrinsics.checkNotNullParameter(r110, "light_amount_keyboard_icon");
        Intrinsics.checkNotNullParameter(r111, "dark_amount_keyboard_icon");
        Intrinsics.checkNotNullParameter(r112, "unified_keyboard_icon");
        this.show = r100;
        this.light_icon = r101;
        this.dark_icon = r102;
        this.new_light_icon = r103;
        this.new_dark_icon = r104;
        this.keyboard_icon = r105;
        this.keyboard_denoise_icon = r106;
        this.new_keyboard_denoise_icon = r107;
        this.light_amount_keyboard_icon = r110;
        this.dark_amount_keyboard_icon = r111;
        this.unified_keyboard_icon = r112;
        this.is_no_show_douyin_logo = r113;
    }

    public /* synthetic */ CJInsuranceConfig(int r100, boolean r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, String r111, String r112, String r113, boolean r114, q2 r115) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, CJInsuranceConfig$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.show = false;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.light_icon = "";
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.dark_icon = "";
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.new_light_icon = "";
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.new_dark_icon = "";
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.keyboard_icon = "";
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.keyboard_denoise_icon = "";
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.new_keyboard_denoise_icon = "";
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.light_amount_keyboard_icon = "";
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.dark_amount_keyboard_icon = "";
    L45:
        if ((r100 & 1024) != 0) goto L47;
        this.unified_keyboard_icon = "";
    L49:
        if ((r100 & 2048) != 0) goto L51;
        this.is_no_show_douyin_logo = false;
        return;
    L51:
        this.is_no_show_douyin_logo = r114;
        return;
    L47:
        this.unified_keyboard_icon = r113;
        goto L49
    L43:
        this.dark_amount_keyboard_icon = r112;
        goto L45
    L39:
        this.light_amount_keyboard_icon = r111;
        goto L41
    L35:
        this.new_keyboard_denoise_icon = r110;
        goto L37
    L31:
        this.keyboard_denoise_icon = r107;
        goto L33
    L27:
        this.keyboard_icon = r106;
        goto L29
    L23:
        this.new_dark_icon = r105;
        goto L25
    L19:
        this.new_light_icon = r104;
        goto L21
    L15:
        this.dark_icon = r103;
        goto L17
    L11:
        this.light_icon = r102;
        goto L13
    L7:
        this.show = r101;
        goto L9
    }

    public /* synthetic */ CJInsuranceConfig(boolean r110, String r111, String r112, String r113, String r114, String r210, String r211, String r212, String r213, String r214, String r215, boolean r216, int r217, DefaultConstructorMarker r218) {
        boolean r100 = false;
        if ((r217 & 1) == 0) goto L5;
        boolean r101 = false;
    L6:
        String r102 = "";
        if ((r217 & 2) == 0) goto L9;
        String r103 = "";
    L11:
        if ((r217 & 4) == 0) goto L13;
        String r104 = "";
    L15:
        if ((r217 & 8) == 0) goto L17;
        String r105 = "";
    L19:
        if ((r217 & 16) == 0) goto L21;
        String r106 = "";
    L23:
        if ((r217 & 32) == 0) goto L25;
        String r107 = "";
    L27:
        if ((r217 & 64) == 0) goto L29;
        String r108 = "";
    L31:
        if ((r217 & 128) == 0) goto L33;
        String r115 = "";
    L35:
        if ((r217 & 256) == 0) goto L37;
        String r116 = "";
    L39:
        if ((r217 & 512) == 0) goto L41;
        String r117 = "";
    L43:
        if ((r217 & 1024) != 0) goto L47;
        r102 = r215;
    L47:
        if ((r217 & 2048) != 0) goto L50;
        r100 = r216;
    L50:
        this(r101, r103, r104, r105, r106, r107, r108, r115, r116, r117, r102, r100);
        return;
    L41:
        r117 = r214;
        goto L43
    L37:
        r116 = r213;
        goto L39
    L33:
        r115 = r212;
        goto L35
    L29:
        r108 = r211;
        goto L31
    L25:
        r107 = r210;
        goto L27
    L21:
        r106 = r114;
        goto L23
    L17:
        r105 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}
