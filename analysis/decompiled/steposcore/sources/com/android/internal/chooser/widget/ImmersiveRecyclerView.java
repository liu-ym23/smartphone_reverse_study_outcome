package com.android.internal.chooser.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.android.internal.chooser.utils.Utils;
import com.android.internal.widget.RecyclerView;

/* loaded from: classes.dex */
public class ImmersiveRecyclerView extends RecyclerView {
    private final Context mContext;
    private boolean mIsChooser;

    public ImmersiveRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
    }

    public void setIsChooser(boolean isChooser) {
        this.mIsChooser = isChooser;
    }

    public void setBackgroundAndPadding(int position, int viewType, int columnNum, int favoriteSize, int allSize, boolean isCollapse) {
        RecyclerView.ViewHolder viewHolder;
        if (!this.mIsChooser || (viewHolder = findViewHolderForAdapterPosition(position)) == null) {
            return;
        }
        View itemView = viewHolder.itemView;
        setBackgroundAndPadding(position, viewType, itemView, columnNum, favoriteSize, allSize, isCollapse);
    }

    public void setBackgroundAndPadding(int position, int viewType, View itemView, int columnNum, int favoriteSize, int allSize, boolean isCollapse) {
        if (!this.mIsChooser) {
            return;
        }
        int extraPadding = Utils.dp2px(8.0f, this.mContext);
        if (viewType == 0 || viewType == 1) {
            int atRow = position / columnNum;
            int allRowCount = (favoriteSize / columnNum) + 1;
            if (allRowCount == 1) {
                itemView.setPadding(0, extraPadding, 0, 0);
                return;
            } else {
                if (atRow == allRowCount - 1) {
                    if (isCollapse) {
                        itemView.setPadding(0, 0, 0, extraPadding);
                        return;
                    } else {
                        itemView.setPadding(0, 0, 0, 0);
                        return;
                    }
                }
                return;
            }
        }
        if (viewType == 6) {
            itemView.setPadding(0, extraPadding, 0, 0);
        }
    }
}
