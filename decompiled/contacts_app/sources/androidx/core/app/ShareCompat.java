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
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.ActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;
import androidx.core.content.IntentCompat;
import androidx.core.util.Preconditions;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ShareCompat {
    public static final String EXTRA_CALLING_ACTIVITY = "androidx.core.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_ACTIVITY_INTEROP = "android.support.v4.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_PACKAGE = "androidx.core.app.EXTRA_CALLING_PACKAGE";
    public static final String EXTRA_CALLING_PACKAGE_INTEROP = "android.support.v4.app.EXTRA_CALLING_PACKAGE";
    private static final String HISTORY_FILENAME_PREFIX = ".sharecompat_";

    private static class Api16Impl {
        private Api16Impl() {
        }

        static void migrateExtraStreamToClipData(Intent r8, ArrayList<Uri> r9) {
            ClipData r2 = new ClipData(null, new String[]{r8.getType()}, new ClipData.Item(r8.getCharSequenceExtra("android.intent.extra.TEXT"), r8.getStringExtra(IntentCompat.EXTRA_HTML_TEXT), null, r9.get(0)));
            int r0 = r9.size();
            int r1 = 1;
        L3:
            if (r1 >= r0) goto L5;
            r2.addItem(new ClipData.Item(r9.get(r1)));
            r1 = r1 + 1;
            goto L3
        L5:
            r8.setClipData(r2);
            r8.addFlags(1);
        }

        static void removeClipData(Intent r1) {
            r1.setClipData(null);
            r1.setFlags(r1.getFlags() & (-2));
        }

        static String escapeHtml(CharSequence r0) {
            return Html.escapeHtml(r0);
        }
    }

    public static class IntentBuilder {
        private ArrayList<String> mBccAddresses;
        private ArrayList<String> mCcAddresses;
        private CharSequence mChooserTitle;
        private final Context mContext;
        private final Intent mIntent;
        private ArrayList<Uri> mStreams;
        private ArrayList<String> mToAddresses;

        @Deprecated
        public static IntentBuilder from(Activity r1) {
            return new IntentBuilder(r1);
        }

        public IntentBuilder(Context r4) {
            this.mContext = (Context) Preconditions.checkNotNull(r4);
            Intent r0 = new Intent().setAction("android.intent.action.SEND");
            this.mIntent = r0;
            r0.putExtra(ShareCompat.EXTRA_CALLING_PACKAGE, r4.getPackageName());
            r0.putExtra(ShareCompat.EXTRA_CALLING_PACKAGE_INTEROP, r4.getPackageName());
            r0.addFlags(524288);
        L4:
            if ((r4 instanceof ContextWrapper) == false) goto L9;
            if ((r4 instanceof Activity) == true) goto L7;
            r4 = ((ContextWrapper) r4).getBaseContext();
            goto L4
        L7:
            Activity r5 = (Activity) r4;
        L10:
            if (r5 == null) goto L15;
            ComponentName r6 = r5.getComponentName();
            this.mIntent.putExtra(ShareCompat.EXTRA_CALLING_ACTIVITY, r6);
            this.mIntent.putExtra(ShareCompat.EXTRA_CALLING_ACTIVITY_INTEROP, r6);
            return;
        L15:
            return;
        L9:
            r5 = null;
            goto L10
        }

        public Intent getIntent() {
            ArrayList<String> r0 = this.mToAddresses;
            if (r0 == null) goto L5;
            combineArrayExtra("android.intent.extra.EMAIL", r0);
            this.mToAddresses = null;
        L5:
            ArrayList<String> r1 = this.mCcAddresses;
            if (r1 == null) goto L8;
            combineArrayExtra("android.intent.extra.CC", r1);
            this.mCcAddresses = null;
        L8:
            ArrayList<String> r2 = this.mBccAddresses;
            if (r2 == null) goto L11;
            combineArrayExtra("android.intent.extra.BCC", r2);
            this.mBccAddresses = null;
        L11:
            ArrayList<Uri> r3 = this.mStreams;
            if (r3 == null) goto L16;
            boolean r4 = true;
            if (r3.size() <= 1) goto L16;
        L18:
            if (r4 == true) goto L25;
            this.mIntent.setAction("android.intent.action.SEND");
            ArrayList<Uri> r5 = this.mStreams;
            if (r5 != null) goto L22;
        L24:
            this.mIntent.removeExtra("android.intent.extra.STREAM");
            Api16Impl.removeClipData(this.mIntent);
        L27:
            return this.mIntent;
        L22:
            if (r5.isEmpty() == true) goto L24;
            this.mIntent.putExtra("android.intent.extra.STREAM", this.mStreams.get(0));
            Api16Impl.migrateExtraStreamToClipData(this.mIntent, this.mStreams);
            goto L27
        L25:
            this.mIntent.setAction("android.intent.action.SEND_MULTIPLE");
            this.mIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.mStreams);
            Api16Impl.migrateExtraStreamToClipData(this.mIntent, this.mStreams);
        L16:
            r4 = false;
            goto L18
        }

        Context getContext() {
            return this.mContext;
        }

        private void combineArrayExtra(String r5, ArrayList<String> r6) {
            String[] r0 = this.mIntent.getStringArrayExtra(r5);
            if (r0 == null) goto L5;
            int r2 = r0.length;
        L6:
            String[] r3 = new String[r6.size() + r2];
            r6.toArray(r3);
            if (r0 == null) goto L9;
            System.arraycopy(r0, 0, r3, r6.size(), r2);
        L9:
            this.mIntent.putExtra(r5, r3);
            return;
        L5:
            r2 = 0;
            goto L6
        }

        private void combineArrayExtra(String r5, String[] r6) {
            Intent r4 = getIntent();
            String[] r0 = r4.getStringArrayExtra(r5);
            if (r0 == null) goto L5;
            int r2 = r0.length;
        L6:
            String[] r3 = new String[r6.length + r2];
            if (r0 == null) goto L9;
            System.arraycopy(r0, 0, r3, 0, r2);
        L9:
            System.arraycopy(r6, 0, r3, r2, r6.length);
            r4.putExtra(r5, r3);
            return;
        L5:
            r2 = 0;
            goto L6
        }

        public Intent createChooserIntent() {
            return Intent.createChooser(getIntent(), this.mChooserTitle);
        }

        public void startChooser() {
            this.mContext.startActivity(createChooserIntent());
        }

        public IntentBuilder setChooserTitle(CharSequence r1) {
            this.mChooserTitle = r1;
            return this;
        }

        public IntentBuilder setChooserTitle(int r2) {
            return setChooserTitle(this.mContext.getText(r2));
        }

        public IntentBuilder setType(String r2) {
            this.mIntent.setType(r2);
            return this;
        }

        public IntentBuilder setText(CharSequence r3) {
            this.mIntent.putExtra("android.intent.extra.TEXT", r3);
            return this;
        }

        public IntentBuilder setHtmlText(String r3) {
            this.mIntent.putExtra(IntentCompat.EXTRA_HTML_TEXT, r3);
            if (this.mIntent.hasExtra("android.intent.extra.TEXT") == true) goto L5;
            setText(Html.fromHtml(r3));
        L5:
            return this;
        }

        public IntentBuilder setStream(Uri r2) {
            this.mStreams = null;
            if (r2 == null) goto L5;
            addStream(r2);
        L5:
            return this;
        }

        public IntentBuilder addStream(Uri r2) {
            if (this.mStreams != null) goto L5;
            this.mStreams = new ArrayList();
        L5:
            this.mStreams.add(r2);
            return this;
        }

        public IntentBuilder setEmailTo(String[] r3) {
            if (this.mToAddresses == null) goto L5;
            this.mToAddresses = null;
        L5:
            this.mIntent.putExtra("android.intent.extra.EMAIL", r3);
            return this;
        }

        public IntentBuilder addEmailTo(String r2) {
            if (this.mToAddresses != null) goto L5;
            this.mToAddresses = new ArrayList();
        L5:
            this.mToAddresses.add(r2);
            return this;
        }

        public IntentBuilder addEmailTo(String[] r2) {
            combineArrayExtra("android.intent.extra.EMAIL", r2);
            return this;
        }

        public IntentBuilder setEmailCc(String[] r3) {
            this.mIntent.putExtra("android.intent.extra.CC", r3);
            return this;
        }

        public IntentBuilder addEmailCc(String r2) {
            if (this.mCcAddresses != null) goto L5;
            this.mCcAddresses = new ArrayList();
        L5:
            this.mCcAddresses.add(r2);
            return this;
        }

        public IntentBuilder addEmailCc(String[] r2) {
            combineArrayExtra("android.intent.extra.CC", r2);
            return this;
        }

        public IntentBuilder setEmailBcc(String[] r3) {
            this.mIntent.putExtra("android.intent.extra.BCC", r3);
            return this;
        }

        public IntentBuilder addEmailBcc(String r2) {
            if (this.mBccAddresses != null) goto L5;
            this.mBccAddresses = new ArrayList();
        L5:
            this.mBccAddresses.add(r2);
            return this;
        }

        public IntentBuilder addEmailBcc(String[] r2) {
            combineArrayExtra("android.intent.extra.BCC", r2);
            return this;
        }

        public IntentBuilder setSubject(String r3) {
            this.mIntent.putExtra("android.intent.extra.SUBJECT", r3);
            return this;
        }
    }

    public static class IntentReader {
        private static final String TAG = "IntentReader";
        private final ComponentName mCallingActivity;
        private final String mCallingPackage;
        private final Context mContext;
        private final Intent mIntent;
        private ArrayList<Uri> mStreams;

        @Deprecated
        public static IntentReader from(Activity r1) {
            return new IntentReader(r1);
        }

        public IntentReader(Activity r2) {
            this((Context) Preconditions.checkNotNull(r2), r2.getIntent());
        }

        public IntentReader(Context r1, Intent r2) {
            this.mContext = (Context) Preconditions.checkNotNull(r1);
            this.mIntent = (Intent) Preconditions.checkNotNull(r2);
            this.mCallingPackage = ShareCompat.getCallingPackage(r2);
            this.mCallingActivity = ShareCompat.getCallingActivity(r2);
        }

        public boolean isShareIntent() {
            String r1 = this.mIntent.getAction();
            if ("android.intent.action.SEND".equals(r1) == false) goto L5;
        L8:
            return true;
        L5:
            if ("android.intent.action.SEND_MULTIPLE".equals(r1) == true) goto L8;
            return false;
        }

        public boolean isSingleShare() {
            return "android.intent.action.SEND".equals(this.mIntent.getAction());
        }

        public boolean isMultipleShare() {
            return "android.intent.action.SEND_MULTIPLE".equals(this.mIntent.getAction());
        }

        public String getType() {
            return this.mIntent.getType();
        }

        public CharSequence getText() {
            return this.mIntent.getCharSequenceExtra("android.intent.extra.TEXT");
        }

        public String getHtmlText() {
            String r0 = this.mIntent.getStringExtra(IntentCompat.EXTRA_HTML_TEXT);
            if (r0 != null) goto L10;
            CharSequence r2 = getText();
            if ((r2 instanceof Spanned) == true) goto L11;
            if (r2 != null) goto L9;
            return r0;
        L9:
            return Api16Impl.escapeHtml(r2);
        L11:
            return Html.toHtml((Spanned) r2);
        L10:
            return r0;
        }

        private static void withinStyle(StringBuilder r3, CharSequence r4, int r5, int r6) {
        L2:
            if (r5 >= r6) goto L27;
            char r0 = r4.charAt(r5);
            if (r0 != '<') goto L7;
            r3.append("&lt;");
        L26:
            r5 = r5 + 1;
            goto L2
        L7:
            if (r0 != '>') goto L10;
            r3.append("&gt;");
            goto L26
        L10:
            if (r0 != '&') goto L13;
            r3.append("&amp;");
            goto L26
        L13:
            if (r0 <= '~') goto L15;
        L25:
            r3.append("&#").append(r0).append(";");
            goto L26
        L15:
            if (r0 < ' ') goto L25;
            if (r0 != ' ') goto L24;
        L18:
            int r1 = r5 + 1;
            if (r1 >= r6) goto L23;
            if (r4.charAt(r1) != ' ') goto L23;
            r3.append("&nbsp;");
            r5 = r1;
        L23:
            r3.append(' ');
            goto L26
        L24:
            r3.append(r0);
            goto L26
        }

        public Uri getStream() {
            return (Uri) this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
        }

        public Uri getStream(int r4) {
            if (this.mStreams == null) goto L5;
        L7:
            ArrayList<Uri> r0 = this.mStreams;
            if (r0 != null) goto L10;
            if (r4 != 0) goto L15;
            return (Uri) this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
        L15:
            throw new IndexOutOfBoundsException("Stream items available: " + getStreamCount() + " index requested: " + r4);
        L10:
            return r0.get(r4);
        L5:
            if (isMultipleShare() == false) goto L7;
            this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
            goto L7
        }

        public int getStreamCount() {
            if (this.mStreams == null) goto L5;
        L7:
            ArrayList<Uri> r0 = this.mStreams;
            if (r0 == null) goto L12;
            return r0.size();
        L12:
            return this.mIntent.hasExtra("android.intent.extra.STREAM") ? 1 : 0;
        L5:
            if (isMultipleShare() == false) goto L7;
            this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
            goto L7
        }

        public String[] getEmailTo() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.EMAIL");
        }

        public String[] getEmailCc() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.CC");
        }

        public String[] getEmailBcc() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.BCC");
        }

        public String getSubject() {
            return this.mIntent.getStringExtra("android.intent.extra.SUBJECT");
        }

        public String getCallingPackage() {
            return this.mCallingPackage;
        }

        public ComponentName getCallingActivity() {
            return this.mCallingActivity;
        }

        public Drawable getCallingActivityIcon() {
            if (this.mCallingActivity != null) goto L5;
            return null;
        L5:
            PackageManager r0 = this.mContext.getPackageManager();
            return r0.getActivityIcon(this.mCallingActivity);
        L8:
            e = move-exception;
            Log.e(TAG, "Could not retrieve icon for calling activity", e);
            return null;
        }

        public Drawable getCallingApplicationIcon() {
            if (this.mCallingPackage != null) goto L5;
            return null;
        L5:
            PackageManager r0 = this.mContext.getPackageManager();
            return r0.getApplicationIcon(this.mCallingPackage);
        L8:
            e = move-exception;
            Log.e(TAG, "Could not retrieve icon for calling application", e);
            return null;
        }

        public CharSequence getCallingApplicationLabel() {
            if (this.mCallingPackage != null) goto L5;
            return null;
        L5:
            PackageManager r0 = this.mContext.getPackageManager();
            return r0.getApplicationLabel(r0.getApplicationInfo(this.mCallingPackage, 0));
        L8:
            e = move-exception;
            Log.e(TAG, "Could not retrieve label for calling application", e);
            return null;
        }
    }

    private ShareCompat() {
    }

    public static String getCallingPackage(Activity r1) {
        Intent r0 = r1.getIntent();
        String r2 = r1.getCallingPackage();
        if (r2 != null) goto L7;
        if (r0 != null) goto L6;
        return r2;
    L6:
        return getCallingPackage(r0);
    L7:
        return r2;
    }

    static String getCallingPackage(Intent r1) {
        String r0 = r1.getStringExtra(EXTRA_CALLING_PACKAGE);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return r1.getStringExtra(EXTRA_CALLING_PACKAGE_INTEROP);
    }

    public static ComponentName getCallingActivity(Activity r1) {
        Intent r0 = r1.getIntent();
        ComponentName r2 = r1.getCallingActivity();
        if (r2 == null) goto L5;
        return r2;
    L5:
        return getCallingActivity(r0);
    }

    static ComponentName getCallingActivity(Intent r1) {
        ComponentName r0 = (ComponentName) r1.getParcelableExtra(EXTRA_CALLING_ACTIVITY);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return (ComponentName) r1.getParcelableExtra(EXTRA_CALLING_ACTIVITY_INTEROP);
    }

    @Deprecated
    public static void configureMenuItem(MenuItem r3, IntentBuilder r4) {
        ActionProvider r0 = r3.getActionProvider();
        if ((r0 instanceof ShareActionProvider) == true) goto L5;
        ShareActionProvider r1 = new ShareActionProvider(r4.getContext());
    L6:
        r1.setShareHistoryFileName(HISTORY_FILENAME_PREFIX + r4.getContext().getClass().getName());
        r1.setShareIntent(r4.getIntent());
        r3.setActionProvider(r1);
        return;
    L5:
        r1 = (ShareActionProvider) r0;
        goto L6
    }

    @Deprecated
    public static void configureMenuItem(Menu r1, int r2, IntentBuilder r3) {
        MenuItem r4 = r1.findItem(r2);
        if (r4 == null) goto L7;
        configureMenuItem(r4, r3);
        return;
    L7:
        throw new IllegalArgumentException("Could not find menu item with id " + r2 + " in the supplied menu");
    }
}
