package h6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.stepos.ailauncher.sheet.R$id;
import com.stepos.ailauncher.sheet.R$layout;
import com.stepos.ailauncher.sheet.widget.DraggableSheetLayout;
import s1.C5437a;

/* renamed from: h6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C4145a {
    public final FrameLayout ailContentContainer;
    public final View ailDimView;
    public final FrameLayout ailDragHandle;
    public final TextView ailSettleHint;
    public final DraggableSheetLayout ailSheetLayout;
    public final FrameLayout ailSheetPanel;
    public final FrameLayout ailSheetRoot;
    private final FrameLayout rootView;

    public C4145a(FrameLayout frameLayout, FrameLayout frameLayout2, View view, FrameLayout frameLayout3, TextView textView, DraggableSheetLayout draggableSheetLayout, FrameLayout frameLayout4, FrameLayout frameLayout5) {
        this.rootView = frameLayout;
        this.ailContentContainer = frameLayout2;
        this.ailDimView = view;
        this.ailDragHandle = frameLayout3;
        this.ailSettleHint = textView;
        this.ailSheetLayout = draggableSheetLayout;
        this.ailSheetPanel = frameLayout4;
        this.ailSheetRoot = frameLayout5;
    }

    public static C4145a a(View view) {
        View viewA;
        int i10 = R$id.ail_content_container;
        FrameLayout frameLayout = (FrameLayout) C5437a.a(view, i10);
        if (frameLayout != null && (viewA = C5437a.a(view, (i10 = R$id.ail_dim_view))) != null) {
            i10 = R$id.ail_drag_handle;
            FrameLayout frameLayout2 = (FrameLayout) C5437a.a(view, i10);
            if (frameLayout2 != null) {
                i10 = R$id.ail_settle_hint;
                TextView textView = (TextView) C5437a.a(view, i10);
                if (textView != null) {
                    i10 = R$id.ail_sheet_layout;
                    DraggableSheetLayout draggableSheetLayout = (DraggableSheetLayout) C5437a.a(view, i10);
                    if (draggableSheetLayout != null) {
                        i10 = R$id.ail_sheet_panel;
                        FrameLayout frameLayout3 = (FrameLayout) C5437a.a(view, i10);
                        if (frameLayout3 != null) {
                            FrameLayout frameLayout4 = (FrameLayout) view;
                            return new C4145a(frameLayout4, frameLayout, viewA, frameLayout2, textView, draggableSheetLayout, frameLayout3, frameLayout4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static C4145a c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C4145a d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.ail_lite_sheet_host, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public FrameLayout b() {
        return this.rootView;
    }
}
