package com.android.server.wm;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.TextView;

/* JADX INFO: loaded from: classes3.dex */
public final class LaunchWarningWindow extends Dialog {
    public LaunchWarningWindow(Context context, ActivityRecord cur, ActivityRecord next) {
        super(context, R.style.Widget.Material.Light.Spinner.DropDown.ActionBar);
        requestWindowFeature(3);
        getWindow().setType(2003);
        getWindow().addFlags(24);
        setContentView(R.layout.notification_material_media_action);
        setTitle(context.getText(R.string.mediasize_japanese_chou3));
        TypedValue out = new TypedValue();
        getContext().getTheme().resolveAttribute(R.attr.alertDialogIcon, out, true);
        getWindow().setFeatureDrawableResource(3, out.resourceId);
        ImageView icon = (ImageView) findViewById(R.id.split_action_bar);
        icon.setImageDrawable(next.info.applicationInfo.loadIcon(context.getPackageManager()));
        TextView text = (TextView) findViewById(R.id.square);
        text.setText(context.getResources().getString(R.string.mediasize_japanese_chou2, new Object[]{next.info.applicationInfo.loadLabel(context.getPackageManager()).toString()}));
        ImageView icon2 = (ImageView) findViewById(R.id.role);
        icon2.setImageDrawable(cur.info.applicationInfo.loadIcon(context.getPackageManager()));
        TextView text2 = (TextView) findViewById(R.id.round);
        text2.setText(context.getResources().getString(R.string.mediasize_iso_c9, new Object[]{cur.info.applicationInfo.loadLabel(context.getPackageManager()).toString()}));
    }
}
