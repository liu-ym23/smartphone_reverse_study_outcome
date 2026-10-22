package stepos.support.v7.app.palette;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import java.util.Objects;
import net.sqlcipher.database.SQLiteDatabase;
import stepos.support.v7.app.l;
import stepos.support.v7.app.m;
import stepos.support.v7.appcompat.R$id;
import stepos.support.v7.appcompat.R$layout;
import stepos.support.v7.appcompat.R$menu;

/* loaded from: classes5.dex */
public class StepOSPalettePopupActivity extends m {

    /* renamed from: f, reason: collision with root package name */
    public static Activity f40681f;

    public interface a {
    }

    public static void D(Context context, int i10) {
        Intent intent = new Intent(context, (Class<?>) StepOSPalettePopupActivity.class);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.putExtra("pick_color", i10);
        context.startActivity(intent);
    }

    public static void E() {
        View rootView = f40681f.getWindow().getDecorView().getRootView();
        rootView.setDrawingCacheEnabled(true);
        d.s().w(Bitmap.createBitmap(rootView.getDrawingCache()));
        rootView.setDrawingCacheEnabled(false);
    }

    @Override // stepos.support.v7.app.m, android.app.Activity
    public void finish() {
        super.finish();
    }

    @Override // stepos.support.v7.app.m, stepos.support.v7.app.d, androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.palette_activity_layout);
        stepos.support.v7.app.a supportActionBar = getSupportActionBar();
        Objects.requireNonNull(supportActionBar);
        supportActionBar.p(true);
        l lVarT = t();
        if (lVarT != null) {
            lVarT.a(1);
        }
        ColorPickerView colorPickerView = (ColorPickerView) findViewById(R$id.color_pick_view);
        colorPickerView.t(null);
        int intExtra = getIntent().getIntExtra("pick_color", 0);
        if (intExtra != 0) {
            colorPickerView.u(intExtra);
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R$menu.menu_palette_icon, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            onBackPressed();
            return true;
        }
        if (itemId != R$id.palette_open_pick) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (!Hc.d.a(this)) {
            Hc.d.b(this);
        } else {
            if (f40681f == null) {
                d.s().v();
                return true;
            }
            if (!d.s().f40700n.booleanValue()) {
                E();
            }
            d.s().x(this, null);
            finish();
        }
        return true;
    }

    @Override // stepos.support.v7.app.m
    public void w() {
        super.w();
    }
}
