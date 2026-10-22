package awb;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.platform.comapi.map.MapController;
import com.larus.platform.api.creation.TplType;
import com.suite.lark.emm.impl.SCClipboardProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a implements ActionMode.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f16598a;

    @Override // android.view.ActionMode.Callback
    public final boolean onActionItemClicked(ActionMode r100, MenuItem r101) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onCreateActionMode(ActionMode r100, Menu r101) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        Intrinsics.checkNotNullParameter(r101, TplType.MENU);
        return true;
    }

    public a(c r100) {
        this.f16598a = r100;
    }

    @Override // android.view.ActionMode.Callback
    public final void onDestroyActionMode(ActionMode r100) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        c r101 = this.f16598a;
        r101.f16602c.removeCallbacks(r101.f16605f);
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onPrepareActionMode(ActionMode r100, Menu r101) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        Intrinsics.checkNotNullParameter(r101, TplType.MENU);
        c r102 = this.f16598a;
        r102.f16602c.removeCallbacks(r102.f16605f);
        c r103 = this.f16598a;
        r103.f16602c.postDelayed(r103.f16605f, 500);
        SCClipboardProvider.a().S0(r101);
        return true;
    }
}
