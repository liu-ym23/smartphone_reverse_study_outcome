package com.mdisdk.capability.model;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.mdisdk.capability.model.ViewNode;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ViewNodeIndexManager {
    private static volatile ViewNodeIndexManager sInstance;

    @Nullable
    private ViewNode.BuildResult mBuildResult;

    private ViewNodeIndexManager() {
    }

    @NonNull
    public static ViewNodeIndexManager getInstance() {
        if (sInstance == null) {
            synchronized (ViewNodeIndexManager.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new ViewNodeIndexManager();
                    }
                } finally {
                }
            }
        }
        return sInstance;
    }

    public void clear() {
        this.mBuildResult = null;
    }

    @Nullable
    public View findView(@NonNull ViewNode viewNode) {
        ViewNode.BuildResult buildResult = this.mBuildResult;
        if (buildResult == null) {
            return null;
        }
        return buildResult.findView(viewNode);
    }

    @NonNull
    public List<View> findViews(@NonNull List<ViewNode> list) {
        ViewNode.BuildResult buildResult = this.mBuildResult;
        return buildResult == null ? new ArrayList() : buildResult.findViews(list);
    }

    @Nullable
    public ViewNode.BuildResult getBuildResult() {
        return this.mBuildResult;
    }

    @Nullable
    public ViewNode getRootNode() {
        ViewNode.BuildResult buildResult = this.mBuildResult;
        if (buildResult != null) {
            return buildResult.getRootNode();
        }
        return null;
    }

    public boolean isInitialized() {
        return this.mBuildResult != null;
    }

    public int size() {
        ViewNode.BuildResult buildResult = this.mBuildResult;
        if (buildResult != null) {
            return buildResult.size();
        }
        return 0;
    }

    public void updateIndex(@NonNull ViewNode.BuildResult buildResult) {
        this.mBuildResult = buildResult;
    }

    @Nullable
    public View findView(long j5) {
        ViewNode.BuildResult buildResult = this.mBuildResult;
        if (buildResult == null) {
            return null;
        }
        return buildResult.findView(j5);
    }
}
