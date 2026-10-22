package com.android.ttcjpaysdk.verify.data.product;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.ss.android.ugc.aweme.discover.model.CommodityText;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/verify/data/product/ContentListItem;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "text", "", "color", CommodityText.BOLD, "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ContentListItem implements CJPayObject {
    public boolean bold;
    public String color;
    public String text;

    public ContentListItem() {
        this(null, null, false, 7, null);
    }

    public ContentListItem(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "color");
        this.text = r100;
        this.color = r101;
        this.bold = r102;
    }

    public /* synthetic */ ContentListItem(String r100, String r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = false;
    L11:
        this(r100, r101, r102);
    }
}
