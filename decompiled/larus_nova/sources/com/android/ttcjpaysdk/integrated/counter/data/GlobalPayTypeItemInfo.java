package com.android.ttcjpaysdk.integrated.counter.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.bytedance.android.ec.core.event.a;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\nB\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/data/GlobalPayTypeItemInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "card_group_icon_url", "", "sub_items", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/integrated/counter/data/GlobalPayTypeItemInfo$SubItem;", "Lkotlin/collections/ArrayList;", "SubItem", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GlobalPayTypeItemInfo implements CJPayObject, Serializable {
    public String card_group_icon_url;
    public ArrayList<SubItem> sub_items;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/data/GlobalPayTypeItemInfo$SubItem;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", a.KEY_BUTTON_TYPE, "", "current_value", "default_tip", "jump_url", "title", "type", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SubItem implements CJPayObject, Serializable {
        public String button_type;
        public String current_value;
        public String default_tip;
        public String jump_url;
        public String title;
        public String type;

        public SubItem() {
            this.type = "";
            this.title = "";
            this.default_tip = "";
            this.current_value = "";
            this.button_type = "";
            this.jump_url = "";
        }
    }

    public GlobalPayTypeItemInfo() {
        this.card_group_icon_url = "";
        this.sub_items = new ArrayList();
    }
}
