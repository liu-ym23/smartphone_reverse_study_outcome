package butterknife.internal;

import android.view.View;

/* JADX INFO: loaded from: classes28.dex */
public abstract class DebouncingOnClickListener implements View.OnClickListener {
    private static final Runnable ENABLE_AGAIN = null;
    static boolean enabled = true;

    public DebouncingOnClickListener() {
    }

    public static /* synthetic */ void a() {
        lambda$static$0();
    }

    private static /* synthetic */ void lambda$static$0() {
        enabled = true;
    }

    public abstract void doClick(View r100);

    static {
        ENABLE_AGAIN = new a();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (enabled == false) goto L6;
        enabled = false;
        r100.post(ENABLE_AGAIN);
        doClick(r100);
        return;
    }
}
