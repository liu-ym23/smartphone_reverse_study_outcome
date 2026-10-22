package com.android.internal.chooser.adapter;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.internal.chooser.base.OnViewClickListener;
import com.android.internal.chooser.bean.DisplayResolveInfo;
import com.android.internal.chooser.db.ChooserRepository;
import com.android.internal.chooser.utils.LogUtils;
import com.android.internal.chooser.utils.StepOSPressAnimationHelper;
import com.android.internal.chooser.utils.StepOSThemeUtils;
import com.android.internal.chooser.utils.Utils;
import com.android.internal.chooser.widget.DiffCallback;
import com.android.internal.chooser.widget.DiffUtil;
import com.android.internal.chooser.widget.ImmersiveRecyclerView;
import com.android.internal.widget.GridLayoutManager;
import com.android.internal.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class BaseResolverAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int CROSS_USER_SHARE = 1;
    public static final int FAKE_DATA_DIVIDER = 3;
    public static final int FAKE_DATA_EDIT_BUTTON = 2;
    public static final int FAKE_DATA_MORE = 0;
    public static final int FAKE_DATA_SPACING = 4;
    private static final int MENU_ITEM_ADD_FAVORITE = 2;
    private static final int MENU_ITEM_REMOVE_FAVORITE = 3;
    private static final int MENU_ITEM_SHARE_TO_CLONED_APP = 5;
    private static final int MENU_ITEM_SHARE_TO_MAIN_APP = 4;
    private static final int MENU_ITEM_SHARE_WITH_FULL_SCREEN = 1;
    private static final int MENU_ITEM_SHARE_WITH_QUICK_LOOK = 0;
    private static final int RESULT_CLONE_APP = 2;
    public static final int VIEW_TYPE_COLLAPSE_ITEM = 3;
    public static final int VIEW_TYPE_DEVICE_ITEM = 6;
    public static final int VIEW_TYPE_DIVIDER = 5;
    public static final int VIEW_TYPE_EDIT_BUTTON = 4;
    public static final int VIEW_TYPE_FAVORITE_ITEM = 0;
    public static final int VIEW_TYPE_MORE_BUTTON = 1;
    public static final int VIEW_TYPE_SPACING = 7;
    private static boolean sIsPoleStarTheme = false;
    private final Activity mActivity;
    private final ChooserRepository mChooserRepository;
    private final Context mContext;
    private List<DisplayResolveInfo> mData;
    private List<Object> mDisplayData;
    private StepOSPressAnimationHelper mHelper;
    private int mIconDpi;
    private final LayoutInflater mInflater;
    private final boolean mIsChooserActivity;
    private RecyclerView.ItemDecoration mItemDecoration;
    private final OnViewClickListener mOnViewClickListener;
    private ImmersiveRecyclerView mRecyclerView;
    private final Resources mResources;
    private int mSelector;
    private final boolean mShowRecommendTagIfNeed;
    private int mTextColor;
    List<DisplayResolveInfo> favorites = new ArrayList();
    List<DisplayResolveInfo> collapses = new ArrayList();
    List<DisplayResolveInfo> devices = new ArrayList();
    private boolean mIsCollapse = true;
    private int mShouldCancelItemAnim = -1;
    private int columnNum = 4;

    public BaseResolverAdapter(Activity activity, Context context, OnViewClickListener listener, boolean isChooserActivity, boolean showRecommendTagIfNeed) {
        this.mActivity = activity;
        this.mContext = context;
        this.mChooserRepository = ChooserRepository.getInstance(context);
        ActivityManager am = (ActivityManager) activity.getSystemService("activity");
        if (am != null) {
            this.mIconDpi = am.getLauncherLargeIconDensity();
        } else {
            LogUtils.d("ActivityManager == null, use default dpi=" + this.mIconDpi);
        }
        sIsPoleStarTheme = StepOSThemeUtils.isPoleStarTheme();
        this.mInflater = LayoutInflater.from(context);
        this.mResources = context.getResources();
        this.mOnViewClickListener = listener;
        this.mIsChooserActivity = isChooserActivity;
        this.mShowRecommendTagIfNeed = showRecommendTagIfNeed;
        this.mHelper = new StepOSPressAnimationHelper();
    }

    public void setData(List<DisplayResolveInfo> list) {
        this.mData = list;
        rebuildData(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rebuildData(List<DisplayResolveInfo> list) {
        List<Object> oldData = this.mDisplayData == null ? new ArrayList<>() : new ArrayList<>(this.mDisplayData);
        this.favorites.clear();
        this.collapses.clear();
        this.devices.clear();
        if (this.mIsChooserActivity) {
            for (DisplayResolveInfo info : list) {
                if (info.isDevice()) {
                    this.devices.add(info);
                } else if (info.isCollapse()) {
                    this.collapses.add(info);
                } else {
                    this.favorites.add(info);
                }
            }
            List<Object> data = new ArrayList<>(this.favorites);
            data.add(0);
            if (!this.mIsCollapse) {
                data.add(3);
                data.addAll(this.collapses);
                data.add(2);
            }
            if (!this.devices.isEmpty()) {
                data.add(4);
            }
            data.addAll(this.devices);
            this.mDisplayData = data;
        } else {
            this.mDisplayData = new ArrayList(list);
        }
        if (oldData.size() == 0 || this.mShouldCancelItemAnim == 0) {
            notifyDataSetChanged();
        } else {
            List<Object> newData = new ArrayList<>(this.mDisplayData);
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffCallback(oldData, newData));
            result.dispatchUpdatesTo(this);
        }
        for (int i = 0; i < this.mDisplayData.size(); i++) {
            this.mRecyclerView.setBackgroundAndPadding(i, getItemViewType(i), this.columnNum, this.favorites.size(), this.mDisplayData.size(), this.mIsCollapse);
        }
    }

    public void refresh() {
        if (this.mData != null && !this.mData.isEmpty()) {
            rebuildData(this.mData);
        }
    }

    public void setTextColor(int textColor) {
        this.mTextColor = textColor;
    }

    public void setItemSelector(int selector) {
        this.mSelector = selector;
    }

    public int getItemViewType(int position) {
        Object data = this.mDisplayData.get(position);
        if (data instanceof Integer) {
            int fakeData = ((Integer) data).intValue();
            if (fakeData == 0) {
                return 1;
            }
            if (fakeData == 2) {
                return 4;
            }
            if (fakeData == 4) {
                return 7;
            }
            return 5;
        }
        DisplayResolveInfo info = (DisplayResolveInfo) data;
        if (info.isDevice()) {
            return 6;
        }
        if (info.isCollapse()) {
            return 3;
        }
        return 0;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                View view = this.mInflater.inflate(17367448, parent, false);
                return new ResolveInfoViewHolder(view);
            case 1:
                View view2 = this.mInflater.inflate(17367448, parent, false);
                return new MoreButtonViewHolder(view2);
            case 2:
            default:
                View view3 = this.mInflater.inflate(17367445, parent, false);
                return new MoreButtonViewHolder(view3);
            case 3:
                View view4 = this.mInflater.inflate(17367444, parent, false);
                return new ResolveInfoViewHolder(view4);
            case 4:
                View view5 = this.mInflater.inflate(17367447, parent, false);
                return new EditButtonViewHolder(view5);
            case 5:
                View view6 = this.mInflater.inflate(17367446, parent, false);
                return new SpaceViewHolder(this, view6);
            case 6:
                View view7 = this.mInflater.inflate(17367445, parent, false);
                return new ResolveInfoViewHolder(view7);
            case 7:
                View view8 = this.mInflater.inflate(17367449, parent, false);
                return new SpaceViewHolder(this, view8);
        }
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        this.mRecyclerView.setBackgroundAndPadding(position, getItemViewType(position), holder.itemView, this.columnNum, this.favorites.size(), this.mDisplayData.size(), this.mIsCollapse);
        if (holder instanceof ResolveInfoViewHolder) {
            ((ResolveInfoViewHolder) holder).bindData((DisplayResolveInfo) this.mDisplayData.get(position), getItemViewType(position));
        }
    }

    public int getItemCount() {
        if (this.mDisplayData == null) {
            return 0;
        }
        return this.mDisplayData.size();
    }

    public class ResolveInfoViewHolder extends RecyclerView.ViewHolder {
        private final TextView mActivityLabel;
        private final TextView mAppLabel;
        private final ImageView mIcon;
        private final ImageView mRecommendIcon;
        private final View mRoot;

        ResolveInfoViewHolder(View itemView) {
            super(itemView);
            this.mRoot = itemView;
            this.mIcon = (ImageView) itemView.findViewById(R.id.no_permissions);
            this.mActivityLabel = (TextView) itemView.findViewById(R.id.no_applications_message);
            this.mAppLabel = (TextView) itemView.findViewById(R.id.nokeys);
            this.mRecommendIcon = (ImageView) itemView.findViewById(R.id.nonav);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean hasMultiOpenPkg(int uid) {
            if (BaseResolverAdapter.this.mContext == null) {
                LogUtils.e("context is null");
                return false;
            }
            String[] packagesForUid = BaseResolverAdapter.this.mContext.getPackageManager().getPackagesForUid(99900000 + uid);
            return packagesForUid != null && packagesForUid.length > 0;
        }

        /* JADX WARN: Removed duplicated region for block: B:49:0x010b  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x0153  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void bindData(final com.android.internal.chooser.bean.DisplayResolveInfo r14, int r15) {
            /*
                Method dump skipped, instructions count: 366
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.internal.chooser.adapter.BaseResolverAdapter.ResolveInfoViewHolder.bindData(com.android.internal.chooser.bean.DisplayResolveInfo, int):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$bindData$0(DisplayResolveInfo displayInfo, View v, MotionEvent event) {
            if (displayInfo.isFavorite || displayInfo.isDevice) {
                BaseResolverAdapter.this.mHelper.handleCustomTouch(this.mIcon, event);
                return false;
            }
            return false;
        }
    }

    class SpaceViewHolder extends RecyclerView.ViewHolder {
        public SpaceViewHolder(BaseResolverAdapter this$0, View itemView) {
            super(itemView);
        }
    }

    class EditButtonViewHolder extends RecyclerView.ViewHolder {
        public EditButtonViewHolder(View itemView) {
            super(itemView);
            Button button = (Button) itemView.findViewById(R.id.group_message_container);
            if (BaseResolverAdapter.sIsPoleStarTheme) {
                button.setTextColor(BaseResolverAdapter.this.mContext.getResources().getColor(17171518));
            }
            button.setOnClickListener(new View.OnClickListener() { // from class: com.android.internal.chooser.adapter.BaseResolverAdapter.EditButtonViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!Utils.isFastClick()) {
                        BaseResolverAdapter.this.mOnViewClickListener.onEditButtonClick(BaseResolverAdapter.this.favorites, BaseResolverAdapter.this.collapses);
                    }
                }
            });
        }
    }

    class MoreButtonViewHolder extends RecyclerView.ViewHolder {
        private final ImageView mIcon;
        private final TextView mLabel;

        public MoreButtonViewHolder(View itemView) {
            super(itemView);
            this.mIcon = (ImageView) itemView.findViewById(R.id.no_permissions);
            final Drawable foreDrawable = BaseResolverAdapter.this.mContext.getDrawable(17304657);
            final Drawable foreDrawableReverse = BaseResolverAdapter.this.mContext.getDrawable(17304656);
            this.mIcon.setBackground(BaseResolverAdapter.this.mContext.getDrawable(17304658));
            this.mIcon.setForeground(BaseResolverAdapter.this.mContext.getDrawable(17304659));
            this.mIcon.setForegroundGravity(17);
            itemView.setOnClickListener(new View.OnClickListener() { // from class: com.android.internal.chooser.adapter.BaseResolverAdapter.MoreButtonViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Drawable drawable = BaseResolverAdapter.this.mIsCollapse ? foreDrawable : foreDrawableReverse;
                    MoreButtonViewHolder.this.mIcon.setForeground(drawable);
                    ((Animatable) drawable).start();
                    BaseResolverAdapter.this.mIsCollapse = !BaseResolverAdapter.this.mIsCollapse;
                    BaseResolverAdapter.this.mOnViewClickListener.onMoreButtonClick(BaseResolverAdapter.this.mIsCollapse);
                    BaseResolverAdapter.this.rebuildData(BaseResolverAdapter.this.mData);
                }
            });
            this.mLabel = (TextView) itemView.findViewById(R.id.no_applications_message);
            this.mLabel.setText(17042468);
        }
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        updateLayoutManager(recyclerView);
    }

    public void updateLayoutManager(RecyclerView recyclerView) {
        this.mRecyclerView = (ImmersiveRecyclerView) recyclerView;
        this.mRecyclerView.setIsChooser(this.mIsChooserActivity);
        boolean landscape = this.mContext.getResources().getConfiguration().orientation == 2;
        if (this.mActivity != null) {
            boolean isInMultiWindow = this.mActivity.isInMultiWindowMode();
            if (isInMultiWindow) {
                landscape = false;
            }
        } else {
            LogUtils.w("owner activity is null");
        }
        this.columnNum = landscape ? 7 : 4;
        GridLayoutManager layoutManager = new GridLayoutManager(this.mContext, this.columnNum);
        recyclerView.setLayoutManager(layoutManager);
        if (this.mItemDecoration != null) {
            this.mRecyclerView.removeItemDecoration(this.mItemDecoration);
        }
        this.mItemDecoration = new SpaceItemDecoration();
        this.mRecyclerView.addItemDecoration(this.mItemDecoration);
        recyclerView.getLayoutManager().setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.android.internal.chooser.adapter.BaseResolverAdapter.1
            public int getSpanSize(int position) {
                switch (BaseResolverAdapter.this.getItemViewType(position)) {
                    case 3:
                    case 4:
                    case 5:
                    case 7:
                        return BaseResolverAdapter.this.columnNum;
                    case 6:
                    default:
                        return 1;
                }
            }
        });
        recyclerView.requestLayout();
    }

    public long getItemId(int position) {
        return super.getItemId(position);
    }

    private class SpaceItemDecoration extends RecyclerView.ItemDecoration {
        private SpaceItemDecoration() {
        }

        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            int position = parent.getChildAdapterPosition(view);
            if (position < 0) {
                return;
            }
            int itemViewType = BaseResolverAdapter.this.getItemViewType(position);
            int spacing = Utils.dp2px(8.0f, BaseResolverAdapter.this.mContext);
            if (itemViewType == 0 || itemViewType == 1) {
                int columnIndex = position % BaseResolverAdapter.this.columnNum;
                outRect.left = spacing - ((columnIndex * spacing) / BaseResolverAdapter.this.columnNum);
                outRect.right = ((columnIndex + 1) * spacing) / BaseResolverAdapter.this.columnNum;
            } else if (itemViewType == 6) {
                int columnIndex2 = position - (BaseResolverAdapter.this.mDisplayData.size() - BaseResolverAdapter.this.devices.size());
                outRect.left = spacing - ((columnIndex2 * spacing) / BaseResolverAdapter.this.columnNum);
                outRect.right = ((columnIndex2 + 1) * spacing) / BaseResolverAdapter.this.columnNum;
            }
        }
    }
}
