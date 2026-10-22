package com.android.ttcjpaysdk.base.settings.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B«\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0006¢\u0006\u0002\u0010\u0016R\u0012\u0010\u0010\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/BrandPromotion;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "show_new_loading", "", "loading_gif", "", "half_input_password_title", "full_verify_password_title", "full_set_password_title", "full_set_password_title_again", "full_safe_set_password_title", "full_safe_set_password_title_again", "cashier_title", "one_key_quick_cashier_title", "add_card_title", "add_card_h1", "setting_open_bio_finger_password_title", "password_keyboard_show_account_insurance", "douyin_loading_url", "", "brand_design_full_screen_background", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;Ljava/lang/String;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BrandPromotion implements CJPayObject, Serializable {
    public String add_card_h1;
    public String add_card_title;
    public String brand_design_full_screen_background;
    public String cashier_title;
    public List<String> douyin_loading_url;
    public String full_safe_set_password_title;
    public String full_safe_set_password_title_again;
    public String full_set_password_title;
    public String full_set_password_title_again;
    public String full_verify_password_title;
    public String half_input_password_title;
    public String loading_gif;
    public String one_key_quick_cashier_title;
    public boolean password_keyboard_show_account_insurance;
    public String setting_open_bio_finger_password_title;
    public boolean show_new_loading;

    public BrandPromotion() {
        this(false, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, 65535, null);
    }

    public BrandPromotion(boolean r110, String r111, String r112, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, boolean r310, List<String> r311, String r312) {
        Intrinsics.checkNotNullParameter(r111, "loading_gif");
        Intrinsics.checkNotNullParameter(r112, "half_input_password_title");
        Intrinsics.checkNotNullParameter(r210, "full_verify_password_title");
        Intrinsics.checkNotNullParameter(r211, "full_set_password_title");
        Intrinsics.checkNotNullParameter(r212, "full_set_password_title_again");
        Intrinsics.checkNotNullParameter(r213, "full_safe_set_password_title");
        Intrinsics.checkNotNullParameter(r214, "full_safe_set_password_title_again");
        Intrinsics.checkNotNullParameter(r215, "cashier_title");
        Intrinsics.checkNotNullParameter(r216, "one_key_quick_cashier_title");
        Intrinsics.checkNotNullParameter(r217, "add_card_title");
        Intrinsics.checkNotNullParameter(r218, "add_card_h1");
        Intrinsics.checkNotNullParameter(r219, "setting_open_bio_finger_password_title");
        Intrinsics.checkNotNullParameter(r311, "douyin_loading_url");
        Intrinsics.checkNotNullParameter(r312, "brand_design_full_screen_background");
        this.show_new_loading = r110;
        this.loading_gif = r111;
        this.half_input_password_title = r112;
        this.full_verify_password_title = r210;
        this.full_set_password_title = r211;
        this.full_set_password_title_again = r212;
        this.full_safe_set_password_title = r213;
        this.full_safe_set_password_title_again = r214;
        this.cashier_title = r215;
        this.one_key_quick_cashier_title = r216;
        this.add_card_title = r217;
        this.add_card_h1 = r218;
        this.setting_open_bio_finger_password_title = r219;
        this.password_keyboard_show_account_insurance = r310;
        this.douyin_loading_url = r311;
        this.brand_design_full_screen_background = r312;
    }

    public /* synthetic */ BrandPromotion(boolean r110, String r111, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, boolean r311, List r312, String r313, int r314, DefaultConstructorMarker r315) {
        if ((r314 & 1) == 0) goto L5;
        boolean r100 = true;
    L7:
        if ((r314 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r314 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r314 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r314 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r314 & 32) == 0) goto L25;
        String r105 = "";
    L27:
        if ((r314 & 64) == 0) goto L29;
        String r106 = "";
    L31:
        if ((r314 & 128) == 0) goto L33;
        String r107 = "";
    L35:
        if ((r314 & 256) == 0) goto L37;
        String r112 = "";
    L39:
        if ((r314 & 512) == 0) goto L41;
        String r113 = "";
    L43:
        if ((r314 & 1024) == 0) goto L45;
        String r114 = "";
    L47:
        if ((r314 & 2048) == 0) goto L49;
        String r115 = "";
    L51:
        if ((r314 & 4096) == 0) goto L53;
        String r116 = "";
    L55:
        if ((r314 & 8192) == 0) goto L57;
        boolean r117 = false;
    L59:
        if ((r314 & 16384) == 0) goto L61;
        List r108 = new ArrayList();
    L63:
        if ((r314 & 32768) == 0) goto L65;
        String r109 = "";
    L66:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r112, r113, r114, r115, r116, r117, r108, r109);
        return;
    L65:
        r109 = r313;
        goto L66
    L61:
        r108 = r312;
        goto L63
    L57:
        r117 = r311;
        goto L59
    L53:
        r116 = r310;
        goto L55
    L49:
        r115 = r219;
        goto L51
    L45:
        r114 = r218;
        goto L47
    L41:
        r113 = r217;
        goto L43
    L37:
        r112 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
