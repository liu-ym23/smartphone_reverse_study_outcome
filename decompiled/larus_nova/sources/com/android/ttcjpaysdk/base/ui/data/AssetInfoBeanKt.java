package com.android.ttcjpaysdk.base.ui.data;

import androidx.core.provider.FontsContractCompat;
import com.ss.android.ugc.aweme.discover.model.CommodityText;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aL\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u00032&\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0001j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0003H\u0002\u001a.\u0010\u0006\u001a\u00020\u00072&\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0001j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0018\u0001`\u0003\u001aL\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u00032&\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0018\u00010\u0001j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0018\u0001`\u0003H\u0002¨\u0006\u000b"}, d2 = {"transUIComponentList", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "map", "Lcom/android/ttcjpaysdk/base/ui/data/UIComponentList;", "transVoucherMsgBean", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$VoucherMsgBean;", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$VoucherTagBeanList;", "transVoucherMsgInfoBeanList", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$VoucherMsgInfoBeanList;", "base-context_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class AssetInfoBeanKt {
    public static final /* synthetic */ HashMap access$transUIComponentList(HashMap r100) {
        return transUIComponentList(r100);
    }

    public static final /* synthetic */ HashMap access$transVoucherMsgInfoBeanList(HashMap r100) {
        return transVoucherMsgInfoBeanList(r100);
    }

    private static final HashMap<String, String> transUIComponentList(HashMap<String, UIComponentList> r100) {
        HashMap<String, String> r101 = new HashMap();
        if (r100 == null) goto L21;
        Iterator<Map.Entry<String, UIComponentList>> r102 = r100.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L21;
        Map.Entry<String, UIComponentList> r103 = r102.next();
        JSONArray r104 = new JSONArray();
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L18
        List<CJPayUIComponent> r106 = r103.getValue().list;     // Catch: Throwable -> L18
        if (r106 == null) goto L15;
        Iterator<T> r107 = r106.iterator();     // Catch: Throwable -> L18
    L12:
        if (r107.hasNext() == false) goto L14;
        CJPayUIComponent r108 = (CJPayUIComponent) r107.next();     // Catch: Throwable -> L18
        JSONObject r109 = new JSONObject();     // Catch: Throwable -> L18
        r109.put("type", r108.type);     // Catch: Throwable -> L18
        r109.put("text", r108.text);     // Catch: Throwable -> L18
        r109.put("url", r108.url);     // Catch: Throwable -> L18
        r109.put("header", r108.header);     // Catch: Throwable -> L18
        r109.put("bg", r108.f29367bg);     // Catch: Throwable -> L18
        r109.put("color", r108.color);     // Catch: Throwable -> L18
        r109.put("border", r108.border);     // Catch: Throwable -> L18
        r109.put(CommodityText.BOLD, r108.bold);     // Catch: Throwable -> L18
        r109.put("link", r108.link);     // Catch: Throwable -> L18
        r109.put("font_size", r108.font_size);     // Catch: Throwable -> L18
        r109.put(FontsContractCompat.Columns.WEIGHT, r108.font_weight);     // Catch: Throwable -> L18
        r109.put("width", r108.width);     // Catch: Throwable -> L18
        r109.put("height", r108.height);     // Catch: Throwable -> L18
        r109.put("icon_shape", r108.icon_shape);     // Catch: Throwable -> L18
        r104.put(r109);     // Catch: Throwable -> L18
        goto L12
    L14:
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L18
    L16:
        Result.m9449constructorimpl(r110);     // Catch: Throwable -> L18
    L20:
        r101.put(r103.getKey(), r104.toString());
        goto L6
    L15:
        r110 = null;
    L18:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L21:
        return r101;
    }

    public static final AssetInfoBean.VoucherMsgBean transVoucherMsgBean(HashMap<String, AssetInfoBean.VoucherTagBeanList> r100) {
        AssetInfoBean.VoucherMsgBean r101 = new AssetInfoBean.VoucherMsgBean();
        if (r100 == null) goto L12;
        AssetInfoBean.VoucherTagBeanList r102 = r100.get("tag12");
        if (r102 == null) goto L12;
        ArrayList<AssetInfoBean.VoucherTagBean> r103 = r102.list;
        if (r103 == null) goto L12;
        Iterator<T> r104 = r103.iterator();
    L10:
        if (r104.hasNext() == false) goto L12;
        AssetInfoBean.VoucherTagBean r105 = (AssetInfoBean.VoucherTagBean) r104.next();
        r101.tag12.add(r105);
    L12:
        if (r100 == null) goto L21;
        AssetInfoBean.VoucherTagBeanList r106 = r100.get("tag34");
        if (r106 == null) goto L21;
        ArrayList<AssetInfoBean.VoucherTagBean> r107 = r106.list;
        if (r107 == null) goto L21;
        Iterator<T> r108 = r107.iterator();
    L19:
        if (r108.hasNext() == false) goto L21;
        AssetInfoBean.VoucherTagBean r109 = (AssetInfoBean.VoucherTagBean) r108.next();
        r101.tag34.add(r109);
    L21:
        if (r100 == null) goto L30;
        AssetInfoBean.VoucherTagBeanList r110 = r100.get("tag56");
        if (r110 == null) goto L30;
        ArrayList<AssetInfoBean.VoucherTagBean> r111 = r110.list;
        if (r111 == null) goto L30;
        Iterator<T> r112 = r111.iterator();
    L28:
        if (r112.hasNext() == false) goto L30;
        AssetInfoBean.VoucherTagBean r113 = (AssetInfoBean.VoucherTagBean) r112.next();
        r101.tag56.add(r113);
    L30:
        if (r100 == null) goto L39;
        AssetInfoBean.VoucherTagBeanList r114 = r100.get("recommend_tag");
        if (r114 == null) goto L39;
        ArrayList<AssetInfoBean.VoucherTagBean> r115 = r114.list;
        if (r115 == null) goto L39;
        Iterator<T> r116 = r115.iterator();
    L37:
        if (r116.hasNext() == false) goto L39;
        AssetInfoBean.VoucherTagBean r117 = (AssetInfoBean.VoucherTagBean) r116.next();
        r101.recommend_tag.add(r117);
    L39:
        if (r100 == null) goto L48;
        AssetInfoBean.VoucherTagBeanList r118 = r100.get("premium_feel_tag");
        if (r118 == null) goto L48;
        ArrayList<AssetInfoBean.VoucherTagBean> r119 = r118.list;
        if (r119 == null) goto L48;
        Iterator<T> r120 = r119.iterator();
    L46:
        if (r120.hasNext() == false) goto L48;
        AssetInfoBean.VoucherTagBean r121 = (AssetInfoBean.VoucherTagBean) r120.next();
        r101.premium_feel_tag.add(r121);
    L48:
        return r101;
    }

    private static final HashMap<String, String> transVoucherMsgInfoBeanList(HashMap<String, AssetInfoBean.VoucherMsgInfoBeanList> r100) {
        HashMap<String, String> r101 = new HashMap();
        if (r100 == null) goto L17;
        Iterator<Map.Entry<String, AssetInfoBean.VoucherMsgInfoBeanList>> r102 = r100.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L17;
        Map.Entry<String, AssetInfoBean.VoucherMsgInfoBeanList> r103 = r102.next();
        JSONArray r104 = new JSONArray();
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L14
        Iterator<T> r106 = r103.getValue().list.iterator();     // Catch: Throwable -> L14
    L10:
        if (r106.hasNext() == false) goto L12;
        AssetInfoBean.VoucherMsgInfo r107 = (AssetInfoBean.VoucherMsgInfo) r106.next();     // Catch: Throwable -> L14
        JSONObject r108 = new JSONObject();     // Catch: Throwable -> L14
        r108.put("left_msg", r107.left_msg);     // Catch: Throwable -> L14
        r108.put("right_msg", r107.right_msg);     // Catch: Throwable -> L14
        r108.put("tag_show_type", r107.tag_show_type);     // Catch: Throwable -> L14
        r104.put(r108);     // Catch: Throwable -> L14
        goto L10
    L12:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        r101.put(r103.getKey(), r104.toString());
    L14:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L17:
        return r101;
    }
}
