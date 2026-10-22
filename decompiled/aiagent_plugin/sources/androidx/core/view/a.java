package androidx.core.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ActionProvider.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    private static final String TAG = "ActionProvider(support)";
    private final Context mContext;
    private InterfaceC0035a mSubUiVisibilityListener;
    private b mVisibilityListener;

    /* JADX INFO: renamed from: androidx.core.view.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActionProvider.java */
    public interface InterfaceC0035a {
        void c(boolean r1);
    }

    /* JADX INFO: compiled from: ActionProvider.java */
    public interface b {
        void a(boolean r1);
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.w(r0, r1);
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isVisible() {
        return true;
    }

    public abstract View onCreateActionView();

    public boolean onPerformDefaultAction() {
        return false;
    }

    public void onPrepareSubMenu(SubMenu r2) {
        SubMenu r1 = (SubMenu) ZeusTransformUtils.wrapperContextForParams(r2, SubMenu.class, "com.obric.aiagent.plugin");
    }

    public boolean overridesItemVisibility() {
        return false;
    }

    public a(Context r3) {
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    }

    public Context getContext() {
        return this.mContext;
    }

    public View onCreateActionView(MenuItem r3) {
        MenuItem r4 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r3, MenuItem.class, "com.obric.aiagent.plugin");
        return onCreateActionView();
    }

    public void refreshVisibility() {
        if (this.mVisibilityListener != null) goto L5;
        return;
    L5:
        if (overridesItemVisibility() == false) goto L9;
        this.mVisibilityListener.a(isVisible());
        return;
    }

    public void subUiVisibilityChanged(boolean r1) {
        InterfaceC0035a r0 = this.mSubUiVisibilityListener;
        if (r0 == null) goto L6;
        r0.c(r1);
        return;
    }

    public void setSubUiVisibilityListener(InterfaceC0035a r3) {
        this.mSubUiVisibilityListener = (InterfaceC0035a) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0035a.class, "com.obric.aiagent.plugin");
    }

    public void setVisibilityListener(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        if (this.mVisibilityListener == null) goto L6;
        if (r4 == null) goto L6;
        INVOKESTATIC_androidx_core_view_ActionProvider_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
    L6:
        this.mVisibilityListener = r4;
    }

    public void reset() {
        this.mVisibilityListener = null;
        this.mSubUiVisibilityListener = null;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_androidx_core_view_ActionProvider_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }
}
