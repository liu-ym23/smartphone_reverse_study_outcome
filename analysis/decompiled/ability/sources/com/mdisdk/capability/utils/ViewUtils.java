package com.mdisdk.capability.utils;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/* loaded from: classes3.dex */
public class ViewUtils {
    private static final String TAG = "APEX-ViewUtils";

    private static View findClickableParent(View view) {
        while (view != null) {
            Log.i(TAG, "findClickableParent " + view);
            if (view.hasOnClickListeners() && view.hasOnLongClickListeners()) {
                Log.i(TAG, "findClickableParent result is " + view);
                return view;
            }
            if (!(view.getParent() instanceof View)) {
                return null;
            }
            view = (View) view.getParent();
        }
        return null;
    }

    public static View findClickableViewByLocation(View view, int i, int i6) {
        Log.i(TAG, "findClickableViewByLocation " + i);
        View viewFindViewByLocation = findViewByLocation(view, i, i6);
        if (viewFindViewByLocation == null) {
            return view;
        }
        Log.i(TAG, "findClickableViewByLocation " + viewFindViewByLocation);
        View viewFindClickableParent = findClickableParent(viewFindViewByLocation);
        return viewFindClickableParent != null ? viewFindClickableParent : viewFindViewByLocation;
    }

    public static <T extends View> T findFocusingTextEditor(View view) {
        if (view != null && view.isShown() && view.hasWindowFocus() && (view instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                T t9 = (T) viewGroup.getChildAt(i);
                if (t9.onCheckIsTextEditor() && t9.isEnabled() && (t9 instanceof TextView) && t9.hasFocus()) {
                    return t9;
                }
                T t10 = (T) findFocusingTextEditor(t9);
                if (t10 != null) {
                    return t10;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends View> T findTextEditorByLocation(View view, int i, int i6) {
        T t9;
        T t10;
        if (view != 0 && view.isShown()) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                t9 = null;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View childAt = viewGroup.getChildAt(childCount);
                    int left = i - childAt.getLeft();
                    int top = i6 - childAt.getTop();
                    if (left >= 0 && top >= 0 && left < childAt.getWidth() && top < childAt.getHeight() && (t10 = (T) findTextEditorByLocation(childAt, left, top)) != null) {
                        if (t10.isFocused()) {
                            return t10;
                        }
                        if (t9 == null) {
                            t9 = t10;
                        }
                    }
                }
            } else {
                t9 = null;
            }
            if (t9 != null) {
                return t9;
            }
            if (i >= 0 && i6 >= 0 && i < view.getWidth() && i6 < view.getHeight() && view.isEnabled() && ((view instanceof EditText) || view.onCheckIsTextEditor())) {
                return view;
            }
        }
        return null;
    }

    public static View findViewByLocation(View view, int i, int i6) {
        View viewFindViewByLocation;
        if (view == null || !view.isShown() || !positionInView(view, i, i6)) {
            return null;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt.isShown() && positionInView(childAt, i, i6) && (viewFindViewByLocation = findViewByLocation(childAt, i, i6)) != null && (viewFindViewByLocation.hasOnClickListeners() || viewFindViewByLocation.hasOnLongClickListeners())) {
                    return viewFindViewByLocation;
                }
            }
        }
        if (view.hasOnClickListeners() || view.hasOnLongClickListeners()) {
            return view;
        }
        return null;
    }

    private static boolean isClickView(View view) {
        return view.hasOnClickListeners() || view.hasOnLongClickListeners();
    }

    private static boolean positionInView(View view, int i, int i6) {
        return (i >= view.getLeft() && i <= view.getRight()) && (i6 >= view.getTop() && i6 <= view.getBottom());
    }
}
