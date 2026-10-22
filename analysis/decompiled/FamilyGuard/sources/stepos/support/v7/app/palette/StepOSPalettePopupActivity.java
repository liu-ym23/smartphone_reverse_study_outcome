package stepos.support.v7.app.palette;

import X4.h;
import X4.i;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import java.util.Objects;
import stepos.support.v7.app.m;
import stepos.support.v7.app.n;

/* loaded from: classes.dex */
public class StepOSPalettePopupActivity extends n {

    /* renamed from: f, reason: collision with root package name */
    private static Activity f20945f;

    public interface a {
    }

    protected static void F(Context context, int i5) {
        Intent intent = new Intent(context, (Class<?>) StepOSPalettePopupActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("pick_color", i5);
        context.startActivity(intent);
    }

    private static void G() {
        View rootView = f20945f.getWindow().getDecorView().getRootView();
        rootView.setDrawingCacheEnabled(true);
        d.s().w(Bitmap.createBitmap(rootView.getDrawingCache()));
        rootView.setDrawingCacheEnabled(false);
    }

    @Override // stepos.support.v7.app.n, android.app.Activity
    public void finish() {
        super.finish();
    }

    @Override // stepos.support.v7.app.n, stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(h.f6031c);
        stepos.support.v7.app.a supportActionBar = getSupportActionBar();
        Objects.requireNonNull(supportActionBar);
        supportActionBar.E(true);
        m mVarV = v();
        if (mVarV != null) {
            mVarV.a(1);
        }
        ColorPickerView colorPickerView = (ColorPickerView) findViewById(X4.f.f6009p);
        colorPickerView.t(null);
        int intExtra = getIntent().getIntExtra("pick_color", 0);
        if (intExtra != 0) {
            colorPickerView.u(intExtra);
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(i.f6051a, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            onBackPressed();
            return true;
        }
        if (itemId != X4.f.f5957E) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (!a5.e.a(this)) {
            a5.e.b(this);
        } else {
            if (f20945f == null) {
                d.s().v();
                return true;
            }
            if (!d.s().f20964n.booleanValue()) {
                G();
            }
            d.s().x(this, null);
            finish();
        }
        return true;
    }

    @Override // stepos.support.v7.app.n
    protected void y() {
        super.y();
    }
}
