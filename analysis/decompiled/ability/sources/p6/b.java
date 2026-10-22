package p6;

import android.app.Dialog;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.mdisdk.capability.model.WindowType;
import com.stepos.ability.R;

/* loaded from: classes3.dex */
public abstract class b {
    public static final void a(Dialog dialog, int i, int i6, final int i10, final int i11, final int i12, final int i13, float f, boolean z10, int i14) throws Resources.NotFoundException {
        final Window window = dialog.getWindow();
        if (window == null) {
            dialog.show();
            return;
        }
        final Resources resources = dialog.getContext().getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(i);
        final int dimensionPixelOffset2 = resources.getDimensionPixelOffset(i6);
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        Object systemService = dialog.getContext().getSystemService("window");
        kotlin.jvm.internal.k.d(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(displayMetrics);
        window.setType(WindowType.APPLICATION_OVERLAY);
        window.addFlags(2);
        window.setDimAmount(f);
        if (z10) {
            window.addFlags(4);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.setBlurBehindRadius(i14);
            window.setAttributes(attributes);
        }
        WindowManager.LayoutParams attributes2 = window.getAttributes();
        attributes2.gravity = 81;
        attributes2.width = displayMetrics.widthPixels - (dimensionPixelOffset * 2);
        attributes2.height = -2;
        attributes2.y = dimensionPixelOffset2;
        window.setAttributes(attributes2);
        dialog.show();
        window.getDecorView().post(new Runnable() { // from class: p6.a
            @Override // java.lang.Runnable
            public final void run() {
                Window window2 = window;
                WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(window2.getDecorView());
                if (rootWindowInsets == null) {
                    return;
                }
                int i15 = rootWindowInsets.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
                int i16 = rootWindowInsets.getInsets(WindowInsetsCompat.Type.statusBars()).top;
                WindowManager.LayoutParams attributes3 = window2.getAttributes();
                int i17 = dimensionPixelOffset2;
                attributes3.y = i17 + i15;
                View viewFindViewById = window2.getDecorView().findViewById(R.id.tv_title);
                int measuredHeight = viewFindViewById != null ? viewFindViewById.getMeasuredHeight() : 0;
                Resources resources2 = resources;
                int dimensionPixelSize = (((displayMetrics.heightPixels - i15) - i16) - (i17 * 2)) - (resources2.getDimensionPixelSize(i13) + (resources2.getDimensionPixelSize(i12) + (resources2.getDimensionPixelSize(i11) + (resources2.getDimensionPixelSize(i10) + measuredHeight))));
                View viewFindViewById2 = window2.getDecorView().findViewById(R.id.scroll_content);
                if (viewFindViewById2 != null && dimensionPixelSize > 0 && viewFindViewById2.getMeasuredHeight() > dimensionPixelSize) {
                    ViewGroup.LayoutParams layoutParams = viewFindViewById2.getLayoutParams();
                    layoutParams.height = dimensionPixelSize;
                    viewFindViewById2.setLayoutParams(layoutParams);
                    viewFindViewById2.requestLayout();
                }
                window2.setAttributes(attributes3);
            }
        });
    }
}
