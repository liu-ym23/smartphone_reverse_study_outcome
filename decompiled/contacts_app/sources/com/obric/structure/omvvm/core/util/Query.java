package com.obric.structure.omvvm.core.util;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.android.contacts.common.SimContactsConstants;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.obric.contactsdk.loader.ContractKt;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.structure.omvvm.core.presenter.QContext;
import com.obric.structure.omvvm.core.ui.QUIManager;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Query.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00002\b\b\u0001\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u00020\u00002\b\b\u0001\u0010\u001b\u001a\u00020\u0019J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\u001e\u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0012\u0010!\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002J\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u001dJ&\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u0019J\u0010\u0010(\u001a\u00020\u00002\b\b\u0001\u0010)\u001a\u00020\u0019J!\u0010*\u001a\u0004\u0018\u0001H+\"\n\b\u0000\u0010+*\u0004\u0018\u00010\u00032\u0006\u0010)\u001a\u00020\u0019¢\u0006\u0002\u0010,J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u00012\u0006\u0010)\u001a\u00020\u0019J\u0006\u0010-\u001a\u00020\u0000J\u0010\u0010.\u001a\u00020\u00002\b\u0010/\u001a\u0004\u0018\u000100J\u0010\u0010.\u001a\u00020\u00002\b\u00101\u001a\u0004\u0018\u000102J\u0010\u0010.\u001a\u00020\u00002\b\b\u0001\u00103\u001a\u00020\u0019J\u0006\u00104\u001a\u00020\u0000J\u0006\u00105\u001a\u00020\u0000J\u0006\u00106\u001a\u00020\u001dJ\u0010\u00107\u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u000108J\u000e\u00109\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u001dJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0001J\u0016\u0010\r\u001a\u00020\u00002\u0006\u0010:\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\u0001J\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0010\u001a\u00020\u00002\b\b\u0001\u00103\u001a\u00020\u0019J\u0010\u0010;\u001a\u00020\u00002\b\b\u0001\u0010\u0018\u001a\u00020\u0019J\u0010\u0010<\u001a\u00020\u00002\b\b\u0001\u0010)\u001a\u00020\u0019J\u000e\u0010=\u001a\u00020\u00002\u0006\u0010>\u001a\u00020\u0016J\u000e\u0010=\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u0019J\u0016\u0010=\u001a\u00020\u00002\u0006\u0010?\u001a\u00020\u00192\u0006\u0010>\u001a\u00020\u0016J\u000e\u0010@\u001a\u00020\u00002\u0006\u0010A\u001a\u00020BJ\u0017\u0010\u0002\u001a\u0002H+\"\b\b\u0000\u0010+*\u00020\u0003H\u0007¢\u0006\u0002\u0010CJ\u0019\u0010D\u001a\u0004\u0018\u0001H+\"\n\b\u0000\u0010+*\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010CJ\u000e\u0010E\u001a\u00020\u00002\u0006\u0010E\u001a\u00020\u0019J\u0006\u0010F\u001a\u00020\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/obric/structure/omvvm/core/util/Query;", "", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "holder", "Landroid/util/SparseArray;", "qContext", "Lcom/obric/structure/omvvm/core/presenter/QContext;", "getQContext", "()Lcom/obric/structure/omvvm/core/presenter/QContext;", "setQContext", "(Lcom/obric/structure/omvvm/core/presenter/QContext;)V", SimContactsConstants.STR_TAG, "getTag", "()Ljava/lang/Object;", "text", "", "getText", "()Ljava/lang/CharSequence;", "alpha", "", "", "backgroundColor", "color", "", "backgroundColorId", "colorResId", MaterialConfigFormatNames.CHECKED, "", "clickListener", "listener", "Landroid/view/View$OnClickListener;", ContractKt.OBRIC_ACTION_CREATE, "enabled", "expandTouchSize", "left", "top", "right", "bottom", "find", "id", "findViewByIdFromParent", ExifInterface.GPS_DIRECTION_TRUE, "(I)Landroid/view/View;", "gone", SlardarSettingsConsts.SETTING_IMAGE, "bm", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", "resId", "imageBitmapNull", "invisible", "isVisible", "longClickListener", "Landroid/view/View$OnLongClickListener;", "select", "key", "textColor", "textColorId", "textSize", PerfConsts.PERF_DISK_FILE_SIZE, "unit", "typeface", "tf", "Landroid/graphics/Typeface;", "()Landroid/view/View;", "viewNullable", "visibility", "visible", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Query {
    private final SparseArray<View> holder;
    private QContext qContext;
    private final View view;

    public Query(View r1) {
        this.view = r1;
        this.holder = new SparseArray();
    }

    public static final /* synthetic */ View access$getView$p(Query r0) {
        return r0.view;
    }

    public final QContext getQContext() {
        return this.qContext;
    }

    public final void setQContext(QContext r1) {
        this.qContext = r1;
    }

    private final Query create(View r1) {
        return new Query(r1);
    }

    public final Query find(int r3) {
        View r0 = this.holder.get(r3);
        if (r0 != null) goto L7;
        View r1 = this.view;
        if (r1 == null) goto L7;
        r0 = r1.findViewById(r3);
    L7:
        this.holder.put(r3, r0);
        return create(r0);
    }

    @Deprecated(message = "view 可能为空", replaceWith = @ReplaceWith(expression = "this.viewNullable()", imports = {}))
    public final <T extends View> T view() {
        T r1 = (T) this.view;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type T of com.obric.structure.omvvm.core.util.Query.view");
        return r1;
    }

    public final <T extends View> T viewNullable() {
        T r1 = (T) this.view;
        if ((r1 instanceof View) == true) goto L7;
        return null;
    L7:
        return r1;
    }

    public final Query text(int r3) {
        View r0 = this.view;
        if ((r0 instanceof TextView) == false) goto L5;
        ((TextView) r0).setText(r3);
    L5:
        return this;
    }

    public final Query text(CharSequence r3) {
        View r0 = this.view;
        if ((r0 instanceof TextView) == false) goto L5;
        ((TextView) r0).setText(r3);
    L5:
        return this;
    }

    public final Query textColor(int r3) {
        View r0 = this.view;
        if ((r0 instanceof TextView) == false) goto L5;
        ((TextView) r0).setTextColor(r3);
    L5:
        return this;
    }

    public final Query textColorId(int r3) {
        View r0 = this.view;
        if ((r0 instanceof TextView) == false) goto L5;
        ((TextView) r0).setTextColor(((TextView) r0).getResources().getColor(r3));
    L5:
        return this;
    }

    public final Query typeface(Typeface r3) {
        Intrinsics.checkNotNullParameter(r3, "tf");
        View r0 = this.view;
        if ((r0 instanceof TextView) == false) goto L5;
        ((TextView) r0).setTypeface(r3);
    L5:
        return this;
    }

    public final Query textSize(float r3) {
        View r0 = this.view;
        if ((r0 instanceof TextView) == false) goto L5;
        ((TextView) r0).setTextSize(r3);
    L5:
        return this;
    }

    public final Query textSize(int r3) {
        View r0 = this.view;
        if ((r0 instanceof TextView) == false) goto L5;
        ((TextView) r0).setTextSize(0, ((TextView) r0).getContext().getResources().getDimension(r3));
    L5:
        return this;
    }

    public final Query textSize(int r3, float r4) {
        View r0 = this.view;
        if ((r0 instanceof TextView) == false) goto L5;
        ((TextView) r0).setTextSize(r3, r4);
    L5:
        return this;
    }

    public final Query image(int r3) {
        View r0 = this.view;
        if ((r0 instanceof ImageView) == false) goto L7;
        if (r3 != 0) goto L6;
        ((ImageView) r0).setImageBitmap(null);
        goto L7
    L6:
        ((ImageView) r0).setImageResource(r3);
    L7:
        return this;
    }

    public final Query image(Drawable r3) {
        View r0 = this.view;
        if ((r0 instanceof ImageView) == false) goto L5;
        ((ImageView) r0).setImageDrawable(r3);
    L5:
        return this;
    }

    public final Query image(Bitmap r3) {
        View r0 = this.view;
        if ((r0 instanceof ImageView) == false) goto L5;
        ((ImageView) r0).setImageBitmap(r3);
    L5:
        return this;
    }

    public final Query imageBitmapNull() {
        View r0 = this.view;
        if ((r0 instanceof ImageView) == false) goto L5;
        ((ImageView) r0).setImageBitmap(null);
    L5:
        return this;
    }

    public final Query tag(Object r2) {
        Intrinsics.checkNotNullParameter(r2, SimContactsConstants.STR_TAG);
        View r0 = this.view;
        if (r0 == null) goto L5;
        r0.setTag(r2);
    L5:
        return this;
    }

    public final Query tag(int r2, Object r3) {
        Intrinsics.checkNotNullParameter(r3, SimContactsConstants.STR_TAG);
        View r0 = this.view;
        if (r0 == null) goto L5;
        r0.setTag(r2, r3);
    L5:
        return this;
    }

    public final Query enabled(boolean r2) {
        View r0 = this.view;
        if (r0 == null) goto L5;
        r0.setEnabled(r2);
    L5:
        return this;
    }

    public final Query checked(boolean r3) {
        KeyEvent.Callback r0 = this.view;
        if ((r0 instanceof Checkable) == false) goto L5;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.widget.Checkable");
        ((Checkable) r0).setChecked(r3);
    L5:
        return this;
    }

    public final Query select(boolean r2) {
        View r0 = this.view;
        if (r0 == null) goto L5;
        r0.setSelected(r2);
    L5:
        return this;
    }

    public final Query gone() {
        return visibility(8);
    }

    public final Query invisible() {
        return visibility(4);
    }

    public final Query visible() {
        return visibility(0);
    }

    public final Query visibility(int r2) {
        View r0 = this.view;
        if (r0 != null) goto L5;
    L7:
        return this;
    L5:
        if (r0.getVisibility() == r2) goto L7;
        this.view.setVisibility(r2);
        goto L7
    }

    public final boolean isVisible() {
        View r0 = this.view;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getVisibility() != 0) goto L10;
        return true;
    L10:
        return false;
    }

    public final void alpha(float r1) {
        View r0 = this.view;
        if (r0 == null) goto L6;
        r0.setAlpha(r1);
        return;
    }

    public final Query backgroundColor(int r2) {
        View r0 = this.view;
        if (r0 == null) goto L5;
        r0.setBackgroundColor(r2);
    L5:
        return this;
    }

    public final Query backgroundColorId(int r3) {
        View r0 = this.view;
        if (r0 == null) goto L5;
        r0.setBackgroundColor(r0.getContext().getResources().getColor(r3));
    L5:
        return this;
    }

    public final Object getTag() {
        View r0 = this.view;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getTag();
    }

    public final Object getTag(int r1) {
        View r0 = this.view;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getTag(r1);
    }

    public final CharSequence getText() {
        View r1 = this.view;
        if ((r1 instanceof TextView) == true) goto L7;
        return null;
    L7:
        return ((TextView) r1).getText();
    }

    public final Query clickListener(View.OnClickListener r2) {
        View r0 = this.view;
        if (r0 == null) goto L5;
        r0.setOnClickListener(r2);
    L5:
        return this;
    }

    public final Query longClickListener(View.OnLongClickListener r2) {
        View r0 = this.view;
        if (r0 == null) goto L5;
        r0.setOnLongClickListener(r2);
    L5:
        return this;
    }

    public final Query expandTouchSize(final int r9, final int r10, final int r11, final int r12) {
        View r0 = this.view;
        if (r0 != null) goto L5;
    L12:
        return this;
    L5:
        if (ViewCompat.isLaidOut(r0) == true) goto L7;
    L11:
        r0.addOnLayoutChangeListener(new Query$expandTouchSize$$inlined$doOnLayout$1(this, r10, r12, r9, r11));
        goto L12
    L7:
        if (r0.isLayoutRequested() == true) goto L11;
        Rect r1 = new Rect();
        access$getView$p(this).getHitRect(r1);
        r1.top -= r10;
        r1.bottom += r12;
        r1.left -= r9;
        r1.right += r11;
        TouchDelegate r13 = new TouchDelegate(r1, access$getView$p(this));
        if (View.class.isInstance(access$getView$p(this).getParent()) == false) goto L12;
        Object r14 = access$getView$p(this).getParent();
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type android.view.View");
        ((View) r14).setTouchDelegate(r13);
        goto L12
    }

    public final <T extends View> T findViewByIdFromParent(int r5) {
        View r0 = this.holder.get(r5);
        ViewGroup r2 = null;
        if ((r0 instanceof View) == false) goto L5;
        T r1 = (T) r0;
    L6:
        if (r1 != null) goto L48;
        View r3 = this.view;
        if (r3 != null) goto L10;
        return r1;
    L10:
        if ((r3 instanceof ViewGroup) == false) goto L12;
        ViewGroup r4 = (ViewGroup) r3;
    L13:
        QContext r6 = this.qContext;
        if (r6 == null) goto L18;
        QUIManager r7 = r6.getUiManager();
        if (r7 == null) goto L18;
        View r8 = r7.rootView();
    L19:
        if (r4 == null) goto L31;
        if (r4.getParent() == null) goto L31;
        if (r4.getId() == r5) goto L31;
        ViewParent r9 = r4.getParent();
        if ((r9 instanceof ViewGroup) == false) goto L27;
        r4 = (ViewGroup) r9;
    L28:
        if (r8 == null) goto L19;
        if (Intrinsics.areEqual(r4, r8) == false) goto L19;
    L27:
        r4 = null;
    L31:
        if (r4 != null) goto L33;
    L35:
        if (r4 == null) goto L37;
        r2 = r4.findViewById(r5);
    L37:
        this.holder.put(r5, r2);
        return (T) r2;
    L33:
        if (r4.getId() != r5) goto L35;
        r2 = r4;
    L18:
        r8 = null;
        goto L19
    L12:
        r4 = null;
        goto L13
    L48:
        return r1;
    L5:
        r1 = null;
        goto L6
    }
}
