package com.bytedanceos.common.ui;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.model.Topic;
import com.bytedanceos.common.ui.fragment.GameSubListFragment;
import com.bytedanceos.common.ui.fragment.StateView;
import com.bytedanceos.common.utils.u;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: loaded from: classes2.dex */
public class TopicCompatActivity extends StatusBarActivity implements Observer, View.OnClickListener {
    private FragmentManager mFragmentManager;
    private boolean mIsToDestroy;
    private ViewGroup mStateView;
    private TextView mToolbarTitle;
    private Topic mTopic;

    public TopicCompatActivity() {
        this.mIsToDestroy = false;
    }

    private void hideEmptyView() {
        this.mStateView.setVisibility(8);
    }

    private void initData() {
        if (getIntent() == null) goto L15;
        Serializable r10 = getIntent().getSerializableExtra("topic_page");     // Catch: Exception -> L10
        if (r10 != null) goto L7;
        return;
    L7:
        if ((r10 instanceof Topic) == false) goto L17;
        this.mTopic = (Topic) r10;     // Catch: Exception -> L10
        return;
    L17:
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    private void initListener() {
    }

    private void initView() {
        setContentView(R$layout.topic_compat_activity);
        this.mStateView = StateView.getStateView((ViewGroup) findViewById(R$id.content));
        Topic r10 = this.mTopic;
        if (r10 != null) goto L5;
    L11:
        showEmptyView();
        return;
    L5:
        if (r10.isAvaliable() == false) goto L11;
        this.mFragmentManager = getSupportFragmentManager();
        if (showFragmentByTopicId() == false) goto L10;
        hideEmptyView();
        return;
    L10:
        showEmptyView();
    }

    private boolean isActivityAlive() {
        if (isFinishing() == false) goto L5;
    L9:
        return false;
    L5:
        if (this.mIsToDestroy == true) goto L9;
        if (isDestroyed() == true) goto L9;
        return true;
    }

    private void showEmptyView() {
        StateView.showEmptyView(this.mStateView, getString(R$string.topic_empty_msg), "", new int[]{R$drawable.topics_empty});
    }

    private void showFragment(Fragment r10) {
        FragmentTransaction r11 = this.mFragmentManager.o();
        r11.u(R$id.content, r10);
        r11.k();
    }

    private boolean showFragmentByTopicId() {
        String r10 = this.mTopic.getTopicId();
        r10.hashCode();
        if (r10.equals("6") == true) goto L6;
        return false;
    L6:
        showFragment(GameSubListFragment.newInstance(this.mTopic.getTabSource()));
        return true;
    }

    @Override // com.bytedanceos.common.ui.BasicActivity
    public String getSourcePageName() {
        return getResources().getString(R$string.game_subcribe);
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity
    public View initHeaderView() {
        OFloatingTitleBar r10 = (OFloatingTitleBar) findViewById(R$id.toolbar);
        Topic r11 = this.mTopic;
        if (r11 == null) goto L5;
        String r12 = r11.getTitle();
    L6:
        this.mToolbarTitle = u.f(r10, r12);
        u.a(r10, this);
        u.c(r10, this);
        return r10;
    L5:
        r12 = "";
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        int r11 = r10.getId();
        if (r11 != R$id.toolbar_search) goto L6;
        com.bytedanceos.common.toolbox.e.n1(this, null, 0, "page_app_detail", 2);
        return;
    L6:
        if (r11 != R$id.left_action_back) goto L10;
        onBackPressed();
        return;
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity, com.bytedanceos.common.ui.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        initData();
        initView();
        initListener();
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity, com.bytedanceos.common.ui.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mIsToDestroy = true;
    }

    @Override // java.util.Observer
    public void update(Observable r10, Object r11) {
        isActivityAlive();
    }
}
