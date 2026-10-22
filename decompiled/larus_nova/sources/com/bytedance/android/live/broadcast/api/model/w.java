package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdkapi.depend.model.broadcast.ItemBubbleInfo;
import com.bytedance.android.livesdkapi.depend.model.broadcast.ItemDotInfo;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.room.ConfigItemPre")
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b7\u00108R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0018\u0010\r\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0007R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0016\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0004R\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0011R\u001e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0011R\"\u0010\u001c\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0007\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b!\u0010\u0004R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R$\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010,\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00102\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010\u000b\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006:"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/w;", "", "", "name", "Ljava/lang/String;", "", "order", "I", "text", "Lcom/bytedance/android/live/base/model/ImageModel;", "icon", "Lcom/bytedance/android/live/base/model/ImageModel;", "innerIcon", "selectedIcon", "schema", "", "excludedItems", "Ljava/util/List;", "type", "buttonText", com.bytedance.android.livesdk.gift.model.n.KEY_SUB_TEXT, "", "switchStatus", "Z", "panelName", "Lcom/bytedance/android/live/broadcast/api/model/l0;", "subItems", "showInSubTabs", "dotType", "getDotType", "()I", "setDotType", "(I)V", "extra", "toolbarComponentType", "Ljava/lang/Integer;", "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ItemBubbleInfo;", "bubbleInfo", "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ItemBubbleInfo;", "getBubbleInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ItemBubbleInfo;", "setBubbleInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ItemBubbleInfo;)V", "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ItemDotInfo;", "dotInfo", "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ItemDotInfo;", "getDotInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ItemDotInfo;", "setDotInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ItemDotInfo;)V", "innerSelectedIcon", "getInnerSelectedIcon", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setInnerSelectedIcon", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class w implements vh7.h {

    @SerializedName("bubble_info")
    protected ItemBubbleInfo bubbleInfo;

    @SerializedName("button_text")
    public String buttonText;

    @SerializedName("dot_info")
    protected ItemDotInfo dotInfo;

    @SerializedName("dot_type")
    protected int dotType;

    @SerializedName("excluded_by_other_items")
    public List<String> excludedItems;

    @SerializedName("extra")
    public String extra;

    @SerializedName("icon")
    public ImageModel icon;

    @SerializedName("inner_icon")
    public ImageModel innerIcon;

    @SerializedName("inner_selected_icon")
    protected ImageModel innerSelectedIcon;

    @SerializedName("name")
    public String name;

    @SerializedName("order")
    public int order;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_PANEL_NAME)
    public String panelName;

    @SerializedName("schema")
    public String schema;

    @SerializedName("selected_icon")
    public ImageModel selectedIcon;

    @SerializedName("show_in_sub_tabs")
    public List<Integer> showInSubTabs;

    @SerializedName("sub_items")
    public List<l0> subItems;

    @SerializedName("sub_text")
    public String subText;

    @SerializedName(EventConstants.ExtraJson.SWITCH_STATUS)
    public boolean switchStatus;

    @SerializedName("text")
    public String text;

    @SerializedName("toolbar_component_type")
    public Integer toolbarComponentType;

    @SerializedName("type")
    public int type;

    public static final class a {
    }

    static {
    }

    public w() {
        this.name = "";
        this.order = -1;
        this.text = "";
        this.schema = "";
        this.buttonText = "";
        this.subText = "";
        this.panelName = "";
        this.extra = "";
    }

    public w(am3.g r100) {
        this.excludedItems = new ArrayList();
        this.subItems = new ArrayList();
        this.showInSubTabs = new ArrayList();
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L29;
        switch(r103) {
            case 1: goto L28;
            case 2: goto L27;
            case 3: goto L26;
            case 4: goto L25;
            case 5: goto L24;
            case 6: goto L22;
            case 7: goto L21;
            case 8: goto L20;
            case 9: goto L19;
            case 10: goto L18;
            case 11: goto L17;
            case 12: goto L16;
            case 13: goto L15;
            case 14: goto L14;
            case 15: goto L13;
            case 16: goto L12;
            case 17: goto L11;
            case 18: goto L6;
            case 19: goto L10;
            case 20: goto L9;
            case 21: goto L8;
            case 22: goto L7;
            default: goto L6;
        };
    L7:
        this.innerSelectedIcon = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L8:
        this.toolbarComponentType = Integer.valueOf(r100.i());
        goto L3
    L9:
        this.dotInfo = new ItemDotInfo(r100);
        goto L3
    L10:
        this.bubbleInfo = new ItemBubbleInfo(r100);
        goto L3
    L11:
        this.extra = am3.h.c(r100);
        goto L3
    L12:
        this.dotType = r100.i();
        goto L3
    L13:
        List r104 = this.showInSubTabs;
        Object r105 = Integer.valueOf(r100.i());
    L23:
        r104.add(r105);
        goto L3
    L14:
        this.panelName = am3.h.c(r100);
        goto L3
    L15:
        this.selectedIcon = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L16:
        this.innerIcon = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L17:
        r104 = this.subItems;
        r105 = new l0(r100);
        goto L23
    L18:
        this.switchStatus = am3.h.a(r100);
        goto L3
    L19:
        this.subText = am3.h.c(r100);
        goto L3
    L20:
        this.buttonText = am3.h.c(r100);
        goto L3
    L21:
        this.type = r100.i();
        goto L3
    L22:
        r104 = this.excludedItems;
        r105 = am3.h.c(r100);
        goto L23
    L24:
        this.schema = am3.h.c(r100);
        goto L3
    L25:
        this.icon = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L26:
        this.text = am3.h.c(r100);
        goto L3
    L27:
        this.order = r100.i();
        r102 = r102 | true;
        goto L3
    L28:
        this.name = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L29:
        r100.d(r101);
        if (this.name != null) goto L33;
        this.name = "";
    L33:
        if ((r102 & true) == true) goto L36;
        this.order = -1;
    L36:
        if (this.text != null) goto L39;
        this.text = "";
    L39:
        if (this.schema != null) goto L42;
        this.schema = "";
    L42:
        if (this.buttonText != null) goto L45;
        this.buttonText = "";
    L45:
        if (this.subText != null) goto L48;
        this.subText = "";
    L48:
        if (this.panelName != null) goto L51;
        this.panelName = "";
    L51:
        if (this.extra != null) goto L98;
        this.extra = "";
        return;
    }
}
