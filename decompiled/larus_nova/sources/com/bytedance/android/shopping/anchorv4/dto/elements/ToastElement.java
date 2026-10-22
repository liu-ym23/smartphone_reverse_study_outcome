package com.bytedance.android.shopping.anchorv4.dto.elements;

import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002BM\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0019\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\bHÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003JX\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\f2\b\u0010#\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\tHÖ\u0001R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\r\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R&\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/elements/ToastElement;", "Ljava/io/Serializable;", "()V", "content", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "duration", "", "trackParams", "Lcom/google/gson/internal/LinkedTreeMap;", "", "", "showInFull", "", "toastContent", "(Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;Ljava/lang/Float;Lcom/google/gson/internal/LinkedTreeMap;Ljava/lang/Boolean;Ljava/lang/String;)V", "getContent", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "getDuration", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getShowInFull", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getToastContent", "()Ljava/lang/String;", "getTrackParams", "()Lcom/google/gson/internal/LinkedTreeMap;", "component1", "component2", "component3", "component4", "component5", "copy", "(Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;Ljava/lang/Float;Lcom/google/gson/internal/LinkedTreeMap;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/bytedance/android/shopping/anchorv4/dto/elements/ToastElement;", "equals", "other", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToastElement implements Serializable {

    @SerializedName("content")
    private final TextWithOneIconElement content;

    @SerializedName("duration")
    private final Float duration;

    @SerializedName("show_in_full")
    private final Boolean showInFull;

    @SerializedName("toast_content")
    private final String toastContent;

    @SerializedName("track_params")
    private final LinkedTreeMap<String, Object> trackParams;

    public ToastElement() {
        this(null, null, null, null, null, 24, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ToastElement copy$default(ToastElement r100, TextWithOneIconElement r101, Float r102, LinkedTreeMap r103, Boolean r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.content;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.duration;
    L8:
        Float r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.trackParams;
    L11:
        LinkedTreeMap r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.showInFull;
    L14:
        Boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.toastContent;
    L17:
        TextWithOneIconElement r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final TextWithOneIconElement component1() {
        return this.content;
    }

    public final Float component2() {
        return this.duration;
    }

    public final LinkedTreeMap<String, Object> component3() {
        return this.trackParams;
    }

    public final Boolean component4() {
        return this.showInFull;
    }

    public final String component5() {
        return this.toastContent;
    }

    public final ToastElement copy(TextWithOneIconElement r100, Float r101, LinkedTreeMap<String, Object> r110, Boolean r111, String r112) {
        return new ToastElement(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ToastElement) == false) goto L16;
        ToastElement r101 = (ToastElement) r100;
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.duration, r101.duration) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.trackParams, r101.trackParams) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.showInFull, r101.showInFull) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.toastContent, r101.toastContent) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        TextWithOneIconElement r100 = this.content;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Float r104 = this.duration;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        LinkedTreeMap<String, Object> r107 = this.trackParams;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.showInFull;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.toastContent;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ToastElement(content=" + this.content + ", duration=" + this.duration + ", trackParams=" + this.trackParams + ", showInFull=" + this.showInFull + ", toastContent=" + this.toastContent + ")";
    }

    public final TextWithOneIconElement getContent() {
        return this.content;
    }

    public final Float getDuration() {
        return this.duration;
    }

    public final Boolean getShowInFull() {
        return this.showInFull;
    }

    public final String getToastContent() {
        return this.toastContent;
    }

    public final LinkedTreeMap<String, Object> getTrackParams() {
        return this.trackParams;
    }

    public ToastElement(TextWithOneIconElement r100, Float r101, LinkedTreeMap<String, Object> r102, Boolean r103, String r104) {
        this.content = r100;
        this.duration = r101;
        this.trackParams = r102;
        this.showInFull = r103;
        this.toastContent = r104;
    }

    public /* synthetic */ ToastElement(TextWithOneIconElement r100, Float r101, LinkedTreeMap r110, Boolean r111, String r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 1) == 0) goto L5;
        TextWithOneIconElement r102 = null;
    L7:
        if ((r113 & 2) == 0) goto L9;
        r101 = Float.valueOf(0);
    L9:
        Float r103 = r101;
        if ((r113 & 8) == 0) goto L12;
        r111 = Boolean.TRUE;
    L12:
        Boolean r104 = r111;
        if ((r113 & 16) == 0) goto L15;
        String r105 = null;
    L16:
        this(r102, r103, r110, r104, r105);
        return;
    L15:
        r105 = r112;
        goto L16
    L5:
        r102 = r100;
        goto L7
    }
}
