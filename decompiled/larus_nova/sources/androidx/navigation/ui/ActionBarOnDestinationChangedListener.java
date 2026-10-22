package androidx.navigation.ui;

import android.graphics.drawable.Drawable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0001\u0010\u000b\u001a\u00020\fH\u0014J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/navigation/ui/ActionBarOnDestinationChangedListener;", "Landroidx/navigation/ui/AbstractAppBarOnDestinationChangedListener;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "configuration", "Landroidx/navigation/ui/AppBarConfiguration;", "(Landroidx/appcompat/app/AppCompatActivity;Landroidx/navigation/ui/AppBarConfiguration;)V", "setNavigationIcon", "", "icon", "Landroid/graphics/drawable/Drawable;", "contentDescription", "", com.alipay.sdk.m.x.d.f25925o, "title", "", "navigation-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ActionBarOnDestinationChangedListener extends AbstractAppBarOnDestinationChangedListener {
    private final AppCompatActivity activity;

    @Override // androidx.navigation.ui.AbstractAppBarOnDestinationChangedListener
    public void setTitle(CharSequence r100) {
        ActionBar r101 = this.activity.getSupportActionBar();
        if (r101 == null) goto L7;
        r101.setTitle(r100);
        return;
    L7:
        throw new IllegalStateException(("Activity " + this.activity + " does not have an ActionBar set via setSupportActionBar()").toString());
    }

    public ActionBarOnDestinationChangedListener(AppCompatActivity r100, AppBarConfiguration r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "configuration");
        ActionBarDrawerToggle.Delegate r102 = r100.getDrawerToggleDelegate();
        if (r102 == null) goto L7;
        super(r102.getActionBarThemedContext(), r101);
        this.activity = r100;
        return;
    L7:
        throw new IllegalStateException(("Activity " + r100 + " does not have an DrawerToggleDelegate set").toString());
    }

    @Override // androidx.navigation.ui.AbstractAppBarOnDestinationChangedListener
    public void setNavigationIcon(Drawable r100, int r101) {
        ActionBar r102 = this.activity.getSupportActionBar();
        if (r102 == null) goto L14;
        if (r100 == null) goto L6;
        boolean r103 = true;
    L7:
        r102.setDisplayHomeAsUpEnabled(r103);
        ActionBarDrawerToggle.Delegate r104 = this.activity.getDrawerToggleDelegate();
        if (r104 == null) goto L12;
        r104.setActionBarUpIndicator(r100, r101);
        return;
    L12:
        throw new IllegalStateException(("Activity " + this.activity + " does not have an DrawerToggleDelegate set").toString());
    L6:
        r103 = false;
        goto L7
    L14:
        throw new IllegalStateException(("Activity " + this.activity + " does not have an ActionBar set via setSupportActionBar()").toString());
    }
}
