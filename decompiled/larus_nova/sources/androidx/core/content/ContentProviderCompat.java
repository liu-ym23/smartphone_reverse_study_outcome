package androidx.core.content;

import android.content.ContentProvider;
import android.content.Context;

/* JADX INFO: loaded from: classes17.dex */
public final class ContentProviderCompat {
    private ContentProviderCompat() {
    }

    public static Context requireContext(ContentProvider r100) {
        Context r101 = r100.getContext();
        if (r101 == null) goto L6;
        return r101;
    L6:
        throw new IllegalStateException("Cannot find context from the provider.");
    }
}
