package com.android.internal.chooser.adapter;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.ColorFilter;
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
import com.android.internal.chooser.widget.helper.ItemTouchHelper;
import com.android.internal.widget.GridLayoutManager;
import com.android.internal.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class SettingFavoriteAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final Activity mActivity;
    private final Context mContext;
    private List<DisplayResolveInfo> mData;
    private int mIconDpi;
    private OnItemChangedListener mOnItemChangedListener;
    private final Resources mResources;

    public interface OnItemChangedListener {
        void onItemMoved(DisplayResolveInfo displayResolveInfo, DisplayResolveInfo displayResolveInfo2, int i, int i2);

        void onItemRemoved(DisplayResolveInfo displayResolveInfo);
    }

    public SettingFavoriteAdapter(Context context, Activity activity) {
        this.mContext = context;
        this.mActivity = activity;
        ActivityManager am = (ActivityManager) context.getSystemService("activity");
        if (am != null) {
            this.mIconDpi = am.getLauncherLargeIconDensity();
        } else {
            LogUtils.d("ActivityManager == null, use default dpi=" + this.mIconDpi);
        }
        this.mResources = context.getResources();
    }

    public void setOnItemChangedListener(OnItemChangedListener onItemChangedListener) {
        this.mOnItemChangedListener = onItemChangedListener;
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

    /* renamed from: onCreateViewHolder, reason: merged with bridge method [inline-methods] */
    public ViewHolder m445onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.mContext).inflate(17367453, parent, false);
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

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        updateLayoutManager(recyclerView);
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchCallback());
        helper.attachToRecyclerView(recyclerView);
    }

    public void updateLayoutManager(RecyclerView recyclerView) {
        boolean landscape = this.mContext.getResources().getConfiguration().orientation == 2;
        if (this.mActivity != null) {
            boolean isInMultiWindow = this.mActivity.isInMultiWindowMode();
            if (isInMultiWindow) {
                landscape = false;
            }
        } else {
            LogUtils.w("owner activity is null");
        }
        int columnNum = landscape ? 7 : 4;
        GridLayoutManager layoutManager = new GridLayoutManager(this.mContext, columnNum);
        recyclerView.setLayoutManager(layoutManager);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView mActivityLabel;
        private final TextView mAppLabel;
        private final ImageView mIcon;
        private final ImageView mIconRemove;
        private final View mRoot;

        public ViewHolder(View itemView) {
            super(itemView);
            this.mRoot = itemView;
            this.mIcon = (ImageView) itemView.findViewById(R.id.no_permissions);
            this.mActivityLabel = (TextView) itemView.findViewById(R.id.no_applications_message);
            this.mAppLabel = (TextView) itemView.findViewById(R.id.nokeys);
            this.mIconRemove = (ImageView) itemView.findViewById(R.id.none);
        }

        void bindData(DisplayResolveInfo displayInfo) {
            final DisplayResolveInfo displayInfo2;
            if (displayInfo == null) {
                this.mRoot.setVisibility(4);
                displayInfo2 = displayInfo;
            } else {
                this.mRoot.setVisibility(0);
                CharSequence activityLabel = AppInfo.getCustomLabel(SettingFavoriteAdapter.this.mContext, displayInfo.resolveInfo);
                if (TextUtils.isEmpty(activityLabel)) {
                    activityLabel = displayInfo.activityLabel;
                }
                this.mActivityLabel.setText(activityLabel);
                CharSequence appLabel = AppInfo.getCustomAppName(SettingFavoriteAdapter.this.mContext, displayInfo.resolveInfo);
                if (TextUtils.isEmpty(appLabel)) {
                    appLabel = displayInfo.appLabel;
                }
                this.mAppLabel.setText(appLabel);
                Context userContext = SettingFavoriteAdapter.this.mContext.createContextAsUser(displayInfo.resolveInfo.userHandle, 0);
                PackageManager mPackageManager = userContext.getPackageManager();
                displayInfo2 = displayInfo;
                ImageLoader.getInstance().load(this.mIcon, displayInfo2, SettingFavoriteAdapter.this.mIconDpi, mPackageManager, SettingFavoriteAdapter.this.mResources);
                Drawable drawable = Utils.getIconStrokeDrawable(SettingFavoriteAdapter.this.mContext);
                if (drawable != null && this.mIcon != null) {
                    this.mIcon.setForeground(drawable);
                }
            }
            if (SettingFavoriteAdapter.this.mData.size() > 1) {
                this.mIconRemove.setImageResource(17304653);
                this.mIconRemove.setBackground(new DarkImageDrawable(this.mIconRemove));
                this.mIconRemove.setOnClickListener(new View.OnClickListener() { // from class: com.android.internal.chooser.adapter.SettingFavoriteAdapter.ViewHolder.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (SettingFavoriteAdapter.this.mOnItemChangedListener != null) {
                            SettingFavoriteAdapter.this.mOnItemChangedListener.onItemRemoved(displayInfo2);
                        }
                    }
                });
            } else {
                this.mIconRemove.setImageResource(17304654);
                this.mIconRemove.setBackground(null);
                this.mIconRemove.setOnClickListener(null);
            }
            SettingFavoriteAdapter.this.setItemViewHeight(this.itemView);
        }

        public void onDragStart() {
            this.mIcon.setColorFilter(DarkImageDrawable.sDarkFilter);
            this.mActivityLabel.setVisibility(4);
            this.mAppLabel.setVisibility(4);
        }

        public void onDragEnd() {
            this.mIcon.setColorFilter((ColorFilter) null);
            this.mActivityLabel.setVisibility(0);
            this.mAppLabel.setVisibility(0);
        }
    }

    public class ItemTouchCallback extends ItemTouchHelper.Callback {
        public ItemTouchCallback() {
        }

        @Override // com.android.internal.chooser.widget.helper.ItemTouchHelper.Callback
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return makeMovementFlags(15, 0);
        }

        @Override // com.android.internal.chooser.widget.helper.ItemTouchHelper.Callback
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            int fromPosition = viewHolder.getAdapterPosition();
            int toPosition = target.getAdapterPosition();
            DisplayResolveInfo movedItem = (DisplayResolveInfo) SettingFavoriteAdapter.this.mData.get(fromPosition);
            DisplayResolveInfo beforeItem = null;
            if (toPosition > 0) {
                beforeItem = (DisplayResolveInfo) SettingFavoriteAdapter.this.mData.get(toPosition - 1);
            }
            DisplayResolveInfo resolveInfo = (DisplayResolveInfo) SettingFavoriteAdapter.this.mData.remove(fromPosition);
            SettingFavoriteAdapter.this.mData.add(toPosition, resolveInfo);
            SettingFavoriteAdapter.this.notifyItemMoved(fromPosition, toPosition);
            if (SettingFavoriteAdapter.this.mOnItemChangedListener != null) {
                SettingFavoriteAdapter.this.mOnItemChangedListener.onItemMoved(movedItem, beforeItem, fromPosition, toPosition);
                return true;
            }
            return true;
        }

        @Override // com.android.internal.chooser.widget.helper.ItemTouchHelper.Callback
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        }

        @Override // com.android.internal.chooser.widget.helper.ItemTouchHelper.Callback
        public boolean isLongPressDragEnabled() {
            return super.isLongPressDragEnabled();
        }

        @Override // com.android.internal.chooser.widget.helper.ItemTouchHelper.Callback
        public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
            super.onSelectedChanged(viewHolder, actionState);
            if (viewHolder == null) {
                return;
            }
            ((ViewHolder) viewHolder).onDragStart();
        }

        @Override // com.android.internal.chooser.widget.helper.ItemTouchHelper.Callback
        public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            super.clearView(recyclerView, viewHolder);
            if (viewHolder == null) {
                return;
            }
            ((ViewHolder) viewHolder).onDragEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setItemViewHeight(View itemView) {
        if (itemView.getLayoutParams() != null) {
            TextView tv1 = (TextView) itemView.findViewById(R.id.no_applications_message);
            int diff1 = (int) (tv1.getTextSize() - 36.0f);
            TextView tv2 = (TextView) itemView.findViewById(R.id.nokeys);
            int diff2 = (int) (tv2.getTextSize() - 28.0f);
            View content = itemView.findViewById(R.id.nonZero);
            if (content != null && content.getLayoutParams() != null) {
                content.getLayoutParams().height = Utils.dp2px(124.0f, this.mContext) + diff1 + diff2;
            }
        }
    }
}
