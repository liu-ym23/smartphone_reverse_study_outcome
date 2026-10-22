package Y4;

import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ailauncher.agent.R$id;
import com.stepos.ailauncher.agent.R$layout;
import s1.C5437a;

/* renamed from: Y4.g, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1123g {
    public final LinearLayout bottomBar;
    public final ImageButton btnBack;
    public final FrameLayout navBar;
    public final SurfaceView previewView;
    private final FrameLayout rootView;
    public final FrameLayout scanFrame;
    public final View scanLine;
    public final TextView tvScanHint;
    public final TextView tvScanMismatch;

    public C1123g(FrameLayout frameLayout, LinearLayout linearLayout, ImageButton imageButton, FrameLayout frameLayout2, SurfaceView surfaceView, FrameLayout frameLayout3, View view, TextView textView, TextView textView2) {
        this.rootView = frameLayout;
        this.bottomBar = linearLayout;
        this.btnBack = imageButton;
        this.navBar = frameLayout2;
        this.previewView = surfaceView;
        this.scanFrame = frameLayout3;
        this.scanLine = view;
        this.tvScanHint = textView;
        this.tvScanMismatch = textView2;
    }

    public static C1123g a(View view) {
        View viewA;
        int i10 = R$id.bottom_bar;
        LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
        if (linearLayout != null) {
            i10 = R$id.btn_back;
            ImageButton imageButton = (ImageButton) C5437a.a(view, i10);
            if (imageButton != null) {
                i10 = R$id.nav_bar;
                FrameLayout frameLayout = (FrameLayout) C5437a.a(view, i10);
                if (frameLayout != null) {
                    i10 = R$id.preview_view;
                    SurfaceView surfaceView = (SurfaceView) C5437a.a(view, i10);
                    if (surfaceView != null) {
                        i10 = R$id.scan_frame;
                        FrameLayout frameLayout2 = (FrameLayout) C5437a.a(view, i10);
                        if (frameLayout2 != null && (viewA = C5437a.a(view, (i10 = R$id.scan_line))) != null) {
                            i10 = R$id.tv_scan_hint;
                            TextView textView = (TextView) C5437a.a(view, i10);
                            if (textView != null) {
                                i10 = R$id.tv_scan_mismatch;
                                TextView textView2 = (TextView) C5437a.a(view, i10);
                                if (textView2 != null) {
                                    return new C1123g((FrameLayout) view, linearLayout, imageButton, frameLayout, surfaceView, frameLayout2, viewA, textView, textView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static C1123g c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C1123g d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_scan_qr, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public FrameLayout b() {
        return this.rootView;
    }
}
