package com.android.ttcjpaysdk.base.settings.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B}\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004¢\u0006\u0002\u0010\u0011R\u0012\u0010\u000e\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/InsuranceConfiguration;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "show", "", "light_icon", "", "dark_icon", "new_light_icon", "new_dark_icon", "keyboard_icon", "keyboard_denoise_icon", "new_keyboard_denoise_icon", "light_amount_keyboard_icon", "dark_amount_keyboard_icon", "unified_keyboard_icon", "is_no_show_douyin_logo", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InsuranceConfiguration implements CJPayObject, Serializable {
    public String dark_amount_keyboard_icon;
    public String dark_icon;
    public boolean is_no_show_douyin_logo;
    public String keyboard_denoise_icon;
    public String keyboard_icon;
    public String light_amount_keyboard_icon;
    public String light_icon;
    public String new_dark_icon;
    public String new_keyboard_denoise_icon;
    public String new_light_icon;
    public boolean show;
    public String unified_keyboard_icon;

    public InsuranceConfiguration() {
        this(false, null, null, null, null, null, null, null, null, null, null, false, UnixStat.PERM_MASK, null);
    }

    public InsuranceConfiguration(boolean r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, String r111, String r112, boolean r113) {
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

    public /* synthetic */ InsuranceConfiguration(boolean r110, String r111, String r112, String r113, String r114, String r210, String r211, String r212, String r213, String r214, String r215, boolean r216, int r217, DefaultConstructorMarker r218) {
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
