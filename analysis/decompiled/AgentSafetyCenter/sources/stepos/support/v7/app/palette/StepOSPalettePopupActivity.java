package stepos.support.v7.app.palette;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.stepos.agentsafetycenter.R;
import f8.b;
import java.lang.invoke.VarHandle;
import java.util.Objects;
import stepos.support.v7.app.c;
import stepos.support.v7.app.u;
import stepos.support.v7.app.w;
import stepos.support.v7.widget.PopupNestedScrollingLayout;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public class StepOSPalettePopupActivity extends u {
    public StepOSPalettePopupActivity() {
        this.f12506g = Boolean.TRUE;
        this.f12507h = R.style.Theme_StepOS_AppCompat_Light_LitePopupOverlay;
    }

    @Override // stepos.support.v7.app.u, stepos.support.v7.app.j, androidx.fragment.app.j, androidx.activity.p, d3.c, android.app.Activity
    public final void onCreate(Bundle bundle) {
        PopupNestedScrollingLayout popupNestedScrollingLayout;
        super.onCreate(bundle);
        setContentView(R.layout.palette_activity_layout);
        c supportActionBar = getSupportActionBar();
        Objects.requireNonNull(supportActionBar);
        supportActionBar.j(true);
        w wVar = this.f12505f;
        if (wVar != null && (popupNestedScrollingLayout = wVar.f12512c) != null) {
            popupNestedScrollingLayout.setStyle(1);
        }
        ColorPickerView colorPickerView = (ColorPickerView) findViewById(R.id.color_pick_view);
        colorPickerView.getClass();
        int intExtra = getIntent().getIntExtra("pick_color", 0);
        if (intExtra != 0) {
            g7.c cVar = new g7.c(1);
            cVar.f4357g = colorPickerView;
            cVar.f4356f = intExtra;
            VarHandle.storeStoreFence();
            colorPickerView.post(cVar);
        }
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_palette_icon, menu);
        return true;
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            onBackPressed();
            return true;
        }
        if (itemId != R.id.palette_open_pick) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (Settings.canDrawOverlays(this)) {
            if (b.f4040h == null) {
                b.f4040h = new b(22);
            }
            b.f4040h.getClass();
            return true;
        }
        if (Settings.canDrawOverlays(this)) {
            Toast.makeText(this, "悬浮窗权限已拥有", 0).show();
            return true;
        }
        startActivity(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getPackageName())));
        return true;
    }
}
