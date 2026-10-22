package com.mdisdk.capability.thirdpart;

import android.R;
import android.annotation.SuppressLint;
import android.graphics.Region;
import android.os.Bundle;
import android.text.Selection;
import android.text.Spannable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.compose.foundation.b;
import androidx.constraintlayout.core.dsl.a;
import com.mdisdk.capability.model.ActionExtra;
import com.mdisdk.capability.model.RequestInfo;
import com.mdisdk.capability.model.ResultInfo;
import com.mdisdk.capability.model.ViewNode;
import com.mdisdk.capability.model.WindowStateInfo;
import com.mdisdk.capability.utils.A11yBridge;
import com.mdisdk.capability.utils.ViewUtils;

/* loaded from: classes3.dex */
public class RequestHandler {
    private static final String TAG = "APEX-RequestHandler";

    private int[] calculateLocalCoordinates(View view, View view2, int i, int i6) {
        if (view2 == view) {
            return new int[]{i, i6};
        }
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        view.getLocationInWindow(iArr);
        view2.getLocationInWindow(iArr2);
        return new int[]{i - (iArr2[0] - iArr[0]), i6 - (iArr2[1] - iArr[1])};
    }

    @SuppressLint({"WrongConstant"})
    private ResultInfo createActionResult(@NonNull RequestInfo requestInfo, @Nullable Bundle bundle, int i) {
        return new ResultInfo(requestInfo.getRequestId(), requestInfo.getFunction(), i, new WindowStateInfo(bundle != null ? bundle.getString(WindowStateInfo.KEY_WIN_PACKAGE, "") : "", bundle != null ? bundle.getString(WindowStateInfo.KEY_WIN_ACTIVITY, "") : "", bundle != null ? bundle.getString(WindowStateInfo.KEY_WIN_TITLE, "") : "", bundle != null ? bundle.getInt("type", 1) : 1, bundle != null ? bundle.getInt(WindowStateInfo.KEY_WIN_MODE, 1) : 1, bundle != null ? (Region) bundle.getParcelable(WindowStateInfo.KEY_TOUCH_REGION) : null, true, null));
    }

