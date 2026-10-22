package com.baidu.platform.comapi.bmsdk.xmlui;

import android.text.TextUtils;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.bmsdk.style.BmGuessResource;
import com.baidu.platform.comapi.bmsdk.style.BmTextStyle;
import com.baidu.platform.comapi.bmsdk.ui.BmBaseUI;
import com.baidu.platform.comapi.bmsdk.ui.BmFrameLayout;
import com.baidu.platform.comapi.bmsdk.ui.BmGroupUI;
import com.baidu.platform.comapi.bmsdk.ui.BmHorizontalLayout;
import com.baidu.platform.comapi.bmsdk.ui.BmImageUI;
import com.baidu.platform.comapi.bmsdk.ui.BmLabelUI;
import com.baidu.platform.comapi.bmsdk.ui.BmRichView;
import com.baidu.platform.comapi.bmsdk.ui.BmVerticalLayout;
import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.ugc.aweme.discover.model.CommodityText;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes39.dex */
public class a {
    public a() {
    }

    private BmHorizontalLayout b(Node r100) {
        BmHorizontalLayout r101 = new BmHorizontalLayout();
        if (r100.getAttributes() == null) goto L5;
        a(r101, r100);
    L5:
        return r101;
    }

    private BmImageUI c(Node r100) {
        BmImageUI r101 = new BmImageUI();
        if (r100.getAttributes() == null) goto L5;
        a(r101, r100);
    L5:
        return r101;
    }

    private BmLabelUI d(Node r100) {
        BmLabelUI r101 = new BmLabelUI();
        if (r100.getAttributes() == null) goto L5;
        a(r101, r100);
    L5:
        return r101;
    }

    private BmVerticalLayout e(Node r100) {
        BmVerticalLayout r101 = new BmVerticalLayout();
        if (r100.getAttributes() == null) goto L5;
        a(r101, r100);
    L5:
        return r101;
    }

    public BmRichView a(Document r100) {
        BmBaseUI r101 = b(r100);
        if (r101 == null) goto L6;
        BmRichView r102 = new BmRichView();
        r102.a(r101);
        return r102;
    L6:
        return null;
    }

    public final BmBaseUI f(Node r100) {
        String r101 = r100.getNodeName();
        r101.getClass();
        byte r102 = -1;
        switch(r101.hashCode()) {
            case -1673975200: goto L22;
            case 73174740: goto L18;
            case 1125864064: goto L14;
            case 1310765783: goto L10;
            case 1690373262: goto L6;
            default: goto L25;
        };
    L25:
        switch(r102) {
            case 0: goto L32;
            case 1: goto L37;
            case 2: goto L36;
            case 3: goto L35;
            case 4: goto L34;
            default: goto L26;
        };
    L26:
        return null;
    L34:
        return b(r100);
    L35:
        return a(r100);
    L36:
        return c(r100);
    L37:
        return d(r100);
    L32:
        return e(r100);
    L6:
        if (r101.equals("HorizontalLayout") == false) goto L25;
        r102 = 4;
        goto L25
    L10:
        if (r101.equals("FrameLayout") == false) goto L25;
        r102 = 3;
        goto L25
    L14:
        if (r101.equals("ImageView") == false) goto L25;
        r102 = 2;
        goto L25
    L18:
        if (r101.equals("Label") == false) goto L25;
        r102 = 1;
        goto L25
    L22:
        if (r101.equals("VerticalLayout") == false) goto L25;
        r102 = 0;
        goto L25
    }

    private BmFrameLayout a(Node r100) {
        BmFrameLayout r101 = new BmFrameLayout();
        if (r100.getAttributes() == null) goto L5;
        a(r101, r100);
    L5:
        return r101;
    }

    public BmBaseUI b(Document r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return a(r100.getDocumentElement(), null);
    }

