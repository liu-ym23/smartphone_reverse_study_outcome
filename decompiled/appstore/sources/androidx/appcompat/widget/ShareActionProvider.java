package androidx.appcompat.widget;

import android.content.Intent;
import androidx.core.view.ActionProvider;

/* JADX INFO: loaded from: classes.dex */
public abstract class ShareActionProvider extends ActionProvider {

    public interface OnShareTargetSelectedListener {
        boolean onShareTargetSelected(ShareActionProvider r10, Intent r11);
    }
}
