package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import e.EnumC0546d;

@RestrictTo({EnumC0546d.f12494c})
/* loaded from: classes.dex */
public class FitWindowsFrameLayout extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public InterfaceC0231v0 f2819a;

    public FitWindowsFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    public final boolean fitSystemWindows(Rect rect) {
        InterfaceC0231v0 interfaceC0231v0 = this.f2819a;
        if (interfaceC0231v0 != null) {
            interfaceC0231v0.a(rect);
        }
        return super.fitSystemWindows(rect);
    }

    public void setOnFitSystemWindowsListener(InterfaceC0231v0 interfaceC0231v0) {
        this.f2819a = interfaceC0231v0;
    }
}