    private View findViewByNodeId(View view, long j5) {
        if (view.hashCode() == j5) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View viewFindViewByNodeId = findViewByNodeId(viewGroup.getChildAt(i), j5);
            if (viewFindViewByNodeId != null) {
                return viewFindViewByNodeId;
            }
        }
        return null;
    }

    private boolean isValidWindowType(int i) {
        return (i >= 1 && i <= 4) || i == 1000 || i == 1002 || i == 1003;
    }

    private ResultInfo processClick(@NonNull View view, @NonNull RequestInfo requestInfo, @Nullable Bundle bundle) {
        ActionExtra actionExtra = requestInfo.getActionExtra();
        if (actionExtra == null) {
            Log.w(TAG, "processClick: ActionExtra is null");
            return createActionResult(requestInfo, bundle, -1);
        }
        boolean zPerformClick = ActionHelper.performClick(view, actionExtra.getX(), actionExtra.getY());
        Log.d(TAG, "performClick: " + zPerformClick);
        return createActionResult(requestInfo, bundle, zPerformClick ? 0 : -1);
    }

    private ResultInfo processDoubleClick(@NonNull View view, @NonNull RequestInfo requestInfo, @Nullable Bundle bundle) {
        ActionExtra actionExtra = requestInfo.getActionExtra();
        if (actionExtra == null) {
            Log.w(TAG, "processDoubleClick: ActionExtra is null");
            return createActionResult(requestInfo, bundle, -1);
        }
        boolean zPerformDoubleClick = ActionHelper.performDoubleClick(view, actionExtra.getX(), actionExtra.getY());
        Log.d(TAG, "performDoubleClick: " + zPerformDoubleClick);
        return createActionResult(requestInfo, bundle, zPerformDoubleClick ? 0 : -1);
    }

    private ResultInfo processLongClick(@NonNull View view, @NonNull RequestInfo requestInfo, @Nullable Bundle bundle) {
        ActionExtra actionExtra = requestInfo.getActionExtra();
        if (actionExtra == null) {
            Log.w(TAG, "processLongClick: ActionExtra is null");
            return createActionResult(requestInfo, bundle, -1);
        }
        boolean zPerformLongClick = ActionHelper.performLongClick(view, actionExtra.getX(), actionExtra.getY(), actionExtra.getDuration());
        Log.d(TAG, "performLongClick: " + zPerformLongClick);
        return createActionResult(requestInfo, bundle, zPerformLongClick ? 0 : -1);
    }

    private ResultInfo processReplaceText(View view, RequestInfo requestInfo, Bundle bundle) {
        ActionExtra actionExtra = requestInfo.getActionExtra();
        int i = bundle != null ? bundle.getInt("type", 1) : 1;
        if (actionExtra == null || actionExtra.getContent() == null || !isValidWindowType(i)) {
            return createActionResult(requestInfo, bundle, -1);
        }
        View viewFindViewByNodeId = actionExtra.getTextNodeId() != 0 ? findViewByNodeId(view, actionExtra.getTextNodeId()) : (actionExtra.getX() <= 0 || actionExtra.getY() <= 0) ? ViewUtils.findFocusingTextEditor(view) : ViewUtils.findTextEditorByLocation(view, actionExtra.getX(), actionExtra.getY());
        if (!(viewFindViewByNodeId instanceof TextView) || !viewFindViewByNodeId.isShown() || !viewFindViewByNodeId.isEnabled()) {
            return createActionResult(requestInfo, bundle, -1);
        }
        try {
            TextEditorWriter.replaceText((TextView) viewFindViewByNodeId, actionExtra.getContent(), actionExtra.getTextStart(), actionExtra.getTextEnd(), RequestInfo.FUNCTION_REPLACE_TEXT_BY_CODE_POINT.equals(requestInfo.getFunction()));
            return createActionResult(requestInfo, bundle, 0);
        } catch (RuntimeException e) {
            Log.w(TAG, "replaceText failed: requestId=" + requestInfo.getRequestId(), e);
            return this.createActionResult(requestInfo, bundle, -1);
        }
    }

    private ResultInfo processScrollDown(@NonNull View view, @NonNull RequestInfo requestInfo, @Nullable Bundle bundle) {
        View viewFindViewByLocation;
        ActionExtra actionExtra = requestInfo.getActionExtra();
        if (actionExtra != null && ((actionExtra.getX() > 0 || actionExtra.getY() > 0) && (viewFindViewByLocation = ViewUtils.findViewByLocation(view, actionExtra.getX(), actionExtra.getY())) != null)) {
            view = viewFindViewByLocation;
        }
        boolean zPerformScrollDown = ActionHelper.performScrollDown(view, ActionHelper.getBoundsOnScreen(view));
        Log.d(TAG, "processScrollDown: targetView=" + view.getClass().getSimpleName() + ", result=" + zPerformScrollDown);
        return createActionResult(requestInfo, bundle, zPerformScrollDown ? 0 : -1);
    }

    private ResultInfo processScrollLeft(@NonNull View view, @NonNull RequestInfo requestInfo, @Nullable Bundle bundle) {
        View viewFindViewByLocation;
        ActionExtra actionExtra = requestInfo.getActionExtra();
        if (actionExtra != null && ((actionExtra.getX() > 0 || actionExtra.getY() > 0) && (viewFindViewByLocation = ViewUtils.findViewByLocation(view, actionExtra.getX(), actionExtra.getY())) != null)) {
            view = viewFindViewByLocation;
        }
        boolean zPerformScrollLeft = ActionHelper.performScrollLeft(view, ActionHelper.getBoundsOnScreen(view));
        Log.d(TAG, "processScrollLeft: targetView=" + view.getClass().getSimpleName() + ", result=" + zPerformScrollLeft);
        return createActionResult(requestInfo, bundle, zPerformScrollLeft ? 0 : -1);
    }

    private ResultInfo processScrollRight(@NonNull View view, @NonNull RequestInfo requestInfo, @Nullable Bundle bundle) {
        View viewFindViewByLocation;
        ActionExtra actionExtra = requestInfo.getActionExtra();
        if (actionExtra != null && ((actionExtra.getX() > 0 || actionExtra.getY() > 0) && (viewFindViewByLocation = ViewUtils.findViewByLocation(view, actionExtra.getX(), actionExtra.getY())) != null)) {
            view = viewFindViewByLocation;
        }
        boolean zPerformScrollRight = ActionHelper.performScrollRight(view, ActionHelper.getBoundsOnScreen(view));
        Log.d(TAG, "processScrollRight: targetView=" + view.getClass().getSimpleName() + ", result=" + zPerformScrollRight);
        return createActionResult(requestInfo, bundle, zPerformScrollRight ? 0 : -1);
    }

    private ResultInfo processScrollUp(@NonNull View view, @NonNull RequestInfo requestInfo, @Nullable Bundle bundle) {
        View viewFindViewByLocation;
        ActionExtra actionExtra = requestInfo.getActionExtra();
        if (actionExtra != null && ((actionExtra.getX() > 0 || actionExtra.getY() > 0) && (viewFindViewByLocation = ViewUtils.findViewByLocation(view, actionExtra.getX(), actionExtra.getY())) != null)) {
            view = viewFindViewByLocation;
        }
        boolean zPerformScrollUp = ActionHelper.performScrollUp(view, ActionHelper.getBoundsOnScreen(view));
        Log.d(TAG, "processScrollUp: targetView=" + view.getClass().getSimpleName() + ", result=" + zPerformScrollUp);
        return createActionResult(requestInfo, bundle, zPerformScrollUp ? 0 : -1);
    }

    private ResultInfo processSetText(@NonNull View view, @NonNull RequestInfo requestInfo, @Nullable Bundle bundle) {
        String str;
        boolean z10;
        int i = bundle.getInt("type", 1);
        String string = bundle.getString(WindowStateInfo.KEY_WIN_PACKAGE, "");
        String string2 = bundle.getString(WindowStateInfo.KEY_WIN_ACTIVITY, "");
        String string3 = bundle.getString(WindowStateInfo.KEY_WIN_TITLE, "");
        int i6 = bundle.getInt(WindowStateInfo.KEY_WIN_MODE, 1);
        Region region = (Region) bundle.getParcelable(WindowStateInfo.KEY_TOUCH_REGION);
        Log.d(TAG, "processSetText: windowType=" + i + ", package=" + string);
        ActionExtra actionExtra = requestInfo.getActionExtra();
        int iTrySetTextViaA11y = -1;
        if (actionExtra == null || actionExtra.getContent() == null || !isValidWindowType(i)) {
            str = string;
            a.p(i, "setText skipped: no valid ActionExtra or invalid windowType=", TAG);
        } else {
            int x10 = actionExtra.getX();
            int y = actionExtra.getY();
            View viewFindFocusingTextEditor = (x10 <= 0 || y <= 0) ? ViewUtils.findFocusingTextEditor(view) : ViewUtils.findTextEditorByLocation(view, x10, y);
            if (viewFindFocusingTextEditor instanceof TextView) {
                TextView textView = (TextView) viewFindFocusingTextEditor;
                textView.setText(actionExtra.getContent());
                CharSequence text = textView.getText();
                if (text instanceof Spannable) {
                    Selection.setSelection((Spannable) text, text.length());
                    StringBuilder sb = new StringBuilder("setText cursor=end: requestId=");
                    str = string;
                    sb.append(requestInfo.getRequestId());
                    sb.append(", view=");
                    sb.append(textView.getClass().getName());
                    sb.append(", length=");
                    sb.append(text.length());
                    sb.append(", selectionStart=");
                    sb.append(textView.getSelectionStart());
                    sb.append(", selectionEnd=");
                    sb.append(textView.getSelectionEnd());
                    Log.d(TAG, sb.toString());
                } else {
                    str = string;
                }
                iTrySetTextViaA11y = 0;
                z10 = true;
            } else {
                str = string;
                if (viewFindFocusingTextEditor != null) {
                    Log.d(TAG, "setText: candidate is not TextView (likely Compose host): " + viewFindFocusingTextEditor.getClass().getName() + ", fallback to A11y");
                }
                z10 = false;
            }
            if (!z10) {
                if (x10 > 0 && y > 0) {
                    iTrySetTextViaA11y = trySetTextViaA11y(view, x10, y, actionExtra.getContent());
                }
                if (iTrySetTextViaA11y != 0) {
                    View viewFindFocus = view.findFocus();
                    if (viewFindFocus == null || A11yBridge.isComposeHost(viewFindFocus)) {
                        Log.w(TAG, "setText: no editor found. root=" + view.getClass().getSimpleName() + " hasWindowFocus=" + view.hasWindowFocus() + " focused=" + viewFindFocus);
                    } else {
                        int textViaInputConnection = setTextViaInputConnection(viewFindFocus, actionExtra.getContent());
                        if (textViaInputConnection != 0) {
                            Log.w(TAG, "setText: failed via InputConnection. view=".concat(viewFindFocus.getClass().getName()));
                        }
                        iTrySetTextViaA11y = textViaInputConnection;
                    }
                }
            }
        }
        return new ResultInfo(requestInfo.getRequestId(), requestInfo.getFunction(), iTrySetTextViaA11y, new WindowStateInfo(str, string2, string3, i, i6, region, true, null));
    }

    @NonNull
    private ResultInfo processSnapshot(@NonNull View view, @NonNull RequestInfo requestInfo, @Nullable Bundle bundle) {
        ViewNode viewNodeBuild = ViewNode.build(view);
        WindowStateInfo windowStateInfo = new WindowStateInfo(bundle.getString(WindowStateInfo.KEY_WIN_PACKAGE, ""), bundle.getString(WindowStateInfo.KEY_WIN_ACTIVITY, ""), bundle.getString(WindowStateInfo.KEY_WIN_TITLE, ""), bundle.getInt("type", 1), bundle.getInt(WindowStateInfo.KEY_WIN_MODE, 1), (Region) bundle.getParcelable(WindowStateInfo.KEY_TOUCH_REGION), true, viewNodeBuild);
        Log.d(TAG, "Snapshot processed: package=" + windowStateInfo + ", nodes=" + viewNodeBuild.getChildren().size());
        return new ResultInfo(requestInfo.getRequestId(), requestInfo.getFunction(), 0, windowStateInfo);
    }

    private ResultInfo processSwipe(@NonNull View view, @NonNull RequestInfo requestInfo, @Nullable Bundle bundle) {
        ActionExtra actionExtra = requestInfo.getActionExtra();
        if (actionExtra == null) {
            Log.w(TAG, "processSwipe: ActionExtra is null");
            return createActionResult(requestInfo, bundle, -1);
        }
        boolean zPerformSwipe = ActionHelper.performSwipe(view, actionExtra.getX(), actionExtra.getY(), actionExtra.getToX(), actionExtra.getToY(), actionExtra.getDuration());
        Log.d(TAG, "performSwipe: " + zPerformSwipe);
        return createActionResult(requestInfo, bundle, zPerformSwipe ? 0 : -1);
    }

    private int setTextViaInputConnection(View view, String str) {
        try {
            InputConnection inputConnectionOnCreateInputConnection = view.onCreateInputConnection(new EditorInfo());
            if (inputConnectionOnCreateInputConnection == null) {
                Log.w(TAG, "setTextViaInputConnection: onCreateInputConnection returned null");
                return -1;
            }
            inputConnectionOnCreateInputConnection.beginBatchEdit();
            inputConnectionOnCreateInputConnection.performContextMenuAction(R.id.selectAll);
            inputConnectionOnCreateInputConnection.commitText(str, 1);
            inputConnectionOnCreateInputConnection.endBatchEdit();
            return 0;
        } catch (Exception e) {
            Log.w(TAG, "setTextViaInputConnection: exception=" + e.getMessage());
            return -1;
        }
    }

    private int trySetTextViaA11y(@NonNull View view, int i, int i6, @NonNull CharSequence charSequence) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i10 = i + iArr[0];
        int i11 = i6 + iArr[1];
        View viewFindComposeHostAt = A11yBridge.findComposeHostAt(view, i10, i11);
        if (viewFindComposeHostAt == null) {
            Log.d(TAG, b.o(i10, "trySetTextViaA11y: no Compose host at (", i11, ",", ")"));
            return -1;
        }
        int iFindEditableVirtualNodeAt = A11yBridge.findEditableVirtualNodeAt(viewFindComposeHostAt, i10, i11);
        if (iFindEditableVirtualNodeAt == -1) {
            Log.w(TAG, b.o(i10, "trySetTextViaA11y: Compose host at (", i11, ",", ") but no editable virtual node"));
            return -2;
        }
        boolean textViaAction = A11yBridge.setTextViaAction(viewFindComposeHostAt, iFindEditableVirtualNodeAt, charSequence);
        Log.d(TAG, "trySetTextViaA11y: virtualId=" + iFindEditableVirtualNodeAt + ", ok=" + textViaAction);
        return textViaAction ? 0 : -3;
    }

    @Nullable
    @UiThread
    public ResultInfo process(@NonNull View view, @NonNull RequestInfo requestInfo, @Nullable Bundle bundle) {
        String function;
        function = requestInfo.getFunction();
        String string = bundle != null ? bundle.getString(WindowStateInfo.KEY_WIN_PACKAGE, "") : "";
        String string2 = bundle != null ? bundle.getString(WindowStateInfo.KEY_WIN_ACTIVITY, "") : "";
        String string3 = bundle != null ? bundle.getString(WindowStateInfo.KEY_WIN_TITLE, "") : "";
        int i = bundle != null ? bundle.getInt("type", -1) : -1;
        StringBuilder sbW = B7.a.w("process: function=", function, ", package=", string, ", activity=");
        a.A(sbW, string2, ", windowTitle=", string3, ", windowType=");
        sbW.append(i);
        sbW.append(", root=");
        sbW.append(view);
        Log.d(TAG, sbW.toString());
        function.getClass();
        switch (function) {
            case "replaceTextByCodePoint":
            case "replaceText":
                return processReplaceText(view, requestInfo, bundle);
            case "doubleClick":
                return processDoubleClick(view, requestInfo, bundle);
            case "scrollUp":
                return processScrollUp(view, requestInfo, bundle);
            case "scrollDown":
                return processScrollDown(view, requestInfo, bundle);
            case "scrollLeft":
                return processScrollLeft(view, requestInfo, bundle);
            case "click":
                return processClick(view, requestInfo, bundle);
            case "longClick":
                return processLongClick(view, requestInfo, bundle);
            case "swipe":
                return processSwipe(view, requestInfo, bundle);
            case "snapshot":
                return processSnapshot(view, requestInfo, bundle);
            case "setText":
                return processSetText(view, requestInfo, bundle);
            case "scrollRight":
                return processScrollRight(view, requestInfo, bundle);
            default:
                Log.w(TAG, "Unknown function: ".concat(function));
                return null;
        }
    }
}
