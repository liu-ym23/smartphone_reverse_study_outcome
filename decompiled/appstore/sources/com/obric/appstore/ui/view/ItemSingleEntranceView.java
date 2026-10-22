package com.obric.appstore.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedanceos.common.ui.widget.oui.ViewExtKt;
import com.obric.appstore.R;
import com.obric.oui.layout.OUIFrameLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yf.b;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/obric/appstore/ui/view/ItemSingleEntranceView;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/view/MotionEvent;", "event", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "Landroid/graphics/drawable/Drawable;", "drawable", "", "a", "(Landroid/graphics/drawable/Drawable;)V", "", "title", "b", "(Ljava/lang/String;)V", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "vIcon", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "vTitle", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nItemSingleEntranceView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ItemSingleEntranceView.kt\ncom/obric/appstore/ui/view/ItemSingleEntranceView\n+ 2 OUnitExtension.kt\ncom/obric/oui/common/util/OUnitExtensionKt\n*L\n1#1,58:1\n181#2,3:59\n180#2,5:62\n181#2,3:67\n180#2,5:70\n*S KotlinDebug\n*F\n+ 1 ItemSingleEntranceView.kt\ncom/obric/appstore/ui/view/ItemSingleEntranceView\n*L\n35#1:59,3\n35#1:62,5\n37#1:67,3\n37#1:70,5\n*E\n"})
public final class ItemSingleEntranceView extends OUIFrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f11050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f11051b;

    @JvmOverloads
    public ItemSingleEntranceView(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public final void a(Drawable r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.f11050a.setImageDrawable(r10);
    }

    public final void b(String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.f11051b.setText(r10);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r10) {
        q.g(r10, "event");
        if (isEnabled() == true) goto L7;
        return false;
    L7:
        return super.dispatchTouchEvent(r10);
    }

    @JvmOverloads
    public ItemSingleEntranceView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ ItemSingleEntranceView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public ItemSingleEntranceView(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12, null, 8, null);
        LayoutInflater.from(r10).inflate(R.layout.item_single_entrance_view, this);
        this.f11050a = (ImageView) ViewExtKt.findView(this, R.id.entrance_icon);
        this.f11051b = (TextView) ViewExtKt.findView(this, R.id.entrance_name);
        TypedArray r13 = r10.obtainStyledAttributes(r11, R.styleable.ItemSingleEntranceView);
        q.f(r13, "obtainStyledAttributes(...)");
        a(r13.getDrawable(R.styleable.ItemSingleEntranceView_icon));
        b(r13.getString(R.styleable.ItemSingleEntranceView_title));
        r13.recycle();
        setLayoutParams(new ViewGroup.LayoutParams(b.b(TypedValue.applyDimension(1, 104, Resources.getSystem().getDisplayMetrics())), b.b(TypedValue.applyDimension(1, 56, Resources.getSystem().getDisplayMetrics()))));
        setBackgroundColor(-1);
        setRadius(b.b(TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics())));
        setChangeAlphaWhenDisable(false);
        setClickable(true);
    }
}
