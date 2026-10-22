package android.app.asyncinflate;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class AsyncInflateImpl implements AsyncInflateStub {
    private volatile AsyncInflateViewManager mAsyncInflate;

    public void setActivityName(Context activityContext, String activityName) {
        if (AsyncInflateControl.isEnable() && this.mAsyncInflate != null) {
            this.mAsyncInflate.setActivityName(activityName, activityContext);
        }
    }

    public void setTheme(int theme) {
        if (AsyncInflateControl.isEnable() && this.mAsyncInflate != null) {
            this.mAsyncInflate.setTheme(theme);
        }
    }

    public void finished(String activityName) {
        if (AsyncInflateControl.isEnable() && this.mAsyncInflate != null) {
            this.mAsyncInflate.finished(activityName);
        }
    }

    public void init(Context appContext) {
        if (!AsyncInflateControl.isEnable()) {
            return;
        }
        this.mAsyncInflate = AsyncInflateViewManager.getInstance(appContext);
    }

    public void destroy(String activityName) {
        if (AsyncInflateControl.isEnable() && this.mAsyncInflate != null) {
            this.mAsyncInflate.destroy(activityName);
        }
    }

    public void recordId(int id) {
        if (AsyncInflateControl.isEnable() && this.mAsyncInflate != null) {
            this.mAsyncInflate.recordId(id);
        }
    }

    public void notifyDoFrame() {
        if (AsyncInflateControl.isEnable() && this.mAsyncInflate != null) {
            this.mAsyncInflate.notifyDoFrame();
        }
    }

    public boolean shouldHook() {
        if (AsyncInflateControl.isEnable() && this.mAsyncInflate != null) {
            return this.mAsyncInflate.shouldHook();
        }
        return false;
    }

    public View findView(Context activityContext, XmlResourceParser parser, int id, ViewGroup root, boolean attachToRoot) {
        if (AsyncInflateControl.isEnable() && this.mAsyncInflate != null) {
            return this.mAsyncInflate.findView(activityContext, parser, id, root, attachToRoot);
        }
        return null;
    }
}
