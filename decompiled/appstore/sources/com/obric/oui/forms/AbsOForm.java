package com.obric.oui.forms;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R>\u0010!\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0017j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018`\u001a8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010#R\u0016\u0010&\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010#R\"\u0010)\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b\u000f\u0010\u000e¨\u0006+"}, d2 = {"Lcom/obric/oui/forms/AbsOForm;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "b", "", "setInScrollView1", "(Z)V", "setInScrollView", "Landroid/widget/EditText;", "getInterEditText", "()Landroid/widget/EditText;", "Landroid/view/MotionEvent;", "ev", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "Ljava/util/ArrayList;", "Ljava/lang/ref/WeakReference;", "Landroid/text/TextWatcher;", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "getTextWatchers", "()Ljava/util/ArrayList;", "setTextWatchers", "(Ljava/util/ArrayList;)V", "textWatchers", "", "F", "lastScrollY", "c", "lastScrollX", "d", "Z", "isInScrollView", "()Z", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsOForm extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f14580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f14581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f14582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f14583d;

    @JvmOverloads
    public AbsOForm(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r10) {
        if (r10 == null) goto L36;
        if (this.f14583d == false) goto L36;
        float r11 = r10.getX();
        float r12 = r10.getY();
        int r13 = r10.getAction();
        if (r13 != 0) goto L8;
        this.f14581b = r12;
        goto L36
    L8:
        if (r13 != 1) goto L10;
        super.requestDisallowInterceptTouchEvent(false);
        goto L36
    L10:
        if (r13 != 2) goto L12;
        EditText r14 = getInterEditText();
        q.d(r14);
        if (r11 <= this.f14582c) goto L20;
        if (r14.canScrollHorizontally(-1) == false) goto L20;
    L31:
        super.requestDisallowInterceptTouchEvent(true);
    L32:
        this.f14582c = r11;
        this.f14581b = r12;
    L20:
        if (r11 >= this.f14582c) goto L24;
        if (r14.canScrollHorizontally(1) == true) goto L31;
    L24:
        if (r12 >= this.f14581b) goto L28;
        if (r14.canScrollVertically(1) == true) goto L31;
    L28:
        if (r12 <= this.f14581b) goto L32;
        if (r14.canScrollVertically(-1) == false) goto L32;
    L12:
        if (r13 != 3) goto L36;
        super.requestDisallowInterceptTouchEvent(false);
    L36:
        return super.dispatchTouchEvent(r10);
    }

    @NotNull
    public abstract EditText getInterEditText();

    @NotNull
    public final ArrayList<WeakReference<TextWatcher>> getTextWatchers() {
        return this.f14580a;
    }

    public final void setInScrollView(boolean r10) {
        this.f14583d = r10;
    }

    @JvmName(name = "setInScrollView1")
    public final void setInScrollView1(boolean r10) {
        this.f14583d = r10;
    }

    public final void setTextWatchers(@NotNull ArrayList<WeakReference<TextWatcher>> r10) {
        q.g(r10, "<set-?>");
        this.f14580a = r10;
    }

    @JvmOverloads
    public AbsOForm(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ AbsOForm(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public AbsOForm(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f14580a = new ArrayList();
    }
}
