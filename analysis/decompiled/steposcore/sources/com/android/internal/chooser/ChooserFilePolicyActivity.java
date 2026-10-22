package com.android.internal.chooser;

import android.R;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.android.internal.chooser.utils.ChooserAnimUtils;
import com.android.internal.chooser.utils.LogUtils;
import com.android.internal.chooser.utils.Utils;
import com.android.internal.chooser.widget.LitePopup;
import com.android.internal.chooser.widget.NestedScrollingLayout;
import com.android.internal.chooser.widget.Switch;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class ChooserFilePolicyActivity extends Activity {
    private ListAdapter mAdapter;
    private ImageView mBackIcon;
    private Context mContext;
    private List<Map<String, Object>> mListItems;
    private ListView mListView;
    private NestedScrollingLayout mNestedScrollingLayout;
    private ArrayList<Uri> mUris = new ArrayList<>();
    private List<Uri> mRedactedUris = new CopyOnWriteArrayList();
    private int mFilePolicyType = 0;
    private boolean mLocationErased = false;
    private boolean mShootingErased = false;
    private int[] mTitles = {17042495, 17042498};
    private final int[] infos = {17042497, 17042500};
    private ColorDrawable mDimBackground = new ColorDrawable(0);
    private float mDimAmount = 0.0f;
    private Handler mHandler = new Handler();
    private Runnable finishRunnable = new Runnable() { // from class: com.android.internal.chooser.ChooserFilePolicyActivity$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.lambda$new$0();
        }
    };
    private final LitePopup.OnDismissedListener mDismissedListener = new LitePopup.OnDismissedListener() { // from class: com.android.internal.chooser.ChooserFilePolicyActivity.3
        @Override // com.android.internal.chooser.widget.LitePopup.OnDismissedListener
        public void onDismissed(boolean needExitAnim) {
            ChooserFilePolicyActivity.this.finishAfterAnimator(needExitAnim);
        }

        @Override // com.android.internal.chooser.widget.LitePopup.OnDismissedListener
        public void onDragTriggered() {
        }

        @Override // com.android.internal.chooser.widget.LitePopup.OnDismissedListener
        public void onDismissProgress(float progress) {
            ChooserFilePolicyActivity.this.mDimAmount = (1.0f - progress) * 0.1f;
            ChooserFilePolicyActivity.this.mDimBackground = ChooserAnimUtils.updateDimBackground(ChooserFilePolicyActivity.this.mDimBackground, ChooserFilePolicyActivity.this.mDimAmount);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        super.finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(17367443);
        this.mContext = this;
        this.mUris = (ArrayList) getIntent().getSerializableExtra("file_policy_uri");
        this.mFilePolicyType = Utils.getChooserFilePolicyStatus(this.mContext);
        if (this.mFilePolicyType == 4) {
            this.mShootingErased = true;
            this.mLocationErased = true;
        } else if (this.mFilePolicyType == 2) {
            this.mLocationErased = true;
        } else if (this.mFilePolicyType == 3) {
            this.mShootingErased = true;
        }
        ChooserAnimUtils.transparentNavigationBar(getWindow());
        this.mListView = (ListView) findViewById(16909940);
        this.mListItems = getListItems();
        this.mNestedScrollingLayout = (NestedScrollingLayout) findViewById(R.id.conversation_face_pile_bottom);
        this.mNestedScrollingLayout.setOnDismissedListener(this.mDismissedListener);
        this.mNestedScrollingLayout.setStyle(2);
        this.mNestedScrollingLayout.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.android.internal.chooser.ChooserFilePolicyActivity.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                ChooserFilePolicyActivity.this.mNestedScrollingLayout.getViewTreeObserver().removeOnPreDrawListener(this);
                ChooserAnimUtils.startEnterAnimation(ChooserFilePolicyActivity.this.getWindow(), ChooserFilePolicyActivity.this.mNestedScrollingLayout, ChooserFilePolicyActivity.this.mDimBackground, ChooserFilePolicyActivity.this.mDimAmount);
                return true;
            }
        });
        this.mBackIcon = (ImageView) findViewById(16909939);
        this.mBackIcon.setOnClickListener(new View.OnClickListener() { // from class: com.android.internal.chooser.ChooserFilePolicyActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChooserFilePolicyActivity.this.finishAfterAnimator(true);
            }
        });
        this.mAdapter = new SwitchAdapter(this, this.mListItems);
        this.mListView.setAdapter(this.mAdapter);
        this.mListView.setDivider(null);
    }

    private List<Map<String, Object>> getListItems() {
        List<Map<String, Object>> listItems = new ArrayList<>();
        for (int i = 0; i < this.mTitles.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("titleName", getResources().getString(this.mTitles[i]));
            map.put("info", getResources().getString(this.infos[i]));
            listItems.add(map);
        }
        return listItems;
    }

    private class SwitchAdapter extends BaseAdapter {
        boolean isConvertViewClicked = false;
        private Context mContext;
        private LayoutInflater mInflator;
        private List<Map<String, Object>> mListItems;

        public SwitchAdapter(Context context, List<Map<String, Object>> listItems) {
            this.mContext = context;
            this.mInflator = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
            this.mListItems = listItems;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mListItems.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int position) {
            return this.mListItems.get(position);
        }

        @Override // android.widget.Adapter
        public long getItemId(int position) {
            return position;
        }

        @Override // android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = this.mInflator.inflate(17367491, (ViewGroup) null);
                viewHolder = new ViewHolder();
                viewHolder.titleName = (TextView) convertView.findViewById(16909991);
                viewHolder.info = (TextView) convertView.findViewById(16909989);
                viewHolder.commonSwitch = (Switch) convertView.findViewById(16909990);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            if ((ChooserFilePolicyActivity.this.mLocationErased && ChooserFilePolicyActivity.this.mShootingErased) || ((ChooserFilePolicyActivity.this.mLocationErased && position == 0) || (ChooserFilePolicyActivity.this.mShootingErased && position == 1))) {
                viewHolder.commonSwitch.setChecked(true);
            }
            setClickListener(convertView, viewHolder.commonSwitch, position);
            String name = (String) this.mListItems.get(position).get("titleName");
            String info = (String) this.mListItems.get(position).get("info");
            viewHolder.titleName.setText(name);
            if (info == null || info.contentEquals("")) {
                viewHolder.info.setVisibility(8);
            } else {
                viewHolder.info.setVisibility(0);
                viewHolder.info.setText(info);
            }
            if (position == 0) {
                convertView.setBackground(this.mContext.getDrawable(17304674));
                convertView.setPadding(convertView.getPaddingStart(), Utils.dp2px(this.mContext, 8.0f), convertView.getPaddingEnd(), convertView.getPaddingBottom());
            } else if (position == this.mListItems.size() - 1) {
                convertView.setBackground(this.mContext.getDrawable(17304673));
                convertView.setPadding(convertView.getPaddingStart(), convertView.getPaddingEnd(), convertView.getPaddingEnd(), Utils.dp2px(this.mContext, 8.0f));
            }
            return convertView;
        }

        private void setClickListener(View convertView, final Switch switchView, final int position) {
            convertView.setOnClickListener(new View.OnClickListener() { // from class: com.android.internal.chooser.ChooserFilePolicyActivity.SwitchAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    SwitchAdapter.this.isConvertViewClicked = true;
                    Switch switchView2 = (Switch) v.findViewById(16909990);
                    switchView2.toggle();
                    ChooserFilePolicyActivity.this.handleSwitchClick(switchView2, position);
                    SwitchAdapter.this.isConvertViewClicked = false;
                }
            });
            switchView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.android.internal.chooser.ChooserFilePolicyActivity.SwitchAdapter.2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (!SwitchAdapter.this.isConvertViewClicked) {
                        ChooserFilePolicyActivity.this.handleSwitchClick(switchView, position);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSwitchClick(Switch switchView, int position) {
        if (position == 0) {
            this.mLocationErased = switchView.isChecked();
        } else if (position == 1) {
            this.mShootingErased = switchView.isChecked();
        }
    }

    private class ViewHolder {
        Switch commonSwitch;
        TextView info;
        TextView titleName;

        private ViewHolder(ChooserFilePolicyActivity chooserFilePolicyActivity) {
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void finishAfterAnimator(boolean needExitAnim) {
        this.mFilePolicyType = Utils.getFilePolicyStatus(this.mLocationErased, this.mShootingErased);
        Utils.setChooserFilePolicyStatus(this.mContext, this.mFilePolicyType);
        LogUtils.d("finishAfterAnimator " + this.mFilePolicyType);
        if (needExitAnim) {
            ChooserAnimUtils.startExitAnimation(getWindow(), this.mNestedScrollingLayout, this.mDimBackground, this.mDimAmount, this.finishRunnable);
            return;
        }
        ObjectAnimator animator = ObjectAnimator.ofFloat(this.mNestedScrollingLayout, "alpha", 1.0f, 0.0f);
        animator.setDuration(50L);
        animator.start();
        this.mHandler.postDelayed(this.finishRunnable, 100L);
    }
}
