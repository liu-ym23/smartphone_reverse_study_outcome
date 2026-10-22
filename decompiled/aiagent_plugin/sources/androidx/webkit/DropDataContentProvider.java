package androidx.webkit;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import androidx.webkit.internal.q;
import com.volcengine.zeus.provider.PluginContentProvider;
import org.chromium.support_lib_boundary.DropDataContentProviderBoundaryInterface;

/* JADX INFO: loaded from: classes.dex */
public final class DropDataContentProvider extends PluginContentProvider {
    DropDataContentProviderBoundaryInterface mImpl;

    public boolean onCreate() {
        return true;
    }

    public DropDataContentProvider() {
    }

    public ParcelFileDescriptor openFile(Uri r1, String r2) {
        return getDropImpl().openFile(this, r1);
    }

    public Cursor query(Uri r7, String[] r8, String r9, String[] r10, String r11) {
        return getDropImpl().query(r7, r8, r9, r10, r11);
    }

    public String getType(Uri r1) {
        return getDropImpl().getType(r1);
    }

    public Uri insert(Uri r1, ContentValues r2) {
        throw new UnsupportedOperationException("Insert method is not supported.");
    }

    public int delete(Uri r1, String r2, String[] r3) {
        throw new UnsupportedOperationException("delete method is not supported.");
    }

    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        throw new UnsupportedOperationException("update method is not supported.");
    }

    public Bundle call(String r1, String r2, Bundle r3) {
        return getDropImpl().call(r1, r2, r3);
    }

    private DropDataContentProviderBoundaryInterface getDropImpl() {
        if (this.mImpl != null) goto L6;
        DropDataContentProviderBoundaryInterface r0 = q.a().d();
        this.mImpl = r0;
        r0.onCreate();
    L6:
        return this.mImpl;
    }
}
