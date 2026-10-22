package com.android.ttcjpaysdk.integrated.counter.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002By\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\u0018\b\u0002\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u000ej\b\u0012\u0004\u0012\u00020\u0004`\u000f¢\u0006\u0002\u0010\u0010R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u000ej\b\u0012\u0004\u0012\u00020\u0004`\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/data/SignTemplateInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "icon", "", "button_desc", "service_desc", "service_name", ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, "zg_merchant_id", "zg_merchant_app_id", "zg_merchant_name", "page_title", "support_pay_type", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SignTemplateInfo implements CJPayObject, Serializable {
    public String button_desc;
    public String icon;
    public String page_title;
    public String service_desc;
    public String service_name;
    public ArrayList<String> support_pay_type;
    public String template_id;
    public String zg_merchant_app_id;
    public String zg_merchant_id;
    public String zg_merchant_name;

    public SignTemplateInfo() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public SignTemplateInfo(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, ArrayList<String> r111) {
        Intrinsics.checkNotNullParameter(r100, "icon");
        Intrinsics.checkNotNullParameter(r101, "button_desc");
        Intrinsics.checkNotNullParameter(r102, "service_desc");
        Intrinsics.checkNotNullParameter(r103, "service_name");
        Intrinsics.checkNotNullParameter(r104, ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID);
        Intrinsics.checkNotNullParameter(r105, "zg_merchant_id");
        Intrinsics.checkNotNullParameter(r106, "zg_merchant_app_id");
        Intrinsics.checkNotNullParameter(r107, "zg_merchant_name");
        Intrinsics.checkNotNullParameter(r110, "page_title");
        Intrinsics.checkNotNullParameter(r111, "support_pay_type");
        this.icon = r100;
        this.button_desc = r101;
        this.service_desc = r102;
        this.service_name = r103;
        this.template_id = r104;
        this.zg_merchant_id = r105;
        this.zg_merchant_app_id = r106;
        this.zg_merchant_name = r107;
        this.page_title = r110;
        this.support_pay_type = r111;
    }

    public /* synthetic */ SignTemplateInfo(String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, String r210, ArrayList r211, int r212, DefaultConstructorMarker r213) {
        String r100 = "";
        if ((r212 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r105 = "";
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r106 = "";
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r107 = "";
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r108 = "";
    L35:
        if ((r212 & 256) != 0) goto L39;
        r100 = r210;
    L39:
        if ((r212 & 512) == 0) goto L41;
        ArrayList r109 = new ArrayList();
    L42:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r100, r109);
        return;
    L41:
        r109 = r211;
        goto L42
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
