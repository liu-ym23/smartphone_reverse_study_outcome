package com.bytedanceos.common.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OCTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseActivity extends StatusBarActivity implements View.OnClickListener {
    protected OButton mCancelBtn;
    private RelativeLayout mContentView;
    protected OCTitleBar mTitleBar;

    public BaseActivity() {
    }

    private void initView() {
        OCTitleBar r10 = (OCTitleBar) findViewById(R$id.main_header);
        this.mTitleBar = r10;
        OButton r11 = r10.d(this, r10.getMRightContainer());
        this.mCancelBtn = r11;
        r11.setId(R$id.oui_id_cancel);
        this.mCancelBtn.setOnClickListener(this);
        this.mContentView = (RelativeLayout) findViewById(R$id.base_content);
    }

    public abstract void addContentView(RelativeLayout r10);

    @Override // com.bytedanceos.common.ui.StatusBarActivity
    public View initHeaderView() {
        return findViewById(R$id.main_header);
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity, com.bytedanceos.common.ui.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        setContentView(R$layout.base_activity);
        initView();
        updateHeaderView();
        addContentView(this.mContentView);
    }

    public abstract void updateHeaderView();
}
