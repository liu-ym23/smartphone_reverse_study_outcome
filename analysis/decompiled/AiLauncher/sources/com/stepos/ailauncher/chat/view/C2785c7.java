package com.stepos.ailauncher.chat.view;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.appcompat.widget.AppCompatEditText;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\b\b\u0016\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/chat/view/c7;", "Landroidx/appcompat/widget/AppCompatEditText;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/view/MotionEvent;", "event", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "performLongClick", "()Z", "onTouchEvent", Const.INTENT_KEY_UMID, "touchSlop", "I", "", "downRawX", "F", "downRawY", "longClickHandled", "Z", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.view.c7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C2785c7 extends AppCompatEditText {
    private static final a Companion = new a(null);

    @Deprecated
    public static final String TAG = "OverlaySafeEditText";
    private float downRawX;
    private float downRawY;
    private boolean longClickHandled;
    private final int touchSlop;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\b\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/ailauncher/chat/view/c7$a;", "", "<init>", "()V", "Ljava/lang/NullPointerException;", "Lkotlin/NullPointerException;", "e", "", Const.INTENT_KEY_APIKEY, "(Ljava/lang/NullPointerException;)Z", "", "TAG", "Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.view.c7$a */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final boolean a(NullPointerException e10) {
            kotlin.jvm.internal.p.i(e10, "e");
            String message = e10.getMessage();
            if (message == null) {
                message = "";
            }
            if (La.H.g0(message, "Magnifier", false, 2, null) || La.H.g0(message, "android.graphics.Rect", false, 2, null)) {
                return true;
            }
            StackTraceElement[] stackTrace = e10.getStackTrace();
            kotlin.jvm.internal.p.h(stackTrace, "getStackTrace(...)");
            for (StackTraceElement stackTraceElement : stackTrace) {
                String className = stackTraceElement.getClassName();
                kotlin.jvm.internal.p.h(className, "getClassName(...)");
                if (La.H.g0(className, "android.widget.Magnifier", false, 2, null)) {
                    return true;
                }
            }
            return false;
        }

        public a() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C2785c7(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public final boolean d(MotionEvent event) {
        return C2862j7.INSTANCE.a(this.longClickHandled, event.getPointerCount(), event.getRawX() - this.downRawX, event.getRawY() - this.downRawY, this.touchSlop);
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent event) {
        kotlin.jvm.internal.p.i(event, "event");
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            this.downRawX = event.getRawX();
            this.downRawY = event.getRawY();
            this.longClickHandled = false;
        } else if (actionMasked == 3 && d(event)) {
            this.longClickHandled = false;
            C4148a.k(TAG, "restore ACTION_UP rewritten to CANCEL by ROM picker long-press", false, 4, null);
            MotionEvent motionEventObtain = MotionEvent.obtain(event);
            motionEventObtain.setAction(1);
            try {
                return super.dispatchTouchEvent(motionEventObtain);
            } finally {
                motionEventObtain.recycle();
            }
        }
        return super.dispatchTouchEvent(event);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        kotlin.jvm.internal.p.i(event, "event");
        try {
            return super.onTouchEvent(event);
        } catch (NullPointerException e10) {
            if (!Companion.a(e10)) {
                throw e10;
            }
            C4148a.g(TAG, "suppress Magnifier framework NPE on touch action=" + event.getActionMasked(), e10, false, 8, null);
            return false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean performLongClick() {
        boolean zPerformLongClick = super.performLongClick();
        if (zPerformLongClick) {
            this.longClickHandled = true;
        }
        return zPerformLongClick;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2785c7(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public /* synthetic */ C2785c7(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? R.attr.editTextStyle : i10);
    }
}
