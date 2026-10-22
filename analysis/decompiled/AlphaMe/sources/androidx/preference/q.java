package androidx.preference;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.stepos.alphame.R;

/* loaded from: classes.dex */
public final class q implements View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final Preference f4154a;

    public q(Preference preference) {
        this.f4154a = preference;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        Preference preference = this.f4154a;
        CharSequence charSequenceF = preference.f();
        if (!preference.f4066C || TextUtils.isEmpty(charSequenceF)) {
            return;
        }
        contextMenu.setHeaderTitle(charSequenceF);
        contextMenu.add(0, 0, 0, R.string.copy).setOnMenuItemClickListener(this);
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        Preference preference = this.f4154a;
        ClipboardManager clipboardManager = (ClipboardManager) preference.f4077a.getSystemService("clipboard");
        CharSequence charSequenceF = preference.f();
        clipboardManager.setPrimaryClip(ClipData.newPlainText("Preference", charSequenceF));
        Context context = preference.f4077a;
        Toast.makeText(context, context.getString(R.string.preference_copied, charSequenceF), 0).show();
        return true;
    }
}
