package com.stepos.agentframework.chatui.dialog;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import androidx.appcompat.widget.AppCompatTextView;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 '2\u00020\u0001:\u0001(B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\fJ/\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0018\u0010\fJ\u001f\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010!\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u001bH\u0002¢\u0006\u0004\b!\u0010\"J!\u0010#\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u001bH\u0002¢\u0006\u0004\b#\u0010\"R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/stepos/agentframework/chatui/dialog/SelectTxtContentView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LY8/t;", "onAttachedToWindow", "()V", "onDetachedFromWindow", "horiz", "vert", "oldHoriz", "oldVert", "onScrollChanged", "(IIII)V", "selStart", "selEnd", "onSelectionChanged", "(II)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "", "controller", "", "handleField", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/Object;Ljava/lang/String;)V", "target", "name", "k", "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "clipHandlesOnPreDraw", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "Companion", Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SelectTxtContentView extends AppCompatTextView {
    private static final a Companion = new a(null);

    @Deprecated
    public static final String TAG = "SelectTxtContentView";
    private final ViewTreeObserver.OnPreDrawListener clipHandlesOnPreDraw;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentframework/chatui/dialog/SelectTxtContentView$a;", "", "<init>", "()V", "", "TAG", "Ljava/lang/String;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SelectTxtContentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public static final boolean g(SelectTxtContentView selectTxtContentView) {
        selectTxtContentView.h();
        return true;
    }

    public final void h() {
        Object objB;
        Object objK;
        if (hasSelection()) {
            try {
                Result.Companion companion = Result.INSTANCE;
                objK = k(this, "mEditor");
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            if (objK == null) {
                return;
            }
            Object objK2 = k(objK, "mSelectionModifierCursorController");
            if (objK2 == null && (objK2 = j(objK, "getSelectionController")) == null) {
                return;
            }
            i(objK2, "mStartHandle");
            i(objK2, "mEndHandle");
            objB = Result.b(Y8.t.f7040a);
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.u(TAG, "clipSelectionHandlesToWindow failed: " + thE.getMessage(), false, 4, null);
            }
        }
    }

    public final void i(Object controller, String handleField) throws NoSuchFieldException, SecurityException {
        Object objK = k(controller, handleField);
        if (objK == null) {
            return;
        }
        Object objK2 = k(objK, "mContainer");
        PopupWindow popupWindow = objK2 instanceof PopupWindow ? (PopupWindow) objK2 : null;
        if (popupWindow == null) {
            return;
        }
        if (!popupWindow.isClippingEnabled()) {
            popupWindow.setClippingEnabled(true);
        }
        if (popupWindow.isShowing()) {
            try {
                Result.Companion companion = Result.INSTANCE;
                popupWindow.update();
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
    }

    public final Object j(Object target, String name) throws NoSuchMethodException, SecurityException {
        for (Class<?> superclass = target.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Method declaredMethod = superclass.getDeclaredMethod(name, null);
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke(target, null);
            } catch (NoSuchMethodException unused) {
            }
        }
        return null;
    }

    public final Object k(Object target, String name) throws NoSuchFieldException, SecurityException {
        for (Class<?> superclass = target.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField(name);
                declaredField.setAccessible(true);
                return declaredField.get(target);
            } catch (NoSuchFieldException unused) {
            }
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnPreDrawListener(this.clipHandlesOnPreDraw);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.view.View
    public void onDetachedFromWindow() {
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            viewTreeObserver = null;
        }
        if (viewTreeObserver != null) {
            viewTreeObserver.removeOnPreDrawListener(this.clipHandlesOnPreDraw);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.TextView, android.view.View
    public void onScrollChanged(int horiz, int vert, int oldHoriz, int oldVert) {
        super.onScrollChanged(horiz, vert, oldHoriz, oldVert);
        h();
    }

    @Override // android.widget.TextView
    public void onSelectionChanged(int selStart, int selEnd) {
        super.onSelectionChanged(selStart, selEnd);
        h();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectTxtContentView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.clipHandlesOnPreDraw = new ViewTreeObserver.OnPreDrawListener() { // from class: com.stepos.agentframework.chatui.dialog.C
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                return SelectTxtContentView.g(this.f22880a);
            }
        };
    }

    public /* synthetic */ SelectTxtContentView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? R.attr.textViewStyle : i10);
    }
}
