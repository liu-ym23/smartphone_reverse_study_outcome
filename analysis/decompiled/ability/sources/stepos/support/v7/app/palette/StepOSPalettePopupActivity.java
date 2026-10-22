package stepos.support.v7.app.palette;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.stepos.ability.R;
import e3.C1417f;
import java.util.Objects;
import stepos.support.v7.app.AbstractC1955d;
import stepos.support.v7.app.D;
import stepos.support.v7.app.F;
import stepos.support.v7.widget.PopupNestedScrollingLayout;

/* loaded from: classes4.dex */
public class StepOSPalettePopupActivity extends D {
    public StepOSPalettePopupActivity() {
        this.c = Boolean.TRUE;
        this.d = R.style.Theme_StepOS_AppCompat_Light_LitePopupOverlay;
    }

    @Override // stepos.support.v7.app.D, stepos.support.v7.app.AbstractActivityC1962k, androidx.fragment.app.FragmentActivity, android.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        PopupNestedScrollingLayout popupNestedScrollingLayout;
        super.onCreate(bundle);
        setContentView(R.layout.palette_activity_layout);
        AbstractC1955d supportActionBar = getSupportActionBar();
        Objects.requireNonNull(supportActionBar);
        supportActionBar.j(true);
        F f = this.b;
        if (f != null && (popupNestedScrollingLayout = f.c) != null) {
            popupNestedScrollingLayout.setStyle(1);
        }
        final ColorPickerView colorPickerView = (ColorPickerView) findViewById(R.id.color_pick_view);
        colorPickerView.getClass();
        final int intExtra = getIntent().getIntExtra("pick_color", 0);
        if (intExtra != 0) {
            colorPickerView.post(new Runnable() { // from class: stepos.support.v7.app.palette.d
                @Override // java.lang.Runnable
                public final void run() {
                    int i = ColorPickerView.f6323q;
                    float[] fArr = new float[3];
                    final int i6 = intExtra;
                    Color.colorToHSV(i6, fArr);
                    float f7 = fArr[0];
                    ColorPickerView colorPickerView2 = colorPickerView;
                    if (f7 >= 0.0f) {
                        double d = f7;
                        colorPickerView2.d = (float) ((Math.cos(Math.toRadians(d)) * colorPickerView2.f) + colorPickerView2.b);
                        colorPickerView2.e = (float) ((Math.sin(Math.toRadians(d)) * colorPickerView2.f) + colorPickerView2.c);
                    }
                    float[] fArr2 = {0.0f, 1.0f, 1.0f};
                    Color.colorToHSV(i6, fArr2);
                    colorPickerView2.m = Color.HSVToColor(fArr2);
                    colorPickerView2.k.setColor(i6);
                    float[] fArr3 = new float[3];
                    Color.colorToHSV(i6, fArr3);
                    colorPickerView2.n = fArr3[1];
                    float[] fArr4 = new float[3];
                    Color.colorToHSV(i6, fArr4);
                    colorPickerView2.o = fArr4[2];
                    colorPickerView2.invalidate();
                    colorPickerView2.post(new Runnable() { // from class: stepos.support.v7.app.palette.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            int i10 = ColorPickerView.f6323q;
                            b.c().d(i6);
                        }
                    });
                }
            });
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
            if (C1417f.b == null) {
                C1417f.b = new C1417f(9);
            }
            C1417f.b.getClass();
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
