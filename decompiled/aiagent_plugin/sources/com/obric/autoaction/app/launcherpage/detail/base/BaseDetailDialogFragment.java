package com.obric.autoaction.app.launcherpage.detail.base;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.detail.shortcut.data.DetailParams;
import com.obric.eventkit.task.model.EventTask;
import com.obric.oui.sheet.v2.OSheet;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.io.Serializable;

/* JADX INFO: compiled from: BaseDetailDialogFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class BaseDetailDialogFragment extends BaseOSheetDialogFragment<EventTask> {
    private static final String ARG_FRAGMENT_CLASS = "fragment_class";
    private static final String ARG_PAGE_NAME = "page_name";
    public static final a Companion = null;
    private static final String TAG = "BaseDetailDialogFragment";
    private Fragment fragment;

    /* JADX INFO: compiled from: BaseDetailDialogFragment.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final BaseDetailDialogFragment a(Class<? extends Fragment> r4, DetailParams r5, String r6) {
            o.e(r4, "fragmentClass");
            o.e(r5, "params");
            BaseDetailDialogFragment r3 = new BaseDetailDialogFragment();
            Bundle r0 = new Bundle();
            r0.putSerializable(BaseDetailDialogFragment.ARG_FRAGMENT_CLASS, (Serializable) ZeusTransformUtils.preCheckCast(r4, Serializable.class, "com.obric.aiagent.plugin"));
            r0.putParcelable("key_ui_model", (Parcelable) ZeusTransformUtils.preCheckCast(r5, Parcelable.class, "com.obric.aiagent.plugin"));
            r0.putString(BaseDetailDialogFragment.ARG_PAGE_NAME, r6);
            r3.setArguments(r0);
            return r3;
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ x lambda$ArgYCW06GU9AVB_gp5Js1PpqRBc(BaseDetailDialogFragment r0, com.obric.autoaction.common.base.a r1) {
        return configExtension$lambda$1(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$JILY9KelUsg-oRjU0bs_8eYQ0AU, reason: not valid java name */
    public static /* synthetic */ x m465lambda$JILY9KelUsgoRjU0bs_8eYQ0AU(BaseDetailDialogFragment r0, EventTask r1) {
        return onCreate$lambda$4$lambda$3(r0, r1);
    }

    public BaseDetailDialogFragment() {
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.BaseOSheetDialogFragment
    public d.h.a.b<com.obric.autoaction.common.base.a, x> configExtension() {
        return new $$Lambda$BaseDetailDialogFragment$ArgYCW06GU9AVB_gp5Js1PpqRBc(this);
    }

    private static final x configExtension$lambda$1(BaseDetailDialogFragment r4, com.obric.autoaction.common.base.a r5) {
        o.e(r5, "<this>");
        Bundle r6 = r4.getArguments();
        if (r6 == null) goto L8;
        String r7 = r6.getString(ARG_PAGE_NAME);
        if (r7 == null) goto L8;
        r5.a((com.obric.autoaction.common.base.b) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.common.ext.b(r7, false, 2, null), com.obric.autoaction.common.base.b.class, "com.obric.aiagent.plugin"));
    L8:
        return x.f38692a;
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.BaseOSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r8) {
        super.onCreate(r8);
        if (r8 == null) goto L5;
        return;
    L5:
        Bundle r9 = getArguments();
        g r0 = null;
        if (r9 == null) goto L8;
        Serializable r10 = r9.getSerializable(ARG_FRAGMENT_CLASS);
    L10:
        if (ZeusTransformUtils.instanceOf(r10, Class.class) == false) goto L12;
        Class r11 = (Class) ZeusTransformUtils.preCheckCast(r10, Class.class, "com.obric.aiagent.plugin");
    L13:
        Bundle r1 = getArguments();
        if (r1 == null) goto L16;
        DetailParams r2 = (DetailParams) ZeusTransformUtils.preCheckCast(r1.getParcelable("key_ui_model"), DetailParams.class, "com.obric.aiagent.plugin");
    L17:
        if (r11 == null) goto L27;
        if (r2 == null) goto L27;
        Object r12 = r11.getConstructor(new Class[0]).newInstance(new Object[0]);
        Fragment r4 = (Fragment) ZeusTransformUtils.preCheckCast(r12, Fragment.class, "com.obric.aiagent.plugin");
        Bundle r5 = new Bundle();
        r5.putParcelable("key_ui_model", (Parcelable) ZeusTransformUtils.preCheckCast(r2, Parcelable.class, "com.obric.aiagent.plugin"));
        r4.setArguments(r5);
        if (ZeusTransformUtils.instanceOf(r4, g.class) == false) goto L23;
        r0 = (g) ZeusTransformUtils.preCheckCast(r4, g.class, "com.obric.aiagent.plugin");
    L23:
        if (r0 == null) goto L25;
        r0.setOnResult(new $$Lambda$BaseDetailDialogFragment$JILY9KelUsgoRjU0bs_8eYQ0AU(this));
    L25:
        this.fragment = (Fragment) ZeusTransformUtils.preCheckCast(r12, Fragment.class, "com.obric.aiagent.plugin");
        return;
    L27:
        deliverResultAndDismiss(null);
        ILogDepend.Companion.e(TAG, "create dialog fail, fragmentClass: " + r11 + ", params:" + r2);
        return;
    L16:
        r2 = null;
        goto L17
    L12:
        r11 = null;
        goto L13
    L8:
        r10 = null;
        goto L10
    }

    private static final x onCreate$lambda$4$lambda$3(BaseDetailDialogFragment r0, EventTask r1) {
        r0.deliverResultAndDismiss(r1);
        return x.f38692a;
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.BaseOSheetDialogFragment
    public void configureSheet(OSheet r6, Bundle r7) {
        o.e(r6, "sheet");
        FrameLayout r0 = new FrameLayout((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        r0.setId(ZeusTransformUtils.mapRes(R.id.fragment_container, DbHelper.COL_ID, "fragment_container"));
        r6.setBodyView((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"));
        if (r7 != null) goto L8;
        Fragment r8 = this.fragment;
        if (r8 == null) goto L9;
        getChildFragmentManager().a().b(r0.getId(), r8).d();
        return;
    L9:
        return;
    }
}
