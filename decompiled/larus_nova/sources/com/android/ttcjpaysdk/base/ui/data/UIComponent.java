package com.android.ttcjpaysdk.base.ui.data;

import androidx.core.provider.FontsContractCompat;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.ss.android.ugc.aweme.discover.model.CommodityText;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\r\u0010\u0015\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0016J\u0006\u0010\u0017\u001a\u00020\u0018R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0014\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/UIComponent;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "bg", "", CommodityText.BOLD, "border", "color", "font_size", "", "Ljava/lang/Integer;", FontsContractCompat.Columns.WEIGHT, "header", "height", "id", "link", "text", "type", "url", "width", "getValidFontSize", "()Ljava/lang/Integer;", "isBold", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UIComponent implements CJPayObject, Serializable {

    /* JADX INFO: renamed from: bg, reason: collision with root package name */
    public String f29368bg;
    public String bold;
    public String border;
    public String color;
    public Integer font_size;
    public Integer font_weight;
    public String header;
    public int height;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public String f29369id;
    public String link;
    public String text;
    public String type;
    public String url;
    public int width;

    public final Integer getValidFontSize() {
        Integer r100 = this.font_size;
        if (r100 == null) goto L12;
        int r101 = r100.intValue();
        boolean r102 = false;
        if (8 <= r101) goto L7;
    L9:
        if (r102 == false) goto L12;
        return r100;
    L7:
        if (r101 >= 49) goto L9;
        r102 = true;
    L12:
        return null;
    }

    public final boolean isBold() {
        if (Intrinsics.areEqual(this.bold, "1") == true) goto L17;
        Integer r100 = this.font_weight;
        if (r100 != null) goto L7;
    L12:
        boolean r101 = false;
    L13:
        if (r101 == true) goto L18;
        return false;
    L18:
        return true;
    L7:
        if (r100.intValue() < 500) goto L9;
        boolean r102 = true;
    L10:
        if (r102 != true) goto L12;
        r101 = true;
        goto L13
    L9:
        r102 = false;
        goto L10
    L17:
        return true;
    }

    public UIComponent() {
        this.type = "";
        this.f29369id = "";
    }
}
