package com.android.internal.chooser.adapter;

import android.R;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.internal.chooser.bean.DisplayResolveInfo;
import com.android.internal.chooser.chooser.AppInfo;
import com.android.internal.chooser.utils.ImageLoader;
import com.android.internal.chooser.utils.LogUtils;
import com.android.internal.chooser.utils.Utils;
import com.android.internal.chooser.widget.DarkImageDrawable;
import com.android.internal.chooser.widget.DiffCallback;
import com.android.internal.chooser.widget.DiffUtil;
import com.android.internal.widget.LinearLayoutManager;
import com.android.internal.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class SettingCollapseAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final Context mContext;
    private List<DisplayResolveInfo> mData;
    private int mIconDpi;
    private final LayoutInflater mInflater;
    private OnItemChangedListener mOnItemChangedListener;
    private final PackageManager mPackageManager;
    private final Resources mResources;
    private final int mWidth;

    public interface OnItemChangedListener {
        void onItemRemoved(DisplayResolveInfo displayResolveInfo);
    }

    public SettingCollapseAdapter(Context context) {
        this.mContext = context;
        this.mPackageManager = context.getPackageManager();
        ActivityManager am = (ActivityManager) context.getSystemService("activity");
        if (am != null) {
            this.mIconDpi = am.getLauncherLargeIconDensity();
        } else {
            LogUtils.d("ActivityManager == null, use default dpi=" + this.mIconDpi);
        }
        this.mInflater = LayoutInflater.from(context);
        this.mResources = context.getResources();
        this.mWidth = Utils.dp2px(context, 50.0f);
    }

    public void setData(List<DisplayResolveInfo> data) {
        List<Object> oldData = this.mData == null ? new ArrayList<>() : new ArrayList<>(this.mData);
        this.mData = new ArrayList(data);
        if (oldData.size() == 0) {
            notifyDataSetChanged();
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffCallback(oldData, this.mData));
            result.dispatchUpdatesTo(this);
        }
    }

    public void setOnItemChangedListener(OnItemChangedListener onItemChangedListener) {
        this.mOnItemChangedListener = onItemChangedListener;
    }

    /* renamed from: onCreateViewHolder, reason: merged with bridge method [inline-methods] */
    public ViewHolder m438onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = this.mInflater.inflate(17367452, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(this.mData.get(position));
    }

    public int getItemCount() {
        if (this.mData == null) {
            return 0;
        }
        return this.mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView mActivityLabel;
        private final TextView mAppLabel;
        private final ImageView mIcon;
        private final ImageView mIconAdd;
        private final View mRoot;

        public ViewHolder(View itemView) {
            super(itemView);
            this.mRoot = itemView;
            this.mIcon = (ImageView) itemView.findViewById(R.id.no_permissions);
            this.mActivityLabel = (TextView) itemView.findViewById(R.id.no_applications_message);
            this.mAppLabel = (TextView) itemView.findViewById(R.id.nokeys);
            this.mIconAdd = (ImageView) itemView.findViewById(R.id.no_drop);
            this.mIconAdd.setBackground(new DarkImageDrawable(this.mIconAdd));
        }

        void bindData(DisplayResolveInfo displayInfo) {
            final DisplayResolveInfo displayInfo2;
            if (displayInfo == null) {
                this.mRoot.setVisibility(4);
                displayInfo2 = displayInfo;
            } else {
                this.mRoot.setVisibility(0);
                CharSequence activityLabel = AppInfo.getCustomLabel(SettingCollapseAdapter.this.mContext, displayInfo.resolveInfo);
                if (TextUtils.isEmpty(activityLabel)) {
                    activityLabel = displayInfo.activityLabel;
                }
                this.mActivityLabel.setText(activityLabel);
                CharSequence appLabel = AppInfo.getCustomAppName(SettingCollapseAdapter.this.mContext, displayInfo.resolveInfo);
                if (TextUtils.isEmpty(appLabel)) {
                    appLabel = displayInfo.appLabel;
                }
                this.mAppLabel.setText(appLabel);
                Context userContext = SettingCollapseAdapter.this.mContext.createContextAsUser(displayInfo.resolveInfo.userHandle, 0);
                PackageManager mPackageManager = userContext.getPackageManager();
                displayInfo2 = displayInfo;
                ImageLoader.getInstance().load(this.mIcon, displayInfo2, SettingCollapseAdapter.this.mIconDpi, mPackageManager, SettingCollapseAdapter.this.mResources);
                Drawable drawable = Utils.getIconStrokeDrawable(SettingCollapseAdapter.this.mContext);
                if (drawable != null && this.mIcon != null) {
                    this.mIcon.setForeground(drawable);
                }
            }
            this.mIconAdd.setOnClickListener(new View.OnClickListener() { // from class: com.android.internal.chooser.adapter.SettingCollapseAdapter.ViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (SettingCollapseAdapter.this.mOnItemChangedListener != null) {
                        SettingCollapseAdapter.this.mOnItemChangedListener.onItemRemoved(displayInfo2);
                    }
                }
            });
        }
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.mContext);
        recyclerView.setLayoutManager(layoutManager);
    }
}
