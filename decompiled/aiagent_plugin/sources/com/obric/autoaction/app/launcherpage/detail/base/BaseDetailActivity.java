package com.obric.autoaction.app.launcherpage.detail.base;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.detail.base.fragment.BaseDetailFragmentV2;
import com.obric.autoaction.app.launcherpage.detail.shortcut.ShortCutCreateActivity;
import com.obric.autoaction.app.launcherpage.detail.shortcut.data.DetailParams;
import com.obric.autoaction.app.launcherpage.utils.p;
import com.obric.autoaction.common.base.BaseActivity;
import com.obric.autogui.common.api.presentation.AssistRemoteCardUIParams;
import com.obric.eventkit.task.model.EventTask;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: compiled from: BaseDetailActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseDetailActivity extends BaseActivity implements com.obric.autoaction.app.launcherpage.b.a {
    public abstract Fragment createFragment();

    public BaseDetailActivity() {
    }

    @Override // com.obric.autoaction.common.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r17) {
        super.onCreate(r17);
        setContentView(ZeusTransformUtils.mapRes(R.layout.autoaction_base_detail_activity_layout, "layout", "autoaction_base_detail_activity_layout"));
        BaseActivity.Companion.a((FragmentActivity) ZeusTransformUtils.preCheckCast(this, FragmentActivity.class, "com.obric.aiagent.plugin"), false);
        AssistRemoteCardUIParams r5 = null;
        p.a((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.aiagent.plugin"), false, 1, null);
        if (getSupportFragmentManager().c(ZeusTransformUtils.mapRes(R.id.fragment_container, DbHelper.COL_ID, "fragment_container")) != null) goto L9;
        Fragment r1 = createFragment();
        Bundle r2 = new Bundle();
        String r8 = getIntent().getStringExtra("key_task_id");
        String r9 = getIntent().getStringExtra(ShortCutCreateActivity.KEY_ENTER_FROM);
        EventTask r10 = (EventTask) ZeusTransformUtils.preCheckCast(getIntent().getParcelableExtra("key_event_task"), EventTask.class, "com.obric.aiagent.plugin");
        Serializable r7 = getIntent().getSerializableExtra("key_doubao_card_params");
        if (ZeusTransformUtils.instanceOf(r7, AssistRemoteCardUIParams.class) == false) goto L7;
        r5 = (AssistRemoteCardUIParams) ZeusTransformUtils.preCheckCast(r7, AssistRemoteCardUIParams.class, "com.obric.aiagent.plugin");
    L7:
        r2.putParcelable("key_ui_model", (Parcelable) ZeusTransformUtils.preCheckCast(new DetailParams(r8, r9, r10, r5, false, false, 32, null), Parcelable.class, "com.obric.aiagent.plugin"));
        r1.setArguments(r2);
        getSupportFragmentManager().a().b(ZeusTransformUtils.mapRes(R.id.fragment_container, DbHelper.COL_ID, "fragment_container"), r1).b();
        return;
    }

    @Override // com.obric.autoaction.app.launcherpage.b.a
    public OFloatingTitleBar getFloatingTransitionSourceTitleBar() {
        Fragment r3 = getSupportFragmentManager().c(ZeusTransformUtils.mapRes(R.id.fragment_container, DbHelper.COL_ID, "fragment_container"));
        if (ZeusTransformUtils.instanceOf(r3, BaseDetailFragmentV2.class) == false) goto L5;
        BaseDetailFragmentV2 r4 = (BaseDetailFragmentV2) ZeusTransformUtils.preCheckCast(r3, BaseDetailFragmentV2.class, "com.obric.aiagent.plugin");
    L6:
        if (r4 != null) goto L8;
        return null;
    L8:
        return r4.getFloatingTransitionSourceTitleBar();
    L5:
        r4 = null;
        goto L6
    }
}
