package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.capabilitykit.common.UiType;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class ShareActionProvider extends androidx.core.view.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Context f385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f387c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ShareMenuItemOnMenuItemClickListener f388d;

    private class ShareMenuItemOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ ShareActionProvider this$0;

        ShareMenuItemOnMenuItemClickListener(ShareActionProvider r1) {
            this.this$0 = r1;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem r4) {
            MenuItem r5 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r4, MenuItem.class, "com.obric.aiagent.plugin");
            Intent r6 = ActivityChooserModel.get(this.this$0.f385a, this.this$0.f386b).chooseActivity(r5.getItemId());
            if (r6 == null) goto L12;
            String r0 = r6.getAction();
            if ("android.intent.action.SEND".equals(r0) == false) goto L7;
        L8:
            this.this$0.a(r6);
        L9:
            ZeusTransformUtils.startActivity(this.this$0.f385a, r6, "com.obric.aiagent.plugin");
            return true;
        L7:
            if ("android.intent.action.SEND_MULTIPLE".equals(r0) == false) goto L9;
        L12:
            return true;
        }
    }

    @Override // androidx.core.view.a
    public boolean hasSubMenu() {
        return true;
    }

    @Override // androidx.core.view.a
    public View onCreateActionView() {
        ActivityChooserView r0 = new ActivityChooserView(this.f385a);
        if (r0.isInEditMode() == true) goto L5;
        r0.setActivityChooserModel(ActivityChooserModel.get(this.f385a, this.f386b));
    L5:
        TypedValue r1 = new TypedValue();
        this.f385a.getTheme().resolveAttribute(ZeusTransformUtils.mapRes(R.attr.actionModeShareDrawable, "attr", "actionModeShareDrawable"), r1, true);
        r0.setExpandActivityOverflowButtonDrawable(androidx.appcompat.a.a.a.b(this.f385a, r1.resourceId));
        r0.setProvider(this);
        r0.setDefaultActionButtonContentDescription(ZeusTransformUtils.mapRes(R.string.abc_shareactionprovider_share_with_application, WsChannelMultiProcessSharedProvider.STRING_TYPE, "abc_shareactionprovider_share_with_application"));
        r0.setExpandActivityOverflowButtonContentDescription(ZeusTransformUtils.mapRes(R.string.abc_shareactionprovider_share_with, WsChannelMultiProcessSharedProvider.STRING_TYPE, "abc_shareactionprovider_share_with"));
        return r0;
    }

    @Override // androidx.core.view.a
    public void onPrepareSubMenu(SubMenu r10) {
        SubMenu r11 = (SubMenu) ZeusTransformUtils.wrapperContextForParams(r10, SubMenu.class, "com.obric.aiagent.plugin");
        r11.clear();
        ActivityChooserModel r0 = ActivityChooserModel.get(this.f385a, this.f386b);
        PackageManager r1 = this.f385a.getPackageManager();
        int r2 = r0.getActivityCount();
        int r3 = Math.min(r2, this.f387c);
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L5;
        ResolveInfo r6 = r0.getActivity(r5);
        r11.add(0, r5, r5, r6.loadLabel(r1)).setIcon(r6.loadIcon(r1)).setOnMenuItemClickListener(this.f388d);
        r5 = r5 + 1;
        goto L3
    L5:
        if (r3 >= r2) goto L9;
        SubMenu r12 = r11.addSubMenu(0, r3, r3, this.f385a.getString(ZeusTransformUtils.mapRes(R.string.abc_activity_chooser_view_see_all, WsChannelMultiProcessSharedProvider.STRING_TYPE, "abc_activity_chooser_view_see_all")));
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L12;
        ResolveInfo r7 = r0.getActivity(r4);
        r12.add(0, r4, r4, r7.loadLabel(r1)).setIcon(r7.loadIcon(r1)).setOnMenuItemClickListener(this.f388d);
        r4 = r4 + 1;
        goto L7
    L12:
        return;
    }

    void a(Intent r2) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        r2.addFlags(134742016);
        return;
    L5:
        r2.addFlags(UiType.FLAG_WIFI_QRCODE_CARD);
    }
}
