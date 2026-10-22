package cc5;

import android.graphics.drawable.Drawable;
import com.bytedance.ee.bear.lark.tab.DocTabView;
import com.larus.nova.R;
import com.ss.android.lark.widget.tab.MainTabItemView;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements MainTabItemView.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DocTabView f23293a;

    @Override // com.ss.android.lark.widget.tab.MainTabItemView.b
    public final Drawable getDrawable() {
        return this.f23293a.getResources().getDrawable(R.drawable.ud_icon_tab_drive_colorful);
    }

    public a(DocTabView r100) {
        this.f23293a = r100;
    }
}
