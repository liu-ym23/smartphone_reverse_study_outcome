package com.tmall.wireless.tangram;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.structure.BaseCell;
import com.tmall.wireless.tangram.util.Utils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class MVResolver {
    public static final String KEY_BIZ_ID = "bizId";
    public static final String KEY_POSITION = "position";
    public static final String KEY_STYLE = "style";
    public static final String KEY_TYPE = "type";
    public static final String KEY_TYPE_KEY = "typeKey";
    public static final String KEY_TYPE_REUSEID = "reuseId";
    private ArrayMap idCardMap;
    private ArrayMap idViewMap;
    private ArrayMap mvMap;
    private SparseArray<Class<? extends BaseCell>> typeCellMap;
    private SparseArray<Class<? extends View>> typeViewMap;
    private ArrayMap vmMap;

    public MVResolver() {
        this.typeViewMap = new SparseArray(64);
        this.typeCellMap = new SparseArray(64);
        this.idCardMap = new ArrayMap();
        this.mvMap = new ArrayMap(128);
        this.vmMap = new ArrayMap(128);
        this.idViewMap = new ArrayMap(128);
    }

    private void parseBizParams(BaseCell r10, JSONObject r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        Iterator<String> r12 = r11.keys();
    L6:
        if (r12.hasNext() == false) goto L10;
        String r13 = r12.next();
        r10.addBizParam(r13, r11.get(r13));     // Catch: JSONException -> L11
        goto L6
    }

    public Card findCardById(String r10) {
        return (Card) this.idCardMap.get(r10);
    }

    public BaseCell getCell(View r10) {
        return (BaseCell) this.vmMap.get(r10);
    }

    public Class<? extends BaseCell> getCellClass(int r10) {
        return this.typeCellMap.get(r10);
    }

    public View getView(BaseCell r10) {
        return (View) this.mvMap.get(r10);
    }

    public Class<? extends View> getViewClass(int r10) {
        return this.typeViewMap.get(r10);
    }

    public boolean isCompatibleType(int r10) {
        if (this.typeCellMap.get(r10) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void parseCell(MVHelper r10, BaseCell r11, JSONObject r12) {
        if (r12 == null) goto L7;
        r11.extras = r12;
        r11.f18213id = r12.optString(KEY_BIZ_ID);
        r11.type = r12.optInt("type");
        r11.typeKey = r12.optString(KEY_TYPE_KEY);
        String r13 = r12.optString(KEY_TYPE_REUSEID);
        if (TextUtils.isEmpty(r13) == true) goto L6;
        r11.typeKey = r13;
    L6:
        parseBizParams(r11, r12);
        r11.parseWith(r12);
        r11.parseWith(r12, r10);
        JSONObject r14 = r12.optJSONObject("style");
        parseStyle(r11, r14);
        parseBizParams(r11, r14);
        return;
    L7:
        r11.extras = new JSONObject();
    }

    public void parseStyle(BaseCell r10, @Nullable JSONObject r11) {
        if (Utils.isCellizedCard(r10.extras) == true) goto L8;
        Style r12 = new Style();
        r10.style = r12;
        if (r11 == null) goto L9;
        r12.parseWith(r11);
        r10.parseStyle(r11);
        return;
    L9:
        return;
    }

    public void register(int r10, Class<? extends View> r11) {
        this.typeViewMap.put(r10, r11);
    }

    public void registerCompatible(int r10, Class<? extends BaseCell> r11) {
        this.typeCellMap.put(r10, r11);
    }

    public void reset() {
        this.mvMap.clear();
        this.vmMap.clear();
        this.idViewMap.clear();
    }

    public void setCards(List<Card> r10) {
        Iterator<Card> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Card r12 = r11.next();
        if (TextUtils.isEmpty(r12.f18212id) == true) goto L4;
        this.idCardMap.put(r12.f18212id, r12);
        goto L4
    }

    public View getView(String r10) {
        return (View) this.idViewMap.get(r10);
    }

    public void register(String r10, BaseCell r11, View r12) {
        this.mvMap.put(r11, r12);
        this.vmMap.put(r12, r11);
        this.idViewMap.put(r10, r12);
    }
}
