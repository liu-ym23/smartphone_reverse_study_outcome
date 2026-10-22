package com.android.ttcjpaysdk.base.ui.data;

import androidx.core.provider.FontsContractCompat;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.ss.android.ugc.aweme.discover.model.CommodityText;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0015\u001a\u00020\u0016R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/CJPayUIComponent;", "Ljava/io/Serializable;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "bg", "", CommodityText.BOLD, "border", "color", "font_size", "", "Ljava/lang/Integer;", FontsContractCompat.Columns.WEIGHT, "header", "height", "icon_shape", "link", "text", "type", "url", "width", "toUIComponent", "Lcom/android/ttcjpaysdk/base/ui/data/UIComponent;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayUIComponent implements Serializable, CJPayObject {

    /* JADX INFO: renamed from: bg, reason: collision with root package name */
    public String f29367bg;
    public String bold;
    public String border;
    public String color;
    public Integer font_size;
    public Integer font_weight;
    public String header;
    public int height;
    public String icon_shape;
    public String link;
    public String text;
    public String type;
    public String url;
    public int width;

    public final UIComponent toUIComponent() {
        UIComponent r100 = new UIComponent();
        r100.type = this.type;
        r100.text = this.text;
        r100.url = this.url;
        r100.header = this.header;
        r100.f29368bg = this.f29367bg;
        r100.color = this.color;
        r100.border = this.border;
        r100.bold = this.bold;
        r100.link = this.link;
        r100.font_size = this.font_size;
        r100.font_weight = this.font_weight;
        r100.width = this.width;
        r100.height = this.height;
        return r100;
    }

    public CJPayUIComponent() {
        this.type = "";
        this.text = "";
        this.url = "";
        this.header = "";
        this.f29367bg = "";
        this.color = "";
        this.border = "";
        this.bold = "";
        this.link = "";
        this.icon_shape = "";
    }
}
