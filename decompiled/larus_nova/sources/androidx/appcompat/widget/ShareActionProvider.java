package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ActionProvider;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes2.dex */
public class ShareActionProvider extends ActionProvider {
    private static final int DEFAULT_INITIAL_ACTIVITY_COUNT = 4;
    public static final String DEFAULT_SHARE_HISTORY_FILE_NAME = "share_history.xml";
    final Context mContext;
    private int mMaxShownActivityCount;
    private ActivityChooserModel.OnChooseActivityListener mOnChooseActivityListener;
    private final ShareMenuItemOnMenuItemClickListener mOnMenuItemClickListener;
    OnShareTargetSelectedListener mOnShareTargetSelectedListener;
    String mShareHistoryFileName;

    public interface OnShareTargetSelectedListener {
        boolean onShareTargetSelected(ShareActionProvider r100, Intent r101);
    }

    public class ShareActivityChooserModelPolicy implements ActivityChooserModel.OnChooseActivityListener {
        final /* synthetic */ ShareActionProvider this$0;

        public ShareActivityChooserModelPolicy(ShareActionProvider r100) {
            this.this$0 = r100;
        }

        @Override // androidx.appcompat.widget.ActivityChooserModel.OnChooseActivityListener
        public boolean onChooseActivity(ActivityChooserModel r100, Intent r101) {
            ShareActionProvider r102 = this.this$0;
            OnShareTargetSelectedListener r103 = r102.mOnShareTargetSelectedListener;
            if (r103 == null) goto L7;
            r103.onShareTargetSelected(r102, r101);
            return false;
        L7:
            return false;
        }
    }

    public class ShareMenuItemOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ ShareActionProvider this$0;

        public ShareMenuItemOnMenuItemClickListener(ShareActionProvider r100) {
            this.this$0 = r100;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem r100) {
            ShareActionProvider r101 = this.this$0;
            Intent r102 = ActivityChooserModel.get(r101.mContext, r101.mShareHistoryFileName).chooseActivity(r100.getItemId());
            if (r102 == null) goto L12;
            String r103 = r102.getAction();
            if ("android.intent.action.SEND".equals(r103) == false) goto L7;
        L8:
            this.this$0.updateIntent(r102);
        L9:
            this.this$0.mContext.startActivity(r102);
            return true;
        L7:
            if ("android.intent.action.SEND_MULTIPLE".equals(r103) == false) goto L9;
        L12:
            return true;
        }
    }

    @Override // androidx.core.view.ActionProvider
    public boolean hasSubMenu() {
        return true;
    }

    private void setActivityChooserPolicyIfNeeded() {
        if (this.mOnShareTargetSelectedListener != null) goto L6;
        return;
    L6:
        if (this.mOnChooseActivityListener != null) goto L8;
        this.mOnChooseActivityListener = new ShareActivityChooserModelPolicy(this);
    L8:
        ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName).setOnChooseActivityListener(this.mOnChooseActivityListener);
    }

    @Override // androidx.core.view.ActionProvider
    public View onCreateActionView() {
        ActivityChooserView r100 = new ActivityChooserView(this.mContext);
        if (r100.isInEditMode() == true) goto L5;
        r100.setActivityChooserModel(ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName));
    L5:
        TypedValue r101 = new TypedValue();
        this.mContext.getTheme().resolveAttribute(R.attr.actionModeShareDrawable, r101, true);
        r100.setExpandActivityOverflowButtonDrawable(AppCompatResources.getDrawable(this.mContext, r101.resourceId));
        r100.setProvider(this);
        r100.setDefaultActionButtonContentDescription(R.string.abc_shareactionprovider_share_with_application);
        r100.setExpandActivityOverflowButtonContentDescription(R.string.abc_shareactionprovider_share_with);
        return r100;
    }

    public ShareActionProvider(Context r100) {
        super(r100);
        this.mMaxShownActivityCount = 4;
        this.mOnMenuItemClickListener = new ShareMenuItemOnMenuItemClickListener(this);
        this.mShareHistoryFileName = DEFAULT_SHARE_HISTORY_FILE_NAME;
        this.mContext = r100;
    }

    @Override // androidx.core.view.ActionProvider
    public void onPrepareSubMenu(SubMenu r100) {
        r100.clear();
        ActivityChooserModel r101 = ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName);
        PackageManager r102 = this.mContext.getPackageManager();
        int r103 = r101.getActivityCount();
        int r104 = Math.min(r103, this.mMaxShownActivityCount);
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L5;
        ResolveInfo r106 = r101.getActivity(r105);
        r100.add(0, r105, r105, r106.loadLabel(r102)).setIcon(r106.loadIcon(r102)).setOnMenuItemClickListener(this.mOnMenuItemClickListener);
        r105 = r105 + 1;
        goto L3
    L5:
        if (r104 >= r103) goto L9;
        SubMenu r107 = r100.addSubMenu(0, r104, r104, this.mContext.getString(R.string.abc_activity_chooser_view_see_all));
        int r108 = 0;
    L7:
        if (r108 >= r103) goto L12;
        ResolveInfo r109 = r101.getActivity(r108);
        r107.add(0, r108, r108, r109.loadLabel(r102)).setIcon(r109.loadIcon(r102)).setOnMenuItemClickListener(this.mOnMenuItemClickListener);
        r108 = r108 + 1;
        goto L7
    L12:
        return;
    }

    public void setOnShareTargetSelectedListener(OnShareTargetSelectedListener r100) {
        this.mOnShareTargetSelectedListener = r100;
        setActivityChooserPolicyIfNeeded();
    }

    public void setShareHistoryFileName(String r100) {
        this.mShareHistoryFileName = r100;
        setActivityChooserPolicyIfNeeded();
    }

    public void setShareIntent(Intent r100) {
        if (r100 == null) goto L8;
        String r101 = r100.getAction();
        if ("android.intent.action.SEND".equals(r101) == false) goto L6;
    L7:
        updateIntent(r100);
        goto L8
    L6:
        if ("android.intent.action.SEND_MULTIPLE".equals(r101) == true) goto L7;
    L8:
        ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName).setIntent(r100);
    }

    public void updateIntent(Intent r100) {
        r100.addFlags(134742016);
    }
}
