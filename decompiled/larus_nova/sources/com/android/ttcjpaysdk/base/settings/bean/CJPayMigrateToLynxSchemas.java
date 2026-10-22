package com.android.ttcjpaysdk.base.settings.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPayMigrateToLynxSchemas;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "forgetpass_schema", "", "(Ljava/lang/String;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayMigrateToLynxSchemas implements CJPayObject, Serializable {
    public String forgetpass_schema;

    /* JADX WARN: Multi-variable type inference failed */
    public CJPayMigrateToLynxSchemas() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public CJPayMigrateToLynxSchemas(String r100) {
        this.forgetpass_schema = r100;
    }

    public /* synthetic */ CJPayMigrateToLynxSchemas(String r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-cj-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F10181%2Fgecko%2Fresource%2Ffe_lynx_ttpay%2Frouter%2Ftemplate.js&hide_nav_bar=1&trans_status_bar=1&hide_loading=1&type=fullscreen&page_name=resetpass_dispatch_full&show_error=1&top_level=1&host=aweme&engine_type=new&web_bg_color=%23FFFFFF&merchant_id=800010000160013&app_id=NA202008272032554177543173&tea_source=cashdesk&service=27&user_entrance=0";
    L5:
        this(r100);
    }
}
