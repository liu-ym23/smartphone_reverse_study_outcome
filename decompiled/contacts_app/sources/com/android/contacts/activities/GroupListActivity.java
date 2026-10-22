package com.android.contacts.activities;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import com.android.contacts.R;
import com.android.contacts.util.AnimationUtil;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.oui.titlebar.OCTitleBar;
import java.util.ArrayList;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class GroupListActivity extends ListActivity {
    public static final String EXTAR_GROUP_LIST = "extra_group_list";
    private ArrayList<String> mGroups;

    public void com_android_contacts_activities_GroupListActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onStop() {
        com_android_contacts_activities_GroupListActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public GroupListActivity() {
        this.mGroups = new ArrayList();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle r4) {
        super.onCreate(r4);
        setContentView(R.layout.group_list_activity);
        UiUtils.setWindowColorStatusBar(this);
        ((OCTitleBar) findViewById(R.id.otitlebar)).getMLeftActionBack().setOnClickListener(new AnonymousClass1(this));
        this.mGroups = getIntent().getStringArrayListExtra(EXTAR_GROUP_LIST);
        setListAdapter(new ArrayAdapter(this, R.layout.group_list_item, R.id.text_view, this.mGroups));
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        AnimationUtil.switchActivityAnimation(this, 2);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_activities_GroupListActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(GroupListActivity r1) {
        r1.com_android_contacts_activities_GroupListActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }
}
