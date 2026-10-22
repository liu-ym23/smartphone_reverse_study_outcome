package com.tmall.wireless.tangram.structure.style;

import com.tmall.wireless.tangram.dataparser.concrete.Style;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class DelegateStyle extends Style {
    private static final String KEY_MIXED_LAYOUTS = "mixedLayouts";
    public List<CardInfo> cardInfos;

    public static final class CardInfo {
        public JSONObject data;
        public int itemCount;
        public int type;

        public CardInfo() {
        }
    }

    public DelegateStyle() {
        this.cardInfos = new LinkedList();
    }

    @Override // com.tmall.wireless.tangram.dataparser.concrete.Style
    public void parseWith(JSONObject r10) {
        super.parseWith(r10);
        if (r10 == null) goto L17;
        JSONArray r11 = r10.optJSONArray(KEY_MIXED_LAYOUTS);
        if (r11 != null) goto L7;
        return;
    L7:
        if (r11.length() <= 0) goto L23;
        int r12 = r11.length();
        int r13 = 0;
    L9:
        if (r13 >= r12) goto L24;
        JSONObject r14 = r11.optJSONObject(r13);
        if (r14 == null) goto L16;
        int r15 = r14.optInt("type", -1);
        if (r15 < 0) goto L16;
        CardInfo r16 = new CardInfo();
        r16.type = r15;
        r16.itemCount = r14.optInt("count", 0);
        r16.data = r14;
        this.cardInfos.add(r16);
    L16:
        r13 = r13 + 1;
        goto L9
    L24:
        return;
    L23:
        return;
    }
}
