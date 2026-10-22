package androidx.core.app;

import android.app.Activity;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcelable;
import android.text.Html;
import android.text.Spanned;
import android.view.ActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;
import androidx.core.content.IntentCompat;
import androidx.core.util.Preconditions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes17.dex */
public final class ShareCompat {
    public static final String EXTRA_CALLING_ACTIVITY = "androidx.core.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_ACTIVITY_INTEROP = "android.support.v4.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_PACKAGE = "androidx.core.app.EXTRA_CALLING_PACKAGE";
    public static final String EXTRA_CALLING_PACKAGE_INTEROP = "android.support.v4.app.EXTRA_CALLING_PACKAGE";
    private static final String HISTORY_FILENAME_PREFIX = ".sharecompat_";

    public static class IntentBuilder {
        private ArrayList<String> mBccAddresses;
        private ArrayList<String> mCcAddresses;
        private CharSequence mChooserTitle;
        private final Context mContext;
        private final Intent mIntent;
        private ArrayList<Uri> mStreams;
        private ArrayList<String> mToAddresses;

        public Intent getIntent() {
            ArrayList<String> r100 = this.mToAddresses;
            if (r100 == null) goto L5;
            combineArrayExtra("android.intent.extra.EMAIL", r100);
            this.mToAddresses = null;
        L5:
            ArrayList<String> r101 = this.mCcAddresses;
            if (r101 == null) goto L8;
            combineArrayExtra("android.intent.extra.CC", r101);
            this.mCcAddresses = null;
        L8:
            ArrayList<String> r102 = this.mBccAddresses;
            if (r102 == null) goto L11;
            combineArrayExtra("android.intent.extra.BCC", r102);
            this.mBccAddresses = null;
        L11:
            ArrayList<Uri> r103 = this.mStreams;
            if (r103 == null) goto L16;
            boolean r104 = true;
            if (r103.size() <= 1) goto L16;
        L18:
            if (r104 == true) goto L25;
            this.mIntent.setAction("android.intent.action.SEND");
            ArrayList<Uri> r105 = this.mStreams;
            if (r105 != null) goto L22;
        L24:
            this.mIntent.removeExtra("android.intent.extra.STREAM");
            this.mIntent.setClipData(null);
            Intent r106 = this.mIntent;
            r106.setFlags(r106.getFlags() & (-2));
        L27:
            return this.mIntent;
        L22:
            if (r105.isEmpty() == true) goto L24;
            this.mIntent.putExtra("android.intent.extra.STREAM", (Parcelable) ListProtector.get(this.mStreams, 0));
            ShareCompat.migrateExtraStreamToClipData(this.mIntent, this.mStreams);
            goto L27
        L25:
            this.mIntent.setAction("android.intent.action.SEND_MULTIPLE");
            this.mIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.mStreams);
            ShareCompat.migrateExtraStreamToClipData(this.mIntent, this.mStreams);
        L16:
            r104 = false;
            goto L18
        }

        public void startChooser() {
            this.mContext.startActivity(createChooserIntent());
        }

        public Intent createChooserIntent() {
            return Intent.createChooser(getIntent(), this.mChooserTitle);
        }

        public Context getContext() {
            return this.mContext;
        }

        public IntentBuilder(Context r100) {
            this.mContext = (Context) Preconditions.checkNotNull(r100);
            Intent r101 = new Intent().setAction("android.intent.action.SEND");
            this.mIntent = r101;
            r101.putExtra(ShareCompat.EXTRA_CALLING_PACKAGE, r100.getPackageName());
            r101.putExtra(ShareCompat.EXTRA_CALLING_PACKAGE_INTEROP, r100.getPackageName());
            r101.addFlags(524288);
        L4:
            if ((r100 instanceof ContextWrapper) == false) goto L9;
            if ((r100 instanceof Activity) == true) goto L7;
            r100 = ((ContextWrapper) r100).getBaseContext();
            goto L4
        L7:
            Activity r102 = (Activity) r100;
        L10:
            if (r102 == null) goto L15;
            ComponentName r103 = r102.getComponentName();
            this.mIntent.putExtra(ShareCompat.EXTRA_CALLING_ACTIVITY, r103);
            this.mIntent.putExtra(ShareCompat.EXTRA_CALLING_ACTIVITY_INTEROP, r103);
            return;
        L15:
            return;
        L9:
            r102 = null;
            goto L10
        }

