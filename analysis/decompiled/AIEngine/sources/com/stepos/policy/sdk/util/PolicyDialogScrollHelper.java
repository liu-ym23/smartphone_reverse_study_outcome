package com.stepos.policy.sdk.util;

import android.R;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.stepos.core.common.notification.ModelDownloadNotifier;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PolicyDialogScrollHelper {
    private static final float DIALOG_RESERVED_SAFETY_DP = 8.0f;
    private static final float FALLBACK_SCROLL_HEIGHT_RATIO = 0.45f;
    private static final float TERMS_DESCENDER_PADDING_DP = 4.0f;

    private PolicyDialogScrollHelper() {
    }

    private static void applyMaxHeight(View view, View view2, Dialog dialog) {
        ensureBelowTitle(view, view2);
        scheduleScrollHeightLimit(view, dialog, view2, 5);
    }

    public static void attach(final Dialog dialog) {
        if (dialog == null) {
            return;
        }
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.stepos.policy.sdk.util.b
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                PolicyDialogScrollHelper.lambda$attach$0(dialog, dialogInterface);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int computeAvailableScrollHeight(android.app.Dialog r4, android.view.View r5, android.view.View r6) throws android.content.res.Resources.NotFoundException {
        /*
            android.view.Window r0 = r4.getWindow()
            if (r0 != 0) goto La
            r4 = 2147483647(0x7fffffff, float:NaN)
            return r4
        La:
            android.view.View r0 = r0.getDecorView()
            int r0 = r0.getHeight()
            r1 = 0
            if (r0 > 0) goto L16
            return r1
        L16:
            java.lang.String r2 = "topPanel"
            int r2 = visibleHeight(r4, r2)
            java.lang.String r3 = "buttonPanel"
            int r3 = visibleHeight(r4, r3)
            int r2 = r2 + r3
            java.lang.String r3 = "dialogSpace1"
            int r3 = visibleHeight(r4, r3)
            int r2 = r2 + r3
            java.lang.String r3 = "dialogSpace2"
            int r3 = visibleHeight(r4, r3)
            int r2 = r2 + r3
            java.lang.String r3 = "dialogSpace3"
            int r3 = visibleHeight(r4, r3)
            int r2 = r2 + r3
            java.lang.String r3 = "dialogSpace4"
            int r3 = visibleHeight(r4, r3)
            int r2 = r2 + r3
            java.lang.String r3 = "stepos_permission_checkbox_pack"
            int r3 = visibleHeight(r4, r3)
            if (r3 <= 0) goto L49
        L47:
            int r2 = r2 + r3
            goto L5e
        L49:
            java.lang.String r3 = "stepos_permission_dialog_checkbox"
            int r3 = visibleHeight(r4, r3)
            int r2 = r2 + r3
            java.lang.String r3 = "stepos_checkbox_layout_first"
            int r3 = visibleHeight(r4, r3)
            int r2 = r2 + r3
            java.lang.String r3 = "stepos_checkbox_layout_second"
            int r3 = visibleHeight(r4, r3)
            goto L47
        L5e:
            java.lang.String r3 = "stepos_permission_dialog_title"
            java.lang.String[] r3 = new java.lang.String[]{r3}
            android.view.View r4 = findViewByCandidateIds(r4, r3)
            if (r4 == 0) goto L78
            if (r4 == r6) goto L78
            int r3 = r4.getVisibility()
            if (r3 != 0) goto L78
            int r4 = r4.getHeight()
        L76:
            int r2 = r2 + r4
            goto L91
        L78:
            if (r6 == 0) goto L91
            int r4 = r6.getVisibility()
            if (r4 != 0) goto L91
            java.lang.String r4 = "alertTitle"
            java.lang.String r3 = safeEntryName(r6)
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L91
            int r4 = r6.getHeight()
            goto L76
        L91:
            android.view.ViewGroup$LayoutParams r4 = r5.getLayoutParams()
            boolean r6 = r4 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r6 == 0) goto La1
            android.view.ViewGroup$MarginLayoutParams r4 = (android.view.ViewGroup.MarginLayoutParams) r4
            int r6 = r4.topMargin
            int r4 = r4.bottomMargin
            int r6 = r6 + r4
            int r2 = r2 + r6
        La1:
            android.content.res.Resources r4 = r5.getResources()
            android.util.DisplayMetrics r4 = r4.getDisplayMetrics()
            r5 = 1
            r6 = 1090519040(0x41000000, float:8.0)
            float r4 = android.util.TypedValue.applyDimension(r5, r6, r4)
            int r4 = (int) r4
            int r0 = r0 - r2
            int r0 = r0 - r4
            int r4 = java.lang.Math.max(r0, r1)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.util.PolicyDialogScrollHelper.computeAvailableScrollHeight(android.app.Dialog, android.view.View, android.view.View):int");
    }

    private static void ensureBelowTitle(View view, View view2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (view2 == null || !(layoutParams instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.addRule(3, view2.getId());
        view.setLayoutParams(layoutParams2);
    }

    private static void ensureCheckboxPackAboveButtons(Dialog dialog, View view, View view2, int i10) {
        if (dialog == null) {
            return;
        }
        view.post(new a(dialog, view, i10, view2));
    }

    public static void ensureTermsDescendersVisible(Dialog dialog) {
        if (dialog == null) {
            return;
        }
        View viewFindTermsView = findTermsView(dialog);
        if (viewFindTermsView instanceof TextView) {
            TextView textView = (TextView) viewFindTermsView;
            int iApplyDimension = (int) TypedValue.applyDimension(1, TERMS_DESCENDER_PADDING_DP, textView.getResources().getDisplayMetrics());
            if (iApplyDimension <= 0 || textView.getPaddingBottom() >= iApplyDimension) {
                return;
            }
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), iApplyDimension);
        }
    }

    private static View findScrollView(Dialog dialog) throws Resources.NotFoundException {
        View viewFindViewById;
        View viewFindViewById2 = dialog.findViewById(R.id.content);
        if (viewFindViewById2 == null) {
            return null;
        }
        String[] strArr = {"stepos_permission_dialog_scrollview", "scrollView"};
        for (int i10 = 0; i10 < 2; i10++) {
            String str = strArr[i10];
            int identifier = viewFindViewById2.getResources().getIdentifier(str, ModelDownloadNotifier.EXTRA_NOTIF_ID, dialog.getContext().getPackageName());
            if (identifier == 0) {
                identifier = viewFindViewById2.getResources().getIdentifier(str, ModelDownloadNotifier.EXTRA_NOTIF_ID, viewFindViewById2.getContext().getPackageName());
            }
            if (identifier != 0 && (viewFindViewById = dialog.findViewById(identifier)) != null && viewFindViewById.getVisibility() != 8) {
                return viewFindViewById;
            }
            View viewFindViewByName = findViewByName(viewFindViewById2, str);
            if (viewFindViewByName != null && viewFindViewByName.getVisibility() != 8) {
                return viewFindViewByName;
            }
        }
        return null;
    }

    private static View findTermsView(Dialog dialog) {
        return findViewByCandidateIds(dialog, "stepos_permission_dialog_terms");
    }

    private static View findTitleView(Dialog dialog) {
        return findViewByCandidateIds(dialog, "alertTitle", "stepos_permission_dialog_title");
    }

    private static View findViewByCandidateIds(Dialog dialog, String... strArr) throws Resources.NotFoundException {
        View viewFindViewByName;
        View viewFindViewById;
        View viewFindViewById2 = dialog.findViewById(R.id.content);
        for (String str : strArr) {
            int identifier = dialog.getContext().getResources().getIdentifier(str, ModelDownloadNotifier.EXTRA_NOTIF_ID, dialog.getContext().getPackageName());
            if (identifier != 0 && (viewFindViewById = dialog.findViewById(identifier)) != null) {
                return viewFindViewById;
            }
            if (viewFindViewById2 != null && (viewFindViewByName = findViewByName(viewFindViewById2, str)) != null) {
                return viewFindViewByName;
            }
        }
        return null;
    }

    private static View findViewByName(View view, String str) throws Resources.NotFoundException {
        if (view == null) {
            return null;
        }
        int id2 = view.getId();
        if (id2 != -1) {
            try {
                if (str.equals(view.getResources().getResourceEntryName(id2))) {
                    return view;
                }
            } catch (Exception unused) {
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                View viewFindViewByName = findViewByName(viewGroup.getChildAt(i10), str);
                if (viewFindViewByName != null) {
                    return viewFindViewByName;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$attach$0(Dialog dialog, DialogInterface dialogInterface) {
        ensureTermsDescendersVisible(dialog);
        limitScrollContent(dialog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$ensureCheckboxPackAboveButtons$2(Dialog dialog, View view, int i10, View view2) throws Resources.NotFoundException {
        Window window;
        int height;
        ViewGroup.LayoutParams layoutParams;
        View viewFindViewByCandidateIds = findViewByCandidateIds(dialog, "stepos_permission_checkbox_pack");
        if (viewFindViewByCandidateIds == null || viewFindViewByCandidateIds.getVisibility() != 0 || viewFindViewByCandidateIds.getHeight() <= 0 || (window = dialog.getWindow()) == null) {
            return;
        }
        View decorView = window.getDecorView();
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        viewFindViewByCandidateIds.getLocationOnScreen(iArr);
        int height2 = viewFindViewByCandidateIds.getHeight() + iArr[1];
        View viewFindViewByCandidateIds2 = findViewByCandidateIds(dialog, "buttonPanel");
        if (viewFindViewByCandidateIds2 == null || viewFindViewByCandidateIds2.getVisibility() != 0 || viewFindViewByCandidateIds2.getHeight() <= 0) {
            decorView.getLocationOnScreen(iArr2);
            height = decorView.getHeight() + iArr2[1];
        } else {
            viewFindViewByCandidateIds2.getLocationOnScreen(iArr2);
            height = iArr2[1];
        }
        int i11 = height2 - height;
        if (i11 > 0 && (layoutParams = view.getLayoutParams()) != null) {
            int iApplyDimension = (int) TypedValue.applyDimension(1, DIALOG_RESERVED_SAFETY_DP, view.getResources().getDisplayMetrics());
            int height3 = view.getHeight() > 0 ? view.getHeight() : layoutParams.height;
            if (height3 <= 0) {
                height3 = measureContentHeight(view);
            }
            int iMax = Math.max((height3 - i11) - iApplyDimension, 0);
            if (layoutParams.height != iMax) {
                layoutParams.height = iMax;
                view.setLayoutParams(layoutParams);
            } else if (i10 > 0) {
                scheduleScrollHeightLimit(view, dialog, view2, i10 - 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$scheduleScrollHeightLimit$1(View view, Dialog dialog, View view2, int i10) throws Resources.NotFoundException {
        int iResolveMaxScrollHeight = resolveMaxScrollHeight(view, dialog, view2);
        if (iResolveMaxScrollHeight <= 0) {
            if (i10 > 0) {
                scheduleScrollHeightLimit(view, dialog, view2, i10 - 1);
                return;
            }
            return;
        }
        int iMeasureContentHeight = measureContentHeight(view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        if (iMeasureContentHeight <= iResolveMaxScrollHeight) {
            if (layoutParams.height != -2) {
                layoutParams.height = -2;
                view.setLayoutParams(layoutParams);
            }
        } else if (layoutParams.height != iResolveMaxScrollHeight) {
            layoutParams.height = iResolveMaxScrollHeight;
            view.setLayoutParams(layoutParams);
        }
        ensureCheckboxPackAboveButtons(dialog, view, view2, i10);
    }

    public static void limitScrollContent(Dialog dialog) {
        View viewFindScrollView;
        if (dialog == null || (viewFindScrollView = findScrollView(dialog)) == null) {
            return;
        }
        applyMaxHeight(viewFindScrollView, findTitleView(dialog), dialog);
    }

    public static void limitScrollView(View view, View view2) {
        if (view == null) {
            return;
        }
        ensureBelowTitle(view, view2);
    }

    private static int measureContentHeight(View view) {
        if (!(view instanceof ViewGroup)) {
            return view.getMeasuredHeight();
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup.getChildCount() == 0) {
            return view.getMeasuredHeight();
        }
        View childAt = viewGroup.getChildAt(0);
        int width = view.getWidth();
        if (width <= 0 && view.getLayoutParams() != null) {
            width = view.getResources().getDisplayMetrics().widthPixels;
        }
        childAt.measure(View.MeasureSpec.makeMeasureSpec(Math.max(width, 0), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        return childAt.getMeasuredHeight();
    }

    private static int resolveMaxScrollHeight(View view, Dialog dialog, View view2) throws Resources.NotFoundException {
        int dimensionPixelSize = view.getResources().getDimensionPixelSize(com.stepos.aiengine.R.dimen.policy_sdk_permission_dialog_scroll_max_height);
        int i10 = (int) (view.getResources().getDisplayMetrics().heightPixels * FALLBACK_SCROLL_HEIGHT_RATIO);
        if (i10 <= 0) {
            i10 = dimensionPixelSize;
        }
        if (dialog == null) {
            return Math.min(i10, dimensionPixelSize);
        }
        int iComputeAvailableScrollHeight = computeAvailableScrollHeight(dialog, view, view2);
        if (iComputeAvailableScrollHeight <= 0) {
            return 0;
        }
        return iComputeAvailableScrollHeight;
    }

    private static String safeEntryName(View view) throws Resources.NotFoundException {
        try {
            int id2 = view.getId();
            if (id2 == -1) {
                return null;
            }
            return view.getResources().getResourceEntryName(id2);
        } catch (Exception unused) {
            return null;
        }
    }

    private static void scheduleScrollHeightLimit(View view, Dialog dialog, View view2, int i10) {
        view.post(new a(view, dialog, view2, i10));
    }

    private static int visibleHeight(Dialog dialog, String str) throws Resources.NotFoundException {
        return visibleHeight(findViewByCandidateIds(dialog, str));
    }

    private static int visibleHeight(View view) {
        if (view == null || view.getVisibility() != 0) {
            return 0;
        }
        return view.getHeight();
    }
}
