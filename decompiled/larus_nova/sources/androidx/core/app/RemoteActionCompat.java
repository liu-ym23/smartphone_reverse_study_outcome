package androidx.core.app;

import android.app.PendingIntent;
import android.app.RemoteAction;
import android.graphics.drawable.Icon;
import android.os.Build;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Preconditions;
import androidx.versionedparcelable.VersionedParcelable;

/* JADX INFO: loaded from: classes17.dex */
public final class RemoteActionCompat implements VersionedParcelable {
    public PendingIntent mActionIntent;
    public CharSequence mContentDescription;
    public boolean mEnabled;
    public IconCompat mIcon;
    public boolean mShouldShowIcon;
    public CharSequence mTitle;

    public static class Api26Impl {
        private Api26Impl() {
        }

        public static PendingIntent getActionIntent(RemoteAction r100) {
            return r100.getActionIntent();
        }

        public static CharSequence getContentDescription(RemoteAction r100) {
            return r100.getContentDescription();
        }

        public static Icon getIcon(RemoteAction r100) {
            return r100.getIcon();
        }

        public static CharSequence getTitle(RemoteAction r100) {
            return r100.getTitle();
        }

        public static boolean isEnabled(RemoteAction r100) {
            return r100.isEnabled();
        }

        public static void setEnabled(RemoteAction r100, boolean r101) {
            r100.setEnabled(r101);
        }

        public static RemoteAction createRemoteAction(Icon r100, CharSequence r101, CharSequence r102, PendingIntent r103) {
            return new RemoteAction(r100, r101, r102, r103);
        }
    }

    public static class Api28Impl {
        private Api28Impl() {
        }

        public static boolean shouldShowIcon(RemoteAction r100) {
            return r100.shouldShowIcon();
        }

        public static void setShouldShowIcon(RemoteAction r100, boolean r101) {
            r100.setShouldShowIcon(r101);
        }
    }

    public RemoteActionCompat() {
    }

    public RemoteAction toRemoteAction() {
        RemoteAction r100 = Api26Impl.createRemoteAction(this.mIcon.toIcon(), this.mTitle, this.mContentDescription, this.mActionIntent);
        Api26Impl.setEnabled(r100, isEnabled());
        if (Build.VERSION.SDK_INT < 28) goto L5;
        Api28Impl.setShouldShowIcon(r100, shouldShowIcon());
    L5:
        return r100;
    }

    public PendingIntent getActionIntent() {
        return this.mActionIntent;
    }

    public CharSequence getContentDescription() {
        return this.mContentDescription;
    }

    public IconCompat getIcon() {
        return this.mIcon;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public boolean shouldShowIcon() {
        return this.mShouldShowIcon;
    }

    public RemoteActionCompat(RemoteActionCompat r100) {
        Preconditions.checkNotNull(r100);
        this.mIcon = r100.mIcon;
        this.mTitle = r100.mTitle;
        this.mContentDescription = r100.mContentDescription;
        this.mActionIntent = r100.mActionIntent;
        this.mEnabled = r100.mEnabled;
        this.mShouldShowIcon = r100.mShouldShowIcon;
    }

    public static RemoteActionCompat createFromRemoteAction(RemoteAction r100) {
        Preconditions.checkNotNull(r100);
        RemoteActionCompat r101 = new RemoteActionCompat(IconCompat.createFromIcon(Api26Impl.getIcon(r100)), Api26Impl.getTitle(r100), Api26Impl.getContentDescription(r100), Api26Impl.getActionIntent(r100));
        r101.setEnabled(Api26Impl.isEnabled(r100));
        if (Build.VERSION.SDK_INT < 28) goto L5;
        r101.setShouldShowIcon(Api28Impl.shouldShowIcon(r100));
    L5:
        return r101;
    }

    public void setEnabled(boolean r100) {
        this.mEnabled = r100;
    }

    public void setShouldShowIcon(boolean r100) {
        this.mShouldShowIcon = r100;
    }

    public RemoteActionCompat(IconCompat r100, CharSequence r101, CharSequence r102, PendingIntent r103) {
        this.mIcon = (IconCompat) Preconditions.checkNotNull(r100);
        this.mTitle = (CharSequence) Preconditions.checkNotNull(r101);
        this.mContentDescription = (CharSequence) Preconditions.checkNotNull(r102);
        this.mActionIntent = (PendingIntent) Preconditions.checkNotNull(r103);
        this.mEnabled = true;
        this.mShouldShowIcon = true;
    }
}
