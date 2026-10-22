package com.android.ttcjpaysdk.bdpay.counter.outer.preload;

import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tR\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/preload/PreloadXMLInfo;", "", "layoutName", "", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "inflateCount", "", "layoutId", "(Ljava/lang/String;Landroid/view/ViewGroup$LayoutParams;II)V", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PreloadXMLInfo {
    public int inflateCount;
    public int layoutId;
    public String layoutName;
    public ViewGroup.LayoutParams layoutParams;

    public PreloadXMLInfo() {
        this(null, null, 0, 0, 15, null);
    }

    public PreloadXMLInfo(String r100, ViewGroup.LayoutParams r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "layoutName");
        this.layoutName = r100;
        this.layoutParams = r101;
        this.inflateCount = r102;
        this.layoutId = r103;
    }

    public /* synthetic */ PreloadXMLInfo(String r100, ViewGroup.LayoutParams r101, int r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 1;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 0;
    L14:
        this(r100, r101, r102, r103);
    }
}