    private void a(BmLabelUI r110, Node r111) {
        NamedNodeMap r112 = r111.getAttributes();
        int r100 = r112.getLength();
        BmTextStyle r101 = new BmTextStyle();
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L72;
        Node r103 = r112.item(r102);
        String r104 = r103.getNodeName();
        String r105 = r103.getNodeValue();
        if (TextUtils.isEmpty(r104) == true) goto L71;
        if (TextUtils.isEmpty(r105) == true) goto L71;
        if ("text".equals(r104) == false) goto L13;
        r110.b(r105);
        goto L71
    L13:
        if ("maxLines".equals(r104) == false) goto L16;
        r110.j(CastIntegerProtector.parseInt(r105));
        goto L71
    L16:
        if ("fontSize".equals(r104) == false) goto L19;
        r101.e(CastIntegerProtector.parseInt(r105));
        goto L71
    L19:
        if ("fontOption".equals(r104) == false) goto L30;
        if ("normal".equals(r105) == false) goto L24;
        r101.c(0);
        goto L71
    L24:
        if (CommodityText.BOLD.equals(r105) == false) goto L27;
        r101.c(1);
        goto L71
    L27:
        if ("italic".equals(r105) == false) goto L71;
        r101.c(2);
        goto L71
    L30:
        if ("textColor".equals(r104) == false) goto L36;
        if (r105.charAt(0) != '#') goto L34;
        r101.d(ColorProtector.parseColor(r105));
        goto L71
    L34:
        r101.d(CastIntegerProtector.parseInt(r105));
        goto L71
    L36:
        if ("borderColor".equals(r104) == false) goto L42;
        if (r105.charAt(0) != '#') goto L40;
        r101.a(ColorProtector.parseColor(r105));
        goto L71
    L40:
        r101.a(CastIntegerProtector.parseInt(r105));
        goto L71
    L42:
        if ("borderWidth".equals(r104) == false) goto L45;
        r101.b(CastIntegerProtector.parseInt(r105));
        goto L71
    L45:
        if (GXTemplateKey.GAIAX_LAYER_GRAVITY.equals(r104) == true) goto L47;
        a(r110, r104, r105);
        goto L71
    L47:
        if ("left".equals(r105) == false) goto L50;
        r110.e(1);
        goto L71
    L50:
        if ("right".equals(r105) == false) goto L53;
        r110.e(4);
        goto L71
    L53:
        if ("hcenter".equals(r105) == false) goto L56;
        r110.e(16);
        goto L71
    L56:
        if ("top".equals(r105) == false) goto L59;
        r110.e(2);
        goto L71
    L59:
        if ("bottom".equals(r105) == false) goto L62;
        r110.e(8);
        goto L71
    L62:
        if ("vcenter".equals(r105) == false) goto L65;
        r110.e(32);
        goto L71
    L65:
        if ("bottom|hcenter".equals(r105) == false) goto L68;
        r110.e(24);
        goto L71
    L68:
        if ("center".equals(r105) == false) goto L71;
        r110.e(48);
    L71:
        r102 = r102 + 1;
        goto L3
    L72:
        r110.a(r101);
    }

    private void a(BmFrameLayout r100, Node r101) {
        NamedNodeMap r102 = r101.getAttributes();
        int r103 = r102.getLength();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L40;
        Node r105 = r102.item(r104);
        String r106 = r105.getNodeName();
        String r107 = r105.getNodeValue();
        if (TextUtils.isEmpty(r106) == true) goto L39;
        if (TextUtils.isEmpty(r107) == true) goto L39;
        if (GXTemplateKey.GAIAX_LAYER_GRAVITY.equals(r106) == true) goto L16;
        if ("childalign".equals(r106) == true) goto L16;
        a(r100, r106, r107);
    L16:
        if ("left".equals(r107) == false) goto L19;
        r100.e(1);
        goto L39
    L19:
        if ("right".equals(r107) == false) goto L22;
        r100.e(4);
        goto L39
    L22:
        if ("center".equals(r107) == false) goto L25;
        r100.e(48);
        goto L39
    L25:
        if ("hcenter".equals(r107) == false) goto L28;
        r100.e(16);
        goto L39
    L28:
        if ("top".equals(r107) == false) goto L31;
        r100.e(2);
        goto L39
    L31:
        if ("bottom".equals(r107) == false) goto L34;
        r100.e(8);
        goto L39
    L34:
        if ("vcenter".equals(r107) == false) goto L37;
        r100.e(32);
        goto L39
    L37:
        if ("bottom|hcenter".equals(r107) == false) goto L39;
        r100.e(24);
    L39:
        r104 = r104 + 1;
        goto L3
    }

