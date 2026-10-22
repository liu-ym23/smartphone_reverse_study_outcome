package stepos.support.v7.app.palette;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.android.gms.common.internal.f;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import java.util.Objects;
import stepos.support.v7.app.AbstractC0860e;
import stepos.support.v7.app.C;
import stepos.support.v7.app.D;
import stepos.support.v7.app.G;
import stepos.support.v7.widget.PopupNestedScrollingLayout;

/* loaded from: classes2.dex */
public class StepOSPalettePopupActivity extends D {
    @Override // stepos.support.v7.app.D, android.app.Activity
    public final void finish() {
        super.finish();
    }

    @Override // stepos.support.v7.app.D, stepos.support.v7.app.AbstractActivityC0866k, androidx.fragment.app.G, androidx.activity.o, androidx.core.app.k, android.app.Activity
    public final void onCreate(Bundle bundle) {
        PopupNestedScrollingLayout popupNestedScrollingLayout;
        super.onCreate(bundle);
        setContentView(R.layout.palette_activity_layout);
        AbstractC0860e supportActionBar = getSupportActionBar();
        Objects.requireNonNull(supportActionBar);
        supportActionBar.l(true);
        C litePopup = getLitePopup();
        if (litePopup != null && (popupNestedScrollingLayout = ((G) litePopup).f14272c) != null) {
            popupNestedScrollingLayout.setStyle(1);
        }
        final ColorPickerView colorPickerView = (ColorPickerView) findViewById(R.id.color_pick_view);
        colorPickerView.getClass();
        final int intExtra = getIntent().getIntExtra("pick_color", 0);
        if (intExtra != 0) {
            colorPickerView.post(new Runnable() { // from class: stepos.support.v7.app.palette.d
                @Override // java.lang.Runnable
                public final void run() {
                    int i4 = ColorPickerView.f14547q;
                    ColorPickerView colorPickerView2 = colorPickerView;
                    colorPickerView2.getClass();
                    float[] fArr = new float[3];
                    final int i5 = intExtra;
                    Color.colorToHSV(i5, fArr);
                    float f4 = fArr[0];
                    if (f4 >= Property.DEFAULT_FLOAT_VALUE) {
                        double d4 = f4;
                        colorPickerView2.f14551d = (float) ((Math.cos(Math.toRadians(d4)) * colorPickerView2.f14553f) + colorPickerView2.f14549b);
                        colorPickerView2.f14552e = (float) ((Math.sin(Math.toRadians(d4)) * colorPickerView2.f14553f) + colorPickerView2.f14550c);
                    }
                    float[] fArr2 = {0.0f, 1.0f, 1.0f};
                    Color.colorToHSV(i5, fArr2);
                    colorPickerView2.f14560m = Color.HSVToColor(fArr2);
                    colorPickerView2.f14558k.setColor(i5);
                    float[] fArr3 = new float[3];
                    Color.colorToHSV(i5, fArr3);
                    colorPickerView2.f14561n = fArr3[1];
                    float[] fArr4 = new float[3];
                    Color.colorToHSV(i5, fArr4);
                    colorPickerView2.f14562o = fArr4[2];
                    colorPickerView2.invalidate();
                    colorPickerView2.post(new Runnable() { // from class: stepos.support.v7.app.palette.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            int i6 = ColorPickerView.f14547q;
                            b.d().e(i5);
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

    @Override // stepos.support.v7.app.D
    public final void onDismissed() {
        super.onDismissed();
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
            if (f.f9807b == null) {
                f.f9807b = new f();
            }
            f.f9807b.getClass();
            return true;
        }
        if (Settings.canDrawOverlays(this)) {
            Toast.makeText(this, "悬浮窗权限已拥有", 0).show();
        } else {
            startActivity(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getPackageName())));
        }
        return true;
    }
}
