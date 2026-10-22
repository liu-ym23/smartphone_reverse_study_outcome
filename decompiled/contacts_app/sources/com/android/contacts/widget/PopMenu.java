package com.android.contacts.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.android.contacts.common.SimContactsConstants;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.popover.OPopover;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: PopMenu.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0013\u0010\u001c\u001a\u0004\u0018\u0001H\u001d\"\u0004\b\u0000\u0010\u001d¢\u0006\u0002\u0010\u001eJ\u0006\u0010\u001f\u001a\u00020\rJ0\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001b0'J:\u0010 \u001a\u00020\u001b2\b\u0010(\u001a\u0004\u0018\u00010\u00012\u0006\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001b0'R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u000bR\u001a\u0010\u0014\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\t\"\u0004\b\u0016\u0010\u000bR\u001a\u0010\u0017\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\t\"\u0004\b\u0019\u0010\u000b¨\u0006)"}, d2 = {"Lcom/android/contacts/widget/PopMenu;", "", "()V", "currMenu", "Lcom/obric/oui/popover/OPopover;", "currTag", "gravity", "", "getGravity", "()I", "setGravity", "(I)V", "isMiddle", "", "()Z", "setMiddle", "(Z)V", "offsetX", "getOffsetX", "setOffsetX", "offsetY", "getOffsetY", "setOffsetY", MaterialConfigFormatNames.WIDTH, "getWidth", "setWidth", "dismiss", "", "getTag", ExifInterface.GPS_DIRECTION_TRUE, "()Ljava/lang/Object;", "isShowed", "show", "anchor", "Landroid/view/View;", "items", "", "Lcom/android/contacts/widget/PopMenuItem;", "listener", "Lkotlin/Function1;", SimContactsConstants.STR_TAG, "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PopMenu {
    private OPopover currMenu;
    private Object currTag;
    private int gravity;
    private boolean isMiddle;
    private int offsetX;
    private int offsetY;
    private int width;

    /* JADX INFO: renamed from: $r8$lambda$QSg-6leDW6WNCzngA_PAHFBmdoM, reason: not valid java name */
    public static /* synthetic */ void m230$r8$lambda$QSg6leDW6WNCzngA_PAHFBmdoM(PopMenu r0) {
        show$lambda$3$lambda$2(r0);
    }

    public PopMenu() {
        this.width = MathKt.roundToInt(TypedValue.applyDimension(1, 200, Resources.getSystem().getDisplayMetrics()));
        this.gravity = 48;
        this.isMiddle = true;
    }

    public final int getOffsetX() {
        return this.offsetX;
    }

    public final void setOffsetX(int r1) {
        this.offsetX = r1;
    }

    public final int getOffsetY() {
        return this.offsetY;
    }

    public final void setOffsetY(int r1) {
        this.offsetY = r1;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setWidth(int r1) {
        this.width = r1;
    }

    public final int getGravity() {
        return this.gravity;
    }

    public final void setGravity(int r1) {
        this.gravity = r1;
    }

    public final boolean isMiddle() {
        return this.isMiddle;
    }

    public final void setMiddle(boolean r1) {
        this.isMiddle = r1;
    }

    public final void show(View r2, List<? extends PopMenuItem> r3, Function1<? super Integer, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "anchor");
        Intrinsics.checkNotNullParameter(r3, "items");
        Intrinsics.checkNotNullParameter(r4, "listener");
        show(null, r2, r3, r4);
    }

    public final void show(Object r23, final View r24, List<? extends PopMenuItem> r25, final Function1<? super Integer, Unit> r26) {
        Intrinsics.checkNotNullParameter(r24, "anchor");
        Intrinsics.checkNotNullParameter(r25, "items");
        Intrinsics.checkNotNullParameter(r26, "listener");
        dismiss();
        Context r3 = r24.getContext();
        if ((r3 instanceof Activity) == false) goto L5;
        Activity r4 = (Activity) r3;
    L6:
        if (r4 != null) goto L9;
        return;
    L9:
        if (r4.isFinishing() == false) goto L11;
        return;
    L11:
        OPopover.Builder r5 = new OPopover.Builder(r4);
        OPopoverEntranceMenuView.Builder r6 = new OPopoverEntranceMenuView.Builder(r4);
        r6.setItemWidth(this.width);
        Iterator<T> r1 = r25.iterator();
    L13:
        if (r1.hasNext() == false) goto L15;
        final PopMenuItem r7 = (PopMenuItem) r1.next();
        OPopoverEntranceMenuView.Builder.addPopoverItem$default(r6, Integer.valueOf(r7.getIcon()), null, null, r7.getTitle(), r7.getDesc(), null, false, null, new PopMenu$show$popover$1$1$1(r26, r7, this), 230, null);
        goto L13
    L15:
        OPopover r10 = r5.setView(r6.build()).build();
        r10.setOnDismissListener(new PopMenu$$ExternalSyntheticLambda0(this));
        r10.show(r24, this.gravity, this.isMiddle, 0.0f, this.offsetX, this.offsetY, false);
        if (ViewCompat.isAttachedToWindow(r24) == true) goto L18;
        dismiss();
    L19:
        this.currMenu = r10;
        this.currTag = r23;
        return;
    L18:
        r24.addOnAttachStateChangeListener(new PopMenu$show$$inlined$doOnDetach$1(r24, this));
        goto L19
    L5:
        r4 = null;
        goto L6
    }

    private static final void show$lambda$3$lambda$2(PopMenu r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.dismiss();
    }

    public final void dismiss() {
        OPopover r0 = this.currMenu;
        if (r0 == null) goto L5;
        r0.dismiss();
    L5:
        this.currMenu = null;
        this.currTag = null;
    }

    public final <T> T getTag() {
        T r0 = (T) this.currTag;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0;
    }

    public final boolean isShowed() {
        OPopover r2 = this.currMenu;
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.isShowing() == true) goto L7;
        return false;
    L7:
        return true;
    }
}