    private void a(BmHorizontalLayout r100, Node r101) {
        NamedNodeMap r102 = r101.getAttributes();
        int r103 = r102.getLength();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L25;
        Node r105 = r102.item(r104);
        String r106 = r105.getNodeName();
        String r107 = r105.getNodeValue();
        if (TextUtils.isEmpty(r106) == true) goto L24;
        if (TextUtils.isEmpty(r107) == true) goto L24;
        if (GXTemplateKey.GAIAX_LAYER_GRAVITY.equals(r106) == true) goto L16;
        if ("childvalign".equals(r106) == true) goto L16;
        a(r100, r106, r107);
    L16:
        if ("top".equals(r107) == false) goto L19;
        r100.e(2);
        goto L24
    L19:
        if ("bottom".equals(r107) == false) goto L22;
        r100.e(8);
        goto L24
    L22:
        if ("vcenter".equals(r107) == false) goto L24;
        r100.e(32);
    L24:
        r104 = r104 + 1;
        goto L3
    }

    private void a(BmVerticalLayout r100, Node r101) {
        NamedNodeMap r102 = r101.getAttributes();
        int r103 = r102.getLength();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L25;
        Node r105 = r102.item(r104);
        String r106 = r105.getNodeName();
        String r107 = r105.getNodeValue();
        if (TextUtils.isEmpty(r106) == true) goto L24;
        if (TextUtils.isEmpty(r107) == true) goto L24;
        if (GXTemplateKey.GAIAX_LAYER_GRAVITY.equals(r106) == true) goto L16;
        if ("childhalign".equals(r106) == true) goto L16;
        a(r100, r106, r107);
    L16:
        if ("left".equals(r107) == false) goto L19;
        r100.e(1);
        goto L24
    L19:
        if ("right".equals(r107) == false) goto L22;
        r100.e(4);
        goto L24
    L22:
        if ("hcenter".equals(r107) == false) goto L24;
        r100.e(16);
    L24:
        r104 = r104 + 1;
        goto L3
    }

    private void a(BmImageUI r100, Node r101) {
        NamedNodeMap r102 = r101.getAttributes();
        int r103 = r102.getLength();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L21;
        Node r105 = r102.item(r104);
        String r106 = r105.getNodeName();
        String r107 = r105.getNodeValue();
        if (TextUtils.isEmpty(r106) == true) goto L20;
        if (TextUtils.isEmpty(r107) == true) goto L20;
        if ("frImage".equals(r106) == false) goto L15;
        if (TextUtils.isEmpty(r107) == true) goto L20;
        r100.b(new BmGuessResource(r107));
        goto L20
    L15:
        if (BuyNowCloseMethod.MASK.equals(r106) == true) goto L17;
        a(r100, r106, r107);
        goto L20
    L17:
        if (TextUtils.isEmpty(r107) == true) goto L20;
        r100.c(new BmGuessResource(r107));
    L20:
        r104 = r104 + 1;
        goto L3
    }

    private BmBaseUI a(Node r100, BmGroupUI r101) {
        BmBaseUI r102 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        Node r103 = r100.getFirstChild();
    L6:
        if (r103 == null) goto L20;
        BmBaseUI r104 = f(r103);
        if (r104 == null) goto L19;
        if (r103.hasChildNodes() == false) goto L13;
        a(r103, (BmGroupUI) r104);
    L13:
        if (r101 != null) goto L15;
    L17:
        if (r102 != null) goto L19;
        r102 = r104;
        goto L19
    L15:
        if (r101.a(r104) == true) goto L17;
    L19:
        r103 = r103.getNextSibling();
        goto L6
    L20:
        return r102;
    }

