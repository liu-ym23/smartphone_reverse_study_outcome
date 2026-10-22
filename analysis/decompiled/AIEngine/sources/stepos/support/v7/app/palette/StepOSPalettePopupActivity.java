package stepos.support.v7.app.palette;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.stepos.aiengine.R;
import java.util.Objects;
import stepos.support.v7.app.r;
import stepos.support.v7.app.s;
import stepos.support.v7.widget.PopupNestedScrollingLayout;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class StepOSPalettePopupActivity extends r {
    @Override // stepos.support.v7.app.r, stepos.support.v7.app.f, androidx.fragment.app.o, b.k, androidx.core.app.c, android.app.Activity
    public final void onCreate(Bundle bundle) {
        PopupNestedScrollingLayout popupNestedScrollingLayout;
        super.onCreate(bundle);
        setContentView(R.layout.palette_activity_layout);
        stepos.support.v7.app.a supportActionBar = getSupportActionBar();
        Objects.requireNonNull(supportActionBar);
        supportActionBar.j(true);
        s sVar = this.f12257b;
        if (sVar != null && (popupNestedScrollingLayout = sVar.f12263c) != null) {
            popupNestedScrollingLayout.setStyle(1);
        }
        final ColorPickerView colorPickerView = (ColorPickerView) findViewById(R.id.color_pick_view);
        colorPickerView.getClass();
        final int intExtra = getIntent().getIntExtra("pick_color", 0);
        if (intExtra != 0) {
            colorPickerView.post(new Runnable() { // from class: stepos.support.v7.app.palette.e
                @Override // java.lang.Runnable
                public final void run() {
                    int i10 = ColorPickerView.f12223t;
                    float[] fArr = new float[3];
                    final int i11 = intExtra;
                    Color.colorToHSV(i11, fArr);
                    float f8 = fArr[0];
                    ColorPickerView colorPickerView2 = colorPickerView;
                    if (f8 >= 0.0f) {
                        double d8 = f8;
                        colorPickerView2.f12227d = (float) ((Math.cos(Math.toRadians(d8)) * colorPickerView2.h) + colorPickerView2.f12225b);
                        colorPickerView2.f12228e = (float) ((Math.sin(Math.toRadians(d8)) * colorPickerView2.h) + colorPickerView2.f12226c);
                    }
                    float[] fArr2 = {0.0f, 1.0f, 1.0f};
                    Color.colorToHSV(i11, fArr2);
                    colorPickerView2.f12235p = Color.HSVToColor(fArr2);
                    colorPickerView2.f12233n.setColor(i11);
                    float[] fArr3 = new float[3];
                    Color.colorToHSV(i11, fArr3);
                    colorPickerView2.f12236q = fArr3[1];
                    float[] fArr4 = new float[3];
                    Color.colorToHSV(i11, fArr4);
                    colorPickerView2.r = fArr4[2];
                    colorPickerView2.invalidate();
                    colorPickerView2.post(new Runnable() { // from class: stepos.support.v7.app.palette.f
                        @Override // java.lang.Runnable
                        public final void run() {
                            int i12 = ColorPickerView.f12223t;
                            b.h().k(i11);
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
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            onBackPressed();
            return true;
        }
        if (itemId != R.id.palette_open_pick) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (Settings.canDrawOverlays(this)) {
            if (c.f12251a == null) {
                c.f12251a = new c();
            }
            c.f12251a.getClass();
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
