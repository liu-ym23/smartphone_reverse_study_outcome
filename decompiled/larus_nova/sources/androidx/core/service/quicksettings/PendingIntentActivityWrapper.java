package androidx.core.service.quicksettings;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.PendingIntentCompat;

/* JADX INFO: loaded from: classes17.dex */
public class PendingIntentActivityWrapper {
    private final Context mContext;
    private final int mFlags;
    private final Intent mIntent;
    private final boolean mIsMutable;
    private final Bundle mOptions;
    private final PendingIntent mPendingIntent;
    private final int mRequestCode;

    private PendingIntent createPendingIntent() {
        Bundle r100 = this.mOptions;
        if (r100 != null) goto L7;
        return PendingIntentCompat.getActivity(this.mContext, this.mRequestCode, this.mIntent, this.mFlags, this.mIsMutable);
    L7:
        return PendingIntentCompat.getActivity(this.mContext, this.mRequestCode, this.mIntent, this.mFlags, r100, this.mIsMutable);
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getFlags() {
        return this.mFlags;
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    public Bundle getOptions() {
        return this.mOptions;
    }

    public PendingIntent getPendingIntent() {
        return this.mPendingIntent;
    }

    public int getRequestCode() {
        return this.mRequestCode;
    }

    public boolean isMutable() {
        return this.mIsMutable;
    }

    public PendingIntentActivityWrapper(Context r100, int r101, Intent r110, int r111, boolean r112) {
        this(r100, r101, r110, r111, null, r112);
    }

    public PendingIntentActivityWrapper(Context r100, int r101, Intent r102, int r103, Bundle r104, boolean r105) {
        this.mContext = r100;
        this.mRequestCode = r101;
        this.mIntent = r102;
        this.mFlags = r103;
        this.mOptions = r104;
        this.mIsMutable = r105;
        this.mPendingIntent = createPendingIntent();
    }
}