        public static IntentBuilder from(Activity r100) {
            return new IntentBuilder(r100);
        }

        public IntentBuilder addEmailBcc(String r100) {
            if (this.mBccAddresses != null) goto L5;
            this.mBccAddresses = new ArrayList();
        L5:
            this.mBccAddresses.add(r100);
            return this;
        }

        public IntentBuilder addEmailCc(String r100) {
            if (this.mCcAddresses != null) goto L5;
            this.mCcAddresses = new ArrayList();
        L5:
            this.mCcAddresses.add(r100);
            return this;
        }

        public IntentBuilder addEmailTo(String r100) {
            if (this.mToAddresses != null) goto L5;
            this.mToAddresses = new ArrayList();
        L5:
            this.mToAddresses.add(r100);
            return this;
        }

        public IntentBuilder addStream(Uri r100) {
            if (this.mStreams != null) goto L5;
            this.mStreams = new ArrayList();
        L5:
            this.mStreams.add(r100);
            return this;
        }

        public IntentBuilder setChooserTitle(int r100) {
            return setChooserTitle(this.mContext.getText(r100));
        }

        public IntentBuilder setEmailBcc(String[] r100) {
            this.mIntent.putExtra("android.intent.extra.BCC", r100);
            return this;
        }

        public IntentBuilder setEmailCc(String[] r100) {
            this.mIntent.putExtra("android.intent.extra.CC", r100);
            return this;
        }

        public IntentBuilder setEmailTo(String[] r100) {
            if (this.mToAddresses == null) goto L5;
            this.mToAddresses = null;
        L5:
            this.mIntent.putExtra("android.intent.extra.EMAIL", r100);
            return this;
        }

        public IntentBuilder setHtmlText(String r100) {
            this.mIntent.putExtra(IntentCompat.EXTRA_HTML_TEXT, r100);
            if (this.mIntent.hasExtra("android.intent.extra.TEXT") == true) goto L5;
            setText(Html.fromHtml(r100));
        L5:
            return this;
        }

        public IntentBuilder setStream(Uri r100) {
            this.mStreams = null;
            if (r100 == null) goto L5;
            addStream(r100);
        L5:
            return this;
        }

        public IntentBuilder setSubject(String r100) {
            this.mIntent.putExtra("android.intent.extra.SUBJECT", r100);
            return this;
        }

        public IntentBuilder setText(CharSequence r100) {
            this.mIntent.putExtra("android.intent.extra.TEXT", r100);
            return this;
        }

        public IntentBuilder setType(String r100) {
            this.mIntent.setType(r100);
            return this;
        }

        public IntentBuilder addEmailBcc(String[] r100) {
            combineArrayExtra("android.intent.extra.BCC", r100);
            return this;
        }

        public IntentBuilder addEmailCc(String[] r100) {
            combineArrayExtra("android.intent.extra.CC", r100);
            return this;
        }

        public IntentBuilder addEmailTo(String[] r100) {
            combineArrayExtra("android.intent.extra.EMAIL", r100);
            return this;
        }

        public IntentBuilder setChooserTitle(CharSequence r100) {
            this.mChooserTitle = r100;
            return this;
        }

        private void combineArrayExtra(String r100, ArrayList<String> r101) {
            String[] r102 = this.mIntent.getStringArrayExtra(r100);
            if (r102 == null) goto L5;
            int r103 = r102.length;
        L6:
            String[] r104 = new String[r101.size() + r103];
            r101.toArray(r104);
            if (r102 == null) goto L9;
            System.arraycopy(r102, 0, r104, r101.size(), r103);
        L9:
            this.mIntent.putExtra(r100, r104);
            return;
        L5:
            r103 = 0;
            goto L6
        }

