package androidx.core.app;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class RemoteInput {
    public static final int EDIT_CHOICES_BEFORE_SENDING_AUTO = 0;
    public static final int EDIT_CHOICES_BEFORE_SENDING_DISABLED = 1;
    public static final int EDIT_CHOICES_BEFORE_SENDING_ENABLED = 2;
    private static final String EXTRA_DATA_TYPE_RESULTS_DATA = "android.remoteinput.dataTypeResultsData";
    public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
    private static final String EXTRA_RESULTS_SOURCE = "android.remoteinput.resultsSource";
    public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";
    public static final int SOURCE_CHOICE = 1;
    public static final int SOURCE_FREE_FORM_INPUT = 0;
    private final boolean mAllowFreeFormTextInput;
    private final Set<String> mAllowedDataTypes;
    private final CharSequence[] mChoices;
    private final int mEditChoicesBeforeSending;
    private final Bundle mExtras;
    private final CharSequence mLabel;
    private final String mResultKey;

    static class Api16Impl {
        private Api16Impl() {
        }

        static ClipData getClipData(Intent r0) {
            return r0.getClipData();
        }

        static void setClipData(Intent r0, ClipData r1) {
            r0.setClipData(r1);
        }
    }

    static class Api20Impl {
        private Api20Impl() {
        }

        static Bundle getResultsFromIntent(Intent r0) {
            return android.app.RemoteInput.getResultsFromIntent(r0);
        }

        static void addResultsToIntent(Object r0, Intent r1, Bundle r2) {
            android.app.RemoteInput.addResultsToIntent((android.app.RemoteInput[]) r0, r1, r2);
        }

        static RemoteInput fromPlatform(Object r4) {
            android.app.RemoteInput r5 = (android.app.RemoteInput) r4;
            Builder r0 = new Builder(r5.getResultKey()).setLabel(r5.getLabel()).setChoices(r5.getChoices()).setAllowFreeFormInput(r5.getAllowFreeFormInput()).addExtras(r5.getExtras());
            Set<String> r1 = Api26Impl.getAllowedDataTypes(r5);
            if (r1 == null) goto L8;
            Iterator<String> r2 = r1.iterator();
        L6:
            if (r2.hasNext() == false) goto L8;
            r0.setAllowDataType(r2.next(), true);
        L8:
            r0.setEditChoicesBeforeSending(Api29Impl.getEditChoicesBeforeSending(r5));
            return r0.build();
        }

        public static android.app.RemoteInput fromCompat(RemoteInput r4) {
            android.app.RemoteInput.Builder r0 = new android.app.RemoteInput.Builder(r4.getResultKey()).setLabel(r4.getLabel()).setChoices(r4.getChoices()).setAllowFreeFormInput(r4.getAllowFreeFormInput()).addExtras(r4.getExtras());
            Set<String> r1 = r4.getAllowedDataTypes();
            if (r1 == null) goto L8;
            Iterator<String> r2 = r1.iterator();
        L6:
            if (r2.hasNext() == false) goto L8;
            Api26Impl.setAllowDataType(r0, r2.next(), true);
        L8:
            Api29Impl.setEditChoicesBeforeSending(r0, r4.getEditChoicesBeforeSending());
            return r0.build();
        }
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static Map<String, Uri> getDataResultsFromIntent(Intent r0, String r1) {
            return android.app.RemoteInput.getDataResultsFromIntent(r0, r1);
        }

        static Set<String> getAllowedDataTypes(Object r0) {
            return ((android.app.RemoteInput) r0).getAllowedDataTypes();
        }

        static void addDataResultToIntent(RemoteInput r0, Intent r1, Map<String, Uri> r2) {
            android.app.RemoteInput.addDataResultToIntent(RemoteInput.fromCompat(r0), r1, r2);
        }

        static android.app.RemoteInput.Builder setAllowDataType(android.app.RemoteInput.Builder r0, String r1, boolean r2) {
            return r0.setAllowDataType(r1, r2);
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static void setResultsSource(Intent r0, int r1) {
            android.app.RemoteInput.setResultsSource(r0, r1);
        }

        static int getResultsSource(Intent r0) {
            return android.app.RemoteInput.getResultsSource(r0);
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static int getEditChoicesBeforeSending(Object r0) {
            return ((android.app.RemoteInput) r0).getEditChoicesBeforeSending();
        }

        static android.app.RemoteInput.Builder setEditChoicesBeforeSending(android.app.RemoteInput.Builder r0, int r1) {
            return r0.setEditChoicesBeforeSending(r1);
        }
    }

    public static final class Builder {
        private boolean mAllowFreeFormTextInput;
        private final Set<String> mAllowedDataTypes;
        private CharSequence[] mChoices;
        private int mEditChoicesBeforeSending;
        private final Bundle mExtras;
        private CharSequence mLabel;
        private final String mResultKey;

        public Builder(String r2) {
            this.mAllowedDataTypes = new HashSet();
            this.mExtras = new Bundle();
            this.mAllowFreeFormTextInput = true;
            this.mEditChoicesBeforeSending = 0;
            if (r2 == null) goto L7;
            this.mResultKey = r2;
            return;
        L7:
            throw new IllegalArgumentException("Result key can't be null");
        }

        public Builder setLabel(CharSequence r1) {
            this.mLabel = r1;
            return this;
        }

        public Builder setChoices(CharSequence[] r1) {
            this.mChoices = r1;
            return this;
        }

        public Builder setAllowDataType(String r1, boolean r2) {
            if (r2 == false) goto L4;
            this.mAllowedDataTypes.add(r1);
        L5:
            return this;
        L4:
            this.mAllowedDataTypes.remove(r1);
            goto L5
        }

        public Builder setAllowFreeFormInput(boolean r1) {
            this.mAllowFreeFormTextInput = r1;
            return this;
        }

        public Builder setEditChoicesBeforeSending(int r1) {
            this.mEditChoicesBeforeSending = r1;
            return this;
        }

        public Builder addExtras(Bundle r2) {
            if (r2 == null) goto L4;
            this.mExtras.putAll(r2);
        L4:
            return this;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public RemoteInput build() {
            return new RemoteInput(this.mResultKey, this.mLabel, this.mChoices, this.mAllowFreeFormTextInput, this.mEditChoicesBeforeSending, this.mExtras, this.mAllowedDataTypes);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface EditChoicesBeforeSending {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Source {
    }

    RemoteInput(String r1, CharSequence r2, CharSequence[] r3, boolean r4, int r5, Bundle r6, Set<String> r7) {
        this.mResultKey = r1;
        this.mLabel = r2;
        this.mChoices = r3;
        this.mAllowFreeFormTextInput = r4;
        this.mEditChoicesBeforeSending = r5;
        this.mExtras = r6;
        this.mAllowedDataTypes = r7;
        if (getEditChoicesBeforeSending() == 2) goto L5;
        return;
    L5:
        if (getAllowFreeFormInput() == false) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
    }

    public String getResultKey() {
        return this.mResultKey;
    }

    public CharSequence getLabel() {
        return this.mLabel;
    }

    public CharSequence[] getChoices() {
        return this.mChoices;
    }

    public Set<String> getAllowedDataTypes() {
        return this.mAllowedDataTypes;
    }

    public boolean isDataOnly() {
        if (getAllowFreeFormInput() == false) goto L5;
    L13:
        return false;
    L5:
        if (getChoices() == null) goto L9;
        if (getChoices().length != 0) goto L13;
    L9:
        if (getAllowedDataTypes() == null) goto L13;
        if (getAllowedDataTypes().isEmpty() == true) goto L13;
        return true;
    }

    public boolean getAllowFreeFormInput() {
        return this.mAllowFreeFormTextInput;
    }

    public int getEditChoicesBeforeSending() {
        return this.mEditChoicesBeforeSending;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public static Map<String, Uri> getDataResultsFromIntent(Intent r0, String r1) {
        return Api26Impl.getDataResultsFromIntent(r0, r1);
    }

    public static Bundle getResultsFromIntent(Intent r0) {
        return Api20Impl.getResultsFromIntent(r0);
    }

    public static void addResultsToIntent(RemoteInput[] r0, Intent r1, Bundle r2) {
        Api20Impl.addResultsToIntent(fromCompat(r0), r1, r2);
    }

    public static void addDataResultToIntent(RemoteInput r0, Intent r1, Map<String, Uri> r2) {
        Api26Impl.addDataResultToIntent(r0, r1, r2);
    }

    public static void setResultsSource(Intent r0, int r1) {
        Api28Impl.setResultsSource(r0, r1);
    }

    public static int getResultsSource(Intent r0) {
        return Api28Impl.getResultsSource(r0);
    }

    private static String getExtraResultsKeyForData(String r2) {
        return EXTRA_DATA_TYPE_RESULTS_DATA + r2;
    }

    static android.app.RemoteInput[] fromCompat(RemoteInput[] r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        android.app.RemoteInput[] r0 = new android.app.RemoteInput[r3.length];
        int r1 = 0;
    L7:
        if (r1 >= r3.length) goto L9;
        r0[r1] = fromCompat(r3[r1]);
        r1 = r1 + 1;
        goto L7
    L9:
        return r0;
    }

    static android.app.RemoteInput fromCompat(RemoteInput r0) {
        return Api20Impl.fromCompat(r0);
    }

    static RemoteInput fromPlatform(android.app.RemoteInput r0) {
        return Api20Impl.fromPlatform(r0);
    }

    private static Intent getClipDataIntentFromIntent(Intent r3) {
        ClipData r4 = Api16Impl.getClipData(r3);
        if (r4 != null) goto L5;
        return null;
    L5:
        ClipDescription r1 = r4.getDescription();
        if (r1.hasMimeType("text/vnd.android.intent") == true) goto L9;
        return null;
    L9:
        if (r1.getLabel().toString().contentEquals(RESULTS_CLIP_LABEL) == true) goto L12;
        return null;
    L12:
        return r4.getItemAt(0).getIntent();
    }
}