    private void a(BmBaseUI r100, String r101, String r110) {
        if ("name".equals(r101) == false) goto L6;
        r100.setName(r110);
        return;
    L6:
        if ("tag".equals(r101) == false) goto L9;
        r100.setTag(r110);
        return;
    L9:
        if ("bkImage".equals(r101) == true) goto L11;
        int r102 = 0;
        if ("bkColor".equals(r101) == false) goto L20;
        if (r110.charAt(0) != '#') goto L18;
        r100.b(ColorProtector.parseColor(r110));
        return;
    L18:
        r100.b(CastIntegerProtector.parseInt(r110));
        return;
    L20:
        if ("bkColorL".equals(r101) == false) goto L26;
        if (r110.charAt(0) != '#') goto L24;
        r100.c(ColorProtector.parseColor(r110));
        return;
    L24:
        r100.c(CastIntegerProtector.parseInt(r110));
        return;
    L26:
        if ("bkColorR".equals(r101) == false) goto L32;
        if (r110.charAt(0) != '#') goto L30;
        r100.d(ColorProtector.parseColor(r110));
        return;
    L30:
        r100.d(CastIntegerProtector.parseInt(r110));
        return;
    L32:
        if ("width".equals(r101) == false) goto L38;
        if ("auto".equals(r110) == false) goto L36;
        r100.i(-2);
        return;
    L36:
        r100.i(CastIntegerProtector.parseInt(r110));
        return;
    L38:
        if ("height".equals(r101) == false) goto L44;
        if ("auto".equals(r110) == false) goto L42;
        r100.f(-2);
        return;
    L42:
        r100.f(CastIntegerProtector.parseInt(r110));
        return;
    L44:
        if ("clickAction".equals(r101) == false) goto L49;
        if (TextUtils.isEmpty(r110) == true) goto L138;
        r100.a(r110);
        r100.a(true);
        return;
    L138:
        return;
    L49:
        if (GXTemplateKey.FLEXBOX_PADDING.equals(r101) == false) goto L56;
        String[] r103 = r110.split(",");
        if (r103 != null) goto L53;
        return;
    L53:
        if (r103.length != 4) goto L141;
        r100.b(CastIntegerProtector.parseInt(r103[0]), CastIntegerProtector.parseInt(r103[1]), CastIntegerProtector.parseInt(r103[2]), CastIntegerProtector.parseInt(r103[3]));
        return;
    L141:
        return;
    L56:
        if (GXTemplateKey.FLEXBOX_MARGIN.equals(r101) == false) goto L63;
        String[] r104 = r110.split(",");
        if (r104 != null) goto L60;
        return;
    L60:
        if (r104.length != 4) goto L144;
        r100.a(CastIntegerProtector.parseInt(r104[0]), CastIntegerProtector.parseInt(r104[1]), CastIntegerProtector.parseInt(r104[2]), CastIntegerProtector.parseInt(r104[3]));
        return;
    L144:
        return;
    L63:
        if (RemoteMessageConst.Notification.VISIBILITY.equals(r101) == false) goto L74;
        if ("visible".equals(r110) == false) goto L68;
        r100.h(1);
        return;
    L68:
        if ("gone".equals(r110) == false) goto L71;
        r100.h(4);
        return;
    L71:
        if ("invisible".equals(r110) == false) goto L148;
        r100.h(1);
        return;
    L148:
        return;
    L74:
        if ("vcenterInparent".equals(r101) == false) goto L79;
        if ("true".equals(r110) == false) goto L150;
        r100.e(32);
        return;
    L150:
        return;
    L79:
        if ("layoutWeight".equals(r101) == false) goto L82;
        r100.g(CastIntegerProtector.parseInt(r110));
        return;
    L82:
        if ("alignParent".equals(r101) == false) goto L113;
        String[] r105 = r110.split("\\|");
        if (r105 != null) goto L86;
    L112:
        r100.a(r102);
        return;
    L86:
        if (r105.length <= 0) goto L112;
        int r111 = r105.length;
        int r106 = 0;
    L88:
        if (r102 >= r111) goto L111;
        String r107 = r105[r102];
        if (r107.contains("left") == false) goto L93;
        r106 = r106 | 1;
    L110:
        r102 = r102 + 1;
        goto L88
    L93:
        if (r107.contains("right") == false) goto L96;
        r106 = r106 | 4;
        goto L110
    L96:
        if (r107.contains("top") == false) goto L99;
        r106 = r106 | 2;
        goto L110
    L99:
        if (r107.contains("bottom") == false) goto L102;
        r106 = r106 | 8;
        goto L110
    L102:
        if (r107.contains("hcenter") == false) goto L105;
        r106 = r106 | 16;
        goto L110
    L105:
        if (r107.contains("vcenter") == false) goto L108;
        r106 = r106 | 32;
        goto L110
    L108:
        if (r107.contains("center") == false) goto L110;
        r106 = r106 | 48;
        goto L110
    L111:
        r102 = r106;
        goto L112
    L113:
        "trim".equals(r101);
        return;
    L11:
        if (TextUtils.isEmpty(r110) == true) goto L126;
        r100.a(new BmGuessResource(r110));
        return;
    }
}
