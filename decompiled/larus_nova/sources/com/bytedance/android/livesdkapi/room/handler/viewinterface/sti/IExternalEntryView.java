package com.bytedance.android.livesdkapi.room.handler.viewinterface.sti;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/sti/IExternalEntryView;", "", "view", "Landroid/view/View;", "displayDuration", "", "(Landroid/view/View;J)V", "getDisplayDuration", "()J", "getView", "()Landroid/view/View;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IExternalEntryView {
    private final long displayDuration;
    private final View view;

    public static /* synthetic */ IExternalEntryView copy$default(IExternalEntryView r100, View r101, long r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.view;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.displayDuration;
    L9:
        return r100.copy(r101, r102);
    }

    public final View component1() {
        return this.view;
    }

    public final long component2() {
        return this.displayDuration;
    }

    public final IExternalEntryView copy(View r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        return new IExternalEntryView(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof IExternalEntryView) == false) goto L10;
        IExternalEntryView r101 = (IExternalEntryView) r100;
        if (Intrinsics.areEqual(this.view, r101.view) == true) goto L8;
        return false;
    L8:
        if (this.displayDuration == r101.displayDuration) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        View r100 = this.view;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        long r102 = this.displayDuration;
        return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
    L5:
        r101 = 0;
        goto L6
    }

    public String toString() {
        return "IExternalEntryView(view=" + this.view + ", displayDuration=" + this.displayDuration + ")";
    }

    public final long getDisplayDuration() {
        return this.displayDuration;
    }

    public final View getView() {
        return this.view;
    }

    public IExternalEntryView(View r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.view = r100;
        this.displayDuration = r101;
    }

    public /* synthetic */ IExternalEntryView(View r100, long r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = 1000;
    L5:
        this(r100, r101);
    }
}
