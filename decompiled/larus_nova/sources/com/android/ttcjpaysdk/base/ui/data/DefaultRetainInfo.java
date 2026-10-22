package com.android.ttcjpaysdk.base.ui.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B=\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0013\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0003JA\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/DefaultRetainInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "bottom_retain_button_text", "", "title", "top_retain_button_text", "retain_questionnaire", "", "Lcom/android/ttcjpaysdk/base/ui/data/UIComponent;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DefaultRetainInfo implements CJPayObject, Serializable {
    public String bottom_retain_button_text;
    public List<UIComponent> retain_questionnaire;
    public String title;
    public String top_retain_button_text;

    public DefaultRetainInfo() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DefaultRetainInfo copy$default(DefaultRetainInfo r100, String r101, String r102, String r103, List r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.bottom_retain_button_text;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.title;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.top_retain_button_text;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.retain_questionnaire;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.bottom_retain_button_text;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.top_retain_button_text;
    }

    public final List<UIComponent> component4() {
        return this.retain_questionnaire;
    }

    public final DefaultRetainInfo copy(String r100, String r101, String r102, List<UIComponent> r103) {
        return new DefaultRetainInfo(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DefaultRetainInfo) == true) goto L8;
        return false;
    L8:
        DefaultRetainInfo r101 = (DefaultRetainInfo) r100;
        if (Intrinsics.areEqual(this.bottom_retain_button_text, r101.bottom_retain_button_text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.top_retain_button_text, r101.top_retain_button_text) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.retain_questionnaire, r101.retain_questionnaire) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.bottom_retain_button_text;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.title;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.top_retain_button_text;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<UIComponent> r110 = this.retain_questionnaire;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "DefaultRetainInfo(bottom_retain_button_text=" + this.bottom_retain_button_text + ", title=" + this.title + ", top_retain_button_text=" + this.top_retain_button_text + ", retain_questionnaire=" + this.retain_questionnaire + ')';
    }

    public DefaultRetainInfo(String r100, String r101, String r102, List<UIComponent> r103) {
        this.bottom_retain_button_text = r100;
        this.title = r101;
        this.top_retain_button_text = r102;
        this.retain_questionnaire = r103;
    }

    public /* synthetic */ DefaultRetainInfo(String r100, String r101, String r102, List r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
