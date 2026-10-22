package com.bytedanceos.common.ui;

import android.text.TextUtils;
import com.bytedanceos.common.model.Category;
import com.bytedanceos.common.network.api.CommonAPIHelper;
import com.bytedanceos.common.ui.adapter.TopicListAdapter;
import com.bytedanceos.common.view.RecyclerviewCompat;
import com.obric.appstore.network.entity.template.ElementTextEntity;

/* JADX INFO: loaded from: classes2.dex */
public class RankingListActivity extends TopicActivity {
    private String mBackBtnText;
    private Category mCurrCategory;

    public RankingListActivity() {
    }

    @Override // com.bytedanceos.common.ui.TopicActivity
    public void fetchData(int r10) {
        CommonAPIHelper.x(this.mCurrCategory.getId(), this);
    }

    @Override // com.bytedanceos.common.ui.TopicActivity
    public String getBackBtnText() {
        return this.mBackBtnText;
    }

    @Override // com.bytedanceos.common.ui.TopicActivity
    public Object getExtendedInfo() {
        return this.mCurrCategory;
    }

    @Override // com.bytedanceos.common.ui.TopicActivity
    public String getTitleText() {
        Category r10 = this.mCurrCategory;
        if (r10 == null) goto L10;
        if (TextUtils.isEmpty(r10.getName()) == true) goto L10;
        return this.mCurrCategory.getName();
    L10:
        return super.getTitleText();
    }

    @Override // com.bytedanceos.common.ui.TopicActivity
    public boolean hasGroupTopicView() {
        return true;
    }

    @Override // com.bytedanceos.common.ui.TopicActivity
    public void initBaseView(boolean r10) {
        super.initBaseView(false);
    }

    @Override // com.bytedanceos.common.ui.TopicActivity
    public boolean initDataInternal() {
        String r10 = getIntent().getStringExtra(ElementTextEntity.Key.CATEGORY_ID);     // Catch: Exception -> L8
        if (TextUtils.isEmpty(r10) == true) goto L10;
        String r11 = getIntent().getStringExtra(ElementTextEntity.Key.CATEGORY_NAME);     // Catch: Exception -> L8
        this.mBackBtnText = getIntent().getStringExtra("original_back_info");     // Catch: Exception -> L8
        Category r12 = new Category();     // Catch: Exception -> L8
        this.mCurrCategory = r12;     // Catch: Exception -> L8
        r12.setId(r10);     // Catch: Exception -> L8
        this.mCurrCategory.setName(r11);     // Catch: Exception -> L8
        return true;
    L10:
        return false;
    L8:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // com.bytedanceos.common.ui.TopicActivity
    public void updateInternal() {
        RecyclerviewCompat r10 = this.mListView;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.getAdapter() == null) goto L9;
        ((TopicListAdapter) this.mListView.getAdapter()).updateDownloadStatus();
        return;
    }
}