        private void combineArrayExtra(String r100, String[] r101) {
            Intent r102 = getIntent();
            String[] r103 = r102.getStringArrayExtra(r100);
            if (r103 == null) goto L5;
            int r104 = r103.length;
        L6:
            String[] r105 = new String[r101.length + r104];
            if (r103 == null) goto L9;
            System.arraycopy(r103, 0, r105, 0, r104);
        L9:
            System.arraycopy(r101, 0, r105, r104, r101.length);
            r102.putExtra(r100, r105);
            return;
        L5:
            r104 = 0;
            goto L6
        }
    }

    public static class IntentReader {
        private static final String TAG = "IntentReader";
        private final ComponentName mCallingActivity;
        private final String mCallingPackage;
        private final Context mContext;
        private final Intent mIntent;
        private ArrayList<Uri> mStreams;

        public Drawable getCallingActivityIcon() {
            if (this.mCallingActivity != null) goto L5;
            return null;
        L5:
            PackageManager r100 = this.mContext.getPackageManager();
            return r100.getActivityIcon(this.mCallingActivity);
        L8:
            return null;
        }

        public Drawable getCallingApplicationIcon() {
            if (this.mCallingPackage != null) goto L5;
            return null;
        L5:
            PackageManager r100 = this.mContext.getPackageManager();
            return r100.getApplicationIcon(this.mCallingPackage);
        L8:
            return null;
        }

        public CharSequence getCallingApplicationLabel() {
            if (this.mCallingPackage != null) goto L5;
            return null;
        L5:
            PackageManager r100 = this.mContext.getPackageManager();
            return r100.getApplicationLabel(r100.getApplicationInfo(this.mCallingPackage, 0));
        L8:
            return null;
        }

        public String[] getEmailBcc() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.BCC");
        }

        public String[] getEmailCc() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.CC");
        }

        public String[] getEmailTo() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.EMAIL");
        }

        public String getHtmlText() {
            String r100 = this.mIntent.getStringExtra(IntentCompat.EXTRA_HTML_TEXT);
            if (r100 != null) goto L10;
            CharSequence r101 = getText();
            if ((r101 instanceof Spanned) == true) goto L11;
            if (r101 != null) goto L9;
            return r100;
        L9:
            return Html.escapeHtml(r101);
        L11:
            return Html.toHtml((Spanned) r101);
        L10:
            return r100;
        }

        public Uri getStream() {
            return (Uri) this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
        }

        public int getStreamCount() {
            if (this.mStreams == null) goto L5;
        L7:
            ArrayList<Uri> r100 = this.mStreams;
            if (r100 == null) goto L12;
            return r100.size();
        L12:
            return this.mIntent.hasExtra("android.intent.extra.STREAM") ? 1 : 0;
        L5:
            if (isMultipleShare() == false) goto L7;
            this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
            goto L7
        }

        public String getSubject() {
            return this.mIntent.getStringExtra("android.intent.extra.SUBJECT");
        }

        public CharSequence getText() {
            return this.mIntent.getCharSequenceExtra("android.intent.extra.TEXT");
        }

        public String getType() {
            return this.mIntent.getType();
        }

        public boolean isMultipleShare() {
            return "android.intent.action.SEND_MULTIPLE".equals(this.mIntent.getAction());
        }

        public boolean isShareIntent() {
            String r100 = this.mIntent.getAction();
            if ("android.intent.action.SEND".equals(r100) == false) goto L5;
        L8:
            return true;
        L5:
            if ("android.intent.action.SEND_MULTIPLE".equals(r100) == true) goto L8;
            return false;
        }

        public boolean isSingleShare() {
            return "android.intent.action.SEND".equals(this.mIntent.getAction());
        }

        public ComponentName getCallingActivity() {
            return this.mCallingActivity;
        }

        public String getCallingPackage() {
            return this.mCallingPackage;
        }

        public IntentReader(Activity r100) {
            this((Context) Preconditions.checkNotNull(r100), r100.getIntent());
        }

        public static IntentReader from(Activity r100) {
            return new IntentReader(r100);
        }

        public Uri getStream(int r100) {
            if (this.mStreams == null) goto L5;
        L7:
            ArrayList<Uri> r101 = this.mStreams;
            if (r101 != null) goto L10;
            if (r100 != 0) goto L15;
            return (Uri) this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
        L15:
            throw new IndexOutOfBoundsException("Stream items available: " + getStreamCount() + " index requested: " + r100);
        L10:
            return (Uri) ListProtector.get(r101, r100);
        L5:
            if (isMultipleShare() == false) goto L7;
            this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
            goto L7
        }

        public IntentReader(Context r100, Intent r101) {
            this.mContext = (Context) Preconditions.checkNotNull(r100);
            this.mIntent = (Intent) Preconditions.checkNotNull(r101);
            this.mCallingPackage = ShareCompat.getCallingPackage(r101);
            this.mCallingActivity = ShareCompat.getCallingActivity(r101);
        }
    }

    private ShareCompat() {
    }

    public static ComponentName getCallingActivity(Intent r100) {
        ComponentName r101 = (ComponentName) r100.getParcelableExtra(EXTRA_CALLING_ACTIVITY);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return (ComponentName) r100.getParcelableExtra(EXTRA_CALLING_ACTIVITY_INTEROP);
    }

    public static String getCallingPackage(Activity r100) {
        Intent r101 = r100.getIntent();
        String r102 = r100.getCallingPackage();
        if (r102 != null) goto L7;
        if (r101 != null) goto L6;
        return r102;
    L6:
        return getCallingPackage(r101);
    L7:
        return r102;
    }

    public static ComponentName getCallingActivity(Activity r100) {
        Intent r101 = r100.getIntent();
        ComponentName r102 = r100.getCallingActivity();
        if (r102 == null) goto L5;
        return r102;
    L5:
        return getCallingActivity(r101);
    }

    public static String getCallingPackage(Intent r100) {
        String r101 = r100.getStringExtra(EXTRA_CALLING_PACKAGE);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return r100.getStringExtra(EXTRA_CALLING_PACKAGE_INTEROP);
    }

    public static void configureMenuItem(MenuItem r100, IntentBuilder r101) {
        ActionProvider r102 = r100.getActionProvider();
        if ((r102 instanceof ShareActionProvider) == true) goto L5;
        ShareActionProvider r103 = new ShareActionProvider(r101.getContext());
    L6:
        r103.setShareHistoryFileName(HISTORY_FILENAME_PREFIX.concat(r101.getContext().getClass().getName()));
        r103.setShareIntent(r101.getIntent());
        r100.setActionProvider(r103);
        return;
    L5:
        r103 = (ShareActionProvider) r102;
        goto L6
    }

    public static void migrateExtraStreamToClipData(Intent r100, ArrayList<Uri> r101) {
        CharSequence r102 = r100.getCharSequenceExtra("android.intent.extra.TEXT");
        String r103 = r100.getStringExtra(IntentCompat.EXTRA_HTML_TEXT);
        ClipData r104 = new ClipData(null, new String[]{r100.getType()}, new ClipData.Item(r102, r103, null, (Uri) ListProtector.get(r101, 0)));
        int r105 = r101.size();
        int r106 = 1;
    L3:
        if (r106 >= r105) goto L5;
        r104.addItem(new ClipData.Item((Uri) ListProtector.get(r101, r106)));
        r106 = r106 + 1;
        goto L3
    L5:
        r100.setClipData(r104);
        r100.addFlags(1);
    }

    public static void configureMenuItem(Menu r100, int r101, IntentBuilder r102) {
        MenuItem r103 = r100.findItem(r101);
        if (r103 == null) goto L7;
        configureMenuItem(r103, r102);
        return;
    L7:
        throw new IllegalArgumentException("Could not find menu item with id " + r101 + " in the supplied menu");
    }
}
