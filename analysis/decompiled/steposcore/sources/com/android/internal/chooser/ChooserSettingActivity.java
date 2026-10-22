package com.android.internal.chooser;

import android.R;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.android.internal.chooser.adapter.SettingCollapseAdapter;
import com.android.internal.chooser.adapter.SettingFavoriteAdapter;
import com.android.internal.chooser.bean.DisplayResolveInfo;
import com.android.internal.chooser.chooser.ChooserItemComparator;
import com.android.internal.chooser.db.ChooserRepository;
import com.android.internal.chooser.utils.ChooserAnimUtils;
import com.android.internal.chooser.utils.LogUtils;
import com.android.internal.chooser.widget.ChooserListItemAnimator;
import com.android.internal.chooser.widget.LitePopup;
import com.android.internal.chooser.widget.NestedScrollingLayout;
import com.android.internal.chooser.widget.RecyclerViewItemAnimator;
import com.android.internal.chooser.widget.Switch;
import com.android.internal.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import stepos.window.WindowModeUtils;

/* loaded from: classes.dex */
public class ChooserSettingActivity extends Activity {
    private static final String KEY_COLLAPSES = "KEY_COLLAPSES";
    private static final String KEY_FAVORITES = "KEY_FAVORITES";
    private ImageView mBackIcon;
    private ChooserRepository mChooserRepository;
    private SettingCollapseAdapter mCollapseAdapter;
    private RecyclerView mCollapseView;
    private SettingFavoriteAdapter mFavoriteAdapter;
    private RecyclerView mFavoriteView;
    private ViewGroup mMoreContainer;
    private NestedScrollingLayout mNestedScrollingLayout;
    private PackageManager mPackageManager;
    private LinearLayout mQuickLookContainer;
    private Switch mQuickLookSwitch;
    private List<DisplayResolveInfo> mFavorites = new ArrayList();
    private List<DisplayResolveInfo> mCollapses = new ArrayList();
    private ColorDrawable mDimBackground = new ColorDrawable(0);
    private float mDimAmount = 0.0f;
    private Handler mHandler = new Handler();
    private Runnable finishRunnable = new Runnable() { // from class: com.android.internal.chooser.ChooserSettingActivity$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.lambda$new$0();
        }
    };
    private final LitePopup.OnDismissedListener mDismissedListener = new LitePopup.OnDismissedListener() { // from class: com.android.internal.chooser.ChooserSettingActivity.6
        @Override // com.android.internal.chooser.widget.LitePopup.OnDismissedListener
        public void onDismissed(boolean needExitAnim) {
            ChooserSettingActivity.this.finishAfterAnimator(needExitAnim);
        }

        @Override // com.android.internal.chooser.widget.LitePopup.OnDismissedListener
        public void onDragTriggered() {
        }

        @Override // com.android.internal.chooser.widget.LitePopup.OnDismissedListener
        public void onDismissProgress(float progress) {
            ChooserSettingActivity.this.mDimAmount = (1.0f - progress) * 0.1f;
            ChooserSettingActivity.this.mDimBackground = ChooserAnimUtils.updateDimBackground(ChooserSettingActivity.this.mDimBackground, ChooserSettingActivity.this.mDimAmount);
            if (progress >= 0.8d) {
                ChooserSettingActivity.this.finishAfterAnimator(true);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        super.finish();
    }

    public static void openChooserSettingActivity(Context context, List<DisplayResolveInfo> favorites, List<DisplayResolveInfo> collapses) {
        Intent intent = new Intent("stepos.intent.action.CHOOSER_SETTING");
        ArrayList<ResolveInfo> favoriteInfo = new ArrayList<>(favorites.size());
        for (DisplayResolveInfo info : favorites) {
            favoriteInfo.add(info.resolveInfo);
        }
        intent.putParcelableArrayListExtra(KEY_FAVORITES, favoriteInfo);
        ArrayList<ResolveInfo> collapseInfo = new ArrayList<>(collapses.size());
        for (DisplayResolveInfo info2 : collapses) {
            collapseInfo.add(info2.resolveInfo);
        }
        intent.putParcelableArrayListExtra(KEY_COLLAPSES, collapseInfo);
        context.startActivity(intent);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 1024 | 256);
        ChooserAnimUtils.transparentNavigationBar(getWindow());
        this.mChooserRepository = ChooserRepository.getInstance(this);
        this.mPackageManager = getPackageManager();
        ArrayList<Parcelable> favoritesList = getIntent().getParcelableArrayListExtra(KEY_FAVORITES);
        if (favoritesList != null) {
            Iterator<Parcelable> it = favoritesList.iterator();
            while (it.hasNext()) {
                Parcelable info = it.next();
                this.mFavorites.add(createDisplayResolveInfo((ResolveInfo) info));
            }
        } else {
            LogUtils.d("Favorites list is null");
        }
        ArrayList<Parcelable> collapsesList = getIntent().getParcelableArrayListExtra(KEY_COLLAPSES);
        if (collapsesList != null) {
            Iterator<Parcelable> it2 = collapsesList.iterator();
            while (it2.hasNext()) {
                Parcelable info2 = it2.next();
                this.mCollapses.add(createDisplayResolveInfo((ResolveInfo) info2));
            }
        } else {
            LogUtils.d("Collapses list is null");
        }
        setContentView(17367451);
        initView();
        this.mNestedScrollingLayout.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.android.internal.chooser.ChooserSettingActivity.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                ChooserSettingActivity.this.mNestedScrollingLayout.getViewTreeObserver().removeOnPreDrawListener(this);
                ChooserAnimUtils.startEnterAnimation(ChooserSettingActivity.this.getWindow(), ChooserSettingActivity.this.mNestedScrollingLayout, ChooserSettingActivity.this.mDimBackground, ChooserSettingActivity.this.mDimAmount);
                return true;
            }
        });
    }

    private DisplayResolveInfo createDisplayResolveInfo(ResolveInfo resolveInfo) {
        DisplayResolveInfo displayResolveInfo = new DisplayResolveInfo(resolveInfo, (Intent) null);
        displayResolveInfo.activityLabel = resolveInfo.loadLabel(this.mPackageManager).toString().replace("\n", "");
        displayResolveInfo.appLabel = resolveInfo.activityInfo.applicationInfo.loadLabel(this.mPackageManager).toString().replace("\n", "");
        return displayResolveInfo;
    }

    private void initView() {
        this.mNestedScrollingLayout = (NestedScrollingLayout) findViewById(R.id.conversation_text);
        this.mNestedScrollingLayout.setOnDismissedListener(this.mDismissedListener);
        this.mNestedScrollingLayout.setStyle(2);
        this.mBackIcon = (ImageView) findViewById(16909948);
        this.mBackIcon.setOnClickListener(new View.OnClickListener() { // from class: com.android.internal.chooser.ChooserSettingActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChooserSettingActivity.this.finishAfterAnimator(true);
            }
        });
        this.mQuickLookSwitch = (Switch) findViewById(16909952);
        this.mQuickLookSwitch.setChecked(WindowModeUtils.isShareWithQuickLook(this));
        this.mQuickLookContainer = (LinearLayout) findViewById(16909953);
        this.mQuickLookContainer.setOnClickListener(new View.OnClickListener() { // from class: com.android.internal.chooser.ChooserSettingActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                boolean checked = !ChooserSettingActivity.this.mQuickLookSwitch.isChecked();
                ChooserSettingActivity.this.mQuickLookSwitch.setCheckedWithHapticFeedback(checked);
                WindowModeUtils.setShareWithQuickLook(ChooserSettingActivity.this, checked);
            }
        });
        this.mFavoriteView = findViewById(16909950);
        this.mFavoriteAdapter = new SettingFavoriteAdapter(this, this);
        this.mFavoriteView.setAdapter(this.mFavoriteAdapter);
        this.mFavoriteView.setItemAnimator(new RecyclerViewItemAnimator(this.mFavoriteView));
        this.mFavoriteAdapter.setData(this.mFavorites);
        this.mFavoriteAdapter.setOnItemChangedListener(new SettingFavoriteAdapter.OnItemChangedListener() { // from class: com.android.internal.chooser.ChooserSettingActivity.4
            @Override // com.android.internal.chooser.adapter.SettingFavoriteAdapter.OnItemChangedListener
            public void onItemRemoved(DisplayResolveInfo info) throws JSONException {
                ChooserSettingActivity.this.mFavorites.remove(info);
                ChooserSettingActivity.this.mCollapses.add(info);
                ChooserSettingActivity.this.mCollapses.sort(new ChooserItemComparator(ChooserSettingActivity.this));
                ChooserSettingActivity.this.mFavoriteAdapter.setData(ChooserSettingActivity.this.mFavorites);
                ChooserSettingActivity.this.mCollapseAdapter.setData(ChooserSettingActivity.this.mCollapses);
                if (ChooserSettingActivity.this.mFavorites.size() == 1) {
                    ChooserSettingActivity.this.mFavoriteAdapter.notifyItemChanged(0);
                }
                ChooserSettingActivity.this.updateRecyclerViewHeight();
                ChooserSettingActivity.this.mChooserRepository.removeFavorite(ChooserSettingActivity.this.mFavorites, info, true);
            }

            @Override // com.android.internal.chooser.adapter.SettingFavoriteAdapter.OnItemChangedListener
            public void onItemMoved(DisplayResolveInfo movedItem, DisplayResolveInfo beforeItem, int fromPosition, int toPosition) throws JSONException {
                DisplayResolveInfo resolveInfo = (DisplayResolveInfo) ChooserSettingActivity.this.mFavorites.remove(fromPosition);
                ChooserSettingActivity.this.mFavorites.add(toPosition, resolveInfo);
                ChooserSettingActivity.this.mChooserRepository.moveFavorite(ChooserSettingActivity.this.mFavorites, movedItem, beforeItem, true);
            }
        });
        this.mCollapseView = findViewById(16909949);
        this.mCollapseAdapter = new SettingCollapseAdapter(this);
        this.mCollapseView.setAdapter(this.mCollapseAdapter);
        this.mCollapseView.setItemAnimator(new ChooserListItemAnimator());
        this.mCollapseAdapter.setData(this.mCollapses);
        this.mCollapseAdapter.setOnItemChangedListener(new SettingCollapseAdapter.OnItemChangedListener() { // from class: com.android.internal.chooser.ChooserSettingActivity.5
            @Override // com.android.internal.chooser.adapter.SettingCollapseAdapter.OnItemChangedListener
            public void onItemRemoved(DisplayResolveInfo info) throws JSONException {
                ChooserSettingActivity.this.mCollapses.remove(info);
                ChooserSettingActivity.this.mFavorites.add(info);
                ChooserSettingActivity.this.mFavoriteAdapter.setData(ChooserSettingActivity.this.mFavorites);
                ChooserSettingActivity.this.mCollapseAdapter.setData(ChooserSettingActivity.this.mCollapses);
                if (ChooserSettingActivity.this.mFavorites.size() == 2) {
                    ChooserSettingActivity.this.mFavoriteAdapter.notifyItemChanged(0, 1);
                }
                ChooserSettingActivity.this.updateRecyclerViewHeight();
                ChooserSettingActivity.this.mChooserRepository.updateFavorites(ChooserSettingActivity.this.mFavorites, true);
            }
        });
        this.mMoreContainer = (ViewGroup) findViewById(16909951);
        updateRecyclerViewHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRecyclerViewHeight() {
        this.mMoreContainer.setVisibility(this.mCollapseAdapter.getItemCount() > 0 ? 0 : 4);
        this.mCollapseView.setVisibility(this.mCollapseAdapter.getItemCount() <= 0 ? 4 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishAfterAnimator(boolean needExitAnim) {
        if (needExitAnim) {
            ChooserAnimUtils.startExitAnimation(getWindow(), this.mNestedScrollingLayout, this.mDimBackground, this.mDimAmount, this.finishRunnable);
            return;
        }
        ObjectAnimator animator = ObjectAnimator.ofFloat(this.mNestedScrollingLayout, "alpha", 1.0f, 0.0f);
        animator.setDuration(50L);
        animator.start();
        this.mHandler.postDelayed(this.finishRunnable, 100L);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacks(this.finishRunnable);
    }

    @Override // android.app.Activity
    public void finish() {
        finishAfterAnimator(true);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) throws Resources.NotFoundException {
        super.onConfigurationChanged(newConfig);
        this.mFavoriteAdapter.updateLayoutManager(this.mFavoriteView);
        updateScrollingLayoutPadding();
    }

    private void updateScrollingLayoutPadding() throws Resources.NotFoundException {
        if (this.mNestedScrollingLayout == null) {
            return;
        }
        int padding = getResources().getDimensionPixelOffset(17106491);
        boolean isInMultiWindow = isInMultiWindowMode();
        LogUtils.d("updateScrollingLayoutPadding and multiWindow:" + isInMultiWindow);
        if (isInMultiWindow) {
            padding = 0;
        }
        this.mNestedScrollingLayout.setPadding(padding, this.mNestedScrollingLayout.getPaddingTop(), padding, this.mNestedScrollingLayout.getPaddingBottom());
    }
}
