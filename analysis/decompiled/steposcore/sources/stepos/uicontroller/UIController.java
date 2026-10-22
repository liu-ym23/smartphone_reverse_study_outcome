package stepos.uicontroller;

import android.content.IntentExt;
import android.content.res.Resources;
import android.hardware.display.StepOSDisplayManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteCallbackList;
import android.text.TextUtils;
import android.util.Log;
import android.util.StepOSDateTimeUrlHelper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewRootImpl;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import stepos.uicontroller.IUIController;

/* loaded from: classes.dex */
public class UIController extends IUIController.Stub {
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final RemoteCallbackList<IUIControllerEventListener> mListeners = new RemoteCallbackList<>();
    private final Map<Integer, RemoteCallbackList<IUIControllerEventListener>> mNodeIdSpecificListeners = new HashMap();
    private WeakReference<ViewRootImpl> mViewRootImpl;

    public UIController(ViewRootImpl viewRoot) {
        this.mViewRootImpl = new WeakReference<>(viewRoot);
    }

    public void notifyEvent(View view, int action) {
        UINodeInfo node = new UINodeInfo(view);
        if (this.mListeners.getRegisteredCallbackCount() > 0) {
            for (int i = this.mListeners.beginBroadcast() - 1; i >= 0; i--) {
                try {
                    IUIControllerEventListener listener = (IUIControllerEventListener) this.mListeners.getBroadcastItem(i);
                    listener.onUIEvent(node, action);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.mListeners.finishBroadcast();
        }
        synchronized (this.mNodeIdSpecificListeners) {
            int nodeId = node.getNodeId();
            RemoteCallbackList<IUIControllerEventListener> nodeListeners = this.mNodeIdSpecificListeners.get(Integer.valueOf(nodeId));
            if (nodeListeners != null && nodeListeners.getRegisteredCallbackCount() > 0) {
                for (int i2 = nodeListeners.beginBroadcast() - 1; i2 >= 0; i2--) {
                    try {
                        IUIControllerEventListener listener2 = (IUIControllerEventListener) nodeListeners.getBroadcastItem(i2);
                        listener2.onUIEvent(node, action);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                nodeListeners.finishBroadcast();
            }
        }
    }

    public void notifyViewEvent(View view, int action) {
        UINodeInfo node = new UINodeInfo(view);
        synchronized (this.mNodeIdSpecificListeners) {
            int nodeId = node.getNodeId();
            RemoteCallbackList<IUIControllerEventListener> nodeListeners = this.mNodeIdSpecificListeners.get(Integer.valueOf(nodeId));
            if (nodeListeners != null && nodeListeners.getRegisteredCallbackCount() > 0) {
                for (int i = nodeListeners.beginBroadcast() - 1; i >= 0; i--) {
                    try {
                        IUIControllerEventListener listener = (IUIControllerEventListener) nodeListeners.getBroadcastItem(i);
                        listener.onUIEvent(node, action);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                nodeListeners.finishBroadcast();
            }
        }
    }

    public void reset() {
    }

    @Override // stepos.uicontroller.IUIController
    public void findNodes(final Bundle arguments, final IUIControllerCallback callback) {
        this.mHandler.post(new Runnable() { // from class: stepos.uicontroller.UIController.1
            @Override // java.lang.Runnable
            public void run() throws Resources.NotFoundException {
                ViewRootImpl viewRoot = (ViewRootImpl) UIController.this.mViewRootImpl.get();
                if (viewRoot == null) {
                    try {
                        if (callback != null) {
                            callback.onFindNodesResult(Collections.emptyList());
                            return;
                        }
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                View view = viewRoot.getView();
                if (view == null) {
                    try {
                        if (callback != null) {
                            callback.onFindNodesResult(Collections.emptyList());
                            return;
                        }
                        return;
                    } catch (Exception e2) {
                        return;
                    }
                }
                UIController.this.findNodesUiThread(viewRoot.getView(), arguments, callback);
            }
        });
    }

    @Override // stepos.uicontroller.IUIController
    public void performAction(final int nodeId, final int action, final Bundle arguments, final IUIControllerCallback callback) {
        this.mHandler.post(new Runnable() { // from class: stepos.uicontroller.UIController.2
            @Override // java.lang.Runnable
            public void run() {
                CharSequence cs;
                ViewRootImpl viewRoot = (ViewRootImpl) UIController.this.mViewRootImpl.get();
                if (viewRoot == null) {
                    if (callback != null) {
                        try {
                            callback.onPerformActionResult(false);
                            return;
                        } catch (Exception e) {
                            return;
                        }
                    }
                    return;
                }
                View view = UIControllerNodeIdManager.getInstance().findView(nodeId);
                if (view == null) {
                    if (callback != null) {
                        try {
                            callback.onPerformActionResult(false);
                            return;
                        } catch (Exception e2) {
                            return;
                        }
                    }
                    return;
                }
                boolean ret = false;
                switch (action) {
                    case IntentExt.STEPOS_FLAG_START_FROM_NOTIFICATION /* 2097152 */:
                        if (view instanceof TextView) {
                            TextView tv = (TextView) view;
                            if (arguments != null && (cs = arguments.getCharSequence("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE")) != null) {
                                tv.setText(cs);
                                ret = true;
                                break;
                            }
                        }
                        break;
                }
                if (callback != null) {
                    try {
                        callback.onPerformActionResult(ret);
                    } catch (Exception e3) {
                    }
                }
            }
        });
    }

    @Override // stepos.uicontroller.IUIController
    public void addUIEventListener(IUIControllerEventListener listener) {
        this.mListeners.register(listener);
    }

    @Override // stepos.uicontroller.IUIController
    public void removeUIEventListener(IUIControllerEventListener listener) {
        if (listener != null) {
            this.mListeners.unregister(listener);
            synchronized (this.mNodeIdSpecificListeners) {
                if (this.mNodeIdSpecificListeners != null) {
                    for (RemoteCallbackList<IUIControllerEventListener> nodeListeners : this.mNodeIdSpecificListeners.values()) {
                        nodeListeners.unregister(listener);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void findNodesUiThread(View view, Bundle arguments, IUIControllerCallback callback) throws Resources.NotFoundException {
        int minLength;
        int maxLength;
        String resourceId = arguments.getString("resourceId");
        String className = arguments.getString("className");
        String text = arguments.getString(StepOSDisplayManager.BACK_SCREEN_BASIC_TYPE_TEXT);
        String keyword = arguments.getString("keyword");
        int minLength2 = arguments.getInt("minLength");
        int maxLength2 = arguments.getInt("maxLength");
        if (minLength2 >= 0) {
            minLength = minLength2;
        } else {
            minLength = 0;
        }
        if (maxLength2 >= 0) {
            maxLength = maxLength2;
        } else {
            maxLength = 0;
        }
        ArrayList<UINodeInfo> nodes = new ArrayList<>();
        findViewsRecursive(nodes, view, resourceId, text, keyword, className, minLength, maxLength);
        if (callback != null) {
            try {
                callback.onFindNodesResult(nodes);
            } catch (Exception e) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0151 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void findViewsRecursive(java.util.List<stepos.uicontroller.UINodeInfo> r15, android.view.View r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, int r21, int r22) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 338
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.uicontroller.UIController.findViewsRecursive(java.util.List, android.view.View, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int):void");
    }

    private static boolean viewMatchClassName(View view, String className) {
        if (TextUtils.equals(className, "TextView")) {
            return view instanceof TextView;
        }
        if (TextUtils.equals(className, "EditText")) {
            return view instanceof EditText;
        }
        if (TextUtils.equals(className, "Button")) {
            return view instanceof Button;
        }
        if (TextUtils.equals(className, "FlutterView")) {
            return view.getClass().getName().endsWith(".FlutterView");
        }
        return true;
    }

    @Override // stepos.uicontroller.IUIController
    public void printString(String text) {
        Log.w("UIController", "printString : " + text);
    }

    @Override // stepos.uicontroller.IUIController
    public void findScrollableAncestor(final int nodeId, final boolean horizontal, final IUIControllerCallback callback) {
        this.mHandler.post(new Runnable() { // from class: stepos.uicontroller.UIController.3
            @Override // java.lang.Runnable
            public void run() {
                ViewRootImpl viewRoot = (ViewRootImpl) UIController.this.mViewRootImpl.get();
                if (viewRoot == null) {
                    try {
                        if (callback != null) {
                            callback.onFindNodesResult(Collections.emptyList());
                            return;
                        }
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                View result = UIController.this.findScrollableAncestorUiThread(nodeId, horizontal, callback);
                if (result == null) {
                    if (callback != null) {
                        try {
                            callback.onFindNodesResult(Collections.emptyList());
                            return;
                        } catch (Exception e2) {
                            return;
                        }
                    }
                    return;
                }
                if (callback != null) {
                    try {
                        callback.onFindNodesResult(Collections.singletonList(new UINodeInfo(result)));
                    } catch (Exception e3) {
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.view.ViewParent] */
    public View findScrollableAncestorUiThread(int i, boolean z, IUIControllerCallback iUIControllerCallback) {
        View viewFindView = UIControllerNodeIdManager.getInstance().findView(i);
        if (viewFindView == null) {
            return null;
        }
        for (HorizontalScrollView parent = viewFindView.getParent(); parent != null; parent = parent.getParent()) {
            if (!z && (parent instanceof ScrollView)) {
                if (getScrollRange((ScrollView) parent) > 0) {
                    return parent;
                }
            } else if (z && (parent instanceof HorizontalScrollView) && getScrollRange(parent) > 0) {
                return parent;
            }
        }
        return null;
    }

    private int getScrollRange(ScrollView view) {
        if (view.getChildCount() <= 0) {
            return 0;
        }
        View child = view.getChildAt(0);
        int scrollRange = Math.max(0, child.getHeight() - ((view.getHeight() - view.getPaddingBottom()) - view.getPaddingTop()));
        return scrollRange;
    }

    private int getScrollRange(HorizontalScrollView view) {
        if (view.getChildCount() <= 0) {
            return 0;
        }
        View child = view.getChildAt(0);
        int scrollRange = Math.max(0, child.getWidth() - ((view.getWidth() - view.getPaddingLeft()) - view.getPaddingRight()));
        return scrollRange;
    }

    private String getTextByTextView(TextView textView) {
        CharSequence cs = textView.getText();
        if (!TextUtils.isEmpty(cs)) {
            return cs.toString();
        }
        CharSequence cs2 = textView.getHint();
        if (cs2 != null) {
            return cs2.toString();
        }
        return null;
    }

    private String getContentDescription(View view) {
        CharSequence cs = view.getContentDescription();
        if (cs != null) {
            return cs.toString();
        }
        return null;
    }

    @Override // stepos.uicontroller.IUIController
    public void findViewByClassHierarchy(final String classHierarchy, final IUIControllerCallback callback) {
        this.mHandler.post(new Runnable() { // from class: stepos.uicontroller.UIController.4
            @Override // java.lang.Runnable
            public void run() throws NumberFormatException {
                ViewRootImpl viewRoot = (ViewRootImpl) UIController.this.mViewRootImpl.get();
                if (viewRoot == null) {
                    try {
                        if (callback != null) {
                            callback.onFindNodesResult(Collections.emptyList());
                            return;
                        }
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                View view = viewRoot.getView();
                if (view == null) {
                    try {
                        if (callback != null) {
                            callback.onFindNodesResult(Collections.emptyList());
                            return;
                        }
                        return;
                    } catch (Exception e2) {
                        return;
                    }
                }
                UIController.this.findNodesUiThread(view, classHierarchy, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void findNodesUiThread(View view, String classHierarchy, IUIControllerCallback callback) throws NumberFormatException {
        ArrayList<UINodeInfo> nodes = new ArrayList<>();
        String[] classPath = classHierarchy.split(StepOSDateTimeUrlHelper.BACKSLASH_STRING);
        View result = findViewByClassHierarchy(view, classPath);
        if (result != null) {
            UINodeInfo node = new UINodeInfo(result);
            nodes.add(node);
        }
        if (callback != null) {
            try {
                callback.onFindNodesResult(nodes);
            } catch (Exception e) {
            }
        }
    }

    public View findViewByClassHierarchy(View rootView, String[] classPath) throws NumberFormatException {
        View windowRoot;
        View textView;
        if (rootView == null || classPath == null || classPath.length == 0) {
            return null;
        }
        ClassPathElement firstElement = parseClassPathElement(classPath[0]);
        if (firstElement.isTextMatch) {
            ViewRootImpl viewRoot = this.mViewRootImpl.get();
            if (viewRoot == null || (windowRoot = viewRoot.getView()) == null || (textView = findTextViewWithKeyword((ViewGroup) windowRoot, firstElement.textKeyword)) == null || !(textView.getParent() instanceof View)) {
                return null;
            }
            View parentView = (View) textView.getParent();
            return findViewByClassPathRecursive(parentView, classPath, 1);
        }
        if (!isClassMatch(rootView, firstElement.className)) {
            return null;
        }
        return findViewByClassPathRecursive(rootView, classPath, 1);
    }

    private View findViewByClassPathRecursive(View currentView, String[] classPath, int currentIndex) throws NumberFormatException {
        View windowRoot;
        View textView;
        if (currentIndex >= classPath.length) {
            return currentView;
        }
        if (!(currentView instanceof ViewGroup)) {
            return null;
        }
        ClassPathElement currentElement = parseClassPathElement(classPath[currentIndex]);
        if (currentElement.isTextMatch) {
            ViewRootImpl viewRoot = this.mViewRootImpl.get();
            if (viewRoot == null || (windowRoot = viewRoot.getView()) == null || (textView = findTextViewWithKeyword((ViewGroup) windowRoot, currentElement.textKeyword)) == null || !(textView.getParent() instanceof View)) {
                return null;
            }
            View parentView = (View) textView.getParent();
            return findViewByClassPathRecursive(parentView, classPath, currentIndex + 1);
        }
        View targetView = findChildByClassAndIndex((ViewGroup) currentView, currentElement);
        if (targetView != null) {
            return findViewByClassPathRecursive(targetView, classPath, currentIndex + 1);
        }
        return null;
    }

    private ClassPathElement parseClassPathElement(String pathElement) throws NumberFormatException {
        int index;
        if (pathElement == null) {
            return new ClassPathElement("", 1);
        }
        if (pathElement.startsWith("@")) {
            return new ClassPathElement(pathElement.substring(1));
        }
        int hashIndex = pathElement.indexOf(35);
        if (hashIndex == -1) {
            return new ClassPathElement(pathElement, 1);
        }
        String className = pathElement.substring(0, hashIndex);
        try {
            index = Integer.parseInt(pathElement.substring(hashIndex + 1));
        } catch (NumberFormatException e) {
            index = 1;
        }
        return new ClassPathElement(className, index);
    }

    private View findChildByClassAndIndex(ViewGroup parent, ClassPathElement element) {
        int currentIndex = 0;
        for (int i = 0; i < parent.getChildCount(); i++) {
            View child = parent.getChildAt(i);
            if (isClassMatch(child, element.className) && (currentIndex = currentIndex + 1) == element.index) {
                return child;
            }
        }
        return null;
    }

    private View findTextViewWithKeyword(ViewGroup parent, String keyword) throws Resources.NotFoundException {
        ArrayList<UINodeInfo> resultNodes = new ArrayList<>();
        findViewsRecursive(resultNodes, parent, null, null, keyword, null, 0, 0);
        if (!resultNodes.isEmpty()) {
            return UIControllerNodeIdManager.getInstance().findView(resultNodes.get(0).getNodeId());
        }
        return null;
    }

    private boolean isClassMatch(View view, String className) {
        if (view == null || className == null || className.isEmpty()) {
            return false;
        }
        return className.equals(view.getClass().getSimpleName());
    }

    private static class ClassPathElement {
        final String className;
        final int index;
        final boolean isTextMatch;
        final String textKeyword;

        ClassPathElement(String className, int index) {
            this.className = className;
            this.index = index;
            this.textKeyword = null;
            this.isTextMatch = false;
        }

        ClassPathElement(String textKeyword) {
            this.className = null;
            this.index = 0;
            this.textKeyword = textKeyword;
            this.isTextMatch = true;
        }
    }

    @Override // stepos.uicontroller.IUIController
    public void addUIEventListenerForNodeId(int nodeId, IUIControllerEventListener listener) {
        if (listener == null) {
            return;
        }
        synchronized (this.mNodeIdSpecificListeners) {
            RemoteCallbackList<IUIControllerEventListener> nodeListeners = this.mNodeIdSpecificListeners.get(Integer.valueOf(nodeId));
            if (nodeListeners == null) {
                nodeListeners = new RemoteCallbackList<>();
                this.mNodeIdSpecificListeners.put(Integer.valueOf(nodeId), nodeListeners);
            }
            nodeListeners.register(listener);
        }
    }

    @Override // stepos.uicontroller.IUIController
    public void removeUIEventListenerForNodeId(int nodeId, IUIControllerEventListener listener) {
        if (listener == null) {
            return;
        }
        synchronized (this.mNodeIdSpecificListeners) {
            RemoteCallbackList<IUIControllerEventListener> nodeListeners = this.mNodeIdSpecificListeners.get(Integer.valueOf(nodeId));
            if (nodeListeners != null) {
                nodeListeners.unregister(listener);
                if (nodeListeners.getRegisteredCallbackCount() == 0) {
                    this.mNodeIdSpecificListeners.remove(Integer.valueOf(nodeId));
                }
            }
        }
    }

    @Override // stepos.uicontroller.IUIController
    public void removeAllListenersForNodeId(int nodeId) {
        synchronized (this.mNodeIdSpecificListeners) {
            this.mNodeIdSpecificListeners.remove(Integer.valueOf(nodeId));
        }
    }

    @Override // stepos.uicontroller.IUIController
    public boolean isMonitoringUINode(int nodeId) {
        boolean zContainsKey;
        synchronized (this.mNodeIdSpecificListeners) {
            zContainsKey = this.mNodeIdSpecificListeners.containsKey(Integer.valueOf(nodeId));
        }
        return zContainsKey;
    }

    private boolean matchWithWildcard(String text, String pattern) {
        String[] parts = pattern.split("\\*", -1);
        int lastIndex = 0;
        for (String part : parts) {
            if (!part.isEmpty()) {
                int index = text.indexOf(part, lastIndex);
                if (index == -1) {
                    return false;
                }
                lastIndex = part.length() + index;
            }
        }
        return true;
    }

    private boolean isTextLengthMatch(String text, int minLength, int maxLength) {
        if (text == null) {
            return false;
        }
        if (minLength == 0 && maxLength == 0) {
            return true;
        }
        String trimmedText = text.replaceAll("\\s+", "");
        int length = trimmedText.length();
        if (minLength != 0 && length < minLength) {
            return false;
        }
        if (maxLength != 0 && length > maxLength) {
            return false;
        }
        return true;
    }
}
