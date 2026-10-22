package com.bytedanceos.common.ui.widget;

import android.content.pm.PackageInfo;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.network.FetchDataCallBack;
import com.bytedanceos.common.network.api.CommonAPIHelper;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.ui.fragment.StateView;
import java.util.List;
import y8.f;

/* JADX INFO: loaded from: classes2.dex */
public class AppPermissionPresenter implements View.OnClickListener, FetchDataCallBack {
    private final String REQ_TAG;
    private final AppPermissionView mApv;
    private boolean mDestroyed;
    private final String mIconUrl;
    private final String mName;
    private final String mPkg;
    private final ViewGroup mStateView;
    private final String mVersion;

    public AppPermissionPresenter(AppPermissionView r10, String r11, String r12, String r13, String r14) {
        this.mDestroyed = false;
        this.mApv = r10;
        this.mPkg = r11;
        this.mName = r12;
        this.mVersion = r13;
        this.mIconUrl = r14;
        this.mStateView = StateView.getStateView(r10);
        this.REQ_TAG = BaseApplication.c().getPackageName() + LibrarianImpl.Constants.SEPARATOR + AppPermissionPresenter.class.getSimpleName() + "_http_req";
    }

    public void destroy() {
        f.c(this.REQ_TAG);
        this.mDestroyed = true;
    }

    public void hideStateView() {
        if (isStateViewVisible() == false) goto L6;
        this.mStateView.setVisibility(8);
        return;
    }

    public boolean isStateViewVisible() {
        ViewGroup r10 = this.mStateView;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.getVisibility() != 0) goto L7;
        return true;
    }

    public void loadPermissionsFromServer() {
        j.n("loading Permissions FromServer, pkg: " + this.mPkg);
        showLoadingView();
        CommonAPIHelper.u(this.mPkg, this, this.REQ_TAG);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        if (e.p0() == true) goto L6;
        return;
    L6:
        if (R$id.refresh_btn != r10.getId()) goto L9;
        CommonAPIHelper.u(this.mPkg, this, this.REQ_TAG);
        return;
    }

    @Override // com.bytedanceos.common.network.FetchDataCallBack
    public void onFetchDataFailed(int r10, Throwable r11, String r12, Object r13) {
        if (this.mDestroyed == false) goto L6;
        j.n("onFetchDataFailed after destroyed. Fast return");
        return;
    L6:
        j.n("getAppPermissions failed, pkg: " + this.mPkg);
        if (isStateViewVisible() == false) goto L9;
        hideStateView();
    L9:
        showRefreshView();
    }

    @Override // com.bytedanceos.common.network.FetchDataCallBack
    public void onFetchDataSuccess(int r10, int r11, String r12, Object r13, String r14) {
        if (this.mDestroyed == false) goto L6;
        j.n("onFetchDataSuccess after destroyed. Fast return");
        return;
    L6:
        j.n("loaded Permissions FromServer, pkg: " + this.mPkg);
        List r15 = c9.a.A(r12);
        if (isStateViewVisible() == false) goto L9;
        hideStateView();
    L9:
        if (r15 != null) goto L11;
        j.b("No permission resolved. pkg: " + this.mPkg);
        return;
    L11:
        PackageInfo r16 = new PackageInfo();
        r16.packageName = this.mPkg;
        int r17 = 0;
        r16.requestedPermissions = (String[]) r15.toArray(new String[0]);
        r16.requestedPermissionsFlags = new int[r15.size()];
    L13:
        if (r17 >= r15.size()) goto L15;
        r16.requestedPermissionsFlags[r17] = 1;
        r17 = r17 + 1;
        goto L13
    L15:
        this.mApv.setIcon(this.mIconUrl);
        this.mApv.setAppName(this.mName);
        this.mApv.setVersion(BaseApplication.c().getString(R$string.version_text, new Object[]{this.mVersion}));
        this.mApv.showPermissions(r16);
    }

    public void showLoadingView() {
        StateView.showLoadingView(this.mStateView);
    }

    public void showRefreshView() {
        StateView.showRefreshView(this.mStateView, this);
    }
}
