package com.android.ttcjpaysdk.base.settings.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.tencent.connect.common.Constants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0001\u000bB7\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004¢\u0006\u0002\u0010\nR\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/LynxSchemaBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", Constants.LOGIN_INFO, "", "my_bank_card", "keep_dialog_standard_new", "Lcom/android/ttcjpaysdk/base/settings/bean/KeepDialogStandard;", "dydeposit_schema", "invite_share_card", "(Ljava/lang/String;Ljava/lang/String;Lcom/android/ttcjpaysdk/base/settings/bean/KeepDialogStandard;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LynxSchemaBean implements CJPayObject, Serializable {
    public static final Companion Companion = null;
    public static final String INVITE_SHARE_CARD = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F10181%2Fgecko%2Fresource%2Fcj_lynx_share_assets%2Frouter%2Ftemplate.js&web_bg_color=%23FFFFFF&show_error=1&trans_status_bar=1&status_bar_color=black&hide_nav_bar=1&top_level=1&android_soft_input_mode=48&forbid_right_back=1&host=aweme&engine_type=new&disable_url_handle=1&caijing_disable_router_match=1&business_type=caijing_share_assets&page_name=startup_share&user_type=receiver";
    public String dydeposit_schema;
    public String invite_share_card;
    public KeepDialogStandard keep_dialog_standard_new;
    public String login_info;
    public String my_bank_card;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/LynxSchemaBean$Companion;", "", "()V", "INVITE_SHARE_CARD", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public LynxSchemaBean() {
        this(null, null, null, null, null, 31, null);
    }

    public LynxSchemaBean(String r100, String r101, KeepDialogStandard r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, Constants.LOGIN_INFO);
        Intrinsics.checkNotNullParameter(r101, "my_bank_card");
        Intrinsics.checkNotNullParameter(r102, "keep_dialog_standard_new");
        Intrinsics.checkNotNullParameter(r103, "dydeposit_schema");
        Intrinsics.checkNotNullParameter(r104, "invite_share_card");
        this.login_info = r100;
        this.my_bank_card = r101;
        this.keep_dialog_standard_new = r102;
        this.dydeposit_schema = r103;
        this.invite_share_card = r104;
    }

    public /* synthetic */ LynxSchemaBean(String r100, String r101, KeepDialogStandard r102, String r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = "";
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = "";
    L11:
        if ((r110 & 4) == 0) goto L13;
        r102 = new KeepDialogStandard(null, null, 3, null);
    L13:
        KeepDialogStandard r106 = r102;
        if ((r110 & 8) == 0) goto L16;
        String r107 = "";
    L18:
        if ((r110 & 16) == 0) goto L20;
        String r113 = "";
    L21:
        this(r112, r105, r106, r107, r113);
        return;
    L20:
        r113 = r104;
        goto L21
    L16:
        r107 = r103;
        goto L18
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
