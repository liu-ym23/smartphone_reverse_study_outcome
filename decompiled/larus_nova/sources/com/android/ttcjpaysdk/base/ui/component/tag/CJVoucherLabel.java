package com.android.ttcjpaysdk.base.ui.component.tag;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/tag/CJVoucherLabel;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "icon_url", "", "img_base64", VideoThumbInfo.KEY_IMG_URL, "text", "type", "voucher_type", "width", "", "isPictureType", "", "isTextType", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJVoucherLabel implements CJPayObject, Serializable {
    public String icon_url;
    public String img_base64;
    public String img_url;
    public String text;
    public String type;
    public String voucher_type;
    public int width;

    public final boolean isPictureType() {
        return TextUtils.equals(this.type, "picture");
    }

    public final boolean isTextType() {
        return TextUtils.equals(this.type, "text");
    }

    public CJVoucherLabel() {
        this.text = "";
        this.type = "";
        this.icon_url = "";
        this.img_url = "";
        this.img_base64 = "";
        this.voucher_type = "";
    }
}
